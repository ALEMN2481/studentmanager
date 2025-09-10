package BicycleSystem;

public class ElectricBike extends Bicycle {
    private int batteryLevel = 100;

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
    
        public int OpBatteryLevel() {
        String Status = getStatus();
        if (Status.equals("Prestada")) {
            int[] consumption = {10, 15, 20};
            int randomIndex = (int)(Math.random() * consumption.length);
            batteryLevel = batteryLevel - consumption[randomIndex];
            if (batteryLevel <= 0) {
                batteryLevel = 0;
                setStatus("No disponible");
                System.out.println("La bicicleta debe ser recargada.");
            }
        }
        return batteryLevel;
    }

    public void ChargeBattery() {
        batteryLevel = 100;
    }


}
