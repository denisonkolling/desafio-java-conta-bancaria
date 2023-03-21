package Programa;
import javax.swing.*;
import java.util.ArrayList;
public class AgenciaBancaria {

    static ArrayList<ContaBancaria> contasBancarias;
    public static void main(String[] args) {
        contasBancarias = new ArrayList<ContaBancaria>();
        operacoes();
    }
        public static void operacoes () {
            int operacao =
                    Integer.parseInt(JOptionPane.showInputDialog("----- Selecione uma operação -----\n" +
            "|   Opção 1 - Criar conta \n" +
            "|   Opção 2 - Depositar\n" +
            "|   Opção 3 - Sacar\n" +
            "|   Opção 4 - Transferir\n" +
            "|   Opção 5 - Listar\n" +
            "|   Opção 6 - Sair\n"));

            switch (operacao) {
                case 1 -> criarConta();
                case 2 -> depositar();
                case 3 -> sacar();
                case 4 -> transferir();
                case 5 -> listarContas();
                case 6 -> {
                    JOptionPane.showMessageDialog(null,"Obrigado por utilizar nossa agência!");
                    System.exit(0);
                }
                default -> {
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
                    operacoes();
                }
            }
        }


        public static void criarConta () {

            Cliente cliente = new Cliente();

            cliente.setNome(JOptionPane.showInputDialog("Nome:"));

            cliente.setCpf(JOptionPane.showInputDialog("CPF:"));

            cliente.setEmail(JOptionPane.showInputDialog("Email:"));


            ContaBancaria contaBancaria = new ContaBancaria(cliente);

            contasBancarias.add(contaBancaria);

            JOptionPane.showInputDialog(null, "Sua conta foi incluída com sucesso!");

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

            int numeroConta = Integer.parseInt(JOptionPane.showInputDialog("Número da conta para depósito:"));

            ContaBancaria contaBancaria = encontrarConta(numeroConta);

            if (contaBancaria != null) {
                Double valorDeposito = Double.parseDouble(JOptionPane.showInputDialog("Digíte o valor que deseja depositar:"));
                contaBancaria.depositar(valorDeposito);
            } else {
                JOptionPane.showMessageDialog(null,"Conta não encontrada!");
            }
            operacoes();
        }

        public static void sacar () {

            int numeroConta = Integer.parseInt(JOptionPane.showInputDialog("Digíte o número da conta: "));

            ContaBancaria contaBancaria = encontrarConta(numeroConta);

            if (contaBancaria != null) {
                Double valorSaque = Double.parseDouble(JOptionPane.showInputDialog("Digíte o valor que deseja sacar: "));
                contaBancaria.sacar(valorSaque);
            } else {
                JOptionPane.showMessageDialog(null,"Conta não encontrada!");
            }
            operacoes();
        }
        public static void transferir () {

            int numeroContaRemetente = Integer.parseInt(JOptionPane.showInputDialog("Digíte o número da conta do rementente: "));
            ContaBancaria contaRemetente = encontrarConta(numeroContaRemetente);

            if (contaRemetente != null) {
                int numeroContaDestinatario = Integer.parseInt(JOptionPane.showInputDialog("Digíte o número da conta do destinatário: "));
                ContaBancaria contaDestinatario = encontrarConta(numeroContaDestinatario);

                if (contaDestinatario != null) {
                    Double valorTransferencia = Double.parseDouble(JOptionPane.showInputDialog("Digíte o valor que deseja transferir: "));
                    contaRemetente.transferir(contaDestinatario, valorTransferencia);
                } else {
                    JOptionPane.showMessageDialog(null,"Conta para depósito não encontrada!");
                }
            } else {
                 JOptionPane.showMessageDialog(null,"Conta para transferência não encontrada!");
            }
                operacoes();
        }

        public static void listarContas () {
            if (contasBancarias.size() > 0) {
                for (ContaBancaria contaBancaria : contasBancarias) {
                    JOptionPane.showMessageDialog(null,contaBancaria);
                }
            } else {
                JOptionPane.showMessageDialog(null,"Não existem contas cadastradas!");
            }
            operacoes();

        }

    }

