package undefined.src.file;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by xushuailong on 2017/3/30.
 */
public class ReadFromProcess {
    public static void main(String[] args) throws IOException {
        Process p = Runtime.getRuntime().exec("javac");
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(p.getErrorStream()))){
            String buff = "";
            while ((buff = bf.readLine()) != null){
                System.out.println(buff);
            }

        }
    }
}
