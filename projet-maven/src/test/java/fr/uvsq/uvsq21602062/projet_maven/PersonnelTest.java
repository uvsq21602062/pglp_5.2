package fr.uvsq.uvsq21602062.projet_maven;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

public class PersonnelTest {

	@Test
	public void testBuilder() {
		Personnel p = new Personnel
				.Builder("Dupont", "François")
				.dateNaissance(LocalDate.now())
				.fonction("Chef de groupe")
				.numeroTel("0678905676")
				.build();
		assertTrue(p.getFonction() == "Chef de groupe");
	}

}
