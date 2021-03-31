# AceleraDev-Java

## Manipulação de dados com Spring
Neste desafio você receberá um projeto Maven pré-configurado com Springboot, Spring-JPA e banco de dados H2. Este projeto também contém as classes de entidade entity já criadas para o Modelo de Entidade Relacionamento abaixo:

<img src="https://codenation-challenges.s3-us-west-1.amazonaws.com/java-10/codenation-sample-2.png" />

No pacote service estão disponíveis interfaces de serviço para cada uma das classes entity. São elas:<br><br>

UserService.java<br>
CandidateService.java<br>
SubmissionService.java<br>
AccelerationService.java<br>
CompanyService.java<br>
ChallengeService.java<br>
Crie classes de serviço implementado as interfaces acima, e também as classes repository para manipulação dos dados.<br><br>

### Services<br>

UserService<br>
findById: buscar um usuário por id<br>
save: Cria ou altera um usuário na base de dados<br>
findByAccelerationName: busca candidatos pelo nome da aceleração<br>
findByCompanyId: buscar usuários relacionados com uma empresa.<br><br>

CandidateService<br>
findByCompanyId: buscar um candidato pelo id da empresa<br>
findByAccelerationId: buscar candidatos de uma aceleração<br>
save: Cria ou altera um candidato na base de dados<br><br>

SubmissionService<br>
findHigherScoreByChallengeId: Buscar o maior score de um determinado desafio<br>
findByChallegeIdAndAccelerationId: buscar submissões de um determinado desafio de uma determinada aceleração<br>
save: Cria ou altera um desafio na base de dados<br><br>

AccelerationService<br>
findAccelerationById: buscar uma aceleração por id<br>
findAccelerationByName: buscar uma aceleração pelo nome<br>
findByCompanyId: buscar acelerações vinculadas com uma empresa<br>
save: Cria ou altera uma aceleração<br><br>

CompanyService<br>
findById: buscar uma empresa pelo id<br>
findbyAccelerationId: buscar empresas de uma aceleração<br>
findByUserId: buscar empresas relacionadas com um usuário<br>
save: Cria ou altera uma empresa<br><br>

ChallengeService<br>
findByAccelerationIdAndUserId: buscar desafios feitos por um usuario em determinada aceleração<br>
save: Cria ou altera um desafio<br>

##### Informações adicionais:<br>
O projeto deve buildar e iniciar sem erros<br>
Utilize o comando mvn spring-boot:run para iniciar a aplicação
