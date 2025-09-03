package SistemaGestionFlota;

public abstract class Usuario {
    protected String nombre;
    protected String cedula;
    
    public Usuario(String nombre, String cedula) {
        this.nombre = nombre;
        this.cedula = cedula;
    }
    public abstract void consultarVehiculo(Vehiculo vehiculo);
    
    public abstract void registrarVehiculo(Vehiculo vehiculo);
}
