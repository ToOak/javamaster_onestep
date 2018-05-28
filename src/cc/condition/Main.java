package cc.condition;

import javax.swing.plaf.basic.BasicButtonUI;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        BoundBuffer b = new BoundBuffer();
        new Thread(new Taker(b)).start();
        new Thread(new Puter(b)).start();

    }

    static class Puter implements Runnable {
        private BoundBuffer b;

        public Puter(BoundBuffer b) {
            this.b = b;
        }

        @Override
        public void run() {
            Thread.currentThread().setName("PUTER");
            while (true) {
                b.put(new Random().nextInt(100));
//                System.out.println(Thread.currentThread().getName() + "\t" + Arrays.toString(b.items));
            }
        }
    }

    static class Taker implements Runnable {
        private BoundBuffer b;

        public Taker(BoundBuffer b) {
            this.b = b;
        }

        @Override
        public void run() {
            Thread.currentThread().setName("TAKER");
            while (true) {
                b.take();
//                System.out.println(Thread.currentThread().getName() + "\t" + b.take().toString());
//                System.out.println(Thread.currentThread().getName() + "\t" + Arrays.toString(b.items));
            }

        }
    }

}
