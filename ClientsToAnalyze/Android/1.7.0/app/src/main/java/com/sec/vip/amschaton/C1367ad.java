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
import com.sec.chaton.util.C1341p;
import java.util.ArrayList;

/* compiled from: AMSObjectLine.java */
/* renamed from: com.sec.vip.amschaton.ad */
/* loaded from: classes.dex */
public class C1367ad extends C1468i {

    /* renamed from: V */
    private float f4790V;

    /* renamed from: W */
    private boolean f4791W;

    /* renamed from: X */
    private boolean f4792X;

    /* renamed from: Y */
    private Path f4793Y;

    /* renamed from: Z */
    private ArrayList f4794Z;

    /* renamed from: a */
    private final int f4795a;

    /* renamed from: aa */
    private int f4796aa;

    /* renamed from: ab */
    private boolean f4797ab;

    /* renamed from: b */
    private final int f4798b;

    public C1367ad(int i, int i2, int i3) {
        super(i, i2, i3);
        this.f4795a = 0;
        this.f4798b = 1;
        this.f4791W = true;
        this.f4792X = false;
        this.f4796aa = 0;
        this.f4797ab = true;
        this.f5154l = new Paint();
        this.f5154l.setColor(this.f5146d);
        this.f5154l.setStrokeWidth(i3);
        this.f5154l.setAntiAlias(true);
        this.f5154l.setDither(true);
        this.f5154l.setStrokeCap(Paint.Cap.ROUND);
        this.f5154l.setStrokeJoin(Paint.Join.ROUND);
        this.f5154l.setStyle(Paint.Style.STROKE);
        this.f4793Y = new Path();
        switch (i) {
            case 1:
                this.f5154l.setMaskFilter(new BlurMaskFilter(3.0f, BlurMaskFilter.Blur.NORMAL));
                this.f4791W = false;
                break;
            case 2:
                this.f5154l.setAlpha(128);
                this.f4791W = false;
                break;
            case 3:
                this.f5154l.setPathEffect(new DashPathEffect(new float[]{((this.f5147e + 1) / 2) * this.f5148f, this.f5147e * 3 * this.f5148f}, 0.0f));
                this.f4791W = false;
                break;
            case 4:
                this.f5154l.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
                this.f4791W = false;
                break;
            case 5:
                this.f5154l.setMaskFilter(new EmbossMaskFilter(new float[]{1.0f, 1.0f, 1.0f}, 0.4f, 6.0f, 3.5f));
                this.f4791W = false;
                break;
        }
    }

    /* renamed from: d */
    private void m4884d(float f) {
        this.f5154l.setStrokeWidth((((((float) Math.sqrt(f / 4096.0f)) * (100.0f - f5120R)) + f5120R) / 100.0f) * this.f4790V * 1.5f);
    }

    /* renamed from: j */
    private void m4885j() {
        this.f5154l.setStrokeWidth(this.f4790V);
    }

    @Override // com.sec.vip.amschaton.C1468i
    /* renamed from: a */
    public void mo4887a(float f) {
        super.mo4887a(f);
        this.f4790V = (float) ((this.f5147e * f) + 0.5d);
        this.f5154l.setStrokeWidth(this.f4790V);
    }

    @Override // com.sec.vip.amschaton.C1468i
    /* renamed from: e */
    public void mo4897e(float f, float f2) {
        this.f4791W = m5308e() >= 0.0f;
        if (this.f4791W) {
            this.f4792X = true;
            m5309f();
            m4884d(m5311h());
        }
        this.f4793Y.reset();
        this.f4793Y.moveTo(f, f2);
        this.f5126E = f;
        this.f5127F = f2;
        this.f4796aa = 1;
    }

    @Override // com.sec.vip.amschaton.C1468i
    /* renamed from: f */
    public void mo4898f(float f, float f2) {
        this.f4793Y.lineTo(f, f2);
        if (this.f5145c != 4) {
            this.f5149g.drawBitmap(this.f5151i, 0.0f, 0.0f, (Paint) null);
            this.f5149g.drawPath(this.f4793Y, this.f5154l);
        } else {
            this.f5152j.drawPath(this.f4793Y, this.f5154l);
            this.f5149g.drawBitmap(this.f5153k, new Rect(0, 0, this.f5153k.getWidth(), this.f5153k.getHeight()), new Rect(0, 0, this.f5151i.getWidth(), this.f5151i.getHeight()), (Paint) null);
            this.f5149g.drawBitmap(this.f5151i, 0.0f, 0.0f, (Paint) null);
        }
        this.f4793Y.reset();
        this.f4796aa = 0;
    }

    @Override // com.sec.vip.amschaton.C1468i
    /* renamed from: a */
    public void mo4886a() {
        this.f4793Y.reset();
        this.f4796aa = 0;
    }

    @Override // com.sec.vip.amschaton.C1468i
    /* renamed from: a */
    public boolean mo4890a(float f, float f2, int i, float f3) {
        return mo4891a(f, f2, i, f3, true);
    }

