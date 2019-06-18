package ar.edu.calculadora.myCalculadora.controladores;



import ar.edu.calculadora.myCalculadora.modelo.Complejos;
import ar.edu.calculadora.myCalculadora.vista.OperacionesBasicas;


public class CalculosControlador {
	
	public OperacionesBasicas vistaOperacionesBasicas;
	public Complejos complejosOperaciones = new Complejos();
	

	
	
	public Complejos obtenerParteAB (String nro) {
		
		Complejos nroComplejo;
		
	 String [] cadenaParte1 = nro.split(",");
	 
	 String cadenaParte1A = cadenaParte1[0];
	 
	 String cadenaParte2B = cadenaParte1[1];
	 cadenaParte1A=cadenaParte1A.substring(1, cadenaParte1A.length());
	 
	 double pA = Double.parseDouble(cadenaParte1A);
	 
	 cadenaParte2B=cadenaParte2B.substring(0, cadenaParte2B.length()-1);
	 
	
	 int is = this.isBinomicaPolar(nro);
	 if (is==2){
		 
		
	    nroComplejo=this.ABPolar(pA, cadenaParte2B);
		 		 
	 }else {
		 
		 double pImg = Double.parseDouble(cadenaParte2B);
		 
		 nroComplejo = this.ABinomica(pA, pImg);
		
	 }
	 
	
	return nroComplejo;
	
		
	}
	
	public Complejos ABinomica(double pReal , double pImg ) {
		 Complejos nroComplejos = new Complejos(pReal, pImg);
		 
		 return nroComplejos;
		 	
	}
	
	public Complejos ABPolar(double pModulo , String pArgumento ) {
		 Complejos nroComplejo = new Complejos(pModulo,pArgumento);
		 
		 return nroComplejo;
		 	
	}
	
	public Boolean validacionFormatoPolar(String s) {
        String pattern = "\\[\\d(.\\d)?,\\d(.\\d)?PI\\]";
        String[] pattern2 = s.split(",");
        String parte = pattern2[1];
      Boolean b=  s.matches(pattern);
      
   
      
      if(b) {
    	  return true;
      }else if (parte =="PI") {
    	  return true;
		
	}else {
		return false;
	}   	  
			

    }
	
	public Boolean validacionFormatoBinomica(String s) {
		String pattern = "\\(\\d(.\\d)?,\\d(.\\d)?\\)";
		
		return s.matches(pattern);
		
			
	}
	
	public int isBinomicaPolar (String s) {
		//1= Binomica
		//2=Polar
		
		int es =0;
		
		if (validacionFormatoBinomica(s)) {
			
			es=1;
		}else if (validacionFormatoPolar(s)) {
			es =2;
		}
			
		
		
		return es;
				
		
	}
	

	public String sumar (Complejos nro1 , Complejos nro2 ) {
		
		String resultado = new String();
		
		Complejos resulSuma ;
		
		resulSuma =complejosOperaciones.sumaBinario(nro1, nro2);
		
		
		resultado = "(" + resulSuma.getpReal() + " , " + resulSuma.getpImaginaria() + ")"; 
		
		return resultado;
		
	}


	

	public String restar (Complejos nro1 , Complejos nro2 ) {
		
		String resultado = new String();
		
		Complejos resul ;
		
		resul =complejosOperaciones.restaBinario(nro1, nro2);
		
		
		resultado = "(" + resul.getpReal() + " , " + resul.getpImaginaria() + ")";
		
		return resultado;
		
	}
	
	

	public String multiplicar (Complejos nro1 , Complejos nro2 ) {
		
		String resultado = new String();
		
		Complejos resul ;
		
		resul =complejosOperaciones.multiplicarPolar(nro1, nro2);
		
		
		resultado = "(" + resul.getpReal() + " , " + resul.getpImaginaria() + ")";
		
		return resultado;
		
	}
	
	public String dividir (Complejos nro1 , Complejos nro2 ) {
		
		String resultado = new String();
		
		Complejos resul ;
		
		resul =complejosOperaciones.dividirPolar(nro1, nro2);
		
		
		resultado = "(" + resul.getpReal() + " , " + resul.getpImaginaria() + ")";
		
		return resultado;
		
	}
    
	public String transformarABinomica(String s ) {
		Complejos nroC = new Complejos();
		
		nroC =this.obtenerParteAB(s);
		
		nroC.aBinomica(nroC.modulo, nroC.argumento);
		
		return "(" + nroC.pReal +" , "+ nroC.pImaginaria+" )"; 
				
		
		
	}
	public String transformarAPolar(String s ) {
		Complejos nroC = new Complejos();
		
		nroC =this.obtenerParteAB(s);
		
		nroC.transformarAPolar(nroC.pReal, nroC.pImaginaria);
		
		return "[" + nroC.modulo +" , "+ nroC.argumento+"PI"+"]"; 
				
		
		
	}
	
    }
    

