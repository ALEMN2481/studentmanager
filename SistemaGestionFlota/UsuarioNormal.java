package SistemaGestionFlota;

public class UsuarioNormal extends Usuario {
    
    public UsuarioNormal(String nombre, String cedula) {
        super(nombre, cedula);
    }
    
    @Override
    public void consultarVehiculo(Vehiculo vehiculo) {
        System.out.println("Consultando vehiculo como Usuario Normal: " + vehiculo.mostrarInfo());
    }
    
    @Override
    public void registrarVehiculo(Vehiculo vehiculo) {
        System.out.println("No tiene permisos para registrar vehículos.");
    }
}
