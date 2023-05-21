package Davi_hoffmann_Takahashi_Albert;

import java.util.Date;

public class professor extends pessoa{
	public float salario;
	public String disciplina;
	public Date data_contratado;
	public int id, pessoaID, disciplinaID;
	public boolean demitido;
	
	public professor() {}
	
	public professor(String nome, String cpf, Date data_nascimento, float salario, String disciplina) {
		super(nome, cpf, data_nascimento);
		this.salario = salario;
		this.disciplina = disciplina;
	}
	
	
	public float getSalario() {
		return salario;
	}
	public void setSalario(float salario) {
		this.salario = salario;
	}
	public String getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}
	
	
}
