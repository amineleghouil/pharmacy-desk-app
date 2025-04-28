package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class pharmacienGUI extends JFrame {
    private JPanel lP;
    private JButton BCC;
    private JButton BCM;
    private JButton BGO;
    private JPanel titre;
    private JLabel ltitre;
    public pharmacienGUI() {
        
        this.setIconImage(new ImageIcon("pict.png").getImage());
        this.setTitle("Pharmacien Interface");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(650, 500));
        titre = new JPanel(new FlowLayout(FlowLayout.CENTER));
        titre.setBackground(new Color(0, 102, 102));
        ltitre = new JLabel("Pharmacien Interface");
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
        BCC = new JButton("Cosulter les clients");
        BCM = new JButton("Consulter les médicaments");
        BGO = new JButton("Gérer les ordonnances");
        BCC.setFont(new Font("Segoe UI", Font.BOLD, 14));
        BCC.setBackground(new Color(0, 102, 102));
        BCC.setForeground(new Color(255, 255, 255));
        BCM.setFont(new Font("Segoe UI", Font.BOLD, 14));
        BCM.setBackground(new Color(0, 102, 102));
        BCM.setForeground(new Color(255, 255, 255));
        BGO.setFont(new Font("Segoe UI", Font.BOLD, 14));
        BGO.setBackground(new Color(0, 102, 102));
        BGO.setForeground(new Color(255, 255, 255));
        JLabel n14=new JLabel("Cosulter les clients :");
        n14.setFont(new Font("Segoe UI", Font.BOLD, 18));
        n14.setForeground(new Color(0, 102, 102));
        lP.add(n14);
        lP.add(BCC);
        JLabel n15=new JLabel("Cosulter les médicaments :");
        n15.setFont(new Font("Segoe UI", Font.BOLD, 18));
        n15.setForeground(new Color(0, 102, 102));
        lP.add(n15);
        lP.add(BCM);
        JLabel n16=new JLabel("Gérer les ordonnances :");
        n16.setFont(new Font("Segoe UI", Font.BOLD, 18));
        n16.setForeground(new Color(0, 102, 102));
        lP.add(n16);
        lP.add(BGO);
        BCM.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				conMed c1= new conMed();
				
				
			}
        	
        });
        BGO.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				gestionOrd c2= new gestionOrd();
				
				
			}
        	
        });
        BCC.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				conClient c3= new conClient();
				
				
			}
        	
        });
       
        this.add(lP);
        lP.setBounds(0, 0, 650, 500);
       
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
