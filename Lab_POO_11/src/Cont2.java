import java.util.concurrent.*;
public class Cont2 extends Thread{

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("Thread 1: " + i);

            try{
                TimeUnit.SECONDS.sleep(2);
            }

            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
