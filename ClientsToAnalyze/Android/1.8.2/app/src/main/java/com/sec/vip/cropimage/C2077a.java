package com.sec.vip.cropimage;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.sec.chaton.R;

/* compiled from: HighlightView.java */
/* renamed from: com.sec.vip.cropimage.a */
/* loaded from: classes.dex */
public class C2077a {

    /* renamed from: a */
    View f7535a;

    /* renamed from: b */
    boolean f7536b;

    /* renamed from: c */
    boolean f7537c;

    /* renamed from: d */
    Rect f7538d;

    /* renamed from: e */
    RectF f7539e;

    /* renamed from: f */
    Matrix f7540f;

    /* renamed from: l */
    private RectF f7546l;

    /* renamed from: n */
    private float f7548n;

    /* renamed from: p */
    private Drawable f7550p;

    /* renamed from: q */
    private Drawable f7551q;

    /* renamed from: r */
    private Drawable f7552r;

    /* renamed from: s */
    private Drawable f7553s;

    /* renamed from: t */
    private Drawable f7554t;

    /* renamed from: g */
    private int f7541g = 1000;

    /* renamed from: h */
    private int f7542h = 2000;

    /* renamed from: i */
    private Bitmap f7543i = null;

    /* renamed from: j */
    private Matrix f7544j = null;

    /* renamed from: k */
    private EnumC2078b f7545k = EnumC2078b.None;

    /* renamed from: m */
    private boolean f7547m = false;

    /* renamed from: o */
    private boolean f7549o = false;

    /* renamed from: u */
    private final Paint f7555u = new Paint();

    /* renamed from: v */
    private final Paint f7556v = new Paint();

    /* renamed from: w */
    private final Paint f7557w = new Paint();

    public C2077a(View view) {
        this.f7535a = view;
    }

    /* renamed from: d */
    private void m7321d() {
        Resources resources = this.f7535a.getResources();
        this.f7550p = resources.getDrawable(R.drawable.co_emoti_selected_02);
        this.f7551q = resources.getDrawable(R.drawable.ams_ics_selector_image_crop_h);
        this.f7552r = resources.getDrawable(R.drawable.ams_ics_selector_image_crop_w);
        this.f7553s = resources.getDrawable(R.drawable.indicator_autocrop);
        if (this.f7541g != 1000) {
            m7318a(resources);
        } else if (this.f7542h != 2000) {
            m7320b(resources);
        } else {
            this.f7554t = null;
        }
    }

    /* renamed from: a */
    private void m7318a(Resources resources) {
        switch (this.f7541g) {
            case 1001:
                this.f7554t = resources.getDrawable(R.drawable.template_roundrect);
                break;
            case 1002:
                this.f7554t = resources.getDrawable(R.drawable.template_circle);
                break;
            case 1003:
                this.f7554t = resources.getDrawable(R.drawable.template_star);
                break;
            case 1004:
                this.f7554t = resources.getDrawable(R.drawable.template_heart);
                break;
            default:
                this.f7554t = null;
                break;
        }
    }

    /* renamed from: b */
    private void m7320b(Resources resources) {
        switch (this.f7542h) {
            case 2006:
                this.f7554t = resources.getDrawable(R.drawable.template_polaroid);
                break;
            case 2007:
                this.f7554t = resources.getDrawable(R.drawable.template_vignetting);
                break;
            default:
                this.f7554t = null;
                break;
        }
    }

    /* renamed from: a */
    public boolean m7331a() {
        return this.f7536b;
    }

    /* renamed from: a */
    public void m7330a(boolean z) {
        this.f7536b = z;
    }

