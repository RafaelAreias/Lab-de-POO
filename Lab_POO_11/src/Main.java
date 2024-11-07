public class Main {
    public static void main(String[] args) {

        Cont2 A = new Cont2();
        new Thread(A).start();

        Cont4 B = new Cont4();
        new Thread(B).start();

        Quadrado C = new Quadrado();
        new Thread(C).start();
    }
}