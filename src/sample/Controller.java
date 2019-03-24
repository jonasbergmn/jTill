package sample;

import database.Database;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Controller {

    public Button dbTest;

    public void fillDb(ActionEvent actionEvent) {
        Database d = new Database();
        Article a = new Article("0123456789");
        d.addArticle(a);
    }
}
