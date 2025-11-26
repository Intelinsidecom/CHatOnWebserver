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
public class C1598o {

    /* renamed from: a */
    View f5621a;

    /* renamed from: b */
    boolean f5622b;

    /* renamed from: c */
    boolean f5623c;

    /* renamed from: d */
    Rect f5624d;

    /* renamed from: e */
    RectF f5625e;

    /* renamed from: f */
    Matrix f5626f;

    /* renamed from: l */
    private RectF f5632l;

    /* renamed from: n */
    private float f5634n;

    /* renamed from: p */
    private Drawable f5636p;

    /* renamed from: q */
    private Drawable f5637q;

    /* renamed from: r */
    private Drawable f5638r;

    /* renamed from: s */
    private Drawable f5639s;

    /* renamed from: t */
    private Drawable f5640t;

    /* renamed from: g */
    private int f5627g = 1000;

    /* renamed from: h */
    private int f5628h = 2000;

    /* renamed from: i */
    private Bitmap f5629i = null;

    /* renamed from: j */
    private Matrix f5630j = null;

    /* renamed from: k */
    private EnumC1564c f5631k = EnumC1564c.None;

    /* renamed from: m */
    private boolean f5633m = false;

    /* renamed from: o */
    private boolean f5635o = false;

    /* renamed from: u */
    private final Paint f5641u = new Paint();

    /* renamed from: v */
    private final Paint f5642v = new Paint();

    /* renamed from: w */
    private final Paint f5643w = new Paint();

    public C1598o(View view) {
        this.f5621a = view;
    }

    /* renamed from: d */
    private void m5820d() {
        Resources resources = this.f5621a.getResources();
        this.f5636p = resources.getDrawable(R.drawable.co_emoti_selected_02);
        this.f5637q = resources.getDrawable(R.drawable.ams_ics_selector_image_crop_h);
        this.f5638r = resources.getDrawable(R.drawable.ams_ics_selector_image_crop_w);
        this.f5639s = resources.getDrawable(R.drawable.indicator_autocrop);
        if (this.f5627g != 1000) {
            m5817a(resources);
        } else if (this.f5628h != 2000) {
            m5819b(resources);
        } else {
            this.f5640t = null;
        }
    }

    /* renamed from: a */
    private void m5817a(Resources resources) {
        switch (this.f5627g) {
            case 1001:
                this.f5640t = resources.getDrawable(R.drawable.template_roundrect);
                break;
            case 1002:
                this.f5640t = resources.getDrawable(R.drawable.template_circle);
                break;
            case 1003:
                this.f5640t = resources.getDrawable(R.drawable.template_star);
                break;
            case 1004:
                this.f5640t = resources.getDrawable(R.drawable.template_heart);
                break;
            default:
                this.f5640t = null;
                break;
        }
    }

    /* renamed from: b */
    private void m5819b(Resources resources) {
        switch (this.f5628h) {
            case 2006:
                this.f5640t = resources.getDrawable(R.drawable.template_polaroid);
                break;
            case 2007:
                this.f5640t = resources.getDrawable(R.drawable.template_vignetting);
                break;
            default:
                this.f5640t = null;
                break;
        }
    }

    /* renamed from: a */
    public boolean m5830a() {
        return this.f5622b;
    }

    /* renamed from: a */
    public void m5829a(boolean z) {
        this.f5622b = z;
    }

