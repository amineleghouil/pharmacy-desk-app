package model.entity;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Controller.OrdC;
import model.beans.ligne_ord;
import model.beans.ordonnance;

public class ordonanceDAO {
	private static Connection connection;
	public ordonanceDAO() {
		connection = connexion.getInstance();
	}
	public void ajouterOrd(ordonnance ordonnance1,ligne_ord c) throws SQLException {
		try {
			if(trouverOrd(ordonnance1.getId_ordonnance())==null) {
				String query = "INSERT INTO ordonnance VALUES (?, ?)";
				PreparedStatement statement = connection.prepareStatement(query);
				statement.setInt(1, ordonnance1.getIdclient());
			    statement.setInt(2, ordonnance1.getId_ordonnance());
			    statement.executeUpdate();
			}
		    String query1 = "INSERT INTO ligne_ord VALUES (?, ?, ?)";
		    PreparedStatement statement1 = connection.prepareStatement(query1);
		    statement1.setInt(1, c.getId_medicament());
		    statement1.setInt(2, c.getId_ordonnance());
		    statement1.setInt(3, c.getQuantité());
		    statement1.executeUpdate();
		} catch (SQLException e1) {
		    JOptionPane.showMessageDialog(null, "Error occurred while inserting data: " + e1.getMessage(),
		                                    "Database Error", JOptionPane.ERROR_MESSAGE);
		}
    }
	public void supprimerOrd(int id) throws SQLException {
        String query = "DELETE FROM ordonnance WHERE Id_ordonnance = ?";
        String query1 = "DELETE FROM ligne_ord WHERE Id_ordonnance = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        PreparedStatement statement1 = connection.prepareStatement(query1);
        statement.setInt(1, id);
        statement1.setInt(1, id);
        statement1.executeUpdate();
        statement.executeUpdate();
    }
	public void modifierOrd(ordonnance ordonnance1,ligne_ord c) throws SQLException {
        String query = "UPDATE clients SET id_client = ? WHERE Id_ordonnance = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, ordonnance1.getIdclient());
        statement.setInt(2, ordonnance1.getId_ordonnance());
        statement.executeUpdate();
        String query1 = "UPDATE ligne_ord SET Id_medicament = ? and Quantité = ? WHERE Id_ordonnance = ?";
	    PreparedStatement statement1 = connection.prepareStatement(query1);
	    statement1.setInt(1, c.getId_medicament());
	    statement1.setInt(2, c.getQuantité());
	    statement1.setInt(3, c.getId_ordonnance());
	    statement1.executeUpdate();
    }
	public ordonnance trouverOrd(int id) throws SQLException {
        String query = "SELECT * FROM ordonnance WHERE Id_ordonnance = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            int id_c = resultSet.getInt("idclient");
            
            return new ordonnance(id,id_c);
        }
        return null;
    }
	public static List<OrdC> listerOrdonnances() throws SQLException {
	    String query = "SELECT * FROM ordonnance O, ligne_ord L WHERE L.Id_ordonnance = O.Id_ordonnance";
	    Statement statement = connection.createStatement();
	    ResultSet resultSet = statement.executeQuery(query);
	    List<OrdC> ordonnances = new ArrayList<>();
	    while (resultSet.next()) {
	        int idMedicament = resultSet.getInt("id_medicament");
	        int idClient = resultSet.getInt("id_client");
	        int quantite = resultSet.getInt("quantite");
	        int Id_ordonnance = resultSet.getInt("Id_ordonnance");
	        OrdC ordonnance = new OrdC(Id_ordonnance, idClient, idMedicament ,quantite);
	        ordonnances.add(ordonnance);
	    }
	    return ordonnances;
	}

}
