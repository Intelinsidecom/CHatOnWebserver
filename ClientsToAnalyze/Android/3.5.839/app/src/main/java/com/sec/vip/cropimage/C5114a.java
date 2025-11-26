package com.sec.vip.cropimage;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.sec.chaton.R;

/* compiled from: HighlightView.java */
/* renamed from: com.sec.vip.cropimage.a */
/* loaded from: classes.dex */
public class C5114a {

    /* renamed from: a */
    View f18659a;

    /* renamed from: b */
    boolean f18660b;

    /* renamed from: c */
    boolean f18661c;

    /* renamed from: d */
    Rect f18662d;

    /* renamed from: e */
    RectF f18663e;

    /* renamed from: f */
    Matrix f18664f;

    /* renamed from: l */
    private RectF f18670l;

    /* renamed from: n */
    private float f18672n;

    /* renamed from: p */
    private Drawable f18674p;

    /* renamed from: q */
    private Drawable f18675q;

    /* renamed from: r */
    private Drawable f18676r;

    /* renamed from: s */
    private Drawable f18677s;

    /* renamed from: t */
    private Drawable f18678t;

    /* renamed from: g */
    private int f18665g = 1000;

    /* renamed from: h */
    private int f18666h = 2000;

    /* renamed from: i */
    private Bitmap f18667i = null;

    /* renamed from: j */
    private Matrix f18668j = null;

    /* renamed from: k */
    private EnumC5115b f18669k = EnumC5115b.None;

    /* renamed from: m */
    private boolean f18671m = false;

    /* renamed from: o */
    private boolean f18673o = false;

    /* renamed from: u */
    private final Paint f18679u = new Paint();

    /* renamed from: v */
    private final Paint f18680v = new Paint();

    /* renamed from: w */
    private final Paint f18681w = new Paint();

    public C5114a(View view) {
        this.f18659a = view;
    }

    /* renamed from: d */
    private void m19571d() {
        Resources resources = this.f18659a.getResources();
        this.f18674p = resources.getDrawable(R.drawable.gridview_selector_selected);
        this.f18675q = resources.getDrawable(R.drawable.ams_ics_selector_image_crop_w);
        this.f18676r = resources.getDrawable(R.drawable.ams_ics_selector_image_crop_h);
        this.f18677s = resources.getDrawable(R.drawable.indicator_autocrop);
        if (this.f18665g != 1000) {
            m19568a(resources);
        } else if (this.f18666h != 2000) {
            m19570b(resources);
        } else {
            this.f18678t = null;
        }
    }

    /* renamed from: a */
    private void m19568a(Resources resources) {
        switch (this.f18665g) {
            case 1001:
                this.f18678t = resources.getDrawable(R.drawable.template_roundrect);
                break;
            case 1002:
                this.f18678t = resources.getDrawable(R.drawable.template_circle);
                break;
            case 1003:
                this.f18678t = resources.getDrawable(R.drawable.template_star);
                break;
            case 1004:
                this.f18678t = resources.getDrawable(R.drawable.template_heart);
                break;
            default:
                this.f18678t = null;
                break;
        }
    }

    /* renamed from: b */
    private void m19570b(Resources resources) {
        switch (this.f18666h) {
            case 2006:
                this.f18678t = resources.getDrawable(R.drawable.template_polaroid);
                break;
            case 2007:
                this.f18678t = resources.getDrawable(R.drawable.template_vignetting);
                break;
            default:
                this.f18678t = null;
                break;
        }
    }

    /* renamed from: a */
    public boolean m19579a() {
        return this.f18660b;
    }

    /* renamed from: a */
    public void m19578a(boolean z) {
        this.f18660b = z;
    }

