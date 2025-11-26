package com.samsung.samm.lib.p003a;

import android.util.Log;
import java.io.IOException;
import java.io.RandomAccessFile;

/* renamed from: com.samsung.samm.lib.a.g */
/* loaded from: classes.dex */
public class C0893g {

    /* renamed from: a */
    private static final byte[] f559a = new byte[12];

    /* renamed from: b */
    private int f560b = 0;

    public C0893g() {
        System.arraycopy("AMS".getBytes(), 0, f559a, 0, "AMS".length());
        f559a["AMS".length()] = -1;
        f559a["AMS".length() + 1] = -1;
        System.arraycopy("Samsung".getBytes(), 0, f559a, "AMS".length() + 2, "Samsung".length());
    }

    /* renamed from: a */
    public int m438a() {
        return this.f560b;
    }

    /* renamed from: a */
    public void m439a(int i) {
        this.f560b = i;
    }

    /* renamed from: a */
    public boolean m440a(RandomAccessFile randomAccessFile) throws IOException {
        try {
            this.f560b = C0903q.m591b(randomAccessFile);
            byte[] bArr = new byte[12];
            randomAccessFile.read(bArr);
            if (!new String(f559a).equals(new String(bArr))) {
                Log.w("SAMMLibraryCore", "Not AMS File(Invalid AMS End Marker)");
                return false;
            }
            return true;
        } catch (IOException e) {
            Log.e("SAMMLibraryCore", "Read AMS Tag Error : IOException");
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: b */
    public boolean m441b(RandomAccessFile randomAccessFile) throws IOException {
        try {
            C0903q.m586a(randomAccessFile, this.f560b);
            randomAccessFile.write(f559a);
            return true;
        } catch (IOException e) {
            Log.e("SAMMLibraryCore", "Write AMS Tag Error : IOException");
            e.printStackTrace();
            return false;
        }
    }
}
