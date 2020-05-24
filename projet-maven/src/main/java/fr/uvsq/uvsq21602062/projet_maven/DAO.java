package fr.uvsq.uvsq21602062.projet_maven;

import java.sql.Connection;
import java.util.ArrayList;

/**
 * Interface implementant le patron de conception DAO.
 * @author jean
 *
 */
public abstract class DAO<T>{
	/**
	 * Attribut stockant le nom de l'utilisateur de la bdd
	*/
	protected String username = "jdbc-user";
	
	/**
	 * Attribut stockant le mdp de l'utilisateur
	 */
	protected String password = "1234";

	/**
	 * Attribut stockant l'url de connexion à la bdd
	 */
	protected String urlConnexion = "jdbc:mysql://localhost:3306/Annuaire?useUnicode=true&characterEncoding=utf8&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";
	
	/**
	 * Attribut stockant la connexion à la bdd
	 */
	protected Connection conn;
	
	/**
	 * Méthode permettant de trouver tous les elements
	 */
	public abstract ArrayList<T> toutObtenir();
	
	/**
	 * Méthode permettant d'ajouter un element
	 */
	public abstract void ajouter(T obj);
}
