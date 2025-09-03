package SistemaGestionFlota;
import java.util.Scanner;

public class SistemaGestionFlota {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            Autobus autobus1 = new Autobus("Ruta A", 40);
            Taxi taxi1 = new Taxi("Juan Perez", "Tarifa 1");
            Bicicleta bici1 = new Bicicleta("Eléctrica");

            System.out.println("Bienvenido al Sistema de Gestión de Flota de Vehículos Urbanos");

            
            System.out.print("Ingrese su ID de usuario: ");
            String userId = scanner.nextLine();

         
            Usuario usuario;
            if (userId.equals("admin123")) {
                usuario = new UsuarioAdministrador("Admin1", "123456");
                System.out.println("Ha ingresado como Administrador.");
            } else if (userId.equals("user123")) {
                usuario = new UsuarioNormal("User1", "654321");
                System.out.println("Ha ingresado como Usuario Normal.");
            } else {
                System.out.println("ID de usuario no válido. Saliendo...");
                return;
            }

            while (true) {
              
                System.out.println("\n¿Qué desea hacer?");
                System.out.println("1. Consultar vehículos");
                if (usuario instanceof UsuarioAdministrador) {
                    System.out.println("2. Registrar vehículo");
                }
                System.out.println("0. Salir");
                System.out.print("Seleccione una opción: ");
                int opcion = scanner.nextInt();
                scanner.nextLine(); 

                switch (opcion) {
                    case 1:
             
                        System.out.println("\nConsultando vehículos..");
                        usuario.consultarVehiculo(autobus1);
                        usuario.consultarVehiculo(taxi1);
                        usuario.consultarVehiculo(bici1);
                        break;

                    case 2:
                        if (usuario instanceof UsuarioAdministrador) {
        
                            System.out.print("\nIngrese el tipo de vehículo a registrar (Autobús/Taxi/Bicicleta): ");
                            String tipoVehiculo = scanner.nextLine();
                            Vehiculo vehiculoRegistrado = null;

                            if (tipoVehiculo.equalsIgnoreCase("Autobús")) {
                                System.out.print("Ingrese la ruta del autobús: ");
                                String ruta = scanner.nextLine();
                                System.out.print("Ingrese el número de pasajeros: ");
                                int numPasajeros = scanner.nextInt();
                                scanner.nextLine(); 
                                System.out.print("Ingrese la velocidad promedio (km/h): ");
                                double velocidadPromedio = scanner.nextDouble();
                                scanner.nextLine();
                                vehiculoRegistrado = new Autobus(ruta, numPasajeros, velocidadPromedio);
                                
                            } else if (tipoVehiculo.equalsIgnoreCase("Taxi")) {
                                System.out.print("Ingrese el nombre del conductor: ");
                                String conductor = scanner.nextLine();
                                System.out.print("Ingrese la tarifa base: ");
                                String tarifaBase = scanner.nextLine();
                                vehiculoRegistrado = new Taxi(conductor, tarifaBase);
                            } else if (tipoVehiculo.equalsIgnoreCase("Bicicleta")) {
                                System.out.print("Ingrese el tipo de bicicleta (Eléctrica/Mecánica): ");
                                String tipoBici = scanner.nextLine();
                                vehiculoRegistrado = new Bicicleta(tipoBici);
                            } else {
                                System.out.println("Tipo de vehículo no válido.");
                                break;
                            }

                            usuario.registrarVehiculo(vehiculoRegistrado);
                        } else {
                            System.out.println("No tiene permisos para registrar vehículos.");
                        }
                        break;

                    case 0:
  
                        System.out.println("Saliendo del sistema.");
                        return;

                    default:
                        System.out.println("Opción no válida. Por favor intente nuevamente.");
                }
            }

        } finally {
            scanner.close(); 
        }
    }
}
