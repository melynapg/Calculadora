package ar.edu.calculadora.myCalculadora.controladores;

import java.text.DecimalFormat;

import ar.edu.calculadora.myCalculadora.modelo.Complejos;
import ar.edu.calculadora.myCalculadora.modelo.Fasores;

public class FasoresControlador {
	
	
	private Fasores calculosFasores = new Fasores();
	private Complejos calculosComplejo = new Complejos();
	
	
	public  Boolean validarFormato( String amp , String fasor , String fre)
	
	{	
		//String pattern = "-?\\d{1,2,3}(\\.\\d{1,2})?PI";
		//String patternDigito = "\\d{1,2}(\\.\\d{1,2})?";
	    Boolean a=  calculosFasores.validarDouble(amp);
	    Boolean b= calculosFasores.validarDouble(fasor);
	    Boolean c= calculosFasores.validarDouble(fre);
		
		
	if( a && b && c) {
		 
		 return true ;
		 		 
	 }else{
		 return false;}
		
	}
	
	public Boolean validarAmplitud (String amplitud) {
		
		String patternDigito = "\\d(\\.\\d)?";
		
		if (amplitud.matches(patternDigito)) {
			
			return true;
			
		}else {
			return false;
		}
		
	}
	
	
	
	
	

	
	
 public Boolean validarFrecuencia (String ffrec , String gfrec ) {
	 
 
	 if (ffrec.equals(gfrec)) {
		 
		 return true ;
		 
	 }else {
		 
		 return false;
	 }
	  
	 
 }
 
 
 public String suma(String famp , String ffrec , String ffase,String ffunc, String gamp , String gfrec , String gfase,String gfunc) {
	 
	 Fasores	fasorF  = new Fasores();
	 Fasores	fasorG  = new Fasores();
	 
	 fasorF.setAmplitud(Double.parseDouble(famp));
	 fasorF.setFrecuencia(Double.parseDouble(ffrec));
	 fasorF.setFase(Double.parseDouble(ffase));
	 fasorF.setFunc(ffunc);
	 
	fasorG.setAmplitud(Double.parseDouble(gamp));
	fasorG.setFrecuencia(Double.parseDouble(gfrec));
	fasorG.setFase(Double.parseDouble(gfase));
	fasorG.setFunc(gfunc);
	return sumaConFasores(fasorF, fasorG);
	
	 
 }
 
 public String sumaConFasores(Fasores fas1 , Fasores fas2 ) {
	 
	 
Fasores	fasor1  = new Fasores();
Fasores	fasor2  = new Fasores();
Fasores fasorResultado = new Fasores();

Complejos nroFasor1 = new Complejos();
Complejos nroFasor2 = new Complejos();
Complejos nroTotal = new Complejos();

if( !fas1.getFunc().equals(fas2.getFunc())){
fasor1 =calculosFasores.funcHomologar(fas1);
fasor2 = calculosFasores.funcHomologar(fas2);
}else {
	fasor1=fas1;
	fasor2=fas2;
	
}
nroFasor1=calculosFasores.pasarBinomico(fasor1);
nroFasor2=calculosFasores.pasarBinomico(fasor2);

nroTotal= calculosComplejo.sumaBinario(nroFasor1, nroFasor2);

fasorResultado = this.pasarAfasor(nroTotal, fas1.getFrecuencia(),fas1.getFunc());

DecimalFormat f = new DecimalFormat("####.###");


return  "F(x) + G(x)= " + f.format(fasorResultado.getAmplitud()) +" " +fasorResultado.getFunc() +" ( " + f.format(fasorResultado.getFrecuencia() )+" x + "+ f.format(fasorResultado.getFase()) +" )";	 
	 
 }
	
 public Fasores pasarAfasor (Complejos nro , double frecuencia , String func) {
	
	 Fasores fasor = new Fasores();
	 
	 fasor=calculosFasores.pasarFasor(nro);
	 fasor.setFrecuencia(frecuencia);
	 fasor.setFunc(func);
	 return fasor;
	 
}

 
}


