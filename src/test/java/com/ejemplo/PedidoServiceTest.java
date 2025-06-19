// src/test/java/com/ejemplo/PedidoServiceTest.java
package com.ejemplo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PedidoServiceTest {
  PedidoService service = new PedidoService();

  @Test
  void testSinDescuentoYEnvioNormal() {
    assertEquals(110.0, service.calcularTotal(100, false, false));
  }

  @Test
  void testConDescuentoYEnvioExpress() {
    assertEquals(110.0, service.calcularTotal(100, true, true));
  }

  @Test
  void testConDescuentoYEnvioNormal() {
    assertEquals(190.0, service.calcularTotal(200, true, false));
  }

  @Test
  void testSinDescuentoYEnvioExpress() {
    assertEquals(170.0, service.calcularTotal(150, false, true));
  }
}
