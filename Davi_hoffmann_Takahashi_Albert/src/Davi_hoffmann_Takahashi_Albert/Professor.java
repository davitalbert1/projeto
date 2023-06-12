package Davi_hoffmann_Takahashi_Albert;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Professor extends Pessoa{
		private static String curso_professor;
		private static float salario_professor;

	    public Professor() {}
	    
	    public static void setSalario(float salario) {
	    	salario_professor=salario;
	    }
	    
	    public static void setCargo(String curso) {
	    	curso_professor=curso;
	    }
	    
		public static void exibir() {
	        try {
	 	       	Statement statement = Armazenamento.conn.createStatement();
	 	       ResultSet pessoa = Pessoa.getPessoa();
	 	      ResultSet procurar_pessoa = Pessoa.getPessoa();
	 	       
	           ResultSet professor = statement.executeQuery("SELECT count(*) FROM professor");
	           ResultSet procurar_professor = statement.executeQuery("SELECT * FROM professor");
		           int count=0;
		           for (; pessoa.next();) {
		        	   count = pessoa.getInt(1);
		            }

	         if (count>0) {
	        	 
	            while (pessoa.next()) {
	            	int cod_pessoa= procurar_pessoa.getInt("cod_pessoa");
	                int cod_professor= procurar_professor.getInt("cod_professor");
	                String curso= procurar_professor.getString("cod_professor");
	                String nome = procurar_pessoa.getString("nome");
	                String email = procurar_pessoa.getString("email");
	                String endereco = procurar_pessoa.getString("endereco");
	                String CPF = procurar_pessoa.getString("CPF");

	                System.out.println("Código da pessoa: " + cod_pessoa);
	                System.out.println("Código do professor: " + cod_professor);
	                System.out.println("Nome do professor: " + nome);
	                System.out.println("Email do professor: " + email);
	                System.out.println("Endereco do professor: " + endereco);
	                System.out.println("CPF do professor: " + CPF);
	                System.out.println("Curso do professor: " + curso);
	                System.out.println();
	                
	            }}else {
	            	System.out.println("Nenhum professor encontrado.");
	            }
	            
	        } catch (SQLException e) {
	            System.out.println("Erro ao exibir os atributos da tabela professor: " + e.getMessage());
	        }

		}
		
		public static ResultSet pesquisar() {
			try{
				System.out.println("Qual o nome da pessoa?");
	            String nomeAluno = scanner.next();

	            String sql = "SELECT * FROM pessoa WHERE nome = '" + nomeAluno + "'";

	            Statement statement = Armazenamento.conn.createStatement();
	            ResultSet resultSet = statement.executeQuery(sql);

	            if (resultSet.next()) {
	                int id = resultSet.getInt("id");
	                String nome = resultSet.getString("nome");
	                String cpf = resultSet.getString("cpf");
	                String curso = resultSet.getString("curso");
	                String turma = resultSet.getString("turma");
	                String sala = resultSet.getString("sala");

	                System.out.println("Aluno encontrado:");
	                System.out.println("ID: " + id);
	                System.out.println("Nome: " + nome);
	                System.out.println("CPF: " + cpf);
	                System.out.println("Curso: " + curso);
	                System.out.println("Turma: " + turma);
	                System.out.println("Sala: " + sala);
	            } else {
	                System.out.println("Aluno não encontrado.");
	            }

	        } catch (SQLException e) {
	            System.out.println("Erro ao pesquisar aluno: " + e.getMessage());
	        }
			return null;

		}
	    
	    public int inserir() {
	    	int id;
	        
	        try {
	        int idPessoa = super.inserir();
	        String sqlPessoa1 = "INSERT INTO professor (curso, salario, cod_pessoa) VALUES (?, ?, ?)";
	        PreparedStatement stmtPessoa1 = Armazenamento.conn.prepareStatement(sqlPessoa1, Statement.RETURN_GENERATED_KEYS);
	        
	        stmtPessoa1.setString(1, curso_professor);
	        stmtPessoa1.setFloat(2, salario_professor);
	        stmtPessoa1.setFloat(3, idPessoa);
	        stmtPessoa1.executeUpdate();
	        
	        stmtPessoa1.close();
	        
	        String sqlPessoa = "INSERT INTO professor_curso (cod_professor) VALUES (?)";
	        PreparedStatement stmtPessoa = Armazenamento.conn.prepareStatement(sqlPessoa);
	        ResultSet generatedKeys = stmtPessoa1.getGeneratedKeys();
	        if (generatedKeys.next()) {
	        int lastInsertId = generatedKeys.getInt(1);
	        id = lastInsertId;
	        }
	        
	        } catch (SQLException e) {
	        System.out.println("Erro ao salvar os dados da pessoa no banco de dados: " + e.getMessage());
	        }
			return 0;
	    }
	    
		public void cadastrar() {
			super.cadastrar();
			tipo=true;
			System.out.println("Digite o salario do professor:");
		    Float salario = scanner.nextFloat();
			System.out.println("Digite o curso do professor:");
			String curso = scanner.next();
		    setSalario(salario);
		    setCargo(curso);
		    inserir();
		}

		public static void editarProfessor() {
			// TODO Auto-generated method stub
			
		}

		public static void apagar() {
			// TODO Auto-generated method stub
			
		}
}
