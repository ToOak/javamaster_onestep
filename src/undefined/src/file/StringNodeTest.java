package undefined.src.file;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * Created by xushuailong on 2017/3/30.
 */
public class StringNodeTest {
    public static void main(String[] args){
        String str = "从明天起，做一个幸福的人\n" +
                "喂马，劈柴，周游世界\n" +
                "从明天起，关心粮食和蔬菜\n" +
                "我有一所房子，面朝大海，春暖花开\n" +
                "从明天起，和每一个亲人通信\n" +
                "告诉他们我的幸福\n";
        char[] buffer = new char[32];
        int hasRead;
        try (StringReader sr = new StringReader(str)){
            while ((hasRead = sr.read(buffer)) > 0){
                System.out.print(new String(buffer,0,hasRead));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (StringWriter sw = new StringWriter()){
            sw.write("有一个美丽的新世界，\n");
            sw.write("她在远方等我，\n");
            sw.write("那里有天真的孩子，\n");
            sw.write("还有姑娘的酒窝。\n");
            System.out.println("************************");
            System.out.println(sw);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
