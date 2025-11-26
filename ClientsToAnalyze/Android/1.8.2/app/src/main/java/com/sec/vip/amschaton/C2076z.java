package com.sec.vip.amschaton;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.text.TextPaint;
import com.sec.amsoma.structure.AMS_RECT;
import twitter4j.MediaEntity;

/* compiled from: AMSObjectTextGuide.java */
/* renamed from: com.sec.vip.amschaton.z */
/* loaded from: classes.dex */
public class C2076z extends C2068r {

    /* renamed from: V */
    public String f7457V;

    /* renamed from: W */
    public Rect f7458W;

    /* renamed from: X */
    private InterfaceC2062l f7459X;

    /* renamed from: Y */
    private Bitmap f7460Y;

    /* renamed from: Z */
    private int f7461Z;

    /* renamed from: aa */
    private int f7462aa;

    /* renamed from: ab */
    private int[] f7463ab;

    /* renamed from: ac */
    private final int f7464ac;

    /* renamed from: ad */
    private final int f7465ad;

    /* renamed from: ae */
    private float f7466ae;

    /* renamed from: af */
    private float f7467af;

    /* renamed from: ag */
    private int f7468ag;

    /* renamed from: ah */
    private boolean f7469ah;

    /* renamed from: ai */
    private float f7470ai;

    /* renamed from: aj */
    private int f7471aj;

    /* renamed from: ak */
    private float f7472ak;

    /* renamed from: al */
    private float f7473al;

    /* renamed from: am */
    private float f7474am;

    /* renamed from: an */
    private float f7475an;

    /* renamed from: ao */
    private float f7476ao;

    public C2076z(int i, int i2, int i3, boolean z, int i4, int i5) {
        super(i, i2, i3, i4, i5);
        this.f7459X = null;
        this.f7460Y = null;
        this.f7461Z = 0;
        this.f7462aa = 0;
        this.f7463ab = new int[]{15, 18, 20, 23, 25};
        this.f7464ac = 15;
        this.f7465ad = 12;
        this.f7466ae = 0.0f;
        this.f7467af = 0.0f;
        this.f7468ag = 0;
        this.f7469ah = false;
        this.f7470ai = 0.0f;
        this.f7471aj = 0;
        this.f7472ak = 0.0f;
        this.f7473al = 0.0f;
        this.f7474am = 0.0f;
        this.f7457V = new String();
        this.f7458W = new Rect(0, 0, 0, 0);
        this.f7475an = 0.0f;
        this.f7476ao = 0.0f;
        this.f7401j = new Paint();
        this.f7401j.setColor(this.f7393b);
        this.f7401j.setAntiAlias(true);
        this.f7401j.setDither(true);
        this.f7401j.setStrokeCap(Paint.Cap.ROUND);
        this.f7401j.setStrokeJoin(Paint.Join.ROUND);
        this.f7401j.setStyle(Paint.Style.FILL);
        int i6 = i3 < 0 ? 0 : i3;
        this.f7394c = i6 > 4 ? 4 : i6;
        this.f7471aj = this.f7394c;
        this.f7401j.setTextSize(this.f7463ab[this.f7394c] * this.f7395d);
        this.f7469ah = z;
    }

    @Override // com.sec.vip.amschaton.C2068r
    /* renamed from: a */
    public void mo7194a(float f) {
        super.mo7194a(f);
        this.f7401j.setTextSize((float) ((this.f7463ab[this.f7394c] * f) + 0.5d));
    }

    @Override // com.sec.vip.amschaton.C2068r
    /* renamed from: c */
    public boolean mo7233c(float f, float f2) {
        if (this.f7417z != 2) {
            return false;
        }
        float f3 = 15.0f * this.f7395d;
        return new RectF(((float) this.f7458W.left) - f3, ((float) this.f7458W.top) - f3, (((float) this.f7458W.right) + f3) + ((float) ((int) (12.0f * this.f7395d))), f3 + ((float) this.f7458W.bottom)).contains(f, f2);
    }

