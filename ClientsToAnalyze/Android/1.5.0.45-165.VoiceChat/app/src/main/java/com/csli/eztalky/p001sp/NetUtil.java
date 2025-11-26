package com.csli.eztalky.p001sp;

import java.io.InputStream;
import java.util.UUID;

/* loaded from: classes.dex */
public class NetUtil {
    private int transactionCount = 0;
    private Object transactionKey = new Object();
    private String uuid = UUID.randomUUID().toString().replace("-", "");

    private int generateTransactionCount() {
        synchronized (this.transactionKey) {
            this.transactionCount++;
            if (this.transactionCount > 9999) {
                this.transactionCount = 0;
            }
        }
        return this.transactionCount;
    }

    public String generateTransactionId() {
        return String.valueOf(this.uuid) + String.format("%04d", Integer.valueOf(generateTransactionCount()));
    }

    public static String getEncodingResString(InputStream in, int len, String encoding) throws Exception {
        byte[] buf = new byte[len];
        int sum = 0;
        do {
            int value = in.read(buf, sum, len - sum);
            if (value == -1) {
                throw new RuntimeException("Invalid Packet!");
            }
            sum += value;
        } while (sum < len);
        return new String(buf, 0, len, encoding);
    }

    public static String getResString(InputStream in, int len) throws Exception {
        byte[] buf = new byte[len];
        int sum = 0;
        do {
            int value = in.read(buf, sum, len - sum);
            if (value == -1) {
                throw new RuntimeException("Invalid Packet!");
            }
            sum += value;
        } while (sum < len);
        return new String(buf, 0, len);
    }

    public static String replaceJapan(String original) {
        return original.replace('.', (char) 12290).replace(',', (char) 12289);
    }
}
