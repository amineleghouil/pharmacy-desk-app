package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import Controller.clientC;
import Controller.loginC;
import model.beans.client;

public class conClient extends JFrame{
	private JPanel lP;
    private JPanel rP;
    private JTextField nom;
    private JTextField prenom;
    private JButton bR;
    private JTable tableClients;
    private DefaultTableModel modelTable;
    private List<client> allClients;
    private JLabel nomL;
    private JLabel prenomL;
    private JLabel BL;
    private JLabel b;
	public conClient() {
		this.setTitle("Client consultation");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(800, 540));
        this.setLayout(null);
        lP = new JPanel();
        lP.setLayout(new GridLayout(0,2,0,10));
        b = new JLabel("Consultation de clients");
        b.setFont(new Font("Segoe UI", Font.BOLD, 18));
        b.setForeground(new Color(0, 102, 102));
        lP.add(b);
        JLabel n11=new JLabel("\n");
        lP.add(n11);
        JLabel n12=new JLabel("\n");
        lP.add(n12);
        JLabel n13=new JLabel("\n");
        lP.add(n13);
        nomL = new JLabel("Nom");
        lP.add(nomL);
        nom = new JTextField();
        lP.add(nom);
        prenomL = new JLabel("Prénom");
        lP.add(prenomL);
        prenom = new JTextField();
        lP.add(prenom);
        JLabel p=new JLabel("\n");
        lP.add(p);
        bR = new JButton("CHERCHER");
        bR.setBackground(new Color(0, 102, 102));
        bR.setFont(new Font("Segoe UI", 0, 18));
        bR.setForeground(new Color(255, 255, 255));
        bR.setBounds(30, 270, 50, 40);
        lP.add(bR);
        JLabel n1=new JLabel("\n");
        lP.add(n1);
        JLabel n2=new JLabel("\n");
        lP.add(n2);
        JLabel n3=new JLabel("\n");
        lP.add(n3);
        JLabel n4=new JLabel("\n");
        lP.add(n4);
        JLabel n5=new JLabel("\n");
        lP.add(n5);
        JLabel n6=new JLabel("\n");
        lP.add(n6);
        JLabel n7=new JLabel("\n");
        lP.add(n7);
        JLabel n8=new JLabel("\n");
        lP.add(n8);
        JLabel n9=new JLabel("\n");
        lP.add(n9);
        JLabel n10=new JLabel("\n");
        lP.add(n10);
        modelTable = new DefaultTableModel(new Object[][]{}, new String[]{"Id", "Nom", "Prénom", "Crédit"});
        clientC c=new clientC();
        try {
			allClients = c.lister();
			for (client client : allClients) {
                modelTable.addRow(new Object[]{client.getIdclient(), client.getNom(), client.getPrenom(),
                         client.getCredit()});
            }
		} catch (SQLException e) {
			 JOptionPane.showMessageDialog(null, e.getMessage(), "title", JOptionPane.ERROR_MESSAGE);
		}      
        tableClients = new JTable(modelTable);
        
        JScrollPane scrollPane = new JScrollPane(tableClients);
        rP=new JPanel(new BorderLayout());
        rP.add(scrollPane, BorderLayout.CENTER);
        bR.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		try {
        			String nomr = nom.getText().trim();
                    String prenomr =prenom.getText().trim();
                    if (nomr.length()==0 || prenomr.length()==0 ) {
                    	JOptionPane.showMessageDialog(null, "enter nom and prenom !","title", JOptionPane.WARNING_MESSAGE);
                    }
                    else {
                    	List<client> clients =c.filter(allClients, nomr, prenomr);
                    	modelTable.setRowCount(0);
     				    for (client client : clients) {
     				        modelTable.addRow(new Object[]{client.getIdclient(), client.getNom(), client.getPrenom(),
     				                client.getCredit()});
     				    	}
                    	}
          
                    }
        		 catch (  SQLException e1) {
        				JOptionPane.showMessageDialog(null, "there is a problem in your data", "title", JOptionPane.ERROR_MESSAGE);
        			
        		}
        		
            }
        });
        
        rP.setBounds(400, 0, 400, 500);
        lP.setBounds(0, 0, 400, 500);
        this.add(lP);
        this.add(rP);
        this.setIconImage(new ImageIcon("pict.png").getImage());
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
	}

}
