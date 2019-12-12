package Semaphores;

public class Consumer implements Runnable {
    private Queue q;

    public Consumer(Queue q) throws InterruptedException{
        this.q = q;
        new Thread(this, "Semaphores.Consumer").start();

    }

    @Override
    public void run() {
        q.get();
    }
}
