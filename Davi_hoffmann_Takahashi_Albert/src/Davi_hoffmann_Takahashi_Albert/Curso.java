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
    private static int carga_horaria, cod_curso;
    private boolean ativo;
    
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
    
	public void exibir() {
        try {
 	       	Statement statement = Armazenamento.conn.createStatement();
	           ResultSet contar = statement.executeQuery("SELECT count(*) FROM curso");
	           int count=0;
	           for (; contar.next();) {
	        	   count = contar.getInt(1);
	            }

         if (count>0) {
        	 
            while (contar.next()) {
            	ResultSet ver = statement.executeQuery("SELECT * FROM curso");
                int cod= ver.getInt("cod_curso");
                String nome = ver.getString("nome_curso");
                int descricao = ver.getInt("descricao_curso");
                int carga = ver.getInt("carga_horaria");
                boolean ativo = ver.getBoolean("ativo");
                
                String reposta;
                if (ativo==true) {
                	reposta = "ativo";
                }else {
                	reposta = "inativo";
                }

                System.out.println("Código do curso: " + cod);
                System.out.println("Nome do curso: " + nome);
                System.out.println("Descrição do curso: " + descricao);
                System.out.println("Carga horária do curso: " + carga);
                System.out.println("Status do curso: " + reposta);
                System.out.println();
                
            }}else {
            	System.out.println("Nenhum curso encontrado.");
            }
            
        } catch (SQLException e) {
            System.out.println("Erro ao exibir os atributos da tabela curso: " + e.getMessage());
        }

	}
	
	public void deletar(){
			
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
	
	public int pesquisar() {
		try{
			System.out.println("Digite o id do curso.");
			cod_curso = scanner.nextInt();
			Statement statement = Armazenamento.conn.createStatement();
            
			ResultSet procurar_pessoa = statement.executeQuery("SELECT * FROM curso WHERE cod_curso = "+ cod_curso);

            if (procurar_pessoa.next()) {
            	String nome = procurar_pessoa.getString("nome");
                String descricao  = procurar_pessoa.getString("descricao");
                int carga_horaria  = procurar_pessoa.getInt("carga_horaria");
                cod_curso  = procurar_pessoa.getInt("cod_curso");
                boolean ativo  = procurar_pessoa.getBoolean("ativo");

                System.out.println("Curso encontrado:");
                System.out.println("ID: " + cod_curso);
                System.out.println("Nome: " + nome);
                System.out.println("Descricao: " + descricao);
                System.out.println("Carga horaria: " + carga_horaria);
                System.out.println("Ativo: " + ativo);
            } else {
                System.out.println("Curso não encontrado.");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao pesquisar curso: " + e.getMessage());
        }
		return 0;

	}
	
	public static void ativo() {
	    boolean opcao = false;
	    int ativo = 0;

	    while (ativo !=1 && ativo !=2) {
	        System.out.println("Você quer ver os cursos ativos ou não ativos?(1:sim / 2: não)");
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
	        Statement statement = Armazenamento.conn.createStatement();
	        ResultSet contar = statement.executeQuery("SELECT count(*) FROM curso");
	        int count = 0;

	        while (contar.next()) {
	            count = contar.getInt(1);
	        }

	        if (count > 0) {
	            String query = "SELECT * FROM curso WHERE ativo = ?";
	            PreparedStatement statement1 = Armazenamento.conn.prepareStatement(query);
	            statement1.setBoolean(1, opcao);
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
		 try {
	            System.out.print("Insira o código do curso: ");
	            int id = scanner.nextInt();

	            Statement statement = Armazenamento.conn.createStatement();
	            ResultSet contar = statement.executeQuery("SELECT count(*) FROM curso WHERE cod_curso = " + id);

	            int count = 0;
	            if (contar.next()) {
	                count = contar.getInt(1);
	            }

	            if (count > 0) {

	                System.out.print("Insira o nome para editar: ");
	                String nome = scanner.next();
	                System.out.print("Insira a descrição do curso para editar: ");
	                String descricao = scanner.next();
	                System.out.print("Insira a carga horária do curso para editar: ");
	                int carga = scanner.nextInt();
	                
	                int ativo=0;
	                boolean opcao = false;
	                do {
	                System.out.print("Insira se o curso está ativo para editar (0:não / 1:sim): ");
	                ativo = scanner.nextInt();
	                
	                switch(ativo) {
	                case 0:
	                	opcao = false;
	                break;
	                case 1:
	                	opcao = true;
		            break;
		            default:
		            	System.out.print("Opção inválida, selecione outra.");
		            break;
	                }}while(ativo!=1 && ativo !=0);

	                String editar_curso = "UPDATE curso SET nome = ? WHERE cod_curso = ?";
	                PreparedStatement editar = Armazenamento.conn.prepareStatement(editar_curso);
	                editar.setString(1, nome);
	                editar.setInt(2, id);
	                editar.executeUpdate();

	                String editar_descricao = "UPDATE curso SET descricao = ? WHERE cod_curso = ?";
	                PreparedStatement editar_D = Armazenamento.conn.prepareStatement(editar_descricao);
	                editar_D.setString(1, descricao);
	                editar_D.setInt(2, id);
	                editar_D.executeUpdate();
	                
	                String editar_carga = "UPDATE curso SET carga_horaria = ? WHERE cod_curso = ?";
	                PreparedStatement editar_C = Armazenamento.conn.prepareStatement(editar_carga);
	                editar_C.setInt(1, carga);
	                editar_C.setInt(2, id);
	                editar_C.executeUpdate();
	                
	                String editar_ativo = "UPDATE curso SET ativo = ? WHERE cod_curso = ?";
	                PreparedStatement editar_A = Armazenamento.conn.prepareStatement(editar_ativo);
	                editar_A.setBoolean(1, opcao);
	                editar_A.setInt(2, id);
	                editar_A.executeUpdate();
	            } else {
	                System.out.println("Nenhum aluno encontrado.");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
	}
}
