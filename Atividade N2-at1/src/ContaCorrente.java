public class ContaCorrente extends Conta implements OperacoesBancarias{

    public ContaCorrente(int numero, String titular) {
        super(numero, titular);
    }

    @Override
    public void aplicarJuros(double valor) {
        double taxaJuros = 0.005;// 0.5% a cada saque
        double taxa = getSaldoInicial() * taxaJuros;
        if (getSaldoInicial() > taxa) {
            try {
                super.sacar(taxa);
                System.out.printf("Para cada saque tem uma taxa administrativa de %.2f ", taxa);;
            } catch (SaldoInsuficienteException e) {
                System.out.println("Vc nao tem dinheiro suficiente para saque devido a taxa");
            }
        }
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
                ---------- Conta Corrente ----------
                Titular: %s
                numero da conta: %d
                Saldo: %.2f
                """, this.getTitular(), this.getNumeroConta(), this.getSaldoInicial());

    }


}
