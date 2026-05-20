# Sistema de Facturación Telefónica

## 🚀 Ejecución

Para probar el sistema, ejecutar la clase `Main.java` dentro del paquete `facturacion`. El programa inicializa un set de datos de prueba en memoria y muestra el detalle de la factura por consola.

## ⚙️ Decisiones de Diseño y Supuestos de Negocio

- **Criterio de Franja Horaria (Llamadas Locales):** El costo de las llamadas locales se calcula tomando estrictamente la tarifa correspondiente a la **hora de inicio** de la llamada. No se realiza un fraccionamiento minuto a minuto en caso de que la duración de la llamada cruce el límite de una franja horaria (por ejemplo, una llamada que inicia a las 19:55 y termina a las 20:15).
- **Desacoplamiento de la Capa de Presentación:** Se definió la interfaz `ImpresionFactura` y su implementación concreta `ImpresionFacturaConsola`. El objetivo de esta separación es aislar la lógica de negocio (`Factura`) de la salida visual. De esta manera, el sistema queda preparado para soportar otros formatos de salida (como PDF o Web) implementando la misma interfaz sin alterar el modelo de datos.

![Diagrama de Clases](diagrama.png)
