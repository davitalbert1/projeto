package Davi_hoffmann_Takahashi_Albert;
import java.util.Date;
import java.util.*;

public class turma extends sala{
	
	public int id_turma, numero_aluno, disciplinaID, cursoID, salaID;
	public String info;
	
	public turma(int id_sala, int numero_sala, String bloco_sala, String curso, String tipo, String bloco, int id, int numero, int cursoID, int numero_pessoas, String nome, String curso_sala) {
		super(id_sala, numero_sala, bloco_sala, curso, tipo, bloco, id, numero, cursoID, numero_pessoas, nome, curso_sala);
		// TODO Auto-generated constructor stub
	}
	
	public int getId_turma() {
		return id_turma;
	}
	
	public int getNumero_aluno() {
		return numero_aluno;
	}
	
	public int getDisciplinaID() {
		return disciplinaID;
	}
	
	public int getCursoID() {
		return cursoID;
	}
	
	public int getSalaId() {
		return salaID;
	}
	
	public String getInfo() {
		return info;
	}

}
