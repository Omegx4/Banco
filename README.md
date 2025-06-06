# 🏦 Sistema de Conta Bancária em Java com POO

Este projeto é uma solução em Java que simula operações básicas de uma conta bancária, aplicando os princípios da **Programação Orientada a Objetos (POO)**. Desenvolvido como um exercício prático para demonstrar o uso de classes, objetos, encapsulamento e métodos em um cenário real.

---

## ✨ **Funcionalidades**

O sistema permite ao usuário interagir com uma conta bancária através das seguintes operações:

* **Criação de Conta:** Solicita e armazena o nome do titular, número da conta e saldo inicial.
* **Depósito:** Adiciona um valor ao saldo da conta.
    * Valida se o valor do depósito é positivo.
* **Saque:** Retira um valor do saldo da conta.
    * **Validação de Saldo:** Impede saques com valor superior ao saldo disponível.
    * **Limite de Saque:** Impede saques acima de R$ 5.000,00.
* **Consulta de Saldo:** Exibe o saldo atual da conta.
* **Interatividade:** O usuário pode realizar quantas operações desejar, com mensagens claras para cada ação.
* **Saída:** Opção para encerrar o programa a qualquer momento.
