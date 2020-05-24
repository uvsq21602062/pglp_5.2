package fr.uvsq.uvsq21602062.projet_maven;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.Test;

public class AnnuaireTest {

	@Test
	public void testAjouterGetH() {
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
				.fonction("DRH")
				.numeroTel("0600343321")
				.build();
		
		a.ajouter(p1, 0);
		a.ajouter(p2, 1);
		a.ajouter(p3, 1);
		ArrayList<CompositePersonnel> liste = a.getListGroupeHierarchie();
		assertTrue(liste.get(1).obtenir("Dupuit", "Alain") == p2);
	}
	
	@Test
	public void testAjouterGetF() {
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
		
		a.ajouter(p1, 0);
		a.ajouter(p2, 1);
		a.ajouter(p3, 2);
		ArrayList<CompositePersonnel> liste = a.getListGroupeFonction();
		assertTrue(liste.get(1).obtenir("Dubois", "Jean") == p3);
	}

}
