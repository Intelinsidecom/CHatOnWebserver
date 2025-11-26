package com.sec.vip.amschaton;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.hardware.motion.MREvent;
import android.os.Build;
import android.support.v4.view.MotionEventCompat;
import android.view.MotionEvent;
import android.view.View;
import com.sec.amsoma.AMSLibs;
import com.sec.amsoma.structure.AMS_CODING_FILE_INFO;
import com.sec.amsoma.structure.AMS_OBJECT_DATA;
import com.sec.amsoma.structure.AMS_OPTION;
import com.sec.amsoma.structure.AMS_RECT;
import com.sec.amsoma.structure.AMS_SELECT_OBJECT;
import com.sec.amsoma.structure.AMS_UI_DATA;
import com.sec.chaton.R;
import com.sec.chaton.util.C1341p;
import com.sec.widget.C1619g;
import java.io.File;

/* loaded from: classes.dex */
public class AMSDrawManager extends ZoomableImageView implements View.OnTouchListener {

    /* renamed from: a */
    public static final String f4637a = AMSActivity.f4622d;

    /* renamed from: b */
    public static final String f4638b = AMSActivity.f4626h;

    /* renamed from: c */
    public static final String f4639c = f4637a + "template/";

    /* renamed from: F */
    private Context f4640F;

    /* renamed from: G */
    private AMSLibs f4641G;

    /* renamed from: H */
    private int f4642H;

    /* renamed from: I */
    private AMS_UI_DATA f4643I;

    /* renamed from: J */
    private int f4644J;

    /* renamed from: K */
    private int f4645K;

    /* renamed from: L */
    private int f4646L;

    /* renamed from: M */
    private int f4647M;

    /* renamed from: N */
    private int f4648N;

    /* renamed from: O */
    private int f4649O;

    /* renamed from: P */
    private int f4650P;

    /* renamed from: Q */
    private float f4651Q;

    /* renamed from: R */
    private C1468i f4652R;

    /* renamed from: S */
    private C1468i f4653S;

    /* renamed from: T */
    private Bitmap f4654T;

    /* renamed from: U */
    private Bitmap f4655U;

    /* renamed from: V */
    private Bitmap f4656V;

    /* renamed from: W */
    private boolean f4657W;

    /* renamed from: Z */
    private int f4658Z;

    /* renamed from: aA */
    private boolean f4659aA;

    /* renamed from: aB */
    private boolean f4660aB;

    /* renamed from: aC */
    private PointF f4661aC;

    /* renamed from: aD */
    private Bitmap f4662aD;

    /* renamed from: aE */
    private InterfaceC1375al f4663aE;

    /* renamed from: aF */
    private InterfaceC1545j f4664aF;

    /* renamed from: aG */
    private final int f4665aG;

    /* renamed from: aH */
    private InterfaceC1557v f4666aH;

    /* renamed from: aa */
    private boolean f4667aa;

    /* renamed from: ab */
    private AMS_SELECT_OBJECT f4668ab;

    /* renamed from: ac */
    private final int f4669ac;

    /* renamed from: ad */
    private final int f4670ad;

    /* renamed from: ae */
    private int f4671ae;

    /* renamed from: af */
    private C1468i f4672af;

    /* renamed from: ag */
    private AMS_OBJECT_DATA f4673ag;

    /* renamed from: ah */
    private int f4674ah;

    /* renamed from: ai */
    private boolean f4675ai;

    /* renamed from: aj */
    private boolean f4676aj;

    /* renamed from: ak */
    private int f4677ak;

    /* renamed from: al */
    private int f4678al;

    /* renamed from: am */
    private boolean f4679am;

    /* renamed from: an */
    private int f4680an;

    /* renamed from: ao */
    private boolean f4681ao;

    /* renamed from: ap */
    private int f4682ap;

    /* renamed from: aq */
    private float[] f4683aq;

    /* renamed from: ar */
    private float[] f4684ar;

    /* renamed from: as */
    private float f4685as;

    /* renamed from: at */
    private InterfaceC1552q f4686at;

    /* renamed from: au */
    private InterfaceC1553r f4687au;

    /* renamed from: av */
    private boolean f4688av;

    /* renamed from: aw */
    private float f4689aw;

    /* renamed from: ax */
    private float f4690ax;

    /* renamed from: ay */
    private int f4691ay;

    /* renamed from: az */
    private C1398c f4692az;

    public AMSDrawManager(Context context, int i, int i2) {
        super(context);
        this.f4652R = null;
        this.f4653S = null;
        this.f4654T = null;
        this.f4655U = null;
        this.f4656V = null;
        this.f4657W = false;
        this.f4667aa = false;
        this.f4668ab = null;
        this.f4669ac = 32;
        this.f4670ad = 2;
        this.f4671ae = 0;
        this.f4672af = null;
        this.f4673ag = null;
        this.f4674ah = 0;
        this.f4675ai = false;
        this.f4676aj = false;
        this.f4677ak = 0;
        this.f4678al = 0;
        this.f4679am = false;
        this.f4680an = 0;
        this.f4681ao = true;
        this.f4685as = 32.0f;
        this.f4686at = null;
        this.f4687au = null;
        this.f4688av = false;
        this.f4689aw = 0.0f;
        this.f4690ax = 0.0f;
        this.f4691ay = 100;
        this.f4692az = null;
        this.f4659aA = false;
        this.f4660aB = false;
        this.f4661aC = new PointF(0.0f, 0.0f);
        this.f4662aD = null;
        this.f4663aE = null;
        this.f4664aF = new C1378ao(this);
        this.f4665aG = 240;
        this.f4666aH = new C1377an(this);
        this.f4640F = context;
        this.f4646L = 1;
        this.f4647M = 0;
        this.f4651Q = i / 240.0f;
        this.f4650P = 1;
        this.f4648N = -16777216;
        this.f4649O = -1;
        this.f4644J = i;
        this.f4645K = i2;
        this.f4654T = null;
        this.f4655U = null;
        new File(f4637a).mkdirs();
        new File(f4638b).mkdirs();
        new File(f4639c).mkdirs();
        new File(AMSActivity.f4623e).mkdirs();
        new File(AMSActivity.f4624f).mkdirs();
        this.f4685as = getContext().getResources().getDimensionPixelSize(R.dimen.ams_invalidate_rect_margin);
    }

