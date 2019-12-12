package Synchronized;

public class Producer implements Runnable {
    private Buffer q;
    public Thread th;

    public Producer(Buffer q) {
        this.q = q;
        this.th = new Thread(this, "Producer");
    }

    @Override
    public void run() {
        try {
            q.produce();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
