package Davi_hoffmann_Takahashi_Albert;

import java.util.Date;
import java.util.prefs.Preferences;
import java.util.*;

class Turma extends Curso{
	private String curso;
	private Professor nome;
    public int numero_alunos, numero_sala;

    public Turma() {
    }

    public String getCurso() {
        return curso;
    }

    public String getProfessor() {
        return Professor.getCargo();
    }

    public int getSala() {
        return Sala.numero_sala;
    }
    
    public int getNumero() {
        return numero_alunos;
    }
    
    
    private void setSala(int sala) {
    	Sala.numero_sala=sala;
    }
    
    protected void setCurso(String curso) {
    	Curso.nome_curso=curso;
     }
    
    protected void setNumero(int numero) {
    	this.nome=nome;
    }
    
    public void exibirTurmas() {
            System.out.println("Curso: " + getCurso());
            System.out.println("Professor: " + getProfessor());
            System.out.println("Sala: " + getSala());
            System.out.println("Número de pessoas: " + getNumero());
    }
}
