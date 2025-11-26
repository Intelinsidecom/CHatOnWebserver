package com.sec.vip.amschaton;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.text.TextPaint;
import com.sec.amsoma.structure.AMS_OBJECT_DATA;
import com.sec.amsoma.structure.AMS_OBJECT_TEXT_INFO;
import com.sec.amsoma.structure.AMS_RECT;
import com.sec.chaton.util.C1786r;
import twitter4j.MediaEntity;

/* compiled from: AMSObjectText.java */
/* renamed from: com.sec.vip.amschaton.x */
/* loaded from: classes.dex */
public class C2074x extends C2068r {

    /* renamed from: V */
    private InterfaceC2075y f7446V;

    /* renamed from: W */
    private Bitmap f7447W;

    /* renamed from: X */
    private int f7448X;

    /* renamed from: Y */
    private int f7449Y;

    /* renamed from: Z */
    private int[] f7450Z;

    /* renamed from: aa */
    private boolean f7451aa;

    /* renamed from: ab */
    private int f7452ab;

    /* renamed from: ac */
    private boolean f7453ac;

    /* renamed from: ad */
    private float f7454ad;

    /* renamed from: ae */
    private int f7455ae;

    /* renamed from: af */
    private int f7456af;

    public C2074x(int i, int i2, int i3, boolean z, int i4, int i5) {
        super(i, i2, i3, i4, i5);
        this.f7446V = null;
        this.f7447W = null;
        this.f7448X = 0;
        this.f7449Y = 0;
        this.f7450Z = new int[]{15, 18, 20, 23, 25};
        this.f7451aa = false;
        this.f7452ab = 100;
        this.f7453ac = false;
        this.f7454ad = 0.0f;
        this.f7455ae = 48;
        this.f7456af = 4;
        this.f7401j = new Paint();
        this.f7401j.setColor(this.f7393b);
        this.f7401j.setAntiAlias(true);
        this.f7401j.setDither(true);
        this.f7401j.setStrokeCap(Paint.Cap.ROUND);
        this.f7401j.setStrokeJoin(Paint.Join.ROUND);
        this.f7401j.setStyle(Paint.Style.FILL);
        int i6 = i3 < 0 ? 0 : i3;
        this.f7394c = i6 > 4 ? 4 : i6;
        this.f7401j.setTextSize(this.f7450Z[this.f7394c] * this.f7395d);
        this.f7453ac = z;
    }

    @Override // com.sec.vip.amschaton.C2068r
    /* renamed from: a */
    public void mo7194a(float f) {
        super.mo7194a(f);
        this.f7401j.setTextSize((float) ((this.f7450Z[this.f7394c] * f) + 0.5d));
        this.f7454ad = 15.0f * this.f7395d;
        this.f7455ae = (int) ((20.0f * this.f7395d) + 0.5f);
        this.f7456af = (int) ((1.0f * this.f7395d) + 0.5f);
    }

    @Override // com.sec.vip.amschaton.C2068r
    /* renamed from: c */
    public boolean mo7233c(float f, float f2) {
        return this.f7417z == 2 && new RectF(((float) this.f7377I.getM_TRect().nLeft) - (((this.f7384P * this.f7395d) * 2.0f) + this.f7454ad), ((float) this.f7377I.getM_TRect().nTop) - (((this.f7384P * this.f7395d) * 2.0f) + this.f7454ad), ((float) this.f7377I.getM_TRect().nRight) + (((this.f7384P * this.f7395d) * 2.0f) + this.f7454ad), ((float) this.f7377I.getM_TRect().nBottom) + (((this.f7384P * this.f7395d) * 2.0f) + this.f7454ad)).contains(f, f2);
    }

