package com.sec.vip.amschaton;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.v4.view.MotionEventCompat;
import android.text.TextPaint;
import com.sec.amsoma.structure.AMS_RECT;

/* compiled from: AMSObjectTextGuide.java */
/* renamed from: com.sec.vip.amschaton.c */
/* loaded from: classes.dex */
public class C1398c extends C1468i {

    /* renamed from: V */
    private InterfaceC1557v f4900V;

    /* renamed from: W */
    private Bitmap f4901W;

    /* renamed from: X */
    private int f4902X;

    /* renamed from: Y */
    private int f4903Y;

    /* renamed from: Z */
    private int[] f4904Z;

    /* renamed from: a */
    public String f4905a;

    /* renamed from: aa */
    private final int f4906aa;

    /* renamed from: ab */
    private final int f4907ab;

    /* renamed from: ac */
    private float f4908ac;

    /* renamed from: ad */
    private float f4909ad;

    /* renamed from: ae */
    private int f4910ae;

    /* renamed from: af */
    private boolean f4911af;

    /* renamed from: ag */
    private float f4912ag;

    /* renamed from: ah */
    private int f4913ah;

    /* renamed from: ai */
    private float f4914ai;

    /* renamed from: aj */
    private float f4915aj;

    /* renamed from: ak */
    private float f4916ak;

    /* renamed from: al */
    private float f4917al;

    /* renamed from: am */
    private float f4918am;

    /* renamed from: b */
    public Rect f4919b;

    public C1398c(int i, int i2, int i3, boolean z, int i4, int i5) {
        super(i, i2, i3, i4, i5);
        this.f4900V = null;
        this.f4901W = null;
        this.f4902X = 0;
        this.f4903Y = 0;
        this.f4904Z = new int[]{15, 18, 20, 23, 25};
        this.f4906aa = 15;
        this.f4907ab = 12;
        this.f4908ac = 0.0f;
        this.f4909ad = 0.0f;
        this.f4910ae = 0;
        this.f4911af = false;
        this.f4912ag = 0.0f;
        this.f4913ah = 0;
        this.f4914ai = 0.0f;
        this.f4915aj = 0.0f;
        this.f4916ak = 0.0f;
        this.f4905a = new String();
        this.f4919b = new Rect(0, 0, 0, 0);
        this.f4917al = 0.0f;
        this.f4918am = 0.0f;
        this.f5154l = new Paint();
        this.f5154l.setColor(this.f5146d);
        this.f5154l.setAntiAlias(true);
        this.f5154l.setDither(true);
        this.f5154l.setStrokeCap(Paint.Cap.ROUND);
        this.f5154l.setStrokeJoin(Paint.Join.ROUND);
        this.f5154l.setStyle(Paint.Style.FILL);
        int i6 = i3 < 0 ? 0 : i3;
        this.f5147e = i6 > 4 ? 4 : i6;
        this.f4913ah = this.f5147e;
        this.f5154l.setTextSize(this.f4904Z[this.f5147e] * this.f5148f);
        this.f4911af = z;
    }

    @Override // com.sec.vip.amschaton.C1468i
    /* renamed from: a */
    public void mo4887a(float f) {
        super.mo4887a(f);
        this.f5154l.setTextSize((float) ((this.f4904Z[this.f5147e] * f) + 0.5d));
    }

    @Override // com.sec.vip.amschaton.C1468i
    /* renamed from: a */
    public boolean mo4944a(float f, float f2) {
        if (this.f5123B != 2) {
            return false;
        }
        float f3 = 15.0f * this.f5148f;
        return new RectF(((float) this.f4919b.left) - f3, ((float) this.f4919b.top) - f3, (((float) this.f4919b.right) + f3) + ((float) ((int) (12.0f * this.f5148f))), f3 + ((float) this.f4919b.bottom)).contains(f, f2);
    }

    /* renamed from: a */
    public boolean m5010a(String str, int i, int i2) {
        this.f5146d = i;
        this.f5154l.setColor(this.f5146d);
        int i3 = i2 < 0 ? 0 : i2;
        this.f5147e = i3 <= 5 ? i3 : 5;
        this.f4913ah = this.f5147e;
        this.f5154l.setTextSize(this.f4904Z[this.f5147e] * this.f5148f);
        m5008a(str);
        this.f4905a = str;
        this.f4919b.set((int) (this.f5126E - (this.f4902X / 2)), (int) (this.f5127F - (this.f4903Y / 2)), (int) (this.f5126E + (this.f4902X / 2)), (int) (this.f5127F + (this.f4903Y / 2)));
        if (this.f4911af) {
            mo4971a(this.f4919b.left, this.f4919b.top, this.f4919b.right, this.f4919b.bottom, str, MotionEventCompat.ACTION_MASK);
            return true;
        }
        m5009a(str, MotionEventCompat.ACTION_MASK);
        return true;
    }

