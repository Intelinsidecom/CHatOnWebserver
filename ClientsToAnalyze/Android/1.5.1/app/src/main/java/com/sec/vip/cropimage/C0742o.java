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
import com.sec.chaton.C0062R;
import com.sec.pns.msg.MsgResultCode;

/* renamed from: com.sec.vip.cropimage.o */
/* loaded from: classes.dex */
class C0742o {

    /* renamed from: a */
    View f4486a;

    /* renamed from: b */
    boolean f4487b;

    /* renamed from: c */
    boolean f4488c;

    /* renamed from: d */
    Rect f4489d;

    /* renamed from: e */
    RectF f4490e;

    /* renamed from: f */
    Matrix f4491f;

    /* renamed from: l */
    private RectF f4497l;

    /* renamed from: n */
    private float f4499n;

    /* renamed from: p */
    private Drawable f4501p;

    /* renamed from: q */
    private Drawable f4502q;

    /* renamed from: r */
    private Drawable f4503r;

    /* renamed from: s */
    private Drawable f4504s;

    /* renamed from: t */
    private Drawable f4505t;

    /* renamed from: g */
    private int f4492g = MsgResultCode.SUCCESS;

    /* renamed from: h */
    private int f4493h = MsgResultCode.UNKNOWN_MESSAGE_TYPE;

    /* renamed from: i */
    private Bitmap f4494i = null;

    /* renamed from: j */
    private Matrix f4495j = null;

    /* renamed from: k */
    private EnumC0729b f4496k = EnumC0729b.None;

    /* renamed from: m */
    private boolean f4498m = false;

    /* renamed from: o */
    private boolean f4500o = false;

    /* renamed from: u */
    private final Paint f4506u = new Paint();

    /* renamed from: v */
    private final Paint f4507v = new Paint();

    /* renamed from: w */
    private final Paint f4508w = new Paint();

    public C0742o(View view) {
        this.f4486a = view;
    }

    /* renamed from: a */
    private void m4348a(Resources resources) {
        switch (this.f4492g) {
            case 1001:
                this.f4505t = resources.getDrawable(C0062R.drawable.template_roundrect);
                break;
            case 1002:
                this.f4505t = resources.getDrawable(C0062R.drawable.template_circle);
                break;
            case 1003:
                this.f4505t = resources.getDrawable(C0062R.drawable.template_star);
                break;
            case 1004:
                this.f4505t = resources.getDrawable(C0062R.drawable.template_heart);
                break;
            default:
                this.f4505t = null;
                break;
        }
    }

