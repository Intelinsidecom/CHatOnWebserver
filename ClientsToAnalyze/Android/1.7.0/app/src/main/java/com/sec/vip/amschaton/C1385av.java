package com.sec.vip.amschaton;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.v4.view.MotionEventCompat;
import android.text.TextPaint;
import com.sec.amsoma.structure.AMS_OBJECT_DATA;
import com.sec.amsoma.structure.AMS_OBJECT_TEXT_INFO;
import com.sec.amsoma.structure.AMS_RECT;

/* compiled from: AMSObjectText.java */
/* renamed from: com.sec.vip.amschaton.av */
/* loaded from: classes.dex */
public class C1385av extends C1468i {

    /* renamed from: V */
    private int f4849V;

    /* renamed from: W */
    private int f4850W;

    /* renamed from: X */
    private int[] f4851X;

    /* renamed from: Y */
    private final int f4852Y;

    /* renamed from: Z */
    private final int f4853Z;

    /* renamed from: a */
    private InterfaceC1552q f4854a;

    /* renamed from: aa */
    private boolean f4855aa;

    /* renamed from: ab */
    private float f4856ab;

    /* renamed from: ac */
    private float f4857ac;

    /* renamed from: ad */
    private int f4858ad;

    /* renamed from: ae */
    private boolean f4859ae;

    /* renamed from: af */
    private float f4860af;

    /* renamed from: ag */
    private float f4861ag;

    /* renamed from: ah */
    private int f4862ah;

    /* renamed from: ai */
    private float f4863ai;

    /* renamed from: aj */
    private float f4864aj;

    /* renamed from: ak */
    private float f4865ak;

    /* renamed from: al */
    private boolean f4866al;

    /* renamed from: am */
    private float f4867am;

    /* renamed from: an */
    private float f4868an;

    /* renamed from: ao */
    private float f4869ao;

    /* renamed from: ap */
    private float f4870ap;

    /* renamed from: aq */
    private float f4871aq;

    /* renamed from: ar */
    private int f4872ar;

    /* renamed from: b */
    private Bitmap f4873b;

    public C1385av(int i, int i2, int i3, boolean z, int i4, int i5) {
        super(i, i2, i3, i4, i5);
        this.f4854a = null;
        this.f4873b = null;
        this.f4849V = 0;
        this.f4850W = 0;
        this.f4851X = new int[]{15, 18, 20, 23, 25};
        this.f4852Y = 15;
        this.f4853Z = 12;
        this.f4855aa = false;
        this.f4856ab = 0.0f;
        this.f4857ac = 0.0f;
        this.f4858ad = 100;
        this.f4859ae = false;
        this.f4860af = 0.0f;
        this.f4861ag = 0.0f;
        this.f4862ah = 0;
        this.f4863ai = 0.0f;
        this.f4864aj = 0.0f;
        this.f4865ak = 0.0f;
        this.f4866al = false;
        this.f4867am = 0.0f;
        this.f4868an = 0.0f;
        this.f4869ao = 0.0f;
        this.f4870ap = 0.0f;
        this.f4871aq = 0.0f;
        this.f4872ar = 48;
        this.f5154l = new Paint();
        this.f5154l.setColor(this.f5146d);
        this.f5154l.setAntiAlias(true);
        this.f5154l.setDither(true);
        this.f5154l.setStrokeCap(Paint.Cap.ROUND);
        this.f5154l.setStrokeJoin(Paint.Join.ROUND);
        this.f5154l.setStyle(Paint.Style.FILL);
        int i6 = i3 < 0 ? 0 : i3;
        this.f5147e = i6 > 4 ? 4 : i6;
        this.f4862ah = this.f5147e;
        this.f5154l.setTextSize(this.f4851X[this.f5147e] * this.f5148f);
        this.f4859ae = z;
    }

    @Override // com.sec.vip.amschaton.C1468i
    /* renamed from: a */
    public void mo4887a(float f) {
        super.mo4887a(f);
        this.f5154l.setTextSize((float) ((this.f4851X[this.f5147e] * f) + 0.5d));
        this.f4869ao = 15.0f * this.f5148f;
        this.f4870ap = (this.f5139T * this.f5148f * 2.0f) + (this.f4869ao / 2.0f);
        this.f4871aq = 12.0f * this.f5148f;
        this.f4872ar = (int) ((20.0f * this.f5148f) + 0.5f);
    }

