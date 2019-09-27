package fr.cesi.sun.commerce.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import fr.cesi.commerce.object.Auteur;
import fr.cesi.commerce.object.Livre;
import fr.cesi.sun.commerce.exception.UnknownProductException;

public class AuteurDao {
	
	private static List<Auteur> auteurs = new ArrayList<Auteur>();
	private static Long idSequence = 1L;
	
	private AuteurDao() { }

	public static void addAuteur(Auteur auteur) {
		auteur.setId(idSequence++);
		auteurs.add(auteur);
	}
	
	
	public static void updateAuteur(Auteur product) {
		int index = getAuteurIndexById(product.getId());
		if(index > -1) {
			auteurs.set(index, product);
		} else {
			throw new UnknownProductException(product.getId());
		}
	}
	
	
	public static Auteur findAuteurById(Long id) {
		int index = getAuteurIndexById(id);
		if(index > -1) {
			Auteur product = auteurs.get(index);
			return product;
		}
		throw new UnknownProductException(id);
	}
	
	
	public static List<Auteur> getAllAuteurs() {
		return Collections.unmodifiableList(auteurs);
	}
	
	
	public static void removeAuteur(Auteur product) {
		removeAuteur(product.getId());
	}
	
	
	public static void removeAuteur(Long id) {
		int index = getAuteurIndexById(id);
		if(index > -1) {
			auteurs.remove(index);
		} else {
			throw new UnknownProductException(id);
		}
	}
	
	private static int getAuteurIndexById(Long id) {
		for (int i = 0; i < auteurs.size(); i++) {
			Auteur product = auteurs.get(i);
			if(product.getId().equals(id)) {
				return i;
			}
		}
		return -1;
	
	}
}
