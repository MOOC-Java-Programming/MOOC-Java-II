import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private Map<String, Item> cart;

    public ShoppingCart(){
        cart = new HashMap<>();
    }

    public void add(String product, int price){
        if(cart.containsKey(product)){
            increaseQuantity(product);
        } else{
            cart.put(product, new Item(product, 1, price));
        }
    }

    public void increaseQuantity(String product){
        cart.get(product).increaseQuantity();
    }

    public int price(){
        int total = 0;

        for (Item eachItem : cart.values()) {
            total += eachItem.price();   
        }

        return total;
    }

    public void print(){
        for (Item eachItem : cart.values()) {
            System.out.println(eachItem);
        }
    }
}
