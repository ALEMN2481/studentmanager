package GymControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainGym {
    private final List<TrainerGym> trainers = new ArrayList<>();
    private final List<String> history = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    public void start() {
        int option;
        do {
            showMenu();
            option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1 -> registerTrainer();
                case 2 -> listTrainers();
                case 3 -> assignClient();
                case 4 -> viewHistory();
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
        System.out.printf("Entrenadores registrados: %d\n", trainers.size());
        System.out.println("------------------------------------------");
        System.out.println(" 1. Registrar entrenador");
        System.out.println(" 2. Listar entrenadores");
        System.out.println(" 3. Eliminar entrenador");
        System.out.println(" 4. Asignar cliente a entrenador");
        System.out.println(" 0. Salir");
        System.out.println("------------------------------------------");
        System.out.print ("Seleccione una opción: ");
    }

    void registerTrainer() {
        System.out.println("\nRegistrar entrenador");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Especialidad: ");
        String especialidad = scanner.nextLine();

        TrainerGym trainer = new TrainerGym(nombre, especialidad);
        trainers.add(trainer);
        System.out.println("\nEntrenador registrado: " + trainer + "\n");
    }

    void listTrainers() {
        System.out.println("\nEntrenadores registrados");
        if (trainers.isEmpty()) {
            System.out.println("No hay entrenadores registrados.\n");
        } else {
            for (TrainerGym t : trainers) {
                System.out.println(t);
            }
            System.out.println();
        }
    }

    void assignClient() {
        System.out.println("\nAsignar cliente a entrenador");
        if (trainers.isEmpty()) {
            System.out.println("No hay entrenadores registrados.\n");
            return;
        }
        System.out.print("Nombre del cliente: ");
        String cliente = scanner.nextLine();

        System.out.print("Nombre del entrenador: ");
        String nombreEntrenador = scanner.nextLine();

        TrainerGym trainer = null;
        for (TrainerGym t : trainers) {
            if (t.getNombre().equalsIgnoreCase(nombreEntrenador)) {
                trainer = t;
                break;
            }
        }
        if (trainer == null) {
            System.out.println("Entrenador no encontrado.\n");
            return;
        }
        trainer.addClient(cliente);
        history.add("Cliente " + cliente + " asignado a " + trainer.getNombre());
        System.out.println("Cliente asignado correctamente.\n");
    }

    void viewHistory() {
        System.out.println("\nHistorial de asignaciones");
        if (history.isEmpty()) {
            System.out.println("No hay movimientos registrados.\n");
        } else {
            for (String h : history) {
                System.out.println(h);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        MainGym system = new MainGym();
        system.start();
    }
}
