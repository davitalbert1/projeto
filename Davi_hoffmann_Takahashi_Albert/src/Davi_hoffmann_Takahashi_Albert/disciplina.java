package Davi_hoffmann_Takahashi_Albert;

public class disciplina extends sala{
	
	public int id, cursoID, salaID, numero_pessoas;
	public String nome;

	public disciplina(String bloco, String curso, String tipo, int id, int numero) {
		super(bloco, curso, tipo, id, numero);
		this.id = id;
		this.cursoID = cursoID;
		this.salaID = salaID;
		this.numero_pessoas = numero_pessoas;
		this.nome = nome;
	}
	
	public int getID() {
		return id;
	}
	
	public int getcursoID() {
		return cursoID;
	}
	
	public int salaID() {
		return salaID;
	}
	
	public int numero_pessoas() {
		return numero_pessoas;
	}
	
	public String nome() {
		return nome;
	}

}
