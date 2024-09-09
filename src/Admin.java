public class Admin extends User {
    // Parameters
    public String name;
    public String phoneNumber;

    // Constructor
    public Admin(int id, String login, String password, String name, String phoneNumber) {
        super(id, login, password, "Admin");
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
}
