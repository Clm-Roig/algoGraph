public class Sommet {
	private String nom;

	public Sommet(String n) { 
		this.nom = n;
	}

	public String toString() {
		return nom;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public boolean equals(Object obj) {
		boolean res;
		if(obj instanceof Sommet) {
			res = (((Sommet)obj).getNom() == this.getNom());
		}
		else {
			res = false;
		}		
		return res;
	}
}
