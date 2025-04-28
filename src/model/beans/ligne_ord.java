package model.beans;

public class ligne_ord {
	private int id_medicament ;
    private int Id_ordonnance ;
    private int quantité ;
	public ligne_ord(int id_medicament, int id_ordonnance, int quantité) {
		super();
		this.id_medicament = id_medicament;
		Id_ordonnance = id_ordonnance;
		this.quantité = quantité;
	}
	public int getId_medicament() {
		return id_medicament;
	}
	public void setId_medicament(int id_medicament) {
		this.id_medicament = id_medicament;
	}
	public int getId_ordonnance() {
		return Id_ordonnance;
	}
	public void setId_ordonnance(int id_ordonnance) {
		Id_ordonnance = id_ordonnance;
	}
	public int getQuantité() {
		return quantité;
	}
	public void setQuantité(int quantité) {
		this.quantité = quantité;
	}
    

}
