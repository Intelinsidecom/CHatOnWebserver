package com.sec.chaton.smsplugin.p112ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SqliteWrapper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.text.TextUtils;
import com.sec.chaton.smsplugin.p110g.AbstractC3863i;
import com.sec.chaton.smsplugin.p111h.C3890m;
import com.sec.chaton.smsplugin.p111h.C3891n;
import com.sec.chaton.smsplugin.spam.C4012bp;
import com.sec.google.android.p134a.p135a.C5094q;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: UriImage.java */
@TargetApi(14)
/* renamed from: com.sec.chaton.smsplugin.ui.jh */
/* loaded from: classes.dex */
public class C4342jh {

    /* renamed from: a */
    private static String f15771a = "map";

    /* renamed from: b */
    private static String f15772b = "jpg";

    /* renamed from: c */
    private final Context f15773c;

    /* renamed from: d */
    private final Uri f15774d;

    /* renamed from: e */
    private String f15775e;

    /* renamed from: f */
    private String f15776f;

    /* renamed from: g */
    private String f15777g;

    /* renamed from: h */
    private int f15778h = 0;

    /* renamed from: i */
    private int f15779i = 0;

    /* renamed from: j */
    private int f15780j;

    public C4342jh(Context context, Uri uri) throws IOException {
        this.f15780j = 0;
        if (context == null || uri == null) {
            throw new IllegalArgumentException();
        }
        String scheme = uri.getScheme();
        if ("content".equals(scheme)) {
            m16515b(context, uri);
        } else if ("file".equals(scheme)) {
            m16513a(context, uri);
        }
        this.f15780j = m16511a(uri, context);
        if (TextUtils.isEmpty(this.f15776f)) {
            throw new IllegalArgumentException();
        }
        this.f15777g = this.f15776f.substring(this.f15776f.lastIndexOf(47) + 1);
        if (this.f15777g.startsWith(".") && this.f15777g.length() > 1) {
            this.f15777g = this.f15777g.substring(1);
        }
        this.f15777g = this.f15777g.replace(' ', '_');
        this.f15777g = this.f15777g.replace(f15771a, f15772b);
        this.f15773c = context;
        this.f15774d = uri;
        m16519f();
    }

    /* renamed from: a */
    private void m16513a(Context context, Uri uri) {
        this.f15776f = uri.getPath();
        C3891n c3891nM15001a = C3891n.m15001a();
        String strM15002a = C3891n.m15002a(this.f15776f);
        if (TextUtils.isEmpty(strM15002a)) {
            int iLastIndexOf = this.f15776f == null ? -1 : this.f15776f.lastIndexOf(46);
            if (iLastIndexOf >= 0) {
                strM15002a = this.f15776f.substring(iLastIndexOf + 1);
            }
        }
        this.f15775e = c3891nM15001a.m15005b(strM15002a);
    }

