package personnages;

public class Musee {
	private Trophee[] trophee = new Trophee[200];
	private int nbTrophee = 0;

	public void donnerTrophee(Gaulois gaulois, Equipement equipement) {
		Trophee trophy;
		trophy = new Trophee(gaulois, equipement);
		trophee[nbTrophee] = trophy;
		nbTrophee++;
	}

	public String extraireInstructionsCaml() {
		return "let musee = [\n" + dansMusee() + "\n]";
	}

	private String dansMusee() {
		String texte = "";
		for (int i = 0; i < nbTrophee; i++) {
			texte = texte + "     " + trophee[i].donnerNom() + ", " + trophee[i].getEquipement() + ";\n";
		}
		return texte;
	}

}
