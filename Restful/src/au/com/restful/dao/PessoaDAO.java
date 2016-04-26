package au.com.restful.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import au.com.restful.factory.ConnectionFactory;
import au.com.restful.model.Pessoa;

/**
 * Class responsible for having the CRUD's methods
 * 
 * @author Gustavo <gustavotavaresdias@gmail.com>
 * @date 24 Apr 2016
 *
 */
public class PessoaDAO extends ConnectionFactory {

	private static PessoaDAO instance;

	public static PessoaDAO getInstance() {
		if (instance == null)
			instance = new PessoaDAO();

		return instance;
	}

	/**
	 * Method responsible for insert object Pessoa into the database
	 *
	 * @param pessoa
	 * @return true or false
	 */
	public boolean InsertPessoa(Pessoa pessoa) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		connection = createConnection();
		
		try {
			pstmt = connection.prepareStatement("INSERT INTO tb_pessoa VALUES (null,?)");
			
			pstmt.setString(1, pessoa.getNomePessoa());			
			
			pstmt.executeUpdate();


		} catch (Exception e) {
			System.out.println("Error when try insert user:" + e);
			e.printStackTrace();
			return false;
		} finally {
			closeConnection(connection, pstmt, rs);
		}

		return true;
	}
	
	/**
	 * Method responsible for update object Pessoa into the database
	 *
	 * @param pessoa
	 * @return true or false
	 */
	public boolean UpdatePessoa(Pessoa pessoa) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		connection = createConnection();
		
		try {
			pstmt = connection.prepareStatement("UPDATE tb_pessoa SET ds_pessoa = ? WHERE id_pessoa = ?");
			
			pstmt.setString(1, pessoa.getNomePessoa());
			pstmt.setInt(2, pessoa.getCodigoPessoa());
			
			pstmt.executeUpdate();


		} catch (Exception e) {
			System.out.println("Error when try update user:" + e);
			e.printStackTrace();
			return false;
		} finally {
			closeConnection(connection, pstmt, rs);
		}

		return true;
	}
	
	/**
	 * Method responsible for delete object Pessoa from the database
	 *
	 * @param int - codPessoa
	 * @return boolean - true or false
	 */
	public boolean DeletePessoa(int codPessoa) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		connection = createConnection();
		
		try {
			pstmt = connection.prepareStatement("DELETE FROM tb_pessoa WHERE id_pessoa = ?");
			
			pstmt.setInt(1, codPessoa);
			
			pstmt.executeUpdate();


		} catch (Exception e) {
			System.out.println("Error when try delete user:" + e);
			e.printStackTrace();
			return false;
		} finally {
			closeConnection(connection, pstmt, rs);
		}

		return true;
	}

	/**
	 * Method responsible for list all objects Pessoa from the database
	 *
	 * @return ArrayList<Pessoa> - List of Pessoa from database 
	 */
	public ArrayList<Pessoa> ListAll() {
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Pessoa> pessoas = null;

		connection = createConnection();
		pessoas = new ArrayList<Pessoa>();

		try {
			pstmt = connection.prepareStatement("SELECT * FROM tb_pessoa");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Pessoa pessoa = new Pessoa();

				pessoa.setCodigoPessoa(rs.getInt("id_pessoa"));
				pessoa.setNomePessoa(rs.getString("ds_pessoa"));

				pessoas.add(pessoa);
			}

		} catch (Exception e) {
			System.out.println("Error when try list all users:" + e);
			e.printStackTrace();
		} finally {
			closeConnection(connection, pstmt, rs);
		}

		return pessoas;
	}

}
