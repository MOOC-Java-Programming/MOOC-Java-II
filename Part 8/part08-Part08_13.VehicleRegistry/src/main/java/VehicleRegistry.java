import java.util.ArrayList;
import java.util.HashMap;

public class VehicleRegistry {
    
    private HashMap<LicensePlate, String> register;

    public VehicleRegistry(){
        this.register = new HashMap<>();
    }
    public boolean add(LicensePlate licensePlate, String owner){
        for(LicensePlate lp : register.keySet()){
            if(lp.equals(licensePlate)){
                return false;
            }
        }

        register.put(licensePlate, owner);
        return true;
    }

    public String get(LicensePlate licensePlate){
        return register.get(licensePlate);
    }

    public boolean remove(LicensePlate licensePlate){
        if(!register.containsKey(licensePlate)) return false;

        register.remove(licensePlate);
        return true;
    }

    public void printLicensePlates(){
        for(LicensePlate lp : register.keySet()){
            System.out.println(lp);
        }
    }

    public void printOwners(){

        ArrayList<String> owners = new ArrayList<>();

        for(String carOwner : register.values()){
            if(!owners.contains(carOwner)){
                owners.add(carOwner);
            }
        }

        for (String owner : owners) {
            System.out.println(owner);
        }
    }
}
