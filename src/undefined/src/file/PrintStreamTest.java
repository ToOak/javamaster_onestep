package undefined.src.file;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by xushuailong on 2017/3/30.
 */
public class PrintStreamTest {
    public static void main(String[] args){
        try (FileOutputStream fout = new FileOutputStream("test.txt");
             PrintStream ps = new PrintStream(fout)){
            ps.println("普通字符串");
            ps.println(new PrintStreamTest());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
