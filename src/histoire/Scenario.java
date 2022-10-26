package histoire;

import personnages.*;

public class Scenario {

	public static void main(String[] args) {

		Gaulois obelix = new Gaulois("Obelix", 10);
		Gaulois asterix = new Gaulois("Asterix", 10);
		Druide panoramix = new Druide("Panoramix", 5, 10);
		Romain minus = new Romain("minus", 6);
		Romain milexcus = new Romain("milexcus", 8);
		Musee louvre = new Musee();
		panoramix.preparerPotion();
		panoramix.booster(obelix);
		panoramix.booster(asterix);
		asterix.parler("Bonjour");
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
		milexcus.sEquiper(Equipement.CASQUE);
		minus.parler("UN GAU... UN GAUGAU...");
		asterix.frapper(minus);
		asterix.frapper(minus);
		milexcus.parler("UN GAU... UN GAUGAU...");
		asterix.frapper(milexcus);
		asterix.faireUneDonnation(louvre,asterix);
		System.out.println(louvre.extraireInstructionsCaml());

	}

}