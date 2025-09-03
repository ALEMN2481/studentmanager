package SistemaGestionFlota;

public class Autobus extends Vehiculo {
    private String ruta;
    private int numPasajeros;
    private double velocidadPromedio;

    public Autobus(String ruta, int numPasajeros, double velocidadPromedio) {
        super("Autobus");
        this.ruta = ruta;
        this.numPasajeros = numPasajeros;
        this.velocidadPromedio = velocidadPromedio;
    }

    @Override
    public String mostrarInfo() {
        return "Ruta: " + ruta + ", Pasajeros actuales: " + numPasajeros +
               ", Velocidad Promedio: " + velocidadPromedio + " km/h, Estado: " + getEstado();
    }
}
