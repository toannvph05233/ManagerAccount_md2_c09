package io;

import model.Role;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RoleIO {
    public static void readRole(ArrayList<Role> roleList) {
        try {
            File roles = new File("roles.txt");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(roles));
            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                String[] arr = str.split(",");
                roleList.add(new Role(Integer.parseInt(arr[0]), arr[1]));
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("loi đọc file");
        }
    }

    public static void writeRole(ArrayList<Role> roleList) {
        try {
            File roles = new File("roles.txt");
            FileWriter fileWriter = new FileWriter(roles);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Role r : roleList) {
                bufferedWriter.write(r.getId() + "," + r.getName());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Loi file");
        }
    }
}