    /* renamed from: a */
    protected void m19575a(Canvas canvas) throws Throwable {
        m19569a(canvas, this.f18667i);
        if (!this.f18661c) {
            canvas.save();
            Path path = new Path();
            if (!m19579a()) {
                this.f18681w.setColor(-16777216);
                canvas.drawRect(this.f18662d, this.f18681w);
                return;
            }
            Rect rect = new Rect();
            this.f18659a.getDrawingRect(rect);
            if (this.f18673o) {
                float fWidth = this.f18662d.width();
                path.addCircle(this.f18662d.left + (fWidth / 2.0f), (this.f18662d.height() / 2.0f) + this.f18662d.top, fWidth / 2.0f, Path.Direction.CW);
                this.f18681w.setColor(-1112874);
            } else {
                if (this.f18678t != null) {
                    this.f18678t.setBounds(this.f18662d.left, this.f18662d.top, this.f18662d.right, this.f18662d.bottom);
                    this.f18678t.draw(canvas);
                }
                path.addRect(new RectF(this.f18662d), Path.Direction.CW);
            }
            canvas.clipPath(path, Region.Op.DIFFERENCE);
            canvas.drawRect(rect, m19579a() ? this.f18679u : this.f18680v);
            canvas.restore();
            this.f18681w.setColor(0);
            canvas.drawPath(path, this.f18681w);
            this.f18674p.setBounds(new Rect(this.f18662d.left, this.f18662d.top, this.f18662d.right, this.f18662d.bottom));
            this.f18674p.draw(canvas);
            if (this.f18669k == EnumC5115b.Grow) {
                int[] iArr = {android.R.attr.state_pressed};
                this.f18675q.setState(iArr);
                this.f18676r.setState(iArr);
            } else {
                int[] iArr2 = {-16842919};
                this.f18675q.setState(iArr2);
                this.f18676r.setState(iArr2);
            }
            if (this.f18673o) {
                int intrinsicWidth = this.f18677s.getIntrinsicWidth();
                int intrinsicHeight = this.f18677s.getIntrinsicHeight();
                int iRound = (int) Math.round(Math.cos(0.7853981633974483d) * (this.f18662d.width() / 2.0d));
                int iWidth = ((this.f18662d.left + (this.f18662d.width() / 2)) + iRound) - (intrinsicWidth / 2);
                int iHeight = ((this.f18662d.top + (this.f18662d.height() / 2)) - iRound) - (intrinsicHeight / 2);
                this.f18677s.setBounds(iWidth, iHeight, this.f18677s.getIntrinsicWidth() + iWidth, this.f18677s.getIntrinsicHeight() + iHeight);
                this.f18677s.draw(canvas);
                return;
            }
            int i = this.f18662d.left + 1;
            int i2 = this.f18662d.right + 1;
            int i3 = this.f18662d.top + 1;
            int i4 = this.f18662d.bottom + 1;
            int intrinsicWidth2 = this.f18675q.getIntrinsicWidth() / 2;
            int intrinsicHeight2 = this.f18675q.getIntrinsicHeight() / 2;
            int intrinsicHeight3 = this.f18676r.getIntrinsicHeight() / 2;
            int intrinsicWidth3 = this.f18676r.getIntrinsicWidth() / 2;
            int i5 = this.f18662d.left + ((this.f18662d.right - this.f18662d.left) / 2);
            int i6 = this.f18662d.top + ((this.f18662d.bottom - this.f18662d.top) / 2);
            this.f18675q.setBounds(i - intrinsicWidth2, i6 - intrinsicHeight2, i + intrinsicWidth2, i6 + intrinsicHeight2);
            this.f18675q.draw(canvas);
            this.f18675q.setBounds(i2 - intrinsicWidth2, i6 - intrinsicHeight2, i2 + intrinsicWidth2, i6 + intrinsicHeight2);
            this.f18675q.draw(canvas);
            this.f18676r.setBounds(i5 - intrinsicWidth3, i3 - intrinsicHeight3, i5 + intrinsicWidth3, i3 + intrinsicHeight3);
            this.f18676r.draw(canvas);
            this.f18676r.setBounds(i5 - intrinsicWidth3, i4 - intrinsicHeight3, i5 + intrinsicWidth3, i4 + intrinsicHeight3);
            this.f18676r.draw(canvas);
        }
    }

    /* renamed from: a */
    public void m19577a(EnumC5115b enumC5115b) {
        if (enumC5115b != this.f18669k) {
            this.f18669k = enumC5115b;
            this.f18659a.invalidate();
        }
    }

