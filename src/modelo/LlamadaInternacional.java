package facturacion.modelo;

import java.time.LocalDateTime;

// Llamada internacional -> el costo por minuto depende del país destino.

public class LlamadaInternacional extends Llamada {

    private final Pais paisDestino;

    public LlamadaInternacional(LocalDateTime fechaHoraInicio, int duracionMinutos, String numeroDestino, Pais paisDestino) {
        super(fechaHoraInicio, duracionMinutos, numeroDestino);
        this.paisDestino = paisDestino;
    }

    @Override
    public double calcularCosto() {
        return paisDestino.getTarifaPorMinuto() * getDuracionMinutos();
    }

    @Override
    public TipoLlamada getTipo() {
        return TipoLlamada.INTERNACIONAL;
    }

    public Pais getPaisDestino() { 
        return paisDestino; 
    }
}
