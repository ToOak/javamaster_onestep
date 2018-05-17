package cc.udpdatagram;

import java.io.IOException;
import java.net.*;

public class UDPSend {
    public static void main(String[] args){
        DatagramPacket dp1 = null;
        DatagramPacket dp2 = null;
        DatagramSocket ds = null;
        try {
            ds = new DatagramSocket(8888);
        } catch (SocketException e) {
            e.printStackTrace();
        }
        String str = "Hello UDP Datagram!";
        try {
            dp1 = new DatagramPacket((str + "dp1").getBytes(),(str + "dp1").length(),
                    InetAddress.getLocalHost(),9999);
            dp2 = new DatagramPacket((str + "dp2").getBytes(),(str + "dp2").length(),
                    InetAddress.getByName("localhost"),9999);
//                    InetAddress.getByName("localhost"),9999);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        try {
            ds.send(dp1);
            ds.send(dp2);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ds.close();
    }
}
