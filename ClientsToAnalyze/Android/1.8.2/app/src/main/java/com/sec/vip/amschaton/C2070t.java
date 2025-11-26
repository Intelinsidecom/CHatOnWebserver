package com.sec.vip.amschaton;

import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import com.sec.amsoma.structure.AMS_OBJECT_DATA;
import com.sec.amsoma.structure.AMS_RECT;
import com.sec.chaton.util.C1786r;
import twitter4j.MediaEntity;

/* compiled from: AMSObjectDrawings.java */
/* renamed from: com.sec.vip.amschaton.t */
/* loaded from: classes.dex */
public class C2070t extends C2068r {

    /* renamed from: V */
    private Paint f7418V;

    /* renamed from: W */
    private float f7419W;

    /* renamed from: X */
    private float f7420X;

    /* renamed from: Y */
    private final int f7421Y;

    /* renamed from: Z */
    private boolean f7422Z;

    /* renamed from: aa */
    private boolean f7423aa;

    public C2070t(int i, int i2, int i3, boolean z) {
        super(i, i2, i3);
        this.f7419W = 0.0f;
        this.f7420X = 0.0f;
        this.f7421Y = 10;
        this.f7422Z = false;
        this.f7423aa = false;
        this.f7423aa = z;
        if (this.f7423aa) {
            this.f7418V = new Paint();
            this.f7418V.setColor(this.f7393b);
            this.f7418V.setStrokeWidth(i3);
            this.f7418V.setAntiAlias(true);
            this.f7418V.setDither(true);
            this.f7418V.setStrokeCap(Paint.Cap.ROUND);
            this.f7418V.setStrokeJoin(Paint.Join.ROUND);
            switch (i) {
                case 0:
                case 1:
                case 2:
                case 6:
                    this.f7418V.setStyle(Paint.Style.STROKE);
                    break;
                case 3:
                case 4:
                case 5:
                case 7:
                    this.f7418V.setStyle(Paint.Style.FILL);
                    break;
                default:
                    this.f7418V.setStyle(Paint.Style.STROKE);
                    break;
            }
        }
    }

    @Override // com.sec.vip.amschaton.C2068r
    /* renamed from: a */
    public void mo7194a(float f) {
        super.mo7194a(f);
        if (this.f7418V != null) {
            this.f7418V.setStrokeWidth((float) ((this.f7394c * f) + 0.5d));
        }
    }

    @Override // com.sec.vip.amschaton.C2068r
    /* renamed from: a */
    public boolean mo7221a(AMS_RECT ams_rect) {
        if (!this.f7414w.VipAMS_EncodeNewDiagram(this.f7415x, ams_rect, (byte) this.f7392a, false)) {
            C1786r.m6054a("errocode = " + this.f7414w.VipAMS_GetErrorCode(this.f7415x), getClass().getSimpleName());
            mo7193a();
            return false;
        }
        mo7209a(ams_rect.nLeft, ams_rect.nTop, ams_rect.nRight, ams_rect.nBottom, MotionEventCompat.ACTION_MASK);
        return true;
    }

    @Override // com.sec.vip.amschaton.C2068r
    /* renamed from: a */
    public boolean mo7218a(int i, int i2, int i3) {
        super.mo7218a(i, i2, i3);
        if (this.f7418V == null) {
            return true;
        }
        if (this.f7374F && this.f7376H != null) {
            if (!this.f7414w.VipAMS_ChangeSelectDiagram(this.f7415x, this.f7376H, this.f7377I.getM_TRect(), (byte) this.f7392a, false)) {
                return false;
            }
            this.f7377I.setM_cStyle(i);
            this.f7418V.setColor(i2);
            this.f7418V.setStrokeWidth((float) ((this.f7394c * this.f7395d) + 0.5d));
            switch (i) {
                case 0:
                case 1:
                case 2:
                case 6:
                    this.f7418V.setStyle(Paint.Style.STROKE);
                    break;
                case 3:
                case 4:
                case 5:
                case 7:
                    this.f7418V.setStyle(Paint.Style.FILL);
                    break;
                default:
                    this.f7418V.setStyle(Paint.Style.STROKE);
                    break;
            }
            mo7209a(this.f7377I.getM_TRect().nLeft, this.f7377I.getM_TRect().nTop, this.f7377I.getM_TRect().nRight, this.f7377I.getM_TRect().nBottom, MotionEventCompat.ACTION_MASK);
        }
        return true;
    }

