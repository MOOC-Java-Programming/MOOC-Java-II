
import java.util.ArrayList;
import java.util.Scanner;

public class LimitedNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> values = new ArrayList<>();

        while(true){
            int input = scanner.nextInt();

            if(input < 0){
                printValuesBetween1And5(values);
                break;
            }

            values.add(input);
        }

    }

    public static void printValuesBetween1And5(ArrayList<Integer> numbers){
        numbers.stream().filter(n -> (n > 1 && n <= 5)).forEach(v -> System.out.println(v));
    }
}
