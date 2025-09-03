package SistemaGestionFlota;

public class UsuarioAdministrador extends Usuario {
    
    public UsuarioAdministrador(String nombre, String cedula) {
        super(nombre, cedula);
    }
    @Override
    public void consultarVehiculo(Vehiculo vehiculo) {
        System.out.println("Consultando vehiculo como Administrador: " + vehiculo.mostrarInfo());
    }
    @Override
    public void registrarVehiculo(Vehiculo vehiculo) {
        System.out.println("Registrando vehiculo: " + vehiculo.mostrarInfo());
    }
}