    @Override // com.sec.vip.amschaton.C2068r
    /* renamed from: b */
    public boolean mo7228b(AMS_RECT ams_rect) {
        if (!this.f7374F || this.f7376H == null || !this.f7414w.VipAMS_ChangeSelectDiagram(this.f7415x, this.f7376H, ams_rect, (byte) this.f7377I.getM_cStyle(), false)) {
            return false;
        }
        this.f7377I.setM_TRect(ams_rect);
        mo7209a(ams_rect.nLeft, ams_rect.nTop, ams_rect.nRight, ams_rect.nBottom, MotionEventCompat.ACTION_MASK);
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
        float f3;
        float f4;
        float f5;
        float f6 = this.f7371C;
        float f7 = this.f7372D;
        switch (this.f7417z) {
            case 5:
                f3 = this.f7420X;
                f4 = f;
                break;
            case 6:
                f3 = f2;
                f4 = this.f7419W;
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
        return mo7209a(f4, f5, f6, f7, i);
    }

    @Override // com.sec.vip.amschaton.C2068r
    /* renamed from: a */
    public boolean mo7209a(float f, float f2, float f3, float f4, int i) {
        return mo7210a(f, f2, f3, f4, i, true);
    }

    @Override // com.sec.vip.amschaton.C2068r
    /* renamed from: a */
    public boolean mo7210a(float f, float f2, float f3, float f4, int i, boolean z) {
        if (z) {
            this.f7396e.drawBitmap(this.f7398g, 0.0f, 0.0f, (Paint) null);
        }
        if (this.f7423aa) {
            RectF rectF = new RectF(f, f2, f3, f4);
            Path path = new Path();
            this.f7418V.setAlpha(i);
            switch (this.f7392a) {
                case 0:
                case 3:
                    this.f7396e.drawRect(rectF, this.f7418V);
                    break;
                case 1:
                case 4:
                    this.f7396e.drawRoundRect(rectF, (f3 - f) / 2.0f, (f4 - f2) / 2.0f, this.f7418V);
                    break;
                case 2:
                case 5:
                    path.moveTo(rectF.centerX(), f2);
                    path.lineTo(f, f4);
                    path.lineTo(f3, f4);
                    path.lineTo(rectF.centerX(), f2);
                    this.f7396e.drawPath(path, this.f7418V);
                    break;
                case 6:
                case 7:
                    path.moveTo(rectF.centerX(), f2);
                    path.lineTo(f, rectF.centerY());
                    path.lineTo(rectF.centerX(), f4);
                    path.lineTo(f3, rectF.centerY());
                    path.lineTo(rectF.centerX(), f2);
                    this.f7396e.drawPath(path, this.f7418V);
                    break;
                default:
                    this.f7396e.drawRect(rectF, this.f7418V);
                    break;
            }
            m7196a(f - ((this.f7394c * this.f7395d) / 2.0f), f2 - ((this.f7394c * this.f7395d) / 2.0f), ((this.f7394c * this.f7395d) / 2.0f) + f3, ((this.f7394c * this.f7395d) / 2.0f) + f4);
            return true;
        }
        if (this.f7379K != null) {
            this.f7379K.setBounds(new Rect(Math.round(f), Math.round(f2), Math.round(f3), Math.round(f4)));
            this.f7379K.draw(this.f7396e);
            return true;
        }
        return true;
    }

    @Override // com.sec.vip.amschaton.C2068r
    /* renamed from: c */
    public boolean mo7233c(float f, float f2) {
        return this.f7417z == 2 && new RectF(((float) this.f7377I.getM_TRect().nLeft) - (this.f7395d * 10.0f), ((float) this.f7377I.getM_TRect().nTop) - (this.f7395d * 10.0f), ((float) this.f7377I.getM_TRect().nRight) + (this.f7395d * 10.0f), ((float) this.f7377I.getM_TRect().nBottom) + (this.f7395d * 10.0f)).contains(f, f2);
    }

    @Override // com.sec.vip.amschaton.C2068r
    /* renamed from: d */
    public boolean mo7235d(float f, float f2) {
        boolean z;
        if (this.f7414w == null) {
            return false;
        }
        switch (this.f7417z) {
            case 0:
                if (!this.f7373E) {
                    this.f7373E = true;
                    return true;
                }
                this.f7417z = 1;
                mo7195a(f - 1.0f, f2 - 1.0f);
                mo7213a((15.0f * this.f7395d) + f, (15.0f * this.f7395d) + f2, MotionEventCompat.ACTION_MASK);
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
                    if (Math.abs(s - f) < this.f7395d * 10.0f && Math.abs(s2 - f2) < this.f7395d * 10.0f) {
                        this.f7371C = s3;
                        this.f7372D = s4;
                        this.f7417z = 4;
                        z = false;
                    } else if (Math.abs(s3 - f) < this.f7395d * 10.0f && Math.abs(s2 - f2) < this.f7395d * 10.0f) {
                        m7198a(MediaEntity.Size.CROP, true);
                        z = true;
                    } else if (Math.abs(s3 - f) < this.f7395d * 10.0f && Math.abs(s4 - f2) < this.f7395d * 10.0f) {
                        this.f7371C = s;
                        this.f7372D = s2;
                        this.f7417z = 4;
                        z = false;
                    } else if (Math.abs(s - f) < this.f7395d * 10.0f && Math.abs(s4 - f2) < this.f7395d * 10.0f) {
                        this.f7371C = s3;
                        this.f7372D = s2;
                        this.f7417z = 4;
                        z = false;
                    } else if (Math.abs(((s + s3) / 2) - f) < this.f7395d * 10.0f && Math.abs(s2 - f2) < this.f7395d * 10.0f) {
                        this.f7371C = s;
                        this.f7372D = s4;
                        this.f7419W = s3;
                        this.f7420X = s4;
                        this.f7417z = 6;
                        z = false;
                    } else if (Math.abs(s3 - f) < this.f7395d * 10.0f && Math.abs(((s2 + s4) / 2) - f2) < this.f7395d * 10.0f) {
                        this.f7371C = s;
                        this.f7372D = s2;
                        this.f7419W = s;
                        this.f7420X = s4;
                        this.f7417z = 5;
                        z = false;
                    } else if (Math.abs(((s + s3) / 2) - f) >= this.f7395d * 10.0f || Math.abs(s4 - f2) >= this.f7395d * 10.0f) {
                        if (Math.abs(s - f) < this.f7395d * 10.0f && Math.abs(((s2 + s4) / 2) - f2) < this.f7395d * 10.0f) {
                            this.f7371C = s3;
                            this.f7372D = s2;
                            this.f7419W = s3;
                            this.f7420X = s4;
                            this.f7417z = 5;
                        }
                        z = false;
                    } else {
                        this.f7371C = s;
                        this.f7372D = s2;
                        this.f7419W = s3;
                        this.f7420X = s2;
                        this.f7417z = 6;
                        z = false;
                    }
                } else {
                    z = false;
                }
                this.f7375G = false;
                if (this.f7417z == 4 || this.f7417z == 5 || this.f7417z == 6) {
                    mo7213a(f, f2, AccessibilityEventCompat.TYPE_VIEW_HOVER_ENTER);
                    return true;
                }
                if (this.f7377I == null) {
                    this.f7377I = new AMS_OBJECT_DATA();
                    this.f7414w.VipAMS_GetSelectObjectData(this.f7376H.getM_pSelectObjectData(), this.f7377I);
                    this.f7422Z = false;
                }
                if (this.f7422Z && z) {
                    this.f7417z = 7;
                    return true;
                }
                this.f7369A = (int) (f - this.f7377I.getM_TRect().nLeft);
                this.f7370B = (int) (f2 - this.f7377I.getM_TRect().nTop);
                this.f7417z = 3;
                mo7209a(this.f7377I.getM_TRect().nLeft, this.f7377I.getM_TRect().nTop, this.f7377I.getM_TRect().nRight, this.f7377I.getM_TRect().nBottom, AccessibilityEventCompat.TYPE_VIEW_HOVER_ENTER);
                this.f7422Z = true;
                return true;
        }
    }

