package com.sec.vip.amschaton;

import android.graphics.BlurMaskFilter;
import android.graphics.DashPathEffect;
import android.graphics.EmbossMaskFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import com.sec.chaton.util.C1786r;
import java.util.ArrayList;

/* compiled from: AMSObjectLine.java */
/* renamed from: com.sec.vip.amschaton.u */
/* loaded from: classes.dex */
public class C2071u extends C2068r {

    /* renamed from: V */
    private final int f7424V;

    /* renamed from: W */
    private final int f7425W;

    /* renamed from: X */
    private float f7426X;

    /* renamed from: Y */
    private boolean f7427Y;

    /* renamed from: Z */
    private boolean f7428Z;

    /* renamed from: aa */
    private Path f7429aa;

    /* renamed from: ab */
    private ArrayList f7430ab;

    /* renamed from: ac */
    private int f7431ac;

    /* renamed from: ad */
    private boolean f7432ad;

    public C2071u(int i, int i2, int i3) {
        super(i, i2, i3);
        this.f7424V = 0;
        this.f7425W = 1;
        this.f7427Y = true;
        this.f7428Z = false;
        this.f7431ac = 0;
        this.f7432ad = true;
        this.f7401j = new Paint();
        this.f7401j.setColor(this.f7393b);
        this.f7401j.setStrokeWidth(i3);
        this.f7401j.setAntiAlias(true);
        this.f7401j.setDither(true);
        this.f7401j.setStrokeCap(Paint.Cap.ROUND);
        this.f7401j.setStrokeJoin(Paint.Join.ROUND);
        this.f7401j.setStyle(Paint.Style.STROKE);
        this.f7429aa = new Path();
        switch (i) {
            case 1:
                this.f7401j.setMaskFilter(new BlurMaskFilter(3.0f, BlurMaskFilter.Blur.NORMAL));
                this.f7427Y = false;
                break;
            case 2:
                this.f7401j.setAlpha(AccessibilityEventCompat.TYPE_VIEW_HOVER_ENTER);
                this.f7427Y = false;
                break;
            case 3:
                this.f7401j.setPathEffect(new DashPathEffect(new float[]{((this.f7394c + 1) / 2) * this.f7395d, this.f7394c * 3 * this.f7395d}, 0.0f));
                this.f7427Y = false;
                break;
            case 4:
                this.f7401j.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
                this.f7427Y = false;
                break;
            case 5:
                this.f7401j.setMaskFilter(new EmbossMaskFilter(new float[]{1.0f, 1.0f, 1.0f}, 0.4f, 6.0f, 3.5f));
                this.f7427Y = false;
                break;
        }
    }

    /* renamed from: d */
    private void m7243d(float f) {
        this.f7401j.setStrokeWidth((((((float) Math.sqrt(f / 4096.0f)) * (100.0f - f7367S)) + f7367S) / 100.0f) * this.f7426X * 1.5f);
    }

    /* renamed from: j */
    private void m7244j() {
        this.f7401j.setStrokeWidth(this.f7426X);
    }

    @Override // com.sec.vip.amschaton.C2068r
    /* renamed from: a */
    public void mo7194a(float f) {
        super.mo7194a(f);
        this.f7426X = (float) ((this.f7394c * f) + 0.5d);
        this.f7401j.setStrokeWidth(this.f7426X);
    }

    @Override // com.sec.vip.amschaton.C2068r
    /* renamed from: a */
    public void mo7195a(float f, float f2) {
        this.f7427Y = m7236e() >= 0.0f;
        if (this.f7427Y) {
            this.f7428Z = true;
            m7238f();
            m7243d(m7241h());
        }
        this.f7429aa.reset();
        this.f7429aa.moveTo(f, f2);
        this.f7371C = f;
        this.f7372D = f2;
        this.f7431ac = 1;
    }

    @Override // com.sec.vip.amschaton.C2068r
    /* renamed from: b */
    public void mo7223b(float f, float f2) {
        this.f7429aa.lineTo(f, f2);
        if (this.f7392a != 4) {
            this.f7396e.drawBitmap(this.f7398g, 0.0f, 0.0f, (Paint) null);
            this.f7396e.drawPath(this.f7429aa, this.f7401j);
        } else {
            this.f7399h.drawPath(this.f7429aa, this.f7401j);
            this.f7396e.drawBitmap(this.f7400i, new Rect(0, 0, this.f7400i.getWidth(), this.f7400i.getHeight()), new Rect(0, 0, this.f7398g.getWidth(), this.f7398g.getHeight()), (Paint) null);
            this.f7396e.drawBitmap(this.f7398g, 0.0f, 0.0f, (Paint) null);
        }
        this.f7429aa.reset();
        this.f7431ac = 0;
    }

    @Override // com.sec.vip.amschaton.C2068r
    /* renamed from: a */
    public void mo7193a() {
        this.f7429aa.reset();
        this.f7431ac = 0;
    }

    @Override // com.sec.vip.amschaton.C2068r
    /* renamed from: a */
    public boolean mo7214a(float f, float f2, int i, float f3) {
        return mo7215a(f, f2, i, f3, true);
    }

