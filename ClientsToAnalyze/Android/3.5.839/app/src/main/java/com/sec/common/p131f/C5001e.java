package com.sec.common.p131f;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import com.sec.common.C4996f;
import com.sec.common.CommonApplication;
import com.sec.common.util.C5052r;
import java.io.File;
import java.io.IOException;

/* compiled from: ResizeCommand.java */
/* renamed from: com.sec.common.f.e */
/* loaded from: classes.dex */
class C5001e {

    /* renamed from: a */
    private static final String f18247a = C5001e.class.getSimpleName();

    /* renamed from: b */
    private File f18248b;

    /* renamed from: c */
    private int f18249c;

    /* renamed from: d */
    private int f18250d;

    /* renamed from: e */
    private int f18251e;

    /* renamed from: f */
    private Bitmap.Config f18252f;

    /* renamed from: g */
    private boolean f18253g;

    C5001e(int i, int i2) {
        this(i, i2, true);
    }

    C5001e(int i, int i2, boolean z) {
        this.f18250d = i;
        this.f18251e = i2;
        this.f18252f = Bitmap.Config.ARGB_8888;
        this.f18253g = z;
    }

    /* renamed from: a */
    void m18985a(File file) {
        this.f18248b = file;
    }

    /* renamed from: a */
    void m18983a(int i) {
        this.f18249c = i;
    }

    /* renamed from: a */
    void m18984a(Bitmap.Config config) {
        this.f18252f = config;
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public Bitmap m18982a(Bitmap bitmap) throws IOException {
        Bitmap bitmapCreateBitmap;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        options.inSampleSize = 1;
        m18980a(options);
        int i = options.outWidth >> 1;
        int i2 = options.outHeight;
        while (true) {
            i2 >>= 1;
            if (i <= this.f18250d || i2 <= this.f18251e) {
                break;
            }
            options.inSampleSize <<= 1;
            i >>= 1;
        }
        if (C4996f.f18229a.f18171c) {
            C4996f.f18229a.m18892f(f18247a, C5052r.m19199a("Sampling size: ", Integer.valueOf(options.inSampleSize)));
        }
        options.inJustDecodeBounds = false;
        options.inDither = true;
        options.inPurgeable = true;
        if (Build.VERSION.SDK_INT >= 10) {
            options.inPreferQualityOverSpeed = false;
        }
        options.inPreferredConfig = this.f18252f;
        Bitmap bitmapM18980a = m18980a(options);
        if (bitmapM18980a == null) {
            throw new IOException("Can't decode file. " + this.f18248b.getCanonicalPath());
        }
        if (this.f18253g) {
            bitmapCreateBitmap = bitmapM18980a;
        } else {
            bitmapCreateBitmap = Bitmap.createBitmap(this.f18250d, this.f18251e, bitmapM18980a.getConfig());
            new Canvas(bitmapCreateBitmap).drawBitmap(bitmapM18980a, new Rect(0, 0, bitmapM18980a.getWidth(), bitmapM18980a.getHeight()), new Rect(0, 0, this.f18250d, this.f18251e), new Paint());
            bitmapM18980a.recycle();
        }
        if (bitmapCreateBitmap == null) {
            throw new IOException("Can't decode file");
        }
        if (C4996f.f18229a.f18171c) {
            C4996f.f18229a.m18892f(f18247a, C5052r.m19199a("Request(Width: ", Integer.valueOf(this.f18250d), ", Height: ", Integer.valueOf(this.f18251e), "), Response(Width: ", Integer.valueOf(bitmapCreateBitmap.getWidth()), ", Height: ", Integer.valueOf(bitmapCreateBitmap.getHeight()), ")"));
        }
        return bitmapCreateBitmap;
    }

    /* renamed from: a */
    private Bitmap m18980a(BitmapFactory.Options options) {
        return m18981a() ? BitmapFactory.decodeFile(this.f18248b.getCanonicalPath(), options) : BitmapFactory.decodeResource(CommonApplication.m18732r().getResources(), this.f18249c);
    }

    /* renamed from: a */
    private boolean m18981a() {
        return this.f18248b != null;
    }
}
