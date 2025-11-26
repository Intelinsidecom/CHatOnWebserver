package org.p138a.p142b.p143a.p144a;

import com.sec.amsoma.AMSLibs;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/* compiled from: QuotedPrintableInputStream.java */
/* renamed from: org.a.b.a.a.e */
/* loaded from: classes.dex */
public class C5230e extends InputStream {

    /* renamed from: c */
    private static Log f19066c = LogFactory.getLog(C5230e.class);

    /* renamed from: d */
    private InputStream f19069d;

    /* renamed from: a */
    C5228c f19067a = new C5228c();

    /* renamed from: b */
    C5228c f19068b = new C5228c();

    /* renamed from: e */
    private byte f19070e = 0;

    /* renamed from: f */
    private boolean f19071f = false;

    public C5230e(InputStream inputStream) {
        this.f19069d = inputStream;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f19071f = true;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.f19071f) {
            throw new IOException("QuotedPrintableInputStream has been closed");
        }
        m19929b();
        if (this.f19067a.m19919b() == 0) {
            return -1;
        }
        byte bM19917a = this.f19067a.m19917a();
        return bM19917a < 0 ? bM19917a & 255 : bM19917a;
    }

    /* renamed from: a */
    private void m19928a() throws IOException {
        if (this.f19068b.m19919b() != 0) {
            return;
        }
        while (true) {
            int i = this.f19069d.read();
            switch (i) {
                case -1:
                    this.f19068b.m19920c();
                    return;
                case 9:
                case 32:
                    this.f19068b.m19918a((byte) i);
                case 10:
                case 13:
                    this.f19068b.m19920c();
                    this.f19068b.m19918a((byte) i);
                    return;
                default:
                    this.f19068b.m19918a((byte) i);
                    return;
            }
        }
    }

    /* renamed from: b */
    private void m19929b() throws IOException {
        byte b2 = 0;
        while (this.f19067a.m19919b() == 0) {
            if (this.f19068b.m19919b() == 0) {
                m19928a();
                if (this.f19068b.m19919b() == 0) {
                    return;
                }
            }
            byte bM19917a = this.f19068b.m19917a();
            switch (this.f19070e) {
                case 0:
                    if (bM19917a != 61) {
                        this.f19067a.m19918a(bM19917a);
                        break;
                    } else {
                        this.f19070e = (byte) 1;
                        break;
                    }
                case 1:
                    if (bM19917a == 13) {
                        this.f19070e = (byte) 2;
                        break;
                    } else if ((bM19917a >= 48 && bM19917a <= 57) || ((bM19917a >= 65 && bM19917a <= 70) || (bM19917a >= 97 && bM19917a <= 102))) {
                        this.f19070e = (byte) 3;
                        b2 = bM19917a;
                        break;
                    } else if (bM19917a == 61) {
                        if (f19066c.isWarnEnabled()) {
                            f19066c.warn("Malformed MIME; got ==");
                        }
                        this.f19067a.m19918a((byte) 61);
                        break;
                    } else {
                        if (f19066c.isWarnEnabled()) {
                            f19066c.warn("Malformed MIME; expected \\r or [0-9A-Z], got " + ((int) bM19917a));
                        }
                        this.f19070e = (byte) 0;
                        this.f19067a.m19918a((byte) 61);
                        this.f19067a.m19918a(bM19917a);
                        break;
                    }
                    break;
                case 2:
                    if (bM19917a == 10) {
                        this.f19070e = (byte) 0;
                        break;
                    } else {
                        if (f19066c.isWarnEnabled()) {
                            f19066c.warn("Malformed MIME; expected 10, got " + ((int) bM19917a));
                        }
                        this.f19070e = (byte) 0;
                        this.f19067a.m19918a((byte) 61);
                        this.f19067a.m19918a(AMSLibs.ENUM_VIP_AMS_DIAGRAM_OBJECT_NUM_FULL);
                        this.f19067a.m19918a(bM19917a);
                        break;
                    }
                case 3:
                    if ((bM19917a >= 48 && bM19917a <= 57) || ((bM19917a >= 65 && bM19917a <= 70) || (bM19917a >= 97 && bM19917a <= 102))) {
                        byte bM19927a = m19927a(b2);
                        byte bM19927a2 = m19927a(bM19917a);
                        this.f19070e = (byte) 0;
                        this.f19067a.m19918a((byte) (bM19927a2 | (bM19927a << 4)));
                        break;
                    } else {
                        if (f19066c.isWarnEnabled()) {
                            f19066c.warn("Malformed MIME; expected [0-9A-Z], got " + ((int) bM19917a));
                        }
                        this.f19070e = (byte) 0;
                        this.f19067a.m19918a((byte) 61);
                        this.f19067a.m19918a(b2);
                        this.f19067a.m19918a(bM19917a);
                        break;
                    }
                    break;
                default:
                    f19066c.error("Illegal state: " + ((int) this.f19070e));
                    this.f19070e = (byte) 0;
                    this.f19067a.m19918a(bM19917a);
                    break;
            }
        }
    }

    /* renamed from: a */
    private byte m19927a(byte b2) {
        if (b2 >= 48 && b2 <= 57) {
            return (byte) (b2 - 48);
        }
        if (b2 >= 65 && b2 <= 90) {
            return (byte) ((b2 - 65) + 10);
        }
        if (b2 >= 97 && b2 <= 122) {
            return (byte) ((b2 - 97) + 10);
        }
        throw new IllegalArgumentException(((char) b2) + " is not a hexadecimal digit");
    }
}
