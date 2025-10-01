package GymControl;

public class TrainerGym {
    private String nombre;
    private String especialidad;

    public TrainerGym(String nombre, String especialidad) {
        this.nombre = nombre;
        this.especialidad = especialidad;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Entrenador: " + nombre + ", Especialidad: " + especialidad;
    }
}