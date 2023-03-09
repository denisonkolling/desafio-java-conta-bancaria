package Programa;

import Programa.utilitarios.Utils;

public class ContaBancaria {

    private static int contadorDeContas = 1000;
    private int numeroConta;
    private Cliente cliente;
    private Double saldo = 0.0;

    public ContaBancaria(Cliente cliente) {
        this.numeroConta = contadorDeContas;
        this.cliente = cliente;
        contadorDeContas += 1;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "\nNúmero da conta: " + this.getNumeroConta() +
                "\nCliente: " + this.cliente.getNome() +
                "\nCPF: " + this.cliente.getEmail() +
                "\nSaldo: " + this.cliente.getCpf()+
                "\nSaldo: " + Utils.doubleToString(this.getSaldo())+
                "\n";
    }

    public void depositar(Double valor){
        if ( valor > 0){
            setSaldo(getSaldo() + valor);
            System.out.println("Seu depósito foi realizado com sucesso!");
        } else {
            System.out.println("Não foi possível realizar seu depósito!");
        }
    }

    public void sacar(Double valor){
        if ( valor > 0 && this.getSaldo() >= valor){
            setSaldo(getSaldo() - valor);
            System.out.println("Saque realizado com sucesso!");
        } else {
            System.out.println("Não foi possivel realizar seu saque");

        }
    }

    public void transferir(ContaBancaria contaParaDeposito, Double valor){
        if (valor > 0 && this.getSaldo() >= valor){
            setSaldo(getSaldo() - valor);
            contaParaDeposito.saldo = contaParaDeposito.getSaldo() + valor;
            System.out.println("Transferência realizada com sucesso!");
        } else {
            System.out.println("Não foi possível realizar a tranferência!");
        }
    }

}
