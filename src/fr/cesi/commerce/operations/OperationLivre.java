package fr.cesi.commerce.operations;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.tool.schema.internal.exec.GenerationTargetToStdout;

import fr.cesi.commerce.entity.AuteurJPA;
import fr.cesi.commerce.entity.LivreJPA;


/**
 * 
 *Class to illustrate the usage of EntityManager API.
 */
public class OperationLivre {

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
    public void saveLivre(LivreJPA a) {
        EntityManager em = OperationAuteur.getEntityManager();
        em.getTransaction()
            .begin();
        LivreJPA livre = new LivreJPA();
        int taille = getAllLivres().size();
        livre.setId(taille++);
        livre.setTitre(a.getTitre());
        em.persist(livre);
        em.getTransaction()
            .commit();
    }

    /**
     * Method to illustrate the querying support in EntityManager when the result is a single object.
     * @return Auteur
     */
    public List<LivreJPA> queryForAuteurById() {
        EntityManager em = OperationAuteur.getEntityManager();
        List<LivreJPA> movie = (List<LivreJPA>) em.createQuery("SELECT livre from Livre where auteur  = ?1")
            .setParameter(1, new Long(1L))
            .getResultList();
        return movie;
    }
    public List<LivreJPA> getAllLivres() {
        EntityManager em = OperationAuteur.getEntityManager();
        List<LivreJPA> movie = em.createQuery("SELECT c FROM LivreJPA c", LivreJPA.class).getResultList();
        
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
//    public AuteurJPA getAuteur(LivreJPA livre) {
//        EntityManager em = OperationAuteur.getEntityManager();
//        AuteurJPA movie = em.find(AuteurJPA.class, new Long(auteurId));
//        return movie;
//    }

    /**
     * Method to illustrate the usage of merge() function.
     */
//    public void mergeMovie() {
//        EntityManager em = OperationAuteur.getEntityManager();
//        AuteurJPA auteur = getAuteur(1L);
//        em.detach(auteur);
//        auteur.setName("Italian");
//        em.getTransaction()
//            .begin();
//        em.merge(auteur);
//        em.getTransaction()
//            .commit();
//    }

    /**
     * Method to illustrate the usage of remove() function.
     */
    public void removeLivre(int id) {
        EntityManager em = OperationAuteur.getEntityManager();
        em.getTransaction()
            .begin();
        LivreJPA movie = em.find(LivreJPA.class, id);
        em.remove(movie);
        em.getTransaction()
            .commit();
    }

}
