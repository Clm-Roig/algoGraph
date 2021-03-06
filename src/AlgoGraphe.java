import java.util.ArrayList;

public class AlgoGraphe {
	
	private Graphe graphe;
		
	public AlgoGraphe(Graphe g) {
		this.graphe = g;
	} 
	
	// Maximal de couple disjoints
	public ArrayList<Sommet> maxMatching() {
		ArrayList<Sommet> vp = new ArrayList<Sommet>();
		ArrayList<Arete> a = graphe.getAretes();
		Arete x;
		ArrayList<Arete> aSupprimer = new ArrayList<Arete>();
		
		while(!a.isEmpty()) {
			x = a.get(0);
			vp.add(x.getS1());
			vp.add(x.getS2());
			for(Arete ar : a) {
				if(
					ar.getS1() == x.getS1() || 
					ar.getS2() == x.getS1()	||
					ar.getS1() == x.getS2() || 
					ar.getS2() == x.getS2()
				) {
					aSupprimer.add(ar);
				}
			}
			for(Arete ar : aSupprimer) {
				a.remove(ar);
			}
		}
		return vp;
	}
	
	// Couvrir toutes les arêtes avec le minimum de sommet
	public ArrayList<ArrayList<Sommet>> vertexCover() {
		ArrayList<ArrayList<Sommet>> la = new ArrayList<ArrayList<Sommet>>();
		
		
		
		return la;
	}
	
	
	// ===== MAIN ===== //

	public static void main(String[] args) {
		Graphe graphe1 = new Graphe(6);
		System.out.println(graphe1);
		System.out.println(new AlgoGraphe(graphe1).maxMatching());
	}
}
