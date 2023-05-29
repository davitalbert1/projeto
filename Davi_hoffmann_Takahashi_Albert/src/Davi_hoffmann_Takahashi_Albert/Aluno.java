package Davi_hoffmann_Takahashi_Albert;

public class Aluno extends Pessoa {
	private  int matricula_aluno;
	private String curso_aluno;

	    public int getMatricula() {
	        return matricula_aluno;
	    }
	    
	    public void setMatricula(int matricula) {
	         matricula_aluno=matricula;
	    }
	    
	    public void setCurso(String curso) {
	         curso_aluno=curso;
	    }
	    
	    public String getCurso() {
	        return curso_aluno;
	    }
	    
		public void cadastrarCurso(String nomeCurso) {
			
		}
		
		public void cadastrarAluno(String curso) {
			curso_aluno=curso;
	        System.out.println("Aluno cadastrado com sucesso.");
		}
}
