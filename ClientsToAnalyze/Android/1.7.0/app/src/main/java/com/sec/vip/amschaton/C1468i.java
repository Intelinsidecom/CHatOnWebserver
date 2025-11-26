package com.sec.vip.amschaton;

import android.R;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.sec.amsoma.AMSLibs;
import com.sec.amsoma.structure.AMS_OBJECT_DATA;
import com.sec.amsoma.structure.AMS_RECT;
import com.sec.amsoma.structure.AMS_SELECT_OBJECT;
import com.sec.amsoma.structure.AMS_UI_DATA;

/* compiled from: AMSObject.java */
/* renamed from: com.sec.vip.amschaton.i */
/* loaded from: classes.dex */
public class C1468i {

    /* renamed from: R */
    public static float f5120R = 20.0f;

    /* renamed from: S */
    public static int f5121S = 30;

    /* renamed from: A */
    protected AMS_UI_DATA f5122A;

    /* renamed from: B */
    protected int f5123B;

    /* renamed from: C */
    protected int f5124C;

    /* renamed from: D */
    protected int f5125D;

    /* renamed from: E */
    protected float f5126E;

    /* renamed from: F */
    protected float f5127F;

    /* renamed from: G */
    protected boolean f5128G;

    /* renamed from: H */
    protected boolean f5129H;

    /* renamed from: I */
    protected boolean f5130I;

    /* renamed from: J */
    protected AMS_SELECT_OBJECT f5131J;

    /* renamed from: K */
    protected AMS_OBJECT_DATA f5132K;

    /* renamed from: L */
    protected Rect f5133L;

    /* renamed from: M */
    protected Drawable f5134M;

    /* renamed from: N */
    protected int f5135N;

    /* renamed from: O */
    protected int f5136O;

    /* renamed from: P */
    protected InterfaceC1545j f5137P;

    /* renamed from: Q */
    protected final float f5138Q;

    /* renamed from: T */
    protected int f5139T;

    /* renamed from: U */
    protected final float f5140U;

    /* renamed from: V */
    private float[] f5141V;

    /* renamed from: W */
    private int f5142W;

    /* renamed from: a */
    private float f5143a;

    /* renamed from: b */
    private float f5144b;

    /* renamed from: c */
    protected int f5145c;

    /* renamed from: d */
    protected int f5146d;

    /* renamed from: e */
    protected int f5147e;

    /* renamed from: f */
    protected float f5148f;

    /* renamed from: g */
    protected Canvas f5149g;

    /* renamed from: h */
    protected Bitmap f5150h;

    /* renamed from: i */
    protected Bitmap f5151i;

    /* renamed from: j */
    protected Canvas f5152j;

    /* renamed from: k */
    protected Bitmap f5153k;

    /* renamed from: l */
    protected Paint f5154l;

    /* renamed from: m */
    protected Drawable f5155m;

    /* renamed from: n */
    protected Drawable f5156n;

    /* renamed from: o */
    protected Drawable f5157o;

    /* renamed from: p */
    protected Drawable f5158p;

    /* renamed from: q */
    protected Drawable f5159q;

    /* renamed from: r */
    protected Drawable f5160r;

    /* renamed from: s */
    protected Drawable f5161s;

    /* renamed from: t */
    protected Drawable f5162t;

    /* renamed from: u */
    protected Drawable f5163u;

    /* renamed from: v */
    protected Paint f5164v;

    /* renamed from: w */
    protected DashPathEffect f5165w;

    /* renamed from: x */
    protected DashPathEffect f5166x;

    /* renamed from: y */
    protected AMSLibs f5167y;

    /* renamed from: z */
    protected int f5168z;

    /* renamed from: a */
    public void m5295a(InterfaceC1545j interfaceC1545j) {
        this.f5137P = interfaceC1545j;
    }