    /* renamed from: a */
    public boolean m7263a(String str, int i, int i2) {
        this.f7393b = i;
        this.f7401j.setColor(this.f7393b);
        int i3 = i2 < 0 ? 0 : i2;
        this.f7394c = i3 <= 5 ? i3 : 5;
        this.f7471aj = this.f7394c;
        this.f7401j.setTextSize(this.f7463ab[this.f7394c] * this.f7395d);
        m7261a(str);
        this.f7457V = str;
        this.f7458W.set((int) (this.f7371C - (this.f7461Z / 2)), (int) (this.f7372D - (this.f7462aa / 2)), (int) (this.f7371C + (this.f7461Z / 2)), (int) (this.f7372D + (this.f7462aa / 2)));
        if (this.f7469ah) {
            mo7211a(this.f7458W.left, this.f7458W.top, this.f7458W.right, this.f7458W.bottom, str, MotionEventCompat.ACTION_MASK);
            return true;
        }
        m7262a(str, MotionEventCompat.ACTION_MASK);
        return true;
    }

    /* renamed from: a */
    public boolean m7264a(String str, int i, int i2, float f, float f2) {
        this.f7371C = f;
        this.f7372D = f2;
        return m7263a(str, i, i2);
    }

    @Override // com.sec.vip.amschaton.C2068r
    /* renamed from: a */
    public boolean mo7218a(int i, int i2, int i3) {
        super.mo7218a(i, i2, i3);
        int i4 = i3 < 0 ? 0 : i3;
        int i5 = i4 <= 5 ? i4 : 5;
        boolean z = this.f7471aj != i5;
        this.f7394c = i5;
        this.f7471aj = this.f7394c;
        this.f7401j.setTextSize(this.f7463ab[this.f7394c] * this.f7395d);
        if (this.f7469ah) {
            RectF rectF = new RectF(this.f7458W);
            m7260a(rectF, this.f7457V);
            if (!this.f7374F) {
                return false;
            }
            AMS_RECT ams_rect = new AMS_RECT();
            ams_rect.nLeft = (short) rectF.left;
            ams_rect.nTop = (short) rectF.top;
            ams_rect.nRight = (short) rectF.right;
            ams_rect.nBottom = (short) rectF.bottom;
            if (z) {
                float f = (rectF.left + rectF.right) / 2.0f;
                float f2 = (rectF.bottom + rectF.top) / 2.0f;
                ams_rect.nLeft = (short) (f - (this.f7461Z / 2));
                ams_rect.nTop = (short) (f2 - (this.f7462aa / 2));
                ams_rect.nRight = (short) (f + (this.f7461Z / 2));
                ams_rect.nBottom = (short) (f2 + (this.f7462aa / 2));
            }
            this.f7458W.set(ams_rect.nLeft, ams_rect.nTop, ams_rect.nRight, ams_rect.nBottom);
            this.f7401j.setColor(i2);
            this.f7460Y = null;
            mo7211a(ams_rect.nLeft, ams_rect.nTop, ams_rect.nRight, ams_rect.nBottom, this.f7457V, MotionEventCompat.ACTION_MASK);
        } else {
            m7261a(this.f7457V);
            if (!this.f7374F) {
                return false;
            }
            AMS_RECT ams_rect2 = new AMS_RECT();
            float f3 = (this.f7458W.left + this.f7458W.right) / 2.0f;
            float f4 = (this.f7458W.top + this.f7458W.bottom) / 2.0f;
            ams_rect2.nLeft = (short) (f3 - (this.f7461Z / 2));
            ams_rect2.nTop = (short) (f4 - (this.f7462aa / 2));
            ams_rect2.nRight = (short) (f3 + (this.f7461Z / 2));
            ams_rect2.nBottom = (short) ((this.f7462aa / 2) + f4);
            this.f7458W.set(ams_rect2.nLeft, ams_rect2.nTop, ams_rect2.nRight, ams_rect2.nBottom);
            this.f7401j.setColor(i2);
            this.f7460Y = null;
            mo7217a(this.f7458W.left, this.f7458W.top, this.f7457V, MotionEventCompat.ACTION_MASK);
        }
        return true;
    }

    @Override // com.sec.vip.amschaton.C2068r
    /* renamed from: b */
    public boolean mo7228b(AMS_RECT ams_rect) {
        if (!this.f7374F) {
            return false;
        }
        if (this.f7469ah) {
            this.f7458W.set(ams_rect.nLeft, ams_rect.nTop, ams_rect.nRight, ams_rect.nBottom);
            mo7211a(ams_rect.nLeft, ams_rect.nTop, ams_rect.nRight, ams_rect.nBottom, this.f7457V, MotionEventCompat.ACTION_MASK);
        } else {
            this.f7458W.set(ams_rect.nLeft, ams_rect.nTop, ams_rect.nRight, ams_rect.nBottom);
            mo7217a(ams_rect.nLeft, ams_rect.nTop, this.f7457V, MotionEventCompat.ACTION_MASK);
        }
        return true;
    }

