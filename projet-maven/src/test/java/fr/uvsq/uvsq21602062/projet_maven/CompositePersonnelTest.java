package fr.uvsq.uvsq21602062.projet_maven;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

public class CompositePersonnelTest {

	@Test
	public void testAjouterObtenir() {
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
		
		CompositePersonnel pComp = new CompositePersonnel();
		pComp.ajouter(p1);
		pComp.ajouter(p2);
		assertTrue(pComp.obtenir("Dupont", "François").getFonction() == "Chef de groupe");
	}
	
	@Test
	public void testObtenir() {
		Personnel p1 = new Personnel
				.Builder("Dupont", "François")
				.dateNaissance(LocalDate.now())
				.fonction("Chef de groupe")
				.numeroTel("0678905676")
				.build();
		
		CompositePersonnel pComp = new CompositePersonnel();
		pComp.ajouter(p1);
		assertTrue(pComp.obtenir().getFonction() == "Chef de groupe");
	}

}