    /* renamed from: a */
    protected void m7327a(Canvas canvas) {
        m7319a(canvas, this.f7543i);
        if (!this.f7537c) {
            canvas.save();
            Path path = new Path();
            if (!m7331a()) {
                this.f7557w.setColor(-16777216);
                canvas.drawRect(this.f7538d, this.f7557w);
                return;
            }
            this.f7535a.getDrawingRect(new Rect());
            if (this.f7549o) {
                float fWidth = this.f7538d.width();
                path.addCircle(this.f7538d.left + (fWidth / 2.0f), (this.f7538d.height() / 2.0f) + this.f7538d.top, fWidth / 2.0f, Path.Direction.CW);
                this.f7557w.setColor(-1112874);
            } else {
                if (this.f7554t != null) {
                    this.f7554t.setBounds(this.f7538d.left, this.f7538d.top, this.f7538d.right, this.f7538d.bottom);
                    this.f7554t.draw(canvas);
                }
                path.addRect(new RectF(this.f7538d), Path.Direction.CW);
            }
            canvas.restore();
            canvas.drawPath(path, this.f7557w);
            this.f7550p.setBounds(new Rect(this.f7538d.left, this.f7538d.top, this.f7538d.right, this.f7538d.bottom));
            this.f7550p.draw(canvas);
            if (this.f7545k == EnumC2078b.Grow) {
                int[] iArr = {android.R.attr.state_pressed};
                this.f7551q.setState(iArr);
                this.f7552r.setState(iArr);
            } else if (this.f7545k == EnumC2078b.Grow_X) {
                this.f7551q.setState(new int[]{android.R.attr.state_pressed});
            } else if (this.f7545k == EnumC2078b.Grow_Y) {
                this.f7552r.setState(new int[]{android.R.attr.state_pressed});
            } else {
                int[] iArr2 = {-16842919};
                this.f7551q.setState(iArr2);
                this.f7552r.setState(iArr2);
            }
            if (this.f7549o) {
                int intrinsicWidth = this.f7553s.getIntrinsicWidth();
                int intrinsicHeight = this.f7553s.getIntrinsicHeight();
                int iRound = (int) Math.round(Math.cos(0.7853981633974483d) * (this.f7538d.width() / 2.0d));
                int iWidth = ((this.f7538d.left + (this.f7538d.width() / 2)) + iRound) - (intrinsicWidth / 2);
                int iHeight = ((this.f7538d.top + (this.f7538d.height() / 2)) - iRound) - (intrinsicHeight / 2);
                this.f7553s.setBounds(iWidth, iHeight, this.f7553s.getIntrinsicWidth() + iWidth, this.f7553s.getIntrinsicHeight() + iHeight);
                this.f7553s.draw(canvas);
                return;
            }
            int i = this.f7538d.left + 1;
            int i2 = this.f7538d.right + 1;
            int i3 = this.f7538d.top + 1;
            int i4 = this.f7538d.bottom + 1;
            int intrinsicWidth2 = this.f7551q.getIntrinsicWidth() / 2;
            int intrinsicHeight2 = this.f7551q.getIntrinsicHeight() / 2;
            int intrinsicHeight3 = this.f7552r.getIntrinsicHeight() / 2;
            int intrinsicWidth3 = this.f7552r.getIntrinsicWidth() / 2;
            int i5 = this.f7538d.left + ((this.f7538d.right - this.f7538d.left) / 2);
            int i6 = this.f7538d.top + ((this.f7538d.bottom - this.f7538d.top) / 2);
            this.f7551q.setBounds(i - intrinsicWidth2, i6 - intrinsicHeight2, i + intrinsicWidth2, i6 + intrinsicHeight2);
            this.f7551q.draw(canvas);
            this.f7551q.setBounds(i2 - intrinsicWidth2, i6 - intrinsicHeight2, i2 + intrinsicWidth2, i6 + intrinsicHeight2);
            this.f7551q.draw(canvas);
            this.f7552r.setBounds(i5 - intrinsicWidth3, i3 - intrinsicHeight3, i5 + intrinsicWidth3, i3 + intrinsicHeight3);
            this.f7552r.draw(canvas);
            this.f7552r.setBounds(i5 - intrinsicWidth3, i4 - intrinsicHeight3, i5 + intrinsicWidth3, i4 + intrinsicHeight3);
            this.f7552r.draw(canvas);
        }
    }

    /* renamed from: a */
    public void m7329a(EnumC2078b enumC2078b) {
        if (enumC2078b != this.f7545k) {
            this.f7545k = enumC2078b;
            this.f7535a.invalidate();
        }
    }

