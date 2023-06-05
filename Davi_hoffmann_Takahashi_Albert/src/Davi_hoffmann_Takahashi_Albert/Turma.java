package Davi_hoffmann_Takahashi_Albert;

import java.util.prefs.Preferences;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

class Turma{
	private static String curso_turma;
    public int numero_alunos,cod_turma;
    
    static Scanner scanner = new Scanner(System.in);

    public Turma() {
    }

    public String getCurso() {
        return curso_turma;
    }
    
    public int getCod() {
        return cod_turma;
    }

    public String getProfessor() {
        return Professor.getNome();
    }
    
    public int getNumero() {
        return numero_alunos;
    }
    
    public static void setCurso(String curso) {
    	curso_turma=curso;
    }

    
	public static void exibir() {
        try {
 	       	Statement statement = Armazenamento.conn.createStatement();
	           ResultSet contar = statement.executeQuery("SELECT count(*) FROM turma");
	           int count=0;
	           for (; contar.next();) {
	        	   count = contar.getInt(1);
	            }

         if (count>0) {
        	 
            while (contar.next()) {
                int cod_turma = contar.getInt("cod_turma");
                String numero_alunos = contar.getString("numero_alunos");
                int curso = contar.getInt("cod_curso");
                int cod_sala = contar.getInt("cod_sala");

                System.out.println("Código da turma: " + cod_turma);
                System.out.println("Cargo do professor: " + numero_alunos);
                System.out.println("Código do curso: " + curso);
                System.out.println("Código da sala: " + cod_sala);
                System.out.println();
                
            }}else {
            	System.out.println("Nenhuma turma encontrada.");
            }
            
        } catch (SQLException e) {
            System.out.println("Erro ao exibir os atributos da tabela pessoa: " + e.getMessage());
        }

	}
	
public void Inserir() {
        
        try {
        
        String sqlPessoa1 = "INSERT INTO curso (curso_turma) VALUES (?)";
        PreparedStatement stmtPessoa1 = Armazenamento.conn.prepareStatement(sqlPessoa1);
        
        stmtPessoa1.setString(1, curso_turma);
        stmtPessoa1.executeUpdate();
        stmtPessoa1.close();
        Armazenamento.conn.close();
        
        } catch (SQLException e) {
        System.out.println("Erro ao salvar os dados da pessoa no banco de dados: " + e.getMessage());
    }}
    
	public void cadastrarTurma() {
		System.out.println("Digite o curso da turma:");
	    String curso = scanner.next();

		setCurso(curso);
	}
}
