package undefined.src.socket.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * Created by xushuailong on 2017/4/7.
 */
public class MyClient {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("127.0.0.1",40000);
        new Thread(new ClientThread(s)).start();
        PrintStream ps = new PrintStream(s.getOutputStream());
        String line = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while ((line = br.readLine()) != null){
            ps.println(line);
        }
    }
}