    /* renamed from: a */
    public int m7323a(float f, float f2) {
        boolean z = false;
        Rect rectM7322e = m7322e();
        if (this.f7549o) {
            float fCenterX = f - rectM7322e.centerX();
            float fCenterY = f2 - rectM7322e.centerY();
            int iSqrt = (int) Math.sqrt((fCenterX * fCenterX) + (fCenterY * fCenterY));
            int iWidth = this.f7538d.width() / 2;
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
        boolean z2 = f2 >= ((float) rectM7322e.top) - 20.0f && f2 < ((float) rectM7322e.bottom) + 20.0f;
        if (f >= rectM7322e.left - 20.0f && f < rectM7322e.right + 20.0f) {
            z = true;
        }
        int i = (Math.abs(((float) rectM7322e.left) - f) >= 20.0f || !z2) ? 1 : 3;
        if (Math.abs(rectM7322e.right - f) < 20.0f && z2) {
            i |= 4;
        }
        if (Math.abs(rectM7322e.top - f2) < 20.0f && z) {
            i |= 8;
        }
        int i2 = (Math.abs(((float) rectM7322e.bottom) - f2) >= 20.0f || !z) ? i : i | 16;
        if (i2 == 1 && rectM7322e.contains((int) f, (int) f2)) {
            return 32;
        }
        return i2;
    }

    /* renamed from: a */
    void m7325a(int i, float f, float f2) throws Resources.NotFoundException {
        Rect rectM7322e = m7322e();
        if (i != 1) {
            if (i == 32) {
                m7333b((this.f7539e.width() / rectM7322e.width()) * f, (this.f7539e.height() / rectM7322e.height()) * f2);
                return;
            }
            if ((i & 6) == 0) {
                f = 0.0f;
            }
            if ((i & 24) == 0) {
                f2 = 0.0f;
            }
            m7335c(f * (this.f7539e.width() / rectM7322e.width()) * ((i & 2) != 0 ? -1 : 1), ((i & 8) != 0 ? -1 : 1) * f2 * (this.f7539e.height() / rectM7322e.height()));
        }
    }

    /* renamed from: b */
    void m7333b(float f, float f2) throws Resources.NotFoundException {
        Rect rect = new Rect(this.f7538d);
        this.f7539e.offset(f, f2);
        this.f7539e.offset(Math.max(0.0f, this.f7546l.left - this.f7539e.left), Math.max(0.0f, this.f7546l.top - this.f7539e.top));
        this.f7539e.offset(Math.min(0.0f, this.f7546l.right - this.f7539e.right), Math.min(0.0f, this.f7546l.bottom - this.f7539e.bottom));
        this.f7538d = m7322e();
        rect.union(this.f7538d);
        int dimensionPixelSize = this.f7535a.getResources().getDimensionPixelSize(R.dimen.ams_ics_crop_image_outline_offset);
        rect.inset(-dimensionPixelSize, -dimensionPixelSize);
        this.f7535a.invalidate();
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x010f A[PHI: r9
  0x010f: PHI (r9v2 float) = (r9v1 float), (r9v1 float), (r9v3 float) binds: [B:8:0x001a, B:10:0x002b, B:12:0x003c] A[DONT_GENERATE, DONT_INLINE]] */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void m7335c(float r9, float r10) {
        /*
            Method dump skipped, instructions count: 275
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.vip.cropimage.C2077a.m7335c(float, float):void");
    }

    /* renamed from: b */
    public Rect m7332b() {
        return new Rect((int) this.f7539e.left, (int) this.f7539e.top, (int) this.f7539e.right, (int) this.f7539e.bottom);
    }

    /* renamed from: e */
    private Rect m7322e() {
        RectF rectF = new RectF(this.f7539e.left, this.f7539e.top, this.f7539e.right, this.f7539e.bottom);
        this.f7540f.mapRect(rectF);
        return new Rect(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
    }

    /* renamed from: c */
    public void m7334c() {
        this.f7538d = m7322e();
    }

    /* renamed from: a */
    public void m7328a(Matrix matrix, Rect rect, RectF rectF, boolean z, int i, int i2, boolean z2) {
        if (z) {
            z2 = true;
        }
        this.f7540f = new Matrix(matrix);
        this.f7539e = rectF;
        this.f7546l = new RectF(rect);
        this.f7547m = z2;
        this.f7549o = z;
        this.f7541g = i;
        this.f7542h = i2;
        this.f7548n = this.f7539e.width() / this.f7539e.height();
        this.f7538d = m7322e();
        this.f7555u.setARGB(180, 0, 0, 0);
        this.f7556v.setARGB(180, 0, 0, 0);
        this.f7557w.setStrokeWidth(3.0f);
        this.f7557w.setStyle(Paint.Style.STROKE);
        this.f7557w.setAntiAlias(true);
        this.f7545k = EnumC2078b.None;
        m7321d();
    }

    /* renamed from: a */
    public void m7324a(int i) {
        this.f7541g = i;
        m7321d();
    }

    /* renamed from: a */
    public void m7326a(Bitmap bitmap, int i, float f) {
        this.f7542h = i;
        this.f7544j = new Matrix();
        this.f7544j.postRotate(f);
        this.f7543i = bitmap;
        m7321d();
    }

    /* renamed from: a */
    private void m7319a(Canvas canvas, Bitmap bitmap) {
        if (bitmap != null) {
            Rect rect = new Rect(Math.round(this.f7539e.left), Math.round(this.f7539e.top), Math.round(this.f7539e.right), Math.round(this.f7539e.bottom));
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, rect.left, rect.top, rect.width(), rect.height(), this.f7544j, true);
            canvas.drawBitmap(bitmapCreateBitmap, (Rect) null, this.f7538d, (Paint) null);
            if (bitmap != null && bitmapCreateBitmap != null) {
                if (bitmap.getWidth() != bitmapCreateBitmap.getWidth() || bitmap.getHeight() != bitmapCreateBitmap.getHeight()) {
                    bitmapCreateBitmap.recycle();
                }
            }
        }
    }
}
