package NoGuardedProducerConsumer;

public class Consumer implements Runnable {
    private Buffer q;
    public Thread th;

    public Consumer(Buffer q) throws InterruptedException{
        this.q = q;
        this.th = new Thread(this, "Consumer");
    }

    @Override
    public void run() {
        try {
            q.consume();
        }
        catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}
