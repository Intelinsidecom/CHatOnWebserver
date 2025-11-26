package com.sec.vip.amschaton;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.sec.amsoma.AMSLibs;
import com.sec.amsoma.structure.AMS_OBJECT_DATA;
import com.sec.amsoma.structure.AMS_RECT;
import com.sec.amsoma.structure.AMS_SELECT_OBJECT;
import com.sec.amsoma.structure.AMS_UI_DATA;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;

/* compiled from: AMSObject.java */
/* renamed from: com.sec.vip.amschaton.u */
/* loaded from: classes.dex */
public class C3588u {

    /* renamed from: U */
    public static float f13056U = 20.0f;

    /* renamed from: V */
    public static int f13057V = 30;

    /* renamed from: A */
    protected AMS_UI_DATA f13058A;

    /* renamed from: B */
    protected int f13059B;

    /* renamed from: C */
    protected int f13060C;

    /* renamed from: D */
    protected int f13061D;

    /* renamed from: E */
    protected float f13062E;

    /* renamed from: F */
    protected float f13063F;

    /* renamed from: G */
    protected boolean f13064G;

    /* renamed from: H */
    protected boolean f13065H;

    /* renamed from: I */
    protected boolean f13066I;

    /* renamed from: J */
    protected AMS_SELECT_OBJECT f13067J;

    /* renamed from: K */
    protected AMS_OBJECT_DATA f13068K;

    /* renamed from: L */
    protected Rect f13069L;

    /* renamed from: M */
    protected Drawable f13070M;

    /* renamed from: N */
    protected int f13071N;

    /* renamed from: O */
    protected int f13072O;

    /* renamed from: P */
    protected final float f13073P;

    /* renamed from: Q */
    protected final int f13074Q;

    /* renamed from: R */
    protected float f13075R;

    /* renamed from: S */
    protected InterfaceC3589v f13076S;

    /* renamed from: T */
    protected final float f13077T;

    /* renamed from: W */
    protected final float f13078W;

    /* renamed from: X */
    protected Point f13079X;

    /* renamed from: Y */
    float f13080Y;

    /* renamed from: Z */
    private float f13081Z;

    /* renamed from: a */
    protected int f13082a;

    /* renamed from: aa */
    private float f13083aa;

    /* renamed from: ab */
    private float[] f13084ab;

    /* renamed from: ac */
    private int f13085ac;

    /* renamed from: ad */
    private Paint f13086ad;

    /* renamed from: b */
    protected int f13087b;

    /* renamed from: c */
    protected int f13088c;

    /* renamed from: d */
    protected float f13089d;

    /* renamed from: e */
    protected int f13090e;

    /* renamed from: f */
    protected boolean f13091f;

    /* renamed from: g */
    protected Canvas f13092g;

    /* renamed from: h */
    protected Bitmap f13093h;

    /* renamed from: i */
    protected Bitmap f13094i;

    /* renamed from: j */
    protected Canvas f13095j;

    /* renamed from: k */
    protected Bitmap f13096k;

    /* renamed from: l */
    protected Paint f13097l;

    /* renamed from: m */
    protected Drawable f13098m;

    /* renamed from: n */
    protected Drawable f13099n;

    /* renamed from: o */
    protected Drawable f13100o;

    /* renamed from: p */
    protected Drawable f13101p;

    /* renamed from: q */
    protected Drawable f13102q;

    /* renamed from: r */
    protected Drawable f13103r;

    /* renamed from: s */
    protected Drawable f13104s;

    /* renamed from: t */
    protected Drawable f13105t;

    /* renamed from: u */
    protected Drawable f13106u;

    /* renamed from: v */
    protected Paint f13107v;

    /* renamed from: w */
    protected DashPathEffect f13108w;

    /* renamed from: x */
    protected DashPathEffect f13109x;

    /* renamed from: y */
    protected AMSLibs f13110y;

    /* renamed from: z */
    protected int f13111z;

    /* renamed from: a */
    public void m12827a(InterfaceC3589v interfaceC3589v) {
        this.f13076S = interfaceC3589v;
    }

    public C3588u(int i, int i2, int i3) {
        this(i, i2, i3, 0, 0, 0);
    }

    public C3588u(int i, int i2, int i3, int i4, int i5) {
        this(i, i2, i3, 0, i4, i5);
    }

