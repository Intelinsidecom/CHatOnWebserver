package com.android.p029ex.editstyledtext;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.style.ImageSpan;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: EditStyledText.java */
/* renamed from: com.android.ex.editstyledtext.aj */
/* loaded from: classes.dex */
public class C0370aj extends ImageSpan {

    /* renamed from: a */
    Uri f888a;

    /* renamed from: b */
    public int f889b;

    /* renamed from: c */
    public int f890c;

    /* renamed from: d */
    private Drawable f891d;

    /* renamed from: e */
    private Context f892e;

    /* renamed from: f */
    private final int f893f;

    public C0370aj(Context context, Uri uri, int i) {
        super(context, uri);
        this.f889b = -1;
        this.f890c = -1;
        this.f892e = context;
        this.f888a = uri;
        this.f893f = i;
    }

    public C0370aj(Context context, int i, int i2) {
        super(context, i);
        this.f889b = -1;
        this.f890c = -1;
        this.f892e = context;
        this.f893f = i2;
    }

    @Override // android.text.style.ImageSpan, android.text.style.DynamicDrawableSpan
    public Drawable getDrawable() throws IOException {
        Bitmap bitmapDecodeStream;
        if (this.f891d != null) {
            return this.f891d;
        }
        if (this.f888a != null) {
            System.gc();
            try {
                InputStream inputStreamOpenInputStream = this.f892e.getContentResolver().openInputStream(this.f888a);
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeStream(inputStreamOpenInputStream, null, options);
                inputStreamOpenInputStream.close();
                InputStream inputStreamOpenInputStream2 = this.f892e.getContentResolver().openInputStream(this.f888a);
                int i = options.outWidth;
                int i2 = options.outHeight;
                this.f889b = i;
                this.f890c = i2;
                if (options.outWidth > this.f893f) {
                    i = this.f893f;
                    i2 = (i2 * this.f893f) / options.outWidth;
                    bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpenInputStream2, new Rect(0, 0, i, i2), null);
                } else {
                    bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpenInputStream2);
                }
                this.f891d = new BitmapDrawable(this.f892e.getResources(), bitmapDecodeStream);
                this.f891d.setBounds(0, 0, i, i2);
                inputStreamOpenInputStream2.close();
            } catch (Exception e) {
                Log.e("EditStyledTextSpan", "Failed to loaded content " + this.f888a, e);
                return null;
            } catch (OutOfMemoryError e2) {
                Log.e("EditStyledTextSpan", "OutOfMemoryError");
                return null;
            }
        } else {
            this.f891d = super.getDrawable();
            m1322a(this.f891d);
            this.f889b = this.f891d.getIntrinsicWidth();
            this.f890c = this.f891d.getIntrinsicHeight();
        }
        return this.f891d;
    }

    /* renamed from: a */
    public Uri m1323a() {
        return this.f888a;
    }

    /* renamed from: a */
    private void m1322a(Drawable drawable) {
        Log.d("EditStyledTextSpan", "--- rescaleBigImage:");
        if (this.f893f >= 0) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            Log.d("EditStyledTextSpan", "--- rescaleBigImage:" + intrinsicWidth + "," + intrinsicHeight + "," + this.f893f);
            if (intrinsicWidth > this.f893f) {
                intrinsicWidth = this.f893f;
                intrinsicHeight = (intrinsicHeight * this.f893f) / intrinsicWidth;
            }
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        }
    }
}
