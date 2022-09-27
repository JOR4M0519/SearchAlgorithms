package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.edu.unbosque.model.Contenido;
import co.edu.unbosque.view.Vista;

/**
 * La clase Controller representa el controlador en el patron de arquitectura MVC que unira las funciones de la vista y el modelo.
 * Además contiene ciertos metodos que nos ayudan a generar datos.
 * @author Laura Mateus, Jeanpierr Ramos y Kevin Garcia.
 *
 */
public class Controller implements ActionListener {


	private Contenido contenido;
	private Vista vista;
	
	/**
	 * Representa el método constructor de la clase Controller, en el cual, se hacen las validaciones que permiten el 
	 * correcto funcionamiento del programa.
	 */
	public Controller() {

		contenido = new Contenido();
		vista = new Vista();
		asignarOyentes();
		
	}

	/**
	 * Se encarga de asignar la activacion de los componentes.
	 */
	public void asignarOyentes() {

		vista.getInicioPanel().getBtnBM().addActionListener(this);
		vista.getInicioPanel().getBtnKMP().addActionListener(this);
		vista.getInicioPanel().getBtnCargarArchivo().addActionListener(this);
		vista.getInicioPanel().getBtnSalir().addActionListener(this);
		
		vista.getParametrosPanel().getBtnContinuar().addActionListener(this);
		vista.getParametrosPanel().getBtnRegresar().addActionListener(this);
		
		vista.getResultadoPanel().getBtnRegresar().addActionListener(this);
		
	}
	
	/**
	 * Se encarga de asignar las acciones de los componentes.
	 */
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("ALGORITMO_BM")) {
			
			if(contenido.getTexto() != null){
				contenido.setTipoAlgoritmo("BM");
				vista.getParametrosPanel().setVisible(true);
				vista.getInicioPanel().setVisible(false);
				vista.setContentPane(vista.getParametrosPanel());	
			}else {
				vista.mostrarVentana("No se ha cargado ningun archivo porfavor\n"+"cargue un archivo para buscar un patr�n");
			}
			
		}else if(e.getActionCommand().equals("ALGORITMO_KMP")) {
			
			if(contenido.getTexto() != null) {
				contenido.setTipoAlgoritmo("KMP");
				vista.getParametrosPanel().setVisible(true);
				vista.getInicioPanel().setVisible(false);
				vista.setContentPane(vista.getParametrosPanel());	
			}else {
				vista.mostrarVentana("No se ha cargado ningun archivo porfavor\n"+"cargue un archivo para buscar un patr�n");
			}
			
		}else if(e.getActionCommand().equals("CARGAR_TEXTO")) {
			
			contenido.setTexto(vista.cargarArchivo());
			
		}else if(e.getActionCommand().equals("SALIR")) {
			System.exit(0);
		}
		
		if(e.getActionCommand().equals("REGRESAR")) {
			vista.getParametrosPanel().getTxtTextoBuscar().setText("");
			contenido.setPatron(null);
			contenido.setTexto(null);
			vista.getInicioPanel().setVisible(true);
			vista.getResultadoPanel().setVisible(false);
			vista.getParametrosPanel().setVisible(false);
			vista.setContentPane(vista.getInicioPanel());
			
		}else if(e.getActionCommand().equals("CONTINUAR")) {

			String patron =vista.getParametrosPanel().getTxtTextoBuscar().getText();
			contenido.setPatron(patron);
			boolean sensibleMay = vista.getParametrosPanel().getChkMayusMinus().isSelected();
			
			if(contenido.getPatron() != null) {
				
				vista.getResultadoPanel().getTxtResultado().setText(contenido.getTexto());
				vista.highlight(vista.getResultadoPanel().getTxtResultado(), contenido.obtnerPosicionesPatrones(sensibleMay)); ;
				
				
				vista.getResultadoPanel().setVisible(true);
				vista.getParametrosPanel().setVisible(false);
				vista.setContentPane(vista.getResultadoPanel());	
			}
		}
	}
	

}

