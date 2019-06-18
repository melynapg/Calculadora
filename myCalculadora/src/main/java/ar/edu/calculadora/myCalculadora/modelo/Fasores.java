package ar.edu.calculadora.myCalculadora.modelo;

public class Fasores {

	private float amplitud ;
	private float fase;
	private float frecuencia;
	
	
	public float getAmplitud() {
		return amplitud;
	}


	public void setAmplitud(float amplitud) {
		this.amplitud = amplitud;
	}


	public float getFase() {
		return fase;
	}


	public void setFase(float fase) {
		this.fase = fase;
	}


	public float getFrecuencia() {
		return frecuencia;
	}


	public void setFrecuencia(float frecuencia) {
		this.frecuencia = frecuencia;
	}


	public Fasores(float amp , float fre ,float fase) {
		

		this.setAmplitud(amp);
		this.setFase(fase);
		this.setFrecuencia(fre);
		
		
	}

	
	
	
	
	
}
