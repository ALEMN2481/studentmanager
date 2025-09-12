package BicycleSystem;

public class ElectricBike extends Bicycle {
    private int batteryLevel;

    public ElectricBike(int id, String type, String status, int batteryLevel) {
        super(id, type, status);
        this.batteryLevel = batteryLevel;
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }

    public void setBatteryLevel(int batteryLevel) {
        if (batteryLevel < 0) this.batteryLevel = 0;
        else if (batteryLevel > 100) this.batteryLevel = 100;
        else this.batteryLevel = batteryLevel;
    }

    @Override
    public void devolver() {
        super.devolver(); // vuelve a disponible
        int[] consumption = {10, 15, 20};
        int randomIndex = (int)(Math.random() * consumption.length);
        setBatteryLevel(batteryLevel - consumption[randomIndex]);

        if (batteryLevel == 0) {
            setStatus(Bicycle.STATUS_NO_DISPONIBLE);
            System.out.println("La bicicleta debe ser recargada.");
        }
    }

    public void chargeBattery() {
        setBatteryLevel(100);
        System.out.println("La bicicleta fue recargada al 100%.");
    }

    @Override
    public String toString() {
        return "[ID: " + getId() + "] Eléctrica - " + getStatus() + " (Batería: " + batteryLevel + "%)";
    }
}
