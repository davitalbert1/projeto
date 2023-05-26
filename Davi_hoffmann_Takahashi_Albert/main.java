package Davi_hoffmann_Takahashi_Albert;

import java.util.Date;
import javax.swing.*;
import java.awt.Container;
import java.awt.FlowLayout;
import java.util.*;

public class main {

	public static void main(String[] args) {
		Scanner myObj = new Scanner(System.in);
		pessoa pessoa = new pessoa();
		FlowLayout flow = new FlowLayout();
		
		JFrame janela = new JFrame("Teste grafico.");
		janela.setBounds(50, 100, 400, 150);
		janela.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		janela.setVisible(true);
		
		Container caixa = janela.getContentPane();
		caixa.setLayout(flow);
		caixa.add(new JButton("OK"));
		
		
		pessoa.setData_nascimento(new Date());

		pessoa pessoa1 = new pessoa("Petri", "1111111111", new Date(), 0, 1, 1, 1);
		pessoa pessoa2 = new pessoa("Petri", "1111111111");
		
		System.out.println("Nome: "+pessoa.getNome());
		System.out.println("Cpf: "+pessoa.getCpf());
		System.out.println("Data: "+pessoa.getData_nascimento());
		System.out.println("------------------------");
		System.out.println("Nome: "+pessoa1.getNome());
		System.out.println("Cpf: "+pessoa1.getCpf());
		System.out.println("Data: "+pessoa1.getData_nascimento());
		
		
		professor prof = new professor();
		prof.setNome("Joao");
		prof.setCpf("2222222222");
		prof.setData_nascimento(new Date());
		prof.setSalario(50000);
		prof.setDisciplina("Informatica");
	}

}
