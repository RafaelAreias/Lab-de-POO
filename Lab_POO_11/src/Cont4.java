import java.util.concurrent.*;
public class Cont4 extends Thread{

    @Override
    public void run() {
        for (int i = 2; i <= 6; i++) {
            System.out.println("Thread 2: " + i);

            try{
                TimeUnit.SECONDS.sleep(4);
            }

            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}