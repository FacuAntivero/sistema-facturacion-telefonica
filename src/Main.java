package facturacion;
import facturacion.datos.DatosSimulados;
import facturacion.modelo.Factura;
import facturacion.servicio.ImpresionFactura;
import facturacion.servicio.ImpresionFacturaConsola;

public class Main {

    public static void main(String[] args) {

        // Obtenemos la factura de ejemplo (esto simula la parte de "negocio" o "servicio" que prepara los datos)
        Factura factura = DatosSimulados.crearFacturaEjemplo();

        // Elegimos el metodo de impresion (en este caso, consola)
        ImpresionFactura impresion = new ImpresionFacturaConsola();

        // Imprimimos la factura
        impresion.imprimir(factura);
    }
}
