package com.sec.vip.amschaton;

import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.v4.view.MotionEventCompat;
import com.sec.amsoma.structure.AMS_OBJECT_DATA;
import com.sec.amsoma.structure.AMS_RECT;
import com.sec.chaton.util.C1341p;

/* compiled from: AMSObjectDrawings.java */
/* renamed from: com.sec.vip.amschaton.aq */
/* loaded from: classes.dex */
public class C1380aq extends C1468i {

    /* renamed from: V */
    private float f4831V;

    /* renamed from: W */
    private final int f4832W;

    /* renamed from: X */
    private boolean f4833X;

    /* renamed from: Y */
    private boolean f4834Y;

    /* renamed from: a */
    private Paint f4835a;

    /* renamed from: b */
    private float f4836b;

    public C1380aq(int i, int i2, int i3, boolean z) {
        super(i, i2, i3);
        this.f4836b = 0.0f;
        this.f4831V = 0.0f;
        this.f4832W = 10;
        this.f4833X = false;
        this.f4834Y = false;
        this.f4834Y = z;
        if (this.f4834Y) {
            this.f4835a = new Paint();
            this.f4835a.setColor(this.f5146d);
            this.f4835a.setStrokeWidth(i3);
            this.f4835a.setAntiAlias(true);
            this.f4835a.setDither(true);
            this.f4835a.setStrokeCap(Paint.Cap.ROUND);
            this.f4835a.setStrokeJoin(Paint.Join.ROUND);
            switch (i) {
                case 0:
                case 1:
                case 2:
                case 6:
                    this.f4835a.setStyle(Paint.Style.STROKE);
                    break;
                case 3:
                case 4:
                case 5:
                case 7:
                    this.f4835a.setStyle(Paint.Style.FILL);
                    break;
                default:
                    this.f4835a.setStyle(Paint.Style.STROKE);
                    break;
            }
        }
    }

    @Override // com.sec.vip.amschaton.C1468i
    /* renamed from: a */
    public void mo4887a(float f) {
        super.mo4887a(f);
        if (this.f4835a != null) {
            this.f4835a.setStrokeWidth((float) ((this.f5147e * f) + 0.5d));
        }
    }

    @Override // com.sec.vip.amschaton.C1468i
    /* renamed from: b */
    public boolean mo4948b(AMS_RECT ams_rect) {
        if (!this.f5167y.VipAMS_EncodeNewDiagram(this.f5168z, ams_rect, (byte) this.f5145c, false)) {
            C1341p.m4651a("errocode = " + this.f5167y.VipAMS_GetErrorCode(this.f5168z), getClass().getSimpleName());
            mo4886a();
            return false;
        }
        mo4888a(ams_rect.nLeft, ams_rect.nTop, ams_rect.nRight, ams_rect.nBottom, MotionEventCompat.ACTION_MASK);
        return true;
    }

    @Override // com.sec.vip.amschaton.C1468i
    /* renamed from: a */
    public boolean mo4946a(int i, int i2, int i3) {
        super.mo4946a(i, i2, i3);
        if (this.f4835a == null) {
            return true;
        }
        if (this.f5129H && this.f5131J != null) {
            if (!this.f5167y.VipAMS_ChangeSelectDiagram(this.f5168z, this.f5131J, this.f5132K.getM_TRect(), (byte) this.f5145c, false)) {
                return false;
            }
            this.f5132K.setM_cStyle(i);
            this.f4835a.setColor(i2);
            this.f4835a.setStrokeWidth((float) ((this.f5147e * this.f5148f) + 0.5d));
            switch (i) {
                case 0:
                case 1:
                case 2:
                case 6:
                    this.f4835a.setStyle(Paint.Style.STROKE);
                    break;
                case 3:
                case 4:
                case 5:
                case 7:
                    this.f4835a.setStyle(Paint.Style.FILL);
                    break;
                default:
                    this.f4835a.setStyle(Paint.Style.STROKE);
                    break;
            }
            mo4888a(this.f5132K.getM_TRect().nLeft, this.f5132K.getM_TRect().nTop, this.f5132K.getM_TRect().nRight, this.f5132K.getM_TRect().nBottom, MotionEventCompat.ACTION_MASK);
        }
        return true;
    }

