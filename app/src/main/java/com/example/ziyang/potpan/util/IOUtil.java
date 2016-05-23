package com.example.ziyang.potpan.util;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class IOUtil {

    public static String readstr(DataInputStream din) throws IOException {
        String str = null;
        byte[] data = null;
        ByteArrayOutputStream out = new ByteArrayOutputStream(1024);
        int len = 0, temRev = 0, size;
        len = din.readInt();
        byte[] buf = new byte[len - temRev];
        while ((size = din.read(buf)) != -1) {
            temRev += size;
            out.write(buf, 0, size);
            if (temRev >= len) {
                break;
            }
            buf = new byte[len - temRev];
        }
        data = out.toByteArray();
        str = new String(data, 0, len, "utf-8");
        str = MyConverter.unescape(str);
        return str;
    }

    public static byte[] readBytes(DataInputStream din) throws IOException {
        byte[] data = null;
        ByteArrayOutputStream out = new ByteArrayOutputStream(1024);
        int len = 0, temRev = 0, size;
        len = din.readInt();
        byte[] buf = new byte[len - temRev];
        while ((size = din.read(buf)) != -1) {
            temRev += size;
            out.write(buf, 0, size);
            if (temRev >= len) {
                break;
            }
            buf = new byte[len - temRev];
        }
        data = out.toByteArray();
        return data;
    }
}
