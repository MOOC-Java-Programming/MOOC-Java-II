package application;

import java.util.Random;

public class TemperatureSensor implements Sensor{
    private boolean isOn;

    public TemperatureSensor(){
        this.isOn = false;
    }

    @Override
    public boolean isOn() {
        return isOn;
    }

    @Override
    public int read(){
        if(isOn){
            return new Random().nextInt(61) -30;
        }
        throw new IllegalStateException();
    }

    @Override
    public void setOff() {
        isOn = false;
    }

    @Override
    public void setOn() {
        isOn = true;
    }
}