    /* renamed from: a */
    protected void m5826a(Canvas canvas) {
        m5818a(canvas, this.f5629i);
        if (!this.f5623c) {
            canvas.save();
            Path path = new Path();
            if (!m5830a()) {
                this.f5643w.setColor(-16777216);
                canvas.drawRect(this.f5624d, this.f5643w);
                return;
            }
            Rect rect = new Rect();
            this.f5621a.getDrawingRect(rect);
            if (this.f5635o) {
                float fWidth = this.f5624d.width();
                path.addCircle(this.f5624d.left + (fWidth / 2.0f), (this.f5624d.height() / 2.0f) + this.f5624d.top, fWidth / 2.0f, Path.Direction.CW);
                this.f5643w.setColor(-1112874);
            } else {
                if (this.f5640t != null) {
                    this.f5640t.setBounds(this.f5624d.left, this.f5624d.top, this.f5624d.right, this.f5624d.bottom);
                    this.f5640t.draw(canvas);
                }
                path.addRect(new RectF(this.f5624d), Path.Direction.CW);
            }
            canvas.clipPath(path, Region.Op.DIFFERENCE);
            canvas.drawRect(rect, m5830a() ? this.f5641u : this.f5642v);
            canvas.restore();
            canvas.drawPath(path, this.f5643w);
            this.f5636p.setBounds(new Rect(this.f5624d.left, this.f5624d.top, this.f5624d.right, this.f5624d.bottom));
            this.f5636p.draw(canvas);
            if (this.f5631k == EnumC1564c.Grow) {
                int[] iArr = {android.R.attr.state_pressed};
                this.f5637q.setState(iArr);
                this.f5638r.setState(iArr);
            } else {
                int[] iArr2 = {-16842919};
                this.f5637q.setState(iArr2);
                this.f5638r.setState(iArr2);
            }
            if (this.f5635o) {
                int intrinsicWidth = this.f5639s.getIntrinsicWidth();
                int intrinsicHeight = this.f5639s.getIntrinsicHeight();
                int iRound = (int) Math.round(Math.cos(0.7853981633974483d) * (this.f5624d.width() / 2.0d));
                int iWidth = ((this.f5624d.left + (this.f5624d.width() / 2)) + iRound) - (intrinsicWidth / 2);
                int iHeight = ((this.f5624d.top + (this.f5624d.height() / 2)) - iRound) - (intrinsicHeight / 2);
                this.f5639s.setBounds(iWidth, iHeight, this.f5639s.getIntrinsicWidth() + iWidth, this.f5639s.getIntrinsicHeight() + iHeight);
                this.f5639s.draw(canvas);
                return;
            }
            int i = this.f5624d.left + 1;
            int i2 = this.f5624d.right + 1;
            int i3 = this.f5624d.top + 1;
            int i4 = this.f5624d.bottom + 1;
            int intrinsicWidth2 = this.f5637q.getIntrinsicWidth() / 2;
            int intrinsicHeight2 = this.f5637q.getIntrinsicHeight() / 2;
            int intrinsicHeight3 = this.f5638r.getIntrinsicHeight() / 2;
            int intrinsicWidth3 = this.f5638r.getIntrinsicWidth() / 2;
            int i5 = this.f5624d.left + ((this.f5624d.right - this.f5624d.left) / 2);
            int i6 = this.f5624d.top + ((this.f5624d.bottom - this.f5624d.top) / 2);
            this.f5637q.setBounds(i - intrinsicWidth2, i6 - intrinsicHeight2, i + intrinsicWidth2, i6 + intrinsicHeight2);
            this.f5637q.draw(canvas);
            this.f5637q.setBounds(i2 - intrinsicWidth2, i6 - intrinsicHeight2, i2 + intrinsicWidth2, i6 + intrinsicHeight2);
            this.f5637q.draw(canvas);
            this.f5638r.setBounds(i5 - intrinsicWidth3, i3 - intrinsicHeight3, i5 + intrinsicWidth3, i3 + intrinsicHeight3);
            this.f5638r.draw(canvas);
            this.f5638r.setBounds(i5 - intrinsicWidth3, i4 - intrinsicHeight3, i5 + intrinsicWidth3, i4 + intrinsicHeight3);
            this.f5638r.draw(canvas);
        }
    }

    /* renamed from: a */
    public void m5828a(EnumC1564c enumC1564c) {
        if (enumC1564c != this.f5631k) {
            this.f5631k = enumC1564c;
            this.f5621a.invalidate();
        }
    }

