package Davi_hoffmann_Takahashi_Albert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Aluno extends Pessoa {
	private  int matricula_aluno;
	private String curso_aluno;
	private static ResultSet contar, ver;
	
	static Scanner scanner = new Scanner(System.in);

	    public int getMatricula(int matricula) {
	    	String sqlAluno = "SELECT * FROM aluno WHERE ";
	        return matricula_aluno;
	    }
	    
	    private String getCurso(String curso) {
	    	String sqlAluno = "SELECT * FROM aluno WHERE ";
	        return curso_aluno;
	    }
		public void setCursuo(String curso) {
			curso_aluno = curso;
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
	            }}
		}
		
		public static void exibir() {
	        try {
	 	       	Statement statement = Armazenamento.conn.createStatement();
	           ResultSet professor = statement.executeQuery("SELECT count(*) FROM aluno");
	           
	          ResultSet pessoa = Pessoa.getPesquisa();
	           
	           ResultSet procurar_pessoa = statement.executeQuery("SELECT * FROM pessoa");
	           ResultSet procurar_aluno = statement.executeQuery("SELECT * FROM aluno");
		           int count=0;
		           for (; pessoa.next();) {
		        	   count = pessoa.getInt(1);
		            }
		           
		           int count1=0;
		           for (; professor.next();) {
		        	   count1 = professor.getInt(1);
		            }

	         if (count>0 || count1>0) {
	            while (procurar_pessoa.next()) {
	            	int cod_pessoa= procurar_pessoa.getInt("cod_pessoa");
	                int cod_professor= procurar_aluno.getInt("cod_aluno");
	                int cod_turma= procurar_aluno.getInt("cod_turma");
	                int matricula= procurar_aluno.getInt("matricula");
	                String curso= procurar_aluno.getString("curso");
	                String nome = procurar_pessoa.getString("nome");
	                String email = procurar_pessoa.getString("email");
	                String endereco = procurar_pessoa.getString("endereco");
	                String CPF = procurar_pessoa.getString("CPF");

	                System.out.println("Código da pessoa: " + cod_pessoa);
	                System.out.println("Código do professor: " + cod_professor);
	                System.out.println("Código da turma: " + cod_turma);
	                System.out.println("Matricula do aluno: " + matricula);
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
		
	    public void inserir() {
	    	
	        try {
	        	super.inserir();
	            String sqlAluno = "INSERT INTO aluno (curso) VALUES (?,?)";
	            PreparedStatement stmtAluno = Armazenamento.conn.prepareStatement(sqlAluno);
	            stmtAluno.setString(1, curso_aluno);
	            stmtAluno.executeUpdate();
	            stmtAluno.close();
	            Armazenamento.conn.close();

	            System.out.println("Dados salvos no banco de dados com sucesso!");
	        } catch (SQLException e) {
	            System.out.println("Erro ao salvar os dados do aluno no banco de dados: " + e.getMessage());
	        }
	    }
	    
	    public void cadastrar() {
	    	tipo=false;
	    	super.cadastrar();
			System.out.println("Digite o curso do aluno:");
		    String curso = scanner.next();
		    setCursuo(curso);
		    
		try {
		    Statement statement = Armazenamento.conn.createStatement();
	        contar = statement.executeQuery("SELECT count(cod_turma) FROM turma ");
	        ver = statement.executeQuery("SELECT * FROM turma ");
		    
	        int count=0;
	           for (; contar.next();) {
	        	   count = contar.getInt(1);
	            }
	           
	           if(count>0) {
	        	   System.out.println("Selecione a turma:");
	        	   while(contar.next()) {
	                   int cod_turma = ver.getInt("cod_turma");
	                   int sala = ver.getInt("cod_curso");
	                   int curso_turma = ver.getInt("cod_sala");

	                   System.out.println("Código da turma: " + cod_turma);
	                   System.out.println("Código do curso: " + curso_turma);
	                   System.out.println("Código da sala: " + sala);
	                   System.out.println();
	        	   }
	           }else {
	        	   System.out.println("Nenhuma turma encotrada, insira um turma antes de inserir um aluno.");
	           }
	           
		}catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }
	    }

		public static void editarAluno() {
			// TODO Auto-generated method stub
			
		}

		public static void apagar() {
			// TODO Auto-generated method stub
			
		}
}
