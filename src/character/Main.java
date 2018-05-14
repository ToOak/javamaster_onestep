package character;

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

        char c = '中';
        char c1 = '国';
        System.out.println(("\u0000" + c + c1).length());
        // gbk utf-8 utf-16 iso-8859-1 us-ascii gb2312 gb18030
        System.out.println(("\u0000" + c + c1).getBytes("gbk").length);
        System.out.println(Arrays.deepToString(charToBytes(c)));

        System.getProperties().list(System.out);
    }

    private static Byte[] charToBytes(char c) {
        Byte[] bytes = new Byte[2];
        bytes[0] = (byte) ((c & 0xff00) >> 8);
        bytes[1] = (byte) (c & 0xff);
        return bytes;
    }
}
