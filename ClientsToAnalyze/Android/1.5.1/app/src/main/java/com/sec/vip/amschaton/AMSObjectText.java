package com.sec.vip.amschaton;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextPaint;
import com.sec.amsoma.structure.AMS_OBJECT_DATA;
import com.sec.amsoma.structure.AMS_OBJECT_TEXT_INFO;
import com.sec.amsoma.structure.AMS_RECT;
import com.sec.chaton.util.ChatONLogWriter;

/* loaded from: classes.dex */
public class AMSObjectText extends AMSObject {

    /* renamed from: D */
    private InterfaceC0715r f4000D;

    /* renamed from: E */
    private Bitmap f4001E;

    /* renamed from: F */
    private int f4002F;

    /* renamed from: G */
    private int f4003G;

    /* renamed from: H */
    private int[] f4004H;

    public AMSObjectText(int i, int i2, int i3) {
        super(i, i2, i3);
        this.f4000D = null;
        this.f4001E = null;
        this.f4002F = 0;
        this.f4003G = 0;
        this.f4004H = new int[]{15, 18, 20, 23, 25};
        this.f3971k = new Paint();
        this.f3971k.setColor(this.f3963b);
        this.f3971k.setAntiAlias(true);
        this.f3971k.setDither(true);
        this.f3971k.setStrokeCap(Paint.Cap.ROUND);
        this.f3971k.setStrokeJoin(Paint.Join.ROUND);
        this.f3971k.setStyle(Paint.Style.FILL);
        int i4 = i3 < 0 ? 0 : i3;
        this.f3964c = i4 > 4 ? 4 : i4;
        this.f3971k.setTextSize(this.f4004H[this.f3964c] * this.f3965d);
    }

    @Override // com.sec.vip.amschaton.AMSObject
    /* renamed from: a */
    public void mo3954a(float f) {
        super.mo3954a(f);
        this.f3971k.setTextSize((float) ((this.f4004H[this.f3964c] * f) + 0.5d));
    }

    @Override // com.sec.vip.amschaton.AMSObject
    /* renamed from: a */
    public void mo3955a(float f, float f2) {
        this.f3982v = (int) f;
        this.f3983w = (int) f2;
    }

    /* renamed from: a */
    public void m3979a(InterfaceC0715r interfaceC0715r) {
        this.f4000D = interfaceC0715r;
    }

    @Override // com.sec.vip.amschaton.AMSObject
    /* renamed from: a */
    public boolean mo3965a(float f, float f2, String str, int i) {
        this.f3971k.setAlpha(i);
        if (this.f4001E == null) {
            m3983b(str);
        }
        Rect rect = new Rect((int) f, (int) f2, (int) (this.f4002F + f), (int) (this.f4003G + f2));
        this.f3966e.drawBitmap(this.f3968g, 0.0f, 0.0f, (Paint) null);
        this.f3966e.drawBitmap(this.f4001E, f, f2, this.f3971k);
        m3956a(rect.left, rect.top, rect.right, rect.bottom);
        return true;
    }

    @Override // com.sec.vip.amschaton.AMSObject
    /* renamed from: a */
    public boolean mo3966a(int i, int i2, int i3) {
        super.mo3966a(i, i2, i3);
        int i4 = i3 < 0 ? 0 : i3;
        if (i4 > 5) {
            i4 = 5;
        }
        this.f3964c = i4;
        this.f3971k.setTextSize(this.f4004H[this.f3964c] * this.f3965d);
        m3983b(String.copyValueOf(this.f3960B.getM_TText().getM_cText()));
        if (!this.f3985y || this.f3959A == null) {
            return false;
        }
        AMS_RECT ams_rect = new AMS_RECT();
        ams_rect.nLeft = this.f3960B.getM_TRect().nLeft;
        ams_rect.nTop = this.f3960B.getM_TRect().nTop;
        ams_rect.nRight = (short) (this.f3960B.getM_TRect().nLeft + this.f4002F);
        ams_rect.nBottom = (short) (this.f3960B.getM_TRect().nTop + this.f4003G);
        this.f3976p.VipAMS_SetCurObjectColor(this.f3977q, this.f3978r, Color.red(i2), Color.green(i2), Color.blue(i2));
        if (!this.f3976p.VipAMS_ChangeSelectText(this.f3977q, this.f3978r, this.f3959A, ams_rect, (byte) this.f3964c, this.f3960B.getM_TText().getM_cText(), this.f3960B.getM_TText().getM_nTextLength(), this.f3960B.getM_TText().getM_cFontFaceName(), this.f3960B.getM_TText().getM_nFontFaceLength(), false)) {
            return false;
        }
        this.f3960B.setM_TRect(ams_rect);
        this.f3971k.setColor(i2);
        this.f4001E = null;
        mo3965a(this.f3960B.getM_TRect().nLeft, this.f3960B.getM_TRect().nTop, this.f3960B.getM_TText().getM_strText(), 255);
        return true;
    }

