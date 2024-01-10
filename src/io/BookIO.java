package io;

import model.Book;
import model.Role;

import java.io.*;
import java.util.ArrayList;

public class BookIO {
    public static void readBook(ArrayList<Book> books) {
        try {
            File file = new File("books.txt");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                String[] arr = str.split(",");
                books.add(new Book(Integer.parseInt(arr[0]), arr[1], arr[2], arr[3]));
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("loi đọc file");
        }
    }

    public static void writeBook(ArrayList<Book> books) {
        try {
            File file = new File("books.txt");
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Book b : books) {
                bufferedWriter.write(b.getId() + "," + b.getName()+ "," + b.getCategory()+ "," + b.getAuthor());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Loi file");
        }
    }
}
