package synchronization;

import synchronization.bean.P;
import synchronization.thread.Consumer;
import synchronization.thread.Producter;

/**
 * 线程间的通信 同步问题
 * wait: 告诉当前线程放弃监视器并进入睡眠状态，知道其他线程进入统一监视器并调用notify为止
 * notify： 唤醒同一对象监视其中调用wait的第一个线程，类似排队买票，一人买完之后，后面的人可以继续买
 * notifyAll：唤醒同一监视器中调用wait的所有线程，具有最高优先级的线程首先被唤醒并执行
 *
 * wait、notify、notifyAll只能在synchronized方法中调用，即无论线程调用一个对象的wait还是notify方法，
 * 该线程必须先得到该对象的锁标记，这样notify只能唤醒同一对象监视器中调用wait的线程，使用多个对象监视器就可以
 * 分别有多个wait、notify的情况，同组里的wait只能被同组的notify唤醒。
 */
public class Main {
    public static void main(String[] args){
        P p = new P();
        new Thread(new Producter(p)).start();
        new Thread(new Consumer(p)).start();
    }
}
