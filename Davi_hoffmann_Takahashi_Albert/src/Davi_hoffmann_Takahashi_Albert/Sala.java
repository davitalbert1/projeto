package Davi_hoffmann_Takahashi_Albert;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Scanner;

public class Sala {
	
	public static String nome_sala, bloco_sala;
    public static int capacidade_sala, numero_sala;
    
    static Scanner scanner = new Scanner(System.in);

    public Sala() {
    }

    public String getNome() {
        return nome_sala;
    }

    public int getCapacidade() {
        return capacidade_sala;
    }
    
    public static void setNome(String nome) {
        nome_sala=nome;
   }
    
    public static void setCapacidade(int capacidade) {
         capacidade_sala=capacidade;
    }
    
    public static void setNumero(int numero) {
        numero_sala=numero;
   }
    
    public static void setBloco(String bloco) {
        bloco_sala=bloco;
   }
    
	public static void editarSala() {
		System.out.println("Digite o nome da sala:");
	    String nome = scanner.next();
		System.out.println("Digite a capacidade da sala:");
		int capacidade = scanner.nextInt();
		System.out.println("Digite o número da sala:");
		int numero = scanner.nextInt();
		System.out.println("Digite o bloco da sala:");
		String bloco = scanner.next();
		setNome(nome);
		setCapacidade(capacidade);
		setNumero(numero);
		setBloco(bloco);
	}
    
	public static void exibir() {
        try {
 	       	Statement statement = Armazenamento.conn.createStatement();
	           ResultSet contar = statement.executeQuery("SELECT count(*) FROM sala");
	           int count=0;
	           for (; contar.next();) {
	        	   count = contar.getInt(1);
	            }

         if (count>0) {
        	 
            while (contar.next()) {
                int cod= contar.getInt("cod_sala");
                String nome = contar.getString("nome");
                int capacidade = contar.getInt("capacidade");
                int numero_sala = contar.getInt("numero");
                int bloco_sala = contar.getInt("bloco");

                System.out.println("Código da sala: " + cod);
                System.out.println("Nome da sala: " + nome);
                System.out.println("Capacidade da sala: " + capacidade);
                System.out.println("Número da sala: " + numero_sala);
                System.out.println("Bloco da sala: " + bloco_sala);
                System.out.println();
                
            }}else {
            	System.out.println("Nenhuma turma encontrada.");
            }
            
        } catch (SQLException e) {
            System.out.println("Erro ao exibir os atributos da tabela pessoa: " + e.getMessage());
        }

	}
    
    public void inserir() {
        
        try {
        
        String sqlPessoa1 = "INSERT INTO Sala (nome_sala, bloco_sala, capacidade_sala, numero_sala) VALUES (?, ?, ?, ?)";
        PreparedStatement stmtPessoa1 = Armazenamento.conn.prepareStatement(sqlPessoa1);
        
        stmtPessoa1.setString(1, nome_sala);
        stmtPessoa1.setString(2, bloco_sala);
        stmtPessoa1.setInt(3, capacidade_sala);
        stmtPessoa1.setInt(4, numero_sala);
        stmtPessoa1.executeUpdate();
        stmtPessoa1.close();
        Armazenamento.conn.close();
        
        } catch (SQLException e) {
        System.out.println("Erro ao salvar os dados da pessoa no banco de dados: " + e.getMessage());
        }
    }
    
	public static void cadastrar() {
		System.out.println("Digite o nome da sala:");
	    String nome = scanner.next();
		System.out.println("Digite a capacidade da sala:");
		int capacidade = scanner.nextInt();
		System.out.println("Digite o número da sala:");
		int numero = scanner.nextInt();
		System.out.println("Digite o bloco da sala:");
		String bloco = scanner.next();
		
		setNome(nome);
		setCapacidade(capacidade);
		setNumero(numero);
		setBloco(bloco);
	}

	public static void apagar() {
		// TODO Auto-generated method stub
		
	}
}