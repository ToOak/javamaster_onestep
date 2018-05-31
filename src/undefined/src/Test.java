package undefined.src;

import sun.misc.BASE64Encoder;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by xushuailong on 2017/2/10.
 */
public class Test {
    public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException {


        int i = 0;
        i = i++;
        System.out.print(i + "\n");
        int a = 10;
        int b = 10;
        method(a, b);
//        method2(a,b);
//        method4(a,b);
        System.out.println("a=" + a);
        System.out.println("b=" + b);
        System.out.println("sssss");

//        a(new int[]{1,1});
//        a(1,1);

//        int c = 10;
//        method3(c);
//        System.out.println((Object)c);

        testPrint();

        byte[] secretBytes = null;
        try {
            secretBytes = MessageDigest.getInstance("md5").digest("a".getBytes());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new RuntimeException("no md5!");
        }
        System.out.println("1: " + secretBytes.toString());
        System.out.println("2: " + new BigInteger(1,secretBytes).toString());
        String md5code = new BigInteger(1,secretBytes).toString(16);
        System.out.println("3: " + md5code);

        String str="0123456789";
        System.out.println(md5sumWithEncoder(str));

    }
    public static String md5sumWithEncoder(String text) throws NoSuchAlgorithmException,
            UnsupportedEncodingException{
        /*确定计算方法*/
        MessageDigest md5=MessageDigest.getInstance("MD5");
        BASE64Encoder base64en = new BASE64Encoder();
        System.out.println("base: " + md5.digest(text.getBytes("utf-8")));
        /*加密后的散列码字符串*/
        String strMd5=base64en.encode(md5.digest(text.getBytes("utf-8")));
        return strMd5;
    }
    private static void testPrint() {
        PrintStream out = System.out;
        try {
            PrintStream ps = new PrintStream("e:/log.txt");
            System.setOut(ps);

            System.out.println(".............");
            int age = 18;
            System.out.println("年龄定义，初始值：" + age + "...");
            String sex = "女";
            System.out.println("性别定义：" + sex + "...");
            System.out.println("初始化定义完毕 ...");
            System.out.print(".............");

            System.setOut(out);
            System.out.println("程序运行完毕！");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void method4(int a, int b) {
        PrintStream p = new PrintStream(System.out) {
            @Override
            public void println(String x) {
                if (x.startsWith("a")) {
                    super.println(x + "0");
                    return;
                } else if (x.startsWith("b")) {
                    super.println("b=200");
                    return;
                }
                super.println(x);
            }
        };
        System.setOut(p);
    }

    private static void method3(int c) {
        Class cache = Integer.class.getDeclaredClasses()[0];
        Field myCache = null;
        try {
            myCache = cache.getDeclaredField("cache");
            myCache.setAccessible(true);

            Integer[] newCache = (Integer[]) myCache.get(cache);
            for (int i = 0; i < newCache.length; i++) {
                if (newCache[i].equals(10)) {
                    System.out.println("i is: " + i);
                    newCache[i] = 666;
                    break;
                }
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


    }

    public static void a(int... a) {
        System.out.println("    public void a(int...a){");
    }

    public static void a(int a, int s) {
        System.out.println("    public void a(int a,int s){");

    }

    private static void method2(int a, int b) {
        System.out.println("a=100");
        System.out.println("b=200");
        System.exit(0);
    }

    private static void method(int a1, int b1) {
        Class cache = Integer.class.getDeclaredClasses()[0];
        Field myCache = null;
        try {
            myCache = cache.getDeclaredField("cache");
            myCache.setAccessible(true);

            Integer[] newCache = (Integer[]) myCache.get(cache);
            newCache[132] = newCache[133];
            for (int i = 0; i < newCache.length; i++) {
                if (newCache[i].equals(10)) {
                    System.out.println("i is :" + i);
                    newCache[i] = 100;
                    break;
                }
            }

        } catch (NoSuchFieldException e) {
            System.out.println("NoSuchFieldException");
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            System.out.println("IllegalAccessException");
            e.printStackTrace();
        }

        int a = 2;
        int s = 10;
        int b = a + a;
        System.out.println(a + "," + (Object) b + "," + s);
        System.out.println(a + "," + b + "," + s);
        System.out.printf("%d + %d = %d\n", a, a, b);
        System.out.printf("ss %d\n", s);

    }
}
