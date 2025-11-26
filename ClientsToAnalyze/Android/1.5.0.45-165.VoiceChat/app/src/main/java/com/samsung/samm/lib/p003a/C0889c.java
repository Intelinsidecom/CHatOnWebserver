package com.samsung.samm.lib.p003a;

import android.graphics.Bitmap;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* renamed from: com.samsung.samm.lib.a.c */
/* loaded from: classes.dex */
public class C0889c {

    /* renamed from: j */
    private String f476j;

    /* renamed from: k */
    private boolean f477k;

    /* renamed from: a */
    private int f467a = 0;

    /* renamed from: b */
    private int f468b = 0;

    /* renamed from: c */
    private int f469c = 0;

    /* renamed from: d */
    private int f470d = 0;

    /* renamed from: e */
    private int f471e = 0;

    /* renamed from: f */
    private int f472f = 0;

    /* renamed from: g */
    private String f473g = null;

    /* renamed from: h */
    private String f474h = null;

    /* renamed from: i */
    private String f475i = null;

    /* renamed from: l */
    private boolean f478l = true;

    public C0889c(String str, boolean z) {
        this.f477k = true;
        this.f476j = str;
        this.f477k = z;
        m263k();
    }

    /* renamed from: k */
    private void m263k() {
        this.f467a = 0;
        this.f472f = 0;
        this.f474h = String.valueOf(this.f476j) + ".jpg";
        this.f475i = String.valueOf(this.f476j) + ".png";
    }

    /* renamed from: a */
    public int m264a() {
        return this.f467a;
    }

    /* renamed from: a */
    public void m265a(int i) {
        this.f467a = 0;
        this.f468b = (i >> 24) & 255;
        this.f469c = (i >> 16) & 255;
        this.f470d = (i >> 8) & 255;
        this.f471e = i & 255;
    }

    /* renamed from: b */
    public void m272b(int i) {
        this.f468b = i;
    }

    /* renamed from: c */
    public void m274c(int i) {
        this.f469c = i;
    }

    /* renamed from: d */
    public void m276d(int i) {
        this.f470d = i;
    }

    /* renamed from: e */
    public void m278e(int i) {
        this.f471e = i;
    }

    /* renamed from: b */
    public int m271b() {
        return (this.f468b << 24) | (this.f469c << 16) | (this.f470d << 8) | this.f471e;
    }

    /* renamed from: c */
    public int m273c() {
        return this.f468b;
    }

    /* renamed from: d */
    public int m275d() {
        return this.f469c;
    }

    /* renamed from: e */
    public int m277e() {
        return this.f470d;
    }

    /* renamed from: f */
    public int m279f() {
        return this.f471e;
    }

    /* renamed from: f */
    public void m280f(int i) {
        this.f467a = 2;
        this.f472f = i & 255;
    }

    /* renamed from: g */
    public int m281g() {
        return this.f472f;
    }

    /* renamed from: a */
    public boolean m270a(String str, int i, int i2) throws Throwable {
        if (!C0902p.m578b(str)) {
            Log.e("SAMMLibraryCore", "setBGImagePath : Invalid Image File Path");
            return false;
        }
        if (i <= 0) {
            Log.e("SAMMLibraryCore", "setBGImagePath : Invalid nCanvasWidth");
            return false;
        }
        this.f473g = str;
        Bitmap bitmapM574a = C0902p.m574a(str, i, i);
        if (bitmapM574a == null) {
            Log.e("SAMMLibraryCore", "Image scaling fail");
            return false;
        }
        if (this.f477k) {
            String strSubstring = str.substring(str.lastIndexOf(".") + 1);
            if (strSubstring.compareToIgnoreCase("jpg") == 0 || strSubstring.compareToIgnoreCase("jpeg") == 0) {
                this.f467a = 3;
            } else if (strSubstring.compareToIgnoreCase("png") == 0) {
                this.f467a = 4;
            } else {
                Log.e("SAMMLibraryCore", "Unsupported Image file format");
                return false;
            }
            String strM283i = m283i();
            if (strSubstring.compareToIgnoreCase("jpg") == 0 || strSubstring.compareToIgnoreCase("jpeg") == 0) {
                C0902p.m577a(strM283i, bitmapM574a, 100);
                return true;
            }
            if (strSubstring.compareToIgnoreCase("png") != 0) {
                return false;
            }
            C0902p.m576a(strM283i, bitmapM574a);
            return true;
        }
        m267a(bitmapM574a, i, i2);
        return true;
    }

    /* renamed from: h */
    public String m282h() {
        int iM264a = m264a();
        if (iM264a == 3 || iM264a == 4) {
            return this.f473g;
        }
        return null;
    }

    /* renamed from: i */
    public String m283i() {
        if (this.f467a == 3) {
            return this.f474h;
        }
        if (this.f467a == 4) {
            return this.f475i;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x001f  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00eb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v12, types: [java.nio.Buffer, java.nio.ByteBuffer] */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v16, types: [java.io.RandomAccessFile] */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r2v30 */
    /* JADX WARN: Type inference failed for: r2v31 */
    /* JADX WARN: Type inference failed for: r2v32 */
    /* JADX WARN: Type inference failed for: r2v33 */
    /* JADX WARN: Type inference failed for: r2v34 */
    /* JADX WARN: Type inference failed for: r2v35 */
    /* JADX WARN: Type inference failed for: r7v2, types: [android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean m267a(android.graphics.Bitmap r7, int r8, int r9) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 270
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.samsung.samm.lib.p003a.C0889c.m267a(android.graphics.Bitmap, int, int):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:122:0x021d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0218 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v19, types: [java.io.RandomAccessFile] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v30 */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.io.RandomAccessFile] */
    /* JADX WARN: Type inference failed for: r4v9, types: [java.io.RandomAccessFile] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean m266a(int r12, int r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 671
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.samsung.samm.lib.p003a.C0889c.m266a(int, int):boolean");
    }

    /* renamed from: j */
    public int m284j() {
        if (!this.f477k) {
            return 0;
        }
        if (this.f467a != 3 && this.f467a != 4) {
            return 0;
        }
        File file = new File(m283i());
        if (file.exists() && file.canRead()) {
            return (int) file.length();
        }
        return 0;
    }

    /* renamed from: a */
    public boolean m269a(RandomAccessFile randomAccessFile, int i, int i2, int i3) throws IOException {
        this.f467a = i;
        this.f472f = i2;
        if (this.f467a == 3 || this.f467a == 4) {
            if (!C0903q.m589a(randomAccessFile, m283i(), i3)) {
                return false;
            }
        } else {
            try {
                randomAccessFile.skipBytes(i3);
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public boolean m268a(RandomAccessFile randomAccessFile, int i, int i2) {
        if (this.f477k && (i == 3 || i == 4)) {
            if (!C0903q.m596b(randomAccessFile, m283i(), i2)) {
                return false;
            }
        } else if (i2 > 0) {
            return false;
        }
        return true;
    }
}
