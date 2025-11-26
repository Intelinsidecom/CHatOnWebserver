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
/* renamed from: com.sec.vip.cropimage.o */
/* loaded from: classes.dex */
public class C3619o {

    /* renamed from: a */
    View f13301a;

    /* renamed from: b */
    boolean f13302b;

    /* renamed from: c */
    boolean f13303c;

    /* renamed from: d */
    Rect f13304d;

    /* renamed from: e */
    RectF f13305e;

    /* renamed from: f */
    Matrix f13306f;

    /* renamed from: l */
    private RectF f13312l;

    /* renamed from: n */
    private float f13314n;

    /* renamed from: p */
    private Drawable f13316p;

    /* renamed from: q */
    private Drawable f13317q;

    /* renamed from: r */
    private Drawable f13318r;

    /* renamed from: s */
    private Drawable f13319s;

    /* renamed from: t */
    private Drawable f13320t;

    /* renamed from: g */
    private int f13307g = 1000;

    /* renamed from: h */
    private int f13308h = 2000;

    /* renamed from: i */
    private Bitmap f13309i = null;

    /* renamed from: j */
    private Matrix f13310j = null;

    /* renamed from: k */
    private EnumC3620p f13311k = EnumC3620p.None;

    /* renamed from: m */
    private boolean f13313m = false;

    /* renamed from: o */
    private boolean f13315o = false;

    /* renamed from: u */
    private final Paint f13321u = new Paint();

    /* renamed from: v */
    private final Paint f13322v = new Paint();

    /* renamed from: w */
    private final Paint f13323w = new Paint();

    public C3619o(View view) {
        this.f13301a = view;
    }

    /* renamed from: d */
    private void m13001d() {
        Resources resources = this.f13301a.getResources();
        this.f13316p = resources.getDrawable(R.drawable.gridview_selector_selected);
        this.f13317q = resources.getDrawable(R.drawable.ams_ics_selector_image_crop_w);
        this.f13318r = resources.getDrawable(R.drawable.ams_ics_selector_image_crop_h);
        this.f13319s = resources.getDrawable(R.drawable.indicator_autocrop);
        if (this.f13307g != 1000) {
            m12998a(resources);
        } else if (this.f13308h != 2000) {
            m13000b(resources);
        } else {
            this.f13320t = null;
        }
    }

    /* renamed from: a */
    private void m12998a(Resources resources) {
        switch (this.f13307g) {
            case 1001:
                this.f13320t = resources.getDrawable(R.drawable.template_roundrect);
                break;
            case 1002:
                this.f13320t = resources.getDrawable(R.drawable.template_circle);
                break;
            case 1003:
                this.f13320t = resources.getDrawable(R.drawable.template_star);
                break;
            case 1004:
                this.f13320t = resources.getDrawable(R.drawable.template_heart);
                break;
            default:
                this.f13320t = null;
                break;
        }
    }

    /* renamed from: b */
    private void m13000b(Resources resources) {
        switch (this.f13308h) {
            case 2006:
                this.f13320t = resources.getDrawable(R.drawable.template_polaroid);
                break;
            case 2007:
                this.f13320t = resources.getDrawable(R.drawable.template_vignetting);
                break;
            default:
                this.f13320t = null;
                break;
        }
    }

    /* renamed from: a */
    public boolean m13012a() {
        return this.f13302b;
    }

    /* renamed from: a */
    public void m13011a(boolean z) {
        this.f13302b = z;
    }

