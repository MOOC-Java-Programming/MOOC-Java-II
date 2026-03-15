
import java.util.ArrayList;
import java.util.Random;

public class LotteryRow {

    private ArrayList<Integer> numbers;

    public LotteryRow() {
        this.randomizeNumbers();
    }

    public ArrayList<Integer> numbers() {
        return this.numbers;
    }

    public void randomizeNumbers() {
        // Initialize the list for numbers
        this.numbers = new ArrayList<>();
        Random rand = new Random();

        while(numbers.size() < 7){
            int randomNum = rand.nextInt(40) + 1;
            if(!containsNumber(randomNum)){
                numbers.add(randomNum);
            }
        }
    }

    public boolean containsNumber(int number) {
        return numbers.contains(number);
    }
}

