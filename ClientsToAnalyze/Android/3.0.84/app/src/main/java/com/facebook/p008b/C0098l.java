package com.facebook.p008b;

import android.support.v4.view.MotionEventCompat;
import com.facebook.EnumC0070ak;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* compiled from: FileLruCache.java */
/* renamed from: com.facebook.b.l */
/* loaded from: classes.dex */
final class C0098l {
    /* renamed from: a */
    static void m242a(OutputStream outputStream, JSONObject jSONObject) throws IOException {
        byte[] bytes = jSONObject.toString().getBytes();
        outputStream.write(0);
        outputStream.write((bytes.length >> 16) & MotionEventCompat.ACTION_MASK);
        outputStream.write((bytes.length >> 8) & MotionEventCompat.ACTION_MASK);
        outputStream.write((bytes.length >> 0) & MotionEventCompat.ACTION_MASK);
        outputStream.write(bytes);
    }

    /* renamed from: a */
    static JSONObject m241a(InputStream inputStream) throws JSONException, IOException {
        JSONObject jSONObject;
        int i = 0;
        if (inputStream.read() != 0) {
            return null;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < 3; i3++) {
            int i4 = inputStream.read();
            if (i4 == -1) {
                C0099m.m244a(EnumC0070ak.CACHE, C0087a.f160a, "readHeader: stream.read returned -1 while reading header size");
                return null;
            }
            i2 = (i2 << 8) + (i4 & MotionEventCompat.ACTION_MASK);
        }
        byte[] bArr = new byte[i2];
        while (i < bArr.length) {
            int i5 = inputStream.read(bArr, i, bArr.length - i);
            if (i5 < 1) {
                C0099m.m244a(EnumC0070ak.CACHE, C0087a.f160a, "readHeader: stream.read stopped at " + Integer.valueOf(i) + " when expected " + bArr.length);
                return null;
            }
            i += i5;
        }
        try {
            Object objNextValue = new JSONTokener(new String(bArr)).nextValue();
            if (!(objNextValue instanceof JSONObject)) {
                C0099m.m244a(EnumC0070ak.CACHE, C0087a.f160a, "readHeader: expected JSONObject, got " + objNextValue.getClass().getCanonicalName());
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
