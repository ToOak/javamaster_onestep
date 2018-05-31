package undefined.src.file;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by xushuailong on 2017/3/30.
 */
public class WriteToProcess {
    public static void main(String[] args) throws IOException {
        Process p = Runtime.getRuntime().exec("java ReadStandard");
        try (PrintStream ps = new PrintStream(p.getOutputStream())){
            ps.println("��ͨ�ַ���");
            ps.println(new WriteToProcess());
        }
    }
}

class ReadStandard {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in);
             PrintStream ps = new PrintStream(new FileOutputStream("ReadStandard_out.txt"))) {
            sc.useDelimiter("\n");
            while (sc.hasNext()){
                ps.println("��������������ǣ�" + sc.next());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
