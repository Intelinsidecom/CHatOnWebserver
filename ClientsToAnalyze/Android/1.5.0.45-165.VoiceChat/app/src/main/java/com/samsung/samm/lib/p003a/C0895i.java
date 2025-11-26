package com.samsung.samm.lib.p003a;

import android.util.Log;
import java.io.IOException;
import java.io.RandomAccessFile;

/* renamed from: com.samsung.samm.lib.a.i */
/* loaded from: classes.dex */
public class C0895i {

    /* renamed from: a */
    private static final byte[] f602a = new byte[4];

    public C0895i() {
        System.arraycopy("AMS".getBytes(), 0, f602a, 0, "AMS".length());
        f602a["AMS".length()] = -18;
    }

    /* renamed from: a */
    public boolean m506a(RandomAccessFile randomAccessFile) throws IOException {
        try {
            byte[] bArr = new byte[4];
            randomAccessFile.read(bArr);
            if (!new String(f602a).equals(new String(bArr))) {
                for (int i = 0; i < 4; i++) {
                    Log.e("SAMMLibraryCore", "Invalid AMS Start Marker[" + i + "]" + ((int) bArr[i]));
                }
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
    public boolean m507b(RandomAccessFile randomAccessFile) throws IOException {
        try {
            randomAccessFile.write(f602a);
            return true;
        } catch (IOException e) {
            Log.e("SAMMLibraryCore", "Write AMS Tag Error : IOException");
            e.printStackTrace();
            return false;
        }
    }
}
