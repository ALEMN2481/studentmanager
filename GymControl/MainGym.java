package GymControl;

import java.util.Scanner;

public class MainGym {
    private final Scanner scanner = new Scanner(System.in);

    public void start() {
        int option;
        do {
            showMenu();
            option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1 -> System.out.println("Registrar entrenador (implementación pendiente)");
                case 2 -> System.out.println("Listar entrenadores (implementación pendiente)");
                case 3 -> System.out.println("Eliminar entrenador (implementación pendiente)");
                case 4 -> System.out.println("Asignar cliente a entrenador (implementación pendiente)");
                case 0 -> System.out.println("\nSaliendo del sistema...\n");
                default -> System.out.println("\nOpción inválida.\n");
            }
        } while (option != 0);
    }

    void showMenu() {
        System.out.println();
        System.out.println("==========================================");
        System.out.println("      SISTEMA DE GESTIÓN DE ENTRENADORES  ");
        System.out.println("==========================================");
        System.out.println(" 1. Registrar entrenador");
        System.out.println(" 2. Listar entrenadores");
        System.out.println(" 3. Eliminar entrenador");
        System.out.println(" 4. Asignar cliente a entrenador");
        System.out.println(" 0. Salir");
        System.out.println("------------------------------------------");
        System.out.print ("Seleccione una opción: ");
    }

    public static void main(String[] args) {
        MainGym system = new MainGym();
        system.start();
    }
}
