//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Alberto Ribeiro");
        pessoa.setPeso(70);
        pessoa.setAltura(1.75);

        Atleta atleta = new Atleta();
        atleta.setNome("David Gomes");
        atleta.setEsportePraticado("Jogador de futebol"); // se caso esse set for igual null, o calculo do IMC mudar
        atleta.setPeso(100);
        atleta.setAltura(1.90);



        CalculoFeito calculoFeito = new CalculoFeito();
        pessoa.MostrarDescricao();
        atleta.MostrarDescricao();
        calculoFeito.CalcularImc(atleta); // Chamada do polimofismo
        calculoFeito.CalcularImc(pessoa);


    }
    public static void Seila(){

    }
}