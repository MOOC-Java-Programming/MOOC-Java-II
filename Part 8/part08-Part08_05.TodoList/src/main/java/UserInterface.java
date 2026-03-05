import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    
    private TodoList list;
    private Scanner scanner;

    public UserInterface(TodoList list, Scanner scanner){
        this.list = list;
        this.scanner = scanner;
    }

    public void start(){
        while(true){
            System.out.print("Command: ");
            String input = scanner.nextLine();

            if(input.equals("stop")){
                break;
            }

            if(input.equals("add")){
                System.out.print("To add: ");
                String toAdd = scanner.nextLine();
                list.add(toAdd);
            }

            if(input.equals("list")){
                list.print();
            }

            if(input.equals("remove")){
                System.out.print("Which one is removed? ");
                int removed = Integer.valueOf(scanner.nextLine());
                list.remove(removed);
            }
        }
    }
}
