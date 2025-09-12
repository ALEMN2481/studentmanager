package BicycleSystem;

public class Bicycle {
    private int id;
    private String type;   // "Mecánica" o "Eléctrica"
    private String status; // "Disponible" o "No disponible"

    public static final String TYPE_MECANICA = "Mecánica";
    public static final String TYPE_ELECTRICA = "Eléctrica";
    public static final String STATUS_DISPONIBLE = "Disponible";
    public static final String STATUS_NO_DISPONIBLE = "No disponible";

    public Bicycle(int id, String type, String status) {
        this.id = id;
        setType(type);
        setStatus(status);
    }

  
    public int getId() { return id; }
    public String getType() { return type; }
    public String getStatus() { return status; }


    public void setStatus(String status) {
        if (status == null) throw new IllegalArgumentException("Estado requerido");
        String s = status.trim().toLowerCase();
        if (s.equals("disponible")) {
            this.status = STATUS_DISPONIBLE;
        } else if (s.equals("no disponible")) {
            this.status = STATUS_NO_DISPONIBLE;
        } else {
            throw new IllegalArgumentException("Estado inválido (use Disponible o No disponible).");
        }
    }

    protected void setType(String type) {
        if (type == null) throw new IllegalArgumentException("Tipo requerido");
        String t = type.trim().toLowerCase();
        if (t.equals("mecánica") || t.equals("mecanica")) {
            this.type = TYPE_MECANICA;
        } else if (t.equals("eléctrica") || t.equals("electrica")) {
            this.type = TYPE_ELECTRICA;
        } else {
            throw new IllegalArgumentException("Tipo inválido (use Mecánica o Eléctrica).");
        }
    }

   
    public boolean prestar() {
        if (status.equals(STATUS_NO_DISPONIBLE)) return false;
        this.status = STATUS_NO_DISPONIBLE;
        return true;
    }

    public void devolver() {
        this.status = STATUS_DISPONIBLE;
    }

    @Override
    public String toString() {
        return "[ID: " + id + "] " + type + " - " + status;
    }
}
