package Davi_hoffmann_Takahashi_Albert;
import java.util.Scanner;



public class Main {
	static Scanner scanner = new Scanner(System.in);
	static Armazenamento banco = new Armazenamento();
	private static int pesquisar=0;
	
	private static void opcao() {
		int opcao = 0;

	    while (opcao != 6) {
	        System.out.println("Selecione uma opção:");
	        System.out.println("1 - Cadastrar aluno");
	        System.out.println("2 - Cadastrar sala");
	        System.out.println("3 - Cadastrar curso");
	        System.out.println("4 - Cadastrar professor");
	        System.out.println("5 - Cadastrar turma");
	        System.out.println("6 - Sair");
	        opcao = scanner.nextInt();

	        switch (opcao) {
	            case 1:
	            	Aluno aluno = new Aluno();
	            	aluno.cadastrar();
	                System.out.println("Aluno cadastrado.");
	                break;
	            case 2:
	            	Sala sala = new Sala();
	            	Sala.cadastrar();
	            	sala.inserir();
	                System.out.println("Sala cadastrada.");
	                break;
	            case 3:
	            	Curso curso = new Curso();
	            	curso.cadastrarCurso();
	            	curso.Inserir();
	                System.out.println("Curso cadastrado.");
	                break;
	            case 4:
	            	Professor professor = new Professor();
	            	professor.cadastrar();
	            	System.out.println("Professor cadastrado.");
	                break;
	            case 5:
	            	Turma turma = new Turma();
	            	turma.cadastrarTurma();
	            	turma.Inserir();
	                System.out.println("Turma cadastrada.");
	                break;
	                case 6:
	                main(null);
	                break;
	                default:
	                System.out.println("Opção inválida. Digite novamente.");
	                break;
	                }
	                }
	}
	
	private static void editar() {
		int opcao = 0;

	    while (opcao != 6) {
	        System.out.println("Selecione uma opção:");
	        System.out.println("1 - Editar aluno");
	        System.out.println("2 - Editar sala");
	        System.out.println("3 - Editar curso");
	        System.out.println("4 - Editar professor");
	        System.out.println("5 - Editar turma");
	        System.out.println("6 - Sair");
	        opcao = scanner.nextInt();

	        switch (opcao) {
	            case 1:
	            	Aluno aluno = new Aluno();
	            	aluno.editarAluno();
	                break;
	            case 2:
	            	Sala sala = new Sala();
	            	sala.editarSala();
	                break;
	            case 3:
	                Curso.editarCurso();
	                break;
	            case 4:
	            	Professor professor = new Professor();
	            	professor.editar();
	                break;
	            case 5:
	                Turma.editarTurma();
	                break;
	                case 6:
	                main(null);
	                break;
	                default:
	                System.out.println("Opção inválida. Digite novamente.");
	                break;
	                }
	                }}
	
	private static void apagar() {
		int opcao = 0;

	    while (opcao != 6) {
	        System.out.println("Selecione uma opção:");
	        System.out.println("1 - Apagar aluno");
	        System.out.println("2 - Apagar sala");
	        System.out.println("3 - Apagar curso");
	        System.out.println("4 - Apagar professor");
	        System.out.println("5 - Apagar turma");
	        System.out.println("6 - Sair");
	        opcao = scanner.nextInt();

	        switch (opcao) {
	            case 1:
	            	Aluno aluno = new Aluno();
	            	aluno.apagar();
	                break;
	            case 2:
	            	Sala sala = new Sala();
	            	sala.deletar();
	                break;
	            case 3:
	            	Curso curso = new Curso();
	            	curso.deletar();
	                break;
	            case 4:
	            	Professor professor = new Professor();
	            	professor.apagar();
	                break;
	            case 5:
	            	Turma turma = new Turma();
	            	turma.deletar();
	                break;
	                case 6:
	                main(null);
	                break;
	                default:
	                System.out.println("Opção inválida. Digite novamente.");
	                break;
	                }
	                }
	}
	
	private static void pesquisar() {
        System.out.println("Selecione uma opção:");
        System.out.println("1 - Ver todos");
        System.out.println("2 - Pesquisar");
        pesquisar = scanner.nextInt();
        if(pesquisar!=1 && pesquisar !=2) {
        	System.out.println("Opção inexistente, selecione outra opção.");
        	pesquisar();
        }
	}
	
	private static void ver() {
		int opcao = 0;

	    while (opcao != 6) {
	        System.out.println("Selecione uma opção:");
	        System.out.println("1 - Ver aluno");
	        System.out.println("2 - Ver sala");
	        System.out.println("3 - Ver curso");
	        System.out.println("4 - Ver professor");
	        System.out.println("5 - Ver turma");
	        System.out.println("6 - Sair");
	        opcao = scanner.nextInt();
	    
	    	pesquisar();

	        switch (opcao) {
	            case 1:
	            	if(pesquisar==1) {
	            		Aluno aluno = new Aluno();
	            		aluno.exibir();
	            	}else {
	            		Aluno aluno = new Aluno();
	            		aluno.pesquisar();
	            	}
	                break;
	            case 2:
	            	if(pesquisar==1) {
	            		Sala sala = new Sala();
	            		sala.exibir();
	            	}else {
	            		Sala sala = new Sala();
	            		sala.pesquisar();
	            	}
	                break;
	            case 3:
	            	if(pesquisar==1) {
	            		Curso curso = new Curso();
	            		curso.exibir();
	            	}else {
	            		Curso curso = new Curso();
	            		curso.pesquisar();
	            	}
	                break;
	            case 4:
	            	if(pesquisar==1) {
	            		Professor professor = new Professor();
	            		professor.exibir();
	            	}else {
	            		Professor professor = new Professor();
	            		professor.pesquisar();
	            	}
	                break;
	            case 5:
	            	if(pesquisar==1) {
	            		Turma turma = new Turma();
	            		turma.exibir();
	            	}else {
	            		Turma turma = new Turma();
	            		turma.pesquisar();
	            	}
	                break;
	                case 6:
	                main(null);
	                break;
	                default:
	                System.out.println("Opção inválida. Digite novamente.");
	                break;
	        }}
	                }
	
	private static void inicio() {
		int opcao=0;
		while(opcao != 5) {
		System.out.println("1 - cadastrar");
		System.out.println("2 - editar");
		System.out.println("3 - deletar");
		System.out.println("4 - ver");
		System.out.println("5 - sair");
		opcao = scanner.nextInt();
		
		switch(opcao) {
		case 1:
			opcao();
		break;
		case 2:
			editar();
		break;
		case 3:
			apagar();
		break;
		case 4:
			ver();
		break;
		case 5:
			main(null);
		break;
		default:
		System.out.println("1 - Opção inválida, digite outra opção.");
		break;
		}
		}
	    }
	


	public static void main(String[] args) {
		Armazenamento.conecta();
		inicio();
	}
}
