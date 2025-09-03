package SistemaGestionFlota;

public class Bicicleta extends Vehiculo {
    private String tipoBici;

    public Bicicleta(String tipoBici) {
        super("Bicicleta");
        this.tipoBici = tipoBici;
    }

    @Override
    public String mostrarInfo() {
        return "Tipo de bicicleta: " + tipoBici + ", Estado: " + getEstado();
    }
}

