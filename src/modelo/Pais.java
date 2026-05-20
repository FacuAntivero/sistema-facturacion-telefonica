package facturacion.modelo;

// Clase que representa un país con su tarifa por minuto

public class Pais {

    private final String nombre;
    private final double tarifaPorMinuto;

    public Pais(String nombre, double tarifaPorMinuto) {
        this.nombre = nombre;
        this.tarifaPorMinuto = tarifaPorMinuto;
    }

    public String getNombre() { 
        return nombre; 
    }

    public double getTarifaPorMinuto() { 
        return tarifaPorMinuto; 
    }
}
