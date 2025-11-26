package com.samsung.samm.lib.p003a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;

/* renamed from: com.samsung.samm.lib.a.p */
/* loaded from: classes.dex */
public class C0902p {
    /* JADX WARN: Removed duplicated region for block: B:29:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x002d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0036 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m576a(java.lang.String r6, android.graphics.Bitmap r7) throws java.io.IOException {
        /*
            r2 = 1
            r1 = 0
            if (r6 == 0) goto L6
            if (r7 != 0) goto L7
        L6:
            return r1
        L7:
            java.io.File r3 = new java.io.File
            r3.<init>(r6)
            boolean r0 = r3.exists()
            if (r0 == 0) goto L18
            boolean r0 = r3.delete()
            if (r0 == 0) goto L6
        L18:
            boolean r0 = r3.createNewFile()     // Catch: java.io.IOException -> L41
        L1c:
            r5 = 0
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch: java.lang.Exception -> L47
            r4.<init>(r3)     // Catch: java.lang.Exception -> L47
            android.graphics.Bitmap$CompressFormat r3 = android.graphics.Bitmap.CompressFormat.PNG     // Catch: java.lang.Exception -> L72
            r5 = 100
            boolean r3 = r7.compress(r3, r5, r4)     // Catch: java.lang.Exception -> L72
            r5 = r3
        L2b:
            if (r4 == 0) goto L4e
            r4.flush()     // Catch: java.io.IOException -> L50 java.lang.Throwable -> L61
            r4.close()     // Catch: java.io.IOException -> L50 java.lang.Throwable -> L61
            r3 = r2
        L34:
            if (r4 == 0) goto L39
            r4.close()     // Catch: java.io.IOException -> L6d
        L39:
            if (r0 == 0) goto L6
            if (r5 == 0) goto L6
            if (r3 == 0) goto L6
            r1 = r2
            goto L6
        L41:
            r0 = move-exception
            r0.printStackTrace()
            r0 = r1
            goto L1c
        L47:
            r3 = move-exception
            r4 = r5
        L49:
            r3.printStackTrace()
            r5 = r1
            goto L2b
        L4e:
            r3 = r1
            goto L34
        L50:
            r3 = move-exception
            r3.printStackTrace()     // Catch: java.lang.Throwable -> L61
            if (r4 == 0) goto L74
            r4.close()     // Catch: java.io.IOException -> L5b
            r3 = r1
            goto L39
        L5b:
            r3 = move-exception
            r3.printStackTrace()
            r3 = r1
            goto L39
        L61:
            r0 = move-exception
            if (r4 == 0) goto L67
            r4.close()     // Catch: java.io.IOException -> L68
        L67:
            throw r0
        L68:
            r1 = move-exception
            r1.printStackTrace()
            goto L67
        L6d:
            r4 = move-exception
            r4.printStackTrace()
            goto L39
        L72:
            r3 = move-exception
            goto L49
        L74:
            r3 = r1
            goto L39
        */
        throw new UnsupportedOperationException("Method not decompiled: com.samsung.samm.lib.p003a.C0902p.m576a(java.lang.String, android.graphics.Bitmap):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x003f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0036 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m577a(java.lang.String r7, android.graphics.Bitmap r8, int r9) throws java.io.IOException {
        /*
            r0 = 10
            r2 = 1
            r3 = 100
            r1 = 0
            if (r7 == 0) goto La
            if (r8 != 0) goto Lb
        La:
            return r1
        Lb:
            if (r9 < 0) goto La
            if (r9 > r3) goto La
            java.io.File r6 = new java.io.File
            r6.<init>(r7)
            boolean r4 = r6.exists()
            if (r4 == 0) goto L20
            boolean r4 = r6.delete()
            if (r4 == 0) goto La
        L20:
            if (r9 >= r0) goto L4a
            r9 = r0
        L23:
            boolean r0 = r6.createNewFile()     // Catch: java.io.IOException -> L4e
        L27:
            r5 = 0
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch: java.lang.Exception -> L54
            r4.<init>(r6)     // Catch: java.lang.Exception -> L54
            android.graphics.Bitmap$CompressFormat r3 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch: java.lang.Exception -> L7f
            boolean r3 = r8.compress(r3, r9, r4)     // Catch: java.lang.Exception -> L7f
            r5 = r3
        L34:
            if (r4 == 0) goto L5b
            r4.flush()     // Catch: java.io.IOException -> L5d java.lang.Throwable -> L6e
            r4.close()     // Catch: java.io.IOException -> L5d java.lang.Throwable -> L6e
            r3 = r2
        L3d:
            if (r4 == 0) goto L42
            r4.close()     // Catch: java.io.IOException -> L7a
        L42:
            if (r0 == 0) goto La
            if (r5 == 0) goto La
            if (r3 == 0) goto La
            r1 = r2
            goto La
        L4a:
            if (r9 <= r3) goto L23
            r9 = r3
            goto L23
        L4e:
            r0 = move-exception
            r0.printStackTrace()
            r0 = r1
            goto L27
        L54:
            r3 = move-exception
            r4 = r5
        L56:
            r3.printStackTrace()
            r5 = r1
            goto L34
        L5b:
            r3 = r1
            goto L3d
        L5d:
            r3 = move-exception
            r3.printStackTrace()     // Catch: java.lang.Throwable -> L6e
            if (r4 == 0) goto L81
            r4.close()     // Catch: java.io.IOException -> L68
            r3 = r1
            goto L42
        L68:
            r3 = move-exception
            r3.printStackTrace()
            r3 = r1
            goto L42
        L6e:
            r0 = move-exception
            if (r4 == 0) goto L74
            r4.close()     // Catch: java.io.IOException -> L75
        L74:
            throw r0
        L75:
            r1 = move-exception
            r1.printStackTrace()
            goto L74
        L7a:
            r4 = move-exception
            r4.printStackTrace()
            goto L42
        L7f:
            r3 = move-exception
            goto L56
        L81:
            r3 = r1
            goto L42
        */
        throw new UnsupportedOperationException("Method not decompiled: com.samsung.samm.lib.p003a.C0902p.m577a(java.lang.String, android.graphics.Bitmap, int):boolean");
    }

