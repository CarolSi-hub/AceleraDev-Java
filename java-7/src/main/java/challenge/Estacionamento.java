package challenge;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;

public class Estacionamento {
  public int numberPlaces = 10;

  List<Carro> estacionados = new ArrayList<>();


  public void estacionar(Carro carro) {
    if(carrosEstacionados() == numberPlaces) {
      for (Carro estacionado : estacionados) {
        if (estacionado.getMotorista().getIdade() <= 55) {
          estacionados.remove(estacionado);
          break;
        }
      }
    }
    if(carrosEstacionados() < numberPlaces) estacionados.add(carro);
    List motoristasSenior = estacionados.stream()
        .filter((estacionado) -> estacionado.getMotorista().getIdade() > 55)
        .collect(Collectors.toList());
    if(motoristasSenior.size() == numberPlaces) throw new EstacionamentoException("Nao ha vagas");
    }



  public int carrosEstacionados() {
    return estacionados.size();
  }

  public boolean carroEstacionado(Carro carro) {
    return estacionados.contains(carro);
  }
}
