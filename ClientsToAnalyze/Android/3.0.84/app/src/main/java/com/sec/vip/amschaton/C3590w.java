package com.sec.vip.amschaton;

import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.v4.view.MotionEventCompat;
import com.sec.amsoma.structure.AMS_OBJECT_DATA;
import com.sec.amsoma.structure.AMS_RECT;
import com.sec.chaton.util.C3250y;

/* compiled from: AMSObjectDrawings.java */
/* renamed from: com.sec.vip.amschaton.w */
/* loaded from: classes.dex */
public class C3590w extends C3588u {

    /* renamed from: Z */
    private Paint f13112Z;

    /* renamed from: aa */
    private float f13113aa;

    /* renamed from: ab */
    private float f13114ab;

    /* renamed from: ac */
    private final int f13115ac;

    /* renamed from: ad */
    private boolean f13116ad;

    /* renamed from: ae */
    private boolean f13117ae;

    public C3590w(int i, int i2, int i3, boolean z) {
        super(i, i2, i3);
        this.f13113aa = 0.0f;
        this.f13114ab = 0.0f;
        this.f13115ac = 10;
        this.f13116ad = false;
        this.f13117ae = false;
        this.f13117ae = z;
        if (this.f13117ae) {
            this.f13112Z = new Paint();
            this.f13112Z.setColor(this.f13087b);
            this.f13112Z.setStrokeWidth(i3);
            this.f13112Z.setAntiAlias(true);
            this.f13112Z.setDither(true);
            this.f13112Z.setStrokeCap(Paint.Cap.ROUND);
            this.f13112Z.setStrokeJoin(Paint.Join.ROUND);
            switch (i) {
                case 0:
                case 1:
                case 2:
                case 6:
                    this.f13112Z.setStyle(Paint.Style.STROKE);
                    break;
                case 3:
                case 4:
                case 5:
                case 7:
                    this.f13112Z.setStyle(Paint.Style.FILL);
                    break;
                default:
                    this.f13112Z.setStyle(Paint.Style.STROKE);
                    break;
            }
        }
    }

    @Override // com.sec.vip.amschaton.C3588u
    /* renamed from: a */
    public void mo12131a(float f) {
        super.mo12131a(f);
        if (this.f13112Z != null) {
            this.f13112Z.setStrokeWidth((float) ((this.f13088c * f) + 0.5d));
        }
    }

    @Override // com.sec.vip.amschaton.C3588u
    /* renamed from: a */
    public boolean mo12838a(AMS_RECT ams_rect) {
        if (!this.f13110y.VipAMS_EncodeNewDiagram(this.f13111z, ams_rect, (byte) this.f13082a)) {
            C3250y.m11442a("errocode = " + this.f13110y.VipAMS_GetErrorCode(this.f13111z), getClass().getSimpleName());
            mo12815a();
            return false;
        }
        mo12830a(ams_rect.nLeft, ams_rect.nTop, ams_rect.nRight, ams_rect.nBottom, MotionEventCompat.ACTION_MASK);
        return true;
    }

    @Override // com.sec.vip.amschaton.C3588u
    /* renamed from: a */
    public boolean mo12137a(int i, int i2, int i3) {
        super.mo12137a(i, i2, i3);
        if (this.f13112Z == null) {
            return true;
        }
        if (this.f13065H && this.f13067J != null) {
            if (!this.f13110y.VipAMS_ChangeSelectDiagram(this.f13111z, this.f13067J, this.f13068K.getM_TRect(), (byte) this.f13082a)) {
                return false;
            }
            this.f13068K.setM_cStyle(i);
            this.f13112Z.setColor(i2);
            this.f13112Z.setStrokeWidth((float) ((this.f13088c * this.f13089d) + 0.5d));
            switch (i) {
                case 0:
                case 1:
                case 2:
                case 6:
                    this.f13112Z.setStyle(Paint.Style.STROKE);
                    break;
                case 3:
                case 4:
                case 5:
                case 7:
                    this.f13112Z.setStyle(Paint.Style.FILL);
                    break;
                default:
                    this.f13112Z.setStyle(Paint.Style.STROKE);
                    break;
            }
            mo12830a(this.f13068K.getM_TRect().nLeft, this.f13068K.getM_TRect().nTop, this.f13068K.getM_TRect().nRight, this.f13068K.getM_TRect().nBottom, MotionEventCompat.ACTION_MASK);
        }
        return true;
    }

