package com.samsung.sdraw;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;

/* renamed from: com.samsung.sdraw.ab */
/* loaded from: classes.dex */
final class C0989ab extends AbstractSprite {

    /* renamed from: d */
    public float[] f1417d;

    /* renamed from: e */
    public PointF[] f1418e;

    /* renamed from: f */
    public PointF f1419f;

    /* renamed from: g */
    public Point f1420g;

    /* renamed from: h */
    public Bitmap f1421h;

    /* renamed from: i */
    public String f1422i;

    /* renamed from: j */
    public int f1423j;

    /* renamed from: k */
    public int f1424k;

    /* renamed from: l */
    private Paint f1425l;

    /* renamed from: m */
    private Matrix f1426m;

    /* renamed from: n */
    private final int f1427n = 0;

    /* renamed from: o */
    private final int f1428o = 1;

    /* renamed from: p */
    private final int f1429p = 2;

    /* renamed from: q */
    private final int f1430q = 3;

    /* renamed from: r */
    private int f1431r;

    C0989ab() {
    }

    /* renamed from: a */
    public Matrix m1252a(PointF[] pointFArr) {
        Matrix matrix = new Matrix();
        PointF pointF = new PointF();
        pointF.x = (((pointFArr[0].x + pointFArr[1].x) + pointFArr[2].x) + pointFArr[3].x) / 4.0f;
        pointF.y = (((pointFArr[0].y + pointFArr[1].y) + pointFArr[2].y) + pointFArr[3].y) / 4.0f;
        matrix.preRotate(this.f1424k, pointF.x, pointF.y);
        this.f1424k = 0;
        return matrix;
    }

    @Override // com.samsung.sdraw.InterfaceC1008au
    /* renamed from: a */
    public RectF mo1136a() {
        this.f831b = new RectF();
        this.f831b.left = this.f1418e[0].x;
        this.f831b.right = this.f1418e[0].x;
        this.f831b.top = this.f1418e[0].y;
        this.f831b.bottom = this.f1418e[0].y;
        for (int i = 0; i < 4; i++) {
            if (this.f1418e[i].x < this.f831b.left) {
                this.f831b.left = this.f1418e[i].x;
            }
            if (this.f1418e[i].x > this.f831b.right) {
                this.f831b.right = this.f1418e[i].x;
            }
            if (this.f1418e[i].y > this.f831b.bottom) {
                this.f831b.bottom = this.f1418e[i].y;
            }
            if (this.f1418e[i].y < this.f831b.top) {
                this.f831b.top = this.f1418e[i].y;
            }
        }
        return this.f831b;
    }

    /* renamed from: a */
    public PointF[] m1258a(RectF rectF) {
        return new PointF[]{new PointF(rectF.left, rectF.top), new PointF(rectF.right, rectF.top), new PointF(rectF.left, rectF.bottom), new PointF(rectF.right, rectF.bottom)};
    }

    @Override // com.samsung.sdraw.InterfaceC1008au
    /* renamed from: a */
    public void mo1139a(Canvas canvas, RectF rectF) {
        if (this.f1421h != null && !this.f1421h.isRecycled()) {
            this.f1426m = m1252a(this.f1418e);
            this.f1417d = m1251b(this.f1418e);
            this.f1426m.mapPoints(this.f1417d);
            this.f1418e = m1250a(this.f1417d);
            canvas.drawBitmapMesh(this.f1421h, 1, 1, this.f1417d, 0, null, 0, this.f1425l);
        }
    }

    /* renamed from: a */
    private PointF[] m1250a(float[] fArr) {
        return new PointF[]{new PointF(fArr[0], fArr[1]), new PointF(fArr[2], fArr[3]), new PointF(fArr[4], fArr[5]), new PointF(fArr[6], fArr[7])};
    }

    /* renamed from: b */
    private float[] m1251b(PointF[] pointFArr) {
        return new float[]{pointFArr[0].x, pointFArr[0].y, pointFArr[1].x, pointFArr[1].y, pointFArr[2].x, pointFArr[2].y, pointFArr[3].x, pointFArr[3].y};
    }

    @Override // com.samsung.sdraw.AbstractSprite
    public void dispose() {
        if (this.f1421h != null) {
            this.f1421h.recycle();
        }
        this.f1421h = null;
    }

    /* renamed from: a */
    public void m1255a(int i) {
        this.f1423j = i;
    }

    /* renamed from: b */
    public void m1260b(int i) {
        if (this.f1421h != null) {
            this.f1423j = (this.f1423j + i) % 360;
            this.f1424k = i;
            mo1136a();
        }
    }

    /* renamed from: a */
    public void m1254a(float f, float f2, int i, int i2, int i3, int i4) {
        this.f1419f = new PointF(f, f2);
        this.f1420g = new Point(i, i2);
        this.f1418e = m1258a(new RectF(f, f2, i + f, i2 + f2));
        m1260b(0);
        this.f1425l = new Paint();
        this.f1425l.setAntiAlias(true);
        this.f1425l.setDither(true);
        this.f1425l.setStyle(Paint.Style.STROKE);
        this.f1425l.setFilterBitmap(true);
        setLayerID(i3);
        m1265d(i4);
    }

