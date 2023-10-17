import java.util.List;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Producer implements Runnable{
    private Queue<Shirt> store;
    private String name;
    private int maxSize;
    Semaphore semaProducer;
    Semaphore semaConsumer;

    public Producer(Queue<Shirt> store, String name, int maxSize, Semaphore semaProducer, Semaphore semaConsumer) {
        this.maxSize = maxSize;
        this.store = store;
        this.name = name;
        this.semaProducer = semaProducer;
        this.semaConsumer = semaConsumer;
    }

    @Override
    public void run() {
        while(true) {
            try {
                semaProducer.acquire();
                System.out.println("Current Size - " + store.size() + " Added by producer - " + name);
                store.add(new Shirt());
                semaConsumer.release();
            } catch (Exception e) {
                e.getMessage();
            }
        }
    }
}
