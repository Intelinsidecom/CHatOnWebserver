package com.sec.vip.amschaton;

import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.sec.amsoma.structure.AMS_OBJECT_DATA;
import com.sec.amsoma.structure.AMS_RECT;
import com.sec.chaton.util.ChatONLogWriter;

/* loaded from: classes.dex */
public class AMSObjectDrawings extends AMSObject {

    /* renamed from: D */
    private final int f3987D;

    /* renamed from: E */
    private Paint f3988E;

    /* renamed from: F */
    private float f3989F;

    /* renamed from: G */
    private float f3990G;

    public AMSObjectDrawings(int i, int i2, int i3) {
        super(i, i2, i3);
        this.f3987D = 10;
        this.f3989F = 0.0f;
        this.f3990G = 0.0f;
        this.f3988E = new Paint();
        this.f3988E.setColor(this.f3963b);
        this.f3988E.setStrokeWidth(i3);
        this.f3988E.setAntiAlias(true);
        this.f3988E.setDither(true);
        this.f3988E.setStrokeCap(Paint.Cap.ROUND);
        this.f3988E.setStrokeJoin(Paint.Join.ROUND);
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 6:
                this.f3988E.setStyle(Paint.Style.STROKE);
                break;
            case 3:
            case 4:
            case 5:
            case 7:
                this.f3988E.setStyle(Paint.Style.FILL);
                break;
            default:
                this.f3988E.setStyle(Paint.Style.STROKE);
                break;
        }
    }

    @Override // com.sec.vip.amschaton.AMSObject
    /* renamed from: a */
    public void mo3954a(float f) {
        super.mo3954a(f);
        this.f3988E.setStrokeWidth((float) ((this.f3964c * f) + 0.5d));
    }

    @Override // com.sec.vip.amschaton.AMSObject
    /* renamed from: a */
    public void mo3955a(float f, float f2) {
        this.f3982v = f;
        this.f3983w = f2;
    }

    @Override // com.sec.vip.amschaton.AMSObject
    /* renamed from: a */
    public boolean mo3963a(float f, float f2, float f3, float f4, int i) {
        this.f3966e.drawBitmap(this.f3968g, 0.0f, 0.0f, (Paint) null);
        RectF rectF = new RectF(f, f2, f3, f4);
        Path path = new Path();
        this.f3988E.setAlpha(i);
        switch (this.f3962a) {
            case 0:
            case 3:
                this.f3966e.drawRect(rectF, this.f3988E);
                break;
            case 1:
            case 4:
                this.f3966e.drawRoundRect(rectF, (f3 - f) / 2.0f, (f4 - f2) / 2.0f, this.f3988E);
                break;
            case 2:
            case 5:
                path.moveTo(rectF.centerX(), f2);
                path.lineTo(f, f4);
                path.lineTo(f3, f4);
                path.lineTo(rectF.centerX(), f2);
                this.f3966e.drawPath(path, this.f3988E);
                break;
            case 6:
            case 7:
                path.moveTo(rectF.centerX(), f2);
                path.lineTo(f, rectF.centerY());
                path.lineTo(rectF.centerX(), f4);
                path.lineTo(f3, rectF.centerY());
                path.lineTo(rectF.centerX(), f2);
                this.f3966e.drawPath(path, this.f3988E);
                break;
            default:
                this.f3966e.drawRect(rectF, this.f3988E);
                break;
        }
        m3956a(f - ((this.f3964c * this.f3965d) / 2.0f), f2 - ((this.f3964c * this.f3965d) / 2.0f), ((this.f3964c * this.f3965d) / 2.0f) + f3, ((this.f3964c * this.f3965d) / 2.0f) + f4);
        return true;
    }

    @Override // com.sec.vip.amschaton.AMSObject
    /* renamed from: a */
    public boolean mo3964a(float f, float f2, int i) {
        float f3;
        float f4;
        float f5;
        float f6 = this.f3982v;
        float f7 = this.f3983w;
        switch (this.f3979s) {
            case 5:
                f4 = this.f3990G;
                f3 = f;
                break;
            case 6:
                f3 = this.f3989F;
                f4 = f2;
                break;
            default:
                f4 = f2;
                f3 = f;
                break;
        }
        if (f6 > f3) {
            f5 = f6;
        } else {
            f5 = f3;
            f3 = f6;
        }
        if (f7 > f4) {
            f7 = f4;
            f4 = f7;
        }
        return mo3963a(f3, f7, f5, f4, i);
    }

    @Override // com.sec.vip.amschaton.AMSObject
    /* renamed from: a */
    public boolean mo3966a(int i, int i2, int i3) {
        super.mo3966a(i, i2, i3);
        if (this.f3985y && this.f3959A != null) {
            if (!this.f3976p.VipAMS_ChangeSelectDiagram(this.f3977q, this.f3978r, this.f3959A, this.f3960B.getM_TRect(), (byte) this.f3962a, false)) {
                return false;
            }
            this.f3960B.setM_cStyle(i);
            this.f3988E.setColor(i2);
            this.f3988E.setStrokeWidth((float) ((this.f3964c * this.f3965d) + 0.5d));
            switch (i) {
                case 0:
                case 1:
                case 2:
                case 6:
                    this.f3988E.setStyle(Paint.Style.STROKE);
                    break;
                case 3:
                case 4:
                case 5:
                case 7:
                    this.f3988E.setStyle(Paint.Style.FILL);
                    break;
                default:
                    this.f3988E.setStyle(Paint.Style.STROKE);
                    break;
            }
            mo3963a(this.f3960B.getM_TRect().nLeft, this.f3960B.getM_TRect().nTop, this.f3960B.getM_TRect().nRight, this.f3960B.getM_TRect().nBottom, 255);
        }
        return true;
    }

    @Override // com.sec.vip.amschaton.AMSObject
    /* renamed from: a */
    public boolean mo3967a(AMS_RECT ams_rect) {
        if (this.f3976p.VipAMS_EncodeNewDiagram(this.f3977q, this.f3978r, ams_rect, (byte) this.f3962a, false)) {
            mo3963a(ams_rect.nLeft, ams_rect.nTop, ams_rect.nRight, ams_rect.nBottom, 255);
            return true;
        }
        ChatONLogWriter.m3499a("errocode = " + this.f3976p.VipAMS_GetErrorCode(this.f3977q), getClass().getSimpleName());
        mo3953a();
        return false;
    }

    @Override // com.sec.vip.amschaton.AMSObject
    /* renamed from: b */
    public boolean mo3972b(AMS_RECT ams_rect) {
        if (!this.f3985y || this.f3959A == null) {
            return false;
        }
        if (!this.f3976p.VipAMS_ChangeSelectDiagram(this.f3977q, this.f3978r, this.f3959A, ams_rect, (byte) this.f3960B.getM_cStyle(), false)) {
            return false;
        }
        this.f3960B.setM_TRect(ams_rect);
        mo3963a(ams_rect.nLeft, ams_rect.nTop, ams_rect.nRight, ams_rect.nBottom, 255);
        return true;
    }

    @Override // com.sec.vip.amschaton.AMSObject
    /* renamed from: c */
    public boolean mo3974c(float f, float f2) {
        return this.f3979s == 2 && new RectF(((float) this.f3960B.getM_TRect().nLeft) - (this.f3965d * 10.0f), ((float) this.f3960B.getM_TRect().nTop) - (this.f3965d * 10.0f), ((float) this.f3960B.getM_TRect().nRight) + (this.f3965d * 10.0f), ((float) this.f3960B.getM_TRect().nBottom) + (this.f3965d * 10.0f)).contains(f, f2);
    }

    @Override // com.sec.vip.amschaton.AMSObject
    /* renamed from: d */
    public boolean mo3976d(float f, float f2) {
        if (this.f3976p == null) {
            return false;
        }
        switch (this.f3979s) {
            case 0:
                if (!this.f3984x) {
                    this.f3984x = true;
                    return true;
                }
                this.f3979s = 1;
                mo3955a(f - 1.0f, f2 - 1.0f);
                mo3964a(f, f2, 255);
                this.f3982v = (int) (f - 1.0f);
                this.f3983w = (int) (f2 - 1.0f);
                break;
            case 2:
                if (this.f3959A != null) {
                    if (this.f3960B != null) {
                        short s = this.f3960B.getM_TRect().nLeft;
                        short s2 = this.f3960B.getM_TRect().nTop;
                        short s3 = this.f3960B.getM_TRect().nRight;
                        short s4 = this.f3960B.getM_TRect().nBottom;
                        if (Math.abs(s - f) < this.f3965d * 10.0f && Math.abs(s2 - f2) < this.f3965d * 10.0f) {
                            this.f3982v = s3;
                            this.f3983w = s4;
                            this.f3979s = 4;
                        } else if (Math.abs(s3 - f) < this.f3965d * 10.0f && Math.abs(s2 - f2) < this.f3965d * 10.0f) {
                            this.f3982v = s;
                            this.f3983w = s4;
                            this.f3979s = 4;
                        } else if (Math.abs(s3 - f) < this.f3965d * 10.0f && Math.abs(s4 - f2) < this.f3965d * 10.0f) {
                            this.f3982v = s;
                            this.f3983w = s2;
                            this.f3979s = 4;
                        } else if (Math.abs(s - f) < this.f3965d * 10.0f && Math.abs(s4 - f2) < this.f3965d * 10.0f) {
                            this.f3982v = s3;
                            this.f3983w = s2;
                            this.f3979s = 4;
                        } else if (Math.abs(((s + s3) / 2) - f) < this.f3965d * 10.0f && Math.abs(s2 - f2) < this.f3965d * 10.0f) {
                            this.f3982v = s;
                            this.f3983w = s4;
                            this.f3989F = s3;
                            this.f3990G = s4;
                            this.f3979s = 6;
                        } else if (Math.abs(s3 - f) < this.f3965d * 10.0f && Math.abs(((s2 + s4) / 2) - f2) < this.f3965d * 10.0f) {
                            this.f3982v = s;
                            this.f3983w = s2;
                            this.f3989F = s;
                            this.f3990G = s4;
                            this.f3979s = 5;
                        } else if (Math.abs(((s + s3) / 2) - f) < this.f3965d * 10.0f && Math.abs(s4 - f2) < this.f3965d * 10.0f) {
                            this.f3982v = s;
                            this.f3983w = s2;
                            this.f3989F = s3;
                            this.f3990G = s2;
                            this.f3979s = 6;
                        } else if (Math.abs(s - f) < this.f3965d * 10.0f && Math.abs(((s2 + s4) / 2) - f2) < this.f3965d * 10.0f) {
                            this.f3982v = s3;
                            this.f3983w = s2;
                            this.f3989F = s3;
                            this.f3990G = s4;
                            this.f3979s = 5;
                        }
                    }
                    this.f3986z = false;
                    if (this.f3979s != 4 && this.f3979s != 5 && this.f3979s != 6) {
                        if (this.f3960B == null) {
                            this.f3960B = new AMS_OBJECT_DATA();
                            this.f3976p.VipAMS_GetSelectObjectData(this.f3959A.getM_pSelectObjectData(), this.f3960B);
                        }
                        this.f3980t = (int) (f - this.f3960B.getM_TRect().nLeft);
                        this.f3981u = (int) (f2 - this.f3960B.getM_TRect().nTop);
                        this.f3979s = 3;
                        mo3963a(this.f3960B.getM_TRect().nLeft, this.f3960B.getM_TRect().nTop, this.f3960B.getM_TRect().nRight, this.f3960B.getM_TRect().nBottom, 128);
                        break;
                    } else {
                        mo3964a(f, f2, 128);
                        break;
                    }
                } else {
                    ChatONLogWriter.m3499a("Why is selected object null???", getClass().getSimpleName());
                    this.f3979s = 0;
                    return true;
                }
                break;
        }
        return true;
    }

    @Override // com.sec.vip.amschaton.AMSObject
    /* renamed from: e */
    public boolean mo3977e(float f, float f2) {
        if (this.f3976p == null) {
            return false;
        }
        switch (this.f3979s) {
            case 1:
            case 4:
            case 5:
            case 6:
                mo3964a(f, f2, 128);
                if (this.f3985y) {
                    this.f3986z = true;
                    break;
                }
                break;
            case 3:
                mo3963a(f - this.f3980t, f2 - this.f3981u, ((this.f3960B.getM_TRect().nRight - this.f3960B.getM_TRect().nLeft) + f) - this.f3980t, ((this.f3960B.getM_TRect().nBottom - this.f3960B.getM_TRect().nTop) + f2) - this.f3981u, 128);
                if (this.f3985y) {
                    this.f3986z = true;
                    break;
                }
                break;
        }
        return true;
    }

    @Override // com.sec.vip.amschaton.AMSObject
    /* renamed from: f */
    public boolean mo3978f(float f, float f2) {
        if (this.f3976p == null) {
            return false;
        }
        AMS_RECT ams_rect = new AMS_RECT();
        switch (this.f3979s) {
            case 1:
                ams_rect.nLeft = (short) this.f3982v;
                ams_rect.nTop = (short) this.f3983w;
                ams_rect.nRight = (short) f;
                ams_rect.nBottom = (short) f2;
                if (f < this.f3982v) {
                    ams_rect.nLeft = (short) f;
                    ams_rect.nRight = (short) this.f3982v;
                }
                if (f2 < this.f3983w) {
                    ams_rect.nTop = (short) f2;
                    ams_rect.nBottom = (short) this.f3983w;
                }
                this.f3979s = 0;
                return mo3967a(ams_rect);
            case 3:
                this.f3979s = 2;
                int i = this.f3960B.getM_TRect().nRight - this.f3960B.getM_TRect().nLeft;
                int i2 = this.f3960B.getM_TRect().nBottom - this.f3960B.getM_TRect().nTop;
                ams_rect.nLeft = (short) (f - this.f3980t);
                ams_rect.nTop = (short) (f2 - this.f3981u);
                ams_rect.nRight = (short) ((i + f) - this.f3980t);
                ams_rect.nBottom = (short) ((i2 + f2) - this.f3981u);
                if (!this.f3986z) {
                    mo3963a(ams_rect.nLeft, ams_rect.nTop, ams_rect.nRight, ams_rect.nBottom, 255);
                    break;
                } else {
                    this.f3986z = false;
                    return mo3972b(ams_rect);
                }
            case 4:
                this.f3979s = 2;
                if (!this.f3986z) {
                    mo3964a(f, f2, 255);
                    break;
                } else {
                    this.f3986z = false;
                    ams_rect.nLeft = (short) this.f3982v;
                    ams_rect.nTop = (short) this.f3983w;
                    ams_rect.nRight = (short) f;
                    ams_rect.nBottom = (short) f2;
                    if (f < this.f3982v) {
                        ams_rect.nLeft = (short) f;
                        ams_rect.nRight = (short) this.f3982v;
                    }
                    if (f2 < this.f3983w) {
                        ams_rect.nTop = (short) f2;
                        ams_rect.nBottom = (short) this.f3983w;
                    }
                    return mo3972b(ams_rect);
                }
            case 5:
                this.f3979s = 2;
                if (!this.f3986z) {
                    mo3964a(f, f2, 255);
                    break;
                } else {
                    this.f3986z = false;
                    ams_rect.nLeft = (short) this.f3982v;
                    ams_rect.nTop = (short) this.f3983w;
                    ams_rect.nRight = (short) f;
                    ams_rect.nBottom = (short) this.f3990G;
                    if (f < this.f3982v) {
                        ams_rect.nLeft = (short) f;
                        ams_rect.nRight = (short) this.f3982v;
                    }
                    return mo3972b(ams_rect);
                }
            case 6:
                this.f3979s = 2;
                if (!this.f3986z) {
                    mo3964a(f, f2, 255);
                    break;
                } else {
                    this.f3986z = false;
                    ams_rect.nLeft = (short) this.f3982v;
                    ams_rect.nTop = (short) this.f3983w;
                    ams_rect.nRight = (short) this.f3989F;
                    ams_rect.nBottom = (short) f2;
                    if (f2 < this.f3983w) {
                        ams_rect.nTop = (short) f2;
                        ams_rect.nBottom = (short) this.f3983w;
                    }
                    return mo3972b(ams_rect);
                }
        }
        return false;
    }
}
