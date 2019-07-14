import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class SingUp implements Initializable {
    String Image ;
    @FXML
    Button btnBack ;
    @FXML
    Button btnNext ;
    @FXML
    Button btnExit ;
    @FXML
    TextField txtfFirstname;
    @FXML
    TextField txtfLastname ;
    @FXML
    TextField txtfEmail ;
    @FXML
    TextField txtfUsername ;
    @FXML
    TextField txtfPassword ;
    @FXML
    Button btnPhoto ;
    @FXML
    Text txtuser ;
    @FXML
    Text txtpass ;




    @Override
    public void initialize(URL location, ResourceBundle resources) {
    btnNext.setOnAction(event -> {
        String firstname = txtfFirstname.getText();
//        System.out.println(firstname);
        String lastname = txtfLastname.getText();
        String Email = txtfEmail.getText();
        String username = txtfUsername.getText();
        String pass = txtfPassword.getText();
        User user = new User(username, pass, firstname, lastname, Email,Image);
        try {
            pesonDB pesonDB = new pesonDB();
            pesonDB.addPerson(user);
            ArrayList<String> person11 = new ArrayList<>();

            ArrayList<String> person1 = new ArrayList<>();

//            person11 = pesonDB.getPerson(username);
//            person1 = pesonDB.getPerson(pass);
//            if (person11.isEmpty()) {
//                txtuser.setText("username not exsist");
//            } else {
//                if (person1.isEmpty()) {
//                    txtpass.setText(("password not exsist"));
//                }else {
//
//                    server.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Search.fxml"))));
//            pesonDB pesonDB = new pesonDB() ;
//            ArrayList<String> person1 = new ArrayList<>();
//            person1 = pesonDB.getPerson(username);
//            if (username.equals(person1.get(0))){
//                if (pass.equals(person1.get(1))) {
//


        } catch (Exception e) {
            e.printStackTrace();
        }


//        try {
////            server.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Search.fxml"))));
//
//
//            pesonDB pesonDB = new pesonDB();
//




//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    });
        btnBack.setOnAction(event -> {
            try {
                client.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("login.fxml"))));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        btnExit.setOnAction(event -> {

            System.exit(0);
        });

        btnPhoto.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
            File selectedFile = fileChooser.showOpenDialog(null);
            if (selectedFile != null) {
                Image = selectedFile.getPath();

            }
//            fileChooser.setSelectedExtensionFilter();
        });

    }
}
