package Programa;
import java.util.ArrayList;
import java.util.Scanner;
public class AgenciaBancaria {
    public static Scanner input = new Scanner(System.in);
    static ArrayList<ContaBancaria> contasBancarias;
    public static void main(String[] args) {
        contasBancarias = new ArrayList<ContaBancaria>();
        operacoes();
    }
        public static void operacoes () {
            System.out.println("------------------------------------------------------");
            System.out.println("-------------Bem vindos a nossa Agência---------------");
            System.out.println("------------------------------------------------------");
            System.out.println("***** Selecione uma operação que deseja realizar *****");
            System.out.println("------------------------------------------------------");
            System.out.println("|   Opção 1 - Criar conta   |");
            System.out.println("|   Opção 2 - Depositar     |");
            System.out.println("|   Opção 3 - Sacar         |");
            System.out.println("|   Opção 4 - Transferir    |");
            System.out.println("|   Opção 5 - Listar        |");
            System.out.println("|   Opção 6 - Sair          |");

            int operacao = input.nextInt();

            switch (operacao) {
                case 1 -> criarConta();
                case 2 -> depositar();
                case 3 -> sacar();
                case 4 -> transferir();
                case 5 -> listarContas();
                case 6 -> {
                    System.out.println("Obrigado por utilizar nossa agência!");
                    System.exit(0);
                }
                default -> {
                    System.out.println("Opção inválida!");
                    operacoes();
                }
            }
        }


        public static void criarConta () {
            System.out.println("\nNome: ");
            String nome = input.next();

            System.out.println("\nCPF: ");
            String cpf = input.next();

            System.out.println("\nEmail: ");
            String email = input.next();

            Cliente cliente = new Cliente(nome, cpf, email);

            ContaBancaria contaBancaria = new ContaBancaria(cliente);

            contasBancarias.add(contaBancaria);

            System.out.println("Sua conta foi incluída com sucesso!");

            operacoes();
        }

        private static ContaBancaria encontrarConta ( int numeroConta){
            ContaBancaria contaBancaria = null;
            if (contasBancarias.size() > 0) {
                for (ContaBancaria c : contasBancarias) {
                    if (c.getNumeroConta() == numeroConta) {
                        contaBancaria = c;
                    }
                }
            }
            return contaBancaria;
        }
        public static void depositar () {
            System.out.println("Digíte o número da conta: ");
            int numeroConta = input.nextInt();

            ContaBancaria contaBancaria = encontrarConta(numeroConta);

            if (contaBancaria != null) {
                System.out.println(("Digíte o valor que deseja depositar: "));
                Double valorDeposito = input.nextDouble();
                contaBancaria.depositar(valorDeposito);
//            System.out.println("Deposito realizado com sucesso!");
            } else {
                System.out.println("Conta não encontrada!");
            }
            operacoes();
        }

        public static void sacar () {
            System.out.println("Digíte o número da conta: ");
            int numeroConta = input.nextInt();

            ContaBancaria contaBancaria = encontrarConta(numeroConta);

            if (contaBancaria != null) {
                System.out.println("Digíte o valor que deseja sacar: ");
                Double valorSaque = input.nextDouble();
                contaBancaria.sacar(valorSaque);
//            System.out.println("Saque realizado com sucesso!");
            } else {
                System.out.println("Conta não encontrada!");
            }
            operacoes();
        }
        public static void transferir () {
            System.out.println("Digíte o número da conta do rementente: ");
            int numeroContaRemetente = input.nextInt();
            ContaBancaria contaRemetente = encontrarConta(numeroContaRemetente);

            if (contaRemetente != null) {
                System.out.println("Digíte o número da conta do destinatário: ");
                int numeroContaDestinatario = input.nextInt();
                ContaBancaria contaDestinatario = encontrarConta(numeroContaDestinatario);

                if (contaDestinatario != null) {
                    System.out.println(("Digíte o valor que deseja transferir: "));
                    Double valorTransferencia = input.nextDouble();
                    contaRemetente.transferir(contaDestinatario, valorTransferencia);
                } else {
                    System.out.println("Conta para depósito não foi encontrada!");
                }
            } else {
                System.out.println("Conta para transferência não encontrada!");
                operacoes();
            }
        }

        public static void listarContas () {
            if (contasBancarias.size() > 0) {
                for (ContaBancaria contaBancaria : contasBancarias) {
                    System.out.println(contaBancaria);
                }
            } else {
                System.out.println("Não existem contas cadastradas!");
            }
            operacoes();

        }

    }

