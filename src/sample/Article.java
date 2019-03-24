package sample;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
 public class Article {

    @Id @GeneratedValue
    private long id;

    private String articleNo;

    public Article(String articleNo){
        this.articleNo = articleNo;
    }

}
