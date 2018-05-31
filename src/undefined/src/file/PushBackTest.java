package undefined.src.file;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PushbackReader;

/**
 * Created by xushuailong on 2017/3/30.
 */
public class PushBackTest {
    public static void main(String[] args) {
        // ָ���ƻػ���������Ϊ64
        try (PushbackReader pr = new PushbackReader(new FileReader("src/file/PushBackTest.java"), 64)) {
            char[] buf = new char[32];
            // ������һ�ζ�ȡ�ַ�������
            String lastContent = "";
            int hasRead = 0;
            while ((hasRead = pr.read(buf)) > 0) {
                String content = new String(buf, 0, hasRead);
                int targetIndex = 0;
                // ���ϴ�ȡ���ַ����ͱ��ζ�ȡ���ַ���ƴ������
                // �鿴�Ƿ����Ŀ���ַ���
                if ((targetIndex = (lastContent + content).indexOf("new PushBackTest")) > 0) {
                    // ���������ݺ��ϴ�����һ���ƻػ�����
                    pr.unread((lastContent + content).toCharArray());
                    // ָ����ȡǰ��len���ַ�
                    int len = targetIndex > 32 ? 32 : targetIndex;
                    // �ٴζ�ȡָ�����ȵ����ݣ�����Ŀ���ַ���֮ǰ�����ݣ�
                    pr.read(buf, 0, len);
                    System.out.println(len);
                    System.out.println(buf);
                    System.exit(0);
                } else {
                    // ��ӡ�ϴζ�ȡ������
                    System.out.println(lastContent);
                    // �����ζ�ȡ��������Ϊ�ϴζ�ȡ������
                    lastContent = content;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
