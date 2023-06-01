package Davi_hoffmann_Takahashi_Albert;

import java.util.Scanner;

public class Aluno extends Pessoa {
	private  int matricula_aluno;
	private static String curso_aluno;
	
	static Scanner scanner = new Scanner(System.in);

	    public int getMatricula() {
	        return matricula_aluno;
	    }
	    
	    private String getCurso() {
	        return curso_aluno;
	    }
		
		public static void cadastrarAluno() {
			Aluno.cadastrarPessoa();
			System.out.println("Digite o curso do aluno:");
			curso_aluno = scanner.next();
		}
}
