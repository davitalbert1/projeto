package Davi_hoffmann_Takahashi_Albert;
import java.util.Date;
import java.util.Scanner;

public class Pessoa {
	
	public Date data_nascimento;
	private static String nome_pessoa;
	private static String sobrenome_pessoa;
	private static String celular_pessoa;
	private static String endereco_pessoa;
	private static String email_pessoa;
	private static String cpf_pessoa;
	private boolean is_professor_pessoa, is_aluno_pessoa;
	
	static Scanner scanner = new Scanner(System.in);

	
	public static String getNome() {
		return nome_pessoa;
	}
	
	public static void setNome(String nome) {
		nome_pessoa = nome;
	}
	
	public static void setSobrenome(String sobrenome) {
		sobrenome_pessoa = sobrenome;
	}
	
	public static void setCpf(String cpf) {
	    cpf_pessoa = cpf;
	}
	
	public static void setEmail(String email) {
	    email_pessoa = email;
	}
	
	public static void setCelular(String celular) {
	    celular_pessoa = celular;
	}
	
	public static void setEndereco(String endereco) {
		endereco_pessoa = endereco;
	}
	
	public void setIs_professor(boolean is_professor) {
	    is_professor_pessoa = is_professor;
	}
	
	public void setIs_aluno(boolean is_aluno) {
	    is_aluno_pessoa = is_aluno;
	}
	
	public String getCpf() {
		return cpf_pessoa;
	}
	
	public void setData_nascimento(Date data_nascimento) {
		this.data_nascimento = data_nascimento;
	}
	
	public static void cadastrarPessoa() {
		System.out.println("Digite o nome da pessoa:");
	    String nome = scanner.next();
		System.out.println("Digite o sobrenome da pessoa:");
	    String sobrenome = scanner.next();
		System.out.println("Digite o cpf da pessoa:");
	    String cpf = scanner.next();
		System.out.println("Digite o email da pessoa:");
	    String email = scanner.next();
		System.out.println("Digite o celular da pessoa:");
	    String celular = scanner.next();
		System.out.println("Digite o endereco da pessoa:");
	    String endereco = scanner.next();
	    
	    setNome(nome);
	    setSobrenome(sobrenome);
	    setCpf(cpf);
	    setEmail(email);
	    setCelular(celular);
	    setEndereco(endereco);
	}

}
