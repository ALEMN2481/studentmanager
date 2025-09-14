package BicycleSystem;


public class Bicycle {
    public static final String STATUS_DISPONIBLE = "Disponible";
    public static final String STATUS_NO_DISPONIBLE = "No disponible";

    private final int id;
    private String type;
    private String status;

    public Bicycle(int id, String type, String status) {
        this.id = id;
        this.type = type;
        this.status = status;
    }

    public int getId() { return id; }
    public String getType() { return type; }
    public String getStatus() { return status; }

    protected void setType(String type) { this.type = type; }
    public void setStatus(String status) { this.status = status; }

    public boolean prestar() {
        if (STATUS_DISPONIBLE.equals(status)) {
            status = STATUS_NO_DISPONIBLE;
            return true;
        }
        return false;
    }

    public void devolver() {
        status = STATUS_DISPONIBLE;
    }

    @Override
    public String toString() {
        return "[ID: " + id + "] " + type + " - " + status;
    }
}
