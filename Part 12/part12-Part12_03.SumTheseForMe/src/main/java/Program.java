
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // test your method here
        int[] numbers = {3, -1, 8, 4};

System.out.println(sum(numbers, 0, 0, 0, 0));
System.out.println(sum(numbers, 0, 0, 0, 10));
System.out.println(sum(numbers, 0, 1, 0, 10));
System.out.println(sum(numbers, 0, 1, -10, 10));
System.out.println(sum(numbers, -1, 999, -10, 10));

    }

    public static int sum(int[] array, int fromWhere, int toWhere, int smallest, int largest){
        int sum = 0;
        int startIndex = fromWhere;
        int endIndex = toWhere;

        if(startIndex < 0){
            startIndex = 0;
        }
        if(endIndex > array.length){
            endIndex = array.length;
        }

        for(int i = startIndex; i < endIndex; i++){
            if(array[i] >= smallest && array[i] <= largest){
                sum += array[i];
            }
        }

        return sum;
    }

}
