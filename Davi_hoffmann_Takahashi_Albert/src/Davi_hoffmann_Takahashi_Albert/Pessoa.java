package Davi_hoffmann_Takahashi_Albert;
import java.util.Date;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Pessoa {
	
    private static final String URL = "jdbc:mysql://localhost:3306/projeto", SENHA = "", USUARIO = "root";
	private static String email_pessoa, cpf_pessoa, endereco_pessoa, celular_pessoa, sobrenome_pessoa, nome_pessoa;
	private boolean is_professor_pessoa, is_aluno_pessoa;
	private static int opcao=0;
	protected static Connection connection=null;
	protected static Connection conn=null;
	
	static Scanner scanner = new Scanner(System.in);

	
	public static String getNome() {
		Armazenamento.conecta();
		return nome_pessoa;
	}
	
	public static void setNome(String nome) {
		nome_pessoa = nome;
		
	}
	
	public static void setSobrenome(String sobrenome) {
		sobrenome_pessoa = sobrenome;
	}
	
	public static void setCpf(String cpf) {
	    cpf_pessoa = cpf;
	}
	
	public static void setEmail(String email) {
	    email_pessoa = email;
	}
	
	public static void setCelular(String celular) {
	    celular_pessoa = celular;
	}
	
	public static void setEndereco(String endereco) {
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
	
    public static long salvarPessoa() {
    	
        String nome = null;
        String sobrenome = null;
        String telefone = null;
        String email = null;
        String endereco = null;
        
        try {
        Armazenamento.conecta();
        String sqlPessoa1 = "INSERT INTO pessoa (nome, sobrenome, telefone, email, endereco) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement stmtPessoa1 = conn.prepareStatement(sqlPessoa1);
        
        stmtPessoa1.setString(2, nome);
        stmtPessoa1.setString(3, sobrenome);
        stmtPessoa1.setString(4, telefone);
        stmtPessoa1.setString(5, email);
        stmtPessoa1.setString(6, endereco);
        stmtPessoa1.executeUpdate();
        try (ResultSet generatedKeys = stmtPessoa1.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                return generatedKeys.getLong(1);
            } else {
                return 0;
            }
        }
        
        } catch (SQLException e) {
        System.out.println("Erro ao salvar os dados da pessoa no banco de dados: " + e.getMessage());
        return 0;
    }
		
    	
    }
	
	public static void cadastrarPessoa() {
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
	
	public static void deletarPessoa() throws SQLException{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Você quer deletar pelo código da pessoa ou pelo nome e sobrenome?(1: código / 2: nome)");
		opcao = scanner.nextInt();
            
            switch(opcao) {
            case 1:
            	try {
                System.out.print("Insira o código da pessoa para deletar: ");
                int codPessoa = scanner.nextInt();
                String deletePessoaSql = "DELETE FROM pessoa WHERE cod_pessoa = ?";
                PreparedStatement deletePessoaStatement = connection.prepareStatement(deletePessoaSql);
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
            	System.out.print("Insira o código da pessoa para deletar: ");
                int nomePessoa = scanner.nextInt();
            	String deletePessoaSql1 = "DELETE FROM pessoa WHERE cod_pessoa = ?";
                PreparedStatement deleteAlunoStatement = connection.prepareStatement(deletePessoaSql1);
               deleteAlunoStatement.setInt(1, nomePessoa);
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
            }
	}

}
