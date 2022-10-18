package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
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
		System.out.println(prendreParole() + "Â« " + texte + "Â»");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

//	public void recevoirCoup(int forceCoup) {
//		int forceDebut;
//		forceDebut = force;
//		assert force > 0;
//		force -= forceCoup;
//		if (force > 0) {
//			parler("AÃ¯e");
//		} else {
//			parler("J'abandonne...");
//		}
//		assert forceDebut > force;
//	}

	public void sEquiper(Equipement objet) {
		switch (nbEquipement) {
		case 0:
			ajouterEquipement(objet);
			break;
		case 1:
			if (equipements[0] == objet) {
				System.out.println("Le soldat " + nom + " possede deja un " + objet);
			} else {
				ajouterEquipement(objet);
			}
			break;

		default:
			System.out.println("Le soldat " + nom + " est deja bien protege ! ");
			break;
		}
	}

	private void ajouterEquipement(Equipement objet) {
		equipements[nbEquipement] = objet;
		nbEquipement++;
		System.out.println("Le soldat " + nom + " s equipe avec un " + objet);
	}

	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// précondition
		if (force > 0) {
			assert force > 0;
			int oldForce = force;
			forceCoup = calculResistanceEquipement(forceCoup);
			force -= forceCoup;
			if (force > 0) {
				parler("Aïe");
			} else {
				force = 0;
				equipementEjecte = ejecterEquipement();
				parler("J'abandonne...");
			}
//		if (force == 0) {
//			parler("Aie");
//		} else {
//			equipementEjecte = ejecterEquipement();
//			parler("J abandonne...");
//		}
			// post condition la force à diminuer
			assert force < oldForce;
			return equipementEjecte;
		}
		System.out.println("Le romain " + nom + " n est plus en capacite d encaisser les coups");
		return equipementEjecte;
	}

	private int calculResistanceEquipement(int forceCoup) {
		String texte;
		texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if ((nbEquipement > 0) || (nbEquipement < 0)) {
			texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
			for (int i = 0; i < nbEquipement; i++) {
				if ((equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER))) {
					resistanceEquipement += 8;
				} else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}
			}
			texte += resistanceEquipement + "!";
		}
		parler(texte);
		if (forceCoup < resistanceEquipement) {
			forceCoup = 0;
		} else {
			forceCoup -= resistanceEquipement;
		}
		return forceCoup;
	}

	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom + "s'envole sous la force du coup.");
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] != null) {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}
		}
		return equipementEjecte;
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
