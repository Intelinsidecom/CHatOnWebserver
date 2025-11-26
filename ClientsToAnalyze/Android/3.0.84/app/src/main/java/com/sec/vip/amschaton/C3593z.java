package com.sec.vip.amschaton;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.v4.view.MotionEventCompat;
import com.sec.amsoma.structure.AMS_RECT;
import com.sec.spp.push.dlc.api.DlcApi;

/* compiled from: AMSObjectStamp.java */
/* renamed from: com.sec.vip.amschaton.z */
/* loaded from: classes.dex */
public class C3593z extends C3588u {

    /* renamed from: Z */
    float f13132Z;

    /* renamed from: aa */
    float f13133aa;

    /* renamed from: ab */
    private Bitmap f13134ab;

    /* renamed from: ac */
    private int f13135ac;

    /* renamed from: ad */
    private C3410al f13136ad;

    /* renamed from: ae */
    private final int f13137ae;

    /* renamed from: af */
    private final int f13138af;

    /* renamed from: ag */
    private boolean f13139ag;

    /* renamed from: ah */
    private float f13140ah;

    /* renamed from: ai */
    private float f13141ai;

    /* renamed from: aj */
    private float f13142aj;

    /* renamed from: ak */
    private float f13143ak;

    /* renamed from: al */
    private int f13144al;

    /* renamed from: am */
    private boolean f13145am;

    public C3593z(int i, int i2, int i3, boolean z) {
        this(i, i2, i3, 0, z);
    }

    public C3593z(int i, int i2, int i3, int i4, boolean z) {
        super(i, i2, i3, i4, 0, 0);
        this.f13135ac = 55;
        this.f13136ad = C3410al.m12173a();
        this.f13137ae = 12;
        this.f13138af = 6;
        this.f13139ag = false;
        this.f13140ah = 0.0f;
        this.f13141ai = 0.0f;
        this.f13142aj = 0.0f;
        this.f13143ak = 0.0f;
        this.f13144al = 0;
        this.f13145am = false;
        this.f13132Z = 0.0f;
        this.f13133aa = 0.0f;
        boolean z2 = false;
        if (i < this.f13136ad.m12208k()) {
            this.f13134ab = this.f13136ad.m12195d(i, true);
            z2 = true;
        } else if (i < this.f13136ad.m12208k() + this.f13136ad.m12205i()) {
            this.f13134ab = this.f13136ad.m12176a(this.f13082a - this.f13136ad.m12208k(), 7);
        } else if (i >= 20000 && i < 30000) {
            this.f13134ab = this.f13136ad.m12198e(this.f13082a - 20000, true);
        } else if (i >= 30000 && i < 40000) {
            this.f13134ab = this.f13136ad.m12187b(this.f13082a - 30000, true);
        } else if (i >= 40000) {
            this.f13134ab = this.f13136ad.m12177a(this.f13082a - 40000, true);
        } else {
            this.f13134ab = this.f13136ad.m12195d(0, true);
            z2 = true;
        }
        this.f13097l = new Paint();
        this.f13097l.setAntiAlias(true);
        this.f13097l.setDither(true);
        this.f13097l.setFilterBitmap(true);
        if (this.f13134ab == null || (z2 && !C3410al.m12173a().m12204h(i))) {
            this.f13135ac = 110;
        } else {
            this.f13135ac = this.f13134ab.getWidth();
        }
        this.f13145am = z;
    }

    public C3593z(int i, int i2, int i3, int i4, Bitmap bitmap, boolean z) {
        super(i, i2, i3, i4, 0, 0);
        this.f13135ac = 55;
        this.f13136ad = C3410al.m12173a();
        this.f13137ae = 12;
        this.f13138af = 6;
        this.f13139ag = false;
        this.f13140ah = 0.0f;
        this.f13141ai = 0.0f;
        this.f13142aj = 0.0f;
        this.f13143ak = 0.0f;
        this.f13144al = 0;
        this.f13145am = false;
        this.f13132Z = 0.0f;
        this.f13133aa = 0.0f;
        this.f13134ab = bitmap;
        this.f13097l = new Paint();
        this.f13097l.setAntiAlias(true);
        this.f13097l.setDither(true);
        this.f13097l.setFilterBitmap(true);
        this.f13135ac = this.f13134ab.getWidth();
        this.f13145am = z;
    }

