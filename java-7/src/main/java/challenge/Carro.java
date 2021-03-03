package challenge;

import java.util.*;

public class Carro {

  private final Motorista motorista;

  private final String placa;

  private final Cor cor;

  private Carro(Motorista motorista, String placa, Cor cor) {
    this.motorista = motorista;
    this.placa = placa;
    this.cor = cor;
  }

  public Motorista getMotorista() {
    return motorista;
  }

  public String getPlaca() {
    return placa;
  }

  public Cor getCor() {
    return cor;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Carro carro = (Carro) o;
    return Objects.equals(motorista, carro.motorista) &&
        Objects.equals(placa, carro.placa) &&
        cor == carro.cor;
  }

  @Override
  public int hashCode() {
    return Objects.hash(motorista, placa, cor);
  }

  @Override
  public String toString() {
    return "Carro{" +
        "motorista=" + motorista +
        ", placa='" + placa + '\'' +
        ", cor=" + cor +
        '}';
  }

  public static CarroBuilder builder() {
    return new CarroBuilder();
  }


  public static class CarroBuilder {

    private Motorista motorista;

    private String placa;

    private Cor cor;

    private CarroBuilder() {
    }

    public CarroBuilder withMotorista(Motorista motorista) {
      this.motorista = motorista;
      return this;
    }

    public CarroBuilder withPlaca(String placa) {
      this.placa = placa;
      return this;
    }

    public CarroBuilder withCor(Cor cor) {
      this.cor = cor;
      return this;
    }

    public void checkConditions(Motorista motorista, String placa, Cor cor){
      if(this.placa.isEmpty() || this.cor == null) throw new NullPointerException("Faltando dados");
      if(this.motorista == null) throw new EstacionamentoException("Nao aceita carro autonomo");
      if(this.motorista.getIdade() < 18) throw new EstacionamentoException("Nao aceita motorista menor");
      if(this.motorista.getPontos() > 20) throw new EstacionamentoException("Nao aceita motorista sem pontos");
    }

    public Carro build() {
      checkConditions(this.motorista, this.placa, this.cor);

      return new Carro(motorista, placa, cor);
    }
  }
}
