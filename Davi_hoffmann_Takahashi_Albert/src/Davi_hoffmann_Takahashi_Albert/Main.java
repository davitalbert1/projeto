package Davi_hoffmann_Takahashi_Albert;
import java.util.Date;
import java.util.*;



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
	            	aluno.inserir();
	                System.out.println("Aluno cadastrado.");
	                break;
	            case 2:
	                Sala.cadastrar();
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
	            	professor.inserir();
	            	Professor.cadastrarProfessor();
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
	
	private static void pesquisar() {
        System.out.println("Selecione uma opção:");
        System.out.println("1 - Ver todos");
        System.out.println("2 - Pesquisar");
        pesquisar = scanner.nextInt();
        if(pesquisar!=1 && pesquisar !=2) {
        	System.out.println("Opção inexistente, selecione outra opção");
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
	            		Aluno.exibir();
	            	}else {
	            		
	            	}
	                break;
	            case 2:
	            	if(pesquisar==1) {
	            		Sala.exibir();
	            	}else {
	            		
	            	}
	                break;
	            case 3:
	            	if(pesquisar==1) {
	            		Curso.exibir();
	            	}else {
	            		
	            	}
	                break;
	            case 4:
	            	if(pesquisar==1) {
	            		Professor.exibir();
	            	}else {
	            		
	            	}
	                break;
	            case 5:
	            	if(pesquisar==1) {
	            		Turma.exibir();
	            	}else {
	            		
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

	public static void main(String[] args) {
		
		int opcao=0;
		
		Armazenamento.conecta();
		while(opcao != 6) {
		System.out.println("1 - cadastrar");
		System.out.println("2 - editar");
		System.out.println("3 - deletar");
		System.out.println("4 - ver");
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
		default:
		System.out.println("1 - Opção inválida, digite outra opção.");
		break;}
		}
	    }
}
