package Semaphores;

public class Main {

    public static void main(String[] args) throws InterruptedException{
        Queue q = new Queue();

        Consumer c = new Consumer(q);

        Producer p = new Producer(q);
    }
}
