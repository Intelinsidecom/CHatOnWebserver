package com.sec.vip.amschaton;

import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import com.sec.amsoma.structure.AMS_OBJECT_DATA;
import com.sec.amsoma.structure.AMS_RECT;
import com.sec.chaton.util.C1786r;
import twitter4j.MediaEntity;

/* compiled from: AMSObjectStamp.java */
/* renamed from: com.sec.vip.amschaton.w */
/* loaded from: classes.dex */
public class C2073w extends C2068r {

    /* renamed from: V */
    private Bitmap f7437V;

    /* renamed from: W */
    private int f7438W;

    /* renamed from: X */
    private C1849ai f7439X;

    /* renamed from: Y */
    private final int f7440Y;

    /* renamed from: Z */
    private boolean f7441Z;

    /* renamed from: aa */
    private float f7442aa;

    /* renamed from: ab */
    private float f7443ab;

    /* renamed from: ac */
    private int f7444ac;

    /* renamed from: ad */
    private boolean f7445ad;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2073w(int i, int i2, int i3, boolean z) {
        super(i, i2, i3);
        boolean z2 = true;
        this.f7438W = 55;
        this.f7439X = C1849ai.m6394a();
        this.f7440Y = 12;
        this.f7441Z = false;
        this.f7442aa = 0.0f;
        this.f7443ab = 0.0f;
        this.f7444ac = 0;
        this.f7445ad = false;
        if (i < this.f7439X.m6410f()) {
            this.f7437V = this.f7439X.m6397a(i, true);
        } else if (i < this.f7439X.m6410f() + this.f7439X.m6407d()) {
            this.f7437V = this.f7439X.m6396a(this.f7392a - this.f7439X.m6410f(), 7);
            z2 = false;
        } else if (i >= 1000) {
            this.f7437V = this.f7439X.m6404b(this.f7392a - 1000, true);
            z2 = false;
        } else {
            this.f7437V = this.f7439X.m6397a(0, true);
        }
        this.f7401j = new Paint();
        if (this.f7437V == null || (z2 && !C1849ai.m6394a().m6406c(i))) {
            this.f7438W = 110;
        } else {
            this.f7438W = this.f7437V.getWidth();
        }
        this.f7445ad = z;
    }

    public C2073w(int i, int i2, int i3, Bitmap bitmap, boolean z) {
        super(i, i2, i3);
        this.f7438W = 55;
        this.f7439X = C1849ai.m6394a();
        this.f7440Y = 12;
        this.f7441Z = false;
        this.f7442aa = 0.0f;
        this.f7443ab = 0.0f;
        this.f7444ac = 0;
        this.f7445ad = false;
        this.f7437V = bitmap;
        this.f7401j = new Paint();
        this.f7438W = this.f7437V.getWidth();
        this.f7445ad = z;
    }

    @Override // com.sec.vip.amschaton.C2068r
    /* renamed from: a */
    public void mo7194a(float f) {
        super.mo7194a(f);
        if (this.f7438W == 0) {
            this.f7438W = (int) ((55.0f * this.f7395d) + 0.5d);
        } else {
            this.f7438W = (int) (((this.f7438W / 2) * this.f7395d) + 0.5d);
        }
    }

    @Override // com.sec.vip.amschaton.C2068r
    /* renamed from: a */
    public boolean mo7221a(AMS_RECT ams_rect) {
        if (this.f7392a >= 0 && this.f7392a < this.f7439X.m6410f()) {
            if (!this.f7414w.VipAMS_EncodeNewStamp(this.f7415x, ams_rect, 0, 2, this.f7392a, null, 0, 0, 0, false)) {
                mo7193a();
                return false;
            }
        } else if (this.f7392a < this.f7439X.m6410f() + this.f7439X.m6407d()) {
            if (!this.f7414w.VipAMS_EncodeNewStamp(this.f7415x, ams_rect, 0, 2, this.f7392a, null, 0, 0, 0, false)) {
                mo7193a();
                return false;
            }
        } else {
            int[] iArr = new int[this.f7437V.getWidth() * this.f7437V.getHeight()];
            this.f7437V.getPixels(iArr, 0, this.f7437V.getWidth(), 0, 0, this.f7437V.getWidth(), this.f7437V.getHeight());
            if (!this.f7414w.VipAMS_EncodeNewStamp(this.f7415x, ams_rect, 2, 2, this.f7392a, iArr, this.f7437V.getWidth(), this.f7437V.getHeight(), 32, false)) {
                mo7193a();
                return false;
            }
        }
        mo7219a(new RectF(ams_rect.nLeft, ams_rect.nTop, ams_rect.nRight, ams_rect.nBottom), MotionEventCompat.ACTION_MASK);
        return true;
    }

