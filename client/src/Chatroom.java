
import com.sun.security.ntlm.Server;
import com.vdurmont.emoji.Emoji;
import com.vdurmont.emoji.EmojiParser;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.awt.Desktop;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class Chatroom implements Initializable {
    @FXML
    Button btnSend;
    @FXML
    Button btnh;
    @FXML
    Button btnInformation;
    @FXML
    Button btnFile;
    @FXML
    Button btnSetting;
    @FXML
    TextField txtfMessege;
    @FXML
    TextArea txta;
    @FXML
    Button btnL;
    @FXML
    Button btnc;
    @FXML
    Button btns;
    @FXML
    Button btnm;
    @FXML
    Button btnp;
    @FXML
    Button btnFS;





    public static String FileDirectory ;
















    String laugh = "\uD83D\uDE02";
    String cry = "\uD83D\uDE2D";
    String scared = "\uD83D\uDE31";
    String mad = "\uD83D\uDE21";
    String poker = "\uD83D\uDE10";
    String heart = "❤";



    public static String TEXT;
    public static int finalytimes[];

    public Chatroom() throws Exception {
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ArrayList<Integer> sort = new ArrayList<>() ;

        chatHistoryDB chatHistoryDB = null;
        try {
            chatHistoryDB = new chatHistoryDB();
        } catch (Exception e) {
            e.printStackTrace();
        }



        HashMap<Integer, String> times = new HashMap<>();
        try {
//                Addpayam payam = new Addpayam();
            for (int i = 0; i < chatHistoryDB.showPm(Login.username, Search.Search).size(); i++)
                times.put(time(chatHistoryDB.showDate(Login.username, Search.Search).get(i)), chatHistoryDB.showPm(Login.username, Search.Search).get(i));
            for (int i = 0; i < chatHistoryDB.showPm(Search.Search, Login.username).size(); i++)
                times.put(time(chatHistoryDB.showDate(Search.Search, Login.username).get(i)), chatHistoryDB.showPm(Search.Search, Login.username).get(i));


            List<Integer> timess = new ArrayList<>();
            for (int i = 0; i < chatHistoryDB.showPm(Login.username, Search.Search).size(); i++)
                timess.add(time(chatHistoryDB.showDate(Login.username, Search.Search).get(i)));

            for (int i = 0; i < chatHistoryDB.showPm(Search.Search, Login.username).size(); i++)
                timess.add(time(chatHistoryDB.showDate(Search.Search, Login.username).get(i)));



            int temp = 0;
            int finalytimes[] = new int[timess.size()];
            for (int i = 0; i < timess.size(); i++)
                finalytimes[i] = timess.get(i);

            for (int i = 0; i < timess.size(); i++)
                for (int j = 1; j < (timess.size() - i); j++)
                    if (finalytimes[j - 1] > finalytimes[j]) {
                        temp = finalytimes[j - 1];
                        finalytimes[j - 1] = finalytimes[j];
                        finalytimes[j] = temp;
                    }
        } catch (Exception e) {
            e.printStackTrace();
        }


//            HashMap<Integer , String> sort1 =new HashMap<>();
//
//            for (int i = 0 ; i < time() ;i++);
//                sort1.put()
//            HashMap< Integer > Sort = new  HashMap<>() ;






//        try {
//            chatHistoryDB chatHistoryDB = new chatHistoryDB();
//
//            for (int i = 0; i < chatHistoryDB.showPm(Login.username, Search.Search).size(); i++) {
//                chatHistoryDB.showPm(Login.username, Search.Search).get(i);
//            }
//            for (int i = 0; i < chatHistoryDB.showPm(Search.Search, Login.username).size(); i++) {
//                chatHistoryDB.showPm(Search.Search, Login.username).get(i);
//            }
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


        btnh.setOnAction(event -> {

            txtfMessege.setText(EmojiParser.parseToUnicode(heart));
        });

        btnL.setOnAction(event -> {

            txtfMessege.setText(EmojiParser.parseToUnicode(laugh));

        });
        btnc.setOnAction(event -> {

            txtfMessege.setText(EmojiParser.parseToUnicode(cry));
        });
        btns.setOnAction(event -> {

            txtfMessege.setText(EmojiParser.parseToUnicode(scared));
        });
        btnm.setOnAction(event -> {

            txtfMessege.setText(EmojiParser.parseToUnicode(mad));
        });

        btnp.setOnAction(event -> {

            txtfMessege.setText(EmojiParser.parseToUnicode(poker));
        });


        btnInformation.setOnAction(event -> {

            try {
                client.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("information.fxml"))));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });


        Date date = new Date();
        SimpleDateFormat format  = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
        String tarikh = format.format(date);


        btnSetting.setOnAction(event -> {
            try {
                client.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("setting.fxml"))));
            } catch (IOException e) {
                e.printStackTrace();
            }

        });
        try {
            pesonDB pd = new pesonDB();
            Image image = new Image(new FileInputStream(pd.getPerson(Search.Search).get(5)));
            ImageView iv = new ImageView(image);
            iv.setFitHeight(100);
            iv.setFitWidth(60);
            btnInformation.setGraphic(iv);


        } catch (Exception e) {
            e.printStackTrace();
        }


        btnSend.setOnAction(event -> {
            new Thread(() -> {

                try {
                    TEXT = txtfMessege.getText();
                    client.dos.writeUTF(Login.username + ":" + TEXT);
                    chatHistoryDB chatHistoryDB1 = new chatHistoryDB();
                    chatHistory chatHistory = new chatHistory(Login.username, Search.Search, TEXT, tarikh );
                    chatHistoryDB1.addpm(chatHistory);
                    txta.appendText("you :" + TEXT + "\n");

                    for (int i = 0; i < times.size(); i++) {
                        System.out.println(times.get(finalytimes[i])+"\n");
                        txta.appendText(times.get(finalytimes[i])+"\n");


                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }


            }).start();


        });
        btnFile.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
            File selectedFile = fileChooser.showOpenDialog(null);
            FileDirectory = selectedFile.getPath() ;

//            File file = new File(selectedFile.getPath());
//
//            if (!Desktop.isDesktopSupported()) {
//                System.out.println("Desktop is not supported");
//                return;
//            }
//
//            Desktop desktop = Desktop.getDesktop();
//            if (file.exists()) {
//                try {
//                    desktop.open(file);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            //let's try to open PDF file
//            file = new File(selectedFile.getPath());
//            if (file.exists()) {
//                try {
//                    desktop.open(file);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//            btnFS.setOnAction(event1 -> {
//
//                File file = new File(FileDirectory);
//                System.out.println("111");
//                if (!Desktop.isDesktopSupported()) {
//                    System.out.println("Desktop is not supported");
//                    return;
//                }
//
//                Desktop desktop = Desktop.getDesktop();
//                if (file.exists()) {
//                    try {
//                        desktop.open(file);
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//
//                //let's try to open PDF file
//                file = new File(FileDirectory);
//                if (file.exists()) {
//                    try {
//                        desktop.open(file);
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//
        });




        new Thread(() -> {
            try {

                while (true) {

                    TEXT = client.dis.readUTF();
                    txta.appendText(TEXT + "\n");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }).start();

    }

    public int time (String m) {

        String[] M  = m.split(" ");
        String[] M1 = M[1].split(":");
        String MM = M1[1] +""+ M1[0]+""+ M1[1] ;
        return Integer.parseInt(MM);
    }

}


