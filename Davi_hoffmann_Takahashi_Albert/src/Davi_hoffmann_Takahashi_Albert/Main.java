package Davi_hoffmann_Takahashi_Albert;
import java.util.Date;
import java.util.*;



public class Main {
	static Scanner scanner = new Scanner(System.in);
	static Armazenamento banco = new Armazenamento();
	
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
	                cadastrarAluno();
	                System.out.println("Aluno cadastrado.");
	                break;
	            case 2:
	                cadastrarSala();
	                System.out.println("Sala cadastrada.");
	                break;
	            case 3:
	                cadastrarCurso();
	                System.out.println("Curso cadastrado.");
	                break;
	            case 4:
	            	cadastrarProfessor();
	            	System.out.println("Professor cadastrado.");
	                break;
	            case 5:
	                cadastrarTurma();
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
	        opcao = scanner.nextInt();}

	        /*switch (opcao) {
	            case 1:
	                editarAluno();
	                System.out.println("Aluno editado.");
	                break;
	            case 2:
	                editarSala();
	                System.out.println("Sala editada.");
	                break;
	            case 3:
	                editarCurso();
	                System.out.println("Curso editado.");
	                break;
	            case 4:
	            	editarProfessor();
	            	System.out.println("Professor editado.");
	                break;
	            case 5:
	                editarTurma();
	                System.out.println("Turma editada.");
	                break;
	                case 6:
	                main(null);
	                break;
	                default:
	                System.out.println("Opção inválida. Digite novamente.");
	                break;
	                }
	                }*/
	}
	
	private static void apagar() {
		/*int opcao = 0;

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
	                apagarAluno();
	                System.out.println("Aluno apagado.");
	                break;
	            case 2:
	                apagarSala();
	                System.out.println("Sala apagada.");
	                break;
	            case 3:
	                apagarCurso();
	                System.out.println("Curso apagado.");
	                break;
	            case 4:
	            	apagarProfessor();
	            	System.out.println("Professor apagado.");
	                break;
	            case 5:
	                apagarTurma();
	                System.out.println("Turma apagada.");
	                break;
	                case 6:
	                main(null);
	                break;
	                default:
	                System.out.println("Opção inválida. Digite novamente.");
	                break;
	                }
	                }*/
	}
	
	private static void editarSala() {
		System.out.println("Digite o nome da sala:");
	    String nome = scanner.next();
		System.out.println("Digite a capacidade da sala:");
		int capacidade = scanner.nextInt();
		System.out.println("Digite o número da sala:");
		int numero = scanner.nextInt();
		System.out.println("Digite o bloco da sala:");
		String bloco = scanner.next();
		
		Sala salaAux = new Sala();
		salaAux.setNome(nome);
		salaAux.setCapacidade(capacidade);
		salaAux.setNumero(numero);
		salaAux.setBloco(bloco);
	}
	
	private static void cadastrarSala() {
		System.out.println("Digite o nome da sala:");
	    String nome = scanner.next();
		System.out.println("Digite a capacidade da sala:");
		int capacidade = scanner.nextInt();
		System.out.println("Digite o número da sala:");
		int numero = scanner.nextInt();
		System.out.println("Digite o bloco da sala:");
		String bloco = scanner.next();
		
		Sala salaAux = new Sala();
		salaAux.setNome(nome);
		salaAux.setCapacidade(capacidade);
		salaAux.setNumero(numero);
		salaAux.setBloco(bloco);
	}
	
	private static void cadastrarCurso() {
		System.out.println("Digite o nome do curso:");
	    String nome = scanner.next();
		System.out.println("Digite a capacidade do curso:");
		int capacidade = scanner.nextInt();
		System.out.println("Digite a descrição do curso:");
		String descricao = scanner.next();
		
		Curso cursoAux = new Curso();
		cursoAux.setNome(nome);
		cursoAux.setCapacidade(capacidade);
		cursoAux.setDescricao(descricao);
	}
	
	private static void cadastrarAluno() {
		System.out.println("Digite o nome do aluno:");
	    String nome = scanner.next();
		System.out.println("Digite o curso do aluno:");
	    String curso = scanner.next();
	    Aluno alunoAux = new Aluno();
	    alunoAux.setCurso(curso);
	    alunoAux.setNome(nome);
	}
	
	private static void cadastrarProfessor() {
		System.out.println("Digite o salario do professor:");
	    Float salario = scanner.nextFloat();
		System.out.println("Digite o professor encarregado:");
	    String cargo = scanner.next();
	    Professor alunoAux = new Professor();
	    alunoAux.setSalario(salario);
	    alunoAux.setCargo(cargo);
	}
	
	private static void cadastrarTurma() {
		System.out.println("Digite o curso da turma:");
	    String curso = scanner.next();
		System.out.println("Digite o núemro de alunos:");
	    int numero = scanner.nextInt();
		System.out.println("Digite o núemro da sala:");
	    int sala = scanner.nextInt();
	    System.out.println("Digite o núemro do bloco:");
	    int bloco = scanner.nextInt();
	    Turma alunoAux = new Turma();
	    alunoAux.setCurso(curso);
	    alunoAux.setNumero(numero);
	    alunoAux.setNumero(sala);
	    alunoAux.setNumero(bloco);
	}

	public static void main(String[] args) {
		
		int opcao=0;
		
		
		while(opcao != 6) {
		System.out.println("1 - cadastrar");
		System.out.println("2 - ver");
		System.out.println("3 - deletar");
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
		default:
		System.out.println("1 - Opção inválida, digite outra opção.");
		break;}
		}
	    }
}
