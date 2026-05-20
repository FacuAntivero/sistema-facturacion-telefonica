package facturacion.modelo;

// Representa al titular de la línea 
 
public class Cliente {

    private final String nombre;
    private final String apellido;
    private final String dni;
    private final String numeroLinea;

    public Cliente(String nombre, String apellido, String dni, String numeroLinea) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.numeroLinea = numeroLinea;
    }

    public String getNombreCompleto() { 
        return apellido + ", " + nombre; 
    }
    
    public String getDni() { 
        return dni; 
    }
    
    public String getNumeroLinea() { 
        return numeroLinea;
    }
}
