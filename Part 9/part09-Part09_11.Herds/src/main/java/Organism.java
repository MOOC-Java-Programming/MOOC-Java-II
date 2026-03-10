public class Organism implements Movable{
    private int xCoord;
    private int yCoord;

    public Organism(int x, int y){
        this.xCoord = x;
        this.yCoord = y;
    }

    @Override
    public String toString(){
        return "x: " + xCoord + "; y: " + yCoord;
    }

    public void move(int dx, int dy){
        xCoord += dx;
        yCoord += dy;
    }
}
