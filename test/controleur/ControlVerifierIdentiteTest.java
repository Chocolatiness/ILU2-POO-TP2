package controleur;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlVerifierIdentiteTest {
	private Village village;
	private Chef abraracourcix;
	private Gaulois pasduvillage;
	private Gaulois duvillage;

	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		pasduvillage = new Gaulois("pasduvillage", 1);
		duvillage = new Gaulois("duvillage", 1465);
		village.setChef(abraracourcix);
		village.ajouterHabitant(duvillage);
}
	@Test
	void testControlVerifierIdentite() {
		ControlVerifierIdentite controlV = new ControlVerifierIdentite(village);
		assertTrue(controlV.verifierIdentite("duvillage"));
		assertFalse(controlV.verifierIdentite("pasduvillage"));
	}
	
}
