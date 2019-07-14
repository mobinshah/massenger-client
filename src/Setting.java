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

//        txtfF.setText(Login.username);
//        System.out.println(Login.username);
//
//        txtfP.setText((Login.password));
//
//
    btnChangeF.setOnAction(event -> {

        String firstname = txtfF.getText();
        try {
            pesonDB pesonDB = new pesonDB();
            pesonDB.changeFirstname(Login.username, firstname);

        } catch (Exception e) {
            e.printStackTrace();
        }

    });
    btnChangeU.setOnAction(event -> {
        String username = txtfU.getText();
        try {
            pesonDB pesonDB =new pesonDB();
            pesonDB.changeUsername(Login.username , username);

        } catch (Exception e) {
            e.printStackTrace();
        }
    });
    btnChengeL.setOnAction(event -> {
        String lastname = txtfL.getText();
    try {
        pesonDB pesonDB =new pesonDB();
        pesonDB.changeLastname(Login.username , lastname);
    }catch (Exception e) {
        e.printStackTrace();
    }

    });
    btnChengeP.setOnAction(event -> {
        String password = txtfP.getText();
        try {
            pesonDB pesonDB =new pesonDB();
            pesonDB.changePass(Login.username , password);

        } catch (Exception e) {
            e.printStackTrace();
        }

    });
    btnChengeE.setOnAction(event ->{
        String Email = txtfE.getText();
        try {
            pesonDB pesonDB = new pesonDB();
            pesonDB.changeEmail(Login.username , Email );
        } catch (Exception e) {
            e.printStackTrace();
        }
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