    /* renamed from: a */
    public boolean m3980a(String str) {
        if (!this.f3985y || this.f3959A == null) {
            return false;
        }
        m3983b(str);
        AMS_RECT ams_rect = new AMS_RECT();
        ams_rect.nLeft = (short) this.f3982v;
        ams_rect.nTop = (short) this.f3983w;
        ams_rect.nRight = (short) (this.f3982v + this.f4002F);
        ams_rect.nBottom = (short) (this.f3983w + this.f4003G);
        if (!this.f3976p.VipAMS_ChangeSelectText(this.f3977q, this.f3978r, this.f3959A, ams_rect, (byte) this.f3964c, str.toCharArray(), str.length(), this.f3960B.getM_TText().getM_cFontFaceName(), this.f3960B.getM_TText().getM_nFontFaceLength(), false)) {
            return false;
        }
        this.f3960B.setM_TRect(ams_rect);
        AMS_OBJECT_TEXT_INFO ams_object_text_info = new AMS_OBJECT_TEXT_INFO();
        ams_object_text_info.setM_strText(str);
        ams_object_text_info.setM_nTextLength(str.length());
        ams_object_text_info.setM_strFontFaceName(this.f3960B.getM_TText().getM_strFontFaceName());
        ams_object_text_info.setM_nFontFaceLength(this.f3960B.getM_TText().getM_nFontFaceLength());
        this.f3960B.setM_TText(ams_object_text_info);
        m3981a(str, 255);
        return true;
    }

    /* renamed from: a */
    public boolean m3981a(String str, int i) {
        mo3965a(this.f3982v, this.f3983w, str, i);
        return true;
    }

    /* renamed from: a */
    public boolean m3982a(String str, int i, int i2) {
        if (this.f3976p == null) {
            return false;
        }
        this.f3963b = i;
        this.f3971k.setColor(this.f3963b);
        int i3 = i2 < 0 ? 0 : i2;
        if (i3 > 5) {
            i3 = 5;
        }
        this.f3964c = i3;
        this.f3971k.setTextSize(this.f4004H[this.f3964c] * this.f3965d);
        m3983b(str);
        AMS_RECT ams_rect = new AMS_RECT();
        ams_rect.nLeft = (short) this.f3982v;
        ams_rect.nTop = (short) this.f3983w;
        ams_rect.nRight = (short) (this.f3982v + this.f4002F);
        ams_rect.nBottom = (short) (this.f3983w + this.f4003G);
        if (this.f3976p.VipAMS_EncodeNewText(this.f3977q, this.f3978r, ams_rect, (byte) this.f3964c, str.toCharArray(), str.length(), "".toCharArray(), 0, false)) {
            m3981a(str, 255);
        }
        return true;
    }

    @Override // com.sec.vip.amschaton.AMSObject
    /* renamed from: b */
    public boolean mo3972b(AMS_RECT ams_rect) {
        if (!this.f3985y || this.f3959A == null) {
            return false;
        }
        if (!this.f3976p.VipAMS_ChangeSelectText(this.f3977q, this.f3978r, this.f3959A, ams_rect, (byte) this.f3964c, this.f3960B.getM_TText().getM_cText(), this.f3960B.getM_TText().getM_nTextLength(), this.f3960B.getM_TText().getM_cFontFaceName(), this.f3960B.getM_TText().getM_nFontFaceLength(), false)) {
            return false;
        }
        this.f3960B = new AMS_OBJECT_DATA();
        this.f3976p.VipAMS_GetSelectObjectData(this.f3959A.getM_pSelectObjectData(), this.f3960B);
        mo3965a(ams_rect.nLeft, ams_rect.nTop, this.f3960B.getM_TText().getM_strText(), 255);
        return true;
    }