    /* renamed from: a */
    public int m19573a(float f, float f2) {
        boolean z = false;
        Rect rectM19572e = m19572e();
        if (this.f18673o) {
            float fCenterX = f - rectM19572e.centerX();
            float fCenterY = f2 - rectM19572e.centerY();
            int iSqrt = (int) Math.sqrt((fCenterX * fCenterX) + (fCenterY * fCenterY));
            int iWidth = this.f18662d.width() / 2;
            if (Math.abs(iSqrt - iWidth) > 40.0f) {
                return iSqrt >= iWidth ? 1 : 32;
            }
            if (Math.abs(fCenterY) > Math.abs(fCenterX)) {
                if (fCenterY < 0.0f) {
                    return 8;
                }
                return 16;
            }
            if (fCenterX < 0.0f) {
                return 2;
            }
            return 4;
        }
        boolean z2 = f2 >= ((float) rectM19572e.top) - 40.0f && f2 < ((float) rectM19572e.bottom) + 40.0f;
        if (f >= rectM19572e.left - 40.0f && f < rectM19572e.right + 40.0f) {
            z = true;
        }
        int i = (Math.abs(((float) rectM19572e.left) - f) >= 40.0f || !z2) ? 1 : 3;
        if (Math.abs(rectM19572e.right - f) < 40.0f && z2) {
            i |= 4;
        }
        if (Math.abs(rectM19572e.top - f2) < 40.0f && z) {
            i |= 8;
        }
        int i2 = (Math.abs(((float) rectM19572e.bottom) - f2) >= 40.0f || !z) ? i : i | 16;
        if (i2 == 1 && rectM19572e.contains((int) f, (int) f2)) {
            return 32;
        }
        return i2;
    }

    /* renamed from: a */
    void m19574a(int i, float f, float f2) throws Resources.NotFoundException {
        Rect rectM19572e = m19572e();
        if (i != 1) {
            if (i == 32) {
                m19581b((this.f18663e.width() / rectM19572e.width()) * f, (this.f18663e.height() / rectM19572e.height()) * f2);
                return;
            }
            if ((i & 6) == 0) {
                f = 0.0f;
            }
            if ((i & 24) == 0) {
                f2 = 0.0f;
            }
            m19583c(f * (this.f18663e.width() / rectM19572e.width()) * ((i & 2) != 0 ? -1 : 1), ((i & 8) != 0 ? -1 : 1) * f2 * (this.f18663e.height() / rectM19572e.height()));
        }
    }

