package com.samsung.sdraw;

import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;
import java.util.Vector;

/* renamed from: com.samsung.sdraw.e */
/* loaded from: classes.dex */
class C1049e implements InterfaceC1033bs {

    /* renamed from: a */
    private StrokeSprite f1716a;

    /* renamed from: b */
    private Paint f1717b;

    /* renamed from: c */
    private Paint f1718c;

    /* renamed from: d */
    private RectF f1719d;

    /* renamed from: e */
    private Vector<C1043cb> f1720e;

    /* renamed from: f */
    private int f1721f;

    /* renamed from: g */
    private int f1722g;

    C1049e() {
    }

    @Override // com.samsung.sdraw.InterfaceC1033bs
    /* renamed from: a */
    public void mo1377a(StrokeSprite strokeSprite) {
        this.f1716a = strokeSprite;
        this.f1718c = strokeSprite.m1153c();
        this.f1720e = strokeSprite.m1156d();
        this.f1719d = new RectF();
        this.f1717b = new Paint();
        this.f1717b.setAntiAlias(true);
        this.f1717b.setDither(true);
        this.f1717b.setColor(this.f1718c.getColor());
        this.f1717b.setStyle(Paint.Style.FILL);
        this.f1717b.setStrokeWidth(1.0f);
        this.f1717b.setAlpha(this.f1718c.getAlpha());
        this.f1717b.setMaskFilter(new BlurMaskFilter(1.0f, BlurMaskFilter.Blur.NORMAL));
    }

    @Override // com.samsung.sdraw.InterfaceC1033bs
    /* renamed from: a */
    public RectF mo1374a(int i, boolean z) {
        if (i != -1) {
            this.f1721f = i == 0 ? 0 : i + 1;
            this.f1722g = this.f1720e.size();
        } else {
            this.f1722g = this.f1720e.size();
        }
        m1542b();
        return this.f1719d;
    }

    @Override // com.samsung.sdraw.InterfaceC1033bs
    /* renamed from: a */
    public void mo1376a(Canvas canvas, RectF rectF) {
        if (this.f1716a.m1169n()) {
            this.f1721f = 0;
            this.f1722g = this.f1720e.size();
        }
        int i = this.f1721f;
        while (true) {
            int i2 = i;
            if (i2 < this.f1722g) {
                m1541a(canvas, this.f1720e.get(i2), i2);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    /* renamed from: b */
    private RectF m1542b() {
        this.f1719d.set(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET);
        int i = this.f1721f;
        while (true) {
            int i2 = i;
            if (i2 < this.f1722g) {
                this.f1719d.union(m1540a(this.f1720e.get(i2)));
                i = i2 + 1;
            } else {
                this.f1719d.inset(-1.0f, -1.0f);
                this.f1716a.getBounds().union(this.f1719d);
                return this.f1719d;
            }
        }
    }

    /* renamed from: a */
    private void m1541a(Canvas canvas, C1043cb c1043cb, int i) {
        this.f1717b.setAlpha((int) Math.max(50.0f, Math.min(153.0f, c1043cb.f1689i * 255.0f)));
        canvas.drawCircle(c1043cb.x, c1043cb.y, c1043cb.f1688h, this.f1717b);
    }

    /* renamed from: a */
    private RectF m1540a(C1043cb c1043cb) {
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
