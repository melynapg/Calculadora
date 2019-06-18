package ar.edu.calculadora.myCalculadora.controladores;

public class FasoresControlador {
	

	
	
	
	
	public Boolean validarFormaFasor(String amplitud , String frecuencia , String fase)
	
	{
		
	 if(amplitud.matches("\\d") || fase.matches("\\d")) {
		 
		 return false ;
		 
		 
	 }
	 

		
		
		return true;
		
		
	}
	
	public Boolean validarFrecuencia (String s) {
		
		if(s.matches("\\d(.\\d)?PI\\]")) {
			
			return true;
		}else {
			return false;
		}
		
		
	}

}


