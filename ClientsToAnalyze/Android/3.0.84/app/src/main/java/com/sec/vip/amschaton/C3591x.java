package com.sec.vip.amschaton;

import android.graphics.BlurMaskFilter;
import android.graphics.DashPathEffect;
import android.graphics.EmbossMaskFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.v4.view.MotionEventCompat;
import android.util.DisplayMetrics;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C3250y;
import java.util.ArrayList;

/* compiled from: AMSObjectLine.java */
/* renamed from: com.sec.vip.amschaton.x */
/* loaded from: classes.dex */
public class C3591x extends C3588u {

    /* renamed from: Z */
    private final int f13118Z;

    /* renamed from: aa */
    private final int f13119aa;

    /* renamed from: ab */
    private float f13120ab;

    /* renamed from: ac */
    private boolean f13121ac;

    /* renamed from: ad */
    private boolean f13122ad;

    /* renamed from: ae */
    private Path f13123ae;

    /* renamed from: af */
    private ArrayList<C3592y> f13124af;

    /* renamed from: ag */
    private int f13125ag;

    /* renamed from: ah */
    private boolean f13126ah;

    /* renamed from: ai */
    private float f13127ai;

    public C3591x(int i, int i2, int i3) {
        super(i, i2, i3);
        this.f13118Z = 0;
        this.f13119aa = 1;
        this.f13121ac = true;
        this.f13122ad = false;
        this.f13125ag = 0;
        this.f13126ah = true;
        this.f13127ai = 4.0f;
        this.f13097l = new Paint();
        this.f13097l.setColor(this.f13087b);
        this.f13097l.setStrokeWidth(i3);
        this.f13097l.setAntiAlias(true);
        this.f13097l.setDither(true);
        this.f13097l.setStrokeCap(Paint.Cap.ROUND);
        this.f13097l.setStrokeJoin(Paint.Join.ROUND);
        this.f13097l.setStyle(Paint.Style.STROKE);
        this.f13123ae = new Path();
        switch (i) {
            case 1:
                this.f13097l.setMaskFilter(new BlurMaskFilter(3.0f, BlurMaskFilter.Blur.NORMAL));
                this.f13121ac = false;
                break;
            case 2:
                this.f13097l.setAlpha(128);
                this.f13121ac = false;
                break;
            case 3:
                DisplayMetrics displayMetrics = GlobalApplication.m6451b().getDisplayMetrics();
                if (displayMetrics != null) {
                    if (displayMetrics.density <= 1.0f) {
                        this.f13127ai /= 2.0f;
                    } else {
                        this.f13127ai = (displayMetrics.density * this.f13127ai) / 2.0f;
                    }
                }
                this.f13097l.setPathEffect(new DashPathEffect(new float[]{((this.f13088c + 1) / 2) * this.f13089d, this.f13127ai * this.f13088c * this.f13089d}, 0.0f));
                this.f13121ac = false;
                break;
            case 4:
                this.f13097l.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
                this.f13121ac = false;
                break;
            case 5:
                this.f13097l.setMaskFilter(new EmbossMaskFilter(new float[]{1.0f, 1.0f, 1.0f}, 0.4f, 6.0f, 3.5f));
                this.f13121ac = false;
                break;
        }
    }

    /* renamed from: d */
    private void m12860d(float f) {
        this.f13097l.setStrokeWidth((((((float) Math.sqrt(f / 4096.0f)) * (100.0f - f13056U)) + f13056U) / 100.0f) * this.f13120ab * 1.5f);
    }

    /* renamed from: l */
    private void m12861l() {
        this.f13097l.setStrokeWidth(this.f13120ab);
    }

    @Override // com.sec.vip.amschaton.C3588u
    /* renamed from: a */
    public void mo12131a(float f) {
        super.mo12131a(f);
        this.f13120ab = (float) ((this.f13088c * f) + 0.5d);
        this.f13097l.setStrokeWidth(this.f13120ab);
    }

    @Override // com.sec.vip.amschaton.C3588u
    /* renamed from: a */
    public void mo12132a(float f, float f2) {
        this.f13121ac = m12855g() >= 0.0f;
        if (this.f13121ac) {
            this.f13122ad = true;
            m12856h();
            m12860d(m12858j());
        }
        this.f13123ae.reset();
        this.f13123ae.moveTo(f, f2);
        this.f13062E = f;
        this.f13063F = f2;
        this.f13125ag = 1;
    }

    @Override // com.sec.vip.amschaton.C3588u
    /* renamed from: b */
    public void mo12842b(float f, float f2) {
        this.f13123ae.lineTo(f, f2);
        RectF rectF = new RectF();
        this.f13123ae.computeBounds(rectF, true);
        if (this.f13082a != 4) {
            this.f13092g.drawBitmap(this.f13094i, 0.0f, 0.0f, (Paint) null);
            if (rectF.isEmpty()) {
                this.f13092g.drawPoint(f, f2, this.f13097l);
            } else {
                this.f13092g.drawPath(this.f13123ae, this.f13097l);
            }
        } else {
            if (rectF.isEmpty()) {
                this.f13095j.drawPoint(f, f2, this.f13097l);
            } else {
                this.f13095j.drawPath(this.f13123ae, this.f13097l);
            }
            this.f13092g.drawBitmap(this.f13096k, new Rect(0, 0, this.f13096k.getWidth(), this.f13096k.getHeight()), new Rect(0, 0, this.f13094i.getWidth(), this.f13094i.getHeight()), (Paint) null);
            this.f13092g.drawBitmap(this.f13094i, 0.0f, 0.0f, (Paint) null);
        }
        this.f13123ae.reset();
        this.f13125ag = 0;
    }

