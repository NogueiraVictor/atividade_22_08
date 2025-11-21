public class ContaPoupanca extends Conta implements OperacoesBancarias{

    public ContaPoupanca(int numero, String titular) {
        super(numero, titular);
    }

    @Override
    public void aplicarJuros(double valor) {
        double taxaJuros = 0.003;// 0.3% por mes
        double aux = getSaldoInicial() * taxaJuros;
        depositar(aux);
        System.out.printf("\njuros de R$%.2f, aumentor aplicado e aumentou o seu saldo no valor ", aux);
    }

    @Override
    public void transferir(Conta destino, double valor) {

        if (valor > 0 && this.podeSacar(valor)) {
            try {
                this.sacar(valor);
                destino.depositar(valor);
                System.out.println("Transferência realizada com sucesso.");
            } catch (SaldoInsuficienteException e) {
                System.out.println("Erro na transferência: " + e.getMessage());
            }
        } else {
            System.out.println("Saldo insuficiente ou valor inválido para transferência.");
        }
    }

    @Override
    public void MostrarInformacoes() {
        System.out.printf("""
                ---------- Conta Pouoanca ----------
                Titular: %s
                numero da conta: %d
                Saldo: %.2f
                """, this.getTitular(), this.getNumeroConta(), this.getSaldoInicial());

    }
}
