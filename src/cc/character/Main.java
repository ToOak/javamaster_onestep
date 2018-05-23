package cc.character;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Collection;

/**
 * 关于字节、字符、字符串的疑问
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Employee e1 = new Employee("zhangsan", 23);
        Employee e2 = new Employee("ohmyladagaga", 21);
        Employee e3 = new Employee("lisi", 18);
        RandomAccessFile ra = new RandomAccessFile("d:\\2.txt", "rw");
        ra.write(e1.name.getBytes());
        ra.writeInt(e1.age);
        ra.write(e2.name.getBytes());
        ra.writeInt(e2.age);
        ra.write(e3.name.getBytes());
        ra.writeInt(e3.age);
        ra.close();

        RandomAccessFile raf = new RandomAccessFile("d:\\2.txt", "r");
        int len = 8;
        raf.skipBytes(12);
        System.out.println("第二个员工的信息：");
        String str = "";
        for (int i = 0; i < len; i++) {
            str += (char) raf.readByte();
        }
        System.out.println("name: " + str);
        System.out.println("age: " + raf.readInt());

        raf.seek(0);
        System.out.println("第一个员工的信息：");
        str = "";
        for (int i = 0; i < len; i++) {
            str += (char) raf.readByte();
        }
        System.out.println("name: " + str);
        System.out.println("age: " + raf.readInt());

        raf.skipBytes(12);
        System.out.println("第三个员工的信息：");
        str = "";
        for (int i = 0; i < len; i++) {
            str += (char) raf.readByte();
        }
        System.out.println("name: " + str);
        System.out.println("age: " + raf.readInt());

        raf.close();


        {
            System.out.println("abcdefg".length());
            System.out.println("abcdefg".getBytes().length);
            System.out.println("1234567".length());
            System.out.println("1234567".getBytes().length);
            System.out.println("一二三四五六七".length());
            System.out.println("一二三四五六七".getBytes("utf-8").length);
            int i = 0;
            for (; i < 7; i++) {
                byte letter = "abcdefg".getBytes()[i];
                byte numer = "1234567".getBytes()[i];
                byte character = "一二三四五六七".getBytes()[i];

                System.out.print(letter + "--> " + (char) letter + "\t");
                System.out.print(numer + "--> " + (char) numer + "\t");
                System.out.println(character + "--> " + (char) character);

            }
        }
        {
            char c = '中';
            char c1 = '国';
            System.out.println(("\u0000" + c + c1).length());
            // gbk utf-8 utf-16 iso-8859-1 us-ascii gb2312 gb18030
            System.out.println(("\u0000" + c + c1).getBytes("gbk").length);
            System.out.println(Arrays.deepToString(charToBytes(c)));
        }

        System.getProperties().list(System.out);

        {
            for (int i = 0; i < 127; i++) {
                if (i % 10 == 0) {
                    System.out.println();
                }
                System.out.print("\t" + i + ": " + (char) i + "\t");

            }
            System.out.println();

        }

        {
            // 补码
            int i = -2;
            long l = i;
            System.out.println(i + ":" + Integer.toBinaryString(i));
            System.out.println(l + ":" + Long.toBinaryString(l));
            float f = l;
        }

        {
            byte b = 5;
            // 强转类型转换
            b = (byte) (b + 10);
            // 无需类型转换
            b += 10;
            b = 5 + 10;

            // 类型转换时 需要注意边界数风险问题
            int i = 129;
            b = (byte) i;
            System.out.println(i + ": " + b + ": " + (char) b);
        }

        {
            // 两个变量之间的交换
            // 方法一：
            {
                int a = 3, b = 5;
                int temp = a;
                a = b;
                b = temp;
                System.out.println("方法一： a = " + a + "  b = " + b);
            }

            // 方法二：
            {
                int a = 3, b = 5;
                a = a + b;
                b = a - b;
                a = a - b;
                System.out.println("方法二： a = " + a + "  b = " + b);
            }
        }
        {
            double d = 2.6;
            double e = d - 2;
            System.out.println("2.6 - 2 = " + e);
        }

        {
            // 递归
            System.out.println("递归： " + addNum(100));
        }

    }

    private static int addNum(int num){
        if (num == 1){
            return 1;
        }else {
            return num + addNum(num - 1);
        }
    }

    private static Byte[] charToBytes(char c) {
        Byte[] bytes = new Byte[2];
        bytes[0] = (byte) ((c & 0xff00) >> 8);
        bytes[1] = (byte) (c & 0xff);
        return bytes;
    }

//    高效的算出 2*8 = 2<<3;
}
