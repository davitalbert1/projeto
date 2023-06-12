package Davi_hoffmann_Takahashi_Albert;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Scanner;

public class Sala {
	
	public static String nome_sala, sql, curso_sala, dia_sala, local_sala;
    public static int capacidade_sala, numero_sala, id;
    private static ResultSet resultSet;
    
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
    
    public static void setCurso(String curso) {
    	curso_sala=curso;
   }
    
    public static void setLocal(String local) {
    	local_sala=local;
   }
    
    public void inserir() {
        
        try {
        
        String sqlPessoa1 = "INSERT INTO Sala (nome, local_sala, capacidade) VALUES (?,?, ?)";
        PreparedStatement stmtPessoa1 = Armazenamento.conn.prepareStatement(sqlPessoa1);
        
        stmtPessoa1.setString(1, nome_sala);
        stmtPessoa1.setString(2, local_sala);
        stmtPessoa1.setInt(3, capacidade_sala);
        stmtPessoa1.executeUpdate();
        stmtPessoa1.close();
        
        } catch (SQLException e) {
        System.out.println("Erro ao salvar os dados da sala no banco de dados: " + e.getMessage());
        }
    }
    
	public static void cadastrar() {
		System.out.println("Digite o nome da sala:");
	    String nome = scanner.next();
		System.out.println("Digite a capacidade da sala:");
		int capacidade = scanner.nextInt();
		System.out.println("Digite o local da sala:");
	    String local = scanner.next();
		
		setNome(nome);
		setCapacidade(capacidade);
		setLocal(local);
	}
    
	public static void editarSala() {
		exibir();
		System.out.println("Escolha o id de qual sala você quer:");
		id = scanner.nextInt();
		String sql = "SELECT * FROM sala WHERE cod_sala = '" + id + "'";
        Statement statement;
		try {
			statement = Armazenamento.conn.createStatement();
			resultSet = statement.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(resultSet);
		
		System.out.println("Digite o nome da sala:");
	    String nome = scanner.next();
		System.out.println("Digite a capacidade da sala:");
		int capacidade = scanner.nextInt();
		System.out.println("Digite o local da sala:");
		String local = scanner.next();
		
		setNome(nome);
		setCapacidade(capacidade);
		setLocal(local);
	}
	
	public static void deletar(){
		System.out.print("Você quer deletar pelo código da sala ou pelo nome?(1: código / 2: nome)");
		int opcao = scanner.nextInt();
            
		while(opcao!=1 || opcao!=2) {
            switch(opcao) {
            
            case 1:
            	try {
                System.out.print("Insira o código da sala para deletar: ");
                int codPessoa = scanner.nextInt();
                String deletePessoaSql = "DELETE FROM sala WHERE cod_curso = ?";
                PreparedStatement deletePessoaStatement = Armazenamento.conn.prepareStatement(deletePessoaSql);
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
            	System.out.print("Insira o código da sala para deletar: ");
                int nomePessoa = scanner.nextInt();
            	String deletePessoaSql1 = "DELETE FROM sala WHERE nome = ?";
                PreparedStatement deleteAlunoStatement = Armazenamento.conn.prepareStatement(deletePessoaSql1);
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
	           ResultSet contar = statement.executeQuery("SELECT count(*) FROM sala");
	           ResultSet ver = statement.executeQuery("SELECT * FROM sala");
	           int count=0;
	           for (; contar.next();) {
	        	   count = contar.getInt(1);
	            }

         if (count>0) {
        	 
            while (contar.next()) {
                int cod= ver.getInt("cod_sala");
                String nome = ver.getString("nome");
                int capacidade = ver.getInt("capacidade");
                int numero_sala = ver.getInt("numero");
                int bloco_sala = ver.getInt("bloco");

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
	
	public static ResultSet pesquisar() {
		try{
			System.out.println("Qual o nome da sala?");
            String nomeAluno = scanner.next();

            String sql = "SELECT * FROM sala WHERE nome = '" + nomeAluno + "'";

            Statement statement = Armazenamento.conn.createStatement();
            resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                int id = resultSet.getInt("cod_sala");
                String nome = resultSet.getString("nome");
                String capacidade = resultSet.getString("capacidade");
                String curso = resultSet.getString("curso");
                String local_sala = resultSet.getString("local_sala");
                String dia_semana = resultSet.getString("dia_semana");
                String local = resultSet.getString("local");

                System.out.println("Sala encontrada:");
                System.out.println("ID: " + id);
                System.out.println("Nome: " + nome);
                System.out.println("capacidade: " + capacidade);
                System.out.println("Curso: " + curso);
                System.out.println("Local: " + local);
                System.out.println("Local da sala: " + local_sala);
                System.out.println("Dia dasemana: " + dia_semana);
            } else {
                System.out.println("Sala não encontrada.");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao pesquisar sala: " + e.getMessage());
        }
		return null;

	}
}