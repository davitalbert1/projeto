package Davi_hoffmann_Takahashi_Albert;

import java.util.Date;

public class Sala {
	
	public static String nome_sala, bloco_sala;
    public static int capacidade_sala, numero_sala;

    public Sala() {
    }

    public String getNome() {
        return nome_sala;
    }

    public int getCapacidade() {
        return capacidade_sala;
    }
    
    public void setNome(String nome) {
        nome_sala=nome;
   }
    
    public void setCapacidade(int capacidade) {
         capacidade_sala=capacidade;
    }
    
    public void setNumero(int numero) {
        numero_sala=numero;
   }
    
    public void setBloco(String bloco) {
        bloco_sala=bloco;
   }
    
    public static void cadastrarSala(String nome, int capacidade) {
        nome_sala=nome;
        capacidade_sala=capacidade;
        System.out.println("Sala cadastrada com sucesso.");
    }
}