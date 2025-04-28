package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class adminGUI extends JFrame{
	private JPanel lP;
    private JPanel titre;
    private JLabel LB;
    private JLabel ltitre;
    private JButton BGC ;
    private JButton BGM ;
    private JButton BGS ;
	public adminGUI() {
		this.setIconImage(new ImageIcon("pict.png").getImage());
        this.setTitle("Admin Interface");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(650, 500));
        titre = new JPanel(new FlowLayout(FlowLayout.CENTER));
        titre.setBackground(new Color(0, 102, 102));
        ltitre = new JLabel("Admin Interface");
        ltitre.setFont(new Font("Arial", Font.BOLD, 30));
        ltitre.setForeground(Color.WHITE);
        titre.add(ltitre);
        this.getContentPane().add(titre, BorderLayout.NORTH);
        
        lP = new JPanel();
        lP.setBackground(new Color(255, 255, 255));
        lP.setPreferredSize(new Dimension(400, 500));
        lP.setLayout(new GridLayout(5,2,15,15));
        JLabel n12=new JLabel("\n");
        lP.add(n12);
        JLabel n13=new JLabel("\n");
        lP.add(n13);
        BGC = new JButton("Gestion des clients");
        BGM = new JButton("Gestion des médicaments");
        BGS = new JButton("Gestion du stock");
        BGC.setFont(new Font("Segoe UI", Font.BOLD, 14));
        BGC.setBackground(new Color(0, 102, 102));
        BGC.setForeground(new Color(255, 255, 255));
        BGM.setFont(new Font("Segoe UI", Font.BOLD, 14));
        BGM.setBackground(new Color(0, 102, 102));
        BGM.setForeground(new Color(255, 255, 255));
        BGS.setFont(new Font("Segoe UI", Font.BOLD, 14));
        BGS.setBackground(new Color(0, 102, 102));
        BGS.setForeground(new Color(255, 255, 255));
        JLabel n14=new JLabel("Gestion des clients :");
        n14.setFont(new Font("Segoe UI", Font.BOLD, 18));
        n14.setForeground(new Color(0, 102, 102));
        lP.add(n14);
        lP.add(BGC);
        JLabel n15=new JLabel("Gestion des médicaments :");
        n15.setFont(new Font("Segoe UI", Font.BOLD, 18));
        n15.setForeground(new Color(0, 102, 102));
        lP.add(n15);
        lP.add(BGM);
        JLabel n16=new JLabel("Gestion du stock :");
        n16.setFont(new Font("Segoe UI", Font.BOLD, 18));
        n16.setForeground(new Color(0, 102, 102));
        lP.add(n16);
        lP.add(BGS);
        BGM.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				gestionMed c2= new gestionMed();
				
				
			}
        	
        });
        BGS.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GestionStock c3= new GestionStock();
				
				
			}
        	
        });
        BGC.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				gestionClient c1= new gestionClient();
				
				
			}
        	
        });
        this.add(lP);
        lP.setBounds(0, 0, 650, 500);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
	}

}
