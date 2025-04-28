package model.beans;

public class ordonnance {
	private int Id_ordonnance ;
    private int Idclient ;
	public ordonnance(int id_ordonnance, int idclient) {
		super();
		Id_ordonnance = id_ordonnance;
		Idclient = idclient;
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
    
}
