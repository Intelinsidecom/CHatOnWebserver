package com.sec.vip.amschaton;

import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.sec.amsoma.structure.AMS_OBJECT_DATA;
import com.sec.amsoma.structure.AMS_RECT;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.pns.msg.MsgResultCode;

/* loaded from: classes.dex */
public class AMSObjectStamp extends AMSObject {

    /* renamed from: D */
    private Bitmap f3997D;

    /* renamed from: E */
    private int f3998E;

    /* renamed from: F */
    private AMSStampManager f3999F;

    public AMSObjectStamp(int i, int i2, int i3) {
        super(i, i2, i3);
        this.f3998E = 55;
        this.f3999F = AMSStampManager.m4056a();
        if (i < this.f3999F.m4063b()) {
            this.f3997D = this.f3999F.m4058a(i);
        } else if (i < this.f3999F.m4063b() + this.f3999F.m4067d()) {
            this.f3997D = this.f3999F.m4059a(this.f3962a - this.f3999F.m4063b(), 7);
        } else if (i >= 1000) {
            this.f3997D = this.f3999F.m4064b(this.f3962a - MsgResultCode.SUCCESS);
        } else {
            this.f3997D = this.f3999F.m4058a(0);
        }
        this.f3971k = new Paint();
        if (this.f3997D == null) {
            this.f3998E = 110;
        } else {
            this.f3998E = this.f3997D.getWidth();
        }
    }

    public AMSObjectStamp(int i, int i2, int i3, Bitmap bitmap) {
        super(i, i2, i3);
        this.f3998E = 55;
        this.f3999F = AMSStampManager.m4056a();
        this.f3997D = bitmap;
        this.f3971k = new Paint();
        this.f3998E = this.f3997D.getWidth();
    }

    @Override // com.sec.vip.amschaton.AMSObject
    /* renamed from: a */
    public void mo3954a(float f) {
        super.mo3954a(f);
        if (this.f3998E == 0) {
            this.f3998E = (int) ((55.0f * this.f3965d) + 0.5d);
        } else {
            this.f3998E = (int) (((this.f3998E / 2) * this.f3965d) + 0.5d);
        }
    }

    @Override // com.sec.vip.amschaton.AMSObject
    /* renamed from: a */
    public boolean mo3964a(float f, float f2, int i) {
        Rect rect = new Rect((int) f, (int) f2, (int) (this.f3998E + f), (int) (this.f3998E + f2));
        this.f3966e.drawBitmap(this.f3968g, 0.0f, 0.0f, (Paint) null);
        if (i >= 256) {
            this.f3971k.setAlpha(255);
            this.f3966e.drawBitmap(AMSStampManager.m4056a().m4059a(this.f3962a - this.f3999F.m4063b(), i - MsgResultCode.SUCCESS), (Rect) null, rect, this.f3971k);
            return true;
        }
        this.f3971k.setAlpha(i);
        this.f3966e.drawBitmap(this.f3997D, (Rect) null, rect, this.f3971k);
        m3956a(rect.left, rect.top, rect.right, rect.bottom);
        return true;
    }

    @Override // com.sec.vip.amschaton.AMSObject
    /* renamed from: a */
    public boolean mo3967a(AMS_RECT ams_rect) {
        if (this.f3962a < 0 || this.f3962a >= this.f3999F.m4063b()) {
            if (this.f3962a >= this.f3999F.m4063b() + this.f3999F.m4067d()) {
                int[] iArr = new int[this.f3997D.getWidth() * this.f3997D.getHeight()];
                this.f3997D.getPixels(iArr, 0, this.f3997D.getWidth(), 0, 0, this.f3997D.getWidth(), this.f3997D.getHeight());
                if (!this.f3976p.VipAMS_EncodeNewStamp(this.f3977q, this.f3978r, ams_rect, 2, 2, this.f3962a, iArr, this.f3997D.getWidth(), this.f3997D.getHeight(), 32, false)) {
                    mo3953a();
                    return false;
                }
            } else if (!this.f3976p.VipAMS_EncodeNewStamp(this.f3977q, this.f3978r, ams_rect, 0, 2, this.f3962a, null, 0, 0, 0, false)) {
                mo3953a();
                return false;
            }
        } else if (!this.f3976p.VipAMS_EncodeNewStamp(this.f3977q, this.f3978r, ams_rect, 0, 2, this.f3962a, null, 0, 0, 0, false)) {
            mo3953a();
            return false;
        }
        mo3964a(ams_rect.nLeft, ams_rect.nTop, 255);
        return true;
    }

