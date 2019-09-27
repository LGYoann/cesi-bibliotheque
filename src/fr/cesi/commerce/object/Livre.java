package fr.cesi.commerce.object;

public class Livre {
	
	private long id;
	
	private Auteur auteur;	
	
	private String titre;

	public Livre() {
		// TODO Auto-generated constructor stub
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public Long getId() {
		return this.id;
	}
	
	public void setNom(String nom) {
		this.titre = nom;
	}
	
	public String getNom() {
		return this.titre;
	}

	public Auteur getAuteur() {
		return auteur;
	}

	public void setAuteur(Auteur auteur) {
		this.auteur = auteur;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}
	
	

}