    @Override // com.sec.vip.amschaton.C1468i
    /* renamed from: a */
    public boolean mo4891a(float f, float f2, int i, float f3, boolean z) {
        if (f3 < 0.0f) {
            this.f4792X = false;
        } else {
            this.f4792X = true;
            m5299b(f3);
        }
        mo4892a(f, f2, i, z);
        return true;
    }

    @Override // com.sec.vip.amschaton.C1468i
    /* renamed from: a */
    public boolean mo4889a(float f, float f2, int i) {
        return mo4892a(f, f2, i, true);
    }

    @Override // com.sec.vip.amschaton.C1468i
    /* renamed from: a */
    public boolean mo4892a(float f, float f2, int i, boolean z) {
        if (this.f4791W && this.f4792X) {
            this.f4793Y.lineTo(f, f2);
            this.f5152j.drawPath(this.f4793Y, this.f5154l);
            m4884d(m5311h());
            this.f4793Y.reset();
            this.f4793Y.moveTo(f, f2);
        } else {
            m4885j();
            this.f4793Y.quadTo(this.f5126E, this.f5127F, (this.f5126E + f) / 2.0f, (this.f5127F + f2) / 2.0f);
        }
        this.f5126E = f;
        this.f5127F = f2;
        if (i != 0) {
            if (this.f5145c != 4) {
                if (z) {
                    this.f5149g.drawBitmap(this.f5151i, 0.0f, 0.0f, (Paint) null);
                }
                this.f5149g.drawPath(this.f4793Y, this.f5154l);
            } else {
                this.f5152j.drawPath(this.f4793Y, this.f5154l);
                this.f5149g.drawBitmap(this.f5153k, new Rect(0, 0, this.f5153k.getWidth(), this.f5153k.getHeight()), new Rect(0, 0, this.f5151i.getWidth(), this.f5151i.getHeight()), (Paint) null);
                this.f5149g.drawBitmap(this.f5151i, 0.0f, 0.0f, (Paint) null);
            }
        }
        return true;
    }

    @Override // com.sec.vip.amschaton.C1468i
    /* renamed from: a */
    public boolean mo4888a(float f, float f2, float f3, float f4, int i) {
        this.f5149g.drawLine(f, f2, f3, f4, this.f5154l);
        return true;
    }

    @Override // com.sec.vip.amschaton.C1468i
    /* renamed from: b */
    public boolean mo4893b(float f, float f2) {
        mo4897e((short) f, (short) f2);
        this.f4794Z = new ArrayList();
        this.f4794Z.add(new C1386aw(this, f, f2, m5308e()));
        return true;
    }

    @Override // com.sec.vip.amschaton.C1468i
    /* renamed from: c */
    public boolean mo4895c(float f, float f2) {
        if (this.f4796aa == 0) {
            return false;
        }
        if (this.f4791W) {
            this.f4792X = m5308e() >= 0.0f;
        }
        mo4889a((short) f, (short) f2, MotionEventCompat.ACTION_MASK);
        this.f4794Z.add(new C1386aw(this, f, f2, m5308e()));
        return true;
    }

    @Override // com.sec.vip.amschaton.C1468i
    /* renamed from: d */
    public boolean mo4896d(float f, float f2) {
        if (this.f5167y == null || this.f4796aa == 0) {
            return false;
        }
        if (this.f4796aa == 1 && this.f4797ab) {
            mo4895c(f + 1.0f, f2 + 1.0f);
            f += 1.0f;
            f2 += 1.0f;
            this.f4794Z.add(new C1386aw(this, f, f2, m5308e()));
        }
        this.f4797ab = true;
        float f3 = ((C1386aw) this.f4794Z.get(this.f4794Z.size() - 1)).f4874a;
        float f4 = ((C1386aw) this.f4794Z.get(this.f4794Z.size() - 1)).f4875b;
        mo4898f((short) f, (short) f2);
        if (this.f4791W) {
            m5310g();
            m4885j();
        }
        this.f4794Z.add(new C1386aw(this, f, f2, m5308e()));
        if (this.f5167y == null) {
            return false;
        }
        if (!this.f5167y.VipAMS_EncodeStrokeStart(this.f5168z)) {
            C1341p.m4651a("VipAMS_EncodeStrokeStart failed", getClass().getSimpleName());
            this.f4796aa = 0;
            return false;
        }
        int size = this.f4794Z.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            if (this.f5167y.VipAMS_EncodePointData(this.f5168z, (short) ((C1386aw) this.f4794Z.get(i)).f4874a, (short) ((C1386aw) this.f4794Z.get(i)).f4875b, (short) ((C1386aw) this.f4794Z.get(i)).f4876c)) {
                i++;
            } else {
                C1341p.m4651a("VipAMS_EncodePointData failed", getClass().getSimpleName());
                this.f4796aa = 0;
                break;
            }
        }
        if (this.f5167y.VipAMS_EncodeStrokeEnd(this.f5168z)) {
            return true;
        }
        C1341p.m4651a("VipAMS_EncodeStrokeEnd failed", getClass().getSimpleName());
        mo4886a();
        return false;
    }

    @Override // com.sec.vip.amschaton.C1468i
    /* renamed from: c */
    public void mo4894c(boolean z) {
        this.f4797ab = z;
    }
}
