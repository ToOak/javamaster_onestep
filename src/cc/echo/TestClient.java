package cc.echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TestClient {
    public static void main(String[] args){
        Socket socket = null;
        PrintWriter out = null;
        BufferedReader in = null;
        BufferedReader userIn = null;
        try {
            socket = new Socket("localhost",6666);
            out = new PrintWriter(socket.getOutputStream(),true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            userIn = new BufferedReader(new InputStreamReader(System.in));
            System.out.println(in.readLine());
            System.out.println(in.readLine());
            String userStr = "";
            do {
                userStr = userIn.readLine();
                out.println(userStr);
                out.flush();
                System.out.println(in.readLine());
            }while (!userStr.equalsIgnoreCase("BYE"));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("socket accept end!");
            System.exit(3);
        }finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (out != null) {
                out.close();
            }
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                userIn.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
