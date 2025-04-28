package view;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Controller.medicamentC;
import Controller.stockC;
import model.beans.medicament;
import model.beans.stock1;
public class GestionStock extends JFrame{
	private JPanel lP;
    private JPanel rP;
    private JButton bAjouter;
    private JButton bEnregistrer;
    private JButton bSupprimer;
    private JButton bFermer;
    private JButton bModifier;
    private JTextField tqteS;
    private JTextField tnom;
    private JTextField tstock;
    private JLabel b;
    private JLabel nom;
    private JLabel stock;
    private JLabel qteS;
    private DefaultTableModel modelTable;
    private JTable tableS;
    private List<stock1> allS;
	public GestionStock() {
		this.setTitle("Gestion de stock ");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(800, 540));
        this.setLayout(null);
        lP = new JPanel();
        lP.setLayout(new GridLayout(0,2,15,15));
        b = new JLabel("Gestion de stock");
        b.setFont(new Font("Segoe UI", Font.BOLD, 18));
        b.setForeground(new Color(0, 102, 102));
        lP.add(b);
        JLabel n11=new JLabel("\n");
        lP.add(n11);
        JLabel n12=new JLabel("\n");
        lP.add(n12);
        JLabel n13=new JLabel("\n");
        lP.add(n13);
        stock = new JLabel("ID de stock");
        lP.add(stock);
        tstock = new JTextField();
        lP.add(tstock);
        nom = new JLabel("nom");
        lP.add(nom);
        tnom = new JTextField();
        lP.add(tnom);
        qteS = new JLabel("quantité de stock");
        lP.add(qteS);
        tqteS= new JTextField();
        lP.add(tqteS);
        bAjouter = new JButton("ajouter ");
        bAjouter.setFont(new Font("Segoe UI", 0, 18));
        bAjouter.setForeground(new Color(255,255,255));
        bAjouter.setBackground(new Color(0, 102, 102));
        bAjouter.setBounds(30, 270, 50, 40);
        lP.add(bAjouter);
        bEnregistrer = new JButton("enregistrer ");
        bEnregistrer.setFont(new Font("Segoe UI", 0, 18));
        bEnregistrer.setBackground(new Color(0, 102, 102));
        bEnregistrer.setForeground(new Color(255,255,255));
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
        bSupprimer.setBackground(new Color(0, 102, 102));
        bSupprimer.setForeground(new Color(255,255,255));
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
        bFermer.setBackground(new Color(0, 102, 102));
        bFermer.setForeground(new Color(255,255,255));
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
        modelTable = new DefaultTableModel(new Object[][]{}, new String[]{"Id stock", "nom","qunatité de stock"});
        load();
        tableS= new JTable(modelTable);
        JScrollPane scrollPane = new JScrollPane(tableS);
        bModifier.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		try {
        			
                    String tnom1 =tnom.getText().trim();
                    String tstock1 =tstock.getText().trim();
                    String tqteS1 =tqteS.getText().trim();
                    if ( tnom1.length()==0  || tstock1.length()==0 || tqteS1.length()==0) {
                    	JOptionPane.showMessageDialog(null, "chaque donnée doit etre non null","title", JOptionPane.WARNING_MESSAGE);
                    }
                    else {
                    	stockC c = new stockC();
                    	c.modifier(new stock1(Integer.parseInt(tstock1),tnom1,Integer.parseInt(tqteS1)));
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
        			String tnom1 =tnom.getText().trim();
                    String tstock1 =tstock.getText().trim();
                    String tqteS1 =tqteS.getText().trim();
                    if (tnom1.length()==0  || tstock1.length()==0 || tqteS1.length()==0) {
                    	JOptionPane.showMessageDialog(null, "chaque donnée doit etre non null","title", JOptionPane.WARNING_MESSAGE);
                    }
                    else {
                    	stockC c = new stockC();
                    	c.ajout(new stock1(Integer.parseInt(tstock1),tnom1,Integer.parseInt(tqteS1)));
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
        			String tstock1 =tstock.getText().trim();
                    
                    if (tstock1.length()==0 ) {
                    	JOptionPane.showMessageDialog(null, "id stock doit etre non null","title", JOptionPane.WARNING_MESSAGE);
                    }
                    else {
                    	int choix = JOptionPane.showConfirmDialog(null, "Êtes-vous sûr de vouloir supprimer cette stock ?",
                                "Confirmation de suppression", JOptionPane.YES_NO_OPTION);
                    	if (choix == JOptionPane.YES_OPTION) {
                    	stockC c = new stockC();
                    	c.supprimer(Integer.parseInt(tstock1));
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
        this.add(lP);
        rP.setBounds(400, 0, 400, 500);
        this.add(rP);
        lP.setBounds(0, 0, 400, 500);
        
        this.setIconImage(new ImageIcon("pict.png").getImage());
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.pack();
        this.setLocationRelativeTo(null);
	}
	private void load() {
		try {
			modelTable.setRowCount(0);
			stockC c =new stockC();
			allS = c.lister();
			for (stock1 m : allS) {
                modelTable.addRow(new Object[]{m.getStock(), m.getNom(),m.getQteS() 
                         });
            }
		} catch (SQLException e) {
			 JOptionPane.showMessageDialog(null, e.getMessage(), "title", JOptionPane.ERROR_MESSAGE);
		} 
		
	}

}
