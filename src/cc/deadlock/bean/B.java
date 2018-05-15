package cc.deadlock.bean;

public class B {
    public synchronized void method(A a) {
        System.out.println(Thread.currentThread().getName() + "-->B method start!");
        try {
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + "-->B method stop sleep!");
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + "-->B method sleep error!");
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + "-->B method want for A lose!");
        a.lose();
        System.out.println(Thread.currentThread().getName() + "-->B method end!");

    }

    public synchronized void lose() {
        System.out.println(Thread.currentThread().getName() + "-->B lose!");
    }
}
