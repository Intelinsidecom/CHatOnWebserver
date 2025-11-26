package com.sec.vip.amschaton;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.v4.view.MotionEventCompat;
import android.text.TextPaint;
import com.sec.amsoma.structure.AMS_RECT;

/* compiled from: AMSObjectTextGuide.java */
/* renamed from: com.sec.vip.amschaton.ac */
/* loaded from: classes.dex */
public class C3401ac extends C3588u {

    /* renamed from: Z */
    public String f12446Z;

    /* renamed from: aa */
    public Rect f12447aa;

    /* renamed from: ab */
    private InterfaceC3582o f12448ab;

    /* renamed from: ac */
    private Bitmap f12449ac;

    /* renamed from: ad */
    private int f12450ad;

    /* renamed from: ae */
    private int f12451ae;

    /* renamed from: af */
    private int[] f12452af;

    /* renamed from: ag */
    private final int f12453ag;

    /* renamed from: ah */
    private final int f12454ah;

    /* renamed from: ai */
    private float f12455ai;

    /* renamed from: aj */
    private float f12456aj;

    /* renamed from: ak */
    private int f12457ak;

    /* renamed from: al */
    private boolean f12458al;

    /* renamed from: am */
    private float f12459am;

    /* renamed from: an */
    private int f12460an;

    /* renamed from: ao */
    private float f12461ao;

    /* renamed from: ap */
    private float f12462ap;

    /* renamed from: aq */
    private float f12463aq;

    /* renamed from: ar */
    private float f12464ar;

    /* renamed from: as */
    private float f12465as;

    public C3401ac(int i, int i2, int i3, boolean z, int i4, int i5) {
        super(i, i2, i3, i4, i5);
        this.f12448ab = null;
        this.f12449ac = null;
        this.f12450ad = 0;
        this.f12451ae = 0;
        this.f12452af = new int[]{15, 18, 20, 23, 25};
        this.f12453ag = 15;
        this.f12454ah = 12;
        this.f12455ai = 0.0f;
        this.f12456aj = 0.0f;
        this.f12457ak = 0;
        this.f12458al = false;
        this.f12459am = 0.0f;
        this.f12460an = 0;
        this.f12461ao = 0.0f;
        this.f12462ap = 0.0f;
        this.f12463aq = 0.0f;
        this.f12446Z = new String();
        this.f12447aa = new Rect(0, 0, 0, 0);
        this.f12464ar = 0.0f;
        this.f12465as = 0.0f;
        this.f13097l = new Paint();
        this.f13097l.setColor(this.f13087b);
        this.f13097l.setAntiAlias(true);
        this.f13097l.setDither(true);
        this.f13097l.setStrokeCap(Paint.Cap.ROUND);
        this.f13097l.setStrokeJoin(Paint.Join.ROUND);
        this.f13097l.setStyle(Paint.Style.FILL);
        int i6 = i3 < 0 ? 0 : i3;
        this.f13088c = i6 > 4 ? 4 : i6;
        this.f12460an = this.f13088c;
        this.f13097l.setTextSize(this.f12452af[this.f13088c] * this.f13089d);
        this.f12458al = z;
    }

    @Override // com.sec.vip.amschaton.C3588u
    /* renamed from: a */
    public void mo12131a(float f) {
        super.mo12131a(f);
        this.f13097l.setTextSize((float) ((this.f12452af[this.f13088c] * f) + 0.5d));
    }

    @Override // com.sec.vip.amschaton.C3588u
    /* renamed from: c */
    public boolean mo12146c(float f, float f2) {
        if (this.f13059B != 2) {
            return false;
        }
        float f3 = 15.0f * this.f13089d;
        return new RectF(((float) this.f12447aa.left) - f3, ((float) this.f12447aa.top) - f3, (((float) this.f12447aa.right) + f3) + ((float) ((int) (12.0f * this.f13089d))), f3 + ((float) this.f12447aa.bottom)).contains(f, f2);
    }

