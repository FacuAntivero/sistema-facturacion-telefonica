package facturacion.modelo;

import java.time.LocalDateTime;


// Llamada nacional: el costo por minuto depende de la localidad destino

public class LlamadaNacional extends Llamada {

    private final Localidad localidadDestino;

    public LlamadaNacional(LocalDateTime fechaHoraInicio, int duracionMinutos, String numeroDestino, Localidad localidadDestino) {
        super(fechaHoraInicio, duracionMinutos, numeroDestino);
        this.localidadDestino = localidadDestino;
    }

    @Override
    public double calcularCosto() {
        return localidadDestino.getTarifaPorMinuto() * getDuracionMinutos();
    }

    @Override
    public TipoLlamada getTipo() {
        return TipoLlamada.NACIONAL;
    }

    public Localidad getLocalidadDestino() { 
        return localidadDestino; 
    }
}
