package com.challenge.desafio;

import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;

import java.math.BigDecimal;

public class Teste {

  @Somar
  BigDecimal a = BigDecimal.TEN;

  @Subtrair
  BigDecimal b = BigDecimal.ONE;

  public static void main(String[] args) throws IllegalAccessException {
    CalculadorDeClasses calculadora = new CalculadorDeClasses();
    Teste teste = new Teste();

    System.out.println(calculadora.somar(teste));

    System.out.println(calculadora.subtrair(teste));

    System.out.println(calculadora.totalizar(teste));

  }
}
