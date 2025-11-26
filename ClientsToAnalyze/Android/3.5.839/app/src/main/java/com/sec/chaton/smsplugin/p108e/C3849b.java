package com.sec.chaton.smsplugin.p108e;

import android.net.Uri;
import com.sec.chaton.smsplugin.p111h.C3890m;
import com.sec.google.android.mobile1.C5112a;
import com.sec.google.android.mobile1.DrmRawContent;
import com.sec.google.android.mobile1.DrmRights;
import com.sec.google.android.mobile1.DrmRightsManager;
import com.sec.google.android.p134a.C5077a;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: DrmWrapper.java */
/* renamed from: com.sec.chaton.smsplugin.e.b */
/* loaded from: classes.dex */
public class C3849b {

    /* renamed from: a */
    private DrmRights f13845a;

    /* renamed from: b */
    private final DrmRawContent f13846b;

    /* renamed from: c */
    private final Uri f13847c;

    /* renamed from: d */
    private final byte[] f13848d;

    /* renamed from: e */
    private byte[] f13849e;

    public C3849b(String str, Uri uri, byte[] bArr) throws C5112a {
        if (str == null || bArr == null) {
            throw new IllegalArgumentException("Content-Type or data may not be null.");
        }
        this.f13847c = uri;
        this.f13848d = bArr;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        this.f13846b = new DrmRawContent(byteArrayInputStream, byteArrayInputStream.available(), str);
        if (!m14727c()) {
            m14724a(bArr);
        }
    }

    /* renamed from: h */
    private int m14723h() {
        String strM19505b = this.f13846b.m19505b();
        return (C5077a.m19290c(strM19505b) || C5077a.m19291d(strM19505b)) ? 1 : 2;
    }

    /* renamed from: a */
    public byte[] m14725a() throws IOException {
        if (this.f13849e == null && this.f13845a != null) {
            InputStream inputStreamM19504a = this.f13846b.m19504a(this.f13845a);
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[256];
                while (true) {
                    int i = inputStreamM19504a.read(bArr);
                    if (i <= 0) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, i);
                }
                this.f13849e = byteArrayOutputStream.toByteArray();
            } finally {
                try {
                    inputStreamM19504a.close();
                } catch (IOException e) {
                    C3890m.m14995a("DrmWrapper", e.getMessage(), e);
                }
            }
        }
        if (this.f13849e == null) {
            return null;
        }
        byte[] bArr2 = new byte[this.f13849e.length];
        System.arraycopy(this.f13849e, 0, bArr2, 0, this.f13849e.length);
        return bArr2;
    }

    /* renamed from: b */
    public boolean m14726b() {
        if (this.f13845a == null) {
            return false;
        }
        return this.f13845a.m19506a(m14723h());
    }

    /* renamed from: a */
    public void m14724a(byte[] bArr) throws C5112a {
        if (bArr == null) {
            throw new C5112a("Right data may not be null.");
        }
        this.f13845a = DrmRightsManager.m19507a().m19509a(new ByteArrayInputStream(bArr), bArr.length, "application/vnd.oma.drm.message");
    }

    /* renamed from: c */
    public boolean m14727c() {
        if (this.f13845a != null) {
            return true;
        }
        this.f13845a = DrmRightsManager.m19507a().m19508a(this.f13846b);
        return this.f13845a != null;
    }

    /* renamed from: d */
    public boolean m14728d() {
        return 3 == this.f13846b.m19503a();
    }

    /* renamed from: e */
    public String m14729e() {
        return this.f13846b.m19505b();
    }

    /* renamed from: f */
    public Uri m14730f() {
        return this.f13847c;
    }

    /* renamed from: g */
    public byte[] m14731g() {
        return this.f13848d;
    }
}
