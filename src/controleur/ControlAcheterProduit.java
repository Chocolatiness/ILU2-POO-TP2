package controleur;

import personnages.Gaulois;
import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public Gaulois[] vendeursProd(String prod) {
		return village.rechercherVendeursProduit(prod);
	}
	
	public int nbprod(Gaulois vendeur) {
		return controlTrouverEtalVendeur.trouverEtalVendeur(vendeur.getNom()).getQuantite();
	}
	
	public boolean contientProduit(String produit) {
		return village.rechercherVendeursProduit(produit) == null;
	}
	
	public void acheterProduit(int nbachat,Gaulois vendeur) {
		controlTrouverEtalVendeur.trouverEtalVendeur(vendeur.getNom()).acheterProduit(nbachat);
	}
}
