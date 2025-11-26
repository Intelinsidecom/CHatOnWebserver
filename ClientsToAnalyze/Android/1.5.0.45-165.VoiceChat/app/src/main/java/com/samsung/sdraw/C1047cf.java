package com.samsung.sdraw;

import android.graphics.Bitmap;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Region;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Random;
import java.util.Vector;

/* renamed from: com.samsung.sdraw.cf */
/* loaded from: classes.dex */
class C1047cf implements InterfaceC1033bs {

    /* renamed from: g */
    private static LinkedHashMap<Integer, Bitmap> f1706g;

    /* renamed from: j */
    private static LinkedHashMap<Integer, Vector<Region>> f1707j;

    /* renamed from: a */
    C0995ah f1708a = new C0995ah(System.currentTimeMillis());

    /* renamed from: b */
    private StrokeSprite f1709b;

    /* renamed from: c */
    private Paint f1710c;

    /* renamed from: d */
    private C1030bp f1711d;

    /* renamed from: e */
    private RectF f1712e;

    /* renamed from: f */
    private Vector<C1043cb> f1713f;

    /* renamed from: h */
    private int f1714h;

    /* renamed from: i */
    private int f1715i;

    C1047cf() {
    }

    @Override // com.samsung.sdraw.InterfaceC1033bs
    /* renamed from: a */
    public void mo1377a(StrokeSprite strokeSprite) {
        this.f1709b = strokeSprite;
        this.f1711d = strokeSprite.m1153c();
        this.f1713f = strokeSprite.m1156d();
        this.f1710c = new Paint();
        this.f1710c.setAntiAlias(true);
        this.f1710c.setDither(true);
        this.f1710c.setColor(this.f1711d.getColor());
        this.f1710c.setStyle(Paint.Style.FILL);
        this.f1710c.setStrokeWidth(1.0f);
        this.f1710c.setAlpha(this.f1711d.getAlpha());
        this.f1710c.setMaskFilter(new BlurMaskFilter(1.0f, BlurMaskFilter.Blur.NORMAL));
        if (f1706g == null) {
            f1706g = new LinkedHashMap<>();
        }
        if (f1707j == null) {
            f1707j = new LinkedHashMap<>();
        }
        this.f1712e = new RectF();
    }

    @Override // com.samsung.sdraw.InterfaceC1033bs
    /* renamed from: a */
    public RectF mo1374a(int i, boolean z) {
        if (i != -1) {
            this.f1714h = i == 0 ? 0 : i + 1;
            this.f1715i = this.f1713f.size();
        } else {
            this.f1715i = this.f1713f.size();
        }
        m1539b();
        return this.f1712e;
    }

    @Override // com.samsung.sdraw.InterfaceC1033bs
    /* renamed from: a */
    public void mo1376a(Canvas canvas, RectF rectF) {
        if (this.f1709b.m1169n()) {
            this.f1714h = 0;
            this.f1715i = this.f1713f.size();
        }
        int i = this.f1714h;
        while (true) {
            int i2 = i;
            if (i2 >= this.f1715i) {
                break;
            }
            m1538a(canvas, this.f1713f.get(i2), i2);
            i = i2 + 1;
        }
        if (this.f1709b.m1169n() && this.f1709b.m1150b()) {
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.FILL);
            paint.setStrokeWidth(4.0f);
            paint.setColor(-16711936);
            Iterator<C1043cb> it = this.f1713f.iterator();
            while (it.hasNext()) {
                C1043cb next = it.next();
                canvas.drawPoint(next.x, next.y, paint);
            }
            paint.setColor(-65281);
            paint.setStrokeWidth(4.0f);
            for (int i3 = 0; i3 < this.f1713f.size(); i3++) {
                C1043cb c1043cb = this.f1713f.get(i3);
                canvas.drawPoint(c1043cb.x, c1043cb.y, paint);
            }
        }
    }

    /* renamed from: b */
    private RectF m1539b() {
        this.f1712e.set(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET);
        int i = this.f1714h;
        while (true) {
            int i2 = i;
            if (i2 < this.f1715i) {
                this.f1712e.union(m1535a(this.f1713f.get(i2)));
                i = i2 + 1;
            } else {
                this.f1712e.inset(-1.0f, -1.0f);
                this.f1709b.getBounds().union(this.f1712e);
                return this.f1712e;
            }
        }
    }

    /* renamed from: a */
    private void m1538a(Canvas canvas, C1043cb c1043cb, int i) {
        canvas.save();
        m1537a(canvas, c1043cb);
        this.f1710c.setAlpha((int) Math.max(50.0f, Math.min(120.0f, c1043cb.f1689i * 255.0f)));
        canvas.drawCircle(c1043cb.x, c1043cb.y, c1043cb.f1688h, this.f1710c);
        canvas.restore();
    }

    /* renamed from: a */
    private void m1536a(int i) {
        if (!f1707j.containsKey(Integer.valueOf(i))) {
            Vector<Region> vector = new Vector<>();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 < 5) {
                    float f = i;
                    Region region = new Region();
                    float f2 = i;
                    float f3 = i;
                    for (float f4 = f; f4 >= (-f); f4 -= 1.0f) {
                        float fSqrt = (float) (2.0d * Math.sqrt((f * f) - (f4 * f4)));
                        float f5 = f2 - (fSqrt / 2.0f);
                        float f6 = f3 - f4;
                        float fM1279b = this.f1708a.m1279b() * 2.0f;
                        region.op((int) (f5 - fM1279b), (int) f6, (int) (fSqrt + f5 + fM1279b), (int) (1.0f + f6), Region.Op.UNION);
                    }
                    for (float f7 = f; f7 >= (-f); f7 -= 1.0f) {
                        float fSqrt2 = (float) (2.0d * Math.sqrt((f * f) - (f7 * f7)));
                        float f8 = f2 - f7;
                        float f9 = f3 - (fSqrt2 / 2.0f);
                        float fM1279b2 = this.f1708a.m1279b() * 2.0f;
                        region.op((int) f8, (int) (f9 - fM1279b2), (int) (f8 + 1.0f), (int) (fSqrt2 + f9 + fM1279b2), Region.Op.UNION);
                    }
                    vector.add(region);
                    i2 = i3 + 1;
                } else {
                    f1707j.put(Integer.valueOf(i), vector);
                    return;
                }
            }
        }
    }

    /* renamed from: a */
    private void m1537a(Canvas canvas, C1043cb c1043cb) {
        int i = (int) c1043cb.f1688h;
        m1536a(i);
        int iAbs = Math.abs(new Random().nextInt(5));
        if (f1707j.containsKey(Integer.valueOf(i))) {
            Region region = new Region(f1707j.get(Integer.valueOf(i)).get(iAbs));
            region.translate(((int) c1043cb.x) - i, ((int) c1043cb.y) - i);
            canvas.clipRegion(region);
        }
    }

    /* renamed from: a */
    private RectF m1535a(C1043cb c1043cb) {
        float f = c1043cb.f1688h;
        int i = (int) (2.0f * f);
        RectF rectF = new RectF(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, i, i);
        rectF.offset(c1043cb.x - f, c1043cb.y - f);
        return rectF;
    }

    @Override // com.samsung.sdraw.InterfaceC1033bs
    /* renamed from: a */
    public void mo1375a() {
    }
}
