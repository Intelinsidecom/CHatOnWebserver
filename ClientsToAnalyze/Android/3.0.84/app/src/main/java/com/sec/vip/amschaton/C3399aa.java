package com.sec.vip.amschaton;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.v4.view.MotionEventCompat;
import android.text.TextPaint;
import com.sec.amsoma.structure.AMS_OBJECT_DATA;
import com.sec.amsoma.structure.AMS_OBJECT_TEXT_INFO;
import com.sec.amsoma.structure.AMS_RECT;
import com.sec.chaton.util.C3250y;

/* compiled from: AMSObjectText.java */
/* renamed from: com.sec.vip.amschaton.aa */
/* loaded from: classes.dex */
public class C3399aa extends C3588u {

    /* renamed from: Z */
    private InterfaceC3400ab f12435Z;

    /* renamed from: aa */
    private Bitmap f12436aa;

    /* renamed from: ab */
    private int f12437ab;

    /* renamed from: ac */
    private int f12438ac;

    /* renamed from: ad */
    private int[] f12439ad;

    /* renamed from: ae */
    private boolean f12440ae;

    /* renamed from: af */
    private int f12441af;

    /* renamed from: ag */
    private boolean f12442ag;

    /* renamed from: ah */
    private float f12443ah;

    /* renamed from: ai */
    private int f12444ai;

    /* renamed from: aj */
    private int f12445aj;

    public C3399aa(int i, int i2, int i3, boolean z, int i4, int i5) {
        super(i, i2, i3, i4, i5);
        this.f12435Z = null;
        this.f12436aa = null;
        this.f12437ab = 0;
        this.f12438ac = 0;
        this.f12439ad = new int[]{15, 18, 20, 23, 25};
        this.f12440ae = false;
        this.f12441af = 100;
        this.f12442ag = false;
        this.f12443ah = 0.0f;
        this.f12444ai = 48;
        this.f12445aj = 4;
        this.f13097l = new Paint();
        this.f13097l.setColor(this.f13087b);
        this.f13097l.setAntiAlias(true);
        this.f13097l.setDither(true);
        this.f13097l.setStrokeCap(Paint.Cap.ROUND);
        this.f13097l.setStrokeJoin(Paint.Join.ROUND);
        this.f13097l.setStyle(Paint.Style.FILL);
        int i6 = i3 < 0 ? 0 : i3;
        this.f13088c = i6 > 4 ? 4 : i6;
        this.f13097l.setTextSize(this.f12439ad[this.f13088c] * this.f13089d);
        this.f12442ag = z;
    }

    @Override // com.sec.vip.amschaton.C3588u
    /* renamed from: a */
    public void mo12131a(float f) {
        super.mo12131a(f);
        this.f13097l.setTextSize((float) ((this.f12439ad[this.f13088c] * f) + 0.5d));
        this.f12443ah = 15.0f * this.f13089d;
        this.f12444ai = (int) ((20.0f * this.f13089d) + 0.5f);
        this.f12445aj = (int) ((1.0f * this.f13089d) + 0.5f);
    }

    @Override // com.sec.vip.amschaton.C3588u
    /* renamed from: c */
    public boolean mo12146c(float f, float f2) {
        return this.f13059B == 2 && new RectF(((float) this.f13068K.getM_TRect().nLeft) - (((this.f13075R * this.f13089d) * 2.0f) + this.f12443ah), ((float) this.f13068K.getM_TRect().nTop) - (((this.f13075R * this.f13089d) * 2.0f) + this.f12443ah), ((float) this.f13068K.getM_TRect().nRight) + (((this.f13075R * this.f13089d) * 2.0f) + this.f12443ah), ((float) this.f13068K.getM_TRect().nBottom) + (((this.f13075R * this.f13089d) * 2.0f) + this.f12443ah)).contains(f, f2);
    }

    /* renamed from: a */
    public boolean m12141a(String str, int i, int i2) {
        if (this.f13110y == null) {
            return false;
        }
        this.f13087b = i;
        this.f13097l.setColor(this.f13087b);
        int i3 = i2 < 0 ? 0 : i2;
        this.f13088c = i3 <= 5 ? i3 : 5;
        this.f13097l.setTextSize(this.f12439ad[this.f13088c] * this.f13089d);
        m12145b(str);
        AMS_RECT ams_rect = new AMS_RECT();
        ams_rect.nLeft = (short) ((this.f13062E - (this.f12437ab / 2.0f)) + 0.5f);
        ams_rect.nTop = (short) ((this.f13063F - (this.f12438ac / 2.0f)) + 0.5f);
        ams_rect.nRight = (short) (this.f13062E + (this.f12437ab / 2.0f) + 0.5f);
        ams_rect.nBottom = (short) (this.f13063F + (this.f12438ac / 2.0f) + 0.5f);
        if (this.f13110y.VipAMS_EncodeNewText(this.f13111z, ams_rect, (byte) this.f13088c, str.toCharArray(), (short) str.length(), "".toCharArray(), (short) 0)) {
            m12140a(str, MotionEventCompat.ACTION_MASK);
        }
        return true;
    }