    /* renamed from: a */
    public boolean m5011a(String str, int i, int i2, float f, float f2) {
        this.f5126E = f;
        this.f5127F = f2;
        return m5010a(str, i, i2);
    }

    @Override // com.sec.vip.amschaton.C1468i
    /* renamed from: a */
    public boolean mo4946a(int i, int i2, int i3) {
        super.mo4946a(i, i2, i3);
        int i4 = i3 < 0 ? 0 : i3;
        int i5 = i4 <= 5 ? i4 : 5;
        boolean z = this.f4913ah != i5;
        this.f5147e = i5;
        this.f4913ah = this.f5147e;
        this.f5154l.setTextSize(this.f4904Z[this.f5147e] * this.f5148f);
        if (this.f4911af) {
            RectF rectF = new RectF(this.f4919b);
            m5007a(rectF, this.f4905a);
            if (!this.f5129H) {
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
                ams_rect.nLeft = (short) (f - (this.f4902X / 2));
                ams_rect.nTop = (short) (f2 - (this.f4903Y / 2));
                ams_rect.nRight = (short) (f + (this.f4902X / 2));
                ams_rect.nBottom = (short) (f2 + (this.f4903Y / 2));
            }
            this.f4919b.set(ams_rect.nLeft, ams_rect.nTop, ams_rect.nRight, ams_rect.nBottom);
            this.f5154l.setColor(i2);
            this.f4901W = null;
            mo4971a(ams_rect.nLeft, ams_rect.nTop, ams_rect.nRight, ams_rect.nBottom, this.f4905a, MotionEventCompat.ACTION_MASK);
        } else {
            m5008a(this.f4905a);
            if (!this.f5129H) {
                return false;
            }
            AMS_RECT ams_rect2 = new AMS_RECT();
            float f3 = (this.f4919b.left + this.f4919b.right) / 2.0f;
            float f4 = (this.f4919b.top + this.f4919b.bottom) / 2.0f;
            ams_rect2.nLeft = (short) (f3 - (this.f4902X / 2));
            ams_rect2.nTop = (short) (f4 - (this.f4903Y / 2));
            ams_rect2.nRight = (short) (f3 + (this.f4902X / 2));
            ams_rect2.nBottom = (short) ((this.f4903Y / 2) + f4);
            this.f4919b.set(ams_rect2.nLeft, ams_rect2.nTop, ams_rect2.nRight, ams_rect2.nBottom);
            this.f5154l.setColor(i2);
            this.f4901W = null;
            mo4973a(this.f4919b.left, this.f4919b.top, this.f4905a, MotionEventCompat.ACTION_MASK);
        }
        return true;
    }

    @Override // com.sec.vip.amschaton.C1468i
    /* renamed from: a */
    public boolean mo4947a(AMS_RECT ams_rect) {
        if (!this.f5129H) {
            return false;
        }
        if (this.f4911af) {
            this.f4919b.set(ams_rect.nLeft, ams_rect.nTop, ams_rect.nRight, ams_rect.nBottom);
            mo4971a(ams_rect.nLeft, ams_rect.nTop, ams_rect.nRight, ams_rect.nBottom, this.f4905a, MotionEventCompat.ACTION_MASK);
        } else {
            this.f4919b.set(ams_rect.nLeft, ams_rect.nTop, ams_rect.nRight, ams_rect.nBottom);
            mo4973a(ams_rect.nLeft, ams_rect.nTop, this.f4905a, MotionEventCompat.ACTION_MASK);
        }
        return true;
    }

