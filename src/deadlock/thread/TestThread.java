package deadlock.thread;

import deadlock.bean.A;
import deadlock.bean.B;

public class TestThread implements Runnable {

    private A a = new A();
    private B b = new B();

    public TestThread() {
        System.out.println(Thread.currentThread().getName() + "-->test thread start 1!");
        new Thread(this).start();
        System.out.println(Thread.currentThread().getName() + "-->test thread start 2!");
        a.method(b);
        System.out.println(Thread.currentThread().getName() + "-->test thread start 3!");

    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "-->test thread start 4!");
        b.method(a);
        System.out.println(Thread.currentThread().getName() + "-->test thread end!");
    }
}
