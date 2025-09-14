package BicycleSystem;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class ElectricBike extends Bicycle {
    private int batteryLevel;

    public ElectricBike(int id, String type, String status, int batteryLevel) {
        super(id, type, status);
        setBatteryLevel(batteryLevel);
    }

    public int getBatteryLevel() { return batteryLevel; }

    public void setBatteryLevel(int batteryLevel) {
        if (batteryLevel < 0) this.batteryLevel = 0;
        else if (batteryLevel > 100) this.batteryLevel = 100;
        else this.batteryLevel = batteryLevel;
    }

    @Override
    public boolean prestar() {
        if (batteryLevel <= 0) {
            System.out.println("La bicicleta está descargada y debe ser recargada.");
            return false;
        }
        return super.prestar();
    }

    @Override
    public void devolver() {
        super.devolver();
        int[] consumption = {10, 15, 20};
        int randomIndex = (int)(Math.random() * consumption.length);
        setBatteryLevel(batteryLevel - consumption[randomIndex]);

        if (batteryLevel == 0) {
            setStatus(Bicycle.STATUS_NO_DISPONIBLE);
            System.out.println("La bicicleta quedó descargada y no puede prestarse hasta recargarla.");
        }
    }

    public void chargeBattery() {
        final int steps = 20;
        System.out.println("Cargando batería:");

        ScheduledExecutorService ses = Executors.newSingleThreadScheduledExecutor();
        AtomicInteger step = new AtomicInteger(0);

        ses.scheduleAtFixedRate(() -> {
            int i = step.incrementAndGet();
            int percent = i * 100 / steps;

            StringBuilder bar = new StringBuilder("[");
            for (int j = 0; j < i; j++) bar.append("=");
            for (int j = i; j < steps; j++) bar.append(" ");
            bar.append("] ").append(percent).append("%");
            System.out.print("\r" + bar);

            if (i >= steps) {
                setBatteryLevel(100);
                setStatus(Bicycle.STATUS_DISPONIBLE);
                System.out.print("\r[====================] 100%\n");
                System.out.println("La bicicleta fue recargada al 100%.\n");
                ses.shutdown();
            }
        }, 0, 80, TimeUnit.MILLISECONDS);

        try {
            // Espera a que el programador termine; si no, lo forzamos
            if (!ses.awaitTermination(5, TimeUnit.SECONDS)) {
                ses.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            ses.shutdownNow();
        }
    }

    @Override
    public String toString() {
        return "[ID: " + getId() + "] Eléctrica - " + getStatus() + " (Batería: " + batteryLevel + "%)";
    }
}
