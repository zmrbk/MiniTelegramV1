public class Seller extends User {
    // Parameters
    public String name;
    public String surname;
    public String shopName;
    public String shoppingStartDate;

    // Constructor
    public Seller(int id, String login, String password, String name, String surname, String shopName, String shoppingStartDate) {
        super(id, login, password, "Seller");
        this.name = name;
        this.surname = surname;
        this.shopName = shopName;
        this.shoppingStartDate = shoppingStartDate;
    }
}
