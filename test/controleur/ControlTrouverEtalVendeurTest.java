package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Druide;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlTrouverEtalVendeurTest {

	private Village village;
	private Chef abraracourcix;
	private Gaulois duvillage;

	
	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		village = new Village("le village des irréductibles", 10, 1);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		duvillage = new Gaulois("duvillage", 1465);
		village.setChef(abraracourcix);
		village.ajouterHabitant(duvillage);
}
	@Test
	void testControlTrouverEtalVendeur() {
		ControlTrouverEtalVendeur ctrlTEV = new ControlTrouverEtalVendeur(village);
		assertNotNull(ctrlTEV, "Constructeur ne renvoie pas null");
	}
	
	@Test
	void testtrouverEtalVendeur() {
		ControlTrouverEtalVendeur ctrlTEV = new ControlTrouverEtalVendeur(village);
		assertNull(ctrlTEV.trouverEtalVendeur("duvillage"));
		village.installerVendeur(duvillage, "Hippolyte", 1);
		assertEquals(village.rechercherEtal(duvillage),ctrlTEV.trouverEtalVendeur("duvillage"));
	}
}
