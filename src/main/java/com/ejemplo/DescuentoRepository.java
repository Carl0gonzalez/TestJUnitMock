package com.ejemplo;

public class DescuentoRepository {
   public double obtenerPorcentaje(String codigo) {
    if ("PROMO10".equals(codigo)) return 0.10;
    return 0.0;
   } 
}
