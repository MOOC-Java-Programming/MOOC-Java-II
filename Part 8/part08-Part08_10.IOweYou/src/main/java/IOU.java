import java.util.HashMap;

public class IOU {
    
    private HashMap<String, Double> debtHashMap;

    public IOU(){
        this.debtHashMap = new HashMap<>();
    }

    public void setSum(String toWhom, double amount){
        debtHashMap.put(toWhom, amount);
    }

    public double howMuchDoIOweTo(String toWhom){
        if(debtHashMap.containsKey(toWhom)){
            return debtHashMap.get(toWhom);
        }
        return 0;
    }
}