    @Override // com.sec.vip.amschaton.C1468i
    /* renamed from: a */
    public boolean mo4944a(float f, float f2) {
        return this.f5123B == 2 && new RectF(((float) this.f5132K.getM_TRect().nLeft) - this.f4870ap, ((float) this.f5132K.getM_TRect().nTop) - this.f4870ap, (((float) this.f5132K.getM_TRect().nRight) + this.f4870ap) + this.f4871aq, ((float) this.f5132K.getM_TRect().nBottom) + this.f4870ap).contains(f, f2);
    }

    /* renamed from: a */
    public boolean m4977a(String str, int i, int i2) {
        if (this.f5167y == null) {
            return false;
        }
        this.f5146d = i;
        this.f5154l.setColor(this.f5146d);
        int i3 = i2 < 0 ? 0 : i2;
        this.f5147e = i3 <= 5 ? i3 : 5;
        this.f4862ah = this.f5147e;
        this.f5154l.setTextSize(this.f4851X[this.f5147e] * this.f5148f);
        m4980b(str);
        AMS_RECT ams_rect = new AMS_RECT();
        ams_rect.nLeft = (short) (this.f5126E - (this.f4849V / 2));
        ams_rect.nTop = (short) (this.f5127F - (this.f4850W / 2));
        ams_rect.nRight = (short) (this.f5126E + (this.f4849V / 2));
        ams_rect.nBottom = (short) (this.f5127F + (this.f4850W / 2));
        if (this.f5167y.VipAMS_EncodeNewText(this.f5168z, ams_rect, (byte) this.f5147e, str.toCharArray(), (short) str.length(), "".toCharArray(), (short) 0, false)) {
            if (this.f4859ae) {
                m4968b(ams_rect.nLeft, ams_rect.nTop, ams_rect.nRight, ams_rect.nBottom, str, MotionEventCompat.ACTION_MASK, false);
            } else {
                m4976a(str, MotionEventCompat.ACTION_MASK);
            }
        }
        return true;
    }

    /* renamed from: a */
    public boolean m4978a(String str, int i, int i2, float f, float f2) {
        this.f5126E = f;
        this.f5127F = f2;
        return m4977a(str, i, i2);
    }

    @Override // com.sec.vip.amschaton.C1468i
    /* renamed from: a */
    public boolean mo4946a(int i, int i2, int i3) {
        super.mo4946a(i, i2, i3);
        int i4 = i3 < 0 ? 0 : i3;
        int i5 = i4 <= 5 ? i4 : 5;
        boolean z = this.f4862ah != i5;
        this.f5147e = i5;
        this.f4862ah = this.f5147e;
        this.f5154l.setTextSize(this.f4851X[this.f5147e] * this.f5148f);
        if (this.f4859ae) {
            m4974a(new RectF(this.f5132K.getM_TRect().nLeft, this.f5132K.getM_TRect().nTop, this.f5132K.getM_TRect().nRight, this.f5132K.getM_TRect().nBottom), String.copyValueOf(this.f5132K.getM_TText().getM_cText()));
            if (!this.f5129H || this.f5131J == null) {
                return false;
            }
            AMS_RECT ams_rect = new AMS_RECT();
            ams_rect.nLeft = (short) r0.left;
            ams_rect.nTop = (short) r0.top;
            ams_rect.nRight = (short) r0.right;
            ams_rect.nBottom = (short) r0.bottom;
            if (z) {
                ams_rect.nRight = (short) (r0.left + this.f4849V);
                ams_rect.nBottom = (short) (r0.top + this.f4850W);
            }
            this.f5167y.VipAMS_SetCurObjectColor(this.f5168z, Color.red(i2), Color.green(i2), Color.blue(i2));
            if (!this.f5167y.VipAMS_ChangeSelectText(this.f5168z, this.f5131J, ams_rect, (byte) this.f5147e, this.f5132K.getM_TText().getM_cText(), (short) this.f5132K.getM_TText().getM_nTextLength(), this.f5132K.getM_TText().getM_cFontFaceName(), (short) this.f5132K.getM_TText().getM_nFontFaceLength(), false)) {
                return false;
            }
            this.f5132K.setM_TRect(ams_rect);
            this.f5154l.setColor(i2);
            m4968b(this.f5132K.getM_TRect().nLeft, this.f5132K.getM_TRect().nTop, this.f5132K.getM_TRect().nRight, this.f5132K.getM_TRect().nBottom, this.f5132K.getM_TText().getM_strText(), MotionEventCompat.ACTION_MASK, false);
        } else {
            m4980b(String.copyValueOf(this.f5132K.getM_TText().getM_cText()));
            if (!this.f5129H || this.f5131J == null) {
                return false;
            }
            AMS_RECT ams_rect2 = new AMS_RECT();
            ams_rect2.nLeft = this.f5132K.getM_TRect().nLeft;
            ams_rect2.nTop = this.f5132K.getM_TRect().nTop;
            ams_rect2.nRight = (short) (this.f5132K.getM_TRect().nLeft + this.f4849V);
            ams_rect2.nBottom = (short) (this.f5132K.getM_TRect().nTop + this.f4850W);
            this.f5167y.VipAMS_SetCurObjectColor(this.f5168z, Color.red(i2), Color.green(i2), Color.blue(i2));
            if (!this.f5167y.VipAMS_ChangeSelectText(this.f5168z, this.f5131J, ams_rect2, (byte) this.f5147e, this.f5132K.getM_TText().getM_cText(), (short) this.f5132K.getM_TText().getM_nTextLength(), this.f5132K.getM_TText().getM_cFontFaceName(), (short) this.f5132K.getM_TText().getM_nFontFaceLength(), false)) {
                return false;
            }
            this.f5132K.setM_TRect(ams_rect2);
            this.f5154l.setColor(i2);
            this.f4873b = null;
            mo4973a(this.f5132K.getM_TRect().nLeft, this.f5132K.getM_TRect().nTop, this.f5132K.getM_TText().getM_strText(), MotionEventCompat.ACTION_MASK);
        }
        return true;
    }