    @Override // com.sec.vip.amschaton.C1468i
    /* renamed from: b */
    public boolean mo4893b(float f, float f2) {
        if (this.f4911af) {
            boolean z = false;
            switch (this.f5123B) {
                case 2:
                    this.f4917al = f;
                    this.f4918am = f2;
                    int i = this.f4919b.left;
                    int i2 = this.f4919b.top;
                    int i3 = this.f4919b.right;
                    int i4 = this.f4919b.bottom;
                    int i5 = (int) (this.f5139T * this.f5148f * 2.0f);
                    int i6 = i - i5;
                    int i7 = i2 - i5;
                    int i8 = i3 + i5 + ((int) (12.0f * this.f5148f));
                    int i9 = i5 + i4;
                    if (Math.abs(i8 - f) < 15.0f * this.f5148f && Math.abs(i7 - f2) < 15.0f * this.f5148f) {
                        m5286a(101, true);
                        z = true;
                    } else if (Math.abs(((i6 + i8) / 2) - f) < 15.0f * this.f5148f && Math.abs(i7 - f2) < 15.0f * this.f5148f) {
                        this.f5126E = i;
                        this.f5127F = i4;
                        this.f4908ac = i3;
                        this.f4909ad = i4;
                        this.f4914ai = this.f5126E;
                        this.f4915aj = this.f4908ac;
                        this.f5123B = 6;
                        this.f4910ae = 106;
                    } else if (Math.abs(i8 - f) < 15.0f * this.f5148f && Math.abs(((i7 + i9) / 2) - f2) < 15.0f * this.f5148f) {
                        this.f5126E = i;
                        this.f5127F = i2;
                        this.f4908ac = i;
                        this.f4909ad = i4;
                        this.f5123B = 5;
                        this.f4910ae = 107;
                    } else if (Math.abs(((i8 + i6) / 2) - f) < 15.0f * this.f5148f && Math.abs(i9 - f2) < 15.0f * this.f5148f) {
                        this.f5126E = i;
                        this.f5127F = i2;
                        this.f4908ac = i3;
                        this.f4909ad = i2;
                        this.f4914ai = this.f5126E;
                        this.f4915aj = this.f4908ac;
                        this.f5123B = 6;
                        this.f4910ae = 108;
                    } else if (Math.abs(i6 - f) < 15.0f * this.f5148f && Math.abs(((i7 + i9) / 2) - f2) < 15.0f * this.f5148f) {
                        this.f5126E = i3;
                        this.f5127F = i2;
                        this.f4908ac = i3;
                        this.f4909ad = i4;
                        this.f5123B = 5;
                        this.f4910ae = 105;
                    }
                    this.f4912ag = f2;
                    this.f5130I = false;
                    if (this.f5123B == 5 || this.f5123B == 6) {
                        m5286a(this.f4910ae, true);
                        String str = new String(this.f4905a);
                        mo4973a(f, f2, str, 128);
                        this.f4916ak = m5004b(str);
                    } else if (z) {
                        this.f5123B = 7;
                    } else {
                        this.f5124C = (int) (f - this.f4919b.left);
                        this.f5125D = (int) (f2 - this.f4919b.top);
                        this.f5123B = 3;
                        mo4971a(this.f4919b.left, this.f4919b.top, this.f4919b.right, this.f4919b.bottom, this.f4905a, 128);
                    }
                    break;
                default:
                    return true;
            }
        } else {
            switch (this.f5123B) {
                case 2:
                    int i10 = this.f4919b.top;
                    if (Math.abs(this.f4919b.right - f) < 15.0f * this.f5148f && Math.abs(i10 - f2) < 15.0f * this.f5148f) {
                        m5286a(101, true);
                        this.f5123B = 7;
                    } else {
                        this.f5124C = (int) (f - this.f4919b.left);
                        this.f5125D = (int) (f2 - this.f4919b.top);
                        this.f5123B = 3;
                        mo4897e(this.f4919b.left, this.f4919b.top);
                        m5009a(new String(this.f4905a), 128);
                        this.f5130I = false;
                        mo4897e(f, f2);
                    }
                    break;
                default:
                    return true;
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.sec.vip.amschaton.C1468i
    /* renamed from: c */
    public boolean mo4895c(float f, float f2) {
        if (this.f4911af) {
            switch (this.f5123B) {
                case 1:
                case 5:
                    float f3 = f - this.f5126E;
                    float f4 = f2 - this.f5127F;
                    if (f3 > this.f4902X) {
                        f = this.f5126E + this.f4902X;
                    }
                    if ((-this.f4902X) > f3) {
                        f = this.f5126E - this.f4902X;
                    }
                    if (f4 > this.f4903Y || (0.0f <= f4 && f4 < this.f4903Y)) {
                        f2 = this.f5127F + this.f4903Y;
                    }
                    if ((-this.f4903Y) > f4 || ((-this.f4903Y) < f4 && f4 < 0.0f)) {
                        f2 = this.f5127F - this.f4903Y;
                    }
                    mo4973a(f, f2, this.f4905a, 128);
                    if (this.f5129H) {
                        this.f5130I = true;
                    }
                    m5286a(this.f4910ae, true);
                    break;
                case 3:
                    m5005b(f - this.f5124C, f2 - this.f5125D, ((this.f4919b.right - this.f4919b.left) + f) - this.f5124C, ((this.f4919b.bottom - this.f4919b.top) + f2) - this.f5125D, this.f4905a, 128, false);
                    if (this.f5129H) {
                        this.f5130I = true;
                        break;
                    }
                    break;
                case 6:
                    int i = this.f4903Y;
                    float f5 = (f2 - this.f4912ag) * 0.6f;
                    if (this.f4910ae == 106) {
                        this.f5126E -= f5;
                        this.f4908ac += f5;
                        i = -this.f4903Y;
                    } else if (this.f4910ae == 108) {
                        this.f5126E += f5;
                        this.f4908ac -= f5;
                    }
                    if (this.f5126E > this.f4908ac) {
                        float f6 = this.f4908ac;
                        this.f4908ac = this.f5126E;
                        this.f5126E = f6;
                    }
                    if (Math.abs(this.f4908ac - this.f5126E) > this.f4916ak) {
                        this.f5126E = this.f4914ai;
                        this.f4908ac = this.f4915aj;
                    }
                    this.f4914ai = this.f5126E;
                    this.f4915aj = this.f4908ac;
                    this.f4912ag = f2;
                    float f7 = f2 - this.f5127F;
                    if (f7 > this.f4903Y || ((0.0f <= f7 && f7 < this.f4903Y) || (-this.f4903Y) > f7 || ((-this.f4903Y) < f7 && f7 < 0.0f))) {
                        f2 = this.f5127F + i;
                    }
                    mo4973a(f, f2, this.f4905a, 128);
                    if (this.f5129H) {
                        this.f5130I = true;
                    }
                    m5286a(this.f4910ae, true);
                    break;
                case 7:
                    int i2 = this.f4919b.top;
                    int i3 = this.f4919b.right;
                    int i4 = (int) (this.f5139T * this.f5148f * 2.0f);
                    if (!(Math.abs(((float) ((i3 + i4) + ((int) (12.0f * this.f5148f)))) - f) < this.f5148f * 15.0f && Math.abs(((float) (i2 - i4)) - f2) < this.f5148f * 15.0f)) {
                        m5286a(101, false);
                        this.f5123B = 2;
                        break;
                    }
                    break;
            }
        } else {
            switch (this.f5123B) {
                case 3:
                    if (!this.f5130I && (Math.abs(this.f5126E - f) > 10.0f * this.f5148f || Math.abs(this.f5127F - f2) > 10.0f * this.f5148f)) {
                        this.f5130I = true;
                    }
                    mo4973a(f - this.f5124C, f2 - this.f5125D, this.f4905a, 128);
                    break;
                case 7:
                    if (!(Math.abs(((float) this.f4919b.right) - f) < this.f5148f * 15.0f && Math.abs(((float) this.f4919b.top) - f2) < this.f5148f * 15.0f)) {
                        m5286a(101, false);
                        this.f5123B = 2;
                        break;
                    }
                    break;
            }
        }
        return true;
    }

    @Override // com.sec.vip.amschaton.C1468i
    /* renamed from: d */
    public boolean mo4896d(float f, float f2) {
        if (this.f4911af) {
            AMS_RECT ams_rect = new AMS_RECT();
            float f3 = f - this.f5126E;
            float f4 = f2 - this.f5127F;
            switch (this.f5123B) {
                case 0:
                    mo4897e(f, f2);
                    if (this.f4900V != null) {
                        this.f4900V.mo4928a(null, (this.f4919b.left + this.f4919b.right) / 2, (this.f4919b.top + this.f4919b.bottom) / 2);
                        break;
                    } else {
                        return false;
                    }
                case 1:
                    if (f3 > this.f4902X) {
                        f = this.f5126E + this.f4902X;
                    }
                    if ((-this.f4902X) > f3) {
                        f = this.f5126E - this.f4902X;
                    }
                    if (f4 > this.f4903Y || (0.0f <= f4 && f4 < this.f4903Y)) {
                        f2 = this.f5127F + this.f4903Y;
                    }
                    if ((-this.f4903Y) > f4 || ((-this.f4903Y) < f4 && f4 < 0.0f)) {
                        f2 = this.f5127F - this.f4903Y;
                    }
                    ams_rect.nLeft = (short) this.f5126E;
                    ams_rect.nTop = (short) this.f5127F;
                    ams_rect.nRight = (short) f;
                    ams_rect.nBottom = (short) f2;
                    if (f < this.f5126E) {
                        ams_rect.nLeft = (short) f;
                        ams_rect.nRight = (short) this.f5126E;
                    }
                    if (f2 < this.f5127F) {
                        ams_rect.nTop = (short) f2;
                        ams_rect.nBottom = (short) this.f5127F;
                    }
                    this.f5123B = 0;
                    return mo4948b(ams_rect);
                case 3:
                    this.f5123B = 2;
                    int i = this.f4919b.right - this.f4919b.left;
                    int i2 = this.f4919b.bottom - this.f4919b.top;
                    ams_rect.nLeft = (short) (f - this.f5124C);
                    ams_rect.nTop = (short) (f2 - this.f5125D);
                    ams_rect.nRight = (short) ((i + f) - this.f5124C);
                    ams_rect.nBottom = (short) ((i2 + f2) - this.f5125D);
                    boolean zMo4947a = mo4947a(ams_rect);
                    if (this.f5130I && (Math.abs(this.f4917al - f) > 4.0f || Math.abs(this.f4918am - f2) > 4.0f)) {
                        this.f5130I = false;
                        return zMo4947a;
                    }
                    mo4897e(f - this.f5124C, f2 - this.f5125D);
                    if (!this.f5128G) {
                        this.f5128G = true;
                        return true;
                    }
                    if (this.f4900V != null) {
                        this.f4900V.mo4928a(null, (this.f4919b.left + this.f4919b.right) / 2, (this.f4919b.top + this.f4919b.bottom) / 2);
                        break;
                    } else {
                        return false;
                    }
                    break;
                case 5:
                    if (f3 > this.f4902X) {
                        f = this.f5126E + this.f4902X;
                    }
                    if ((-this.f4902X) > f3) {
                        f = this.f5126E - this.f4902X;
                    }
                    if (f4 > this.f4903Y || (0.0f <= f4 && f4 < this.f4903Y)) {
                        f2 = this.f5127F + this.f4903Y;
                    }
                    if ((-this.f4903Y) > f4 || ((-this.f4903Y) < f4 && f4 < 0.0f)) {
                        f2 = this.f5127F - this.f4903Y;
                    }
                    if (!this.f5130I) {
                        mo4973a(f, f2, this.f5132K.getM_TText().getM_strText(), MotionEventCompat.ACTION_MASK);
                        break;
                    } else {
                        this.f5130I = false;
                        this.f4909ad = f2;
                        ams_rect.nLeft = (short) this.f5126E;
                        ams_rect.nTop = (short) this.f5127F;
                        ams_rect.nRight = (short) f;
                        ams_rect.nBottom = (short) this.f4909ad;
                        if (f < this.f5126E) {
                            ams_rect.nLeft = (short) f;
                            ams_rect.nRight = (short) this.f5126E;
                        }
                        return mo4947a(ams_rect);
                    }
                    break;
                case 6:
                    if (this.f5130I) {
                        int i3 = this.f4903Y;
                        if (this.f4910ae == 106) {
                            i3 = -this.f4903Y;
                        }
                        if (f4 > this.f4903Y || ((0.0f <= f4 && f4 < this.f4903Y) || (-this.f4903Y) > f4 || ((-this.f4903Y) < f4 && f4 < 0.0f))) {
                            f2 = this.f5127F + i3;
                        }
                        this.f5130I = false;
                        ams_rect.nLeft = (short) this.f5126E;
                        ams_rect.nTop = (short) this.f5127F;
                        ams_rect.nRight = (short) this.f4908ac;
                        ams_rect.nBottom = (short) f2;
                        if (f2 < this.f5127F) {
                            ams_rect.nTop = (short) f2;
                            ams_rect.nBottom = (short) this.f5127F;
                        }
                        return mo4947a(ams_rect);
                    }
                    if (f3 > this.f4902X) {
                        f = this.f5126E + this.f4902X;
                    }
                    if ((-this.f4902X) > f3) {
                        f = this.f5126E - this.f4902X;
                    }
                    if (f4 > this.f4903Y || (0.0f <= f4 && f4 < this.f4903Y)) {
                        f2 = this.f5127F + this.f4903Y;
                    }
                    if ((-this.f4903Y) > f4 || ((-this.f4903Y) < f4 && f4 < 0.0f)) {
                        f2 = this.f5127F - this.f4903Y;
                    }
                    mo4973a(f, f2, this.f4905a, MotionEventCompat.ACTION_MASK);
                    break;
                    break;
                case 7:
                    m5286a(101, false);
                    this.f5137P.mo4929a();
                    break;
            }
            return false;
        }
        AMS_RECT ams_rect2 = new AMS_RECT();
        switch (this.f5123B) {
            case 0:
                if (!this.f5128G) {
                    this.f5128G = true;
                    return true;
                }
                mo4897e(f, f2);
                if (this.f4900V != null) {
                    this.f4900V.mo4928a(null, (this.f4919b.left + this.f4919b.right) / 2, (this.f4919b.top + this.f4919b.bottom) / 2);
                    break;
                } else {
                    return false;
                }
            case 3:
                this.f5123B = 2;
                int i4 = this.f4919b.right - this.f4919b.left;
                int i5 = this.f4919b.bottom - this.f4919b.top;
                ams_rect2.nLeft = (short) (f - this.f5124C);
                ams_rect2.nTop = (short) (f2 - this.f5125D);
                ams_rect2.nRight = (short) ((i4 + f) - this.f5124C);
                ams_rect2.nBottom = (short) ((i5 + f2) - this.f5125D);
                boolean zMo4947a2 = mo4947a(ams_rect2);
                if (this.f5130I) {
                    this.f5130I = false;
                    return zMo4947a2;
                }
                mo4897e(f - this.f5124C, f2 - this.f5125D);
                if (!this.f5128G) {
                    this.f5128G = true;
                    return true;
                }
                if (this.f4900V != null) {
                    this.f4900V.mo4928a(null, (this.f4919b.left + this.f4919b.right) / 2, (this.f4919b.top + this.f4919b.bottom) / 2);
                    break;
                } else {
                    return false;
                }
            case 7:
                m5286a(101, false);
                this.f5137P.mo4929a();
                break;
        }
        return true;
    }

    @Override // com.sec.vip.amschaton.C1468i
    /* renamed from: e */
    public void mo4897e(float f, float f2) {
        this.f5126E = (int) f;
        this.f5127F = (int) f2;
    }

    /* renamed from: a */
    public boolean m5008a(String str) {
        TextPaint textPaint = new TextPaint();
        textPaint.setAntiAlias(true);
        textPaint.setDither(true);
        textPaint.setTextSize(this.f4904Z[this.f5147e] * this.f5148f);
        textPaint.setColor(this.f5146d);
        String str2 = "";
        StringBuilder sb = new StringBuilder();
        this.f4902X = 0;
        this.f4903Y = 0;
        int i = this.f5135N - ((int) ((40.0f * this.f5148f) + 0.5f));
        int length = str.length();
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            char cCharAt = str.charAt(i3);
            int iMeasureText = (int) textPaint.measureText(sb.toString());
            if (this.f4902X < iMeasureText) {
                this.f4902X = iMeasureText;
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
        if (this.f4902X < iMeasureText2) {
            this.f4902X = iMeasureText2;
        }
        this.f4903Y = (int) ((i4 + 0.4d) * textPaint.getTextSize());
        if (this.f4901W != null) {
            this.f4901W.recycle();
            this.f4901W = null;
        }
        this.f4901W = Bitmap.createBitmap(this.f4902X, this.f4903Y, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(this.f4901W);
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
    public boolean m5007a(RectF rectF, String str) {
        TextPaint textPaint = new TextPaint();
        textPaint.setAntiAlias(true);
        textPaint.setDither(true);
        textPaint.setTextSize(this.f4904Z[this.f5147e] * this.f5148f);
        textPaint.setColor(this.f5146d);
        String str2 = "";
        StringBuilder sb = new StringBuilder();
        this.f4902X = 0;
        this.f4903Y = 0;
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
                    if (this.f4902X < iMeasureText) {
                        this.f4902X = iMeasureText;
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
                    if (this.f4902X < iMeasureText2) {
                        this.f4902X = iMeasureText2;
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
            if (this.f4902X < iMeasureText3) {
                this.f4902X = iMeasureText3;
            }
        }
        this.f4903Y = (int) ((i + 0.4d) * textPaint.getTextSize());
        if (this.f4901W != null) {
            this.f4901W.recycle();
            this.f4901W = null;
        }
        this.f4901W = Bitmap.createBitmap(this.f4902X, this.f4903Y, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(this.f4901W);
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
    private float m5004b(String str) {
        TextPaint textPaint = new TextPaint();
        textPaint.setAntiAlias(true);
        textPaint.setDither(true);
        textPaint.setTextSize(this.f4904Z[this.f5147e] * this.f5148f);
        textPaint.setColor(this.f5146d);
        return textPaint.measureText(str);
    }

    /* renamed from: a */
    public boolean m5009a(String str, int i) {
        mo4973a(this.f5126E, this.f5127F, str, i);
        return true;
    }

    @Override // com.sec.vip.amschaton.C1468i
    /* renamed from: a */
    public boolean mo4973a(float f, float f2, String str, int i) {
        float f3;
        float f4;
        float f5;
        if (this.f4911af) {
            float f6 = this.f5126E;
            float f7 = this.f5127F;
            switch (this.f5123B) {
                case 5:
                    f3 = this.f4909ad;
                    f4 = f;
                    break;
                case 6:
                    f3 = f2;
                    f4 = this.f4908ac;
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
            return mo4971a(f4, f5, f6, f7, str, i);
        }
        this.f5154l.setAlpha(i);
        if (this.f4901W == null) {
            m5008a(str);
        }
        Rect rect = new Rect((int) f, (int) f2, (int) (this.f4902X + f), (int) (this.f4903Y + f2));
        this.f5149g.drawBitmap(this.f5151i, 0.0f, 0.0f, (Paint) null);
        this.f5149g.drawBitmap(this.f4901W, f, f2, this.f5154l);
        m5284a(rect.left, rect.top, rect.right, rect.bottom);
        return true;
    }

    @Override // com.sec.vip.amschaton.C1468i
    /* renamed from: a */
    public boolean mo4971a(float f, float f2, float f3, float f4, String str, int i) {
        return m5005b(f, f2, f3, f4, str, i, false);
    }

    /* renamed from: b */
    private boolean m5005b(float f, float f2, float f3, float f4, String str, int i, boolean z) {
        this.f5154l.setAlpha(i);
        RectF rectF = new RectF(f, f2, f3, f4);
        if (z) {
            m5007a(rectF, str);
        }
        this.f5149g.drawBitmap(this.f5151i, 0.0f, 0.0f, (Paint) null);
        float f5 = ((f + f3) - this.f4902X) / 2.0f;
        float f6 = ((f + f3) + this.f4902X) / 2.0f;
        switch (this.f4910ae) {
            case 105:
                this.f5149g.drawBitmap(this.f4901W, f3 - this.f4902X, f2, this.f5154l);
                rectF.set(f3 - this.f4902X, f2, f3, this.f4903Y + f2);
                break;
            case 106:
                if (this.f5130I) {
                    this.f5149g.drawBitmap(this.f4901W, f5, f2, this.f5154l);
                    rectF.set(f5, f4 - this.f4903Y, f6, f4);
                    break;
                } else {
                    this.f5149g.drawBitmap(this.f4901W, f, f2, this.f5154l);
                    rectF.set(f, f2, this.f4902X + f, this.f4903Y + f2);
                    break;
                }
            case 107:
            default:
                this.f5149g.drawBitmap(this.f4901W, f, f2, this.f5154l);
                rectF.set(f, f2, this.f4902X + f, this.f4903Y + f2);
                break;
            case 108:
                if (this.f5130I) {
                    this.f5149g.drawBitmap(this.f4901W, f5, f2, this.f5154l);
                    rectF.set(f5, f2, f6, this.f4903Y + f2);
                    break;
                } else {
                    this.f5149g.drawBitmap(this.f4901W, f, f2, this.f5154l);
                    rectF.set(f, f2, this.f4902X + f, this.f4903Y + f2);
                    break;
                }
        }
        m5284a(rectF.left, rectF.top, rectF.right, rectF.bottom);
        return true;
    }

    /* renamed from: a */
    public void m5006a(InterfaceC1557v interfaceC1557v) {
        this.f4900V = interfaceC1557v;
    }
}
