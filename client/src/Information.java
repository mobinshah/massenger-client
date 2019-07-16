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
    TextField txtfFirstname ;
    @FXML
    TextField txtfLastname ;
    @FXML
    TextField txtfEmail ;
    @FXML
    TextField txtfusername ;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnBack.setOnAction(event -> {
            try {
                client.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("chatroom.fxml"))));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
