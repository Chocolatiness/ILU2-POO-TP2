package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println(
					"Mais vous Ãªtes dÃ©jÃ  un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("ÃŠtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					
					emmenagerGaulois(nomVisiteur);
					break;

				default:
					System.out
							.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		System.out.println("Bienvenue Druide  " + nomVisiteur);
		StringBuilder question = new StringBuilder();
		StringBuilder question2 = new StringBuilder();
		StringBuilder question3 = new StringBuilder();
		int forcepotmin=0, forcepotmax=1;
		question.append("Quel est votre force ?");
		int force = Clavier.entrerEntier(question.toString());
		do {
		question2.append("Quelle est la force de potion la\r\n" + 
				"plus faible que vous produisez ?");
		forcepotmin = Clavier.entrerEntier(question2.toString());
		question3.append("Quelle est la force de potion la\r\n" + 
				"plus forte que vous produisez ?");
		forcepotmax = Clavier.entrerEntier(question3.toString());
		if (forcepotmin > forcepotmax)
			System.out.println("Attention Druide vous avez entré une force min supérieur à la force max");
		}while (forcepotmin > forcepotmax);
		controlEmmenager.ajouterDuide(nomVisiteur, force, forcepotmin, forcepotmax);
	}
	
	private void emmenagerGaulois(String nomVisiteur) {
		System.out.println("Bienvenue villageois " + nomVisiteur);
		StringBuilder question2 = new StringBuilder();
		question2.append("Quel est votre force ?");
		int force = Clavier.entrerEntier(question2.toString());
		controlEmmenager.ajouterGaulois(nomVisiteur, force);
		
	}
}