    /* renamed from: a */
    public boolean m12142a(String str, int i, int i2, float f, float f2) {
        this.f13062E = f;
        this.f13063F = f2;
        return m12141a(str, i, i2);
    }

    @Override // com.sec.vip.amschaton.C3588u
    /* renamed from: a */
    public boolean mo12137a(int i, int i2, int i3) {
        super.mo12137a(i, i2, i3);
        int i4 = i3 < 0 ? 0 : i3;
        this.f13088c = i4 <= 5 ? i4 : 5;
        this.f13097l.setTextSize(this.f12439ad[this.f13088c] * this.f13089d);
        m12138a(new RectF(this.f13068K.getM_TRect().nLeft, this.f13068K.getM_TRect().nTop, this.f13068K.getM_TRect().nRight, this.f13068K.getM_TRect().nBottom), String.copyValueOf(this.f13068K.getM_TText().getM_cText()));
        if (!this.f13065H || this.f13067J == null) {
            return false;
        }
        AMS_RECT ams_rect = new AMS_RECT();
        ams_rect.nLeft = this.f13068K.getM_TRect().nLeft;
        ams_rect.nTop = this.f13068K.getM_TRect().nTop;
        ams_rect.nRight = (short) (this.f13068K.getM_TRect().nLeft + this.f12437ab);
        ams_rect.nBottom = (short) (this.f13068K.getM_TRect().nTop + this.f12438ac);
        this.f13110y.VipAMS_SetCurObjectColor(this.f13111z, Color.red(i2), Color.green(i2), Color.blue(i2));
        if (!this.f13110y.VipAMS_ChangeSelectText(this.f13111z, this.f13067J, ams_rect, (byte) this.f13088c, this.f13068K.getM_TText().getM_cText(), (short) this.f13068K.getM_TText().getM_nTextLength(), this.f13068K.getM_TText().getM_cFontFaceName(), (short) this.f13068K.getM_TText().getM_nFontFaceLength())) {
            return false;
        }
        this.f13068K.setM_TRect(ams_rect);
        this.f13097l.setColor(i2);
        this.f12436aa = null;
        mo12136a(this.f13068K.getM_TRect().nLeft, this.f13068K.getM_TRect().nTop, this.f13068K.getM_TText().getM_strText(), MotionEventCompat.ACTION_MASK);
        return true;
    }

    /* renamed from: a */
    public boolean m12139a(String str) {
        if (!this.f13065H || this.f13067J == null) {
            return false;
        }
        m12138a(new RectF(this.f13068K.getM_TRect().nLeft, this.f13068K.getM_TRect().nTop, this.f13068K.getM_TRect().nRight, this.f13068K.getM_TRect().nBottom), str);
        AMS_RECT ams_rect = new AMS_RECT();
        ams_rect.nLeft = (short) this.f13062E;
        ams_rect.nTop = (short) this.f13063F;
        ams_rect.nRight = (short) (this.f13062E + this.f12437ab);
        ams_rect.nBottom = (short) (this.f13063F + this.f12438ac);
        if (!this.f13110y.VipAMS_ChangeSelectText(this.f13111z, this.f13067J, ams_rect, (byte) this.f13088c, str.toCharArray(), (short) str.length(), this.f13068K.getM_TText().getM_cFontFaceName(), (short) this.f13068K.getM_TText().getM_nFontFaceLength())) {
            return false;
        }
        this.f13068K.setM_TRect(ams_rect);
        AMS_OBJECT_TEXT_INFO ams_object_text_info = new AMS_OBJECT_TEXT_INFO();
        ams_object_text_info.setM_strText(str);
        ams_object_text_info.setM_nTextLength(str.length());
        ams_object_text_info.setM_strFontFaceName(this.f13068K.getM_TText().getM_strFontFaceName());
        ams_object_text_info.setM_nFontFaceLength(this.f13068K.getM_TText().getM_nFontFaceLength());
        this.f13068K.setM_TText(ams_object_text_info);
        m12140a(str, MotionEventCompat.ACTION_MASK);
        return true;
    }

