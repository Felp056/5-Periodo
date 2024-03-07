/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.financ;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author felip
 */
public class ProjetoFinanceiro {

    public static void main(String[] args) {
       /* BigDecimal valor  = new BigDecimal("1.0");
        valor = valor.add(new BigDecimal("2.005"));
        System.out.println(valor);
        valor = valor.subtract(new BigDecimal("0.005"));
        System.out.println(valor.setScale(1, RoundingMode.UNNECESSARY));
        valor = valor.multiply(new BigDecimal("5.1"));
        System.out.println(valor.setScale(2, RoundingMode.UNNECESSARY));
        valor = valor.divide(new BigDecimal("3"));
        System.out.println(valor);
        valor = valor.pow(2);
        System.out.println(valor.setScale(10, RoundingMode.HALF_UP));
        System.out.println((valor.compareTo(new BigDecimal("25.001"))> 0 ? "Maior q 25.001 " : "Menor q 25.001"));*/
        new com.financ.Telas.IMC().setVisible(true);
    }
}