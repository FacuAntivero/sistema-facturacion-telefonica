package facturacion.servicio;

import facturacion.modelo.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ImpresionFacturaConsola implements ImpresionFactura {

    private static final String LINEA_SIMPLE  = "------------------------------------------------------------";
    private static final String LINEA_DOBLE   = "============================================================";
    private static final DateTimeFormatter FMT = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    @Override
    public void imprimir(Factura factura) {
        imprimirEncabezado(factura);
        imprimirDetalleAbono(factura);
        imprimirDetalleLlamadas(factura);
        imprimirResumen(factura);
    }

    private void imprimirEncabezado(Factura factura) {
        System.out.println(LINEA_DOBLE);
        System.out.println(" FACTURA TELEFÓNICA MENSUAL ");
        System.out.println(LINEA_DOBLE);
        System.out.println(" Cliente: " + factura.getCliente().getNombreCompleto());
        System.out.println(" DNI: " + factura.getCliente().getDni());
        System.out.println(" Línea: " + factura.getCliente().getNumeroLinea());
        System.out.println(" Plan: " + factura.getPlan().getNombre());
        System.out.println(LINEA_DOBLE);
    }

    private void imprimirDetalleAbono(Factura factura) {
        System.out.println(" ABONO MENSUAL BÁSICO");
        System.out.println(LINEA_SIMPLE);
        System.out.printf(" %-40s $ %8.2f%n", 
                "Abono " + factura.getPlan().getNombre(), 
                factura.getPlan().getAbonoMensual());
        System.out.println();
    }

    private void imprimirDetalleLlamadas(Factura factura) {
        List<Llamada> llamadas = new ArrayList<>(factura.getLlamadas());

        imprimirSeccionLlamadas("LLAMADAS LOCALES", TipoLlamada.LOCAL, llamadas);
        imprimirSeccionLlamadas("LLAMADAS NACIONALES", TipoLlamada.NACIONAL, llamadas);
        imprimirSeccionLlamadas("LLAMADAS INTERNACIONALES", TipoLlamada.INTERNACIONAL, llamadas);
    }

    private void imprimirSeccionLlamadas(String titulo, TipoLlamada tipo, List<Llamada> todas) {
        List<Llamada> filtradas = new ArrayList<>();
        for (Llamada l : todas) {
            if (l.getTipo() == tipo) {
                filtradas.add(l);
            }
        }

        System.out.println("  " + titulo);
        System.out.println(LINEA_SIMPLE);

        if (filtradas.isEmpty()) {
            System.out.println("  (sin llamadas en este período)");
        } else {
            // Cabecera de la tabla con printf para que quede alineada
            System.out.printf("  %-18s %-22s %5s  %8s%n", "Fecha/Hora", "Destino", "Min.", "Costo");
            System.out.println("  ---------------------------------------------------------");

            for (Llamada llamada : filtradas) {
                String destino = resolverDestino(llamada);
                System.out.printf("  %-18s %-22s %5d  $ %6.2f%n", llamada.getFechaHoraInicio().format(FMT), destino, llamada.getDuracionMinutos(), llamada.calcularCosto());

                // Solo si la llamada es de tipo Local
                if (llamada.getTipo() == TipoLlamada.LOCAL) {
                    
                    LlamadaLocal local = (LlamadaLocal) llamada;
                    System.out.printf("  %-44s [%s]%n", "", local.getDescripcionTarifa());
                    
                }
            }
        }
        System.out.println();
    }

    private String resolverDestino(Llamada llamada) {
        if (llamada.getTipo() == TipoLlamada.LOCAL) {
            
            return "Local (" + llamada.getNumeroDestino() + ")";
            
        } else if (llamada.getTipo() == TipoLlamada.NACIONAL) {
            
            // convertimos la Llamada general a LlamadaNacional
            LlamadaNacional n = (LlamadaNacional) llamada;
            return n.getLocalidadDestino().getNombre() + " (" + n.getNumeroDestino() + ")";
            
        } else if (llamada.getTipo() == TipoLlamada.INTERNACIONAL) {
            
            LlamadaInternacional i = (LlamadaInternacional) llamada;
            return i.getPaisDestino().getNombre() + " (" + i.getNumeroDestino() + ")";
            
        }
        
        return llamada.getNumeroDestino();
    }

    private void imprimirResumen(Factura factura) {
        System.out.println(LINEA_DOBLE);
        System.out.println("RESUMEN");
        System.out.println(LINEA_SIMPLE);
        System.out.printf(" %-40s $ %8.2f%n", "Abono mensual básico:", factura.getPlan().getAbonoMensual());
        System.out.printf(" %-40s $ %8.2f%n", "Subtotal llamadas locales:", factura.getTotalLlamadasLocales());
        System.out.printf(" %-40s $ %8.2f%n", "Subtotal llamadas nacionales:", factura.getTotalLlamadasNacionales());
        System.out.printf(" %-40s $ %8.2f%n", "Subtotal llamadas internacionales:", factura.getTotalLlamadasInternacionales());
        System.out.println(LINEA_SIMPLE);
        System.out.printf(" %-40s $ %8.2f%n", "TOTAL A PAGAR:", factura.getTotalFactura());
        System.out.println(LINEA_DOBLE);
    }
}