    public AMSDrawManager(Context context) {
        super(context);
        this.f4652R = null;
        this.f4653S = null;
        this.f4654T = null;
        this.f4655U = null;
        this.f4656V = null;
        this.f4657W = false;
        this.f4667aa = false;
        this.f4668ab = null;
        this.f4669ac = 32;
        this.f4670ad = 2;
        this.f4671ae = 0;
        this.f4672af = null;
        this.f4673ag = null;
        this.f4674ah = 0;
        this.f4675ai = false;
        this.f4676aj = false;
        this.f4677ak = 0;
        this.f4678al = 0;
        this.f4679am = false;
        this.f4680an = 0;
        this.f4681ao = true;
        this.f4685as = 32.0f;
        this.f4686at = null;
        this.f4687au = null;
        this.f4688av = false;
        this.f4689aw = 0.0f;
        this.f4690ax = 0.0f;
        this.f4691ay = 100;
        this.f4692az = null;
        this.f4659aA = false;
        this.f4660aB = false;
        this.f4661aC = new PointF(0.0f, 0.0f);
        this.f4662aD = null;
        this.f4663aE = null;
        this.f4664aF = new C1378ao(this);
        this.f4665aG = 240;
        this.f4666aH = new C1377an(this);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) throws Resources.NotFoundException {
        switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
            case 0:
                this.f4680an = 0;
                m4778a(motionEvent);
                break;
            case 1:
                if (this.f4680an == 0) {
                    m4788c(motionEvent);
                }
                this.f4680an = 0;
                break;
            case 2:
                if (this.f4680an == 1 && this.f4681ao) {
                    return m4859d(motionEvent);
                }
                m4785b(motionEvent);
                break;
            case 5:
                if (this.f4681ao) {
                    this.f4680an = 1;
                    if (this.f4646L == 1) {
                        m4793g();
                    } else if (this.f4692az == null) {
                        if (!this.f4667aa) {
                            if (this.f4652R != null) {
                                this.f4652R.mo4886a();
                                this.f4652R.f5123B = 0;
                            }
                        } else {
                            m4788c(motionEvent);
                        }
                    } else {
                        m4811y();
                    }
                    return m4859d(motionEvent);
                }
                break;
            case 6:
                if (this.f4681ao) {
                    return m4859d(motionEvent);
                }
                break;
        }
        if (this.f4652R == null) {
            return true;
        }
        if (this.f4653S != null || this.f4652R.m5307d() == null) {
            invalidate();
            return true;
        }
        invalidate(this.f4652R.m5307d());
        return true;
    }

    /* renamed from: d */
    private PointF m4765d(float f, float f2) {
        float fB = m4856B();
        PointF pointFD = m4858D();
        if (fB == 1.0f && pointFD.x == 0.0f && pointFD.y == 0.0f) {
            return new PointF(f, f2);
        }
        return new PointF((f - pointFD.x) / fB, (f2 - pointFD.y) / fB);
    }

    public void setBitmapForAMS(String str) {
        if (str == null) {
            setBitmap(this.f4654T);
            return;
        }
        Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(str);
        if (bitmapDecodeFile != null) {
            setBitmap(bitmapDecodeFile);
        }
    }

    public void setEnableZoom(boolean z) {
        this.f4681ao = z;
    }

    /* renamed from: a */
    public boolean m4772a() {
        try {
            if (this.f4654T != null) {
                this.f4654T.recycle();
                this.f4654T = null;
            }
            this.f4654T = Bitmap.createBitmap(this.f4644J, this.f4645K, Bitmap.Config.ARGB_8888);
            if (this.f4655U != null) {
                this.f4655U.recycle();
                this.f4655U = null;
            }
            this.f4655U = Bitmap.createBitmap(this.f4644J, this.f4645K, Bitmap.Config.ARGB_8888);
            setDefaultScale(0);
            setBitmap(this.f4654T);
            m4857C();
            m4745E();
            if (!m4776a(Color.red(this.f4649O), Color.green(this.f4649O), Color.blue(this.f4649O), true)) {
                return false;
            }
            m4775a(this.f4646L, this.f4647M, this.f4648N, this.f4650P);
            m4746F();
            return true;
        } catch (OutOfMemoryError e) {
            C1619g.m5888a(this.f4640F, R.string.chat_view_memory_error, 0).show();
            return false;
        }
    }

    /* renamed from: E */
    private boolean m4745E() {
        if (this.f4641G != null) {
            this.f4641G.VipAMS_Close(this.f4642H);
            this.f4641G = null;
        }
        this.f4641G = new AMSLibs();
        this.f4641G.VipAMS_Init();
        String str = f4638b;
        this.f4641G.VipAMS_SetTempFilePath(str.getBytes(), str.getBytes().length);
        this.f4643I = new AMS_UI_DATA();
        this.f4643I.Init();
        this.f4643I.SetRect((short) 0, (short) 0, (short) this.f4644J, (short) this.f4645K);
        this.f4643I.m_rgbPen = this.f4648N;
        this.f4643I.m_rgbBack = this.f4649O;
        this.f4643I.m_cObjectSize = (byte) this.f4650P;
        this.f4643I.m_eObjectType = (byte) 1;
        this.f4643I.m_cObjectStyle = (byte) 0;
        AMS_OPTION ams_option = new AMS_OPTION();
        ams_option.Init();
        this.f4642H = this.f4641G.VipAMS_Open(ams_option);
        AMS_OBJECT_DATA ams_object_data = new AMS_OBJECT_DATA();
        ams_object_data.setM_cSize(this.f4643I.m_cObjectSize);
        ams_object_data.setM_cStyle(this.f4643I.m_cObjectStyle);
        ams_object_data.setM_nColorR(Color.red(this.f4643I.m_rgbPen));
        ams_object_data.setM_nColorG(Color.green(this.f4643I.m_rgbPen));
        ams_object_data.setM_nColorB(Color.blue(this.f4643I.m_rgbPen));
        if (this.f4641G.VipAMS_TotalNewEncoding(this.f4642H, this.f4643I.m_rectRegion, ams_object_data)) {
            return true;
        }
        C1341p.m4651a("Error Code: " + this.f4641G.VipAMS_GetErrorCode(this.f4642H), getClass().getSimpleName());
        return false;
    }

    /* renamed from: b */
    private boolean m4763b(int i, int i2, int i3, int i4) {
        if (!this.f4641G.VipAMS_SetCurObjectType(this.f4642H, (byte) i)) {
            C1341p.m4651a(" Error Code =" + this.f4641G.VipAMS_GetErrorCode(this.f4642H) + ", Line : " + new Exception().getStackTrace()[0].getLineNumber(), getClass().getSimpleName());
            return false;
        }
        if (!this.f4641G.VipAMS_SetCurObjectStyle(this.f4642H, (byte) i2)) {
            C1341p.m4651a(" Error Code =" + this.f4641G.VipAMS_GetErrorCode(this.f4642H) + ", Line : " + new Exception().getStackTrace()[0].getLineNumber(), getClass().getSimpleName());
            return false;
        }
        if (!this.f4641G.VipAMS_SetCurObjectSize(this.f4642H, (byte) i4)) {
            C1341p.m4651a(" Error Code =" + this.f4641G.VipAMS_GetErrorCode(this.f4642H) + ", Line : " + new Exception().getStackTrace()[0].getLineNumber(), getClass().getSimpleName());
            return false;
        }
        if (!this.f4641G.VipAMS_SetCurObjectColor(this.f4642H, Color.red(i3), Color.green(i3), Color.blue(i3))) {
            C1341p.m4651a(" Error Code =" + this.f4641G.VipAMS_GetErrorCode(this.f4642H) + ", Line : " + new Exception().getStackTrace()[0].getLineNumber(), getClass().getSimpleName());
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public boolean m4775a(int i, int i2, int i3, int i4) {
        this.f4643I.m_rgbBack = this.f4649O;
        if (!m4763b(i, i2, i3, i4)) {
            return false;
        }
        this.f4646L = i;
        this.f4647M = i2;
        this.f4648N = i3;
        this.f4650P = i4;
        if (this.f4652R != null) {
            this.f4652R.mo5304c();
            this.f4652R = null;
        }
        switch (i) {
            case 1:
                this.f4652R = new C1367ad(this.f4647M, this.f4648N, this.f4650P);
                if (this.f4647M == 4) {
                    this.f4658Z = this.f4650P;
                    break;
                }
                break;
            case 2:
                C1385av c1385av = new C1385av(this.f4647M, this.f4648N, this.f4650P, true, this.f4644J, this.f4645K);
                c1385av.m4970a(this.f4686at);
                this.f4652R = c1385av;
                break;
            case 3:
                this.f4652R = new C1551p(this.f4647M, this.f4648N, this.f4650P, false);
                break;
            case 4:
                this.f4652R = new C1380aq(this.f4647M, this.f4648N, this.f4650P, false);
                this.f4652R.m5306c(getContext().getResources().getDrawable(R.drawable.more_option_icon_help));
                break;
        }
        this.f4652R.m5293a(this.f4641G, this.f4642H, this.f4643I);
        this.f4652R.m5288a(this.f4654T, this.f4655U);
        this.f4652R.m5300b(this.f4656V);
        this.f4652R.mo4887a(this.f4651Q);
        return true;
    }

    public void setEraserSize(int i) {
        this.f4658Z = i;
    }

    /* renamed from: a */
    public boolean m4776a(int i, int i2, int i3, boolean z) {
        if (z && !this.f4641G.VipAMS_SetBackgroundColor(this.f4642H, i, i2, i3)) {
            C1341p.m4651a("VipAMS_SetBackgroundColor Error = " + this.f4641G.VipAMS_GetErrorCode(this.f4642H), getClass().getSimpleName());
            return false;
        }
        this.f4649O = Color.rgb(i, i2, i3);
        if (this.f4656V != null) {
            this.f4656V.recycle();
            this.f4656V = null;
        }
        try {
            this.f4656V = Bitmap.createBitmap(this.f4654T.getWidth(), this.f4654T.getHeight(), Bitmap.Config.ARGB_8888);
            new Canvas(this.f4656V).drawColor(this.f4649O);
            if (this.f4652R != null) {
                this.f4652R.m5300b(this.f4656V);
            }
            if (this.f4653S != null) {
                this.f4653S.m5300b(this.f4656V);
            }
            return true;
        } catch (OutOfMemoryError e) {
            C1619g.m5888a(this.f4640F, R.string.chat_view_memory_error, 0).show();
            return false;
        }
    }

    /* renamed from: a */
    public boolean m4777a(Bitmap bitmap, boolean z) {
        if (z) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int[] iArr = new int[width * height];
            bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
            if (!this.f4641G.VipAMS_SetBackgroundRawImage(this.f4642H, iArr, width, height, 24)) {
                C1341p.m4651a("VipAMS_SetBackgroundRawImage1 Error = " + this.f4641G.VipAMS_GetErrorCode(this.f4642H), getClass().getSimpleName());
                return false;
            }
        }
        if (this.f4656V != null) {
            this.f4656V.recycle();
            this.f4656V = null;
        }
        this.f4656V = Bitmap.createBitmap(this.f4654T.getWidth(), this.f4654T.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(this.f4656V);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setFilterBitmap(true);
        canvas.drawBitmap(bitmap, new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), new Rect(0, 0, this.f4654T.getWidth(), this.f4654T.getHeight()), paint);
        if (this.f4652R != null) {
            this.f4652R.m5300b(this.f4656V);
        }
        if (this.f4653S != null) {
            this.f4653S.m5300b(this.f4656V);
        }
        return true;
    }

    public void setPlayMode(boolean z) {
        if (z) {
            setOnTouchListener(null);
        } else {
            setOnTouchListener(this);
        }
    }

    public void setEditMode(boolean z, boolean z2) {
        boolean z3 = false;
        this.f4667aa = z;
        if (!this.f4667aa) {
            if (this.f4653S != null) {
                this.f4653S = null;
                this.f4668ab = null;
                m4793g();
                z3 = true;
            }
            m4775a(this.f4646L, this.f4647M, this.f4648N, this.f4650P);
        }
        if (!z3 && z2) {
            m4793g();
        }
    }

    public void setAMSLib(AMSLibs aMSLibs, int i, AMS_UI_DATA ams_ui_data) {
        this.f4641G = aMSLibs;
        this.f4642H = i;
        this.f4643I = ams_ui_data;
    }

    public void setOnObjectListener(InterfaceC1375al interfaceC1375al) {
        this.f4663aE = interfaceC1375al;
    }

    public void setOnTextInputRequestListener(InterfaceC1552q interfaceC1552q) {
        this.f4686at = interfaceC1552q;
    }

    /* renamed from: b */
    public int m4782b() {
        return this.f4649O;
    }

    /* renamed from: c */
    public int m4786c() {
        return this.f4641G.VipAMS_GetBGAudioStyle(this.f4642H);
    }

    /* renamed from: d */
    public boolean m4790d() {
        switch (m4786c()) {
            case 1:
            case 2:
            case 3:
                return true;
            default:
                return false;
        }
    }

    /* renamed from: e */
    public C1468i m4791e() {
        return this.f4653S;
    }

    /* renamed from: a */
    public boolean m4774a(int i, int i2, int i3) {
        if (!this.f4667aa || this.f4653S == null) {
            return false;
        }
        this.f4647M = i;
        this.f4648N = i2;
        this.f4650P = i3;
        m4763b(this.f4646L, this.f4647M, i2, i3);
        return this.f4653S.mo4946a(this.f4647M, i2, i3);
    }

    /* renamed from: a */
    public boolean m4778a(MotionEvent motionEvent) {
        float f;
        PointF pointF = new PointF();
        pointF.set(m4765d(motionEvent.getX(), motionEvent.getY()));
        float f2 = pointF.x;
        float f3 = pointF.y;
        this.f4691ay = 101;
        if (this.f4646L == 1) {
            this.f4688av = false;
            if (f2 < 0.0f || f3 < 0.0f || f2 > this.f4644J || f3 > this.f4645K) {
                this.f4688av = true;
                return true;
            }
            f = f2;
        } else {
            if (f2 < 0.0f) {
                f2 = 0.0f;
            }
            float f4 = f3 >= 0.0f ? f3 : 0.0f;
            float f5 = f2 > ((float) this.f4644J) ? this.f4644J - 1 : f2;
            if (f4 > this.f4645K) {
                f = f5;
                f3 = this.f4645K - 1;
            } else {
                float f6 = f4;
                f = f5;
                f3 = f6;
            }
        }
        return m4757a(f, f3, motionEvent);
    }

    /* renamed from: b */
    public boolean m4785b(MotionEvent motionEvent) throws Resources.NotFoundException {
        float f;
        float f2;
        PointF pointF = new PointF();
        pointF.set(m4765d(motionEvent.getX(), motionEvent.getY()));
        float f3 = pointF.x;
        float f4 = pointF.y;
        this.f4691ay = 102;
        if (this.f4646L != 1) {
            if (f3 < 0.0f) {
                f3 = 0.0f;
            }
            f = f4 >= 0.0f ? f4 : 0.0f;
            f2 = f3 > ((float) this.f4644J) ? this.f4644J - 1 : f3;
            if (f > this.f4645K) {
                f = this.f4645K - 1;
            }
        } else {
            if (f3 < 0.0f || f4 < 0.0f || f3 > this.f4644J || f4 > this.f4645K) {
                if (!this.f4688av) {
                    this.f4688av = true;
                    if (f3 < 0.0f) {
                        f3 = 0.0f;
                    }
                    f = f4 >= 0.0f ? f4 : 0.0f;
                    float f5 = f3 > ((float) this.f4644J) ? this.f4644J - 1 : f3;
                    if (f > this.f4645K) {
                        f = this.f4645K - 1;
                    }
                    m4761b(f5, f, motionEvent);
                    return m4758a(f5, f, false);
                }
                this.f4689aw = f3;
                this.f4690ax = f4;
                return true;
            }
            if (this.f4688av) {
                this.f4688av = false;
                float f6 = this.f4689aw;
                float f7 = this.f4690ax;
                if (f6 < 0.0f) {
                    f6 = 0.0f;
                }
                f = f7 >= 0.0f ? f7 : 0.0f;
                f2 = f6 > ((float) this.f4644J) ? this.f4644J - 1 : f6;
                if (f > this.f4645K) {
                    f = this.f4645K - 1;
                }
                m4757a(f2, f, motionEvent);
            } else {
                f = f4;
                f2 = f3;
            }
        }
        return m4761b(f2, f, motionEvent);
    }

    /* renamed from: c */
    public boolean m4788c(MotionEvent motionEvent) {
        float f;
        PointF pointF = new PointF();
        pointF.set(m4765d(motionEvent.getX(), motionEvent.getY()));
        float f2 = pointF.x;
        float f3 = pointF.y;
        this.f4691ay = 103;
        if (this.f4646L != 1) {
            if (f2 < 0.0f) {
                f2 = 0.0f;
            }
            float f4 = f3 >= 0.0f ? f3 : 0.0f;
            float f5 = f2 > ((float) this.f4644J) ? this.f4644J - 1 : f2;
            if (f4 > this.f4645K) {
                f = f5;
                f3 = this.f4645K - 1;
            } else {
                float f6 = f4;
                f = f5;
                f3 = f6;
            }
        } else {
            if (f2 < 0.0f || f3 < 0.0f || f2 > this.f4644J || f3 > this.f4645K) {
                return true;
            }
            f = f2;
        }
        return m4758a(f, f3, true);
    }

    /* renamed from: a */
    private boolean m4757a(float f, float f2, MotionEvent motionEvent) throws Resources.NotFoundException {
        int m_cStyle;
        if (m4773a(f, f2)) {
            return true;
        }
        if (m4767e(motionEvent)) {
            this.f4657W = true;
            setEditMode(false, false);
            m4763b(1, 4, this.f4648N, this.f4658Z);
            this.f4652R = new C1367ad(4, this.f4648N, this.f4658Z);
            this.f4652R.m5293a(this.f4641G, this.f4642H, this.f4643I);
            this.f4652R.m5288a(this.f4654T, this.f4655U);
            this.f4652R.m5300b(this.f4656V);
            this.f4652R.mo4887a(this.f4651Q);
            return this.f4652R.mo4893b(f, f2);
        }
        if (this.f4653S != null && this.f4653S.mo4944a(f, f2)) {
            return this.f4653S.mo4893b(f, f2);
        }
        AMS_SELECT_OBJECT ams_select_object = new AMS_SELECT_OBJECT();
        if (!this.f4641G.VipAMS_SelectObject(this.f4642H, (int) f, (int) f2, ams_select_object, this.f4646L)) {
            if (this.f4646L == 3 && this.f4647M == -1) {
                return false;
            }
            this.f4652R.m5288a(this.f4654T, this.f4655U);
            boolean z = this.f4667aa;
            setEditMode(false, false);
            if (z) {
                this.f4652R.m5302b(false);
            }
            if (this.f4663aE != null) {
                this.f4663aE.mo4925a(2, 0, 0, 0, 0);
            }
            if (this.f4646L == 1 && this.f4647M == 0 && m4768f(motionEvent)) {
                C1468i c1468i = this.f4652R;
                float pressure = motionEvent.getPressure();
                this.f4652R.getClass();
                c1468i.m5299b(pressure * 4096.0f);
            } else {
                this.f4652R.m5299b(-1.0f);
            }
            if (this.f4646L == 2) {
                this.f4687au.mo5121a(false);
            }
            return this.f4652R.mo4893b(f, f2);
        }
        setEditMode(true, false);
        this.f4668ab = ams_select_object;
        AMS_OBJECT_DATA ams_object_data = new AMS_OBJECT_DATA();
        this.f4641G.VipAMS_GetSelectObjectData(this.f4668ab.getM_pSelectObjectData(), ams_object_data);
        int m_eType = ams_object_data.getM_eType();
        if (m_eType == 3) {
            m_cStyle = ams_object_data.getM_cAdditionalID();
        } else {
            m_cStyle = ams_object_data.getM_cStyle();
        }
        byte m_cSize = ams_object_data.getM_cSize();
        int iRgb = Color.rgb(ams_object_data.getM_nColorR(), ams_object_data.getM_nColorG(), ams_object_data.getM_nColorB());
        if (!m4763b(m_eType, m_cStyle, iRgb, m_cSize)) {
            return false;
        }
        if (this.f4663aE != null) {
            if (ams_object_data.getM_eType() == 3 && ams_object_data.getM_cStyle() == 2) {
                this.f4663aE.mo4925a(1, 3, -1, this.f4648N, this.f4650P);
            } else {
                this.f4663aE.mo4925a(1, m_eType, m_cStyle, iRgb, m_cSize);
            }
        }
        m4779a(this.f4668ab);
        Drawable drawable = this.f4640F.getResources().getDrawable(R.drawable.ams_ics_selector_image_crop_cancel);
        Drawable drawable2 = this.f4640F.getResources().getDrawable(R.drawable.ams_ics_selector_image_crop_01);
        Drawable drawable3 = this.f4640F.getResources().getDrawable(R.drawable.ams_ics_selector_image_crop_01);
        Drawable drawable4 = this.f4640F.getResources().getDrawable(R.drawable.ams_ics_selector_image_crop_02);
        Drawable drawable5 = this.f4640F.getResources().getDrawable(R.drawable.ams_ics_selector_image_crop_h);
        Drawable drawable6 = this.f4640F.getResources().getDrawable(R.drawable.ams_ics_selector_image_crop_w);
        Drawable drawable7 = this.f4640F.getResources().getDrawable(R.drawable.ams_ics_selector_image_crop_h);
        Drawable drawable8 = this.f4640F.getResources().getDrawable(R.drawable.ams_ics_selector_image_crop_w);
        if (this.f4653S != null) {
            this.f4653S.mo5304c();
            this.f4653S = null;
        }
        switch (this.f4646L) {
            case 2:
                C1385av c1385av = new C1385av(m_cStyle, iRgb, m_cSize, true, this.f4644J, this.f4645K);
                c1385av.m4970a(this.f4686at);
                c1385av.m5302b(false);
                this.f4653S = c1385av;
                this.f4653S.m5290a(this.f4640F.getResources().getDrawable(R.drawable.co_emoti_selected_02));
                this.f4653S.m5292a(drawable5, drawable6, drawable7, drawable8);
                this.f4653S.m5301b(drawable);
                this.f4653S.m5295a(this.f4664aF);
                this.f4653S.m5285a(5);
                this.f4687au.mo5121a(true);
                break;
            case 3:
                if (ams_object_data.getM_cStyle() == 0) {
                    this.f4653S = new C1551p(m_cStyle, iRgb, m_cSize, false);
                } else {
                    this.f4653S = new C1551p(-1, this.f4648N, this.f4650P, Bitmap.createBitmap(this.f4641G.VipAMS_GetObjectImageBuf(this.f4642H, ams_object_data), AMSLibs.g_nCurObjectImageWidth, AMSLibs.g_nCurObjectImageHeight, Bitmap.Config.ARGB_8888), false);
                }
                this.f4653S.m5290a(this.f4640F.getResources().getDrawable(R.drawable.co_emoti_selected_02));
                this.f4653S.m5301b(drawable);
                this.f4653S.m5295a(this.f4664aF);
                this.f4653S.m5285a(5);
                break;
            case 4:
                this.f4653S = new C1380aq(m_cStyle, iRgb, m_cSize, false);
                Drawable drawable9 = this.f4640F.getResources().getDrawable(R.drawable.co_emoti_selected_02);
                this.f4653S.m5306c(getContext().getResources().getDrawable(R.drawable.more_option_icon_help));
                this.f4653S.m5290a(drawable9);
                this.f4653S.m5291a(drawable2, drawable3, drawable4);
                this.f4653S.m5301b(drawable);
                this.f4653S.m5295a(this.f4664aF);
                this.f4653S.m5285a(5);
                break;
            default:
                this.f4653S = new C1551p(0, iRgb, m_cSize, true);
                this.f4653S.m5290a(this.f4640F.getResources().getDrawable(R.drawable.memo_bg_focus_02));
                this.f4653S.m5291a(drawable2, drawable3, drawable4);
                this.f4653S.m5301b(drawable);
                this.f4653S.m5295a(this.f4664aF);
                this.f4653S.m5285a(5);
                break;
        }
        this.f4653S.m5293a(this.f4641G, this.f4642H, this.f4643I);
        this.f4653S.m5294a(this.f4668ab);
        this.f4653S.m5300b(this.f4656V);
        this.f4653S.mo4887a(this.f4651Q);
        this.f4653S.m5296a(true);
        this.f4653S.m5288a(this.f4654T, this.f4655U);
        return this.f4653S.mo4893b(f, f2);
    }

    /* renamed from: b */
    private boolean m4761b(float f, float f2, MotionEvent motionEvent) {
        if (m4784b(f, f2)) {
            return true;
        }
        if (!this.f4667aa) {
            if (this.f4646L == 1 && this.f4647M == 0 && m4768f(motionEvent)) {
                C1468i c1468i = this.f4652R;
                float pressure = motionEvent.getPressure();
                this.f4652R.getClass();
                c1468i.m5299b(pressure * 4096.0f);
            } else {
                this.f4652R.m5299b(-1.0f);
            }
            return this.f4652R.mo4895c(f, f2);
        }
        if (this.f4653S == null) {
            return false;
        }
        if (this.f4663aE != null) {
            getLocationOnScreen(new int[2]);
            this.f4663aE.mo4925a(3, (int) (r5[0] + f), (int) (r5[1] + f2), 0, 0);
        }
        return this.f4653S.mo4895c(f, f2);
    }

    /* renamed from: a */
    private boolean m4758a(float f, float f2, boolean z) {
        if (m4787c(f, f2)) {
            return true;
        }
        if (!this.f4667aa) {
            this.f4652R.mo4894c(z);
            boolean zMo4896d = this.f4652R.mo4896d(f, f2);
            if (this.f4663aE != null) {
                this.f4663aE.mo4925a(0, 0, 0, 0, 0);
            }
            if (this.f4657W) {
                this.f4657W = false;
                m4775a(this.f4646L, this.f4647M, this.f4648N, this.f4650P);
            }
            return zMo4896d;
        }
        if (this.f4653S == null) {
            return false;
        }
        if (this.f4663aE != null) {
            getLocationOnScreen(new int[2]);
            this.f4663aE.mo4925a(4, (int) (r5[0] + f), (int) (r5[1] + f2), 0, 0);
        }
        this.f4653S.mo4894c(z);
        return this.f4653S.mo4896d(f, f2);
    }

    /* renamed from: f */
    public Bitmap m4792f() {
        return this.f4654T;
    }

    /* renamed from: F */
    private boolean m4746F() {
        Canvas canvas = new Canvas(this.f4654T);
        if (this.f4656V != null) {
            canvas.drawBitmap(this.f4656V, new Rect(0, 0, this.f4656V.getWidth(), this.f4656V.getHeight()), new Rect(0, 0, this.f4654T.getWidth(), this.f4654T.getHeight()), (Paint) null);
            return true;
        }
        canvas.drawColor(this.f4649O);
        return true;
    }

    /* renamed from: G */
    private boolean m4747G() {
        switch (this.f4641G.VipAMS_GetBackgroundStyle(this.f4642H)) {
            case 0:
                int iVipAMS_GetBackgroundColorR = this.f4641G.VipAMS_GetBackgroundColorR(this.f4642H);
                int iVipAMS_GetBackgroundColorG = this.f4641G.VipAMS_GetBackgroundColorG(this.f4642H);
                int iVipAMS_GetBackgroundColorB = this.f4641G.VipAMS_GetBackgroundColorB(this.f4642H);
                this.f4649O = Color.rgb(iVipAMS_GetBackgroundColorR, iVipAMS_GetBackgroundColorG, iVipAMS_GetBackgroundColorB);
                m4776a(iVipAMS_GetBackgroundColorR, iVipAMS_GetBackgroundColorG, iVipAMS_GetBackgroundColorB, false);
                break;
            case 2:
                m4755a(this.f4641G.VipAMS_GetBackgroundIndex(this.f4642H));
                break;
            case 4:
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(this.f4641G.VipAMS_GetCurrentBackgroundBuf(this.f4642H), AMSLibs.g_nCurrentBackgroundWidth, AMSLibs.g_nCurrentBackgroundHeight, Bitmap.Config.ARGB_8888);
                m4777a(bitmapCreateBitmap, false);
                bitmapCreateBitmap.recycle();
                break;
        }
        return true;
    }

    /* renamed from: g */
    public boolean m4793g() {
        return m4779a((AMS_SELECT_OBJECT) null);
    }

    /* renamed from: a */
    public boolean m4779a(AMS_SELECT_OBJECT ams_select_object) {
        float m_pnAMSPointPressure;
        m4747G();
        m4746F();
        AMS_OBJECT_DATA ams_object_data = new AMS_OBJECT_DATA();
        int iVipAMS_GetNextDrawingData = this.f4641G.VipAMS_GetNextDrawingData(this.f4642H, 0, ams_object_data);
        C1468i c1385av = null;
        while (iVipAMS_GetNextDrawingData != 0) {
            if (ams_select_object != null && iVipAMS_GetNextDrawingData == ams_select_object.getM_pSelectObjectNode()) {
                iVipAMS_GetNextDrawingData = this.f4641G.VipAMS_GetNextDrawingData(this.f4642H, iVipAMS_GetNextDrawingData, ams_object_data);
            } else {
                switch (ams_object_data.getM_eType()) {
                    case 1:
                        c1385av = new C1367ad(ams_object_data.getM_cStyle(), Color.rgb(ams_object_data.getM_nColorR(), ams_object_data.getM_nColorG(), ams_object_data.getM_nColorB()), ams_object_data.getM_cSize());
                        if (ams_object_data.getM_cStyle() != 4) {
                            c1385av.m5287a(this.f4654T);
                        } else {
                            c1385av.m5288a(this.f4654T, this.f4655U);
                        }
                        c1385av.m5300b(this.f4656V);
                        c1385av.mo4887a(this.f4651Q);
                        int m_nPointNum = ams_object_data.getM_TPoint().getM_nPointNum();
                        for (int i = 0; i < m_nPointNum; i++) {
                            float m_pnAMSPointX = ams_object_data.getM_TPoint().getM_pnAMSPointX(i);
                            float m_pnAMSPointY = ams_object_data.getM_TPoint().getM_pnAMSPointY(i);
                            if (ams_object_data.getM_TPoint().getM_bPressureFlag()) {
                                m_pnAMSPointPressure = ams_object_data.getM_TPoint().getM_pnAMSPointPressure(i);
                            } else {
                                m_pnAMSPointPressure = -1.0f;
                            }
                            if (i == 0) {
                                c1385av.mo4897e(m_pnAMSPointX, m_pnAMSPointY);
                            } else if (i < ams_object_data.getM_TPoint().getM_nPointNum() - 1) {
                                c1385av.mo4891a(m_pnAMSPointX, m_pnAMSPointY, 0, m_pnAMSPointPressure, false);
                            }
                            if (i == ams_object_data.getM_TPoint().getM_nPointNum() - 1) {
                                c1385av.mo4898f(m_pnAMSPointX, m_pnAMSPointY);
                            }
                        }
                        break;
                    case 2:
                        c1385av = new C1385av(ams_object_data.getM_cStyle(), Color.rgb(ams_object_data.getM_nColorR(), ams_object_data.getM_nColorG(), ams_object_data.getM_nColorB()), ams_object_data.getM_cSize(), true, this.f4644J, this.f4645K);
                        AMS_RECT m_TRect = ams_object_data.getM_TRect();
                        c1385av.m5287a(this.f4654T);
                        c1385av.m5300b(this.f4656V);
                        c1385av.mo4887a(this.f4651Q);
                        c1385av.mo4972a(m_TRect.nLeft, m_TRect.nTop, m_TRect.nRight, m_TRect.nBottom, ams_object_data.getM_TText().getM_strText(), MotionEventCompat.ACTION_MASK, false);
                        break;
                    case 3:
                        if (ams_object_data.getM_cStyle() == 0) {
                            c1385av = new C1551p(ams_object_data.getM_cAdditionalID(), Color.rgb(ams_object_data.getM_nColorR(), ams_object_data.getM_nColorG(), ams_object_data.getM_nColorB()), ams_object_data.getM_cSize(), false);
                        } else if (ams_object_data.getM_cStyle() == 2) {
                            c1385av = new C1551p(-1, Color.rgb(ams_object_data.getM_nColorR(), ams_object_data.getM_nColorG(), ams_object_data.getM_nColorB()), ams_object_data.getM_cSize(), Bitmap.createBitmap(this.f4641G.VipAMS_GetObjectImageBuf(this.f4642H, ams_object_data), AMSLibs.g_nCurObjectImageWidth, AMSLibs.g_nCurObjectImageHeight, Bitmap.Config.ARGB_8888), false);
                        } else {
                            c1385av = new C1551p(0, Color.rgb(ams_object_data.getM_nColorR(), ams_object_data.getM_nColorG(), ams_object_data.getM_nColorB()), ams_object_data.getM_cSize(), false);
                        }
                        AMS_RECT m_TRect2 = ams_object_data.getM_TRect();
                        c1385av.m5287a(this.f4654T);
                        c1385av.m5300b(this.f4656V);
                        c1385av.mo4887a(this.f4651Q);
                        c1385av.mo5298a(new RectF(m_TRect2.nLeft, m_TRect2.nTop, m_TRect2.nRight, m_TRect2.nBottom), MotionEventCompat.ACTION_MASK, false);
                        break;
                    case 4:
                        c1385av = new C1380aq(ams_object_data.getM_cStyle(), Color.rgb(ams_object_data.getM_nColorR(), ams_object_data.getM_nColorG(), ams_object_data.getM_nColorB()), ams_object_data.getM_cSize(), false);
                        AMS_RECT m_TRect3 = ams_object_data.getM_TRect();
                        c1385av.m5306c(getContext().getResources().getDrawable(R.drawable.more_option_icon_help));
                        c1385av.m5287a(this.f4654T);
                        c1385av.m5300b(this.f4656V);
                        c1385av.mo4887a(this.f4651Q);
                        c1385av.mo4945a(m_TRect3.nLeft, m_TRect3.nTop, m_TRect3.nRight, m_TRect3.nBottom, MotionEventCompat.ACTION_MASK, false);
                        break;
                }
                iVipAMS_GetNextDrawingData = this.f4641G.VipAMS_GetNextDrawingData(this.f4642H, iVipAMS_GetNextDrawingData, ams_object_data);
            }
        }
        if (c1385av != null) {
            c1385av.mo5304c();
        }
        int iVipAMS_GetErrorCode = this.f4641G.VipAMS_GetErrorCode(this.f4642H);
        if (iVipAMS_GetErrorCode == 0) {
            return true;
        }
        C1341p.m4651a(" Error Code =" + iVipAMS_GetErrorCode + ", Line : " + new Exception().getStackTrace()[0].getLineNumber(), getClass().getSimpleName());
        return false;
    }

    /* renamed from: a */
    public boolean m4781a(String str, int i, int i2) throws Resources.NotFoundException {
        int i3;
        int i4;
        if (this.f4646L != 2) {
            return false;
        }
        this.f4648N = i;
        this.f4650P = i2;
        if (this.f4667aa) {
            C1385av c1385av = (C1385av) this.f4653S;
            c1385av.mo4946a(this.f4647M, this.f4648N, this.f4650P);
            c1385av.m4975a(str);
        } else {
            C1385av c1385av2 = (C1385av) this.f4652R;
            m4763b(this.f4646L, this.f4647M, this.f4648N, this.f4650P);
            int i5 = this.f4644J / 2;
            int i6 = this.f4645K / 2;
            if (this.f4660aB) {
                this.f4660aB = false;
                m4811y();
                int i7 = (int) this.f4661aC.x;
                int i8 = (int) this.f4661aC.y;
                c1385av2.m4978a(str, this.f4648N, this.f4650P, i7, i8);
                i4 = i8;
                i3 = i7;
            } else {
                c1385av2.m4977a(str, this.f4648N, this.f4650P);
                int[] iArr = new int[2];
                c1385av2.m4979a(iArr);
                i3 = iArr[0];
                i4 = iArr[1];
            }
            m4762b(i3, i4);
        }
        if (this.f4663aE != null) {
            this.f4663aE.mo4925a(0, 0, 0, 0, 0);
        }
        m4808v();
        return true;
    }

    /* renamed from: b */
    private boolean m4762b(int i, int i2) throws Resources.NotFoundException {
        int m_cStyle;
        AMS_SELECT_OBJECT ams_select_object = new AMS_SELECT_OBJECT();
        if (!this.f4641G.VipAMS_SelectObject(this.f4642H, i, i2, ams_select_object, this.f4646L)) {
            return false;
        }
        setEditMode(true, false);
        this.f4668ab = ams_select_object;
        AMS_OBJECT_DATA ams_object_data = new AMS_OBJECT_DATA();
        this.f4641G.VipAMS_GetSelectObjectData(this.f4668ab.getM_pSelectObjectData(), ams_object_data);
        int m_eType = ams_object_data.getM_eType();
        if (m_eType == 3) {
            m_cStyle = ams_object_data.getM_cAdditionalID();
        } else {
            m_cStyle = ams_object_data.getM_cStyle();
        }
        byte m_cSize = ams_object_data.getM_cSize();
        int iRgb = Color.rgb(ams_object_data.getM_nColorR(), ams_object_data.getM_nColorG(), ams_object_data.getM_nColorB());
        if (!m4763b(m_eType, m_cStyle, iRgb, m_cSize)) {
            return false;
        }
        if (this.f4663aE != null) {
            if (ams_object_data.getM_eType() == 3 && ams_object_data.getM_cStyle() == 2) {
                this.f4663aE.mo4925a(1, 3, -1, this.f4648N, this.f4650P);
            } else {
                this.f4663aE.mo4925a(1, m_eType, m_cStyle, iRgb, m_cSize);
            }
        }
        m4779a(this.f4668ab);
        Drawable drawable = this.f4640F.getResources().getDrawable(R.drawable.ams_ics_selector_image_crop_cancel);
        Drawable drawable2 = this.f4640F.getResources().getDrawable(R.drawable.ams_ics_selector_image_crop_h);
        Drawable drawable3 = this.f4640F.getResources().getDrawable(R.drawable.ams_ics_selector_image_crop_w);
        Drawable drawable4 = this.f4640F.getResources().getDrawable(R.drawable.ams_ics_selector_image_crop_h);
        Drawable drawable5 = this.f4640F.getResources().getDrawable(R.drawable.ams_ics_selector_image_crop_w);
        if (this.f4653S != null) {
            this.f4653S.mo5304c();
            this.f4653S = null;
        }
        switch (this.f4646L) {
            case 2:
                C1385av c1385av = new C1385av(m_cStyle, iRgb, m_cSize, true, this.f4644J, this.f4645K);
                c1385av.m4970a(this.f4686at);
                c1385av.m5302b(true);
                this.f4653S = c1385av;
                this.f4653S.m5290a(this.f4640F.getResources().getDrawable(R.drawable.co_emoti_selected_02));
                this.f4653S.m5292a(drawable2, drawable3, drawable4, drawable5);
                this.f4653S.m5301b(drawable);
                this.f4653S.m5295a(this.f4664aF);
                this.f4653S.m5285a(5);
                break;
            case 3:
                if (ams_object_data.getM_cStyle() == 0) {
                    this.f4653S = new C1551p(m_cStyle, iRgb, m_cSize, false);
                } else {
                    this.f4653S = new C1551p(-1, this.f4648N, this.f4650P, Bitmap.createBitmap(this.f4641G.VipAMS_GetObjectImageBuf(this.f4642H, ams_object_data), AMSLibs.g_nCurObjectImageWidth, AMSLibs.g_nCurObjectImageHeight, Bitmap.Config.ARGB_8888), false);
                }
                this.f4653S.m5302b(true);
                this.f4653S.m5290a(this.f4640F.getResources().getDrawable(R.drawable.co_emoti_selected_02));
                this.f4653S.m5301b(drawable);
                this.f4653S.m5295a(this.f4664aF);
                this.f4653S.m5285a(5);
                ((C1551p) this.f4653S).m5644d(true);
                break;
        }
        this.f4653S.m5293a(this.f4641G, this.f4642H, this.f4643I);
        this.f4653S.m5294a(this.f4668ab);
        this.f4653S.m5300b(this.f4656V);
        this.f4653S.mo4887a(this.f4651Q);
        this.f4653S.m5296a(true);
        this.f4653S.m5288a(this.f4654T, this.f4655U);
        AMS_OBJECT_DATA ams_object_data2 = new AMS_OBJECT_DATA();
        this.f4641G.VipAMS_GetSelectObjectData(this.f4668ab.getM_pSelectObjectData(), ams_object_data2);
        if (this.f4646L == 3) {
            return this.f4653S.mo5297a(new RectF(ams_object_data2.getM_TRect().nLeft, ams_object_data2.getM_TRect().nTop, ams_object_data2.getM_TRect().nRight, ams_object_data2.getM_TRect().nBottom), MotionEventCompat.ACTION_MASK);
        }
        return this.f4653S.mo4971a(ams_object_data2.getM_TRect().nLeft, ams_object_data2.getM_TRect().nTop, ams_object_data2.getM_TRect().nRight, ams_object_data2.getM_TRect().nBottom, new String(ams_object_data2.getM_TText().getM_cText()), MotionEventCompat.ACTION_MASK);
    }

    /* renamed from: h */
    public boolean m4794h() {
        this.f4641G.VipAMS_SetCurrentFrame(this.f4642H, (byte) 0);
        m4747G();
        m4746F();
        this.f4673ag = new AMS_OBJECT_DATA();
        this.f4671ae = 0;
        this.f4675ai = false;
        this.f4674ah = 0;
        this.f4676aj = false;
        this.f4678al = 0;
        return true;
    }

    /* renamed from: i */
    public boolean m4795i() {
        float m_pnAMSPointPressure;
        if (this.f4676aj) {
            return true;
        }
        if (!this.f4675ai) {
            this.f4674ah = 0;
            this.f4671ae = this.f4641G.VipAMS_GetNextDrawingData(this.f4642H, this.f4671ae, this.f4673ag);
            while (this.f4671ae == 0) {
                if (!this.f4641G.VipAMS_SetNextFrame(this.f4642H)) {
                    return false;
                }
                m4746F();
                m4771a(false);
                this.f4671ae = this.f4641G.VipAMS_GetNextDrawingData(this.f4642H, this.f4671ae, this.f4673ag);
            }
            this.f4675ai = true;
        }
        this.f4676aj = true;
        if (this.f4674ah == 0 && this.f4672af != null) {
            this.f4672af.mo5304c();
            this.f4672af = null;
        }
        switch (this.f4673ag.getM_eType()) {
            case 1:
                if (this.f4674ah == 0) {
                    this.f4672af = new C1367ad(this.f4673ag.getM_cStyle(), Color.rgb(this.f4673ag.getM_nColorR(), this.f4673ag.getM_nColorG(), this.f4673ag.getM_nColorB()), this.f4673ag.getM_cSize());
                    this.f4672af.m5288a(this.f4654T, this.f4655U);
                    this.f4672af.m5300b(this.f4656V);
                    this.f4672af.mo4887a(this.f4651Q);
                }
                float m_pnAMSPointX = this.f4673ag.getM_TPoint().getM_pnAMSPointX(this.f4674ah);
                float m_pnAMSPointY = this.f4673ag.getM_TPoint().getM_pnAMSPointY(this.f4674ah);
                if (this.f4673ag.getM_TPoint().getM_bPressureFlag()) {
                    m_pnAMSPointPressure = this.f4673ag.getM_TPoint().getM_pnAMSPointPressure(this.f4674ah);
                } else {
                    m_pnAMSPointPressure = -1.0f;
                }
                if (this.f4674ah == 0) {
                    this.f4672af.mo4897e(m_pnAMSPointX, m_pnAMSPointY);
                    m4750J();
                } else if (this.f4674ah < this.f4673ag.getM_TPoint().getM_nPointNum()) {
                    this.f4672af.mo4890a(m_pnAMSPointX, m_pnAMSPointY, MotionEventCompat.ACTION_MASK, m_pnAMSPointPressure);
                }
                if (this.f4674ah == this.f4673ag.getM_TPoint().getM_nPointNum() - 1) {
                    this.f4672af.mo4898f(m_pnAMSPointX, m_pnAMSPointY);
                    this.f4675ai = false;
                }
                this.f4674ah++;
                this.f4678al++;
                m4756a(m4766e(m_pnAMSPointX, m_pnAMSPointY));
                break;
            case 2:
                if (this.f4674ah == 0) {
                    this.f4672af = new C1385av(this.f4673ag.getM_cStyle(), Color.rgb(this.f4673ag.getM_nColorR(), this.f4673ag.getM_nColorG(), this.f4673ag.getM_nColorB()), this.f4673ag.getM_cSize(), true, this.f4644J, this.f4645K);
                    this.f4672af.m5288a(this.f4654T, this.f4655U);
                    this.f4672af.m5300b(this.f4656V);
                    this.f4672af.mo4887a(this.f4651Q);
                }
                AMS_RECT m_TRect = this.f4673ag.getM_TRect();
                this.f4674ah++;
                this.f4678al++;
                if (this.f4674ah < 32) {
                    this.f4672af.mo4971a(m_TRect.nLeft, m_TRect.nTop, m_TRect.nRight, m_TRect.nBottom, this.f4673ag.getM_TText().getM_strText(), (int) ((this.f4674ah / 2) * (this.f4674ah / 2)));
                } else {
                    this.f4672af.mo4971a(m_TRect.nLeft, m_TRect.nTop, m_TRect.nRight, m_TRect.nBottom, this.f4673ag.getM_TText().getM_strText(), MotionEventCompat.ACTION_MASK);
                    this.f4675ai = false;
                }
                m4756a(m_TRect);
                break;
            case 3:
                int m_cAdditionalID = this.f4673ag.getM_cAdditionalID();
                if (this.f4674ah == 0) {
                    if (this.f4673ag.getM_cStyle() == 0) {
                        this.f4672af = new C1551p(m_cAdditionalID, Color.rgb(this.f4673ag.getM_nColorR(), this.f4673ag.getM_nColorG(), this.f4673ag.getM_nColorB()), this.f4673ag.getM_cSize(), false);
                    } else if (this.f4673ag.getM_cStyle() == 2) {
                        this.f4672af = new C1551p(-1, Color.rgb(this.f4673ag.getM_nColorR(), this.f4673ag.getM_nColorG(), this.f4673ag.getM_nColorB()), this.f4673ag.getM_cSize(), Bitmap.createBitmap(this.f4641G.VipAMS_GetObjectImageBuf(this.f4642H, this.f4673ag), AMSLibs.g_nCurObjectImageWidth, AMSLibs.g_nCurObjectImageHeight, Bitmap.Config.ARGB_8888), false);
                    } else {
                        this.f4672af = new C1551p(0, Color.rgb(this.f4673ag.getM_nColorR(), this.f4673ag.getM_nColorG(), this.f4673ag.getM_nColorB()), this.f4673ag.getM_cSize(), false);
                    }
                    this.f4672af.m5288a(this.f4654T, this.f4655U);
                    this.f4672af.m5300b(this.f4656V);
                    this.f4672af.mo4887a(this.f4651Q);
                }
                AMS_RECT m_TRect2 = this.f4673ag.getM_TRect();
                RectF rectF = new RectF(m_TRect2.nLeft, m_TRect2.nTop, m_TRect2.nRight, m_TRect2.nBottom);
                this.f4674ah++;
                this.f4678al++;
                if (this.f4673ag.getM_cStyle() == 0) {
                    if (m_cAdditionalID < C1561z.m5654a().m5670f()) {
                        if (this.f4674ah < 32) {
                            this.f4672af.mo5297a(rectF, (int) ((this.f4674ah / 2) * (this.f4674ah / 2)));
                        } else {
                            this.f4672af.mo5297a(rectF, MotionEventCompat.ACTION_MASK);
                            this.f4675ai = false;
                        }
                    } else if (m_cAdditionalID < C1561z.m5654a().m5670f() + C1561z.m5654a().m5667d()) {
                        if (this.f4674ah < 32) {
                            this.f4672af.mo5297a(rectF, (this.f4674ah / 2) + 1000);
                        } else {
                            this.f4672af.mo5297a(rectF, MotionEventCompat.ACTION_MASK);
                            this.f4675ai = false;
                        }
                    } else if (this.f4674ah < 32) {
                        this.f4672af.mo5297a(rectF, (int) ((this.f4674ah / 2) * (this.f4674ah / 2)));
                    } else {
                        this.f4672af.mo5297a(rectF, MotionEventCompat.ACTION_MASK);
                        this.f4675ai = false;
                    }
                } else if (this.f4673ag.getM_cStyle() == 2) {
                    if (this.f4674ah < 32) {
                        this.f4672af.mo5297a(rectF, (int) ((this.f4674ah / 2) * (this.f4674ah / 2)));
                    } else {
                        this.f4672af.mo5297a(rectF, MotionEventCompat.ACTION_MASK);
                        this.f4675ai = false;
                    }
                } else if (this.f4674ah < 32) {
                    this.f4672af.mo5297a(rectF, (int) ((this.f4674ah / 2) * (this.f4674ah / 2)));
                } else {
                    this.f4672af.mo5297a(rectF, MotionEventCompat.ACTION_MASK);
                    this.f4675ai = false;
                }
                m4756a(m_TRect2);
                break;
            case 4:
                if (this.f4674ah == 0) {
                    this.f4672af = new C1380aq(this.f4673ag.getM_cStyle(), Color.rgb(this.f4673ag.getM_nColorR(), this.f4673ag.getM_nColorG(), this.f4673ag.getM_nColorB()), this.f4673ag.getM_cSize(), false);
                    this.f4672af.m5306c(getContext().getResources().getDrawable(R.drawable.more_option_icon_help));
                    this.f4672af.m5288a(this.f4654T, this.f4655U);
                    this.f4672af.m5300b(this.f4656V);
                    this.f4672af.mo4887a(this.f4651Q);
                }
                AMS_RECT m_TRect3 = this.f4673ag.getM_TRect();
                this.f4674ah++;
                this.f4678al++;
                if (this.f4674ah < 32) {
                    this.f4672af.mo4888a(m_TRect3.nLeft, m_TRect3.nTop, m_TRect3.nRight, m_TRect3.nBottom, (int) ((this.f4674ah / 2) * (this.f4674ah / 2)));
                } else {
                    this.f4672af.mo4888a(m_TRect3.nLeft, m_TRect3.nTop, m_TRect3.nRight, m_TRect3.nBottom, MotionEventCompat.ACTION_MASK);
                    this.f4675ai = false;
                }
                m4756a(m_TRect3);
                break;
        }
        this.f4676aj = false;
        return true;
    }

    /* renamed from: j */
    public boolean m4796j() {
        if (this.f4653S == null || !this.f4653S.m5303b()) {
            return false;
        }
        setEditMode(false, true);
        if (this.f4663aE != null) {
            this.f4663aE.mo4925a(0, 0, 0, 0, 0);
        }
        m4808v();
        return true;
    }

    /* renamed from: k */
    public boolean m4797k() {
        if (this.f4692az != null) {
            m4811y();
            return false;
        }
        if (this.f4641G == null || this.f4641G.VipAMS_Undo(this.f4642H) == 0) {
            return false;
        }
        setEditMode(false, true);
        if (this.f4663aE != null) {
            this.f4663aE.mo4925a(0, 0, 0, 0, 0);
        }
        m4808v();
        return true;
    }

    /* renamed from: l */
    public boolean m4798l() {
        if (this.f4641G == null || this.f4641G.VipAMS_Redo(this.f4642H) == 0) {
            return false;
        }
        setEditMode(false, true);
        if (this.f4663aE != null) {
            this.f4663aE.mo4925a(0, 0, 0, 0, 0);
        }
        m4808v();
        return true;
    }

    /* renamed from: a */
    public boolean m4780a(String str) {
        if (this.f4641G == null) {
            return false;
        }
        int[] iArr = new int[57600];
        m4801o();
        m4793g();
        Bitmap.createScaledBitmap(this.f4654T, 240, 240, true).getPixels(iArr, 0, 240, 0, 0, 240, 240);
        this.f4641G.VipAMS_SetAMSImageBuf(this.f4642H, iArr, 240, 240);
        AMS_CODING_FILE_INFO[] ams_coding_file_infoArr = {new AMS_CODING_FILE_INFO()};
        ams_coding_file_infoArr[0].setM_eExportType(0);
        ams_coding_file_infoArr[0].setM_strFileName(str);
        if (this.f4641G.VipAMS_TotalSaveEncoding(this.f4642H, ams_coding_file_infoArr) != 0) {
            return true;
        }
        C1341p.m4651a("VipAMS_TotalSaveEncoding Error = " + this.f4641G.VipAMS_GetErrorCode(this.f4642H), getClass().getSimpleName());
        return false;
    }

    /* renamed from: b */
    public int m4783b(String str) {
        if (this.f4641G == null) {
            this.f4679am = false;
            return 3;
        }
        if (!this.f4641G.VipAMS_ClearEncoding(this.f4642H)) {
            this.f4679am = false;
            return 3;
        }
        AMS_CODING_FILE_INFO[] ams_coding_file_infoArr = {new AMS_CODING_FILE_INFO()};
        ams_coding_file_infoArr[0].setM_eExportType(0);
        ams_coding_file_infoArr[0].setM_strFileName(str);
        if (this.f4641G.VipAMS_TotalLoadEncodingFile(this.f4642H, ams_coding_file_infoArr, this.f4643I.m_rectRegion) == 0) {
            int iVipAMS_GetErrorCode = this.f4641G.VipAMS_GetErrorCode(this.f4642H);
            this.f4679am = false;
            switch (iVipAMS_GetErrorCode) {
                case MREvent.SNAP1_Y_POSITIVE /* 49 */:
                    break;
                case MREvent.SNAP1_Y_NEGATIVE /* 50 */:
                    break;
                default:
                    C1341p.m4651a("VipAMS_TotalLoadEncodingFile Error = " + iVipAMS_GetErrorCode, getClass().getSimpleName());
                    break;
            }
            return 3;
        }
        this.f4677ak = m4748H();
        this.f4679am = true;
        return 0;
    }

    /* renamed from: m */
    public int m4799m() {
        return this.f4677ak;
    }

    /* renamed from: n */
    public int m4800n() {
        return this.f4678al;
    }

    /* renamed from: H */
    private int m4748H() {
        int iVipAMS_GetNextDrawingData = 0;
        AMS_OBJECT_DATA ams_object_data = new AMS_OBJECT_DATA();
        if (this.f4641G != null) {
            int m_nPointNum = 0;
            while (true) {
                iVipAMS_GetNextDrawingData = this.f4641G.VipAMS_GetNextDrawingData(this.f4642H, iVipAMS_GetNextDrawingData, ams_object_data);
                while (iVipAMS_GetNextDrawingData == 0) {
                    if (!this.f4641G.VipAMS_SetNextFrame(this.f4642H)) {
                        return m_nPointNum;
                    }
                    iVipAMS_GetNextDrawingData = this.f4641G.VipAMS_GetNextDrawingData(this.f4642H, iVipAMS_GetNextDrawingData, ams_object_data);
                }
                switch (ams_object_data.getM_eType()) {
                    case 1:
                        m_nPointNum += ams_object_data.getM_TPoint().getM_nPointNum();
                        break;
                    case 2:
                    case 3:
                    case 4:
                        m_nPointNum += 32;
                        break;
                }
            }
        } else {
            return 0;
        }
    }

    /* renamed from: o */
    public void m4801o() {
        if (this.f4641G != null) {
            while (this.f4641G.VipAMS_SetNextFrame(this.f4642H)) {
            }
            setEditMode(false, false);
        }
    }

    public void setPage(int i) {
        if (this.f4641G != null) {
            this.f4641G.VipAMS_SetCurrentFrame(this.f4642H, (byte) i);
            setEditMode(false, false);
        }
    }

    /* renamed from: p */
    public int m4802p() {
        if (this.f4641G == null) {
            return -1;
        }
        return this.f4641G.VipAMS_GetLastFrame(this.f4642H);
    }

    /* renamed from: q */
    public boolean m4803q() {
        if (this.f4641G == null) {
            return false;
        }
        return this.f4641G.VipAMS_IsEnableUndo(this.f4642H);
    }

    /* renamed from: r */
    public boolean m4804r() {
        if (this.f4641G == null) {
            return false;
        }
        return this.f4641G.VipAMS_IsEnableRedo(this.f4642H);
    }

    /* renamed from: s */
    public boolean m4805s() {
        return this.f4641G != null && this.f4641G.VipAMS_IsEditEnable(this.f4642H) && this.f4679am;
    }

    /* renamed from: t */
    public boolean m4806t() {
        if (this.f4641G == null) {
            return false;
        }
        return this.f4641G.VipAMS_IsAnimationEnable(this.f4642H);
    }

    /* renamed from: u */
    public void m4807u() {
        this.f4640F = null;
        if (this.f4641G != null) {
            this.f4641G.VipAMS_Close(this.f4642H);
            this.f4641G = null;
        }
        this.f4654T.recycle();
        this.f4654T = null;
        this.f4655U.recycle();
        this.f4655U = null;
        this.f4656V.recycle();
        this.f4656V = null;
        this.f4643I = null;
        this.f4652R = null;
        this.f4653S = null;
        this.f4668ab = null;
        this.f4672af = null;
        this.f4673ag = null;
        this.f4686at = null;
        System.gc();
    }

    /* renamed from: v */
    public void m4808v() {
        m4749I();
    }

    /* renamed from: a */
    public void m4771a(boolean z) {
        if (z) {
            m4808v();
        } else {
            invalidate();
        }
    }

    /* renamed from: I */
    private void m4749I() {
        if (this.f4672af == null) {
            invalidate();
        } else if (this.f4672af.m5307d() == null) {
            invalidate();
        } else {
            invalidate(this.f4672af.m5307d());
        }
    }

    /* renamed from: a */
    private void m4756a(AMS_RECT ams_rect) {
        this.f4672af.m5289a(new Rect((int) (ams_rect.nLeft - this.f4685as), (int) (ams_rect.nTop - this.f4685as), (int) (ams_rect.nRight + this.f4685as), (int) (ams_rect.nBottom + this.f4685as)));
    }

    /* renamed from: J */
    private void m4750J() {
        this.f4682ap = 0;
        this.f4683aq = new float[]{0.0f, 0.0f, 0.0f};
        this.f4684ar = new float[]{0.0f, 0.0f, 0.0f};
    }

    /* renamed from: e */
    private AMS_RECT m4766e(float f, float f2) {
        this.f4683aq[this.f4682ap] = f;
        this.f4684ar[this.f4682ap] = f2;
        this.f4682ap++;
        if (this.f4682ap > 2) {
            this.f4682ap = 0;
        }
        float fMax = Math.max(Math.max(this.f4683aq[0], this.f4683aq[1]), this.f4683aq[2]);
        float fMin = Math.min(Math.min(this.f4683aq[0], this.f4683aq[1]), this.f4683aq[2]);
        float fMax2 = Math.max(Math.max(this.f4684ar[0], this.f4684ar[1]), this.f4684ar[2]);
        float fMin2 = Math.min(Math.min(this.f4684ar[0], this.f4684ar[1]), this.f4684ar[2]);
        AMS_RECT ams_rect = new AMS_RECT();
        ams_rect.nLeft = (short) fMin;
        ams_rect.nTop = (short) fMin2;
        ams_rect.nRight = (short) fMax;
        ams_rect.nBottom = (short) fMax2;
        return ams_rect;
    }

    /* renamed from: c */
    public boolean m4789c(String str) {
        if (this.f4641G != null) {
            this.f4641G.VipAMS_Close(this.f4642H);
            this.f4641G = null;
        }
        this.f4641G = new AMSLibs();
        this.f4641G.VipAMS_Init();
        String str2 = f4638b;
        this.f4641G.VipAMS_SetTempFilePath(str2.getBytes(), str2.getBytes().length);
        this.f4643I = new AMS_UI_DATA();
        this.f4643I.Init();
        this.f4643I.SetRect((short) 0, (short) 0, (short) 100, (short) 100);
        this.f4643I.m_rgbPen = this.f4648N;
        this.f4643I.m_rgbBack = this.f4649O;
        this.f4643I.m_cObjectSize = (byte) this.f4650P;
        this.f4643I.m_eObjectType = (byte) 1;
        this.f4643I.m_cObjectStyle = (byte) 0;
        AMS_OPTION ams_option = new AMS_OPTION();
        ams_option.Init();
        this.f4642H = this.f4641G.VipAMS_Open(ams_option);
        AMS_OBJECT_DATA ams_object_data = new AMS_OBJECT_DATA();
        ams_object_data.setM_cSize(this.f4643I.m_cObjectSize);
        ams_object_data.setM_cStyle(this.f4643I.m_cObjectStyle);
        ams_object_data.setM_nColorR(Color.red(this.f4643I.m_rgbPen));
        ams_object_data.setM_nColorG(Color.green(this.f4643I.m_rgbPen));
        ams_object_data.setM_nColorB(Color.blue(this.f4643I.m_rgbPen));
        if (!this.f4641G.VipAMS_TotalNewEncoding(this.f4642H, this.f4643I.m_rectRegion, ams_object_data)) {
            C1341p.m4651a("Error Code: " + this.f4641G.VipAMS_GetErrorCode(this.f4642H), getClass().getSimpleName());
            return false;
        }
        switch (m4783b(str)) {
            case 1:
                C1619g.m5888a(getContext(), R.string.ams_msg_minor_version_changed, 0).show();
                break;
            case 2:
                C1619g.m5888a(getContext(), R.string.ams_msg_major_version_changed, 0).show();
                break;
            case 3:
                C1619g.m5888a(getContext(), R.string.ams_msg_invalid_ams_file, 0).show();
                break;
            default:
                if (!m4805s()) {
                    C1619g.m5888a(getContext(), R.string.ams_msg_edit_protection, 0).show();
                    break;
                } else if (this.f4641G != null) {
                    boolean z = m4802p() > 1;
                    boolean zM4790d = m4790d();
                    boolean zM4751K = m4751K();
                    boolean zM4752L = m4752L();
                    boolean zM4753M = m4753M();
                    this.f4640F = null;
                    if (this.f4641G != null) {
                        this.f4641G.VipAMS_Close(this.f4642H);
                        this.f4641G = null;
                    }
                    this.f4643I = null;
                    if (!z && !zM4790d && !zM4751K && !zM4752L && !zM4753M) {
                        break;
                    }
                }
                break;
        }
        return false;
    }

    /* renamed from: K */
    private boolean m4751K() {
        AMS_OBJECT_DATA ams_object_data = new AMS_OBJECT_DATA();
        int iVipAMS_GetNextDrawingData = this.f4641G.VipAMS_GetNextDrawingData(this.f4642H, 0, ams_object_data);
        boolean z = false;
        while (iVipAMS_GetNextDrawingData != 0) {
            switch (ams_object_data.getM_eType()) {
                case 4:
                    z = true;
                    break;
            }
            iVipAMS_GetNextDrawingData = this.f4641G.VipAMS_GetNextDrawingData(this.f4642H, iVipAMS_GetNextDrawingData, ams_object_data);
        }
        int iVipAMS_GetErrorCode = this.f4641G.VipAMS_GetErrorCode(this.f4642H);
        if (iVipAMS_GetErrorCode != 0) {
            C1341p.m4651a(" Error Code =" + iVipAMS_GetErrorCode + ", Line : " + new Exception().getStackTrace()[0].getLineNumber(), getClass().getSimpleName());
            return false;
        }
        return z;
    }

    /* renamed from: L */
    private boolean m4752L() {
        return this.f4641G.VipAMS_GetBackgroundStyle(this.f4642H) == 2;
    }

    /* renamed from: M */
    private boolean m4753M() {
        AMS_OBJECT_DATA ams_object_data = new AMS_OBJECT_DATA();
        int iVipAMS_GetNextDrawingData = this.f4641G.VipAMS_GetNextDrawingData(this.f4642H, 0, ams_object_data);
        boolean z = false;
        while (iVipAMS_GetNextDrawingData != 0) {
            switch (ams_object_data.getM_eType()) {
                case 3:
                    if (ams_object_data.getM_cStyle() != 0) {
                        break;
                    } else {
                        if (!C1561z.m5654a().m5666c(ams_object_data.getM_cAdditionalID())) {
                            z = true;
                            break;
                        } else {
                            break;
                        }
                    }
            }
            iVipAMS_GetNextDrawingData = this.f4641G.VipAMS_GetNextDrawingData(this.f4642H, iVipAMS_GetNextDrawingData, ams_object_data);
        }
        int iVipAMS_GetErrorCode = this.f4641G.VipAMS_GetErrorCode(this.f4642H);
        if (iVipAMS_GetErrorCode != 0) {
            C1341p.m4651a(" Error Code =" + iVipAMS_GetErrorCode + ", Line : " + new Exception().getStackTrace()[0].getLineNumber(), getClass().getSimpleName());
            return false;
        }
        return z;
    }

    /* renamed from: a */
    private void m4755a(int i) {
        if (i >= 0 && i <= 11) {
            switch (i) {
                case 0:
                    m4776a(MotionEventCompat.ACTION_MASK, MotionEventCompat.ACTION_MASK, MotionEventCompat.ACTION_MASK, false);
                    break;
                case 1:
                    m4776a(MotionEventCompat.ACTION_MASK, MotionEventCompat.ACTION_MASK, MotionEventCompat.ACTION_MASK, false);
                    break;
                case 2:
                    m4776a(MotionEventCompat.ACTION_MASK, MotionEventCompat.ACTION_MASK, MotionEventCompat.ACTION_MASK, false);
                    break;
                case 3:
                    m4776a(MotionEventCompat.ACTION_MASK, 249, 187, false);
                    break;
                case 4:
                    m4776a(207, 230, 244, false);
                    break;
                case 5:
                    m4776a(243, 207, 235, false);
                    break;
                case 6:
                    m4776a(252, 244, MotionEventCompat.ACTION_MASK, false);
                    break;
                case 7:
                    m4776a(MotionEventCompat.ACTION_MASK, 253, 238, false);
                    break;
                case 8:
                    m4776a(230, 247, MotionEventCompat.ACTION_MASK, false);
                    break;
                case 9:
                    m4776a(MotionEventCompat.ACTION_MASK, 250, 208, false);
                    break;
                case 10:
                    m4776a(229, 206, 157, false);
                    break;
                case 11:
                    m4776a(8, 49, 8, false);
                    break;
            }
        }
    }

    public void setOnTouchTextArea(InterfaceC1553r interfaceC1553r) {
        this.f4687au = interfaceC1553r;
    }

    /* renamed from: e */
    private boolean m4767e(MotionEvent motionEvent) {
        String str = Build.VERSION.RELEASE;
        if (str.startsWith("2.3")) {
            if ((1024 & motionEvent.getMetaState()) != 0) {
                return true;
            }
        } else if (str.startsWith("3")) {
            if ((67108864 & motionEvent.getMetaState()) != 0) {
                return true;
            }
        } else if (str.startsWith("4") && motionEvent.getToolType(0) == 4) {
            return true;
        }
        return false;
    }

    /* renamed from: f */
    private boolean m4768f(MotionEvent motionEvent) {
        String str = Build.VERSION.RELEASE;
        if (str.startsWith("2.3")) {
            if ((512 & motionEvent.getMetaState()) != 0) {
                return true;
            }
        } else if (str.startsWith("3")) {
            if ((33554432 & motionEvent.getMetaState()) != 0) {
                return true;
            }
        } else if (str.startsWith("4") && motionEvent.getToolType(0) == 2) {
            return true;
        }
        return false;
    }

    /* renamed from: w */
    public void m4809w() throws Resources.NotFoundException {
        Rect rectM5312i;
        switch (this.f4691ay) {
            case 101:
            case 102:
                m4793g();
                if ((this.f4646L == 3 || this.f4646L == 2) && this.f4667aa && this.f4653S != null && (rectM5312i = this.f4653S.m5312i()) != null) {
                    m4762b(rectM5312i.centerX(), rectM5312i.centerY());
                    break;
                }
                break;
        }
    }

    /* renamed from: x */
    public void m4810x() throws Resources.NotFoundException {
        this.f4662aD = this.f4655U.copy(Bitmap.Config.ARGB_8888, true);
        Drawable drawable = this.f4640F.getResources().getDrawable(R.drawable.ams_ics_selector_image_crop_cancel);
        this.f4692az = new C1398c(this.f4646L, this.f4648N, this.f4650P, false, this.f4644J, this.f4645K);
        this.f4692az.m5006a(this.f4666aH);
        this.f4692az.m5302b(true);
        this.f4692az.m5290a(this.f4640F.getResources().getDrawable(R.drawable.co_emoti_selected_02));
        this.f4692az.m5301b(drawable);
        this.f4692az.m5295a(this.f4664aF);
        this.f4692az.m5285a(5);
        this.f4687au.mo5121a(true);
        this.f4692az.m5300b(this.f4656V);
        this.f4692az.mo4887a(this.f4651Q);
        this.f4692az.m5296a(true);
        this.f4692az.m5288a(this.f4654T, this.f4662aD);
        if (this.f4646L == 2) {
            String string = this.f4640F.getResources().getString(R.string.ams_msg_enter_message);
            this.f4692az.m5011a(string, this.f4648N, this.f4650P, this.f4644J / 2, this.f4645K / 2);
            RectF rectF = new RectF(this.f4692az.f4919b);
            this.f4692az.mo4971a(rectF.left, rectF.top, rectF.right, rectF.bottom, string, MotionEventCompat.ACTION_MASK);
            m4808v();
        }
    }

    /* renamed from: a */
    public void m4770a(int i, int i2) {
        if (this.f4692az != null) {
            if (i != this.f4648N) {
                i = this.f4648N;
            }
            if (i2 != this.f4650P) {
                i2 = this.f4650P;
            }
            this.f4692az.mo4886a();
            this.f4692az.mo4946a(this.f4647M, i, i2);
            m4808v();
        }
    }

    /* renamed from: y */
    public void m4811y() {
        if (this.f4692az == null) {
            m4812z();
            return;
        }
        this.f4692az.mo4886a();
        m4808v();
        this.f4692az = null;
        m4812z();
    }

    /* renamed from: z */
    public void m4812z() {
        if (this.f4662aD != null) {
            this.f4662aD.recycle();
        }
        this.f4662aD = null;
    }

    /* renamed from: A */
    public boolean m4769A() {
        return this.f4692az != null;
    }

    /* renamed from: a */
    public boolean m4773a(float f, float f2) {
        if (this.f4692az == null) {
            return false;
        }
        this.f4659aA = false;
        if (this.f4692az.mo4944a(f, f2)) {
            this.f4659aA = true;
            return this.f4692az.mo4893b(f, f2);
        }
        if (!this.f4641G.VipAMS_SelectObject(this.f4642H, (int) f, (int) f2, new AMS_SELECT_OBJECT(), this.f4646L)) {
            return true;
        }
        m4811y();
        return false;
    }

    /* renamed from: b */
    public boolean m4784b(float f, float f2) {
        if (this.f4692az == null) {
            return false;
        }
        if (this.f4659aA) {
            return this.f4692az.mo4895c(f, f2);
        }
        return true;
    }

    /* renamed from: c */
    public boolean m4787c(float f, float f2) {
        if (this.f4692az == null) {
            return false;
        }
        this.f4661aC.set(f, f2);
        if (this.f4659aA) {
            return this.f4692az.mo4896d(f, f2);
        }
        this.f4666aH.mo4928a(null, f, f2);
        return true;
    }
}
