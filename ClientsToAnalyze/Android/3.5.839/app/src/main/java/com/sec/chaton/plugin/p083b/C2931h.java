package com.sec.chaton.plugin.p083b;

import android.hardware.motion.MotionRecognitionManager;
import com.sec.chaton.plugin.p087f.C2946a;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;

/* compiled from: StringWriter.java */
/* renamed from: com.sec.chaton.plugin.b.h */
/* loaded from: classes.dex */
public class C2931h extends AbstractC2932i {

    /* renamed from: a */
    private static final String f10813a = C2931h.class.getSimpleName();

    /* renamed from: b */
    private BufferedInputStream f10814b = null;

    /* renamed from: c */
    private DataOutputStream f10815c = null;

    /* renamed from: d */
    private OutputStream f10816d = null;

    /* renamed from: e */
    private byte[] f10817e;

    /* renamed from: f */
    private final String f10818f;

    public C2931h(String str) {
        this.f10818f = str;
        int length = this.f10818f.length();
        C2946a.m12189b(this.f10818f.substring(0, length >= 300 ? 300 : length), f10813a);
    }

    @Override // com.sec.chaton.plugin.p083b.AbstractC2932i
    /* renamed from: a */
    public long mo12163a(HttpURLConnection httpURLConnection) throws IOException {
        this.f10817e = this.f10818f.getBytes("utf-8");
        this.f10814b = new BufferedInputStream(new ByteArrayInputStream(this.f10817e));
        httpURLConnection.setDoOutput(true);
        this.f10816d = httpURLConnection.getOutputStream();
        this.f10815c = new DataOutputStream(this.f10816d);
        byte[] bArr = new byte[MotionRecognitionManager.EVENT_TILT_TO_UNLOCK];
        int i = 0;
        while (true) {
            int i2 = this.f10814b.read(bArr);
            if (i2 > 0) {
                this.f10815c.write(bArr, 0, i2);
                this.f10815c.flush();
                i += i2;
            } else {
                C2946a.m12189b("Total write [" + i + "] bytes", f10813a);
                return i;
            }
        }
    }

    @Override // com.sec.chaton.plugin.p083b.AbstractC2932i
    /* renamed from: a */
    public void mo12164a() throws IOException {
        try {
            if (this.f10814b != null) {
                this.f10814b.close();
            }
            if (this.f10815c != null) {
                this.f10815c.close();
            }
            if (this.f10816d != null) {
                this.f10816d.close();
            }
        } catch (IOException e) {
            C2946a.m12187a(e, f10813a);
        }
    }
}
