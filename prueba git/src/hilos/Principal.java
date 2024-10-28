package hilos;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;

public class Principal extends JFrame{ 
	Thread t;
	public Principal() {
		setTitle("");
		setSize(400,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ArrayList<Thread> hilos = new ArrayList<Thread>();
		
		JPanel panel = new JPanel();
		
		JButton boton = new JButton("Iniciar");
		JButton parar = new JButton("Parar");
		parar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				for(Thread t: hilos) {
					t.interrupt();
				}
				for(Thread t: hilos) {
					try {
						t.join();
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
		});
		JProgressBar barra = new JProgressBar();
		barra.setMaximum(10);
		add(barra, BorderLayout.NORTH);
		
		boton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				  t = new Thread(() -> {
					for(int i = 0; i<=10 && !  t.isInterrupted(); i++) {
						System.out.println("Swing: "+i);
						int counter = i;
						SwingUtilities.invokeLater(new Runnable() {
							@Override
							public void run() {
								barra.setValue(counter);
								
							}
						});
						try {
							t.sleep(500);
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
							Thread.currentThread().interrupt();
						}
					}
					System.out.println("hilo terminado");
				});
				 t.start();
				 hilos.add(t);
			}});
		panel.add(boton);
		panel.add(parar);
		add(panel, BorderLayout.SOUTH);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			Principal ventana = new Principal();
		});
	}
	
	//Solo un hilo puede utilizar este metodo
	synchronized public int sumador(int c) {
		return c++;
	}
}
		
		
			
	

	
	


