package com.sec.chaton.smsplugin.p110g;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.net.Uri;
import android.text.TextUtils;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.smsplugin.C3781b;
import com.sec.chaton.smsplugin.C3847e;
import com.sec.chaton.smsplugin.p108e.C3849b;
import com.sec.chaton.smsplugin.p111h.C3890m;
import com.sec.chaton.smsplugin.p112ui.C4149cd;
import com.sec.chaton.smsplugin.p112ui.C4342jh;
import com.sec.google.android.p134a.C5111c;
import com.sec.google.android.p134a.p135a.C5094q;
import com.sec.google.android.p134a.p135a.C5097t;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.p146b.p147a.p148a.InterfaceC5237b;

/* compiled from: ImageModel.java */
/* renamed from: com.sec.chaton.smsplugin.g.g */
/* loaded from: classes.dex */
public class C3861g extends AbstractC3867m {

    /* renamed from: o */
    private static final int f13865o;

    /* renamed from: p */
    private static final Set<String> f13866p;

    /* renamed from: u */
    private static int f13867u;

    /* renamed from: v */
    private static int f13868v;

    /* renamed from: q */
    private int f13869q;

    /* renamed from: r */
    private int f13870r;

    /* renamed from: s */
    private int f13871s;

    /* renamed from: t */
    private Bitmap f13872t;

    static {
        f13865o = C4149cd.m16430d() > C4149cd.m16426c() ? C4149cd.m16426c() : C4149cd.m16430d();
        f13866p = new HashSet(Arrays.asList("image/jpeg", "image/png"));
        f13867u = (int) GlobalApplication.m10279a().getResources().getDimension(R.dimen.message_bubble_thumbnail_max_short);
        f13868v = (int) GlobalApplication.m10279a().getResources().getDimension(R.dimen.message_bubble_thumbnail_max_long);
    }

    public C3861g(Context context, Uri uri, C3868n c3868n) throws C5111c {
        super(context, "img", uri, c3868n);
        m14771c(uri);
        m14775d();
        m14780i();
    }

    public C3861g(Context context, String str, String str2, Uri uri, C3868n c3868n) {
        super(context, "img", str, str2, uri, c3868n);
        m14763H();
    }

    public C3861g(Context context, String str, String str2, C3849b c3849b, C3868n c3868n) {
        super(context, "img", str, str2, c3849b, c3868n);
    }

    /* renamed from: c */
    private void m14771c(Uri uri) throws C5111c {
        C4342jh c4342jh = new C4342jh(this.f13879a, uri);
        this.f13884f = c4342jh.m16521a();
        if (TextUtils.isEmpty(this.f13884f)) {
            throw new C5111c("Type of media is unknown.");
        }
        this.f13883e = c4342jh.m16522b();
        this.f13869q = c4342jh.m16523c();
        this.f13870r = c4342jh.m16524d();
        this.f13871s = c4342jh.m16525e();
    }

    /* renamed from: H */
    private void m14763H() {
        C4342jh c4342jh = new C4342jh(this.f13879a, m14814o());
        this.f13869q = c4342jh.m16523c();
        this.f13870r = c4342jh.m16524d();
        this.f13871s = c4342jh.m16525e();
    }

    @Override // org.p146b.p147a.p148a.InterfaceC5239d
    /* renamed from: a */
    public void mo14745a(InterfaceC5237b interfaceC5237b) {
        if (interfaceC5237b.mo14494b().equals("SmilMediaStart")) {
            this.f13901n = true;
        } else if (this.f13885g != 1) {
            this.f13901n = false;
        }
        m14833a(false);
    }

    /* renamed from: a */
    public int m14772a() {
        return this.f13869q;
    }

    /* renamed from: b */
    public int m14774b() {
        return this.f13870r;
    }

    /* renamed from: d */
    protected void m14775d() {
        C3859e.m14762a().mo14758a(this.f13884f);
    }

    /* renamed from: e */
    public Bitmap m14776e() {
        return m14767a(m14813n(), true);
    }

