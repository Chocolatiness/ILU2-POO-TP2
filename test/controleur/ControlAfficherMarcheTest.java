package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAfficherMarcheTest {
	
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
	void testControlAfficherMarche() {
		ControlAfficherMarche ctrlAM = new ControlAfficherMarche(village);
		assertNotNull(ctrlAM, "Constructeur ne renvoie pas null");
	}
	
	@Test
	void testdonnerInfosMarche() {
		ControlAfficherMarche ctrlAM = new ControlAfficherMarche(village);
		String[] expect = {};
		assertArrayEquals(expect,ctrlAM.donnerInfosMarche());
		village.installerVendeur(duvillage, "Hippolyte", 1);
		String[] expect2 = {"duvillage","1","Hippolyte"};
		assertArrayEquals(expect2,ctrlAM.donnerInfosMarche());
	}
}