    /* renamed from: a */
    protected void m13008a(Canvas canvas) throws Throwable {
        m12999a(canvas, this.f13309i);
        if (!this.f13303c) {
            canvas.save();
            Path path = new Path();
            if (!m13012a()) {
                this.f13323w.setColor(-16777216);
                canvas.drawRect(this.f13304d, this.f13323w);
                return;
            }
            Rect rect = new Rect();
            this.f13301a.getDrawingRect(rect);
            if (this.f13315o) {
                float fWidth = this.f13304d.width();
                path.addCircle(this.f13304d.left + (fWidth / 2.0f), (this.f13304d.height() / 2.0f) + this.f13304d.top, fWidth / 2.0f, Path.Direction.CW);
                this.f13323w.setColor(-1112874);
            } else {
                if (this.f13320t != null) {
                    this.f13320t.setBounds(this.f13304d.left, this.f13304d.top, this.f13304d.right, this.f13304d.bottom);
                    this.f13320t.draw(canvas);
                }
                path.addRect(new RectF(this.f13304d), Path.Direction.CW);
            }
            canvas.clipPath(path, Region.Op.DIFFERENCE);
            canvas.drawRect(rect, m13012a() ? this.f13321u : this.f13322v);
            canvas.restore();
            this.f13323w.setColor(0);
            canvas.drawPath(path, this.f13323w);
            this.f13316p.setBounds(new Rect(this.f13304d.left, this.f13304d.top, this.f13304d.right, this.f13304d.bottom));
            this.f13316p.draw(canvas);
            if (this.f13311k == EnumC3620p.Grow) {
                int[] iArr = {android.R.attr.state_pressed};
                this.f13317q.setState(iArr);
                this.f13318r.setState(iArr);
            } else {
                int[] iArr2 = {-16842919};
                this.f13317q.setState(iArr2);
                this.f13318r.setState(iArr2);
            }
            if (this.f13315o) {
                int intrinsicWidth = this.f13319s.getIntrinsicWidth();
                int intrinsicHeight = this.f13319s.getIntrinsicHeight();
                int iRound = (int) Math.round(Math.cos(0.7853981633974483d) * (this.f13304d.width() / 2.0d));
                int iWidth = ((this.f13304d.left + (this.f13304d.width() / 2)) + iRound) - (intrinsicWidth / 2);
                int iHeight = ((this.f13304d.top + (this.f13304d.height() / 2)) - iRound) - (intrinsicHeight / 2);
                this.f13319s.setBounds(iWidth, iHeight, this.f13319s.getIntrinsicWidth() + iWidth, this.f13319s.getIntrinsicHeight() + iHeight);
                this.f13319s.draw(canvas);
                return;
            }
            int i = this.f13304d.left + 1;
            int i2 = this.f13304d.right + 1;
            int i3 = this.f13304d.top + 1;
            int i4 = this.f13304d.bottom + 1;
            int intrinsicWidth2 = this.f13317q.getIntrinsicWidth() / 2;
            int intrinsicHeight2 = this.f13317q.getIntrinsicHeight() / 2;
            int intrinsicHeight3 = this.f13318r.getIntrinsicHeight() / 2;
            int intrinsicWidth3 = this.f13318r.getIntrinsicWidth() / 2;
            int i5 = this.f13304d.left + ((this.f13304d.right - this.f13304d.left) / 2);
            int i6 = this.f13304d.top + ((this.f13304d.bottom - this.f13304d.top) / 2);
            this.f13317q.setBounds(i - intrinsicWidth2, i6 - intrinsicHeight2, i + intrinsicWidth2, i6 + intrinsicHeight2);
            this.f13317q.draw(canvas);
            this.f13317q.setBounds(i2 - intrinsicWidth2, i6 - intrinsicHeight2, i2 + intrinsicWidth2, i6 + intrinsicHeight2);
            this.f13317q.draw(canvas);
            this.f13318r.setBounds(i5 - intrinsicWidth3, i3 - intrinsicHeight3, i5 + intrinsicWidth3, i3 + intrinsicHeight3);
            this.f13318r.draw(canvas);
            this.f13318r.setBounds(i5 - intrinsicWidth3, i4 - intrinsicHeight3, i5 + intrinsicWidth3, i4 + intrinsicHeight3);
            this.f13318r.draw(canvas);
        }
    }

    /* renamed from: a */
    public void m13010a(EnumC3620p enumC3620p) {
        if (enumC3620p != this.f13311k) {
            this.f13311k = enumC3620p;
            this.f13301a.invalidate();
        }
    }

