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
		public int cod_professor, cod_pessoa, cod;

	    public Professor() {}
	    
	    public static void setSalario(float salario) {
	    	salario_professor=salario;
	    }
	    
	    public static void setCargo(String curso) {
	    	curso_professor=curso;
	    }
	    
		public void exibir() {
	        try {
	        	Pessoa pessoa = new Pessoa();
				pessoa.exibir();
	        	Statement statement = Armazenamento.conn.createStatement();
	 	       
	           ResultSet professor = statement.executeQuery("SELECT count(*) FROM professor");
		           int count=0;
		           for (; professor.next();) {
		        	   count = professor.getInt(1);
		            }

	         if (count>0) {
	        	 ResultSet procurar_professor = statement.executeQuery("SELECT * FROM professor");
	            while (professor.next()) {
	                int curso= procurar_professor.getInt("cod_curso");
	                float salario= procurar_professor.getFloat("salario");
	                
	                System.out.println("Salario do professor: R$" + salario);
	                System.out.println("Código do curso do professor: " + curso);
	                System.out.println();
	                System.out.println("----------------------");
	                
	            }}else {
	            	System.out.println("Nenhum professor encontrado.");
	            }
	            
	        } catch (SQLException e) {
	            System.out.println("Erro ao exibir os atributos da tabela professor: " + e.getMessage());
	        }

		}
		
		public int pesquisar() {
			try{
				System.out.println("Digite o código da pessoa:");
				cod_pessoa = scanner.nextInt();
				Statement statement = Armazenamento.conn.createStatement();
	            
				ResultSet procurar_pessoa = statement.executeQuery("SELECT * FROM professor WHERE cod_pessoa = "+ cod_pessoa);

	            if (procurar_pessoa.next()) {
	                float salario = procurar_pessoa.getFloat("salario");
	                int curso  = procurar_pessoa.getInt("cod_curso");
	                cod = procurar_pessoa.getInt("cod_professor");
	                
					Pessoa pessoa = new Pessoa();
					pessoa.getPessoa(cod_pessoa);

	                System.out.println("Professor encontrado:");
	                System.out.println("ID: " + cod);
	                System.out.println("Salario: " + salario);
	                System.out.println("Curso: " + curso);
	                System.out.println("----------------------");
	            } else {
	                System.out.println("Professor não encontrado.");
	            }

	        } catch (SQLException e) {
	            System.out.println("Erro ao pesquisar professor: " + e.getMessage());
	        }
			return 0;

		}
	    
	    public int inserir() {
	        
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

		   public void editar() {
		        try {
		            System.out.print("Insira o código do professor: ");
		            int id = scanner.nextInt();

		            Statement statement = Armazenamento.conn.createStatement();
		            ResultSet contar = statement.executeQuery("SELECT count(*) FROM professor WHERE cod_professor = " + id);

		            int count = 0;
		            if (contar.next()) {
		                count = contar.getInt(1);
		            }

		            if (count > 0) {
		               

		                System.out.print("Insira o código curso do professor para editar: ");
		                int curso = scanner.nextInt();
		                System.out.print("Insira o salario do professor para editar: ");
		                float salario = scanner.nextInt();

		                String editar_curso = "UPDATE professor SET cod_curso = ?, salario=? WHERE cod_professor = ?";
		                PreparedStatement editar = Armazenamento.conn.prepareStatement(editar_curso);
		                editar.setInt(1, curso);
		                editar.setFloat(2, salario);
		                editar.setInt(3, id);
		                editar.executeUpdate();
		                
		                ResultSet rsPessoa = statement.executeQuery("SELECT cod_pessoa FROM professor WHERE cod_professor="+id);

		                
		                Pessoa pessoa = new Pessoa();
		                if (rsPessoa.next())
		                   pessoa.editar(rsPessoa.getInt(1));
		            } else {
		                System.out.println("Nenhum professor encontrado.");
		            }
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }

		public void apagar() {
			try {
                System.out.print("Insira o código do professor para deletar: ");
                cod_pessoa = scanner.nextInt();
                String deletePessoaSql = "DELETE FROM professor WHERE cod_pessoa = ?";
                PreparedStatement deletePessoaStatement = Armazenamento.conn.prepareStatement(deletePessoaSql);
                deletePessoaStatement.setInt(1, cod_pessoa);
                int pessoaRowsAffected = deletePessoaStatement.executeUpdate();
                System.out.println("Deletado " + pessoaRowsAffected + " informações na tabela professor.");
                Pessoa pessoa = new Pessoa();
                pessoa.deletar(cod_pessoa);
			}catch (SQLException e) {
    				e.printStackTrace();
    				System.out.println("Erro em acessar o banco de dados. Erro: " + e.getMessage());
            	}
			
		}
			
		}