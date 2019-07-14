import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class chatHistoryDB {
    private Connection connection;
    private PreparedStatement preparedStatement;

    public chatHistoryDB() throws Exception {
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/massenger?currentSchema=public", "massenger", "momlifelove");



    }
    public void addpm(chatHistory chatHistory) throws Exception {
        preparedStatement = connection.prepareStatement("insert into person values (default ,?,?,?,?,?)");
        preparedStatement.setString(1, chatHistory.getUsernamesend());
        preparedStatement.setString(2, chatHistory.getUsernameresive());
        preparedStatement.setString(3, chatHistory.getPmsend());
        preparedStatement.setString(4, chatHistory.getPmresive());
        preparedStatement.setString(5, chatHistory.getDate());
        preparedStatement.executeUpdate();
    }
    public ArrayList<String> showPm(String username) throws Exception {

        preparedStatement = connection.prepareStatement("select * from person where username = ?");
        preparedStatement.setString(1, username);
        ResultSet resultSet = preparedStatement.executeQuery();
        ArrayList<String> showPm = new ArrayList<>();

        if (resultSet.next()) {
            showPm.add(resultSet.getString("usernamesend"));
            showPm.add(resultSet.getString("usernameresive"));
            showPm.add(resultSet.getString("pmsend"));
            showPm.add(resultSet.getString("pmresive"));
            showPm.add(resultSet.getString("date"));

        }



        return showPm;


    }





}
