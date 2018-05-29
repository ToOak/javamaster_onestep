package cc;

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

