# AceleraDev-Java

## Order Service
Em um sistema de gerenciamento de pedidos, surgiram alguns requisitos novos para serem implementados.<br> Sua tarefa é realizar a implementação dessas funcionalidades conforme as instruções abaixo.<br><br>

Você deve implementar os métodos da classe OrderServiceImpl, uma implementação da Interface OrderService.<br> A implementação de seus métodos deve utilizar a seguir as regras abaixo.<br><br>

### Double calculateOrderValue(List items)<br><br>

Esse método deverá receber uma lista de OrderItem (Classe que contem o id do produto e sua quantidade no pedido) e deve retornar o valor total do pedido.<br>
Para calcular o valor total, deve-se obter o valor de cada item do pedido (OrderItem) multiplicando a quantidade de itens pelo valor do produto e,<br>
caso o produto tenha o atributo isSale igual a true, deve-se aplicar um desconto de 20%.<br><br>

Set findProductsById(List ids)<br><br>

Esse é um método de mapeamento, que deve receber uma lista de ids de produtos e devolver um conjunto de produtos.<br><br>

### Double calculateMultipleOrders(List> orders)<br><br>

Esse método deverá calcular o valor total de todos os pedidos, sendo que cada pedido corresponde a uma lista de OrderItem.<br> Para calcular o valor total de cada pedido, você deve seguir as mesmas regras do método calculateOrderValue.<br><br>

### Map> groupProductsBySale(List productIds)<br><br>

Esse método deverá receber uma lista de ids de produtos e retornar um mapa com os produtos agrupados de acordo com o atributo isSale.<br><br>

Observações Para implementar os métodos acima, deverão ser utilizados os métodos disponíveis na Interface ProductRepository Todos os métodos devem ignorar id inválidos Todos os método devem ser implementados utilizando a Stream API<br>

### Tópicos
Neste desafio, você utilizará:

Programação Funcional<br>
Java Stream API<br>
Java Collections API<br>
Classe Optional<br>
