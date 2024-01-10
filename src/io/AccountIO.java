package io;

import model.Account;
import model.Role;

import java.io.*;
import java.util.ArrayList;

public class AccountIO {
    public static void readAccount(ArrayList<Account> accounts, ArrayList<Role> roles) {
        try {
            File file = new File("accounts.txt");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                String[] arr = str.split(",");

                int idRole = Integer.parseInt(arr[3]);
                for (Role r : roles) {
                    if (r.getId() == idRole) {
                        Account account = new Account(Integer.parseInt(arr[0]), arr[1], arr[2], r);
                        accounts.add(account);
                    }
                }
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("loi đọc file");
        }
    }

    public static void writeAccount(ArrayList<Account> accounts) {
        try {
            File file = new File("accounts.txt");
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Account a : accounts) {
                bufferedWriter.write(a.getId() + "," + a.getUsername() + "," + a.getPassword() + "," + a.getRole().getId());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Loi file");
        }
    }
}
