package BicycleSystem;

public class ElectricBike extends Bicycle {
    private int batteryLevel;

    public ElectricBike(int ID, String Type, String Status, int batteryLevel) {
        super(ID, Type, Status);
        this.batteryLevel = batteryLevel;
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }

    public void setBatteryLevel(int batteryLevel) {
        this.batteryLevel = batteryLevel;
    }
    
}
