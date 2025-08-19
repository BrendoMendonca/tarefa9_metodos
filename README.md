# Refatoração da Locadora com Princípios SOLID
A versão inicial do código, embora funcional, concentrava a maior parte da lógica de negócio em um único método (extrato na classe Client). Esta abordagem centralizada trazia vários problemas de design, violando princípios fundamentais de uma boa arquitetura de software.

## Problemas Identificados

Princípio da Responsabilidade Única (SRP - Single Responsibility Principle): A classe Client tinha múltiplas responsabilidades. Seu método extrato era responsável por calcular os custos de aluguel para diferentes tipos de fitas, calcular pontos de fidelidade e, ao mesmo tempo, formatar a string de texto do extrato. 

Princípio Aberto/Fechado (OCP - Open/Closed Principle): O sistema não era aberto para extensão, mas fechado para modificação. Para adicionar um novo tipo de fita com uma regra de precificação diferente, seria necessário alterar o switch dentro do método extrato da classe Client. Isso torna o sistema frágil, pois modificações em código existente podem introduzir bugs.

## Refatoração com SOLID

## 1. Aplicação do Padrão Strategy e OCP
Para eliminar o switch e aderir ao OCP, foi aplicado o padrão de projeto Strategy.

Foi criada uma classe abstrata Price que define a interface para os cálculos de preço e pontos de fidelidade.

Foram implementadas classes concretas (NormalPrice, LancamentoPrice, InfantilPrice), cada uma encapsulando uma regra de cálculo específica.

A classe Tape agora possui uma instância de Price e delega a ela a responsabilidade do cálculo. Com isso, para adicionar uma nova categoria de fita, basta criar uma nova classe que herde de Price, sem a necessidade de modificar qualquer código já existente.

## 2. Delegação de Responsabilidades (SRP)
A lógica de cálculo de valor (getCharge) e pontos (getFrequentRenterPoints) foi movida da classe Client para as classes Rent e Tape.

A classe Client agora tem a única responsabilidade de gerenciar os dados do cliente e orquestrar a geração do extrato, delegando os cálculos para os objetos de aluguel. Os métodos getTotalCharge e getTotalFrequentRenterPoints foram criados para manter a coesão, consultando cada aluguel sobre seus respectivos totais.

## Estrutura das Classes Após a Refatoração
Client.java: Agora, focado em gerenciar os aluguéis de um cliente e formatar o extrato final. A lógica de cálculo foi completamente removida desta classe.

Tape.java: Representa uma fita e delega a lógica de precificação para um objeto Price.

Rent.java: Representa um aluguel e agora pode calcular seu próprio valor e pontos, servindo como um intermediário entre Client e Tape.

Price.java: (Nova) Classe abstrata que define o contrato para as diferentes regras de preço (Strategy).

NormalPrice.java, LancamentoPrice.java, InfantilPrice.java: (Novas) Implementações concretas do Price para cada categoria de fita.

Rental.java: Classe principal (main) para executar a aplicação, que permanece a mesma.
