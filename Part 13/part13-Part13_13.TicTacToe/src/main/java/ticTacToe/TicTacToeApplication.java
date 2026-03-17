package ticTacToe;

import java.util.Arrays;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TicTacToeApplication extends Application{
    private String currentTurn = "X";
    private int turnCount = 0;

    public static void main(String[] args) {
        launch(TicTacToeApplication.class);
    }

    @Override
    public void start(Stage window){
        BorderPane layout = new BorderPane();

        Label turnLabel = new Label("Turn: X");

        GridPane grid = new GridPane();

        grid.setAlignment(Pos.CENTER);
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setPadding(new Insets(10, 10, 10, 10));

        Button[][] buttons = new Button[3][3];

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                Button btn = new Button(" ");
                btn.setFont(Font.font("Monospaced", 40));

                btn.setOnAction((event) -> {
                    if(btn.getText().equals(" ")){
                        btn.setText(currentTurn);
                        turnCount++;
                        if(currentTurn.equals("X")){
                            currentTurn = "O";
                            turnLabel.setText("Turn: O");
                        } else{
                            currentTurn = "X";
                            turnLabel.setText("Turn: X");
                        }

                        if(checkHorizontalWin(buttons) || 
                            checkVerticalWin(buttons) || 
                            checkDiagonalWin(buttons))
                        {
                            Arrays.stream(buttons)
                                    .flatMap(Arrays::stream)
                                    .forEach(b -> b.setDisable(true));
                            turnLabel.setText("The end!");
                        } else if(turnCount == 9){
                            turnLabel.setText("The end");
                        }
                    }
                });
                buttons[i][j] = btn;
                grid.add(btn, i, j);
            }
        }

        layout.setTop(turnLabel);
        layout.setCenter(grid);

        Scene scene = new Scene(layout, 450, 450);

        window.setScene(scene);
        window.show();
    }

    private boolean checkHorizontalWin(Button[][] buttons){
        for(int r = 0; r < buttons.length; r++){
            if(!buttons[r][0].getText().equals(" ") && 
                buttons[r][0].getText().equals(buttons[r][1].getText()) && 
                buttons[r][1].getText().equals(buttons[r][2].getText()))
            {
                return true;
            }
        }
        return false;
    }

    private boolean checkVerticalWin(Button[][] buttons){
        for(int c = 0; c < buttons[0].length; c++){
            if(!buttons[0][c].getText().equals(" ") &&
                buttons[0][c].getText().equals(buttons[1][c].getText()) &&
                buttons[1][c].getText().equals(buttons[2][c].getText()))
            {
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonalWin(Button[][] buttons){
        if(!buttons[0][0].getText().equals(" ") &&
            buttons[0][0].getText().equals(buttons[1][1].getText()) && 
            buttons[1][1].getText().equals(buttons[2][2].getText()))
            {
                return true;
            }
        
        if(!buttons[0][2].getText().equals(" ") &&
            buttons[0][2].getText().equals(buttons[1][1].getText()) &&
            buttons[1][1].getText().equals(buttons[2][0].getText()))
            {
                return true;
            }

        return false;
    }
}
