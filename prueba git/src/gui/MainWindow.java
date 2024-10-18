package gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.time.LocalDate;
import java.time.chrono.ChronoPeriod;
import java.time.chrono.Chronology;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalField;
import java.time.temporal.TemporalUnit;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import domain.Athlete;
import domain.Athlete.Genre;

public class MainWindow extends JFrame{
	
	public class mirenderer extends DefaultListCellRenderer{
		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			JLabel etiqueta = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
			
			Athlete atleta = (Athlete) value;
			
			etiqueta.setText("Apellido,"+atleta.getName());
			
			return etiqueta;
		}
	}
	public MainWindow() {
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
		setTitle("JJ.OO. París 2024");
		setSize(640 , 480);
		setLocationRelativeTo(null);
		
		addWindowListener(new WindowAdapter() {
		@Override
		public void windowClosing(WindowEvent e) {
			int response = JOptionPane.showConfirmDialog(MainWindow.this, "¿Seguro que desea salir?", "Salir", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
		}
		});
		
		String[] prueba = new String[30];
		for(int i = 0; i<30; i++) {
			String nombre = "Atleta "+i;
			prueba[i] = nombre;
		}
		DefaultListModel<Athlete> modeloatleta = new DefaultListModel<Athlete>();
		LocalDate data = LocalDate.now();
		modeloatleta.add(0, new Athlete(11, "nombre1", Genre.MALE, "pais1",data ));
		modeloatleta.add(1, new Athlete(22, "nombre2", Genre.FEMALE, "pais1",data ));
		modeloatleta.add(2, new Athlete(33, "nombre3", Genre.MALE, "pais2",data ));
		modeloatleta.add(3, new Athlete(44, "nombre4", Genre.FEMALE, "pais2",data ));
		modeloatleta.add(4, new Athlete(55, "nombre5", Genre.MALE, "pais3",data ));
		
		JList<Athlete> jlista = new JList<Athlete>(modeloatleta);
		jlista.setCellRenderer(new mirenderer());
		JScrollPane barra = new JScrollPane(jlista);
		jlista.setFixedCellWidth(200);
		add(barra, BorderLayout.WEST);
		
		JTabbedPane pestañas = new JTabbedPane();
		pestañas.addTab("Datos",null);
		pestañas.addTab("Medallas",null);
		add(pestañas, BorderLayout.CENTER);
		
		JMenuBar jmenubar = new JMenuBar();
		JMenu jmenu = new JMenu("Fichero");
		JMenuItem jmenuItem = new JMenuItem("Nuevo Atleta...");
		JMenuItem jmenuItem1 = new JMenuItem("Importar");
		JMenuItem jmenuItem2 = new JMenuItem("Exportar");
		JMenuItem jmenuItem3 = new JMenuItem("Salir");
		jmenuItem3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int response = JOptionPane.showConfirmDialog(MainWindow.this, "¿Seguro que desea salir?", "Salir", JOptionPane.YES_NO_OPTION);
	            if (response == JOptionPane.YES_OPTION) {
	                System.exit(0);
	            }
			}
		});
		
		
		jmenu.add(jmenuItem);
		jmenu.addSeparator();
		jmenu.add(jmenuItem1);
		jmenu.add(jmenuItem2);
		jmenu.addSeparator();
		jmenu.add(jmenuItem3);
		setJMenuBar(jmenubar);
		jmenubar.add(jmenu);
		
		
		
		
		setVisible(true);
	}
}
