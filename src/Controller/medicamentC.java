package Controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.beans.client;
import model.beans.medicament;
import model.entity.medicamentDAO;


public class medicamentC {
	medicamentDAO d;
	public medicamentC() {
		d = new medicamentDAO();
	}
	public List<medicament> lister() throws SQLException{
        return d.listerMed();
	}
	public List<medicament> filter(List<medicament> l, String nom ) throws SQLException{
		List<medicament> medicaments = new ArrayList<>();
        for (medicament medicament1 : l) {
        	 if (medicament1.getNom().toLowerCase().contains(nom.toLowerCase())) {
        		 medicaments.add(medicament1);
             }
         }
         return medicaments;
        	
        }
	public void modifier (medicament m) throws SQLException {
		d.modifierMed(m);
		
	}
	public void ajout (medicament m) throws SQLException {
		d.ajouterMed(m);
		
	}
	public void supprimer (int id) throws SQLException {
		d.supprimerMed(id);
		
	}
	

}
