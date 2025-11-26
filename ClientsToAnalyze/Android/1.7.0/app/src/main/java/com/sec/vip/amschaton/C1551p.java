package com.sec.vip.amschaton;

import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.v4.view.MotionEventCompat;
import com.sec.amsoma.structure.AMS_OBJECT_DATA;
import com.sec.amsoma.structure.AMS_RECT;
import com.sec.chaton.util.C1341p;

/* compiled from: AMSObjectStamp.java */
/* renamed from: com.sec.vip.amschaton.p */
/* loaded from: classes.dex */
public class C1551p extends C1468i {

    /* renamed from: V */
    private C1561z f5401V;

    /* renamed from: W */
    private final int f5402W;

    /* renamed from: X */
    private boolean f5403X;

    /* renamed from: Y */
    private float f5404Y;

    /* renamed from: Z */
    private float f5405Z;

    /* renamed from: a */
    private Bitmap f5406a;

    /* renamed from: aa */
    private int f5407aa;

    /* renamed from: ab */
    private boolean f5408ab;

    /* renamed from: b */
    private int f5409b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1551p(int i, int i2, int i3, boolean z) {
        super(i, i2, i3);
        boolean z2 = true;
        this.f5409b = 55;
        this.f5401V = C1561z.m5654a();
        this.f5402W = 12;
        this.f5403X = false;
        this.f5404Y = 0.0f;
        this.f5405Z = 0.0f;
        this.f5407aa = 0;
        this.f5408ab = false;
        if (i < this.f5401V.m5670f()) {
            this.f5406a = this.f5401V.m5657a(i, true);
        } else if (i < this.f5401V.m5670f() + this.f5401V.m5667d()) {
            this.f5406a = this.f5401V.m5656a(this.f5145c - this.f5401V.m5670f(), 7);
            z2 = false;
        } else if (i >= 1000) {
            this.f5406a = this.f5401V.m5664b(this.f5145c - 1000, true);
            z2 = false;
        } else {
            this.f5406a = this.f5401V.m5657a(0, true);
        }
        this.f5154l = new Paint();
        if (this.f5406a == null || (z2 && !C1561z.m5654a().m5666c(i))) {
            this.f5409b = 110;
        } else {
            this.f5409b = this.f5406a.getWidth();
        }
        this.f5408ab = z;
    }

    public C1551p(int i, int i2, int i3, Bitmap bitmap, boolean z) {
        super(i, i2, i3);
        this.f5409b = 55;
        this.f5401V = C1561z.m5654a();
        this.f5402W = 12;
        this.f5403X = false;
        this.f5404Y = 0.0f;
        this.f5405Z = 0.0f;
        this.f5407aa = 0;
        this.f5408ab = false;
        this.f5406a = bitmap;
        this.f5154l = new Paint();
        this.f5409b = this.f5406a.getWidth();
        this.f5408ab = z;
    }

    @Override // com.sec.vip.amschaton.C1468i
    /* renamed from: a */
    public void mo4887a(float f) {
        super.mo4887a(f);
        if (this.f5409b == 0) {
            this.f5409b = (int) ((55.0f * this.f5148f) + 0.5d);
        } else {
            this.f5409b = (int) (((this.f5409b / 2) * this.f5148f) + 0.5d);
        }
    }

    @Override // com.sec.vip.amschaton.C1468i
    /* renamed from: b */
    public boolean mo4948b(AMS_RECT ams_rect) {
        if (this.f5145c >= 0 && this.f5145c < this.f5401V.m5670f()) {
            if (!this.f5167y.VipAMS_EncodeNewStamp(this.f5168z, ams_rect, 0, 2, this.f5145c, null, 0, 0, 0, false)) {
                mo4886a();
                return false;
            }
        } else if (this.f5145c < this.f5401V.m5670f() + this.f5401V.m5667d()) {
            if (!this.f5167y.VipAMS_EncodeNewStamp(this.f5168z, ams_rect, 0, 2, this.f5145c, null, 0, 0, 0, false)) {
                mo4886a();
                return false;
            }
        } else {
            int[] iArr = new int[this.f5406a.getWidth() * this.f5406a.getHeight()];
            this.f5406a.getPixels(iArr, 0, this.f5406a.getWidth(), 0, 0, this.f5406a.getWidth(), this.f5406a.getHeight());
            if (!this.f5167y.VipAMS_EncodeNewStamp(this.f5168z, ams_rect, 2, 2, this.f5145c, iArr, this.f5406a.getWidth(), this.f5406a.getHeight(), 32, false)) {
                mo4886a();
                return false;
            }
        }
        mo5297a(new RectF(ams_rect.nLeft, ams_rect.nTop, ams_rect.nRight, ams_rect.nBottom), MotionEventCompat.ACTION_MASK);
        return true;
    }

