package co.edu.unbosque.view;

import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ResultadoPanel extends JPanel{

	private	JLabel titulo;
	private JTextArea resultado;
	private JScrollPane scroll;
	private JButton regresar;
	
	public ResultadoPanel() {
		
		setLayout(new GridBagLayout());
		
		titulo = new JLabel("Bienvenidos al sistema de coincidencia");
		titulo.setFont(new Font("Serif", Font.BOLD, 20));
		
		regresar = new JButton("Regresar al Menú");
		regresar.setActionCommand("REGRESAR");
		
		resultado = new JTextArea("");
		resultado.setEditable(false);
		
		addComponent(titulo,0,0,1,1,0,1,GridBagConstraints.CENTER);
		addComponent(regresar,0,0,1,1,0,1,GridBagConstraints.CENTER);
		addComponent(resultado,0,0,1,1,0,1,GridBagConstraints.CENTER);
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
	
	
}
