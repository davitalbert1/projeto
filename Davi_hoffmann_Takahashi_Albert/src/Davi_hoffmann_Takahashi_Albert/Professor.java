package Davi_hoffmann_Takahashi_Albert;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Professor extends Pessoa{
		private String cargo;
		private float salario;

	    public Professor() {}
	    
	    public void setSalario(float salario) {
	    	this.salario=salario;
	    }
	    
	    public void setCargo(String cargo) {
	    	this.cargo=cargo;
	    }
}
