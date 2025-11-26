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
import twitter4j.MediaEntity;

/* compiled from: AMSObject.java */
/* renamed from: com.sec.vip.amschaton.r */
/* loaded from: classes.dex */
public class C2068r {

    /* renamed from: S */
    public static float f7367S = 20.0f;

    /* renamed from: T */
    public static int f7368T = 30;

    /* renamed from: A */
    protected int f7369A;

    /* renamed from: B */
    protected int f7370B;

    /* renamed from: C */
    protected float f7371C;

    /* renamed from: D */
    protected float f7372D;

    /* renamed from: E */
    protected boolean f7373E;

    /* renamed from: F */
    protected boolean f7374F;

    /* renamed from: G */
    protected boolean f7375G;

    /* renamed from: H */
    protected AMS_SELECT_OBJECT f7376H;

    /* renamed from: I */
    protected AMS_OBJECT_DATA f7377I;

    /* renamed from: J */
    protected Rect f7378J;

    /* renamed from: K */
    protected Drawable f7379K;

    /* renamed from: L */
    protected int f7380L;

    /* renamed from: M */
    protected int f7381M;

    /* renamed from: N */
    protected final float f7382N;

    /* renamed from: O */
    protected final int f7383O;

    /* renamed from: P */
    protected float f7384P;

    /* renamed from: Q */
    protected InterfaceC2069s f7385Q;

    /* renamed from: R */
    protected final float f7386R;

    /* renamed from: U */
    protected final float f7387U;

    /* renamed from: V */
    private float f7388V;

    /* renamed from: W */
    private float f7389W;

    /* renamed from: X */
    private float[] f7390X;

    /* renamed from: Y */
    private int f7391Y;

    /* renamed from: a */
    protected int f7392a;

    /* renamed from: b */
    protected int f7393b;

    /* renamed from: c */
    protected int f7394c;

    /* renamed from: d */
    protected float f7395d;

    /* renamed from: e */
    protected Canvas f7396e;

    /* renamed from: f */
    protected Bitmap f7397f;

    /* renamed from: g */
    protected Bitmap f7398g;

    /* renamed from: h */
    protected Canvas f7399h;

    /* renamed from: i */
    protected Bitmap f7400i;

    /* renamed from: j */
    protected Paint f7401j;

    /* renamed from: k */
    protected Drawable f7402k;

    /* renamed from: l */
    protected Drawable f7403l;

    /* renamed from: m */
    protected Drawable f7404m;

    /* renamed from: n */
    protected Drawable f7405n;

    /* renamed from: o */
    protected Drawable f7406o;

    /* renamed from: p */
    protected Drawable f7407p;

    /* renamed from: q */
    protected Drawable f7408q;

    /* renamed from: r */
    protected Drawable f7409r;

    /* renamed from: s */
    protected Drawable f7410s;

    /* renamed from: t */
    protected Paint f7411t;

    /* renamed from: u */
    protected DashPathEffect f7412u;

    /* renamed from: v */
    protected DashPathEffect f7413v;

    /* renamed from: w */
    protected AMSLibs f7414w;

    /* renamed from: x */
    protected int f7415x;

    /* renamed from: y */
    protected AMS_UI_DATA f7416y;

    /* renamed from: z */
    protected int f7417z;

    /* renamed from: a */
    public void m7207a(InterfaceC2069s interfaceC2069s) {
        this.f7385Q = interfaceC2069s;
    }

    public C2068r(int i, int i2, int i3) {
        this.f7395d = 1.0f;
        this.f7396e = null;
        this.f7397f = null;
        this.f7398g = null;
        this.f7399h = null;
        this.f7400i = null;
        this.f7401j = null;
        this.f7402k = null;
        this.f7403l = null;
        this.f7404m = null;
        this.f7405n = null;
        this.f7406o = null;
        this.f7407p = null;
        this.f7408q = null;
        this.f7409r = null;
        this.f7410s = null;
        this.f7411t = null;
        this.f7412u = null;
        this.f7413v = null;
        this.f7414w = null;
        this.f7415x = 0;
        this.f7416y = null;
        this.f7417z = 0;
        this.f7369A = 0;
        this.f7370B = 0;
        this.f7371C = 0.0f;
        this.f7372D = 0.0f;
        this.f7373E = true;
        this.f7374F = false;
        this.f7375G = false;
        this.f7376H = null;
        this.f7377I = null;
        this.f7378J = null;
        this.f7379K = null;
        this.f7380L = 0;
        this.f7381M = 0;
        this.f7382N = 12.5f;
        this.f7383O = 15;
        this.f7384P = 12.5f;
        this.f7385Q = null;
        this.f7386R = 4096.0f;
        this.f7388V = 0.0f;
        this.f7389W = 0.0f;
        this.f7390X = null;
        this.f7391Y = 0;
        this.f7387U = 2.0f;
        m7192b(i, i2, i3);
    }

