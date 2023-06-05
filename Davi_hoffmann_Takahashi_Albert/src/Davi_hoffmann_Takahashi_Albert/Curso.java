package Davi_hoffmann_Takahashi_Albert;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Curso {
	private static String nome_curso, descricao_curso;
    private static int carga_horaria;
    
    static Scanner scanner = new Scanner(System.in);

    public Curso() {
    }

    public String getNome() {
        return nome_curso;
    }

    public int getCarga() {
    	
        return carga_horaria;
    }
        
    public static void setNome(String nome) {
    	nome_curso=nome;
    }
    
    public static void setCarga(int carga) {
    	carga_horaria=carga;
    }
    
    public static void setDescricao(String descricao) {
    	descricao_curso=descricao;
    }
    
	public static void exibir() {
        try {
 	       	Statement statement = Armazenamento.conn.createStatement();
	           ResultSet contar = statement.executeQuery("SELECT count(*) FROM curso");
	           int count=0;
	           for (; contar.next();) {
	        	   count = contar.getInt(1);
	            }

         if (count>0) {
        	 
            while (contar.next()) {
                int cod= contar.getInt("cod_curso");
                String nome = contar.getString("nome_curso");
                int descricao = contar.getInt("descricao_curso");
                int carga = contar.getInt("carga_horaria");

                System.out.println("Código do curso: " + cod);
                System.out.println("Nome do curso: " + nome);
                System.out.println("Descrição do curso: " + descricao);
                System.out.println("Carga horária do curso: " + carga);
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
        
        String sqlPessoa1 = "INSERT INTO curso (nome, descricao, carga_horaria) VALUES (?, ?, ?)";
        PreparedStatement stmtPessoa1 = Armazenamento.conn.prepareStatement(sqlPessoa1);
        
        stmtPessoa1.setString(1, nome_curso);
        stmtPessoa1.setString(2, descricao_curso);
        stmtPessoa1.setInt(3, carga_horaria);
        stmtPessoa1.executeUpdate();
        stmtPessoa1.close();
        Armazenamento.conn.close();
        
        } catch (SQLException e) {
        System.out.println("Erro ao salvar os dados da pessoa no banco de dados: " + e.getMessage());
    }}
    
	protected void cadastrarCurso() {
		System.out.println("Digite o nome do curso:");
	    String nome = scanner.next();
		System.out.println("Digite a carga horaria do curso:");
		int carga = scanner.nextInt();
		System.out.println("Digite a descrição do curso:");
		String descricao = scanner.next();

		setNome(nome);
		setCarga(carga);
		setDescricao(descricao);
	}
}
