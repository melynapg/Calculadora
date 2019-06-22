package ar.edu.calculadora.myCalculadora.controladores;



import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import ar.edu.calculadora.myCalculadora.modelo.Complejos;
import ar.edu.calculadora.myCalculadora.modelo.Raices;
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
        String pattern = "\\[\\d(\\.\\d{1,2})?,\\d(\\.\\d{1,2})?PI\\]";
        Boolean b=  s.matches(pattern);
        String[] pattern2 = s.split(",");
        String parte = pattern2[1];
 
      
   
      
      if(b) {
    	  return true;
      }else if (parte =="PI") {
    	  return true;
		
	}else {
		return false;
	}   	  
			

    }
	
	public Boolean validacionFormatoBinomica(String s) {
		String pattern = "\\(\\d(\\.\\d{1,2})?,\\d(\\.\\d{1,2})?\\)";
		
		
		Boolean b= s.matches(pattern);
		
		return b;
			
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
		
		DecimalFormat f = new DecimalFormat("####.##");
		resultado = "(" + f.format(resulSuma.getpReal()) + " , " + f.format(resulSuma.getpImaginaria() )+ ")"; 
		
		return resultado;
		
	}


	

	public String restar (Complejos nro1 , Complejos nro2 ) {
		
		String resultado = new String();
		
		Complejos resul ;
		
		resul =complejosOperaciones.restaBinario(nro1, nro2);
		
		DecimalFormat f = new DecimalFormat("####.###");
		resultado = "(" + f.format(resul.getpReal()) + " , " + f.format(resul.getpImaginaria() )+ ")";
		
		return resultado;
		
	}
	
	

	public String multiplicar (Complejos nro1 , Complejos nro2 ) {
		
		String resultado = new String();
		
		Complejos resul ;
		
		resul =complejosOperaciones.multiplicarPolar(nro1, nro2);
		DecimalFormat f = new DecimalFormat("####.###");
		
		resultado = "(" + f.format(resul.getpReal()) + " , " + f.format(resul.getpImaginaria()) + ")";
		
		return resultado;
		
	}
	
	public String dividir (Complejos nro1 , Complejos nro2 ) {
		
		String resultado = new String();
		
		Complejos resul ;
		
		resul =complejosOperaciones.dividirPolar(nro1, nro2);
		
		DecimalFormat f = new DecimalFormat("####.###");
		resultado = "(" + f.format(resul.getpReal()) + " , " + f.format(resul.getpImaginaria()) + ")";
		
		return resultado;
		
	}
    
	public String transformarABinomica(String s ) {
		Complejos nro = new Complejos();
		Complejos nroC = new Complejos();
		nro =this.obtenerParteAB(s);
		
		DecimalFormat f = new DecimalFormat("####.###");
		nroC = complejosOperaciones.aBinomica(nro.modulo, nro.argumento);
		
		return "(" + f.format(nroC.pReal) +" , "+ f.format(nroC.pImaginaria)+" )"; 
				
		
		
	}
	public String transformarAPolar(String s ) {
		Complejos nroC = new Complejos();
		
		nroC =this.obtenerParteAB(s);
		
		DecimalFormat f = new DecimalFormat("####.###");
		nroC=nroC.transformarAPolar(nroC.pReal, nroC.pImaginaria);
		
		return "[" + f.format(nroC.modulo) +" , "+ f.format(nroC.argumento)+"PI"+"]"; 
				
		
		
	}
	
	
	public Boolean validarIndice(String indice) {
		
	
		
		try {
			if (complejosOperaciones.isNumeric(indice)) {

				return true;
				
			}else {
				
				return false;
				
			}
		} catch (Exception e) {
			
			return false;
		}
		
	}
	
	public Boolean validarNroOperacionesAvanzadas(String nro){
		
	if (this.validacionFormatoBinomica(nro) || this.validacionFormatoPolar(nro)) {
		
		return true;
	}else {
		
		return false;
	} 	}
	
	
	
	public ArrayList<Raices> raicesradicacion(String indice , String nroC) {
		
		Complejos nro = new Complejos();
		 nro = this.obtenerParteAB(nroC);
		if (validacionFormatoBinomica(nroC)) {
		nro =complejosOperaciones.transformarAPolar(nro.getpReal(), nro.getpImaginaria());
	      
		}
		 
		int ind = Integer.parseInt(indice);
		
		ArrayList<Integer> listaIndice = (ArrayList<Integer>) complejosOperaciones.raicesPrimtivas(ind);

		ArrayList<Raices> raices = complejosOperaciones.radicacion(listaIndice, nro);
		
		
		return raices;
		
	}
	
	public String potencia(String indice , String nroS){
		
		Complejos nro = new Complejos();
		Complejos resultadoPotencia = new Complejos();
		
		 nro = this.obtenerParteAB(nroS);
		 
		 if (validacionFormatoBinomica(nroS)) {
			 
			 nro= complejosOperaciones.transformarAPolar(nro.getpReal(), nro.getpImaginaria());
			 
		 }
		 
		int ind = Integer.parseInt(indice);
		
		resultadoPotencia = complejosOperaciones.potenciaPolar(nro, ind);
		 DecimalFormat f = new DecimalFormat("####.###");
		
		return "[ "+ f.format(resultadoPotencia.getModulo())+ ","+ f.format(resultadoPotencia.getArgumento())+"PI]";
		
		
		 
		 
		
		
	}
	
	

	
	
    }
    

