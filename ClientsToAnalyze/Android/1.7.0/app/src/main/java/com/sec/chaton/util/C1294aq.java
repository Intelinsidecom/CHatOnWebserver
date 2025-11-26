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
/* renamed from: com.sec.chaton.util.aq */
/* loaded from: classes.dex */
public class C1294aq {

    /* renamed from: a */
    public static final int[] f4480a = {0, 270, 180, 90};

    /* renamed from: a */
    public static ByteArrayOutputStream m4506a(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        return byteArrayOutputStream;
    }

    /* renamed from: a */
    public static Bitmap m4501a(Context context, Uri uri, int i) throws IOException {
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
            bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpenInputStream, null, options);
            if (bitmapDecodeStream != null) {
                iLog = iLog > 0 ? iLog - ((int) (Math.log(i2 / (bitmapDecodeStream.getWidth() > bitmapDecodeStream.getHeight() ? bitmapDecodeStream.getWidth() : bitmapDecodeStream.getHeight())) / Math.log(2.0d))) : 0;
                if (i2 <= 0 || bitmapDecodeStream.getWidth() >= i2 / 2) {
                    break;
                }
            } else {
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
    public static void m4508a(android.graphics.Bitmap r3, java.io.File r4, java.lang.String r5, android.graphics.Bitmap.CompressFormat r6, int r7) throws java.lang.Throwable {
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
            com.sec.chaton.util.C1341p.m4653a(r0, r1)
            goto L2
        L2d:
            r0 = move-exception
            r1 = r2
        L2f:
            java.lang.String r2 = "ChatOnGraphics"
            com.sec.chaton.util.C1341p.m4653a(r0, r2)     // Catch: java.lang.Throwable -> L4d
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
            com.sec.chaton.util.C1341p.m4653a(r1, r2)
            goto L45
        L4d:
            r0 = move-exception
            goto L40
        L4f:
            r0 = move-exception
            goto L2f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.util.C1294aq.m4508a(android.graphics.Bitmap, java.io.File, java.lang.String, android.graphics.Bitmap$CompressFormat, int):void");
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
    public static android.net.Uri m4505a(java.io.ByteArrayOutputStream r4, java.lang.String r5, java.lang.String r6) {
        /*
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch: java.lang.Exception -> L37 java.lang.Throwable -> L41
            android.content.Context r2 = com.sec.chaton.global.GlobalApplication.m3100a()     // Catch: java.lang.Exception -> L37 java.lang.Throwable -> L41
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
            com.sec.chaton.util.C1341p.m4653a(r1, r3)     // Catch: java.lang.Throwable -> L4a
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
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.util.C1294aq.m4505a(java.io.ByteArrayOutputStream, java.lang.String, java.lang.String):android.net.Uri");
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
    public static android.net.Uri m4504a(java.io.ByteArrayOutputStream r4, java.lang.String r5) throws java.lang.Throwable {
        /*
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch: java.lang.Exception -> L43 java.lang.Throwable -> L4d
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L43 java.lang.Throwable -> L4d
            r2.<init>()     // Catch: java.lang.Exception -> L43 java.lang.Throwable -> L4d
            android.content.Context r3 = com.sec.chaton.global.GlobalApplication.m3100a()     // Catch: java.lang.Exception -> L43 java.lang.Throwable -> L4d
            java.io.File r3 = r3.getFilesDir()     // Catch: java.lang.Exception -> L43 java.lang.Throwable -> L4d
            java.io.File r3 = r3.getAbsoluteFile()     // Catch: java.lang.Exception -> L43 java.lang.Throwable -> L4d
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Exception -> L43 java.lang.Throwable -> L4d
            java.lang.String r3 = "/"
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Exception -> L43 java.lang.Throwable -> L4d
            java.lang.StringBuilder r2 = r2.append(r5)     // Catch: java.lang.Exception -> L43 java.lang.Throwable -> L4d
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Exception -> L43 java.lang.Throwable -> L4d
            r1.<init>(r2)     // Catch: java.lang.Exception -> L43 java.lang.Throwable -> L4d
            android.content.Context r2 = com.sec.chaton.global.GlobalApplication.m3100a()     // Catch: java.lang.Exception -> L43 java.lang.Throwable -> L4d
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
            com.sec.chaton.util.C1341p.m4653a(r1, r3)     // Catch: java.lang.Throwable -> L56
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
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.util.C1294aq.m4504a(java.io.ByteArrayOutputStream, java.lang.String):android.net.Uri");
    }

    /* renamed from: a */
    public static Bitmap m4502a(Context context, String str) {
        Boolean boolValueOf;
        if (context == null) {
            return null;
        }
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
                C1341p.m4653a(e, context.getClass().getName());
                return null;
            }
        } catch (Exception e2) {
            C1341p.m4653a(e2, "ChatOnGraphics");
            return null;
        } catch (OutOfMemoryError e3) {
            C1341p.m4653a(e3, "ChatOnGraphics");
            return null;
        }
    }

    /* renamed from: a */
    public static Bitmap m4499a(Context context, Uri uri) {
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
            C1341p.m4653a(e, "ChatOnGraphics");
            return null;
        }
    }

    /* renamed from: b */
    public static Bitmap m4511b(Context context, Uri uri) {
        return m4500a(context, uri, 100.0f);
    }

