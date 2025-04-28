package model.entity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.beans.stock1;

public class stockDAO {
	private static Connection connection;
	public stockDAO() {
		connection = connexion.getInstance();
	}
	public void ajouterStock(stock1 stock) throws SQLException {
		try {
		    String query = "INSERT INTO stock1 VALUES (?, ?, ?)";
		    PreparedStatement statement = connection.prepareStatement(query);
		    statement.setInt(1, stock.getStock());
		    statement.setString(2, stock.getNom());
		    statement.setInt(3, stock.getQteS());
		    statement.executeUpdate();
		} catch (SQLException e1) {
		    JOptionPane.showMessageDialog(null, "Error occurred while inserting data: " + e1.getMessage(),
		                                    "Database Error", JOptionPane.ERROR_MESSAGE);
		}
    }
	public void supprimerStock(int id) throws SQLException {
        String query = "DELETE FROM stock1 WHERE stock = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, id);
        statement.executeUpdate();
    }
	public void modifierClient(stock1 stock) throws SQLException {
        String query = "UPDATE stock1 SET nom = ?, QteS = ? WHERE stock = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, stock.getNom());
        statement.setInt(2, stock.getQteS());
        statement.setInt(3, stock.getStock());
        statement.executeUpdate();
    }
	public List<stock1> lister() throws SQLException {
        String query = "SELECT * FROM stock1";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        List<stock1> stock2 = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("stock");
            String nom = resultSet.getString("nom");
            int QteS = resultSet.getInt("QteS");
            stock1 stock = new stock1(id, nom,QteS);;
            stock2.add(stock);
        }
        return stock2;
    }

}
