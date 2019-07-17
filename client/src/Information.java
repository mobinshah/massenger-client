import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Information implements Initializable {
    @FXML
    Button btnBack ;
    @FXML
    javafx.scene.text.Text txtf;
    @FXML
    javafx.scene.text.Text txtl;
    @FXML
    javafx.scene.text.Text txtu;
    @FXML
    javafx.scene.text.Text txte;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnBack.setOnAction(event -> {
            try {
                client.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("chatroom.fxml"))));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        try {
            pesonDB persondb=new pesonDB();
            txtf.setText(persondb.getPerson(Search.Search).get(3));
            txtl.setText(persondb.getPerson(Search.Search).get(4));
            txtu.setText(persondb.getPerson(Search.Search).get(0));
            txte.setText(persondb.getPerson(Search.Search).get(2));


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
