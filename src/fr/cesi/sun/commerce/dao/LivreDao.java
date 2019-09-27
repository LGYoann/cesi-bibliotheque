package fr.cesi.sun.commerce.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import fr.cesi.sun.commerce.exception.UnknownProductException;
import fr.cesi.commerce.object.Livre;


public class LivreDao {
	
	private static List<Livre> products = new ArrayList<Livre>();
	private static Long idSequence = 1L;
	
	private LivreDao() { }
	
	
	public static void addProduct(Livre product) {
		product.setId(idSequence++);
		products.add(product);
	}
	
	
	public static void updateProduct(Livre product) {
		int index = getProductIndexById(product.getId());
		if(index > -1) {
			products.set(index, product);
		} else {
			throw new UnknownProductException(product.getId());
		}
	}
	
	
	public static Livre findProductById(Long id) {
		int index = getProductIndexById(id);
		if(index > -1) {
			Livre product = products.get(index);
			return product;
		}
		throw new UnknownProductException(id);
	}
	
	
	public static List<Livre> getAllProducts() {
		return Collections.unmodifiableList(products);
	}
	
	
	public static void removeProduct(Livre product) {
		removeProduct(product.getId());
	}
	
	
	public static void removeProduct(Long id) {
		int index = getProductIndexById(id);
		if(index > -1) {
			products.remove(index);
		} else {
			throw new UnknownProductException(id);
		}
	}
	
	private static int getProductIndexById(Long id) {
		for (int i = 0; i < products.size(); i++) {
			Livre product = products.get(i);
			if(product.getId().equals(id)) {
				return i;
			}
		}
		return -1;
	}

}