    /* renamed from: f */
    public Bitmap m14777f() {
        return m14767a(m14814o(), false);
    }

    /* renamed from: a */
    private Bitmap m14767a(Uri uri, boolean z) {
        Bitmap bitmapM14764I = m14764I();
        if (bitmapM14764I == null) {
            try {
                if (z) {
                    if (C3847e.m14673ae()) {
                        int iM16426c = (C4149cd.m16426c() * 3) / 4;
                        if (this.f13869q * 2 > iM16426c) {
                            bitmapM14764I = m14770b(iM16426c, uri);
                        } else {
                            bitmapM14764I = m14770b(this.f13869q * 2, uri);
                        }
                    } else {
                        bitmapM14764I = m14770b(480, uri);
                    }
                } else {
                    bitmapM14764I = m14765a(f13865o, uri);
                }
                if (bitmapM14764I != null) {
                    m14768a(bitmapM14764I);
                }
            } catch (OutOfMemoryError e) {
            }
        }
        return bitmapM14764I;
    }

    /* renamed from: a */
    private Bitmap m14765a(int i, Uri uri) {
        int i2 = this.f13869q;
        int i3 = this.f13870r;
        int i4 = 1;
        if (!C3847e.m14673ae()) {
            while (true) {
                if (i2 / i4 <= i && i3 / i4 <= i) {
                    break;
                }
                i4 *= 2;
            }
        } else {
            while ((i2 > i3 ? i2 : i3) / i4 > i) {
                i4 *= 2;
            }
        }
        if (C3890m.m15000f("Mms:app", C3890m.f13993b)) {
            C3890m.m14994a("Mms/image", "createThumbnailBitmap: scale=" + i4 + ", w=" + (i2 / i4) + ", h=" + (i3 / i4));
        }
        return m14766a(uri, i4);
    }

