package com.sec.chaton.util;

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
import com.sec.chaton.buddy.C1113ad;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p051c.C1427a;
import com.sec.common.CommonApplication;
import com.sec.common.util.C5034k;
import com.sec.widget.C5179v;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;

/* compiled from: ChatOnGraphics.java */
/* renamed from: com.sec.chaton.util.ad */
/* loaded from: classes.dex */
public class C4812ad {

    /* renamed from: a */
    public static final String f17576a = C4812ad.class.getSimpleName();

    /* renamed from: b */
    public static final int[] f17577b = {0, 270, 180, 90};

    /* renamed from: a */
    public static ByteArrayOutputStream m18151a(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        return byteArrayOutputStream;
    }

    /* renamed from: a */
    public static Bitmap m18143a(Context context, Uri uri, int i) throws IOException {
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
                C4904y.m18635a(e, f17576a);
                C5179v.m19810a(CommonApplication.m18732r(), R.string.chat_view_memory_error, 0).show();
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
    public static void m18152a(android.graphics.Bitmap r3, java.io.File r4, java.lang.String r5, android.graphics.Bitmap.CompressFormat r6, int r7) throws java.lang.Throwable {
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
            java.lang.String r1 = com.sec.chaton.util.C4812ad.f17576a
        L29:
            com.sec.chaton.util.C4904y.m18635a(r0, r1)
            goto L2
        L2d:
            r0 = move-exception
            r1 = r2
        L2f:
            java.lang.String r2 = com.sec.chaton.util.C4812ad.f17576a     // Catch: java.lang.Throwable -> L4d
            com.sec.chaton.util.C4904y.m18635a(r0, r2)     // Catch: java.lang.Throwable -> L4d
            if (r1 == 0) goto L2
            r1.close()     // Catch: java.lang.Exception -> L3a
            goto L2
        L3a:
            r0 = move-exception
            java.lang.String r1 = com.sec.chaton.util.C4812ad.f17576a
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
            java.lang.String r2 = com.sec.chaton.util.C4812ad.f17576a
            com.sec.chaton.util.C4904y.m18635a(r1, r2)
            goto L45
        L4d:
            r0 = move-exception
            goto L40
        L4f:
            r0 = move-exception
            goto L2f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.util.C4812ad.m18152a(android.graphics.Bitmap, java.io.File, java.lang.String, android.graphics.Bitmap$CompressFormat, int):void");
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
    public static android.net.Uri m18150a(java.io.ByteArrayOutputStream r4, java.lang.String r5, java.lang.String r6) throws java.lang.Throwable {
        /*
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch: java.lang.Exception -> L37 java.lang.Throwable -> L41
            android.content.Context r2 = com.sec.common.CommonApplication.m18732r()     // Catch: java.lang.Exception -> L37 java.lang.Throwable -> L41
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
            java.lang.String r3 = com.sec.chaton.util.C4812ad.f17576a     // Catch: java.lang.Throwable -> L4a
            com.sec.chaton.util.C4904y.m18635a(r1, r3)     // Catch: java.lang.Throwable -> L4a
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
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.util.C4812ad.m18150a(java.io.ByteArrayOutputStream, java.lang.String, java.lang.String):android.net.Uri");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0040 A[PHI: r0 r2
  0x0040: PHI (r0v6 android.net.Uri) = (r0v0 android.net.Uri), (r0v8 android.net.Uri) binds: [B:11:0x004b, B:5:0x003e] A[DONT_GENERATE, DONT_INLINE]
  0x0040: PHI (r2v5 java.io.FileOutputStream) = (r2v4 java.io.FileOutputStream), (r2v12 java.io.FileOutputStream) binds: [B:11:0x004b, B:5:0x003e] A[DONT_GENERATE, DONT_INLINE]] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.net.Uri m18149a(java.io.ByteArrayOutputStream r4, java.lang.String r5) throws java.lang.Throwable {
        /*
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch: java.lang.Exception -> L44 java.lang.Throwable -> L4e
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L44 java.lang.Throwable -> L4e
            r2.<init>()     // Catch: java.lang.Exception -> L44 java.lang.Throwable -> L4e
            android.content.Context r3 = com.sec.common.CommonApplication.m18732r()     // Catch: java.lang.Exception -> L44 java.lang.Throwable -> L4e
            java.io.File r3 = r3.getFilesDir()     // Catch: java.lang.Exception -> L44 java.lang.Throwable -> L4e
            java.io.File r3 = r3.getAbsoluteFile()     // Catch: java.lang.Exception -> L44 java.lang.Throwable -> L4e
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Exception -> L44 java.lang.Throwable -> L4e
            java.lang.String r3 = "/"
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Exception -> L44 java.lang.Throwable -> L4e
            java.lang.StringBuilder r2 = r2.append(r5)     // Catch: java.lang.Exception -> L44 java.lang.Throwable -> L4e
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Exception -> L44 java.lang.Throwable -> L4e
            r1.<init>(r2)     // Catch: java.lang.Exception -> L44 java.lang.Throwable -> L4e
            android.content.Context r2 = com.sec.common.CommonApplication.m18732r()     // Catch: java.lang.Exception -> L44 java.lang.Throwable -> L4e
            r3 = 0
            java.io.FileOutputStream r2 = r2.openFileOutput(r5, r3)     // Catch: java.lang.Exception -> L44 java.lang.Throwable -> L4e
            byte[] r3 = r4.toByteArray()     // Catch: java.lang.Throwable -> L57 java.lang.Exception -> L59
            r2.write(r3)     // Catch: java.lang.Throwable -> L57 java.lang.Exception -> L59
            android.net.Uri r0 = android.net.Uri.fromFile(r1)     // Catch: java.lang.Throwable -> L57 java.lang.Exception -> L59
            if (r2 == 0) goto L43
        L40:
            r2.close()
        L43:
            return r0
        L44:
            r1 = move-exception
            r2 = r0
        L46:
            java.lang.String r3 = com.sec.chaton.util.C4812ad.f17576a     // Catch: java.lang.Throwable -> L57
            com.sec.chaton.util.C4904y.m18635a(r1, r3)     // Catch: java.lang.Throwable -> L57
            if (r2 == 0) goto L43
            goto L40
        L4e:
            r1 = move-exception
            r2 = r0
            r0 = r1
        L51:
            if (r2 == 0) goto L56
            r2.close()
        L56:
            throw r0
        L57:
            r0 = move-exception
            goto L51
        L59:
            r1 = move-exception
            goto L46
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.util.C4812ad.m18149a(java.io.ByteArrayOutputStream, java.lang.String):android.net.Uri");
    }

    /* renamed from: a */
    public static Bitmap m18145a(Context context, String str) {
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
                C4904y.m18635a(e, context.getClass().getName());
                return null;
            }
        } catch (Exception e2) {
            C4904y.m18635a(e2, f17576a);
            return null;
        } catch (OutOfMemoryError e3) {
            C4904y.m18635a(e3, f17576a);
            return null;
        }
    }

    /* renamed from: a */
    public static Bitmap m18148a(Uri uri) {
        try {
            return m18158b(uri);
        } catch (FileNotFoundException e) {
            C4904y.m18635a(e, f17576a);
            return null;
        } catch (IOException e2) {
            C4904y.m18635a(e2, f17576a);
            return null;
        } catch (OutOfMemoryError e3) {
            C4904y.m18635a(e3, f17576a);
            return null;
        }
    }

    /* renamed from: b */
    public static Bitmap m18158b(Uri uri) throws IOException {
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
            options.inSampleSize = m18159c(Uri.parse(strReplace));
            str = strReplace;
        } else {
            String string = uri.toString();
            options.inSampleSize = m18159c(uri);
            str = string;
        }
        try {
            try {
                if (uri.toString().contains("file://") || uri.toString().contains("content://")) {
                    try {
                        inputStreamOpenInputStream = CommonApplication.m18732r().getContentResolver().openInputStream(uri);
                        bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpenInputStream, null, options);
                    } catch (FileNotFoundException e) {
                        throw e;
                    }
                } else {
                    bitmapDecodeStream = BitmapFactory.decodeFile(uri.toString(), options);
                }
                if (inputStreamOpenInputStream != null) {
                    try {
                        inputStreamOpenInputStream.close();
                    } catch (IOException e2) {
                        C4904y.m18635a(e2, f17576a);
                    }
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
                        } catch (OutOfMemoryError e3) {
                            throw e3;
                        }
                    }
                    return bitmapDecodeStream;
                } catch (IOException e4) {
                    throw e4;
                }
            } catch (OutOfMemoryError e5) {
                throw e5;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    inputStreamOpenInputStream.close();
                } catch (IOException e6) {
                    C4904y.m18635a(e6, f17576a);
                }
            }
            throw th;
        }
    }

    /* renamed from: a */
    public static Bitmap m18142a(Context context, Uri uri) {
        return m18144a(context, uri, 250, 250);
    }

    /* renamed from: a */
    public static Bitmap m18144a(Context context, Uri uri, int i, int i2) {
        Boolean boolValueOf;
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = false;
            options.inDither = true;
            options.inPurgeable = true;
            options.inSampleSize = m18159c(uri);
            Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(uri.getPath(), options);
            if (bitmapDecodeFile == null) {
                C4904y.m18639b("[thumbnailFromUri2] Can NOT decode a file", context.getClass().getName());
                return null;
            }
            Bitmap bitmapExtractThumbnail = (bitmapDecodeFile.getWidth() <= 15 || bitmapDecodeFile.getHeight() <= 15) ? null : ThumbnailUtils.extractThumbnail(bitmapDecodeFile, i, i2);
            if (bitmapExtractThumbnail != bitmapDecodeFile && bitmapDecodeFile != null && !bitmapDecodeFile.isRecycled()) {
                bitmapDecodeFile.recycle();
            }
            if (bitmapExtractThumbnail == null) {
                C4904y.m18639b("[thumbnailFromUri2] Can NOT make a thumbnail", context.getClass().getName());
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
                C4904y.m18635a(e, f17576a);
                return null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            C4904y.m18635a(e2, f17576a);
            return null;
        } catch (OutOfMemoryError e3) {
            C4904y.m18635a(e3, context.getClass().getName());
            return null;
        }
    }

    @Deprecated
    /* renamed from: a */
    public static Bitmap m18140a(Context context, Bitmap bitmap) {
        return m18141a(context, bitmap, R.drawable.shortcut_chat_icon);
    }

    @Deprecated
    /* renamed from: a */
    public static Bitmap m18141a(Context context, Bitmap bitmap, int i) throws Resources.NotFoundException {
        if (bitmap == null && (bitmap = m18146a(context.getResources(), R.drawable.profile_photo_buddy_default)) == null) {
            return null;
        }
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.app_icon_base_size);
        int dimensionPixelSize2 = context.getResources().getDimensionPixelSize(R.dimen.app_icon_size);
        C4904y.m18646e("IConSize : " + dimensionPixelSize2 + ", BaseIConsSize : " + dimensionPixelSize, f17576a);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(dimensionPixelSize2, dimensionPixelSize2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint();
        paint.setDither(true);
        paint.setFilterBitmap(true);
        int dimensionPixelSize3 = context.getResources().getDimensionPixelSize(R.dimen.shortcut_position_x);
        canvas.drawBitmap(bitmap, new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), new Rect(dimensionPixelSize3, context.getResources().getDimensionPixelSize(R.dimen.shortcut_position_y), dimensionPixelSize2 - dimensionPixelSize3, dimensionPixelSize2 - context.getResources().getDimensionPixelSize(R.dimen.shortcut_bottom_margin)), paint);
        int dimensionPixelSize4 = context.getResources().getDimensionPixelSize(R.dimen.shortcut_overlayout_margin);
        Bitmap bitmapM18146a = m18146a(context.getResources(), i);
        if (bitmapM18146a != null) {
            canvas.drawBitmap(bitmapM18146a, new Rect(0, 0, bitmapM18146a.getWidth(), bitmapM18146a.getHeight()), new Rect(dimensionPixelSize2 - (bitmapM18146a.getWidth() + dimensionPixelSize4), dimensionPixelSize2 - (bitmapM18146a.getWidth() + dimensionPixelSize4), dimensionPixelSize2 - dimensionPixelSize4, dimensionPixelSize2 - dimensionPixelSize4), paint);
            return bitmapCreateBitmap;
        }
        return bitmapCreateBitmap;
    }

    /* renamed from: a */
    private static Bitmap m18146a(Resources resources, int i) throws Resources.NotFoundException {
        Drawable drawable = resources.getDrawable(i);
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        return null;
    }

    /* renamed from: b */
    public static Bitmap m18157b(Context context, Uri uri, int i) throws ExecutionException, InterruptedException, IOException {
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
                Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(GlobalApplication.m10283b(), R.drawable.profile_photo_buddy_default);
                C1113ad.m7109b("Me", bitmapDecodeResource);
                C4855bt.m18351a(CommonApplication.m18732r()).m18358a();
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
    public static void m18154a(String str, InterfaceC4837bb interfaceC4837bb) {
        String strM18357e = C4855bt.m18357e(str);
        C4904y.m18646e("[getBigProfile] : " + strM18357e, f17576a);
        C4831aw.m18293a().m18299a(str, strM18357e, "//profile", String.format("%s_big.jpeg_", str), Bitmap.CompressFormat.JPEG, interfaceC4837bb);
    }

    /* renamed from: a */
    public static void m18155a(String str, ExecutorService executorService, InterfaceC4837bb interfaceC4837bb) {
        new C4814af(str, executorService).m19059d(interfaceC4837bb);
    }

    /* renamed from: c */
    public static int m18159c(Uri uri) {
        return m18138a(uri, C1427a.f5077o);
    }

    /* renamed from: a */
    public static int m18138a(Uri uri, float f) throws IOException {
        InputStream inputStreamOpenInputStream = null;
        if (uri == null) {
            return 1;
        }
        try {
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                if (uri.toString().contains("file://") || uri.toString().contains("content://")) {
                    inputStreamOpenInputStream = CommonApplication.m18732r().getContentResolver().openInputStream(uri);
                    BitmapFactory.decodeStream(inputStreamOpenInputStream, null, options);
                } else {
                    BitmapFactory.decodeFile(uri.toString(), options);
                }
                int i = options.outWidth;
                int i2 = options.outHeight;
                C4904y.m18639b("options: width, height : " + i + ", " + i2, CommonApplication.m18732r().getClass().getSimpleName());
                int iFloor = i >= i2 ? (int) Math.floor(i / f) : (int) Math.floor(i2 / f);
                if (iFloor >= 1) {
                    return iFloor;
                }
                return 1;
            } finally {
                if (inputStreamOpenInputStream != null) {
                    try {
                        inputStreamOpenInputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
            if (inputStreamOpenInputStream == null) {
                return 0;
            }
            try {
                inputStreamOpenInputStream.close();
                return 0;
            } catch (IOException e3) {
                e3.printStackTrace();
                return 0;
            }
        }
    }

    /* renamed from: a */
    public static Bitmap m18139a(Context context, int i, int i2, int i3) {
        try {
            new Matrix().postRotate(f17577b[((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation()]);
            return m18157b(context, Uri.parse(new File(C4873ck.m18501b() + "/skins/") + "/skin_myskin.png_"), i);
        } catch (IOException e) {
            C4904y.m18635a(e, f17576a);
            return null;
        } catch (OutOfMemoryError e2) {
            C5179v.m19810a(CommonApplication.m18732r(), R.string.chat_view_memory_error, 0).show();
            C4904y.m18635a(e2, f17576a);
            return null;
        }
    }

    /* renamed from: b */
    public static Bitmap m18156b(Context context, int i, int i2, int i3) {
        try {
            new Matrix().postRotate(f17577b[((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation()]);
            return m18157b(context, Uri.parse(new File(C4873ck.m18501b() + "/skins/") + "/skin_myskin.png_"), i2);
        } catch (IOException e) {
            C4904y.m18635a(e, f17576a);
            return null;
        } catch (OutOfMemoryError e2) {
            C5179v.m19810a(CommonApplication.m18732r(), R.string.chat_view_memory_error, 0).show();
            C4904y.m18635a(e2, f17576a);
            return null;
        }
    }

    /* renamed from: a */
    public static void m18153a(ImageView imageView) {
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
    public static Bitmap m18147a(Bitmap bitmap, int i) {
        Matrix matrix = new Matrix();
        if (i <= 0 || i >= 360) {
            return null;
        }
        matrix.postRotate(i);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    /* renamed from: d */
    public static Bitmap m18160d(Uri uri) {
        Boolean boolValueOf;
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = false;
            options.inDither = true;
            options.inPurgeable = true;
            options.inSampleSize = m18138a(uri, C5034k.m19088a(173.0f));
            Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(uri.getPath(), options);
            if (bitmapDecodeFile == null) {
                if (C4904y.f17872b) {
                    C4904y.m18639b("getAdjustViewBoundsImage Can NOT decode a file", f17576a);
                }
                return null;
            }
            int iM19088a = (int) C5034k.m19088a(173.0f);
            int iM19088a2 = (int) C5034k.m19088a(173.0f);
            if (bitmapDecodeFile.getWidth() >= iM19088a || bitmapDecodeFile.getHeight() >= iM19088a2) {
                if (bitmapDecodeFile.getWidth() > bitmapDecodeFile.getHeight()) {
                    iM19088a2 = (int) ((iM19088a / bitmapDecodeFile.getWidth()) * bitmapDecodeFile.getHeight());
                } else {
                    iM19088a = (int) ((iM19088a2 / bitmapDecodeFile.getHeight()) * bitmapDecodeFile.getWidth());
                }
                Bitmap bitmapExtractThumbnail = ThumbnailUtils.extractThumbnail(bitmapDecodeFile, iM19088a, iM19088a2);
                if (bitmapExtractThumbnail == null) {
                    if (C4904y.f17872b) {
                        C4904y.m18639b("getAdjustViewBoundsImage Can NOT extractThumbnail", f17576a);
                        return bitmapDecodeFile;
                    }
                    return bitmapDecodeFile;
                }
                if (!bitmapExtractThumbnail.equals(bitmapDecodeFile) && bitmapDecodeFile != null && !bitmapDecodeFile.isRecycled()) {
                    bitmapDecodeFile.recycle();
                }
                bitmapDecodeFile = bitmapExtractThumbnail;
            }
            int attributeInt = new ExifInterface(uri.getPath()).getAttributeInt("Orientation", 0);
            Matrix matrix = new Matrix();
            Boolean.valueOf(false);
            if (attributeInt == 6) {
                boolValueOf = Boolean.valueOf(matrix.postRotate(90.0f));
            } else if (attributeInt == 3) {
                boolValueOf = Boolean.valueOf(matrix.postRotate(180.0f));
            } else if (attributeInt == 8) {
                boolValueOf = Boolean.valueOf(matrix.postRotate(270.0f));
            } else {
                boolValueOf = false;
            }
            if (boolValueOf.booleanValue()) {
                return Bitmap.createBitmap(bitmapDecodeFile, 0, 0, bitmapDecodeFile.getWidth(), bitmapDecodeFile.getHeight(), matrix, true);
            }
            return bitmapDecodeFile;
        } catch (Exception e) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e, f17576a);
            }
            return null;
        } catch (OutOfMemoryError e2) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e2, f17576a);
            }
            return null;
        }
    }
}
