package com.samsung.sdraw;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.samsung.sdraw.StrokeSprite;
import java.util.Iterator;
import java.util.Vector;

/* renamed from: com.samsung.sdraw.ay */
/* loaded from: classes.dex */
class C1012ay implements InterfaceC1033bs {

    /* renamed from: n */
    private static /* synthetic */ int[] f1539n;

    /* renamed from: a */
    private StrokeSprite f1540a;

    /* renamed from: b */
    private Paint f1541b;

    /* renamed from: c */
    private RectF f1542c;

    /* renamed from: d */
    private RectF f1543d;

    /* renamed from: e */
    private Vector<C1053i> f1544e;

    /* renamed from: f */
    private Vector<C1043cb> f1545f;

    /* renamed from: g */
    private Vector<Integer> f1546g;

    /* renamed from: h */
    private C1043cb f1547h;

    /* renamed from: i */
    private InterfaceC1027bm f1548i;

    /* renamed from: j */
    private InterfaceC1029bo f1549j;

    /* renamed from: k */
    private InterfaceC1026bl f1550k;

    /* renamed from: l */
    private Path f1551l;

    /* renamed from: m */
    private Path f1552m;

    C1012ay() {
    }

    /* renamed from: b */
    static /* synthetic */ int[] m1396b() {
        int[] iArr = f1539n;
        if (iArr == null) {
            iArr = new int[StrokeSprite.Type.valuesCustom().length];
            try {
                iArr[StrokeSprite.Type.Blur.ordinal()] = 4;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[StrokeSprite.Type.Brush.ordinal()] = 6;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[StrokeSprite.Type.Emboss.ordinal()] = 5;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[StrokeSprite.Type.Eraser.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[StrokeSprite.Type.Hightlighter.ordinal()] = 3;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[StrokeSprite.Type.Pencil.ordinal()] = 7;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[StrokeSprite.Type.Solid.ordinal()] = 1;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr[StrokeSprite.Type.Zenbrush.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            f1539n = iArr;
        }
        return iArr;
    }

    @Override // com.samsung.sdraw.InterfaceC1033bs
    /* renamed from: a */
    public void mo1377a(StrokeSprite strokeSprite) {
        this.f1540a = strokeSprite;
        this.f1541b = strokeSprite.m1153c();
        this.f1544e = strokeSprite.m1158e();
        this.f1545f = strokeSprite.m1156d();
        this.f1546g = new Vector<>();
        this.f1552m = new Path();
        this.f1551l = new Path();
        this.f1542c = new RectF();
        m1397c();
        m1398d();
    }

    /* renamed from: c */
    private void m1397c() {
        Paint.Join strokeJoin = this.f1541b.getStrokeJoin();
        if (strokeJoin == Paint.Join.ROUND) {
            this.f1549j = new C1010aw();
        } else if (strokeJoin == Paint.Join.BEVEL) {
            this.f1549j = new C0987a();
        }
        Paint.Cap strokeCap = this.f1541b.getStrokeCap();
        if (strokeCap == Paint.Cap.ROUND) {
            this.f1550k = new C1009av();
        } else if (strokeCap == Paint.Cap.SQUARE) {
            this.f1550k = new C1024bj();
        }
    }

    /* renamed from: d */
    private void m1398d() {
        switch (m1396b()[this.f1540a.getType().ordinal()]) {
            case 3:
                this.f1548i = new C1067w();
                break;
            default:
                this.f1548i = new C0996ai();
                break;
        }
        this.f1548i.mo1282a(this.f1540a);
        this.f1543d = new RectF();
    }

    /* renamed from: b */
    public RectF m1400b(int i, boolean z) {
        RectF rectFMo1280a;
        if (this.f1552m == null || this.f1551l == null || this.f1545f.isEmpty()) {
            return new RectF();
        }
        RectF rectF = new RectF();
        this.f1552m.reset();
        if (i == 0) {
            C1053i c1053iFirstElement = this.f1544e.firstElement();
            if (this.f1544e.size() >= 2) {
                rectF = this.f1548i.mo1280a(true);
                this.f1548i.mo1283b(true);
            }
            this.f1551l.moveTo(c1053iFirstElement.f1744a, c1053iFirstElement.f1745b);
            this.f1550k.mo1395a(this.f1540a, this.f1552m, this.f1545f.firstElement());
            rectFMo1280a = rectF;
        } else if (i == -1) {
            if (this.f1545f.isEmpty()) {
                rectFMo1280a = rectF;
            } else {
                this.f1550k.mo1395a(this.f1540a, this.f1552m, this.f1545f.lastElement());
                rectFMo1280a = this.f1548i.mo1280a(false);
            }
        } else if (z) {
            this.f1546g.add(Integer.valueOf(i));
            this.f1549j.mo1204a(this.f1540a, i, this.f1552m, this.f1547h);
            rectFMo1280a = rectF;
        } else {
            this.f1552m.moveTo(this.f1547h.f1685e, this.f1547h.f1686f);
            this.f1552m.lineTo(this.f1547h.f1683c, this.f1547h.f1684d);
            rectFMo1280a = rectF;
        }
        if (i != -1) {
            int size = this.f1545f.size();
            if (size == 1) {
                this.f1552m.close();
                this.f1551l.addPath(this.f1552m);
                this.f1547h = this.f1545f.firstElement();
                return new RectF();
            }
            C1043cb c1043cb = null;
            for (int i2 = i; i2 < size; i2++) {
                c1043cb = this.f1545f.get(i2);
                this.f1552m.lineTo(c1043cb.f1683c, c1043cb.f1684d);
            }
            if (c1043cb != null) {
                this.f1547h = new C1043cb(c1043cb);
            }
            for (int i3 = size - 1; i3 >= i; i3--) {
                C1043cb c1043cb2 = this.f1545f.get(i3);
                this.f1552m.lineTo(c1043cb2.f1685e, c1043cb2.f1686f);
            }
            this.f1552m.close();
        }
        this.f1551l.addPath(this.f1552m);
        m1399e();
        if (i == -1) {
            this.f1552m.reset();
        }
        if (!rectFMo1280a.isEmpty()) {
            this.f1542c.union(rectFMo1280a);
            this.f1542c.union(this.f1543d);
            this.f1540a.getBounds().union(rectFMo1280a);
            this.f1543d = rectFMo1280a;
        }
        return this.f1540a.getType() == StrokeSprite.Type.Blur || this.f1540a.getType() == StrokeSprite.Type.Emboss ? this.f1540a.getBounds() : this.f1542c;
    }

    @Override // com.samsung.sdraw.InterfaceC1033bs
    /* renamed from: a */
    public RectF mo1374a(int i, boolean z) {
        RectF rectFMo1280a;
        if (this.f1552m == null || this.f1551l == null || this.f1545f.isEmpty()) {
            return new RectF();
        }
        RectF rectF = new RectF();
        this.f1552m.reset();
        if (i == 0) {
            C1053i c1053iFirstElement = this.f1544e.firstElement();
            if (this.f1544e.size() >= 2) {
                rectF = this.f1548i.mo1280a(true);
                this.f1548i.mo1283b(true);
            }
            this.f1551l.moveTo(c1053iFirstElement.f1744a, c1053iFirstElement.f1745b);
            this.f1550k.mo1395a(this.f1540a, this.f1552m, this.f1545f.firstElement());
            rectFMo1280a = rectF;
        } else if (i == -1) {
            if (this.f1545f.isEmpty()) {
                rectFMo1280a = rectF;
            } else {
                this.f1550k.mo1395a(this.f1540a, this.f1552m, this.f1545f.lastElement());
                rectFMo1280a = this.f1548i.mo1280a(false);
            }
        } else {
            this.f1546g.add(Integer.valueOf(i));
            if (z) {
                this.f1549j.mo1204a(this.f1540a, i, this.f1552m, this.f1547h);
                rectFMo1280a = rectF;
            } else {
                this.f1552m.moveTo(this.f1547h.f1685e, this.f1547h.f1686f);
                this.f1552m.lineTo(this.f1547h.f1683c, this.f1547h.f1684d);
                rectFMo1280a = rectF;
            }
        }
        if (i != -1) {
            int size = this.f1545f.size();
            if (size == 1) {
                this.f1552m.close();
                this.f1551l.addPath(this.f1552m);
                this.f1547h = this.f1545f.firstElement();
                return new RectF();
            }
            C1043cb c1043cb = null;
            for (int i2 = i; i2 < size; i2++) {
                c1043cb = this.f1545f.get(i2);
                this.f1552m.lineTo(c1043cb.f1683c, c1043cb.f1684d);
            }
            if (c1043cb != null) {
                this.f1547h = new C1043cb(c1043cb);
            }
            for (int i3 = size - 1; i3 >= i; i3--) {
                C1043cb c1043cb2 = this.f1545f.get(i3);
                this.f1552m.lineTo(c1043cb2.f1685e, c1043cb2.f1686f);
            }
            this.f1552m.close();
        }
        if (i == 0) {
            Iterator<Integer> it = this.f1546g.iterator();
            while (it.hasNext()) {
                this.f1549j.mo1204a(this.f1540a, it.next().intValue(), this.f1552m, null);
            }
        }
        this.f1551l.addPath(this.f1552m);
        m1399e();
        if (i == -1) {
            this.f1552m.reset();
            this.f1546g.clear();
            this.f1546g.setSize(0);
            this.f1546g.trimToSize();
        }
        if (!rectFMo1280a.isEmpty()) {
            this.f1542c.union(rectFMo1280a);
            this.f1542c.union(this.f1543d);
            this.f1540a.getBounds().union(rectFMo1280a);
            this.f1543d = rectFMo1280a;
        }
        return this.f1540a.getType() == StrokeSprite.Type.Blur || this.f1540a.getType() == StrokeSprite.Type.Emboss ? this.f1540a.getBounds() : this.f1542c;
    }

    @Override // com.samsung.sdraw.InterfaceC1033bs
    /* renamed from: a */
    public void mo1376a(Canvas canvas, RectF rectF) {
        if (this.f1552m != null && this.f1551l != null && this.f1541b != null) {
            canvas.save();
            if (this.f1540a.m1170o() && !this.f1540a.m1169n()) {
                if (this.f1541b.getStrokeJoin() == Paint.Join.ROUND && this.f1547h != null) {
                    canvas.drawCircle(this.f1547h.x, this.f1547h.y, this.f1547h.f1688h, this.f1541b);
                }
                if (this.f1544e.size() == 4) {
                    this.f1548i.mo1281a(canvas);
                }
                canvas.drawPath(this.f1552m, this.f1541b);
            } else {
                canvas.clipRect(new RectF(rectF));
                this.f1548i.mo1281a(canvas);
                canvas.drawPath(this.f1551l, this.f1541b);
            }
            canvas.restore();
        }
    }

    /* renamed from: e */
    private RectF m1399e() {
        RectF rectF = new RectF();
        float strokeWidth = this.f1540a.getType() == StrokeSprite.Type.Eraser ? this.f1541b.getStrokeWidth() * 2.0f : this.f1541b.getStrokeWidth();
        this.f1552m.computeBounds(rectF, false);
        if (rectF.isEmpty()) {
            return this.f1542c;
        }
        this.f1542c.set(rectF.left, rectF.top, rectF.right, rectF.bottom);
        this.f1542c.sort();
        this.f1542c.inset(-strokeWidth, -strokeWidth);
        this.f1540a.getBounds().union(this.f1542c);
        return this.f1542c;
    }

    @Override // com.samsung.sdraw.InterfaceC1033bs
    /* renamed from: a */
    public void mo1375a() {
        if (this.f1552m != null && this.f1551l != null) {
            this.f1551l.reset();
            this.f1551l = new Path();
            this.f1552m.reset();
            this.f1552m = new Path();
        }
    }
}
