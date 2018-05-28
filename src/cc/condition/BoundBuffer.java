package cc.condition;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.System.out;

public class BoundBuffer {
    final Lock lock = new ReentrantLock();
    final Condition notFull = lock.newCondition();
    final Condition notEmpty = lock.newCondition();
    final Object[] items = new Object[10];
    int putptr, takeptr, count;

    public void put(Object x) {
        try {
            lock.lock();
            while (count == items.length) {
                notFull.await();
            }
            items[putptr] = x;
//            Thread.sleep(1500);
            if (++putptr == items.length) {
                putptr = 0;
            }
            ++count;
            notEmpty.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
            out.println(Thread.currentThread().getName() + "\t" + Arrays.toString(this.items));
        }
    }

    public Object take() {
        Object x = null;
        try {
            lock.lock();
            while (count == 0) {
                notEmpty.await();
            }

            x = items[takeptr];
            if (++takeptr == items.length) {
                takeptr = 0;
            }
            Thread.sleep(1500);
            --count;
            notFull.signal();
            return x;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return x;
        } finally {
            lock.unlock();
            out.println(Thread.currentThread().getName() + "\t" +x);
        }
    }
}
