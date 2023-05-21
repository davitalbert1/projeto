package Davi_hoffmann_Takahashi_Albert;
import java.util.Date;

public class pessoa {

	public int id;
	public String nome, cpf;
	public Date data_nascimento;
	
	public pessoa() {}

	public pessoa(String nome, String cpf, Date data_nascimento, int id){
		this.id= id;
		this.nome = nome;
		this.cpf  = cpf;
		this.data_nascimento = data_nascimento;
	}

	public pessoa(String n, String c){
		this.nome = n;
		this.cpf  = c;
	}
	
	public pessoa(String n){
		this.nome = n;
	}

	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
	    this.cpf = cpf;
	}
	
	public Date getData_nascimento() {
		return data_nascimento;
	}
	
	public void setData_nascimento(Date data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

}
