package view;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;
import Controller.loginC;

public class Login extends JFrame {

    private JPanel lP;
    private JPanel rP;
    private JLabel tL;
    private JLabel id;
    private JTextField idt;
    private JLabel passwordL;
    private JPasswordField passwordF;
    private JLabel signL;
    private JButton signB;
    private JLabel php;
    private JLabel phn;
    private JLabel copyright;
    private JButton lb;

    public Login() {
        
    

        this.setTitle("LOGIN");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(800, 500));
        this.setLayout(null);

        lP = new JPanel();
        lP.setBackground(new Color(255, 255, 255));
        lP.setPreferredSize(new Dimension(400, 500));
        lP.setLayout(null);

        tL = new JLabel("LOGIN");
        tL.setFont(new Font("Segoe UI", Font.BOLD, 36));
        tL.setForeground(new Color(0, 102, 102));
        tL.setBounds(138, 51, 200, 50);
        lP.add(tL);

        id = new JLabel("ID");
        id.setFont(new Font("Segoe UI", 0, 14));
        id.setBounds(30, 150, 100, 20);
        lP.add(id);

        idt = new JTextField();
        idt.setFont(new Font("Segoe UI", 0, 14));
        idt.setBounds(30, 180, 343, 40);
        lP.add(idt);

        passwordL = new JLabel("Password");
        passwordL.setFont(new Font("Segoe UI", 0, 14));
        passwordL.setBounds(30, 240, 100, 20);
        lP.add(passwordL);

        passwordF = new JPasswordField();
        passwordF.setFont(new Font("Segoe UI", 0, 14));
        passwordF.setBounds(30, 270, 343, 40);
        lP.add(passwordF);

        lb = new JButton("Login");
        lb.setBackground(new Color(0, 102, 102));
        lb.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lb.setForeground(new Color(255, 255, 255));
        lb.setBounds(30, 330, 93, 36);
        lP.add(lb);
        lb.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		try {
        			String login = idt.getText();
                    String password = new String(passwordF.getPassword());
                    if (login.length()==0 || password.length()==0 ) {
                    	JOptionPane.showMessageDialog(null, "username or password must not be null","title",JOptionPane.ERROR_MESSAGE);
                    }
                    else {
                    	int l = Integer.parseInt(login);
                    	loginC loginc = new loginC(l,password);
                    	if(loginc.getType().equals("erro1")) {
                    		JOptionPane.showMessageDialog(null, "you don't have an account","title",JOptionPane.ERROR_MESSAGE);
                    	}
                    	if(loginc.getType().equals("erro2")){
                    		JOptionPane.showMessageDialog(null, "password incorrect ","title",JOptionPane.ERROR_MESSAGE);
                    	}
                    	if(loginc.getType().equals("PHARMACIEN")){
                    		pharmacienGUI pharmacienGUIFrame = new pharmacienGUI();
                            dispose();
                    		
                    	}
                    	if(loginc.getType().equals("ADMIN")){
                    		adminGUI adminGUIFrame = new adminGUI();
                            dispose();
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
        signL = new JLabel("I don't have an account");
        signL.setBounds(30, 400, 150, 20);
        lP.add(signL);

        signB = new JButton("Sign Up");
        signB.setFont(new Font("Segoe UI", Font.BOLD, 14));
        signB.setForeground(new Color(255, 255, 255));
        signB.setBounds(180, 400, 93, 36);
        signB.setBackground(new Color(0, 102, 102));
        lP.add(signB);
        signB.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		SignUp SignUpFrame = new SignUp();
                dispose();
            }
        });
        rP = new JPanel();
        rP.setBackground(new Color(0, 102, 102));
        rP.setPreferredSize(new Dimension(400, 500));
        rP.setLayout(null);
        
        php = new JLabel(new ImageIcon("pic.png"));
        php.setBounds(103, 136, 200, 200);
        rP.add(php);

        phn = new JLabel("ISIMG Pharmacy");
        phn.setFont(new Font("Showcard Gothic", 0, 22));
        phn.setForeground(new Color(255, 255, 255));
        phn.setBounds(103, 350, 200, 50);
        rP.add(phn);

        copyright = new JLabel("copyright © ISIMG Pharmacy All rights reserved");
        copyright.setFont(new Font("Segoe UI Light", 0, 14));
        copyright.setForeground(new Color(204, 204, 204));
        copyright.setBounds(81, 430, 350, 20);
        rP.add(copyright);
        
        this.add(lP);
        lP.setBounds(0, 0, 400, 500);
        this.add(rP);
        rP.setBounds(400, 0, 400, 500);
        this.setIconImage(new ImageIcon("pict.png").getImage());
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        
    }

    
}
