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

public class ResultadoPanel extends JPanel{

	private	JLabel lblTitulo;
	private JTextArea txtResultado;
	private JScrollPane scrollBar;
	private JButton btnRegresar;
	
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

	public JLabel getLblTitulo() {
		return lblTitulo;
	}

	public JTextArea getTxtResultado() {
		return txtResultado;
	}

	public JScrollPane getScrollBar() {
		return scrollBar;
	}

	public JButton getBtnRegresar() {
		return btnRegresar;
	}
	
}
