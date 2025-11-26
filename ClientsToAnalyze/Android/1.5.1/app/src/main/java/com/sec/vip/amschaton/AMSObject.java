package com.sec.vip.amschaton;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.sec.amsoma.AMSLibs;
import com.sec.amsoma.structure.AMS_OBJECT_DATA;
import com.sec.amsoma.structure.AMS_RECT;
import com.sec.amsoma.structure.AMS_SELECT_OBJECT;
import com.sec.amsoma.structure.AMS_UI_DATA;

/* loaded from: classes.dex */
public class AMSObject {

    /* renamed from: i */
    protected static Bitmap f3958i = null;

    /* renamed from: a */
    protected int f3962a;

    /* renamed from: b */
    protected int f3963b;

    /* renamed from: c */
    protected int f3964c;

    /* renamed from: e */
    protected Canvas f3966e;

    /* renamed from: m */
    protected Paint f3973m;

    /* renamed from: n */
    protected DashPathEffect f3974n;

    /* renamed from: o */
    protected DashPathEffect f3975o;

    /* renamed from: d */
    protected float f3965d = 1.0f;

    /* renamed from: f */
    protected Bitmap f3967f = null;

    /* renamed from: g */
    protected Bitmap f3968g = null;

    /* renamed from: h */
    protected Canvas f3969h = null;

    /* renamed from: j */
    protected Bitmap f3970j = null;

    /* renamed from: k */
    protected Paint f3971k = null;

    /* renamed from: l */
    protected Drawable f3972l = null;

    /* renamed from: p */
    protected AMSLibs f3976p = null;

    /* renamed from: q */
    protected int f3977q = 0;

    /* renamed from: r */
    protected AMS_UI_DATA f3978r = null;

    /* renamed from: s */
    protected int f3979s = 0;

    /* renamed from: t */
    protected int f3980t = 0;

    /* renamed from: u */
    protected int f3981u = 0;

    /* renamed from: v */
    protected float f3982v = 0.0f;

    /* renamed from: w */
    protected float f3983w = 0.0f;

    /* renamed from: x */
    protected boolean f3984x = true;

    /* renamed from: y */
    protected boolean f3985y = false;

    /* renamed from: z */
    protected boolean f3986z = false;

    /* renamed from: A */
    protected AMS_SELECT_OBJECT f3959A = null;

    /* renamed from: B */
    protected AMS_OBJECT_DATA f3960B = null;

    /* renamed from: C */
    protected Rect f3961C = null;

    public AMSObject(int i, int i2, int i3) {
        this.f3966e = null;
        this.f3973m = null;
        this.f3974n = null;
        this.f3975o = null;
        this.f3963b = i2;
        this.f3962a = i;
        this.f3964c = i3;
        this.f3966e = null;
        this.f3974n = new DashPathEffect(new float[]{5.0f, 5.0f}, 0.0f);
        this.f3975o = new DashPathEffect(new float[]{3.0f, 7.0f}, -1.0f);
        this.f3973m = new Paint();
        this.f3973m.setStyle(Paint.Style.STROKE);
        this.f3973m.setAntiAlias(true);
        this.f3973m.setDither(true);
    }

    /* renamed from: a */
    public void mo3953a() {
        this.f3966e.drawBitmap(this.f3968g, 0.0f, 0.0f, (Paint) null);
    }

    /* renamed from: a */
    public void mo3954a(float f) {
        this.f3965d = f;
        this.f3974n = new DashPathEffect(new float[]{this.f3965d * 5.0f, this.f3965d * 5.0f}, 0.0f);
        this.f3975o = new DashPathEffect(new float[]{3.0f * this.f3965d, 7.0f * this.f3965d}, -this.f3965d);
    }

    /* renamed from: a */
    public void mo3955a(float f, float f2) {
    }

