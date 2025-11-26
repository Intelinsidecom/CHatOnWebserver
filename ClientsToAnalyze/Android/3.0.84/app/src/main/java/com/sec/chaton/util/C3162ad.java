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
import android.view.Display;
import android.view.WindowManager;
import android.widget.ImageView;
import com.sec.chaton.R;
import com.sec.chaton.buddy.C0522ag;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p020c.C0816a;
import com.sec.common.CommonApplication;
import com.sec.widget.C3641ai;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: ChatOnGraphics.java */
/* renamed from: com.sec.chaton.util.ad */
/* loaded from: classes.dex */
public class C3162ad {

    /* renamed from: a */
    public static final String f11475a = C3162ad.class.getSimpleName();

    /* renamed from: b */
    public static final int[] f11476b = {0, 270, 180, 90};

    /* renamed from: a */
    public static ByteArrayOutputStream m11006a(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        return byteArrayOutputStream;
    }

    /* renamed from: a */
    public static Bitmap m10998a(Context context, Uri uri, int i) throws IOException {
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
            } catch (OutOfMemoryError e) {
                C3250y.m11443a(e, f11475a);
                C3641ai.m13210a(CommonApplication.m11493l(), R.string.chat_view_memory_error, 0).show();
            }
            if (bitmapDecodeStream == null) {
                return null;
            }
            int width = bitmapDecodeStream.getWidth() > bitmapDecodeStream.getHeight() ? bitmapDecodeStream.getWidth() : bitmapDecodeStream.getHeight();
            if (iLog > 0) {
                iLog -= (int) (Math.log(i2 / width) / Math.log(2.0d));
            } else {
                iLog = 0;
            }
            if (i2 <= 0 || bitmapDecodeStream.getWidth() >= i2 / 2) {
                break;
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
    public static void m11007a(android.graphics.Bitmap r3, java.io.File r4, java.lang.String r5, android.graphics.Bitmap.CompressFormat r6, int r7) throws java.lang.Throwable {
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
            java.lang.String r1 = com.sec.chaton.util.C3162ad.f11475a
        L29:
            com.sec.chaton.util.C3250y.m11443a(r0, r1)
            goto L2
        L2d:
            r0 = move-exception
            r1 = r2
        L2f:
            java.lang.String r2 = com.sec.chaton.util.C3162ad.f11475a     // Catch: java.lang.Throwable -> L4d
            com.sec.chaton.util.C3250y.m11443a(r0, r2)     // Catch: java.lang.Throwable -> L4d
            if (r1 == 0) goto L2
            r1.close()     // Catch: java.lang.Exception -> L3a
            goto L2
        L3a:
            r0 = move-exception
            java.lang.String r1 = com.sec.chaton.util.C3162ad.f11475a
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
            java.lang.String r2 = com.sec.chaton.util.C3162ad.f11475a
            com.sec.chaton.util.C3250y.m11443a(r1, r2)
            goto L45
        L4d:
            r0 = move-exception
            goto L40
        L4f:
            r0 = move-exception
            goto L2f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.util.C3162ad.m11007a(android.graphics.Bitmap, java.io.File, java.lang.String, android.graphics.Bitmap$CompressFormat, int):void");
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
    public static android.net.Uri m11005a(java.io.ByteArrayOutputStream r4, java.lang.String r5, java.lang.String r6) throws java.lang.Throwable {
        /*
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch: java.lang.Exception -> L37 java.lang.Throwable -> L41
            android.content.Context r2 = com.sec.common.CommonApplication.m11493l()     // Catch: java.lang.Exception -> L37 java.lang.Throwable -> L41
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
            java.lang.String r3 = com.sec.chaton.util.C3162ad.f11475a     // Catch: java.lang.Throwable -> L4a
            com.sec.chaton.util.C3250y.m11443a(r1, r3)     // Catch: java.lang.Throwable -> L4a
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
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.util.C3162ad.m11005a(java.io.ByteArrayOutputStream, java.lang.String, java.lang.String):android.net.Uri");
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
    public static android.net.Uri m11004a(java.io.ByteArrayOutputStream r4, java.lang.String r5) throws java.lang.Throwable {
        /*
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch: java.lang.Exception -> L43 java.lang.Throwable -> L4d
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L43 java.lang.Throwable -> L4d
            r2.<init>()     // Catch: java.lang.Exception -> L43 java.lang.Throwable -> L4d
            android.content.Context r3 = com.sec.common.CommonApplication.m11493l()     // Catch: java.lang.Exception -> L43 java.lang.Throwable -> L4d
            java.io.File r3 = r3.getFilesDir()     // Catch: java.lang.Exception -> L43 java.lang.Throwable -> L4d
            java.io.File r3 = r3.getAbsoluteFile()     // Catch: java.lang.Exception -> L43 java.lang.Throwable -> L4d
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Exception -> L43 java.lang.Throwable -> L4d
            java.lang.String r3 = "/"
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Exception -> L43 java.lang.Throwable -> L4d
            java.lang.StringBuilder r2 = r2.append(r5)     // Catch: java.lang.Exception -> L43 java.lang.Throwable -> L4d
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Exception -> L43 java.lang.Throwable -> L4d
            r1.<init>(r2)     // Catch: java.lang.Exception -> L43 java.lang.Throwable -> L4d
            android.content.Context r2 = com.sec.common.CommonApplication.m11493l()     // Catch: java.lang.Exception -> L43 java.lang.Throwable -> L4d
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
            java.lang.String r3 = com.sec.chaton.util.C3162ad.f11475a     // Catch: java.lang.Throwable -> L56
            com.sec.chaton.util.C3250y.m11443a(r1, r3)     // Catch: java.lang.Throwable -> L56
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
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.util.C3162ad.m11004a(java.io.ByteArrayOutputStream, java.lang.String):android.net.Uri");
    }

    /* renamed from: a */
    public static Bitmap m11000a(Context context, String str) {
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
                    if (bitmapDecodeFile.isRecycled()) {
                        return bitmapCreateBitmap;
                    }
                    bitmapDecodeFile.recycle();
                    return bitmapCreateBitmap;
                }
                return bitmapDecodeFile;
            } catch (IOException e) {
                C3250y.m11443a(e, context.getClass().getName());
                return null;
            }
        } catch (Exception e2) {
            C3250y.m11443a(e2, f11475a);
            return null;
        } catch (OutOfMemoryError e3) {
            C3250y.m11443a(e3, f11475a);
            return null;
        }
    }

