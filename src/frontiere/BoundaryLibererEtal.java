package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		String donneesEtal[] = null;
		if (!controlLibererEtal.isVendeur(nomVendeur)) {
			System.out.println("Mais vous n'�tes pas inscrit sur notre march� aujourd'hui");
		}
		else {
			donneesEtal = controlLibererEtal.libererEtal(nomVendeur);
			System.out.println("Vous avez vendu " +donneesEtal[4] + "sur " + donneesEtal[3] + " " + donneesEtal[4] + ".\nAu revoir " + nomVendeur + "passez une bonne journ�e.");
			
		}
	}

}
