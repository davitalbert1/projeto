package Davi_hoffmann_Takahashi_Albert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Curso {
    protected static String nome_curso;
	private String descricao_curso;
    private int capacidade_curso;

    public Curso() {
    }

    public String getNome() {
        return nome_curso;
    }

    public int getCapacidade() {
    	
        return capacidade_curso;
    }
        
    public void setNome(String nome) {
    	nome_curso=nome;
    }
    
    public void setCapacidade(int capacidade) {
    	capacidade_curso=capacidade;
    }
    
    public void setDescricao(String descricao) {
    	descricao_curso=descricao;
    }
}
