package co.edu.unbosque.view;

import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * En esta clase se encuentran los metodos que permiten la visualización del panel inicial, el cual se muestra al ejecutar el programa.
 * @author Laura Mateus, Jeanpierr Ramos y Kevin Garcia.
 *
 */
public class InicioPanel extends JPanel {

	private JButton btnCargarArchivo;
	private JButton btnSalir;
	private JButton btnBM;
	private JButton btnKMP;
	
	private	JLabel lablTitulo;
	private	JLabel lblAutores;
	
	/**
	 * Representa el metodo constructor de la clase InicioPanel.  
	 */
	public InicioPanel() {
		
		setLayout(new GridBagLayout());
		
		lablTitulo = new JLabel("Bienvenidos al sistema de coincidencia");
		lablTitulo.setFont(new Font("Serif", Font.BOLD, 20));
		
		btnBM = new JButton("Algoritmo BM");
		btnBM.setActionCommand("ALGORITMO_BM");
		
		btnKMP = new JButton("Algoritmo KMP");
		btnKMP.setActionCommand("ALGORITMO_KMP");
		
		btnCargarArchivo = new JButton("Cargar TEXTO");
		btnCargarArchivo.setActionCommand("CARGAR_TEXTO");
		
		btnSalir = new JButton("Salir");
		btnSalir.setActionCommand("SALIR");
		
		lblAutores = new JLabel("<html><div style='text-align: center;'>" + "Autores: "+"<br>"+
		"Jeanpierr Ramos "+"<br>"+"Kevin García"+"<br>"+"Laura Mateus"+ "</div></html>");
		lblAutores.setFont(new Font("Serif", Font.CENTER_BASELINE, 12));
		
		addComponent(lablTitulo,0,0,1,1,0,1,GridBagConstraints.CENTER);
		addComponent(btnBM,0,1,1,1,0,0.5,GridBagConstraints.BOTH);
		addComponent(btnKMP,0,2,1,1,0,0.5,GridBagConstraints.BOTH);
		addComponent(btnCargarArchivo,0,3,1,1,0,0.5,GridBagConstraints.BOTH);
		addComponent(btnSalir,0,4,1,1,0,0.5,GridBagConstraints.CENTER);
		addComponent(lblAutores,0,5,1,1,0,0.5,GridBagConstraints.CENTER);
		
	}
	
	/**
	 * Añade los componentes al panel y especifica lase cordenadas del mismo.
	 * @param component Componente que verá el usuario.
	 * @param gridx Ajuste del grid en el eje x.
	 * @param gridy Ajuste del grid en el eje y.
	 * @param gridwidth Ajuste del acho del grid.
	 * @param gridheight Ajuste del alto del grid.
	 * @param weightx Ajusta la distribucion tendra el componente en el eje x.
	 * @param weighty Ajusta la distribucion tendra el componente en el eje y.
	 * @param fill Rellena el area que le es asignada.
	 */
	private void addComponent(Component component, int gridx, int gridy, int gridwidth, int gridheight,double weightx, double weighty, int fill) {
		    GridBagConstraints gbc = new GridBagConstraints();
		    gbc.gridx = gridx;
		    gbc.gridy = gridy;
		    gbc.gridwidth = gridwidth;
		    gbc.gridheight = gridheight;
		    gbc.weightx = weightx;
		    gbc.weighty = weighty;
		    gbc.fill = fill;
		    add(component, gbc);
		  }

	/**
	 * Se encarga de obtener el boton para cargar el archivo.
	 * @return Boton para cargar archivo.
	 */
	public JButton getBtnCargarArchivo() {
		return btnCargarArchivo;
	}

	/**
	 * Se encarga de obtener el boton para salir del programa.
	 * @return Boton para salir del programa.
	 */
	public JButton getBtnSalir() {
		return btnSalir;
	}

	/**
	 * Se encarga de obtener el boton para ejecutar el algoritmo BM.
	 * @return Boton para ejecutar el algoritmo BM.
	 */
	public JButton getBtnBM() {
		return btnBM;
	}

	/**
	 * Se encarga de obtener el boton para ejecutar el algoritmo KMP.
	 * @return Boton para ejecutar el algoritmo KMP.
	 */
	public JButton getBtnKMP() {
		return btnKMP;
	}

	/**
	 * Se encarga de obtener el label del titulo.
	 * @return Label del titulo.
	 */
	public JLabel getLblTitulo() {
		return lablTitulo;
	}

	/**
	 * Se encarga de obtener el label de los autores del programa.
	 * @return Label de los autores del programa.
	 */
	public JLabel getLblAutores() {
		return lblAutores;
	}
	
}