    /* renamed from: a */
    public boolean m4975a(String str) {
        if (!this.f5129H || this.f5131J == null) {
            return false;
        }
        if (this.f4859ae) {
            m4974a(new RectF(this.f5132K.getM_TRect().nLeft, this.f5132K.getM_TRect().nTop, this.f5132K.getM_TRect().nRight, this.f5132K.getM_TRect().nBottom), str);
            AMS_RECT ams_rect = new AMS_RECT();
            ams_rect.nLeft = (short) r0.left;
            ams_rect.nTop = (short) r0.top;
            ams_rect.nRight = (short) (r0.left + this.f4849V);
            ams_rect.nBottom = (short) (r0.top + this.f4850W);
            if (!this.f5167y.VipAMS_ChangeSelectText(this.f5168z, this.f5131J, ams_rect, (byte) this.f5147e, str.toCharArray(), (short) str.length(), this.f5132K.getM_TText().getM_cFontFaceName(), (short) this.f5132K.getM_TText().getM_nFontFaceLength(), false)) {
                return false;
            }
            this.f5132K.setM_TRect(ams_rect);
            AMS_OBJECT_TEXT_INFO ams_object_text_info = new AMS_OBJECT_TEXT_INFO();
            ams_object_text_info.setM_strText(str);
            ams_object_text_info.setM_nTextLength(str.length());
            ams_object_text_info.setM_strFontFaceName(this.f5132K.getM_TText().getM_strFontFaceName());
            ams_object_text_info.setM_nFontFaceLength(this.f5132K.getM_TText().getM_nFontFaceLength());
            this.f5132K.setM_TText(ams_object_text_info);
            m4968b(ams_rect.nLeft, ams_rect.nTop, ams_rect.nRight, ams_rect.nBottom, str, MotionEventCompat.ACTION_MASK, false);
        } else {
            m4980b(str);
            AMS_RECT ams_rect2 = new AMS_RECT();
            ams_rect2.nLeft = (short) this.f5126E;
            ams_rect2.nTop = (short) this.f5127F;
            ams_rect2.nRight = (short) (this.f5126E + this.f4849V);
            ams_rect2.nBottom = (short) (this.f5127F + this.f4850W);
            if (!this.f5167y.VipAMS_ChangeSelectText(this.f5168z, this.f5131J, ams_rect2, (byte) this.f5147e, str.toCharArray(), (short) str.length(), this.f5132K.getM_TText().getM_cFontFaceName(), (short) this.f5132K.getM_TText().getM_nFontFaceLength(), false)) {
                return false;
            }
            this.f5132K.setM_TRect(ams_rect2);
            AMS_OBJECT_TEXT_INFO ams_object_text_info2 = new AMS_OBJECT_TEXT_INFO();
            ams_object_text_info2.setM_strText(str);
            ams_object_text_info2.setM_nTextLength(str.length());
            ams_object_text_info2.setM_strFontFaceName(this.f5132K.getM_TText().getM_strFontFaceName());
            ams_object_text_info2.setM_nFontFaceLength(this.f5132K.getM_TText().getM_nFontFaceLength());
            this.f5132K.setM_TText(ams_object_text_info2);
            m4976a(str, MotionEventCompat.ACTION_MASK);
        }
        return true;
    }

