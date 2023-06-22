package Davi_hoffmann_Takahashi_Albert;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

class Turma{
    public static int count=0;
	public int cod_sala;
	public int cod_curso;
	public int numero=0;
    public static int capacidade;
    
    static Scanner scanner = new Scanner(System.in);

    public Turma() {
    }

    public int getCurso() {
        return cod_curso;
    }

    public String getProfessor() {
        return Professor.getNome();
    }
    
    public void setCurso(int curso) {
    	cod_curso=curso;
    }
    
    public void setSala(int cod_sala) {
    	this.cod_sala=cod_sala;
    }
    
    public void setNumero(int numero) {
    	this.numero=numero;
    }
    
    public static void tamanho(int cod) {
		try {
			Statement statement = Armazenamento.conn.createStatement();
	    	ResultSet procurar_pessoa = statement.executeQuery("SELECT * FROM turma WHERE cod_turma = " + cod);
	    	capacidade = procurar_pessoa.getInt("capacidade");
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	alunos(cod);
    }
    
    public static void alunos(int cod) {
		try {
			Statement statement = Armazenamento.conn.createStatement();
	    	ResultSet procurar_pessoa = statement.executeQuery("SELECT count(*) FROM aluno WHERE cod_turma = " + cod);
            if (procurar_pessoa.next()) {
                count = procurar_pessoa.getInt(1);
            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }

    
	public static void exibir() {
        try {
	        Statement statementTurmas = Armazenamento.conn.createStatement();
	        Statement statementNumeroAlunos = Armazenamento.conn.createStatement();

        	ResultSet ver = statementTurmas.executeQuery("SELECT * FROM turma");
	        boolean mostrouTurmas = false;
	        
	        
            while (ver.next()) {
            	mostrouTurmas = true;
                int cod_turma = ver.getInt("cod_turma");
                int curso = ver.getInt("cod_curso");
                int cod_sala = ver.getInt("cod_sala");
                ResultSet numero = statementNumeroAlunos.executeQuery("SELECT count(*) FROM aluno WHERE cod_turma = "+ cod_turma);

 	           int countAlunos=0;
 	           for (; numero.next();) {
 	        	  countAlunos = numero.getInt(1);
 	            }
               
 	            System.out.println("--------------------------");
                System.out.println("Código da turma: " + cod_turma);
                System.out.println("Código do curso: " + curso);
                System.out.println("Código da sala: " + cod_sala);
                System.out.println("Número de alunos: " + countAlunos);
                System.out.println("--------------------------");
                
                System.out.println();
                
            }
            
            if(!mostrouTurmas) {
            	System.out.println("** Nenhuma turma encontrada **");
            }
            
        } catch (SQLException e) {
            System.out.println("Erro ao exibir os atributos da tabela turma: " + e.getMessage());
        }

	}
	
	public static ResultSet pesquisar() {
		try{
			System.out.println("Qual o código da turma?");
            String nomeAluno = scanner.next();

            String sql = "SELECT * FROM turma WHERE cod_turma = '" + nomeAluno + "'";

            Statement statement = Armazenamento.conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                int id = resultSet.getInt("cod_turma");
                String cod_curso = resultSet.getString("cod_curso");
                String cod_sala = resultSet.getString("cod_sala");

                System.out.println("Turma encontrada:");
                System.out.println("ID: " + id);
                System.out.println("Código do curso: " + cod_curso);
                System.out.println("Código da sala: " + cod_sala);
            } else {
                System.out.println("Sala não encontrada.");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao pesquisar turma: " + e.getMessage());
        }
		return null;

	}
	
public void Inserir() {
        
        try {
        
        String sqlPessoa1 = "INSERT INTO turma ( cod_curso, cod_sala) VALUES (?,?)";
        PreparedStatement stmtPessoa1 = Armazenamento.conn.prepareStatement(sqlPessoa1);
        
        stmtPessoa1.setInt(1, cod_curso);
        stmtPessoa1.setInt(2, cod_sala);
        stmtPessoa1.executeUpdate();
        stmtPessoa1.close();
        Armazenamento.conn.close();
        
        } catch (SQLException e) {
        System.out.println("Erro ao salvar os dados da turma no banco de dados: " + e.getMessage());
    }}
    
	public void cadastrarTurma() {
		System.out.println("Digite o id do curso:");
		int curso = scanner.nextInt();
		System.out.println("Digite o id da sala:");
	    int sala = scanner.nextInt();

		setCurso(curso);
		setSala(sala);
	}

	public static void editarTurma() {
		 try {
	            System.out.print("Insira o código da turma: ");
	            int id = scanner.nextInt();

	            Statement statement = Armazenamento.conn.createStatement();
	            ResultSet contar = statement.executeQuery("SELECT count(*) FROM turma WHERE cod_turma = " + id);

	            int count = 0;
	            if (contar.next()) {
	                count = contar.getInt(1);
	            }

	            if (count > 0) {
	                System.out.print("Insira o código do curso para editar: ");
	                int curso = scanner.nextInt();
	                System.out.print("Insira o código da sala para editar: ");
	                int sala = scanner.nextInt();

	                String editar_curso = "UPDATE turma SET cod_curso = ?, cod_sala=? WHERE cod_turma = ?";
	                PreparedStatement editar = Armazenamento.conn.prepareStatement(editar_curso);
	                editar.setInt(1, curso);
	                editar.setInt(2, sala);
	                editar.setInt(3, id);
	                editar.executeUpdate();
	            } else {
	                System.out.println("** Turma não encontrada. **");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
	}
	
	public void deletar(){
		
    	try {
        System.out.print("Insira o código da turma para deletar: ");
        int codPessoa = scanner.nextInt();
        String deletePessoaSql = "DELETE FROM turma WHERE cod_turma = ?";
        PreparedStatement deletePessoaStatement = Armazenamento.conn.prepareStatement(deletePessoaSql);
        deletePessoaStatement.setInt(1, codPessoa);
        int pessoaRowsAffected = deletePessoaStatement.executeUpdate();
        System.out.println("Deletado " + pessoaRowsAffected + " informações na tabela.");
    	}catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Erro em apagar a turma do banco de dados. Erro: " + e.getMessage());
					
		}
}
}
