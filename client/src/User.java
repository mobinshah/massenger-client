import com.sun.javafx.binding.StringFormatter;

public class User {
    private String username;
    private String password;
    private String firstname ;
    private String lastname ;
    private String email ;
    private String Image ;


    public User(String username, String password, String firstname , String lastname, String email, String Image ) {
        this.username = username;
        this.password = password;
        this.firstname = firstname ;
        this.lastname = lastname ;
        this.email = email ;
        this.Image = Image ;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User() {
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }



}