    /* renamed from: a */
    public static Bitmap m11003a(Uri uri) {
        try {
            return m11013b(uri);
        } catch (FileNotFoundException e) {
            C3250y.m11443a(e, f11475a);
            return null;
        } catch (IOException e2) {
            C3250y.m11443a(e2, f11475a);
            return null;
        } catch (OutOfMemoryError e3) {
            C3250y.m11443a(e3, f11475a);
            return null;
        }
    }

    /* renamed from: b */
    public static Bitmap m11013b(Uri uri) throws IOException {
        String str;
        Bitmap bitmapDecodeStream;
        Boolean boolValueOf;
        InputStream inputStreamOpenInputStream = null;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inDither = true;
        options.inPurgeable = true;
        if (uri == null) {
            return null;
        }
        if (uri.toString() != null && uri.toString().startsWith("//")) {
            String strReplace = uri.toString().replace("//", "/");
            options.inSampleSize = m11014c(Uri.parse(strReplace));
            str = strReplace;
        } else {
            String string = uri.toString();
            options.inSampleSize = m11014c(uri);
            str = string;
        }
        try {
            try {
                if (uri.toString().contains("file://") || uri.toString().contains("content://")) {
                    try {
                        inputStreamOpenInputStream = CommonApplication.m11493l().getContentResolver().openInputStream(uri);
                        bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpenInputStream, null, options);
                    } catch (FileNotFoundException e) {
                        throw e;
                    }
                } else {
                    bitmapDecodeStream = BitmapFactory.decodeFile(uri.toString(), options);
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
                        try {
                            try {
                                return Bitmap.createBitmap(bitmapDecodeStream, 0, 0, bitmapDecodeStream.getWidth(), bitmapDecodeStream.getHeight(), matrix, true);
                            } finally {
                                if (!bitmapDecodeStream.isRecycled()) {
                                    bitmapDecodeStream.recycle();
                                }
                            }
                        } catch (OutOfMemoryError e2) {
                            throw e2;
                        }
                    }
                    return bitmapDecodeStream;
                } catch (IOException e3) {
                    throw e3;
                }
            } finally {
                if (0 != 0) {
                    try {
                        inputStreamOpenInputStream.close();
                    } catch (IOException e4) {
                        C3250y.m11443a(e4, f11475a);
                    }
                }
            }
        } catch (OutOfMemoryError e5) {
            throw e5;
        }
    }

    /* renamed from: a */
    public static Bitmap m10997a(Context context, Uri uri) {
        return m10999a(context, uri, 250, 250);
    }

    /* renamed from: a */
    public static Bitmap m10999a(Context context, Uri uri, int i, int i2) {
        Boolean boolValueOf;
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = false;
            options.inDither = true;
            options.inPurgeable = true;
            options.inSampleSize = m11014c(uri);
            Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(uri.getPath(), options);
            if (bitmapDecodeFile == null) {
                C3250y.m11450b("[thumbnailFromUri2] Can NOT decode a file", context.getClass().getName());
                return null;
            }
            Bitmap bitmapExtractThumbnail = (bitmapDecodeFile.getWidth() <= 15 || bitmapDecodeFile.getHeight() <= 15) ? null : ThumbnailUtils.extractThumbnail(bitmapDecodeFile, i, i2);
            if (bitmapExtractThumbnail != bitmapDecodeFile && bitmapDecodeFile != null && !bitmapDecodeFile.isRecycled()) {
                bitmapDecodeFile.recycle();
            }
            if (bitmapExtractThumbnail == null) {
                C3250y.m11450b("[thumbnailFromUri2] Can NOT make a thumbnail", context.getClass().getName());
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
                    if (bitmapExtractThumbnail.isRecycled()) {
                        return bitmapCreateBitmap;
                    }
                    bitmapExtractThumbnail.recycle();
                    return bitmapCreateBitmap;
                }
                return bitmapExtractThumbnail;
            } catch (IOException e) {
                e.printStackTrace();
                C3250y.m11443a(e, f11475a);
                return null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            C3250y.m11443a(e2, f11475a);
            return null;
        } catch (OutOfMemoryError e3) {
            C3250y.m11443a(e3, context.getClass().getName());
            return null;
        }
    }

    /* renamed from: a */
    public static Bitmap m10995a(Context context, Bitmap bitmap) {
        return m10996a(context, bitmap, R.drawable.shortcut_chat_icon);
    }

    /* renamed from: a */
    public static Bitmap m10996a(Context context, Bitmap bitmap, int i) throws Resources.NotFoundException {
        if (bitmap == null && (bitmap = m11001a(context.getResources(), R.drawable.contacts_default_01)) == null) {
            return null;
        }
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.app_icon_base_size);
        int dimensionPixelSize2 = context.getResources().getDimensionPixelSize(R.dimen.app_icon_size);
        C3250y.m11456e("IConSize : " + dimensionPixelSize2 + ", BaseIConsSize : " + dimensionPixelSize, f11475a);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(dimensionPixelSize2, dimensionPixelSize2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint();
        paint.setDither(true);
        paint.setFilterBitmap(true);
        int dimensionPixelSize3 = context.getResources().getDimensionPixelSize(R.dimen.shortcut_position_x);
        canvas.drawBitmap(bitmap, new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), new Rect(dimensionPixelSize3, context.getResources().getDimensionPixelSize(R.dimen.shortcut_position_y), dimensionPixelSize2 - dimensionPixelSize3, dimensionPixelSize2 - context.getResources().getDimensionPixelSize(R.dimen.shortcut_bottom_margin)), paint);
        int dimensionPixelSize4 = context.getResources().getDimensionPixelSize(R.dimen.shortcut_overlayout_margin);
        Bitmap bitmapM11001a = m11001a(context.getResources(), i);
        if (bitmapM11001a != null) {
            canvas.drawBitmap(bitmapM11001a, new Rect(0, 0, bitmapM11001a.getWidth(), bitmapM11001a.getHeight()), new Rect(dimensionPixelSize2 - (bitmapM11001a.getWidth() + dimensionPixelSize4), dimensionPixelSize2 - (bitmapM11001a.getWidth() + dimensionPixelSize4), dimensionPixelSize2 - dimensionPixelSize4, dimensionPixelSize2 - dimensionPixelSize4), paint);
            return bitmapCreateBitmap;
        }
        return bitmapCreateBitmap;
    }

    /* renamed from: a */
    private static Bitmap m11001a(Resources resources, int i) throws Resources.NotFoundException {
        Drawable drawable = resources.getDrawable(i);
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        return null;
    }

    /* renamed from: b */
    public static Bitmap m11012b(Context context, Uri uri, int i) throws IOException {
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
                Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(GlobalApplication.m6451b(), R.drawable.contacts_default_01);
                C0522ag.m4023b("Me", bitmapDecodeResource);
                C3205bt.m11182a(CommonApplication.m11493l()).m11206a();
                return bitmapDecodeResource;
            }
            int width = bitmapDecodeStream.getWidth() > bitmapDecodeStream.getHeight() ? bitmapDecodeStream.getWidth() : bitmapDecodeStream.getHeight();
            if (iLog > 0) {
                iLog -= (int) (Math.log(i3 / width) / Math.log(2.0d));
            } else {
                iLog = 0;
            }
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
    public static void m11009a(String str, InterfaceC3187bb interfaceC3187bb) {
        String strM11201i = C3205bt.m11201i(str);
        C3250y.m11456e("[getBigProfile] : " + strM11201i, f11475a);
        C3181aw.m11120a().m11126a(str, strM11201i, "//profile", String.format("%s_big.jpeg_", str), Bitmap.CompressFormat.JPEG, interfaceC3187bb);
    }

    /* renamed from: c */
    public static int m11014c(Uri uri) throws IOException {
        InputStream inputStreamOpenInputStream = null;
        if (uri == null) {
            return 1;
        }
        try {
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                if (uri.toString().contains("file://") || uri.toString().contains("content://")) {
                    inputStreamOpenInputStream = CommonApplication.m11493l().getContentResolver().openInputStream(uri);
                    BitmapFactory.decodeStream(inputStreamOpenInputStream, null, options);
                } else {
                    BitmapFactory.decodeFile(uri.toString(), options);
                }
                int i = options.outWidth;
                int i2 = options.outHeight;
                C3250y.m11450b("options: width, height : " + i + ", " + i2, CommonApplication.m11493l().getClass().getSimpleName());
                int iRound = i >= i2 ? Math.round(i / C0816a.f3121j) : Math.round(i2 / C0816a.f3121j);
                if (iRound >= 1) {
                    return iRound;
                }
                return 1;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                if (inputStreamOpenInputStream == null) {
                    return 0;
                }
                try {
                    inputStreamOpenInputStream.close();
                    return 0;
                } catch (IOException e2) {
                    e2.printStackTrace();
                    return 0;
                }
            }
        } finally {
            if (inputStreamOpenInputStream != null) {
                try {
                    inputStreamOpenInputStream.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
        }
    }

    /* renamed from: a */
    public static Bitmap m10993a(Context context, int i, int i2, int i3) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        ((Activity) context).getWindow().getDecorView().getWindowVisibleDisplayFrame(new Rect());
        try {
            new Matrix().postRotate(f11476b[defaultDisplay.getRotation()]);
            return m11012b(context, Uri.parse(new File(C3223ck.m11328b() + "/skins/") + "/skin_myskin.png_"), i);
        } catch (IOException e) {
            C3250y.m11443a(e, f11475a);
            return null;
        } catch (OutOfMemoryError e2) {
            C3641ai.m13210a(CommonApplication.m11493l(), R.string.chat_view_memory_error, 0).show();
            C3250y.m11443a(e2, f11475a);
            return null;
        }
    }

    /* renamed from: b */
    public static Bitmap m11010b(Context context, int i, int i2, int i3) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        ((Activity) context).getWindow().getDecorView().getWindowVisibleDisplayFrame(new Rect());
        try {
            new Matrix().postRotate(f11476b[defaultDisplay.getRotation()]);
            return m11012b(context, Uri.parse(new File(C3223ck.m11328b() + "/skins/") + "/skin_myskin.png_"), i2);
        } catch (IOException e) {
            C3250y.m11443a(e, f11475a);
            return null;
        } catch (OutOfMemoryError e2) {
            C3641ai.m13210a(CommonApplication.m11493l(), R.string.chat_view_memory_error, 0).show();
            C3250y.m11443a(e2, f11475a);
            return null;
        }
    }

    /* renamed from: a */
    public static Bitmap m10994a(Context context, int i, int i2, int i3, String str, String str2) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        ((Activity) context).getWindow().getDecorView().getWindowVisibleDisplayFrame(new Rect());
        try {
            new Matrix().postRotate(f11476b[defaultDisplay.getRotation()]);
            return m11012b(context, Uri.parse(new File(str) + "/" + str2), i);
        } catch (IOException e) {
            C3250y.m11443a(e, f11475a);
            return null;
        } catch (OutOfMemoryError e2) {
            C3641ai.m13210a(CommonApplication.m11493l(), R.string.chat_view_memory_error, 0).show();
            C3250y.m11443a(e2, f11475a);
            return null;
        }
    }

    /* renamed from: b */
    public static Bitmap m11011b(Context context, int i, int i2, int i3, String str, String str2) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        ((Activity) context).getWindow().getDecorView().getWindowVisibleDisplayFrame(new Rect());
        try {
            new Matrix().postRotate(f11476b[defaultDisplay.getRotation()]);
            return m11012b(context, Uri.parse(new File(str) + "/" + str2), i2);
        } catch (IOException e) {
            C3250y.m11443a(e, f11475a);
            return null;
        } catch (OutOfMemoryError e2) {
            C3641ai.m13210a(CommonApplication.m11493l(), R.string.chat_view_memory_error, 0).show();
            C3250y.m11443a(e2, f11475a);
            return null;
        }
    }

    /* renamed from: a */
    public static void m11008a(ImageView imageView) {
        Matrix matrix = new Matrix();
        matrix.reset();
        if (imageView != null) {
            int width = imageView.getWidth();
            int height = imageView.getHeight();
            Drawable drawable = imageView.getDrawable();
            if (drawable != null) {
                int intrinsicWidth = drawable.getIntrinsicWidth();
                int intrinsicHeight = drawable.getIntrinsicHeight();
                float fMin = Math.min(width / intrinsicWidth, height / intrinsicHeight);
                float[] fArr = {fMin, 0.0f, fMax, 0.0f, fMin, fMax, 0.0f, 0.0f, 0.0f};
                matrix.getValues(fArr);
                float fMax = Math.max(0.0f, width - (intrinsicWidth * fMin)) * 0.5f;
                float fMax2 = Math.max(0.0f, height - (intrinsicHeight * fMin)) * 0.5f;
                matrix.setValues(fArr);
                imageView.setImageMatrix(matrix);
            }
        }
    }

    /* renamed from: a */
    public static Bitmap m11002a(Bitmap bitmap, int i) {
        Matrix matrix = new Matrix();
        if (i <= 0 || i >= 360) {
            return null;
        }
        matrix.postRotate(i);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }
}