    @Override // com.sec.vip.amschaton.C1468i
    /* renamed from: a */
    public boolean mo4947a(AMS_RECT ams_rect) {
        if (!this.f5129H || this.f5131J == null || !this.f5167y.VipAMS_ChangeSelectDiagram(this.f5168z, this.f5131J, ams_rect, (byte) this.f5132K.getM_cStyle(), false)) {
            return false;
        }
        this.f5132K.setM_TRect(ams_rect);
        mo4888a(ams_rect.nLeft, ams_rect.nTop, ams_rect.nRight, ams_rect.nBottom, MotionEventCompat.ACTION_MASK);
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
        float f3;
        float f4;
        float f5;
        float f6 = this.f5126E;
        float f7 = this.f5127F;
        switch (this.f5123B) {
            case 5:
                f3 = this.f4831V;
                f4 = f;
                break;
            case 6:
                f3 = f2;
                f4 = this.f4836b;
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
        return mo4888a(f4, f5, f6, f7, i);
    }

    @Override // com.sec.vip.amschaton.C1468i
    /* renamed from: a */
    public boolean mo4888a(float f, float f2, float f3, float f4, int i) {
        return mo4945a(f, f2, f3, f4, i, true);
    }

    @Override // com.sec.vip.amschaton.C1468i
    /* renamed from: a */
    public boolean mo4945a(float f, float f2, float f3, float f4, int i, boolean z) {
        if (z) {
            this.f5149g.drawBitmap(this.f5151i, 0.0f, 0.0f, (Paint) null);
        }
        if (this.f4834Y) {
            RectF rectF = new RectF(f, f2, f3, f4);
            Path path = new Path();
            this.f4835a.setAlpha(i);
            switch (this.f5145c) {
                case 0:
                case 3:
                    this.f5149g.drawRect(rectF, this.f4835a);
                    break;
                case 1:
                case 4:
                    this.f5149g.drawRoundRect(rectF, (f3 - f) / 2.0f, (f4 - f2) / 2.0f, this.f4835a);
                    break;
                case 2:
                case 5:
                    path.moveTo(rectF.centerX(), f2);
                    path.lineTo(f, f4);
                    path.lineTo(f3, f4);
                    path.lineTo(rectF.centerX(), f2);
                    this.f5149g.drawPath(path, this.f4835a);
                    break;
                case 6:
                case 7:
                    path.moveTo(rectF.centerX(), f2);
                    path.lineTo(f, rectF.centerY());
                    path.lineTo(rectF.centerX(), f4);
                    path.lineTo(f3, rectF.centerY());
                    path.lineTo(rectF.centerX(), f2);
                    this.f5149g.drawPath(path, this.f4835a);
                    break;
                default:
                    this.f5149g.drawRect(rectF, this.f4835a);
                    break;
            }
            m5284a(f - ((this.f5147e * this.f5148f) / 2.0f), f2 - ((this.f5147e * this.f5148f) / 2.0f), ((this.f5147e * this.f5148f) / 2.0f) + f3, ((this.f5147e * this.f5148f) / 2.0f) + f4);
            return true;
        }
        if (this.f5134M != null) {
            this.f5134M.setBounds(new Rect(Math.round(f), Math.round(f2), Math.round(f3), Math.round(f4)));
            this.f5134M.draw(this.f5149g);
            return true;
        }
        return true;
    }

    @Override // com.sec.vip.amschaton.C1468i
    /* renamed from: a */
    public boolean mo4944a(float f, float f2) {
        return this.f5123B == 2 && new RectF(((float) this.f5132K.getM_TRect().nLeft) - (this.f5148f * 10.0f), ((float) this.f5132K.getM_TRect().nTop) - (this.f5148f * 10.0f), ((float) this.f5132K.getM_TRect().nRight) + (this.f5148f * 10.0f), ((float) this.f5132K.getM_TRect().nBottom) + (this.f5148f * 10.0f)).contains(f, f2);
    }

    @Override // com.sec.vip.amschaton.C1468i
    /* renamed from: b */
    public boolean mo4893b(float f, float f2) {
        boolean z;
        if (this.f5167y == null) {
            return false;
        }
        switch (this.f5123B) {
            case 0:
                if (!this.f5128G) {
                    this.f5128G = true;
                    return true;
                }
                this.f5123B = 1;
                mo4897e(f - 1.0f, f2 - 1.0f);
                mo4889a((15.0f * this.f5148f) + f, (15.0f * this.f5148f) + f2, MotionEventCompat.ACTION_MASK);
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
                    if (Math.abs(s - f) < this.f5148f * 10.0f && Math.abs(s2 - f2) < this.f5148f * 10.0f) {
                        this.f5126E = s3;
                        this.f5127F = s4;
                        this.f5123B = 4;
                        z = false;
                    } else if (Math.abs(s3 - f) < this.f5148f * 10.0f && Math.abs(s2 - f2) < this.f5148f * 10.0f) {
                        m5286a(101, true);
                        z = true;
                    } else if (Math.abs(s3 - f) < this.f5148f * 10.0f && Math.abs(s4 - f2) < this.f5148f * 10.0f) {
                        this.f5126E = s;
                        this.f5127F = s2;
                        this.f5123B = 4;
                        z = false;
                    } else if (Math.abs(s - f) < this.f5148f * 10.0f && Math.abs(s4 - f2) < this.f5148f * 10.0f) {
                        this.f5126E = s3;
                        this.f5127F = s2;
                        this.f5123B = 4;
                        z = false;
                    } else if (Math.abs(((s + s3) / 2) - f) < this.f5148f * 10.0f && Math.abs(s2 - f2) < this.f5148f * 10.0f) {
                        this.f5126E = s;
                        this.f5127F = s4;
                        this.f4836b = s3;
                        this.f4831V = s4;
                        this.f5123B = 6;
                        z = false;
                    } else if (Math.abs(s3 - f) < this.f5148f * 10.0f && Math.abs(((s2 + s4) / 2) - f2) < this.f5148f * 10.0f) {
                        this.f5126E = s;
                        this.f5127F = s2;
                        this.f4836b = s;
                        this.f4831V = s4;
                        this.f5123B = 5;
                        z = false;
                    } else if (Math.abs(((s + s3) / 2) - f) >= this.f5148f * 10.0f || Math.abs(s4 - f2) >= this.f5148f * 10.0f) {
                        if (Math.abs(s - f) < this.f5148f * 10.0f && Math.abs(((s2 + s4) / 2) - f2) < this.f5148f * 10.0f) {
                            this.f5126E = s3;
                            this.f5127F = s2;
                            this.f4836b = s3;
                            this.f4831V = s4;
                            this.f5123B = 5;
                        }
                        z = false;
                    } else {
                        this.f5126E = s;
                        this.f5127F = s2;
                        this.f4836b = s3;
                        this.f4831V = s2;
                        this.f5123B = 6;
                        z = false;
                    }
                } else {
                    z = false;
                }
                this.f5130I = false;
                if (this.f5123B == 4 || this.f5123B == 5 || this.f5123B == 6) {
                    mo4889a(f, f2, 128);
                    return true;
                }
                if (this.f5132K == null) {
                    this.f5132K = new AMS_OBJECT_DATA();
                    this.f5167y.VipAMS_GetSelectObjectData(this.f5131J.getM_pSelectObjectData(), this.f5132K);
                    this.f4833X = false;
                }
                if (this.f4833X && z) {
                    this.f5123B = 7;
                    return true;
                }
                this.f5124C = (int) (f - this.f5132K.getM_TRect().nLeft);
                this.f5125D = (int) (f2 - this.f5132K.getM_TRect().nTop);
                this.f5123B = 3;
                mo4888a(this.f5132K.getM_TRect().nLeft, this.f5132K.getM_TRect().nTop, this.f5132K.getM_TRect().nRight, this.f5132K.getM_TRect().nBottom, 128);
                this.f4833X = true;
                return true;
        }
    }

