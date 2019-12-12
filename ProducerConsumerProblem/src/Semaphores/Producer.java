package Semaphores;

public class Producer implements Runnable {
    private Queue q;
    private int produced = 0;

    public Producer(Queue q) {
        this.q = q;
        new Thread(this, "Semaphores.Producer").start();
    }

    @Override
    public void run() {
        q.put(++produced);
    }
}
