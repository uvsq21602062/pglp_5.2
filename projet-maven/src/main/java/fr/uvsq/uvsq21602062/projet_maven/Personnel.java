package fr.uvsq.uvsq21602062.projet_maven;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Classe immuable représentant un personnel
 * @author jean
 *
 */
public final class Personnel implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * Attribut contenant le nom
	 */
	private final String nom;
	
	/**
	 * Attribut contenant le prénom
	 */
	private final String prenom;
	
	/**
	 * Attribut contenant la fonction
	 */
	private final String fonction;
	
	/**
	 * Attribut contenant la date de naissance
	 */
	private final LocalDate dateNaissance;
	
	/**
	 * Attribut contenant les numeros de téléphone
	 */
	private final String numeroTel;
	
	/**
	 * Classe Builder
	 */
	public static class Builder {
		/**
		 * Contient les mêmes attributs que Personnel
		 */
		private final String nom;
		private final String prenom;
		private String fonction = "Aucune";
		private LocalDate dateNaissance = LocalDate.now();
		private String numeroTel = "";
		
		/**
		 * Constructeur de Builder
		 */
		public Builder(String nom, String prenom) {
			this.nom = nom;
			this.prenom = prenom;
		}
		
		/**
		 * Fonction définissant l'attribut fonction;
		 * @param fonction
		 * @return
		 */
		public Builder fonction(String fonction) {
			this.fonction = fonction;
			return this;
		}
		
		/**
		 * Fonction définisssant l'attribut dateNaissance
		 * @param fonction
		 * @return
		 */
		public Builder dateNaissance(LocalDate dateNaissance) {
			this.dateNaissance = dateNaissance;
			return this;
		}
		
		/**
		 * Fonction définisssant l'attribut numeroTel
		 * @param fonction
		 * @return
		 */
		public Builder numeroTel(String numeroTel) {
			this.numeroTel = numeroTel;
			return this;
		}
		
		/**
		 * Méthode builder de personnel
		 */
		public Personnel build() {
			return new Personnel(this);
		}
	}
	
	/**
	 * Constructeur privé pour suivre le patern de conception Builder
	 */
	private Personnel(Builder builder) {
		this.nom = builder.nom;
		this.prenom = builder.prenom;
		this.fonction = builder.fonction;
		this.dateNaissance = builder.dateNaissance;
		this.numeroTel = builder.numeroTel;
	}
	
	/**
	 * Getters
	 * @return
	 */
	public String getNom() {
		return this.nom;
	}
	public String getPrenom() {
		return this.prenom;
	}
	public String getFonction() {
		return this.fonction;
	}
	public LocalDate getDateNaissance() {
		return this.dateNaissance;
	}
	public String getNumeroTel() {
		return this.numeroTel;
	}
	
	/**
	 * Méthode affichant un personnel
	 */
	public void afficher() {
		System.out.println(this.fonction + " " + this.nom + " " + this.prenom + " " + this.dateNaissance.toString() + " " + this.numeroTel);
	}
}
