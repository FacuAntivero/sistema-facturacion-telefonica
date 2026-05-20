package facturacion.modelo;
import java.time.LocalDateTime;

// Clase base abstracta para todos los tipos de llamada.
 
public abstract class Llamada {

    private final LocalDateTime fechaHoraInicio;
    private final int duracionMinutos;
    private final String numeroDestino;

    public Llamada(LocalDateTime fechaHoraInicio, int duracionMinutos, String numeroDestino) {
        if (duracionMinutos <= 0) {
            throw new IllegalArgumentException("La duración debe ser mayor a cero.");
        }
        this.fechaHoraInicio = fechaHoraInicio;
        this.duracionMinutos = duracionMinutos;
        this.numeroDestino = numeroDestino;
    }

    // Contrato que cada tipo de llamada debe cumplir 
    public abstract double calcularCosto();

    public abstract TipoLlamada getTipo();

    public LocalDateTime getFechaHoraInicio() { 
        return fechaHoraInicio; 
    }

    public int getDuracionMinutos() { 
        return duracionMinutos; 
    }

    public String getNumeroDestino() { 
        return numeroDestino; 
    }
}
