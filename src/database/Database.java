package database;

import sample.Article;
import javax.persistence.*;
import java.io.IOException;
import java.util.List;

public class Database {

    public void addArticle(Article a){
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("$objectdb/db/jTill.odb");
        EntityManager em = emf.createEntityManager();
        Article s = a;
        em.getTransaction().begin();
        em.persist(s);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }


}
