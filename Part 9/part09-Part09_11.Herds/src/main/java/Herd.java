import java.util.ArrayList;

public class Herd implements Movable{
    
    private ArrayList<Movable> herdList;

    public Herd(){
        this.herdList = new ArrayList<>();
    }

    public void addToHerd(Movable movable){
        herdList.add(movable);
    }

    @Override
    public void move(int dx, int dy){
        for (Movable movable : herdList) {
            movable.move(dx, dy);
        }
    }

    @Override
    public String toString(){
        String returnString = "";
        
        for (Movable movable : herdList) {
            returnString += movable.toString() + "\n";
        }

        return returnString;
    }
}
