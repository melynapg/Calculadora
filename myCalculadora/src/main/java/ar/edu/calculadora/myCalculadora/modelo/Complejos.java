package ar.edu.calculadora.myCalculadora.modelo;

//import java.util.function.DoubleSupplier;

public class Complejos {
    public float pReal;
    public float pImaginaria;
    public float modulo;
    public float argumento;

    public float getpReal() {
        return pReal;
    }

    public void setpReal(float pReal) {
        this.pReal = pReal;
    }

    public float getpImaginaria() {
        return pImaginaria;
    }

    public void setpImaginaria(float pImaginaria) {
        this.pImaginaria = pImaginaria;
    }

    public float getModulo() {
        return modulo;
    }

    public void setModulo(float modulo) {
        this.modulo = modulo;
    }

    public float getArgumento() {
        return argumento;
    }

    public void setArgumento(float argumento) {
        this.argumento = argumento;
    }
       

   public Complejos(float modulo, float argumento) {
        this.aBinomica(modulo , argumento);
    }
    
    public Complejos(double pReal, double pImaginaria) {
         this.transformarAPolar();
        
    }

    public void aBinomica(float modulo , float argumento){
        this.pReal = (float) (modulo* Math.cos(argumento));
        this.pImaginaria = (float) (modulo* Math.sin(argumento));}
   

    public void transformarAPolar(){
    	
    	float dosPhi = 360;
    	float dosphiRad = (float)Math.toRadians(dosPhi);
        this.modulo = (float) Math.sqrt((Math.pow(this.pReal, 2) + 
               Math.pow(this.pImaginaria, 2)));
      
         float argumentoGrado =   (float) 
           Math.toDegrees(Math.atan2(this.pImaginaria, this.pReal));
    		

         float argumentoRadianes =   (float) Math.toRadians(argumentoGrado);
         
    if (argumentoRadianes < 0 ) {
    	
    	this.argumento = dosphiRad + argumentoRadianes;
    	 
     }else  {
    	this.argumento = argumentoRadianes;
    }
}
    
    public Complejos sumaBinario(Complejos z1 , Complejos z2) {
    	
    	Complejos resultado = new Complejos(pReal, pImaginaria);
    	
    	resultado.pReal= z1.pReal + z2.pImaginaria;
    	resultado.pImaginaria = z1.pImaginaria +z2.pImaginaria; 
    	
    	
    	return resultado;
    	
    	
    }
    
    public Complejos multiplicarPolar (Complejos z1 , Complejos z2 ) {
    	
    	Complejos resultado = new Complejos(modulo,argumento);
    	
    	resultado.modulo = z1.modulo * z2.modulo;
    	resultado.argumento= z1.argumento +z2.argumento;
    	
    	return resultado;
    	
    	
    	
    }
    
    public Complejos dividirPolar (Complejos z1 , Complejos z2) {
    
    	Complejos resultado = new Complejos(modulo, argumento);
    	
    	resultado.modulo = z1.modulo/z2.modulo;
    	resultado.argumento = z1.argumento - z2.argumento;
    	
    	return resultado;
    }
    
    /*public Complejos potenciaPolar (Complejos z1 , int i) {
    	
    	Integer potencia = 1;
    	
    	for(int i = 0; i<i ;i++) {
    		potencia * = z1.modulo;
    	}
    	
    }
    
    public static Integer potencia(Integer a, Integer b){
    	Integer potencia = 1;
    	for(int i = 0; i<b;i++){
    	potencia *= a;
    	}
    	return potencia;
    	}*/
    
   
}
    
    

