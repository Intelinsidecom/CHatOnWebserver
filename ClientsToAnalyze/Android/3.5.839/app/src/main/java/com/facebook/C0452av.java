package com.facebook;

import android.graphics.Bitmap;
import android.hardware.motion.MotionRecognitionManager;
import android.os.ParcelFileDescriptor;
import com.facebook.p032b.C0470m;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;

/* compiled from: Request.java */
/* renamed from: com.facebook.av */
/* loaded from: classes.dex */
class C0452av implements InterfaceC0451au {

    /* renamed from: a */
    private final BufferedOutputStream f1099a;

    /* renamed from: b */
    private final C0470m f1100b;

    /* renamed from: c */
    private boolean f1101c = true;

    public C0452av(BufferedOutputStream bufferedOutputStream, C0470m c0470m) {
        this.f1099a = bufferedOutputStream;
        this.f1100b = c0470m;
    }

    /* renamed from: a */
    public void m1627a(String str, Object obj) {
        if (C0443am.m1606d(obj)) {
            mo1621a(str, C0443am.m1607e(obj));
            return;
        }
        if (obj instanceof Bitmap) {
            m1625a(str, (Bitmap) obj);
        } else if (obj instanceof byte[]) {
            m1629a(str, (byte[]) obj);
        } else {
            if (obj instanceof ParcelFileDescriptor) {
                m1626a(str, (ParcelFileDescriptor) obj);
                return;
            }
            throw new IllegalArgumentException("value is not a supported type: String, Bitmap, byte[]");
        }
    }

    @Override // com.facebook.InterfaceC0451au
    /* renamed from: a */
    public void mo1621a(String str, String str2) {
        m1628a(str, null, null);
        m1631b("%s", str2);
        m1624a();
        if (this.f1100b != null) {
            this.f1100b.m1695a("    " + str, (Object) str2);
        }
    }

    /* renamed from: a */
    public void m1625a(String str, Bitmap bitmap) {
        m1628a(str, str, "image/png");
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, this.f1099a);
        m1631b("", new Object[0]);
        m1624a();
        this.f1100b.m1695a("    " + str, (Object) "<Image>");
    }

    /* renamed from: a */
    public void m1629a(String str, byte[] bArr) {
        m1628a(str, str, "content/unknown");
        this.f1099a.write(bArr);
        m1631b("", new Object[0]);
        m1624a();
        this.f1100b.m1695a("    " + str, (Object) String.format("<Data: %d>", Integer.valueOf(bArr.length)));
    }

    /* renamed from: a */
    public void m1626a(String str, ParcelFileDescriptor parcelFileDescriptor) throws Throwable {
        BufferedInputStream bufferedInputStream;
        ParcelFileDescriptor.AutoCloseInputStream autoCloseInputStream = null;
        m1628a(str, str, "content/unknown");
        try {
            ParcelFileDescriptor.AutoCloseInputStream autoCloseInputStream2 = new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor);
            try {
                bufferedInputStream = new BufferedInputStream(autoCloseInputStream2);
                try {
                    byte[] bArr = new byte[MotionRecognitionManager.EVENT_FLAT];
                    int i = 0;
                    while (true) {
                        int i2 = bufferedInputStream.read(bArr);
                        if (i2 == -1) {
                            break;
                        }
                        this.f1099a.write(bArr, 0, i2);
                        i += i2;
                    }
                    if (bufferedInputStream != null) {
                        bufferedInputStream.close();
                    }
                    if (autoCloseInputStream2 != null) {
                        autoCloseInputStream2.close();
                    }
                    m1631b("", new Object[0]);
                    m1624a();
                    this.f1100b.m1695a("    " + str, (Object) String.format("<Data: %d>", Integer.valueOf(i)));
                } catch (Throwable th) {
                    th = th;
                    autoCloseInputStream = autoCloseInputStream2;
                    if (bufferedInputStream != null) {
                        bufferedInputStream.close();
                    }
                    if (autoCloseInputStream != null) {
                        autoCloseInputStream.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedInputStream = null;
                autoCloseInputStream = autoCloseInputStream2;
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedInputStream = null;
        }
    }

    /* renamed from: a */
    public void m1624a() {
        m1631b("--%s", "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f");
    }

    /* renamed from: a */
    public void m1628a(String str, String str2, String str3) {
        m1630a("Content-Disposition: form-data; name=\"%s\"", str);
        if (str2 != null) {
            m1630a("; filename=\"%s\"", str2);
        }
        m1631b("", new Object[0]);
        if (str3 != null) {
            m1631b("%s: %s", "Content-Type", str3);
        }
        m1631b("", new Object[0]);
    }

    /* renamed from: a */
    public void m1630a(String str, Object... objArr) {
        if (this.f1101c) {
            this.f1099a.write("--".getBytes());
            this.f1099a.write("3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f".getBytes());
            this.f1099a.write("\r\n".getBytes());
            this.f1101c = false;
        }
        this.f1099a.write(String.format(str, objArr).getBytes());
    }

    /* renamed from: b */
    public void m1631b(String str, Object... objArr) {
        m1630a(str, objArr);
        m1630a("\r\n", new Object[0]);
    }
}