    public C3588u(int i, int i2, int i3, int i4, int i5, int i6) {
        this.f13089d = 1.0f;
        this.f13092g = null;
        this.f13093h = null;
        this.f13094i = null;
        this.f13095j = null;
        this.f13096k = null;
        this.f13097l = null;
        this.f13098m = null;
        this.f13099n = null;
        this.f13100o = null;
        this.f13101p = null;
        this.f13102q = null;
        this.f13103r = null;
        this.f13104s = null;
        this.f13105t = null;
        this.f13106u = null;
        this.f13107v = null;
        this.f13108w = null;
        this.f13109x = null;
        this.f13110y = null;
        this.f13111z = 0;
        this.f13058A = null;
        this.f13059B = 0;
        this.f13060C = 0;
        this.f13061D = 0;
        this.f13062E = 0.0f;
        this.f13063F = 0.0f;
        this.f13064G = true;
        this.f13065H = false;
        this.f13066I = false;
        this.f13067J = null;
        this.f13068K = null;
        this.f13069L = null;
        this.f13070M = null;
        this.f13071N = 0;
        this.f13072O = 0;
        this.f13073P = 12.5f;
        this.f13074Q = 15;
        this.f13075R = 12.5f;
        this.f13076S = null;
        this.f13077T = 4096.0f;
        this.f13081Z = 0.0f;
        this.f13083aa = 0.0f;
        this.f13084ab = null;
        this.f13085ac = 0;
        this.f13078W = 2.0f;
        this.f13086ad = null;
        this.f13080Y = 0.0f;
        m12813a(i, i2, i3, i4);
        this.f13071N = i5;
        this.f13072O = i6;
    }

    /* renamed from: a */
    private void m12813a(int i, int i2, int i3, int i4) {
        this.f13087b = i2;
        this.f13082a = i;
        this.f13088c = i3;
        this.f13092g = null;
        this.f13090e = i4;
        this.f13108w = new DashPathEffect(new float[]{5.0f, 5.0f}, 0.0f);
        this.f13109x = new DashPathEffect(new float[]{3.0f, 7.0f}, -1.0f);
        this.f13107v = new Paint();
        this.f13107v.setStyle(Paint.Style.STROKE);
        this.f13107v.setAntiAlias(true);
        this.f13107v.setDither(true);
    }

    /* renamed from: a */
    public void m12825a(AMSLibs aMSLibs, int i, AMS_UI_DATA ams_ui_data) {
        this.f13110y = aMSLibs;
        this.f13111z = i;
        this.f13058A = ams_ui_data;
    }

    /* renamed from: a */
    public void m12820a(Bitmap bitmap, Bitmap bitmap2) {
        this.f13093h = bitmap;
        this.f13092g = new Canvas(this.f13093h);
        this.f13094i = bitmap2;
        this.f13095j = new Canvas(this.f13094i);
        this.f13095j.drawBitmap(this.f13093h, 0.0f, 0.0f, (Paint) null);
    }

    /* renamed from: a */
    public void m12819a(Bitmap bitmap) {
        m12820a(bitmap, bitmap);
    }

    /* renamed from: a */
    public void mo12131a(float f) {
        this.f13089d = f;
        this.f13108w = new DashPathEffect(new float[]{this.f13089d * 5.0f, this.f13089d * 5.0f}, 0.0f);
        this.f13109x = new DashPathEffect(new float[]{3.0f * this.f13089d, 7.0f * this.f13089d}, -this.f13089d);
    }

    /* renamed from: a */
    public void m12828a(boolean z) {
        this.f13065H = z;
        if (z) {
            this.f13059B = 2;
        } else {
            this.f13059B = 0;
        }
    }

    /* renamed from: b */
    public void m12847b(boolean z) {
        this.f13064G = z;
    }

    /* renamed from: a */
    public void m12826a(AMS_SELECT_OBJECT ams_select_object) {
        this.f13067J = ams_select_object;
        if (this.f13110y != null) {
            this.f13068K = new AMS_OBJECT_DATA();
            this.f13110y.VipAMS_GetSelectObjectData(ams_select_object.getM_pSelectObjectData(), this.f13068K);
        } else {
            this.f13068K = null;
        }
    }

    /* renamed from: b */
    public void m12845b(Bitmap bitmap) {
        this.f13096k = bitmap;
    }

    /* renamed from: a */
    public boolean mo12838a(AMS_RECT ams_rect) {
        return false;
    }

    /* renamed from: a */
    public boolean mo12137a(int i, int i2, int i3) {
        this.f13082a = i;
        this.f13087b = i2;
        this.f13088c = i3;
        return false;
    }

