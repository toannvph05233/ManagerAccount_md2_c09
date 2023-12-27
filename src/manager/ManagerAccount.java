package manager;

import model.Account;
import model.Role;

import java.util.ArrayList;
import java.util.Scanner;

public class ManagerAccount {
    ArrayList<Account> accounts = new ArrayList<>();
    ArrayList<Role> roles = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);


    public ManagerAccount() {
        roles.add(new Role(1, "Admin"));
        roles.add(new Role(2, "User"));
        roles.add(new Role(3, "Guest"));
    }

    public void login(){
        System.out.println("Nhập username");
        String username = scanner.nextLine();
        System.out.println("Nhập password");
        String password = scanner.nextLine();
        Account account = checkLogin(username,password);
        if (account!= null){
            System.out.println("Xin chào " + account.getUsername() + " - " + account.getRole().getName());
        }else {
            System.err.println("Bạn đã đăng nhập lỗi");
        }
    }


    public Account checkLogin(String username, String password) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getUsername().equals(username)
                    && accounts.get(i).getPassword().equals(password)) {
                return accounts.get(i);
            }
        }
        return null;
    }

    public void add(Account account) {
        accounts.add(account);
    }

    public boolean checkUsername(String username) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public String validateUsername() {
        while (true) {
            System.out.println("Nhập username");
            String username = scanner.nextLine();
            if (checkUsername(username)) {
                System.err.println("username đã trùng");
            } else {
                return username;
            }
        }
    }

    public String validatePassword() {
        while (true) {
            System.out.println("Nhập password");
            String password = scanner.nextLine();
            System.out.println("Nhập lại password");
            String rePassword = scanner.nextLine();
            if (password.equals(rePassword)) {
                return password;
            } else {
                System.err.println("pass không trùng nhập lại");
            }
        }
    }
    public Role choiceRole() {
        System.out.println("Danh sách quyền trong hệ thống");
        for (int i = 0; i < roles.size(); i++) {
            System.out.println(i+1 + " - " + roles.get(i).getName());
        }
        int choice = Integer.parseInt(scanner.nextLine());
        return roles.get(choice);
    }

    public Account create() {
        String username = validateUsername();
        String password = validatePassword();
        Role role = choiceRole();
        return new Account(username,password,role);
    }
}
