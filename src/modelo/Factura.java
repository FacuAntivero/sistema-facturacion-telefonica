package facturacion.modelo;
import java.time.Month;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

// Representa la factura mensual de un cliente.

public class Factura {

    private final Cliente cliente;
    private final Plan plan;
    private final Month mes;
    private final int anio;
    private final List<Llamada> llamadas;

    public Factura(Cliente cliente, Plan plan, Month mes, int anio) {
        this.cliente = cliente;
        this.plan = plan;
        this.mes = mes;
        this.anio = anio;
        this.llamadas = new ArrayList<>();
    }

    public void agregarLlamada(Llamada llamada) {
        llamadas.add(llamada);
    }

    // Calculos delegados a las llamadas

    public double getTotalLlamadasLocales() {
        double total = 0;

        for (Llamada l : llamadas) {
            if (l.getTipo() == TipoLlamada.LOCAL) {
                total += l.calcularCosto();
            }
        }

        return total;
    }

    public double getTotalLlamadasNacionales() {
        double total = 0;

        for (Llamada l : llamadas) {
            if (l.getTipo() == TipoLlamada.NACIONAL) {
                total += l.calcularCosto();
            }
        }

        return total;
    }

    public double getTotalLlamadasInternacionales() {
        double total = 0;

        for (Llamada l : llamadas) {
            if (l.getTipo() == TipoLlamada.INTERNACIONAL) {
                total += l.calcularCosto();
            }
        }

        return total;
    }

    public double getTotalFactura() {
        return plan.getAbonoMensual() + getTotalConsumo();
    }


    public Cliente getCliente() { 
        return cliente; 
    }

    public Plan getPlan() { 
        return plan; 
    }

    public Month getMes() { 
        return mes; 
    }

    public int getAnio() { 
        return anio; 
    }

    public List<Llamada> getLlamadas() {
        return new ArrayList<>(llamadas); 
    }
}
