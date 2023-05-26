package Davi_hoffmann_Takahashi_Albert;

public class disciplina extends curso{
	
	public int id, cursoID, numero_pessoas;
	public String nome;

	public disciplina(String bloco, String curso, String tipo, int id, int numero, int cursoID, int numero_pessoas, String nome) {
		super(bloco, curso, tipo, id, numero);
		this.id = id;
		this.cursoID = cursoID;
		this.numero_pessoas = numero_pessoas;
		this.nome = nome;
	}

	public int getID() {
		return id;
	}
	
	public int getcursoID() {
		return cursoID;
	}
	
	public int numero_pessoas() {
		return numero_pessoas;
	}
	
	public String nome() {
		return nome;
	}

}