    public C2068r(int i, int i2, int i3, int i4, int i5) {
        this.f7395d = 1.0f;
        this.f7396e = null;
        this.f7397f = null;
        this.f7398g = null;
        this.f7399h = null;
        this.f7400i = null;
        this.f7401j = null;
        this.f7402k = null;
        this.f7403l = null;
        this.f7404m = null;
        this.f7405n = null;
        this.f7406o = null;
        this.f7407p = null;
        this.f7408q = null;
        this.f7409r = null;
        this.f7410s = null;
        this.f7411t = null;
        this.f7412u = null;
        this.f7413v = null;
        this.f7414w = null;
        this.f7415x = 0;
        this.f7416y = null;
        this.f7417z = 0;
        this.f7369A = 0;
        this.f7370B = 0;
        this.f7371C = 0.0f;
        this.f7372D = 0.0f;
        this.f7373E = true;
        this.f7374F = false;
        this.f7375G = false;
        this.f7376H = null;
        this.f7377I = null;
        this.f7378J = null;
        this.f7379K = null;
        this.f7380L = 0;
        this.f7381M = 0;
        this.f7382N = 12.5f;
        this.f7383O = 15;
        this.f7384P = 12.5f;
        this.f7385Q = null;
        this.f7386R = 4096.0f;
        this.f7388V = 0.0f;
        this.f7389W = 0.0f;
        this.f7390X = null;
        this.f7391Y = 0;
        this.f7387U = 2.0f;
        m7192b(i, i2, i3);
        this.f7380L = i4;
        this.f7381M = i5;
    }

    /* renamed from: b */
    private void m7192b(int i, int i2, int i3) {
        this.f7393b = i2;
        this.f7392a = i;
        this.f7394c = i3;
        this.f7396e = null;
        this.f7412u = new DashPathEffect(new float[]{5.0f, 5.0f}, 0.0f);
        this.f7413v = new DashPathEffect(new float[]{3.0f, 7.0f}, -1.0f);
        this.f7411t = new Paint();
        this.f7411t.setStyle(Paint.Style.STROKE);
        this.f7411t.setAntiAlias(true);
        this.f7411t.setDither(true);
    }

    /* renamed from: a */
    public void m7205a(AMSLibs aMSLibs, int i, AMS_UI_DATA ams_ui_data) {
        this.f7414w = aMSLibs;
        this.f7415x = i;
        this.f7416y = ams_ui_data;
    }

    /* renamed from: a */
    public void m7200a(Bitmap bitmap, Bitmap bitmap2) {
        this.f7397f = bitmap;
        this.f7396e = new Canvas(this.f7397f);
        this.f7398g = bitmap2;
        this.f7399h = new Canvas(this.f7398g);
        this.f7399h.drawBitmap(this.f7397f, 0.0f, 0.0f, (Paint) null);
    }

    /* renamed from: a */
    public void m7199a(Bitmap bitmap) {
        m7200a(bitmap, bitmap);
    }

    /* renamed from: a */
    public void mo7194a(float f) {
        this.f7395d = f;
        this.f7412u = new DashPathEffect(new float[]{this.f7395d * 5.0f, this.f7395d * 5.0f}, 0.0f);
        this.f7413v = new DashPathEffect(new float[]{3.0f * this.f7395d, 7.0f * this.f7395d}, -this.f7395d);
    }

    /* renamed from: a */
    public void m7208a(boolean z) {
        this.f7374F = z;
        if (z) {
            this.f7417z = 2;
        } else {
            this.f7417z = 0;
        }
    }

    /* renamed from: b */
    public void m7226b(boolean z) {
        this.f7373E = z;
    }

    /* renamed from: a */
    public void m7206a(AMS_SELECT_OBJECT ams_select_object) {
        this.f7376H = ams_select_object;
        if (this.f7414w != null) {
            this.f7377I = new AMS_OBJECT_DATA();
            this.f7414w.VipAMS_GetSelectObjectData(ams_select_object.getM_pSelectObjectData(), this.f7377I);
        } else {
            this.f7377I = null;
        }
    }

    /* renamed from: b */
    public void m7224b(Bitmap bitmap) {
        this.f7400i = bitmap;
    }

    /* renamed from: a */
    public boolean mo7221a(AMS_RECT ams_rect) {
        return false;
    }

    /* renamed from: a */
    public boolean mo7218a(int i, int i2, int i3) {
        this.f7392a = i;
        this.f7393b = i2;
        this.f7394c = i3;
        return false;
    }

    /* renamed from: b */
    public boolean mo7228b(AMS_RECT ams_rect) {
        return false;
    }

    /* renamed from: a */
    public void mo7195a(float f, float f2) {
    }

