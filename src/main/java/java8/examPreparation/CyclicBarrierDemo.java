package java8.examPreparation;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

    public static void main(String[] args){
        final CyclicBarrier cyclicBarrier = new CyclicBarrier(3,()-> System.out.println("Let's enrich"));

        Runnable r = () ->{
            System.out.println(String.format("Trying %s...%d", Thread.currentThread().getName(), System.currentTimeMillis()));
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        };

        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        Thread t3 = new Thread(r);

        t1.start();
        t2.start();
        t3.start();
    }
}
