package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Document;
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
	
	 public void highlight(JTextComponent comp, ArrayList<String> posiciones) {

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
	 * Método encargado de obtener un dato solicitado al usuario por medio de una ventana con un mensaje.
	 * @param msg Mensaje para el usuario.
	 * @return Ventana en la que se ingresa el dato.
	 */
	public String recibirDato(String msg) {
		return JOptionPane.showInputDialog(null, msg);
	}
	
	/**
	 * Método encargado de obtener una confirmacin al usuario por medio de una ventana con un mensaje.
	 * @param msg Mensaje para el usuario.
	 * @return Valor booleano.
	 */
	public boolean recibirBoolean(String msg) {
		int respuesta = JOptionPane.showConfirmDialog(null, msg, "Confirmación" ,JOptionPane.YES_NO_OPTION);
		
		if (respuesta == JOptionPane.NO_OPTION) return false;
		
		return true;
	}
	
	/**
	 * Método encargado de escribir el resultado en archivos.
	 * @param palabras Datos de ingreso.
	 */
//	public void escribirContenido(String palabras) {
//
//		try {
//			String contenido =leerContenido()+palabras+"\n";
//			FileWriter myWriter = new FileWriter("resultado.txt");
//
//
//
//			myWriter.write(contenido);
//			myWriter.close();
//		} catch (IOException e) {
//			System.out.println("Un error ocurrió.");
//			e.printStackTrace();
//		}
//	}

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

	public InicioPanel getInicioPanel() {
		return inicioPanel;
	}


	public ParametrosPanel getParametrosPanel() {
		return parametrosPanel;
	}

	public ResultadoPanel getResultadoPanel() {
		return resultadoPanel;
	}

	
	
}
