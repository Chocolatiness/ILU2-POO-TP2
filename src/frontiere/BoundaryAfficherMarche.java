package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
		String i[] = controlAfficherMarche.donnerInfosMarche();
		if (i.length == 0) {
			System.out.println("Le marché est vide, revenez plus tard.");
		}
		else {
			System.out.println(nomAcheteur + "vous trouverez au marché : ");
			for(int j = 0;j<i.length;j++) {
				System.out.println("-" + i[j++] + " qui vend " + i[j++] + " " + i[j]);
			}
		}
	}
	
}