    /* renamed from: b */
    public void mo7223b(float f, float f2) {
    }

    /* renamed from: a */
    public void mo7193a() {
        this.f7396e.drawBitmap(this.f7398g, 0.0f, 0.0f, (Paint) null);
    }

    /* renamed from: a */
    public boolean mo7209a(float f, float f2, float f3, float f4, int i) {
        return false;
    }

    /* renamed from: a */
    public boolean mo7213a(float f, float f2, int i) {
        return false;
    }

    /* renamed from: a */
    public boolean mo7214a(float f, float f2, int i, float f3) {
        return false;
    }

    /* renamed from: a */
    public boolean mo7215a(float f, float f2, int i, float f3, boolean z) {
        return false;
    }

    /* renamed from: a */
    public boolean mo7219a(RectF rectF, int i) {
        return false;
    }

    /* renamed from: a */
    public boolean mo7220a(RectF rectF, int i, boolean z) {
        return false;
    }

    /* renamed from: a */
    public boolean mo7217a(float f, float f2, String str, int i) {
        return false;
    }

    /* renamed from: a */
    public boolean mo7211a(float f, float f2, float f3, float f4, String str, int i) {
        return false;
    }

    /* renamed from: a */
    public boolean mo7216a(float f, float f2, int i, boolean z) {
        return false;
    }

    /* renamed from: a */
    public boolean mo7210a(float f, float f2, float f3, float f4, int i, boolean z) {
        return false;
    }

    /* renamed from: a */
    public boolean mo7212a(float f, float f2, float f3, float f4, String str, int i, boolean z) {
        return false;
    }

    /* renamed from: a */
    public void m7202a(Drawable drawable) {
        this.f7402k = drawable;
    }

    /* renamed from: a */
    public void m7203a(Drawable drawable, Drawable drawable2, Drawable drawable3) {
        this.f7403l = drawable;
        this.f7404m = drawable2;
        this.f7405n = drawable3;
    }

    /* renamed from: a */
    public void m7204a(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        this.f7407p = drawable;
        this.f7408q = drawable2;
        this.f7409r = drawable3;
        this.f7410s = drawable4;
    }

    /* renamed from: b */
    public void m7225b(Drawable drawable) {
        this.f7406o = drawable;
    }

    /* renamed from: a */
    public void m7197a(int i) {
        this.f7384P = i;
    }

    /* renamed from: c */
    public void m7231c(Drawable drawable) {
        this.f7379K = drawable;
    }

    /* renamed from: a */
    protected void m7196a(float f, float f2, float f3, float f4) {
        if (this.f7417z != 0 && this.f7417z != 1) {
            float f5 = this.f7395d;
            if (this.f7402k != null) {
                int i = -((int) (12.5f * f5));
                int i2 = (int) (12.5f * f5);
                int i3 = -((int) (12.5f * f5));
                int i4 = (int) (12.5f * f5);
                float f6 = this.f7384P * f5;
                if (this.f7407p != null && this.f7408q != null && this.f7409r != null && this.f7410s != null) {
                    f6 = this.f7384P * f5 * 2.0f;
                }
                this.f7402k.setBounds((int) (f - f6), (int) (f2 - f6), (int) (f3 + f6), (int) (f4 + f6));
                this.f7402k.draw(this.f7396e);
                if (this.f7406o != null) {
                    this.f7406o.setBounds((int) (i + f3 + f6), (int) ((i3 + f2) - f6), (int) (i2 + f3 + f6), (int) ((i4 + f2) - f6));
                    m7198a(MediaEntity.Size.CROP, false);
                }
                if (this.f7403l != null) {
                    this.f7403l.setBounds((int) ((i + f) - f6), (int) ((i3 + f2) - f6), (int) ((i2 + f) - f6), (int) ((i4 + f2) - f6));
                    m7198a(102, false);
                }
                if (this.f7404m != null) {
                    this.f7404m.setBounds((int) (i + f3 + f6), (int) (i3 + f4 + f6), (int) (i2 + f3 + f6), (int) (i4 + f4 + f6));
                    m7198a(103, false);
                }
                if (this.f7405n != null) {
                    this.f7405n.setBounds((int) ((i + f) - f6), (int) (i3 + f4 + f6), (int) ((i2 + f) - f6), (int) (i4 + f4 + f6));
                    m7198a(104, false);
                }
                float f7 = (f2 + f4) / 2.0f;
                if (this.f7407p != null) {
                    this.f7407p.setBounds((int) ((i + f) - f6), (int) (i3 + f7), (int) ((i2 + f) - f6), (int) (i4 + f7));
                    m7198a(105, false);
                }
                if (this.f7409r != null) {
                    this.f7409r.setBounds((int) (i + f3 + f6), (int) (i3 + f7), (int) (i2 + f3 + f6), (int) (f7 + i4));
                    m7198a(107, false);
                }
                float f8 = (f + f3) / 2.0f;
                if (this.f7408q != null) {
                    this.f7408q.setBounds((int) (i + f8), (int) ((i3 + f2) - f6), (int) (i2 + f8), (int) ((i4 + f2) - f6));
                    m7198a(106, false);
                }
                if (this.f7410s != null) {
                    this.f7410s.setBounds((int) (i + f8), (int) (i3 + f4 + f6), (int) (f8 + i2), (int) (f6 + i4 + f4));
                    m7198a(108, false);
                    return;
                }
                return;
            }
            this.f7411t.setPathEffect(this.f7412u);
            this.f7411t.setStrokeWidth(5.0f * f5);
            this.f7411t.setColor(-16777216);
            this.f7396e.drawRect(new RectF(f, f2, f3, f4), this.f7411t);
            this.f7411t.setPathEffect(this.f7413v);
            this.f7411t.setStrokeWidth(f5 * 3.0f);
            this.f7411t.setColor(-1);
            this.f7396e.drawRect(new RectF(f, f2, f3, f4), this.f7411t);
        }
    }

