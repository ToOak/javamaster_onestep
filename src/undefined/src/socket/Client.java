package undefined.src.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by xushuailong on 2017/4/7.
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("127.0.0.1",30000);
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String lin = br.readLine();
        System.out.println("收到来自服务端的信息： " + lin);
        br.close();
        s.close();
    }
}
