import java.util.ArrayList;

public class OneItemBox extends Box{
    
    private ArrayList<Item> oneItem;

    public OneItemBox(){
        oneItem = new ArrayList<>();
    }

    @Override
    public void add(Item item){
        if(oneItem.isEmpty()){
            oneItem.add(item);
        }
    }

    @Override
    public boolean isInBox(Item item){
        return oneItem.contains(item);
    }
}
