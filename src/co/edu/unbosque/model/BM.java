package co.edu.unbosque.model;

import java.util.ArrayList;

/**
 * En la clase BM se encuentran los metodos que contibuyen a la identificacion de patrones en un texto mediante el algoritmo
 * BM.
 * @author Laura Mateus, Jeanpierr Ramos y Kevin Garcia.
 *
 */
public class BM {

	private ArrayList<String> posicion;

	/**
	 * Se encarga de asignar las acciones de los componentes.
	 */
	public BM() {
		this.posicion=new ArrayList<String>();
	}


	/**
	 * Obtiene las posiciones en donde encontra semejanza. 
	 * @param textoLargo Texto ingresado por el usuario.
	 * @param patron Patron ingresado por el usuario.
	 * @return ArrayList en donde se encuentran las posiciones de los patrones.
	 */
	public ArrayList<String> obtenerPosiciones(String textoLargo, String patron, boolean coincidirMayusMinus) {
		if(!coincidirMayusMinus) {
			patron = patron.toLowerCase();
			textoLargo = textoLargo.toLowerCase();
		}
		buscar(textoLargo, patron);
		return this.posicion;
	}

	/**
	 * Se encarga de procesar el texto para encontrar patrones en un determinado caso.
	 * @param tempUno Array que almacena el primer caracter.
	 * @param tempDos Array que almacena los caracteres comunes.
	 * @param arrayPatron Array que almacana el patron.
	 * @param tamanoPatron Cantidad de caracteres del patron.
	 */
	public void revisarCasoUno(int []tempUno, int []tempDos,char []arrayPatron, int tamanoPatron){
		int x= tamanoPatron; 
		int i= tamanoPatron + 1;
		tempDos[x]= i;

		while(x>0){
			while(i<=tamanoPatron && arrayPatron[x-1]!=arrayPatron[i-1]){
				if (tempUno[i]==0) {
					tempUno[i]= i-x;
				}
				i= tempDos[i];
			}
			x--; 
			i--;
			tempDos[x]= i; 
		}
	}

	/**
	 * Se encarga de procesar el texto para encontrar patrones en el segundo caso.
	 * @param tempUno Array que almacena el primer caracter.
	 * @param tempDos Array que almacena los caracteres comunes.
	 * @param arrayPatron Array que almacana el patron.
	 * @param tamanoPatron Cantidad de caracteres del patron.
	 */
	public void revisarCasoDos(int []tempUno, int []tempDos,char []arrayPatron, int tamanoPatron){
		int x; 
		int i;
		i= tempDos[0];

		for(x=0;x<=tamanoPatron;x++){
			/* set the border position of the first character 
        of the pattern to all indices in array shift
        having shift[i] = 0 */
			if(tempUno[x]==0) {
				tempUno[x]= i;
			}
			/* suffix becomes shorter than bpos[0], 
        use the position of next widest border
        as value of j */
			if (x==i) {
				i= tempDos[i];
			}
		}
	}

	/**
	 * Se encarga de buscar un patron en el texto usando el algoritmo BM.
	 * @param textoLargo Texto ingresado por el usuario.
	 * @param patron Patron a buscar.
	 */
	public void buscar(String textoLargo, String patron){

		char[] arrayTextoLargo= textoLargo.toCharArray();
		char[] arrayPatron= patron.toCharArray();
		int tamanoTextoLargo= arrayTextoLargo.length;
		int tamanoPatron= arrayPatron.length;
		int[] tempUno= new int[tamanoPatron+1];
		int[] tempDos= new int[tamanoPatron+1]; 
		int posicionInicial= 0;
		int x;

		//initialize all occurrence of shift to 0
		for(int i=0;i<tamanoPatron+1;i++) { 
			tempUno[i] = 0;

			revisarCasoUno(tempUno, tempDos, arrayPatron, tamanoPatron);
			revisarCasoDos(tempUno, tempDos, arrayPatron, tamanoPatron);

			while(posicionInicial<= tamanoTextoLargo-tamanoPatron){
				x= tamanoPatron-1;

				/* Keep reducing index j of pattern while 
        characters of pattern and text are matching 
        at this shift s*/
				while(x>=0 && arrayPatron[x]==arrayTextoLargo[posicionInicial+x]) {
					x--;
				}
				/* If the pattern is present at the current shift, 
        then index j will become -1 after the above loop */
				if (x<0){
					int posicionFinal= posicionInicial+(tamanoPatron);
					String posi= posicionInicial+","+posicionFinal;
					this.posicion.add(posi);
					posicionInicial+= tempUno[0];
				}else {
					/*pat[i] != pat[s+j] so shift the pattern
            shift[j+1] times */
					posicionInicial+= tempUno[x + 1];
				}
			}
		}
	}

}
