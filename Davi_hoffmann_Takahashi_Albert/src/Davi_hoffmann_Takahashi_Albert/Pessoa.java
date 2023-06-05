package Davi_hoffmann_Takahashi_Albert;
import java.util.Date;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Pessoa {
	
    private static final String URL = "jdbc:mysql://localhost:3306/projeto", SENHA = "", USUARIO = "root";
	private String email_pessoa, cpf_pessoa, endereco_pessoa, celular_pessoa, sobrenome_pessoa;
	private static String nome_pessoa;
	private boolean is_professor_pessoa, is_aluno_pessoa;
	protected static Connection connection=null, conn=null;
	
	static Scanner scanner = new Scanner(System.in);

	
	public static String getNome() {
		
		return nome_pessoa;
	}
	
	public void setNome(String nome) {
		nome_pessoa = nome;
		
	}
	
	public void setSobrenome(String sobrenome) {
		sobrenome_pessoa = sobrenome;
	}
	
	public void setCpf(String cpf) {
	    cpf_pessoa = cpf;
	}
	
	public void setEmail(String email) {
	    email_pessoa = email;
	}
	
	public void setCelular(String celular) {
	    celular_pessoa = celular;
	}
	
	public void setEndereco(String endereco) {
		endereco_pessoa = endereco;
	}
	
	public void setIs_professor(boolean is_professor) {
	    is_professor_pessoa = is_professor;
	}
	
	public void setIs_aluno(boolean is_aluno) {
	    is_aluno_pessoa = is_aluno;
	}
	
	public String getCpf() {
		return cpf_pessoa;
	}
	
	public static ResultSet getPesquisa() {
		ResultSet pessoa = null;
		try {
			Statement statement = Armazenamento.conn.createStatement();
			pessoa = statement.executeQuery("SELECT count(*) FROM pessoa");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pessoa;
	}
	
	public static ResultSet getPessoa() {
		Statement statement;
		try {
			statement = Armazenamento.conn.createStatement();
			ResultSet procurar_pessoa = statement.executeQuery("SELECT * FROM pessoa");
			return procurar_pessoa;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
    public void inserir() {
        
        try {
        
        String sqlPessoa1 = "INSERT INTO pessoa (nome, celular, email, endereco) VALUES (?, ?, ?, ?)";
        PreparedStatement stmtPessoa1 = Armazenamento.conn.prepareStatement(sqlPessoa1);
        
        stmtPessoa1.setString(1, nome_pessoa);
        stmtPessoa1.setString(2, celular_pessoa);
        stmtPessoa1.setString(3, email_pessoa);
        stmtPessoa1.setString(4, endereco_pessoa);
        stmtPessoa1.executeUpdate();
        stmtPessoa1.close();
        Armazenamento.conn.close();
        
        } catch (SQLException e) {
        System.out.println("Erro ao salvar os dados da pessoa no banco de dados: " + e.getMessage());
    }
		
    	
    }
	
	public void cadastrar() {
		System.out.println("Digite o nome da pessoa:");
	    String nome = scanner.next();
		System.out.println("Digite o sobrenome da pessoa:");
	    String sobrenome = scanner.next();
		System.out.println("Digite o cpf da pessoa:");
	    String cpf = scanner.next();
		System.out.println("Digite o email da pessoa:");
	    String email = scanner.next();
		System.out.println("Digite o celular da pessoa:");
	    String celular = scanner.next();
		System.out.println("Digite o endereco da pessoa:");
	    String endereco = scanner.next();
	    
	    setNome(nome);
	    setSobrenome(sobrenome);
	    setCpf(cpf);
	    setEmail(email);
	    setCelular(celular);
	    setEndereco(endereco);
	}
	
    public static void exibirPessoas() {
    	
        try {
    	       Statement statement = Armazenamento.conn.createStatement();
   	           ResultSet contar = statement.executeQuery("SELECT count(*) FROM pessoa");
		

               if(contar.getInt("contar")>0) {          
               while (contar.next()) {
            	   String nome = contar.getString("nome");
                   String sobrenome = contar.getString("sobrenome");
                   String email = contar.getString("email");
                   String celular = contar.getString("celular");
                   String endereco = contar.getString("endereco");

                   System.out.println("Nome: " + nome);
                   System.out.println("Sobrenome: " + sobrenome);
                   System.out.println("Email: " + email);
                   System.out.println("Celular: " + celular);
                   System.out.println("Endereco: " + endereco);
                   System.out.println();
               }}else {
            	   System.out.println("Nenhuma pessoa encontrado.");
               }
               }
            catch (SQLException e) {
           }
    }

}
