package Controller;

public class OrdC {
	private int Id_ordonnance ;
	private int Idclient ;
	private int id_medicament ;
	private int quantité ;
	public OrdC(int id_ordonnance, int idclient, int id_medicament, int quantité) {
		Id_ordonnance = id_ordonnance;
		Idclient = idclient;
		this.id_medicament = id_medicament;
		this.quantité = quantité;
	}
	public int getId_ordonnance() {
		return Id_ordonnance;
	}
	public void setId_ordonnance(int id_ordonnance) {
		Id_ordonnance = id_ordonnance;
	}
	public int getIdclient() {
		return Idclient;
	}
	public void setIdclient(int idclient) {
		Idclient = idclient;
	}
	public int getId_medicament() {
		return id_medicament;
	}
	public void setId_medicament(int id_medicament) {
		this.id_medicament = id_medicament;
	}
	public int getQuantité() {
		return quantité;
	}
	public void setQuantité(int quantité) {
		this.quantité = quantité;
	}
	

}
