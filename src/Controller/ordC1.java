package Controller;



import java.sql.SQLException;

import model.beans.ligne_ord;
import model.beans.ordonnance;
import model.entity.ordonanceDAO;

public class ordC1 {
	ordonanceDAO v;
	public ordC1() {
		v= new ordonanceDAO();
		}
	public void insert(ordonnance c,ligne_ord l) throws SQLException {
		v.ajouterOrd(c, l);
		}	
	public void modifier(ordonnance c,ligne_ord l) throws SQLException {
		v.modifierOrd(c, l);
		}	
	public void supprimer(int id) throws SQLException {
		v.supprimerOrd(id);
		}	
}