    /* renamed from: b */
    public boolean m3983b(String str) {
        String str2;
        int i;
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize(this.f4004H[this.f3964c] * this.f3965d);
        textPaint.setColor(this.f3963b);
        this.f4002F = 0;
        this.f4003G = 0;
        int i2 = 0;
        int i3 = 0;
        String str3 = "";
        String str4 = "";
        for (int i4 = 0; i4 < str.length(); i4++) {
            i3 = str.charAt(i4) < 128 ? i3 + 1 : i3 + 2;
            if (i3 == 16) {
                String str5 = str3 + str.charAt(i4);
                int iMeasureText = (int) textPaint.measureText(str5);
                if (this.f4002F < iMeasureText) {
                    this.f4002F = iMeasureText;
                }
                String str6 = str4 + str5 + "\n";
                i2++;
                i3 = 0;
                str3 = "";
                str4 = str6;
            } else if (i3 == 17) {
                int iMeasureText2 = (int) textPaint.measureText(str3);
                if (this.f4002F < iMeasureText2) {
                    this.f4002F = iMeasureText2;
                }
                i3 = 2;
                i2++;
                str4 = str4 + str3 + "\n";
                str3 = "" + str.charAt(i4);
            } else {
                str3 = str3 + str.charAt(i4);
            }
        }
        if (i3 > 0) {
            String str7 = str4 + str3;
            int i5 = i2 + 1;
            int iMeasureText3 = (int) textPaint.measureText(str3);
            if (this.f4002F < iMeasureText3) {
                this.f4002F = iMeasureText3;
            }
            str2 = str7;
            i = i5;
        } else {
            str2 = str4;
            i = i2;
        }
        this.f4003G = (int) (textPaint.getTextSize() * (i + 0.25d));
        this.f4001E = Bitmap.createBitmap(this.f4002F, this.f4003G, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(this.f4001E);
        int i6 = 0;
        int i7 = 1;
        while (true) {
            int iIndexOf = str2.indexOf("\n", i6);
            if (iIndexOf == -1) {
                canvas.drawText(str2.substring(i6, str2.length()), 0.0f, textPaint.getTextSize() * i7, textPaint);
                return true;
            }
            canvas.drawText(str2.substring(i6, iIndexOf), 0.0f, textPaint.getTextSize() * i7, textPaint);
            i6 = iIndexOf + 1;
            i7++;
        }
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
            case 2:
                if (this.f3959A != null) {
                    if (this.f3960B == null) {
                        this.f3960B = new AMS_OBJECT_DATA();
                        this.f3976p.VipAMS_GetSelectObjectData(this.f3959A.getM_pSelectObjectData(), this.f3960B);
                    }
                    this.f3980t = (int) (f - this.f3960B.getM_TRect().nLeft);
                    this.f3981u = (int) (f2 - this.f3960B.getM_TRect().nTop);
                    this.f3979s = 3;
                    mo3955a(this.f3960B.getM_TRect().nLeft, this.f3960B.getM_TRect().nTop);
                    m3981a(new String(this.f3960B.getM_TText().getM_cText()), 128);
                    this.f3986z = false;
                    mo3955a(f, f2);
                    break;
                } else {
                    ChatONLogWriter.m3499a("Why is selected object null???", getClass().getSimpleName());
                    this.f3979s = 0;
                    return true;
                }
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
            case 3:
                if (!this.f3986z && (Math.abs(this.f3982v - f) > this.f3965d * 10.0f || Math.abs(this.f3983w - f2) > this.f3965d * 10.0f)) {
                    this.f3986z = true;
                }
                mo3965a(f - this.f3980t, f2 - this.f3981u, this.f3960B.getM_TText().getM_strText(), 128);
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
            case 0:
                if (!this.f3984x) {
                    this.f3984x = true;
                    return true;
                }
                mo3955a(f, f2);
                if (this.f4000D != null) {
                    this.f4000D.mo3819a(null);
                    break;
                } else {
                    return false;
                }
            case 3:
                this.f3979s = 2;
                int i = this.f3960B.getM_TRect().nRight - this.f3960B.getM_TRect().nLeft;
                int i2 = this.f3960B.getM_TRect().nBottom - this.f3960B.getM_TRect().nTop;
                ams_rect.nLeft = (short) (f - this.f3980t);
                ams_rect.nTop = (short) (f2 - this.f3981u);
                ams_rect.nRight = (short) ((i + f) - this.f3980t);
                ams_rect.nBottom = (short) ((i2 + f2) - this.f3981u);
                boolean zMo3972b = mo3972b(ams_rect);
                if (!this.f3986z) {
                    mo3955a(f - this.f3980t, f2 - this.f3981u);
                    if (!this.f3984x) {
                        this.f3984x = true;
                        return true;
                    }
                    if (this.f4000D != null) {
                        this.f4000D.mo3819a(this.f3960B.getM_TText().getM_strText());
                        break;
                    } else {
                        return false;
                    }
                } else {
                    this.f3986z = false;
                    return zMo3972b;
                }
        }
        return true;
    }
}
