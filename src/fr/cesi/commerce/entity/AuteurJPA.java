package fr.cesi.commerce.entity;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="auteur")
public class AuteurJPA implements Serializable {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private int id;
	
	 @Column(name="nom")
	private String name;
	
	public AuteurJPA()
	{}	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}