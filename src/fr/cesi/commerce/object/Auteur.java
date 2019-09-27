package fr.cesi.commerce.object;

import fr.cesi.commerce.object.Livre;
import java.util.List;

public class Auteur {
	private long id;
	private String nom;
	private List<Livre> livres;
	
	public Auteur() {
		// TODO Auto-generated method stub
		
	}

	public Long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Livre> getLivres() {
		return livres;
	}

	public void setLivres(List<Livre> livres) {
		this.livres = livres;
	}

}