    @Override // com.sec.vip.amschaton.C2068r
    /* renamed from: a */
    public boolean mo7215a(float f, float f2, int i, float f3, boolean z) {
        if (f3 < 0.0f) {
            this.f7428Z = false;
        } else {
            this.f7428Z = true;
            m7222b(f3);
        }
        mo7216a(f, f2, i, z);
        return true;
    }

    @Override // com.sec.vip.amschaton.C2068r
    /* renamed from: a */
    public boolean mo7213a(float f, float f2, int i) {
        return mo7216a(f, f2, i, true);
    }

    @Override // com.sec.vip.amschaton.C2068r
    /* renamed from: a */
    public boolean mo7216a(float f, float f2, int i, boolean z) {
        if (this.f7427Y && this.f7428Z) {
            this.f7429aa.lineTo(f, f2);
            this.f7399h.drawPath(this.f7429aa, this.f7401j);
            m7243d(m7241h());
            this.f7429aa.reset();
            this.f7429aa.moveTo(f, f2);
        } else {
            m7244j();
            this.f7429aa.quadTo(this.f7371C, this.f7372D, (this.f7371C + f) / 2.0f, (this.f7372D + f2) / 2.0f);
        }
        this.f7371C = f;
        this.f7372D = f2;
        if (i != 0) {
            if (this.f7392a != 4) {
                if (z) {
                    this.f7396e.drawBitmap(this.f7398g, 0.0f, 0.0f, (Paint) null);
                }
                this.f7396e.drawPath(this.f7429aa, this.f7401j);
            } else {
                this.f7399h.drawPath(this.f7429aa, this.f7401j);
                this.f7396e.drawBitmap(this.f7400i, new Rect(0, 0, this.f7400i.getWidth(), this.f7400i.getHeight()), new Rect(0, 0, this.f7398g.getWidth(), this.f7398g.getHeight()), (Paint) null);
                this.f7396e.drawBitmap(this.f7398g, 0.0f, 0.0f, (Paint) null);
            }
        }
        return true;
    }

    @Override // com.sec.vip.amschaton.C2068r
    /* renamed from: a */
    public boolean mo7209a(float f, float f2, float f3, float f4, int i) {
        this.f7396e.drawLine(f, f2, f3, f4, this.f7401j);
        return true;
    }

    @Override // com.sec.vip.amschaton.C2068r
    /* renamed from: d */
    public boolean mo7235d(float f, float f2) {
        mo7195a((short) f, (short) f2);
        this.f7430ab = new ArrayList();
        this.f7430ab.add(new C2072v(this, f, f2, m7236e()));
        return true;
    }

    @Override // com.sec.vip.amschaton.C2068r
    /* renamed from: e */
    public boolean mo7237e(float f, float f2) {
        if (this.f7431ac == 0) {
            return false;
        }
        if (this.f7427Y) {
            this.f7428Z = m7236e() >= 0.0f;
        }
        mo7213a((short) f, (short) f2, MotionEventCompat.ACTION_MASK);
        this.f7430ab.add(new C2072v(this, f, f2, m7236e()));
        return true;
    }

    @Override // com.sec.vip.amschaton.C2068r
    /* renamed from: f */
    public boolean mo7239f(float f, float f2) {
        if (this.f7414w == null || this.f7431ac == 0) {
            return false;
        }
        if (this.f7431ac == 1 && this.f7432ad) {
            mo7237e(f + 1.0f, f2 + 1.0f);
            f += 1.0f;
            f2 += 1.0f;
            this.f7430ab.add(new C2072v(this, f, f2, m7236e()));
        }
        this.f7432ad = true;
        float f3 = ((C2072v) this.f7430ab.get(this.f7430ab.size() - 1)).f7433a;
        float f4 = ((C2072v) this.f7430ab.get(this.f7430ab.size() - 1)).f7434b;
        mo7223b((short) f, (short) f2);
        if (this.f7427Y) {
            m7240g();
            m7244j();
        }
        this.f7430ab.add(new C2072v(this, f, f2, m7236e()));
        if (this.f7414w == null) {
            return false;
        }
        if (!this.f7414w.VipAMS_EncodeStrokeStart(this.f7415x)) {
            C1786r.m6054a("VipAMS_EncodeStrokeStart failed", getClass().getSimpleName());
            this.f7431ac = 0;
            return false;
        }
        int size = this.f7430ab.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            if (this.f7414w.VipAMS_EncodePointData(this.f7415x, (short) ((C2072v) this.f7430ab.get(i)).f7433a, (short) ((C2072v) this.f7430ab.get(i)).f7434b, (short) ((C2072v) this.f7430ab.get(i)).f7435c)) {
                i++;
            } else {
                C1786r.m6054a("VipAMS_EncodePointData failed", getClass().getSimpleName());
                this.f7431ac = 0;
                break;
            }
        }
        if (this.f7414w.VipAMS_EncodeStrokeEnd(this.f7415x)) {
            return true;
        }
        C1786r.m6054a("VipAMS_EncodeStrokeEnd failed", getClass().getSimpleName());
        mo7193a();
        return false;
    }

    @Override // com.sec.vip.amschaton.C2068r
    /* renamed from: c */
    public void mo7232c(boolean z) {
        this.f7432ad = z;
    }
}