    public C1468i(int i, int i2, int i3) {
        this.f5148f = 1.0f;
        this.f5149g = null;
        this.f5150h = null;
        this.f5151i = null;
        this.f5152j = null;
        this.f5153k = null;
        this.f5154l = null;
        this.f5155m = null;
        this.f5156n = null;
        this.f5157o = null;
        this.f5158p = null;
        this.f5159q = null;
        this.f5160r = null;
        this.f5161s = null;
        this.f5162t = null;
        this.f5163u = null;
        this.f5164v = null;
        this.f5165w = null;
        this.f5166x = null;
        this.f5167y = null;
        this.f5168z = 0;
        this.f5122A = null;
        this.f5123B = 0;
        this.f5124C = 0;
        this.f5125D = 0;
        this.f5126E = 0.0f;
        this.f5127F = 0.0f;
        this.f5128G = true;
        this.f5129H = false;
        this.f5130I = false;
        this.f5131J = null;
        this.f5132K = null;
        this.f5133L = null;
        this.f5134M = null;
        this.f5135N = 0;
        this.f5136O = 0;
        this.f5137P = null;
        this.f5138Q = 4096.0f;
        this.f5143a = 0.0f;
        this.f5144b = 0.0f;
        this.f5141V = null;
        this.f5142W = 0;
        this.f5139T = 5;
        this.f5140U = 2.0f;
        m5283b(i, i2, i3);
    }

    public C1468i(int i, int i2, int i3, int i4, int i5) {
        this.f5148f = 1.0f;
        this.f5149g = null;
        this.f5150h = null;
        this.f5151i = null;
        this.f5152j = null;
        this.f5153k = null;
        this.f5154l = null;
        this.f5155m = null;
        this.f5156n = null;
        this.f5157o = null;
        this.f5158p = null;
        this.f5159q = null;
        this.f5160r = null;
        this.f5161s = null;
        this.f5162t = null;
        this.f5163u = null;
        this.f5164v = null;
        this.f5165w = null;
        this.f5166x = null;
        this.f5167y = null;
        this.f5168z = 0;
        this.f5122A = null;
        this.f5123B = 0;
        this.f5124C = 0;
        this.f5125D = 0;
        this.f5126E = 0.0f;
        this.f5127F = 0.0f;
        this.f5128G = true;
        this.f5129H = false;
        this.f5130I = false;
        this.f5131J = null;
        this.f5132K = null;
        this.f5133L = null;
        this.f5134M = null;
        this.f5135N = 0;
        this.f5136O = 0;
        this.f5137P = null;
        this.f5138Q = 4096.0f;
        this.f5143a = 0.0f;
        this.f5144b = 0.0f;
        this.f5141V = null;
        this.f5142W = 0;
        this.f5139T = 5;
        this.f5140U = 2.0f;
        m5283b(i, i2, i3);
        this.f5135N = i4;
        this.f5136O = i5;
    }

    /* renamed from: b */
    private void m5283b(int i, int i2, int i3) {
        this.f5146d = i2;
        this.f5145c = i;
        this.f5147e = i3;
        this.f5149g = null;
        this.f5165w = new DashPathEffect(new float[]{5.0f, 5.0f}, 0.0f);
        this.f5166x = new DashPathEffect(new float[]{3.0f, 7.0f}, -1.0f);
        this.f5164v = new Paint();
        this.f5164v.setStyle(Paint.Style.STROKE);
        this.f5164v.setAntiAlias(true);
        this.f5164v.setDither(true);
    }

    /* renamed from: a */
    public void m5293a(AMSLibs aMSLibs, int i, AMS_UI_DATA ams_ui_data) {
        this.f5167y = aMSLibs;
        this.f5168z = i;
        this.f5122A = ams_ui_data;
    }

    /* renamed from: a */
    public void m5288a(Bitmap bitmap, Bitmap bitmap2) {
        this.f5150h = bitmap;
        this.f5149g = new Canvas(this.f5150h);
        this.f5151i = bitmap2;
        this.f5152j = new Canvas(this.f5151i);
        this.f5152j.drawBitmap(this.f5150h, 0.0f, 0.0f, (Paint) null);
    }