    /* renamed from: a */
    public static Bitmap m574a(String str, int i, int i2) {
        BitmapFactory.Options optionsM575a = m575a(str);
        if (optionsM575a == null) {
            return null;
        }
        int iM572a = m572a(optionsM575a.outWidth, optionsM575a.outHeight, i, i2);
        optionsM575a.inJustDecodeBounds = false;
        optionsM575a.inSampleSize = iM572a;
        optionsM575a.inDither = false;
        optionsM575a.inPreferredConfig = Bitmap.Config.ARGB_8888;
        optionsM575a.inPurgeable = true;
        return BitmapFactory.decodeFile(str, optionsM575a);
    }

    /* renamed from: a */
    public static BitmapFactory.Options m575a(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        return options;
    }

    /* renamed from: a */
    public static int m572a(int i, int i2, int i3, int i4) {
        float f = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
        if (i <= i3 && i2 <= i4) {
            return 1;
        }
        float f2 = i > i3 ? i / i3 : 0.0f;
        if (i2 > i4) {
            f = i2 / i4;
        }
        if (f2 < f) {
            f2 = f;
        }
        return (int) f2;
    }

    /* renamed from: a */
    public static Bitmap m573a(Bitmap bitmap, int i, int i2) {
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width < 0 || height < 0) {
            return null;
        }
        if (width > i || height > i2) {
            float f = i / width;
            float f2 = i2 / height;
            if (f <= f2) {
                i2 = (int) (f * height);
            } else {
                i = (int) (width * f2);
            }
            return Bitmap.createScaledBitmap(bitmap, i, i2, true);
        }
        return bitmap;
    }

    /* renamed from: b */
    public static boolean m578b(String str) {
        if (str == null) {
            return false;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        return options.outMimeType != null;
    }
}