    @Override // com.sec.vip.amschaton.C1468i
    /* renamed from: a */
    public boolean mo4947a(AMS_RECT ams_rect) {
        if (!this.f5129H || this.f5131J == null) {
            return false;
        }
        if (this.f4859ae) {
            AMS_RECT ams_rect2 = new AMS_RECT();
            ams_rect2.nLeft = ams_rect.nLeft;
            ams_rect2.nTop = ams_rect.nTop;
            ams_rect2.nRight = ams_rect.nRight;
            ams_rect2.nBottom = ams_rect.nBottom;
            if (!this.f5167y.VipAMS_ChangeSelectText(this.f5168z, this.f5131J, ams_rect2, (byte) this.f5147e, this.f5132K.getM_TText().getM_cText(), (short) this.f5132K.getM_TText().getM_nTextLength(), this.f5132K.getM_TText().getM_cFontFaceName(), (short) this.f5132K.getM_TText().getM_nFontFaceLength(), false)) {
                return false;
            }
            this.f5132K = new AMS_OBJECT_DATA();
            this.f5167y.VipAMS_GetSelectObjectData(this.f5131J.getM_pSelectObjectData(), this.f5132K);
            mo4971a(ams_rect2.nLeft, ams_rect2.nTop, ams_rect2.nRight, ams_rect2.nBottom, this.f5132K.getM_TText().getM_strText(), MotionEventCompat.ACTION_MASK);
        } else {
            if (!this.f5167y.VipAMS_ChangeSelectText(this.f5168z, this.f5131J, ams_rect, (byte) this.f5147e, this.f5132K.getM_TText().getM_cText(), (short) this.f5132K.getM_TText().getM_nTextLength(), this.f5132K.getM_TText().getM_cFontFaceName(), (short) this.f5132K.getM_TText().getM_nFontFaceLength(), false)) {
                return false;
            }
            this.f5132K = new AMS_OBJECT_DATA();
            this.f5167y.VipAMS_GetSelectObjectData(this.f5131J.getM_pSelectObjectData(), this.f5132K);
            mo4973a(ams_rect.nLeft, ams_rect.nTop, this.f5132K.getM_TText().getM_strText(), MotionEventCompat.ACTION_MASK);
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:73:0x0296  */
    @Override // com.sec.vip.amschaton.C1468i
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean mo4893b(float r12, float r13) {
        /*
            Method dump skipped, instructions count: 758
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.vip.amschaton.C1385av.mo4893b(float, float):boolean");
    }

    @Override // com.sec.vip.amschaton.C1468i
    /* renamed from: c */
    public boolean mo4895c(float f, float f2) {
        if (this.f5167y == null) {
            return false;
        }
        if (this.f4859ae) {
            switch (this.f5123B) {
                case 1:
                case 5:
                    if (this.f5132K != null) {
                        float f3 = f - this.f5126E;
                        float f4 = f2 - this.f5127F;
                        if (f3 > this.f4849V) {
                            f = this.f5126E + this.f4849V;
                        }
                        if ((-this.f4849V) > f3) {
                            f = this.f5126E - this.f4849V;
                        }
                        this.f5127F = this.f4860af - (this.f4850W / 2);
                        this.f4857ac = this.f4860af + (this.f4850W / 2);
                        if (f3 > 0.0f) {
                            if (f3 < this.f4872ar) {
                                f = this.f5126E + this.f4872ar;
                            }
                        } else if (f3 > (-this.f4872ar)) {
                            f = this.f5126E - this.f4872ar;
                        }
                        mo4973a(f, f2, this.f5132K.getM_TText().getM_strText(), 128);
                        if (this.f5129H) {
                            this.f5130I = true;
                        }
                        m5286a(this.f4858ad, true);
                        break;
                    }
                    break;
                case 3:
                    m4968b(f - this.f5124C, f2 - this.f5125D, ((this.f5132K.getM_TRect().nRight - this.f5132K.getM_TRect().nLeft) + f) - this.f5124C, ((this.f5132K.getM_TRect().nBottom - this.f5132K.getM_TRect().nTop) + f2) - this.f5125D, this.f5132K.getM_TText().getM_strText(), 128, false);
                    if (this.f5129H) {
                        this.f5130I = true;
                        break;
                    }
                    break;
                case 6:
                    if (this.f5132K != null) {
                        int i = this.f4850W;
                        float f5 = (f2 - this.f4860af) * 0.6f;
                        if (this.f4858ad == 106) {
                            this.f5126E -= f5;
                            this.f4856ab += f5;
                            i = -this.f4850W;
                        } else if (this.f4858ad == 108) {
                            this.f5126E += f5;
                            this.f4856ab -= f5;
                        }
                        if (this.f5126E > this.f4856ab) {
                            float f6 = this.f4856ab;
                            this.f4856ab = this.f5126E;
                            this.f5126E = f6;
                        }
                        if (this.f4856ab - this.f5126E < this.f4872ar) {
                            this.f4856ab = this.f5126E + this.f4872ar;
                            this.f4866al = true;
                        }
                        if (this.f4866al) {
                            this.f5126E = this.f4863ai;
                            this.f4856ab = this.f4864aj;
                            if (this.f4861ag * f5 <= 0.0f) {
                                this.f4866al = false;
                            }
                        }
                        if (Math.abs(this.f4856ab - this.f5126E) > this.f4865ak) {
                            this.f5126E = this.f4863ai;
                            this.f4856ab = this.f4864aj;
                        }
                        this.f4863ai = this.f5126E;
                        this.f4864aj = this.f4856ab;
                        this.f4860af = f2;
                        this.f4861ag = f5;
                        float f7 = f2 - this.f5127F;
                        if (f7 > this.f4850W || ((0.0f <= f7 && f7 < this.f4850W) || (-this.f4850W) > f7 || ((-this.f4850W) < f7 && f7 < 0.0f))) {
                            f2 = this.f5127F + i;
                        }
                        mo4973a(f, f2, this.f5132K.getM_TText().getM_strText(), 128);
                        if (this.f5129H) {
                            this.f5130I = true;
                        }
                        m5286a(this.f4858ad, true);
                        break;
                    }
                    break;
                case 7:
                    if (!(Math.abs(((float) ((this.f5132K.getM_TRect().nRight + ((int) this.f4870ap)) + ((int) this.f4871aq))) - f) < this.f4869ao && Math.abs(((float) (this.f5132K.getM_TRect().nTop - ((int) this.f4870ap))) - f2) < this.f4869ao)) {
                        m5286a(101, false);
                        this.f5123B = 2;
                        break;
                    }
                    break;
            }
            return true;
        }
        switch (this.f5123B) {
            case 3:
                if (!this.f5130I && (Math.abs(this.f5126E - f) > this.f5148f * 10.0f || Math.abs(this.f5127F - f2) > this.f5148f * 10.0f)) {
                    this.f5130I = true;
                }
                mo4973a(f - this.f5124C, f2 - this.f5125D, this.f5132K.getM_TText().getM_strText(), 128);
                break;
            case 7:
                if (!(Math.abs(((float) this.f5132K.getM_TRect().nRight) - f) < 15.0f * this.f5148f && Math.abs(((float) this.f5132K.getM_TRect().nTop) - f2) < 15.0f * this.f5148f)) {
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
        if (this.f4859ae) {
            AMS_RECT ams_rect = new AMS_RECT();
            float f3 = f - this.f5126E;
            float f4 = f2 - this.f5127F;
            switch (this.f5123B) {
                case 0:
                    if (!this.f5128G) {
                        this.f5128G = true;
                        return true;
                    }
                    mo4897e(f, f2);
                    if (this.f4854a != null) {
                        this.f4854a.mo5122a(null);
                        break;
                    } else {
                        return false;
                    }
                case 1:
                    if (f3 > this.f4849V) {
                        f = this.f5126E + this.f4849V;
                    }
                    if ((-this.f4849V) > f3) {
                        f = this.f5126E - this.f4849V;
                    }
                    if (f4 > this.f4850W || (0.0f <= f4 && f4 < this.f4850W)) {
                        f2 = this.f5127F + this.f4850W;
                    }
                    if ((-this.f4850W) > f4 || ((-this.f4850W) < f4 && f4 < 0.0f)) {
                        f2 = this.f5127F - this.f4850W;
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
                    boolean zMo4947a = mo4947a(ams_rect);
                    if (this.f5130I && (Math.abs(this.f4867am - f) > 4.0f || Math.abs(this.f4868an - f2) > 4.0f)) {
                        this.f5130I = false;
                        return zMo4947a;
                    }
                    mo4897e(f - this.f5124C, f2 - this.f5125D);
                    if (!this.f5128G) {
                        this.f5128G = true;
                        return true;
                    }
                    if (this.f4854a != null) {
                        this.f4854a.mo5122a(this.f5132K.getM_TText().getM_strText());
                        break;
                    } else {
                        return false;
                    }
                    break;
                case 5:
                    this.f5123B = 2;
                    if (f3 > this.f4849V) {
                        f = this.f5126E + this.f4849V;
                    }
                    float f5 = ((float) (-this.f4849V)) > f3 ? this.f5126E - this.f4849V : f;
                    if (f3 > 0.0f) {
                        if (f3 < this.f4872ar) {
                            f5 = this.f5126E + this.f4872ar;
                        }
                    } else if (f3 > (-this.f4872ar)) {
                        f5 = this.f5126E - this.f4872ar;
                    }
                    this.f5130I = false;
                    this.f4857ac = this.f5127F + this.f4850W;
                    ams_rect.nLeft = (short) this.f5126E;
                    ams_rect.nTop = (short) this.f5127F;
                    ams_rect.nRight = (short) f5;
                    ams_rect.nBottom = (short) this.f4857ac;
                    if (f5 < this.f5126E) {
                        ams_rect.nLeft = (short) f5;
                        ams_rect.nRight = (short) this.f5126E;
                    }
                    return mo4947a(ams_rect);
                case 6:
                    this.f5123B = 2;
                    if (this.f5130I) {
                        int i3 = this.f4850W;
                        if (this.f4858ad == 106) {
                            i3 = -this.f4850W;
                        }
                        if (f4 > this.f4850W || ((0.0f <= f4 && f4 < this.f4850W) || (-this.f4850W) > f4 || ((-this.f4850W) < f4 && f4 < 0.0f))) {
                            f2 = this.f5127F + i3;
                        }
                        if (f3 > 0.0f) {
                            if (f3 < this.f4872ar) {
                                float f6 = this.f5126E + this.f4872ar;
                            }
                        } else if (f3 > (-this.f4872ar)) {
                            float f7 = this.f5126E - this.f4872ar;
                        }
                        this.f5130I = false;
                        ams_rect.nLeft = (short) this.f5126E;
                        ams_rect.nTop = (short) this.f5127F;
                        ams_rect.nRight = (short) this.f4856ab;
                        ams_rect.nBottom = (short) f2;
                        if (f2 < this.f5127F) {
                            ams_rect.nTop = (short) f2;
                            ams_rect.nBottom = (short) this.f5127F;
                        }
                        return mo4947a(ams_rect);
                    }
                    if (f3 > this.f4849V) {
                        f = this.f5126E + this.f4849V;
                    }
                    if ((-this.f4849V) > f3) {
                        f = this.f5126E - this.f4849V;
                    }
                    if (f4 > this.f4850W || (0.0f <= f4 && f4 < this.f4850W)) {
                        f2 = this.f5127F + this.f4850W;
                    }
                    if ((-this.f4850W) > f4 || ((-this.f4850W) < f4 && f4 < 0.0f)) {
                        f2 = this.f5127F - this.f4850W;
                    }
                    mo4973a(f, f2, this.f5132K.getM_TText().getM_strText(), MotionEventCompat.ACTION_MASK);
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
                    break;
                } else {
                    mo4897e(f, f2);
                    if (this.f4854a != null) {
                        this.f4854a.mo5122a(null);
                        break;
                    } else {
                        break;
                    }
                }
            case 3:
                this.f5123B = 2;
                int i4 = this.f5132K.getM_TRect().nRight - this.f5132K.getM_TRect().nLeft;
                int i5 = this.f5132K.getM_TRect().nBottom - this.f5132K.getM_TRect().nTop;
                ams_rect2.nLeft = (short) (f - this.f5124C);
                ams_rect2.nTop = (short) (f2 - this.f5125D);
                ams_rect2.nRight = (short) ((i4 + f) - this.f5124C);
                ams_rect2.nBottom = (short) ((i5 + f2) - this.f5125D);
                boolean zMo4947a2 = mo4947a(ams_rect2);
                if (this.f5130I) {
                    this.f5130I = false;
                    break;
                } else {
                    mo4897e(f - this.f5124C, f2 - this.f5125D);
                    if (!this.f5128G) {
                        this.f5128G = true;
                        break;
                    } else if (this.f4854a != null) {
                        this.f4854a.mo5122a(this.f5132K.getM_TText().getM_strText());
                        break;
                    } else {
                        break;
                    }
                }
            case 7:
                m5286a(101, false);
                this.f5137P.mo4929a();
                break;
        }
        return false;
    }

    @Override // com.sec.vip.amschaton.C1468i
    /* renamed from: e */
    public void mo4897e(float f, float f2) {
        this.f5126E = (int) f;
        this.f5127F = (int) f2;
    }

    /* renamed from: b */
    public boolean m4980b(String str) {
        int i;
        int i2 = 0;
        TextPaint textPaint = new TextPaint();
        textPaint.setAntiAlias(true);
        textPaint.setDither(true);
        textPaint.setTextSize(this.f4851X[this.f5147e] * this.f5148f);
        textPaint.setColor(this.f5146d);
        String str2 = "";
        StringBuilder sb = new StringBuilder();
        this.f4849V = 0;
        this.f4850W = 0;
        int i3 = this.f5135N - ((int) ((40.0f * this.f5148f) + 0.5f));
        int length = str.length();
        int i4 = 0;
        for (int i5 = 0; i5 < length; i5++) {
            char cCharAt = str.charAt(i5);
            int iMeasureText = (int) textPaint.measureText(sb.toString());
            if (this.f4849V < iMeasureText) {
                this.f4849V = iMeasureText;
            }
            if (iMeasureText > i3) {
                str2 = str2 + sb.toString() + "\n";
                sb = new StringBuilder();
                sb.append(cCharAt);
                i4++;
            } else {
                sb.append(cCharAt);
            }
        }
        String str3 = str2 + sb.toString();
        int i6 = i4 + 1;
        int iMeasureText2 = (int) textPaint.measureText(sb.toString());
        if (this.f4849V < iMeasureText2) {
            this.f4849V = iMeasureText2;
        }
        if (this.f4849V < this.f4872ar) {
            i = (this.f4872ar - this.f4849V) / 2;
            this.f4849V = this.f4872ar;
        } else {
            i = 0;
        }
        this.f4850W = (int) ((i6 + 0.4d) * textPaint.getTextSize());
        if (this.f4873b != null) {
            this.f4873b.recycle();
            this.f4873b = null;
        }
        this.f4873b = Bitmap.createBitmap(this.f4849V, this.f4850W, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(this.f4873b);
        int i7 = 1;
        while (true) {
            int iIndexOf = str3.indexOf("\n", i2);
            if (iIndexOf == -1) {
                canvas.drawText(str3.substring(i2, str3.length()), i, i7 * textPaint.getTextSize(), textPaint);
                return true;
            }
            canvas.drawText(str3.substring(i2, iIndexOf), i, textPaint.getTextSize() * i7, textPaint);
            i2 = iIndexOf + 1;
            i7++;
        }
    }

    /* renamed from: a */
    public boolean m4974a(RectF rectF, String str) {
        int i;
        int i2 = 0;
        TextPaint textPaint = new TextPaint();
        textPaint.setAntiAlias(true);
        textPaint.setDither(true);
        textPaint.setTextSize(this.f4851X[this.f5147e] * this.f5148f);
        textPaint.setColor(this.f5146d);
        String str2 = "";
        StringBuilder sb = new StringBuilder();
        this.f4849V = 0;
        this.f4850W = 0;
        int length = str.length();
        int iWidth = (int) rectF.width();
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            char cCharAt = str.charAt(i4);
            int iMeasureText = (int) textPaint.measureText(sb.toString());
            if (this.f4849V < iMeasureText) {
                this.f4849V = iMeasureText;
            }
            if (iMeasureText > iWidth) {
                str2 = str2 + sb.toString() + "\n";
                sb = new StringBuilder();
                sb.append(cCharAt);
                i3++;
            } else {
                sb.append(cCharAt);
            }
        }
        String str3 = str2 + ((Object) sb);
        int i5 = i3 + 1;
        int iMeasureText2 = (int) textPaint.measureText(sb.toString());
        if (this.f4849V < iMeasureText2) {
            this.f4849V = iMeasureText2;
        }
        if (this.f4849V < this.f4872ar) {
            i = (this.f4872ar - this.f4849V) / 2;
            this.f4849V = this.f4872ar;
        } else {
            i = 0;
        }
        this.f4850W = (int) ((i5 + 0.4d) * textPaint.getTextSize());
        if (this.f4873b != null) {
            this.f4873b.recycle();
            this.f4873b = null;
        }
        this.f4873b = Bitmap.createBitmap(this.f4849V, this.f4850W, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(this.f4873b);
        int i6 = 1;
        while (true) {
            int iIndexOf = str3.indexOf("\n", i2);
            if (iIndexOf == -1) {
                canvas.drawText(str3.substring(i2, str3.length()), i, i6 * textPaint.getTextSize(), textPaint);
                return true;
            }
            canvas.drawText(str3.substring(i2, iIndexOf), i, textPaint.getTextSize() * i6, textPaint);
            i2 = iIndexOf + 1;
            i6++;
        }
    }

    /* renamed from: c */
    private float m4969c(String str) {
        TextPaint textPaint = new TextPaint();
        textPaint.setAntiAlias(true);
        textPaint.setDither(true);
        textPaint.setTextSize(this.f4851X[this.f5147e] * this.f5148f);
        textPaint.setColor(this.f5146d);
        return textPaint.measureText(str);
    }

    /* renamed from: j */
    public int m4981j() {
        return this.f4849V;
    }

    /* renamed from: k */
    public int m4982k() {
        return this.f4850W;
    }

    /* renamed from: a */
    public boolean m4976a(String str, int i) {
        mo4973a(this.f5126E, this.f5127F, str, i);
        return true;
    }

    @Override // com.sec.vip.amschaton.C1468i
    /* renamed from: a */
    public boolean mo4973a(float f, float f2, String str, int i) {
        float f3;
        float f4;
        float f5;
        if (this.f4859ae) {
            float f6 = this.f5126E;
            float f7 = this.f5127F;
            switch (this.f5123B) {
                case 5:
                    f3 = this.f4857ac;
                    f4 = f;
                    break;
                case 6:
                    f3 = f2;
                    f4 = this.f4856ab;
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
        if (this.f4873b == null) {
            m4980b(str);
        }
        Rect rect = new Rect((int) f, (int) f2, (int) (this.f4849V + f), (int) (this.f4850W + f2));
        this.f5149g.drawBitmap(this.f5151i, 0.0f, 0.0f, (Paint) null);
        this.f5149g.drawBitmap(this.f4873b, f, f2, this.f5154l);
        m5284a(rect.left, rect.top, rect.right, rect.bottom);
        return true;
    }

    @Override // com.sec.vip.amschaton.C1468i
    /* renamed from: a */
    public boolean mo4971a(float f, float f2, float f3, float f4, String str, int i) {
        return m4968b(f, f2, f3, f4, str, i, true);
    }

    @Override // com.sec.vip.amschaton.C1468i
    /* renamed from: a */
    public boolean mo4972a(float f, float f2, float f3, float f4, String str, int i, boolean z) {
        return m4967a(f, f2, f3, f4, str, i, true, z);
    }

    /* renamed from: b */
    private boolean m4968b(float f, float f2, float f3, float f4, String str, int i, boolean z) {
        return m4967a(f, f2, f3, f4, str, i, z, true);
    }

    /* renamed from: a */
    private boolean m4967a(float f, float f2, float f3, float f4, String str, int i, boolean z, boolean z2) {
        this.f5154l.setAlpha(i);
        RectF rectF = new RectF(f, f2, f3, f4);
        if (z) {
            m4974a(rectF, str);
        }
        if (z2) {
            this.f5149g.drawBitmap(this.f5151i, 0.0f, 0.0f, (Paint) null);
        }
        float f5 = ((f + f3) - this.f4849V) / 2.0f;
        float f6 = ((f + f3) + this.f4849V) / 2.0f;
        float f7 = ((f2 + f4) - this.f4850W) / 2.0f;
        float f8 = ((f2 + f4) + this.f4850W) / 2.0f;
        if (this.f5130I) {
            switch (this.f4858ad) {
                case 105:
                    this.f5149g.drawBitmap(this.f4873b, f, f7, this.f5154l);
                    rectF.set(f3 - this.f4849V, f7, f3, f8);
                    break;
                case 106:
                    this.f5149g.drawBitmap(this.f4873b, f5, f2, this.f5154l);
                    rectF.set(f5, f4 - this.f4850W, f6, f4);
                    break;
                case 107:
                default:
                    this.f5149g.drawBitmap(this.f4873b, f, f7, this.f5154l);
                    rectF.set(f, f7, this.f4849V + f, f8);
                    break;
                case 108:
                    this.f5149g.drawBitmap(this.f4873b, f5, f2, this.f5154l);
                    rectF.set(f5, f2, f6, this.f4850W + f2);
                    break;
            }
        } else {
            this.f5149g.drawBitmap(this.f4873b, f, f2, this.f5154l);
            rectF.set(f, f2, this.f4849V + f, this.f4850W + f2);
        }
        m5284a(rectF.left, rectF.top, rectF.right, rectF.bottom);
        return true;
    }

    /* renamed from: a */
    public void m4970a(InterfaceC1552q interfaceC1552q) {
        this.f4854a = interfaceC1552q;
    }

    /* renamed from: a */
    public boolean m4979a(int[] iArr) {
        if (iArr.length != 2) {
            return false;
        }
        iArr[0] = (int) this.f5126E;
        iArr[1] = (int) this.f5127F;
        return true;
    }
}
