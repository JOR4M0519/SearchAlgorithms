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

	private	JLabel lblTitulo;
	private	JTextArea txtTextoBuscar;
	private JButton btnRegresar;
	private JButton btnContinuar;
	private JCheckBox chkMayusMinus;
	
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
		return lblTitulo;
	}

	public JTextArea getTxtTextoBuscar() {
		return txtTextoBuscar;
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