    /* renamed from: a */
    public boolean m7251a(String str, int i, int i2) {
        if (this.f7414w == null) {
            return false;
        }
        this.f7393b = i;
        this.f7401j.setColor(this.f7393b);
        int i3 = i2 < 0 ? 0 : i2;
        this.f7394c = i3 <= 5 ? i3 : 5;
        this.f7401j.setTextSize(this.f7450Z[this.f7394c] * this.f7395d);
        m7254b(str);
        AMS_RECT ams_rect = new AMS_RECT();
        ams_rect.nLeft = (short) ((this.f7371C - (this.f7448X / 2.0f)) + 0.5f);
        ams_rect.nTop = (short) ((this.f7372D - (this.f7449Y / 2.0f)) + 0.5f);
        ams_rect.nRight = (short) (this.f7371C + (this.f7448X / 2.0f) + 0.5f);
        ams_rect.nBottom = (short) (this.f7372D + (this.f7449Y / 2.0f) + 0.5f);
        if (this.f7414w.VipAMS_EncodeNewText(this.f7415x, ams_rect, (byte) this.f7394c, str.toCharArray(), (short) str.length(), "".toCharArray(), (short) 0, false)) {
            m7250a(str, MotionEventCompat.ACTION_MASK);
        }
        return true;
    }

    /* renamed from: a */
    public boolean m7252a(String str, int i, int i2, float f, float f2) {
        this.f7371C = f;
        this.f7372D = f2;
        return m7251a(str, i, i2);
    }

    @Override // com.sec.vip.amschaton.C2068r
    /* renamed from: a */
    public boolean mo7218a(int i, int i2, int i3) {
        super.mo7218a(i, i2, i3);
        int i4 = i3 < 0 ? 0 : i3;
        this.f7394c = i4 <= 5 ? i4 : 5;
        this.f7401j.setTextSize(this.f7450Z[this.f7394c] * this.f7395d);
        m7248a(new RectF(this.f7377I.getM_TRect().nLeft, this.f7377I.getM_TRect().nTop, this.f7377I.getM_TRect().nRight, this.f7377I.getM_TRect().nBottom), String.copyValueOf(this.f7377I.getM_TText().getM_cText()));
        if (!this.f7374F || this.f7376H == null) {
            return false;
        }
        AMS_RECT ams_rect = new AMS_RECT();
        ams_rect.nLeft = this.f7377I.getM_TRect().nLeft;
        ams_rect.nTop = this.f7377I.getM_TRect().nTop;
        ams_rect.nRight = (short) (this.f7377I.getM_TRect().nLeft + this.f7448X);
        ams_rect.nBottom = (short) (this.f7377I.getM_TRect().nTop + this.f7449Y);
        this.f7414w.VipAMS_SetCurObjectColor(this.f7415x, Color.red(i2), Color.green(i2), Color.blue(i2));
        if (!this.f7414w.VipAMS_ChangeSelectText(this.f7415x, this.f7376H, ams_rect, (byte) this.f7394c, this.f7377I.getM_TText().getM_cText(), (short) this.f7377I.getM_TText().getM_nTextLength(), this.f7377I.getM_TText().getM_cFontFaceName(), (short) this.f7377I.getM_TText().getM_nFontFaceLength(), false)) {
            return false;
        }
        this.f7377I.setM_TRect(ams_rect);
        this.f7401j.setColor(i2);
        this.f7447W = null;
        mo7217a(this.f7377I.getM_TRect().nLeft, this.f7377I.getM_TRect().nTop, this.f7377I.getM_TText().getM_strText(), MotionEventCompat.ACTION_MASK);
        return true;
    }

