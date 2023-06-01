package Davi_hoffmann_Takahashi_Albert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Armazenamento {

    private static final String URL = "jdbc:mysql://localhost:3306/projeto";
    private static final String USUARIO = "root";
    private static final String SENHA = "";
    private static Connection conn = null;
    private static int count=0;
    
    
    public Armazenamento() {
    		try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.println("Sucesso em conectar de dados.");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				System.out.println("Erro em conectar de dados. Erro: " + e.getMessage());
			} 
			try {
				Armazenamento.conn = DriverManager.getConnection(URL, USUARIO, SENHA);
				System.out.println("Sucesso em acessar de dados.");
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Erro em acessar o banco de dados. Erro: " + e.getMessage());
						
			}
    }
    
    public long salvarPessoa() {
    	
        String nome = null;
        String sobrenome = null;
        String telefone = null;
        String email = null;
        String endereco = null;
        
        try {
    	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projeto", "usuario", "senha");
        String sqlPessoa1 = "INSERT INTO pessoa (nome, sobrenome, telefone, email, endereco) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement stmtPessoa1 = connection.prepareStatement(sqlPessoa1);
        
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
    
    public void salvarAluno() {
    	
    	long idPessoa = salvarPessoa();
    	
        int cod_aluno = 0;
        String matricula = null;
        String curso = null;
    	
        try {
        	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projeto", "usuario", "senha");
            String sqlAluno = "INSERT INTO aluno (matricula, curso) VALUES (?, ?)";
            PreparedStatement stmtAluno = connection.prepareStatement(sqlAluno);
            
            stmtAluno.setInt(1, cod_aluno);
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
    
    
    
    public static void exibirPessoas() {
    	
        try {
        	 	conn = DriverManager.getConnection(URL, USUARIO, SENHA);
    	       Statement statement = conn.createStatement();
   	           ResultSet contar = statement.executeQuery("SELECT count(*) FROM pessoa WHERE is_aluno = true");
		

               if(contar.getInt("numeroLinhas")>0) {          
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
               }}
               }
            catch (SQLException e) {
               System.out.println("Nenhum aluno encontrado.");
           }
    }

	public static void exibirAlunos() {
        try {
        	Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA);
 	       Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
	           ResultSet contar = statement.executeQuery("SELECT * FROM pessoa WHERE is_aluno = true");
		       ResultSet aluno = statement.executeQuery("SELECT * FROM aluno");
        	 
            while (contar.next()) {
            	int cod_pessoa = contar.getInt("cod_pessoa"); 
                String nome = contar.getString("nome");
                String email = contar.getString("email");
                String telefone = contar.getString("telefone");
                String cpf = contar.getString("cpf");
                int matricula = aluno.getInt("matricula");
                String curso = aluno.getString("curso");
                String cod_turma = aluno.getString("cod_turma");
                
            	 System.out.println("Código do professor: " + cod_pessoa);
                 System.out.println("Código da pessoa: " + cod_pessoa);
                 System.out.println("Nome do professor: " + nome);
                 System.out.println("CPF: " + cpf);
                 System.out.println("Email: " + email);
                 System.out.println("Endereco: " + matricula);
                 System.out.println("Telefone: " + telefone);
                 System.out.println("Cargo: " + curso);
                 System.out.println("Descrição: " + curso);
                 System.out.println("Capacidade: " + cod_turma);
                 System.out.println();
            }
            
        } catch (SQLException e) {
            System.out.println("Erro ao exibir os atributos da tabela pessoa: " + e.getMessage());
        }

	}
	
	public static void exibirSalas() {
        try {
        	Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA);
 	       		Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
	           ResultSet contar = statement.executeQuery("SELECT count(*) as numLinhas FROM sala");
	           contar.first();
	           
         if (contar.getInt("numLinhas")>0) {
        	 
            while (contar.next()) {
                int cod_sala = contar.getInt("cod_sala");
                String nome = contar.getString("nome");
                String local_sala = contar.getString("local_sala");
                int capacidade = contar.getInt("capacidade");
                String dia_semana = contar.getString("dia_semana");
                String disciplina = contar.getString("disciplina");

                System.out.println("Código da Sala: " + cod_sala);
                System.out.println("Nome da sala: " + nome);
                System.out.println("Local da sala: " + local_sala);
                System.out.println("Capacidade: " + capacidade);
                System.out.println("Local da sala: " + dia_semana);
                System.out.println("Disciplina: " + disciplina);
                System.out.println();
            }}else {
            	System.out.println("Nenhum registro encontrado.");
            }
            
        } catch (SQLException e) {
            System.out.println("Erro ao exibir os atributos da tabela pessoa: " + e.getMessage());
        }

	}
	
	public static void exibirCursos() {
        try {
        	
        	Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA);
 	       	Statement statement = conn.createStatement();
	           ResultSet contar = statement.executeQuery("SELECT count(*) FROM curso");

         if (count>0) {
        	 
            while (contar.next()) {
            	exibirAlunos();
                int cod_curso = contar.getInt("cod_curso");
                String nome = contar.getString("nome");
                String descricao = contar.getString("descricao");
                int capacidade = contar.getInt("capacidade");
                String carga_horaria = contar.getString("carga_horaria");

                System.out.println("Código do curso: " + cod_curso);
                System.out.println("Nome do curso: " + nome);
                System.out.println("Descrição: " + descricao);
                System.out.println("Capacidade: " + capacidade);
                System.out.println("Carga horária: " + carga_horaria);
                System.out.println();
            }}
            
        } catch (SQLException e) {
            System.out.println("Erro ao exibir os atributos da tabela pessoa: " + e.getMessage());
        }

	}
	
	public static void exibirProfessores() {
        try {
        	
        	Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA);
 	       	Statement statement = conn.createStatement();
	           ResultSet contar = statement.executeQuery("SELECT count(*) FROM pessoa WHERE is_professor = true");
		       ResultSet professor = statement.executeQuery("SELECT count(*) FROM professor");

         if (count>0) {
        	 
            while (contar.next()) {
                int cod_pessoa = contar.getInt("cod_pessoa"); 
                String nome = contar.getString("nome");
                String email = contar.getString("email");
                String telefone = contar.getString("telefone");
                String cpf = contar.getString("cpf");
                int cod_professor = professor.getInt("cod_professor");
                String cargo = professor.getString("cargo");
                String curso = professor.getString("curso");
                String endereco = professor.getString("endereco");
                float salario = professor.getFloat("salario");

                System.out.println("Código do professor: " + cod_professor);
                System.out.println("Código da pessoa: " + cod_pessoa);
                System.out.println("Nome do professor: " + nome);
                System.out.println("CPF: " + cpf);
                System.out.println("Email: " + email);
                System.out.println("Endereco: " + endereco);
                System.out.println("Telefone: " + telefone);
                System.out.println("Cargo: " + cargo);
                System.out.println("Descrição: " + curso);
                System.out.println("Capacidade: " + salario);
                System.out.println();
            }}
            
        } catch (SQLException e) {
            System.out.println("Erro ao exibir os atributos da tabela pessoa: " + e.getMessage());
        }

	}
	
	public static void exibirTurmas() {
        try {
        	
        	Connection conn = DriverManager.getConnection(URL, USUARIO, SENHA);
 	       	Statement statement = conn.createStatement();
	           ResultSet contar = statement.executeQuery("SELECT count(*) FROM turma");

         if (count>0) {
        	 
            while (contar.next()) {
            	exibirAlunos();
                int cod_turma = contar.getInt("cod_turma");
                String numero_alunos = contar.getString("numero_alunos");
                int curso = contar.getInt("cod_curso");
                int cod_sala = contar.getInt("cod_sala");

                System.out.println("Código da turma: " + cod_turma);
                System.out.println("Cargo do professor: " + numero_alunos);
                System.out.println("Código do curso: " + curso);
                System.out.println("Código da sala: " + cod_sala);
                System.out.println();
            }}
            
        } catch (SQLException e) {
            System.out.println("Erro ao exibir os atributos da tabela pessoa: " + e.getMessage());
        }

	}
}