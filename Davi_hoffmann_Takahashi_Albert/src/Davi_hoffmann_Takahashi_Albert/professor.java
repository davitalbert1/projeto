package Davi_hoffmann_Takahashi_Albert;
import java.util.Date;

public class professor extends pessoa{
	public double salario;
	public String disciplina;
	
	public professor(String nome, String cpf, Date data, double salario, String disciplina) {
		super(nome, cpf, data);
		this.salario = salario;
		this.disciplina = disciplina;
	}

}
