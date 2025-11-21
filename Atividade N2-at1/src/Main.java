import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SaldoInsuficienteException {

        ContaCorrente contaC = new ContaCorrente(4561, "Victor hugo");
        ContaPoupanca contaP = new ContaPoupanca(1563, contaC.getTitular());

        Scanner sc = new Scanner(System.in);
        int decisaoInicial = 0, opcao2 = 0;
        String opcao;
        String voltar;

        System.out.println("Seja bem vindo ao menu inicial do BancoApp!!");
        System.out.println("Você deseja mexer na conta 1 - corrente ou 2 - poupança?");
        opcao2 = sc.nextInt();

        if (opcao2 == 1) {
            // Conta Corrente
            do {
                System.out.printf("""
                        ---------- Bem vindo ao BancoApp ----------
                                   ---conta corrente---
                        
                                    escolha uma opção:
                        
                        Bem Vindo %s
                        numero: %d
                        1 - verificar saldo/extrato atual.
                        2 - sacar.
                        3 - deposito.
                        4 - transferir.
                        5 - Sair.
                        --------------------------------------------
                        """, contaC.getTitular(), contaC.getNumeroConta());
                decisaoInicial = sc.nextInt();
                sc.nextLine(); // Limpar buffer

                switch (decisaoInicial) {
                    case 1: // verificar saldo atual
                        contaC.MostrarInformacoes();
                        System.out.println("(v) - para voltar ao Menu.");
                        voltar = sc.nextLine();
                        while (!voltar.equalsIgnoreCase("v")) {
                            System.out.println("Digite 'v' para voltar:");
                            voltar = sc.nextLine();
                        }
                        break;

                    case 2: // sacar
                        System.out.println("Qual valor deseja sacar?");
                        double valorSacar = sc.nextDouble();
                        sc.nextLine(); // Limpar buffer
                        try {
                            contaC.sacar(valorSacar);


                            System.out.println("---------- BancoApp ----------");
                            System.out.println("Saque realizado com sucesso!");
                            System.out.printf("Valor sacado: R$%.2f%n", valorSacar);
                            contaC.MostrarInformacoes();

                            System.out.println("\nPrecisa de mais algum serviço?");
                            System.out.println("Digite (v) para voltar ao menu ou (s) para sair");
                            opcao = sc.nextLine();
                            if (opcao.equalsIgnoreCase("s")) {
                                System.out.println("Programa encerrando....");
                                return;
                            }
                            break;
                        } catch (SaldoInsuficienteException e) {
                            System.out.println("Problemas ao sacar: " + e.getMessage());
                        }
                        break;

                    case 3: // depositar
                        System.out.println("Qual valor deseja depositar?");
                        double valorDepositar = sc.nextDouble();
                        sc.nextLine(); // Limpar buffer
                        contaC.depositar(valorDepositar);


                        System.out.println("---------- BancoApp ----------");
                        System.out.println("Depósito realizado com sucesso!");
                        System.out.printf("Valor depositado: R$%.2f%n", valorDepositar);
                        contaC.MostrarInformacoes();

                        System.out.println("\nPrecisa de mais algum serviço?");
                        System.out.println("Digite (v) para voltar ao menu ou (s) para sair");
                        opcao = sc.nextLine();
                        if (opcao.equalsIgnoreCase("s")) {
                            System.out.println("Programa encerrando....");
                            return;
                        }
                        break;

                    case 4:
                        System.out.println("Qual valor deseja transferir para a poupança?");
                        double valorTransferir = sc.nextDouble();
                        sc.nextLine();


                        contaC.transferir(contaP, valorTransferir);

                        System.out.println("---------- BancoApp ----------");
                        System.out.println("Transferência realizada com sucesso!");
                        contaC.MostrarInformacoes();

                        System.out.println("\nPrecisa de mais algum serviço?");
                        System.out.println("Digite (v) para voltar ao menu ou (s) para sair");
                        opcao = sc.nextLine();
                        if (opcao.equalsIgnoreCase("s")) {
                            System.out.println("Programa encerrando....");
                            return;
                        }
                        break;

                    case 5: // sair
                        System.out.println("Programa encerrado....");
                        System.out.println("Obrigado, volte sempre e beba água!");
                        return;
                }
            } while (decisaoInicial != 5);

        } else {
            // Conta Poupança
            do {
                System.out.printf("""
                        ---------- Bem vindo ao BancoApp ----------
                                   ---conta poupança---
                        
                                    escolha uma opção:
                        
                        Bem Vindo %s
                        Numero: %d
                        1 - verificar saldo/extrato atual.
                        2 - sacar.
                        3 - deposito.
                        4 - transferir.
                        5 - Sair.
                        --------------------------------------------
                        """, contaP.getTitular(), contaP.getNumeroConta());
                decisaoInicial = sc.nextInt();
                sc.nextLine();

                switch (decisaoInicial) {
                    case 1: // verificar saldo atual
                        contaP.MostrarInformacoes();
                        System.out.println("(v) - para voltar ao Menu.");
                        voltar = sc.nextLine();
                        while (!voltar.equalsIgnoreCase("v")) {
                            System.out.println("Digite 'v' para voltar:");
                            voltar = sc.nextLine();
                        }
                        break;

                    case 2: // sacar
                        System.out.println("Qual valor deseja sacar?");
                        double valorSacar = sc.nextDouble();
                        sc.nextLine();
                        try {
                            contaP.sacar(valorSacar);

                            System.out.println("---------- BancoApp ----------");
                            System.out.println("Saque realizado com sucesso!");
                            contaP.MostrarInformacoes();

                            System.out.println("\nPrecisa de mais algum serviço?");
                            System.out.println("Digite (v) para voltar ao menu ou (s) para sair");
                            opcao = sc.nextLine();
                            if (opcao.equalsIgnoreCase("s")) {
                                System.out.println("Programa encerrando....");
                                return;
                            }
                        } catch (SaldoInsuficienteException e) {
                            System.out.println("Erro ao sacar: " + e.getMessage());
                        }
                        break;

                    case 3: // depositar
                        System.out.println("Qual valor deseja depositar?");
                        double valorDepositar = sc.nextDouble();
                        sc.nextLine();
                        contaP.depositar(valorDepositar);

                        System.out.println("---------- BancoApp ----------");
                        System.out.println("Depósito realizado com sucesso!");
                        contaP.MostrarInformacoes();

                        System.out.println("\nPrecisa de mais algum serviço?");
                        System.out.println("Digite (v) para voltar ao menu ou (s) para sair");
                        opcao = sc.nextLine();
                        if (opcao.equalsIgnoreCase("s")) {
                            System.out.println("Programa encerrando....");
                            return;
                        }
                        break;

                    case 4: // transferir
                        System.out.println("Qual valor deseja transferir para a conta corrente?");
                        double valorTransferir = sc.nextDouble();
                        sc.nextLine();

                        contaP.transferir(contaC, valorTransferir);

                        System.out.println("---------- BancoApp ----------");
                        System.out.println("Transferência realizada com sucesso!");
                        contaP.MostrarInformacoes();

                        System.out.println("\nPrecisa de mais algum serviço?");
                        System.out.println("Digite (v) para voltar ao menu ou (s) para sair");
                        opcao = sc.nextLine();
                        if (opcao.equalsIgnoreCase("s")) {
                            System.out.println("Programa encerrando....");
                            return;
                        }
                        break;

                    case 5: // sair
                        System.out.println("Obrigado, volte sempre e beba água!");
                        return;
                }
            } while (decisaoInicial != 5);
        }

        sc.close();
        System.out.println("Programa encerrado....");
        System.out.println("beba agua e volte sempre");
    }
}