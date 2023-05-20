package Davi_hoffmann_Takahashi_Albert;
import java.util.Date;

public class main {

	public main(String[] args) {
		pessoa pessoa = new pessoa(null);
		pessoa.setNome("Marcelo");
		pessoa.setCpf("00000000000");
		pessoa.setData_nascimento(new Date());

		pessoa pessoa1 = new pessoa("Petri", "1111111111", new Date());
		pessoa pessoa2 = new pessoa("Petri", "1111111111");
		
		System.out.println("Nome: "+pessoa.getNome());
		System.out.println("Cpf: "+pessoa.getCpf());
		System.out.println("Data: "+pessoa.getData_nascimento());
		System.out.println("------------------------");
		System.out.println("Nome: "+pessoa1.getNome());
		System.out.println("Cpf: "+pessoa1.getCpf());
		System.out.println("Data: "+pessoa1.getData_nascimento());
		
		
		professor prof = new professor(null, null, null, 0, null);
		prof.setNome("Joao");
		prof.setCpf("2222222222");
		prof.setData_nascimento(new Date());
		prof.setSalario(50000);
		prof.setDisciplina("Informatica");
	}

}
