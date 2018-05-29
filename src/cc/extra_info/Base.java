package cc.extra_info;

import static java.lang.System.out;

public class Base {
    public static void main(String[] args) {
        {
            // 匿名内部类
            new Object() {
                void test() {
                    out.println("lalalal");
                }
            }.test();

            Object test = new Object() {
                void test() {
                    out.println("hahahah");
                }
            };
//        test.test();
        }
        synchronized (Base.class) {
            //匿名 重写了 Thread 的 run() 方法
            new Thread(() -> System.out.println("runnable run")) {
                public void run() {
                    System.out.println("subthread run");
                }
            }.start();

        }
        {
            // 异常的捕获
            // 这种情况，如果出现异常，并不处理，但是资源一定关闭，
            // 所以try  finally集合只为关闭资源
            int zero = 0;
            try {
                int a = 5 / zero;
                if (zero != 0) {
                    throw new RuntimeException("the zero is not equals 0!");
                }
            } finally {
                out.println("the finally run!");
            }
            out.println("the base end!");
        }
    }
}
