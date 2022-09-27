package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.JTextComponent;

/**
 * Esta clase representa a la vista en el patron de arquitectura MVC.
 * Se encarga de almacenar los métodos que daran lugar a la visualización del programa de parte del usuario.
 * @author Laura Mateus, Jeanpierr Ramos y Kevin Garcia.
 *
 */
public class Vista extends JFrame{
	
	private InicioPanel inicioPanel;
	private ParametrosPanel parametrosPanel;
	private ResultadoPanel resultadoPanel;
	
	/**
	 * Representa el metodo constructor de la clase Vista.  
	 */
	public Vista(){
		 setSize(500, 500);
		 setDefaultCloseOperation(EXIT_ON_CLOSE);
		 setLayout(new BorderLayout());
		 setTitle("Busqueda con algoritmos de fuerza Bruta");
		 setResizable(false);
		 setLocationRelativeTo(null);
		 
		 
		 inicioPanel = new InicioPanel();
		 resultadoPanel = new ResultadoPanel();
		 parametrosPanel = new ParametrosPanel();
		 
		 add(inicioPanel,BorderLayout.CENTER);
		 setVisible(true);
	}
	
	/**
	 * Se encarga de resaltar los patrones que los algoritmos encuentran en el texto.
	 * @param comp Cumple la funcion de resaltador.
	 * @param posiciones Posiciones en las que se resaltar�.
	 */
	 public void resaltarTexto(JTextComponent comp, ArrayList<String> posiciones) {

	        try {
	            Highlighter hilite = comp.getHighlighter();
	            for (String string : posiciones) {
	            	hilite.addHighlight( Integer.parseInt(string.split(",")[0]),Integer.parseInt(string.split(",")[1]) , DefaultHighlighter.DefaultPainter);	
				}
	            
	            
	        } catch (BadLocationException e) {
	        }
	    }
	
	/**
	 * Método encargado de mostrarle al usuario un mensaje.
	 * @param msg Mensaje para el usuario.
	 */
	public void mostrarVentana(String msg) {
		JOptionPane.showMessageDialog(null, msg);
	}
	
	/**
	 * Metodo para cargat el archivo txt del usuario.
	 * @return Lectura del contenido.
	 */
	public String cargarArchivo() {
		
		
		JFileChooser file=new JFileChooser();
		file.showOpenDialog(this);
		
		
		
		if(file.getSelectedFile().getName().split("\\.")[1].equals("txt")) {
			return leerContenido(file.getSelectedFile());	
		}
		
		mostrarVentana("Error\n"+"El archivo cargado es diferente al formato 'txt', vuelva a intentarlo");
		
		return "";
		
	}
	

	/**
	 * Método encargado de leer el contenido del archivo.
	 * @return Contenido del archivo.
	 */
	public String leerContenido(File file){
		String texto="";
		String word;
		try {
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferReader = new BufferedReader(fileReader);
			word = bufferReader.readLine();
			do {
				if(word!=null) texto+=word+"\n";

				word = bufferReader.readLine();
			}while(word!=null);
			fileReader.close();

		}catch (Exception e) {

		}
		return texto;
	}

	/**
	 * Se encarga de obtener le panel inicial que contiene el men�.
	 * @return Panel inicial
	 */
	public InicioPanel getInicioPanel() {
		return inicioPanel;
	}

	/**
	 * Se encarga de obtener le panel que contiene los parametros que requerimos por parte del usuario.
	 * @return Panel de parametros
	 */
	public ParametrosPanel getParametrosPanel() {
		return parametrosPanel;
	}

	/**
	 * Se encarga de obtener el panel de resultados con el texto resaltado.
	 * @return Panel de resultados.
	 */
	public ResultadoPanel getResultadoPanel() {
		return resultadoPanel;
	}
	
}
