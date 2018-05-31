package undefined.src.file;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by xushuailong on 2017/3/30.
 */
public class KeyInTest {
    public static void main(String[] args){
        try (InputStreamReader inRead = new InputStreamReader(System.in);
             BufferedReader bf = new BufferedReader(inRead)){
            String buffer = null;
            while ((buffer = bf.readLine()) != null){
                if (buffer.equals("exit")){
                    System.exit(1);
                }
                System.out.println("输入内容为：" + buffer);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
