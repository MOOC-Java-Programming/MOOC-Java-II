
import java.util.ArrayList;
import java.util.Scanner;

public class PrintingUserInput {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> inputs = new ArrayList<>();

        while(true){
            String userInput = scanner.nextLine();

            if(userInput.isEmpty()){
                printInput(inputs);
                break;
            }
            inputs.add(userInput);

        }

    }

    public static void printInput(ArrayList<String> strings){
        strings.stream().forEach(string -> System.out.println(string));
    }
}
