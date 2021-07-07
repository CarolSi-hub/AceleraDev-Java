# AceleraDev-Java

## Calculador de Atributos de Classe
Você precisa somar ou subtrair determinados atributos do tipo BigDecimal de uma classe.<br> 
Pra isso você deverá cria uma annotation (“Somar”) para determinar quais atributos serão somados e outra annotation <br> 
(“Subtrair”) para todos os atributos que serão subtraídos. Você deverá criar uma interface Calculavel. Esta interface possui 3 métodos:<br> <br> 

### Somar
### Subtrair
### Totalizar
<br> 
Você deverá também criar uma classe concreta que implementa Calculavel. <br> 
O nome dessa classe deve ser CalculadorDeClasses.<br>  
A implementação dos métodos deve obedecer os requisitos abaixo:<br><br> 

O método somar: deverá somar todos os atributos do tipo BigDecimal de uma classe recebida como parâmetro e retornar um BigDecimal.<br> 

O método subtrair: deverá somar todos os atributos do tipo BigDecimal de uma classe recebida como parâmetro e retornar um BigDecimal.<br> 

O método total: deverá subtrair os atributos annotados com “Subtrair” dos atributos annotados com “Somar”.<br> 

Caso a classe não tenha nenhum atributo com annotation, retornar BigDecimal.ZERO<br> 

Caso o atributo não seja BigDecimal, retornar BigDecimal.ZERO<br> 

Utilizar os packages existentes do projeto para crias as devidas classes.<br> 
