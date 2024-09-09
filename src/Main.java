import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Program program = new Program();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hi, type 'help' to see available commands.");

        while (true) {
            System.out.print("Enter command: ");
            String command = scanner.nextLine();

            if (command.equals("register")) {
                System.out.println("<<<<<<<<<<<<<<< Registration starts >>>>>>>>>>>>>>>");
                program.register(scanner);
            } else if (command.equals("login")) {
                System.out.println("<<<<<<<<<<<<<<< Authentication starts >>>>>>>>>>>>>>>");
                program.login(scanner);
            } else if (command.equals("logout")) {
                System.out.println("<<<<<<<<<<<<<<< You logged out >>>>>>>>>>>>>>>");
                program.logout();
            } else if (command.equals("help")) {
                System.out.println("<<<<<<<<<<<<<<<<<<<< Help >>>>>>>>>>>>>>>>>>>>");
                program.help();
            } else if (command.equals("exit")) {
                System.out.println("<<<<<<<<<<<<<<< Program completion >>>>>>>>>>>>>>>");
                System.out.println("<<<<<<<<<<<<<<<<<< Good luck!!! >>>>>>>>>>>>>>>>>>");
                break;
            } else if (command.equals("info")) {
                System.out.println("<<<<<<<<<<<<<<<< User Information >>>>>>>>>>>>>>>>>");
                program.info();
            } else if (command.equals("info_all")) {
                System.out.println("<<<<<<<<<<<<<<<<<<<< Info all >>>>>>>>>>>>>>>>>>>>");
                program.infoAll();
            } else if (command.equals("info_login")) {
                program.infoLogin(scanner);
            } else if (command.equals("info_id")) {
                program.infoId(scanner);
//            } else if (command.equals("update_user_password")) {
//                program.changeUserPassword(scanner);
            } else if (command.equals("delete_user_id")) {
                program.deleteUser(scanner);
            } else if (command.equals("add_item")) {
                System.out.println("<<<<<<<<<<<<<<<<<< Add product >>>>>>>>>>>>>>>>>>");
                program.addItem(scanner);
            } else if (command.equals("my_items")) {
                System.out.println("<<<<<<<<<<<<<<<<<<<< My items >>>>>>>>>>>>>>>>>>>>");
                program.myItems();
            } else if (command.equals("all_items")) {
                System.out.println("<<<<<<<<<<<<<<<<<<<< All items >>>>>>>>>>>>>>>>>>>>");
                program.allItems();
            } else {
                System.out.println("Unknown command. Type 'help' to see available commands.");
            }
        }
    }
}

