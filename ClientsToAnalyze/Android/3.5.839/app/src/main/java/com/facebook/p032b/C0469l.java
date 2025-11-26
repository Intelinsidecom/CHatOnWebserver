package com.facebook.p032b;

import com.facebook.EnumC0441ak;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* compiled from: FileLruCache.java */
/* renamed from: com.facebook.b.l */
/* loaded from: classes.dex */
final class C0469l {
    /* renamed from: a */
    static void m1686a(OutputStream outputStream, JSONObject jSONObject) throws IOException {
        byte[] bytes = jSONObject.toString().getBytes();
        outputStream.write(0);
        outputStream.write((bytes.length >> 16) & 255);
        outputStream.write((bytes.length >> 8) & 255);
        outputStream.write((bytes.length >> 0) & 255);
        outputStream.write(bytes);
    }

    /* renamed from: a */
    static JSONObject m1685a(InputStream inputStream) throws JSONException, IOException {
        JSONObject jSONObject;
        int i = 0;
        if (inputStream.read() != 0) {
            return null;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < 3; i3++) {
            int i4 = inputStream.read();
            if (i4 == -1) {
                C0470m.m1688a(EnumC0441ak.CACHE, C0458a.f1129a, "readHeader: stream.read returned -1 while reading header size");
                return null;
            }
            i2 = (i2 << 8) + (i4 & 255);
        }
        byte[] bArr = new byte[i2];
        while (i < bArr.length) {
            int i5 = inputStream.read(bArr, i, bArr.length - i);
            if (i5 < 1) {
                C0470m.m1688a(EnumC0441ak.CACHE, C0458a.f1129a, "readHeader: stream.read stopped at " + Integer.valueOf(i) + " when expected " + bArr.length);
                return null;
            }
            i += i5;
        }
        try {
            Object objNextValue = new JSONTokener(new String(bArr)).nextValue();
            if (!(objNextValue instanceof JSONObject)) {
                C0470m.m1688a(EnumC0441ak.CACHE, C0458a.f1129a, "readHeader: expected JSONObject, got " + objNextValue.getClass().getCanonicalName());
                jSONObject = null;
            } else {
                jSONObject = (JSONObject) objNextValue;
            }
            return jSONObject;
        } catch (JSONException e) {
            throw new IOException(e.getMessage());
        }
    }
}