    /* renamed from: b */
    public boolean mo12144b(AMS_RECT ams_rect) {
        return false;
    }

    /* renamed from: a */
    public void mo12132a(float f, float f2) {
    }

    /* renamed from: b */
    public void mo12842b(float f, float f2) {
    }

    /* renamed from: a */
    public void mo12815a() {
        this.f13092g.drawBitmap(this.f13094i, 0.0f, 0.0f, (Paint) null);
    }

    /* renamed from: a */
    public boolean mo12830a(float f, float f2, float f3, float f4, int i) {
        return false;
    }

    /* renamed from: a */
    public boolean mo12832a(float f, float f2, int i) {
        return false;
    }

    /* renamed from: a */
    public boolean mo12833a(float f, float f2, int i, float f3) {
        return false;
    }

    /* renamed from: a */
    public boolean mo12834a(float f, float f2, int i, float f3, boolean z) {
        return false;
    }

    /* renamed from: a */
    public boolean mo12836a(RectF rectF, int i) {
        return false;
    }

    /* renamed from: a */
    public boolean mo12837a(RectF rectF, int i, boolean z) {
        return false;
    }

    /* renamed from: a */
    public boolean mo12136a(float f, float f2, String str, int i) {
        return false;
    }

    /* renamed from: a */
    public boolean mo12134a(float f, float f2, float f3, float f4, String str, int i) {
        return false;
    }

    /* renamed from: a */
    public boolean mo12835a(float f, float f2, int i, boolean z) {
        return false;
    }

    /* renamed from: a */
    public boolean mo12831a(float f, float f2, float f3, float f4, int i, boolean z) {
        return false;
    }

    /* renamed from: a */
    public boolean mo12135a(float f, float f2, float f3, float f4, String str, int i, boolean z) {
        return false;
    }

    /* renamed from: a */
    public void m12822a(Drawable drawable) {
        this.f13098m = drawable;
    }

    /* renamed from: a */
    public void m12823a(Drawable drawable, Drawable drawable2, Drawable drawable3) {
        this.f13099n = drawable;
        this.f13100o = drawable2;
        this.f13101p = drawable3;
    }

    /* renamed from: a */
    public void m12824a(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        this.f13103r = drawable;
        this.f13104s = drawable2;
        this.f13105t = drawable3;
        this.f13106u = drawable4;
    }

    /* renamed from: b */
    public void m12846b(Drawable drawable) {
        this.f13102q = drawable;
    }

    /* renamed from: a */
    public void m12817a(int i) {
        this.f13075R = i;
    }

    /* renamed from: c */
    public void m12850c(Drawable drawable) {
        this.f13070M = drawable;
    }

