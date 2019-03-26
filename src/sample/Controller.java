package sample;

import database.Database;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;


public class Controller {

    public Button dbTest;
    public Button buttonDelete;
    public TextField textfield1;

    public void fillDb(ActionEvent actionEvent) throws IOException {
        Database d = new Database();
        String articleNo;
        articleNo = textfield1.getText();
        long bestand = 1;
        Article a = new Article(articleNo,bestand);
        d.safeAddArticleMitBestand(a);
    }

    public void delete(ActionEvent actionEvent) throws IOException {
        Database d = new Database();
        String articleNo;
        articleNo = textfield1.getText();
        long bestand = 1;
        Article a = new Article(articleNo,bestand);
        d.reduceArticle(a);
    }
}
