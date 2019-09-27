package fr.cesi.commerce.operations;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.tool.schema.internal.exec.GenerationTargetToStdout;

import fr.cesi.commerce.entity.AuteurJPA;
import fr.cesi.commerce.object.Auteur;


/**
 * 
 *Class to illustrate the usage of EntityManager API.
 */
public class OperationAuteur {

    private static final EntityManagerFactory emf;

    /**
     * Static block for creating EntityManagerFactory. The Persistence class looks for META-INF/persistence.xml in the classpath.
     */
    static {
        emf = Persistence.createEntityManagerFactory("bibliotheque");
    }

    /**
     * Static method returning EntityManager.
     * @return EntityManager
     */
    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    /**
     * Saves the movie entity into the database. Here we are using Application Managed EntityManager, hence should handle transactions by ourselves.
     */
    public void saveAuteur(Auteur a) {
        EntityManager em = OperationAuteur.getEntityManager();
        em.getTransaction()
            .begin();
        AuteurJPA auteur = new AuteurJPA();
        int taille = getAllAuteurs().size();
        auteur.setId(taille++);
        auteur.setName(a.getNom());
        em.persist(auteur);
        em.getTransaction()
            .commit();
    }

    /**
     * Method to illustrate the querying support in EntityManager when the result is a single object.
     * @return Auteur
     */
    public Auteur queryForAuteurById() {
        EntityManager em = OperationAuteur.getEntityManager();
        Auteur movie = (Auteur) em.createQuery("SELECT auteur from Auteur where auteur.id = ?1")
            .setParameter(1, new Long(1L))
            .getSingleResult();
        return movie;
    }
    public AuteurJPA queryForAuteurByName(String nom) {
        EntityManager em = OperationAuteur.getEntityManager();
        AuteurJPA movie = (AuteurJPA) em.createQuery("SELECT auteur from AuteurJPA auteur where auteur.name = ?1")
            .setParameter(1, nom)
            .getSingleResult();
        return movie;
    }
    public List<AuteurJPA> getAllAuteurs() {
        EntityManager em = OperationAuteur.getEntityManager();
        List<AuteurJPA> movie = em.createQuery("SELECT c FROM AuteurJPA c", AuteurJPA.class).getResultList();
        
        return movie;
    }
//    public void addAuteur() {
//        EntityManager em = OperationAuteur.getEntityManager();
//        AuteurJPA movie = em.find(AuteurJPA.class, new Long(auteurId));
//    }

    /**
     * Method to illustrate the usage of find() method.
     * @param movieId
     * @return Movie
     */
    public AuteurJPA getAuteur(int auteurId) {
        EntityManager em = OperationAuteur.getEntityManager();
        AuteurJPA movie = em.find(AuteurJPA.class, new Long(auteurId));
        return movie;
    }

    /**
     * Method to illustrate the usage of merge() function.
     */
    public void mergeMovie() {
        EntityManager em = OperationAuteur.getEntityManager();
        AuteurJPA auteur = getAuteur(1);
        em.detach(auteur);
        auteur.setName("Italian");
        em.getTransaction()
            .begin();
        em.merge(auteur);
        em.getTransaction()
            .commit();
    }

    /**
     * Method to illustrate the usage of remove() function.
     */
    public void removeAuteur(int id) {
        EntityManager em = OperationAuteur.getEntityManager();
        em.getTransaction()
            .begin();
        AuteurJPA movie = em.find(AuteurJPA.class, id);
        em.remove(movie);
        em.getTransaction()
            .commit();
    }

}
