public class Carro {

    String modelo;
    String marca;
    int anoDeFabricacao;
    String cor;
    Motor motor;

    void detalhes(){
        System.out.printf("""
                ------------DETALHES DE CARRO------------
                Modelo: %s
                Marca: %s
                Ano de frabricação: %d
                Cor: %s
                
                """, modelo, marca, anoDeFabricacao, cor);
        if (motor != null) {
            motor.detalhes_motor();
        } else {
            System.out.println("Esse carro não possui motor definido!");
        }

    }



    void ligar_carro(){
        System.out.println("Motor do carro foi ligador!!\n");
    }

    void desligar_carro(){
        System.out.println("Motor do carro foi desligado!!\n");
    }
}
