package com.samsung.sdraw;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import com.samsung.sdraw.StrokeSprite;
import java.util.Vector;

/* renamed from: com.samsung.sdraw.w */
/* loaded from: classes.dex */
class C1067w implements InterfaceC1027bm {

    /* renamed from: a */
    private StrokeSprite f1803a;

    /* renamed from: b */
    private Path f1804b;

    /* renamed from: c */
    private Path f1805c;

    /* renamed from: d */
    private Paint f1806d;

    /* renamed from: e */
    private Paint f1807e;

    /* renamed from: f */
    private C0995ah f1808f;

    /* renamed from: g */
    private int f1809g = 255;

    C1067w() {
    }

    @Override // com.samsung.sdraw.InterfaceC1027bm
    /* renamed from: a */
    public void mo1282a(StrokeSprite strokeSprite) {
        this.f1809g = Math.min(strokeSprite.m1153c().getAlpha() * 2, 255);
        int color = (strokeSprite.m1153c().getColor() & 16777215) | (-16777216);
        this.f1806d = new Paint(strokeSprite.m1153c());
        this.f1806d.setColor(color);
        this.f1807e = new Paint(strokeSprite.m1153c());
        this.f1807e.setColor(color);
        this.f1803a = strokeSprite;
        this.f1804b = new Path();
        this.f1805c = new Path();
        this.f1808f = new C0995ah();
    }

    @Override // com.samsung.sdraw.InterfaceC1027bm
    /* renamed from: a */
    public RectF mo1280a(boolean z) {
        C1053i c1053i;
        C1053i c1053i2;
        int iMax = this.f1803a.m1160f() == StrokeSprite.InputMethod.Hand ? 16 : 8;
        Path path = z ? this.f1804b : this.f1805c;
        Paint paint = z ? this.f1806d : this.f1807e;
        Vector<C1043cb> vectorM1156d = this.f1803a.m1156d();
        Vector<C1053i> vectorM1158e = this.f1803a.m1158e();
        int size = vectorM1156d.size();
        if (size < iMax) {
            return new RectF();
        }
        if (z) {
            c1053i = vectorM1158e.get(1);
            c1053i2 = vectorM1158e.get(2);
        } else {
            int size2 = vectorM1158e.size();
            c1053i = vectorM1158e.get(size2 - 2);
            c1053i2 = vectorM1158e.get(size2 - 1);
        }
        float fAbs = Math.abs(c1053i2.f1744a - c1053i.f1744a);
        float fAbs2 = Math.abs(c1053i2.f1745b - c1053i.f1745b);
        float f = 0.5f * c1053i.f1746c;
        if (fAbs > fAbs2) {
            if (fAbs > f) {
                iMax = (int) (iMax * Math.max(0.1f, c1053i.f1746c / fAbs));
            }
        } else if (fAbs2 > f) {
            iMax = (int) (iMax * Math.max(0.1f, c1053i.f1746c / fAbs2));
        }
        int iMax2 = Math.max(1, iMax);
        boolean zCalculateDirection = PointF.calculateDirection(c1053i.f1744a, c1053i.f1745b, c1053i2.f1744a, c1053i2.f1745b);
        path.reset();
        m1635a(z, path, zCalculateDirection, Math.min(3.5f, this.f1803a.m1153c().getStrokeWidth() / 4.0f), 10, vectorM1156d.get(z ? 0 : size - 1), vectorM1156d.get(z ? 1 : size - 2));
        m1634a(z, iMax2, path, paint, vectorM1156d, size);
        RectF rectF = new RectF();
        path.computeBounds(rectF, false);
        return rectF;
    }

    /* renamed from: a */
    protected void m1634a(boolean z, int i, Path path, Paint paint, Vector<C1043cb> vector, int i2) {
        int iMax;
        int i3;
        int i4;
        if (z) {
            iMax = 0;
            i3 = i - 1;
        } else {
            int i5 = i2 - 1;
            iMax = Math.max(0, i5 - i);
            i3 = i5;
        }
        if (!vector.isEmpty()) {
            C1043cb c1043cb = vector.get(iMax);
            path.moveTo(c1043cb.x, c1043cb.y);
            for (int i6 = iMax; i6 <= i3; i6++) {
                C1043cb c1043cb2 = vector.get(i6);
                path.lineTo(c1043cb2.f1683c, c1043cb2.f1684d);
            }
            for (int i7 = i3; i7 >= iMax; i7--) {
                C1043cb c1043cb3 = vector.get(i7);
                path.lineTo(c1043cb3.f1685e, c1043cb3.f1686f);
            }
            path.close();
            C1043cb c1043cb4 = vector.get(iMax);
            C1043cb c1043cb5 = vector.get(i3);
            int color = paint.getColor() & 16777215;
            if (z) {
                i4 = (this.f1809g << 24) | color;
            } else {
                i4 = color;
                color = (this.f1809g << 24) | color;
            }
            paint.setShader(new LinearGradient(c1043cb4.x, c1043cb4.y, c1043cb5.x, c1043cb5.y, i4, color, Shader.TileMode.MIRROR));
        }
    }

    /* renamed from: a */
    protected void m1635a(boolean z, Path path, boolean z2, float f, int i, C1043cb c1043cb, C1043cb c1043cb2) {
        int strokeWidth = (int) (this.f1803a.m1153c().getStrokeWidth() * i);
        path.moveTo(c1043cb.f1683c, c1043cb.f1684d);
        for (int i2 = 1; i2 <= strokeWidth; i2++) {
            float f2 = i2 / strokeWidth;
            float fM1410a = C1028bn.m1410a(f2, c1043cb.f1683c, c1043cb.f1685e);
            float fM1410a2 = C1028bn.m1410a(f2, c1043cb.f1684d, c1043cb.f1686f);
            float fM1410a3 = C1028bn.m1410a(f2, c1043cb2.f1683c, c1043cb2.f1685e);
            float fM1410a4 = C1028bn.m1410a(f2, c1043cb2.f1684d, c1043cb2.f1686f);
            PointF pointFM1521a = new C1043cb(fM1410a3, fM1410a4, 1.0f).m1521a(new C1043cb(fM1410a, fM1410a2, 1.0f), m1633a(f) + PointF.calculateDistance(new PointF(fM1410a, fM1410a2), new PointF(fM1410a3, fM1410a4)));
            path.lineTo(pointFM1521a.x, pointFM1521a.y);
        }
        path.lineTo(c1043cb.f1685e, c1043cb.f1686f);
        path.close();
    }

    @Override // com.samsung.sdraw.InterfaceC1027bm
    /* renamed from: a */
    public void mo1281a(Canvas canvas) {
        canvas.drawPath(this.f1804b, this.f1806d);
        canvas.drawPath(this.f1805c, this.f1807e);
    }

    /* renamed from: a */
    private float m1633a(float f) {
        return Math.abs(this.f1808f.m1279b()) * f;
    }

    @Override // com.samsung.sdraw.InterfaceC1027bm
    /* renamed from: b */
    public Path mo1283b(boolean z) {
        return z ? this.f1804b : this.f1805c;
    }
}
