package GymControl;

public class TrainerGym extends CoachCntrl {
    private String tipoEntrenamientoString;
    private double salarioBase;
    private double bonoEjercicio;

    public TrainerGym(String nombre, int id, int añosExperiencia, String tipoEntrenamientoString, double salarioBase,
            double bonoEjercicio) {
        super(nombre, id, añosExperiencia);
        this.tipoEntrenamientoString = tipoEntrenamientoString;
        this.salarioBase = salarioBase;
        this.bonoEjercicio = bonoEjercicio;
    }

    public String getTipoEntrenamiento() {
        return tipoEntrenamientoString;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public double getBonoEjercicio() {
        return bonoEjercicio;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public void setBonoEjercicio(double bonoEjercicio) {
        this.bonoEjercicio = bonoEjercicio;
    }

    @Override
    public double calcularSalario() {
        return salarioBase + bonoEjercicio;
    }

    @Override
    public String toString() {
        return super.toString() + ", Tipo de Entrenamiento=" + tipoEntrenamientoString + ", Salario="
                + calcularSalario();
    }
}