package fr.uvsq.uvsq21602062.projet_maven;

import java.util.ArrayList;

/**
 * Interface implementant le patron de conception DAO.
 * @author jean
 *
 */
public interface DAO<T>{
	/**
	 * Méthode permettant de trouver tous les elements
	 */
	public ArrayList<T> toutObtenir();
	
	/**
	 * Méthode permettant d'ajouter un element
	 */
	public void ajouter(T obj);
}
