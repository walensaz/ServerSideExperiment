package objects.preconnection;


public class Login {

    //Email and password is nullable, none of the others are
    private String email;
    private String password;
    private String username;

    public Login(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Login(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return (email == null || email.equals("")) ? "Login#" + username + ":" : "Login#" + username + ":" + password + ":";
    }
}
