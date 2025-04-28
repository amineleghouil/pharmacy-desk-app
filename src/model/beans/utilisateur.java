package model.beans;

public class utilisateur {
	private int Id_user ;
	private String password ;
	private String nom ;
	private String prenom ;
	private String type ;
	public utilisateur(int id_user, String password, String nom, String prenom, String type) {
		super();
		Id_user = id_user;
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
		this.type = type;
	}
	public int getId_user() {
		return Id_user;
	}
	public void setId_user(int id_user) {
		Id_user = id_user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}	
}
