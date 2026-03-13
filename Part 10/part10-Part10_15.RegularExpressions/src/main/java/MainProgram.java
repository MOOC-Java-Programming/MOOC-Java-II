

public class MainProgram {

    public static void main(String[] args) {
        // you can create test code here. Call the methods that you'll implement
        // during the course of this exercise

        Checker ch = new Checker();
        System.out.println(ch.timeOfDay("45:34:56"));
        System.out.println(ch.timeOfDay("17:23:05"));
        System.out.println(ch.timeOfDay("33:33:33"));
    }
}
