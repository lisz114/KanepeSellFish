package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import com.mysql.cj.protocol.Resultset;

import modelo.Cartao;
import modelo.ICartaoDAO;

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
	
	public int inserirCartao(Cartao c) {
		String sql = "INSERT INTO cartao (TipodoCartao, NumerodoCarao, validade, CVV, apelido) VALUES (?,?,?,?,?)";
		try(Connection conn = ConexaoBD.getConexaoMySQL(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setObject(1, c.getTipodoCartao());
			pstmt.setLong(2, c.getNumdoCartao());
			pstmt.setDate(3, java.sql.Date.valueOf(c.getValidade()));
			pstmt.setInt(4, c.getCVV());
			pstmt.setString(5, c.getApelido());
			
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
	
	public Cartao UsuarioTemCartao(Cartao c) {
		String sql = "SELECT * FROM kanepe.cartao inner join kanepe.usuarios as idUsuarios where idCartao = ?";
		try(Connection conn = ConexaoBD.getConexaoMySQL(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			ResultSet resl = null;
			pstmt.setInt(1, c.getIdC());
			resl = pstmt.executeQuery();
			
			while (resl.next()) {
				
				c.setTipodoCartao(resl.getObject("TipodoCartao"));
				c.setNumdoCartao(resl.getInt("NumerodoCartao"));
//				c.setValidade(resl.getDate("validade"));
				c.setCVV(resl.getInt("CVV"));
				c.setApelido(resl.getString("apelido"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return c;
	}
}
