package undefined.src; /**
 * Created by xushuailong on 2017/3/13.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.out;

public class Main1 {
    public static void main(String[] args){
        StringBuilder[] strBus = new StringBuilder[]{new StringBuilder("a"),new StringBuilder("b"),new StringBuilder("c")};
        for (StringBuilder s : strBus){
            s.append("1");
        }
        out.println(strBus[0].toString() + strBus[1].toString() + strBus[2].toString());
        String[] strs = {"a","b","c"};
        for (String s : strs){
            s += "1";
        }
        out.println(strs[0] + strs[1] + strs[2]);


        Scanner sc = new Scanner(System.in);
        String str = "";
        while(!str.equals("bye")) {
            str = sc.nextLine();

            while (str.contains("$")) {
                if (!str.startsWith("$")){
                    str = str.replace(str.substring(str.indexOf("$") - 1, str.indexOf("$") + 1), "");
                }else {
                    str = str.substring(1);
                }
            }
            while (str.contains("%")) {
                str = str.replace(str.substring(0, str.indexOf("%") + 1), "");
            }
            System.out.println(str);
        }


        Scanner cin = new Scanner(System.in);
        int a, b;
//        while (cin.hasNext()){
        while (cin.hasNextInt()){
            a = cin.nextInt(); b = cin.nextInt();
            System.out.println(a + b);
        }
        System.out.println("Good Bye!");

        @SuppressWarnings(value = "unchecked")
//        @SuppressWarnings("unchecked")
        List<String> l = new ArrayList();
        System.out.println("OEh6UnFXWWhkNTRMYzFGeG1vc21WKzFBdkQrMEpLRjZCbk8wMjFlU3ZZdUZlanV4QmRGWXJweEQw%0AUTRPcTJCMkd6MVY3UmRrenhvcQp6aXZVdVgwT08wVHJ3OUF6WjVzVmN2Nm5iVkZkVmY0a09JbFVT%0AbWhWS1JzYW01NG5ZMDZ0TnFCS3lmQURSNFA2MFZCRjQzL0FrSDlYClcyQ0ZPYWF3aFVtMGVkODVo%0AV1prbjVGQUhralFLQUQzYmZ2c0JxM0E%2FYXBwSWQ9MTAyMiZrZXlJZD0xMDIy".length());

    }
}
