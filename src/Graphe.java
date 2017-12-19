import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Graphe {
	String name = "Bill le graphe";
	private final String[] alphabet = {
			"A", "B", "C", "D",
			"E", "F", "G", "H", "I",
			"J", "K", "L", "M"	                                   
	};

	ArrayList<Sommet> sommets = new ArrayList<Sommet>();
	ArrayList<Arete> aretes = new ArrayList<Arete>();

	// Constructeur de base d'un Graphe
	public Graphe(String n, ArrayList<Sommet> listSom, ArrayList<Arete> listAr) {
		this.name = n;

		for(Sommet s : listSom) {
			sommets.add(s);
		}
		for(Arete a : listAr) {
			aretes.add(a);
		}

	}

	// Constructeur de Graphe par recopie
	public Graphe(Graphe g) {
		this.name = g.name;
		this.sommets = new ArrayList<Sommet>(g.sommets);
		this.aretes = new ArrayList<Arete>(g.aretes);
	}
	
	// Constructeur graphe aléatoire avec nbS sommets
	public Graphe(int nbS) {
		// génération sommets
		ArrayList<Sommet> listS = new ArrayList<Sommet>();
		int i=0; 
		while(i < nbS) {
			listS.add(new Sommet(alphabet[i]));
			i++;
		}
		this.sommets = listS;
		
		// génération arêtes
		ArrayList<Arete> listA = new ArrayList<Arete>();

		int[][] tabArretes = new int[nbS][nbS];
		for (i = 0; i < tabArretes.length; i++) {
			for (int j = 0; j < tabArretes.length; j++) {
				tabArretes[i][j] = ThreadLocalRandom.current().nextInt(0, 1 + 1);
			}
		}
		
		for (i = 0; i < tabArretes.length; i++) {
			for (int j = 0; j < tabArretes.length; j++) {
				if(tabArretes[i][j] == 1 && i != j) {
					Arete ar = new Arete(listS.get(i), listS.get(j), 1);
					if(!listA.contains(ar)) {
						listA.add(ar);
					}
				}				
			}
		}	
		
		this.aretes = listA;
						
	}

	public String toString() {
		String res = "\n---- GRAPHE " + this.name + " ---\nSommets : ";
		for(Sommet s : this.sommets) {
			res += s.toString() + "  ";
		}
		res += "\nAretes : \n";

		for(Arete ar : this.aretes) {
			res += ar.toString() + "  \n";
		}
		return res;
	}
	
	public ArrayList<Arete> getAretes() {
		return this.aretes;
	}
	
	public ArrayList<Sommet> getSommets() {
		return this.sommets;
	}

	// Supprime toutes les aretes qui concernent un sommet
	public void removeAretesSom(Sommet s) {
		ArrayList<Arete> aretesToRemove = new ArrayList<Arete>();
		for(Arete ar : this.aretes) {
			if(ar.s1.equals(s) || ar.s2.equals(s)) {
				aretesToRemove.add(ar);
			}
		}
		this.aretes.removeAll(aretesToRemove);
	}
}
