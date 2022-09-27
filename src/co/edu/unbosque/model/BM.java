package co.edu.unbosque.model;

/**
 * En la clase BM se encuentran los metodos que contibuyen a la identificacion de patrones en un texto mediante el algoritmo
 * BM.
 * @author Laura Mateus, Jeanpierr Ramos y Kevin Garcia.
 *
 */
public class BM {

	private String posicion;

	//Ignorar esto - controller BM
	//	bM= new BM();
	//	String textoLargo= "ABAAAABAACD";
	//	String patron="ABA";
	//	int numeroDePatrones=0;
	//	
	//	String [] posicion= bM.obtenerPosiciones(textoLargo,patron);
	//	if(posicion!=null) {
	//		numeroDePatrones=posicion.length;
	//	}
	//	
	//	System.out.println("El numero de patrones encontrados es: "+numeroDePatrones);
	//Ignorar esto - controller BM

	/**
	 * Se encarga de asignar las acciones de los componentes.
	 */
	public BM() {
		this.posicion="";
	}

	
	/**
	 * Obtiene las posiciones en donde encontra semejanza y las separa todas guardandolas en un array para saber el número 
	 * de patrones encontrados y sus posiciones dentro del texto.
	 * @param textoLargo Texto ingresado por el usuario.
	 * @param patron Patron ingresado por el usuario.
	 * @return Posiciones en donde se encuentran los patrones.
	 */
	public String[] obtenerPosiciones(String textoLargo, String patron) {
		buscar(textoLargo, patron);
		if(this.posicion.length()==0) {
			return null;
		}
		this.posicion=this.posicion.substring(0, this.posicion.length()-1);
		return this.posicion.split(" ");
	}
	
	/**
	 * Se encarga de procesar el texto para encontrar patrones en un determinado caso.
	 * @param tempUno Array que almacena el primer caracter.
	 * @param tempDos Array que almacena los caracteres comunes.
	 * @param arrayPatron Array que almacana el patron.
	 * @param tamanoPatron Cantidad de caracteres del patron.
	 */
	public void revisarCasoUno(int []tempUno, int []tempDos,char []arrayPatron, int tamanoPatron){
		// m is the length of pattern 
		int x= tamanoPatron; 
		int i= tamanoPatron + 1;
		tempDos[x]= i;

		while(x>0){
			/*if character at position i-1 is not 
        equivalent to character at j-1, then 
        continue searching to right of the
        pattern for border */
			while(i<=tamanoPatron && arrayPatron[x-1]!=arrayPatron[i-1]){
				/* the character preceding the occurrence of t 
            in pattern P is different than the mismatching 
            character in P, we stop skipping the occurrences 
            and shift the pattern from i to j */
				if (tempUno[i]==0) {
					tempUno[i]= i-x;
				}
				//Update the position of next border 
				i= tempDos[i];
			}
			/* p[i-1] matched with p[j-1], border is found.
        store the beginning position of border */
			x--; 
			i--;
			tempDos[x]= i; 
		}
	}

	//Preprocessing for case 2
	
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
					int posicionFinal= posicionInicial+(tamanoPatron-1);
					this.posicion+= posicionInicial+","+posicionFinal+" ";
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
