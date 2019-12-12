package Synchronized;

public class Main {

    public static void main(String[] args) throws InterruptedException{
        Buffer buffer = Buffer.getInstance(2);

        Consumer c = new Consumer(buffer);

        Producer p = new Producer(buffer);

        c.th.start();
        p.th.start();

        c.th.join();
        p.th.join();
    }
}