    /* renamed from: a */
    public void m5287a(Bitmap bitmap) {
        m5288a(bitmap, bitmap);
    }

    /* renamed from: a */
    public void mo4887a(float f) {
        this.f5148f = f;
        this.f5165w = new DashPathEffect(new float[]{this.f5148f * 5.0f, this.f5148f * 5.0f}, 0.0f);
        this.f5166x = new DashPathEffect(new float[]{3.0f * this.f5148f, 7.0f * this.f5148f}, -this.f5148f);
    }

    /* renamed from: a */
    public void m5296a(boolean z) {
        this.f5129H = z;
        if (z) {
            this.f5123B = 2;
        } else {
            this.f5123B = 0;
        }
    }

    /* renamed from: b */
    public void m5302b(boolean z) {
        this.f5128G = z;
    }

    /* renamed from: a */
    public void m5294a(AMS_SELECT_OBJECT ams_select_object) {
        this.f5131J = ams_select_object;
        if (this.f5167y != null) {
            this.f5132K = new AMS_OBJECT_DATA();
            this.f5167y.VipAMS_GetSelectObjectData(ams_select_object.getM_pSelectObjectData(), this.f5132K);
        } else {
            this.f5132K = null;
        }
    }

    /* renamed from: b */
    public void m5300b(Bitmap bitmap) {
        this.f5153k = bitmap;
    }

    /* renamed from: b */
    public boolean mo4948b(AMS_RECT ams_rect) {
        return false;
    }

    /* renamed from: a */
    public boolean mo4946a(int i, int i2, int i3) {
        this.f5145c = i;
        this.f5146d = i2;
        this.f5147e = i3;
        return false;
    }

    /* renamed from: a */
    public boolean mo4947a(AMS_RECT ams_rect) {
        return false;
    }

    /* renamed from: e */
    public void mo4897e(float f, float f2) {
    }

    /* renamed from: f */
    public void mo4898f(float f, float f2) {
    }

    /* renamed from: a */
    public void mo4886a() {
        this.f5149g.drawBitmap(this.f5151i, 0.0f, 0.0f, (Paint) null);
    }

    /* renamed from: a */
    public boolean mo4888a(float f, float f2, float f3, float f4, int i) {
        return false;
    }

    /* renamed from: a */
    public boolean mo4889a(float f, float f2, int i) {
        return false;
    }

    /* renamed from: a */
    public boolean mo4890a(float f, float f2, int i, float f3) {
        return false;
    }

    /* renamed from: a */
    public boolean mo4891a(float f, float f2, int i, float f3, boolean z) {
        return false;
    }

    /* renamed from: a */
    public boolean mo5297a(RectF rectF, int i) {
        return false;
    }

    /* renamed from: a */
    public boolean mo5298a(RectF rectF, int i, boolean z) {
        return false;
    }

    /* renamed from: a */
    public boolean mo4973a(float f, float f2, String str, int i) {
        return false;
    }

    /* renamed from: a */
    public boolean mo4971a(float f, float f2, float f3, float f4, String str, int i) {
        return false;
    }

    /* renamed from: a */
    public boolean mo4892a(float f, float f2, int i, boolean z) {
        return false;
    }

    /* renamed from: a */
    public boolean mo4945a(float f, float f2, float f3, float f4, int i, boolean z) {
        return false;
    }

    /* renamed from: a */
    public boolean mo4972a(float f, float f2, float f3, float f4, String str, int i, boolean z) {
        return false;
    }

    /* renamed from: a */
    public void m5290a(Drawable drawable) {
        this.f5155m = drawable;
    }

    /* renamed from: a */
    public void m5291a(Drawable drawable, Drawable drawable2, Drawable drawable3) {
        this.f5156n = drawable;
        this.f5157o = drawable2;
        this.f5158p = drawable3;
    }

