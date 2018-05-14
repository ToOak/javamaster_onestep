package deadlock;

import deadlock.bean.A;
import deadlock.bean.B;
import deadlock.thread.TestThread;

/**
 * 死锁
 * 吃饭时，a持有一只筷子和一把刀，b持有一只筷子和一把叉子，双方都不能吃饭
 * 子线程进入了b的监视器在等待a的监视器 主线程进入了a的监视器在等待b的监视器
 * 要避免死锁，应确保在获取多个锁时，在所有的线程中都以相同的顺序获取锁
 */
public class Main {
    public static void main(String[] args) {
//        new TestThread();
        A a = new A();
        B b = new B();
        new Thread(() -> b.method(a)).start();
        a.method(b);
    }

}
