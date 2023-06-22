package Davi_hoffmann_Takahashi_Albert;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Aluno extends Pessoa {
    private int codPessoa, cod, matricula_aluno, numero_alunos;
    private int cod_turma, curso_aluno;

    static Scanner scanner = new Scanner(System.in);

    public void setCurso(int curso) {
        curso_aluno = curso;
    }
    
    public void setTurma(int turma) {
    	cod_turma = turma;
    }

    public void exibir() {
        try {
            Statement statement = Armazenamento.conn.createStatement();
            ResultSet aluno = statement.executeQuery("SELECT COUNT(*) FROM aluno");

            int count1 = 0;
            while (aluno.next()) {
                count1 = aluno.getInt(1);
            }

            if (count1 > 0) {
                ResultSet procurar_aluno = statement.executeQuery("SELECT * FROM aluno");

                while (procurar_aluno.next()) {
                    Pessoa pessoa = new Pessoa();
                    pessoa.exibir();
                    int cod_turma = procurar_aluno.getInt("cod_turma");
                    int matricula = procurar_aluno.getInt("matricula");
                    String curso = procurar_aluno.getString("curso");

                    System.out.println("Código do aluno: " + matricula);
                    System.out.println("Código da turma: " + cod_turma);
                    System.out.println("Matricula do aluno: " + matricula);
                    System.out.println("Curso do aluno: " + curso);
                    System.out.println("----------------------");
                }
            } else {
                System.out.println("Nenhum aluno encontrado.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao exibir os atributos da tabela aluno: " + e.getMessage());
        }
    }

    public int pesquisar() {
        try {
            System.out.println("Digite o código da pessoa:");
            cod = scanner.nextInt();
            Statement statement = Armazenamento.conn.createStatement();

            ResultSet procurar_pessoa = statement.executeQuery("SELECT * FROM aluno WHERE cod_pessoa = " + cod);

            if (procurar_pessoa.next()) {

                int matricula = procurar_pessoa.getInt("matricula");
                String curso = procurar_pessoa.getString("curso");
                String turma = procurar_pessoa.getString("cod_turma");
                cod = procurar_pessoa.getInt("cod_pessoa");
                Pessoa pessoa = new Pessoa();
                pessoa.getPessoa(cod);

                System.out.println("Aluno encontrado:");
                System.out.println("Matricula: " + matricula);
                System.out.println("Curso: " + curso);
                System.out.println("Turma: " + turma);
                System.out.println("----------------------");
            } else {
                System.out.println("Aluno não encontrado.");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao pesquisar aluno: " + e.getMessage());
        }
        return 0;

    }

    public int inserir() {
        try {
            int idPessoa = super.inserir();
            String sqlAluno = "INSERT INTO aluno (curso, cod_turma, cod_pessoa) VALUES (?, ?, ?)";
            PreparedStatement stmtAluno = Armazenamento.conn.prepareStatement(sqlAluno);
            stmtAluno.setInt(1, curso_aluno);
            stmtAluno.setInt(2, cod_turma);
            stmtAluno.setInt(3, idPessoa);
            stmtAluno.executeUpdate();
            stmtAluno.close();
            numero_alunos = numero_alunos + 1;
            Turma turma = new Turma();
            turma.setNumero(numero_alunos);
            System.out.println("Dados salvos no banco de dados com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao salvar os dados do aluno no banco de dados: " + e.getMessage());
        }
        return 0;
    }

    public void cadastrar() {
        try {
            tipo = false;
            super.cadastrar();
            System.out.println("Digite o código do curso do aluno:");
            int curso = scanner.nextInt();
            System.out.println("Em qual turma você quer adicionar?");
            int turma = scanner.nextInt();
            setCurso(curso);
            setTurma(turma);
            inserir();

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public void editarAluno() {
        try {
            System.out.print("Insira matricula do aluno: ");
            int id = scanner.nextInt();

            Statement statement = Armazenamento.conn.createStatement();
            ResultSet contar = statement.executeQuery("SELECT count(*) FROM aluno WHERE matricula = " + id);

            int count = 0;
            if (contar.next()) {
                count = contar.getInt(1);
            }

            if (count > 0) {
               

                System.out.print("Insira o código do curso do aluno para editar: ");
                int curso = scanner.nextInt();
                System.out.print("Insira a turma do aluno para editar: ");
                int turma = scanner.nextInt();

                String editar_curso = "UPDATE aluno SET cod_curso = ?, cod_turma=? WHERE matricula = ?";
                PreparedStatement editar = Armazenamento.conn.prepareStatement(editar_curso);
                editar.setInt(1, curso);
                editar.setInt(2, turma);
                editar.setInt(3, id);
                editar.executeUpdate();
                ResultSet rsPessoa = statement.executeQuery("SELECT cod_pessoa FROM aluno WHERE matricula="+id);

                
                Pessoa pessoa = new Pessoa();
                if (rsPessoa.next())
                   pessoa.editar(rsPessoa.getInt(1));
            } else {
                System.out.println("Nenhum aluno encontrado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void apagar() {
        try {
            System.out.print("Insira o código da pessoa para deletar: ");
            codPessoa = scanner.nextInt();

            String deleteAlunoSql = "DELETE FROM aluno WHERE cod_pessoa = ?";
            PreparedStatement deleteAlunoStatement = Armazenamento.conn.prepareStatement(deleteAlunoSql);
            deleteAlunoStatement.setInt(1, codPessoa);
            int alunoRowsAffected = deleteAlunoStatement.executeUpdate();
            System.out.println("Deletado " + alunoRowsAffected + " informações na tabela aluno.");
            Pessoa pessoa = new Pessoa();
            pessoa.deletar(codPessoa);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao acessar o banco de dados. Erro: " + e.getMessage());
        }

    }
}
