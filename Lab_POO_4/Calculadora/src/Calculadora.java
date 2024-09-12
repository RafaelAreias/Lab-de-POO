public class Calculadora {

    private static float PI = 3.1415F;

    public static double circunferencia(double raio){
        return 2*PI*raio;
    }

    public static double volumeEsfera(double raio){
        return 4/3*PI*Math.pow(raio,3);
    }

    public static double volumeCilindro(double raio, double altura){
        return PI*Math.pow(raio,2)*altura;
    }
}
