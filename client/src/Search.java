import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Search implements Initializable {
    public static   String Search;
    @FXML
    Button btnSearch ;
    @FXML
    Button btnBack ;
    @FXML
    Button btnExit ;
    @FXML
    TextField txtfSearch ;
@FXML
    Text txt ;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       btnSearch.setOnAction(event -> {
           Search = txtfSearch.getText();

           try {
               pesonDB pesonDB = new pesonDB();
               ArrayList<String> person2 = new ArrayList<>();
               person2 = pesonDB.getPerson(Search);
               if (person2.isEmpty() || Search.isEmpty()){
                   txt.setText("usernam does not exist");
               }else{

                   client.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("chatroom.fxml"))));

               }


           } catch (IOException e) {
               e.printStackTrace();
           } catch (Exception e) {
               e.printStackTrace();
           }
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
    }
}
