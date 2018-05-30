package cc.extra_info;

import java.io.*;

class ObjectStreamDemo {
    public static void main(String[] args) throws Exception {
        writeObj();
        readObj();
    }

    public static void readObj() throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("obj.txt"));
        Object obj = ois.readObject();//读取一个对象。
        System.out.println(obj.toString());
    }

    public static void writeObj() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("obj.txt"));
        oos.writeObject(new Person("lisi", 25)); //写入一个对象。
        oos.close();
    }
}

class Person implements Serializable {
    private static final long serialVersionUID = 42L;
    //用transient修饰后name将不会进行序列化
    private transient String name;
    public int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return name + "::" + age;
    }
}
