package sample;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
 public class Article {

    @Id @GeneratedValue
    private long id;

    private String articleNo;
    private long bestand;

    public Article(String articleNo){
        this.articleNo = articleNo;
    }

    public void setBestand(long bestand){
        this.bestand = bestand;
    }

    public long getBestand(){
        return this.bestand;
    }

}
