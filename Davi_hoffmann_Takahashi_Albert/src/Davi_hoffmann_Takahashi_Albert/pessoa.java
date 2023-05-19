package Davi_hoffmann_Takahashi_Albert;
import java.util.Date;

public class pessoa {

	int id;
	String nome;
	String cpf;
	Date data_nascimento;

	public pessoa(String n, String c, Date d){
		this.id=id;
		this.nome = n;
		this.cpf  = c;
		this.data_nascimento = d;
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
