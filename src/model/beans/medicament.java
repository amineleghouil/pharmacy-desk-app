package model.beans;

public class medicament {
	
	private int id_medicament ;
    private String nom ;
    private int stock ;
    private double prix;
	public medicament(int id_medicament, String nom, int stock,double pprix) {
		this.id_medicament = id_medicament;
		this.nom = nom;
		this.stock = stock;
		this.prix=prix;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public int getId_medicament() {
		return id_medicament;
	}
	public void setId_medicament(int id_medicament) {
		this.id_medicament = id_medicament;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
    
}