    @Override // com.sec.vip.amschaton.C1468i
    /* renamed from: c */
    public boolean mo4895c(float f, float f2) {
        if (this.f5167y == null) {
            return false;
        }
        switch (this.f5123B) {
            case 1:
            case 4:
            case 5:
            case 6:
                float f3 = f - this.f5126E;
                float f4 = f2 - this.f5127F;
                if (0.0f <= f3 && f3 < this.f5148f * 15.0f) {
                    f = this.f5126E + (this.f5148f * 15.0f);
                }
                if (this.f5148f * (-15.0f) < f3 && f3 < 0.0f) {
                    f = this.f5126E - (this.f5148f * 15.0f);
                }
                if (0.0f <= f4 && f4 < this.f5148f * 15.0f) {
                    f2 = this.f5127F + (this.f5148f * 15.0f);
                }
                if (this.f5148f * (-15.0f) < f4 && f4 < 0.0f) {
                    f2 = this.f5127F - (this.f5148f * 15.0f);
                }
                mo4889a(f, f2, 128);
                if (this.f5129H) {
                    this.f5130I = true;
                    break;
                }
                break;
            case 3:
                mo4888a(f - this.f5124C, f2 - this.f5125D, ((this.f5132K.getM_TRect().nRight - this.f5132K.getM_TRect().nLeft) + f) - this.f5124C, ((this.f5132K.getM_TRect().nBottom - this.f5132K.getM_TRect().nTop) + f2) - this.f5125D, 128);
                if (this.f5129H) {
                    this.f5130I = true;
                    break;
                }
                break;
            case 7:
                if (!(Math.abs(((float) this.f5132K.getM_TRect().nRight) - f) < 10.0f * this.f5148f && Math.abs(((float) this.f5132K.getM_TRect().nTop) - f2) < 10.0f * this.f5148f)) {
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
        AMS_RECT ams_rect = new AMS_RECT();
        float f3 = f - this.f5126E;
        float f4 = f2 - this.f5127F;
        switch (this.f5123B) {
            case 1:
                if (0.0f <= f3 && f3 < this.f5148f * 15.0f) {
                    f = this.f5126E + (this.f5148f * 15.0f);
                }
                if (this.f5148f * (-15.0f) < f3 && f3 < 0.0f) {
                    f = this.f5126E - (this.f5148f * 15.0f);
                }
                if (0.0f <= f4 && f4 < this.f5148f * 15.0f) {
                    f2 = this.f5127F + (this.f5148f * 15.0f);
                }
                if (this.f5148f * (-15.0f) < f4 && f4 < 0.0f) {
                    f2 = this.f5127F - (this.f5148f * 15.0f);
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
                this.f5123B = 2;
                if (0.0f <= f3 && f3 < this.f5148f * 15.0f) {
                    f = this.f5126E + (this.f5148f * 15.0f);
                }
                if (this.f5148f * (-15.0f) < f3 && f3 < 0.0f) {
                    f = this.f5126E - (this.f5148f * 15.0f);
                }
                if (0.0f <= f4 && f4 < this.f5148f * 15.0f) {
                    f2 = this.f5127F + (this.f5148f * 15.0f);
                }
                if (this.f5148f * (-15.0f) < f4 && f4 < 0.0f) {
                    f2 = this.f5127F - (this.f5148f * 15.0f);
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
                break;
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
                    ams_rect.nBottom = (short) this.f4831V;
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
                    ams_rect.nRight = (short) this.f4836b;
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
}