    /* renamed from: a */
    public boolean m7249a(String str) {
        if (!this.f7374F || this.f7376H == null) {
            return false;
        }
        m7248a(new RectF(this.f7377I.getM_TRect().nLeft, this.f7377I.getM_TRect().nTop, this.f7377I.getM_TRect().nRight, this.f7377I.getM_TRect().nBottom), str);
        AMS_RECT ams_rect = new AMS_RECT();
        ams_rect.nLeft = (short) this.f7371C;
        ams_rect.nTop = (short) this.f7372D;
        ams_rect.nRight = (short) (this.f7371C + this.f7448X);
        ams_rect.nBottom = (short) (this.f7372D + this.f7449Y);
        if (!this.f7414w.VipAMS_ChangeSelectText(this.f7415x, this.f7376H, ams_rect, (byte) this.f7394c, str.toCharArray(), (short) str.length(), this.f7377I.getM_TText().getM_cFontFaceName(), (short) this.f7377I.getM_TText().getM_nFontFaceLength(), false)) {
            return false;
        }
        this.f7377I.setM_TRect(ams_rect);
        AMS_OBJECT_TEXT_INFO ams_object_text_info = new AMS_OBJECT_TEXT_INFO();
        ams_object_text_info.setM_strText(str);
        ams_object_text_info.setM_nTextLength(str.length());
        ams_object_text_info.setM_strFontFaceName(this.f7377I.getM_TText().getM_strFontFaceName());
        ams_object_text_info.setM_nFontFaceLength(this.f7377I.getM_TText().getM_nFontFaceLength());
        this.f7377I.setM_TText(ams_object_text_info);
        m7250a(str, MotionEventCompat.ACTION_MASK);
        return true;
    }

