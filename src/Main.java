//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        Carro carro = new Carro();

        carro.marca = "Ford";
        carro.modelo = "Maverick_black";
        carro.anoDeFabricacao = 2024;
        carro.cor = "Verde";
        Motor motor = new Motor();
        motor.tipo_combustivel = "Gasolina";
        motor.potencia = 253;
        motor.tipo_motor = "EcoBoost";
        motor.cilindrada = 2.0;


        Carro outroCarro = new Carro();

        outroCarro.marca = "Byd";
        outroCarro.modelo = "Dolphin_mini";
        outroCarro.anoDeFabricacao = 2023;
        outroCarro.cor = "Azul_meia_noite";
        Motor outroMotor = new Motor();
        outroMotor.tipo_combustivel = "BEV";
        outroMotor.potencia = 75;
        outroMotor.tipo_motor = "Eletrico";
        outroMotor.cilindrada = 1.0;

        // fazendo uma "intregração" de motor com o carro
        carro.motor = motor; // aqui é o pulo do gato, com essa linha a class motor tem que ser inicializada primeiro, para depois a class carro
        carro.ligar_carro();
        carro.detalhes();
        carro.desligar_carro();

        // fazendo uma "intregração" de motor com o carro
        outroCarro.motor = outroMotor; // aqui é o pulo do gato, com essa linha a class motor tem que ser inicializada primeiro, para depois a class carro
        outroCarro.ligar_carro();
        outroCarro.detalhes();
        outroCarro.desligar_carro();


    }
}