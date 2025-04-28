package model.entity;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import javax.swing.*;
public class connexion {
	Properties props=new Properties();
	private static String user;
	private static String password;
	private static String url;
	private static Connection connect;
	private connexion(){
	try {
			
			props.load(new FileInputStream("conf.properties"));
			url=props.getProperty("jdbc.url");
			user=props.getProperty("jdbc.user");
			password=props.getProperty("jdbc.password");
			connect = DriverManager.getConnection(url, user, password);
		    
			} 
			catch (SQLException e)
		{ 	
			JOptionPane.showMessageDialog(null, "DATA ACCESS ERROR","Error 404",JOptionPane.WARNING_MESSAGE);
			
			}
		catch(IOException e)
		{
			JOptionPane.showMessageDialog(null, "FILE ACCESS ERROR","Error 404",JOptionPane.WARNING_MESSAGE);
			}
		}
		public static Connection getInstance(){
			if(connect == null){
				new connexion();
			}
			return connect;
		}

}
