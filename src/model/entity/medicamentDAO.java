package model.entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.beans.medicament;


public class medicamentDAO {
	private static Connection connection;
	public medicamentDAO() {
		connection = connexion.getInstance();
	}
	public void ajouterMed(medicament med) throws SQLException {
		try {
		    String query = "INSERT INTO medicament VALUES (?, ?, ?)";
		    PreparedStatement statement = connection.prepareStatement(query);
		    statement.setInt(1, med.getId_medicament());
		    statement.setString(2, med.getNom());
		    statement.setInt(3, med.getStock());
		    statement.setDouble(4, med.getPrix());
		    statement.executeUpdate();
		} catch (SQLException e1) {
		    JOptionPane.showMessageDialog(null, "Error occurred while inserting data: " + e1.getMessage(),
		                                    "Database Error", JOptionPane.ERROR_MESSAGE);
		}
    }
	public void supprimerMed(int id) throws SQLException {
        String query = "DELETE FROM medicament WHERE id_med = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, id);
        statement.executeUpdate();
    }
	public void modifierMed(medicament med) throws SQLException {
        String query = "UPDATE medicament SET nom = ?, stock = ?,  prix= ? WHERE id_med = ?";
        PreparedStatement statement = connection.prepareStatement(query);
	    statement.setString(1, med.getNom());
	    statement.setInt(2, med.getStock());
	    statement.setDouble(3, med.getPrix());
	    statement.setInt(4, med.getId_medicament());
        statement.executeUpdate();
    }
	 public medicament trouverMed(int id) throws SQLException {
	        String query = "SELECT * FROM medicament WHERE id_med = ?";
	        PreparedStatement statement = connection.prepareStatement(query);
	        statement.setInt(1, id);
	        ResultSet resultSet = statement.executeQuery();
	        if (resultSet.next()) {
	            String nom = resultSet.getString("nom");
	            int stock = resultSet.getInt("stock");
	            double prix = resultSet.getDouble("prix");
	            
	            return new medicament(id, nom, stock, prix);
	        }
	        return null;
	    }
	 public List<medicament> listerMed() throws SQLException {
	        String query = "SELECT * FROM medicament";
	        Statement statement = connection.createStatement();
	        ResultSet resultSet = statement.executeQuery(query);
	        List<medicament> medicaments = new ArrayList<>();
	        while (resultSet.next()) {
	            int id = resultSet.getInt("Id_medicament");
	            String nom = resultSet.getString("nom");
	            int stock = resultSet.getInt("stock");
	            double prix = resultSet.getDouble("prix");
	            medicament medicamentn = new medicament(id, nom, stock, prix);
	            medicaments.add(medicamentn);
	        }
	        return medicaments;
	    }

}
