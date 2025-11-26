package com.sec.chaton.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.ExifInterface;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.Display;
import android.view.WindowManager;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: ChatOnGraphics.java */
/* renamed from: com.sec.chaton.util.w */
/* loaded from: classes.dex */
public class C1791w {

    /* renamed from: a */
    public static final int[] f6464a = {0, 270, 180, 90};

    /* renamed from: a */
    public static ByteArrayOutputStream m6093a(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        return byteArrayOutputStream;
    }

    /* renamed from: a */
    public static Bitmap m6088a(Context context, Uri uri, int i) throws IOException {
        InputStream inputStreamOpenInputStream;
        Bitmap bitmapDecodeStream = null;
        BitmapFactory.Options options = new BitmapFactory.Options();
        int iLog = 8;
        int i2 = i;
        do {
            if (bitmapDecodeStream != null && !bitmapDecodeStream.isRecycled()) {
                bitmapDecodeStream.recycle();
            }
            if (iLog == 0) {
                i2 = 0;
            }
            inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
            options.inSampleSize = (int) Math.pow(2.0d, iLog);
            try {
                bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpenInputStream, null, options);
                if (bitmapDecodeStream != null) {
                    iLog = iLog > 0 ? iLog - ((int) (Math.log(i2 / (bitmapDecodeStream.getWidth() > bitmapDecodeStream.getHeight() ? bitmapDecodeStream.getWidth() : bitmapDecodeStream.getHeight())) / Math.log(2.0d))) : 0;
                    if (i2 <= 0 || bitmapDecodeStream.getWidth() >= i2 / 2) {
                        break;
                    }
                } else {
                    return null;
                }
            } catch (OutOfMemoryError e) {
                return null;
            }
        } while (bitmapDecodeStream.getHeight() < i2 / 2);
        inputStreamOpenInputStream.close();
        return bitmapDecodeStream;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0042 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m6096a(android.graphics.Bitmap r3, java.io.File r4, java.lang.String r5, android.graphics.Bitmap.CompressFormat r6, int r7) throws java.lang.Throwable {
        /*
            if (r3 != 0) goto L3
        L2:
            return
        L3:
            boolean r0 = r4.exists()
            if (r0 != 0) goto L12
            boolean r0 = r4.mkdirs()
            if (r0 != 0) goto L12
            r4.mkdir()
        L12:
            java.io.File r0 = new java.io.File
            r0.<init>(r4, r5)
            r2 = 0
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch: java.io.FileNotFoundException -> L2d java.lang.Throwable -> L3e
            r1.<init>(r0)     // Catch: java.io.FileNotFoundException -> L2d java.lang.Throwable -> L3e
            r3.compress(r6, r7, r1)     // Catch: java.lang.Throwable -> L4d java.io.FileNotFoundException -> L4f
            if (r1 == 0) goto L2
            r1.close()     // Catch: java.lang.Exception -> L26
            goto L2
        L26:
            r0 = move-exception
            java.lang.String r1 = "ChatOnGraphics"
        L29:
            com.sec.chaton.util.C1786r.m6056a(r0, r1)
            goto L2
        L2d:
            r0 = move-exception
            r1 = r2
        L2f:
            java.lang.String r2 = "ChatOnGraphics"
            com.sec.chaton.util.C1786r.m6056a(r0, r2)     // Catch: java.lang.Throwable -> L4d
            if (r1 == 0) goto L2
            r1.close()     // Catch: java.lang.Exception -> L3a
            goto L2
        L3a:
            r0 = move-exception
            java.lang.String r1 = "ChatOnGraphics"
            goto L29
        L3e:
            r0 = move-exception
            r1 = r2
        L40:
            if (r1 == 0) goto L45
            r1.close()     // Catch: java.lang.Exception -> L46
        L45:
            throw r0
        L46:
            r1 = move-exception
            java.lang.String r2 = "ChatOnGraphics"
            com.sec.chaton.util.C1786r.m6056a(r1, r2)
            goto L45
        L4d:
            r0 = move-exception
            goto L40
        L4f:
            r0 = move-exception
            goto L2f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.util.C1791w.m6096a(android.graphics.Bitmap, java.io.File, java.lang.String, android.graphics.Bitmap$CompressFormat, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0033 A[PHI: r0 r2
  0x0033: PHI (r0v6 android.net.Uri) = (r0v0 android.net.Uri), (r0v8 android.net.Uri) binds: [B:14:0x003e, B:8:0x0031] A[DONT_GENERATE, DONT_INLINE]
  0x0033: PHI (r2v5 java.io.FileOutputStream) = (r2v4 java.io.FileOutputStream), (r2v10 java.io.FileOutputStream) binds: [B:14:0x003e, B:8:0x0031] A[DONT_GENERATE, DONT_INLINE]] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.net.Uri m6092a(java.io.ByteArrayOutputStream r4, java.lang.String r5, java.lang.String r6) throws java.lang.Throwable {
        /*
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch: java.lang.Exception -> L37 java.lang.Throwable -> L41
            android.content.Context r2 = com.sec.chaton.global.GlobalApplication.m3260b()     // Catch: java.lang.Exception -> L37 java.lang.Throwable -> L41
            r3 = 0
            java.io.File r2 = r2.getExternalFilesDir(r3)     // Catch: java.lang.Exception -> L37 java.lang.Throwable -> L41
            java.lang.String r2 = r2.getAbsolutePath()     // Catch: java.lang.Exception -> L37 java.lang.Throwable -> L41
            r1.<init>(r2, r5)     // Catch: java.lang.Exception -> L37 java.lang.Throwable -> L41
            boolean r2 = r1.canRead()     // Catch: java.lang.Exception -> L37 java.lang.Throwable -> L41
            if (r2 != 0) goto L1c
            r1.mkdir()     // Catch: java.lang.Exception -> L37 java.lang.Throwable -> L41
        L1c:
            java.io.File r3 = new java.io.File     // Catch: java.lang.Exception -> L37 java.lang.Throwable -> L41
            r3.<init>(r1, r6)     // Catch: java.lang.Exception -> L37 java.lang.Throwable -> L41
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch: java.lang.Exception -> L37 java.lang.Throwable -> L41
            r2.<init>(r3)     // Catch: java.lang.Exception -> L37 java.lang.Throwable -> L41
            byte[] r1 = r4.toByteArray()     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4c
            r2.write(r1)     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4c
            android.net.Uri r0 = android.net.Uri.fromFile(r3)     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4c
            if (r2 == 0) goto L36
        L33:
            r2.close()
        L36:
            return r0
        L37:
            r1 = move-exception
            r2 = r0
        L39:
            java.lang.String r3 = "ChatOnGraphics"
            com.sec.chaton.util.C1786r.m6056a(r1, r3)     // Catch: java.lang.Throwable -> L4a
            if (r2 == 0) goto L36
            goto L33
        L41:
            r1 = move-exception
            r2 = r0
            r0 = r1
        L44:
            if (r2 == 0) goto L49
            r2.close()
        L49:
            throw r0
        L4a:
            r0 = move-exception
            goto L44
        L4c:
            r1 = move-exception
            goto L39
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.util.C1791w.m6092a(java.io.ByteArrayOutputStream, java.lang.String, java.lang.String):android.net.Uri");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x003f A[PHI: r0 r2
  0x003f: PHI (r0v6 android.net.Uri) = (r0v0 android.net.Uri), (r0v8 android.net.Uri) binds: [B:11:0x004a, B:5:0x003d] A[DONT_GENERATE, DONT_INLINE]
  0x003f: PHI (r2v6 java.io.FileOutputStream) = (r2v4 java.io.FileOutputStream), (r2v13 java.io.FileOutputStream) binds: [B:11:0x004a, B:5:0x003d] A[DONT_GENERATE, DONT_INLINE]] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.net.Uri m6091a(java.io.ByteArrayOutputStream r4, java.lang.String r5) throws java.lang.Throwable {
        /*
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch: java.lang.Exception -> L43 java.lang.Throwable -> L4d
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L43 java.lang.Throwable -> L4d
            r2.<init>()     // Catch: java.lang.Exception -> L43 java.lang.Throwable -> L4d
            android.content.Context r3 = com.sec.chaton.global.GlobalApplication.m3260b()     // Catch: java.lang.Exception -> L43 java.lang.Throwable -> L4d
            java.io.File r3 = r3.getFilesDir()     // Catch: java.lang.Exception -> L43 java.lang.Throwable -> L4d
            java.io.File r3 = r3.getAbsoluteFile()     // Catch: java.lang.Exception -> L43 java.lang.Throwable -> L4d
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Exception -> L43 java.lang.Throwable -> L4d
            java.lang.String r3 = "/"
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Exception -> L43 java.lang.Throwable -> L4d
            java.lang.StringBuilder r2 = r2.append(r5)     // Catch: java.lang.Exception -> L43 java.lang.Throwable -> L4d
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Exception -> L43 java.lang.Throwable -> L4d
            r1.<init>(r2)     // Catch: java.lang.Exception -> L43 java.lang.Throwable -> L4d
            android.content.Context r2 = com.sec.chaton.global.GlobalApplication.m3260b()     // Catch: java.lang.Exception -> L43 java.lang.Throwable -> L4d
            r3 = 0
            java.io.FileOutputStream r2 = r2.openFileOutput(r5, r3)     // Catch: java.lang.Exception -> L43 java.lang.Throwable -> L4d
            byte[] r3 = r4.toByteArray()     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L58
            r2.write(r3)     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L58
            android.net.Uri r0 = android.net.Uri.fromFile(r1)     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L58
            if (r2 == 0) goto L42
        L3f:
            r2.close()
        L42:
            return r0
        L43:
            r1 = move-exception
            r2 = r0
        L45:
            java.lang.String r3 = "ChatOnGraphics"
            com.sec.chaton.util.C1786r.m6056a(r1, r3)     // Catch: java.lang.Throwable -> L56
            if (r2 == 0) goto L42
            goto L3f
        L4d:
            r1 = move-exception
            r2 = r0
            r0 = r1
        L50:
            if (r2 == 0) goto L55
            r2.close()
        L55:
            throw r0
        L56:
            r0 = move-exception
            goto L50
        L58:
            r1 = move-exception
            goto L45
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.util.C1791w.m6091a(java.io.ByteArrayOutputStream, java.lang.String):android.net.Uri");
    }

    /* renamed from: a */
    public static Bitmap m6089a(Context context, String str) {
        Boolean boolValueOf;
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            BitmapFactory.decodeFile(str, options);
            options.inSampleSize = 1;
            int i = options.outWidth >> 1;
            for (int i2 = options.outHeight >> 1; i > defaultDisplay.getWidth() && i2 > defaultDisplay.getHeight(); i2 >>= 1) {
                options.inSampleSize <<= 1;
                i >>= 1;
            }
            options.inJustDecodeBounds = false;
            options.inDither = true;
            options.inPurgeable = true;
            Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(str, options);
            if (bitmapDecodeFile == null) {
                return null;
            }
            try {
                String attribute = new ExifInterface(str).getAttribute("Orientation");
                Matrix matrix = new Matrix();
                Boolean.valueOf(false);
                if ("6".equals(attribute)) {
                    boolValueOf = Boolean.valueOf(matrix.postRotate(90.0f));
                } else if ("3".equals(attribute)) {
                    boolValueOf = Boolean.valueOf(matrix.postRotate(180.0f));
                } else if ("8".equals(attribute)) {
                    boolValueOf = Boolean.valueOf(matrix.postRotate(270.0f));
                } else {
                    boolValueOf = false;
                }
                if (boolValueOf.booleanValue()) {
                    Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmapDecodeFile, 0, 0, bitmapDecodeFile.getWidth(), bitmapDecodeFile.getHeight(), matrix, true);
                    if (bitmapDecodeFile == null) {
                        return bitmapCreateBitmap;
                    }
                    bitmapDecodeFile.recycle();
                    return bitmapCreateBitmap;
                }
                return bitmapDecodeFile;
            } catch (IOException e) {
                C1786r.m6056a(e, context.getClass().getName());
                return null;
            }
        } catch (Exception e2) {
            C1786r.m6056a(e2, context.getClass().getName());
            return null;
        }
    }

    /* renamed from: a */
    public static Bitmap m6086a(Context context, Uri uri) {
        Boolean boolValueOf;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inDither = true;
        options.inPurgeable = true;
        Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(uri.toString(), options);
        try {
            String attribute = new ExifInterface(uri.getPath()).getAttribute("Orientation");
            Matrix matrix = new Matrix();
            Boolean.valueOf(false);
            if ("6".equals(attribute)) {
                boolValueOf = Boolean.valueOf(matrix.postRotate(90.0f));
            } else if ("3".equals(attribute)) {
                boolValueOf = Boolean.valueOf(matrix.postRotate(180.0f));
            } else if ("8".equals(attribute)) {
                boolValueOf = Boolean.valueOf(matrix.postRotate(270.0f));
            } else {
                boolValueOf = false;
            }
            if (boolValueOf.booleanValue()) {
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmapDecodeFile, 0, 0, bitmapDecodeFile.getWidth(), bitmapDecodeFile.getHeight(), matrix, true);
                bitmapDecodeFile.recycle();
                return bitmapCreateBitmap;
            }
            return bitmapDecodeFile;
        } catch (IOException e) {
            C1786r.m6056a(e, "ChatOnGraphics");
            return null;
        }
    }

    /* renamed from: b */
    public static Bitmap m6099b(Context context, Uri uri) {
        return m6087a(context, uri, 170.0f);
    }

    /* renamed from: a */
    public static Bitmap m6087a(Context context, Uri uri, float f) {
        Boolean boolValueOf;
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(uri.getPath(), options);
            options.inSampleSize = 1;
            int i = options.outWidth >> 1;
            for (int i2 = options.outHeight >> 1; i > f && i2 > f; i2 >>= 1) {
                options.inSampleSize <<= 1;
                i >>= 1;
            }
            options.inJustDecodeBounds = false;
            options.inDither = true;
            options.inPurgeable = true;
            Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(uri.getPath(), options);
            if (bitmapDecodeFile == null) {
                C1786r.m6061b("[thumbnailFromUri2] Can NOT decode a file", context.getClass().getName());
                return null;
            }
            Bitmap bitmapExtractThumbnail = ThumbnailUtils.extractThumbnail(bitmapDecodeFile, 170, 170);
            if (bitmapExtractThumbnail != bitmapDecodeFile && bitmapDecodeFile != null) {
                bitmapDecodeFile.recycle();
            }
            if (bitmapExtractThumbnail == null) {
                C1786r.m6061b("[thumbnailFromUri2] Can NOT make a thumbnail", context.getClass().getName());
                return null;
            }
            try {
                String attribute = new ExifInterface(uri.getPath()).getAttribute("Orientation");
                Matrix matrix = new Matrix();
                Boolean.valueOf(false);
                if ("6".equals(attribute)) {
                    boolValueOf = Boolean.valueOf(matrix.postRotate(90.0f));
                } else if ("3".equals(attribute)) {
                    boolValueOf = Boolean.valueOf(matrix.postRotate(180.0f));
                } else if ("8".equals(attribute)) {
                    boolValueOf = Boolean.valueOf(matrix.postRotate(270.0f));
                } else {
                    boolValueOf = false;
                }
                if (boolValueOf.booleanValue()) {
                    Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmapExtractThumbnail, 0, 0, bitmapExtractThumbnail.getWidth(), bitmapExtractThumbnail.getHeight(), matrix, true);
                    if (bitmapExtractThumbnail == null) {
                        return bitmapCreateBitmap;
                    }
                    bitmapExtractThumbnail.recycle();
                    return bitmapCreateBitmap;
                }
                return bitmapExtractThumbnail;
            } catch (IOException e) {
                e.printStackTrace();
                C1786r.m6056a(e, "ChatOnGraphics");
                return null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            C1786r.m6056a(e2, "ChatOnGraphics");
            return null;
        }
    }

    /* renamed from: a */
    public static Bitmap m6085a(Context context, Bitmap bitmap) throws Resources.NotFoundException {
        float f = context.getResources().getDisplayMetrics().scaledDensity;
        if (bitmap == null && (bitmap = m6090a(context.getResources(), R.drawable.chaton_shortcut_default)) == null) {
            return null;
        }
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.app_icon_base_size);
        int dimensionPixelSize2 = context.getResources().getDimensionPixelSize(R.dimen.app_icon_size);
        C1786r.m6066e("IConSize : " + dimensionPixelSize2 + ", BaseIConsSize : " + dimensionPixelSize, "ChatOnGraphics");
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(dimensionPixelSize2, dimensionPixelSize2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint();
        paint.setDither(true);
        paint.setFilterBitmap(true);
        int dimensionPixelSize3 = context.getResources().getDimensionPixelSize(R.dimen.shortcut_position_x);
        canvas.drawBitmap(bitmap, new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), new Rect(dimensionPixelSize3, context.getResources().getDimensionPixelSize(R.dimen.shortcut_position_y), dimensionPixelSize2 - dimensionPixelSize3, dimensionPixelSize2 - context.getResources().getDimensionPixelSize(R.dimen.shortcut_bottom_margin)), paint);
        Bitmap bitmapM6090a = m6090a(context.getResources(), R.drawable.chaton_shortcut);
        if (bitmapM6090a != null) {
            canvas.drawBitmap(bitmapM6090a, new Rect(0, 0, bitmapM6090a.getWidth(), bitmapM6090a.getHeight()), new Rect(0, 0, dimensionPixelSize2, dimensionPixelSize2), paint);
            return bitmapCreateBitmap;
        }
        return bitmapCreateBitmap;
    }

    /* renamed from: a */
    private static Bitmap m6090a(Resources resources, int i) throws Resources.NotFoundException {
        Drawable drawable = resources.getDrawable(i);
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        return null;
    }

    /* renamed from: a */
    public static String m6095a(Context context, byte[] bArr, int i) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        int iLog = 8;
        Bitmap bitmapDecodeByteArray = null;
        int i2 = i;
        do {
            if (bitmapDecodeByteArray != null && !bitmapDecodeByteArray.isRecycled()) {
                bitmapDecodeByteArray.recycle();
                System.gc();
            }
            if (iLog == 0) {
                i2 = 0;
            }
            options.inSampleSize = (int) Math.pow(2.0d, iLog);
            bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            if (bitmapDecodeByteArray != null) {
                C1786r.m6064d("BitmapFromUri: " + iLog + ", " + bitmapDecodeByteArray.getHeight() + ", " + bitmapDecodeByteArray.getWidth());
                iLog = iLog > 0 ? iLog - ((int) (Math.log(i2 / (bitmapDecodeByteArray.getWidth() > bitmapDecodeByteArray.getHeight() ? bitmapDecodeByteArray.getWidth() : bitmapDecodeByteArray.getHeight())) / Math.log(2.0d))) : 0;
                if (i2 <= 0 || bitmapDecodeByteArray.getWidth() >= i2 / 2) {
                    break;
                }
            } else {
                return null;
            }
        } while (bitmapDecodeByteArray.getHeight() < i2 / 2);
        return MediaStore.Images.Media.insertImage(context.getContentResolver(), bitmapDecodeByteArray, "m&Talk", "");
    }

    /* renamed from: b */
    public static Bitmap m6100b(Context context, Uri uri, int i) throws IOException {
        Bitmap bitmapDecodeStream;
        File file = new File(uri.toString());
        BitmapFactory.Options options = new BitmapFactory.Options();
        FileInputStream fileInputStream = null;
        Bitmap bitmap = null;
        int iLog = 8;
        int i2 = i;
        while (true) {
            if (bitmap != null && !bitmap.isRecycled()) {
                bitmap.recycle();
            }
            int i3 = iLog == 0 ? 0 : i2;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            fileInputStream = new FileInputStream(file);
            options.inSampleSize = (int) Math.pow(2.0d, iLog);
            try {
                bitmapDecodeStream = BitmapFactory.decodeStream(fileInputStream, null, options);
                if (bitmapDecodeStream == null) {
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    return null;
                }
                iLog = iLog > 0 ? iLog - ((int) (Math.log(i3 / (bitmapDecodeStream.getWidth() > bitmapDecodeStream.getHeight() ? bitmapDecodeStream.getWidth() : bitmapDecodeStream.getHeight())) / Math.log(2.0d))) : 0;
                if (i3 <= 0 || bitmapDecodeStream.getWidth() >= i3 / 2 || bitmapDecodeStream.getHeight() >= i3 / 2) {
                    break;
                }
                i2 = i3;
                bitmap = bitmapDecodeStream;
            } catch (OutOfMemoryError e2) {
                return null;
            }
        }
        if (fileInputStream != null) {
            try {
                fileInputStream.close();
                return bitmapDecodeStream;
            } catch (IOException e3) {
                e3.printStackTrace();
                return bitmapDecodeStream;
            }
        }
        return bitmapDecodeStream;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:105:0x00d8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00dd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v10, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v31, types: [java.io.FileOutputStream, java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r4v7, types: [android.graphics.Bitmap] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.io.File m6094a(android.content.Context r11, java.io.File r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 396
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.util.C1791w.m6094a(android.content.Context, java.io.File):java.io.File");
    }

    /* renamed from: a */
    public static void m6097a(String str, InterfaceC1731an interfaceC1731an) {
        String strM5955d = C1746bb.m5955d(str);
        C1786r.m6066e("[getBigProfile] : " + strM5955d, "ChatOnGraphics");
        C1726ai.m5903a().m5909a(str, strM5955d, "//profile", String.format("%s_big.jpeg_", str), Bitmap.CompressFormat.JPEG, interfaceC1731an);
    }

    /* renamed from: a */
    public static int m6083a(Uri uri) throws FileNotFoundException {
        int i;
        try {
            InputStream inputStreamOpenInputStream = GlobalApplication.m3260b().getContentResolver().openInputStream(uri);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(inputStreamOpenInputStream, null, options);
            int i2 = options.outWidth;
            int i3 = options.outHeight;
            C1786r.m6061b("options: width, height : " + i2 + ", " + i3, GlobalApplication.m3260b().getClass().getSimpleName());
            if (i2 >= i3) {
                i = (int) (i2 / 1024.0f);
            } else {
                i = (int) (i3 / 1024.0f);
            }
            if (i < 1) {
                return 1;
            }
            return i;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return 0;
        } catch (OutOfMemoryError e2) {
            return 0;
        }
    }

    /* renamed from: a */
    public static Bitmap m6084a(Context context, int i, int i2, int i3) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Rect rect = new Rect();
        ((Activity) context).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        int i4 = rect.top;
        try {
            new Matrix().postRotate(f6464a[defaultDisplay.getRotation()]);
            return m6100b(context, Uri.parse(new File(C1767bw.m6003b() + "/skins/") + "/skin_myskin.png_"), i);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: b */
    public static Bitmap m6098b(Context context, int i, int i2, int i3) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Rect rect = new Rect();
        ((Activity) context).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        int i4 = rect.top;
        try {
            new Matrix().postRotate(f6464a[defaultDisplay.getRotation()]);
            return m6100b(context, Uri.parse(new File(C1767bw.m6003b() + "/skins/") + "/skin_myskin.png_"), i2);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