    /* renamed from: a */
    public static Bitmap m4500a(Context context, Uri uri, float f) {
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
                C1341p.m4658b("[thumbnailFromUri2] Can NOT decode a file", context.getClass().getName());
                return null;
            }
            Bitmap bitmapExtractThumbnail = ThumbnailUtils.extractThumbnail(bitmapDecodeFile, 100, 100);
            if (bitmapExtractThumbnail != bitmapDecodeFile && bitmapDecodeFile != null) {
                bitmapDecodeFile.recycle();
            }
            if (bitmapExtractThumbnail == null) {
                C1341p.m4658b("[thumbnailFromUri2] Can NOT make a thumbnail", context.getClass().getName());
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
                C1341p.m4653a(e, "ChatOnGraphics");
                return null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            C1341p.m4653a(e2, "ChatOnGraphics");
            return null;
        } catch (OutOfMemoryError e3) {
            C1341p.m4653a(e3, context.getClass().getName());
            return null;
        }
    }

    /* renamed from: a */
    public static Bitmap m4497a(Context context, Bitmap bitmap) {
        return m4498a(context, bitmap, R.drawable.chaton_shortcut);
    }

    /* renamed from: a */
    public static Bitmap m4498a(Context context, Bitmap bitmap, int i) throws Resources.NotFoundException {
        float f = context.getResources().getDisplayMetrics().scaledDensity;
        if (bitmap == null && (bitmap = m4503a(context.getResources(), R.drawable.contacts_default_image)) == null) {
            return null;
        }
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.app_icon_base_size);
        int dimensionPixelSize2 = context.getResources().getDimensionPixelSize(R.dimen.app_icon_size);
        C1341p.m4662e("IConSize : " + dimensionPixelSize2 + ", BaseIConsSize : " + dimensionPixelSize, "ChatOnGraphics");
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(dimensionPixelSize2, dimensionPixelSize2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint();
        paint.setDither(true);
        paint.setFilterBitmap(true);
        int dimensionPixelSize3 = context.getResources().getDimensionPixelSize(R.dimen.shortcut_position_x);
        canvas.drawBitmap(bitmap, new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), new Rect(dimensionPixelSize3, context.getResources().getDimensionPixelSize(R.dimen.shortcut_position_y), dimensionPixelSize2 - dimensionPixelSize3, dimensionPixelSize2 - context.getResources().getDimensionPixelSize(R.dimen.shortcut_bottom_margin)), paint);
        Bitmap bitmapM4503a = m4503a(context.getResources(), i);
        if (bitmapM4503a != null) {
            canvas.drawBitmap(bitmapM4503a, new Rect(0, 0, bitmapM4503a.getWidth(), bitmapM4503a.getHeight()), new Rect(0, 0, dimensionPixelSize2, dimensionPixelSize2), paint);
            return bitmapCreateBitmap;
        }
        return bitmapCreateBitmap;
    }

    /* renamed from: a */
    private static Bitmap m4503a(Resources resources, int i) throws Resources.NotFoundException {
        Drawable drawable = resources.getDrawable(i);
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        return null;
    }

    /* renamed from: a */
    public static String m4507a(Context context, byte[] bArr, int i) {
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
                C1341p.m4659c("BitmapFromUri: " + iLog + ", " + bitmapDecodeByteArray.getHeight() + ", " + bitmapDecodeByteArray.getWidth());
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
    public static Bitmap m4512b(Context context, Uri uri, int i) throws IOException {
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
        }
        if (fileInputStream != null) {
            try {
                fileInputStream.close();
                return bitmapDecodeStream;
            } catch (IOException e2) {
                e2.printStackTrace();
                return bitmapDecodeStream;
            }
        }
        return bitmapDecodeStream;
    }

    /* renamed from: a */
    public static void m4509a(String str, InterfaceC1290am interfaceC1290am) {
        String strM4695d = C1348w.m4695d(str);
        C1341p.m4662e("[getBigProfile] : " + strM4695d, "ChatOnGraphics");
        C1308bd.m4555a().m4561a(str, strM4695d, "//profile", String.format("%s_big.jpeg_", str), Bitmap.CompressFormat.JPEG, interfaceC1290am);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.IOException] */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.io.InputStream] */
    /* renamed from: a */
    public static int m4495a(Uri uri) throws IOException {
        ?? e = 0;
        e = 0;
        int i = 1;
        try {
            try {
                e = GlobalApplication.m3100a().getContentResolver().openInputStream(uri);
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeStream(e, null, options);
                int i2 = options.outWidth;
                int i3 = options.outHeight;
                C1341p.m4658b("options: width, height : " + i2 + ", " + i3, GlobalApplication.m3100a().getClass().getSimpleName());
                e = i2 >= i3 ? (int) (i2 / 1024.0f) : (int) (i3 / 1024.0f);
                if (e >= 1) {
                    i = e;
                }
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
                i = 0;
                if (e != 0) {
                    try {
                        e.close();
                    } catch (IOException e3) {
                        e = e3;
                        e.printStackTrace();
                    }
                }
            }
            return i;
        } finally {
            if (e != 0) {
                try {
                    e.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
            }
        }
    }

    /* renamed from: a */
    public static Bitmap m4496a(Context context, int i, int i2, int i3) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Rect rect = new Rect();
        ((Activity) context).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        int i4 = rect.top;
        try {
            new Matrix().postRotate(f4480a[defaultDisplay.getRotation()]);
            return m4512b(context, Uri.parse(new File(C1327bw.m4596b() + "/skins/") + "/skin_myskin.png_"), i);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: b */
    public static Bitmap m4510b(Context context, int i, int i2, int i3) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Rect rect = new Rect();
        ((Activity) context).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        int i4 = rect.top;
        try {
            new Matrix().postRotate(f4480a[defaultDisplay.getRotation()]);
            return m4512b(context, Uri.parse(new File(C1327bw.m4596b() + "/skins/") + "/skin_myskin.png_"), i2);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
