// src/main/java/com/ejemplo/PedidoService.java
package com.ejemplo;

public class PedidoService {

  private final DescuentoRepository repository;

  // Constructor que recibe el repositorio
  public PedidoService(DescuentoRepository repository) {
    this.repository = repository;
  }

  /**
   * Calcula el total aplicando el % de descuento obtenido del repositorio
   * y el costo de envío.
   */
  public double calcularTotal(double subtotal, String codigoDescuento, boolean envioExpress) {
    double descuento = repository.obtenerPorcentaje(codigoDescuento);
    double envio    = envioExpress ? 20.0 : 10.0;
    return (subtotal * (1 - descuento)) + envio;
  }
}
