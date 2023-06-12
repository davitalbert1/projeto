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
	private static String nome_curso, descricao_curso, sql;
    private static int carga_horaria;
    private static boolean ativo;
    
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
    
    public void setAtivo(boolean ativo) {
    	this.ativo=ativo;
    }
    
	public static void exibir() {
        try {
 	       	Statement statement = Armazenamento.conn.createStatement();
	           ResultSet contar = statement.executeQuery("SELECT count(*) FROM curso");
	           ResultSet ver = statement.executeQuery("SELECT * FROM curso");
	           int count=0;
	           for (; contar.next();) {
	        	   count = contar.getInt(1);
	            }

         if (count>0) {
        	 
            while (contar.next()) {
                int cod= ver.getInt("cod_curso");
                String nome = ver.getString("nome_curso");
                int descricao = ver.getInt("descricao_curso");
                int carga = ver.getInt("carga_horaria");

                System.out.println("Código do curso: " + cod);
                System.out.println("Nome do curso: " + nome);
                System.out.println("Descrição do curso: " + descricao);
                System.out.println("Carga horária do curso: " + carga);
                System.out.println();
                
            }}else {
            	System.out.println("Nenhum curso encontrado.");
            }
            
        } catch (SQLException e) {
            System.out.println("Erro ao exibir os atributos da tabela curso: " + e.getMessage());
        }

	}
	
	public static void deletar(){
			
			try {
                System.out.print("Insira o código do curso para deletar: ");
                int codPessoa = scanner.nextInt();
                String deletePessoaSql = "DELETE FROM curso WHERE cod_curso = ?";
                PreparedStatement deletePessoaStatement = Armazenamento.conn.prepareStatement(deletePessoaSql);
                deletePessoaStatement.setInt(1, codPessoa);
                int pessoaRowsAffected = deletePessoaStatement.executeUpdate();
                System.out.println("Deletado " + pessoaRowsAffected + " informações na tabela.");
            	}catch (SQLException e) {
    				e.printStackTrace();
    				System.out.println("Erro em acessar o banco de dados. Erro: " + e.getMessage());
            	}
}
	
	public static ResultSet pesquisar() {
		try{
			System.out.println("Qual o nome do curso?");
            String nomeAluno = scanner.next();

            String sql = "SELECT * FROM aluno WHERE nome = '" + nomeAluno + "'";

            Statement statement = Armazenamento.conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                int id = resultSet.getInt("cod_curso");
                String nome = resultSet.getString("nome");
                String descricao = resultSet.getString("descricao");
                int carga_horaria = resultSet.getInt("carga_horaria");
                boolean ativo = resultSet.getBoolean("ativo");

                System.out.println("Curso encontrado:");
                System.out.println("ID: " + id);
                System.out.println("Nome: " + nome);
                System.out.println("CPF: " + descricao);
                System.out.println("Carga horaria: " + carga_horaria);
                
                if(ativo==false) {
                	System.out.println("Ativo: Não");
                }else {
                	System.out.println("Ativo: Sim");
                }
            } else {
                System.out.println("Curso não encontrado.");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao pesquisar curso: " + e.getMessage());
        }
		return null;

	}
	
	public static void ativo() {
	    boolean opcao = false;
	    int ativo = 0;

	    while (ativo == 0) {
	        System.out.println("Você quer ver os cursos ativos ou não ativos?");
	        ativo = scanner.nextInt();

	        switch (ativo) {
	            case 1:
	                opcao = true;
	                break;
	            case 2:
	                opcao = false;
	                break;
	            default:
	                System.out.println("Opção inválida, selecione outra.");
	                break;
	        }
	    }

	    try {
	    	System.out.println("Digite o código do curso:");
	    	int cod_curso = scanner.nextInt();
	        Statement statement = Armazenamento.conn.createStatement();
	        ResultSet contar = statement.executeQuery("SELECT count(*) FROM curso");
	        int count = 0;

	        while (contar.next()) {
	            count = contar.getInt(1);
	        }

	        if (count > 0) {
	            String query = "SELECT * FROM curso WHERE cod_curso = ?";
	            PreparedStatement statement1 = Armazenamento.conn.prepareStatement(query);
	            statement1.setInt(1, cod_curso);
	            ResultSet resultSet = statement1.executeQuery();

	            while (resultSet.next()) {
	                int cod = resultSet.getInt("cod_curso");
	                String nome = resultSet.getString("nome_curso");
	                int descricao = resultSet.getInt("descricao_curso");
	                int carga = resultSet.getInt("carga_horaria");

	                System.out.println("Código do curso: " + cod);
	                System.out.println("Nome do curso: " + nome);
	                System.out.println("Descrição do curso: " + descricao);
	                System.out.println("Carga horária do curso: " + carga);
	                System.out.println();
	            }
	        } else {
	            System.out.println("Nenhum curso ativo encontrado.");
	        }

	    } catch (SQLException e) {
	        System.out.println("Erro ao exibir os atributos da tabela curso: " + e.getMessage());
	    }
	}

    
    public void Inserir() {
        
        try {
        
        String sqlPessoa1 = "INSERT INTO curso (nome, descricao, carga_horaria, ativo) VALUES (?,?, ?, ?)";
        PreparedStatement stmtPessoa1 = Armazenamento.conn.prepareStatement(sqlPessoa1);
        
        stmtPessoa1.setString(1, nome_curso);
        stmtPessoa1.setString(2, descricao_curso);
        stmtPessoa1.setInt(3, carga_horaria);
        stmtPessoa1.setBoolean(4, ativo);
        stmtPessoa1.executeUpdate();
        
        } catch (SQLException e) {
        System.out.println("Erro ao salvar os dados da pessoa no banco de dados: " + e.getMessage());
    }}
    
	protected void cadastrarCurso() {
		int opcao=0;
		
		while(opcao!=1 && opcao!=2) {
		
		System.out.println("Digite o nome do curso:");
	    String nome = scanner.next();
		System.out.println("Digite a carga horaria do curso:");
		int carga = scanner.nextInt();
		System.out.println("Digite a descrição do curso:");
		String descricao = scanner.next();
		
		System.out.println("O curso está ativo? (1: não / 2: sim):");
		opcao = scanner.nextInt();
		
		switch(opcao) {
		case 1:
			ativo = false;
		break;
		case 2:
			ativo = true;
		break;
		default:
			System.out.println("Opção invalida, selecione outra.");
		break;
		}

		setNome(nome);
		setCarga(carga);
		setDescricao(descricao);
		setAtivo(ativo);}
	}

	public static void editarCurso() {
		// TODO Auto-generated method stub
		
	}

	public static void apagar() {
		// TODO Auto-generated method stub
		
	}
}
