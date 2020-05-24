package fr.uvsq.uvsq21602062.projet_maven;

import java.time.LocalDate;

/**
 * Application prncipal reposant sur le patern singleton.
 * @author jean
 *
 */
public class AppSingleton {
	/**
	 * Attribut stockant une instance de cettte classe.
	 */
	private static AppSingleton INSTANCE = null;
	/**
	 * Constructeur privé (suivant le patern singleton)
	 */
	private AppSingleton() {
		// Vide car rien à faire.
	}
	
	/**
	 * Permet d'obtenir une instance de la classe.
	 */
	public static AppSingleton getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new AppSingleton();
		}
		return INSTANCE;
	}
	
	public void run() {
		System.out.println("Bonjour");
		
		PersonnelDAO pDAO = new PersonnelDAO();
		Annuaire a = new Annuaire();
		Personnel p1 = new Personnel
				.Builder("Dupont", "François")
				.dateNaissance(LocalDate.now())
				.fonction("Chef de groupe")
				.numeroTel("0678905676")
				.build();
		Personnel p2 = new Personnel
				.Builder("Dupuit", "Alain")
				.dateNaissance(LocalDate.now())
				.fonction("Assistant")
				.numeroTel("0645457886")
				.build();
		Personnel p3 = new Personnel
				.Builder("Dubois", "Jean")
				.dateNaissance(LocalDate.now())
				.fonction("Assistant")
				.numeroTel("0600343321")
				.build();
		
		pDAO.ajouter(p1);
		pDAO.ajouter(p2);
		pDAO.ajouter(p3);
		
		a.ajouter(p1, 0);
		a.ajouter(p2, 1);
		a.ajouter(p3, 2);
		System.out.println("Affichage par fonction : \n");
		a.afficherParFonction();
		System.out.println("Affichage par hierarchie : \n");
		a.afficherParHierarchie();
		System.out.println("Au revoir");
	}
	
	
	/**
	 * Méthode Main
	 * @param args
	 */
	public static void main(String[] args) {
		getInstance().run();

	}

}
