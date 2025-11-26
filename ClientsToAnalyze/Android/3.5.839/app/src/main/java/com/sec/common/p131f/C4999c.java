package com.sec.common.p131f;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.sec.common.C4996f;
import com.sec.common.p132g.C5007c;
import com.sec.common.util.C5034k;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: Picasso.java */
/* renamed from: com.sec.common.f.c */
/* loaded from: classes.dex */
public class C4999c {

    /* renamed from: a */
    private static final String f18236a = C4999c.class.getSimpleName();

    /* renamed from: b */
    private C5001e f18237b;

    /* renamed from: c */
    private C4997a f18238c;

    /* renamed from: d */
    private C5002f f18239d;

    /* renamed from: e */
    private C5003g f18240e;

    /* renamed from: f */
    private List<C4998b> f18241f;

    /* renamed from: g */
    private File f18242g;

    /* renamed from: h */
    private int f18243h;

    /* renamed from: i */
    private int f18244i;

    /* renamed from: j */
    private Bitmap.Config f18245j;

    /* renamed from: a */
    public C4999c m18976a(File file) {
        this.f18242g = file;
        return this;
    }

    /* renamed from: a */
    public C4999c m18971a(int i) {
        this.f18243h = i;
        return this;
    }

    /* renamed from: a */
    public C4999c m18972a(int i, int i2) {
        return m18974a(i, i2, true);
    }

    /* renamed from: a */
    public C4999c m18974a(int i, int i2, boolean z) {
        this.f18237b = new C5001e(i, i2, z);
        return this;
    }

    /* renamed from: a */
    public C4999c m18975a(Bitmap.Config config) {
        this.f18245j = config;
        return this;
    }

    /* renamed from: a */
    public C4999c m18970a(float f, float f2) {
        this.f18240e = C5003g.m18987a(f, f2);
        return this;
    }

    /* renamed from: a */
    public C4999c m18973a(int i, int i2, Bitmap bitmap, int i3) {
        if (this.f18241f == null) {
            this.f18241f = new ArrayList();
        }
        this.f18241f.add(new C4998b(i, i2, bitmap, i3));
        return this;
    }

    /* renamed from: a */
    public Bitmap m18969a() {
        Bitmap bitmap;
        StringBuilder sb = new StringBuilder();
        if (this.f18242g == null && this.f18243h == 0) {
            throw new IllegalArgumentException("File or resource SHOULD be not null.");
        }
        if (this.f18237b == null) {
            this.f18237b = new C5001e(C5034k.m19096b(), C5034k.m19098c());
        }
        if (this.f18245j != null) {
            this.f18237b.m18984a(this.f18245j);
        }
        this.f18237b.m18985a(this.f18242g);
        this.f18237b.m18983a(this.f18243h);
        long jCurrentTimeMillis = System.currentTimeMillis();
        Bitmap bitmapM18982a = this.f18237b.m18982a((Bitmap) null);
        sb.append("Picasso draw(). resize: " + (System.currentTimeMillis() - jCurrentTimeMillis) + "ms");
        if (this.f18241f != null && this.f18241f.size() != 0) {
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            Iterator<C4998b> it = this.f18241f.iterator();
            while (true) {
                bitmap = bitmapM18982a;
                if (!it.hasNext()) {
                    break;
                }
                bitmapM18982a = it.next().m18966a(bitmap);
            }
            sb.append(", overlap: " + (System.currentTimeMillis() - jCurrentTimeMillis2) + "ms");
            bitmapM18982a = bitmap;
        }
        if (this.f18240e != null) {
            long jCurrentTimeMillis3 = System.currentTimeMillis();
            bitmapM18982a = this.f18240e.m18988a(bitmapM18982a);
            sb.append(", round: " + (System.currentTimeMillis() - jCurrentTimeMillis3) + "ms");
        }
        if (this.f18238c != null) {
            long jCurrentTimeMillis4 = System.currentTimeMillis();
            this.f18238c.m18965a(this.f18242g);
            bitmapM18982a = this.f18238c.m18964a(bitmapM18982a);
            sb.append(", adjust: " + (System.currentTimeMillis() - jCurrentTimeMillis4) + "ms");
        }
        if (this.f18239d != null) {
            long jCurrentTimeMillis5 = System.currentTimeMillis();
            bitmapM18982a = this.f18239d.m18986a(bitmapM18982a);
            sb.append(", rotate: " + (System.currentTimeMillis() - jCurrentTimeMillis5) + "ms");
        }
        if (C4996f.f18229a.f18171c) {
            C4996f.f18229a.m18892f(f18236a, sb.toString());
        }
        return bitmapM18982a;
    }

    /* renamed from: a */
    public void m18977a(C5007c c5007c, ImageView imageView) {
        c5007c.m19023b(imageView, new C5000d(this));
    }
}
