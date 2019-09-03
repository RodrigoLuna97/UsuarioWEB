package persistencia.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {

	public static Connection getConnection() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Connection c=null;
		try {
			c = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/banco", "root", "");
		} catch (SQLException e) {
			//Wrapper de Exception
			throw new RuntimeException("Não conectou!", e);
		}
		return c;
	}
}