    /* renamed from: a */
    public boolean m12159a(String str, int i, int i2) {
        this.f13087b = i;
        this.f13097l.setColor(this.f13087b);
        int i3 = i2 < 0 ? 0 : i2;
        this.f13088c = i3 <= 5 ? i3 : 5;
        this.f12460an = this.f13088c;
        this.f13097l.setTextSize(this.f12452af[this.f13088c] * this.f13089d);
        m12157a(str);
        this.f12446Z = str;
        this.f12447aa.set((int) (this.f13062E - (this.f12450ad / 2)), (int) (this.f13063F - (this.f12451ae / 2)), (int) (this.f13062E + (this.f12450ad / 2)), (int) (this.f13063F + (this.f12451ae / 2)));
        if (this.f12458al) {
            mo12134a(this.f12447aa.left, this.f12447aa.top, this.f12447aa.right, this.f12447aa.bottom, str, MotionEventCompat.ACTION_MASK);
            return true;
        }
        m12158a(str, MotionEventCompat.ACTION_MASK);
        return true;
    }

    /* renamed from: a */
    public boolean m12160a(String str, int i, int i2, float f, float f2) {
        this.f13062E = f;
        this.f13063F = f2;
        return m12159a(str, i, i2);
    }

    @Override // com.sec.vip.amschaton.C3588u
    /* renamed from: a */
    public boolean mo12137a(int i, int i2, int i3) {
        super.mo12137a(i, i2, i3);
        int i4 = i3 < 0 ? 0 : i3;
        int i5 = i4 <= 5 ? i4 : 5;
        boolean z = this.f12460an != i5;
        this.f13088c = i5;
        this.f12460an = this.f13088c;
        this.f13097l.setTextSize(this.f12452af[this.f13088c] * this.f13089d);
        if (this.f12458al) {
            RectF rectF = new RectF(this.f12447aa);
            m12156a(rectF, this.f12446Z);
            if (!this.f13065H) {
                return false;
            }
            AMS_RECT ams_rect = new AMS_RECT();
            ams_rect.nLeft = (short) rectF.left;
            ams_rect.nTop = (short) rectF.top;
            ams_rect.nRight = (short) rectF.right;
            ams_rect.nBottom = (short) rectF.bottom;
            if (z) {
                float f = (rectF.left + rectF.right) / 2.0f;
                float f2 = (rectF.bottom + rectF.top) / 2.0f;
                ams_rect.nLeft = (short) (f - (this.f12450ad / 2));
                ams_rect.nTop = (short) (f2 - (this.f12451ae / 2));
                ams_rect.nRight = (short) (f + (this.f12450ad / 2));
                ams_rect.nBottom = (short) (f2 + (this.f12451ae / 2));
            }
            this.f12447aa.set(ams_rect.nLeft, ams_rect.nTop, ams_rect.nRight, ams_rect.nBottom);
            this.f13097l.setColor(i2);
            this.f12449ac = null;
            mo12134a(ams_rect.nLeft, ams_rect.nTop, ams_rect.nRight, ams_rect.nBottom, this.f12446Z, MotionEventCompat.ACTION_MASK);
        } else {
            m12157a(this.f12446Z);
            if (!this.f13065H) {
                return false;
            }
            AMS_RECT ams_rect2 = new AMS_RECT();
            float f3 = (this.f12447aa.left + this.f12447aa.right) / 2.0f;
            float f4 = (this.f12447aa.top + this.f12447aa.bottom) / 2.0f;
            ams_rect2.nLeft = (short) (f3 - (this.f12450ad / 2));
            ams_rect2.nTop = (short) (f4 - (this.f12451ae / 2));
            ams_rect2.nRight = (short) (f3 + (this.f12450ad / 2));
            ams_rect2.nBottom = (short) ((this.f12451ae / 2) + f4);
            this.f12447aa.set(ams_rect2.nLeft, ams_rect2.nTop, ams_rect2.nRight, ams_rect2.nBottom);
            this.f13097l.setColor(i2);
            this.f12449ac = null;
            mo12136a(this.f12447aa.left, this.f12447aa.top, this.f12446Z, MotionEventCompat.ACTION_MASK);
        }
        return true;
    }

