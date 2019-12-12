package Semaphores;

import java.util.concurrent.Semaphore;

public class Queue {

    private int item;
    private static Semaphore semConsumer = new Semaphore(1);
    private static Semaphore semProducer = new Semaphore(0);

    public void get() {
        try {
            //Der Semaphore wird auf "Rot" umgestellt für Semaphores.Producer, Semaphores.Producer kann den Prozess nicht aufhalten!
            semProducer.acquire();
            Thread.sleep(2000);
        }
        catch(InterruptedException e) {
            System.out.print("Caught a Interrupted Exception! Stack Strace: ");
            e.printStackTrace();
        }

        System.out.println("Semaphores.Consumer consumed item: " + item);

        //Der Semaphore für Semaphores.Producer wurde wieder auf "Grün" umgestellt, somit kann Semaphores.Producer wieder vom Scheduler zugewiesen werden.
        semProducer.release();
    }

    public void put(int number) {
        try {
            //Semaphores.Consumer kann nicht vom Scheduler mehr zugewiesen werden.
            semConsumer.acquire();
            Thread.sleep(1000);
        }
        catch (InterruptedException ex) {
            System.out.println("Caught a Interrupted Exception! Stack Strace: ");
            ex.printStackTrace();
        }

        this.item = number;
        System.out.println("Semaphores.Producer produced: " + number);
        semConsumer.release();
    }
}
