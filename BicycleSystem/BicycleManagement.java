package BicycleSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class BicycleManagement {
    ArrayList<User> users = new ArrayList<User>();
    ArrayList<Bicycle> bicycles = new ArrayList<Bicycle>();
    ArrayList<String> history = new ArrayList<String>();
    Scanner scanner = new Scanner(System.in);

    void start() {
        int option;
        do {
            showMenu();
            option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    registerUser();
                    break;
                case 2:
                    registerBicycle();
                    break;
                case 3:
                    listUsers();
                    break;
                case 4:
                    listBicycles();
                    break;
                case 5:
                    listAvailableBicycles();
                    break;
                case 6:
                    borrowBicycle();
                    break;
                case 7:
                    returnBicycle();
                    break;
                case 8:
                    viewHistory();
                    break;
                case 9:
                    rechargeElectricBike();
                    break;
                case 0:
                    System.out.println("\nSaliendo del sistema...\n");
                    break;
                default:
                    System.out.println("\nOpción inválida.\n");
            }
        } while (option != 0);
    }

    void showMenu() {
        System.out.println();
        System.out.println("==========================================");
        System.out.println("      SISTEMA DE GESTIÓN DE BICICLETAS    ");
        System.out.println("==========================================");
        System.out.printf("Usuarios registrados   : %d\n", users.size());
        System.out.printf("Bicicletas registradas : %d\n", bicycles.size());
        System.out.println("------------------------------------------");
        System.out.println(" 1. Registrar usuario");
        System.out.println(" 2. Registrar bicicleta");
        System.out.println(" 3. Listar usuarios");
        System.out.println(" 4. Listar bicicletas");
        System.out.println(" 5. Listar bicicletas disponibles");
        System.out.println(" 6. Prestar bicicleta");
        System.out.println(" 7. Devolver bicicleta");
        System.out.println(" 8. Ver historial");
        System.out.println(" 9. Recargar bicicleta eléctrica");
        System.out.println(" 0. Salir");
        System.out.println("------------------------------------------");
        System.out.print ("Seleccione una opción: ");
    }

    void registerUser() {
        System.out.println("\nRegistrar usuario");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Documento: ");
        String documento = scanner.nextLine();

        System.out.print("Tipo (Estudiante/Empleado): ");
        String tipo = scanner.nextLine();

        try {
            User user = new User(nombre, documento, tipo);
            users.add(user);
            System.out.println("\nUsuario registrado: " + user + "\n");
        } catch (IllegalArgumentException e) {
            System.out.println("\nError: " + e.getMessage() + "\n");
        }
    }

    void registerBicycle() {
        System.out.println("\nRegistrar bicicleta");

        System.out.print("ID único: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        String tipo = "";
        while (true) {
            System.out.print("Tipo (Mecánica/Eléctrica): ");
            tipo = scanner.nextLine().trim().toLowerCase();
            if (tipo.equals("mecánica") || tipo.equals("mecanica") || tipo.equals("eléctrica") || tipo.equals("electrica")) {
                break;
            } else {
                System.out.println("Tipo inválido. Escriba 'Mecánica' o 'Eléctrica'.");
            }
        }

        String status = Bicycle.STATUS_DISPONIBLE;

        if (tipo.equals("eléctrica") || tipo.equals("electrica")) {
            ElectricBike ebike = new ElectricBike(id, "Eléctrica", status, 100);
            bicycles.add(ebike);
            System.out.println("\nBicicleta eléctrica registrada: " + ebike + "\n");
        } else {
            Bicycle bike = new Bicycle(id, "Mecánica", status);
            bicycles.add(bike);
            System.out.println("\nBicicleta mecánica registrada: " + bike + "\n");
        }
    }

    void listUsers() {
        System.out.println("\nUsuarios registrados");
        if (users.isEmpty()) {
            System.out.println("No hay usuarios registrados.\n");
        } else {
            for (User u : users) {
                System.out.println(u);
            }
            System.out.println();
        }
    }

    void listBicycles() {
        System.out.println("\nTodas las bicicletas");
        if (bicycles.isEmpty()) {
            System.out.println("No hay bicicletas registradas.\n");
        } else {
            for (Bicycle b : bicycles) {
                System.out.println(b);
            }
            System.out.println();
        }
    }

    void listAvailableBicycles() {
        System.out.println("\nBicicletas disponibles");
        boolean found = false;
        for (Bicycle b : bicycles) {
            if (b.getStatus().equals(Bicycle.STATUS_DISPONIBLE)) {
                System.out.println(b);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No hay bicicletas disponibles.");
        }
        System.out.println();
    }

    void borrowBicycle() {
        System.out.println("\nPrestar bicicleta");
        if (users.isEmpty() || bicycles.isEmpty()) {
            System.out.println("Debe haber usuarios y bicicletas registradas primero.\n");
            return;
        }

        System.out.print("Documento del usuario: ");
        String doc = scanner.nextLine();
        User user = null;
        for (User u : users) {
            if (u.getDocumento().equals(doc)) {
                user = u;
                break;
            }
        }

        if (user == null) {
            System.out.println("Usuario no encontrado.\n");
            return;
        }

        listAvailableBicycles();
        System.out.print("ID de bicicleta a prestar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Bicycle bike = null;
        for (Bicycle b : bicycles) {
            if (b.getId() == id) {
                bike = b;
                break;
            }
        }

        if (bike == null) {
            System.out.println("Bicicleta no encontrada.\n");
            return;
        }

        if (bike.prestar()) {
            history.add("Préstamo: " + user.getNombre() + " tomó " + bike);
            System.out.println("Bicicleta prestada: " + bike + "\n");
        } else {
            System.out.println("No se pudo prestar la bicicleta.\n");
        }
    }

    void returnBicycle() {
        System.out.println("\nDevolver bicicleta");
        System.out.print("ID de bicicleta a devolver: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Bicycle bike = null;
        for (Bicycle b : bicycles) {
            if (b.getId() == id) {
                bike = b;
                break;
            }
        }

        if (bike == null) {
            System.out.println("Bicicleta no encontrada.\n");
            return;
        }

        bike.devolver();
        history.add("Devolución: Bicicleta devuelta " + bike);
        System.out.println("Bicicleta devuelta: " + bike + "\n");
    }

    void viewHistory() {
        System.out.println("\nHistorial de préstamos/devoluciones");
        if (history.isEmpty()) {
            System.out.println("No hay movimientos registrados.\n");
        } else {
            for (String h : history) {
                System.out.println(h);
            }
            System.out.println();
        }
    }

    void rechargeElectricBike() {
        System.out.println("\nRecargar bicicleta eléctrica");
        System.out.print("ID de bicicleta: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Bicycle b : bicycles) {
            if (b.getId() == id && b instanceof ElectricBike) {
                ((ElectricBike) b).chargeBattery();
                System.out.println("Bicicleta recargada: " + b + "\n");
                return;
            }
        }
        System.out.println("No se encontró una bicicleta eléctrica con ese ID.\n");
    }

    public static void main(String[] args) {
        BicycleManagement system = new BicycleManagement();
        system.start();
    }
}