    /* renamed from: b */
    protected void m12843b(float f, float f2, float f3, float f4, int i) {
        if (this.f13059B != 0 && this.f13059B != 1) {
            float f5 = this.f13089d;
            if (this.f13098m != null) {
                int i2 = -((int) (12.5f * f5));
                int i3 = (int) (12.5f * f5);
                int i4 = -((int) (12.5f * f5));
                int i5 = (int) (12.5f * f5);
                float f6 = this.f13075R * f5;
                if (this.f13103r != null && this.f13104s != null && this.f13105t != null && this.f13106u != null) {
                    f6 = this.f13075R * f5 * 2.0f;
                }
                RectF rectF = new RectF(f - f6, f2 - f6, f3 + f6, f4 + f6);
                Rect rect = new Rect();
                rectF.round(rect);
                this.f13092g.rotate(this.f13090e, rect.centerX(), rect.centerY());
                this.f13098m.setBounds(rect);
                this.f13098m.draw(this.f13092g);
                if (this.f13102q != null) {
                    this.f13102q.setBounds((int) (i2 + f3 + f6), (int) ((i4 + f2) - f6), (int) (i3 + f3 + f6), (int) ((i5 + f2) - f6));
                    m12844b(101, false);
                }
                if (this.f13099n != null) {
                    this.f13099n.setBounds((int) ((i2 + f) - f6), (int) ((i4 + f2) - f6), (int) ((i3 + f) - f6), (int) ((i5 + f2) - f6));
                    m12844b(102, false);
                }
                if (this.f13100o != null) {
                    this.f13100o.setBounds((int) (i2 + f3 + f6), (int) (i4 + f4 + f6), (int) (i3 + f3 + f6), (int) (i5 + f4 + f6));
                    m12844b(103, false);
                }
                if (this.f13101p != null) {
                    this.f13101p.setBounds((int) ((i2 + f) - f6), (int) (i4 + f4 + f6), (int) ((i3 + f) - f6), (int) (i5 + f4 + f6));
                    m12844b(104, false);
                }
                float f7 = (f2 + f4) / 2.0f;
                if (this.f13103r != null) {
                    this.f13103r.setBounds((int) ((i2 + f) - f6), (int) (i4 + f7), (int) ((i3 + f) - f6), (int) (i5 + f7));
                    m12844b(105, false);
                }
                if (this.f13105t != null) {
                    this.f13105t.setBounds((int) (i2 + f3 + f6), (int) (i4 + f7), (int) (i3 + f3 + f6), (int) (f7 + i5));
                    m12844b(107, false);
                }
                float f8 = (f + f3) / 2.0f;
                if (this.f13104s != null) {
                    this.f13104s.setBounds((int) (i2 + f8), (int) ((i4 + f2) - f6), (int) (i3 + f8), (int) ((i5 + f2) - f6));
                    m12844b(106, false);
                }
                if (this.f13106u != null) {
                    this.f13106u.setBounds((int) (i2 + f8), (int) (i4 + f4 + f6), (int) (f8 + i3), (int) (f6 + i5 + f4));
                    m12844b(108, false);
                }
                if (this instanceof C3593z) {
                    m12829a(false, (int) r10, (int) r11, (int) r12, (int) r13);
                }
                this.f13092g.rotate(-this.f13090e, rect.centerX(), rect.centerY());
                return;
            }
            this.f13107v.setPathEffect(this.f13108w);
            this.f13107v.setStrokeWidth(5.0f * f5);
            this.f13107v.setColor(-16777216);
            this.f13092g.drawRect(new RectF(f, f2, f3, f4), this.f13107v);
            this.f13107v.setPathEffect(this.f13109x);
            this.f13107v.setStrokeWidth(f5 * 3.0f);
            this.f13107v.setColor(-1);
            this.f13092g.drawRect(new RectF(f, f2, f3, f4), this.f13107v);
        }
    }

    /* renamed from: a */
    protected void m12816a(float f, float f2, float f3, float f4) {
        if (this.f13059B != 0 && this.f13059B != 1) {
            float f5 = this.f13089d;
            if (this.f13098m != null) {
                int i = -((int) (12.5f * f5));
                int i2 = (int) (12.5f * f5);
                int i3 = -((int) (12.5f * f5));
                int i4 = (int) (12.5f * f5);
                float f6 = this.f13075R * f5;
                if (this.f13103r != null && this.f13104s != null && this.f13105t != null && this.f13106u != null) {
                    f6 = this.f13075R * f5 * 2.0f;
                }
                this.f13098m.setBounds((int) (f - f6), (int) (f2 - f6), (int) (f3 + f6), (int) (f4 + f6));
                this.f13098m.draw(this.f13092g);
                if (this.f13102q != null) {
                    this.f13102q.setBounds((int) (i + f3 + f6), (int) ((i3 + f2) - f6), (int) (i2 + f3 + f6), (int) ((i4 + f2) - f6));
                    m12844b(101, false);
                }
                if (this.f13099n != null) {
                    this.f13099n.setBounds((int) ((i + f) - f6), (int) ((i3 + f2) - f6), (int) ((i2 + f) - f6), (int) ((i4 + f2) - f6));
                    m12844b(102, false);
                }
                if (this.f13100o != null) {
                    this.f13100o.setBounds((int) (i + f3 + f6), (int) (i3 + f4 + f6), (int) (i2 + f3 + f6), (int) (i4 + f4 + f6));
                    m12844b(103, false);
                }
                if (this.f13101p != null) {
                    this.f13101p.setBounds((int) ((i + f) - f6), (int) (i3 + f4 + f6), (int) ((i2 + f) - f6), (int) (i4 + f4 + f6));
                    m12844b(104, false);
                }
                float f7 = (f2 + f4) / 2.0f;
                if (this.f13103r != null) {
                    this.f13103r.setBounds((int) ((i + f) - f6), (int) (i3 + f7), (int) ((i2 + f) - f6), (int) (i4 + f7));
                    m12844b(105, false);
                }
                if (this.f13105t != null) {
                    this.f13105t.setBounds((int) (i + f3 + f6), (int) (i3 + f7), (int) (i2 + f3 + f6), (int) (f7 + i4));
                    m12844b(107, false);
                }
                float f8 = (f + f3) / 2.0f;
                if (this.f13104s != null) {
                    this.f13104s.setBounds((int) (i + f8), (int) ((i3 + f2) - f6), (int) (i2 + f8), (int) ((i4 + f2) - f6));
                    m12844b(106, false);
                }
                if (this.f13106u != null) {
                    this.f13106u.setBounds((int) (i + f8), (int) (i3 + f4 + f6), (int) (f8 + i2), (int) (f6 + i4 + f4));
                    m12844b(108, false);
                }
                if (this instanceof C3593z) {
                    m12829a(false, (int) f, (int) f2, (int) f3, (int) f4);
                    return;
                }
                return;
            }
            this.f13107v.setPathEffect(this.f13108w);
            this.f13107v.setStrokeWidth(5.0f * f5);
            this.f13107v.setColor(-16777216);
            this.f13092g.drawRect(new RectF(f, f2, f3, f4), this.f13107v);
            this.f13107v.setPathEffect(this.f13109x);
            this.f13107v.setStrokeWidth(f5 * 3.0f);
            this.f13107v.setColor(-1);
            this.f13092g.drawRect(new RectF(f, f2, f3, f4), this.f13107v);
        }
    }

