package GymControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class MainGym {
    protected final List<TrainerGym> trainers = new ArrayList<>();
    protected final Scanner scanner = new Scanner(System.in);

    public void start() {
        int option;
        do {
            showMenu();
            option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1 -> registerTrainer();
                case 2 -> listTrainers();
                case 3 -> removeTrainer();
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
        System.out.println("Entrenador registrado: " + trainer);
    }

    void listTrainers() {
        System.out.println("\nEntrenadores registrados:");
        if (trainers.isEmpty()) {
            System.out.println("No hay entrenadores registrados.");
        } else {
            for (TrainerGym t : trainers) {
                System.out.println(t);
            }
        }
    }

    void removeTrainer() {
        System.out.println("\nEliminar entrenador");
        if (trainers.isEmpty()) {
            System.out.println("No hay entrenadores registrados.");
            return;
        }
        System.out.print("Nombre del entrenador a eliminar: ");
        String nombre = scanner.nextLine();
        TrainerGym toRemove = null;
        for (TrainerGym t : trainers) {
            if (t.getNombre().equalsIgnoreCase(nombre)) {
                toRemove = t;
                break;
            }
        }
        if (toRemove != null) {
            trainers.remove(toRemove);
            System.out.println("Entrenador eliminado.");
        } else {
            System.out.println("Entrenador no encontrado.");
        }
    }
}