    /* renamed from: a */
    public void m5292a(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        this.f5160r = drawable;
        this.f5161s = drawable2;
        this.f5162t = drawable3;
        this.f5163u = drawable4;
    }

    /* renamed from: b */
    public void m5301b(Drawable drawable) {
        this.f5159q = drawable;
    }

    /* renamed from: a */
    public void m5285a(int i) {
        this.f5139T = i;
    }

    /* renamed from: c */
    public void m5306c(Drawable drawable) {
        this.f5134M = drawable;
    }

    /* renamed from: a */
    protected void m5284a(float f, float f2, float f3, float f4) {
        if (this.f5123B != 0 && this.f5123B != 1) {
            float f5 = this.f5148f;
            if (this.f5155m != null) {
                int i = (int) ((-10.0f) * f5);
                int i2 = (int) (10.0f * f5);
                int i3 = -i2;
                int i4 = -i;
                float f6 = this.f5139T * f5;
                if (this.f5160r != null && this.f5161s != null && this.f5162t != null && this.f5163u != null) {
                    f6 = this.f5139T * f5 * 2.0f;
                }
                this.f5155m.setBounds((int) (f - f6), (int) (f2 - f6), (int) (f3 + f6), (int) (f4 + f6));
                this.f5155m.draw(this.f5149g);
                if (this.f5159q != null) {
                    this.f5159q.setBounds((int) (i + f3 + f6), (int) ((i3 + f2) - f6), (int) (i2 + f3 + f6), (int) ((i4 + f2) - f6));
                    m5286a(101, false);
                }
                if (this.f5156n != null) {
                    this.f5156n.setBounds((int) ((i + f) - f6), (int) ((i3 + f2) - f6), (int) ((i2 + f) - f6), (int) ((i4 + f2) - f6));
                    m5286a(102, false);
                }
                if (this.f5157o != null) {
                    this.f5157o.setBounds((int) (i + f3 + f6), (int) (i3 + f4 + f6), (int) (i2 + f3 + f6), (int) (i4 + f4 + f6));
                    m5286a(103, false);
                }
                if (this.f5158p != null) {
                    this.f5158p.setBounds((int) ((i + f) - f6), (int) (i3 + f4 + f6), (int) ((i2 + f) - f6), (int) (i4 + f4 + f6));
                    m5286a(104, false);
                }
                float f7 = (f2 + f4) / 2.0f;
                if (this.f5160r != null) {
                    this.f5160r.setBounds((int) ((i + f) - f6), (int) (i3 + f7), (int) ((i2 + f) - f6), (int) (i4 + f7));
                    m5286a(105, false);
                }
                if (this.f5162t != null) {
                    this.f5162t.setBounds((int) (i + f3 + f6), (int) (i3 + f7), (int) (i2 + f3 + f6), (int) (f7 + i4));
                    m5286a(107, false);
                }
                float f8 = (f + f3) / 2.0f;
                if (this.f5161s != null) {
                    this.f5161s.setBounds((int) (i + f8), (int) ((i3 + f2) - f6), (int) (i2 + f8), (int) ((i4 + f2) - f6));
                    m5286a(106, false);
                }
                if (this.f5163u != null) {
                    this.f5163u.setBounds((int) (i + f8), (int) (i3 + f4 + f6), (int) (f8 + i2), (int) (f6 + i4 + f4));
                    m5286a(108, false);
                    return;
                }
                return;
            }
            this.f5164v.setPathEffect(this.f5165w);
            this.f5164v.setStrokeWidth(5.0f * f5);
            this.f5164v.setColor(-16777216);
            this.f5149g.drawRect(new RectF(f, f2, f3, f4), this.f5164v);
            this.f5164v.setPathEffect(this.f5166x);
            this.f5164v.setStrokeWidth(f5 * 3.0f);
            this.f5164v.setColor(-1);
            this.f5149g.drawRect(new RectF(f, f2, f3, f4), this.f5164v);
        }
    }

