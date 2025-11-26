package com.sec.chaton.smsplugin.p110g;

import android.content.Context;
import android.net.Uri;
import com.sec.chaton.smsplugin.p111h.C3890m;
import com.sec.google.android.p134a.C5111c;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import org.p146b.p147a.p148a.InterfaceC5237b;
import org.p146b.p147a.p148a.InterfaceC5239d;

/* compiled from: AttachmentModel.java */
/* renamed from: com.sec.chaton.smsplugin.g.a */
/* loaded from: classes.dex */
public class C3855a extends C3866l implements InterfaceC5239d {

    /* renamed from: g */
    private static final String[] f13853g = {"_display_name"};

    /* renamed from: a */
    protected Context f13854a;

    /* renamed from: b */
    protected String f13855b;

    /* renamed from: c */
    protected String f13856c;

    /* renamed from: d */
    protected int f13857d;

    /* renamed from: e */
    private Uri f13858e;

    /* renamed from: f */
    private byte[] f13859f;

    public C3855a(Context context, String str, String str2, Uri uri) throws IOException {
        this.f13854a = context;
        this.f13856c = str;
        this.f13855b = str2;
        this.f13858e = uri;
        this.f13859f = m14742g();
        m14743i();
    }

    public C3855a(Context context, Uri uri, boolean z) {
        this.f13858e = uri;
        this.f13854a = context;
        m14741f();
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00d3 A[PHI: r3
  0x00d3: PHI (r3v7 java.lang.String) = (r3v4 java.lang.String), (r3v4 java.lang.String), (r3v4 java.lang.String), (r3v8 java.lang.String) binds: [B:32:0x00a1, B:34:0x00ac, B:36:0x00b5, B:18:0x005d] A[DONT_GENERATE, DONT_INLINE]] */
    /* renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m14741f() {
        /*
            r7 = this;
            r6 = 2131427555(0x7f0b00e3, float:1.847673E38)
            r3 = 0
            android.net.Uri r0 = r7.f13858e
            java.lang.String r0 = r0.getScheme()
            java.lang.String r1 = "android.resource"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L33
            r0 = r3
        L14:
            if (r0 != 0) goto L1c
            android.content.Context r0 = r7.f13854a
            java.lang.String r0 = r0.getString(r6)
        L1c:
            java.lang.String r1 = r7.f13856c
            if (r1 != 0) goto L25
            java.lang.String r1 = ""
            r7.f13856c = r1
        L25:
            r7.f13855b = r0
            byte[] r0 = r7.m14742g()
            r7.f13859f = r0
            byte[] r0 = r7.f13859f
            int r0 = r0.length
            r7.f13857d = r0
            return
        L33:
            java.lang.String r1 = "file"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L66
            android.net.Uri r0 = r7.f13858e
            java.lang.String r3 = r0.getLastPathSegment()
            java.lang.String r0 = r3.toLowerCase()
            java.lang.String r1 = ".vcs"
            boolean r1 = r0.endsWith(r1)
            if (r1 == 0) goto L56
            java.lang.String r0 = "text/x-vCalendar"
            r7.f13856c = r0
            r0 = r3
            goto L14
        L56:
            java.lang.String r1 = ".vcf"
            boolean r0 = r0.endsWith(r1)
            if (r0 == 0) goto Ld3
            java.lang.String r0 = "text/x-vCard"
            r7.f13856c = r0
            r0 = r3
            goto L14
        L66:
            java.lang.String r1 = "content"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto Ld6
            android.content.Context r0 = r7.f13854a
            android.content.ContentResolver r0 = r0.getContentResolver()
            android.net.Uri r1 = r7.f13858e
            java.lang.String[] r2 = com.sec.chaton.smsplugin.p110g.C3855a.f13853g
            r4 = r3
            r5 = r3
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)
            if (r1 == 0) goto L8f
            boolean r2 = r1.moveToFirst()     // Catch: java.lang.Throwable -> Lce
            if (r2 == 0) goto L8c
            r2 = 0
            java.lang.String r3 = r1.getString(r2)     // Catch: java.lang.Throwable -> Lce
        L8c:
            r1.close()
        L8f:
            android.net.Uri r1 = r7.f13858e
            java.lang.String r0 = r0.getType(r1)
            r7.f13856c = r0
            if (r3 != 0) goto L9f
            android.content.Context r0 = r7.f13854a
            java.lang.String r3 = r0.getString(r6)
        L9f:
            java.lang.String r0 = r7.f13856c
            if (r0 == 0) goto Ld3
            java.lang.String r0 = r7.f13856c
            java.lang.String r1 = "text/x-vCard"
            boolean r0 = r0.equalsIgnoreCase(r1)
            if (r0 == 0) goto Ld3
            java.lang.String r0 = ".vcf"
            boolean r0 = r3.endsWith(r0)
            if (r0 != 0) goto Ld3
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.StringBuilder r0 = r0.append(r3)
            java.lang.String r1 = ".vcf"
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r3 = r0.toString()
            r0 = r3
            goto L14
        Lce:
            r0 = move-exception
            r1.close()
            throw r0
        Ld3:
            r0 = r3
            goto L14
        Ld6:
            r0 = r3
            goto L14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.smsplugin.p110g.C3855a.m14741f():void");
    }

    /* renamed from: g */
    private byte[] m14742g() throws Throwable {
        byte[] bArr;
        int i = 0;
        InputStream inputStream = null;
        try {
            try {
                InputStream inputStreamOpenInputStream = this.f13854a.getContentResolver().openInputStream(this.f13858e);
                try {
                    byte[] bArr2 = new byte[inputStreamOpenInputStream.available()];
                    while (true) {
                        int i2 = inputStreamOpenInputStream.read(bArr2, i, bArr2.length - i);
                        if (i2 <= 0) {
                            break;
                        }
                        int i3 = i2 + i;
                        int iAvailable = inputStreamOpenInputStream.available();
                        if (iAvailable > bArr2.length - i3) {
                            bArr = new byte[iAvailable + i3];
                            System.arraycopy(bArr2, 0, bArr, 0, i3);
                        } else {
                            bArr = bArr2;
                        }
                        bArr2 = bArr;
                        i = i3;
                    }
                    if (inputStreamOpenInputStream != null) {
                        try {
                            inputStreamOpenInputStream.close();
                        } catch (IOException e) {
                            C3890m.m14995a("Mms/AttachmentModel", "IOException caught while closing stream", e);
                        }
                    }
                    return bArr2;
                } catch (IOException e2) {
                    e = e2;
                    inputStream = inputStreamOpenInputStream;
                    C3890m.m14995a("Mms/AttachmentModel", "IOException caught while opening or reading stream", e);
                    throw new C5111c(e.getMessage());
                } catch (Throwable th) {
                    th = th;
                    inputStream = inputStreamOpenInputStream;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e3) {
                            C3890m.m14995a("Mms/AttachmentModel", "IOException caught while closing stream", e3);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e4) {
            e = e4;
        }
    }

    /* renamed from: a */
    public String m14744a() {
        return this.f13856c;
    }

    /* renamed from: b */
    public Uri m14746b() {
        return this.f13858e;
    }

    /* renamed from: c */
    public byte[] m14747c() {
        if (this.f13859f == null) {
            return null;
        }
        byte[] bArr = new byte[this.f13859f.length];
        System.arraycopy(this.f13859f, 0, bArr, 0, this.f13859f.length);
        return bArr;
    }

    /* renamed from: d */
    public String m14748d() {
        return this.f13855b;
    }

    /* renamed from: e */
    public int m14749e() {
        return this.f13857d;
    }

    /* renamed from: i */
    private void m14743i() throws IOException {
        String str;
        String str2;
        InputStream inputStream = null;
        try {
            try {
                InputStream inputStreamOpenInputStream = this.f13854a.getContentResolver().openInputStream(this.f13858e);
                if (inputStreamOpenInputStream instanceof FileInputStream) {
                    this.f13857d = (int) ((FileInputStream) inputStreamOpenInputStream).getChannel().size();
                } else {
                    while (-1 != inputStreamOpenInputStream.read()) {
                        this.f13857d++;
                    }
                }
                if (inputStreamOpenInputStream != null) {
                    try {
                        inputStreamOpenInputStream.close();
                    } catch (IOException e) {
                        e = e;
                        str = "Mms/AttachmentModel";
                        str2 = "IOException caught while closing stream";
                        C3890m.m14995a(str, str2, e);
                    }
                }
            } catch (IOException e2) {
                C3890m.m14995a("Mms/AttachmentModel", "IOException caught while opening or reading stream", e2);
                if (e2 instanceof FileNotFoundException) {
                    throw new C5111c(e2.getMessage());
                }
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (IOException e3) {
                        e = e3;
                        str = "Mms/AttachmentModel";
                        str2 = "IOException caught while closing stream";
                        C3890m.m14995a(str, str2, e);
                    }
                }
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    inputStream.close();
                } catch (IOException e4) {
                    C3890m.m14995a("Mms/AttachmentModel", "IOException caught while closing stream", e4);
                }
            }
            throw th;
        }
    }

    @Override // org.p146b.p147a.p148a.InterfaceC5239d
    /* renamed from: a */
    public void mo14745a(InterfaceC5237b interfaceC5237b) {
        m14833a(false);
    }
}
