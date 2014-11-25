package com.isad;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;

public class Markoa extends JFrame {
	
	//Entzulea izango da, Botoia sakatzean egikarituko dena eta itxaroten egongo dena aldaketa bat egon arte
	class Entzule implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String proba = jTextField1.getText();
			konparatu(proba, zenbakia);
			//System.out.println(proba);
		}
	}

	JPanel jPanel1 = new JPanel();
	JPanel jPanel2 = new JPanel();
	JPanel jPanel3 = new JPanel();

	JButton jButton1 = new JButton();
	JLabel jLabel1 = new JLabel();
	JTextField jTextField1 = new JTextField(10);
	JLabel jLabel2 = new JLabel();
	int zenbakia;

	public Markoa() {
		super("Asmatu Jokoa");
		jButton1.setText("Asmatu");
		jLabel1.setText("Sartu zenbakia");
		initialize();
		asmatuZenbakia();

	}
	
	//Botoiak eta Panelak hasieratzeko
	private void initialize() {

		this.setSize(300, 200);
		jPanel1.add(jLabel1, BorderLayout.WEST);
		jPanel1.add(jTextField1, BorderLayout.EAST);
		jPanel2.add(jLabel2);
		jPanel3.add(jButton1);

		getContentPane().add(BorderLayout.NORTH, jPanel1);
		getContentPane().add(BorderLayout.CENTER, jPanel2);
		getContentPane().add(BorderLayout.SOUTH, jPanel3);
		jButton1.addActionListener(new Entzule());
	}

	//Zenbakia Random batekin sortzen du
	private void asmatuZenbakia() {
		zenbakia = new Random().nextInt(99) + 1;
		//System.out.println(zenbakia);
	}

	//Random bezala sortutako zenbakia eta pantailatik sartutakoa konparatzen ditu
	public void konparatu(String proba, int zenbakia) {
		int konparatzeko = Integer.parseInt(proba);
		if (konparatzeko > zenbakia) {
			jLabel2.setText("Txikiagoa da");
			
		} else if (konparatzeko == zenbakia) {
			jLabel2.setText(" ");
			 
			int balioa = JOptionPane.showConfirmDialog(null, "Asmatu duzu. Berriro nahi duzu jolastu?", "Asmatuta", JOptionPane.YES_NO_OPTION);
			switch(balioa)
			{
			case JOptionPane.YES_OPTION:
				jTextField1.setText("");
				asmatuZenbakia();
				break;
			case JOptionPane.NO_OPTION:
				dispose();
				return;
			}
			
			
		} else {
			jLabel2.setText("Handiagoa da");
		}

	}
	
	public static void main(String[] args) {
		Markoa thisClass = new Markoa();
		thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		thisClass.setVisible(true);
	}
}
