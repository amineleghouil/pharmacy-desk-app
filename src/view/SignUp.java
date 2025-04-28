package view;

import javax.swing.*;

import Controller.SignUpC;
import Controller.loginC;
import model.beans.utilisateur;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

public class SignUp extends JFrame {

    private JPanel sPanel;
    private JLabel tLabel;
    private JLabel nLabel;
    private JTextField nT;
    private JLabel npLabel;
    private JTextField npT;
    private JLabel id;
    private JTextField idT;
    private JLabel passwordL;
    private JPasswordField passwordF;
    private JButton signB;
    private JLabel loginL;
    private JLabel typeLabel;
    private JTextField type;

    public SignUp() {
   
        this.setTitle("SIGN UP");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(440, 640)); 
        this.setLayout(null);
        this.setIconImage(new ImageIcon("pict.png").getImage());

        sPanel = new JPanel();
        sPanel.setBackground(new Color(255, 255, 255));
        sPanel.setLayout(null);

        tLabel = new JLabel("SIGN UP");
        tLabel.setFont(new Font("Segoe UI", 1, 36));
        tLabel.setForeground(new Color(0, 102, 102));
        tLabel.setBounds(140, 50, 150, 50);
        sPanel.add(tLabel);

        nLabel = new JLabel("nom");
        nLabel.setFont(new Font("Segoe UI", 0, 10));
        nLabel.setBounds(30, 120, 100, 20);
        sPanel.add(nLabel);

        nT = new JTextField();
        nT.setFont(new Font("Segoe UI", 0, 10));
        nT.setBounds(30, 150, 300, 40);
        sPanel.add(nT);
       
        npLabel = new JLabel("prenom");
        npLabel.setFont(new Font("Segoe UI", 0, 10));
        npLabel.setBounds(30, 200, 100, 20); 
        sPanel.add(npLabel);

        npT = new JTextField();
        npT.setFont(new Font("Segoe UI", 0, 10));
        npT.setBounds(30, 230, 300, 40); 
        sPanel.add(npT);

        typeLabel = new JLabel("type");
        typeLabel.setFont(new Font("Segoe UI", 0, 10));
        typeLabel.setBounds(30, 280, 100, 20); 
        sPanel.add(typeLabel);

        type = new JTextField();
        type.setFont(new Font("Segoe UI", 0, 10));
        type.setBounds(30, 310, 300, 40); 
        sPanel.add(type);
        
        id = new JLabel("ID");
        id.setFont(new Font("Segoe UI", 0, 11));
        id.setBounds(30, 360, 100, 20);
        sPanel.add(id);

        idT = new JTextField();
        idT.setFont(new Font("Segoe UI", 0, 10));
        idT.setBounds(30, 390, 300, 40);
        sPanel.add(idT);

        passwordL = new JLabel("Password");
        passwordL.setFont(new Font("Segoe UI", 0, 10));
        passwordL.setBounds(30, 440, 100, 20);
        sPanel.add(passwordL);

        passwordF = new JPasswordField();
        passwordF.setFont(new Font("Segoe UI", 0, 10));
        passwordF.setBounds(30, 470, 300, 40);
        sPanel.add(passwordF);

        signB = new JButton("Sign Up");
        signB.setBackground(new java.awt.Color(0, 102, 102));
        signB.setFont(new Font("Segoe UI", 0, 10));
        signB.setForeground(new Color(255, 255, 255));
        signB.setBounds(30, 520, 150, 36);
        sPanel.add(signB);
        signB.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		try {
        			String nom = nT.getText();
        			String prenom = npT.getText();
        			String type1 = type.getText();
        			String id = idT.getText();
                    String password = new String(passwordF.getPassword());
                    if (id.length()==0 || password.length()==0 || nom.length()==0 || type1.length()==0 || prenom.length()==0 ) {
                    	JOptionPane.showMessageDialog(null, "all data must not be null",null,JOptionPane.ERROR_MESSAGE);
                    }
                    else if(!(type1.toUpperCase().equals("PHARMACIEN")) && !(type1.toUpperCase().equals("ADMIN"))) {
                    	JOptionPane.showMessageDialog(null, "type must be pharmacien or admin",null,JOptionPane.WARNING_MESSAGE);
                    }
                    else {
                    	int l = Integer.parseInt(id);
                    	
                    	utilisateur user = new utilisateur(l,password,nom,prenom,type1);
                    	SignUpC s = new SignUpC(user);
                    	
                    	if(s.ajout()) {
                    		JOptionPane.showMessageDialog(null, "your account has been created successfully","title",JOptionPane.INFORMATION_MESSAGE);
                    	}
                    	else{
                    		JOptionPane.showMessageDialog(null, " your account are already exist ","title",JOptionPane.WARNING_MESSAGE);
                    	}
     
          
                    }
        		} catch (NumberFormatException | HeadlessException | SQLException e1) {
        			if (e1 instanceof NumberFormatException) {
        			    JOptionPane.showMessageDialog(null, "id must be a number", "title", JOptionPane.ERROR_MESSAGE);
        			}
        			else {
        				JOptionPane.showMessageDialog(null, "there is a problem in your data", "title", JOptionPane.ERROR_MESSAGE);
        			}
        		}
        		
            }
        });
        loginL = new JLabel("Already have an account? Login");
        loginL.setBounds(30, 570, 200, 20);
        loginL.setForeground(new Color(0, 0, 255));
        sPanel.add(loginL);

        loginL.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
            	Login login = new Login();
                dispose();
            }
        });
        this.add(sPanel);
        sPanel.setBounds(0, 0, 440, 640); 
        this.setVisible(true);
        this.pack();
        this.setLocationRelativeTo(null);
    }

}
