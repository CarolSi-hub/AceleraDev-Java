package com.challenge.desafio;

import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;
import com.challenge.interfaces.Calculavel;

import java.lang.reflect.Field;
import java.math.BigDecimal;

public class CalculadorDeClasses implements Calculavel{
  @Override
  public BigDecimal somar(Object object) throws IllegalAccessException {
    return this.somarAtributosDaClasse(object, Somar.class);
  }

  @Override
  public BigDecimal subtrair(Object object) throws IllegalAccessException {
    return this.somarAtributosDaClasse(object, Subtrair.class);
  }

  @Override
  public BigDecimal totalizar(Object object) throws IllegalAccessException {
    return somar(object).subtract(subtrair(object));
  }

  private BigDecimal somarAtributosDaClasse(Object object, Class annotationName) throws IllegalAccessException {
    BigDecimal soma = BigDecimal.ZERO;
    Field[] atributos = object.getClass().getDeclaredFields();
    for(Field f : atributos) {
      f.setAccessible(true);
      if(f.getType().equals(BigDecimal.class) && f.getDeclaredAnnotation(annotationName) != null) {
        soma = soma.add((BigDecimal) f.get(object));
      }
    } return soma;
  }
}