    /* renamed from: a */
    public int m5822a(float f, float f2) {
        boolean z = false;
        Rect rectM5821e = m5821e();
        if (this.f5635o) {
            float fCenterX = f - rectM5821e.centerX();
            float fCenterY = f2 - rectM5821e.centerY();
            int iSqrt = (int) Math.sqrt((fCenterX * fCenterX) + (fCenterY * fCenterY));
            int iWidth = this.f5624d.width() / 2;
            if (Math.abs(iSqrt - iWidth) > 20.0f) {
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
        boolean z2 = f2 >= ((float) rectM5821e.top) - 20.0f && f2 < ((float) rectM5821e.bottom) + 20.0f;
        if (f >= rectM5821e.left - 20.0f && f < rectM5821e.right + 20.0f) {
            z = true;
        }
        int i = (Math.abs(((float) rectM5821e.left) - f) >= 20.0f || !z2) ? 1 : 3;
        if (Math.abs(rectM5821e.right - f) < 20.0f && z2) {
            i |= 4;
        }
        if (Math.abs(rectM5821e.top - f2) < 20.0f && z) {
            i |= 8;
        }
        int i2 = (Math.abs(((float) rectM5821e.bottom) - f2) >= 20.0f || !z) ? i : i | 16;
        if (i2 == 1 && rectM5821e.contains((int) f, (int) f2)) {
            return 32;
        }
        return i2;
    }

    /* renamed from: a */
    void m5824a(int i, float f, float f2) throws Resources.NotFoundException {
        Rect rectM5821e = m5821e();
        if (i != 1) {
            if (i == 32) {
                m5832b((this.f5625e.width() / rectM5821e.width()) * f, (this.f5625e.height() / rectM5821e.height()) * f2);
                return;
            }
            if ((i & 6) == 0) {
                f = 0.0f;
            }
            if ((i & 24) == 0) {
                f2 = 0.0f;
            }
            m5834c(f * (this.f5625e.width() / rectM5821e.width()) * ((i & 2) != 0 ? -1 : 1), ((i & 8) != 0 ? -1 : 1) * f2 * (this.f5625e.height() / rectM5821e.height()));
        }
    }

    /* renamed from: b */
    void m5832b(float f, float f2) throws Resources.NotFoundException {
        Rect rect = new Rect(this.f5624d);
        this.f5625e.offset(f, f2);
        this.f5625e.offset(Math.max(0.0f, this.f5632l.left - this.f5625e.left), Math.max(0.0f, this.f5632l.top - this.f5625e.top));
        this.f5625e.offset(Math.min(0.0f, this.f5632l.right - this.f5625e.right), Math.min(0.0f, this.f5632l.bottom - this.f5625e.bottom));
        this.f5624d = m5821e();
        rect.union(this.f5624d);
        int dimensionPixelSize = this.f5621a.getResources().getDimensionPixelSize(R.dimen.ams_ics_crop_image_outline_offset);
        rect.inset(-dimensionPixelSize, -dimensionPixelSize);
        this.f5621a.invalidate();
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x010f A[PHI: r9
  0x010f: PHI (r9v2 float) = (r9v1 float), (r9v1 float), (r9v3 float) binds: [B:8:0x001a, B:10:0x002b, B:12:0x003c] A[DONT_GENERATE, DONT_INLINE]] */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void m5834c(float r9, float r10) {
        /*
            Method dump skipped, instructions count: 275
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.vip.cropimage.C1598o.m5834c(float, float):void");
    }

    /* renamed from: b */
    public Rect m5831b() {
        return new Rect((int) this.f5625e.left, (int) this.f5625e.top, (int) this.f5625e.right, (int) this.f5625e.bottom);
    }

    /* renamed from: e */
    private Rect m5821e() {
        RectF rectF = new RectF(this.f5625e.left, this.f5625e.top, this.f5625e.right, this.f5625e.bottom);
        this.f5626f.mapRect(rectF);
        return new Rect(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
    }

    /* renamed from: c */
    public void m5833c() {
        this.f5624d = m5821e();
    }

    /* renamed from: a */
    public void m5827a(Matrix matrix, Rect rect, RectF rectF, boolean z, int i, int i2, boolean z2) {
        if (z) {
            z2 = true;
        }
        this.f5626f = new Matrix(matrix);
        this.f5625e = rectF;
        this.f5632l = new RectF(rect);
        this.f5633m = z2;
        this.f5635o = z;
        this.f5627g = i;
        this.f5628h = i2;
        this.f5634n = this.f5625e.width() / this.f5625e.height();
        this.f5624d = m5821e();
        this.f5641u.setARGB(180, 0, 0, 0);
        this.f5642v.setARGB(180, 0, 0, 0);
        this.f5643w.setStrokeWidth(3.0f);
        this.f5643w.setStyle(Paint.Style.STROKE);
        this.f5643w.setAntiAlias(true);
        this.f5631k = EnumC1564c.None;
        m5820d();
    }

    /* renamed from: a */
    public void m5823a(int i) {
        this.f5627g = i;
        m5820d();
    }

    /* renamed from: a */
    public void m5825a(Bitmap bitmap, int i, float f) {
        this.f5628h = i;
        this.f5630j = new Matrix();
        this.f5630j.postRotate(f);
        this.f5629i = bitmap;
        m5820d();
    }

    /* renamed from: a */
    private void m5818a(Canvas canvas, Bitmap bitmap) {
        if (bitmap != null) {
            Rect rect = new Rect(Math.round(this.f5625e.left), Math.round(this.f5625e.top), Math.round(this.f5625e.right), Math.round(this.f5625e.bottom));
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, rect.left, rect.top, rect.width(), rect.height(), this.f5630j, true);
            canvas.drawBitmap(bitmapCreateBitmap, (Rect) null, this.f5624d, (Paint) null);
            if (bitmap != null && bitmapCreateBitmap != null) {
                if (bitmap.getWidth() != bitmapCreateBitmap.getWidth() || bitmap.getHeight() != bitmapCreateBitmap.getHeight()) {
                    bitmapCreateBitmap.recycle();
                }
            }
        }
    }
}
