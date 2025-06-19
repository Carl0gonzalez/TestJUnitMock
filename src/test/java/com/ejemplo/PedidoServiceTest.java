// src/test/java/com/ejemplo/PedidoServiceTest.java
package com.ejemplo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PedidoServiceTest {
  // Inyecta el repositorio real (que devuelve 0.0 para cualquier código por defecto)
  private final DescuentoRepository repo = new DescuentoRepository();
  private final PedidoService service = new PedidoService(repo);

  @Test
  void testSinDescuentoYEnvioNormal() {
    double total = service.calcularTotal(100, "SIN-CODIGO", false);
    assertEquals(110.0, total);
  }

  @Test
  void testConDescuentoYEnvioNormalConRepoReal() {
    // Si tu DescuentoRepository real devuelve 0.10 solo para "PROMO10":
    double total = service.calcularTotal(200, "PROMO10", false);
    assertEquals(190.0, total);
  }

  @Test
  void testSinDescuentoYEnvioExpress() {
    double total = service.calcularTotal(150, "SIN-CODIGO", true);
    assertEquals(170.0, total);
  }
}
