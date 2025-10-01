package GymControl;

abstract class Coach {
    private String nombre;
    private int id;
    private int añosDeExperiencia;
    
    public Coach(String nombre, int id, int añosDeExperiencia){
        this.nombre= nombre;
        this.id = id;
        this.añosDeExperiencia = añosDeExperiencia;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public int getID(){
        return id;
    }
    
    public int getAñosDeExperiencia(){
        return añosDeExperiencia;
    }
    
    public abstract double calcularSalario();
}
