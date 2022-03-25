package db.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConexao {
	
	private static final String url = "jdbc:mysql://localhost:3306/projetoCrud";
	private static final String user = "root";
	private static final String password = "root";
	
	public static Connection createConnection() {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("driver found");
			
		} catch(ClassNotFoundException e) {
			
			System.out.println("driver not found. "+ e.getMessage());
			
		}
		
		try {
			
			Connection connection = DriverManager.getConnection(url, user, password);
			System.out.println("Conectado a base de dados");
			return connection;
			
		} catch(SQLException e) {
			
			System.out.println("Não foi conectado a base de dados. "+ e.getMessage());
			return null;
			
		}
	}

}
