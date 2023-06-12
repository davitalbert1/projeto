package Davi_hoffmann_Takahashi_Albert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Aluno extends Pessoa {
	private  int matricula_aluno, cod_turma, numero_alunos;
	private String curso_aluno;
	private static String sql;
	private static ResultSet contar, ver;
	
	static Scanner scanner = new Scanner(System.in);

		public void setCurso(String curso) {
			curso_aluno = curso;
		}
		
		public void setTurma(int turma) {
			cod_turma = turma;
		}
		
		public static void exibir() {
			try {
				Statement statement = Armazenamento.conn.createStatement();
				ResultSet aluno = statement.executeQuery("SELECT COUNT(*) FROM aluno");

			    int count1 = 0;
			    while (aluno.next()) {
			        count1 = aluno.getInt(1);
			    }

			    if (count1 > 0) {
			        ResultSet procurar_pessoa = statement.executeQuery("SELECT * FROM pessoa");
			        ResultSet procurar_aluno = statement.executeQuery("SELECT * FROM aluno");

			        while (procurar_pessoa.next()) {
			        	Pessoa.exibir();
			            int cod_professor = procurar_aluno.getInt("cod_aluno");
			            int cod_turma = procurar_aluno.getInt("cod_turma");
			            int matricula = procurar_aluno.getInt("matricula");
			            String curso = procurar_aluno.getString("curso");
			            String nome = procurar_pessoa.getString("nome");
			            String email = procurar_pessoa.getString("email");
			            String endereco = procurar_pessoa.getString("endereco");
			            String CPF = procurar_pessoa.getString("CPF");

			            System.out.println("Código do aluno: " + cod_professor);
			            System.out.println("Código da turma: " + cod_turma);
			            System.out.println("Matricula do aluno: " + matricula);
			            System.out.println("Nome do professor: " + nome);
			            System.out.println("Email do aluno: " + email);
			            System.out.println("Endereco do aluno: " + endereco);
			            System.out.println("CPF do aluno: " + CPF);
			            System.out.println("Curso do aluno: " + curso);
			            System.out.println();
			        }
			    } else {
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
	            
	            String sql1 = "SELECT * FROM aluno WHERE cod_aluno = '" + nomeAluno + "'";

	            Statement statement = Armazenamento.conn.createStatement();
	            ResultSet resultSet = statement.executeQuery(sql);
	            ResultSet resultSet1 = statement.executeQuery(sql1);

	            if (resultSet.next()) {
	                int id = resultSet.getInt("cod_pessoa");
	                String nome = resultSet.getString("nome");
	                String cpf = resultSet.getString("cpf");
	                String curso = resultSet1.getString("curso");
	                String turma = resultSet1.getString("turma");
	                String sala = resultSet1.getString("sala");

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
	    	
	        try {
	        	int idPessoa = super.inserir();
	            String sqlAluno = "INSERT INTO aluno (curso, cod_turma, cod_pessoa) VALUES (?, ?,?)";
	            PreparedStatement stmtAluno = Armazenamento.conn.prepareStatement(sqlAluno);
	            stmtAluno.setString(1, curso_aluno);
	            stmtAluno.setInt(2, cod_turma);
	            stmtAluno.setInt(3, idPessoa);
	            stmtAluno.executeUpdate();
	            stmtAluno.close();

	            System.out.println("Dados salvos no banco de dados com sucesso!");
	        } catch (SQLException e) {
	            System.out.println("Erro ao salvar os dados do aluno no banco de dados: " + e.getMessage());
	        }
			return 0;
	    }
	    
	    public void cadastrar() {
	    	
		    
		try {
			tipo=false;
	    	super.cadastrar();
			System.out.println("Digite o curso do aluno:");
		    String curso = scanner.next();
		    setCurso(curso);
	        TurmaAdd();
	        inserir();
	       	           
		}catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }}
	    

		public static void editarAluno() {

            try {
            	Pessoa.editar();
            	int codPessoa = Pessoa.id;
                System.out.print("Insira o curso do aluno para editar: ");
                String curso = scanner.next();
                System.out.print("Insira a turma do aluno para editar: ");
                int turma = scanner.nextInt();
                String editar_curso = "UPDATE tabela SET curso = ? WHERE cod_aluno = ?";
				PreparedStatement editar = Armazenamento.conn.prepareStatement(editar_curso);
				editar.setString(1, curso);
				editar.setInt(2, codPessoa);
				String editar_turma = "UPDATE tabela SET cod_turma = ? WHERE cod_aluno = ?";
				PreparedStatement editar_T = Armazenamento.conn.prepareStatement(editar_turma);
				editar_T.setInt(1, turma);
				editar_T.setInt(2, codPessoa);
            } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		public static void apagar() {
			try {
                System.out.print("Insira o código do aluno para deletar: ");
                int codPessoa = scanner.nextInt();
                String deletePessoaSql = "DELETE FROM aluno WHERE cod_curso = ?";
                PreparedStatement deletePessoaStatement = Armazenamento.conn.prepareStatement(deletePessoaSql);
                deletePessoaStatement.setInt(1, codPessoa);
                int pessoaRowsAffected = deletePessoaStatement.executeUpdate();
                System.out.println("Deletado " + pessoaRowsAffected + " informações na tabela.");
            	}catch (SQLException e) {
    				e.printStackTrace();
    				System.out.println("Erro em acessar o banco de dados. Erro: " + e.getMessage());
            	}
			
		}
		
		public void TurmaAdd() {
	        try {
				System.out.println("Em qual turma você quer adicionar?");
				int id = scanner.nextInt();
				numero_alunos+=1;
				String add = "UPDATE tabela SET numero_alunos = ? WHERE cod_turma = ?";
				 PreparedStatement statement = Armazenamento.conn.prepareStatement(add);
				statement.setInt(1, numero_alunos);
				statement.setInt(2, id);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
}
