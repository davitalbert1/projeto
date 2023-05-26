package Davi_hoffmann_Takahashi_Albert;
import java.util.Date;

public class sala extends disciplina{
	
	public int id_sala, numero_sala;
	public String bloco_sala, curso_sala, tipo_sala;
	
	public sala(int id_sala, int numero_sala, String bloco_sala, String curso, String tipo, String bloco, int id, int numero, int cursoID, int numero_pessoas, String nome, String curso_sala) {
		super(bloco, curso, tipo, id, numero, cursoID, numero_pessoas, nome);
		this.id_sala= id_sala;
		this.numero_sala= numero_sala;
		this.bloco_sala= bloco_sala;
		this.curso_sala= curso_sala;
		this.tipo= tipo;
	}
	
	public int getID() {
		return id_sala;
	}
	
	public int getnumero() {
		return numero_sala;
	}
	
	public String getbloco() {
		return bloco_sala;
	}
	
	public String getcurso() {
		return curso_sala;
	}
	
	public String gettipo() {
		return tipo_sala;
	}

}
