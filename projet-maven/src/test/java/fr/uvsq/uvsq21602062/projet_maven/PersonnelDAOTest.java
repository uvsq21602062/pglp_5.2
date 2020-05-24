package fr.uvsq.uvsq21602062.projet_maven;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.Test;

public class PersonnelDAOTest {

	@Test
	public void testAjouterObtenir() {
		Personnel p1 = new Personnel
				.Builder("Dupont", "François")
				.dateNaissance(LocalDate.now())
				.fonction("Chef de groupe")
				.numeroTel("0678905676")
				.build();
		PersonnelDAO pDAO = new PersonnelDAO();
		
		pDAO.ajouter(p1);
		ArrayList<Personnel> liste = pDAO.toutObtenir();
		System.out.println(liste.get(0).getNom());
		
		assertTrue(liste.get(0).getNom().equals(p1.getNom()));
		
	}

}
