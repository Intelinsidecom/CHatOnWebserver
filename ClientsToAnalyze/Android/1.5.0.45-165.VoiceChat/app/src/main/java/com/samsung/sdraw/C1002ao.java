package com.samsung.sdraw;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;
import java.util.Iterator;
import java.util.Vector;

/* renamed from: com.samsung.sdraw.ao */
/* loaded from: classes.dex */
class C1002ao implements InterfaceC1033bs {

    /* renamed from: a */
    private StrokeSprite f1516a;

    /* renamed from: b */
    private C1030bp f1517b;

    /* renamed from: c */
    private Bitmap f1518c;

    /* renamed from: d */
    private RectF f1519d;

    /* renamed from: e */
    private Vector<C1053i> f1520e;

    /* renamed from: f */
    private Vector<C1043cb> f1521f;

    /* renamed from: g */
    private int f1522g;

    /* renamed from: h */
    private int f1523h;

    /* renamed from: i */
    private float f1524i;

    C1002ao() {
    }

    @Override // com.samsung.sdraw.InterfaceC1033bs
    /* renamed from: a */
    public void mo1377a(StrokeSprite strokeSprite) {
        this.f1516a = strokeSprite;
        this.f1517b = strokeSprite.m1153c();
        this.f1517b.setAlpha(160);
        this.f1520e = strokeSprite.m1158e();
        this.f1521f = strokeSprite.m1156d();
        this.f1518c = this.f1517b.m1422b();
        this.f1519d = new RectF();
        this.f1524i = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
    }

    @Override // com.samsung.sdraw.InterfaceC1033bs
    /* renamed from: a */
    public RectF mo1374a(int i, boolean z) {
        if (i != -1) {
            this.f1522g = i == 0 ? 0 : i + 1;
            this.f1523h = this.f1521f.size();
        } else {
            this.f1523h = this.f1521f.size();
        }
        m1373b();
        return this.f1519d;
    }

    @Override // com.samsung.sdraw.InterfaceC1033bs
    /* renamed from: a */
    public void mo1376a(Canvas canvas, RectF rectF) {
        if (this.f1516a.m1169n()) {
            this.f1522g = 0;
            this.f1523h = this.f1521f.size();
        }
        int i = this.f1522g;
        while (true) {
            int i2 = i;
            if (i2 >= this.f1523h) {
                break;
            }
            m1372a(canvas, this.f1521f.get(i2), i2);
            i = i2 + 1;
        }
        if (this.f1516a.m1169n() && this.f1516a.m1150b()) {
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.FILL);
            paint.setStrokeWidth(4.0f);
            paint.setColor(-16711936);
            Iterator<C1043cb> it = this.f1521f.iterator();
            while (it.hasNext()) {
                C1043cb next = it.next();
                canvas.drawPoint(next.x, next.y, paint);
            }
            paint.setColor(-65281);
            paint.setStrokeWidth(4.0f);
            for (int i3 = 0; i3 < this.f1520e.size(); i3++) {
                C1053i c1053i = this.f1520e.get(i3);
                canvas.drawPoint(c1053i.f1744a, c1053i.f1745b, paint);
            }
        }
    }

    /* renamed from: b */
    private RectF m1373b() {
        this.f1519d.set(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET);
        int i = this.f1522g;
        while (true) {
            int i2 = i;
            if (i2 < this.f1523h) {
                this.f1519d.union(m1370a(this.f1521f.get(i2)));
                i = i2 + 1;
            } else {
                Rect rect = new Rect((int) this.f1519d.left, (int) this.f1519d.top, (int) this.f1519d.right, (int) this.f1519d.bottom);
                rect.inset(-1, -1);
                this.f1516a.getBounds().union(new RectF(rect));
                return this.f1519d;
            }
        }
    }

    /* renamed from: a */
    private Matrix m1369a(float f, float f2, float f3, float f4) {
        float f5 = (-this.f1518c.getWidth()) * 0.5f;
        Matrix matrix = new Matrix();
        matrix.setTranslate(f5, f5);
        matrix.postRotate(this.f1524i);
        matrix.postTranslate(f, f2);
        return matrix;
    }

    /* renamed from: a */
    private void m1372a(Canvas canvas, C1043cb c1043cb, int i) {
        C1043cb c1043cb2 = this.f1521f.get(Math.max(0, i - 1));
        this.f1524i = PointF.calculateDegree(c1043cb2.x, c1043cb2.y, c1043cb.x, c1043cb.y);
        Matrix matrixM1369a = m1369a(c1043cb.x, c1043cb.y, c1043cb.f1688h, c1043cb.f1689i);
        Rect rect = new Rect(canvas.getClipBounds());
        canvas.save();
        m1371a(canvas, c1043cb);
        canvas.clipRect(rect, Region.Op.INTERSECT);
        this.f1517b.setAlpha((int) (c1043cb.f1689i * 255.0f));
        canvas.drawBitmap(this.f1518c, matrixM1369a, this.f1517b);
        canvas.restore();
    }

    /* renamed from: a */
    private RectF m1370a(C1043cb c1043cb) {
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

    /* renamed from: a */
    private void m1371a(Canvas canvas, C1043cb c1043cb) {
        float f = c1043cb.f1688h;
        float f2 = c1043cb.x;
        float f3 = c1043cb.y;
        canvas.clipRect(new RectF());
        for (float f4 = f; f4 >= (-f); f4 -= 1.0f) {
            float fSqrt = (float) (2.0d * Math.sqrt((f * f) - (f4 * f4)));
            float f5 = f2 - (fSqrt / 2.0f);
            float f6 = f3 - f4;
            canvas.clipRect(f5, f6, f5 + fSqrt, f6 + 1.0f, Region.Op.UNION);
        }
    }
}