    @Override // com.sec.vip.amschaton.C3588u
    /* renamed from: a */
    public void mo12131a(float f) {
        super.mo12131a(f);
        if (this.f13135ac == 0) {
            this.f13135ac = (int) ((55.0f * this.f13089d) + 0.5d);
        } else {
            this.f13135ac = (int) (((this.f13135ac / 2) * this.f13089d) + 0.5d);
        }
    }

    @Override // com.sec.vip.amschaton.C3588u
    /* renamed from: a */
    public boolean mo12838a(AMS_RECT ams_rect) {
        if (this.f13082a >= 0 && this.f13082a < this.f13136ad.m12208k()) {
            if (!this.f13110y.VipAMS_EncodeNewStamp(this.f13111z, ams_rect, (byte) 0, (byte) 2, (byte) this.f13082a, null, 0, 0, 0)) {
                mo12815a();
                return false;
            }
        } else if (this.f13082a < this.f13136ad.m12208k() + this.f13136ad.m12205i()) {
            if (!this.f13110y.VipAMS_EncodeNewStamp(this.f13111z, ams_rect, (byte) 0, (byte) 2, (byte) this.f13082a, null, 0, 0, 0)) {
                mo12815a();
                return false;
            }
        } else {
            int[] iArr = new int[this.f13134ab.getWidth() * this.f13134ab.getHeight()];
            this.f13134ab.getPixels(iArr, 0, this.f13134ab.getWidth(), 0, 0, this.f13134ab.getWidth(), this.f13134ab.getHeight());
            if (!this.f13110y.VipAMS_EncodeNewStamp(this.f13111z, ams_rect, (byte) 2, (byte) 2, (byte) this.f13082a, iArr, this.f13134ab.getWidth(), this.f13134ab.getHeight(), 32)) {
                mo12815a();
                return false;
            }
        }
        mo12836a(new RectF(ams_rect.nLeft, ams_rect.nTop, ams_rect.nRight, ams_rect.nBottom), MotionEventCompat.ACTION_MASK);
        return true;
    }

    @Override // com.sec.vip.amschaton.C3588u
    /* renamed from: b */
    public boolean mo12144b(AMS_RECT ams_rect) {
        if (!this.f13065H || this.f13067J == null) {
            return false;
        }
        if (this.f13090e < 0) {
            this.f13090e += 360;
        }
        if (!this.f13110y.VipAMS_ChangeSelectStamp(this.f13111z, this.f13067J, ams_rect, this.f13068K.getM_cStyle(), this.f13068K.getM_cSize(), this.f13090e)) {
            return false;
        }
        this.f13068K.setM_TRect(ams_rect);
        this.f13068K.setM_nRotation(this.f13090e);
        mo12836a(new RectF(ams_rect.nLeft, ams_rect.nTop, ams_rect.nRight, ams_rect.nBottom), MotionEventCompat.ACTION_MASK);
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
        return mo12835a(f, f2, i, true);
    }

    @Override // com.sec.vip.amschaton.C3588u
    /* renamed from: a */
    public boolean mo12835a(float f, float f2, int i, boolean z) {
        float f3;
        float f4;
        if (this.f13145am) {
            float f5 = this.f13062E;
            float f6 = this.f13063F;
            int i2 = this.f13059B;
            if (f5 > f) {
                f3 = f;
            } else {
                f3 = f5;
                f5 = f;
            }
            if (f6 > f2) {
                f4 = f2;
            } else {
                f4 = f6;
                f6 = f2;
            }
            return mo12831a(f3, f4, f5, f6, i, z);
        }
        Rect rect = new Rect((int) f, (int) f2, (int) (this.f13135ac + f), (int) (this.f13135ac + f2));
        if (z) {
            this.f13092g.drawBitmap(this.f13094i, 0.0f, 0.0f, (Paint) null);
        }
        if (i < 256) {
            this.f13097l.setAlpha(i);
            this.f13092g.drawBitmap(this.f13134ab, (Rect) null, rect, this.f13097l);
            m12843b(rect.left, rect.top, rect.right, rect.bottom, this.f13090e);
        } else {
            this.f13097l.setAlpha(MotionEventCompat.ACTION_MASK);
            this.f13092g.drawBitmap(C3410al.m12173a().m12176a(this.f13082a - this.f13136ad.m12208k(), i + DlcApi.RC_SVC_NOT_CONNECTED), (Rect) null, rect, this.f13097l);
        }
        return true;
    }