    /* renamed from: a */
    public int m13003a(float f, float f2) {
        boolean z = false;
        Rect rectM13002e = m13002e();
        if (this.f13315o) {
            float fCenterX = f - rectM13002e.centerX();
            float fCenterY = f2 - rectM13002e.centerY();
            int iSqrt = (int) Math.sqrt((fCenterX * fCenterX) + (fCenterY * fCenterY));
            int iWidth = this.f13304d.width() / 2;
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
        boolean z2 = f2 >= ((float) rectM13002e.top) - 40.0f && f2 < ((float) rectM13002e.bottom) + 40.0f;
        if (f >= rectM13002e.left - 40.0f && f < rectM13002e.right + 40.0f) {
            z = true;
        }
        int i = (Math.abs(((float) rectM13002e.left) - f) >= 40.0f || !z2) ? 1 : 3;
        if (Math.abs(rectM13002e.right - f) < 40.0f && z2) {
            i |= 4;
        }
        if (Math.abs(rectM13002e.top - f2) < 40.0f && z) {
            i |= 8;
        }
        int i2 = (Math.abs(((float) rectM13002e.bottom) - f2) >= 40.0f || !z) ? i : i | 16;
        if (i2 == 1 && rectM13002e.contains((int) f, (int) f2)) {
            return 32;
        }
        return i2;
    }

    /* renamed from: a */
    void m13005a(int i, float f, float f2) throws Resources.NotFoundException {
        Rect rectM13002e = m13002e();
        if (i != 1) {
            if (i == 32) {
                m13014b((this.f13305e.width() / rectM13002e.width()) * f, (this.f13305e.height() / rectM13002e.height()) * f2);
                return;
            }
            if ((i & 6) == 0) {
                f = 0.0f;
            }
            if ((i & 24) == 0) {
                f2 = 0.0f;
            }
            m13016c(f * (this.f13305e.width() / rectM13002e.width()) * ((i & 2) != 0 ? -1 : 1), ((i & 8) != 0 ? -1 : 1) * f2 * (this.f13305e.height() / rectM13002e.height()));
        }
    }

    /* renamed from: a */
    void m13006a(int i, float f, float f2, float f3) throws Resources.NotFoundException {
        float f4;
        float f5;
        float f6 = 0.0f;
        Rect rectM13002e = m13002e();
        if (i != 1) {
            if (i == 32) {
                if (f3 == 90.0f || f3 == 270.0f) {
                    m13014b((this.f13305e.width() / rectM13002e.height()) * f, (this.f13305e.height() / rectM13002e.width()) * f2);
                    return;
                } else {
                    m13014b((this.f13305e.width() / rectM13002e.width()) * f, (this.f13305e.height() / rectM13002e.height()) * f2);
                    return;
                }
            }
            if (f3 == 90.0f || f3 == 270.0f) {
                float f7 = (i & 6) == 0 ? 0.0f : f;
                if ((i & 24) == 0) {
                    f2 = 0.0f;
                }
                f6 = f7;
            } else {
                float f8 = (i & 6) == 0 ? 0.0f : f;
                if ((i & 24) == 0) {
                    f2 = f8;
                } else {
                    f6 = f2;
                    f2 = f8;
                }
            }
            float fWidth = (this.f13305e.width() / rectM13002e.width()) * f2;
            float fHeight = (this.f13305e.height() / rectM13002e.height()) * f6;
            if (f3 == 90.0f || f3 == 270.0f) {
                f4 = fWidth * ((i & 8) != 0 ? -1 : 1);
                f5 = ((i & 2) != 0 ? -1 : 1) * fHeight;
            } else {
                f4 = fWidth * ((i & 2) != 0 ? -1 : 1);
                f5 = ((i & 8) == 0 ? 1 : -1) * fHeight;
            }
            m13016c(f4, f5);
        }
    }

    /* renamed from: b */
    void m13014b(float f, float f2) throws Resources.NotFoundException {
        Rect rect = new Rect(this.f13304d);
        this.f13305e.offset(f, f2);
        this.f13305e.offset(Math.max(0.0f, this.f13312l.left - this.f13305e.left), Math.max(0.0f, this.f13312l.top - this.f13305e.top));
        this.f13305e.offset(Math.min(0.0f, this.f13312l.right - this.f13305e.right), Math.min(0.0f, this.f13312l.bottom - this.f13305e.bottom));
        this.f13304d = m13002e();
        rect.union(this.f13304d);
        int dimensionPixelSize = this.f13301a.getResources().getDimensionPixelSize(R.dimen.ams_ics_crop_image_outline_offset);
        rect.inset(-dimensionPixelSize, -dimensionPixelSize);
        this.f13301a.invalidate();
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x010f A[PHI: r9
  0x010f: PHI (r9v2 float) = (r9v1 float), (r9v1 float), (r9v3 float) binds: [B:8:0x001a, B:10:0x002b, B:12:0x003c] A[DONT_GENERATE, DONT_INLINE]] */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void m13016c(float r9, float r10) {
        /*
            Method dump skipped, instructions count: 275
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.vip.cropimage.C3619o.m13016c(float, float):void");
    }

    /* renamed from: b */
    public Rect m13013b() {
        return new Rect((int) this.f13305e.left, (int) this.f13305e.top, (int) this.f13305e.right, (int) this.f13305e.bottom);
    }

    /* renamed from: e */
    private Rect m13002e() {
        RectF rectF = new RectF(this.f13305e.left, this.f13305e.top, this.f13305e.right, this.f13305e.bottom);
        this.f13306f.mapRect(rectF);
        return new Rect(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
    }

    /* renamed from: c */
    public void m13015c() {
        this.f13304d = m13002e();
    }

    /* renamed from: a */
    public void m13009a(Matrix matrix, Rect rect, RectF rectF, boolean z, int i, int i2, boolean z2) {
        if (z) {
            z2 = true;
        }
        this.f13306f = new Matrix(matrix);
        this.f13305e = rectF;
        this.f13312l = new RectF(rect);
        this.f13313m = z2;
        this.f13315o = z;
        this.f13307g = i;
        this.f13308h = i2;
        this.f13314n = this.f13305e.width() / this.f13305e.height();
        this.f13304d = m13002e();
        this.f13321u.setARGB(0, 0, 0, 0);
        this.f13322v.setARGB(0, 0, 0, 0);
        this.f13323w.setStrokeWidth(3.0f);
        this.f13323w.setStyle(Paint.Style.STROKE);
        this.f13323w.setAntiAlias(true);
        this.f13311k = EnumC3620p.None;
        m13001d();
    }

    /* renamed from: a */
    public void m13004a(int i) {
        this.f13307g = i;
        m13001d();
    }

    /* renamed from: a */
    public void m13007a(Bitmap bitmap, int i, float f) {
        this.f13308h = i;
        this.f13310j = new Matrix();
        this.f13310j.postRotate(f);
        this.f13309i = bitmap;
        m13001d();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m12999a(android.graphics.Canvas r10, android.graphics.Bitmap r11) throws java.lang.Throwable {
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
            android.graphics.RectF r1 = r9.f13305e
            float r1 = r1.left
            int r1 = java.lang.Math.round(r1)
            android.graphics.RectF r2 = r9.f13305e
            float r2 = r2.top
            int r2 = java.lang.Math.round(r2)
            android.graphics.RectF r3 = r9.f13305e
            float r3 = r3.right
            int r3 = java.lang.Math.round(r3)
            android.graphics.RectF r4 = r9.f13305e
            float r4 = r4.bottom
            int r4 = java.lang.Math.round(r4)
            r0.<init>(r1, r2, r3, r4)
            int r1 = r0.left     // Catch: java.lang.OutOfMemoryError -> L54 java.lang.Throwable -> L75
            int r2 = r0.top     // Catch: java.lang.OutOfMemoryError -> L54 java.lang.Throwable -> L75
            int r3 = r0.width()     // Catch: java.lang.OutOfMemoryError -> L54 java.lang.Throwable -> L75
            int r4 = r0.height()     // Catch: java.lang.OutOfMemoryError -> L54 java.lang.Throwable -> L75
            android.graphics.Matrix r5 = r9.f13310j     // Catch: java.lang.OutOfMemoryError -> L54 java.lang.Throwable -> L75
            r6 = 1
            r0 = r11
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r0, r1, r2, r3, r4, r5, r6)     // Catch: java.lang.OutOfMemoryError -> L54 java.lang.Throwable -> L75
            r1 = 0
            android.graphics.Rect r2 = r9.f13304d     // Catch: java.lang.Throwable -> L7c java.lang.OutOfMemoryError -> L80
            r10.drawBitmap(r0, r1, r2, r8)     // Catch: java.lang.Throwable -> L7c java.lang.OutOfMemoryError -> L80
            if (r0 != 0) goto L79
        L53:
            return
        L54:
            r0 = move-exception
            r0 = r7
        L56:
            android.view.View r1 = r9.f13301a     // Catch: java.lang.Throwable -> L7c
            android.content.Context r1 = r1.getContext()     // Catch: java.lang.Throwable -> L7c
            r2 = 2131427655(0x7f0b0147, float:1.8476932E38)
            r3 = 0
            android.widget.Toast r1 = com.sec.widget.C3641ai.m13210a(r1, r2, r3)     // Catch: java.lang.Throwable -> L7c
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
        throw new UnsupportedOperationException("Method not decompiled: com.sec.vip.cropimage.C3619o.m12999a(android.graphics.Canvas, android.graphics.Bitmap):void");
    }
}