    @Override // com.sec.vip.amschaton.C3588u
    /* renamed from: b */
    public boolean mo12144b(AMS_RECT ams_rect) {
        if (!this.f13065H || this.f13067J == null || !this.f13110y.VipAMS_ChangeSelectDiagram(this.f13111z, this.f13067J, ams_rect, (byte) this.f13068K.getM_cStyle())) {
            return false;
        }
        this.f13068K.setM_TRect(ams_rect);
        mo12830a(ams_rect.nLeft, ams_rect.nTop, ams_rect.nRight, ams_rect.nBottom, MotionEventCompat.ACTION_MASK);
        return true;
    }

    @Override // com.sec.vip.amschaton.C3588u
    /* renamed from: a */
    public void mo12132a(float f, float f2) {
        this.f13062E = f;
        this.f13063F = f2;
    }

    @Override // com.sec.vip.amschaton.C3588u
    /* renamed from: a */
    public boolean mo12832a(float f, float f2, int i) {
        float f3;
        float f4;
        float f5;
        float f6 = this.f13062E;
        float f7 = this.f13063F;
        switch (this.f13059B) {
            case 5:
                f3 = this.f13114ab;
                f4 = f;
                break;
            case 6:
                f3 = f2;
                f4 = this.f13113aa;
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
        return mo12830a(f4, f5, f6, f7, i);
    }

    @Override // com.sec.vip.amschaton.C3588u
    /* renamed from: a */
    public boolean mo12830a(float f, float f2, float f3, float f4, int i) {
        return mo12831a(f, f2, f3, f4, i, true);
    }

    @Override // com.sec.vip.amschaton.C3588u
    /* renamed from: a */
    public boolean mo12831a(float f, float f2, float f3, float f4, int i, boolean z) {
        if (z) {
            this.f13092g.drawBitmap(this.f13094i, 0.0f, 0.0f, (Paint) null);
        }
        if (this.f13117ae) {
            RectF rectF = new RectF(f, f2, f3, f4);
            Path path = new Path();
            this.f13112Z.setAlpha(i);
            switch (this.f13082a) {
                case 0:
                case 3:
                    this.f13092g.drawRect(rectF, this.f13112Z);
                    break;
                case 1:
                case 4:
                    this.f13092g.drawRoundRect(rectF, (f3 - f) / 2.0f, (f4 - f2) / 2.0f, this.f13112Z);
                    break;
                case 2:
                case 5:
                    path.moveTo(rectF.centerX(), f2);
                    path.lineTo(f, f4);
                    path.lineTo(f3, f4);
                    path.lineTo(rectF.centerX(), f2);
                    this.f13092g.drawPath(path, this.f13112Z);
                    break;
                case 6:
                case 7:
                    path.moveTo(rectF.centerX(), f2);
                    path.lineTo(f, rectF.centerY());
                    path.lineTo(rectF.centerX(), f4);
                    path.lineTo(f3, rectF.centerY());
                    path.lineTo(rectF.centerX(), f2);
                    this.f13092g.drawPath(path, this.f13112Z);
                    break;
                default:
                    this.f13092g.drawRect(rectF, this.f13112Z);
                    break;
            }
            m12816a(f - ((this.f13088c * this.f13089d) / 2.0f), f2 - ((this.f13088c * this.f13089d) / 2.0f), ((this.f13088c * this.f13089d) / 2.0f) + f3, ((this.f13088c * this.f13089d) / 2.0f) + f4);
            return true;
        }
        if (this.f13070M != null) {
            this.f13070M.setBounds(new Rect(Math.round(f), Math.round(f2), Math.round(f3), Math.round(f4)));
            this.f13070M.draw(this.f13092g);
            return true;
        }
        return true;
    }

    @Override // com.sec.vip.amschaton.C3588u
    /* renamed from: c */
    public boolean mo12146c(float f, float f2) {
        return this.f13059B == 2 && new RectF(((float) this.f13068K.getM_TRect().nLeft) - (this.f13089d * 10.0f), ((float) this.f13068K.getM_TRect().nTop) - (this.f13089d * 10.0f), ((float) this.f13068K.getM_TRect().nRight) + (this.f13089d * 10.0f), ((float) this.f13068K.getM_TRect().nBottom) + (this.f13089d * 10.0f)).contains(f, f2);
    }

    @Override // com.sec.vip.amschaton.C3588u
    /* renamed from: d */
    public boolean mo12147d(float f, float f2) {
        boolean z;
        if (this.f13110y == null) {
            return false;
        }
        switch (this.f13059B) {
            case 0:
                if (!this.f13064G) {
                    this.f13064G = true;
                    return true;
                }
                this.f13059B = 1;
                mo12132a(f - 1.0f, f2 - 1.0f);
                mo12832a((15.0f * this.f13089d) + f, (15.0f * this.f13089d) + f2, MotionEventCompat.ACTION_MASK);
                this.f13062E = (int) (f - 1.0f);
                this.f13063F = (int) (f2 - 1.0f);
                return true;
            case 1:
            default:
                return true;
            case 2:
                if (this.f13067J == null) {
                    C3250y.m11442a("Why is selected object null???", getClass().getSimpleName());
                    this.f13059B = 0;
                    return true;
                }
                if (this.f13068K != null) {
                    short s = this.f13068K.getM_TRect().nLeft;
                    short s2 = this.f13068K.getM_TRect().nTop;
                    short s3 = this.f13068K.getM_TRect().nRight;
                    short s4 = this.f13068K.getM_TRect().nBottom;
                    if (Math.abs(s - f) < this.f13089d * 10.0f && Math.abs(s2 - f2) < this.f13089d * 10.0f) {
                        this.f13062E = s3;
                        this.f13063F = s4;
                        this.f13059B = 4;
                        z = false;
                    } else if (Math.abs(s3 - f) < this.f13089d * 10.0f && Math.abs(s2 - f2) < this.f13089d * 10.0f) {
                        m12844b(101, true);
                        z = true;
                    } else if (Math.abs(s3 - f) < this.f13089d * 10.0f && Math.abs(s4 - f2) < this.f13089d * 10.0f) {
                        this.f13062E = s;
                        this.f13063F = s2;
                        this.f13059B = 4;
                        z = false;
                    } else if (Math.abs(s - f) < this.f13089d * 10.0f && Math.abs(s4 - f2) < this.f13089d * 10.0f) {
                        this.f13062E = s3;
                        this.f13063F = s2;
                        this.f13059B = 4;
                        z = false;
                    } else if (Math.abs(((s + s3) / 2) - f) < this.f13089d * 10.0f && Math.abs(s2 - f2) < this.f13089d * 10.0f) {
                        this.f13062E = s;
                        this.f13063F = s4;
                        this.f13113aa = s3;
                        this.f13114ab = s4;
                        this.f13059B = 6;
                        z = false;
                    } else if (Math.abs(s3 - f) < this.f13089d * 10.0f && Math.abs(((s2 + s4) / 2) - f2) < this.f13089d * 10.0f) {
                        this.f13062E = s;
                        this.f13063F = s2;
                        this.f13113aa = s;
                        this.f13114ab = s4;
                        this.f13059B = 5;
                        z = false;
                    } else if (Math.abs(((s + s3) / 2) - f) >= this.f13089d * 10.0f || Math.abs(s4 - f2) >= this.f13089d * 10.0f) {
                        if (Math.abs(s - f) < this.f13089d * 10.0f && Math.abs(((s2 + s4) / 2) - f2) < this.f13089d * 10.0f) {
                            this.f13062E = s3;
                            this.f13063F = s2;
                            this.f13113aa = s3;
                            this.f13114ab = s4;
                            this.f13059B = 5;
                        }
                        z = false;
                    } else {
                        this.f13062E = s;
                        this.f13063F = s2;
                        this.f13113aa = s3;
                        this.f13114ab = s2;
                        this.f13059B = 6;
                        z = false;
                    }
                } else {
                    z = false;
                }
                this.f13066I = false;
                if (this.f13059B == 4 || this.f13059B == 5 || this.f13059B == 6) {
                    mo12832a(f, f2, 128);
                    return true;
                }
                if (this.f13068K == null) {
                    this.f13068K = new AMS_OBJECT_DATA();
                    this.f13110y.VipAMS_GetSelectObjectData(this.f13067J.getM_pSelectObjectData(), this.f13068K);
                    this.f13116ad = false;
                }
                if (this.f13116ad && z) {
                    this.f13059B = 7;
                    return true;
                }
                this.f13060C = (int) (f - this.f13068K.getM_TRect().nLeft);
                this.f13061D = (int) (f2 - this.f13068K.getM_TRect().nTop);
                this.f13059B = 3;
                mo12830a(this.f13068K.getM_TRect().nLeft, this.f13068K.getM_TRect().nTop, this.f13068K.getM_TRect().nRight, this.f13068K.getM_TRect().nBottom, 128);
                this.f13116ad = true;
                return true;
        }
    }

    @Override // com.sec.vip.amschaton.C3588u
    /* renamed from: e */
    public boolean mo12148e(float f, float f2) {
        if (this.f13110y == null) {
            return false;
        }
        switch (this.f13059B) {
            case 1:
            case 4:
            case 5:
            case 6:
                float f3 = f - this.f13062E;
                float f4 = f2 - this.f13063F;
                if (0.0f <= f3 && f3 < this.f13089d * 15.0f) {
                    f = this.f13062E + (this.f13089d * 15.0f);
                }
                if (this.f13089d * (-15.0f) < f3 && f3 < 0.0f) {
                    f = this.f13062E - (this.f13089d * 15.0f);
                }
                if (0.0f <= f4 && f4 < this.f13089d * 15.0f) {
                    f2 = this.f13063F + (this.f13089d * 15.0f);
                }
                if (this.f13089d * (-15.0f) < f4 && f4 < 0.0f) {
                    f2 = this.f13063F - (this.f13089d * 15.0f);
                }
                mo12832a(f, f2, 128);
                if (this.f13065H) {
                    this.f13066I = true;
                    break;
                }
                break;
            case 3:
                mo12830a(f - this.f13060C, f2 - this.f13061D, ((this.f13068K.getM_TRect().nRight - this.f13068K.getM_TRect().nLeft) + f) - this.f13060C, ((this.f13068K.getM_TRect().nBottom - this.f13068K.getM_TRect().nTop) + f2) - this.f13061D, 128);
                if (this.f13065H) {
                    this.f13066I = true;
                    break;
                }
                break;
            case 7:
                if (!(Math.abs(((float) this.f13068K.getM_TRect().nRight) - f) < 10.0f * this.f13089d && Math.abs(((float) this.f13068K.getM_TRect().nTop) - f2) < 10.0f * this.f13089d)) {
                    m12844b(101, false);
                    this.f13059B = 2;
                    break;
                }
                break;
        }
        return true;
    }

    @Override // com.sec.vip.amschaton.C3588u
    /* renamed from: f */
    public boolean mo12149f(float f, float f2) {
        if (this.f13110y == null) {
            return false;
        }
        AMS_RECT ams_rect = new AMS_RECT();
        float f3 = f - this.f13062E;
        float f4 = f2 - this.f13063F;
        switch (this.f13059B) {
            case 1:
                if (0.0f <= f3 && f3 < this.f13089d * 15.0f) {
                    f = this.f13062E + (this.f13089d * 15.0f);
                }
                if (this.f13089d * (-15.0f) < f3 && f3 < 0.0f) {
                    f = this.f13062E - (this.f13089d * 15.0f);
                }
                if (0.0f <= f4 && f4 < this.f13089d * 15.0f) {
                    f2 = this.f13063F + (this.f13089d * 15.0f);
                }
                if (this.f13089d * (-15.0f) < f4 && f4 < 0.0f) {
                    f2 = this.f13063F - (this.f13089d * 15.0f);
                }
                ams_rect.nLeft = (short) this.f13062E;
                ams_rect.nTop = (short) this.f13063F;
                ams_rect.nRight = (short) f;
                ams_rect.nBottom = (short) f2;
                if (f < this.f13062E) {
                    ams_rect.nLeft = (short) f;
                    ams_rect.nRight = (short) this.f13062E;
                }
                if (f2 < this.f13063F) {
                    ams_rect.nTop = (short) f2;
                    ams_rect.nBottom = (short) this.f13063F;
                }
                this.f13059B = 0;
                return mo12838a(ams_rect);
            case 3:
                this.f13059B = 2;
                int i = this.f13068K.getM_TRect().nRight - this.f13068K.getM_TRect().nLeft;
                int i2 = this.f13068K.getM_TRect().nBottom - this.f13068K.getM_TRect().nTop;
                ams_rect.nLeft = (short) (f - this.f13060C);
                ams_rect.nTop = (short) (f2 - this.f13061D);
                ams_rect.nRight = (short) ((i + f) - this.f13060C);
                ams_rect.nBottom = (short) ((i2 + f2) - this.f13061D);
                if (!this.f13066I) {
                    mo12830a(ams_rect.nLeft, ams_rect.nTop, ams_rect.nRight, ams_rect.nBottom, MotionEventCompat.ACTION_MASK);
                    break;
                } else {
                    this.f13066I = false;
                    return mo12144b(ams_rect);
                }
            case 4:
                this.f13059B = 2;
                if (0.0f <= f3 && f3 < this.f13089d * 15.0f) {
                    f = this.f13062E + (this.f13089d * 15.0f);
                }
                if (this.f13089d * (-15.0f) < f3 && f3 < 0.0f) {
                    f = this.f13062E - (this.f13089d * 15.0f);
                }
                if (0.0f <= f4 && f4 < this.f13089d * 15.0f) {
                    f2 = this.f13063F + (this.f13089d * 15.0f);
                }
                if (this.f13089d * (-15.0f) < f4 && f4 < 0.0f) {
                    f2 = this.f13063F - (this.f13089d * 15.0f);
                }
                if (!this.f13066I) {
                    mo12832a(f, f2, MotionEventCompat.ACTION_MASK);
                    break;
                } else {
                    this.f13066I = false;
                    ams_rect.nLeft = (short) this.f13062E;
                    ams_rect.nTop = (short) this.f13063F;
                    ams_rect.nRight = (short) f;
                    ams_rect.nBottom = (short) f2;
                    if (f < this.f13062E) {
                        ams_rect.nLeft = (short) f;
                        ams_rect.nRight = (short) this.f13062E;
                    }
                    if (f2 < this.f13063F) {
                        ams_rect.nTop = (short) f2;
                        ams_rect.nBottom = (short) this.f13063F;
                    }
                    return mo12144b(ams_rect);
                }
                break;
            case 5:
                this.f13059B = 2;
                if (!this.f13066I) {
                    mo12832a(f, f2, MotionEventCompat.ACTION_MASK);
                    break;
                } else {
                    this.f13066I = false;
                    ams_rect.nLeft = (short) this.f13062E;
                    ams_rect.nTop = (short) this.f13063F;
                    ams_rect.nRight = (short) f;
                    ams_rect.nBottom = (short) this.f13114ab;
                    if (f < this.f13062E) {
                        ams_rect.nLeft = (short) f;
                        ams_rect.nRight = (short) this.f13062E;
                    }
                    return mo12144b(ams_rect);
                }
            case 6:
                this.f13059B = 2;
                if (!this.f13066I) {
                    mo12832a(f, f2, MotionEventCompat.ACTION_MASK);
                    break;
                } else {
                    this.f13066I = false;
                    ams_rect.nLeft = (short) this.f13062E;
                    ams_rect.nTop = (short) this.f13063F;
                    ams_rect.nRight = (short) this.f13113aa;
                    ams_rect.nBottom = (short) f2;
                    if (f2 < this.f13063F) {
                        ams_rect.nTop = (short) f2;
                        ams_rect.nBottom = (short) this.f13063F;
                    }
                    return mo12144b(ams_rect);
                }
            case 7:
                m12844b(101, false);
                this.f13076S.mo12776a();
                break;
        }
        return false;
    }
}
