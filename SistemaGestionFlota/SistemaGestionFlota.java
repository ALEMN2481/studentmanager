package SistemaGestionFlota;
public class SistemaGestionFlota {
    public static void main(String[] args) {

        Autobus autobus1 = new Autobus("Ruta A", 40);
        Taxi taxi1 = new Taxi("Juan Perez", "Tarifa 1");
        Bicicleta bici1 = new Bicicleta("Eléctrica");

    
        Usuario administrador = new UsuarioAdministrador("Admin1", "123456");
        Usuario usuarioNormal = new UsuarioNormal("User1", "654321");


        
        administrador.consultarVehiculo(autobus1);
        administrador.consultarVehiculo(taxi1);
        administrador.consultarVehiculo(bici1);

        usuarioNormal.consultarVehiculo(autobus1);
        usuarioNormal.consultarVehiculo(taxi1);
        usuarioNormal.consultarVehiculo(bici1);
        
        administrador.registrarVehiculo(autobus1);
        usuarioNormal.registrarVehiculo(autobus1);
    }
}
