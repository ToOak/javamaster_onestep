package undefined.src.extendsTest;

/**
 * Created by xushuailong on 2017/3/16.
 */
public class Stub extends Parent {
    public String a = "stub";

    public Stub() {
    }

    public void test() {
        System.out.println("stub test");
    }

    public void stub() {
        System.out.println("stub");
    }

    private void studPrivate() {
        System.out.println("stub private");
    }

    int age = 3;

    public void test1(String a) {
//        String a = "a";
        for (int i = 0; i < 10; i++) {
            int age = 4;
            int j = this.age;
            int k = age;
        }
        class TestInner {
            private String b = a;

            public void test() {
                System.out.println(Stub.this.a);
            }
        }
    }
}
