package personnages;

import java.util.*;

public class Druide {
	private String nom;
	private int effetPotionMin;
	private int effetPotionMax;
	private int forcePotion = 1;
	private String prenom;

	public Druide(String nom, int effetPotionMin, int effetPotionMax) {
		this.nom = nom;
		this.effetPotionMin = effetPotionMin;
		this.effetPotionMax = effetPotionMax;
		parler("Bonjour, je suis le druide " + nom + " et ma potion peut aller d'une force " + effetPotionMin + " à "
				+ effetPotionMax + ".");
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}

	private String prendreParole() {
		return "Le druide " + nom + " : ";
	}

	public int preparerPotion() {
		forcePotion = new Random().nextInt(effetPotionMax - effetPotionMin);
		forcePotion += effetPotionMin;
		if (forcePotion > 7) {
			parler("J'ai prepare une super potion de force " + forcePotion);
		} else {
			parler("Je n'ai pas trouve tous les ingredients, ma potion est seulement de force " + forcePotion);
		}
		return forcePotion;
	}

	public void booster(Gaulois gaulois) {
		prenom = gaulois.getNom();
		if (prenom == "Obelix") {
			parler(" Non, Obelix !... Tu n'auras pas de potion magique !");
			gaulois.parler("Par belenos ce n est pas juste");
		} else {
			gaulois.boirePotion(forcePotion);
		}
	}

	public static void main(String[] args) {
		Druide panoramix = new Druide("Panoramix", 5, 10);
		panoramix.preparerPotion();
	}
}
