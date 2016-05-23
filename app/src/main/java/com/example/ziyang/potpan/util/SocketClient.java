package com.example.ziyang.potpan.util;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;

import static com.example.ziyang.potpan.Data.zzy_constants.*;

public class SocketClient {
    static Socket s;
    private static DataInputStream din;
    private static DataOutputStream dout;
    public static String readinfo;
    public static byte[] data = null;
    static String getinfo;

    public static void ConnectSevert(String info) {
        try {
            InetAddress serverAddr = InetAddress.getByName(IP);
            s = new Socket(serverAddr, POINT);
        } catch (SocketTimeoutException e) {
            if (!s.isConnected()) {
                readinfo = SOCKET_ERROR;
            }
            return;
        } catch (IOException e) {
            if (!s.isConnected()) {
                readinfo = SOCKET_ERROR;
            }
            return;
        }
        try {
            din = new DataInputStream(s.getInputStream());
            dout = new DataOutputStream(s.getOutputStream());
            info = MyConverter.escape(info);
            dout.writeInt(info.length());
            dout.write(info.getBytes());
            getinfo = din.readUTF();
            if (getinfo.equals("STR")) {
                readinfo = IOUtil.readstr(din);
            } else if (getinfo.equals("BYTE")) {
                data = IOUtil.readBytes(din);
            }
        } catch (Exception e) {
            if (!s.isClosed() && s.isConnected()) {
                readinfo = SOCKET_IOERROR;
                System.out.println("Over Time...");
            }
            return;
        } finally {
            try {
                dout.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                din.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                s.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