    @Override // com.sec.vip.amschaton.C3588u
    /* renamed from: b */
    public boolean mo12144b(AMS_RECT ams_rect) {
        if (!this.f13065H || this.f13067J == null) {
            return false;
        }
        if (!this.f13110y.VipAMS_ChangeSelectText(this.f13111z, this.f13067J, ams_rect, (byte) this.f13088c, this.f13068K.getM_TText().getM_cText(), (short) this.f13068K.getM_TText().getM_nTextLength(), this.f13068K.getM_TText().getM_cFontFaceName(), (short) this.f13068K.getM_TText().getM_nFontFaceLength())) {
            return false;
        }
        this.f13068K = new AMS_OBJECT_DATA();
        this.f13110y.VipAMS_GetSelectObjectData(this.f13067J.getM_pSelectObjectData(), this.f13068K);
        mo12136a(ams_rect.nLeft, ams_rect.nTop, this.f13068K.getM_TText().getM_strText(), MotionEventCompat.ACTION_MASK);
        this.f13068K.setM_TRect(ams_rect);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x01cf  */
    @Override // com.sec.vip.amschaton.C3588u
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean mo12147d(float r12, float r13) {
        /*
            Method dump skipped, instructions count: 550
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.vip.amschaton.C3399aa.mo12147d(float, float):boolean");
    }

    @Override // com.sec.vip.amschaton.C3588u
    /* renamed from: e */
    public boolean mo12148e(float f, float f2) {
        if (this.f13110y == null) {
            return false;
        }
        switch (this.f13059B) {
            case 3:
                if (!this.f13066I && (Math.abs(this.f13062E - f) > this.f13089d * 10.0f || Math.abs(this.f13063F - f2) > this.f13089d * 10.0f)) {
                    this.f13066I = true;
                }
                mo12136a(f - this.f13060C, f2 - this.f13061D, this.f13068K.getM_TText().getM_strText(), 128);
                break;
            case 5:
            case 6:
                if (this.f12442ag) {
                    mo12136a(f, f2, this.f13068K.getM_TText().getM_strText(), 128);
                    if (this.f13065H) {
                        this.f13066I = true;
                        break;
                    }
                }
                break;
            case 7:
                if (!(Math.abs(((float) (this.f13068K.getM_TRect().nRight + ((int) ((this.f13075R * this.f13089d) * 2.0f)))) - f) < this.f12443ah && Math.abs(((float) (this.f13068K.getM_TRect().nTop - ((int) ((this.f13075R * this.f13089d) * 2.0f)))) - f2) < this.f12443ah)) {
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
        switch (this.f13059B) {
            case 0:
                if (!this.f13064G) {
                    this.f13064G = true;
                    return true;
                }
                mo12132a(f, f2);
                if (this.f12435Z == null) {
                    return false;
                }
                this.f12435Z.mo12152a(null);
                break;
            case 3:
                this.f13059B = 2;
                int i = this.f13068K.getM_TRect().nRight - this.f13068K.getM_TRect().nLeft;
                int i2 = this.f13068K.getM_TRect().nBottom - this.f13068K.getM_TRect().nTop;
                ams_rect.nLeft = (short) (f - this.f13060C);
                ams_rect.nTop = (short) (f2 - this.f13061D);
                ams_rect.nRight = (short) ((i + f) - this.f13060C);
                ams_rect.nBottom = (short) ((i2 + f2) - this.f13061D);
                boolean zMo12144b = mo12144b(ams_rect);
                if (this.f13066I) {
                    this.f13066I = false;
                    return zMo12144b;
                }
                mo12132a(f - this.f13060C, f2 - this.f13061D);
                if (!this.f13064G) {
                    this.f13064G = true;
                    return true;
                }
                if (this.f12435Z == null) {
                    return false;
                }
                this.f12435Z.mo12152a(this.f13068K.getM_TText().getM_strText());
                break;
            case 5:
                this.f13059B = 2;
                ams_rect.nLeft = (short) this.f13062E;
                ams_rect.nTop = (short) (this.f13063F - (this.f12438ac / 2));
                ams_rect.nRight = (short) f;
                ams_rect.nBottom = (short) (ams_rect.nTop + this.f12438ac);
                if (f < this.f13062E) {
                    ams_rect.nLeft = (short) (this.f13062E - this.f12437ab);
                    ams_rect.nRight = (short) this.f13062E;
                } else {
                    ams_rect.nLeft = (short) this.f13062E;
                    ams_rect.nRight = (short) (this.f13062E + this.f12437ab);
                }
                if (!this.f13066I) {
                    mo12136a(ams_rect.nLeft, ams_rect.nTop, this.f13068K.getM_TText().getM_strText(), MotionEventCompat.ACTION_MASK);
                    break;
                } else {
                    this.f13066I = false;
                    if (!mo12144b(ams_rect)) {
                        mo12815a();
                        return false;
                    }
                    mo12136a(ams_rect.nLeft, ams_rect.nTop, this.f13068K.getM_TText().getM_strText(), MotionEventCompat.ACTION_MASK);
                    break;
                }
            case 6:
                this.f13059B = 2;
                ams_rect.nLeft = (short) (this.f13062E - (this.f12437ab / 2));
                ams_rect.nTop = (short) this.f13063F;
                ams_rect.nRight = (short) (ams_rect.nLeft + this.f12437ab);
                ams_rect.nBottom = (short) f2;
                if (f2 < this.f13063F) {
                    ams_rect.nTop = (short) (this.f13063F - this.f12438ac);
                    ams_rect.nBottom = (short) this.f13063F;
                } else {
                    ams_rect.nTop = (short) this.f13063F;
                    ams_rect.nBottom = (short) (this.f13063F + this.f12438ac);
                }
                if (!this.f13066I) {
                    mo12136a(ams_rect.nLeft, ams_rect.nTop, this.f13068K.getM_TText().getM_strText(), MotionEventCompat.ACTION_MASK);
                    break;
                } else {
                    this.f13066I = false;
                    if (!mo12144b(ams_rect)) {
                        mo12815a();
                        return false;
                    }
                    mo12136a(ams_rect.nLeft, ams_rect.nTop, this.f13068K.getM_TText().getM_strText(), MotionEventCompat.ACTION_MASK);
                    break;
                }
            case 7:
                m12844b(101, false);
                this.f13076S.mo12776a();
                break;
        }
        return true;
    }

    @Override // com.sec.vip.amschaton.C3588u
    /* renamed from: a */
    public void mo12132a(float f, float f2) {
        this.f13062E = (int) f;
        this.f13063F = (int) f2;
    }

    /* renamed from: b */
    public boolean m12145b(String str) {
        TextPaint textPaint = new TextPaint();
        textPaint.setAntiAlias(true);
        textPaint.setDither(true);
        textPaint.setTextSize(this.f12439ad[this.f13088c] * this.f13089d);
        textPaint.setColor(this.f13087b);
        String str2 = "";
        StringBuilder sb = new StringBuilder();
        this.f12437ab = 0;
        this.f12438ac = 0;
        int i = this.f13071N - ((int) ((40.0f * this.f13089d) + 0.5f));
        int length = str.length();
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            char cCharAt = str.charAt(i3);
            if (((int) (textPaint.measureText(sb.toString() + cCharAt) + 0.5f)) > this.f12445aj + i) {
                str2 = str2 + sb.toString() + "\n";
                sb = new StringBuilder();
                sb.append(cCharAt);
                i2++;
            } else {
                sb.append(cCharAt);
                int iMeasureText = (int) (textPaint.measureText(sb.toString()) + 0.5f);
                if (this.f12437ab < iMeasureText) {
                    this.f12437ab = iMeasureText;
                }
            }
        }
        String str3 = str2 + sb.toString();
        int i4 = i2 + 1;
        int iMeasureText2 = (int) (textPaint.measureText(sb.toString()) + 0.5f);
        if (this.f12437ab < iMeasureText2) {
            this.f12437ab = iMeasureText2;
        }
        float f = 0.0f;
        if (this.f12437ab < this.f12444ai) {
            f = ((this.f12444ai - this.f12437ab) / 2.0f) + 0.5f;
            this.f12437ab = this.f12444ai;
        }
        this.f12438ac = (int) ((i4 + 0.4d) * textPaint.getTextSize());
        if (this.f12436aa != null) {
            this.f12436aa.recycle();
            this.f12436aa = null;
        }
        this.f12436aa = Bitmap.createBitmap(this.f12437ab, this.f12438ac, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(this.f12436aa);
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
    public boolean m12138a(RectF rectF, String str) {
        int iWidth;
        TextPaint textPaint = new TextPaint();
        textPaint.setAntiAlias(true);
        textPaint.setDither(true);
        textPaint.setTextSize(this.f12439ad[this.f13088c] * this.f13089d);
        textPaint.setColor(this.f13087b);
        String str2 = "";
        StringBuilder sb = new StringBuilder();
        this.f12437ab = 0;
        this.f12438ac = 0;
        int length = str.length();
        if (rectF.width() > 1.0f) {
            iWidth = (int) (rectF.width() + 0.5f);
        } else if (rectF.height() <= 1.0f) {
            iWidth = 1;
        } else {
            iWidth = (int) (((textPaint.measureText(str) * textPaint.getTextSize()) / rectF.height()) + 0.5d);
        }
        if (iWidth > this.f13092g.getWidth()) {
            iWidth = this.f13092g.getWidth();
        }
        if ((textPaint.measureText(str) * textPaint.getTextSize()) / iWidth > this.f13092g.getHeight()) {
            iWidth = (int) (((textPaint.measureText(str) * textPaint.getTextSize()) / this.f13092g.getHeight()) + 0.5d);
        }
        C3250y.m11453c("## maxBoundWidth : " + iWidth, getClass().getSimpleName());
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            if (((int) (textPaint.measureText(sb.toString() + cCharAt) + 0.5f)) > this.f12445aj + iWidth && i2 != 0) {
                str2 = str2 + sb.toString() + "\n";
                sb = new StringBuilder();
                sb.append(cCharAt);
                i++;
            } else {
                sb.append(cCharAt);
                int iMeasureText = (int) (textPaint.measureText(sb.toString()) + 0.5f);
                if (this.f12437ab < iMeasureText) {
                    this.f12437ab = iMeasureText;
                }
            }
        }
        String str3 = str2 + ((Object) sb);
        int i3 = i + 1;
        int iMeasureText2 = (int) (textPaint.measureText(sb.toString()) + 0.5f);
        if (this.f12437ab < iMeasureText2) {
            this.f12437ab = iMeasureText2;
        }
        float f = 0.0f;
        if (this.f12437ab < this.f12444ai) {
            f = ((this.f12444ai - this.f12437ab) / 2.0f) + 0.5f;
            this.f12437ab = this.f12444ai;
        }
        this.f12438ac = (int) ((i3 + 0.4d) * textPaint.getTextSize());
        if (this.f12436aa != null) {
            this.f12436aa.recycle();
            this.f12436aa = null;
        }
        this.f12436aa = Bitmap.createBitmap(this.f12437ab, this.f12438ac, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(this.f12436aa);
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

    /* renamed from: l */
    public int m12150l() {
        return this.f12437ab;
    }

    /* renamed from: m */
    public int m12151m() {
        return this.f12438ac;
    }

    /* renamed from: a */
    public boolean m12140a(String str, int i) {
        mo12136a(this.f13062E, this.f13063F, str, i);
        return true;
    }

    @Override // com.sec.vip.amschaton.C3588u
    /* renamed from: a */
    public boolean mo12136a(float f, float f2, String str, int i) {
        this.f13097l.setAlpha(i);
        if (this.f13059B == 5) {
            this.f13092g.drawBitmap(this.f13094i, 0.0f, 0.0f, (Paint) null);
            m12138a(new RectF(0.0f, 0.0f, Math.abs(f - this.f13062E), 0.0f), str);
            if (this.f13062E < f) {
                this.f13092g.drawBitmap(this.f12436aa, this.f13062E, this.f13063F - (this.f12438ac / 2), this.f13097l);
                m12816a(this.f13062E, this.f13063F - (this.f12438ac / 2), this.f13062E + this.f12437ab, this.f13063F + (this.f12438ac / 2));
                m12844b(107, true);
            } else {
                this.f13092g.drawBitmap(this.f12436aa, this.f13062E - this.f12437ab, this.f13063F - (this.f12438ac / 2), this.f13097l);
                m12816a(this.f13062E - this.f12437ab, this.f13063F - (this.f12438ac / 2), this.f13062E, this.f13063F + (this.f12438ac / 2));
                m12844b(105, true);
            }
        } else if (this.f13059B == 6) {
            this.f13092g.drawBitmap(this.f13094i, 0.0f, 0.0f, (Paint) null);
            m12138a(new RectF(0.0f, 0.0f, 0.0f, Math.abs(f2 - this.f13063F)), str);
            if (this.f13063F < f2) {
                this.f13092g.drawBitmap(this.f12436aa, this.f13062E - (this.f12437ab / 2), this.f13063F, this.f13097l);
                m12816a(this.f13062E - (this.f12437ab / 2), this.f13063F, this.f13062E + (this.f12437ab / 2), this.f13063F + this.f12438ac);
                m12844b(108, true);
            } else {
                this.f13092g.drawBitmap(this.f12436aa, this.f13062E - (this.f12437ab / 2), this.f13063F - this.f12438ac, this.f13097l);
                m12816a(this.f13062E - (this.f12437ab / 2), this.f13063F - this.f12438ac, this.f13062E + (this.f12437ab / 2), this.f13063F);
                m12844b(106, true);
            }
        } else if (this.f13059B == 2 || this.f13059B == 3) {
            this.f13092g.drawBitmap(this.f13094i, 0.0f, 0.0f, (Paint) null);
            if (this.f12436aa == null) {
                m12138a(new RectF(0.0f, 0.0f, this.f13068K.getM_TRect().nRight - this.f13068K.getM_TRect().nLeft, this.f13068K.getM_TRect().nBottom - this.f13068K.getM_TRect().nTop), str);
            }
            this.f13092g.drawBitmap(this.f12436aa, f, f2, this.f13097l);
            m12816a(f, f2, this.f12437ab + f, this.f12438ac + f2);
        } else {
            this.f13092g.drawBitmap(this.f13094i, 0.0f, 0.0f, (Paint) null);
            m12138a(new RectF(0.0f, 0.0f, this.f13092g.getWidth(), -1.0f), str);
            this.f13092g.drawBitmap(this.f12436aa, f, f2, this.f13097l);
            m12816a(f, f2, this.f12437ab + f, this.f12438ac + f2);
        }
        return true;
    }

    @Override // com.sec.vip.amschaton.C3588u
    /* renamed from: a */
    public boolean mo12134a(float f, float f2, float f3, float f4, String str, int i) {
        return m12130a(f, f2, f3, f4, str, i, true, true);
    }

    @Override // com.sec.vip.amschaton.C3588u
    /* renamed from: a */
    public boolean mo12135a(float f, float f2, float f3, float f4, String str, int i, boolean z) {
        return m12130a(f, f2, f3, f4, str, i, true, z);
    }

    /* renamed from: a */
    private boolean m12130a(float f, float f2, float f3, float f4, String str, int i, boolean z, boolean z2) {
        C3250y.m11453c("Don't use it !!!", getClass().getSimpleName());
        this.f13097l.setAlpha(i);
        RectF rectF = new RectF(f, f2, f3, f4);
        if (z) {
            m12138a(rectF, str);
        }
        if (z2) {
            this.f13092g.drawBitmap(this.f13094i, 0.0f, 0.0f, (Paint) null);
        }
        float f5 = ((f + f3) - this.f12437ab) / 2.0f;
        float f6 = ((f + f3) + this.f12437ab) / 2.0f;
        float f7 = ((f2 + f4) - this.f12438ac) / 2.0f;
        float f8 = ((f2 + f4) + this.f12438ac) / 2.0f;
        if (this.f13066I) {
            switch (this.f12441af) {
                case 105:
                    this.f13092g.drawBitmap(this.f12436aa, f3 - this.f12437ab, f7, this.f13097l);
                    rectF.set(f3 - this.f12437ab, f7, f3, f8);
                    break;
                case 106:
                    this.f13092g.drawBitmap(this.f12436aa, f5, f4 - this.f12438ac, this.f13097l);
                    rectF.set(f5, f4 - this.f12438ac, f6, f4);
                    break;
                case 107:
                default:
                    this.f13092g.drawBitmap(this.f12436aa, f, f7, this.f13097l);
                    rectF.set(f, f7, this.f12437ab + f, f8);
                    break;
                case 108:
                    this.f13092g.drawBitmap(this.f12436aa, f5, f2, this.f13097l);
                    rectF.set(f5, f2, f6, this.f12438ac + f2);
                    break;
            }
        } else {
            this.f13092g.drawBitmap(this.f12436aa, f, f2, this.f13097l);
            rectF.set(f, f2, this.f12437ab + f, this.f12438ac + f2);
        }
        m12816a(rectF.left, rectF.top, rectF.right, rectF.bottom);
        return true;
    }

    /* renamed from: a */
    public void m12133a(InterfaceC3400ab interfaceC3400ab) {
        this.f12435Z = interfaceC3400ab;
    }

    /* renamed from: a */
    public boolean m12143a(int[] iArr) {
        if (iArr.length != 2) {
            return false;
        }
        iArr[0] = (int) this.f13062E;
        iArr[1] = (int) this.f13063F;
        return true;
    }
}
