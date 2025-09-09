package BicycleSystem;


public class User {
    private String nombre;
    private String documento;
    private String tipo; // Solo "Estudiante" o "Empleado"

    public static final String TIPO_ESTUDIANTE = "Estudiante";
    public static final String TIPO_EMPLEADO   = "Empleado";

    public void Usuario(String nombre, String documento, String tipo) {
        this.nombre = nombre;
        this.documento = documento;
        setTipo(tipo);
    }

    public String getNombre() { return nombre; }
    public String getDocumento() { return documento; }
    public String getTipo() { return tipo; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public void setTipo(String tipo) {
        if (tipo == null) throw new IllegalArgumentException("Tipo requerido");
        String t = tipo.trim().toLowerCase();
        switch (t) {
            case "1":
            case "estudiante":
                this.tipo = TIPO_ESTUDIANTE;
                break;
            case "2":
            case "empleado":
                this.tipo = TIPO_EMPLEADO;
                break;
            default:
                throw new IllegalArgumentException("Tipo inválido (use Estudiante o Empleado).");
        }
    }

    @Override
    public String toString() {
        return "[" + tipo + "] " + nombre + " (doc: " + documento + ")";
    }
}
