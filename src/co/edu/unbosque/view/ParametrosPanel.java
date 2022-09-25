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

public class ParametrosPanel extends JPanel {

	private	JLabel titulo;
	private	JTextArea textoBuscar;
	private JButton btnRegresar;
	private JButton btnContinuar;
	private JCheckBox chkMayusMinus;
	
	public ParametrosPanel() {
	
		setLayout(new GridBagLayout());
		
		titulo = new JLabel("Digite lo que desea filtrar del archivo cargado");
		titulo.setFont(new Font("Serif", Font.BOLD, 20));
		
		btnRegresar = new JButton("Regresar");
		btnRegresar.setActionCommand("REGRESAR");
		
		btnContinuar = new JButton("Continuar");
		btnContinuar.setActionCommand("CONTINUAR_PARAM");
		
		textoBuscar = new JTextArea("Escriba el patrón de palabras");
		
		chkMayusMinus = new JCheckBox("Con sensibilidad a Mayus");
		
		addComponent(titulo,1,0,1,1,0,1,GridBagConstraints.CENTER);
		addComponent(btnRegresar,0,1,1,1,0,1,GridBagConstraints.CENTER);
		addComponent(textoBuscar,1,1,1,1,0,1,GridBagConstraints.CENTER);
		addComponent(chkMayusMinus,2,1,1,1,0,1,GridBagConstraints.CENTER);
		addComponent(btnContinuar,1,2,1,1,0,1,GridBagConstraints.CENTER);
		
		
	}
	
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

	public JLabel getTitulo() {
		return titulo;
	}

	public JTextArea getTextoBuscar() {
		return textoBuscar;
	}

	public JButton getBtnRegresar() {
		return btnRegresar;
	}

	public JButton getBtnContinuar() {
		return btnContinuar;
	}

	public JCheckBox getChkMayusMinus() {
		return chkMayusMinus;
	}
	
	
	
}