    @Override // com.sec.vip.amschaton.C3588u
    /* renamed from: b */
    public boolean mo12144b(AMS_RECT ams_rect) {
        if (!this.f13065H) {
            return false;
        }
        if (this.f12458al) {
            this.f12447aa.set(ams_rect.nLeft, ams_rect.nTop, ams_rect.nRight, ams_rect.nBottom);
            mo12134a(ams_rect.nLeft, ams_rect.nTop, ams_rect.nRight, ams_rect.nBottom, this.f12446Z, MotionEventCompat.ACTION_MASK);
        } else {
            this.f12447aa.set(ams_rect.nLeft, ams_rect.nTop, ams_rect.nRight, ams_rect.nBottom);
            mo12136a(ams_rect.nLeft, ams_rect.nTop, this.f12446Z, MotionEventCompat.ACTION_MASK);
        }
        return true;
    }

    @Override // com.sec.vip.amschaton.C3588u
    /* renamed from: d */
    public boolean mo12147d(float f, float f2) {
        if (this.f12458al) {
            boolean z = false;
            switch (this.f13059B) {
                case 2:
                    this.f12464ar = f;
                    this.f12465as = f2;
                    int i = this.f12447aa.left;
                    int i2 = this.f12447aa.top;
                    int i3 = this.f12447aa.right;
                    int i4 = this.f12447aa.bottom;
                    int i5 = (int) (this.f13075R * this.f13089d * 2.0f);
                    int i6 = i - i5;
                    int i7 = i2 - i5;
                    int i8 = i3 + i5 + ((int) (12.0f * this.f13089d));
                    int i9 = i5 + i4;
                    if (Math.abs(i8 - f) < 15.0f * this.f13089d && Math.abs(i7 - f2) < 15.0f * this.f13089d) {
                        m12844b(101, true);
                        z = true;
                    } else if (Math.abs(((i6 + i8) / 2) - f) < 15.0f * this.f13089d && Math.abs(i7 - f2) < 15.0f * this.f13089d) {
                        this.f13062E = i;
                        this.f13063F = i4;
                        this.f12455ai = i3;
                        this.f12456aj = i4;
                        this.f12461ao = this.f13062E;
                        this.f12462ap = this.f12455ai;
                        this.f13059B = 6;
                        this.f12457ak = 106;
                    } else if (Math.abs(i8 - f) < 15.0f * this.f13089d && Math.abs(((i7 + i9) / 2) - f2) < 15.0f * this.f13089d) {
                        this.f13062E = i;
                        this.f13063F = i2;
                        this.f12455ai = i;
                        this.f12456aj = i4;
                        this.f13059B = 5;
                        this.f12457ak = 107;
                    } else if (Math.abs(((i8 + i6) / 2) - f) < 15.0f * this.f13089d && Math.abs(i9 - f2) < 15.0f * this.f13089d) {
                        this.f13062E = i;
                        this.f13063F = i2;
                        this.f12455ai = i3;
                        this.f12456aj = i2;
                        this.f12461ao = this.f13062E;
                        this.f12462ap = this.f12455ai;
                        this.f13059B = 6;
                        this.f12457ak = 108;
                    } else if (Math.abs(i6 - f) < 15.0f * this.f13089d && Math.abs(((i7 + i9) / 2) - f2) < 15.0f * this.f13089d) {
                        this.f13062E = i3;
                        this.f13063F = i2;
                        this.f12455ai = i3;
                        this.f12456aj = i4;
                        this.f13059B = 5;
                        this.f12457ak = 105;
                    }
                    this.f12459am = f2;
                    this.f13066I = false;
                    if (this.f13059B == 5 || this.f13059B == 6) {
                        m12844b(this.f12457ak, true);
                        String str = new String(this.f12446Z);
                        mo12136a(f, f2, str, 128);
                        this.f12463aq = m12153b(str);
                    } else if (z) {
                        this.f13059B = 7;
                    } else {
                        this.f13060C = (int) (f - this.f12447aa.left);
                        this.f13061D = (int) (f2 - this.f12447aa.top);
                        this.f13059B = 3;
                        mo12134a(this.f12447aa.left, this.f12447aa.top, this.f12447aa.right, this.f12447aa.bottom, this.f12446Z, 128);
                    }
                    break;
                default:
                    return true;
            }
        } else {
            switch (this.f13059B) {
                case 2:
                    int i10 = this.f12447aa.top;
                    if (Math.abs(this.f12447aa.right - f) < 15.0f * this.f13089d && Math.abs(i10 - f2) < 15.0f * this.f13089d) {
                        m12844b(101, true);
                        this.f13059B = 7;
                    } else {
                        this.f13060C = (int) (f - this.f12447aa.left);
                        this.f13061D = (int) (f2 - this.f12447aa.top);
                        this.f13059B = 3;
                        mo12132a(this.f12447aa.left, this.f12447aa.top);
                        m12158a(new String(this.f12446Z), 128);
                        this.f13066I = false;
                        mo12132a(f, f2);
                    }
                    break;
                default:
                    return true;
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.sec.vip.amschaton.C3588u
    /* renamed from: e */
    public boolean mo12148e(float f, float f2) {
        if (this.f12458al) {
            switch (this.f13059B) {
                case 1:
                case 5:
                    float f3 = f - this.f13062E;
                    float f4 = f2 - this.f13063F;
                    if (f3 > this.f12450ad) {
                        f = this.f13062E + this.f12450ad;
                    }
                    if ((-this.f12450ad) > f3) {
                        f = this.f13062E - this.f12450ad;
                    }
                    if (f4 > this.f12451ae || (0.0f <= f4 && f4 < this.f12451ae)) {
                        f2 = this.f13063F + this.f12451ae;
                    }
                    if ((-this.f12451ae) > f4 || ((-this.f12451ae) < f4 && f4 < 0.0f)) {
                        f2 = this.f13063F - this.f12451ae;
                    }
                    mo12136a(f, f2, this.f12446Z, 128);
                    if (this.f13065H) {
                        this.f13066I = true;
                    }
                    m12844b(this.f12457ak, true);
                    break;
                case 3:
                    m12154b(f - this.f13060C, f2 - this.f13061D, ((this.f12447aa.right - this.f12447aa.left) + f) - this.f13060C, ((this.f12447aa.bottom - this.f12447aa.top) + f2) - this.f13061D, this.f12446Z, 128, false);
                    if (this.f13065H) {
                        this.f13066I = true;
                        break;
                    }
                    break;
                case 6:
                    int i = this.f12451ae;
                    float f5 = (f2 - this.f12459am) * 0.6f;
                    if (this.f12457ak == 106) {
                        this.f13062E -= f5;
                        this.f12455ai += f5;
                        i = -this.f12451ae;
                    } else if (this.f12457ak == 108) {
                        this.f13062E += f5;
                        this.f12455ai -= f5;
                    }
                    if (this.f13062E > this.f12455ai) {
                        float f6 = this.f12455ai;
                        this.f12455ai = this.f13062E;
                        this.f13062E = f6;
                    }
                    if (Math.abs(this.f12455ai - this.f13062E) > this.f12463aq) {
                        this.f13062E = this.f12461ao;
                        this.f12455ai = this.f12462ap;
                    }
                    this.f12461ao = this.f13062E;
                    this.f12462ap = this.f12455ai;
                    this.f12459am = f2;
                    float f7 = f2 - this.f13063F;
                    if (f7 > this.f12451ae || ((0.0f <= f7 && f7 < this.f12451ae) || (-this.f12451ae) > f7 || ((-this.f12451ae) < f7 && f7 < 0.0f))) {
                        f2 = this.f13063F + i;
                    }
                    mo12136a(f, f2, this.f12446Z, 128);
                    if (this.f13065H) {
                        this.f13066I = true;
                    }
                    m12844b(this.f12457ak, true);
                    break;
                case 7:
                    int i2 = this.f12447aa.top;
                    int i3 = this.f12447aa.right;
                    int i4 = (int) (this.f13075R * this.f13089d * 2.0f);
                    if (!(Math.abs(((float) ((i3 + i4) + ((int) (12.0f * this.f13089d)))) - f) < this.f13089d * 15.0f && Math.abs(((float) (i2 - i4)) - f2) < this.f13089d * 15.0f)) {
                        m12844b(101, false);
                        this.f13059B = 2;
                        break;
                    }
                    break;
            }
        } else {
            switch (this.f13059B) {
                case 3:
                    if (!this.f13066I && (Math.abs(this.f13062E - f) > 10.0f * this.f13089d || Math.abs(this.f13063F - f2) > 10.0f * this.f13089d)) {
                        this.f13066I = true;
                    }
                    mo12136a(f - this.f13060C, f2 - this.f13061D, this.f12446Z, 128);
                    break;
                case 7:
                    if (!(Math.abs(((float) this.f12447aa.right) - f) < this.f13089d * 15.0f && Math.abs(((float) this.f12447aa.top) - f2) < this.f13089d * 15.0f)) {
                        m12844b(101, false);
                        this.f13059B = 2;
                        break;
                    }
                    break;
            }
        }
        return true;
    }

    @Override // com.sec.vip.amschaton.C3588u
    /* renamed from: f */
    public boolean mo12149f(float f, float f2) {
        if (this.f12458al) {
            AMS_RECT ams_rect = new AMS_RECT();
            float f3 = f - this.f13062E;
            float f4 = f2 - this.f13063F;
            switch (this.f13059B) {
                case 0:
                    mo12132a(f, f2);
                    if (this.f12448ab != null) {
                        this.f12448ab.mo12777a(null, (this.f12447aa.left + this.f12447aa.right) / 2, (this.f12447aa.top + this.f12447aa.bottom) / 2);
                        break;
                    } else {
                        return false;
                    }
                case 1:
                    if (f3 > this.f12450ad) {
                        f = this.f13062E + this.f12450ad;
                    }
                    if ((-this.f12450ad) > f3) {
                        f = this.f13062E - this.f12450ad;
                    }
                    if (f4 > this.f12451ae || (0.0f <= f4 && f4 < this.f12451ae)) {
                        f2 = this.f13063F + this.f12451ae;
                    }
                    if ((-this.f12451ae) > f4 || ((-this.f12451ae) < f4 && f4 < 0.0f)) {
                        f2 = this.f13063F - this.f12451ae;
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
                    int i = this.f12447aa.right - this.f12447aa.left;
                    int i2 = this.f12447aa.bottom - this.f12447aa.top;
                    ams_rect.nLeft = (short) (f - this.f13060C);
                    ams_rect.nTop = (short) (f2 - this.f13061D);
                    ams_rect.nRight = (short) ((i + f) - this.f13060C);
                    ams_rect.nBottom = (short) ((i2 + f2) - this.f13061D);
                    boolean zMo12144b = mo12144b(ams_rect);
                    if (this.f13066I && (Math.abs(this.f12464ar - f) > 4.0f || Math.abs(this.f12465as - f2) > 4.0f)) {
                        this.f13066I = false;
                        return zMo12144b;
                    }
                    mo12132a(f - this.f13060C, f2 - this.f13061D);
                    if (!this.f13064G) {
                        this.f13064G = true;
                        return true;
                    }
                    if (this.f12448ab != null) {
                        this.f12448ab.mo12777a(null, (this.f12447aa.left + this.f12447aa.right) / 2, (this.f12447aa.top + this.f12447aa.bottom) / 2);
                        break;
                    } else {
                        return false;
                    }
                    break;
                case 5:
                    if (f3 > this.f12450ad) {
                        f = this.f13062E + this.f12450ad;
                    }
                    if ((-this.f12450ad) > f3) {
                        f = this.f13062E - this.f12450ad;
                    }
                    if (f4 > this.f12451ae || (0.0f <= f4 && f4 < this.f12451ae)) {
                        f2 = this.f13063F + this.f12451ae;
                    }
                    if ((-this.f12451ae) > f4 || ((-this.f12451ae) < f4 && f4 < 0.0f)) {
                        f2 = this.f13063F - this.f12451ae;
                    }
                    if (!this.f13066I) {
                        mo12136a(f, f2, this.f13068K.getM_TText().getM_strText(), MotionEventCompat.ACTION_MASK);
                        break;
                    } else {
                        this.f13066I = false;
                        this.f12456aj = f2;
                        ams_rect.nLeft = (short) this.f13062E;
                        ams_rect.nTop = (short) this.f13063F;
                        ams_rect.nRight = (short) f;
                        ams_rect.nBottom = (short) this.f12456aj;
                        if (f < this.f13062E) {
                            ams_rect.nLeft = (short) f;
                            ams_rect.nRight = (short) this.f13062E;
                        }
                        return mo12144b(ams_rect);
                    }
                    break;
                case 6:
                    if (this.f13066I) {
                        int i3 = this.f12451ae;
                        if (this.f12457ak == 106) {
                            i3 = -this.f12451ae;
                        }
                        if (f4 > this.f12451ae || ((0.0f <= f4 && f4 < this.f12451ae) || (-this.f12451ae) > f4 || ((-this.f12451ae) < f4 && f4 < 0.0f))) {
                            f2 = this.f13063F + i3;
                        }
                        this.f13066I = false;
                        ams_rect.nLeft = (short) this.f13062E;
                        ams_rect.nTop = (short) this.f13063F;
                        ams_rect.nRight = (short) this.f12455ai;
                        ams_rect.nBottom = (short) f2;
                        if (f2 < this.f13063F) {
                            ams_rect.nTop = (short) f2;
                            ams_rect.nBottom = (short) this.f13063F;
                        }
                        return mo12144b(ams_rect);
                    }
                    if (f3 > this.f12450ad) {
                        f = this.f13062E + this.f12450ad;
                    }
                    if ((-this.f12450ad) > f3) {
                        f = this.f13062E - this.f12450ad;
                    }
                    if (f4 > this.f12451ae || (0.0f <= f4 && f4 < this.f12451ae)) {
                        f2 = this.f13063F + this.f12451ae;
                    }
                    if ((-this.f12451ae) > f4 || ((-this.f12451ae) < f4 && f4 < 0.0f)) {
                        f2 = this.f13063F - this.f12451ae;
                    }
                    mo12136a(f, f2, this.f12446Z, MotionEventCompat.ACTION_MASK);
                    break;
                    break;
                case 7:
                    m12844b(101, false);
                    this.f13076S.mo12776a();
                    break;
            }
            return false;
        }
        AMS_RECT ams_rect2 = new AMS_RECT();
        switch (this.f13059B) {
            case 0:
                if (!this.f13064G) {
                    this.f13064G = true;
                    return true;
                }
                mo12132a(f, f2);
                if (this.f12448ab != null) {
                    this.f12448ab.mo12777a(null, (this.f12447aa.left + this.f12447aa.right) / 2, (this.f12447aa.top + this.f12447aa.bottom) / 2);
                    break;
                } else {
                    return false;
                }
            case 3:
                this.f13059B = 2;
                int i4 = this.f12447aa.right - this.f12447aa.left;
                int i5 = this.f12447aa.bottom - this.f12447aa.top;
                ams_rect2.nLeft = (short) (f - this.f13060C);
                ams_rect2.nTop = (short) (f2 - this.f13061D);
                ams_rect2.nRight = (short) ((i4 + f) - this.f13060C);
                ams_rect2.nBottom = (short) ((i5 + f2) - this.f13061D);
                boolean zMo12144b2 = mo12144b(ams_rect2);
                if (this.f13066I) {
                    this.f13066I = false;
                    return zMo12144b2;
                }
                mo12132a(f - this.f13060C, f2 - this.f13061D);
                if (!this.f13064G) {
                    this.f13064G = true;
                    return true;
                }
                if (this.f12448ab != null) {
                    this.f12448ab.mo12777a(null, (this.f12447aa.left + this.f12447aa.right) / 2, (this.f12447aa.top + this.f12447aa.bottom) / 2);
                    break;
                } else {
                    return false;
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

    /* renamed from: a */
    public boolean m12157a(String str) {
        TextPaint textPaint = new TextPaint();
        textPaint.setAntiAlias(true);
        textPaint.setDither(true);
        textPaint.setTextSize(this.f12452af[this.f13088c] * this.f13089d);
        textPaint.setColor(this.f13087b);
        String str2 = "";
        StringBuilder sb = new StringBuilder();
        this.f12450ad = 0;
        this.f12451ae = 0;
        int i = this.f13071N - ((int) ((40.0f * this.f13089d) + 0.5f));
        int length = str.length();
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            char cCharAt = str.charAt(i3);
            int iMeasureText = (int) textPaint.measureText(sb.toString());
            if (this.f12450ad < iMeasureText) {
                this.f12450ad = iMeasureText;
            }
            if (iMeasureText > i) {
                str2 = str2 + sb.toString() + "\n";
                sb = new StringBuilder();
                sb.append(cCharAt);
                i2++;
            } else {
                sb.append(cCharAt);
            }
        }
        String str3 = str2 + sb.toString();
        int i4 = i2 + 1;
        int iMeasureText2 = (int) textPaint.measureText(sb.toString());
        if (this.f12450ad < iMeasureText2) {
            this.f12450ad = iMeasureText2;
        }
        this.f12451ae = (int) ((i4 + 0.4d) * textPaint.getTextSize());
        if (this.f12449ac != null) {
            this.f12449ac.recycle();
            this.f12449ac = null;
        }
        this.f12449ac = Bitmap.createBitmap(this.f12450ad, this.f12451ae, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(this.f12449ac);
        int i5 = 0;
        int i6 = 1;
        while (true) {
            int iIndexOf = str3.indexOf("\n", i5);
            if (iIndexOf == -1) {
                canvas.drawText(str3.substring(i5, str3.length()), 0.0f, i6 * textPaint.getTextSize(), textPaint);
                return true;
            }
            canvas.drawText(str3.substring(i5, iIndexOf), 0.0f, textPaint.getTextSize() * i6, textPaint);
            i5 = iIndexOf + 1;
            i6++;
        }
    }

    /* renamed from: a */
    public boolean m12156a(RectF rectF, String str) {
        TextPaint textPaint = new TextPaint();
        textPaint.setAntiAlias(true);
        textPaint.setDither(true);
        textPaint.setTextSize(this.f12452af[this.f13088c] * this.f13089d);
        textPaint.setColor(this.f13087b);
        String str2 = "";
        StringBuilder sb = new StringBuilder();
        this.f12450ad = 0;
        this.f12451ae = 0;
        int length = str.length();
        int iWidth = (int) rectF.width();
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            if (str.charAt(i3) < 128) {
                i2++;
            } else {
                i2 += 2;
            }
            if (i2 > 0) {
                if (i2 % 2 == 0) {
                    int iMeasureText = (int) textPaint.measureText(sb.toString());
                    if (this.f12450ad < iMeasureText) {
                        this.f12450ad = iMeasureText;
                    }
                    if (iMeasureText > iWidth) {
                        str2 = str2 + sb.toString() + "\n";
                        sb = new StringBuilder();
                        sb.append(str.charAt(i3));
                        i++;
                        i2 = 1;
                    } else {
                        sb.append(str.charAt(i3));
                    }
                } else {
                    int iMeasureText2 = (int) textPaint.measureText(sb.toString());
                    if (this.f12450ad < iMeasureText2) {
                        this.f12450ad = iMeasureText2;
                    }
                    if (iMeasureText2 > iWidth) {
                        str2 = str2 + sb.toString() + "\n";
                        sb = new StringBuilder();
                        sb.append("" + str.charAt(i3));
                        i2 = 2;
                        i++;
                    } else {
                        sb.append(str.charAt(i3));
                    }
                }
            } else {
                sb.append(str.charAt(i3));
            }
        }
        if (i2 > 0) {
            str2 = str2 + ((Object) sb);
            i++;
            int iMeasureText3 = (int) textPaint.measureText(sb.toString());
            if (this.f12450ad < iMeasureText3) {
                this.f12450ad = iMeasureText3;
            }
        }
        this.f12451ae = (int) ((i + 0.4d) * textPaint.getTextSize());
        if (this.f12449ac != null) {
            this.f12449ac.recycle();
            this.f12449ac = null;
        }
        this.f12449ac = Bitmap.createBitmap(this.f12450ad, this.f12451ae, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(this.f12449ac);
        int i4 = 0;
        int i5 = 1;
        while (true) {
            int iIndexOf = str2.indexOf("\n", i4);
            if (iIndexOf == -1) {
                canvas.drawText(str2.substring(i4, str2.length()), 0.0f, textPaint.getTextSize() * i5, textPaint);
                return true;
            }
            canvas.drawText(str2.substring(i4, iIndexOf), 0.0f, textPaint.getTextSize() * i5, textPaint);
            i4 = iIndexOf + 1;
            i5++;
        }
    }

    /* renamed from: b */
    private float m12153b(String str) {
        TextPaint textPaint = new TextPaint();
        textPaint.setAntiAlias(true);
        textPaint.setDither(true);
        textPaint.setTextSize(this.f12452af[this.f13088c] * this.f13089d);
        textPaint.setColor(this.f13087b);
        return textPaint.measureText(str);
    }

    /* renamed from: a */
    public boolean m12158a(String str, int i) {
        mo12136a(this.f13062E, this.f13063F, str, i);
        return true;
    }

    @Override // com.sec.vip.amschaton.C3588u
    /* renamed from: a */
    public boolean mo12136a(float f, float f2, String str, int i) {
        float f3;
        float f4;
        float f5;
        if (this.f12458al) {
            float f6 = this.f13062E;
            float f7 = this.f13063F;
            switch (this.f13059B) {
                case 5:
                    f3 = this.f12456aj;
                    f4 = f;
                    break;
                case 6:
                    f3 = f2;
                    f4 = this.f12455ai;
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
            return mo12134a(f4, f5, f6, f7, str, i);
        }
        this.f13097l.setAlpha(i);
        if (this.f12449ac == null) {
            m12157a(str);
        }
        Rect rect = new Rect((int) f, (int) f2, (int) (this.f12450ad + f), (int) (this.f12451ae + f2));
        this.f13092g.drawBitmap(this.f13094i, 0.0f, 0.0f, (Paint) null);
        this.f13092g.drawBitmap(this.f12449ac, f, f2, this.f13097l);
        m12816a(rect.left, rect.top, rect.right, rect.bottom);
        return true;
    }

    @Override // com.sec.vip.amschaton.C3588u
    /* renamed from: a */
    public boolean mo12134a(float f, float f2, float f3, float f4, String str, int i) {
        return m12154b(f, f2, f3, f4, str, i, false);
    }

    /* renamed from: b */
    private boolean m12154b(float f, float f2, float f3, float f4, String str, int i, boolean z) {
        this.f13097l.setAlpha(i);
        RectF rectF = new RectF(f, f2, f3, f4);
        if (z) {
            m12156a(rectF, str);
        }
        this.f13092g.drawBitmap(this.f13094i, 0.0f, 0.0f, (Paint) null);
        float f5 = ((f + f3) - this.f12450ad) / 2.0f;
        float f6 = ((f + f3) + this.f12450ad) / 2.0f;
        switch (this.f12457ak) {
            case 105:
                this.f13092g.drawBitmap(this.f12449ac, f3 - this.f12450ad, f2, this.f13097l);
                rectF.set(f3 - this.f12450ad, f2, f3, this.f12451ae + f2);
                break;
            case 106:
                if (this.f13066I) {
                    this.f13092g.drawBitmap(this.f12449ac, f5, f2, this.f13097l);
                    rectF.set(f5, f4 - this.f12451ae, f6, f4);
                    break;
                } else {
                    this.f13092g.drawBitmap(this.f12449ac, f, f2, this.f13097l);
                    rectF.set(f, f2, this.f12450ad + f, this.f12451ae + f2);
                    break;
                }
            case 107:
            default:
                this.f13092g.drawBitmap(this.f12449ac, f, f2, this.f13097l);
                rectF.set(f, f2, this.f12450ad + f, this.f12451ae + f2);
                break;
            case 108:
                if (this.f13066I) {
                    this.f13092g.drawBitmap(this.f12449ac, f5, f2, this.f13097l);
                    rectF.set(f5, f2, f6, this.f12451ae + f2);
                    break;
                } else {
                    this.f13092g.drawBitmap(this.f12449ac, f, f2, this.f13097l);
                    rectF.set(f, f2, this.f12450ad + f, this.f12451ae + f2);
                    break;
                }
        }
        m12816a(rectF.left, rectF.top, rectF.right, rectF.bottom);
        return true;
    }

    /* renamed from: a */
    public void m12155a(InterfaceC3582o interfaceC3582o) {
        this.f12448ab = interfaceC3582o;
    }
}
