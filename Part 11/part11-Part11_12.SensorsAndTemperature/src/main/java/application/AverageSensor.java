package application;

import java.util.ArrayList;
import java.util.List;

public class AverageSensor implements Sensor{

    private List<Sensor> sensors;
    private List<Integer> pastReadings;
    
    public AverageSensor() {
        sensors = new ArrayList<>();
        pastReadings = new ArrayList<>();
    }

    @Override
    public boolean isOn() {
        for (Sensor sensor : sensors) {
            if(!sensor.isOn()){
                return false;
            }
        }
        return true;
    }

    @Override
    public int read() {
        if(isOn()){
            int average = (int) sensors.stream().mapToInt(x -> x.read()).average().orElse(0.0);
            pastReadings.add(average);
            return average;
        }

        throw new IllegalArgumentException();
    }

    @Override
    public void setOff() {
        for (Sensor sensor : sensors) {
            sensor.setOff();
        }
        
    }

    @Override
    public void setOn() {
        for (Sensor sensor : sensors) {
            sensor.setOn();
        }
        
    }
    
    public void addSensor(Sensor toAdd){
        sensors.add(toAdd);
    }

    public List<Integer> readings(){
        return pastReadings;
    }

}
