public class Main {
    public static void main(String[] args) {

        double altura = 2;
        double raio = 3;

        System.out.println("Circunferência: " + Calculadora.circunferencia(raio));
        System.out.println("Volume da esfera: " + Calculadora.volumeEsfera(raio));
        System.out.println("Volume do cilindro: " + Calculadora.volumeCilindro(raio,altura));
    }
}