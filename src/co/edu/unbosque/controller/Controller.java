package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.stream.LongStream;

import javax.swing.JOptionPane;

import co.edu.unbosque.view.Vista;
/**
 * La clase Controller representa el controlador en el patron de arquitectura MVC que unira las funciones de la vista y el modelo.
 * Además contiene ciertos metodos que nos ayudan a generar datos.
 * @author Laura Mateus, Natalia Ardila, Jeanpierr Ramos y Kevin Garcia.
 *
 */
public class Controller implements ActionListener {


	private Vista vista;
	/**
	 * Representa el método constructor de la clase Controller, en el cual, se hacen las validaciones que permiten el 
	 * correcto funcionamiento del programa.
	 */
	public Controller() {

		vista = new Vista();

		
	}

	public void asignarOyentes() {

		vista.getInicioPanel().getBtnBM().addActionListener(this);
		vista.getInicioPanel().getBtnKMP().addActionListener(this);
		vista.getInicioPanel().getBtnCargarArchivo().addActionListener(this);
		vista.getInicioPanel().getBtnSalir().addActionListener(this);
		
		
	}
	
	
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("ALGORITMO_BM")) {
			
		}else if(e.getActionCommand().equals("ALGORITMO_KMP")) {
			
		}else if(e.getActionCommand().equals("CARGAR_TEXTO")) {
			
			
			
		}else if(e.getActionCommand().equals("SALIR")) {
			
		}
		
		
	}

}

