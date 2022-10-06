package personnages;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois = 0;

	public Village(String nom, int nbVillageoisMax) {
		this.nom = nom;
		villageois = new Gaulois[nbVillageoisMax];
	}

	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public String getNom() {
		return nom;
	}

	public void ajouterHabitant(Gaulois habitant) {
		nbVillageois = nbVillageois + 1;
		villageois[nbVillageois] = habitant;

	}

	public Gaulois trouverHabitant(int numeroHabitant) {
		return villageois[numeroHabitant];
	}

	public void afficherVillageois() {
		Gaulois habitant;
		System.out.println("Dans " + nom + " du chef " + chef.getNom() + " vivent:");
		for (int i = 2; i < nbVillageois+1; i++) {
			habitant = villageois[i];
			System.out.println("-" + habitant.getNom());
		}
	}

}
