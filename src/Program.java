import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Program {
    // Parameters
    private List<User> users;
    private List<Item> items;
    private User currentUser;

    // Constructor
    public Program() {
        this.users = new ArrayList<>();
        this.items = new ArrayList<>();
        this.currentUser = null;
    }

    // Registration and login method
    public void register(Scanner scanner) {
//        if (loggedInUser != null) {
//            System.out.println("You are already logged in. Please logout first.");
//            return;
//        }

        System.out.print("Enter login: ");
        String login = scanner.nextLine();

        if (login.length() < 5 || !login.matches("[a-z]+")) {
            System.out.println("Login should be at least 5 characters long and contain only lowercase letters.");
            System.out.println("Please, register again.");
            return;
        }

        // TODO: check login. Not works contains?
        if (users.contains(login)) {
            System.out.println("User with this login already exists.");
            return;
        }

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (password.length() < 6 || !password.matches(".*[A-Z].*") || !password.matches(".*\\d.*") || password.contains(" ")) {
            System.out.println("Password should be at least 6 characters long, contain at least one uppercase letter, one digit, and no spaces.");
            System.out.println("Please, register again.");
            return;
        }

        System.out.print("Enter type (Admin, Client, Seller): ");
        String type = scanner.nextLine();

        if (type.equals("Admin")) {
            System.out.print("Enter name: ");
            String name = scanner.nextLine();
            System.out.print("Enter phone number: ");
            String phoneNumber = scanner.nextLine();
            users.add(new Admin(users.size() + 1, login, password, name, phoneNumber));
            System.out.println("User registered successfully.");
        } else if (type.equals("Client")) {
            System.out.print("Enter name: ");
            String name = scanner.nextLine();
            System.out.print("Enter surname: ");
            String surname = scanner.nextLine();
            System.out.print("Enter birth date: ");
            String birthDate = scanner.nextLine();
            users.add(new Client(users.size() + 1, login, password, name, surname, birthDate));
            System.out.println("User registered successfully.");
        } else if (type.equals("Seller")) {
            System.out.print("Enter name: ");
            String name = scanner.nextLine();
            System.out.print("Enter surname: ");
            String surname = scanner.nextLine();
            System.out.print("Enter shop name: ");
            String shopName = scanner.nextLine();
            System.out.print("Enter shopping start date: ");
            String shoppingStartDate = scanner.nextLine();
            users.add(new Seller(users.size() + 1, login, password, name, surname, shopName, shoppingStartDate));
            System.out.println("User registered successfully.");
        } else {
            System.out.println("Unknown command. Please register again");
        }
    }

    // Login method
    public void login(Scanner scanner) {
        System.out.print("Enter login: ");
        String login = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        for (User user : users) {
            if (user.login.equals(login) && user.password.equals(password)) {
                currentUser = user;
                return;
            }
        }
        System.out.println("User not found. Type 'help' to see available commands.");
    }

    // Logout method
    public void logout() {
        currentUser = null;
        System.out.println();
    }

    // Help method
    public void help() {
        System.out.println("register - Register a new user.");
        System.out.println("login - Login to the system.");
        System.out.println("logout - Logout from the system.");
        System.out.println("help - Show list of commands available to the system.");
        System.out.println("exit - Exit the program.");
        System.out.println("info - Show information about the authorized user.");
        System.out.println("info_all - Show information about all users of the system (for Admin only).");
        System.out.println("info_login - Show user information by login (all system users).");
        System.out.println("info_id - Show user information by id (all system users).");
        System.out.println("delete_user_id - Delete user by id (for Admin only).");
        System.out.println("change_user_password - Update user id (all system users).");
        System.out.println("add_item - Add a new product (for Seller only).");
        System.out.println("my_items - Show all products of the authenticated seller (for Seller only).");
        System.out.println("all_items - Show all products in the system (for Admin only).");
        System.out.println();
    }

    // Info method
    public void info() {
        if (currentUser == null) {
            System.out.println("You are not logged in. Type 'help' to see available commands.");
            return;
        }
        System.out.println("Id: " + currentUser.id);
        System.out.println("Login: " + currentUser.login);
        System.out.println("Type: " + currentUser.type);

        if (currentUser instanceof Admin) {
            Admin admin = (Admin) currentUser;
            System.out.println("Name: " + admin.name);
            System.out.println("Phone number: " + admin.phoneNumber);
            System.out.println();
        } else if (currentUser instanceof Client) {
            Client client = (Client) currentUser;
            System.out.println("Name: " + client.name);
            System.out.println("Surname: " + client.surname);
            System.out.println("Birth date: " + client.birthDate);
            System.out.println();
        } else if (currentUser instanceof Seller) {
            Seller seller = (Seller) currentUser;
            System.out.println("Name: " + seller.name);
            System.out.println("Surname: " + seller.surname);
            System.out.println("Shop name: " + seller.shopName);
            System.out.println("Trade start date: " + seller.shoppingStartDate);
            System.out.println();
        } else {
            System.out.println("User not found. Type 'help' to see available commands.");
        }
    }

    // Info all method
    public void infoAll() {
        if (currentUser == null || !(currentUser instanceof Admin)) {
            System.out.println("You are not an Admin. Type 'help' to see available commands.");
            return;
        }

        for (User user : users) {
            System.out.println("Id: " + user.id);
            System.out.println("Login: " + user.login);
            System.out.println("Type: " + user.type);

            if (user instanceof Admin) {
                Admin admin = (Admin) user;
                System.out.println("Name: " + admin.name);
                System.out.println("Phone number: " + admin.phoneNumber);
                System.out.println();
            } else if (user instanceof Client) {
                Client client = (Client) user;
                System.out.println("Name: " + client.name);
                System.out.println("Surname: " + client.surname);
                System.out.println("Birth date: " + client.birthDate);
                System.out.println();
            } else if (user instanceof Seller) {
                Seller seller = (Seller) user;
                System.out.println("Name: " + seller.name);
                System.out.println("Surname: " + seller.surname);
                System.out.println("Shop name: " + seller.shopName);
                System.out.println("Shopping start date: " + seller.shoppingStartDate);
                System.out.println();
            }
        }
    }

    // Info login method
    public void infoLogin(Scanner scanner) {
        System.out.print("Enter login: ");
        String login = scanner.nextLine();
        System.out.println("<<<<<<<<<<<<<<<<<<< Info login >>>>>>>>>>>>>>>>>>>");

        for (User user : users) {
            if (user.login.equals(login)) {
                System.out.println("Login: " + user.login);
                System.out.println("Type: " + user.type);

                if (user instanceof Admin) {
                    Admin admin = (Admin) user;
                    System.out.println("Name: " + admin.name);
                    System.out.println("Phone number: " + admin.phoneNumber);
                    System.out.println();
                } else if (user instanceof Client) {
                    Client client = (Client) user;
                    System.out.println("Name: " + client.name);
                    System.out.println("Surname: " + client.surname);
                    System.out.println("Birth date: " + client.birthDate);
                    System.out.println();
                } else if (user instanceof Seller) {
                    Seller seller = (Seller) user;
                    System.out.println("Name: " + seller.name);
                    System.out.println("Surname: " + seller.surname);
                    System.out.println("Shop name: " + seller.shopName);
                    System.out.println("Trade start date: " + seller.shoppingStartDate);
                    System.out.println();
                } else {
                    System.out.println("User not found. Type 'help' to see available commands.");
                }
                return;
            }
        }
    }

    // Info id method
    public void infoId(Scanner scanner) {
        System.out.print("Enter id: ");
        int id = scanner.nextInt();
        System.out.println("<<<<<<<<<<<<<<<<<<<<< Info id >>>>>>>>>>>>>>>>>>>>>");

        for (User user : users) {
            if (user.id == id) {
                System.out.println("Id: " + user.id);
                System.out.println("Type: " + user.type);

                if (user instanceof Admin) {
                    Admin admin = (Admin) user;
                    System.out.println("Name: " + admin.name);
                    System.out.println("Phone number: " + admin.phoneNumber);
                    System.out.println();
                } else if (user instanceof Client) {
                    Client client = (Client) user;
                    System.out.println("Name: " + client.name);
                    System.out.println("Surname: " + client.surname);
                    System.out.println("Birth date: " + client.birthDate);
                    System.out.println();
                } else if (user instanceof Seller) {
                    Seller seller = (Seller) user;
                    System.out.println("Name: " + seller.name);
                    System.out.println("Surname: " + seller.surname);
                    System.out.println("Shop name: " + seller.shopName);
                    System.out.println("Trade start date: " + seller.shoppingStartDate);
                    System.out.println();
                } else {
                    System.out.println("User not found. Type 'help' to see available commands.");
                }
                return;
            }
        }
    }

    // Change user password
//    public void changeUserPassword(Scanner scanner) {
//
//    }

    // Delete user by id
    public void deleteUser(Scanner scanner) {
        if (currentUser == null || !(currentUser instanceof Admin)) {
            System.out.println("You are not an Admin. Type 'help' to see available commands.");
            return;
        }
        System.out.print("Enter id: ");
        int id = scanner.nextInt();
        System.out.println("<<<<<<<<<<<<<<<<<<< Deleted user id >>>>>>>>>>>>>>>>>>>>");
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).id == id) {
                users.remove(i);
                return;
            }
        }
    }

    // Add item method
    public void addItem(Scanner scanner) {
        // Checking if you are not a Seller
        if (currentUser == null || !(currentUser instanceof Seller)) {
            System.out.println("You are not a Seller. Type 'help' to see available commands.");
            return;
        }
        System.out.print("Enter item name: ");
        String name = scanner.nextLine();
        System.out.print("Enter item price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter item quantity: ");
        int quantity = scanner.nextInt();
        items.add(new Item(name, price, quantity));
        System.out.println("Product successfully added.");
    }

    // My items method
    public void myItems() {
        // Checking if you are not a Seller
        if (currentUser == null || !(currentUser instanceof Seller)) {
            System.out.println("You are not a Seller. Type 'help' to see available commands.");
            return;
        }
        for (Item item : items) {
            System.out.println("Item information: ");
            System.out.println("Name: " + item.name);
            System.out.println("Price: " + item.price);
            System.out.println("Quantity: " + item.quantity);
            System.out.println();
        }
    }

    // All items method
    public void allItems() {
        if (currentUser == null || !(currentUser instanceof Admin)) {
            System.out.println("You are not an Admin. Type 'help' to see available commands.");
            return;
        }
        for (Item item : items) {
            System.out.println("Name: " + item.name);
            System.out.println("Price: " + item.price);
            System.out.println("Quantity: " + item.quantity);
            System.out.println();
        }
    }
}

