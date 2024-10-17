package br.inatel.cdg;

public class Conta {

    private int numero;
    private float saldo;
    private float limite;
    public Cliente[] clientes;

    public Conta() {
        clientes = new Cliente[2];
        clientes[0] = new Cliente();
        clientes[1] = new Cliente();
    }

    public void sacar(float quantia){
        if(this.saldo >= quantia){
            this.saldo -= quantia;
            System.out.println("Sacou R$ " + quantia);
        }

        else
            System.out.println("Saldo insuficiente");
    }

    public void depositar(float quantia){
        this.saldo += quantia;
        System.out.println("Depositou R$ " + quantia);
    }
}
