package Davi_hoffmann_Takahashi_Albert;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Professor extends Pessoa{
		private static String cargo_professor;
		private static float salario_professor;

	    public Professor() {}
	    
	    public static void setSalario(float salario) {
	    	salario_professor=salario;
	    }
	    
	    public static void setCargo(String cargo) {
	    	cargo_professor=cargo;
	    }
	    
		public static void cadastrarProfessor() {
			System.out.println("Digite o salario do professor:");
		    Float salario = scanner.nextFloat();
			System.out.println("Digite o curso do professor:");
		    String cargo = scanner.next();
		    setSalario(salario);
		    setCargo(cargo);
		}

		public static String getCargo() {
			return cargo_professor;
		}
}
