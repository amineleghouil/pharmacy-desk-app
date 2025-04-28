package model.entity;
import java.sql.*;

import javax.swing.JOptionPane;

import model.beans.utilisateur;



public class UtilisateurDAO {
	private static Connection connection;

    public UtilisateurDAO() throws SQLException {
        connection = connexion.getInstance();
    }
    public void ajoutUser(utilisateur user) throws SQLException {
        try {String query = "INSERT INTO utilisateur VALUES (? , ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, user.getId_user());
        statement.setString(2, user.getPassword());
        statement.setString(3, user.getNom());
        statement.setString(4, user.getPrenom());
        statement.setString(5, user.getType());
        statement.executeUpdate();}
        catch (SQLException e1) {
		    JOptionPane.showMessageDialog(null, "Error occurred while inserting data: " + e1.getMessage(),
		                                    "Database Error", JOptionPane.ERROR_MESSAGE);
		}
    }
    public utilisateur trouveUser(int id) throws SQLException {
        String query = "SELECT * FROM utilisateur WHERE id_user = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
        	String password = resultSet.getString("password1");
            String nom = resultSet.getString("nom");
            String prenom = resultSet.getString("prenom");
            String type = resultSet.getString("type1");
            return new utilisateur(id, password , nom, prenom,type);
        }
        return null;
    }
    

}
