package com.sec.common.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.UnderlineSpan;
import android.widget.TextView;
import com.sec.common.C3330f;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: GraphicUtils.java */
/* renamed from: com.sec.common.util.j */
/* loaded from: classes.dex */
public class C3348j {

    /* renamed from: a */
    private static final String f12082a = C3348j.class.getSimpleName();

    /* renamed from: a */
    public static Bitmap m11791a(Context context, File file, int i, int i2) throws IOException {
        try {
            String canonicalPath = file.getCanonicalPath();
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            options.inSampleSize = 1;
            BitmapFactory.decodeFile(canonicalPath, options);
            int i3 = options.outWidth >> 1;
            for (int i4 = options.outHeight >> 1; i3 > i && i4 > i2; i4 >>= 1) {
                options.inSampleSize <<= 1;
                i3 >>= 1;
            }
            if (C3330f.f12033a.f11972b) {
                C3330f.f12033a.m11651a(f12082a, C3364o.m11849a("Sampling size: ", Integer.valueOf(options.inSampleSize)));
            }
            options.inJustDecodeBounds = false;
            options.inDither = true;
            options.inPurgeable = true;
            Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(canonicalPath, options);
            if (C3330f.f12033a.f11972b && bitmapDecodeFile != null) {
                C3330f.f12033a.m11651a(f12082a, C3364o.m11849a("Request(Width: ", Integer.valueOf(i), ", Height: ", Integer.valueOf(i2), "), Response(Width: ", Integer.valueOf(bitmapDecodeFile.getWidth()), ", Height: ", Integer.valueOf(bitmapDecodeFile.getHeight()), ")"));
                return bitmapDecodeFile;
            }
            return bitmapDecodeFile;
        } catch (IOException e) {
            if (C3330f.f12033a.f11975e) {
                C3330f.f12033a.m11652a(f12082a, e.getMessage(), e);
            }
            return null;
        } catch (OutOfMemoryError e2) {
            if (C3330f.f12033a.f11975e) {
                C3330f.f12033a.m11652a(f12082a, e2.getMessage(), e2);
            }
            return null;
        }
    }

    /* renamed from: a */
    public static void m11795a(Drawable drawable) {
        Bitmap bitmap;
        int i = 0;
        if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            while (i < layerDrawable.getNumberOfLayers()) {
                m11795a(layerDrawable.getDrawable(i));
                i++;
            }
        } else if (drawable instanceof AnimationDrawable) {
            AnimationDrawable animationDrawable = (AnimationDrawable) drawable;
            animationDrawable.stop();
            while (i < animationDrawable.getNumberOfFrames()) {
                m11795a(animationDrawable.getFrame(i));
                i++;
            }
        } else if ((drawable instanceof BitmapDrawable) && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null) {
            bitmap.recycle();
        }
        drawable.setCallback(null);
    }

    /* renamed from: a */
    public static File m11792a(Bitmap bitmap, String str, String str2) throws Throwable {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(str, str2);
        if (bitmap != null) {
            try {
                fileOutputStream = new FileOutputStream(file2);
            } catch (Throwable th) {
                th = th;
            }
            try {
                if (bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream)) {
                    if (bitmap != null) {
                        bitmap.recycle();
                    }
                    if (fileOutputStream == null) {
                        return file2;
                    }
                    try {
                        fileOutputStream.close();
                        return file2;
                    } catch (IOException e) {
                        if (!C3330f.f12033a.f11975e) {
                            return file2;
                        }
                        C3330f.f12033a.m11652a(f12082a, e.getMessage(), e);
                        return file2;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                if (bitmap != null) {
                    bitmap.recycle();
                }
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e2) {
                        if (C3330f.f12033a.f11975e) {
                            C3330f.f12033a.m11652a(f12082a, e2.getMessage(), e2);
                        }
                    }
                }
                throw th;
            }
        } else {
            fileOutputStream = null;
        }
        if (bitmap != null) {
            bitmap.recycle();
        }
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (IOException e3) {
                if (C3330f.f12033a.f11975e) {
                    C3330f.f12033a.m11652a(f12082a, e3.getMessage(), e3);
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    public static CharSequence m11793a(CharSequence charSequence) {
        return TextUtils.isEmpty(charSequence) ? charSequence : m11794a(charSequence, 0, charSequence.length());
    }

    /* renamed from: a */
    public static CharSequence m11794a(CharSequence charSequence, int i, int i2) {
        if (!TextUtils.isEmpty(charSequence)) {
            SpannableString spannableString = new SpannableString(charSequence);
            spannableString.setSpan(new UnderlineSpan(), i, i2, 33);
            return spannableString;
        }
        return charSequence;
    }

    /* renamed from: a */
    public static void m11796a(TextView textView) {
        CharSequence text = textView.getText();
        if (!TextUtils.isEmpty(text)) {
            m11797a(textView, 0, text.length());
        }
    }

    /* renamed from: a */
    public static void m11797a(TextView textView, int i, int i2) {
        CharSequence text = textView.getText();
        if (!TextUtils.isEmpty(text)) {
            textView.setText(m11794a(text, i, i2));
        }
    }
}