    /* renamed from: a */
    protected void m3956a(float f, float f2, float f3, float f4) {
        if (this.f3979s == 0 || this.f3979s == 1) {
            return;
        }
        if (this.f3972l != null) {
            this.f3972l.setBounds((int) (f - (this.f3965d * 5.0f)), (int) (f2 - (this.f3965d * 5.0f)), (int) ((this.f3965d * 5.0f) + f3), (int) ((this.f3965d * 5.0f) + f4));
            this.f3972l.draw(this.f3966e);
            return;
        }
        this.f3973m.setPathEffect(this.f3974n);
        this.f3973m.setStrokeWidth(this.f3965d * 5.0f);
        this.f3973m.setColor(-16777216);
        this.f3966e.drawRect(new RectF(f, f2, f3, f4), this.f3973m);
        this.f3973m.setPathEffect(this.f3975o);
        this.f3973m.setStrokeWidth(3.0f * this.f3965d);
        this.f3973m.setColor(-1);
        this.f3966e.drawRect(new RectF(f, f2, f3, f4), this.f3973m);
    }

    /* renamed from: a */
    public void m3957a(Bitmap bitmap) {
        m3958a(bitmap, bitmap);
    }

    /* renamed from: a */
    public void m3958a(Bitmap bitmap, Bitmap bitmap2) {
        this.f3967f = bitmap;
        this.f3966e = new Canvas(this.f3967f);
        this.f3968g = bitmap2;
        this.f3969h = new Canvas(this.f3968g);
        this.f3969h.drawBitmap(this.f3967f, 0.0f, 0.0f, (Paint) null);
    }

    /* renamed from: a */
    public void m3959a(Drawable drawable) {
        this.f3972l = drawable;
    }

    /* renamed from: a */
    public void m3960a(AMSLibs aMSLibs, int i, AMS_UI_DATA ams_ui_data) {
        this.f3976p = aMSLibs;
        this.f3977q = i;
        this.f3978r = ams_ui_data;
    }

    /* renamed from: a */
    public void m3961a(AMS_SELECT_OBJECT ams_select_object) {
        this.f3959A = ams_select_object;
        if (this.f3976p == null) {
            this.f3960B = null;
        } else {
            this.f3960B = new AMS_OBJECT_DATA();
            this.f3976p.VipAMS_GetSelectObjectData(ams_select_object.getM_pSelectObjectData(), this.f3960B);
        }
    }

    /* renamed from: a */
    public void m3962a(boolean z) {
        this.f3985y = z;
        if (z) {
            this.f3979s = 2;
        } else {
            this.f3979s = 0;
        }
    }

    /* renamed from: a */
    public boolean mo3963a(float f, float f2, float f3, float f4, int i) {
        return false;
    }

    /* renamed from: a */
    public boolean mo3964a(float f, float f2, int i) {
        return false;
    }

    /* renamed from: a */
    public boolean mo3965a(float f, float f2, String str, int i) {
        return false;
    }

    /* renamed from: a */
    public boolean mo3966a(int i, int i2, int i3) {
        this.f3962a = i;
        this.f3963b = i2;
        this.f3964c = i3;
        return false;
    }

    /* renamed from: a */
    public boolean mo3967a(AMS_RECT ams_rect) {
        return false;
    }

    /* renamed from: b */
    public void mo3968b(float f, float f2) {
    }

    /* renamed from: b */
    public void m3969b(Bitmap bitmap) {
        this.f3970j = bitmap;
    }

    /* renamed from: b */
    public void m3970b(boolean z) {
        this.f3984x = z;
    }

    /* renamed from: b */
    public boolean m3971b() {
        if (this.f3976p != null && this.f3959A != null && this.f3985y) {
            this.f3979s = 0;
            boolean zVipAMS_DeleteSelectObject = this.f3976p.VipAMS_DeleteSelectObject(this.f3977q, this.f3978r, this.f3959A, false);
            this.f3959A = null;
            this.f3960B = null;
            return zVipAMS_DeleteSelectObject;
        }
        return false;
    }

    /* renamed from: b */
    public boolean mo3972b(AMS_RECT ams_rect) {
        return false;
    }

    /* renamed from: c */
    public void m3973c() {
    }

    /* renamed from: c */
    public boolean mo3974c(float f, float f2) {
        return false;
    }

    /* renamed from: d */
    public Rect m3975d() {
        return this.f3961C;
    }

    /* renamed from: d */
    public boolean mo3976d(float f, float f2) {
        return false;
    }

    /* renamed from: e */
    public boolean mo3977e(float f, float f2) {
        return false;
    }

    /* renamed from: f */
    public boolean mo3978f(float f, float f2) {
        return false;
    }
}
