package FlightControl;

import java.util.Scanner;

import FlightControl.logic.FlightControl;
import FlightControl.ui.TextUI;

public class Main {
    public static void main(String[] args) {
        FlightControl fc = new FlightControl();
        Scanner scanner = new Scanner(System.in);

        TextUI tui = new TextUI(fc, scanner);
        tui.start();
    }
}
