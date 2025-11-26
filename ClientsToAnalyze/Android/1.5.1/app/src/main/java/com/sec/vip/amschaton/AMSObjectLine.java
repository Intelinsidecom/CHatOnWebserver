package com.sec.vip.amschaton;

import android.graphics.BlurMaskFilter;
import android.graphics.DashPathEffect;
import android.graphics.EmbossMaskFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import com.sec.chaton.util.ChatONLogWriter;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class AMSObjectLine extends AMSObject {

    /* renamed from: D */
    private final int f3991D;

    /* renamed from: E */
    private final int f3992E;

    /* renamed from: F */
    private final int f3993F;

    /* renamed from: G */
    private Path f3994G;

    /* renamed from: H */
    private ArrayList f3995H;

    /* renamed from: I */
    private int f3996I;

    public AMSObjectLine(int i, int i2, int i3) {
        super(i, i2, i3);
        this.f3991D = 0;
        this.f3992E = 1;
        this.f3993F = 2;
        this.f3996I = 0;
        this.f3971k = new Paint();
        this.f3971k.setColor(this.f3963b);
        this.f3971k.setStrokeWidth(i3);
        this.f3971k.setAntiAlias(true);
        this.f3971k.setDither(true);
        this.f3971k.setStrokeCap(Paint.Cap.ROUND);
        this.f3971k.setStrokeJoin(Paint.Join.ROUND);
        this.f3971k.setStyle(Paint.Style.STROKE);
        this.f3994G = new Path();
        switch (i) {
            case 1:
                this.f3971k.setMaskFilter(new BlurMaskFilter(3.0f, BlurMaskFilter.Blur.NORMAL));
                break;
            case 2:
                this.f3971k.setAlpha(128);
                break;
            case 3:
                this.f3971k.setPathEffect(new DashPathEffect(new float[]{((this.f3964c + 1) / 2) * this.f3965d, this.f3964c * 3 * this.f3965d}, 0.0f));
                break;
            case 4:
                this.f3971k.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
                break;
            case 5:
                this.f3971k.setMaskFilter(new EmbossMaskFilter(new float[]{1.0f, 1.0f, 1.0f}, 0.4f, 6.0f, 3.5f));
                break;
        }
    }

    @Override // com.sec.vip.amschaton.AMSObject
    /* renamed from: a */
    public void mo3953a() {
        this.f3994G.reset();
        this.f3996I = 0;
    }

    @Override // com.sec.vip.amschaton.AMSObject
    /* renamed from: a */
    public void mo3954a(float f) {
        super.mo3954a(f);
        this.f3971k.setStrokeWidth((float) ((this.f3964c * f) + 0.5d));
    }

    @Override // com.sec.vip.amschaton.AMSObject
    /* renamed from: a */
    public void mo3955a(float f, float f2) {
        this.f3994G.reset();
        this.f3994G.moveTo(f, f2);
        this.f3982v = f;
        this.f3983w = f2;
        this.f3996I = 1;
    }

    @Override // com.sec.vip.amschaton.AMSObject
    /* renamed from: a */
    public boolean mo3963a(float f, float f2, float f3, float f4, int i) {
        this.f3966e.drawLine(f, f2, f3, f4, this.f3971k);
        return true;
    }

    @Override // com.sec.vip.amschaton.AMSObject
    /* renamed from: a */
    public boolean mo3964a(float f, float f2, int i) {
        this.f3994G.quadTo(this.f3982v, this.f3983w, (this.f3982v + f) / 2.0f, (this.f3983w + f2) / 2.0f);
        this.f3982v = f;
        this.f3983w = f2;
        if (i == 0) {
            return true;
        }
        if (this.f3962a != 4) {
            this.f3966e.drawBitmap(this.f3968g, 0.0f, 0.0f, (Paint) null);
            this.f3966e.drawPath(this.f3994G, this.f3971k);
        } else {
            this.f3969h.drawPath(this.f3994G, this.f3971k);
            this.f3966e.drawBitmap(this.f3970j, new Rect(0, 0, this.f3970j.getWidth(), this.f3970j.getHeight()), new Rect(0, 0, this.f3968g.getWidth(), this.f3968g.getHeight()), (Paint) null);
            this.f3966e.drawBitmap(this.f3968g, 0.0f, 0.0f, (Paint) null);
        }
        return true;
    }

    @Override // com.sec.vip.amschaton.AMSObject
    /* renamed from: b */
    public void mo3968b(float f, float f2) {
        this.f3994G.lineTo(f, f2);
        if (this.f3962a != 4) {
            this.f3966e.drawBitmap(this.f3968g, 0.0f, 0.0f, (Paint) null);
            this.f3966e.drawPath(this.f3994G, this.f3971k);
        } else {
            this.f3969h.drawPath(this.f3994G, this.f3971k);
            this.f3966e.drawBitmap(this.f3970j, new Rect(0, 0, this.f3970j.getWidth(), this.f3970j.getHeight()), new Rect(0, 0, this.f3968g.getWidth(), this.f3968g.getHeight()), (Paint) null);
            this.f3966e.drawBitmap(this.f3968g, 0.0f, 0.0f, (Paint) null);
        }
        this.f3994G.reset();
        this.f3996I = 0;
    }

    @Override // com.sec.vip.amschaton.AMSObject
    /* renamed from: d */
    public boolean mo3976d(float f, float f2) {
        mo3955a(f, f2);
        this.f3995H = new ArrayList();
        this.f3995H.add(new PointF(f, f2));
        return true;
    }

    @Override // com.sec.vip.amschaton.AMSObject
    /* renamed from: e */
    public boolean mo3977e(float f, float f2) {
        if (this.f3996I == 0) {
            return false;
        }
        mo3964a(f, f2, 255);
        this.f3995H.add(new PointF(f, f2));
        return true;
    }

    @Override // com.sec.vip.amschaton.AMSObject
    /* renamed from: f */
    public boolean mo3978f(float f, float f2) {
        float f3;
        float f4;
        if (this.f3976p == null || this.f3996I == 0) {
            return false;
        }
        if (this.f3996I == 1) {
            mo3977e(f + 1.0f, f2 + 1.0f);
            float f5 = f + 1.0f;
            f3 = f2 + 1.0f;
            this.f3995H.add(new PointF(f5, f3));
            f4 = f5;
        } else {
            f3 = f2;
            f4 = f;
        }
        float f6 = ((PointF) this.f3995H.get(this.f3995H.size() - 1)).x;
        float f7 = ((PointF) this.f3995H.get(this.f3995H.size() - 1)).y;
        mo3968b(f4, f3);
        this.f3995H.add(new PointF(f4, f3));
        if (this.f3976p == null) {
            return false;
        }
        if (!this.f3976p.VipAMS_EncodeStrokeStart(this.f3977q, this.f3978r)) {
            ChatONLogWriter.m3499a("VipAMS_EncodeStrokeStart failed", getClass().getSimpleName());
            this.f3996I = 0;
            return false;
        }
        int i = 0;
        while (true) {
            if (i >= this.f3995H.size()) {
                break;
            }
            if (!this.f3976p.VipAMS_EncodePointData(this.f3977q, this.f3978r, (int) ((PointF) this.f3995H.get(i)).x, (int) ((PointF) this.f3995H.get(i)).y)) {
                ChatONLogWriter.m3499a("VipAMS_EncodePointData failed", getClass().getSimpleName());
                this.f3996I = 0;
                break;
            }
            i++;
        }
        if (this.f3976p.VipAMS_EncodeStrokeEnd(this.f3977q, this.f3978r)) {
            return true;
        }
        ChatONLogWriter.m3499a("VipAMS_EncodeStrokeEnd failed", getClass().getSimpleName());
        mo3953a();
        return false;
    }
}
