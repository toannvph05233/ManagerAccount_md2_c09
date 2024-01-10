package manager;

import io.BookIO;
import model.Book;

import java.util.ArrayList;
import java.util.Scanner;

public class ManagerBook {
    ArrayList<Book> books = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public ManagerBook() {
        BookIO.readBook(books);
    }

    public void addBook(Book book) {
        books.add(book);
        BookIO.writeBook(books);
    }

    public void display() {
        for (Book b : books) {
            System.out.println(b);
        }
    }

    public void editBook(int index, Book book) {
        book.setId(books.get(index).getId());
        books.set(index, book);
        BookIO.writeBook(books);
    }

    public void deleteBook(int index) {
        books.remove(index);
        BookIO.writeBook(books);
    }

    public Book create() {
        String name = validateName();
        System.out.println("Nhập thể loại");
        String category = scanner.nextLine();
        System.out.println("nhập tác giả");
        String author = scanner.nextLine();
        int idEnd = 0;
        try {
            idEnd = books.get(books.size() - 1).getId();
        } catch (Exception e) {

        }
        return new Book(idEnd + 1, name, category, author);
    }

    public String validateName() {
        while (true) {
            System.out.println("Nhập name");
            String name = scanner.nextLine();
            if (checkName(name)) {
                return name;
            } else {
                System.err.println("trùng tên rồi");
            }
        }
    }

    public boolean checkName(String name) {
        for (Book b : books) {
            if (b.getName().equals(name)) {
                return false;
            }
        }
        return true;
    }

    public ArrayList<Book> findAllByName(String name) {
        ArrayList<Book> findBook = new ArrayList<>();
        for (Book b : books) {
            if (b.getName().contains(name)) {
                findBook.add(b);
            }
        }
        return findBook;
    }

    public int findIndexByName(String name) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }
}