    /* renamed from: a */
    protected void m5286a(int i, boolean z) {
        Drawable drawable;
        switch (i) {
            case 101:
                drawable = this.f5159q;
                break;
            case 102:
                drawable = this.f5156n;
                break;
            case 103:
                drawable = this.f5157o;
                break;
            case 104:
                drawable = this.f5158p;
                break;
            case 105:
                drawable = this.f5160r;
                break;
            case 106:
                drawable = this.f5161s;
                break;
            case 107:
                drawable = this.f5162t;
                break;
            case 108:
                drawable = this.f5163u;
                break;
            default:
                drawable = null;
                break;
        }
        if (drawable != null) {
            if (z) {
                drawable.setState(new int[]{R.attr.state_pressed});
            } else {
                drawable.setState(new int[]{-16842919});
            }
            drawable.setDither(true);
            drawable.setFilterBitmap(true);
            drawable.draw(this.f5149g);
        }
    }

    /* renamed from: a */
    public boolean mo4944a(float f, float f2) {
        return false;
    }

    /* renamed from: b */
    public boolean mo4893b(float f, float f2) {
        return false;
    }

    /* renamed from: c */
    public boolean mo4895c(float f, float f2) {
        return false;
    }

    /* renamed from: d */
    public boolean mo4896d(float f, float f2) {
        return false;
    }

    /* renamed from: b */
    public boolean m5303b() {
        if (this.f5167y == null || this.f5131J == null || !this.f5129H) {
            return false;
        }
        this.f5123B = 0;
        boolean zVipAMS_DeleteSelectObject = this.f5167y.VipAMS_DeleteSelectObject(this.f5168z, this.f5131J, false);
        this.f5131J = null;
        this.f5132K = null;
        return zVipAMS_DeleteSelectObject;
    }

    /* renamed from: c */
    public void mo5304c() {
    }

    /* renamed from: d */
    public Rect m5307d() {
        return this.f5133L;
    }

    /* renamed from: a */
    public void m5289a(Rect rect) {
        if (this.f5133L != null) {
            this.f5133L = null;
        }
        this.f5133L = new Rect(rect);
    }

    /* renamed from: b */
    public void m5299b(float f) {
        this.f5143a = f;
        if (f >= 0.0f) {
            m5305c(this.f5143a);
        }
    }

    /* renamed from: e */
    public float m5308e() {
        return this.f5143a;
    }

    /* renamed from: f */
    protected void m5309f() {
        this.f5141V = new float[f5121S];
        for (int i = 0; i < f5121S; i++) {
            this.f5141V[i] = 0.0f;
        }
    }

    /* renamed from: g */
    protected void m5310g() {
        this.f5141V = null;
    }

    /* renamed from: c */
    protected void m5305c(float f) {
        float f2;
        if (this.f5141V != null) {
            float[] fArr = this.f5141V;
            int i = this.f5142W;
            this.f5142W = i + 1;
            fArr[i] = f;
            if (this.f5142W % f5121S == 0) {
                this.f5142W = 0;
            }
            float f3 = 0.0f;
            for (int i2 = 0; i2 < f5121S; i2++) {
                if (this.f5141V == null) {
                    f2 = this.f5143a;
                } else {
                    f2 = this.f5141V[i2];
                }
                f3 += f2;
            }
            this.f5144b = f3 / f5121S;
        }
    }

    /* renamed from: h */
    protected float m5311h() {
        return this.f5144b;
    }

    /* renamed from: c */
    public void mo4894c(boolean z) {
    }

    /* renamed from: i */
    public Rect m5312i() {
        if (this.f5131J == null || this.f5132K == null) {
            return null;
        }
        AMS_RECT m_TRect = this.f5132K.getM_TRect();
        return new Rect(m_TRect.nLeft, m_TRect.nTop, m_TRect.nRight, m_TRect.nBottom);
    }
}
