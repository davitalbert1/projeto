package Davi_hoffmann_Takahashi_Albert;

import java.util.Date;

public class aluno extends pessoa{
	
	public int id, disciplinaID, turmaID, cursoID;
	public String curso, disciplina, turma, sala;

	public aluno(String nome, String cpf, int id, int disciplinaID, int turmaID, int cursoID, String curso, String disciplina, String turma, String sala){
		super(nome, cpf);
		this.id= id;
		this.nome = nome;
		this.cpf  = cpf;
		this.data_nascimento = data_nascimento;
		this.disciplinaID  = disciplinaID;
		this.turmaID  = turmaID;
		this.cursoID  = cursoID;
		this.curso  = curso;
		this.disciplina  = disciplina;
		this.turma  = turma;
		this.sala  = sala;
	}
	
	public int getDisciplinaID() {
		return disciplinaID;
	}
	
	public int getTurmaID() {
		return disciplinaID;
	}
	
	public String getCurso() {
		return curso;
	}
	
	public String getDisciplina() {
		return disciplina;
	}
	
	public String getTurma() {
		return turma;
	}
	
	public String getSala() {
		return sala;
	}
}
