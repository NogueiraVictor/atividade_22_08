public class Pessoa {

    private String nome;
    private double peso;
    private double altura;

    // Essa funcao so faz o calculor do IMC de atleta
    public double CalculadorIMC(double porcentagem) {
        if(porcentagem < 6) {
            return this.peso / (this.altura * this.altura);
        }else{
            return 0;
        }
    }


    public void MostrarDescricao(){
        System.out.printf("""
                ---------- DETALHES DO PESSOA ----------
                Nome: %s
                Peso: %.2f
                Altura: %.2f
                IMC: %.2f
                Seu estado e: %s
                """, this.nome, this.peso, this.altura, this.CalculadorIMC(0), this.PesoIdeal(CalculadorIMC(0)));
    }
    // Crie um metado para dizer se uma pessoa esta "saudavel ou nao"
    public String PesoIdeal(double CalculadorIMC){
        if(CalculadorIMC >= 0 && CalculadorIMC <= 18.5){
            return "Magreza";
        }else if(CalculadorIMC >= 18.5 && CalculadorIMC <= 24.9){
            return "Peso ideal";
        }else if(CalculadorIMC >= 25 && CalculadorIMC <= 29.9){
            return "SobrePeso";
        }else if (CalculadorIMC >= 30){
            return "Obediade";
        }
        return "";
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

}
