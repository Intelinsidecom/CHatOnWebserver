package com.facebook.p033c;

import android.hardware.motion.MotionRecognitionManager;
import com.facebook.p032b.C0476s;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

/* compiled from: ImageResponseCache.java */
/* renamed from: com.facebook.c.m */
/* loaded from: classes.dex */
class C0516m extends BufferedInputStream {

    /* renamed from: a */
    HttpURLConnection f1300a;

    C0516m(InputStream inputStream, HttpURLConnection httpURLConnection) {
        super(inputStream, MotionRecognitionManager.EVENT_FLAT);
        this.f1300a = httpURLConnection;
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        super.close();
        C0476s.m1716a(this.f1300a);
    }
}
