package NoGuardedProducerConsumer;

public class Main {

    public static void main(String[] args) throws InterruptedException{
        Buffer buffer = Buffer.getInstance(2);

        Producer p = new Producer(buffer);

        Consumer c = new Consumer(buffer);

        p.th.start();
        c.th.start();

        p.th.join();
        c.th.join();
    }
}
