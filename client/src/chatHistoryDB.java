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
        preparedStatement = connection.prepareStatement("insert into chathistory values (default ,?,?,?,?)");
        preparedStatement.setString(1, chatHistory.getUsernamesend());
        preparedStatement.setString(2, chatHistory.getUsernameresive());
        preparedStatement.setString(3, chatHistory.getPmresive());
        preparedStatement.setString(4, chatHistory.getDate());
        preparedStatement.executeUpdate();
    }
    public ArrayList<String> showPm(String usersend, String userresive) throws Exception {

        preparedStatement = connection.prepareStatement("select pmresive from chathistory where (usernamesend = ? AND usernameresive=?)OR (usernameresive = ? AND usernamesend = ?)");
        preparedStatement.setString(1, usersend);
        preparedStatement.setString(2, userresive);
        preparedStatement.setString(3, userresive);
        preparedStatement.setString(4, usersend);
        ResultSet resultSet = preparedStatement.executeQuery();

        ArrayList<String> showPm = new ArrayList<>();

        while (resultSet.next()) {
//            showPm.add(resultSet.getString("usernamesend"));
//            showPm.add(resultSet.getString("usernameresive"));
            showPm.add(resultSet.getString("pmresive"));
        }


        return showPm;


    }

    public ArrayList<String> showDate(String usersend, String userresive) throws Exception {
        preparedStatement = connection.prepareStatement("select date from chathistory where (usernamesend = ? AND usernameresive=?)");
        preparedStatement.setString(1, usersend);
        preparedStatement.setString(2, userresive);
        ResultSet resultSet = preparedStatement.executeQuery();
        ArrayList<String> showDate = new ArrayList<>();
        while (resultSet.next()) {
            showDate.add(resultSet.getString("Date"));
        }
        return showDate;

    }

}
