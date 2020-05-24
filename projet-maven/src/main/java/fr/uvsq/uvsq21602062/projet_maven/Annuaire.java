package fr.uvsq.uvsq21602062.projet_maven;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Classe représentant l'annuaire de l'organisation.
 * @author jean
 *
 */
public class Annuaire implements Serializable{
	private static final long serialVersionUID = 1L;

	/**
	 * Attribut liste stockant les groupes d'employé par leur hierarchie.
	 */
	private ArrayList<CompositePersonnel> listeGroupeHierarchie;
	
	/**
	 * Attribut liste stockant les groupes d'employé par leur fonction.
	 */
	private ArrayList<CompositePersonnel> listeGroupeFonction;

	/**
	 * Constructeur
	 */
	public Annuaire() {
		this.listeGroupeFonction = new ArrayList<CompositePersonnel>();
		this.listeGroupeHierarchie = new ArrayList<CompositePersonnel>();
	}
	
	/**
	 * Méthode permettant d'ajouter un personnel dans les liste en indiquant son niveau de hierarchie
	 */
	public void ajouter(Personnel p, int niveau) {
		// Ajout dans la liste groupé par hierarchie
		try {
			this.listeGroupeHierarchie.get(niveau).ajouter(p);
		}
		catch(IndexOutOfBoundsException e) {
			CompositePersonnel nouveauGroupe = new CompositePersonnel();
			nouveauGroupe.ajouter(p);
			this.listeGroupeHierarchie.add(nouveauGroupe);
		}
		// Ajout dans la liste groupé par fonction
		boolean succes = false;
		for (int i = 0; i<this.listeGroupeFonction.size() && !succes; i++) {
			if(this.listeGroupeFonction.get(i).obtenir().getFonction().equals(p.getFonction())) {
				this.listeGroupeFonction.get(i).ajouter(p);
				succes = true;
			}
		}
		if(!succes) {
			CompositePersonnel nouveauGroupe = new CompositePersonnel();
			nouveauGroupe.ajouter(p);
			this.listeGroupeFonction.add(nouveauGroupe);
		}
		
	}
	
	/**
	 * Get des listes
	 * @return
	 */
	public ArrayList<CompositePersonnel> getListGroupeHierarchie(){
		return listeGroupeHierarchie;
	}
	public ArrayList<CompositePersonnel> getListGroupeFonction(){
		return listeGroupeFonction;
	}
	
	/**
	 * Méthode permettant d'afficher les personnels groupés par leur fonction
	 */
	public void afficherParFonction() {
		CompositePersonnel compoP;
		for(Iterator<CompositePersonnel> i = this.listeGroupeFonction.iterator(); i.hasNext();) {
			compoP = i.next();
			compoP.afficher();
			System.out.println();
		}
	}
	
	/**
	 * Méthode permettant d'afficher les personnels groupés par leur hierarchie
	 */
	public void afficherParHierarchie() {
		CompositePersonnel compoP;
		for(Iterator<CompositePersonnel> i = this.listeGroupeHierarchie.iterator(); i.hasNext();) {
			compoP = i.next();
			compoP.afficher();
			System.out.println();
		}
	}
}
