package SistemaGestionFlota;

public abstract class Vehiculo {
    protected String estado;
    protected String tipo;
    
    public Vehiculo(String tipo) {
        this.tipo = tipo;
        this.estado = "detenido"; 
    }
    public String getEstado() {
        return estado;
    }
    public void cambiarEstado(String nuevoEstado) {
        this.estado = nuevoEstado;
    }
    public abstract String mostrarInfo();
}

