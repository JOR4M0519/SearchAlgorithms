package co.edu.unbosque.model;

import java.util.ArrayList;

/**
 * Clase en la que se ubican las demas clases reunidas haciendo la tarea de una clase fachada con funciones extendidas
 * como obtener la repeticion de patrones.
 * @author Laura Mateus, Jeanpierr Ramos y Kevin Garcia.
 *
 */
public class Contenido {

	private KMPAlgorithm kmp_Algorithm;
	private String tipoAlgoritmo;
	private String texto;
	private String patron;
	
	/**
	 * Representa el metodo constructor de la clase Contenido.
	 */
	public Contenido() {
		kmp_Algorithm = new KMPAlgorithm();
	}
	
	/**
	 * Se encarga de obtener las posiciones de los patrones que el usurio ingresa y que se repiten en el texto. 
	 * @param sensibleMay Requiere de la sensibilidad a mayusculas indicada por el usuario.
	 * @return El resultado de la busqueda de los patrones.
	 */
	public ArrayList<String> obtnerPosicionesPatrones(boolean sensibleMay){
		
		if(tipoAlgoritmo.equals("KMP")) {
			return kmp_Algorithm.busquedaPatrones(texto, patron, sensibleMay);	
		}
		
		return null;
		
	}
	
	/**
	 * Se encarga de obtener el tipo de algoritmo que se usara.
	 * @return Algoritmo BM o KMP.
	 */
	public String getTipoAlgoritmo() {
		return tipoAlgoritmo;
	}
	
	/**
	 * Se encarga de modificar el tipo de algoritmo que se usara.
	 * @param tipoAlgoritmo Algoritmo BM o KMP.
	 */
	public void setTipoAlgoritmo(String tipoAlgoritmo) {
		this.tipoAlgoritmo = tipoAlgoritmo;
	}
	
	/**
	 * Se encarga de obtener la clase KMP_Algorithm.
	 * @return Algoritmo Knuth-Morris-Pratt.
	 */
	public KMPAlgorithm getKmp_Algorithm() {
		return kmp_Algorithm;
	}
	
	/**
	 * Se encarga de modificar la clase KMP_Algorithm.
	 * @param kmp_Algorithm Algoritmo Knuth-Morris-Pratt.
	 */
	public void setKmp_Algorithm(KMPAlgorithm kmp_Algorithm) {
		this.kmp_Algorithm = kmp_Algorithm;
	}
	
	/**
	 * Se encarga de obtener el texto a resaltar.
	 * @return El texto.
	 */
	public String getTexto() {
		return texto;
	}
	
	/**
	 * Se encarga de modificar el texto a resaltar. 
	 * @param texto El texto a resaltar.
	 */
	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	/**
	 * Se encarga de obtener el patron del texto.
	 * @return Patron a encontrar en el texto.
	 */
	public String getPatron() {
		return patron;
	}
	
	/**
	 * Se encarga de modificar el patron del texto.
	 * @param patron patron a encontrar en el texto.
	 */
	public void setPatron(String patron) {
		this.patron = patron;
	}
	
}
