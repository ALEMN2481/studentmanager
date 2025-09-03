package SistemaGestionFlota;

public class Taxi extends Vehiculo {
    private String conductor;
    private String tarifaBase;

    public Taxi(String conductor, String tarifaBase) {
        super("Taxi");
        this.conductor = conductor;
        this.tarifaBase = tarifaBase;
    }

    @Override
    public String mostrarInfo() {
        return "Conductor: " + conductor + ", Tarifa Base: " + tarifaBase + ", Estado: " + getEstado();
    }
}
