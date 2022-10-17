package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipement = new Equipement[2];
	private int nbEquipement = 0;

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert force > 0;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

	public void recevoirCoup(int forceCoup) {
		int forceDebut;
		forceDebut = force;
		assert force > 0;
		force -= forceCoup;
		if (force > 0) {
			parler("Aïe");
		} else {
			parler("J'abandonne...");
		}
		assert forceDebut > force;
	}

	public void sEquiper(Equipement objet) {
		switch (nbEquipement) {
		case 0:
			equipement[0] = objet;
			nbEquipement = nbEquipement + 1;
			System.out.println("Le soldat " + nom + " s equipe avec un " + objet);
			break;
		case 1:
			if (equipement[0] == objet) {
				System.out.println("Le soldat " + nom + " possede deja un " + objet);
			} else {
				System.out.println("Le soldat " + nom + " s equipe avec un " + objet);
				nbEquipement = nbEquipement + 1;
			}
			break;

		case 2:
			System.out.println("Le soldat " + nom + " est deja bien protege ! ");
			break;
		}
	}

	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
		minus.prendreParole();
		minus.parler("Salut");
		minus.recevoirCoup(1);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
	}
}
