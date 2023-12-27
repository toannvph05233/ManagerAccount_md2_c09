import manager.ManagerAccount;
import model.Account;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static ManagerAccount managerAccount = new ManagerAccount();
    public static void main(String[] args) {
        while (true){
            System.out.println("Xin chào");
            System.out.println("1. Login");
            System.out.println("2. Register");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    managerAccount.login();
                    break;
                case 2:
                    Account account = managerAccount.create();
                    managerAccount.add(account);
                    break;
                default:
                    System.err.println("Nhập sai");
            }
        }
    }


}