
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class MainProgram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Book> books = new ArrayList<>();

        while(true) {
            System.out.print("Input the name of the book, empty stops: ");
            String bookName = scanner.nextLine();

            if(bookName.isEmpty()){
                System.out.println(books.size() + " books in total.\nBooks:");
                sortBooksByAgeAndName(books);
                break;
            }
            System.out.print("Input the age recommendation: ");
            int age = Integer.valueOf(scanner.nextLine());
            books.add(new Book(bookName, age));
        }
    }

    public static void printBooks(ArrayList<Book> books){
        books.stream().forEach(b -> System.out.println(b));
    }

    public static void printSortedBooks(ArrayList<Book> books){
        books.stream().sorted().forEach(b -> System.out.println(b));
    }

    public static void sortBooksByAgeAndName(ArrayList<Book> books){
        Comparator<Book> comparator = Comparator.comparing(Book::getAge)
                                                .thenComparing(Book::getName);

        Collections.sort(books, comparator);
        books.stream().forEach(b -> System.out.println(b));
    }
}
