package co.edu.unbosque.model;

import java.util.ArrayList;

public class Contenido {

	private KMP_Algorithm kmp_Algorithm;
	private String tipoAlgoritmo;
	private String texto;
	private String patron;
	
	
	public Contenido() {
		kmp_Algorithm = new KMP_Algorithm();
	}
	
	public ArrayList<String> obtnerPosicionesPatrones(boolean sensibleMay){
		
		if(tipoAlgoritmo.equals("KMP")) {
			return kmp_Algorithm.busquedaPatrones(texto, patron, sensibleMay);	
		}
		
		return null;
		
	}
	
	public String getTipoAlgoritmo() {
		return tipoAlgoritmo;
	}
	public void setTipoAlgoritmo(String tipoAlgoritmo) {
		this.tipoAlgoritmo = tipoAlgoritmo;
	}
	public KMP_Algorithm getKmp_Algorithm() {
		return kmp_Algorithm;
	}
	public void setKmp_Algorithm(KMP_Algorithm kmp_Algorithm) {
		this.kmp_Algorithm = kmp_Algorithm;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public String getPatron() {
		return patron;
	}
	public void setPatron(String patron) {
		this.patron = patron;
	}
	
	
	
}