    @Override // com.sec.vip.amschaton.C3588u
    /* renamed from: a */
    public boolean mo12830a(float f, float f2, float f3, float f4, int i) {
        return mo12831a(f, f2, f3, f4, i, true);
    }

    @Override // com.sec.vip.amschaton.C3588u
    /* renamed from: a */
    public boolean mo12831a(float f, float f2, float f3, float f4, int i, boolean z) {
        RectF rectF = new RectF(f, f2, f3, f4);
        if (z && !this.f13094i.isRecycled()) {
            this.f13092g.drawBitmap(this.f13094i, 0.0f, 0.0f, (Paint) null);
        }
        float fAbs = Math.abs(f3 - f) / this.f13134ab.getWidth();
        float fAbs2 = Math.abs(f4 - f2) / this.f13134ab.getHeight();
        Matrix matrix = new Matrix();
        matrix.reset();
        Point pointA = m12814a(rectF);
        matrix.postScale(fAbs, fAbs2);
        matrix.postTranslate(rectF.left, rectF.top);
        matrix.postRotate(this.f13090e, pointA.x, pointA.y);
        if (i < 256) {
            this.f13097l.setAlpha(i);
            if (!this.f13134ab.isRecycled()) {
                this.f13092g.drawBitmap(this.f13134ab, matrix, this.f13097l);
            }
            m12843b(f - ((this.f13088c * this.f13089d) / 2.0f), f2 - ((this.f13088c * this.f13089d) / 2.0f), f3 + ((this.f13088c * this.f13089d) / 2.0f), f4 + ((this.f13088c * this.f13089d) / 2.0f), this.f13090e);
            return true;
        }
        this.f13097l.setAlpha(MotionEventCompat.ACTION_MASK);
        this.f13092g.drawBitmap(C3410al.m12173a().m12176a(this.f13082a - this.f13136ad.m12208k(), i + DlcApi.RC_SVC_NOT_CONNECTED), matrix, this.f13097l);
        return true;
    }

    @Override // com.sec.vip.amschaton.C3588u
    /* renamed from: a */
    public boolean mo12836a(RectF rectF, int i) {
        return mo12837a(rectF, i, true);
    }

    @Override // com.sec.vip.amschaton.C3588u
    /* renamed from: a */
    public boolean mo12837a(RectF rectF, int i, boolean z) {
        return this.f13145am ? mo12831a(rectF.left, rectF.top, rectF.right, rectF.bottom, i, z) : mo12835a(rectF.left, rectF.top, i, z);
    }

    @Override // com.sec.vip.amschaton.C3588u
    /* renamed from: c */
    public boolean mo12146c(float f, float f2) {
        if (this.f13059B != 2) {
            return false;
        }
        RectF rectFB = m12840b();
        float f3 = 18.0f * this.f13089d;
        float[] fArr = {f, f2};
        RectF rectF = new RectF(this.f13068K.getM_TRect().nLeft - f3, this.f13068K.getM_TRect().nTop - f3, this.f13068K.getM_TRect().nRight + f3, f3 + this.f13068K.getM_TRect().nBottom);
        int m_nRotation = this.f13068K.getM_nRotation();
        Matrix matrix = new Matrix();
        matrix.reset();
        matrix.setRotate((90 - m_nRotation) % 90, rectF.centerX(), rectF.centerY());
        matrix.mapPoints(fArr);
        return rectF.contains(fArr[0], fArr[1]) || rectFB.contains(f, f2);
    }

