package Davi_hoffmann_Takahashi_Albert;

import java.util.Date;

public class sala {
	
	public int id, numero;
	public String bloco, curso, tipo;

	public sala(int numero, String bloco, String curso, String tipo, int id) {
		this.id= id;
		this.numero= numero;
		this.bloco = bloco;
		this.curso  = curso;
		this.tipo = tipo;
	}
	
	public int getID() {
		return id;
	}
	
	public int getnumero() {
		return numero;
	}
	
	public String getbloco() {
		return bloco;
	}
	
	public String getcurso() {
		return curso;
	}
	
	public String gettipo() {
		return tipo;
	}

}
