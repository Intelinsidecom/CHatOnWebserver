package android.support.v4.util;

import android.util.Log;
import java.io.Writer;

/* loaded from: classes.dex */
public class LogWriter extends Writer {

    /* renamed from: a */
    private final String f136a;

    /* renamed from: b */
    private StringBuilder f137b = new StringBuilder(128);

    public LogWriter(String str) {
        this.f136a = str;
    }

    /* renamed from: a */
    private void m171a() {
        if (this.f137b.length() > 0) {
            Log.d(this.f136a, this.f137b.toString());
            this.f137b.delete(0, this.f137b.length());
        }
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        m171a();
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        m171a();
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            char c = cArr[i + i3];
            if (c == '\n') {
                m171a();
            } else {
                this.f137b.append(c);
            }
        }
    }
}