    @Override // com.sec.vip.amschaton.C2068r
    /* renamed from: d */
    public boolean mo7235d(float f, float f2) {
        if (this.f7469ah) {
            boolean z = false;
            switch (this.f7417z) {
                case 2:
                    this.f7475an = f;
                    this.f7476ao = f2;
                    int i = this.f7458W.left;
                    int i2 = this.f7458W.top;
                    int i3 = this.f7458W.right;
                    int i4 = this.f7458W.bottom;
                    int i5 = (int) (this.f7384P * this.f7395d * 2.0f);
                    int i6 = i - i5;
                    int i7 = i2 - i5;
                    int i8 = i3 + i5 + ((int) (12.0f * this.f7395d));
                    int i9 = i5 + i4;
                    if (Math.abs(i8 - f) < 15.0f * this.f7395d && Math.abs(i7 - f2) < 15.0f * this.f7395d) {
                        m7198a(MediaEntity.Size.CROP, true);
                        z = true;
                    } else if (Math.abs(((i6 + i8) / 2) - f) < 15.0f * this.f7395d && Math.abs(i7 - f2) < 15.0f * this.f7395d) {
                        this.f7371C = i;
                        this.f7372D = i4;
                        this.f7466ae = i3;
                        this.f7467af = i4;
                        this.f7472ak = this.f7371C;
                        this.f7473al = this.f7466ae;
                        this.f7417z = 6;
                        this.f7468ag = 106;
                    } else if (Math.abs(i8 - f) < 15.0f * this.f7395d && Math.abs(((i7 + i9) / 2) - f2) < 15.0f * this.f7395d) {
                        this.f7371C = i;
                        this.f7372D = i2;
                        this.f7466ae = i;
                        this.f7467af = i4;
                        this.f7417z = 5;
                        this.f7468ag = 107;
                    } else if (Math.abs(((i8 + i6) / 2) - f) < 15.0f * this.f7395d && Math.abs(i9 - f2) < 15.0f * this.f7395d) {
                        this.f7371C = i;
                        this.f7372D = i2;
                        this.f7466ae = i3;
                        this.f7467af = i2;
                        this.f7472ak = this.f7371C;
                        this.f7473al = this.f7466ae;
                        this.f7417z = 6;
                        this.f7468ag = 108;
                    } else if (Math.abs(i6 - f) < 15.0f * this.f7395d && Math.abs(((i7 + i9) / 2) - f2) < 15.0f * this.f7395d) {
                        this.f7371C = i3;
                        this.f7372D = i2;
                        this.f7466ae = i3;
                        this.f7467af = i4;
                        this.f7417z = 5;
                        this.f7468ag = 105;
                    }
                    this.f7470ai = f2;
                    this.f7375G = false;
                    if (this.f7417z == 5 || this.f7417z == 6) {
                        m7198a(this.f7468ag, true);
                        String str = new String(this.f7457V);
                        mo7217a(f, f2, str, AccessibilityEventCompat.TYPE_VIEW_HOVER_ENTER);
                        this.f7474am = m7257b(str);
                    } else if (z) {
                        this.f7417z = 7;
                    } else {
                        this.f7369A = (int) (f - this.f7458W.left);
                        this.f7370B = (int) (f2 - this.f7458W.top);
                        this.f7417z = 3;
                        mo7211a(this.f7458W.left, this.f7458W.top, this.f7458W.right, this.f7458W.bottom, this.f7457V, AccessibilityEventCompat.TYPE_VIEW_HOVER_ENTER);
                    }
                    break;
                default:
                    return true;
            }
        } else {
            switch (this.f7417z) {
                case 2:
                    int i10 = this.f7458W.top;
                    if (Math.abs(this.f7458W.right - f) < 15.0f * this.f7395d && Math.abs(i10 - f2) < 15.0f * this.f7395d) {
                        m7198a(MediaEntity.Size.CROP, true);
                        this.f7417z = 7;
                    } else {
                        this.f7369A = (int) (f - this.f7458W.left);
                        this.f7370B = (int) (f2 - this.f7458W.top);
                        this.f7417z = 3;
                        mo7195a(this.f7458W.left, this.f7458W.top);
                        m7262a(new String(this.f7457V), AccessibilityEventCompat.TYPE_VIEW_HOVER_ENTER);
                        this.f7375G = false;
                        mo7195a(f, f2);
                    }
                    break;
                default:
                    return true;
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.sec.vip.amschaton.C2068r
    /* renamed from: e */
    public boolean mo7237e(float f, float f2) {
        if (this.f7469ah) {
            switch (this.f7417z) {
                case 1:
                case 5:
                    float f3 = f - this.f7371C;
                    float f4 = f2 - this.f7372D;
                    if (f3 > this.f7461Z) {
                        f = this.f7371C + this.f7461Z;
                    }
                    if ((-this.f7461Z) > f3) {
                        f = this.f7371C - this.f7461Z;
                    }
                    if (f4 > this.f7462aa || (0.0f <= f4 && f4 < this.f7462aa)) {
                        f2 = this.f7372D + this.f7462aa;
                    }
                    if ((-this.f7462aa) > f4 || ((-this.f7462aa) < f4 && f4 < 0.0f)) {
                        f2 = this.f7372D - this.f7462aa;
                    }
                    mo7217a(f, f2, this.f7457V, AccessibilityEventCompat.TYPE_VIEW_HOVER_ENTER);
                    if (this.f7374F) {
                        this.f7375G = true;
                    }
                    m7198a(this.f7468ag, true);
                    break;
                case 3:
                    m7258b(f - this.f7369A, f2 - this.f7370B, ((this.f7458W.right - this.f7458W.left) + f) - this.f7369A, ((this.f7458W.bottom - this.f7458W.top) + f2) - this.f7370B, this.f7457V, AccessibilityEventCompat.TYPE_VIEW_HOVER_ENTER, false);
                    if (this.f7374F) {
                        this.f7375G = true;
                        break;
                    }
                    break;
                case 6:
                    int i = this.f7462aa;
                    float f5 = (f2 - this.f7470ai) * 0.6f;
                    if (this.f7468ag == 106) {
                        this.f7371C -= f5;
                        this.f7466ae += f5;
                        i = -this.f7462aa;
                    } else if (this.f7468ag == 108) {
                        this.f7371C += f5;
                        this.f7466ae -= f5;
                    }
                    if (this.f7371C > this.f7466ae) {
                        float f6 = this.f7466ae;
                        this.f7466ae = this.f7371C;
                        this.f7371C = f6;
                    }
                    if (Math.abs(this.f7466ae - this.f7371C) > this.f7474am) {
                        this.f7371C = this.f7472ak;
                        this.f7466ae = this.f7473al;
                    }
                    this.f7472ak = this.f7371C;
                    this.f7473al = this.f7466ae;
                    this.f7470ai = f2;
                    float f7 = f2 - this.f7372D;
                    if (f7 > this.f7462aa || ((0.0f <= f7 && f7 < this.f7462aa) || (-this.f7462aa) > f7 || ((-this.f7462aa) < f7 && f7 < 0.0f))) {
                        f2 = this.f7372D + i;
                    }
                    mo7217a(f, f2, this.f7457V, AccessibilityEventCompat.TYPE_VIEW_HOVER_ENTER);
                    if (this.f7374F) {
                        this.f7375G = true;
                    }
                    m7198a(this.f7468ag, true);
                    break;
                case 7:
                    int i2 = this.f7458W.top;
                    int i3 = this.f7458W.right;
                    int i4 = (int) (this.f7384P * this.f7395d * 2.0f);
                    if (!(Math.abs(((float) ((i3 + i4) + ((int) (12.0f * this.f7395d)))) - f) < this.f7395d * 15.0f && Math.abs(((float) (i2 - i4)) - f2) < this.f7395d * 15.0f)) {
                        m7198a(MediaEntity.Size.CROP, false);
                        this.f7417z = 2;
                        break;
                    }
                    break;
            }
        } else {
            switch (this.f7417z) {
                case 3:
                    if (!this.f7375G && (Math.abs(this.f7371C - f) > 10.0f * this.f7395d || Math.abs(this.f7372D - f2) > 10.0f * this.f7395d)) {
                        this.f7375G = true;
                    }
                    mo7217a(f - this.f7369A, f2 - this.f7370B, this.f7457V, AccessibilityEventCompat.TYPE_VIEW_HOVER_ENTER);
                    break;
                case 7:
                    if (!(Math.abs(((float) this.f7458W.right) - f) < this.f7395d * 15.0f && Math.abs(((float) this.f7458W.top) - f2) < this.f7395d * 15.0f)) {
                        m7198a(MediaEntity.Size.CROP, false);
                        this.f7417z = 2;
                        break;
                    }
                    break;
            }
        }
        return true;
    }

    @Override // com.sec.vip.amschaton.C2068r
    /* renamed from: f */
    public boolean mo7239f(float f, float f2) {
        if (this.f7469ah) {
            AMS_RECT ams_rect = new AMS_RECT();
            float f3 = f - this.f7371C;
            float f4 = f2 - this.f7372D;
            switch (this.f7417z) {
                case 0:
                    mo7195a(f, f2);
                    if (this.f7459X != null) {
                        this.f7459X.mo7172a(null, (this.f7458W.left + this.f7458W.right) / 2, (this.f7458W.top + this.f7458W.bottom) / 2);
                        break;
                    } else {
                        return false;
                    }
                case 1:
                    if (f3 > this.f7461Z) {
                        f = this.f7371C + this.f7461Z;
                    }
                    if ((-this.f7461Z) > f3) {
                        f = this.f7371C - this.f7461Z;
                    }
                    if (f4 > this.f7462aa || (0.0f <= f4 && f4 < this.f7462aa)) {
                        f2 = this.f7372D + this.f7462aa;
                    }
                    if ((-this.f7462aa) > f4 || ((-this.f7462aa) < f4 && f4 < 0.0f)) {
                        f2 = this.f7372D - this.f7462aa;
                    }
                    ams_rect.nLeft = (short) this.f7371C;
                    ams_rect.nTop = (short) this.f7372D;
                    ams_rect.nRight = (short) f;
                    ams_rect.nBottom = (short) f2;
                    if (f < this.f7371C) {
                        ams_rect.nLeft = (short) f;
                        ams_rect.nRight = (short) this.f7371C;
                    }
                    if (f2 < this.f7372D) {
                        ams_rect.nTop = (short) f2;
                        ams_rect.nBottom = (short) this.f7372D;
                    }
                    this.f7417z = 0;
                    return mo7221a(ams_rect);
                case 3:
                    this.f7417z = 2;
                    int i = this.f7458W.right - this.f7458W.left;
                    int i2 = this.f7458W.bottom - this.f7458W.top;
                    ams_rect.nLeft = (short) (f - this.f7369A);
                    ams_rect.nTop = (short) (f2 - this.f7370B);
                    ams_rect.nRight = (short) ((i + f) - this.f7369A);
                    ams_rect.nBottom = (short) ((i2 + f2) - this.f7370B);
                    boolean zMo7228b = mo7228b(ams_rect);
                    if (this.f7375G && (Math.abs(this.f7475an - f) > 4.0f || Math.abs(this.f7476ao - f2) > 4.0f)) {
                        this.f7375G = false;
                        return zMo7228b;
                    }
                    mo7195a(f - this.f7369A, f2 - this.f7370B);
                    if (!this.f7373E) {
                        this.f7373E = true;
                        return true;
                    }
                    if (this.f7459X != null) {
                        this.f7459X.mo7172a(null, (this.f7458W.left + this.f7458W.right) / 2, (this.f7458W.top + this.f7458W.bottom) / 2);
                        break;
                    } else {
                        return false;
                    }
                    break;
                case 5:
                    if (f3 > this.f7461Z) {
                        f = this.f7371C + this.f7461Z;
                    }
                    if ((-this.f7461Z) > f3) {
                        f = this.f7371C - this.f7461Z;
                    }
                    if (f4 > this.f7462aa || (0.0f <= f4 && f4 < this.f7462aa)) {
                        f2 = this.f7372D + this.f7462aa;
                    }
                    if ((-this.f7462aa) > f4 || ((-this.f7462aa) < f4 && f4 < 0.0f)) {
                        f2 = this.f7372D - this.f7462aa;
                    }
                    if (!this.f7375G) {
                        mo7217a(f, f2, this.f7377I.getM_TText().getM_strText(), MotionEventCompat.ACTION_MASK);
                        break;
                    } else {
                        this.f7375G = false;
                        this.f7467af = f2;
                        ams_rect.nLeft = (short) this.f7371C;
                        ams_rect.nTop = (short) this.f7372D;
                        ams_rect.nRight = (short) f;
                        ams_rect.nBottom = (short) this.f7467af;
                        if (f < this.f7371C) {
                            ams_rect.nLeft = (short) f;
                            ams_rect.nRight = (short) this.f7371C;
                        }
                        return mo7228b(ams_rect);
                    }
                    break;
                case 6:
                    if (this.f7375G) {
                        int i3 = this.f7462aa;
                        if (this.f7468ag == 106) {
                            i3 = -this.f7462aa;
                        }
                        if (f4 > this.f7462aa || ((0.0f <= f4 && f4 < this.f7462aa) || (-this.f7462aa) > f4 || ((-this.f7462aa) < f4 && f4 < 0.0f))) {
                            f2 = this.f7372D + i3;
                        }
                        this.f7375G = false;
                        ams_rect.nLeft = (short) this.f7371C;
                        ams_rect.nTop = (short) this.f7372D;
                        ams_rect.nRight = (short) this.f7466ae;
                        ams_rect.nBottom = (short) f2;
                        if (f2 < this.f7372D) {
                            ams_rect.nTop = (short) f2;
                            ams_rect.nBottom = (short) this.f7372D;
                        }
                        return mo7228b(ams_rect);
                    }
                    if (f3 > this.f7461Z) {
                        f = this.f7371C + this.f7461Z;
                    }
                    if ((-this.f7461Z) > f3) {
                        f = this.f7371C - this.f7461Z;
                    }
                    if (f4 > this.f7462aa || (0.0f <= f4 && f4 < this.f7462aa)) {
                        f2 = this.f7372D + this.f7462aa;
                    }
                    if ((-this.f7462aa) > f4 || ((-this.f7462aa) < f4 && f4 < 0.0f)) {
                        f2 = this.f7372D - this.f7462aa;
                    }
                    mo7217a(f, f2, this.f7457V, MotionEventCompat.ACTION_MASK);
                    break;
                    break;
                case 7:
                    m7198a(MediaEntity.Size.CROP, false);
                    this.f7385Q.mo6859a();
                    break;
            }
            return false;
        }
        AMS_RECT ams_rect2 = new AMS_RECT();
        switch (this.f7417z) {
            case 0:
                if (!this.f7373E) {
                    this.f7373E = true;
                    return true;
                }
                mo7195a(f, f2);
                if (this.f7459X != null) {
                    this.f7459X.mo7172a(null, (this.f7458W.left + this.f7458W.right) / 2, (this.f7458W.top + this.f7458W.bottom) / 2);
                    break;
                } else {
                    return false;
                }
            case 3:
                this.f7417z = 2;
                int i4 = this.f7458W.right - this.f7458W.left;
                int i5 = this.f7458W.bottom - this.f7458W.top;
                ams_rect2.nLeft = (short) (f - this.f7369A);
                ams_rect2.nTop = (short) (f2 - this.f7370B);
                ams_rect2.nRight = (short) ((i4 + f) - this.f7369A);
                ams_rect2.nBottom = (short) ((i5 + f2) - this.f7370B);
                boolean zMo7228b2 = mo7228b(ams_rect2);
                if (this.f7375G) {
                    this.f7375G = false;
                    return zMo7228b2;
                }
                mo7195a(f - this.f7369A, f2 - this.f7370B);
                if (!this.f7373E) {
                    this.f7373E = true;
                    return true;
                }
                if (this.f7459X != null) {
                    this.f7459X.mo7172a(null, (this.f7458W.left + this.f7458W.right) / 2, (this.f7458W.top + this.f7458W.bottom) / 2);
                    break;
                } else {
                    return false;
                }
            case 7:
                m7198a(MediaEntity.Size.CROP, false);
                this.f7385Q.mo6859a();
                break;
        }
        return true;
    }

    @Override // com.sec.vip.amschaton.C2068r
    /* renamed from: a */
    public void mo7195a(float f, float f2) {
        this.f7371C = (int) f;
        this.f7372D = (int) f2;
    }

    /* renamed from: a */
    public boolean m7261a(String str) {
        TextPaint textPaint = new TextPaint();
        textPaint.setAntiAlias(true);
        textPaint.setDither(true);
        textPaint.setTextSize(this.f7463ab[this.f7394c] * this.f7395d);
        textPaint.setColor(this.f7393b);
        String str2 = "";
        StringBuilder sb = new StringBuilder();
        this.f7461Z = 0;
        this.f7462aa = 0;
        int i = this.f7380L - ((int) ((40.0f * this.f7395d) + 0.5f));
        int length = str.length();
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            char cCharAt = str.charAt(i3);
            int iMeasureText = (int) textPaint.measureText(sb.toString());
            if (this.f7461Z < iMeasureText) {
                this.f7461Z = iMeasureText;
            }
            if (iMeasureText > i) {
                str2 = str2 + sb.toString() + "\n";
                sb = new StringBuilder();
                sb.append(cCharAt);
                i2++;
            } else {
                sb.append(cCharAt);
            }
        }
        String str3 = str2 + sb.toString();
        int i4 = i2 + 1;
        int iMeasureText2 = (int) textPaint.measureText(sb.toString());
        if (this.f7461Z < iMeasureText2) {
            this.f7461Z = iMeasureText2;
        }
        this.f7462aa = (int) ((i4 + 0.4d) * textPaint.getTextSize());
        if (this.f7460Y != null) {
            this.f7460Y.recycle();
            this.f7460Y = null;
        }
        this.f7460Y = Bitmap.createBitmap(this.f7461Z, this.f7462aa, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(this.f7460Y);
        int i5 = 0;
        int i6 = 1;
        while (true) {
            int iIndexOf = str3.indexOf("\n", i5);
            if (iIndexOf == -1) {
                canvas.drawText(str3.substring(i5, str3.length()), 0.0f, i6 * textPaint.getTextSize(), textPaint);
                return true;
            }
            canvas.drawText(str3.substring(i5, iIndexOf), 0.0f, textPaint.getTextSize() * i6, textPaint);
            i5 = iIndexOf + 1;
            i6++;
        }
    }

    /* renamed from: a */
    public boolean m7260a(RectF rectF, String str) {
        TextPaint textPaint = new TextPaint();
        textPaint.setAntiAlias(true);
        textPaint.setDither(true);
        textPaint.setTextSize(this.f7463ab[this.f7394c] * this.f7395d);
        textPaint.setColor(this.f7393b);
        String str2 = "";
        StringBuilder sb = new StringBuilder();
        this.f7461Z = 0;
        this.f7462aa = 0;
        int length = str.length();
        int iWidth = (int) rectF.width();
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            if (str.charAt(i3) < 128) {
                i2++;
            } else {
                i2 += 2;
            }
            if (i2 > 0) {
                if (i2 % 2 == 0) {
                    int iMeasureText = (int) textPaint.measureText(sb.toString());
                    if (this.f7461Z < iMeasureText) {
                        this.f7461Z = iMeasureText;
                    }
                    if (iMeasureText > iWidth) {
                        str2 = str2 + sb.toString() + "\n";
                        sb = new StringBuilder();
                        sb.append(str.charAt(i3));
                        i++;
                        i2 = 1;
                    } else {
                        sb.append(str.charAt(i3));
                    }
                } else {
                    int iMeasureText2 = (int) textPaint.measureText(sb.toString());
                    if (this.f7461Z < iMeasureText2) {
                        this.f7461Z = iMeasureText2;
                    }
                    if (iMeasureText2 > iWidth) {
                        str2 = str2 + sb.toString() + "\n";
                        sb = new StringBuilder();
                        sb.append("" + str.charAt(i3));
                        i2 = 2;
                        i++;
                    } else {
                        sb.append(str.charAt(i3));
                    }
                }
            } else {
                sb.append(str.charAt(i3));
            }
        }
        if (i2 > 0) {
            str2 = str2 + ((Object) sb);
            i++;
            int iMeasureText3 = (int) textPaint.measureText(sb.toString());
            if (this.f7461Z < iMeasureText3) {
                this.f7461Z = iMeasureText3;
            }
        }
        this.f7462aa = (int) ((i + 0.4d) * textPaint.getTextSize());
        if (this.f7460Y != null) {
            this.f7460Y.recycle();
            this.f7460Y = null;
        }
        this.f7460Y = Bitmap.createBitmap(this.f7461Z, this.f7462aa, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(this.f7460Y);
        int i4 = 0;
        int i5 = 1;
        while (true) {
            int iIndexOf = str2.indexOf("\n", i4);
            if (iIndexOf == -1) {
                canvas.drawText(str2.substring(i4, str2.length()), 0.0f, textPaint.getTextSize() * i5, textPaint);
                return true;
            }
            canvas.drawText(str2.substring(i4, iIndexOf), 0.0f, textPaint.getTextSize() * i5, textPaint);
            i4 = iIndexOf + 1;
            i5++;
        }
    }

    /* renamed from: b */
    private float m7257b(String str) {
        TextPaint textPaint = new TextPaint();
        textPaint.setAntiAlias(true);
        textPaint.setDither(true);
        textPaint.setTextSize(this.f7463ab[this.f7394c] * this.f7395d);
        textPaint.setColor(this.f7393b);
        return textPaint.measureText(str);
    }

    /* renamed from: a */
    public boolean m7262a(String str, int i) {
        mo7217a(this.f7371C, this.f7372D, str, i);
        return true;
    }

    @Override // com.sec.vip.amschaton.C2068r
    /* renamed from: a */
    public boolean mo7217a(float f, float f2, String str, int i) {
        float f3;
        float f4;
        float f5;
        if (this.f7469ah) {
            float f6 = this.f7371C;
            float f7 = this.f7372D;
            switch (this.f7417z) {
                case 5:
                    f3 = this.f7467af;
                    f4 = f;
                    break;
                case 6:
                    f3 = f2;
                    f4 = this.f7466ae;
                    break;
                default:
                    f3 = f2;
                    f4 = f;
                    break;
            }
            if (f6 <= f4) {
                float f8 = f4;
                f4 = f6;
                f6 = f8;
            }
            if (f7 > f3) {
                f5 = f3;
            } else {
                f5 = f7;
                f7 = f3;
            }
            return mo7211a(f4, f5, f6, f7, str, i);
        }
        this.f7401j.setAlpha(i);
        if (this.f7460Y == null) {
            m7261a(str);
        }
        Rect rect = new Rect((int) f, (int) f2, (int) (this.f7461Z + f), (int) (this.f7462aa + f2));
        this.f7396e.drawBitmap(this.f7398g, 0.0f, 0.0f, (Paint) null);
        this.f7396e.drawBitmap(this.f7460Y, f, f2, this.f7401j);
        m7196a(rect.left, rect.top, rect.right, rect.bottom);
        return true;
    }

    @Override // com.sec.vip.amschaton.C2068r
    /* renamed from: a */
    public boolean mo7211a(float f, float f2, float f3, float f4, String str, int i) {
        return m7258b(f, f2, f3, f4, str, i, false);
    }

    /* renamed from: b */
    private boolean m7258b(float f, float f2, float f3, float f4, String str, int i, boolean z) {
        this.f7401j.setAlpha(i);
        RectF rectF = new RectF(f, f2, f3, f4);
        if (z) {
            m7260a(rectF, str);
        }
        this.f7396e.drawBitmap(this.f7398g, 0.0f, 0.0f, (Paint) null);
        float f5 = ((f + f3) - this.f7461Z) / 2.0f;
        float f6 = ((f + f3) + this.f7461Z) / 2.0f;
        switch (this.f7468ag) {
            case 105:
                this.f7396e.drawBitmap(this.f7460Y, f3 - this.f7461Z, f2, this.f7401j);
                rectF.set(f3 - this.f7461Z, f2, f3, this.f7462aa + f2);
                break;
            case 106:
                if (this.f7375G) {
                    this.f7396e.drawBitmap(this.f7460Y, f5, f2, this.f7401j);
                    rectF.set(f5, f4 - this.f7462aa, f6, f4);
                    break;
                } else {
                    this.f7396e.drawBitmap(this.f7460Y, f, f2, this.f7401j);
                    rectF.set(f, f2, this.f7461Z + f, this.f7462aa + f2);
                    break;
                }
            case 107:
            default:
                this.f7396e.drawBitmap(this.f7460Y, f, f2, this.f7401j);
                rectF.set(f, f2, this.f7461Z + f, this.f7462aa + f2);
                break;
            case 108:
                if (this.f7375G) {
                    this.f7396e.drawBitmap(this.f7460Y, f5, f2, this.f7401j);
                    rectF.set(f5, f2, f6, this.f7462aa + f2);
                    break;
                } else {
                    this.f7396e.drawBitmap(this.f7460Y, f, f2, this.f7401j);
                    rectF.set(f, f2, this.f7461Z + f, this.f7462aa + f2);
                    break;
                }
        }
        m7196a(rectF.left, rectF.top, rectF.right, rectF.bottom);
        return true;
    }

    /* renamed from: a */
    public void m7259a(InterfaceC2062l interfaceC2062l) {
        this.f7459X = interfaceC2062l;
    }
}
