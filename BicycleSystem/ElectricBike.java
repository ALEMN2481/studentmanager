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
    public boolean prestar() {
        if (super.prestar()) {
            int[] consumption = {10, 15, 20};
            int randomIndex = (int)(Math.random() * consumption.length);
            setBatteryLevel(batteryLevel - consumption[randomIndex]);

            if (batteryLevel == 0) {
                setStatus(Bicycle.STATUS_NO_DISPONIBLE);
                System.out.println("La bicicleta quedó sin batería y debe ser recargada.");
                return false;
            }
            return true;
        }
        return false;
    }

    @Override
    public void devolver() {
        super.devolver();
        if (batteryLevel == 0) {
            setStatus(Bicycle.STATUS_NO_DISPONIBLE);
            System.out.println("La bicicleta está descargada y no puede usarse hasta recargarla.");
        }
    }

    public void chargeBattery() {
        int steps = 20;
        System.out.println("Cargando batería:");
        for (int i = 1; i <= steps; i++) {
            int percent = i * 100 / steps;
            StringBuilder bar = new StringBuilder("[");
            for (int j = 0; j < i; j++) bar.append("=");
            for (int j = i; j < steps; j++) bar.append(" ");
            bar.append("] ").append(percent).append("%");
            System.out.print("\r" + bar.toString());
            System.out.flush();
            try {
                Thread.sleep(80); // Simula el tiempo de carga
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        setBatteryLevel(100);
        setStatus(Bicycle.STATUS_DISPONIBLE);
        System.out.print("\r[====================] 100%\n");
        System.out.println("La bicicleta fue recargada al 100%.\n");
    }

    @Override
    public String toString() {
        return "[ID: " + getId() + "] Eléctrica - " + getStatus() + " (Batería: " + batteryLevel + "%)";
    }
}