    /* renamed from: a */
    protected void m7198a(int i, boolean z) {
        Drawable drawable;
        switch (i) {
            case MediaEntity.Size.CROP /* 101 */:
                drawable = this.f7406o;
                break;
            case 102:
                drawable = this.f7403l;
                break;
            case 103:
                drawable = this.f7404m;
                break;
            case 104:
                drawable = this.f7405n;
                break;
            case 105:
                drawable = this.f7407p;
                break;
            case 106:
                drawable = this.f7408q;
                break;
            case 107:
                drawable = this.f7409r;
                break;
            case 108:
                drawable = this.f7410s;
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
            drawable.draw(this.f7396e);
        }
    }

    /* renamed from: c */
    public boolean mo7233c(float f, float f2) {
        return false;
    }

    /* renamed from: d */
    public boolean mo7235d(float f, float f2) {
        return false;
    }

    /* renamed from: e */
    public boolean mo7237e(float f, float f2) {
        return false;
    }

    /* renamed from: f */
    public boolean mo7239f(float f, float f2) {
        return false;
    }

    /* renamed from: b */
    public boolean m7227b() {
        if (this.f7414w == null || this.f7376H == null || !this.f7374F) {
            return false;
        }
        this.f7417z = 0;
        boolean zVipAMS_DeleteSelectObject = this.f7414w.VipAMS_DeleteSelectObject(this.f7415x, this.f7376H, false);
        this.f7376H = null;
        this.f7377I = null;
        return zVipAMS_DeleteSelectObject;
    }

    /* renamed from: c */
    public void mo7229c() {
    }

    /* renamed from: d */
    public Rect m7234d() {
        return this.f7378J;
    }

    /* renamed from: a */
    public void m7201a(Rect rect) {
        if (this.f7378J != null) {
            this.f7378J = null;
        }
        this.f7378J = new Rect(rect);
    }

    /* renamed from: b */
    public void m7222b(float f) {
        this.f7388V = f;
        if (f >= 0.0f) {
            m7230c(this.f7388V);
        }
    }

    /* renamed from: e */
    public float m7236e() {
        return this.f7388V;
    }

    /* renamed from: f */
    protected void m7238f() {
        this.f7390X = new float[f7368T];
        for (int i = 0; i < f7368T; i++) {
            this.f7390X[i] = 0.0f;
        }
    }

    /* renamed from: g */
    protected void m7240g() {
        this.f7390X = null;
    }

    /* renamed from: c */
    protected void m7230c(float f) {
        float f2;
        if (this.f7390X != null) {
            float[] fArr = this.f7390X;
            int i = this.f7391Y;
            this.f7391Y = i + 1;
            fArr[i] = f;
            if (this.f7391Y % f7368T == 0) {
                this.f7391Y = 0;
            }
            float f3 = 0.0f;
            for (int i2 = 0; i2 < f7368T; i2++) {
                if (this.f7390X == null) {
                    f2 = this.f7388V;
                } else {
                    f2 = this.f7390X[i2];
                }
                f3 += f2;
            }
            this.f7389W = f3 / f7368T;
        }
    }

    /* renamed from: h */
    protected float m7241h() {
        return this.f7389W;
    }

    /* renamed from: c */
    public void mo7232c(boolean z) {
    }

    /* renamed from: i */
    public Rect m7242i() {
        if (this.f7376H == null || this.f7377I == null) {
            return null;
        }
        AMS_RECT m_TRect = this.f7377I.getM_TRect();
        return new Rect(m_TRect.nLeft, m_TRect.nTop, m_TRect.nRight, m_TRect.nBottom);
    }
}
