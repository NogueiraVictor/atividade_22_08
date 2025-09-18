public class Atleta extends Pessoa{

    private String EsportePraticado;

        // Essa funcao so faz o calculor do IMC de atleta
    public double CalculadorIMC(double porcentagem){
        if (EsportePraticado != null){
            if(porcentagem >= 5) {
                double aux = 0;
                aux = super.CalculadorIMC(0) * porcentagem / 100; // chamando a super class, economizar linhas de codigos.
                return super.CalculadorIMC(0) - aux;
            }
        }
        return super.CalculadorIMC(0); // decidade fazer uma verificacao se realmente existe atleta
    }

    public void MostrarDescricao(){
        System.out.printf("""
                
                ---------- DETALHES DO Atleta ----------
                Nome: %s
                EsportePraticado: %s
                Peso: %.2f
                Altura: %.2f
                IMC: %.2f
                IMX de atleta: %.2f
                Seu estado e: %s
                """, this.getNome(),this.EsportePraticado, this.getPeso(), this.getAltura(), this.CalculadorIMC(0),this.CalculadorIMC(5), this.PesoIdeal(CalculadorIMC(0)));
    }



    public String getEsportePraticado() {
        return EsportePraticado;
    }

    public void setEsportePraticado(String esportePraticado) {
        EsportePraticado = esportePraticado;
    }
}
