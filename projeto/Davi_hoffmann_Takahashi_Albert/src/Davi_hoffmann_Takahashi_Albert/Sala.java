package Davi_hoffmann_Takahashi_Albert;

import java.util.Date;
import java.util.Scanner;

public class Sala {
	
	public static String nome_sala, bloco_sala;
    public static int capacidade_sala, numero_sala;
    
    static Scanner scanner = new Scanner(System.in);

    public Sala() {
    }

    public String getNome() {
        return nome_sala;
    }

    public int getCapacidade() {
        return capacidade_sala;
    }
    
    public static void setNome(String nome) {
        nome_sala=nome;
   }
    
    public static void setCapacidade(int capacidade) {
         capacidade_sala=capacidade;
    }
    
    public static void setNumero(int numero) {
        numero_sala=numero;
   }
    
    public static void setBloco(String bloco) {
        bloco_sala=bloco;
   }
    
	public static void cadastrarSala() {
		System.out.println("Digite o nome da sala:");
	    String nome = scanner.next();
		System.out.println("Digite a capacidade da sala:");
		int capacidade = scanner.nextInt();
		System.out.println("Digite o número da sala:");
		int numero = scanner.nextInt();
		System.out.println("Digite o bloco da sala:");
		String bloco = scanner.next();
		
		setNome(nome);
		setCapacidade(capacidade);
		setNumero(numero);
		setBloco(bloco);
	}
}