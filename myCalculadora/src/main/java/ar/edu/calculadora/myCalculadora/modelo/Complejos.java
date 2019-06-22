package ar.edu.calculadora.myCalculadora.modelo;

import java.util.ArrayList;
import java.util.List;

//import java.util.function.DoubleSupplier;

public class Complejos {
    public double pReal;
    public double pImaginaria;
    public double modulo;
    public double argumento;
	public List<Float> radicacionRaices = new ArrayList<Float>();
    public float radicacionModulo;
    
    public List<Complejos> raices = new ArrayList<Complejos>();
	private int numero;


   public double getpReal() {
		return pReal;
	}



	public void setpReal(double pReal) {
		this.pReal = pReal;
	}



	public double getpImaginaria() {
		return pImaginaria;
	}



	public void setpImaginaria(double pImaginaria) {
		this.pImaginaria = pImaginaria;
	}



	public double getModulo() {
		return modulo;
	}



	public void setModulo(double modulo) {
		this.modulo = modulo;
	}



	public double getArgumento() {
		return argumento;
	}



	public void setArgumento(double argumento) {
		this.argumento = argumento;
	}



public Complejos( double modulo, String argumento) {
	   this.setModulo(modulo);

	   double argPart1= 0;
	   String[] arg = argumento.split("PI");
	 
	   
	   if (arg.length>=1) {
		   String  parteSinPi  = arg[0];
		   argPart1   = Double.parseDouble(parteSinPi);
		  // argPart1 =  (argPart1* 180);
	   }else if (arg.length==0) {
		   
		if(argumento=="0") {
			argPart1= 0;
			
		}else {
			argPart1=1;
			
		}
	}
	   
	  
	
	   this.setArgumento(argPart1);
	    
	   
       
    }
    
 public Complejos() {
	 
 };
   
    public Complejos(double pReal, double pImaginaria) {
         this.setpReal(pReal);
         this.setpImaginaria(pImaginaria);
         
        
    }

    public Complejos aBinomica(double modulo , double argumento){
    	
    	Complejos nroC = new Complejos();
         double pReal = (double) (modulo* Math.cos(argumento * Math.PI));
         double pImaginaria = (double) (modulo* Math.sin(argumento * Math.PI));
       nroC.setModulo(modulo);
       nroC.setArgumento(argumento);
       nroC.setpImaginaria(pImaginaria);
       nroC.setpReal(pReal);
       
       return nroC;
    
    }
   

    public Complejos transformarAPolar(double pReal , double pImg){
    	
         Complejos nroC = new Complejos();
         nroC.setpReal(pReal);
         nroC.setpImaginaria(pImg);
         
         double aux = pImg/pReal;
    	
    	double argumento =   (double) 
                (Math.atan(aux));
    
     

    if (argumento < 0 ) {
    	
    	this.argumento = (2* Math.PI) + argumento;
    	 
     }else  {
    	this.argumento = argumento;
    }
    
	argumento= ( argumento / Math.PI);
    
    double   modulo = (double) Math.sqrt((Math.pow(pReal, 2) + 
            Math.pow(pImg, 2)));
    
    nroC.setModulo(modulo);
    nroC.setArgumento(argumento);
    
    return nroC;
}

 public Complejos sumaBinario(Complejos z1 , Complejos z2) {
    	
    	
    	
    	Complejos resultado = new Complejos(pReal, pImaginaria);
    	
    	resultado.pReal= (z1.pReal+ z2.pReal) ;
    	resultado.pImaginaria = (z1.pImaginaria +z2.pImaginaria); 
    	
    	
    	return resultado;
    	
    	
    }
    
    public Complejos restaBinario(Complejos z1 , Complejos z2) {
    	
    	Complejos resultado = new Complejos(pReal, pImaginaria);
    	
    	resultado.pReal= z1.pReal - z2.pImaginaria;
    	resultado.pImaginaria = z1.pImaginaria - z2.pImaginaria; 
    	
    	
    	return resultado;
    	
    	
    }
    
    @Override
	public String toString() {
		return "Complejos [pReal=" + pReal + ", pImaginaria=" + pImaginaria + ", modulo=" + modulo + ", argumento="
				+ argumento + "]";
	}



	public Complejos multiplicarPolar (Complejos z1 , Complejos z2 ) {
    	
    	Complejos resultado = new Complejos(modulo , argumento);
    	
    	resultado.setModulo( z1.modulo * z2.modulo);
    	resultado.setArgumento(z1.argumento +z2.argumento);
    	
     resultado.aBinomica(resultado.modulo, resultado.argumento);
    	return resultado;
    	
    	
    }
    
    public Complejos dividirPolar (Complejos z1 , Complejos z2) {
    
    	Complejos resultado = new Complejos(modulo, argumento);
    	
    	resultado.modulo = z1.modulo/z2.modulo;
    	resultado.argumento = z1.argumento - z2.argumento;
    	
    	resultado.aBinomica(resultado.modulo, resultado.argumento);
    	
     	return resultado;
    }
    
    public List<Integer> raicesPrimtivas (int orden){

    	List<Integer> raices = new ArrayList<Integer>();
    	int indice = orden-1;
    	int resto = 0;
    	

    	for (int i=1; i<= indice; i++) {
		
    		resto = orden % i;
    		if (resto == 0) {
    		
    			raices.add(i);
    			 }
    		
    	}
    	return raices;
    }

    public  ArrayList<Raices> radicacion( List<Integer> ordenes, Complejos nroC){
    	
    	 ArrayList<Raices>  listaRaices = new ArrayList<Raices> () ;
    	 
    
        		 
    	 
    	 for(int orden : ordenes) {
    		 
    		 Raices raices = new Raices();
    	    		 
    		 double arg= (2 * (orden-1) * Math.PI) / orden;
    		 
    		 raices.setIndice(orden);
    		 raices.setModulo(nroC.modulo);
    		 raices.setArgumento(nroC.argumento + arg);
    		  
    		 listaRaices.add(raices);
    	 }
    	 
    	 
    	 return listaRaices;
    	 

    }	

    
    public boolean isNumeric(String num) throws Exception{
        
         try{
        	 numero=Integer.parseInt(num.trim());  
               
               
               return true;
         }
         
         catch(NumberFormatException ex){
        	 
         }
             return false;
             
       }
    
    
    public Complejos potenciaPolar (Complejos z1 , int i) {

    	Complejos resultado = new Complejos(modulo, argumento);
    	double mod = z1.modulo;
		
		for(int j = 2; j<= i ;j++) {
			double aux ;
		
			aux = z1.modulo*mod ;
			z1.modulo= aux;
			
		
		}
	
    resultado.setModulo(z1.modulo);
    resultado.setArgumento(i*z1.argumento);

		
		return resultado;
    }

   
}
    
    

