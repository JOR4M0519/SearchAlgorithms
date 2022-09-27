package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

/**
 * En esta clase se encuentran los metodos que permiten la visualización del panel de los resultados.
 * @author Laura Mateus, Jeanpierr Ramos y Kevin Garcia.
 *
 */
public class ResultadoPanel extends JPanel{

	private	JLabel lblTitulo;
	private JTextArea txtResultado;
	private JScrollPane scrollBar;
	private JButton btnRegresar;
	
	/**
	 * Representa el metodo constructor de la clase ResultadoPanel.  
	 */
	public ResultadoPanel() {
		
		setLayout(new GridBagLayout());
		
		lblTitulo = new JLabel("Resultado",SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Serif", Font.BOLD, 20));
		
		btnRegresar = new JButton("Regresar al Menu");
		btnRegresar.setActionCommand("REGRESAR");
		
		txtResultado = new JTextArea(5,5);
		txtResultado.setLineWrap(true);
		txtResultado.setWrapStyleWord(true);
		txtResultado.setEditable(false);
		
		scrollBar = new JScrollPane(txtResultado);

		
		addComponent(lblTitulo,		1,0, 1,1, 1,0.2,GridBagConstraints.CENTER);
		addComponent(new JLabel(),	0,1, 1,1, 0.2,1,GridBagConstraints.BOTH);
		addComponent(scrollBar,		1,1, 1,1, 0,1,GridBagConstraints.BOTH);
		addComponent(new JLabel(),	2,1, 1,1, 0.2,1,GridBagConstraints.BOTH);
		addComponent(btnRegresar,	1,2, 1,1, 1,0.08,GridBagConstraints.HORIZONTAL);
		
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
	public JLabel getLblTitulo() {
		return lblTitulo;
	}

	/**
	 * Se encarga de obtener el textarea del texto resaltado.
	 * @return TextArea del texto resaltado.
	 */
	public JTextArea getTxtResultado() {
		return txtResultado;
	}

	/**
	 * Se encarga de obtener el la barra para scrollear.
	 * @return Barra para scrollear.
	 */
	public JScrollPane getScrollBar() {
		return scrollBar;
	}

	/**
	 * Se encarga de obtener el boton para regresar al panel inicial.
	 * @return Boton para regresar al panel inicial.
	 */
	public JButton getBtnRegresar() {
		return btnRegresar;
	}
	
}
