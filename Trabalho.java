class Conta {
    private int numero;
    private double saldo;

    // Construtor
    public Conta(int numero, double saldoInicial) {
        this.numero = numero;
        this.saldo = saldoInicial;
    }

    // Métodos
    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void creditar(double valor) {
        this.saldo += valor;
    }

    public void debitar(double valor) {
        if (valor > saldo) {
            System.out.println("Saldo insuficiente para debitar.");
        } else {
            this.saldo -= valor;
        }
    }

    // Duas contas são iguais se os números forem iguais
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Conta conta = (Conta) obj;
        return numero == conta.numero;
    }
}


class Cliente {
    private String nome;
    private Conta conta;

    // Construtor
    public Cliente(String nome, int numeroConta, double saldoInicial) {
        this.nome = nome;
        this.conta = new Conta(numeroConta, saldoInicial);
    }

    // Métodos
    public Conta getConta() {
        return conta;
    }

    public String getNome() {
        return nome;
    }

    // Dois clientes são iguais se possuem o mesmo saldo
    public boolean equals(Cliente c) {
        if (c == null) return false;
        return this.conta.getSaldo() == c.getConta().getSaldo();
    }
}

public class Main{
    public static void main(String[] args) {
        Cliente bia = new Cliente("Bianca", 123, 100);
        Cliente benjamin = new Cliente("Benjamin", 456, 0);

        // Operações
        bia.getConta().debitar(50);
        benjamin.getConta().creditar(50);

        // Saída
        System.out.println("Saldo Bia = " + bia.getConta().getSaldo());
        System.out.println("Saldo Ben = " + benjamin.getConta().getSaldo());
        System.out.println("Bia e Ben são iguais = " + bia.equals(benjamin));
    }
}
