package controleur;



import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Druide;
import personnages.Gaulois;
import villagegaulois.Village;

import org.junit.jupiter.api.Test;

class ControlAfficherVillageTest {
	private Village village;
	private Chef abraracourcix;
	private Gaulois duvillage;
	private Druide dduvilage;
	
	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		duvillage = new Gaulois("duvillage", 1465);
		dduvilage = new Druide("dduvillage", 3, 5, 8);
		village.setChef(abraracourcix);
		village.ajouterHabitant(duvillage);
		village.ajouterHabitant(dduvilage);
		
}
	@Test
	void testControlAfficherVillage() {
		ControlAfficherVillage controlAV = new ControlAfficherVillage(village);
		assertNotNull(controlAV, "Constructeur ne renvoie pas null");
	}

	@Test
	void testdonnerNomsVillageois() {
		ControlAfficherVillage controlAV = new ControlAfficherVillage(village);
		String[] expect = {"Abraracourcix","duvillage","le druide dduvillage"};
		assertArrayEquals(expect, controlAV.donnerNomsVillageois());
	}
	
	@Test
	void testdonnerNomVillage() {
		ControlAfficherVillage controlAV = new ControlAfficherVillage(village);
		assertEquals("le village des irréductibles",controlAV.donnerNomVillage());
	}
	
	@Test
	void testdonnerNbEtals() {
		ControlAfficherVillage controlAV = new ControlAfficherVillage(village);
		assertEquals(5,controlAV.donnerNbEtals());
	}
}
