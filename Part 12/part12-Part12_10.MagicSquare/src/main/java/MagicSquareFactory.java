
public class MagicSquareFactory {

    public MagicSquare createMagicSquare(int size) {

        MagicSquare square = new MagicSquare(size);

        // implement the creation of a magic square with the Siamese method algorithm here
        int currentRow = 0;
        int currentCol = size / 2;
        int currentNumber = 1;

        while(currentNumber <= (size * size)){
            square.placeValue(currentRow, currentCol, currentNumber);
            
            int nextRow = currentRow - 1;
            int nextCol = currentCol + 1;

            if(nextRow < 0){
                nextRow = size - 1;
            }
            if(nextCol >= size){
                nextCol = 0;
            }
            if(square.readValue(nextRow, nextCol) == 0){
                currentRow = nextRow;
                currentCol = nextCol;
            }else{
                currentRow++;
            }
            currentNumber++;
        }

        return square;
    }

}