    /* renamed from: b */
    private void m16515b(Context context, Uri uri) {
        String string;
        Cursor cursorQuery = SqliteWrapper.query(context, context.getContentResolver(), uri, (String[]) null, (String) null, (String[]) null, (String) null);
        if (cursorQuery == null) {
            throw new IllegalArgumentException("Query on " + uri + " returns null result.");
        }
        try {
            if (cursorQuery.getCount() != 1 || !cursorQuery.moveToFirst()) {
                C3890m.m14999e("Mms/image", "Query on " + uri + " returns 0 or multiple rows.");
                C3890m.m14999e("Mms/image", "cursor count = " + cursorQuery.getCount());
                if (!cursorQuery.moveToFirst()) {
                    throw new IllegalArgumentException("Query on " + uri + " returns 0 or multiple rows.");
                }
            }
            if (uri != null && AbstractC3863i.m14799b(uri)) {
                string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("fn"));
                if (TextUtils.isEmpty(string)) {
                    string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data"));
                }
                this.f15775e = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("ct"));
            } else {
                if (uri != null && m16514a(uri)) {
                    string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data"));
                } else {
                    string = cursorQuery.getString(0);
                }
                this.f15775e = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("mime_type"));
            }
            this.f15776f = string;
        } finally {
            cursorQuery.close();
        }
    }

    /* renamed from: f */
    private void m16519f() throws IOException {
        String str;
        String str2;
        InputStream inputStream = null;
        try {
            try {
                InputStream inputStreamOpenInputStream = this.f15773c.getContentResolver().openInputStream(this.f15774d);
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeStream(inputStreamOpenInputStream, null, options);
                if (this.f15780j == 0 || this.f15780j == 180) {
                    this.f15778h = options.outWidth;
                    this.f15779i = options.outHeight;
                } else {
                    this.f15778h = options.outHeight;
                    this.f15779i = options.outWidth;
                }
                if (inputStreamOpenInputStream != null) {
                    try {
                        inputStreamOpenInputStream.close();
                    } catch (IOException e) {
                        e = e;
                        str = "Mms/image";
                        str2 = "IOException caught while closing stream";
                        C3890m.m14995a(str, str2, e);
                    }
                }
            } catch (FileNotFoundException e2) {
                C3890m.m14995a("Mms/image", "IOException caught while opening stream", e2);
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (IOException e3) {
                        e = e3;
                        str = "Mms/image";
                        str2 = "IOException caught while closing stream";
                        C3890m.m14995a(str, str2, e);
                    }
                }
            } catch (OutOfMemoryError e4) {
                C3890m.m14999e("Mms/image", "OutOfMemoryError" + e4);
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (IOException e5) {
                        e = e5;
                        str = "Mms/image";
                        str2 = "IOException caught while closing stream";
                        C3890m.m14995a(str, str2, e);
                    }
                }
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    inputStream.close();
                } catch (IOException e6) {
                    C3890m.m14995a("Mms/image", "IOException caught while closing stream", e6);
                }
            }
            throw th;
        }
    }

    /* renamed from: a */
    public String m16521a() {
        return this.f15775e;
    }

    /* renamed from: b */
    public String m16522b() {
        return this.f15777g;
    }

    /* renamed from: c */
    public int m16523c() {
        return this.f15778h;
    }

    /* renamed from: d */
    public int m16524d() {
        return this.f15779i;
    }

    /* renamed from: e */
    public int m16525e() {
        return this.f15780j;
    }

    /* renamed from: a */
    public C5094q m16520a(int i, int i2, int i3) throws IOException {
        C5094q c5094q = new C5094q();
        byte[] bArrM16517b = m16517b(i, i2, i3);
        if (bArrM16517b == null) {
            return null;
        }
        c5094q.m19381a(bArrM16517b);
        c5094q.m19389e("image/jpeg".getBytes());
        String strM16522b = m16522b();
        byte[] bytes = strM16522b.getBytes();
        c5094q.m19385c(bytes);
        c5094q.m19395h(bytes);
        int iLastIndexOf = strM16522b.lastIndexOf(46);
        if (iLastIndexOf != -1 && iLastIndexOf != 0) {
            bytes = strM16522b.substring(0, iLastIndexOf).getBytes();
        }
        c5094q.m19384b(bytes);
        return c5094q;
    }

    /* JADX WARN: Code restructure failed: missing block: B:133:0x0247, code lost:
    
        r6 = r5;
     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x02f2 A[Catch: FileNotFoundException -> 0x014e, OutOfMemoryError -> 0x018d, TryCatch #2 {FileNotFoundException -> 0x014e, blocks: (B:12:0x009c, B:13:0x00a4, B:16:0x00bb, B:19:0x00e8, B:48:0x019c, B:55:0x01af, B:57:0x01b7, B:60:0x01c1, B:73:0x0215, B:75:0x0221, B:76:0x0226, B:80:0x0247, B:81:0x024c, B:87:0x02aa, B:91:0x02d3, B:95:0x02de, B:109:0x0375, B:99:0x02e7, B:101:0x02f2, B:104:0x030f, B:108:0x0370, B:105:0x034a, B:107:0x0353, B:62:0x01c9, B:64:0x01da, B:65:0x01ff, B:113:0x0389, B:29:0x0111, B:32:0x013e, B:35:0x0143, B:40:0x015c, B:43:0x0189, B:44:0x018c, B:111:0x037c), top: B:124:0x009c }] */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0398 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01c9 A[Catch: FileNotFoundException -> 0x014e, OutOfMemoryError -> 0x0352, TryCatch #2 {FileNotFoundException -> 0x014e, blocks: (B:12:0x009c, B:13:0x00a4, B:16:0x00bb, B:19:0x00e8, B:48:0x019c, B:55:0x01af, B:57:0x01b7, B:60:0x01c1, B:73:0x0215, B:75:0x0221, B:76:0x0226, B:80:0x0247, B:81:0x024c, B:87:0x02aa, B:91:0x02d3, B:95:0x02de, B:109:0x0375, B:99:0x02e7, B:101:0x02f2, B:104:0x030f, B:108:0x0370, B:105:0x034a, B:107:0x0353, B:62:0x01c9, B:64:0x01da, B:65:0x01ff, B:113:0x0389, B:29:0x0111, B:32:0x013e, B:35:0x0143, B:40:0x015c, B:43:0x0189, B:44:0x018c, B:111:0x037c), top: B:124:0x009c }] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x02d1 A[ADDED_TO_REGION] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private byte[] m16517b(int r18, int r19, int r20) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 934
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.smsplugin.p112ui.C4342jh.m16517b(int, int, int):byte[]");
    }

    /* renamed from: a */
    private Bitmap m16512a(Bitmap bitmap, int i) {
        Bitmap bitmapCreateBitmap;
        C3890m.m14996b("Mms/image", "getRotatedBitmap");
        if (bitmap == null) {
            return null;
        }
        try {
            Matrix matrix = new Matrix();
            matrix.postRotate(i);
            bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (OutOfMemoryError e) {
            C3890m.m14999e("Mms/image", "OutOfMemoryError" + e);
            bitmapCreateBitmap = null;
        }
        return bitmapCreateBitmap;
    }

    /* renamed from: a */
    private static boolean m16514a(Uri uri) {
        String authority = uri.getAuthority();
        return "content".equals(uri.getScheme()) && authority != null && authority.startsWith("media");
    }

    /* renamed from: b */
    private static boolean m16516b(Uri uri) {
        String authority = uri.getAuthority();
        return "content".equals(uri.getScheme()) && authority != null && (authority.startsWith("mms") || authority.startsWith(C4012bp.f14467c));
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0056  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int m16511a(android.net.Uri r9, android.content.Context r10) throws java.lang.Throwable {
        /*
            r8 = 0
            r7 = 0
            if (r9 == 0) goto L44
            boolean r0 = m16514a(r9)
            if (r0 == 0) goto L44
            android.content.ContentResolver r1 = r10.getContentResolver()     // Catch: java.lang.Exception -> L33 java.lang.Throwable -> L3c
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r0 = r10
            r2 = r9
            android.database.Cursor r1 = android.database.sqlite.SqliteWrapper.query(r0, r1, r2, r3, r4, r5, r6)     // Catch: java.lang.Exception -> L33 java.lang.Throwable -> L3c
            if (r1 == 0) goto L56
            boolean r0 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            if (r0 == 0) goto L56
            java.lang.String r0 = "orientation"
            int r0 = r1.getColumnIndexOrThrow(r0)     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            int r7 = r1.getInt(r0)     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            r0 = r7
        L2c:
            if (r1 == 0) goto L31
            r1.close()
        L31:
            r7 = r0
        L32:
            return r7
        L33:
            r0 = move-exception
            r0 = r8
        L35:
            if (r0 == 0) goto L3a
            r0.close()
        L3a:
            r0 = r7
            goto L31
        L3c:
            r0 = move-exception
            r1 = r8
        L3e:
            if (r1 == 0) goto L43
            r1.close()
        L43:
            throw r0
        L44:
            if (r9 == 0) goto L32
            boolean r0 = m16516b(r9)
            if (r0 != 0) goto L32
            int r7 = m16518c(r9)
            goto L32
        L51:
            r0 = move-exception
            goto L3e
        L53:
            r0 = move-exception
            r0 = r1
            goto L35
        L56:
            r0 = r7
            goto L2c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.smsplugin.p112ui.C4342jh.m16511a(android.net.Uri, android.content.Context):int");
    }

    /* renamed from: c */
    private static int m16518c(Uri uri) {
        String string;
        int iIntValue;
        if ("file".equals(uri.getScheme())) {
            string = uri.getPath();
        } else {
            string = uri.toString();
        }
        try {
            ExifInterface exifInterface = new ExifInterface(string);
            if (exifInterface == null) {
                return 0;
            }
            try {
                iIntValue = Integer.valueOf(exifInterface.getAttribute("Orientation")).intValue();
            } catch (NumberFormatException e) {
                iIntValue = -1;
            }
            if (iIntValue == -1) {
                return 0;
            }
            switch (iIntValue) {
            }
            return 0;
        } catch (IOException e2) {
            C3890m.m14995a("Mms/image", "can not read exif", e2);
            return 0;
        }
    }
}