    @Override // com.sec.vip.amschaton.C1468i
    /* renamed from: a */
    public boolean mo4947a(AMS_RECT ams_rect) {
        if (!this.f5129H || this.f5131J == null || !this.f5167y.VipAMS_ChangeSelectStamp(this.f5168z, this.f5131J, ams_rect, this.f5132K.getM_cStyle(), this.f5132K.getM_cSize(), false)) {
            return false;
        }
        this.f5132K.setM_TRect(ams_rect);
        mo5297a(new RectF(ams_rect.nLeft, ams_rect.nTop, ams_rect.nRight, ams_rect.nBottom), MotionEventCompat.ACTION_MASK);
        return true;
    }

    @Override // com.sec.vip.amschaton.C1468i
    /* renamed from: e */
    public void mo4897e(float f, float f2) {
        this.f5126E = f;
        this.f5127F = f2;
    }

    @Override // com.sec.vip.amschaton.C1468i
    /* renamed from: a */
    public boolean mo4889a(float f, float f2, int i) {
        return mo4892a(f, f2, i, true);
    }

    @Override // com.sec.vip.amschaton.C1468i
    /* renamed from: a */
    public boolean mo4892a(float f, float f2, int i, boolean z) {
        float f3;
        float f4;
        float f5;
        if (this.f5408ab) {
            float f6 = this.f5126E;
            float f7 = this.f5127F;
            switch (this.f5123B) {
                case 5:
                    f3 = this.f5405Z;
                    f4 = f;
                    break;
                case 6:
                    f3 = f2;
                    f4 = this.f5404Y;
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
            return mo4945a(f4, f5, f6, f7, i, z);
        }
        Rect rect = new Rect((int) f, (int) f2, (int) (this.f5409b + f), (int) (this.f5409b + f2));
        if (z) {
            this.f5149g.drawBitmap(this.f5151i, 0.0f, 0.0f, (Paint) null);
        }
        if (i < 256) {
            this.f5154l.setAlpha(i);
            this.f5149g.drawBitmap(this.f5406a, (Rect) null, rect, this.f5154l);
            m5284a(rect.left, rect.top, rect.right, rect.bottom);
        } else {
            this.f5154l.setAlpha(MotionEventCompat.ACTION_MASK);
            this.f5149g.drawBitmap(C1561z.m5654a().m5656a(this.f5145c - this.f5401V.m5670f(), i - 1000), (Rect) null, rect, this.f5154l);
        }
        return true;
    }

    @Override // com.sec.vip.amschaton.C1468i
    /* renamed from: a */
    public boolean mo4888a(float f, float f2, float f3, float f4, int i) {
        return mo4945a(f, f2, f3, f4, i, true);
    }

    @Override // com.sec.vip.amschaton.C1468i
    /* renamed from: a */
    public boolean mo4945a(float f, float f2, float f3, float f4, int i, boolean z) {
        Rect rect = new Rect((int) f, (int) f2, (int) f3, (int) f4);
        if (z) {
            this.f5149g.drawBitmap(this.f5151i, 0.0f, 0.0f, (Paint) null);
        }
        if (i < 256) {
            this.f5154l.setAlpha(i);
            this.f5149g.drawBitmap(this.f5406a, (Rect) null, rect, this.f5154l);
            m5284a(f - ((this.f5147e * this.f5148f) / 2.0f), f2 - ((this.f5147e * this.f5148f) / 2.0f), ((this.f5147e * this.f5148f) / 2.0f) + f3, ((this.f5147e * this.f5148f) / 2.0f) + f4);
            return true;
        }
        this.f5154l.setAlpha(MotionEventCompat.ACTION_MASK);
        this.f5149g.drawBitmap(C1561z.m5654a().m5656a(this.f5145c - this.f5401V.m5670f(), i - 1000), (Rect) null, rect, this.f5154l);
        return true;
    }

    @Override // com.sec.vip.amschaton.C1468i
    /* renamed from: a */
    public boolean mo5297a(RectF rectF, int i) {
        return mo5298a(rectF, i, true);
    }

    @Override // com.sec.vip.amschaton.C1468i
    /* renamed from: a */
    public boolean mo5298a(RectF rectF, int i, boolean z) {
        return this.f5408ab ? mo4945a(rectF.left, rectF.top, rectF.right, rectF.bottom, i, z) : mo4892a(rectF.left, rectF.top, i, z);
    }

    @Override // com.sec.vip.amschaton.C1468i
    /* renamed from: a */
    public boolean mo4944a(float f, float f2) {
        if (this.f5123B != 2) {
            return false;
        }
        float f3 = 12.0f * this.f5148f;
        return new RectF(((float) this.f5132K.getM_TRect().nLeft) - f3, ((float) this.f5132K.getM_TRect().nTop) - f3, ((float) this.f5132K.getM_TRect().nRight) + f3, f3 + ((float) this.f5132K.getM_TRect().nBottom)).contains(f, f2);
    }

    /* renamed from: d */
    public void m5644d(boolean z) {
        this.f5403X = z;
    }

    @Override // com.sec.vip.amschaton.C1468i
    /* renamed from: b */
    public boolean mo4893b(float f, float f2) {
        boolean z;
        if (this.f5167y == null) {
            return false;
        }
        if (this.f5408ab) {
            switch (this.f5123B) {
                case 0:
                    if (!this.f5128G) {
                        this.f5128G = true;
                        return true;
                    }
                    this.f5123B = 1;
                    mo4897e(f - 1.0f, f2 - 1.0f);
                    mo4889a((32.0f * this.f5148f) + f, (32.0f * this.f5148f) + f2, MotionEventCompat.ACTION_MASK);
                    this.f5126E = (int) (f - 1.0f);
                    this.f5127F = (int) (f2 - 1.0f);
                    return true;
                case 1:
                default:
                    return true;
                case 2:
                    if (this.f5131J == null) {
                        C1341p.m4651a("Why is selected object null???", getClass().getSimpleName());
                        this.f5123B = 0;
                        return true;
                    }
                    if (this.f5132K != null) {
                        short s = this.f5132K.getM_TRect().nLeft;
                        short s2 = this.f5132K.getM_TRect().nTop;
                        short s3 = this.f5132K.getM_TRect().nRight;
                        short s4 = this.f5132K.getM_TRect().nBottom;
                        if (Math.abs(s - f) < this.f5148f * 12.0f && Math.abs(s2 - f2) < this.f5148f * 12.0f) {
                            this.f5126E = s3;
                            this.f5127F = s4;
                            this.f5123B = 4;
                            this.f5407aa = 102;
                            z = false;
                        } else if (Math.abs(s3 - f) < this.f5148f * 12.0f && Math.abs(s2 - f2) < this.f5148f * 12.0f) {
                            m5286a(101, true);
                            z = true;
                        } else if (Math.abs(s3 - f) < this.f5148f * 12.0f && Math.abs(s4 - f2) < this.f5148f * 12.0f) {
                            this.f5126E = s;
                            this.f5127F = s2;
                            this.f5123B = 4;
                            this.f5407aa = 103;
                            z = false;
                        } else if (Math.abs(s - f) < this.f5148f * 12.0f && Math.abs(s4 - f2) < this.f5148f * 12.0f) {
                            this.f5126E = s3;
                            this.f5127F = s2;
                            this.f5123B = 4;
                            this.f5407aa = 104;
                            z = false;
                        } else if (Math.abs(((s + s3) / 2) - f) < this.f5148f * 12.0f && Math.abs(s2 - f2) < this.f5148f * 12.0f) {
                            this.f5126E = s;
                            this.f5127F = s4;
                            this.f5404Y = s3;
                            this.f5405Z = s4;
                            this.f5123B = 6;
                            this.f5407aa = 100;
                            z = false;
                        } else if (Math.abs(s3 - f) < this.f5148f * 12.0f && Math.abs(((s2 + s4) / 2) - f2) < this.f5148f * 12.0f) {
                            this.f5126E = s;
                            this.f5127F = s2;
                            this.f5404Y = s;
                            this.f5405Z = s4;
                            this.f5123B = 5;
                            this.f5407aa = 100;
                            z = false;
                        } else if (Math.abs(((s + s3) / 2) - f) >= this.f5148f * 12.0f || Math.abs(s4 - f2) >= this.f5148f * 12.0f) {
                            if (Math.abs(s - f) < this.f5148f * 12.0f && Math.abs(((s2 + s4) / 2) - f2) < this.f5148f * 12.0f) {
                                this.f5126E = s3;
                                this.f5127F = s2;
                                this.f5404Y = s3;
                                this.f5405Z = s4;
                                this.f5123B = 5;
                                this.f5407aa = 100;
                            }
                            z = false;
                        } else {
                            this.f5126E = s;
                            this.f5127F = s2;
                            this.f5404Y = s3;
                            this.f5405Z = s2;
                            this.f5123B = 6;
                            this.f5407aa = 100;
                            z = false;
                        }
                    } else {
                        z = false;
                    }
                    this.f5130I = false;
                    if (this.f5123B == 4 || this.f5123B == 5 || this.f5123B == 6) {
                        m5286a(this.f5407aa, true);
                        mo4889a(f, f2, 128);
                        return true;
                    }
                    if (this.f5132K == null) {
                        this.f5132K = new AMS_OBJECT_DATA();
                        this.f5167y.VipAMS_GetSelectObjectData(this.f5131J.getM_pSelectObjectData(), this.f5132K);
                        this.f5403X = false;
                    }
                    if (this.f5403X && z) {
                        this.f5123B = 7;
                        return true;
                    }
                    this.f5124C = (int) (f - this.f5132K.getM_TRect().nLeft);
                    this.f5125D = (int) (f2 - this.f5132K.getM_TRect().nTop);
                    this.f5123B = 3;
                    mo4888a(this.f5132K.getM_TRect().nLeft, this.f5132K.getM_TRect().nTop, this.f5132K.getM_TRect().nRight, this.f5132K.getM_TRect().nBottom, 128);
                    this.f5403X = true;
                    return true;
            }
        }
        switch (this.f5123B) {
            case 0:
                this.f5123B = 1;
                this.f5124C = this.f5409b / 2;
                this.f5125D = this.f5409b / 2;
                mo4889a(f - this.f5124C, f2 - this.f5125D, MotionEventCompat.ACTION_MASK);
                return true;
            case 1:
            default:
                return true;
            case 2:
                if (this.f5131J == null) {
                    C1341p.m4651a("Why is selected object null???", getClass().getSimpleName());
                    this.f5123B = 0;
                    return true;
                }
                if (this.f5132K == null) {
                    this.f5132K = new AMS_OBJECT_DATA();
                    this.f5167y.VipAMS_GetSelectObjectData(this.f5131J.getM_pSelectObjectData(), this.f5132K);
                    this.f5403X = false;
                }
                if (this.f5403X) {
                    float f3 = this.f5132K.getM_TRect().nTop;
                    if (Math.abs(this.f5132K.getM_TRect().nRight - f) < this.f5148f * 12.0f && Math.abs(f3 - f2) < this.f5148f * 12.0f) {
                        m5286a(101, true);
                        this.f5123B = 7;
                        return true;
                    }
                }
                if (this.f5132K.getM_TRect().nLeft >= f || f >= this.f5132K.getM_TRect().nRight || this.f5132K.getM_TRect().nTop >= f2 || f2 >= this.f5132K.getM_TRect().nBottom) {
                    return true;
                }
                this.f5124C = (int) (f - this.f5132K.getM_TRect().nLeft);
                this.f5125D = (int) (f2 - this.f5132K.getM_TRect().nTop);
                this.f5123B = 3;
                mo4889a(f - this.f5124C, f2 - this.f5125D, 128);
                this.f5130I = false;
                this.f5403X = true;
                return true;
        }
    }

    @Override // com.sec.vip.amschaton.C1468i
    /* renamed from: c */
    public boolean mo4895c(float f, float f2) {
        if (this.f5167y == null) {
            return false;
        }
        if (this.f5408ab) {
            switch (this.f5123B) {
                case 1:
                case 4:
                case 5:
                case 6:
                    float f3 = f - this.f5126E;
                    float f4 = f2 - this.f5127F;
                    if (0.0f <= f3 && f3 < this.f5148f * 32.0f) {
                        f = this.f5126E + (this.f5148f * 32.0f);
                    }
                    if ((-32.0f) * this.f5148f < f3 && f3 < 0.0f) {
                        f = this.f5126E - (this.f5148f * 32.0f);
                    }
                    if (0.0f <= f4 && f4 < this.f5148f * 32.0f) {
                        f2 = this.f5127F + (this.f5148f * 32.0f);
                    }
                    if ((-32.0f) * this.f5148f < f4 && f4 < 0.0f) {
                        f2 = this.f5127F - (this.f5148f * 32.0f);
                    }
                    mo4889a(f, f2, 128);
                    if (this.f5129H) {
                        this.f5130I = true;
                    }
                    m5286a(this.f5407aa, true);
                    break;
                case 3:
                    mo4888a(f - this.f5124C, f2 - this.f5125D, ((this.f5132K.getM_TRect().nRight - this.f5132K.getM_TRect().nLeft) + f) - this.f5124C, ((this.f5132K.getM_TRect().nBottom - this.f5132K.getM_TRect().nTop) + f2) - this.f5125D, 128);
                    if (this.f5129H) {
                        this.f5130I = true;
                        break;
                    }
                    break;
                case 7:
                    if (!(Math.abs(((float) this.f5132K.getM_TRect().nRight) - f) < this.f5148f * 12.0f && Math.abs(((float) this.f5132K.getM_TRect().nTop) - f2) < this.f5148f * 12.0f)) {
                        m5286a(101, false);
                        this.f5123B = 2;
                        break;
                    }
                    break;
            }
            return true;
        }
        switch (this.f5123B) {
            case 1:
            case 3:
                if (this.f5129H) {
                    mo4889a(f - this.f5124C, f2 - this.f5125D, 128);
                    this.f5130I = true;
                    break;
                } else {
                    mo4889a(f - this.f5124C, f2 - this.f5125D, MotionEventCompat.ACTION_MASK);
                    break;
                }
            case 7:
                if (!(Math.abs(((float) this.f5132K.getM_TRect().nRight) - f) < this.f5148f * 12.0f && Math.abs(((float) this.f5132K.getM_TRect().nTop) - f2) < this.f5148f * 12.0f)) {
                    m5286a(101, false);
                    this.f5123B = 2;
                    break;
                }
                break;
        }
        return true;
    }

    @Override // com.sec.vip.amschaton.C1468i
    /* renamed from: d */
    public boolean mo4896d(float f, float f2) {
        if (this.f5167y == null) {
            return false;
        }
        if (this.f5408ab) {
            AMS_RECT ams_rect = new AMS_RECT();
            float f3 = f - this.f5126E;
            float f4 = f2 - this.f5127F;
            switch (this.f5123B) {
                case 1:
                    if (0.0f <= f3 && f3 < this.f5148f * 32.0f) {
                        f = this.f5126E + (this.f5148f * 32.0f);
                    }
                    if ((-32.0f) * this.f5148f < f3 && f3 < 0.0f) {
                        f = this.f5126E - (this.f5148f * 32.0f);
                    }
                    if (0.0f <= f4 && f4 < this.f5148f * 32.0f) {
                        f2 = this.f5127F + (this.f5148f * 32.0f);
                    }
                    if ((-32.0f) * this.f5148f < f4 && f4 < 0.0f) {
                        f2 = this.f5127F - (this.f5148f * 32.0f);
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
                    int i = this.f5132K.getM_TRect().nRight - this.f5132K.getM_TRect().nLeft;
                    int i2 = this.f5132K.getM_TRect().nBottom - this.f5132K.getM_TRect().nTop;
                    ams_rect.nLeft = (short) (f - this.f5124C);
                    ams_rect.nTop = (short) (f2 - this.f5125D);
                    ams_rect.nRight = (short) ((i + f) - this.f5124C);
                    ams_rect.nBottom = (short) ((i2 + f2) - this.f5125D);
                    if (!this.f5130I) {
                        mo4888a(ams_rect.nLeft, ams_rect.nTop, ams_rect.nRight, ams_rect.nBottom, MotionEventCompat.ACTION_MASK);
                        break;
                    } else {
                        this.f5130I = false;
                        return mo4947a(ams_rect);
                    }
                case 4:
                    m5286a(102, false);
                    m5286a(103, false);
                    m5286a(104, false);
                    this.f5123B = 2;
                    if (0.0f <= f3 && f3 < this.f5148f * 32.0f) {
                        f = this.f5126E + (this.f5148f * 32.0f);
                    }
                    if ((-32.0f) * this.f5148f < f3 && f3 < 0.0f) {
                        f = this.f5126E - (this.f5148f * 32.0f);
                    }
                    if (0.0f <= f4 && f4 < this.f5148f * 32.0f) {
                        f2 = this.f5127F + (this.f5148f * 32.0f);
                    }
                    if ((-32.0f) * this.f5148f < f4 && f4 < 0.0f) {
                        f2 = this.f5127F - (this.f5148f * 32.0f);
                    }
                    if (!this.f5130I) {
                        mo4889a(f, f2, MotionEventCompat.ACTION_MASK);
                        break;
                    } else {
                        this.f5130I = false;
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
                        return mo4947a(ams_rect);
                    }
                case 5:
                    this.f5123B = 2;
                    if (!this.f5130I) {
                        mo4889a(f, f2, MotionEventCompat.ACTION_MASK);
                        break;
                    } else {
                        this.f5130I = false;
                        ams_rect.nLeft = (short) this.f5126E;
                        ams_rect.nTop = (short) this.f5127F;
                        ams_rect.nRight = (short) f;
                        ams_rect.nBottom = (short) this.f5405Z;
                        if (f < this.f5126E) {
                            ams_rect.nLeft = (short) f;
                            ams_rect.nRight = (short) this.f5126E;
                        }
                        return mo4947a(ams_rect);
                    }
                case 6:
                    this.f5123B = 2;
                    if (!this.f5130I) {
                        mo4889a(f, f2, MotionEventCompat.ACTION_MASK);
                        break;
                    } else {
                        this.f5130I = false;
                        ams_rect.nLeft = (short) this.f5126E;
                        ams_rect.nTop = (short) this.f5127F;
                        ams_rect.nRight = (short) this.f5404Y;
                        ams_rect.nBottom = (short) f2;
                        if (f2 < this.f5127F) {
                            ams_rect.nTop = (short) f2;
                            ams_rect.nBottom = (short) this.f5127F;
                        }
                        return mo4947a(ams_rect);
                    }
                case 7:
                    m5286a(101, false);
                    this.f5137P.mo4929a();
                    break;
            }
            return false;
        }
        AMS_RECT ams_rect2 = new AMS_RECT();
        switch (this.f5123B) {
            case 1:
                this.f5123B = 0;
                ams_rect2.nLeft = (short) (f - this.f5124C);
                ams_rect2.nTop = (short) (f2 - this.f5125D);
                ams_rect2.nRight = (short) ((f - this.f5124C) + ((110.0f * this.f5148f) / 2.0f));
                ams_rect2.nBottom = (short) ((f2 - this.f5125D) + ((110.0f * this.f5148f) / 2.0f));
                return mo4948b(ams_rect2);
            case 3:
                this.f5123B = 2;
                if (!this.f5130I) {
                    mo4889a(f - this.f5124C, f2 - this.f5125D, MotionEventCompat.ACTION_MASK);
                    break;
                } else {
                    ams_rect2.nLeft = (short) (f - this.f5124C);
                    ams_rect2.nTop = (short) (f2 - this.f5125D);
                    ams_rect2.nRight = (short) ((f - this.f5124C) + ((110.0f * this.f5148f) / 2.0f));
                    ams_rect2.nBottom = (short) ((f2 - this.f5125D) + ((110.0f * this.f5148f) / 2.0f));
                    this.f5130I = false;
                    return mo4947a(ams_rect2);
                }
            case 7:
                m5286a(101, false);
                this.f5137P.mo4929a();
                break;
        }
        return false;
    }

    @Override // com.sec.vip.amschaton.C1468i
    /* renamed from: c */
    public void mo5304c() {
        if (this.f5406a != null) {
            this.f5406a.recycle();
            this.f5406a = null;
        }
    }
}
