package BicycleSystem;

public class Bicycle {
    private int ID;
    private String type;
    private String status;

    public Bicycle(int ID, String Type, String Status) {
        this.ID = ID;
        this.type = Type;
        this.status = Status;
    }

    public String getType() {
        return type;
    }

    public int getID() {
        return ID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}