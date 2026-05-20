package facturacion.datos;
import facturacion.modelo.*;
import java.time.LocalDateTime;
import java.time.Month;


// Simulación de los datos de prueba

 
public class DatosSimulados {

    // Países con tarifas internacionales
    public static final Pais BRASIL = new Pais("Brasil", 1.50);
    public static final Pais ESPANIA = new Pais("España", 2.80);
    public static final Pais ESTADOS_UNIDOS = new Pais("EE.UU", 2.20);
    public static final Pais ALEMANIA = new Pais("Alemania", 3.10);

    // Localidades con tarifas nacionales
    public static final Localidad BUENOS_AIRES = new Localidad("Buenos Aires", 0.35);
    public static final Localidad CORDOBA = new Localidad("Córdoba", 0.40);
    public static final Localidad ROSARIO = new Localidad("Rosario", 0.38);
    public static final Localidad MENDOZA = new Localidad("Mendoza", 0.45);
    public static final Localidad MAR_DEL_PLATA = new Localidad("Mar del Plata", 0.42);

    // Planes
    public static final Plan PLAN_BASICO = new Plan("Plan Básico", 500.00);
    public static final Plan PLAN_PERSONAL = new Plan("Plan Personal", 850.00);
    public static final Plan PLAN_PREMIUM = new Plan("Plan Premium", 1500.00);


    // Ejemplo al cual le asignamos diferentes tipos de llamadas

    public static Factura crearFacturaEjemplo() {

        Cliente cliente = new Cliente("Facundo", "Antivero", "43.055.791", "2494-600615");

        Factura factura = new Factura(cliente, PLAN_PERSONAL, Month.MAY, 2025);

        // Llamadas locales

        // Lunes 10:00 -> horario pico -> $0,20/min -> 15 min -> 0,20 * 15 = $3,00
        factura.agregarLlamada(new LlamadaLocal(LocalDateTime.of(2025, 5, 5, 10, 0), 15, "2494-111222"));

        // Lunes 22:00 -> horario reducido -> $0,10/min -> 20 min -> 0,10 * 20 = $2,00
        factura.agregarLlamada(new LlamadaLocal(LocalDateTime.of(2025, 5, 5, 22, 30), 20, "2494-333444"));

        // Sábado 15:00 -> fin de semana -> $0,10/min -> 10 min -> 0,10 * 10 = $1,00
        factura.agregarLlamada(new LlamadaLocal(LocalDateTime.of(2025, 5, 10, 15, 0), 10, "2494-555666"));

        // Viernes 19:55 -> horario pico -> $0,20/min -> 5 min -> 0,20 * 5 = $1,00
        factura.agregarLlamada(new LlamadaLocal(LocalDateTime.of(2025, 5, 16, 19, 55), 5, "2494-777888"));

        // Llamadas nacionales

        // Córdoba -> $0,40/min -> 12 min -> 0,40 * 12 = $4,80
        factura.agregarLlamada(new LlamadaNacional(LocalDateTime.of(2025, 5, 7, 14, 0), 12, "351-987654", CORDOBA));

        // Buenos Aires -> $0,35/min -> 8 min -> 0,35 * 8 = $2,80
        factura.agregarLlamada(new LlamadaNacional(LocalDateTime.of(2025, 5, 14, 9, 30), 8, "011-555321", BUENOS_AIRES));

        // Mendoza -> $0,45/min -> 25 min -> 0,45 * 25 = $11,25
        factura.agregarLlamada(new LlamadaNacional(LocalDateTime.of(2025, 5, 21, 11, 0), 25, "261-444123", MENDOZA));

        // Llamadas internacionales

        // Brasil -> $1,50/min -> 7 min -> 1,50 * 7 = $10,50
        factura.agregarLlamada(new LlamadaInternacional(LocalDateTime.of(2025, 5, 8, 16, 0), 7, "+55-11-98765432", BRASIL));

        // España -> $2,80/min -> 15 min -> 2,80 * 15 = $42,00
        factura.agregarLlamada(new LlamadaInternacional(LocalDateTime.of(2025, 5, 20, 20, 0), 15, "+34-91-1234567", ESPANIA));

        // EE.UU -> $2,20/min -> 3 min -> 2,20 * 3 = $6,60
        factura.agregarLlamada(new LlamadaInternacional(LocalDateTime.of(2025, 5, 27, 13, 0), 3, "+1-212-5550199", ESTADOS_UNIDOS));

        return factura;
    }
}