    @Override // com.sec.vip.amschaton.C2068r
    /* renamed from: e */
    public boolean mo7237e(float f, float f2) {
        if (this.f7414w == null) {
            return false;
        }
        switch (this.f7417z) {
            case 1:
            case 4:
            case 5:
            case 6:
                float f3 = f - this.f7371C;
                float f4 = f2 - this.f7372D;
                if (0.0f <= f3 && f3 < this.f7395d * 15.0f) {
                    f = this.f7371C + (this.f7395d * 15.0f);
                }
                if (this.f7395d * (-15.0f) < f3 && f3 < 0.0f) {
                    f = this.f7371C - (this.f7395d * 15.0f);
                }
                if (0.0f <= f4 && f4 < this.f7395d * 15.0f) {
                    f2 = this.f7372D + (this.f7395d * 15.0f);
                }
                if (this.f7395d * (-15.0f) < f4 && f4 < 0.0f) {
                    f2 = this.f7372D - (this.f7395d * 15.0f);
                }
                mo7213a(f, f2, AccessibilityEventCompat.TYPE_VIEW_HOVER_ENTER);
                if (this.f7374F) {
                    this.f7375G = true;
                    break;
                }
                break;
            case 3:
                mo7209a(f - this.f7369A, f2 - this.f7370B, ((this.f7377I.getM_TRect().nRight - this.f7377I.getM_TRect().nLeft) + f) - this.f7369A, ((this.f7377I.getM_TRect().nBottom - this.f7377I.getM_TRect().nTop) + f2) - this.f7370B, AccessibilityEventCompat.TYPE_VIEW_HOVER_ENTER);
                if (this.f7374F) {
                    this.f7375G = true;
                    break;
                }
                break;
            case 7:
                if (!(Math.abs(((float) this.f7377I.getM_TRect().nRight) - f) < 10.0f * this.f7395d && Math.abs(((float) this.f7377I.getM_TRect().nTop) - f2) < 10.0f * this.f7395d)) {
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
        AMS_RECT ams_rect = new AMS_RECT();
        float f3 = f - this.f7371C;
        float f4 = f2 - this.f7372D;
        switch (this.f7417z) {
            case 1:
                if (0.0f <= f3 && f3 < this.f7395d * 15.0f) {
                    f = this.f7371C + (this.f7395d * 15.0f);
                }
                if (this.f7395d * (-15.0f) < f3 && f3 < 0.0f) {
                    f = this.f7371C - (this.f7395d * 15.0f);
                }
                if (0.0f <= f4 && f4 < this.f7395d * 15.0f) {
                    f2 = this.f7372D + (this.f7395d * 15.0f);
                }
                if (this.f7395d * (-15.0f) < f4 && f4 < 0.0f) {
                    f2 = this.f7372D - (this.f7395d * 15.0f);
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
                this.f7417z = 2;
                if (0.0f <= f3 && f3 < this.f7395d * 15.0f) {
                    f = this.f7371C + (this.f7395d * 15.0f);
                }
                if (this.f7395d * (-15.0f) < f3 && f3 < 0.0f) {
                    f = this.f7371C - (this.f7395d * 15.0f);
                }
                if (0.0f <= f4 && f4 < this.f7395d * 15.0f) {
                    f2 = this.f7372D + (this.f7395d * 15.0f);
                }
                if (this.f7395d * (-15.0f) < f4 && f4 < 0.0f) {
                    f2 = this.f7372D - (this.f7395d * 15.0f);
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
                break;
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
                    ams_rect.nBottom = (short) this.f7420X;
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
                    ams_rect.nRight = (short) this.f7419W;
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
}
