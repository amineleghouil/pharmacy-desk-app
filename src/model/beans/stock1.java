package model.beans;

public class stock1 {
	private int stock;
	private String nom ;
	private int QteS;
	public stock1(int stock, String nom, int qteS) {
		this.stock = stock;
		this.nom = nom;
		QteS = qteS;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getQteS() {
		return QteS;
	}
	public void setQteS(int qteS) {
		QteS = qteS;
	}
	

}

