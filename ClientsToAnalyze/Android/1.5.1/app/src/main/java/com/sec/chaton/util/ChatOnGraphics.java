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
import android.provider.MediaStore;
import android.view.Display;
import android.view.WindowManager;
import com.sec.chaton.C0062R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.ImageDownloader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class ChatOnGraphics {

    /* renamed from: a */
    public static final String f3635a;

    /* renamed from: b */
    public static final String f3636b;

    public class FlushedInputStream extends FilterInputStream {
        public FlushedInputStream(InputStream inputStream) {
            super(inputStream);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public long skip(long j) throws IOException {
            long j2 = 0;
            while (j2 < j) {
                long jSkip = this.in.skip(j - j2);
                if (jSkip == 0) {
                    if (read() < 0) {
                        break;
                    }
                    jSkip = 1;
                }
                j2 += jSkip;
            }
            return j2;
        }
    }

    static {
        f3635a = StorageStateInfoUtil.m3677a() ? GlobalApplication.m2386d().getExternalFilesDir(null).getAbsolutePath() : GlobalApplication.m2387e().getFilesDir().getAbsolutePath();
        f3636b = f3635a + "/profile/";
    }

    /* renamed from: a */
    public static Bitmap m3527a(Context context, Bitmap bitmap) throws Resources.NotFoundException {
        Bitmap bitmapM3532a;
        float f = context.getResources().getDisplayMetrics().scaledDensity;
        if (bitmap == null) {
            bitmapM3532a = m3532a(context.getResources(), C0062R.drawable.chaton_shortcut_default);
            if (bitmapM3532a == null) {
                return null;
            }
        } else {
            bitmapM3532a = bitmap;
        }
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(C0062R.dimen.app_icon_base_size);
        int dimensionPixelSize2 = context.getResources().getDimensionPixelSize(C0062R.dimen.app_icon_size);
        ChatONLogWriter.m3511e("IConSize : " + dimensionPixelSize2 + ", BaseIConsSize : " + dimensionPixelSize, "ChatOnGraphics");
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(dimensionPixelSize2, dimensionPixelSize2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint();
        paint.setDither(true);
        paint.setFilterBitmap(true);
        int iM3571a = (int) Dip.m3571a(6.0f);
        canvas.drawBitmap(bitmapM3532a, new Rect(0, 0, bitmapM3532a.getWidth(), bitmapM3532a.getHeight()), new Rect(iM3571a, (int) Dip.m3571a(3.0f), dimensionPixelSize2 - iM3571a, dimensionPixelSize2 - ((int) Dip.m3571a(8.0f))), paint);
        Bitmap bitmapM3532a2 = m3532a(context.getResources(), C0062R.drawable.chaton_shortcut);
        if (bitmapM3532a2 != null) {
            canvas.drawBitmap(bitmapM3532a2, new Rect(0, 0, bitmapM3532a2.getWidth(), bitmapM3532a2.getHeight()), new Rect(0, 0, dimensionPixelSize2, dimensionPixelSize2), paint);
        }
        return bitmapCreateBitmap;
    }

    /* renamed from: a */
    public static Bitmap m3528a(Context context, Uri uri) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inDither = true;
        options.inPurgeable = true;
        Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(uri.toString(), options);
        try {
            String attribute = new ExifInterface(uri.getPath()).getAttribute("Orientation");
            Matrix matrix = new Matrix();
            Boolean.valueOf(false);
            if (!(attribute.equals("6") ? Boolean.valueOf(matrix.postRotate(90.0f)) : attribute.equals("3") ? Boolean.valueOf(matrix.postRotate(180.0f)) : attribute.equals("8") ? Boolean.valueOf(matrix.postRotate(270.0f)) : false).booleanValue()) {
                return bitmapDecodeFile;
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmapDecodeFile, 0, 0, bitmapDecodeFile.getWidth(), bitmapDecodeFile.getHeight(), matrix, true);
            if (bitmapDecodeFile != null) {
                bitmapDecodeFile.recycle();
            }
            return bitmapCreateBitmap;
        } catch (IOException e) {
            ChatONLogWriter.m3501a(e, "ChatOnGraphics");
            return null;
        }
    }

    /* renamed from: a */
    public static Bitmap m3529a(Context context, Uri uri, float f) {
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
                ChatONLogWriter.m3506b("[thumbnailFromUri2] Can NOT decode a file", context.getClass().getName());
                return null;
            }
            Bitmap bitmapExtractThumbnail = ThumbnailUtils.extractThumbnail(bitmapDecodeFile, 100, 100);
            if (bitmapDecodeFile != null) {
                bitmapDecodeFile.recycle();
            }
            if (bitmapExtractThumbnail == null) {
                ChatONLogWriter.m3506b("[thumbnailFromUri2] Can NOT make a thumbnail", context.getClass().getName());
                return null;
            }
            try {
                String attribute = new ExifInterface(uri.getPath()).getAttribute("Orientation");
                Matrix matrix = new Matrix();
                Boolean.valueOf(false);
                if (!(attribute.equals("6") ? Boolean.valueOf(matrix.postRotate(90.0f)) : attribute.equals("3") ? Boolean.valueOf(matrix.postRotate(180.0f)) : attribute.equals("8") ? Boolean.valueOf(matrix.postRotate(270.0f)) : false).booleanValue()) {
                    return bitmapExtractThumbnail;
                }
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmapExtractThumbnail, 0, 0, bitmapExtractThumbnail.getWidth(), bitmapExtractThumbnail.getHeight(), matrix, true);
                if (bitmapExtractThumbnail == null) {
                    return bitmapCreateBitmap;
                }
                bitmapExtractThumbnail.recycle();
                return bitmapCreateBitmap;
            } catch (IOException e) {
                e.printStackTrace();
                ChatONLogWriter.m3501a(e, "ChatOnGraphics");
                return null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            ChatONLogWriter.m3501a(e2, "ChatOnGraphics");
            return null;
        }
    }

    /* renamed from: a */
    public static Bitmap m3530a(Context context, Uri uri, int i) throws IOException {
        InputStream inputStreamOpenInputStream;
        Bitmap bitmapDecodeStream;
        BitmapFactory.Options options = new BitmapFactory.Options();
        int iLog = 8;
        Bitmap bitmap = null;
        int i2 = i;
        while (true) {
            if (bitmap != null && !bitmap.isRecycled()) {
                bitmap.recycle();
            }
            int i3 = iLog == 0 ? 0 : i2;
            inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
            options.inSampleSize = (int) Math.pow(2.0d, iLog);
            bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpenInputStream, null, options);
            if (bitmapDecodeStream != null) {
                iLog = iLog > 0 ? iLog - ((int) (Math.log(i3 / (bitmapDecodeStream.getWidth() > bitmapDecodeStream.getHeight() ? bitmapDecodeStream.getWidth() : bitmapDecodeStream.getHeight())) / Math.log(2.0d))) : 0;
                if (i3 <= 0 || bitmapDecodeStream.getWidth() >= i3 / 2 || bitmapDecodeStream.getHeight() >= i3 / 2) {
                    break;
                }
                i2 = i3;
                bitmap = bitmapDecodeStream;
            } else {
                return null;
            }
        }
        inputStreamOpenInputStream.close();
        return bitmapDecodeStream;
    }

    /* renamed from: a */
    public static Bitmap m3531a(Context context, String str) {
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
                if (!(attribute.equals("6") ? Boolean.valueOf(matrix.postRotate(90.0f)) : attribute.equals("3") ? Boolean.valueOf(matrix.postRotate(180.0f)) : attribute.equals("8") ? Boolean.valueOf(matrix.postRotate(270.0f)) : false).booleanValue()) {
                    return bitmapDecodeFile;
                }
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmapDecodeFile, 0, 0, bitmapDecodeFile.getWidth(), bitmapDecodeFile.getHeight(), matrix, true);
                if (bitmapDecodeFile == null) {
                    return bitmapCreateBitmap;
                }
                bitmapDecodeFile.recycle();
                return bitmapCreateBitmap;
            } catch (IOException e) {
                ChatONLogWriter.m3501a(e, context.getClass().getName());
                return null;
            }
        } catch (Exception e2) {
            ChatONLogWriter.m3501a(e2, context.getClass().getName());
            return null;
        }
    }

    /* renamed from: a */
    private static Bitmap m3532a(Resources resources, int i) throws Resources.NotFoundException {
        Drawable drawable = resources.getDrawable(i);
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0055  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.net.Uri m3533a(java.io.ByteArrayOutputStream r4, java.lang.String r5) throws java.lang.Throwable {
        /*
            r3 = 0
            java.io.File r0 = new java.io.File     // Catch: java.lang.Exception -> L43 java.lang.Throwable -> L51
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L43 java.lang.Throwable -> L51
            r1.<init>()     // Catch: java.lang.Exception -> L43 java.lang.Throwable -> L51
            android.content.Context r2 = com.sec.chaton.global.GlobalApplication.m2387e()     // Catch: java.lang.Exception -> L43 java.lang.Throwable -> L51
            java.io.File r2 = r2.getFilesDir()     // Catch: java.lang.Exception -> L43 java.lang.Throwable -> L51
            java.io.File r2 = r2.getAbsoluteFile()     // Catch: java.lang.Exception -> L43 java.lang.Throwable -> L51
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Exception -> L43 java.lang.Throwable -> L51
            java.lang.String r2 = "/"
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Exception -> L43 java.lang.Throwable -> L51
            java.lang.StringBuilder r1 = r1.append(r5)     // Catch: java.lang.Exception -> L43 java.lang.Throwable -> L51
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Exception -> L43 java.lang.Throwable -> L51
            r0.<init>(r1)     // Catch: java.lang.Exception -> L43 java.lang.Throwable -> L51
            android.content.Context r1 = com.sec.chaton.global.GlobalApplication.m2387e()     // Catch: java.lang.Exception -> L43 java.lang.Throwable -> L51
            r2 = 0
            java.io.FileOutputStream r1 = r1.openFileOutput(r5, r2)     // Catch: java.lang.Exception -> L43 java.lang.Throwable -> L51
            byte[] r2 = r4.toByteArray()     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L5b
            r1.write(r2)     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L5b
            android.net.Uri r0 = android.net.Uri.fromFile(r0)     // Catch: java.lang.Throwable -> L59 java.lang.Exception -> L5b
            if (r1 == 0) goto L42
            r1.close()
        L42:
            return r0
        L43:
            r0 = move-exception
            r1 = r3
        L45:
            java.lang.String r2 = "ChatOnGraphics"
            com.sec.chaton.util.ChatONLogWriter.m3501a(r0, r2)     // Catch: java.lang.Throwable -> L59
            if (r1 == 0) goto L4f
            r1.close()
        L4f:
            r0 = r3
            goto L42
        L51:
            r0 = move-exception
            r1 = r3
        L53:
            if (r1 == 0) goto L58
            r1.close()
        L58:
            throw r0
        L59:
            r0 = move-exception
            goto L53
        L5b:
            r0 = move-exception
            goto L45
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.util.ChatOnGraphics.m3533a(java.io.ByteArrayOutputStream, java.lang.String):android.net.Uri");
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004a  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.net.Uri m3534a(java.io.ByteArrayOutputStream r5, java.lang.String r6, java.lang.String r7) throws java.lang.Throwable {
        /*
            r3 = 0
            java.io.File r0 = new java.io.File     // Catch: java.lang.Exception -> L38 java.lang.Throwable -> L46
            android.content.Context r1 = com.sec.chaton.global.GlobalApplication.m2387e()     // Catch: java.lang.Exception -> L38 java.lang.Throwable -> L46
            r2 = 0
            java.io.File r1 = r1.getExternalFilesDir(r2)     // Catch: java.lang.Exception -> L38 java.lang.Throwable -> L46
            java.lang.String r1 = r1.getAbsolutePath()     // Catch: java.lang.Exception -> L38 java.lang.Throwable -> L46
            r0.<init>(r1, r6)     // Catch: java.lang.Exception -> L38 java.lang.Throwable -> L46
            boolean r1 = r0.canRead()     // Catch: java.lang.Exception -> L38 java.lang.Throwable -> L46
            if (r1 != 0) goto L1c
            r0.mkdir()     // Catch: java.lang.Exception -> L38 java.lang.Throwable -> L46
        L1c:
            java.io.File r1 = new java.io.File     // Catch: java.lang.Exception -> L38 java.lang.Throwable -> L46
            r1.<init>(r0, r7)     // Catch: java.lang.Exception -> L38 java.lang.Throwable -> L46
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch: java.lang.Exception -> L38 java.lang.Throwable -> L46
            r0.<init>(r1)     // Catch: java.lang.Exception -> L38 java.lang.Throwable -> L46
            byte[] r2 = r5.toByteArray()     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L55
            r0.write(r2)     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L55
            android.net.Uri r1 = android.net.Uri.fromFile(r1)     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L55
            if (r0 == 0) goto L36
            r0.close()
        L36:
            r0 = r1
        L37:
            return r0
        L38:
            r0 = move-exception
            r1 = r3
        L3a:
            java.lang.String r2 = "ChatOnGraphics"
            com.sec.chaton.util.ChatONLogWriter.m3501a(r0, r2)     // Catch: java.lang.Throwable -> L53
            if (r1 == 0) goto L44
            r1.close()
        L44:
            r0 = r3
            goto L37
        L46:
            r0 = move-exception
            r1 = r3
        L48:
            if (r1 == 0) goto L4d
            r1.close()
        L4d:
            throw r0
        L4e:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
            goto L48
        L53:
            r0 = move-exception
            goto L48
        L55:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
            goto L3a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.util.ChatOnGraphics.m3534a(java.io.ByteArrayOutputStream, java.lang.String, java.lang.String):android.net.Uri");
    }

    /* renamed from: a */
    public static ByteArrayOutputStream m3535a(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        return byteArrayOutputStream;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static File m3536a(Context context, File file) throws Throwable {
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream2;
        FileInputStream fileInputStream2;
        FileOutputStream fileOutputStream3;
        File file2;
        int i;
        int i2;
        try {
            try {
                FileInputStream fileInputStream3 = new FileInputStream(file);
                try {
                    Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(fileInputStream3);
                    int width = bitmapDecodeStream.getWidth();
                    int height = bitmapDecodeStream.getHeight();
                    if (width <= 1024 && height <= 768) {
                        i = width;
                        i2 = height;
                    } else if (width * 768 > height * 1024) {
                        i2 = (height * 1024) / width;
                        i = 1024;
                    } else {
                        i = (width * 768) / height;
                        i2 = 768;
                    }
                    Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapDecodeStream, i, i2, true);
                    File file3 = new File(context.getCacheDir(), "tmp_" + String.valueOf(System.currentTimeMillis()) + ".jpg");
                    FileOutputStream fileOutputStream4 = new FileOutputStream(file3);
                    if (bitmapCreateScaledBitmap != null) {
                        try {
                            if (bitmapCreateScaledBitmap.compress(Bitmap.CompressFormat.JPEG, 90, fileOutputStream4)) {
                                if (fileInputStream3 != null) {
                                    try {
                                        fileInputStream3.close();
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                        ChatONLogWriter.m3499a("Cannot close a file input stream", context.getClass().getName());
                                        return null;
                                    }
                                }
                                if (fileOutputStream4 != null) {
                                    try {
                                        fileOutputStream4.close();
                                    } catch (IOException e2) {
                                        e2.printStackTrace();
                                        ChatONLogWriter.m3499a("Cannot close a file output stream", context.getClass().getName());
                                        return null;
                                    }
                                }
                                return file3;
                            }
                        } catch (FileNotFoundException e3) {
                            fileInputStream2 = fileInputStream3;
                            fileOutputStream3 = fileOutputStream4;
                            ChatONLogWriter.m3499a("FileNotFoundException", context.getClass().getName());
                            if (fileInputStream2 != null) {
                                try {
                                    fileInputStream2.close();
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                    ChatONLogWriter.m3499a("Cannot close a file input stream", context.getClass().getName());
                                    return null;
                                }
                            }
                            if (fileOutputStream3 != null) {
                                try {
                                    fileOutputStream3.close();
                                } catch (IOException e5) {
                                    e5.printStackTrace();
                                    ChatONLogWriter.m3499a("Cannot close a file output stream", context.getClass().getName());
                                    return null;
                                }
                            }
                            file2 = 0;
                            return file2;
                        } catch (Exception e6) {
                            fileInputStream2 = fileInputStream3;
                            fileOutputStream2 = fileOutputStream4;
                            ChatONLogWriter.m3499a("Exception", context.getClass().getName());
                            if (fileInputStream2 != null) {
                                try {
                                    fileInputStream2.close();
                                } catch (IOException e7) {
                                    e7.printStackTrace();
                                    ChatONLogWriter.m3499a("Cannot close a file input stream", context.getClass().getName());
                                    return null;
                                }
                            }
                            if (fileOutputStream2 != null) {
                                try {
                                    fileOutputStream2.close();
                                } catch (IOException e8) {
                                    e8.printStackTrace();
                                    ChatONLogWriter.m3499a("Cannot close a file output stream", context.getClass().getName());
                                    return null;
                                }
                            }
                            file2 = 0;
                            return file2;
                        } catch (Throwable th) {
                            fileInputStream = fileInputStream3;
                            th = th;
                            fileOutputStream = fileOutputStream4;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e9) {
                                    e9.printStackTrace();
                                    ChatONLogWriter.m3499a("Cannot close a file input stream", context.getClass().getName());
                                    return null;
                                }
                            }
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e10) {
                                    e10.printStackTrace();
                                    ChatONLogWriter.m3499a("Cannot close a file output stream", context.getClass().getName());
                                    return null;
                                }
                            }
                            throw th;
                        }
                    }
                    if (fileInputStream3 != null) {
                        try {
                            fileInputStream3.close();
                        } catch (IOException e11) {
                            e11.printStackTrace();
                            ChatONLogWriter.m3499a("Cannot close a file input stream", context.getClass().getName());
                            return null;
                        }
                    }
                    if (fileOutputStream4 != null) {
                        try {
                            fileOutputStream4.close();
                        } catch (IOException e12) {
                            e12.printStackTrace();
                            ChatONLogWriter.m3499a("Cannot close a file output stream", context.getClass().getName());
                            return null;
                        }
                    }
                    return null;
                } catch (FileNotFoundException e13) {
                    fileInputStream2 = fileInputStream3;
                    fileOutputStream3 = null;
                } catch (Exception e14) {
                    fileInputStream2 = fileInputStream3;
                    fileOutputStream2 = null;
                } catch (Throwable th2) {
                    fileInputStream = fileInputStream3;
                    th = th2;
                    fileOutputStream = null;
                }
            } catch (FileNotFoundException e15) {
                fileOutputStream3 = null;
                fileInputStream2 = null;
            } catch (Exception e16) {
                fileOutputStream2 = null;
                fileInputStream2 = null;
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
                fileInputStream = null;
            }
        } catch (Throwable th4) {
            fileInputStream = fileInputStream2;
            fileOutputStream = file2;
            th = th4;
        }
    }

    /* renamed from: a */
    public static String m3537a(Context context, byte[] bArr, int i) {
        Bitmap bitmapDecodeByteArray;
        BitmapFactory.Options options = new BitmapFactory.Options();
        int iLog = 8;
        Bitmap bitmap = null;
        int i2 = i;
        while (true) {
            if (bitmap != null && !bitmap.isRecycled()) {
                bitmap.recycle();
                System.gc();
            }
            int i3 = iLog == 0 ? 0 : i2;
            options.inSampleSize = (int) Math.pow(2.0d, iLog);
            bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            if (bitmapDecodeByteArray != null) {
                ChatONLogWriter.m3509d("BitmapFromUri: " + iLog + ", " + bitmapDecodeByteArray.getHeight() + ", " + bitmapDecodeByteArray.getWidth());
                iLog = iLog > 0 ? iLog - ((int) (Math.log(i3 / (bitmapDecodeByteArray.getWidth() > bitmapDecodeByteArray.getHeight() ? bitmapDecodeByteArray.getWidth() : bitmapDecodeByteArray.getHeight())) / Math.log(2.0d))) : 0;
                if (i3 <= 0 || bitmapDecodeByteArray.getWidth() >= i3 / 2 || bitmapDecodeByteArray.getHeight() >= i3 / 2) {
                    break;
                }
                i2 = i3;
                bitmap = bitmapDecodeByteArray;
            } else {
                return null;
            }
        }
        return MediaStore.Images.Media.insertImage(context.getContentResolver(), bitmapDecodeByteArray, "m&Talk", "");
    }

    /* renamed from: a */
    public static void m3538a(Bitmap bitmap, File file, String str, Bitmap.CompressFormat compressFormat, int i) throws Throwable {
        String str2;
        if (bitmap == null) {
            return;
        }
        if (!file.exists() && !file.mkdirs()) {
            file.mkdir();
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(new File(file, str));
                try {
                    bitmap.compress(compressFormat, i, fileOutputStream2);
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (Exception e) {
                            e = e;
                            str2 = "ChatOnGraphics";
                            ChatONLogWriter.m3501a(e, str2);
                        }
                    }
                } catch (FileNotFoundException e2) {
                    e = e2;
                    fileOutputStream = fileOutputStream2;
                    ChatONLogWriter.m3501a(e, "ChatOnGraphics");
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception e3) {
                            e = e3;
                            str2 = "ChatOnGraphics";
                            ChatONLogWriter.m3501a(e, str2);
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception e4) {
                            ChatONLogWriter.m3501a(e4, "ChatOnGraphics");
                        }
                    }
                    throw th;
                }
            } catch (FileNotFoundException e5) {
                e = e5;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* renamed from: a */
    public static void m3539a(String str, ImageDownloader.OnImageLoaded onImageLoaded) {
        String strM3618c = ProfileImageLoader.m3618c(str);
        ChatONLogWriter.m3511e("[getBigProfile] : " + strM3618c, "ChatOnGraphics");
        ImageDownloader.m3585a().m3591a(str, strM3618c, "//profile", String.format("%s_big.jpeg_", str), Bitmap.CompressFormat.JPEG, onImageLoaded);
    }

    /* renamed from: b */
    public static Bitmap m3540b(Context context, Uri uri) {
        return m3529a(context, uri, 100.0f);
    }

    /* renamed from: b */
    public static Bitmap m3541b(Context context, Uri uri, int i) throws IOException {
        Bitmap bitmapDecodeStream;
        File file = new File(uri.toString());
        BitmapFactory.Options options = new BitmapFactory.Options();
        int i2 = i;
        FileInputStream fileInputStream = null;
        Bitmap bitmap = null;
        int iLog = 8;
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
            if (bitmapDecodeStream != null) {
                iLog = iLog > 0 ? iLog - ((int) (Math.log(i3 / (bitmapDecodeStream.getWidth() > bitmapDecodeStream.getHeight() ? bitmapDecodeStream.getWidth() : bitmapDecodeStream.getHeight())) / Math.log(2.0d))) : 0;
                if (i3 <= 0 || bitmapDecodeStream.getWidth() >= i3 / 2 || bitmapDecodeStream.getHeight() >= i3 / 2) {
                    break;
                }
                i2 = i3;
                bitmap = bitmapDecodeStream;
            } else {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                return null;
            }
        }
        if (fileInputStream != null) {
            try {
                fileInputStream.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        return bitmapDecodeStream;
    }
}
