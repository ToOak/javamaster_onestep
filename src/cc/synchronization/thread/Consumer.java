package cc.synchronization.thread;

import cc.synchronization.bean.P;

/**
 * 消费者
 */
public class Consumer implements Runnable {
    P p = null;

    public Consumer(P p) {
        this.p = p;
    }

    @Override
    public void run() {
        while (true) {
            p.get();
        }
    }
}
