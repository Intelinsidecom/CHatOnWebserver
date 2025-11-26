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
import com.sec.common.C4996f;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: GraphicUtils.java */
/* renamed from: com.sec.common.util.l */
/* loaded from: classes.dex */
public class C5035l {

    /* renamed from: a */
    private static final String f18349a = C5035l.class.getSimpleName();

    @Deprecated
    /* renamed from: a */
    public static Bitmap m19109a(Context context, File file, int i, int i2) throws IOException {
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
        if (C4996f.f18229a.f18171c) {
            C4996f.f18229a.m18892f(f18349a, C5052r.m19199a("Sampling size: ", Integer.valueOf(options.inSampleSize)));
        }
        options.inJustDecodeBounds = false;
        options.inDither = true;
        options.inPurgeable = true;
        Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(canonicalPath, options);
        if (bitmapDecodeFile == null) {
            throw new IOException("Can't decode file");
        }
        if (C4996f.f18229a.f18171c) {
            C4996f.f18229a.m18892f(f18349a, C5052r.m19199a("Request(Width: ", Integer.valueOf(i), ", Height: ", Integer.valueOf(i2), "), Response(Width: ", Integer.valueOf(bitmapDecodeFile.getWidth()), ", Height: ", Integer.valueOf(bitmapDecodeFile.getHeight()), ")"));
        }
        return bitmapDecodeFile;
    }

    /* renamed from: a */
    public static void m19113a(Drawable drawable) {
        Bitmap bitmap;
        int i = 0;
        if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            while (i < layerDrawable.getNumberOfLayers()) {
                m19113a(layerDrawable.getDrawable(i));
                i++;
            }
        } else if (drawable instanceof AnimationDrawable) {
            AnimationDrawable animationDrawable = (AnimationDrawable) drawable;
            animationDrawable.stop();
            while (i < animationDrawable.getNumberOfFrames()) {
                m19113a(animationDrawable.getFrame(i));
                i++;
            }
        } else if ((drawable instanceof BitmapDrawable) && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null) {
            bitmap.recycle();
        }
        drawable.setCallback(null);
    }

    /* renamed from: a */
    public static File m19110a(Bitmap bitmap, String str, String str2) throws Throwable {
        FileOutputStream fileOutputStream;
        if (bitmap == null) {
            throw new IllegalArgumentException("Bitmap should not be null.");
        }
        File file = new File(str);
        if (!file.exists() && !file.mkdirs()) {
            throw new IOException("Can't make directory. " + file.getCanonicalPath());
        }
        File file2 = new File(str, str2);
        try {
            fileOutputStream = new FileOutputStream(file2);
            try {
                if (!bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream)) {
                    throw new IOException("Can't save image to file.");
                }
                if (bitmap != null) {
                    bitmap.recycle();
                }
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e) {
                        if (C4996f.f18229a.f18174f) {
                            C4996f.f18229a.mo18649a(f18349a, e.getMessage(), e);
                        }
                    }
                }
                return file2;
            } catch (Throwable th) {
                th = th;
                if (bitmap != null) {
                    bitmap.recycle();
                }
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e2) {
                        if (C4996f.f18229a.f18174f) {
                            C4996f.f18229a.mo18649a(f18349a, e2.getMessage(), e2);
                        }
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
        }
    }

    /* renamed from: a */
    public static CharSequence m19111a(CharSequence charSequence) {
        return TextUtils.isEmpty(charSequence) ? charSequence : m19112a(charSequence, 0, charSequence.length());
    }

    /* renamed from: a */
    public static CharSequence m19112a(CharSequence charSequence, int i, int i2) {
        if (!TextUtils.isEmpty(charSequence)) {
            SpannableString spannableString = new SpannableString(charSequence);
            spannableString.setSpan(new UnderlineSpan(), i, i2, 33);
            return spannableString;
        }
        return charSequence;
    }

    /* renamed from: a */
    public static void m19114a(TextView textView) {
        CharSequence text = textView.getText();
        if (!TextUtils.isEmpty(text)) {
            m19115a(textView, 0, text.length());
        }
    }

    /* renamed from: a */
    public static void m19115a(TextView textView, int i, int i2) {
        CharSequence text = textView.getText();
        if (!TextUtils.isEmpty(text)) {
            textView.setText(m19112a(text, i, i2));
        }
    }
}
