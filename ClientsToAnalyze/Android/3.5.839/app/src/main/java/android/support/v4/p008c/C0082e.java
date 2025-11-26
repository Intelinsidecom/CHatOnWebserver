package android.support.v4.p008c;

import android.util.Log;
import java.io.Writer;

/* compiled from: LogWriter.java */
/* renamed from: android.support.v4.c.e */
/* loaded from: classes.dex */
public class C0082e extends Writer {

    /* renamed from: a */
    private final String f244a;

    /* renamed from: b */
    private StringBuilder f245b = new StringBuilder(128);

    public C0082e(String str) {
        this.f244a = str;
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        m263a();
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        m263a();
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            char c2 = cArr[i + i3];
            if (c2 == '\n') {
                m263a();
            } else {
                this.f245b.append(c2);
            }
        }
    }

    /* renamed from: a */
    private void m263a() {
        if (this.f245b.length() > 0) {
            Log.d(this.f244a, this.f245b.toString());
            this.f245b.delete(0, this.f245b.length());
        }
    }
}
