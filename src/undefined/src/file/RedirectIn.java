package undefined.src.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * @describe �ض�������
 * Created by xushuailong on 2017/3/30.
 */
public class RedirectIn {
    public static void main(String[] args){
        try (FileInputStream fin = new FileInputStream("poem.txt")){
            System.setIn(fin);
            Scanner sc = new Scanner(System.in);
            sc.useDelimiter("\n");
            while (sc.hasNext()){
                System.out.println("# " + sc.next());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
