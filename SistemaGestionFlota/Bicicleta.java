package SistemaGestionFlota;

public class Bicicleta extends Vehiculo {
    private String tipoBicicleta;
    
    public Bicicleta(String tipoBicicleta) {
        super("Bicicleta");
        this.tipoBicicleta = tipoBicicleta;
    }
    
    @Override
    public String mostrarInfo() {
        return "Tipo de bicicleta: " + tipoBicicleta + ", Estado: " + getEstado();
    }
}

