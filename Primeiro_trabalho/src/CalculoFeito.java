public class CalculoFeito {

    double calculo;

    // decidade fazer o polimofismo separado, so pro efeito didatico.
    public void CalcularImc(Pessoa pessoa){ // polimofismo feito
        System.out.println("Calculando imc feito com sucesso");
        System.out.printf("%.2f\n", pessoa.CalculadorIMC(5));
    }
    public double getCalculo(){
        return calculo;
    }
}
