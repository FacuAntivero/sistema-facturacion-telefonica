package facturacion.modelo;

// Clase que representa el plan contratado por el cliente

public class Plan {

    private final String nombre;
    private final double abonoMensual;

    public Plan(String nombre, double abonoMensual) {
        this.nombre = nombre;
        this.abonoMensual = abonoMensual;
    }

    public String getNombre() { 
        return nombre; 
    }

    public double getAbonoMensual() { 
        return abonoMensual; 
    }
}
