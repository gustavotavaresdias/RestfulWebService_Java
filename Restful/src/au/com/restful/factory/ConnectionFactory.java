package au.com.restful.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Class responsible for having methods for open and close database connection
 * 
 * @author Gustavo <gustavotavaresdias@gmail.com>
 * @date 22 Apr 2016
 */
public class ConnectionFactory {

	// Path for Database
	private final String DRIVER = "com.mysql.jdbc.Driver";
	private final String URL = "jdbc:mysql://localhost:3306/base_crud";
	private final String USER = "root";
	private final String PASS = "";

	/**
	 * Method responsible for creating database connection
	 * 
	 * @return
	 * @author Gustavo <gustavotavaresdias@gmail.com>
	 * @date 22 Apr 2016
	 */
	public Connection createConnection() {

		Connection connection = null;

		try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(URL, USER, PASS);

		} catch (Exception e) {
			System.out.println("Error when creating the connection database: "
					+ URL);
		}
		return connection;
	}

	/**
	 * Method responsible for close database connection
	 * 
	 * @param connection
	 * @param pstmt
	 * @param rs
	 * 
	 * @author Gustavo <gustavotavaresdias@gmail.com>
	 * @date 22 Apr 2016
	 */
	public void closeConnection(Connection connection, PreparedStatement pstmt,
			ResultSet rs) {

		try {
			if (connection != null) {
				connection.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (rs != null) {
				rs.close();
			}

		} catch (Exception e) {
			System.out.println("Error when closing the connection database: "
					+ URL);
		}
	}

}
