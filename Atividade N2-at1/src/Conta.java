public abstract class Conta {
    private int numeroConta;
    private String titular;
    private double saldoInicial = 1404.00;

    public Conta(int numero, String titular) {
        this.numeroConta = numero;
        this.titular = titular;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            this.saldoInicial += valor;
            System.out.println("Parabens, depósito realizado com sucesso.");
        } else {
            System.out.println("Valor de depósito nao pode ser menor ou igual a zero.");
        }
    }

    public void sacar(double valor) throws SaldoInsuficienteException {
        if (valor <= 0) {
            throw new SaldoInsuficienteException("nao podemos sacar um valor que seja menor ou igual a zero.");
        }
        if (valor > saldoInicial) {
            throw new SaldoInsuficienteException("saldo da conta e inferior a esse valor de saque.");
        }else{
            saldoInicial -= valor;
        }
    }

    public boolean podeSacar(double valor) {
        return valor > 0 && valor <= saldoInicial;
    }

    public double getSaldoInicial() {
        return saldoInicial;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public String getTitular() {
        return titular;
    }

    public abstract void aplicarJuros(double valor);
}

