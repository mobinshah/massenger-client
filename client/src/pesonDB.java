import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class pesonDB {
    private Connection connection;
    private PreparedStatement preparedStatement;

    public pesonDB() throws Exception {
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/massenger?currentSchema=public", "massenger", "momlifelove");
    }

    public void addPerson(User user) throws Exception {
        preparedStatement = connection.prepareStatement("insert into person values (default ,?,?,?,?,?,?)");
        preparedStatement.setString(1, user.getUsername());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.setString(3, user.getEmail());
        preparedStatement.setString(4, user.getFirstname());
        preparedStatement.setString(5, user.getLastname());
preparedStatement.setString(6,user.getImage());
        preparedStatement.executeUpdate();
    }

    public ArrayList<String> getPerson(String username) throws Exception {
//        System.out.println("hi");
        preparedStatement = connection.prepareStatement("select * from person where username = ?");
        preparedStatement.setString(1, username);
        ResultSet resultSet = preparedStatement.executeQuery();
        ArrayList<String> getperson = new ArrayList<>();
//        System.out.println("by");
        if (resultSet.next()) {
            getperson.add(resultSet.getString("username"));
            getperson.add(resultSet.getString("pass"));
            getperson.add(resultSet.getString("email"));
            getperson.add(resultSet.getString("firstname"));
            getperson.add(resultSet.getString("lastname"));
            getperson.add(resultSet.getString("photo"));

        }



        return getperson;


    }

//    public String getPerson(String username) throws Exception{
//        preparedStatement = connection.prepareStatement("select * from person where username = ?");
//        preparedStatement.setString(1,username);
//        ResultSet resultSet = preparedStatement.executeQuery();
//        resultSet.next();
//        String s = resultSet.getString("username");
//        return s;
//    }

    public void changePass(String login, String newPass) throws Exception{
        preparedStatement = connection.prepareStatement("update person set pass = ? where username = ?");
        preparedStatement.setString(1, newPass);
        preparedStatement.setString(2,Login.username);
        preparedStatement.executeUpdate();
    }
    public void changeFirstname(String login, String newFirstname) throws Exception{
        preparedStatement = connection.prepareStatement("update person set firstname = ? where username = ?");
        preparedStatement.setString(1, newFirstname);
        preparedStatement.setString(2,Login.username);
        preparedStatement.executeUpdate();
    }
    public void changeLastname(String login, String newLastname) throws Exception{
        preparedStatement = connection.prepareStatement("update person set lastname = ? where username = ?");
        preparedStatement.setString(1, newLastname);
        preparedStatement.setString(2,Login.username);
        preparedStatement.executeUpdate();
    }public void changeEmail(String login, String newEmail) throws Exception{
        preparedStatement = connection.prepareStatement("update person set email = ? where username = ?");
        preparedStatement.setString(1, newEmail);
        preparedStatement.setString(2,Login.username);
        preparedStatement.executeUpdate();
    }
    public void changeUsername(String login, String newUsername) throws Exception{
        preparedStatement = connection.prepareStatement("update person set username = ? where username = ?");
        preparedStatement.setString(1, newUsername);
        preparedStatement.setString(2,Login.username);
        preparedStatement.executeUpdate();
    }




    public void deletePerson(String username) throws Exception {
        preparedStatement = connection.prepareStatement("delete from person where username = ?");
        preparedStatement.setString(1, username);
        preparedStatement.executeUpdate();
    }

    public void close() throws Exception {
        preparedStatement.close();
        connection.close();
    }


}
