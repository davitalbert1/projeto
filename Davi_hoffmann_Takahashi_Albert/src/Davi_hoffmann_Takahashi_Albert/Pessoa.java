package Davi_hoffmann_Takahashi_Albert;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Pessoa {
	
    private final String URL = "jdbc:mysql://localhost:3306/projeto", SENHA = "", USUARIO = "root";
	private String email_pessoa, cpf_pessoa, endereco_pessoa, celular_pessoa;
	protected static String nome_pessoa;
	protected String cpf;
	protected boolean tipo=false;
	protected Connection conn=null;
	protected int id;
	protected static int cod_pessoa=0;
	public int lastInsertId;
	
		static Scanner scanner = new Scanner(System.in);

	
	public static String getNome() {
		
		return nome_pessoa;
	}
	
	private void setNome(String nome) {
		nome_pessoa = nome;
		
	}
	
	private void setCpf(String cpf) {
	    this.cpf = cpf;
	}
	
	private void setEmail(String email) {
	    email_pessoa = email;
	}
	
	private void setCelular(String celular) {
	    celular_pessoa = celular;
	}
	
	public void setEndereco(String endereco) {
		endereco_pessoa = endereco;
	}
	
	public String getCpf() {
		return cpf_pessoa;
	}
	
	public void deletar(int id){
            	try {
                String deletePessoaSql = "DELETE FROM pessoa WHERE cod_pessoa = ?";
                PreparedStatement deletePessoaStatement = Armazenamento.conn.prepareStatement(deletePessoaSql);
                deletePessoaStatement.setInt(1, id);
                int pessoaRowsAffected = deletePessoaStatement.executeUpdate();
                System.out.println("Deletado " + pessoaRowsAffected + " informações na tabela pessoa.");
            	}catch (SQLException e) {
    				e.printStackTrace();
    				System.out.println("Erro em acessar o banco de dados. Erro: " + e.getMessage());
    						
    			}
	}
	
	public void getPessoa(int id) {
		try {
			Statement statement = Armazenamento.conn.createStatement();
			ResultSet procurar_pessoa = statement.executeQuery("SELECT * FROM pessoa WHERE cod_pessoa = "+ id);
            if(procurar_pessoa.next()) {
			String nome = procurar_pessoa.getString("nome");
            String email = procurar_pessoa.getString("email");
            String endereco = procurar_pessoa.getString("endereco");
            String CPF = procurar_pessoa.getString("cpf");
            String celular = procurar_pessoa.getString("celular");
            
            System.out.println("Nome: " + nome);
            System.out.println("Email: " + email);
            System.out.println("Endereco: " + endereco);
            System.out.println("CPF: " + CPF);
            System.out.println("Celular: " + celular);
            }
            
            
		} catch (SQLException e) {
			System.out.println("Erro ao procurar os dados da pessoa no banco de dados: " + e.getMessage());
		}
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
                    lastInsertId = generatedKeys.getInt(1);
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
		System.out.println("Digite o cpf da pessoa:");
	    String cpf = scanner.next();
		System.out.println("Digite o email da pessoa:");
	    String email = scanner.next();
		System.out.println("Digite o celular da pessoa:");
	    String celular = scanner.next();
		System.out.println("Digite o endereco da pessoa:");
	    String endereco = scanner.next();
	    
	    setNome(nome);
	    setCpf(cpf);
	    setEmail(email);
	    setCelular(celular);
	    setEndereco(endereco);
	}
	
    public void exibir() {
    	
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
    
	public int editar(int id) {

        try {
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
			String editar_turma = "UPDATE pessoa SET nome = ?, email=?, endereco=?, cpf=?, celular=? WHERE cod_pessoa = ?";
			PreparedStatement editar_T = Armazenamento.conn.prepareStatement(editar_turma);
			editar_T.setString(1, nome);
			editar_T.setString(2, email);
			editar_T.setString(3, endereco);
			editar_T.setString(4, cpf);
			editar_T.setString(5, celular);
			editar_T.setInt(6, id);
			editar_T.executeUpdate();
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}

}
