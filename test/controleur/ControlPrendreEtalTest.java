package controleur;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Druide;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlPrendreEtalTest {
	private Village village;
	private Chef abraracourcix;
	private Gaulois duvillage;
	private Druide dduvilage;
	private Gaulois pasduvillage;
	
	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		village = new Village("le village des irréductibles", 10, 1);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		duvillage = new Gaulois("duvillage", 1465);
		dduvilage = new Druide("dduvillage", 3, 5, 8);
		village.setChef(abraracourcix);
		village.ajouterHabitant(duvillage);
		village.ajouterHabitant(dduvilage);
		pasduvillage = new Gaulois("pasduvillage", 1);
}		
	@Test
	void testControlPrendreEtal() {
		ControlVerifierIdentite ctrlVI = new ControlVerifierIdentite(village);
		ControlPrendreEtal ctrlPE = new ControlPrendreEtal(ctrlVI, village);
		assertNotNull(ctrlPE, "Constructeur ne renvoie pas null");
	}
		
	@Test
	void testresteEtals() {
		ControlVerifierIdentite ctrlVI = new ControlVerifierIdentite(village);
		ControlPrendreEtal ctrlPE = new ControlPrendreEtal(ctrlVI, village);
		assertTrue(ctrlPE.resteEtals());
		village.installerVendeur(duvillage, "Hippolyte", 1);
		assertFalse(ctrlPE.resteEtals());
	}
	
	@Test
	void testprendreEtal() {
		ControlVerifierIdentite ctrlVI = new ControlVerifierIdentite(village);
		ControlPrendreEtal ctrlPE = new ControlPrendreEtal(ctrlVI, village);
		assertEquals(0,ctrlPE.prendreEtal("duvillage", "Hippolyte", 1));
	}
	
	@Test
	void testverifierIdentite() {
		ControlVerifierIdentite ctrlVI = new ControlVerifierIdentite(village);
		ControlPrendreEtal ctrlPE = new ControlPrendreEtal(ctrlVI, village);
		assertTrue(ctrlPE.verifierIdentite("duvillage"));
		assertFalse(ctrlPE.verifierIdentite("pasduvillage"));
	}
}
