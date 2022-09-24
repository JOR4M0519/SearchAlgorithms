package co.edu.unbosque.model;

import java.util.ArrayList;
import java.util.Stack;

public class KMP_Algorithm {

	public static void main(String[] args) {
		System.out.println("Tamaño: "+busquedaPatrones(
				"Gmail works great with desktop clients like Microsoft Outlook, "
				+ "Apple Mail and Mozilla Thunderbird, including contact and event "
				+ "sync.", "a", false).toString());
	}

	
	
	//Recibe la cadena de caracteres del patron
	//devuelve la lista con el valor respectivo de cada leetra del patron
	public static ArrayList<Integer> tablaPatron(String patron2){
		ArrayList<Integer> tabla = new ArrayList<Integer>();
		String patron = patron2;
		
		for (int i = 0; i < patron.length(); i++) {
			if(i==0) tabla.add(0);
			else {
				int posicion = tabla.get(i-1);
				if(patron.charAt(posicion)== patron.charAt(i)) 
					posicion++;
				else 
					posicion=0;
				
				tabla.add(posicion);
			}
		}
		
		return tabla;
	}
	
	//Recibe la cadena de caracteres del patron
		//devuelve la lista con el valor respectivo de cada leetra del patron
		public static int[] tablaPatron2(String patron2){
			int[] tabla = new int[patron2.length()];
			
			//ArrayList<Integer> tabla = new ArrayList<Integer>();
			String patron = patron2;
			
			for (int i = 0; i < patron.length(); i++) {
				if(i==0) tabla[0] = 0;
				else {
					int posicion = tabla[i-1];
					if(patron.charAt(posicion)== patron.charAt(i)) 
						posicion++;
					else 
						posicion=0;
					
					tabla[i] = posicion;
				}
			}
			
			return tabla;
		}
	
	/**
	 * coincidirMayusMinus = si es igual a true debe coincidir las minusculas y mayusculas
	 * 
	*/
	public static ArrayList<String> busquedaPatrones(String texto2, String patron2,boolean coincidirMayusMinus){
		
		String patron = patron2;
		String texto = texto2;
		
		Stack original = new Stack<>();
		int movimientos;
		
		//Si es false no se tiene sensibilidad de mayus-minus
		if(!coincidirMayusMinus) {
			patron = patron.toLowerCase();
			texto = texto.toLowerCase();
		}
		
		//Tabla error Patron
		ArrayList<Integer> arrayLPatron = tablaPatron(patron);
		//Tabla pares coincidencias
		ArrayList<String> arrayPares = new ArrayList<>();
		
		//Carga los valores del alfabeto del patron
		for(int i=patron.length()-1;i>=0;i--) {
			original.push(patron.charAt(i));
		}

		//Se crea una copia para alterar
		Stack copy = (Stack) original.clone();		
		
		for (int i = 0; i < texto.length(); i++) {
			
			//Si la pila no esta vacia sigue coincidiendo
			if(!copy.empty()) {
				//ERROR
				//Si no coincide se mueve de acuerdo al patron del error
				if(!copy.peek().equals(texto.charAt(i))) {
					movimientos = original.size()-copy.size();
					movimientos = arrayLPatron.get(movimientos);
					copy = (Stack) original.clone();
					i=movimientos+i;
				}
				//Coincide, desapila y coincide el siguiente  
				else copy.pop();
				
			}
			//Guarda las posiciones de la coincidencia hallada
			else {
				String posicion = (i-original.size())+","+i;
				arrayPares.add(posicion);
				copy = (Stack) original.clone();
			}
		}
		return arrayPares;
	}
	
}
