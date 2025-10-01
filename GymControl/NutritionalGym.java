package GymControl;

public class NutritionalGym extends Coach {
    private String especialidad;
    private double salarioBase;
    private double bonoNutricionista;

    public NutritionalGym(String nombre, int id, int añosExperiencia, String especialidad, double salarioBase,
            double bonoNutricionista) {
        super(nombre, id, añosExperiencia);
        this.especialidad = especialidad;
        this.salarioBase = salarioBase;
        this.bonoNutricionista = bonoNutricionista;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public void setBonoNutricionista(double bonoNutricionista) {
        this.bonoNutricionista = bonoNutricionista;
    }

    @Override
    public double calcularSalario() {
        return salarioBase + bonoNutricionista;
    }

    @Override
    public String toString() {
        return super.toString() + ", Especialidad=" + especialidad + ", Salario=" + calcularSalario();
    }
}
