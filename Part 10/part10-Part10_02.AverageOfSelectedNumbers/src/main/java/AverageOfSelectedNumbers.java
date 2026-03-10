
import java.util.ArrayList;
import java.util.Scanner;

public class AverageOfSelectedNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // toteuta ohjelmasi tänne

        ArrayList<String> inputs = new ArrayList<>();
        System.out.println("Input numbers, type \"end\" to stop.");
        while(true){
            String input = scanner.nextLine();

            if(input.equals("end")){
                break;
            }
            inputs.add(input);
        }

        double positiveAverage = inputs.stream()
                                        .mapToInt(numbers -> Integer.valueOf(numbers))
                                        .filter(number -> number > 0)
                                        .average()
                                        .getAsDouble();

        double negativeAverage = inputs.stream()
                                        .mapToInt(numbers -> Integer.valueOf(numbers))
                                        .filter(number -> number < 0)
                                        .average()
                                        .getAsDouble();
        System.out.println("Print the average of the negative numbers or the positive numbers? (n/p)");
        String option = scanner.nextLine();

        if(option.equals("n")){
            System.out.println("Average of the negative numbers: " + negativeAverage);
        } else{
            System.out.println("Average of the positive numbers: " + positiveAverage);
        }

    }
}
