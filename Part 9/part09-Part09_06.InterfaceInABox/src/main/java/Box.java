import java.util.ArrayList;

public class Box implements Packable{
    private double maxCapacity;
    private ArrayList<Packable> items;

    public Box(double maxCapacity){
        this.maxCapacity = maxCapacity;
        items = new ArrayList<>();
    }

    public void add(Packable item){
        if(weight() + item.weight() <= maxCapacity){
            items.add(item);
        }
    }

    @Override
    public double weight(){
        double total = 0;
        for (Packable item : items) {
            total += item.weight();
        }

        return total;
    }

    @Override
    public String toString(){
        return "Box: " + items.size() + " items, total weight " + weight() + " kg";
    }
    
}
