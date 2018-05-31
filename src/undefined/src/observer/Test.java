package undefined.src.observer;

/**
 * Created by xushuailong on 2016/12/15.
 */
public class Test {
    public static void main(String[] args) {
        Column column = new Column();

        Corder yuan = new Corder("yuan");
        Corder nong = new Corder("nong");
        Corder shi = new Corder("shi");
        Corder corder = new Corder("corder");

        column.addObserver(yuan);
        column.addObserver(nong);
        column.addObserver(shi);
        column.addObserver(corder);

        column.postNewPublication("新一期的栏目发布啦！！");
        {
            new Object() {
                void test() {
                    System.out.println("lalalal");
                }
            }.test();

            Object test = new Object() {
                void test() {
                    System.out.println("hahahah");
                }
            };
//        test.test();
        }

    }

    class MyException extends Exception{

    }
}
