public class ContaCorrente extends Conta implements OperacoesBancarias{

    public ContaCorrente(int numero, String titular, double saldoInicial) {
        super(numero, titular, saldoInicial);
    }

    @Override
    public void atualizarSaldo() {
        double taxaJuros = 0.005; // 0.5% ao mês
        double v = super.getSaldo() * taxaJuros;
    }

    @Override
    public void transferir(Conta destino, double valor) {

        if (valor > 0 && super.getSaldo() >= valor) {
            double t = super.getSaldo() - valor;
            destino.depositar(valor);
            System.out.println("Transferência realizada com sucesso.");
        } else {
            System.out.println("Saldo insuficiente ou valor inválido.");
        }
    }

    @Override
    public void MostrarInformacoes(double valor, String titular, int numeroConta) {
        System.out.printf("""
                ---------- Conta Corrente ----------
                Titular: %s
                numero da conta: %d
                Saldo: %.2f
                """, this.getTitular(), valor, this.getSaldo());

    }
}
