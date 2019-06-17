package ar.edu.calculadora.myCalculadora.controladores;

import java.text.DecimalFormat;

import javax.swing.JTextField;

import ar.edu.calculadora.myCalculadora.modelo.Complejos;
import ar.edu.calculadora.myCalculadora.vista.Pantalla;

public class CalculosControlador {
	
	public Pantalla  vista;
	


    
    
	public Complejos setBinomicaValues  (String pReal,
            String pImg) {
		Complejos z = new Complejos(0, 0);
		try {
		
        z.setpReal((Float) Float.parseFloat(pReal));
        z.setpImaginaria((Float) Float.parseFloat(pImg));
       
		}catch (Exception e) {
			System.out.print(e + " datos parte real :  "+ pReal +" imaginario: "+  pImg);
		}
		 return z;
    }
    
	
	public Complejos setPolarValues  (String modulo,
            String argumento)  {
		
		Complejos z = new Complejos(0, 0);
        z.setModulo((Float) Float.parseFloat(modulo));
        z.setArgumento((Float) Float.parseFloat(argumento));
        return z;
        
        
    }
    
    public void imprime(Complejos z) {
 //       this.imprimeFasorial(z, this.vista.resFas);
        this.imprimeBinomica(z, this.vista.resultadoBinomica);
    }

    public void imprimeDeBinomicaPolar(Complejos z, JTextField fas) {
        z.transformarAPolar();
        DecimalFormat df = new DecimalFormat("#,###.##");
        fas.setText("[" 
                + df.format(z.modulo)
                + " , " + df.format(z.argumento) + " ]");
    }

    public void imprimeBinomica(Complejos z, JTextField bin) {

        DecimalFormat df = new DecimalFormat("#,###.##");
        bin.setText("" + df.format(z.pReal)
                + " + j(" + df.format(z.pImaginaria) + ")");
    }
    
    
    public void imprimeBinomicaDesdePolar (Complejos z, JTextField bin) {
    	z.aBinomica(z.modulo, z.argumento);
    	
    	  DecimalFormat df = new DecimalFormat("#,###.##");
          bin.setText("" + df.format(z.pReal)
                  + " + j(" + df.format(z.pImaginaria) + ")");
    	
    }
    
    public Boolean validarBtnTransformar(String pReal , String pImg) {
    	
    	Boolean valido = true; 
    	
    	if ( pReal.isEmpty() || pImg.isEmpty() || pReal == "" || pImg=="" ) {
    		
                   valido = false;
    		
    	}
			
			   	
    	    	
    	return valido; 
    	
    	
    	    }
    
    public Boolean validaFormatoBinomio( String pReal , String pImg) {
    	
    Boolean	valido = true;
    	
    
      if(pReal.equals(",") || pImg.equals(",")) {
    	return valido=false  ;
      }
      
      return valido;
      }
    
    }
    