    @Override // com.sec.vip.amschaton.AMSObject
    /* renamed from: b */
    public boolean mo3972b(AMS_RECT ams_rect) {
        if (!this.f3985y || this.f3959A == null) {
            return false;
        }
        if (!this.f3976p.VipAMS_ChangeSelectStamp(this.f3977q, this.f3978r, this.f3959A, ams_rect, this.f3960B.getM_cStyle(), this.f3960B.getM_cSize(), false)) {
            return false;
        }
        this.f3960B.setM_TRect(ams_rect);
        mo3964a(ams_rect.nLeft, ams_rect.nTop, 255);
        return true;
    }

    @Override // com.sec.vip.amschaton.AMSObject
    /* renamed from: c */
    public boolean mo3974c(float f, float f2) {
        return this.f3979s == 2 && new RectF((float) this.f3960B.getM_TRect().nLeft, (float) this.f3960B.getM_TRect().nTop, (float) this.f3960B.getM_TRect().nRight, (float) this.f3960B.getM_TRect().nBottom).contains(f, f2);
    }

    @Override // com.sec.vip.amschaton.AMSObject
    /* renamed from: d */
    public boolean mo3976d(float f, float f2) {
        if (this.f3976p == null) {
            return false;
        }
        switch (this.f3979s) {
            case 0:
                this.f3979s = 1;
                this.f3980t = this.f3998E / 2;
                this.f3981u = this.f3998E / 2;
                mo3964a(f - this.f3980t, f2 - this.f3981u, 255);
                break;
            case 2:
                if (this.f3959A != null) {
                    if (this.f3960B == null) {
                        this.f3960B = new AMS_OBJECT_DATA();
                        this.f3976p.VipAMS_GetSelectObjectData(this.f3959A.getM_pSelectObjectData(), this.f3960B);
                    }
                    if (this.f3960B.getM_TRect().nLeft < f && f < this.f3960B.getM_TRect().nRight && this.f3960B.getM_TRect().nTop < f2 && f2 < this.f3960B.getM_TRect().nBottom) {
                        this.f3980t = (int) (f - this.f3960B.getM_TRect().nLeft);
                        this.f3981u = (int) (f2 - this.f3960B.getM_TRect().nTop);
                        this.f3979s = 3;
                        mo3964a(f - this.f3980t, f2 - this.f3981u, 128);
                        this.f3986z = false;
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
            case 3:
                if (!this.f3985y) {
                    mo3964a(f - this.f3980t, f2 - this.f3981u, 255);
                    break;
                } else {
                    mo3964a(f - this.f3980t, f2 - this.f3981u, 128);
                    this.f3986z = true;
                    break;
                }
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
                this.f3979s = 0;
                ams_rect.nLeft = (short) (f - this.f3980t);
                ams_rect.nTop = (short) (f2 - this.f3981u);
                ams_rect.nRight = (short) ((f - this.f3980t) + 110.0f);
                ams_rect.nBottom = (short) ((f2 - this.f3981u) + 110.0f);
                return mo3967a(ams_rect);
            case 3:
                this.f3979s = 2;
                if (!this.f3986z) {
                    mo3964a(f - this.f3980t, f2 - this.f3981u, 255);
                    break;
                } else {
                    ams_rect.nLeft = (short) (f - this.f3980t);
                    ams_rect.nTop = (short) (f2 - this.f3981u);
                    ams_rect.nRight = (short) ((f - this.f3980t) + 110.0f);
                    ams_rect.nBottom = (short) ((f2 - this.f3981u) + 110.0f);
                    this.f3986z = false;
                    return mo3972b(ams_rect);
                }
        }
        return false;
    }
}