    @Override // com.sec.vip.amschaton.C3588u
    /* renamed from: a */
    public void mo12815a() {
        this.f13123ae.reset();
        this.f13125ag = 0;
    }

    @Override // com.sec.vip.amschaton.C3588u
    /* renamed from: a */
    public boolean mo12833a(float f, float f2, int i, float f3) {
        return mo12834a(f, f2, i, f3, true);
    }

    @Override // com.sec.vip.amschaton.C3588u
    /* renamed from: a */
    public boolean mo12834a(float f, float f2, int i, float f3, boolean z) {
        if (f3 < 0.0f) {
            this.f13122ad = false;
        } else {
            this.f13122ad = true;
            m12841b(f3);
        }
        mo12835a(f, f2, i, z);
        return true;
    }

    @Override // com.sec.vip.amschaton.C3588u
    /* renamed from: a */
    public boolean mo12832a(float f, float f2, int i) {
        return mo12835a(f, f2, i, true);
    }

    @Override // com.sec.vip.amschaton.C3588u
    /* renamed from: a */
    public boolean mo12835a(float f, float f2, int i, boolean z) {
        if (this.f13121ac && this.f13122ad) {
            m12860d(m12858j());
            this.f13123ae.quadTo(this.f13062E, this.f13063F, (this.f13062E + f) / 2.0f, (this.f13063F + f2) / 2.0f);
        } else {
            m12861l();
            this.f13123ae.quadTo(this.f13062E, this.f13063F, (this.f13062E + f) / 2.0f, (this.f13063F + f2) / 2.0f);
        }
        this.f13062E = f;
        this.f13063F = f2;
        if (i != 0) {
            if (this.f13082a != 4) {
                if (z) {
                    this.f13092g.drawBitmap(this.f13094i, 0.0f, 0.0f, (Paint) null);
                }
                this.f13092g.drawPath(this.f13123ae, this.f13097l);
            } else {
                this.f13095j.drawPath(this.f13123ae, this.f13097l);
                this.f13092g.drawBitmap(this.f13096k, new Rect(0, 0, this.f13096k.getWidth(), this.f13096k.getHeight()), new Rect(0, 0, this.f13094i.getWidth(), this.f13094i.getHeight()), (Paint) null);
                this.f13092g.drawBitmap(this.f13094i, 0.0f, 0.0f, (Paint) null);
            }
        }
        return true;
    }

    @Override // com.sec.vip.amschaton.C3588u
    /* renamed from: a */
    public boolean mo12830a(float f, float f2, float f3, float f4, int i) {
        this.f13092g.drawLine(f, f2, f3, f4, this.f13097l);
        return true;
    }

    @Override // com.sec.vip.amschaton.C3588u
    /* renamed from: d */
    public boolean mo12147d(float f, float f2) {
        mo12132a((short) f, (short) f2);
        this.f13124af = new ArrayList<>();
        this.f13124af.add(new C3592y(this, f, f2, m12855g()));
        return true;
    }

    @Override // com.sec.vip.amschaton.C3588u
    /* renamed from: e */
    public boolean mo12148e(float f, float f2) {
        if (this.f13125ag == 0) {
            return false;
        }
        if (this.f13121ac) {
            this.f13122ad = m12855g() >= 0.0f;
        }
        mo12832a((short) f, (short) f2, MotionEventCompat.ACTION_MASK);
        this.f13124af.add(new C3592y(this, f, f2, m12855g()));
        return true;
    }

    @Override // com.sec.vip.amschaton.C3588u
    /* renamed from: f */
    public boolean mo12149f(float f, float f2) {
        if (this.f13110y == null || this.f13125ag == 0) {
            return false;
        }
        if (this.f13125ag == 1 && this.f13126ah) {
            mo12148e(f + 1.0f, f2 + 1.0f);
            f += 1.0f;
            f2 += 1.0f;
            this.f13124af.add(new C3592y(this, f, f2, m12855g()));
        }
        this.f13126ah = true;
        float f3 = this.f13124af.get(this.f13124af.size() - 1).f13128a;
        float f4 = this.f13124af.get(this.f13124af.size() - 1).f13129b;
        mo12842b((short) f, (short) f2);
        if (this.f13121ac) {
            m12857i();
            m12861l();
        }
        this.f13124af.add(new C3592y(this, f, f2, m12855g()));
        if (this.f13110y == null) {
            return false;
        }
        if (!this.f13110y.VipAMS_EncodeStrokeStart(this.f13111z)) {
            C3250y.m11442a("VipAMS_EncodeStrokeStart failed", getClass().getSimpleName());
            this.f13125ag = 0;
            return false;
        }
        int size = this.f13124af.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            if (this.f13110y.VipAMS_EncodePointData(this.f13111z, (short) this.f13124af.get(i).f13128a, (short) this.f13124af.get(i).f13129b, (short) this.f13124af.get(i).f13130c)) {
                i++;
            } else {
                C3250y.m11442a("VipAMS_EncodePointData failed", getClass().getSimpleName());
                this.f13125ag = 0;
                break;
            }
        }
        if (this.f13110y.VipAMS_EncodeStrokeEnd(this.f13111z)) {
            return true;
        }
        C3250y.m11442a("VipAMS_EncodeStrokeEnd failed", getClass().getSimpleName());
        mo12815a();
        return false;
    }

    @Override // com.sec.vip.amschaton.C3588u
    /* renamed from: c */
    public void mo12851c(boolean z) {
        this.f13126ah = z;
    }
}