    @Override // com.sec.vip.amschaton.C2068r
    /* renamed from: b */
    public boolean mo7228b(AMS_RECT ams_rect) {
        if (!this.f7374F || this.f7376H == null || !this.f7414w.VipAMS_ChangeSelectStamp(this.f7415x, this.f7376H, ams_rect, this.f7377I.getM_cStyle(), this.f7377I.getM_cSize(), false)) {
            return false;
        }
        this.f7377I.setM_TRect(ams_rect);
        mo7219a(new RectF(ams_rect.nLeft, ams_rect.nTop, ams_rect.nRight, ams_rect.nBottom), MotionEventCompat.ACTION_MASK);
        return true;
    }

    @Override // com.sec.vip.amschaton.C2068r
    /* renamed from: a */
    public void mo7195a(float f, float f2) {
        this.f7371C = f;
        this.f7372D = f2;
    }

    @Override // com.sec.vip.amschaton.C2068r
    /* renamed from: a */
    public boolean mo7213a(float f, float f2, int i) {
        return mo7216a(f, f2, i, true);
    }

    @Override // com.sec.vip.amschaton.C2068r
    /* renamed from: a */
    public boolean mo7216a(float f, float f2, int i, boolean z) {
        float f3;
        float f4;
        float f5;
        if (this.f7445ad) {
            float f6 = this.f7371C;
            float f7 = this.f7372D;
            switch (this.f7417z) {
                case 5:
                    f3 = this.f7443ab;
                    f4 = f;
                    break;
                case 6:
                    f3 = f2;
                    f4 = this.f7442aa;
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
            return mo7210a(f4, f5, f6, f7, i, z);
        }
        Rect rect = new Rect((int) f, (int) f2, (int) (this.f7438W + f), (int) (this.f7438W + f2));
        if (z) {
            this.f7396e.drawBitmap(this.f7398g, 0.0f, 0.0f, (Paint) null);
        }
        if (i < 256) {
            this.f7401j.setAlpha(i);
            this.f7396e.drawBitmap(this.f7437V, (Rect) null, rect, this.f7401j);
            m7196a(rect.left, rect.top, rect.right, rect.bottom);
        } else {
            this.f7401j.setAlpha(MotionEventCompat.ACTION_MASK);
            this.f7396e.drawBitmap(C1849ai.m6394a().m6396a(this.f7392a - this.f7439X.m6410f(), i - 1000), (Rect) null, rect, this.f7401j);
        }
        return true;
    }

    @Override // com.sec.vip.amschaton.C2068r
    /* renamed from: a */
    public boolean mo7209a(float f, float f2, float f3, float f4, int i) {
        return mo7210a(f, f2, f3, f4, i, true);
    }

    @Override // com.sec.vip.amschaton.C2068r
    /* renamed from: a */
    public boolean mo7210a(float f, float f2, float f3, float f4, int i, boolean z) {
        Rect rect = new Rect((int) f, (int) f2, (int) f3, (int) f4);
        if (z) {
            this.f7396e.drawBitmap(this.f7398g, 0.0f, 0.0f, (Paint) null);
        }
        if (i < 256) {
            this.f7401j.setAlpha(i);
            this.f7396e.drawBitmap(this.f7437V, (Rect) null, rect, this.f7401j);
            m7196a(f - ((this.f7394c * this.f7395d) / 2.0f), f2 - ((this.f7394c * this.f7395d) / 2.0f), ((this.f7394c * this.f7395d) / 2.0f) + f3, ((this.f7394c * this.f7395d) / 2.0f) + f4);
            return true;
        }
        this.f7401j.setAlpha(MotionEventCompat.ACTION_MASK);
        this.f7396e.drawBitmap(C1849ai.m6394a().m6396a(this.f7392a - this.f7439X.m6410f(), i - 1000), (Rect) null, rect, this.f7401j);
        return true;
    }

    @Override // com.sec.vip.amschaton.C2068r
    /* renamed from: a */
    public boolean mo7219a(RectF rectF, int i) {
        return mo7220a(rectF, i, true);
    }

    @Override // com.sec.vip.amschaton.C2068r
    /* renamed from: a */
    public boolean mo7220a(RectF rectF, int i, boolean z) {
        return this.f7445ad ? mo7210a(rectF.left, rectF.top, rectF.right, rectF.bottom, i, z) : mo7216a(rectF.left, rectF.top, i, z);
    }

    @Override // com.sec.vip.amschaton.C2068r
    /* renamed from: c */
    public boolean mo7233c(float f, float f2) {
        if (this.f7417z != 2) {
            return false;
        }
        float f3 = 12.0f * this.f7395d;
        return new RectF(((float) this.f7377I.getM_TRect().nLeft) - f3, ((float) this.f7377I.getM_TRect().nTop) - f3, ((float) this.f7377I.getM_TRect().nRight) + f3, f3 + ((float) this.f7377I.getM_TRect().nBottom)).contains(f, f2);
    }

    /* renamed from: d */
    public void m7245d(boolean z) {
        this.f7441Z = z;
    }

    @Override // com.sec.vip.amschaton.C2068r
    /* renamed from: d */
    public boolean mo7235d(float f, float f2) {
        boolean z;
        if (this.f7414w == null) {
            return false;
        }
        if (this.f7445ad) {
            switch (this.f7417z) {
                case 0:
                    if (!this.f7373E) {
                        this.f7373E = true;
                        return true;
                    }
                    this.f7417z = 1;
                    mo7195a(f - 1.0f, f2 - 1.0f);
                    mo7213a((32.0f * this.f7395d) + f, (32.0f * this.f7395d) + f2, MotionEventCompat.ACTION_MASK);
                    this.f7371C = (int) (f - 1.0f);
                    this.f7372D = (int) (f2 - 1.0f);
                    return true;
                case 1:
                default:
                    return true;
                case 2:
                    if (this.f7376H == null) {
                        C1786r.m6054a("Why is selected object null???", getClass().getSimpleName());
                        this.f7417z = 0;
                        return true;
                    }
                    if (this.f7377I != null) {
                        short s = this.f7377I.getM_TRect().nLeft;
                        short s2 = this.f7377I.getM_TRect().nTop;
                        short s3 = this.f7377I.getM_TRect().nRight;
                        short s4 = this.f7377I.getM_TRect().nBottom;
                        if (Math.abs(s - f) < this.f7395d * 12.0f && Math.abs(s2 - f2) < this.f7395d * 12.0f) {
                            this.f7371C = s3;
                            this.f7372D = s4;
                            this.f7417z = 4;
                            this.f7444ac = 102;
                            z = false;
                        } else if (Math.abs(s3 - f) < this.f7395d * 12.0f && Math.abs(s2 - f2) < this.f7395d * 12.0f) {
                            m7198a(MediaEntity.Size.CROP, true);
                            z = true;
                        } else if (Math.abs(s3 - f) < this.f7395d * 12.0f && Math.abs(s4 - f2) < this.f7395d * 12.0f) {
                            this.f7371C = s;
                            this.f7372D = s2;
                            this.f7417z = 4;
                            this.f7444ac = 103;
                            z = false;
                        } else if (Math.abs(s - f) < this.f7395d * 12.0f && Math.abs(s4 - f2) < this.f7395d * 12.0f) {
                            this.f7371C = s3;
                            this.f7372D = s2;
                            this.f7417z = 4;
                            this.f7444ac = 104;
                            z = false;
                        } else if (Math.abs(((s + s3) / 2) - f) < this.f7395d * 12.0f && Math.abs(s2 - f2) < this.f7395d * 12.0f) {
                            this.f7371C = s;
                            this.f7372D = s4;
                            this.f7442aa = s3;
                            this.f7443ab = s4;
                            this.f7417z = 6;
                            this.f7444ac = 100;
                            z = false;
                        } else if (Math.abs(s3 - f) < this.f7395d * 12.0f && Math.abs(((s2 + s4) / 2) - f2) < this.f7395d * 12.0f) {
                            this.f7371C = s;
                            this.f7372D = s2;
                            this.f7442aa = s;
                            this.f7443ab = s4;
                            this.f7417z = 5;
                            this.f7444ac = 100;
                            z = false;
                        } else if (Math.abs(((s + s3) / 2) - f) >= this.f7395d * 12.0f || Math.abs(s4 - f2) >= this.f7395d * 12.0f) {
                            if (Math.abs(s - f) < this.f7395d * 12.0f && Math.abs(((s2 + s4) / 2) - f2) < this.f7395d * 12.0f) {
                                this.f7371C = s3;
                                this.f7372D = s2;
                                this.f7442aa = s3;
                                this.f7443ab = s4;
                                this.f7417z = 5;
                                this.f7444ac = 100;
                            }
                            z = false;
                        } else {
                            this.f7371C = s;
                            this.f7372D = s2;
                            this.f7442aa = s3;
                            this.f7443ab = s2;
                            this.f7417z = 6;
                            this.f7444ac = 100;
                            z = false;
                        }
                    } else {
                        z = false;
                    }
                    this.f7375G = false;
                    if (this.f7417z == 4 || this.f7417z == 5 || this.f7417z == 6) {
                        m7198a(this.f7444ac, true);
                        mo7213a(f, f2, AccessibilityEventCompat.TYPE_VIEW_HOVER_ENTER);
                        return true;
                    }
                    if (this.f7377I == null) {
                        this.f7377I = new AMS_OBJECT_DATA();
                        this.f7414w.VipAMS_GetSelectObjectData(this.f7376H.getM_pSelectObjectData(), this.f7377I);
                        this.f7441Z = false;
                    }
                    if (this.f7441Z && z) {
                        this.f7417z = 7;
                        return true;
                    }
                    this.f7369A = (int) (f - this.f7377I.getM_TRect().nLeft);
                    this.f7370B = (int) (f2 - this.f7377I.getM_TRect().nTop);
                    this.f7417z = 3;
                    mo7209a(this.f7377I.getM_TRect().nLeft, this.f7377I.getM_TRect().nTop, this.f7377I.getM_TRect().nRight, this.f7377I.getM_TRect().nBottom, AccessibilityEventCompat.TYPE_VIEW_HOVER_ENTER);
                    this.f7441Z = true;
                    return true;
            }
        }
        switch (this.f7417z) {
            case 0:
                this.f7417z = 1;
                this.f7369A = this.f7438W / 2;
                this.f7370B = this.f7438W / 2;
                mo7213a(f - this.f7369A, f2 - this.f7370B, MotionEventCompat.ACTION_MASK);
                return true;
            case 1:
            default:
                return true;
            case 2:
                if (this.f7376H == null) {
                    C1786r.m6054a("Why is selected object null???", getClass().getSimpleName());
                    this.f7417z = 0;
                    return true;
                }
                if (this.f7377I == null) {
                    this.f7377I = new AMS_OBJECT_DATA();
                    this.f7414w.VipAMS_GetSelectObjectData(this.f7376H.getM_pSelectObjectData(), this.f7377I);
                    this.f7441Z = false;
                }
                if (this.f7441Z) {
                    float f3 = this.f7377I.getM_TRect().nTop;
                    if (Math.abs(this.f7377I.getM_TRect().nRight - f) < this.f7395d * 12.0f && Math.abs(f3 - f2) < this.f7395d * 12.0f) {
                        m7198a(MediaEntity.Size.CROP, true);
                        this.f7417z = 7;
                        return true;
                    }
                }
                if (this.f7377I.getM_TRect().nLeft >= f || f >= this.f7377I.getM_TRect().nRight || this.f7377I.getM_TRect().nTop >= f2 || f2 >= this.f7377I.getM_TRect().nBottom) {
                    return true;
                }
                this.f7369A = (int) (f - this.f7377I.getM_TRect().nLeft);
                this.f7370B = (int) (f2 - this.f7377I.getM_TRect().nTop);
                this.f7417z = 3;
                mo7213a(f - this.f7369A, f2 - this.f7370B, AccessibilityEventCompat.TYPE_VIEW_HOVER_ENTER);
                this.f7375G = false;
                this.f7441Z = true;
                return true;
        }
    }

    @Override // com.sec.vip.amschaton.C2068r
    /* renamed from: e */
    public boolean mo7237e(float f, float f2) {
        if (this.f7414w == null) {
            return false;
        }
        if (this.f7445ad) {
            switch (this.f7417z) {
                case 1:
                case 4:
                case 5:
                case 6:
                    float f3 = f - this.f7371C;
                    float f4 = f2 - this.f7372D;
                    if (0.0f <= f3 && f3 < this.f7395d * 32.0f) {
                        f = this.f7371C + (this.f7395d * 32.0f);
                    }
                    if ((-32.0f) * this.f7395d < f3 && f3 < 0.0f) {
                        f = this.f7371C - (this.f7395d * 32.0f);
                    }
                    if (0.0f <= f4 && f4 < this.f7395d * 32.0f) {
                        f2 = this.f7372D + (this.f7395d * 32.0f);
                    }
                    if ((-32.0f) * this.f7395d < f4 && f4 < 0.0f) {
                        f2 = this.f7372D - (this.f7395d * 32.0f);
                    }
                    mo7213a(f, f2, AccessibilityEventCompat.TYPE_VIEW_HOVER_ENTER);
                    if (this.f7374F) {
                        this.f7375G = true;
                    }
                    m7198a(this.f7444ac, true);
                    break;
                case 3:
                    mo7209a(f - this.f7369A, f2 - this.f7370B, ((this.f7377I.getM_TRect().nRight - this.f7377I.getM_TRect().nLeft) + f) - this.f7369A, ((this.f7377I.getM_TRect().nBottom - this.f7377I.getM_TRect().nTop) + f2) - this.f7370B, AccessibilityEventCompat.TYPE_VIEW_HOVER_ENTER);
                    if (this.f7374F) {
                        this.f7375G = true;
                        break;
                    }
                    break;
                case 7:
                    if (!(Math.abs(((float) this.f7377I.getM_TRect().nRight) - f) < this.f7395d * 12.0f && Math.abs(((float) this.f7377I.getM_TRect().nTop) - f2) < this.f7395d * 12.0f)) {
                        m7198a(MediaEntity.Size.CROP, false);
                        this.f7417z = 2;
                        break;
                    }
                    break;
            }
            return true;
        }
        switch (this.f7417z) {
            case 1:
            case 3:
                if (this.f7374F) {
                    mo7213a(f - this.f7369A, f2 - this.f7370B, AccessibilityEventCompat.TYPE_VIEW_HOVER_ENTER);
                    this.f7375G = true;
                    break;
                } else {
                    mo7213a(f - this.f7369A, f2 - this.f7370B, MotionEventCompat.ACTION_MASK);
                    break;
                }
            case 7:
                if (!(Math.abs(((float) this.f7377I.getM_TRect().nRight) - f) < this.f7395d * 12.0f && Math.abs(((float) this.f7377I.getM_TRect().nTop) - f2) < this.f7395d * 12.0f)) {
                    m7198a(MediaEntity.Size.CROP, false);
                    this.f7417z = 2;
                    break;
                }
                break;
        }
        return true;
    }

    @Override // com.sec.vip.amschaton.C2068r
    /* renamed from: f */
    public boolean mo7239f(float f, float f2) {
        if (this.f7414w == null) {
            return false;
        }
        if (this.f7445ad) {
            AMS_RECT ams_rect = new AMS_RECT();
            float f3 = f - this.f7371C;
            float f4 = f2 - this.f7372D;
            switch (this.f7417z) {
                case 1:
                    if (0.0f <= f3 && f3 < this.f7395d * 32.0f) {
                        f = this.f7371C + (this.f7395d * 32.0f);
                    }
                    if ((-32.0f) * this.f7395d < f3 && f3 < 0.0f) {
                        f = this.f7371C - (this.f7395d * 32.0f);
                    }
                    if (0.0f <= f4 && f4 < this.f7395d * 32.0f) {
                        f2 = this.f7372D + (this.f7395d * 32.0f);
                    }
                    if ((-32.0f) * this.f7395d < f4 && f4 < 0.0f) {
                        f2 = this.f7372D - (this.f7395d * 32.0f);
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
                    int i = this.f7377I.getM_TRect().nRight - this.f7377I.getM_TRect().nLeft;
                    int i2 = this.f7377I.getM_TRect().nBottom - this.f7377I.getM_TRect().nTop;
                    ams_rect.nLeft = (short) (f - this.f7369A);
                    ams_rect.nTop = (short) (f2 - this.f7370B);
                    ams_rect.nRight = (short) ((i + f) - this.f7369A);
                    ams_rect.nBottom = (short) ((i2 + f2) - this.f7370B);
                    if (!this.f7375G) {
                        mo7209a(ams_rect.nLeft, ams_rect.nTop, ams_rect.nRight, ams_rect.nBottom, MotionEventCompat.ACTION_MASK);
                        break;
                    } else {
                        this.f7375G = false;
                        return mo7228b(ams_rect);
                    }
                case 4:
                    m7198a(102, false);
                    m7198a(103, false);
                    m7198a(104, false);
                    this.f7417z = 2;
                    if (0.0f <= f3 && f3 < this.f7395d * 32.0f) {
                        f = this.f7371C + (this.f7395d * 32.0f);
                    }
                    if ((-32.0f) * this.f7395d < f3 && f3 < 0.0f) {
                        f = this.f7371C - (this.f7395d * 32.0f);
                    }
                    if (0.0f <= f4 && f4 < this.f7395d * 32.0f) {
                        f2 = this.f7372D + (this.f7395d * 32.0f);
                    }
                    if ((-32.0f) * this.f7395d < f4 && f4 < 0.0f) {
                        f2 = this.f7372D - (this.f7395d * 32.0f);
                    }
                    if (!this.f7375G) {
                        mo7213a(f, f2, MotionEventCompat.ACTION_MASK);
                        break;
                    } else {
                        this.f7375G = false;
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
                        return mo7228b(ams_rect);
                    }
                case 5:
                    this.f7417z = 2;
                    if (!this.f7375G) {
                        mo7213a(f, f2, MotionEventCompat.ACTION_MASK);
                        break;
                    } else {
                        this.f7375G = false;
                        ams_rect.nLeft = (short) this.f7371C;
                        ams_rect.nTop = (short) this.f7372D;
                        ams_rect.nRight = (short) f;
                        ams_rect.nBottom = (short) this.f7443ab;
                        if (f < this.f7371C) {
                            ams_rect.nLeft = (short) f;
                            ams_rect.nRight = (short) this.f7371C;
                        }
                        return mo7228b(ams_rect);
                    }
                case 6:
                    this.f7417z = 2;
                    if (!this.f7375G) {
                        mo7213a(f, f2, MotionEventCompat.ACTION_MASK);
                        break;
                    } else {
                        this.f7375G = false;
                        ams_rect.nLeft = (short) this.f7371C;
                        ams_rect.nTop = (short) this.f7372D;
                        ams_rect.nRight = (short) this.f7442aa;
                        ams_rect.nBottom = (short) f2;
                        if (f2 < this.f7372D) {
                            ams_rect.nTop = (short) f2;
                            ams_rect.nBottom = (short) this.f7372D;
                        }
                        return mo7228b(ams_rect);
                    }
                case 7:
                    m7198a(MediaEntity.Size.CROP, false);
                    this.f7385Q.mo6859a();
                    break;
            }
            return false;
        }
        AMS_RECT ams_rect2 = new AMS_RECT();
        switch (this.f7417z) {
            case 1:
                this.f7417z = 0;
                ams_rect2.nLeft = (short) (f - this.f7369A);
                ams_rect2.nTop = (short) (f2 - this.f7370B);
                ams_rect2.nRight = (short) ((f - this.f7369A) + ((110.0f * this.f7395d) / 2.0f));
                ams_rect2.nBottom = (short) ((f2 - this.f7370B) + ((110.0f * this.f7395d) / 2.0f));
                return mo7221a(ams_rect2);
            case 3:
                this.f7417z = 2;
                if (!this.f7375G) {
                    mo7213a(f - this.f7369A, f2 - this.f7370B, MotionEventCompat.ACTION_MASK);
                    break;
                } else {
                    ams_rect2.nLeft = (short) (f - this.f7369A);
                    ams_rect2.nTop = (short) (f2 - this.f7370B);
                    ams_rect2.nRight = (short) ((f - this.f7369A) + ((110.0f * this.f7395d) / 2.0f));
                    ams_rect2.nBottom = (short) ((f2 - this.f7370B) + ((110.0f * this.f7395d) / 2.0f));
                    this.f7375G = false;
                    return mo7228b(ams_rect2);
                }
            case 7:
                m7198a(MediaEntity.Size.CROP, false);
                this.f7385Q.mo6859a();
                break;
        }
        return false;
    }

    @Override // com.sec.vip.amschaton.C2068r
    /* renamed from: c */
    public void mo7229c() {
        if (this.f7437V != null) {
            this.f7437V.recycle();
            this.f7437V = null;
        }
    }
}
