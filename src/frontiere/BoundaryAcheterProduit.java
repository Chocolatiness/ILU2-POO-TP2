package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;
import personnages.Gaulois;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		System.out.println("Quel produit voulez vous acheter ?\n");
		String reponse = scan.next();
		if (controlAcheterProduit.contientProduit(reponse)) {
			System.out.println("aucun produit de ce nom vendu au marche");
		}
		else {
			System.out.println("Chez quel commerçant voulez vous acheter des " + reponse + " ?");
			Gaulois[] Vendeurs = controlAcheterProduit.vendeursProd(reponse);
			for(int i = 0; i<Vendeurs.length; i++)
				System.out.println((i+1) + " - " + Vendeurs[i]);
			int indiceV = scan.nextInt();
			System.out.println(nomAcheteur + "se délace jusqu'à l'étal de " + Vendeurs[indiceV] + "\nBonjour "+nomAcheteur+ "\n Combien voulez vous acheter de " + reponse);
			int nbachat = scan.nextInt();
			if (controlAcheterProduit.nbprod(Vendeurs[indiceV]) == 0) {
				System.out.println("malheuresement il n'y a plus de " + reponse);
			}
			else {
				if (nbachat >controlAcheterProduit.nbprod(Vendeurs[indiceV])) {
					controlAcheterProduit.acheterProduit(nbachat,Vendeurs[indiceV]);
					System.out.println(nomAcheteur + " veut acheter " + nbachat + "\n malheuresement il n'y en a pas assez\nIl repart avec les " + controlAcheterProduit.nbprod(Vendeurs[indiceV]) + "derniers");
				}
				else {
					System.out.println(nomAcheteur + " a acheter " + controlAcheterProduit.nbprod(Vendeurs[indiceV]) + " " + reponse + " à " + Vendeurs[indiceV]);
				}
			}
		}
		scan.close();
	}
}
