package Davi_hoffmann_Takahashi_Albert;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

class Turma{
    public int cod_sala, cod_curso;
    
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

    
	public static void exibir() {
        try {
 	       	Statement statement = Armazenamento.conn.createStatement();
	           ResultSet contar = statement.executeQuery("SELECT count(*) FROM turma");
	           ResultSet ver = statement.executeQuery("SELECT * FROM turma");
	           int count=0;
	           for (; contar.next();) {
	        	   count = contar.getInt(1);
	            }

         if (count>0) {
        	 
            while (contar.next()) {
                int cod_turma = ver.getInt("cod_turma");
                String numero_alunos = ver.getString("numero_alunos");
                int curso = ver.getInt("cod_curso");
                int cod_sala = ver.getInt("cod_sala");

                System.out.println("Código da turma: " + cod_turma);
                System.out.println("Cargo do professor: " + numero_alunos);
                System.out.println("Código do curso: " + curso);
                System.out.println("Código da sala: " + cod_sala);
                System.out.println();
                
            }}else {
            	System.out.println("Nenhuma turma encontrada.");
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
                String numero_alunos = resultSet.getString("numero_alunos");
                String cod_curso = resultSet.getString("cod_curso");
                String cod_sala = resultSet.getString("cod_sala");

                System.out.println("Turma encontrada:");
                System.out.println("ID: " + id);
                System.out.println("Numero de alunos: " + numero_alunos);
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
        
        String sqlPessoa1 = "INSERT INTO turma ( cod_curso, cod_sala, numero_alunos) VALUES (?,?,?)";
        PreparedStatement stmtPessoa1 = Armazenamento.conn.prepareStatement(sqlPessoa1);
        
        stmtPessoa1.setInt(1, cod_curso);
        stmtPessoa1.setInt(2, cod_sala);
        stmtPessoa1.setInt(3, 0);
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
		// TODO Auto-generated method stub
		
	}

	public static void apagar() {
		// TODO Auto-generated method stub
		
	}
}
