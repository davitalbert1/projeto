package Davi_hoffmann_Takahashi_Albert;
import java.util.Date;
import java.util.Scanner;

public class pessoa {

	public int id, ano, mes, dia;
	public String nome, cpf;
	public Date data_nascimento;
	Scanner myObj = new Scanner(System.in);
	
	public pessoa() {}

	public pessoa(String nome, String cpf, Date data_nascimento, int id, int ano, int mes, int dia){
		this.id= id;
		this.nome = nome;
		this.cpf  = cpf;
		this.data_nascimento = data_nascimento;
		this.ano = ano;
		this.mes = mes;
		this.dia = dia;
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
	
	public void SetPessoa() {
		System.out.println("Nome: ");
		this.nome = myObj.nextLine();
		
		System.out.println("CPF: ");
		this.cpf = myObj.nextLine();
		
		System.out.println("Ano de nascimento: ");
		this.ano = myObj.nextInt();
		
		System.out.println("Mês de nascimento: ");
		this.mes = myObj.nextInt();
		
		System.out.println("Dia de nascimento: ");
		this.dia = myObj.nextInt();
	}
	
	public void AlterNome() {
		System.out.println("Nome: ");
		this.nome = myObj.nextLine();
	}
	
	public void AlterCPF() {
		System.out.println("CPF: ");
		this.cpf = myObj.nextLine();
	}
	
	public void AlterAno() {
		System.out.println("Ano: ");
		this.ano = myObj.nextInt();
	}
	
	public void AlterMes() {
		System.out.println("Mês: ");
		this.mes = myObj.nextInt();
	}
	
	public void AlterDia() {
		System.out.println("Dia: ");
		this.dia = myObj.nextInt();
	}

}
