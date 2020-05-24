package fr.uvsq.uvsq21602062.projet_maven;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Classe utilisant le patern de conception Composite
 * pour materialiser un groupe de personnel.
 * @author jean
 *
 */
public class CompositePersonnel implements Serializable{
	private static final long serialVersionUID = 1L;
	/**
	 * Collection de Personnel
	 */
	ArrayList<Personnel> listePersonnel;
	
	/**
	 * Constructeur
	 */
	public CompositePersonnel() {
		this.listePersonnel = new ArrayList<Personnel>();
	}
	
	/**
	 * Méthode s'occuppant de l'ajout
	 */
	public void ajouter(Personnel p) {
		this.listePersonnel.add(p);
	}
	
	/**
	 * Méthode permettant d'obtenir un Personnel par son nom et son prénom
	 */
	public Personnel obtenir(String nom, String prenom) {
		for(int i = 0; i < this.listePersonnel.size(); i++) {
			if(this.listePersonnel.get(i).getNom() == nom && this.listePersonnel.get(i).getPrenom() == prenom)
				return this.listePersonnel.get(i);
		}
		return null;
	}
	
	/**
	 * Méthode permettant d'obtenir le premier Personnel de la liste
	 */
	public Personnel obtenir() {
		if(this.listePersonnel.size() == 0)
			return null;
		else
			return this.listePersonnel.get(0);
	}
	
	/**
	 * Méthode permettant d'afficher les personnels
	 */
	public void afficher() {
		Personnel p;
		for(Iterator<Personnel> i = this.listePersonnel.iterator(); i.hasNext();) {
			p = i.next();
			p.afficher();
		}
	}
}