    /* renamed from: b */
    void m19581b(float f, float f2) throws Resources.NotFoundException {
        Rect rect = new Rect(this.f18662d);
        this.f18663e.offset(f, f2);
        this.f18663e.offset(Math.max(0.0f, this.f18670l.left - this.f18663e.left), Math.max(0.0f, this.f18670l.top - this.f18663e.top));
        this.f18663e.offset(Math.min(0.0f, this.f18670l.right - this.f18663e.right), Math.min(0.0f, this.f18670l.bottom - this.f18663e.bottom));
        this.f18662d = m19572e();
        rect.union(this.f18662d);
        int dimensionPixelSize = this.f18659a.getResources().getDimensionPixelSize(R.dimen.ams_ics_crop_image_outline_offset);
        rect.inset(-dimensionPixelSize, -dimensionPixelSize);
        this.f18659a.invalidate();
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x010f A[PHI: r9
  0x010f: PHI (r9v2 float) = (r9v1 float), (r9v1 float), (r9v3 float) binds: [B:8:0x001a, B:10:0x002b, B:12:0x003c] A[DONT_GENERATE, DONT_INLINE]] */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void m19583c(float r9, float r10) {
        /*
            Method dump skipped, instructions count: 275
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.vip.cropimage.C5114a.m19583c(float, float):void");
    }

    /* renamed from: b */
    public Rect m19580b() {
        return new Rect((int) this.f18663e.left, (int) this.f18663e.top, (int) this.f18663e.right, (int) this.f18663e.bottom);
    }

    /* renamed from: e */
    private Rect m19572e() {
        RectF rectF = new RectF(this.f18663e.left, this.f18663e.top, this.f18663e.right, this.f18663e.bottom);
        this.f18664f.mapRect(rectF);
        return new Rect(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
    }

    /* renamed from: c */
    public void m19582c() {
        this.f18662d = m19572e();
    }

    /* renamed from: a */
    public void m19576a(Matrix matrix, Rect rect, RectF rectF, boolean z, int i, int i2, boolean z2) {
        if (z) {
            z2 = true;
        }
        this.f18664f = new Matrix(matrix);
        this.f18663e = rectF;
        this.f18670l = new RectF(rect);
        this.f18671m = z2;
        this.f18673o = z;
        this.f18665g = i;
        this.f18666h = i2;
        this.f18672n = this.f18663e.width() / this.f18663e.height();
        this.f18662d = m19572e();
        this.f18679u.setARGB(0, 0, 0, 0);
        this.f18680v.setARGB(0, 0, 0, 0);
        this.f18681w.setStrokeWidth(3.0f);
        this.f18681w.setStyle(Paint.Style.STROKE);
        this.f18681w.setAntiAlias(true);
        this.f18669k = EnumC5115b.None;
        m19571d();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m19569a(android.graphics.Canvas r10, android.graphics.Bitmap r11) throws java.lang.Throwable {
        /*
            r9 = this;
            r7 = 0
            r0 = 1
            if (r11 == 0) goto L53
            android.graphics.Paint r8 = new android.graphics.Paint
            r8.<init>()
            r8.setAntiAlias(r0)
            r8.setDither(r0)
            r8.setFilterBitmap(r0)
            android.graphics.Rect r0 = new android.graphics.Rect
            android.graphics.RectF r1 = r9.f18663e
            float r1 = r1.left
            int r1 = java.lang.Math.round(r1)
            android.graphics.RectF r2 = r9.f18663e
            float r2 = r2.top
            int r2 = java.lang.Math.round(r2)
            android.graphics.RectF r3 = r9.f18663e
            float r3 = r3.right
            int r3 = java.lang.Math.round(r3)
            android.graphics.RectF r4 = r9.f18663e
            float r4 = r4.bottom
            int r4 = java.lang.Math.round(r4)
            r0.<init>(r1, r2, r3, r4)
            int r1 = r0.left     // Catch: java.lang.OutOfMemoryError -> L54 java.lang.Throwable -> L75
            int r2 = r0.top     // Catch: java.lang.OutOfMemoryError -> L54 java.lang.Throwable -> L75
            int r3 = r0.width()     // Catch: java.lang.OutOfMemoryError -> L54 java.lang.Throwable -> L75
            int r4 = r0.height()     // Catch: java.lang.OutOfMemoryError -> L54 java.lang.Throwable -> L75
            android.graphics.Matrix r5 = r9.f18668j     // Catch: java.lang.OutOfMemoryError -> L54 java.lang.Throwable -> L75
            r6 = 1
            r0 = r11
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r0, r1, r2, r3, r4, r5, r6)     // Catch: java.lang.OutOfMemoryError -> L54 java.lang.Throwable -> L75
            r1 = 0
            android.graphics.Rect r2 = r9.f18662d     // Catch: java.lang.Throwable -> L7c java.lang.OutOfMemoryError -> L80
            r10.drawBitmap(r0, r1, r2, r8)     // Catch: java.lang.Throwable -> L7c java.lang.OutOfMemoryError -> L80
            if (r0 != 0) goto L79
        L53:
            return
        L54:
            r0 = move-exception
            r0 = r7
        L56:
            android.view.View r1 = r9.f18659a     // Catch: java.lang.Throwable -> L7c
            android.content.Context r1 = r1.getContext()     // Catch: java.lang.Throwable -> L7c
            r2 = 2131427987(0x7f0b0293, float:1.8477606E38)
            r3 = 0
            android.widget.Toast r1 = com.sec.widget.C5179v.m19810a(r1, r2, r3)     // Catch: java.lang.Throwable -> L7c
            r1.show()     // Catch: java.lang.Throwable -> L7c
            if (r0 == 0) goto L53
            if (r11 == r0) goto L53
        L6b:
            r0.recycle()
            goto L53
        L6f:
            if (r11 == r7) goto L74
            r7.recycle()
        L74:
            throw r0
        L75:
            r0 = move-exception
        L76:
            if (r7 != 0) goto L6f
            goto L53
        L79:
            if (r11 == r0) goto L53
            goto L6b
        L7c:
            r1 = move-exception
            r7 = r0
            r0 = r1
            goto L76
        L80:
            r1 = move-exception
            goto L56
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.vip.cropimage.C5114a.m19569a(android.graphics.Canvas, android.graphics.Bitmap):void");
    }
}
