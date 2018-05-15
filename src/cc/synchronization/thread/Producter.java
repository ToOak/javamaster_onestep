package cc.synchronization.thread;

import cc.synchronization.bean.P;

/**
 * 生产者
 */
public class Producter implements Runnable {
    P p = null;

    public Producter(P p) {
        this.p = p;
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {
            if (i == 0) {
                p.set("张三", "男");
            } else {
                p.set("李四", "女");
            }
            i = (i + 1) % 2;
        }
    }
}
