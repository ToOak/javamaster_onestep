package cc.synchronization.bean;

public class P {
    private String name;
    private String sex;
    private boolean isFull = false;

    public synchronized void set(String name, String sex) {
        if (isFull) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.name = name;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.sex = sex;
        isFull = true;
        notify();
    }

    public synchronized void get() {
        if (!isFull) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(this.name + "-->" + this.sex);
        isFull = false;
        notify();
    }
}
