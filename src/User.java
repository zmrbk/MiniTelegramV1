public class User {
    // Parameters
    public int id;
    public String login;
    public String password;
    public String type;

    // Constructor
    public User(int id, String login, String password, String type) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.type = type;
    }
}