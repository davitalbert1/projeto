package Davi_hoffmann_Takahashi_Albert;
import java.util.Date;

public class Pessoa {

	protected static int x=0;
	protected static int y=0;
	public int id;
	public static String nome;
	public String cpf;
	public Date data_nascimento;
	
	public Pessoa() {
		x+=1;
		y+=1;
	}

	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		Pessoa.nome = nome;
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
