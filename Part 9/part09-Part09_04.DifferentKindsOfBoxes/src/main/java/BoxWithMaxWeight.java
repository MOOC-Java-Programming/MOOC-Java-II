import java.util.ArrayList;

public class BoxWithMaxWeight extends Box{
    private ArrayList<Item> itemsInMaxWeightedBox;
    private int maxCapacity;

    public BoxWithMaxWeight(int capacity){
        itemsInMaxWeightedBox = new ArrayList<>();
        this.maxCapacity = capacity;
    }

    private int currentCapacity(){
        if(itemsInMaxWeightedBox.isEmpty()) return 0;

        int total = 0;
        for (Item item : itemsInMaxWeightedBox) {
            total += item.getWeight();
        }

        return total;
    }

    @Override
    public void add(Item item){
        if(item.getWeight() + currentCapacity() <= maxCapacity){
            itemsInMaxWeightedBox.add(item);
        }
    }

    @Override
    public boolean isInBox(Item item){
        return itemsInMaxWeightedBox.contains(item);
    }
}