    /* renamed from: b */
    protected RectF m12840b() {
        Point pointM12848c = m12848c();
        Resources resources = GlobalApplication.m11493l().getResources();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        if (this.f13080Y == 0.0f) {
            BitmapFactory.decodeResource(resources, R.drawable.stemp_rotation_handle, options);
            this.f13080Y = (1.3f * options.outWidth) / 2.0f;
        }
        float f = this.f13075R * this.f13089d;
        if (this.f13103r != null && this.f13104s != null && this.f13105t != null && this.f13106u != null) {
            f = this.f13075R * this.f13089d * 2.0f;
        }
        float[] fArr = {pointM12848c.x, pointM12848c.y - ((f + (Math.abs(this.f13068K.getM_TRect().nBottom - this.f13068K.getM_TRect().nTop) / 2)) + (40.0f * this.f13089d))};
        Matrix matrix = new Matrix();
        matrix.setRotate(this.f13090e, pointM12848c.x, pointM12848c.y);
        matrix.mapPoints(fArr);
        return new RectF(fArr[0] - this.f13080Y, fArr[1] - this.f13080Y, fArr[0] + this.f13080Y, fArr[1] + this.f13080Y);
    }

    /* renamed from: c */
    protected Point m12848c() {
        return new Point((this.f13068K.getM_TRect().nRight + this.f13068K.getM_TRect().nLeft) / 2, (this.f13068K.getM_TRect().nBottom + this.f13068K.getM_TRect().nTop) / 2);
    }

    /* renamed from: a */
    protected Point m12814a(RectF rectF) {
        return new Point((int) ((rectF.right + rectF.left) / 2.0f), (int) ((rectF.bottom + rectF.top) / 2.0f));
    }

    /* renamed from: b */
    protected Point m12839b(float f, float f2, float f3, float f4) {
        return new Point((int) ((f3 + f) / 2.0f), (int) ((f4 + f2) / 2.0f));
    }

    /* renamed from: a */
    protected void m12829a(boolean z, float f, float f2, float f3, float f4) {
        if (this.f13086ad == null) {
            this.f13086ad = new Paint();
        }
        this.f13079X = m12839b(f, f2, f3, f4);
        float fAbs = Math.abs(f2 - f4);
        this.f13092g.save();
        this.f13092g.translate(this.f13079X.x, this.f13079X.y - (fAbs / 2.0f));
        float f5 = -(40.0f * this.f13089d);
        this.f13086ad.setColor(-65536);
        this.f13086ad.setStyle(Paint.Style.STROKE);
        this.f13086ad.setPathEffect(this.f13108w);
        this.f13092g.drawLine(0.0f, 0.0f, 0.0f, f5, this.f13086ad);
        this.f13086ad.setColor(-256);
        this.f13086ad.setStyle(Paint.Style.FILL);
        this.f13086ad.setColor(-16777216);
        this.f13086ad.setStrokeWidth(1.0f);
        this.f13086ad.setPathEffect(null);
        this.f13086ad.setStrokeJoin(Paint.Join.BEVEL);
        this.f13086ad.setStyle(Paint.Style.STROKE);
        Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(GlobalApplication.m11493l().getResources(), R.drawable.stemp_rotation_handle);
        float width = bitmapDecodeResource.getWidth() / 2;
        this.f13092g.drawBitmap(bitmapDecodeResource, 0.0f - width, f5 - width, this.f13086ad);
        this.f13092g.restore();
    }

