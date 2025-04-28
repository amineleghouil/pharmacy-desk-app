package view;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import Controller.clientC;
import model.beans.client;

public class gestionClient extends JFrame{
	private JPanel lP;
    private JPanel rP;
    private JButton bAjouter;
    private JButton bEnregistrer;
    private JButton bSupprimer;
    private JButton bFermer;
    private JButton bModifier;
    private JTextField tidc;
    private JTextField tnom;
    private JTextField tprenom;
    private JTextField tcredit;
    private JLabel b;
    private JLabel idc;
    private JLabel nom;
    private JLabel prenom;
    private JLabel credit;
    private DefaultTableModel modelTable;
    private JTable tableC;
    private List<client> allC;
	public gestionClient() {
		this.setTitle("Gestion de client ");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(800, 540));
        this.setLayout(null);
        lP = new JPanel();
        lP.setLayout(new GridLayout(0,2,15,15));
        b = new JLabel("Gestion de client");
        b.setFont(new Font("Segoe UI", Font.BOLD, 18));
        b.setForeground(new Color(0, 102, 102));
        lP.add(b);
        JLabel n11=new JLabel("\n");
        lP.add(n11);
        JLabel n12=new JLabel("\n");
        lP.add(n12);
        JLabel n13=new JLabel("\n");
        lP.add(n13);
        idc = new JLabel("ID de client");
        lP.add(idc);
        tidc = new JTextField();
        lP.add(tidc);
        nom = new JLabel("nom");
        lP.add(nom);
        tnom = new JTextField();
        lP.add(tnom);
        prenom = new JLabel("prenom");
        lP.add(prenom);
        tprenom = new JTextField();
        lP.add(tprenom);
        credit = new JLabel("credit");
        lP.add(credit);
        tcredit = new JTextField();
        lP.add(tcredit);
        
