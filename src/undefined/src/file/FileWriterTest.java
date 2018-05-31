package undefined.src.file;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by xushuailong on 2017/3/29.
 */
public class FileWriterTest {
    public static void main(String[] args) {
        try (FileWriter fw = new FileWriter("poem.txt")) {
            fw.write("啦啦啦，啦啦啦\r\n");
            fw.write("老子是码代码的小行家。。。");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
