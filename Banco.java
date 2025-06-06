import java.util.InputMismatchException;
import java.util.Scanner;

public class Banco {

    // --- Classe Aninhada: ContaBancaria ---
    static class ContaBancaria {
        // Atributos da Conta Bancária
        private String nomePessoa;
        private String numeroConta;
        private double saldo;

        // Construtor da ContaBancaria
        public ContaBancaria(String nomePessoa, String numeroConta, double saldoInicial) {
            this.nomePessoa = nomePessoa;
            this.numeroConta = numeroConta;
            this.saldo = saldoInicial;
        }

        // Métodos (Ações) da Conta Bancaria

        /**
         * Realiza um depósito na conta.
         * @param valor O valor a ser depositado.
         */
        public void depositar(double valor) {
            if (valor > 0) {
                this.saldo += valor;
                System.out.printf("Depósito de R$ %.2f realizado com sucesso.\n", valor);
            } else {
                System.out.println("Valor de depósito inválido. O valor deve ser positivo.");
            }
        }

        /**
         * Realiza um saque da conta, aplicando regras de negócio.
         * @param valor O valor a ser sacado.
         */
        public void sacar(double valor) {
            if (valor <= 0) {
                System.out.println("Valor de saque inválido. O valor deve ser positivo.");
            } else if (valor > 5000.00) {
                System.out.println("Valor do saque acima do permitido. Limite máximo é R$ 5000,00.");
            } else if (this.saldo >= valor) {
                this.saldo -= valor;
                System.out.printf("Saque de R$ %.2f realizado com sucesso.\n", valor);
            } else {
                System.out.println("Saldo insuficiente para realizar a operação.");
            }
        }

        /**
         * Retorna o saldo disponível na conta.
         * @return O saldo atual da conta.
         */
        public double obterSaldo() {
            return this.saldo;
        }

        /**
         * Imprime as informações básicas da conta.
         */
        public void imprimirInformacoesConta() {
            System.out.println("\n--- Detalhes da Conta ---");
            System.out.println("Nome: " + this.nomePessoa);
            System.out.println("Número da Conta: " + this.numeroConta);
            System.out.printf("Saldo Atual: R$ %.2f\n", this.saldo);
            System.out.println("------------------------");
        }
    }

    // --- Classe Principal: Main ---
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContaBancaria conta = null; // Objeto da conta bancária

        System.out.println("--- Criação da Conta Bancária ---");
        System.out.print("Informe o Nome da Pessoa: ");
        String nome = scanner.nextLine();

        System.out.print("Informe o Número da Conta: ");
        String numConta = scanner.nextLine();

        double saldoInicial = 0;
        boolean inputValido = false;
        while (!inputValido) {
            try {
                System.out.print("Informe o Saldo Inicial: R$ ");
                saldoInicial = scanner.nextDouble();
                if (saldoInicial < 0) {
                    System.out.println("O saldo inicial não pode ser negativo. Tente novamente.");
                } else {
                    inputValido = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida para o saldo. Por favor, digite um número.");
                scanner.next(); // Consome a entrada inválida
            }
        }
        scanner.nextLine(); // Consumir a quebra de linha pendente após nextDouble()

        // Cria a instância da ContaBancaria
        conta = new ContaBancaria(nome, numConta, saldoInicial);
        System.out.println("\nConta bancária criada com sucesso.");
        conta.imprimirInformacoesConta();

        // --- Menu de Operações ---
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n--- Escolha uma Operação ---");
            System.out.println("1 - Depositar Valor");
            System.out.println("2 - Sacar Valor");
            System.out.println("3 - Obter Saldo Disponível");
            System.out.println("0 - Sair");
        }
    }
}