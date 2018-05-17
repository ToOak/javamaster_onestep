package cc.echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TestServer {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;
        try {
            serverSocket = new ServerSocket(6666);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("couldn't create serverSocket on port 6666!");
            System.exit(1);
        }
        Socket socket = null;
        try {
            socket = serverSocket.accept();
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out.println("Hello...");
            out.println("Enter BYE to Exit!");
            String str = "";
            do {
                str = in.readLine();
                out.println("Echo: " + str);
                out.flush();
            } while (!str.equalsIgnoreCase("BYE"));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("end the accept!");
            System.exit(2);
        } finally {
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (out != null) {
                out.close();
            }
        }

    }
}