    /* renamed from: b */
    private Bitmap m14770b(int i, Uri uri) {
        int i2 = this.f13869q;
        int i3 = this.f13870r;
        int i4 = 1;
        if (!C3847e.m14673ae()) {
            while (true) {
                if (i2 / i4 <= i && i3 / i4 <= i) {
                    break;
                }
                i4 *= 2;
            }
        } else {
            while ((i2 > i3 ? i2 : i3) / i4 > i) {
                i4 *= 2;
            }
        }
        if (C3890m.m15000f("Mms:app", C3890m.f13993b)) {
            C3890m.m14994a("Mms/image", "createThumbnailBitmap: scale=" + i4 + ", w=" + (i2 / i4) + ", h=" + (i3 / i4));
        }
        return m14766a(uri, i4);
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x0059 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.graphics.Bitmap m14766a(android.net.Uri r10, int r11) throws java.lang.Throwable {
        /*
            r9 = this;
            r7 = 0
            android.graphics.BitmapFactory$Options r0 = new android.graphics.BitmapFactory$Options
            r0.<init>()
            r0.inSampleSize = r11
            android.content.Context r1 = r9.f13879a     // Catch: java.io.FileNotFoundException -> L3d java.lang.OutOfMemoryError -> L50 java.lang.Throwable -> L81
            android.content.ContentResolver r1 = r1.getContentResolver()     // Catch: java.io.FileNotFoundException -> L3d java.lang.OutOfMemoryError -> L50 java.lang.Throwable -> L81
            java.io.InputStream r8 = r1.openInputStream(r10)     // Catch: java.io.FileNotFoundException -> L3d java.lang.OutOfMemoryError -> L50 java.lang.Throwable -> L81
            r1 = 0
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeStream(r8, r1, r0)     // Catch: java.lang.Throwable -> L56 java.lang.OutOfMemoryError -> L87 java.io.FileNotFoundException -> L89
            int r1 = r9.f13871s     // Catch: java.lang.Throwable -> L56 java.lang.OutOfMemoryError -> L87 java.io.FileNotFoundException -> L89
            if (r1 == 0) goto L37
            if (r0 == 0) goto L37
            android.graphics.Matrix r5 = new android.graphics.Matrix     // Catch: java.lang.Throwable -> L56 java.lang.OutOfMemoryError -> L87 java.io.FileNotFoundException -> L89
            r5.<init>()     // Catch: java.lang.Throwable -> L56 java.lang.OutOfMemoryError -> L87 java.io.FileNotFoundException -> L89
            int r1 = r9.f13871s     // Catch: java.lang.Throwable -> L56 java.lang.OutOfMemoryError -> L87 java.io.FileNotFoundException -> L89
            float r1 = (float) r1     // Catch: java.lang.Throwable -> L56 java.lang.OutOfMemoryError -> L87 java.io.FileNotFoundException -> L89
            r5.postRotate(r1)     // Catch: java.lang.Throwable -> L56 java.lang.OutOfMemoryError -> L87 java.io.FileNotFoundException -> L89
            r1 = 0
            r2 = 0
            int r3 = r0.getWidth()     // Catch: java.lang.Throwable -> L56 java.lang.OutOfMemoryError -> L87 java.io.FileNotFoundException -> L89
            int r4 = r0.getHeight()     // Catch: java.lang.Throwable -> L56 java.lang.OutOfMemoryError -> L87 java.io.FileNotFoundException -> L89
            r6 = 1
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r0, r1, r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L56 java.lang.OutOfMemoryError -> L87 java.io.FileNotFoundException -> L89
        L37:
            if (r8 == 0) goto L3c
            r8.close()     // Catch: java.io.IOException -> L75
        L3c:
            return r0
        L3d:
            r0 = move-exception
            r1 = r7
        L3f:
            java.lang.String r2 = "Mms/image"
            java.lang.String r3 = r0.getMessage()     // Catch: java.lang.Throwable -> L84
            com.sec.chaton.smsplugin.p111h.C3890m.m14995a(r2, r3, r0)     // Catch: java.lang.Throwable -> L84
            if (r1 == 0) goto L4e
            r1.close()     // Catch: java.io.IOException -> L69
        L4e:
            r0 = r7
            goto L3c
        L50:
            r0 = move-exception
            r8 = r7
        L52:
            com.sec.chaton.smsplugin.p112ui.C4149cd.m16420b()     // Catch: java.lang.Throwable -> L56
            throw r0     // Catch: java.lang.Throwable -> L56
        L56:
            r0 = move-exception
        L57:
            if (r8 == 0) goto L5c
            r8.close()     // Catch: java.io.IOException -> L5d
        L5c:
            throw r0
        L5d:
            r1 = move-exception
            java.lang.String r2 = "Mms/image"
            java.lang.String r3 = r1.getMessage()
            com.sec.chaton.smsplugin.p111h.C3890m.m14995a(r2, r3, r1)
            goto L5c
        L69:
            r0 = move-exception
            java.lang.String r1 = "Mms/image"
            java.lang.String r2 = r0.getMessage()
            com.sec.chaton.smsplugin.p111h.C3890m.m14995a(r1, r2, r0)
            goto L4e
        L75:
            r1 = move-exception
            java.lang.String r2 = "Mms/image"
            java.lang.String r3 = r1.getMessage()
            com.sec.chaton.smsplugin.p111h.C3890m.m14995a(r2, r3, r1)
            goto L3c
        L81:
            r0 = move-exception
            r8 = r7
            goto L57
        L84:
            r0 = move-exception
            r8 = r1
            goto L57
        L87:
            r0 = move-exception
            goto L52
        L89:
            r0 = move-exception
            r1 = r8
            goto L3f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.smsplugin.p110g.C3861g.m14766a(android.net.Uri, int):android.graphics.Bitmap");
    }

    @Override // com.sec.chaton.smsplugin.p110g.AbstractC3863i
    /* renamed from: g */
    public boolean mo14778g() {
        return true;
    }

    @Override // com.sec.chaton.smsplugin.p110g.AbstractC3863i
    /* renamed from: a */
    protected void mo14773a(int i, long j) throws IOException {
        C4342jh c4342jh = new C4342jh(this.f13879a, m14813n());
        int iM14707m = C3847e.m14707m();
        int iM14706l = C3847e.m14706l();
        int iR = m14817r();
        if (c4342jh.m16524d() <= c4342jh.m16523c()) {
            iM14706l = iM14707m;
            iM14707m = iM14706l;
        }
        if (C3890m.m15000f("Mms:app", C3890m.f13993b)) {
            C3890m.m14994a("Mms/image", "resizeMedia size: " + iR + " image.getWidth(): " + c4342jh.m16523c() + " widthLimit: " + iM14706l + " image.getHeight(): " + c4342jh.m16524d() + " heightLimit: " + iM14707m + " image.getContentType(): " + c4342jh.m16521a());
        }
        if (iR != 0 && iR <= i && c4342jh.m16523c() <= iM14706l && c4342jh.m16524d() <= iM14707m && f13866p.contains(c4342jh.m16521a())) {
            if (C3890m.m15000f("Mms:app", C3890m.f13993b)) {
                C3890m.m14994a("Mms/image", "resizeMedia - already sized");
                return;
            }
            return;
        }
        C5094q c5094qM16520a = c4342jh.m16520a(iM14706l, iM14707m, i);
        if (c5094qM16520a == null) {
            throw new C3781b("Not enough memory to turn image into part: " + m14813n());
        }
        this.f13884f = new String(c5094qM16520a.m19394g());
        String strQ = m14816q();
        byte[] bytes = strQ.getBytes();
        c5094qM16520a.m19385c(bytes);
        int iLastIndexOf = strQ.lastIndexOf(".");
        if (iLastIndexOf != -1) {
            bytes = strQ.substring(0, iLastIndexOf).getBytes();
        }
        c5094qM16520a.m19384b(bytes);
        C5097t c5097tM19426a = C5097t.m19426a(this.f13879a);
        if (c5094qM16520a.m19382a() != null) {
            this.f13886h = c5094qM16520a.m19382a().length;
        }
        if (C3890m.m15000f("Mms:app", C3890m.f13993b)) {
            C3890m.m14994a("Mms/image", "resizeMedia mSize: " + this.f13886h);
        }
        m14805a(c5097tM19426a.m19445a(c5094qM16520a, j));
    }

    /* renamed from: h */
    public void m14779h() {
        C3859e.m14762a().mo14756a(this.f13869q, this.f13870r);
    }

    /* renamed from: i */
    public void m14780i() {
        InterfaceC3858d interfaceC3858dM14762a = C3859e.m14762a();
        interfaceC3858dM14762a.mo14759a(this.f13884f, C3857c.m14754a(this.f13879a));
        interfaceC3858dM14762a.mo14756a(this.f13869q, this.f13870r);
        interfaceC3858dM14762a.mo14755a(this.f13871s);
    }

    /* renamed from: j */
    public boolean m14781j() {
        return m14764I() != null;
    }

    /* renamed from: a */
    private void m14768a(Bitmap bitmap) {
        this.f13872t = bitmap;
    }

    /* renamed from: I */
    private Bitmap m14764I() {
        return this.f13872t;
    }

    /* renamed from: a */
    public static void m14769a(Point point, int i, int i2) {
        int i3;
        int i4;
        float f;
        if (i <= i2) {
            i3 = f13867u;
            i4 = f13868v;
            f = i3 / i;
        } else {
            i3 = f13868v;
            i4 = f13867u;
            f = i4 / i2;
        }
        int i5 = (int) (i * f);
        int i6 = (int) (f * i2);
        point.x = i5 < i3 ? i5 : i3;
        point.y = i6 < i4 ? i6 : i4;
        if (point.x == i3) {
            point.y = (int) ((i3 / i5) * point.y);
        } else if (point.y == i4) {
            point.x = (int) ((i4 / i6) * point.x);
        }
    }
}
