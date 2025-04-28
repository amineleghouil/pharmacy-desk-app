package Controller;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.beans.client;
import model.beans.stock1;
import model.entity.clientDAO;
import model.entity.stockDAO;
public class stockC {
	stockDAO d ;
	public stockC() {
		d = new stockDAO();
	}
	public List<stock1> lister() throws SQLException{
        return d.lister();
	}
	public void modifier(stock1 c) throws SQLException{
        d.modifierClient(c);
	}
	public void ajout(stock1 c) throws SQLException{
        d.ajouterStock(c);
	}
	public void supprimer(int id) throws SQLException{
        d.supprimerStock(id);
	}

}
