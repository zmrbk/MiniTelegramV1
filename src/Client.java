public class Client extends User {
    // Parameters
    public String name;
    public String surname;
    public String birthDate;

    // Constructor
    public Client(int id, String login, String password, String name, String surname, String birthDate) {
        super(id, login, password, "Client");
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
    }
}
