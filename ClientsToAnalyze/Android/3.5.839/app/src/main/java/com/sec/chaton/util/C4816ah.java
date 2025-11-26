package com.sec.chaton.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* compiled from: CheckAMSHeader.java */
/* renamed from: com.sec.chaton.util.ah */
/* loaded from: classes.dex */
public class C4816ah {

    /* renamed from: d */
    private static short[] f17583d = {65, 77, 83, 255, 255, 83, 97, 109, 115, 117, 110, 103};

    /* renamed from: e */
    private static String f17584e = "AMS��Samsung";

    /* renamed from: a */
    private RandomAccessFile f17585a = null;

    /* renamed from: b */
    private byte[] f17586b = null;

    /* renamed from: c */
    private long f17587c = 0;

    /* renamed from: a */
    public boolean m18177a(String str) throws IOException {
        try {
            this.f17585a = new RandomAccessFile(str, "r");
            this.f17587c = this.f17585a.length();
            this.f17585a.seek(this.f17587c - 12);
            this.f17586b = new byte[12];
            this.f17585a.read(this.f17586b, 0, 12);
            if (!f17584e.equals(new String(this.f17586b))) {
                for (int i = 0; i < 12; i++) {
                    if (this.f17586b[i] != ((byte) f17583d[i])) {
                        return false;
                    }
                }
                return false;
            }
            return true;
        } catch (FileNotFoundException e) {
            return false;
        } catch (IOException e2) {
            return false;
        } catch (IllegalArgumentException e3) {
            return false;
        } catch (SecurityException e4) {
            return false;
        }
    }
}
