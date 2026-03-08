import java.util.ArrayList;

public class MisplacingBox extends Box{
    private ArrayList<Item> misplacedItems;

    public MisplacingBox(){
        misplacedItems = new ArrayList<>();
    }

    @Override
    public void add(Item item){
        misplacedItems.add(item);
    }

    @Override
    public boolean isInBox(Item item){
        return false;
    }
}
