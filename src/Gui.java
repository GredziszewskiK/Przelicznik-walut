import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Klasa odpowiedzialna za interfejs u¿ytkownika
 * @author Krzysztof Grêdziszewski
 * @param nazwy tabela z nazwami walut króre wyœwietlane s¹ w combobox
 *
 */

@SuppressWarnings("serial")
public class Gui extends JFrame implements ActionListener{
	
	JComboBox<Object> walutaA,walutaB;
	JTextField twalutaA,twalutaB;
	JMenuItem oProgramie,exit;	
	
	public Gui(Object[] nazwy){
		
		setSize(400,400);
		setTitle("Przelicznik");
		setResizable(false);
		setLayout(new BorderLayout());		
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("Menu");
		menuBar.add(menu);
		oProgramie = new JMenuItem("oProgramie");
		oProgramie.addActionListener(this);
		menu.add(oProgramie);
		menu.addSeparator();
		exit = new JMenuItem("Exit");
		exit.addActionListener(this);
		menu.add(exit);
		setJMenuBar(menuBar);		
		JPanel waluta = new JPanel();
		waluta.setLayout(null);
		walutaA = new JComboBox<Object>(nazwy);
		walutaA.setBounds(75, 20, 250, 20);
		walutaA.setSelectedIndex(35);
		waluta.add(walutaA);
		walutaB  = new JComboBox<Object>(nazwy);
		walutaB.setBounds(75, 100, 250, 20);
		walutaB.setSelectedIndex(1);
		waluta.add(walutaB);
		twalutaA = new JTextField();
		twalutaA.setHorizontalAlignment(JTextField.RIGHT);
		twalutaA.setBounds(75, 50, 250, 20);
		twalutaA.addActionListener(this);
		waluta.add(twalutaA);
		twalutaB = new JTextField();
		twalutaB.setHorizontalAlignment(JTextField.RIGHT);
		twalutaB.setBounds(75, 130, 250, 20);
		twalutaB.addActionListener(this);
		waluta.add(twalutaB);
		add(waluta, BorderLayout.CENTER);
				
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);		
		setVisible(true);	
	}	

	@Override
	public void actionPerformed(ActionEvent e) {				
		Object source = e.getSource();		
		if(source==oProgramie)	{
			JOptionPane.showMessageDialog
			(null,"Przelicznik walut.\nAutor: "
					+ "\nKrzysztof Grêdziszewski",
			"Informacjie", JOptionPane.PLAIN_MESSAGE);
		} else if(source==exit){
			dispose();
		} else if(source==twalutaA) {
			Obliczenia oblicz = new Obliczenia(twalutaA.getText(),walutaA.getSelectedItem().toString(),walutaB.getSelectedItem().toString());
			twalutaB.setText(String.valueOf(oblicz.oblicz()));			
		} else if(source==twalutaB) {
							
			Obliczenia oblicz = new Obliczenia(twalutaB.getText(),walutaB.getSelectedItem().toString(),walutaA.getSelectedItem().toString());
			twalutaA.setText(String.valueOf(oblicz.oblicz()));			
		}
	}
}