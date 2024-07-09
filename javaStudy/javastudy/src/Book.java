import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Book implements Comparable<Book> {
    String name;
    double price;

    public Book(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public int compareTo(Book other) {
        return Double.compare(this.price, other.price);
    }

    @Override
    public String toString() {
        return name + "," + price;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Book> books = new ArrayList<>();
        String line;

        System.out.println("input several Book,in the end #");
        while (!(line = scanner.nextLine()).equals("#")) {
            String[] parts = line.split(",");
            String name = parts[0];
            double price = Double.parseDouble(parts[1]);
            books.add(new Book(name, price));
        }

        System.out.println("input a new Book:");
        line = scanner.nextLine();
        String[] parts = line.split(",");
        String name = parts[0];
        double price = Double.parseDouble(parts[1]);
        Book newBook = new Book(name, price);

        System.out.print("new book:<" + newBook.name + ">as same books\n");
        for (Book book : books) {
            if (book.compareTo(newBook) == 0) {
                System.out.println(book);
            }
        }
    }

}


//import java.util.*;
//
//class Book implements Comparable<Book> {
//    String name;
//    double price;
//
//    Book(String name, double price) {
//        this.name = name;
//        this.price = price;
//    }
//
//    @Override
//    public int compareTo(Book other) {
//        return Double.compare(this.price, other.price);
//    }
//
//    @Override
//    public String toString() {
//        return name + "," + price;
//    }
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        Set<Book> books = new TreeSet<>();
//        System.out.println("input several Book,in the end #");
//
//        while (true) {
//            String input = scanner.nextLine();
//            if (input.equals("#")) {
//                break;
//            }
//            String[] parts = input.split(",");
//            String name = parts[0];
//            double price = Double.parseDouble(parts[1]);
//            books.add(new Book(name, price));
//        }
//
//        System.out.print("input a new Book:\n");
//        String input = scanner.nextLine();
//        String[] parts = input.split(",");
//        String name = parts[0];
//        double price = Double.parseDouble(parts[1]);
//        Book newBook = new Book(name, price);
//        boolean found = false;
//        Book temp = new Book("", 100);
//        for (Book book : books) {
//            if (!book.toString().contains(newBook.toString())) {
//                System.out.println("new book:<" + name + ">as same books");
//                return;
//            }
//        }
//        System.out.println("new book:<" + name + ">no same books");
//
//
//    }
//}
//
