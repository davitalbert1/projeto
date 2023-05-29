package Davi_hoffmann_Takahashi_Albert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Armazenamento {

    private static final String URL = "jdbc:mysql://localhost:3306/projeto";
    private static final String USUARIO = "root";
    private static final String SENHA = "";
    private static Connection conn = null;
    
    public Armazenamento() {
    		try {
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println("Sucesso em conectar.");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Erro em conectar.");
			} 
			try {
				Armazenamento.conn = DriverManager.getConnection(URL, USUARIO, SENHA);
				System.out.println("Sucesso em acessar.");
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Erro em acessar.");
						
			}
    }
    
    public static void criarTabela() {
        try {
        	 if(conn!=null) {
        		 Statement statement = conn.createStatement(); 
             	String sql = "CREATE TABLE IF NOT EXISTS alunos (id INT PRIMARY KEY AUTO_INCREMENT, nome VARCHAR(100), idade INT)";
             	statement.execute(sql);

             	System.out.println("Tabela criada com sucesso.");
        	 }
        } catch (SQLException e) {
            System.out.println("Erro ao criar a tabela: " + e.getMessage());
        }
    }

	public static void exibirAlunos() {
        try (Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA);
             Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM alunos")) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                int idade = resultSet.getInt("idade");

                System.out.println("ID: " + id);
                System.out.println("Nome: " + nome);
                System.out.println("Idade: " + idade);
                System.out.println();
            }
        } catch (SQLException e) {
            System.out.println("Erro ao exibir os alunos: " + e.getMessage());
        }
    }

}
