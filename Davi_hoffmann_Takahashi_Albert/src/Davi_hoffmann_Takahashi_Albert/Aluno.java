package Davi_hoffmann_Takahashi_Albert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Aluno extends Pessoa {
	private  int matricula_aluno;
	private static String curso_aluno;
	
	static Scanner scanner = new Scanner(System.in);
	
	public Aluno(String email_pessoa, String cpf_pessoa, String endereco_pessoa, String celular_pessoa, String sobrenome_pessoa, String nome_pessoa, boolean is_professor_pessoa, boolean is_aluno_pessoa) {
		super (email_pessoa, cpf_pessoa, endereco_pessoa, celular_pessoa, sobrenome_pessoa, nome_pessoa, is_professor_pessoa, is_aluno_pessoa);
	}

	    public int getMatricula() {
	        return matricula_aluno;
	    }
	    
	    private String getCurso() {
	        return curso_aluno;
	    }
		
	    public static void salvarAluno() {
	    	
	    	long idPessoa = Pessoa.salvarPessoa();
	    	
	        int cod_aluno = 0;
	        String matricula = null;
	        String curso = null;
	    	
	        try {
	        	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projeto", "usuario", "senha");
	            String sqlAluno = "INSERT INTO aluno (matricula, curso) VALUES (?, ?)";
	            PreparedStatement stmtAluno = connection.prepareStatement(sqlAluno);
	            stmtAluno.setString(2, matricula);
	            stmtAluno.setString(3, curso);
	            stmtAluno.executeUpdate();
	            stmtAluno.close();
	            connection.close();

	            System.out.println("Dados salvos no banco de dados com sucesso!");
	        } catch (SQLException e) {
	            System.out.println("Erro ao salvar os dados do aluno no banco de dados: " + e.getMessage());
	        }
	    }
}
