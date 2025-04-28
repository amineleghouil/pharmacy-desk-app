package model.entity;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import model.beans.client;


public class clientDAO {
	private static Connection connection;
	public clientDAO() {
		connection = connexion.getInstance();
	}
	public void ajouterClient(client client) throws SQLException {
		try {
		    String query = "INSERT INTO clients VALUES (?, ?, ?, ?)";
		    PreparedStatement statement = connection.prepareStatement(query);
		    statement.setInt(1, client.getIdclient());
		    statement.setString(2, client.getNom());
		    statement.setString(3, client.getPrenom());
		    statement.setDouble(4, client.getCredit());
		    statement.executeUpdate();
		} catch (SQLException e1) {
		    JOptionPane.showMessageDialog(null, "Error occurred while inserting data: " + e1.getMessage(),
		                                    "Database Error", JOptionPane.ERROR_MESSAGE);
		}
    }
	public void supprimerClient(int id) throws SQLException {
        String query = "DELETE FROM clients WHERE id_client = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, id);
        statement.executeUpdate();
    }
	public void modifierClient(client client) throws SQLException {
        String query = "UPDATE clients SET nom = ?, prenom = ?,  credit = ? WHERE id_client = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, client.getNom());
        statement.setString(2, client.getPrenom());
        statement.setDouble(3, client.getCredit());
        statement.setInt(4, client.getIdclient());
        statement.executeUpdate();
    }
	 public client trouverClient(int id) throws SQLException {
	        String query = "SELECT * FROM clients WHERE id_client = ?";
	        PreparedStatement statement = connection.prepareStatement(query);
	        statement.setInt(1, id);
	        ResultSet resultSet = statement.executeQuery();
	        if (resultSet.next()) {
	            String nom = resultSet.getString("nom");
	            String prenom = resultSet.getString("prenom");
	            double credit = resultSet.getDouble("credit");
	            
	            return new client(id, nom, prenom, credit);
	        }
	        return null;
	    }
	 public List<client> listerClients() throws SQLException {
	        String query = "SELECT * FROM clients";
	        Statement statement = connection.createStatement();
	        ResultSet resultSet = statement.executeQuery(query);
	        List<client> clients = new ArrayList<>();
	        while (resultSet.next()) {
	            int id = resultSet.getInt("idclient");
	            String nom = resultSet.getString("nom");
	            String prenom = resultSet.getString("prenom");
	            double credit = resultSet.getDouble("credit");
	            client clientN = new client(id, nom, prenom, credit);;
	            clients.add(clientN);
	        }
	        return clients;
	    }

}
