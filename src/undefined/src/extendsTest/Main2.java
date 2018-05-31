package undefined.src.extendsTest;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

/**
 * Created by xushuailong on 2017/3/16.
 */
public class Main2 implements InterA, InterB {
    {
//        c = 7;
    }

    final int c;

    static {
        a = 6;
    }

    static int a = 9;

    {
        b = 4;
    }

    int b = 8;

    public Main2(int c){
        this.c = c;
    }
//    public Main2(){}
    public static void main(String[] args) {
        System.out.println(Main2.a);
        System.out.println(new Main2(1).b);
        class Test{
        Test t = new Test();

        }
        System.gc();
        Runtime.getRuntime().gc();
        System.runFinalization();
        Runtime.getRuntime().runFinalization();

        Map<String,String> env = System.getenv();
        for (String key : env.keySet()){
            System.out.println(key + "-->" + env.get(key));
        }
        System.out.println(System.getenv("JAVA_HOME"));
        Properties properties = System.getProperties();
        for (Object key : properties.keySet()){
            System.out.println(key + "==》" + properties.get(key));
        }
        try {
            properties.store(new FileOutputStream("props.txt"),"System Properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(properties.getProperty("os.name"));

        String str1 = new String("abcdefg");
        String str2 = new String("abcdefg");
        System.out.println("hashCode: " + (str1.hashCode() == str2.hashCode()));
        System.out.println("identityHashCode: " + (System.identityHashCode(str1) == System.identityHashCode(str2)));

        Runtime rt = Runtime.getRuntime();
        System.out.println("处理器数量： " + rt.availableProcessors());
        System.out.println("空闲内存： " + rt.freeMemory());
        System.out.println("总内存： " + rt.totalMemory());
        System.out.println("可用最大内存数量： " + rt.maxMemory());
        try {
            rt.exec("notepad.exe");
        } catch (IOException e) {
            e.printStackTrace();
        }

        Stub stub = null;
        System.out.println("stub hashCode: " + Objects.hashCode(stub));
        System.out.println("stub toString: " + Objects.toString(stub));
        Objects.requireNonNull(stub,"stub is null");
    }
    class Test{
//        static int a = 0;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("系统垃圾回收： 对象状态（可达-->可恢复-->不可达）...");
    }
}