    /* renamed from: a */
    public void m1257a(Bitmap bitmap) {
        if (bitmap != null) {
            if (this.f1421h != null) {
                this.f1421h.recycle();
            }
            if (bitmap.getConfig() != Bitmap.Config.ARGB_8888) {
                Canvas canvas = new Canvas();
                this.f1421h = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
                canvas.setBitmap(this.f1421h);
                canvas.drawBitmap(bitmap, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, new Paint());
                bitmap.recycle();
            } else {
                this.f1421h = bitmap;
            }
            m1260b(0);
        }
    }

    /* renamed from: b */
    public void m1261b(Bitmap bitmap) {
        if (bitmap != null) {
            if (this.f1421h != null) {
                this.f1421h.recycle();
            }
            if (bitmap.getConfig() != Bitmap.Config.ARGB_8888) {
                Canvas canvas = new Canvas();
                this.f1421h = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
                canvas.setBitmap(this.f1421h);
                canvas.drawBitmap(bitmap, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, new Paint());
                bitmap.recycle();
            } else {
                this.f1421h = bitmap;
            }
            m1260b(0);
        }
    }

    @Override // com.samsung.sdraw.AbstractSprite
    public StringBuilder toXML() {
        StringBuilder sb = new StringBuilder();
        RectF rectFM1264d = m1264d();
        Object[] objArr = new Object[12];
        objArr[0] = Float.toString(rectFM1264d.left);
        objArr[1] = Float.toString(rectFM1264d.top);
        objArr[2] = Integer.valueOf((int) rectFM1264d.width());
        objArr[3] = Integer.valueOf((int) rectFM1264d.height());
        objArr[4] = Integer.valueOf(this.f1423j);
        objArr[5] = Integer.valueOf(this.f830a ? 1 : 0);
        objArr[6] = m1249a(this.f1422i);
        objArr[7] = Integer.valueOf(this.objectID);
        objArr[8] = Integer.valueOf(getLayerID());
        objArr[9] = Integer.valueOf(this.multiUserID);
        objArr[10] = Integer.valueOf(this.multiObjectID);
        objArr[11] = Integer.valueOf(this.f1431r);
        sb.append(String.format("<image point=\"%s,%s\" size=\"%d,%d\" angle=\"%d\" visible=\"%d\" extraData=\"%s\" id=\"%d\" layerID=\"%d\" userID=\"%d\" imageID=\"%d\" />", objArr));
        return sb;
    }

    /* renamed from: a */
    private static String m1249a(String str) {
        if (str != null) {
            return str.replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;");
        }
        return str;
    }

    /* renamed from: b */
    public Bitmap m1259b() {
        if (this.f1421h == null) {
            return null;
        }
        Canvas canvas = new Canvas();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(this.f1421h.getWidth(), this.f1421h.getHeight(), Bitmap.Config.ARGB_8888);
        canvas.setBitmap(bitmapCreateBitmap);
        canvas.drawBitmap(this.f1421h, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, new Paint());
        return bitmapCreateBitmap;
    }

    /* renamed from: c */
    public ImageInfo m1262c() {
        ImageInfo imageInfo = new ImageInfo(m1259b(), m1264d(), this.f1423j, getLayerID());
        imageInfo.setID(this.objectID);
        imageInfo.setStyle(this.f1431r);
        imageInfo.setMultiObjectID(this.multiObjectID);
        imageInfo.setMultiUserID(this.multiUserID);
        return imageInfo;
    }

    @Override // com.samsung.sdraw.AbstractSprite, com.samsung.sdraw.InterfaceC1070z
    public boolean isHitted(PointF point) {
        return false;
    }

    /* renamed from: a */
    public void m1253a(float f, float f2) {
        for (int i = 0; i < 4; i++) {
            this.f1418e[i].x += f;
            this.f1418e[i].y += f2;
        }
    }

    /* renamed from: d */
    public RectF m1264d() {
        RectF rectF = new RectF();
        PointF pointF = new PointF();
        pointF.x = (((this.f1418e[0].x + this.f1418e[1].x) + this.f1418e[2].x) + this.f1418e[3].x) / 4.0f;
        pointF.y = (((this.f1418e[0].y + this.f1418e[1].y) + this.f1418e[2].y) + this.f1418e[3].y) / 4.0f;
        rectF.left = pointF.x - (m1266e() / 2.0f);
        rectF.right = pointF.x + (m1266e() / 2.0f);
        rectF.top = pointF.y - (m1267f() / 2.0f);
        rectF.bottom = pointF.y + (m1267f() / 2.0f);
        return rectF;
    }

    /* renamed from: e */
    public float m1266e() {
        return PointF.calculateDistance(m1263c(0), m1263c(1));
    }

    /* renamed from: f */
    public float m1267f() {
        return PointF.calculateDistance(m1263c(0), m1263c(2));
    }

    /* renamed from: c */
    public PointF m1263c(int i) {
        return new PointF(this.f1418e[i]);
    }

    /* renamed from: g */
    public PointF[] m1268g() {
        return new PointF[]{new PointF(this.f1418e[0]), new PointF(this.f1418e[1]), new PointF(this.f1418e[2]), new PointF(this.f1418e[3])};
    }

    /* renamed from: a */
    public void m1256a(int i, PointF pointF) {
        this.f1418e[i] = new PointF(pointF);
    }

    /* renamed from: h */
    protected int m1269h() {
        return this.f1431r;
    }

    /* renamed from: d */
    protected void m1265d(int i) {
        if (i == 0 || i == 1) {
            this.f1431r = i;
        }
    }
}
