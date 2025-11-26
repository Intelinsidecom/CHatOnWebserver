package com.facebook;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import com.facebook.p008b.C0099m;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import weibo4android.org.json.HTTP;

/* compiled from: Request.java */
/* renamed from: com.facebook.av */
/* loaded from: classes.dex */
class C0081av implements InterfaceC0080au {

    /* renamed from: a */
    private final BufferedOutputStream f130a;

    /* renamed from: b */
    private final C0099m f131b;

    /* renamed from: c */
    private boolean f132c = true;

    public C0081av(BufferedOutputStream bufferedOutputStream, C0099m c0099m) {
        this.f130a = bufferedOutputStream;
        this.f131b = c0099m;
    }

    /* renamed from: a */
    public void m183a(String str, Object obj) {
        if (C0072am.m162d(obj)) {
            mo177a(str, C0072am.m163e(obj));
            return;
        }
        if (obj instanceof Bitmap) {
            m181a(str, (Bitmap) obj);
        } else if (obj instanceof byte[]) {
            m185a(str, (byte[]) obj);
        } else {
            if (obj instanceof ParcelFileDescriptor) {
                m182a(str, (ParcelFileDescriptor) obj);
                return;
            }
            throw new IllegalArgumentException("value is not a supported type: String, Bitmap, byte[]");
        }
    }

    @Override // com.facebook.InterfaceC0080au
    /* renamed from: a */
    public void mo177a(String str, String str2) {
        m184a(str, null, null);
        m187b("%s", str2);
        m180a();
        if (this.f131b != null) {
            this.f131b.m251a("    " + str, (Object) str2);
        }
    }

    /* renamed from: a */
    public void m181a(String str, Bitmap bitmap) {
        m184a(str, str, "image/png");
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, this.f130a);
        m187b("", new Object[0]);
        m180a();
        this.f131b.m251a("    " + str, (Object) "<Image>");
    }

    /* renamed from: a */
    public void m185a(String str, byte[] bArr) {
        m184a(str, str, "content/unknown");
        this.f130a.write(bArr);
        m187b("", new Object[0]);
        m180a();
        this.f131b.m251a("    " + str, (Object) String.format("<Data: %d>", Integer.valueOf(bArr.length)));
    }

    /* renamed from: a */
    public void m182a(String str, ParcelFileDescriptor parcelFileDescriptor) throws Throwable {
        BufferedInputStream bufferedInputStream;
        ParcelFileDescriptor.AutoCloseInputStream autoCloseInputStream = null;
        m184a(str, str, "content/unknown");
        try {
            ParcelFileDescriptor.AutoCloseInputStream autoCloseInputStream2 = new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor);
            try {
                bufferedInputStream = new BufferedInputStream(autoCloseInputStream2);
            } catch (Throwable th) {
                th = th;
                bufferedInputStream = null;
                autoCloseInputStream = autoCloseInputStream2;
            }
            try {
                byte[] bArr = new byte[8192];
                int i = 0;
                while (true) {
                    int i2 = bufferedInputStream.read(bArr);
                    if (i2 == -1) {
                        break;
                    }
                    this.f130a.write(bArr, 0, i2);
                    i += i2;
                }
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                if (autoCloseInputStream2 != null) {
                    autoCloseInputStream2.close();
                }
                m187b("", new Object[0]);
                m180a();
                this.f131b.m251a("    " + str, (Object) String.format("<Data: %d>", Integer.valueOf(i)));
            } catch (Throwable th2) {
                th = th2;
                autoCloseInputStream = autoCloseInputStream2;
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                if (autoCloseInputStream != null) {
                    autoCloseInputStream.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedInputStream = null;
        }
    }

    /* renamed from: a */
    public void m180a() {
        m187b("--%s", "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f");
    }

    /* renamed from: a */
    public void m184a(String str, String str2, String str3) {
        m186a("Content-Disposition: form-data; name=\"%s\"", str);
        if (str2 != null) {
            m186a("; filename=\"%s\"", str2);
        }
        m187b("", new Object[0]);
        if (str3 != null) {
            m187b("%s: %s", "Content-Type", str3);
        }
        m187b("", new Object[0]);
    }

    /* renamed from: a */
    public void m186a(String str, Object... objArr) {
        if (this.f132c) {
            this.f130a.write("--".getBytes());
            this.f130a.write("3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f".getBytes());
            this.f130a.write(HTTP.CRLF.getBytes());
            this.f132c = false;
        }
        this.f130a.write(String.format(str, objArr).getBytes());
    }

    /* renamed from: b */
    public void m187b(String str, Object... objArr) {
        m186a(str, objArr);
        m186a(HTTP.CRLF, new Object[0]);
    }
}
