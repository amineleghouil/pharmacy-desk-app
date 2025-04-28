package model.beans;

public class client {
	private int Idclient ;
    private String nom ;
    private String prenom ;
    private double credit ;
	public client(int idclient, String nom, String prenom, double credit) {
		Idclient = idclient;
		this.nom = nom;
		this.prenom = prenom;
		this.credit = credit;
	}
	public int getIdclient() {
		return Idclient;
	}
	public void setIdclient(int idclient) {
		Idclient = idclient;
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
	public double getCredit() {
		return credit;
	}
	public void setCredit(double credit) {
		this.credit = credit;
	}
	

}
