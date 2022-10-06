package histoire;

import personnages.*;

public class Scenario {

	public static void main(String[] args) {

//		Druide panoramix = new Druide("Panoramix", 5, 10);
//		Gaulois obelix = new Gaulois("Obélix", 10);
//		Gaulois asterix = new Gaulois("Astérix", 6);
//		Romain minus = new Romain("Minus", 35);
//		panoramix.parler("Je vais aller préparer une petite potion...");
//		panoramix.preparerPotion();
//		panoramix.booster(obelix);
//		obelix.parler("Par Bélénos, ce n'est pas juste !");
//		panoramix.booster(asterix);
//		asterix.parler("Bonjour");
//		minus.parler("UN GAU... UN GAUGAU...");
//		asterix.frapper(minus);
//		asterix.frapper(minus);
//		asterix.frapper(minus);
		
		Village village=new Village("Village des irreductibles",30);
//		Gaulois gaulois = village.trouverHabitant(30);
//      car il n y a pas 30 habitant
		Chef  abraracourcix=new Chef(" Abraracourcix",6,village);
		village.setChef(abraracourcix);
		Gaulois abraracourcixg=new Gaulois(" Abraracourcix",6);
		village.ajouterHabitant(abraracourcixg);
		Gaulois asterix=new Gaulois("Ast�rix",8);
		village.ajouterHabitant(asterix);
//		Gaulois gaulois = village.trouverHabitant(2);
//		System.out.println(gaulois);
//      On a les competencee du gaulois demander
		Gaulois obelix=new Gaulois("Ob�lix",25);
		village.ajouterHabitant(obelix);
		village.afficherVillageois();
		
	}

}