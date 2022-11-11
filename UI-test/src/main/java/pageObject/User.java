package pageObject;

public class User {

    public String getName() {
        return userName;
    }

    public String getEmail() {
        return userEmail;
    }

    public String getPassword() {
        return userPassword;
    }

    private final String userName;
    private final String userEmail;
    private final String userPassword;

    public User(String userName, String userEmail, String userPassword) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }

}
