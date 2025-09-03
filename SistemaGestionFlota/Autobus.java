package SistemaGestionFlota;

public class Autobus extends Vehiculo {
    private String ruta;
    private int numPasajeros;
    
    public Autobus(String ruta, int numPasajeros) {
        super("Autobús");
        this.ruta = ruta;
        this.numPasajeros = numPasajeros;
    }
    
    @Override
    public String mostrarInfo() {
        return "Ruta: " + ruta + ", Pasajeros actuales: " + numPasajeros + ", Estado: " + getEstado();
    }
}
