package co.edu.unbosque.view;

import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * En esta clase se encuentran los metodos que permiten la visualización del panel de los parametros que solicita el programa, 
 * el cual se muestra al darle clic a los botones "Algoritmo BM" y "Algoritmo KMP".
 * @author Laura Mateus, Jeanpierr Ramos y Kevin Garcia.
 *
 */
public class ParametrosPanel extends JPanel {

	private	JLabel lblTitulo;
	private	JTextArea txtTextoBuscar;
	private JButton btnRegresar;
	private JButton btnContinuar;
	private JCheckBox chkMayusMinus;
	
	/**
	 * Representa el metodo constructor de la clase ParametrosPanel.  
	 */
	public ParametrosPanel() {
	
		setLayout(new GridBagLayout());
		
		lblTitulo = new JLabel("Digite lo que desea filtrar del archivo cargado");
		lblTitulo.setFont(new Font("Serif", Font.BOLD, 20));
		
		btnRegresar = new JButton("Regresar");
		btnRegresar.setActionCommand("REGRESAR");
		
		btnContinuar = new JButton("Continuar");
		btnContinuar.setActionCommand("CONTINUAR");
		
		txtTextoBuscar = new JTextArea("Escriba el patrón de palabras");
		
		chkMayusMinus = new JCheckBox("Sensibilidad a Mayus-Minus");
		

		
		addComponent(lblTitulo,		1,0, 1,1, 0,0.3,GridBagConstraints.CENTER);
		
		addComponent(txtTextoBuscar,1,2, 1,1, 0,1,GridBagConstraints.BOTH);
		addComponent(chkMayusMinus,	1,1, 2,1, 0,0.1,GridBagConstraints.HORIZONTAL);
		
		addComponent(btnRegresar,	1,4, 1,1, 0,0.08,GridBagConstraints.HORIZONTAL);
		addComponent(btnContinuar,	1,3, 1,1, 0,0.08,GridBagConstraints.HORIZONTAL);
		
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
	 * Se encarga de obtener el label del titulo.
	 * @return Label del titulo.
	 */
	public JLabel getTitulo() {
		return lblTitulo;
	}

	/**
	 * Se encarga de obtener el textarea del patron.
	 * @return TextArea del patron.
	 */
	public JTextArea getTxtTextoBuscar() {
		return txtTextoBuscar;
	}

	/**
	 * Se encarga de obtener el boton para regresar al panel inicial.
	 * @return Boton para regresar al panel inicial.
	 */
	public JButton getBtnRegresar() {
		return btnRegresar;
	}

	/**
	 * Se encarga de obtener el boton para continuar al panel de resultados.
	 * @return Boton para continuar al panel de resultados.
	 */
	public JButton getBtnContinuar() {
		return btnContinuar;
	}

	/**
	 * Se encarga de obtener el checkbox de distincion de mayusculas.
	 * @return Checkbox de distincion de mayusculas.
	 */
	public JCheckBox getChkMayusMinus() {
		return chkMayusMinus;
	}
	
}
