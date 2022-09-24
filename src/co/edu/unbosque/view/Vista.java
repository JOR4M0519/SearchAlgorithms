package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Esta clase representa a la vista en el patron de arquitectura MVC.
 * Se encarga de almacenar los métodos que daran lugar a la visualización del programa de parte del usuario.
 * @author Laura Mateus, Natalia Ardila, Jeanpierr Ramos y Kevin Garcia.
 *
 */
public class Vista extends JFrame{
	
	private InicioPanel inicioPanel;
	private parametrosPanel parametrosPanel;
	private ResultadoPanel resultadoPanel;
	
	
	public Vista(){
		 setVisible(true);
		 setSize(500, 500);
		 setDefaultCloseOperation(EXIT_ON_CLOSE);
		 setTitle("B�squeda de algoritmos de fuerza Bruta");
		 setResizable(false);
		 setLocationRelativeTo(null);
		 
		 
		 inicioPanel = new InicioPanel();
		 resultadoPanel = new ResultadoPanel();
		 parametrosPanel = new parametrosPanel();
		 
		 add(inicioPanel, BorderLayout.CENTER);
	}
	
	/**
	 * Método encargado de mostrarle al usuario un mensaje.
	 * @param msg Mensaje para el usuario.
	 */
	public void mostrarVentana(String msg) {
		JOptionPane.showMessageDialog(null, msg);
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
	public void escribirContenido(String palabras) {

		try {
			String contenido =leerContenido()+palabras+"\n";
			FileWriter myWriter = new FileWriter("resultado.txt");



			myWriter.write(contenido);
			myWriter.close();
		} catch (IOException e) {
			System.out.println("Un error ocurrió.");
			e.printStackTrace();
		}
	}

	/**
	 * Método encargado de leer el contenido del archivo.
	 * @return Contenido del archivo.
	 */
	public String leerContenido(){
		String texto="";
		File file = new File("resultado.txt");
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

	public parametrosPanel getParametrosPanel() {
		return parametrosPanel;
	}

	public ResultadoPanel getResultadoPanel() {
		return resultadoPanel;
	}

	
	
}
