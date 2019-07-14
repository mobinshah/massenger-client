import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class client extends Application{
    public static DataInputStream dis ;
    public static DataOutputStream dos ;
    static Stage stage ;
    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("localhost",8088);

//            Socket socket ;
             dos =new DataOutputStream(socket.getOutputStream());
             dis = new java.io.DataInputStream(socket.getInputStream());
        launch();
    }

    @Override
    public void start(Stage Stage) throws Exception {
        stage = Stage;
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        Stage.setScene(new Scene(root, 600, 600));
        Stage.setTitle("Messanger");
        stage.alwaysOnTopProperty();
        Stage.show();

    }
}
