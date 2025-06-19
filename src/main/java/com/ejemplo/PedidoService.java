// src/main/java/com/ejemplo/PedidoService.java
package com.ejemplo;

/* public class PedidoService {
  public double calcularTotal(double subtotal, boolean aplicaDescuento, boolean envioExpress) {
    double descuento = aplicaDescuento ? 0.1 : 0;
    double envio = envioExpress ? 20.0 : 10.0;
    return (subtotal * (1 - descuento)) + envio;
  }
} */
public class PedidoService {
  private DescuentoRepository repository;
  public PedidoService(DescuentoRepository repository) {
    this.repository = repository;
  }
  public double calcularTotal(double subtotal, String codigoDescuento, boolean envioExpress) {
    double descuento = repository.obtenerPorcentaje(codigoDescuento);
    double envio = envioExpress ? 20.0 : 10.0;
    return (subtotal * (1 - descuento)) + envio;
  }
}