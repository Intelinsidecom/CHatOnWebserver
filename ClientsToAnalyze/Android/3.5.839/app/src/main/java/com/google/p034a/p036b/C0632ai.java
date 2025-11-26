package com.google.p034a.p036b;

import java.io.IOException;
import java.io.Writer;

/* compiled from: Streams.java */
/* renamed from: com.google.a.b.ai */
/* loaded from: classes.dex */
final class C0632ai extends Writer {

    /* renamed from: a */
    private final Appendable f1498a;

    /* renamed from: b */
    private final C0633aj f1499b;

    private C0632ai(Appendable appendable) {
        this.f1499b = new C0633aj();
        this.f1498a = appendable;
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i, int i2) throws IOException {
        this.f1499b.f1500a = cArr;
        this.f1498a.append(this.f1499b, i, i + i2);
    }

    @Override // java.io.Writer
    public void write(int i) throws IOException {
        this.f1498a.append((char) i);
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }
}
