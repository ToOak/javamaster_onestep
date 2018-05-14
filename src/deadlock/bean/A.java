package deadlock.bean;

public class A {

    private String threadName = "";

    public A() {
        threadName = Thread.currentThread().getName();
    }

    public synchronized void method(B b) {
        System.out.println(threadName + "-->A method start!");
        try {
            Thread.sleep(2000);
            System.out.println(threadName+"-->A method stop sleep!");
        } catch (InterruptedException e) {
            System.out.println(threadName + "-->A method sleep error!");
            e.printStackTrace();
        }

        System.out.println(threadName + "-->A method want for B lose!");
        b.lose();
        System.out.println(threadName + "-->A method end!");
    }


    public synchronized void lose() {
        System.out.println(threadName + "-->A lose!");
    }
}
