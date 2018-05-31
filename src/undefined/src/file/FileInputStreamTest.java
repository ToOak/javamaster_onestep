package undefined.src.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by xushuailong on 2017/3/29.
 */
public class FileInputStreamTest {
    public static void main(String[] args) {

        try (FileInputStream fin = new FileInputStream("src/file/FileInputStreamTest.java");
             FileOutputStream fout = new FileOutputStream("newFile.txt")){
            // �ļ�������
            byte[] bytes = new byte[1024];
            int hasRead;
            while ((hasRead = fin.read(bytes)) > 0) {
                System.out.println(new String(bytes, 0, hasRead));
                fout.write(bytes,0, hasRead);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
