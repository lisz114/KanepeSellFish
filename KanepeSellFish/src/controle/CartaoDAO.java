package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import com.mysql.cj.protocol.Resultset;

import modelo.Cartao;
import modelo.ICartaoDAO;
import modelo.Produto;
import modelo.Usuario;

public class CartaoDAO implements ICartaoDAO{
	
	private static CartaoDAO instancia;
	private static ArrayList<Cartao> listaCartao;

	UsuarioDAO uDAO = new UsuarioDAO();
	
	public static CartaoDAO getInstancia(){
		
		if (instancia == null) {
			instancia = new CartaoDAO();
			listaCartao = new ArrayList<>();
		}

		return instancia;
	}
	
	public int inserirCartao(Cartao c, Usuario u) {
		String sql = "INSERT INTO kanepe.cartao (TipodoCartao, NumerodoCartao, validade, CVV, apelido, Usuarios_idUsuarios) VALUES (?,?,?,?,?,?)";
		try(Connection conn = ConexaoBD.getConexaoMySQL(); PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			
			pstmt.setObject(1, c.getTipodoCartao());
			pstmt.setLong(2, c.getNumdoCartao());
			pstmt.setDate(3, java.sql.Date.valueOf(c.getValidade()));
			pstmt.setInt(4, c.getCVV());
			pstmt.setString(5, c.getApelido());
			pstmt.setInt(6, u.getIdUsuario());
			
			pstmt.executeUpdate();
			
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				return rs.getInt(1);
			}

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return -1;
	}
	
	public  boolean deletaCartao(Cartao c) {
		int id = Integer.parseInt(pegarIdCartao(c));
		String sql = "DELETE FROM kanepe.cartao where idCarto = ?";
		try(Connection conn = ConexaoBD.getConexaoMySQL(); PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			pstmt.setInt(1, id);
			int row = pstmt.executeUpdate();
			return row > 0;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
	public ArrayList<Cartao> listarCartao () throws SQLException{
		ArrayList<Cartao> cartao = new ArrayList<>();
		String sql = "Select idCartao, TipodoCartao, NumerodoCartao, apelido from kanepe.cartao;";
		Connection conn = ConexaoBD.getConexaoMySQL();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			Cartao cartoes = new Cartao();
			cartoes.setIdC(rs.getInt("idCartao"));
			cartoes.setTipodoCartao(rs.getObject("TipodoCartao"));
			cartoes.setNumdoCartao(rs.getLong("NumerodoCartao"));
			cartoes.setApelido(rs.getString("apelido"));
			cartao.add(cartoes);
		}
		rs.close();
		pstmt.close();
		return cartao;
	}
	
//	public boolean UsuarioTemCartao(Usuario u) {
//		String sql = "SELECT * FROM kanepe.cartao where Usuarios_idUsuarios = ?";
//		try(Connection conn = ConexaoBD.getConexaoMySQL(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
//			
//			ResultSet resl = null;
//			pstmt.setInt(1, u.getIdUsuario());
//			resl = pstmt.executeQuery();
//			
//			if (resl.next()) {
//				return true;
//			}else {
//				return false;
//			}
//		} catch (SQLException e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			return false;
//		}
//	}
	public String pegarIdCartao(Cartao c) {

		PreparedStatement stmt1 = null;

		Connection conn = ConexaoBD.getConexaoMySQL();

		try {
			stmt1 = conn.prepareStatement("SELECT * FROM kanepe.cartao where apelido = ?");
			ResultSet res1 = null;

			stmt1.setString(1, String.valueOf(c.getApelido()));

			res1 = stmt1.executeQuery();

			while (res1.next()) {

				return res1.getString("apelido");
			}

			res1.close();
			stmt1.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
