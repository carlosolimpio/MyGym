package dados;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class Conexao {
	
	public static Connection getConexao() throws SQLException {
		
		Connection conexao = null;
		conexao = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/mygym", "root", "toor");
		return conexao;
	}
}
