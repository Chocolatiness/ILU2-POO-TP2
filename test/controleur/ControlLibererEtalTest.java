package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlLibererEtalTest {

	private Village village;
	private Chef abraracourcix;
	private Gaulois Vduvillage;
	private Gaulois duvillage;
	
	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		village = new Village("le village des irréductibles", 10, 1);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		Vduvillage = new Gaulois("Vduvillage", 1465);
		duvillage = new Gaulois("duvillage", 1465);
		village.setChef(abraracourcix);
		village.ajouterHabitant(Vduvillage);
		village.ajouterHabitant(duvillage);
		village.installerVendeur(Vduvillage, "Hippolyte", 1);
	}
	
	@Test
	void testControlLibererEtal() {
		ControlTrouverEtalVendeur ctrlTEV = new ControlTrouverEtalVendeur(village);
		ControlLibererEtal ctrlLE = new ControlLibererEtal(ctrlTEV);
		assertNotNull(ctrlLE, "Constructeur ne renvoie pas null");
	}

	@Test
	void testisVendeur() {
		ControlTrouverEtalVendeur ctrlTEV = new ControlTrouverEtalVendeur(village);
		ControlLibererEtal ctrlLE = new ControlLibererEtal(ctrlTEV);
		assertFalse(ctrlLE.isVendeur("duvillage"));
		assertTrue(ctrlLE.isVendeur("Vduvillage"));
	}
	
	@Test
	void testlibererEtal() {
		ControlTrouverEtalVendeur ctrlTEV = new ControlTrouverEtalVendeur(village);
		ControlLibererEtal ctrlLE = new ControlLibererEtal(ctrlTEV);
		String[] expect = {"true","Vduvillage","Hippolyte","1","0"};
		assertArrayEquals(expect,ctrlLE.libererEtal("Vduvillage"));
	}
}
