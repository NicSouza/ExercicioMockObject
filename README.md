Exercício Prático - Mock Object

Assumindo o projeto tdd-stack.zip disponibilizado na semana de aula, resolva:

A equipe da Caixa Econômica Federal, tem como objetivo desenvolver uma classe com responsabilidade de coletar todos os número sorteados da Mega Sena que estarão armazenados em um objeto CustomStack, conforme ordem do sorteio realizado, e ordená-los de forma ascendente.

Para tal o objetivo é implementar:

Um classe chamada NumberAscOrder, deve receber uma CustomStack na inicialização
Um método denominado sort() (sem parâmetros) que deverá retornar um List<E extends Number>, bem como os devidos tratamentos/verificações necessários
Uma classe de teste com os casos de teste necessários para atender minimamente os seguintes cenários (outros adicionais podem ser criados)
Uma pilha de 6 posições, contendo os 6 números sorteados (aleatoriamente)
Uma pilha de 6 posições, vazia
Observações:

Nenhum método adicional deve ser criado nas classes já existentes no projeto
Opções de Assert JUnit 5 - https://junit.org/junit5/docs/5.0.0/api/org/junit/jupiter/api/Assertions.html
