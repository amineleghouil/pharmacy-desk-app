package Controller;

import java.sql.SQLException;

import model.beans.utilisateur;
import model.entity.UtilisateurDAO;

public class loginC {
	private int id;
	private String password;
	public loginC(int id, String password) {
		this.id = id;
		this.password = password;
	}
	public String getType() throws SQLException{
		UtilisateurDAO userD = new UtilisateurDAO();
		utilisateur user;
		user=userD.trouveUser(id);
		if (user==null ) {
			return "error1";
		}
		if(!password.equals(user.getPassword())){
			return "error2";
		}
		return user.getType().toUpperCase();
		
	}
	
}
