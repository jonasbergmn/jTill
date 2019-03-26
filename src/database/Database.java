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

    public boolean checkArticleAv(String name) throws IOException{

        try {
            EntityManagerFactory emf =
                    Persistence.createEntityManagerFactory("$objectdb/db/jTill.odb");
            EntityManager em = emf.createEntityManager();
            Article a1 = (Article) em.createQuery("Select q FROM Article q Where q.articleNo = :name").setParameter("name", name).getSingleResult();
            em.close();
            emf.close();
        } catch (NoResultException e){
            return false;
        }
        return true;
    }

    public boolean safeAddArticle(Article a) throws IOException {

       if( checkArticleAv(a.getArticleNo())==true){
           System.out.println("Artikel wurde nicht hinzugefügt");
           return false;
       }

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("$objectdb/db/jTill.odb");
        EntityManager em = emf.createEntityManager();
        Article s = a;
        em.getTransaction().begin();
        em.persist(s);
        em.getTransaction().commit();
        em.close();
        emf.close();
        System.out.println("Artikel wurde hinzugefügt");
        return true;
    }

    public void safeAddArticleMitBestand(Article a) throws IOException {
        String name = a.getArticleNo();
        if(!safeAddArticle(a)){
            try {
                EntityManagerFactory emf =
                        Persistence.createEntityManagerFactory("$objectdb/db/jTill.odb");
                EntityManager em = emf.createEntityManager();
                Article a1 = (Article) em.createQuery("Select q FROM Article q Where q.articleNo = :name").setParameter("name", name).getSingleResult();
                em.getTransaction().begin();
                a1.setBestand(a1.getBestand()+1);
                System.out.println("Bestand erhöht");
                em.getTransaction().commit();
                em.close();
                emf.close();
            } catch (NoResultException e){

            }

        }

    }

    public void reduceArticle(Article a) throws IOException {
        String name = a.getArticleNo();
        if(!safeAddArticle(a)){
            try {
                EntityManagerFactory emf =
                        Persistence.createEntityManagerFactory("$objectdb/db/jTill.odb");
                EntityManager em = emf.createEntityManager();
                Article a1 = (Article) em.createQuery("Select q FROM Article q Where q.articleNo = :name").setParameter("name", name).getSingleResult();
                if(a1.getBestand()>0){
                    em.getTransaction().begin();
                    a1.setBestand(a1.getBestand()-1);
                    System.out.println("Bestand verringert");
                    em.getTransaction().commit();
                }
                else {
                    System.out.println("Bestand = 0");
                }
                em.close();
                emf.close();
            } catch (NoResultException e){

            }

        }
    }

}
