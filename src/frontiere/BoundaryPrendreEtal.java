package frontiere;

import java.util.Scanner;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		if (!controlPrendreEtal.verifierIdentite(nomVendeur)) {
			System.out.println("Je suis d�sol� " + nomVendeur + "il faut �tre un habitant du village pour commercer i�i");
		}
		else {
			System.out.println("Bonjour" + nomVendeur + "je vais regarder si je peux vous trouver un �tal");
			if (!controlPrendreEtal.resteEtals()) {
				System.out.println("D�sol� " + nomVendeur + "je n'ai plus d'�tal qui ne soit pas occup�");
			}
			installerVendeur(nomVendeur);
		}
	}

	private void installerVendeur(String nomVendeur) {
		System.out.println("C'est parfait, il me reste un �tal pour vous !\n Il me faudrait quelques renseignements :\n Quel produit d�sirez vous vendre ?");
		
		String produit = scan.nextLine();
		System.out.println("Combien souhaitez-vous en vendre ?");
		int qtprod = scan.nextInt();
		int numE = controlPrendreEtal.prendreEtal(nomVendeur, produit, qtprod);
		if (numE != -1)
			System.out.println("Le vendeur " + nomVendeur + "s'est install� � l'�tal n� " + numE);
	}
}
