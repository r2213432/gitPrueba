import java.awt.BorderLayout;
import java.awt.ScrollPane;
import java.awt.Scrollbar;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class Tabla extends JFrame{

	public static void main(String[] args) {
		Tabla ventana = new Tabla();

	}
	
	public class mimodelo extends AbstractTableModel{

		private List<Persona> personas;
		public mimodelo(List<Persona> personas) {
			this.personas = personas;
		}
		
		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			return personas.size();
		}

		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return 2;
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			Persona persona= personas.get(rowIndex); 
			switch (columnIndex) {
			case 0:return persona.getNombre();
			case 1:return persona.getApellido();
			default:
				break;
			}
			return "hola";
		}

		@Override
		public boolean isCellEditable(int rowIndex, int columnIndex) {
			return true;
			
		}
		@Override
		public String getColumnName(int column) {
			// TODO Auto-generated method stub
			return super.getColumnName(column);
		}
		@Override
		public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
			// TODO Auto-generated method stub
			super.setValueAt(aValue, rowIndex, columnIndex);
		}
		
		
	}
	
	String[][] filas= {
			{"hola","te","saludo"},
			{"adios","me","despido"}
			};
	
	String[] columnas = new String[] {"1", "2", "3"};
	
	public Tabla() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setTitle("ventana de jtable");
		setSize(640, 480);
		
		ArrayList<Persona> personas = new ArrayList<Persona>();
		for(int i = 0; i<10;i++) {
			Persona persona = new Persona("nombre"+i,"apellido"+i );
			personas.add(persona);
		}
		JTable tabla = new JTable(new mimodelo(personas));
		
		
		ScrollPane panelbarra = new ScrollPane();
		
		panelbarra.add(tabla);
		
		add(panelbarra, BorderLayout.CENTER);
		
		
		setVisible(true);
	}
	

}
