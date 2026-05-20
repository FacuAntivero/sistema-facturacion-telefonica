package facturacion.modelo;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

/*
  Llamada local: el costo varía según día y franja horaria.
 
  Días hábiles  08:00–20:00  → $0,20 / min
  Días hábiles  resto        → $0,10 / min
  Sábado/Domingo             → $0,10 / min
 */
public class LlamadaLocal extends Llamada {

    private static final double TARIFA_PICO = 0.20;
    private static final double TARIFA_REDUCIDA = 0.10;

    public LlamadaLocal(LocalDateTime fechaHoraInicio, int duracionMinutos, String numeroDestino) {
        super(fechaHoraInicio, duracionMinutos, numeroDestino);
    }

    @Override
    public double calcularCosto() {
        return getTarifaAplicable() * getDuracionMinutos();
    }

    @Override
    public TipoLlamada getTipo() {
        return TipoLlamada.LOCAL;
    }

    private double getTarifaAplicable() {
        DayOfWeek dia = getFechaHoraInicio().getDayOfWeek();
        int hora = getFechaHoraInicio().getHour(); 

        boolean esFinDeSemana = (dia == DayOfWeek.SATURDAY || dia == DayOfWeek.SUNDAY);
        boolean esHoraPico = (hora >= 8 && hora < 20);

        if (!esFinDeSemana && esHoraPico) {
            return TARIFA_PICO;
        }
        return TARIFA_REDUCIDA;
    }

    public String getDescripcionTarifa() {
        if (getTarifaAplicable() == TARIFA_PICO) {
            return "Horario pico (Lun-Vie 08-20hs)";
        }
        return "Horario reducido";
    }
}
