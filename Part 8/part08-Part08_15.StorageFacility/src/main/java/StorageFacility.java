import java.util.ArrayList;
import java.util.HashMap;

public class StorageFacility {
    private HashMap<String, ArrayList<String>> facility;

    public StorageFacility(){
        this.facility = new HashMap<>();
    }

    public void add(String unit, String item){
        facility.putIfAbsent(unit, new ArrayList<>());

        facility.get(unit).add(item);
    }

    public ArrayList<String> contents(String storageUnit){
        ArrayList<String> emptyList = new ArrayList<>();
        return facility.getOrDefault(storageUnit, emptyList);
    }

    public void remove(String storageUnit, String item){
        facility.get(storageUnit).remove(item);
    }

    public ArrayList<String> storageUnits(){
        ArrayList<String> unitsToReturn = new ArrayList<>();

        for(String unit : facility.keySet()){
            if(!facility.get(unit).isEmpty()){
                unitsToReturn.add(unit);
            }
        }

        return unitsToReturn;
    }
}
