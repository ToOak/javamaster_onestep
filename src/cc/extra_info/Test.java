package cc.extra_info;

import java.io.File;
import java.io.IOException;

import static java.lang.System.out;

class Test {
    public static void main(String[] args) {
        String s1 = "java";
        String s2 = "hello";
        method_1(s1, s2);
        out.println(s1 + "...." + s2); //java....hello

        StringBuilder s11 = new StringBuilder("java");
        StringBuilder s22 = new StringBuilder("hello");
        method_2(s11, s22);
        out.println(s11 + "-----" + s22); //javahello-----hello


        {
            /**
             * 在装箱时，如果数值在byte范围之内，那么数值相同，不会产生新的对象，
             * 也就是说多个数值相同的引用指向的是同一个对象。
             */
            {
                Integer i = 127;
                Integer j = 127;
                out.println("127: " + (i == j));
            }

            {
                Integer i = 128;
                Integer j = 128;
                out.println("128: " + (i == j));
            }
        }
        {
            Runtime r = Runtime.getRuntime();
            Process p = null;    //运行指定的程序
            try {
                p = r.exec("notepad.exe .\\src\\cc\\extra_info" + File.separator + "Test.java");
                Thread.sleep(3000);
            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
            }
            p.destroy();  //杀掉进程

        }
        {
            // Original
            out.print("\nori:");
            out.print("\t" + 1.3);
            out.print("\t" + -1.3);
            out.print("\t" + 1.6);
            out.print("\t" + -1.6);
            out.print("\t" + 1.5);
            out.print("\t" + -1.5);

            out.println();

            out.print("\nceil:");
            out.print("\t" + (int) Math.ceil(1.3));
            out.print("\t" + (int) Math.ceil(-1.3));
            out.print("\t" + (int) Math.ceil(1.6));
            out.print("\t" + (int) Math.ceil(-1.6));
            out.print("\t" + (int) Math.ceil(1.5));
            out.print("\t" + (int) Math.ceil(-1.5));

            out.print("\nfloor:");
            out.print("\t" + (int) Math.floor(1.3));
            out.print("\t" + (int) Math.floor(-1.3));
            out.print("\t" + (int) Math.floor(1.6));
            out.print("\t" + (int) Math.floor(-1.6));
            out.print("\t" + (int) Math.floor(1.5));
            out.print("\t" + (int) Math.floor(-1.5));

            // 返回值: 与 x 最接近的整数。
            // 说明：  对于 0.5，该方法将进行上舍入。
            // 例如：  3.5 将舍入为 4，而 - 3.5 将舍入为 - 3。
            out.print("\nround:");
            out.print("\t" + Math.round(1.3));
            out.print("\t" + Math.round(-1.3));
            out.print("\t" + Math.round(1.6));
            out.print("\t" + Math.round(-1.6));
            out.print("\t" + Math.round(1.5));
            out.print("\t" + Math.round(-1.5));

        }

    }

    public static void method_1(String s1, String s2) {
        s1.replace('a', 'k');
        s1 = s2;
    }

    public static void method_2(StringBuilder s1, StringBuilder s2) {
        s1.append(s2);
        s1 = s2;
    }
}

