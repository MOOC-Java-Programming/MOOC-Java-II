package application;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private Scanner scanner;
    private TodoDao database;

    public UserInterface(Scanner scanner, TodoDao database) {
        this.scanner = scanner;
        this.database = database;
    }

    public void start() throws SQLException {
        while (true) {
            System.out.println("");
            System.out.println("Enter command:");
            System.out.println("1) list");
            System.out.println("2) add");
            System.out.println("3) mark as done");
            System.out.println("4) remove");
            System.out.println("x) quit");

            System.out.print("> ");
            String command = this.scanner.nextLine();
            if (command.equals("x")) {
                break;
            }

            // implement the functionality here

            if(command.equals("1")){
                printList(database.list());
            }
            if(command.equals("2")){
                database.add(askToAdd());
            }
            if(command.equals("3")){
                database.markAsDone(askToMarkAsDone());
            }
            if(command.equals("4")){
                database.remove(askToRemoveTodo());
            }
        }

        System.out.println("Thank you!");
    }

    private void printList(List<Todo> list){
        System.out.println("Listing the database contents");
        list.stream().forEach(l -> System.out.println(l));
    }

    private Todo askToAdd(){
        System.out.println("Adding a new todo\nEnter a name");
        String name = scanner.nextLine();
        System.out.println("Enter a description");
        String desc = scanner.nextLine();
        return new Todo(name, desc, false);
    }

    private int askToMarkAsDone(){
        System.out.println("Which todo should be marked as done (give the id)?");
        return Integer.valueOf(scanner.nextLine());
    }

    private int askToRemoveTodo(){
        System.out.println("Which todo should be removed (give the id)?");
        return Integer.valueOf(scanner.nextLine());
    }

}
