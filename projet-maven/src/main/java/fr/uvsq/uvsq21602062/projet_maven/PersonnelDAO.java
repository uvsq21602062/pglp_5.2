package fr.uvsq.uvsq21602062.projet_maven;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Classe implementant DAO suivant le patron de conception DAO.
 * @author jean
 *
 */
public class PersonnelDAO extends DAO<Personnel> {
	/**
	 * Constructeur de la classe
	 */
	public PersonnelDAO() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.conn = DriverManager.getConnection(this.urlConnexion, this.username, this.password);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Méthode permettant de trouver tous les elements
	 */
	public ArrayList<Personnel> toutObtenir() {
		ArrayList<Personnel> liste = new ArrayList<Personnel>();
		try {
			PreparedStatement p = this.conn.prepareStatement("select * from Personnel");
			ResultSet result = p.executeQuery();
			while(result.next()) {
				Personnel personnel = new Personnel
						.Builder(result.getString("nom"), result.getString("prenom"))
						.dateNaissance(LocalDate.parse(result.getString("dateNaissance")))
						.fonction(result.getString("fonction"))
						.numeroTel(result.getString("numeroTel"))
						.build();
				liste.add(personnel);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return liste;
	}
	
	/**
	 * Méthode permettant d'ajouter un element
	 */
	public void ajouter(Personnel obj) {
		try {
			PreparedStatement p = this.conn.prepareStatement("insert into Personnel values(?, ?, ?, ?, ?)");
			p.setString(1, obj.getNom());
			p.setString(2, obj.getPrenom());
			p.setString(3, obj.getDateNaissance().toString());
			p.setString(4, obj.getFonction());
			p.setString(5, obj.getNumeroTel());
			p.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