    /* renamed from: a */
    private void m4349a(Canvas canvas, Bitmap bitmap) {
        if (bitmap != null) {
            Rect rect = new Rect(Math.round(this.f4490e.left), Math.round(this.f4490e.top), Math.round(this.f4490e.right), Math.round(this.f4490e.bottom));
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, rect.left, rect.top, rect.width(), rect.height(), this.f4495j, true);
            canvas.drawBitmap(bitmapCreateBitmap, (Rect) null, this.f4489d, (Paint) null);
            bitmapCreateBitmap.recycle();
        }
    }

    /* renamed from: b */
    private void m4350b(Resources resources) {
        switch (this.f4493h) {
            case 2006:
                this.f4505t = resources.getDrawable(C0062R.drawable.template_polaroid);
                break;
            case 2007:
                this.f4505t = resources.getDrawable(C0062R.drawable.template_vignetting);
                break;
            default:
                this.f4505t = null;
                break;
        }
    }

    /* renamed from: d */
    private void m4351d() {
        Resources resources = this.f4486a.getResources();
        this.f4501p = resources.getDrawable(C0062R.drawable.co_emoti_selected_02);
        this.f4502q = resources.getDrawable(C0062R.drawable.ic_image_crop_w);
        this.f4503r = resources.getDrawable(C0062R.drawable.ic_image_crop_h);
        this.f4504s = resources.getDrawable(C0062R.drawable.indicator_autocrop);
        if (this.f4492g != 1000) {
            m4348a(resources);
        } else if (this.f4493h != 2000) {
            m4350b(resources);
        } else {
            this.f4505t = null;
        }
    }

    /* renamed from: e */
    private Rect m4352e() {
        RectF rectF = new RectF(this.f4490e.left, this.f4490e.top, this.f4490e.right, this.f4490e.bottom);
        this.f4491f.mapRect(rectF);
        return new Rect(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
    }

    /* renamed from: a */
    public int m4353a(float f, float f2) {
        Rect rectM4352e = m4352e();
        if (this.f4500o) {
            float fCenterX = f - rectM4352e.centerX();
            float fCenterY = f2 - rectM4352e.centerY();
            int iSqrt = (int) Math.sqrt((fCenterX * fCenterX) + (fCenterY * fCenterY));
            int iWidth = this.f4489d.width() / 2;
            return ((float) Math.abs(iSqrt - iWidth)) <= 20.0f ? Math.abs(fCenterY) > Math.abs(fCenterX) ? fCenterY < 0.0f ? 8 : 16 : fCenterX < 0.0f ? 2 : 4 : iSqrt < iWidth ? 32 : 1;
        }
        boolean z = f2 >= ((float) rectM4352e.top) - 20.0f && f2 < ((float) rectM4352e.bottom) + 20.0f;
        boolean z2 = f >= ((float) rectM4352e.left) - 20.0f && f < ((float) rectM4352e.right) + 20.0f;
        int i = (Math.abs(((float) rectM4352e.left) - f) >= 20.0f || !z) ? 1 : 1 | 2;
        int i2 = (Math.abs(((float) rectM4352e.right) - f) >= 20.0f || !z) ? i : i | 4;
        if (Math.abs(rectM4352e.top - f2) < 20.0f && z2) {
            i2 |= 8;
        }
        if (Math.abs(rectM4352e.bottom - f2) < 20.0f && z2) {
            i2 |= 16;
        }
        if (i2 == 1 && rectM4352e.contains((int) f, (int) f2)) {
            return 32;
        }
        return i2;
    }

    /* renamed from: a */
    public void m4354a(int i) {
        this.f4492g = i;
        m4351d();
    }

    /* renamed from: a */
    void m4355a(int i, float f, float f2) {
        Rect rectM4352e = m4352e();
        if (i == 1) {
            return;
        }
        if (i == 32) {
            m4363b((this.f4490e.width() / rectM4352e.width()) * f, (this.f4490e.height() / rectM4352e.height()) * f2);
            return;
        }
        m4365c(((i & 6) == 0 ? 0.0f : f) * (this.f4490e.width() / rectM4352e.width()) * ((i & 2) != 0 ? -1 : 1), (this.f4490e.height() / rectM4352e.height()) * ((i & 24) == 0 ? 0.0f : f2) * ((i & 8) != 0 ? -1 : 1));
    }

    /* renamed from: a */
    public void m4356a(Bitmap bitmap, int i, float f) {
        this.f4493h = i;
        this.f4495j = new Matrix();
        this.f4495j.postRotate(f);
        this.f4494i = bitmap;
        m4351d();
    }

    /* renamed from: a */
    protected void m4357a(Canvas canvas) {
        m4349a(canvas, this.f4494i);
        if (this.f4488c) {
            return;
        }
        canvas.save();
        Path path = new Path();
        if (!m4361a()) {
            this.f4508w.setColor(-16777216);
            canvas.drawRect(this.f4489d, this.f4508w);
            return;
        }
        Rect rect = new Rect();
        this.f4486a.getDrawingRect(rect);
        if (this.f4500o) {
            float fWidth = this.f4489d.width();
            path.addCircle(this.f4489d.left + (fWidth / 2.0f), (this.f4489d.height() / 2.0f) + this.f4489d.top, fWidth / 2.0f, Path.Direction.CW);
            this.f4508w.setColor(-1112874);
        } else {
            if (this.f4505t != null) {
                this.f4505t.setBounds(this.f4489d.left, this.f4489d.top, this.f4489d.right, this.f4489d.bottom);
                this.f4505t.draw(canvas);
            }
            path.addRect(new RectF(this.f4489d), Path.Direction.CW);
        }
        canvas.clipPath(path, Region.Op.DIFFERENCE);
        canvas.drawRect(rect, m4361a() ? this.f4506u : this.f4507v);
        canvas.restore();
        canvas.drawPath(path, this.f4508w);
        this.f4501p.setBounds(new Rect(this.f4489d.left - 2, this.f4489d.top - 2, this.f4489d.right + 2, this.f4489d.bottom + 2));
        this.f4501p.draw(canvas);
        if (this.f4496k == EnumC0729b.Grow) {
            if (this.f4500o) {
                int intrinsicWidth = this.f4504s.getIntrinsicWidth();
                int intrinsicHeight = this.f4504s.getIntrinsicHeight();
                int iRound = (int) Math.round(Math.cos(0.7853981633974483d) * (this.f4489d.width() / 2.0d));
                int iWidth = ((this.f4489d.left + (this.f4489d.width() / 2)) + iRound) - (intrinsicWidth / 2);
                int iHeight = ((this.f4489d.top + (this.f4489d.height() / 2)) - iRound) - (intrinsicHeight / 2);
                this.f4504s.setBounds(iWidth, iHeight, this.f4504s.getIntrinsicWidth() + iWidth, this.f4504s.getIntrinsicHeight() + iHeight);
                this.f4504s.draw(canvas);
                return;
            }
            int i = this.f4489d.left + 1;
            int i2 = this.f4489d.right + 1;
            int i3 = this.f4489d.top + 1;
            int i4 = this.f4489d.bottom + 1;
            int intrinsicWidth2 = this.f4502q.getIntrinsicWidth() / 2;
            int intrinsicHeight2 = this.f4502q.getIntrinsicHeight() / 2;
            int intrinsicHeight3 = this.f4503r.getIntrinsicHeight() / 2;
            int intrinsicWidth3 = this.f4503r.getIntrinsicWidth() / 2;
            int i5 = this.f4489d.left + ((this.f4489d.right - this.f4489d.left) / 2);
            int i6 = this.f4489d.top + ((this.f4489d.bottom - this.f4489d.top) / 2);
            this.f4502q.setBounds(i - intrinsicWidth2, i6 - intrinsicHeight2, i + intrinsicWidth2, i6 + intrinsicHeight2);
            this.f4502q.draw(canvas);
            this.f4502q.setBounds(i2 - intrinsicWidth2, i6 - intrinsicHeight2, i2 + intrinsicWidth2, i6 + intrinsicHeight2);
            this.f4502q.draw(canvas);
            this.f4503r.setBounds(i5 - intrinsicWidth3, i3 - intrinsicHeight3, i5 + intrinsicWidth3, i3 + intrinsicHeight3);
            this.f4503r.draw(canvas);
            this.f4503r.setBounds(i5 - intrinsicWidth3, i4 - intrinsicHeight3, i5 + intrinsicWidth3, i4 + intrinsicHeight3);
            this.f4503r.draw(canvas);
        }
    }

    /* renamed from: a */
    public void m4358a(Matrix matrix, Rect rect, RectF rectF, boolean z, int i, int i2, boolean z2) {
        boolean z3 = z ? true : z2;
        this.f4491f = new Matrix(matrix);
        this.f4490e = rectF;
        this.f4497l = new RectF(rect);
        this.f4498m = z3;
        this.f4500o = z;
        this.f4492g = i;
        this.f4493h = i2;
        this.f4499n = this.f4490e.width() / this.f4490e.height();
        this.f4489d = m4352e();
        this.f4506u.setARGB(180, 0, 0, 0);
        this.f4507v.setARGB(180, 0, 0, 0);
        this.f4508w.setStrokeWidth(3.0f);
        this.f4508w.setStyle(Paint.Style.STROKE);
        this.f4508w.setAntiAlias(true);
        this.f4496k = EnumC0729b.None;
        m4351d();
    }

    /* renamed from: a */
    public void m4359a(EnumC0729b enumC0729b) {
        if (enumC0729b != this.f4496k) {
            this.f4496k = enumC0729b;
            this.f4486a.invalidate();
        }
    }

    /* renamed from: a */
    public void m4360a(boolean z) {
        this.f4487b = z;
    }

    /* renamed from: a */
    public boolean m4361a() {
        return this.f4487b;
    }

    /* renamed from: b */
    public Rect m4362b() {
        return new Rect((int) this.f4490e.left, (int) this.f4490e.top, (int) this.f4490e.right, (int) this.f4490e.bottom);
    }

    /* renamed from: b */
    void m4363b(float f, float f2) {
        Rect rect = new Rect(this.f4489d);
        this.f4490e.offset(f, f2);
        this.f4490e.offset(Math.max(0.0f, this.f4497l.left - this.f4490e.left), Math.max(0.0f, this.f4497l.top - this.f4490e.top));
        this.f4490e.offset(Math.min(0.0f, this.f4497l.right - this.f4490e.right), Math.min(0.0f, this.f4497l.bottom - this.f4490e.bottom));
        this.f4489d = m4352e();
        rect.union(this.f4489d);
        rect.inset(-10, -10);
        this.f4486a.invalidate(rect);
    }

    /* renamed from: c */
    public void m4364c() {
        this.f4489d = m4352e();
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x010e  */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void m4365c(float r9, float r10) {
        /*
            Method dump skipped, instructions count: 274
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.vip.cropimage.C0742o.m4365c(float, float):void");
    }
}
