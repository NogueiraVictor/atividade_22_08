public class Motor {

    String tipo_combustivel;
    int potencia;
    double cilindrada;
    String tipo_motor;

    void detalhes_motor(){
        System.out.printf("""
                -------------DETALHES DO MOTOR-------------
               Tipo_combustivel: %s
               potencia: %d
               Cilindrada: %.2f
               tipo_motor: %s
              
               """, tipo_combustivel, potencia, cilindrada, tipo_motor);
    }
}
