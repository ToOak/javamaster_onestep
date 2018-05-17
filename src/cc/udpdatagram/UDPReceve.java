package cc.udpdatagram;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPReceve {
    public static void main(String[] args) {
        DatagramSocket ds = null;
        DatagramPacket dp = null;
        byte[] buf = new byte[1024];
        try {
            ds = new DatagramSocket(9999);
        } catch (SocketException e) {
            e.printStackTrace();
        }
        dp = new DatagramPacket(buf, 1024);
        try {
            ds.receive(dp);
            String str1 = new String(dp.getData()).trim() + " from: "
                    + dp.getAddress().getHostAddress() + ": "
                    + dp.getPort();
            System.out.println(str1);

            ds.receive(dp);
            String str2 = new String(dp.getData()).trim() + " from: "
                    + dp.getAddress().getHostAddress() + ": "
                    + dp.getPort();
            System.out.println(str2);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ds.close();
    }
}