    /* renamed from: d */
    public void m12863d(boolean z) {
        this.f13139ag = z;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0338  */
    @Override // com.sec.vip.amschaton.C3588u
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean mo12147d(float r14, float r15) {
        /*
            Method dump skipped, instructions count: 982
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.vip.amschaton.C3593z.mo12147d(float, float):boolean");
    }

    @Override // com.sec.vip.amschaton.C3588u
    /* renamed from: e */
    public boolean mo12148e(float f, float f2) {
        if (this.f13110y == null) {
            return false;
        }
        if (this.f13145am) {
            float f3 = this.f13135ac * 0.5f;
            switch (this.f13059B) {
                case 1:
                    mo12830a(f - f3, f2 - f3, f + f3, f3 + f2, 128);
                    break;
                case 3:
                    if (this.f13091f) {
                        AMS_RECT ams_rect = new AMS_RECT();
                        int i = this.f13068K.getM_TRect().nRight - this.f13068K.getM_TRect().nLeft;
                        int i2 = this.f13068K.getM_TRect().nBottom - this.f13068K.getM_TRect().nTop;
                        Point pointC = m12848c();
                        this.f13090e = (int) (Math.toDegrees(Math.atan2(pointC.y - f2, pointC.x - f)) - 90.0d);
                        ams_rect.nLeft = this.f13068K.getM_TRect().nLeft;
                        ams_rect.nTop = this.f13068K.getM_TRect().nTop;
                        this.f13071N = this.f13092g.getWidth();
                        this.f13072O = this.f13092g.getHeight();
                        if (ams_rect.nLeft < 0) {
                            ams_rect.nLeft = (short) 0;
                        } else if (ams_rect.nLeft > this.f13071N - i) {
                            ams_rect.nLeft = (short) (this.f13071N - i);
                        }
                        if (ams_rect.nTop < 0) {
                            ams_rect.nTop = (short) 0;
                        } else if (ams_rect.nTop > this.f13072O - i2) {
                            ams_rect.nTop = (short) (this.f13072O - i2);
                        }
                        ams_rect.nRight = (short) (this.f13068K.getM_TRect().nLeft + i);
                        ams_rect.nBottom = (short) (this.f13068K.getM_TRect().nTop + i2);
                        mo12830a(ams_rect.nLeft, ams_rect.nTop, ams_rect.nRight, ams_rect.nBottom, 128);
                    } else {
                        mo12830a(f - this.f13060C, f2 - this.f13061D, ((this.f13068K.getM_TRect().nRight - this.f13068K.getM_TRect().nLeft) + f) - this.f13060C, ((this.f13068K.getM_TRect().nBottom - this.f13068K.getM_TRect().nTop) + f2) - this.f13061D, 128);
                    }
                    if (this.f13065H) {
                        this.f13066I = true;
                        break;
                    }
                    break;
                case 5:
                case 6:
                    float[] fArr = {f, f2};
                    Matrix matrix = new Matrix();
                    matrix.setRotate(-this.f13090e, this.f13079X.x, this.f13079X.y);
                    matrix.mapPoints(fArr);
                    PointF pointFM12862g = m12862g(fArr[0], fArr[1]);
                    mo12832a(pointFM12862g.x, pointFM12862g.y, 128);
                    if (this.f13065H) {
                        this.f13066I = true;
                    }
                    m12818a(this.f13144al, true);
                    break;
                case 7:
                    float f4 = 12.0f * this.f13089d;
                    float f5 = 6.0f * this.f13089d;
                    float f6 = (int) (((this.f13068K.getM_TRect().nTop - f4) - f5) + 0.5f);
                    float f7 = (int) (f5 + this.f13068K.getM_TRect().nRight + f4 + 0.5f);
                    float[] fArr2 = {f, f2};
                    Matrix matrix2 = new Matrix();
                    RectF rectF = new RectF(this.f13068K.getM_TRect().nLeft, this.f13068K.getM_TRect().nTop, this.f13068K.getM_TRect().nRight, this.f13068K.getM_TRect().nBottom);
                    matrix2.setRotate(-this.f13090e, rectF.centerX(), rectF.centerY());
                    matrix2.mapPoints(fArr2);
                    if (!(Math.abs(f7 - fArr2[0]) < f4 && Math.abs(f6 - fArr2[1]) < f4)) {
                        m12818a(101, false);
                        this.f13059B = 2;
                        break;
                    }
                    break;
            }
            return true;
        }
        switch (this.f13059B) {
            case 1:
            case 3:
                if (this.f13065H) {
                    mo12832a(f - this.f13060C, f2 - this.f13061D, 128);
                    this.f13066I = true;
                    break;
                } else {
                    mo12832a(f - this.f13060C, f2 - this.f13061D, MotionEventCompat.ACTION_MASK);
                    break;
                }
            case 7:
                float f8 = 12.0f * this.f13089d;
                if (!(Math.abs(((float) ((int) ((((float) this.f13068K.getM_TRect().nRight) + f8) + 0.5f))) - f) < f8 && Math.abs(((float) ((int) ((((float) this.f13068K.getM_TRect().nTop) - f8) + 0.5f))) - f2) < f8)) {
                    m12818a(101, false);
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
        if (this.f13145am) {
            AMS_RECT ams_rect = new AMS_RECT();
            float f3 = this.f13135ac * 0.5f;
            switch (this.f13059B) {
                case 1:
                    this.f13059B = 0;
                    ams_rect.nLeft = (short) (f - f3);
                    ams_rect.nTop = (short) (f2 - f3);
                    ams_rect.nRight = (short) (f + f3);
                    ams_rect.nBottom = (short) (f3 + f2);
                    boolean zMo12838a = mo12838a(ams_rect);
                    this.f13091f = false;
                    return zMo12838a;
                case 3:
                    this.f13059B = 2;
                    int i = this.f13068K.getM_TRect().nRight - this.f13068K.getM_TRect().nLeft;
                    int i2 = this.f13068K.getM_TRect().nBottom - this.f13068K.getM_TRect().nTop;
                    if (this.f13091f) {
                        Point pointC = m12848c();
                        this.f13090e = (int) (Math.toDegrees(Math.atan2(pointC.y - f2, pointC.x - f)) - 90.0d);
                        ams_rect.nLeft = this.f13068K.getM_TRect().nLeft;
                        ams_rect.nTop = this.f13068K.getM_TRect().nTop;
                        this.f13071N = this.f13092g.getWidth();
                        this.f13072O = this.f13092g.getHeight();
                        if (ams_rect.nLeft < 0) {
                            ams_rect.nLeft = (short) 0;
                        } else if (ams_rect.nLeft > this.f13071N - i) {
                            ams_rect.nLeft = (short) (this.f13071N - i);
                        }
                        if (ams_rect.nTop < 0) {
                            ams_rect.nTop = (short) 0;
                        } else if (ams_rect.nTop > this.f13072O - i2) {
                            ams_rect.nTop = (short) (this.f13072O - i2);
                        }
                        ams_rect.nRight = (short) (i + this.f13068K.getM_TRect().nLeft);
                        ams_rect.nBottom = (short) (this.f13068K.getM_TRect().nTop + i2);
                    } else {
                        ams_rect.nLeft = (short) (f - this.f13060C);
                        ams_rect.nTop = (short) (f2 - this.f13061D);
                        this.f13071N = this.f13092g.getWidth();
                        this.f13072O = this.f13092g.getHeight();
                        if (ams_rect.nLeft < 0) {
                            ams_rect.nLeft = (short) 0;
                        } else if (ams_rect.nLeft > this.f13071N - i) {
                            ams_rect.nLeft = (short) (this.f13071N - i);
                        }
                        if (ams_rect.nTop < 0) {
                            ams_rect.nTop = (short) 0;
                        } else if (ams_rect.nTop > this.f13072O - i2) {
                            ams_rect.nTop = (short) (this.f13072O - i2);
                        }
                        ams_rect.nRight = (short) (i + ams_rect.nLeft);
                        ams_rect.nBottom = (short) (ams_rect.nTop + i2);
                    }
                    if (!this.f13066I) {
                        mo12830a(ams_rect.nLeft, ams_rect.nTop, ams_rect.nRight, ams_rect.nBottom, MotionEventCompat.ACTION_MASK);
                        break;
                    } else {
                        this.f13066I = false;
                        boolean zMo12144b = mo12144b(ams_rect);
                        this.f13091f = false;
                        return zMo12144b;
                    }
                case 4:
                case 5:
                case 6:
                    m12818a(102, false);
                    m12818a(103, false);
                    m12818a(104, false);
                    this.f13059B = 2;
                    float[] fArr = {f, f2};
                    Matrix matrix = new Matrix();
                    matrix.setRotate(-this.f13090e, this.f13079X.x, this.f13079X.y);
                    matrix.mapPoints(fArr);
                    PointF pointFM12862g = m12862g(fArr[0], fArr[1]);
                    if (!this.f13066I) {
                        mo12832a(pointFM12862g.x, pointFM12862g.y, MotionEventCompat.ACTION_MASK);
                        break;
                    } else {
                        this.f13066I = false;
                        ams_rect.nLeft = (short) this.f13062E;
                        ams_rect.nTop = (short) this.f13063F;
                        ams_rect.nRight = (short) pointFM12862g.x;
                        ams_rect.nBottom = (short) pointFM12862g.y;
                        if (pointFM12862g.x < this.f13062E) {
                            ams_rect.nLeft = (short) pointFM12862g.x;
                            ams_rect.nRight = (short) this.f13062E;
                        }
                        if (pointFM12862g.y < this.f13063F) {
                            ams_rect.nTop = (short) pointFM12862g.y;
                            ams_rect.nBottom = (short) this.f13063F;
                        }
                        boolean zMo12144b2 = mo12144b(ams_rect);
                        this.f13091f = false;
                        return zMo12144b2;
                    }
                case 7:
                    m12818a(101, false);
                    this.f13076S.mo12776a();
                    break;
            }
            this.f13091f = false;
            return false;
        }
        AMS_RECT ams_rect2 = new AMS_RECT();
        switch (this.f13059B) {
            case 1:
                this.f13059B = 0;
                ams_rect2.nLeft = (short) (f - this.f13060C);
                ams_rect2.nTop = (short) (f2 - this.f13061D);
                ams_rect2.nRight = (short) ((f - this.f13060C) + this.f13135ac);
                ams_rect2.nBottom = (short) ((f2 - this.f13061D) + this.f13135ac);
                boolean zMo12838a2 = mo12838a(ams_rect2);
                this.f13091f = false;
                return zMo12838a2;
            case 3:
                this.f13059B = 2;
                if (!this.f13066I) {
                    mo12832a(f - this.f13060C, f2 - this.f13061D, MotionEventCompat.ACTION_MASK);
                    break;
                } else {
                    ams_rect2.nLeft = (short) (f - this.f13060C);
                    ams_rect2.nTop = (short) (f2 - this.f13061D);
                    ams_rect2.nRight = (short) ((f - this.f13060C) + this.f13135ac);
                    ams_rect2.nBottom = (short) ((f2 - this.f13061D) + this.f13135ac);
                    this.f13066I = false;
                    boolean zMo12144b3 = mo12144b(ams_rect2);
                    this.f13091f = false;
                    return zMo12144b3;
                }
            case 7:
                m12818a(101, false);
                this.f13076S.mo12776a();
                break;
        }
        this.f13091f = false;
        return false;
    }

    @Override // com.sec.vip.amschaton.C3588u
    /* renamed from: e */
    public void mo12853e() {
        if (this.f13134ab != null) {
            this.f13134ab.recycle();
            this.f13134ab = null;
        }
    }

    /* renamed from: g */
    private PointF m12862g(float f, float f2) {
        float f3 = f - this.f13062E;
        float f4 = f2 - this.f13063F;
        float f5 = 24.0f * this.f13089d;
        if (this.f13144al == 105 || this.f13144al == 107) {
            if (0.0f <= f3 && f3 < f5) {
                f = this.f13062E + f5;
            } else if (f3 > this.f13135ac) {
                f = this.f13062E + this.f13135ac;
            } else if ((-f5) < f3 && f3 < 0.0f) {
                f = this.f13062E - f5;
            } else if ((-this.f13135ac) > f3) {
                f = this.f13062E - this.f13135ac;
            }
            if (f > this.f13062E) {
                f2 = this.f13063F + (f - this.f13062E);
            } else {
                f2 = this.f13063F - (f - this.f13062E);
            }
        } else if (this.f13144al == 106 || this.f13144al == 108) {
            if (0.0f <= f4 && f4 < f5) {
                f2 = this.f13063F + f5;
            } else if (f4 > this.f13135ac) {
                f2 = this.f13063F + this.f13135ac;
            } else if ((-f5) < f4 && f4 < 0.0f) {
                f2 = this.f13063F - f5;
            } else if ((-this.f13135ac) > f4) {
                f2 = this.f13063F - this.f13135ac;
            }
            if (f2 > this.f13063F) {
                f = this.f13062E + (f2 - this.f13063F);
            } else {
                f = this.f13062E - (f2 - this.f13063F);
            }
        }
        return new PointF(f, f2);
    }
}