    /* renamed from: a */
    protected void m12818a(int i, boolean z) {
        new RectF(this.f13068K.getM_TRect().nLeft, this.f13068K.getM_TRect().nTop, this.f13068K.getM_TRect().nRight, this.f13068K.getM_TRect().nBottom);
        this.f13092g.rotate(this.f13090e, this.f13079X.x, this.f13079X.y);
        m12844b(i, z);
        this.f13092g.rotate(-this.f13090e, this.f13079X.x, this.f13079X.y);
    }

    /* renamed from: b */
    protected void m12844b(int i, boolean z) {
        Drawable drawable;
        switch (i) {
            case 101:
                drawable = this.f13102q;
                break;
            case 102:
                drawable = this.f13099n;
                break;
            case 103:
                drawable = this.f13100o;
                break;
            case 104:
                drawable = this.f13101p;
                break;
            case 105:
                drawable = this.f13103r;
                break;
            case 106:
                drawable = this.f13104s;
                break;
            case 107:
                drawable = this.f13105t;
                break;
            case 108:
                drawable = this.f13106u;
                break;
            default:
                drawable = null;
                break;
        }
        if (drawable != null) {
            if (z) {
                drawable.setState(new int[]{android.R.attr.state_pressed});
            } else {
                drawable.setState(new int[]{-16842919});
            }
            drawable.setDither(true);
            drawable.setFilterBitmap(true);
            drawable.draw(this.f13092g);
        }
    }

    /* renamed from: c */
    public boolean mo12146c(float f, float f2) {
        return false;
    }

    /* renamed from: d */
    public boolean mo12147d(float f, float f2) {
        return false;
    }

    /* renamed from: e */
    public boolean mo12148e(float f, float f2) {
        return false;
    }

    /* renamed from: f */
    public boolean mo12149f(float f, float f2) {
        return false;
    }

    /* renamed from: d */
    public boolean m12852d() {
        if (this.f13110y == null || this.f13067J == null || !this.f13065H) {
            return false;
        }
        this.f13059B = 0;
        boolean zVipAMS_DeleteSelectObject = this.f13110y.VipAMS_DeleteSelectObject(this.f13111z, this.f13067J);
        this.f13067J = null;
        this.f13068K = null;
        return zVipAMS_DeleteSelectObject;
    }

    /* renamed from: e */
    public void mo12853e() {
    }

    /* renamed from: f */
    public Rect m12854f() {
        return this.f13069L;
    }

    /* renamed from: a */
    public void m12821a(Rect rect) {
        if (this.f13069L != null) {
            this.f13069L = null;
        }
        this.f13069L = new Rect(rect);
    }

    /* renamed from: b */
    public void m12841b(float f) {
        this.f13081Z = f;
        if (f >= 0.0f) {
            m12849c(this.f13081Z);
        }
    }

    /* renamed from: g */
    public float m12855g() {
        return this.f13081Z;
    }

    /* renamed from: h */
    protected void m12856h() {
        this.f13084ab = new float[f13057V];
        for (int i = 0; i < f13057V; i++) {
            this.f13084ab[i] = 0.0f;
        }
    }

    /* renamed from: i */
    protected void m12857i() {
        this.f13084ab = null;
    }

    /* renamed from: c */
    protected void m12849c(float f) {
        float f2;
        if (this.f13084ab != null) {
            float[] fArr = this.f13084ab;
            int i = this.f13085ac;
            this.f13085ac = i + 1;
            fArr[i] = f;
            if (this.f13085ac % f13057V == 0) {
                this.f13085ac = 0;
            }
            float f3 = 0.0f;
            for (int i2 = 0; i2 < f13057V; i2++) {
                if (this.f13084ab == null) {
                    f2 = this.f13081Z;
                } else {
                    f2 = this.f13084ab[i2];
                }
                f3 += f2;
            }
            this.f13083aa = f3 / f13057V;
        }
    }

    /* renamed from: j */
    protected float m12858j() {
        return this.f13083aa;
    }

    /* renamed from: c */
    public void mo12851c(boolean z) {
    }

    /* renamed from: k */
    public Rect m12859k() {
        if (this.f13067J == null || this.f13068K == null) {
            return null;
        }
        AMS_RECT m_TRect = this.f13068K.getM_TRect();
        return new Rect(m_TRect.nLeft, m_TRect.nTop, m_TRect.nRight, m_TRect.nBottom);
    }
}
