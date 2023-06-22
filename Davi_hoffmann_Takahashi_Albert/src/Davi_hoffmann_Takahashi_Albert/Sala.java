package Davi_hoffmann_Takahashi_Albert;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Scanner;

public class Sala {
	
	public static String nome_sala, sql, dia_sala, local_sala;
    public static int capacidade_sala, numero_sala, cod_sala, cod_curso;
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
    
    public static void setLocal(String local) {
    	local_sala=local;
   }
    public static void setDia(String dia_semana) {
    	dia_sala=dia_semana;
   }
    
    public static void setCurso(int curso) {
    	cod_curso=curso;
   }
    
    public void inserir() {
        
        try {
        
        String sqlPessoa1 = "INSERT INTO Sala (nome, local_sala, capacidade, dia_semana, cod_curso) VALUES (?,?,?,?, ?)";
        PreparedStatement stmtPessoa1 = Armazenamento.conn.prepareStatement(sqlPessoa1);
        
        stmtPessoa1.setString(1, nome_sala);
        stmtPessoa1.setString(2, local_sala);
        stmtPessoa1.setInt(3, capacidade_sala);
        stmtPessoa1.setString(4, dia_sala);
        stmtPessoa1.setInt(5, cod_curso);
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
		System.out.println("Digite o dia da semana da sala:");
	    String dia_semana = scanner.next();
	    System.out.println("Digite o código do curso da sala:");
	    int curso = scanner.nextInt();
		
		setNome(nome);
		setCapacidade(capacidade);
		setDia(dia_semana);
		setLocal(local);
		setCurso(curso);
	}
    
	public static void editarSala() {
		exibir();
		System.out.println("Escolha o id de qual sala você quer:");
		cod_sala = scanner.nextInt();
        System.out.print("Insira o código curso do professor para editar: ");
        int cod_curso = scanner.nextInt();
        System.out.print("Insira o dia da semana para editar: ");
        String dia_semana = scanner.next();
        System.out.print("Insira a capacidade para editar: ");
        int capacidade = scanner.nextInt();
        System.out.print("Insira o nome para editar: ");
        String nome = scanner.next();
        System.out.print("Insira o localda sala para editar: ");
        String local_sala = scanner.next();

		try {
			String editar_curso = "UPDATE sala SET cod_curso = ?, dia_semana=?, local_sala=?, capacidade=?, nome=? WHERE cod_sala = ?";
			PreparedStatement editar = Armazenamento.conn.prepareStatement(editar_curso);
	        editar.setInt(1, cod_curso);
	        editar.setString(2, dia_semana);
	        editar.setString(3, local_sala);
	        editar.setInt(4, capacidade);
	        editar.setString(5, nome);
	        editar.setInt(3, cod_sala);
	        editar.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void deletar(){
		
            	try {
                System.out.print("Insira o código da sala para deletar: ");
                int codPessoa = scanner.nextInt();
                String deletePessoaSql = "DELETE FROM sala WHERE cod_sala = ?";
                PreparedStatement deletePessoaStatement = Armazenamento.conn.prepareStatement(deletePessoaSql);
                deletePessoaStatement.setInt(1, codPessoa);
                int pessoaRowsAffected = deletePessoaStatement.executeUpdate();
                System.out.println("Deletado " + pessoaRowsAffected + " informações na tabela.");
            	}catch (SQLException e) {
    				e.printStackTrace();
    				System.out.println("Erro em acessar o banco de dados. Erro: " + e.getMessage());
    						
    			}
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
                int local = ver.getInt("local");

                System.out.println("Código da sala: " + cod);
                System.out.println("Nome da sala: " + nome);
                System.out.println("Capacidade da sala: " + capacidade);
                System.out.println("Número da sala: " + local);
                System.out.println();
                
            }}else {
            	System.out.println("Nenhuma turma encontrada.");
            }
            
        } catch (SQLException e) {
            System.out.println("Erro ao exibir os atributos da tabela pessoa: " + e.getMessage());
        }

	}
	
	public int pesquisar() {
		try{
			System.out.println("Digite o id da sala.");
			cod_sala = scanner.nextInt();
			
			Statement statement = Armazenamento.conn.createStatement();
			ResultSet procurar_pessoa = statement.executeQuery("SELECT * FROM sala WHERE cod_sala = "+ cod_sala);

            if (procurar_pessoa.next()) {
                int capacidade = procurar_pessoa.getInt("capacidade");
                String local  = procurar_pessoa.getString("local_sala");
                String nome  = procurar_pessoa.getString("nome");
                String dia_semana  = procurar_pessoa.getString("dia_semana");

                System.out.println("Sala encontrada:");
                System.out.println("ID: " + cod_sala);
                System.out.println("Nome: " + nome);
                System.out.println("Capacidade: " + capacidade);
                System.out.println("Local: " + local);
                System.out.println("Dia da semana: " + dia_semana);
            } else {
                System.out.println("Sala não encontrado.");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao pesquisar sala: " + e.getMessage());
        }
		return 0;

	}
}