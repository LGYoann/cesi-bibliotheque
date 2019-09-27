package fr.cesi.commerce.entity;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import fr.cesi.commerce.object.Auteur;
@Entity
@Table(name="livre")
public class LivreJPA implements Serializable {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private int id;
	
	 @Column(name="Titre")
	private String name;
	 
//	@ManyToOne(fetch=FetchType.EAGER)
//	@JoinTable(name="auteur")
//	@JoinColumn(name = "Auteur")
//	private AuteurJPA auteur;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "auteur", referencedColumnName = "id", insertable = false, updatable = false, nullable = false)
	private AuteurJPA auteur;
	
	public LivreJPA()
	{}	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitre() {
		return name;
	}
	public void setTitre(String name) {
		this.name = name;
	}
	public AuteurJPA getAuteur() {
		return auteur;
	}
	public void setAuteur(AuteurJPA auteur) {
		this.auteur = auteur;
	}
}