
import java.util.ArrayList;
import java.util.Scanner;

public class AverageOfNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Write your program here

        ArrayList<String> inputs = new ArrayList<>();
        System.out.println("Input numbers, type \"end\" to stop.");
        while(true){
            String input = scanner.nextLine();

            if(input.equals("end")){
                break;
            }
            inputs.add(input);
        }

        double average = inputs.stream()
                                .mapToInt(numbers -> Integer.valueOf(numbers))
                                .average()
                                .getAsDouble();

        System.out.println("Average of the numbers: " + average);

    }
}
