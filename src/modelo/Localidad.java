package facturacion.modelo;

// Clase que representa una localidad nacional con su propia tarifa por minuto.
 
public class Localidad {

    private final String nombre;
    private final double tarifaPorMinuto;

    public Localidad(String nombre, double tarifaPorMinuto) {
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
