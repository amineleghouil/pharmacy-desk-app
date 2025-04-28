package view;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.*;
import Controller.OrdC;
import Controller.ordC1;
import model.beans.ligne_ord;
import model.beans.ordonnance;
import model.entity.ordonanceDAO;

import javax.swing.table.DefaultTableModel;
public class gestionOrd extends JFrame{
	private JPanel lP;
    private JPanel rP;
    private JButton bAjouter;
    private JButton bEnregistrer;
    private JButton bSupprimer;
    private JButton bFermer;
    private JButton bModifier;
    private JTextField tido;
    private JTextField tidm;
    private JTextField tqt;
    private JTextField tidc;
    private JLabel b;
    private JLabel ido;
    private JLabel idm;
    private JLabel qt;
    private JLabel idc;
    private DefaultTableModel modelTable;
    private JTable tableOrd;
    private List<OrdC> allOrd;
	public gestionOrd() {
		this.setTitle("Gestion d'ordonnance ");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(800, 540));
        this.setLayout(null);
        lP = new JPanel();
        lP.setLayout(new GridLayout(0,2,15,15));
        b = new JLabel("Gestion d'ordonnance");
        b.setFont(new Font("Segoe UI", Font.BOLD, 18));
        b.setForeground(new Color(0, 102, 102));
        lP.add(b);
        JLabel n11=new JLabel("\n");
        lP.add(n11);
        JLabel n12=new JLabel("\n");
        lP.add(n12);
        JLabel n13=new JLabel("\n");
        lP.add(n13);
        ido = new JLabel("ID d'ordonnance");
        lP.add(ido);
        tido = new JTextField();
        lP.add(tido);
        idc = new JLabel("ID de client");
        lP.add(idc);
        tidc = new JTextField();
        lP.add(tidc);
        idm = new JLabel("ID de medicament");
        lP.add(idm);
        tidm = new JTextField();
        lP.add(tidm);
        qt = new JLabel("Quantité");
        lP.add(qt);
        tqt = new JTextField();
        lP.add(tqt);
        
        bAjouter = new JButton("ajouter ");
        bAjouter.setFont(new Font("Segoe UI", 0, 18));
        bAjouter.setBackground(new Color(0, 102, 102));
        bAjouter.setForeground(new Color(255,255,255));
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
        bFermer.setForeground(new Color(0,0,0));
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
        modelTable = new DefaultTableModel(new Object[][]{}, new String[]{"Id ordonnance", "Id client","Id medicament","quantité"});
        load();    
        tableOrd = new JTable(modelTable);
        JScrollPane scrollPane = new JScrollPane(tableOrd);
        bModifier.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		try {
        			String tido1 =tido.getText().trim();
                    String tidc1 =tidc.getText().trim();
                    String tidm1 =tidm.getText().trim();
                    String qt1 =tqt.getText().trim();
                    if (tido1.length()==0 || tidc1.length()==0  || tidm1.length()==0 || qt1.length()==0) {
                    	JOptionPane.showMessageDialog(null, "chaque donnée doit etre non null","title", JOptionPane.WARNING_MESSAGE);
                    }
                    else {
                    	ordC1 c = new ordC1();
                    	c.modifier(new ordonnance(Integer.parseInt(tido1),Integer.parseInt(tidc1)), new ligne_ord (Integer.parseInt(tidm1),Integer.parseInt(tido1),Integer.parseInt(qt1)));
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
        			String tido1 =tido.getText().trim();
                    String tidc1 =tidc.getText().trim();
                    String tidm1 =tidm.getText().trim();
                    String qt1 =tqt.getText().trim();
                    if (tido1.length()==0 || tidc1.length()==0  || tidm1.length()==0 || qt1.length()==0) {
                    	JOptionPane.showMessageDialog(null, "chaque donnée doit etre non null","title", JOptionPane.WARNING_MESSAGE);
                    }
                    else {
                    	ordC1 c = new ordC1();
                    	c.insert(new ordonnance(Integer.parseInt(tido1),Integer.parseInt(tidc1)), new ligne_ord (Integer.parseInt(tidm1),Integer.parseInt(tido1),Integer.parseInt(qt1)));
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
        			String tido1 =tido.getText().trim();
                    if (tido1.length()==0 ) {
                    	JOptionPane.showMessageDialog(null, "id d'ordonnance doit etre non null","title", JOptionPane.WARNING_MESSAGE);
                    }
                    else {
                    	int choix = JOptionPane.showConfirmDialog(null, "Êtes-vous sûr de vouloir supprimer cette ordonnance  ?",
                                "Confirmation de suppression", JOptionPane.YES_NO_OPTION);
                    	if (choix == JOptionPane.YES_OPTION) {
                    	ordC1 c = new ordC1();
                    	c.supprimer(Integer.parseInt(tido1));
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
	public void load(){
		try {
			modelTable.setRowCount(0);
        	ordonanceDAO c = new ordonanceDAO();
			allOrd = c.listerOrdonnances();
			for (OrdC ord : allOrd) {
                modelTable.addRow(new Object[]{ord.getId_ordonnance(), ord.getIdclient(), ord.getId_medicament(),
                		ord.getQuantité()});
            }
		} catch (SQLException e) {
			 JOptionPane.showMessageDialog(null, e.getMessage(), "title", JOptionPane.ERROR_MESSAGE);
		}
	}

}
