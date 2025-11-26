package com.facebook.p009c;

import com.facebook.p008b.C0105s;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;

/* compiled from: ImageResponseCache.java */
/* renamed from: com.facebook.c.m */
/* loaded from: classes.dex */
class C0145m extends BufferedInputStream {

    /* renamed from: a */
    HttpURLConnection f331a;

    C0145m(InputStream inputStream, HttpURLConnection httpURLConnection) {
        super(inputStream, 8192);
        this.f331a = httpURLConnection;
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        super.close();
        C0105s.m272a(this.f331a);
    }
}
