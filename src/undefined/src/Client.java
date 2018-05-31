package undefined.src;

/**
 * Created by xushuailong on 2016/12/15.
 */
public class Client {
    public static void main(String[] args){
//        AbstractHandler handler1 = new Handler1();
//        AbstractHandler handler2 = new Handler2();
//        AbstractHandler handler3 = new Handler3();
//        handler1.nextHandler = handler2;
//        handler2.nextHandler = handler3;
//        AbstractReqest reqest1 = new Request1("Request1");
//        AbstractReqest reqest2 = new Request2("Request2");
//        AbstractReqest reqest3 = new Request3("Request3");
//
//        handler1.handleRequest(reqest1);
//        handler1.handleRequest(reqest2);
//        handler1.handleRequest(reqest3);

        int i = 1, j = 2;
//        System.out.println(i+(++j));  // 4
        System.out.println(i+(j++));   //  3
//        System.out.println(i+j++);       //  3
//        System.out.println(i+++j);     //  3
//        System.out.println((i++)+j);    //  3
//        System.out.println(++i+j);        //4
//        System.out.println((++i)+j);      //4
        System.out.println(i);
        System.out.println(j);
    }
}
