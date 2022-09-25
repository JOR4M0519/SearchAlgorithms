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
		
		regresar = new JButton("Regresar al Men�");
		regresar.setActionCommand("REGRESAR");
		
		resultado = new JTextArea("Puede que la tarea que me he impuesto de escribir una historia completa del pueblo romano desde el comienzo mismo de su existencia me recompense por el trabajo invertido en ella, no lo sé con certeza, ni creo que pueda aventurarlo. Porque veo que esta es una práctica común y antiguamente establecida, cada nuevo escritor está siempre persuadido de que ni lograrán mayor certidumbre en las materias de su narración, ni superarán la rudeza de la antigüedad en la excelencia de su estilo. Aunque esto sea así, seguirá siendo una gran satisfacción para mí haber tenido mi parte también en investigar, hasta el máximo de mis capacidades, los anales de la nación más importante del mundo, con un interés más profundo; y si en tal conjunto de escritores mi propia reputación resulta ocultada, me consuelo con la fama y la grandeza de aquellos que eclipsen mi fama. El asunto, además, es uno que exige un inmenso trabajo. Se remonta a más de 700 años atrás y, después de un comienzo modesto y humilde, ha crecido a tal magnitud que empieza a ser abrumador por su grandeza. No me cabe duda, tampoco, que para la mayoría de mis lectores los primeros tiempos y los inmediatamente siguientes, tienen poco atractivo; Se apresurarán a estos tiempos modernos en los que el poderío de una nación principal es desgastado por el deterioro interno. Yo, en cambio, buscaré una mayor recompensa a mis trabajos en poder cerrar los ojos ante los males de que nuestra generación ha sido testigo durante tantos años; tanto tiempo, al menos, como estoy dedicando todo mi pensamiento a reproducir los claros registros, libre de toda la ansiedad que pueden perturbar el historiador de su época, aunque no le puedan deformar la verdad.");
//		resultado.setEditable(false);
		resultado.setEditable(true);
		
		addComponent(titulo,0,0,0,1,1,0.1,GridBagConstraints.CENTER);
		addComponent(regresar,2,2,2,2,0,1,GridBagConstraints.CENTER);
		addComponent(resultado,1,1,2,2,2,0,GridBagConstraints.CENTER);
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
