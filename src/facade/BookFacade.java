package facade;

import entity.Book;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import tools.Singleton;

/**
 *
 * @author pupil
 */
public class BookFacade extends AbstractFacade<Book>{
    
    private EntityManager em;

    public BookFacade(Class<Book> entityClass) {
        super(entityClass);
        init();
    }
    private void init(){
        Singleton singleton = Singleton.getInstance();
        em = singleton.getEntityManager();
    }
   
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
