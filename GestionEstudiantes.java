
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestionEstudiantes {

    static class Calificacion {
        String materia;
        double nota;

        Calificacion(String materia, double nota) {
            this.materia = materia;
            this.nota = nota;
        }
    }

    static class Estudiante {
        String nombre;
        String id;
        List<Calificacion> calificaciones;

        Estudiante(String nombre, String id) {
            this.nombre = nombre;
            this.id = id;
            this.calificaciones = new ArrayList<>();
        }

        void agregarCalificacion(String materia, double nota) {
            calificaciones.add(new Calificacion(materia, nota));
        }

        void eliminarCalificacion(String materia) {
            calificaciones.removeIf(c -> c.materia.equalsIgnoreCase(materia));
        }

        double calcularPromedio() {
            if (calificaciones.isEmpty()) return 0;
            double suma = 0;
            for (Calificacion c : calificaciones) {
                suma += c.nota;
            }
            return suma / calificaciones.size();
        }

        @Override
        public String toString() {
            return "ID: " + id + " | Nombre: " + nombre;
        }
    }

    static class Usuario {
        String nombre;
        String id;
        List<Estudiante> estudiantes;

        Usuario(String nombre, String id) {
            this.nombre = nombre;
            this.id = id;
            this.estudiantes = new ArrayList<>();
        }

        void agregarEstudiante(String nombre, String id) {
            estudiantes.add(new Estudiante(nombre, id));
        }

        Estudiante buscarEstudiante(String id) {
            for (Estudiante e : estudiantes) {
                if (e.id.equals(id)) {
                    return e;
                }
            }
            return null;
        }

        void eliminarEstudiante(String id) {
            estudiantes.removeIf(e -> e.id.equals(id));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Usuario admin = new Usuario("Administrador", "admin001");

        while (true) {

            System.out.println("\nMenú:");
            System.out.println("1. Agregar Estudiante");
            System.out.println("2. Eliminar Estudiante");
            System.out.println("3. Ver Promedio de Estudiante");
            System.out.println("4. Agregar Calificación");
            System.out.println("5. Eliminar Calificación");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();  

            switch (opcion) {


                case 1:
                    System.out.print("Ingrese nombre del estudiante: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese ID del estudiante: ");
                    String id = scanner.nextLine();
                    admin.agregarEstudiante(nombre, id);
                    System.out.println("Estudiante agregado.");
                    break;

                case 2:
                    System.out.print("Ingrese ID del estudiante a eliminar: ");
                    id = scanner.nextLine();
                    admin.eliminarEstudiante(id);
                    System.out.println("Estudiante eliminado.");
                    break;

                case 3:
                    System.out.print("Ingrese ID del estudiante: ");
                    id = scanner.nextLine();
                    Estudiante e = admin.buscarEstudiante(id);
                    if (e != null) {
                        System.out.println("Promedio de " + e.nombre + ": " + e.calcularPromedio());
                    } else {
                        System.out.println("Estudiante no encontrado.");
                    }
                    break;


                case 4:
                    System.out.print("Ingrese ID del estudiante: ");
                    id = scanner.nextLine();
                    e = admin.buscarEstudiante(id);
                    if (e != null) {
                        System.out.print("Ingrese materia: ");
                        String materia = scanner.nextLine();
                        System.out.print("Ingrese nota: ");
                        double nota = scanner.nextDouble();
                        e.agregarCalificacion(materia, nota);
                        System.out.println("Calificación agregada.");
                    } else {
                        System.out.println("Estudiante no encontrado.");
                    }
                    break;

                case 5:
                    System.out.print("Ingrese ID del estudiante: ");
                    id = scanner.nextLine();
                    e = admin.buscarEstudiante(id);
                    if (e != null) {
                        System.out.print("Ingrese materia a eliminar: ");
                        String materia = scanner.nextLine();
                        e.eliminarCalificacion(materia);
                        System.out.println("Calificación eliminada.");
                    } else {
                        System.out.println("Estudiante no encontrado.");
                    }
                    break;

                case 6:
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opción no válida.");
            }
    
        }
    }
}