    @Override // com.sec.vip.amschaton.C2068r
    /* renamed from: b */
    public boolean mo7228b(AMS_RECT ams_rect) {
        if (!this.f7374F || this.f7376H == null || !this.f7414w.VipAMS_ChangeSelectText(this.f7415x, this.f7376H, ams_rect, (byte) this.f7394c, this.f7377I.getM_TText().getM_cText(), (short) this.f7377I.getM_TText().getM_nTextLength(), this.f7377I.getM_TText().getM_cFontFaceName(), (short) this.f7377I.getM_TText().getM_nFontFaceLength(), false)) {
            return false;
        }
        this.f7377I = new AMS_OBJECT_DATA();
        this.f7414w.VipAMS_GetSelectObjectData(this.f7376H.getM_pSelectObjectData(), this.f7377I);
        mo7217a(ams_rect.nLeft, ams_rect.nTop, this.f7377I.getM_TText().getM_strText(), MotionEventCompat.ACTION_MASK);
        this.f7377I.setM_TRect(ams_rect);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x01cf  */
    @Override // com.sec.vip.amschaton.C2068r
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean mo7235d(float r12, float r13) {
        /*
            Method dump skipped, instructions count: 550
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.vip.amschaton.C2074x.mo7235d(float, float):boolean");
    }

    @Override // com.sec.vip.amschaton.C2068r
    /* renamed from: e */
    public boolean mo7237e(float f, float f2) {
        if (this.f7414w == null) {
            return false;
        }
        switch (this.f7417z) {
            case 3:
                if (!this.f7375G && (Math.abs(this.f7371C - f) > this.f7395d * 10.0f || Math.abs(this.f7372D - f2) > this.f7395d * 10.0f)) {
                    this.f7375G = true;
                }
                mo7217a(f - this.f7369A, f2 - this.f7370B, this.f7377I.getM_TText().getM_strText(), AccessibilityEventCompat.TYPE_VIEW_HOVER_ENTER);
                break;
            case 5:
            case 6:
                if (this.f7453ac) {
                    mo7217a(f, f2, this.f7377I.getM_TText().getM_strText(), AccessibilityEventCompat.TYPE_VIEW_HOVER_ENTER);
                    if (this.f7374F) {
                        this.f7375G = true;
                        break;
                    }
                }
                break;
            case 7:
                if (!(Math.abs(((float) this.f7377I.getM_TRect().nRight) - f) < this.f7395d * 12.5f && Math.abs(((float) this.f7377I.getM_TRect().nTop) - f2) < this.f7395d * 12.5f)) {
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
        switch (this.f7417z) {
            case 0:
                if (!this.f7373E) {
                    this.f7373E = true;
                    return true;
                }
                mo7195a(f, f2);
                if (this.f7446V == null) {
                    return false;
                }
                this.f7446V.mo6667a(null);
                break;
            case 3:
                this.f7417z = 2;
                int i = this.f7377I.getM_TRect().nRight - this.f7377I.getM_TRect().nLeft;
                int i2 = this.f7377I.getM_TRect().nBottom - this.f7377I.getM_TRect().nTop;
                ams_rect.nLeft = (short) (f - this.f7369A);
                ams_rect.nTop = (short) (f2 - this.f7370B);
                ams_rect.nRight = (short) ((i + f) - this.f7369A);
                ams_rect.nBottom = (short) ((i2 + f2) - this.f7370B);
                boolean zMo7228b = mo7228b(ams_rect);
                if (this.f7375G) {
                    this.f7375G = false;
                    return zMo7228b;
                }
                mo7195a(f - this.f7369A, f2 - this.f7370B);
                if (!this.f7373E) {
                    this.f7373E = true;
                    return true;
                }
                if (this.f7446V == null) {
                    return false;
                }
                this.f7446V.mo6667a(this.f7377I.getM_TText().getM_strText());
                break;
            case 5:
                this.f7417z = 2;
                ams_rect.nLeft = (short) this.f7371C;
                ams_rect.nTop = (short) (this.f7372D - (this.f7449Y / 2));
                ams_rect.nRight = (short) f;
                ams_rect.nBottom = (short) (ams_rect.nTop + this.f7449Y);
                if (f < this.f7371C) {
                    ams_rect.nLeft = (short) (this.f7371C - this.f7448X);
                    ams_rect.nRight = (short) this.f7371C;
                } else {
                    ams_rect.nLeft = (short) this.f7371C;
                    ams_rect.nRight = (short) (this.f7371C + this.f7448X);
                }
                if (!this.f7375G) {
                    mo7217a(ams_rect.nLeft, ams_rect.nTop, this.f7377I.getM_TText().getM_strText(), MotionEventCompat.ACTION_MASK);
                    break;
                } else {
                    this.f7375G = false;
                    if (!mo7228b(ams_rect)) {
                        mo7193a();
                        return false;
                    }
                    mo7217a(ams_rect.nLeft, ams_rect.nTop, this.f7377I.getM_TText().getM_strText(), MotionEventCompat.ACTION_MASK);
                    break;
                }
            case 6:
                this.f7417z = 2;
                ams_rect.nLeft = (short) (this.f7371C - (this.f7448X / 2));
                ams_rect.nTop = (short) this.f7372D;
                ams_rect.nRight = (short) (ams_rect.nLeft + this.f7448X);
                ams_rect.nBottom = (short) f2;
                if (f2 < this.f7372D) {
                    ams_rect.nTop = (short) (this.f7372D - this.f7449Y);
                    ams_rect.nBottom = (short) this.f7372D;
                } else {
                    ams_rect.nTop = (short) this.f7372D;
                    ams_rect.nBottom = (short) (this.f7372D + this.f7449Y);
                }
                if (!this.f7375G) {
                    mo7217a(ams_rect.nLeft, ams_rect.nTop, this.f7377I.getM_TText().getM_strText(), MotionEventCompat.ACTION_MASK);
                    break;
                } else {
                    this.f7375G = false;
                    if (!mo7228b(ams_rect)) {
                        mo7193a();
                        return false;
                    }
                    mo7217a(ams_rect.nLeft, ams_rect.nTop, this.f7377I.getM_TText().getM_strText(), MotionEventCompat.ACTION_MASK);
                    break;
                }
            case 7:
                m7198a(MediaEntity.Size.CROP, false);
                this.f7385Q.mo6859a();
                break;
        }
        return true;
    }

    @Override // com.sec.vip.amschaton.C2068r
    /* renamed from: a */
    public void mo7195a(float f, float f2) {
        this.f7371C = (int) f;
        this.f7372D = (int) f2;
    }

    /* renamed from: b */
    public boolean m7254b(String str) {
        TextPaint textPaint = new TextPaint();
        textPaint.setAntiAlias(true);
        textPaint.setDither(true);
        textPaint.setTextSize(this.f7450Z[this.f7394c] * this.f7395d);
        textPaint.setColor(this.f7393b);
        String str2 = "";
        StringBuilder sb = new StringBuilder();
        this.f7448X = 0;
        this.f7449Y = 0;
        int i = this.f7380L - ((int) ((40.0f * this.f7395d) + 0.5f));
        int length = str.length();
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            char cCharAt = str.charAt(i3);
            if (((int) (textPaint.measureText(sb.toString() + cCharAt) + 0.5f)) > this.f7456af + i) {
                str2 = str2 + sb.toString() + "\n";
                sb = new StringBuilder();
                sb.append(cCharAt);
                i2++;
            } else {
                sb.append(cCharAt);
                int iMeasureText = (int) (textPaint.measureText(sb.toString()) + 0.5f);
                if (this.f7448X < iMeasureText) {
                    this.f7448X = iMeasureText;
                }
            }
        }
        String str3 = str2 + sb.toString();
        int i4 = i2 + 1;
        int iMeasureText2 = (int) (textPaint.measureText(sb.toString()) + 0.5f);
        if (this.f7448X < iMeasureText2) {
            this.f7448X = iMeasureText2;
        }
        float f = 0.0f;
        if (this.f7448X < this.f7455ae) {
            f = ((this.f7455ae - this.f7448X) / 2.0f) + 0.5f;
            this.f7448X = this.f7455ae;
        }
        this.f7449Y = (int) ((i4 + 0.4d) * textPaint.getTextSize());
        if (this.f7447W != null) {
            this.f7447W.recycle();
            this.f7447W = null;
        }
        this.f7447W = Bitmap.createBitmap(this.f7448X, this.f7449Y, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(this.f7447W);
        int i5 = 0;
        int i6 = 1;
        while (true) {
            int iIndexOf = str3.indexOf("\n", i5);
            if (iIndexOf == -1) {
                canvas.drawText(str3.substring(i5, str3.length()), f, i6 * textPaint.getTextSize(), textPaint);
                return true;
            }
            canvas.drawText(str3.substring(i5, iIndexOf), f, textPaint.getTextSize() * i6, textPaint);
            i5 = iIndexOf + 1;
            i6++;
        }
    }

    /* renamed from: a */
    public boolean m7248a(RectF rectF, String str) {
        int iWidth;
        TextPaint textPaint = new TextPaint();
        textPaint.setAntiAlias(true);
        textPaint.setDither(true);
        textPaint.setTextSize(this.f7450Z[this.f7394c] * this.f7395d);
        textPaint.setColor(this.f7393b);
        String str2 = "";
        StringBuilder sb = new StringBuilder();
        this.f7448X = 0;
        this.f7449Y = 0;
        int length = str.length();
        if (rectF.width() > 1.0f) {
            iWidth = (int) (rectF.width() + 0.5f);
        } else if (rectF.height() <= 1.0f) {
            iWidth = 1;
        } else {
            iWidth = (int) (((textPaint.measureText(str) * textPaint.getTextSize()) / rectF.height()) + 0.5d);
        }
        if (iWidth > this.f7396e.getWidth()) {
            iWidth = this.f7396e.getWidth();
        }
        if ((textPaint.measureText(str) * textPaint.getTextSize()) / iWidth > this.f7396e.getHeight()) {
            iWidth = (int) (((textPaint.measureText(str) * textPaint.getTextSize()) / this.f7396e.getHeight()) + 0.5d);
        }
        C1786r.m6063c("## maxBoundWidth : " + iWidth, getClass().getSimpleName());
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            if (((int) (textPaint.measureText(sb.toString() + cCharAt) + 0.5f)) > this.f7456af + iWidth && i2 != 0) {
                str2 = str2 + sb.toString() + "\n";
                sb = new StringBuilder();
                sb.append(cCharAt);
                i++;
            } else {
                sb.append(cCharAt);
                int iMeasureText = (int) (textPaint.measureText(sb.toString()) + 0.5f);
                if (this.f7448X < iMeasureText) {
                    this.f7448X = iMeasureText;
                }
            }
        }
        String str3 = str2 + ((Object) sb);
        int i3 = i + 1;
        int iMeasureText2 = (int) (textPaint.measureText(sb.toString()) + 0.5f);
        if (this.f7448X < iMeasureText2) {
            this.f7448X = iMeasureText2;
        }
        float f = 0.0f;
        if (this.f7448X < this.f7455ae) {
            f = ((this.f7455ae - this.f7448X) / 2.0f) + 0.5f;
            this.f7448X = this.f7455ae;
        }
        this.f7449Y = (int) ((i3 + 0.4d) * textPaint.getTextSize());
        if (this.f7447W != null) {
            this.f7447W.recycle();
            this.f7447W = null;
        }
        this.f7447W = Bitmap.createBitmap(this.f7448X, this.f7449Y, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(this.f7447W);
        int i4 = 0;
        int i5 = 1;
        while (true) {
            int iIndexOf = str3.indexOf("\n", i4);
            if (iIndexOf == -1) {
                canvas.drawText(str3.substring(i4, str3.length()), f, i5 * textPaint.getTextSize(), textPaint);
                return true;
            }
            canvas.drawText(str3.substring(i4, iIndexOf), f, textPaint.getTextSize() * i5, textPaint);
            i4 = iIndexOf + 1;
            i5++;
        }
    }

    /* renamed from: j */
    public int m7255j() {
        return this.f7448X;
    }

    /* renamed from: k */
    public int m7256k() {
        return this.f7449Y;
    }

    /* renamed from: a */
    public boolean m7250a(String str, int i) {
        mo7217a(this.f7371C, this.f7372D, str, i);
        return true;
    }

    @Override // com.sec.vip.amschaton.C2068r
    /* renamed from: a */
    public boolean mo7217a(float f, float f2, String str, int i) {
        this.f7401j.setAlpha(i);
        if (this.f7417z == 5) {
            this.f7396e.drawBitmap(this.f7398g, 0.0f, 0.0f, (Paint) null);
            m7248a(new RectF(0.0f, 0.0f, Math.abs(f - this.f7371C), 0.0f), str);
            if (this.f7371C < f) {
                this.f7396e.drawBitmap(this.f7447W, this.f7371C, this.f7372D - (this.f7449Y / 2), this.f7401j);
                m7196a(this.f7371C, this.f7372D - (this.f7449Y / 2), this.f7371C + this.f7448X, this.f7372D + (this.f7449Y / 2));
                m7198a(107, true);
            } else {
                this.f7396e.drawBitmap(this.f7447W, this.f7371C - this.f7448X, this.f7372D - (this.f7449Y / 2), this.f7401j);
                m7196a(this.f7371C - this.f7448X, this.f7372D - (this.f7449Y / 2), this.f7371C, this.f7372D + (this.f7449Y / 2));
                m7198a(105, true);
            }
        } else if (this.f7417z == 6) {
            this.f7396e.drawBitmap(this.f7398g, 0.0f, 0.0f, (Paint) null);
            m7248a(new RectF(0.0f, 0.0f, 0.0f, Math.abs(f2 - this.f7372D)), str);
            if (this.f7372D < f2) {
                this.f7396e.drawBitmap(this.f7447W, this.f7371C - (this.f7448X / 2), this.f7372D, this.f7401j);
                m7196a(this.f7371C - (this.f7448X / 2), this.f7372D, this.f7371C + (this.f7448X / 2), this.f7372D + this.f7449Y);
                m7198a(108, true);
            } else {
                this.f7396e.drawBitmap(this.f7447W, this.f7371C - (this.f7448X / 2), this.f7372D - this.f7449Y, this.f7401j);
                m7196a(this.f7371C - (this.f7448X / 2), this.f7372D - this.f7449Y, this.f7371C + (this.f7448X / 2), this.f7372D);
                m7198a(106, true);
            }
        } else if (this.f7417z == 2 || this.f7417z == 3) {
            this.f7396e.drawBitmap(this.f7398g, 0.0f, 0.0f, (Paint) null);
            if (this.f7447W == null) {
                m7248a(new RectF(0.0f, 0.0f, this.f7377I.getM_TRect().nRight - this.f7377I.getM_TRect().nLeft, this.f7377I.getM_TRect().nBottom - this.f7377I.getM_TRect().nTop), str);
            }
            this.f7396e.drawBitmap(this.f7447W, f, f2, this.f7401j);
            m7196a(f, f2, this.f7448X + f, this.f7449Y + f2);
        } else {
            this.f7396e.drawBitmap(this.f7398g, 0.0f, 0.0f, (Paint) null);
            m7248a(new RectF(0.0f, 0.0f, this.f7396e.getWidth(), -1.0f), str);
            this.f7396e.drawBitmap(this.f7447W, f, f2, this.f7401j);
            m7196a(f, f2, this.f7448X + f, this.f7449Y + f2);
        }
        return true;
    }

    @Override // com.sec.vip.amschaton.C2068r
    /* renamed from: a */
    public boolean mo7211a(float f, float f2, float f3, float f4, String str, int i) {
        return m7246a(f, f2, f3, f4, str, i, true, true);
    }

    @Override // com.sec.vip.amschaton.C2068r
    /* renamed from: a */
    public boolean mo7212a(float f, float f2, float f3, float f4, String str, int i, boolean z) {
        return m7246a(f, f2, f3, f4, str, i, true, z);
    }

    /* renamed from: a */
    private boolean m7246a(float f, float f2, float f3, float f4, String str, int i, boolean z, boolean z2) {
        C1786r.m6063c("Don't use it !!!", getClass().getSimpleName());
        this.f7401j.setAlpha(i);
        RectF rectF = new RectF(f, f2, f3, f4);
        if (z) {
            m7248a(rectF, str);
        }
        if (z2) {
            this.f7396e.drawBitmap(this.f7398g, 0.0f, 0.0f, (Paint) null);
        }
        float f5 = ((f + f3) - this.f7448X) / 2.0f;
        float f6 = ((f + f3) + this.f7448X) / 2.0f;
        float f7 = ((f2 + f4) - this.f7449Y) / 2.0f;
        float f8 = ((f2 + f4) + this.f7449Y) / 2.0f;
        if (this.f7375G) {
            switch (this.f7452ab) {
                case 105:
                    this.f7396e.drawBitmap(this.f7447W, f3 - this.f7448X, f7, this.f7401j);
                    rectF.set(f3 - this.f7448X, f7, f3, f8);
                    break;
                case 106:
                    this.f7396e.drawBitmap(this.f7447W, f5, f4 - this.f7449Y, this.f7401j);
                    rectF.set(f5, f4 - this.f7449Y, f6, f4);
                    break;
                case 107:
                default:
                    this.f7396e.drawBitmap(this.f7447W, f, f7, this.f7401j);
                    rectF.set(f, f7, this.f7448X + f, f8);
                    break;
                case 108:
                    this.f7396e.drawBitmap(this.f7447W, f5, f2, this.f7401j);
                    rectF.set(f5, f2, f6, this.f7449Y + f2);
                    break;
            }
        } else {
            this.f7396e.drawBitmap(this.f7447W, f, f2, this.f7401j);
            rectF.set(f, f2, this.f7448X + f, this.f7449Y + f2);
        }
        m7196a(rectF.left, rectF.top, rectF.right, rectF.bottom);
        return true;
    }

    /* renamed from: a */
    public void m7247a(InterfaceC2075y interfaceC2075y) {
        this.f7446V = interfaceC2075y;
    }

    /* renamed from: a */
    public boolean m7253a(int[] iArr) {
        if (iArr.length != 2) {
            return false;
        }
        iArr[0] = (int) this.f7371C;
        iArr[1] = (int) this.f7372D;
        return true;
    }
}
