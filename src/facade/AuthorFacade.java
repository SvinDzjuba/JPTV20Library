package facade;

import entity.Author;
import entity.Book;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author pupil
 */
public class AuthorFacade extends AbstractFacade<Author>{
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("DeLibraryPU");
    private EntityManager em = emf.createEntityManager();
    private EntityTransaction tx = em.getTransaction();

    public AuthorFacade(Class<Author> entityClass) {
        super(entityClass);
    }

   
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
