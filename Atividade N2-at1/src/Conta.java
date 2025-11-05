public abstract class Conta {
    private int numeroConta;
    private String titular;
    private double saldo;

    public Conta(int numero, String titular, double saldoInicial) {
        this.numeroConta = numero;
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
        }
    }

    public void sacar(double valor) throws SaldoInsuficienteException {
        if (valor <= 0) {
            throw new SaldoInsuficienteException("nao podemos sacar um valor que seja menor ou igual a zero.");
        }
        if (valor > saldo) {
            throw new SaldoInsuficienteException("saldo da conta e inferior a esse valor de saque.");
        }
//        saldo -= valor;
    }


    public double getSaldo() {
        return saldo;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public String getTitular() {
        return titular;
    }

    public abstract void atualizarSaldo();
}

