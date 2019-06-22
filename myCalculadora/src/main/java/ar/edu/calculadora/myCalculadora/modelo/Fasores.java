package ar.edu.calculadora.myCalculadora.modelo;

import ar.edu.calculadora.myCalculadora.controladores.CalculosControlador;

public class Fasores {

	private double amplitud ;
	private double fase;
	private double frecuencia;
	private String func;
	
	private Complejos calculoComplejos= new Complejos();
	


	public double getAmplitud() {
		return amplitud;
	}

	public void setAmplitud(double amplitud) {
		this.amplitud = amplitud;
	}

	public double getFase() {
		return fase;
	}

	public void setFase(double fase) {
		this.fase = fase;
	}

	public double getFrecuencia() {
		return frecuencia;
	}

	public void setFrecuencia(double frecuencia) {
		this.frecuencia = frecuencia;
	}

	public String getFunc() {
		return func;
	}

	public void setFunc(String func) {
		this.func = func;
	}

public Fasores(double amp , double fre ,double fase ,String func) {
		

		this.setAmplitud(amp);
		this.setFase(fase);
		this.setFrecuencia(fre);
		this.setFunc(func);
		
		
	}

public Fasores() {
	
}

public  Fasores funcHomologar (Fasores fas1) {

	if( fas1.func.equals("SEN") ) {
				
				double fase = getFase()+ (Math.PI/2);
				
				fas1.setFase( fase);
				fas1.setFunc("COS");
				
	}
	return fas1;
	}
		
		
public Complejos pasarBinomico(Fasores fasor) {
	
	 Complejos nro= new Complejos();
	 
	 double aux = fasor.getFase()*Math.PI;
	 
	 nro.pReal = fasor.getAmplitud()*(Math.cos(aux));
	 
	 nro.pImaginaria=fasor.getAmplitud()*(Math.sin(aux));
	 
	 
	 return nro;
	
		
		
		
}
public Fasores pasarFasor(Complejos nro) {
	
	Fasores fasor=new Fasores();
	
    double aux = nro.getpImaginaria()/nro.getpReal();
	
	double argumento =   (double) 
           (Math.atan(aux));
	
    double   modulo = (double) Math.sqrt((Math.pow(nro.getpReal(), 2) + 
            Math.pow(nro.getpImaginaria(), 2)));
	
	fasor.setAmplitud(modulo);
	fasor.setFase(argumento);
	
	
	return fasor;
	
	
}
	
	
public Boolean validarDouble(String s) {
	
	try {
		
	   Double.parseDouble(s);
		return true ;
	} catch(NumberFormatException ex){
       	 
        
            return false;
            
      }
   
	
	
	
}

	
}
