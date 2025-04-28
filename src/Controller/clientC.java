package Controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.beans.client;
import model.entity.clientDAO;

public class clientC {
	clientDAO d;
	public clientC() {
		d= new clientDAO();
	}
	public List<client> lister() throws SQLException{
        return d.listerClients();
	}
	public List<client> filter(List<client> l, String nom , String prenom) throws SQLException{
		List<client> Clients = new ArrayList<>();
        for (client client : l) {
        	 if (client.getNom().toLowerCase().contains(nom.toLowerCase()) || client.getPrenom().toLowerCase().contains(prenom.toLowerCase())) {
                 Clients.add(client);
             }
         }
         return Clients;
        	
        }
	public void modifier(client c) throws SQLException{
        d.modifierClient(c);
	}
	public void ajout(client c) throws SQLException{
        d.ajouterClient(c);
	}
	public void supprimer(int id) throws SQLException{
        d.supprimerClient(id);
	}
}


