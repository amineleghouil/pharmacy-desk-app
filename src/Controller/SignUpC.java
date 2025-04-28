package Controller;

import java.sql.SQLException;

import model.beans.utilisateur;
import model.entity.UtilisateurDAO;

public class SignUpC {
	private utilisateur user;

	public SignUpC(utilisateur user) {
		this.user = user;
	}
	public boolean ajout() throws SQLException {
		UtilisateurDAO a = new UtilisateurDAO();
		if(a.trouveUser(user.getId_user())!=null) {
			return false;
		}
		a.ajoutUser(user);
		return true;
		
	}
	
	
	
}
