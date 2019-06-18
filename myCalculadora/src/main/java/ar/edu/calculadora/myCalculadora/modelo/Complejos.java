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

    public void aBinomica(double modulo , double argumento){
    	
        this.pReal = (double) (modulo* Math.cos(argumento * Math.PI));
        this.pImaginaria = (double) (modulo* Math.sin(argumento * Math.PI));}
   

    public void transformarAPolar(double pReal , double pImg){
    	
    	//Obtengo el argumento
        double argumento =   (double) 
                (Math.atan2(this.pImaginaria, this.pReal));
        
      //  double argumentoRadianes =   (double) Math.toRadians(argumento);
        
    	
    
        
    if (argumento < 0 ) {
    	
    	this.argumento = (2* Math.PI) + argumento;
    	 
     }else  {
    	this.argumento = argumento;
    }
    
    argumento= ( argumento / Math.PI);
    
    double   modulo = (double) Math.sqrt((Math.pow(this.pReal, 2) + 
            Math.pow(this.pImaginaria, 2)));
    
    this.setModulo(modulo);
    this.setArgumento(argumento);
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
    	List<Integer> excluidos = new ArrayList<Integer>();
    	int resto;
    	int valor = 0;
    	boolean esRaiz = true;
    	
    	raices.add(1);	// 1 Siempre es raiz
    	for (int i=2; i<orden; i++) {
			esRaiz = true;
    		resto = orden % i;
    		if (resto != 0) {
    			if (excluidos.isEmpty()) {
    				for (int j=0; j<raices.size(); j++) {
    					valor = i%raices.get(j);
    					if (valor==0) { 
        					//valor = raices.get(j);
    						esRaiz = false;
    						break;
    					}
    				}
    				if (esRaiz) {
    					raices.add(i);
    					esRaiz = true;
    				}
    			} else {
     				for (int j=0; j<excluidos.size(); j++) {
    					valor = i%excluidos.get(j);
    					if (valor==0){
    						//valor = excluidos.get(j);
    						esRaiz = false;
    						break;
    					}
     				}
    				if (esRaiz) {
    					raices.add(i);
    					esRaiz = true;
    				}
    			}
    		} else {
    			excluidos.add(i);
    		}
    	}
    	return raices;
    }

    public void Radicacion(int orden, Complejos nroC){
    	double argumento=0;
    	
    	Complejos nr = new Complejos();
    	//this.transformarAPolar();
    	for (int i=1; i<=orden; i++){
    		argumento = (argumento + 2*i*(float)Math.PI)/i;
    		
    		 float numero = (orden/i);
    		
    		 


    		
    	}
    	// El modulo siempre es igual para todas raices
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

		int potencia = 1;
		double arg = 0;
		
		
		for(int j = 0; j<i ;j++) {
			potencia *= z1.modulo;
		}
		arg = (double) (z1.argumento*i);
		resultado.modulo = potencia;
		resultado.argumento = arg;
		
		return resultado;
    }

   
}
    
    

