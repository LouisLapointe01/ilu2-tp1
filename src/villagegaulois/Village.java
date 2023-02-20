package villagegaulois;

import personnages.Chef;
import personnages.Gaulois;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois = 0;

	public Village(String nom, int nbVillageoisMaximum) {
		this.nom = nom;
		villageois = new Gaulois[nbVillageoisMaximum];
	}

	public String getNom() {
		return nom;
	}

	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public void ajouterHabitant(Gaulois gaulois) {
		if (nbVillageois < villageois.length) {
			villageois[nbVillageois] = gaulois;
			nbVillageois++;
		}
	}

	public Gaulois trouverHabitant(String nomGaulois) {
		if (nomGaulois.equals(chef.getNom())) {
			return chef;
		}
		for (int i = 0; i < nbVillageois; i++) {
			Gaulois gaulois = villageois[i];
			if (gaulois.getNom().equals(nomGaulois)) {
				return gaulois;
			}
		}
		return null;
	}

	public String afficherVillageois() {
		StringBuilder chaine = new StringBuilder();
		if (nbVillageois < 1) {
			chaine.append("Il n'y a encore aucun habitant au village du chef "
					+ chef.getNom() + ".\n");
		} else {
			chaine.append("Au village du chef " + chef.getNom()
					+ " vivent les légendaires gaulois :\n");
			for (int i = 0; i < nbVillageois; i++) {
				chaine.append("- " + villageois[i].getNom() + "\n");
			}
		}
		return chaine.toString();
	}
	
	private static class Marche{
		
		private  Etal[] etal;
		int nombreEtal;
		
		private Marche(int nombreEtal) {
			
		 etal = new Etal[nombreEtal];
		 
		}
		
		private void utiliserEtal(int indiceEtal, Gaulois vendeur, String produit, int nbProduit) {
			etal[indiceEtal].occuperEtal(vendeur, produit, nbProduit);
		}
		
		private int trouverEtalLibre() {
			
			for( int i = 0; i <= nombreEtal; i++) {
				if(etal[i].isEtalOccupe()){
					return 1;
				}
			}
			return 0;
		}
		
		private Etal[] trouverEtals(String produit) {
			int compteurTabProduit = 0;
			Etal tabEtalProduit[] = new Etal[nombreEtal];
			
			for( int i = 0; i <= nombreEtal; i++) {
				
				if(etal[i].contientProduit(produit) && etal[i].isEtalOccupe()) {
					tabEtalProduit[compteurTabProduit] = etal[i];
				}
			}
			return tabEtalProduit;	
		}
		
		private Etal trouverVendeur(Gaulois gaulois) {
			for( int i = 0; i <= nombreEtal; i++) {
				if((etal[i].getVendeur().equals(gaulois)) && etal[i].isEtalOccupe()) {
					return etal[i];
				}
			}
			return null;
		}
		
		
		
	 }
		
	}
