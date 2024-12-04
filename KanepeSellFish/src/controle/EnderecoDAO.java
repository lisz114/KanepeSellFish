package controle;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import modelo.Endereco;
import modelo.IEnderecoDAO;

public class EnderecoDAO implements IEnderecoDAO {

	private static EnderecoDAO instancia;

	private EnderecoDAO() {
	}

	public static EnderecoDAO getInstancia() {

		if (instancia == null) {
			instancia = new EnderecoDAO();
		}

		return instancia;
	}

	public int inserirEnderecoDoComercio(Endereco endereco) {

	    String sql = "INSERT INTO enderecos (Cidade, Rua, Bairro, Numero, cep) VALUES (?, ?, ?, ?, ?)";

	    try (Connection conn = ConexaoBD.getConexaoMySQL();
	            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

	        pstmt.setString(1, endereco.getCidade());
	        pstmt.setString(2, endereco.getLogradouro());
	        pstmt.setString(3, endereco.getBairro());
	        pstmt.setInt(4, endereco.getNumero());
	        pstmt.setString(5, endereco.getCep());

	        pstmt.executeUpdate();

	        ResultSet rs = pstmt.getGeneratedKeys(); // Recupera o ID gerado automaticamente
	        if (rs.next()) {
	            return rs.getInt(1); // Retorna o ID gerado
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return -1; // Retorna -1 em caso de erro
	}
	
	public int atualizarEndereco(Endereco endereco) {
		String sql = "UPDATE usuarios set Cidade = ?, Bairro = ?, Rua = ?, numero = ?";
		try (Connection conn = ConexaoBD.getConexaoMySQL();
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			pstmt.setString(1, endereco.getCidade());
			pstmt.setString(2, endereco.getBairro());
			pstmt.setString(3, endereco.getLogradouro());
			pstmt.setInt(4, endereco.getNumero());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return -1;
	}


	@SuppressWarnings("deprecation")
	public Endereco buscaCEP(String cep) {
		Endereco endereco = new Endereco();
		try {

			URL url = new URL("http://cep.republicavirtual.com.br/web_cep.php?cep=" + cep + "&formato=xml");

			SAXReader xml = new SAXReader();
			Document doc = xml.read(url);
			Element root = doc.getRootElement();

			for (Iterator<Element> it = root.elementIterator(); it.hasNext();) {
				Element element = it.next();
				if (element.getQualifiedName().equals("cidade")) {
					String cidade = element.getText();
					endereco.setCidade(cidade);
				}
				if (element.getQualifiedName().equals("logradouro")) {
					String logradouro = element.getText();
					endereco.setLogradouro(logradouro);
				}
				if (element.getQualifiedName().equals("bairro")) {
					String bairro = element.getText();
					endereco.setBairro(bairro);
				}
			}
			if (!endereco.equals(null)) {
				return endereco;
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return null;
	}
}