        bAjouter = new JButton("ajouter ");
        bAjouter.setFont(new Font("Segoe UI", 0, 18));
        bAjouter.setForeground(new Color(255,255,255));
        bAjouter.setBackground(new Color(0, 102, 102));
        bAjouter.setBounds(30, 270, 50, 40);
        lP.add(bAjouter);
        bEnregistrer = new JButton("enregistrer ");
        bEnregistrer.setFont(new Font("Segoe UI", 0, 18));
        bEnregistrer.setForeground(new Color(255,255,255));
        bEnregistrer.setBackground(new Color(0, 102, 102));
        bEnregistrer.setBounds(30, 270, 50, 40);
        lP.add(bEnregistrer);
        bModifier = new JButton("modifier");
        bModifier.setFont(new Font("Segoe UI", 0, 18));
        bModifier.setBackground(new Color(0, 102, 102));
        bModifier.setForeground(new Color(255, 255, 255));
        bModifier.setBounds(30, 270, 50, 40);
        lP.add(bModifier);
        bSupprimer = new JButton("supprimer");
        bSupprimer.setFont(new Font("Segoe UI", 0, 18));
        bSupprimer.setForeground(new Color(255,255,255));
        bSupprimer.setBackground(new Color(0, 102, 102));
        bSupprimer.setBounds(30, 270, 50, 40);
        lP.add(bSupprimer);
        JLabel n1=new JLabel("\n");
        lP.add(n1);
        JLabel n2=new JLabel("\n");
        lP.add(n2);
        JLabel n3=new JLabel("\n");
        lP.add(n3);
        bFermer = new JButton("Fermer");
        bFermer.setFont(new Font("Segoe UI", 0, 18));
        bFermer.setForeground(new Color(255,255,255));
        bFermer.setBackground(new Color(0, 102, 102));
        bFermer.setBounds(30, 270, 50, 40);
        lP.add(bFermer);
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
        modelTable = new DefaultTableModel(new Object[][]{}, new String[]{"Id client", "nom","prenom","credit"});
        load();
        tableC = new JTable(modelTable);
        JScrollPane scrollPane = new JScrollPane(tableC);
        bModifier.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		try {
        			String tidc1 =tidc.getText().trim();
                    String tnom1 =tnom.getText().trim();
                    String tprenom1 =tprenom.getText().trim();
                    String tcredit1 =tcredit.getText().trim();
                    if (tidc1.length()==0 || tnom1.length()==0  || tprenom1.length()==0 || tcredit1.length()==0) {
                    	JOptionPane.showMessageDialog(null, "chaque donnée doit etre non null","title", JOptionPane.WARNING_MESSAGE);
                    }
                    else {
                    	clientC c = new clientC();
                    	c.modifier(new client(Integer.parseInt(tidc1),tnom1,tprenom1,Double.parseDouble(tcredit1)));
                    	}
          
                    }
        		 catch (  SQLException e1) {
        				JOptionPane.showMessageDialog(null, "there is a problem in your data", "title", JOptionPane.ERROR_MESSAGE);
        			
        		}
        		
            }
        });
        bAjouter.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		try {
        			String tidc1 =tidc.getText().trim();
                    String tnom1 =tnom.getText().trim();
                    String tprenom1 =tprenom.getText().trim();
                    String tcredit1 =tcredit.getText().trim();
                    if (tidc1.length()==0 || tnom1.length()==0  || tprenom1.length()==0 || tcredit1.length()==0) {
                    	JOptionPane.showMessageDialog(null, "chaque donnée doit etre non null","title", JOptionPane.WARNING_MESSAGE);
                    }
                    else {
                    	clientC c = new clientC();
                    	c.ajout(new client(Integer.parseInt(tidc1),tnom1,tprenom1,Double.parseDouble(tcredit1)));
                    	}
          
                    }
        		 catch (  SQLException e1) {
        				JOptionPane.showMessageDialog(null, "there is a problem in your data", "title", JOptionPane.ERROR_MESSAGE);
        			
        		}
        		
            }
        });
        bSupprimer.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		try {
        			String tidc1 =tidc.getText().trim();
                    
                    if (tidc1.length()==0 ) {
                    	JOptionPane.showMessageDialog(null, "id client doit etre non null","title", JOptionPane.WARNING_MESSAGE);
                    }
                    else {
                    	int choix = JOptionPane.showConfirmDialog(null, "Êtes-vous sûr de vouloir supprimer cette ordonnance  ?",
                                "Confirmation de suppression", JOptionPane.YES_NO_OPTION);
                    	if (choix == JOptionPane.YES_OPTION) {
                    	clientC c = new clientC();
                    	c.supprimer(Integer.parseInt(tidc1));
                    	}
                    }
          
                    }
        		 catch (  SQLException e1) {
        				JOptionPane.showMessageDialog(null, "there is a problem in your data", "title", JOptionPane.ERROR_MESSAGE);
        			
        		}
        		
            }
        });
        bEnregistrer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				load();
			}
        	
        });
        bFermer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int choix = JOptionPane.showConfirmDialog(null, "Êtes-vous sûr de fermer l'app  ?",
                        "Confirmation de fermer", JOptionPane.YES_NO_OPTION);
				if (choix == JOptionPane.YES_OPTION) {
					dispose();
				}
			}
        	
        });
        
        
		
        rP=new JPanel(new BorderLayout());
        rP.add(scrollPane, BorderLayout.CENTER);
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
	public void load() {
		try {
			modelTable.setRowCount(0);
			clientC c=new clientC();
			allC = c.lister();
			for (client client : allC) {
                modelTable.addRow(new Object[]{client.getIdclient(), client.getNom(), client.getPrenom(),
                         client.getCredit()});
            }
		} catch (SQLException e) {
			 JOptionPane.showMessageDialog(null, e.getMessage(), "title", JOptionPane.ERROR_MESSAGE);
		} 
		
		
	}

}
