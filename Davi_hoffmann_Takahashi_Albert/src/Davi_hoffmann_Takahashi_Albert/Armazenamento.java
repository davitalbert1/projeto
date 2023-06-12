package Davi_hoffmann_Takahashi_Albert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Armazenamento {

    private static final String URL = "jdbc:mysql://localhost:3306/projeto";
    private static final String USUARIO = "root";
    private static final String SENHA = "";
    public static Connection conn = null;
    private static int count=0;
    
    
    public Armazenamento() {
    		try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.println("Sucesso em conectar de dados.");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				System.out.println("Erro em conectar de dados. Erro: " + e.getMessage());
			}
    }
    
	public static Connection conecta() {
		try {
			conn = DriverManager.getConnection(URL, USUARIO, SENHA);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void fecha() {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}