import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Setting implements Initializable {
    @FXML
    Button btnExit ;
    @FXML
    Button btnChangeF ;
    @FXML
    Button btnChengeL ;
    @FXML
    Button btnChengeE ;
    @FXML
    Button btnChangeU ;
    @FXML
    Button btnChengeP ;
    @FXML
    Button btnS ;
    @FXML
    TextField txtfF ;
    @FXML
    TextField txtfL ;
    @FXML
    TextField txtfU ;
    @FXML
    TextField txtfP ;
    @FXML
    TextField txtfE ;
    @FXML
    Button btnback ;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    btnChangeF.setOnAction(event -> {
        String firstname = txtfF.getText();
    });
    btnChangeU.setOnAction(event -> {
        String username = txtfU.getText();
    });
    btnChengeL.setOnAction(event -> {
        String lastname = txtfL.getText();

    });
    btnChengeP.setOnAction(event -> {
        String password = txtfP.getText();
    });
    btnChengeE.setOnAction(event ->{
        String Email = txtfE.getText();
    });
        btnExit.setOnAction(event -> {

            System.exit(0);
        });


        btnback.setOnAction(event -> {
            try {
                client.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("chatroom.fxml"))));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
