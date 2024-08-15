import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int n;
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        System.out.println("O fatorial de " + n + " é " + calcularFatorial(n));
        System.out.print("Os pares entre 0 e " + n + " são: ");
        mostraPares(n);
    }

    public static int calcularFatorial(int n) {

        if(n == 1) return 1;
        else return n * calcularFatorial(n-1);
    }

    public static void mostraPares(int n){

        for(int i=0; i<n; i++){
            if(i%2 == 0){
                System.out.print(i+" ");
            }
        }
    }
}