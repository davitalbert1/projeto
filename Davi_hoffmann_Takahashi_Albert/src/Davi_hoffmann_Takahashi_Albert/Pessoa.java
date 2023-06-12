package Davi_hoffmann_Takahashi_Albert;
import java.util.Date;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Pessoa {
	
    private static final String URL = "jdbc:mysql://localhost:3306/projeto", SENHA = "", USUARIO = "root";
	private String email_pessoa, cpf_pessoa, endereco_pessoa, celular_pessoa, sobrenome_pessoa;
	protected static String nome_pessoa;
	protected String cpf;
	private boolean is_professor_pessoa, is_aluno_pessoa;
	protected static boolean tipo=false;
	protected static Connection conn=null;
	protected static int id, cod_pessoa=0;
	
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
	    this.cpf = cpf;
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
	
	public static void deletar(){
		System.out.print("Você quer deletar pelo código da pessoa ou pelo nome e sobrenome?(1: código / 2: nome)");
		int opcao = scanner.nextInt();
            
		while(opcao!=1 || opcao!=2) {
            switch(opcao) {
            
            case 1:
            	try {
                System.out.print("Insira o código da pessoa para deletar: ");
                int codPessoa = scanner.nextInt();
                String deletePessoaSql = "DELETE FROM pessoa WHERE cod_pessoa = ?";
                PreparedStatement deletePessoaStatement = Armazenamento.conn.prepareStatement(deletePessoaSql);
                deletePessoaStatement.setInt(1, codPessoa);
                int pessoaRowsAffected = deletePessoaStatement.executeUpdate();
                System.out.println("Deletado " + pessoaRowsAffected + " informações na tabela.");
            	}catch (SQLException e) {
    				e.printStackTrace();
    				System.out.println("Erro em acessar o banco de dados. Erro: " + e.getMessage());
    						
    			}
            break;
            case 2:
            	try {
            	System.out.print("Insira o nome da pessoa para deletar: ");
                int nomePessoa = scanner.nextInt();
                System.out.print("Insira o sobrenome da pessoa para deletar: ");
                int sobrenome = scanner.nextInt();
            	String deletePessoaSql1 = "DELETE FROM pessoa WHERE nome = ? and sobrenome = ?";
                PreparedStatement deleteAlunoStatement = Armazenamento.conn.prepareStatement(deletePessoaSql1);
               deleteAlunoStatement.setInt(1, nomePessoa);
               deleteAlunoStatement.setInt(2, sobrenome);
               int pessoaRowsAffected = deleteAlunoStatement.executeUpdate();
               System.out.println("Deletado " + pessoaRowsAffected + " informações na tabela.");
            	}catch (SQLException e) {
   				e.printStackTrace();
   				System.out.println("Erro em acessar o banco de dados. Erro: " + e.getMessage());
   						
   			}
            break;
            default:
            	System.out.print("Você quer deletar pelo código da pessoa ou pelo nome e sobrenome?(1: código / 2: nome)");
            break;
            }}
	}
	
	public static ResultSet getPessoa() {
		Statement statement;
		try {
			statement = Armazenamento.conn.createStatement();
			ResultSet procurar_pessoa = statement.executeQuery("SELECT * FROM pessoa");
			return procurar_pessoa;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
    public int inserir() {
        
        try {
            String sqlPessoa1 = "INSERT INTO pessoa (nome, celular, email, endereco, cpf) VALUES (?,?,?,?, ?)";
            PreparedStatement stmtPessoa1 = Armazenamento.conn.prepareStatement(sqlPessoa1, Statement.RETURN_GENERATED_KEYS);
            
            stmtPessoa1.setString(1, nome_pessoa);
            stmtPessoa1.setString(2, celular_pessoa);
            stmtPessoa1.setString(3, email_pessoa);
            stmtPessoa1.setString(4, endereco_pessoa);
            stmtPessoa1.setString(5, cpf);
            int rowsAffected = stmtPessoa1.executeUpdate();
            if (rowsAffected > 0) {
                // Retrieve the generated keys
                ResultSet generatedKeys = stmtPessoa1.getGeneratedKeys();
                if (generatedKeys.next()) {
                    // Get the last inserted auto-incremented key
                    int lastInsertId = generatedKeys.getInt(1);
                    return lastInsertId;
                }
                generatedKeys.close();
            }
            stmtPessoa1.close();
        
        } catch (SQLException e) {
        System.out.println("Erro ao salvar os dados da pessoa no banco de dados: " + e.getMessage());
    }
		return -1;
		
    	
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
	
    public static void exibir() {
    	
        try {
    	       Statement statement = Armazenamento.conn.createStatement();
   	           ResultSet contar = statement.executeQuery("SELECT * FROM pessoa");   
               while (contar.next()) {
            	   String nome = contar.getString("nome");
                   String sobrenome = contar.getString("sobrenome");
                   String email = contar.getString("email");
                   String celular = contar.getString("celular");
                   String endereco = contar.getString("endereco");
                   String cpf = contar.getString("cpf");

                   System.out.println("Nome: " + nome);
                   System.out.println("Sobrenome: " + sobrenome);
                   System.out.println("Email: " + email);
                   System.out.println("Celular: " + celular);
                   System.out.println("Endereco: " + endereco);
                   System.out.println("CPF: " + cpf);
                   System.out.println();
               }
               }
            catch (SQLException e) {
           }
    }
    
	public static int editar() {

        try {
        	System.out.println("Qual o código da pessoa que você quer editar?");
        	id = scanner.nextInt();
        	System.out.println("Qual o nome da pessoa que você quer editar?");
        	String nome = scanner.next();
        	System.out.println("Qual o email da pessoa que você quer editar?");
        	String email = scanner.next();
        	System.out.println("Qual o endereco da pessoa que você quer editar?");
        	String endereco = scanner.next();
        	System.out.println("Qual o cpf da pessoa que você quer editar?");
        	String cpf = scanner.next();
        	System.out.println("Qual o celular da pessoa que você quer editar?");
        	String celular = scanner.next();
            String editar_curso = "UPDATE tabela SET curso = ? WHERE cod_pessoa = ?";
			PreparedStatement editar = Armazenamento.conn.prepareStatement(editar_curso);
			editar.setString(1, nome);
			String editar_turma = "UPDATE tabela SET email = ? WHERE cod_pessoa = ?";
			PreparedStatement editar_T = Armazenamento.conn.prepareStatement(editar_turma);
			editar_T.setString(1, email);
			String editar_endereco = "UPDATE tabela SET endereco = ? WHERE cod_pessoa = ?";
			PreparedStatement editar_E = Armazenamento.conn.prepareStatement(editar_endereco);
			editar_E.setString(1, endereco);
			String editar_cpf = "UPDATE tabela SET endereco = ? WHERE cod_pessoa = ?";
			PreparedStatement editar_C = Armazenamento.conn.prepareStatement(editar_cpf);
			editar_C.setString(1, cpf);
			String editar_celular = "UPDATE tabela SET endereco = ? WHERE cod_pessoa = ?";
			PreparedStatement editar_Ce = Armazenamento.conn.prepareStatement(editar_celular);
			editar_Ce.setString(1, celular);
			return id;
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}

}
