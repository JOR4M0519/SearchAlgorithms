package co.edu.unbosque.view;

import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InicioPanel extends JPanel {

	private JButton btnCargarArchivo;
	private JButton btnSalir;
	private JButton btnBM;
	private JButton btnKMP;
	
	private	JLabel lablTitulo;
	private	JLabel lblAutores;
	
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

	public JButton getBtnCargarArchivo() {
		return btnCargarArchivo;
	}

	public JButton getBtnSalir() {
		return btnSalir;
	}

	public JButton getBtnBM() {
		return btnBM;
	}

	public JButton getBtnKMP() {
		return btnKMP;
	}

	public JLabel getLblTitulo() {
		return lablTitulo;
	}

	public JLabel getLblAutores() {
		return lblAutores;
	}
	
	
	
}
