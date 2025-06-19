// src/test/java/com/ejemplo/PedidoServiceMockTest.java
package com.ejemplo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PedidoServiceMockTest {

  @Test
  void testConMockDeDescuento() {
    DescuentoRepository mockRepo = mock(DescuentoRepository.class);
    when(mockRepo.obtenerPorcentaje("PROMO10")).thenReturn(0.10);

    PedidoService service = new PedidoService(mockRepo);
    double total = service.calcularTotal(100, "PROMO10", true);
    assertEquals(110.0, total);
  }
}
