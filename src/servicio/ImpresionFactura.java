package facturacion.servicio;

import facturacion.modelo.Factura;

/**
 * Contrato que define cómo se imprime/presenta una factura.
 * Permite intercambiar implementaciones (consola, PDF, email, etc.)
 * sin modificar el resto del sistema. Principio abierto/cerrado (SOLID).
 */
public interface ImpresionFactura {
    void imprimir(Factura factura);
}
