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
import android.os.Build;
import android.support.v4.view.MotionEventCompat;
import android.util.DisplayMetrics;
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
import com.sec.chaton.util.C3223ck;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import com.sec.widget.C3641ai;
import java.io.File;

/* loaded from: classes.dex */
public class AMSDrawManager extends ZoomableImageView implements View.OnTouchListener {

    /* renamed from: a */
    public static final String f12284a;

    /* renamed from: b */
    public static final String f12285b;

    /* renamed from: c */
    public static final String f12286c;

    /* renamed from: d */
    public static final String f12287d;

    /* renamed from: e */
    public static final String f12288e;

    /* renamed from: f */
    public static final String f12289f;

    /* renamed from: I */
    private Context f12290I;

    /* renamed from: J */
    private AMSLibs f12291J;

    /* renamed from: K */
    private int f12292K;

    /* renamed from: L */
    private AMS_UI_DATA f12293L;

    /* renamed from: M */
    private int f12294M;

    /* renamed from: N */
    private int f12295N;

    /* renamed from: O */
    private int f12296O;

    /* renamed from: P */
    private int f12297P;

    /* renamed from: Q */
    private int f12298Q;

    /* renamed from: R */
    private int f12299R;

    /* renamed from: S */
    private int f12300S;

    /* renamed from: T */
    private float f12301T;

    /* renamed from: U */
    private C3588u f12302U;

    /* renamed from: V */
    private C3588u f12303V;

    /* renamed from: W */
    private Bitmap f12304W;

    /* renamed from: Z */
    private Bitmap f12305Z;

    /* renamed from: aA */
    private float f12306aA;

    /* renamed from: aB */
    private float f12307aB;

    /* renamed from: aC */
    private float f12308aC;

    /* renamed from: aD */
    private int f12309aD;

    /* renamed from: aE */
    private C3401ac f12310aE;

    /* renamed from: aF */
    private boolean f12311aF;

    /* renamed from: aG */
    private boolean f12312aG;

    /* renamed from: aH */
    private PointF f12313aH;

    /* renamed from: aI */
    private Bitmap f12314aI;

    /* renamed from: aJ */
    private boolean f12315aJ;

    /* renamed from: aK */
    private int f12316aK;

    /* renamed from: aL */
    private InterfaceC3581n f12317aL;

    /* renamed from: aM */
    private InterfaceC3589v f12318aM;

    /* renamed from: aN */
    private final int f12319aN;

    /* renamed from: aO */
    private InterfaceC3582o f12320aO;

    /* renamed from: aa */
    private Bitmap f12321aa;

    /* renamed from: ab */
    private boolean f12322ab;

    /* renamed from: ac */
    private int f12323ac;

    /* renamed from: ad */
    private boolean f12324ad;

    /* renamed from: ae */
    private AMS_SELECT_OBJECT f12325ae;

    /* renamed from: af */
    private final int f12326af;

    /* renamed from: ag */
    private final int f12327ag;

    /* renamed from: ah */
    private int f12328ah;

    /* renamed from: ai */
    private C3588u f12329ai;

    /* renamed from: aj */
    private AMS_OBJECT_DATA f12330aj;

    /* renamed from: ak */
    private int f12331ak;

    /* renamed from: al */
    private boolean f12332al;

    /* renamed from: am */
    private boolean f12333am;

    /* renamed from: an */
    private int f12334an;

    /* renamed from: ao */
    private int f12335ao;

    /* renamed from: ap */
    private boolean f12336ap;

    /* renamed from: aq */
    private int f12337aq;

    /* renamed from: ar */
    private boolean f12338ar;

    /* renamed from: as */
    private int f12339as;

    /* renamed from: at */
    private float[] f12340at;

    /* renamed from: au */
    private float[] f12341au;

    /* renamed from: av */
    private float f12342av;

    /* renamed from: aw */
    private InterfaceC3400ab f12343aw;

    /* renamed from: ax */
    private InterfaceC3583p f12344ax;

    /* renamed from: ay */
    private boolean f12345ay;

    /* renamed from: az */
    private float f12346az;

    static {
        f12284a = (C3223ck.m11327a() ? CommonApplication.m11493l().getExternalFilesDir(null).getAbsolutePath() : CommonApplication.m11493l().getFilesDir().getAbsolutePath()) + "/AMS/";
        f12285b = f12284a + "template/";
        f12286c = f12284a + "temp/";
        f12287d = f12284a + "amsbasicfiles/";
        f12288e = f12284a + "amsuserfiles/";
        f12289f = f12284a + "amssentfiles/";
    }

    public AMSDrawManager(Context context, int i, int i2) {
        super(context);
        this.f12300S = 0;
        this.f12302U = null;
        this.f12303V = null;
        this.f12304W = null;
        this.f12305Z = null;
        this.f12321aa = null;
        this.f12322ab = false;
        this.f12324ad = false;
        this.f12325ae = null;
        this.f12326af = 32;
        this.f12327ag = 2;
        this.f12328ah = 0;
        this.f12329ai = null;
        this.f12330aj = null;
        this.f12331ak = 0;
        this.f12332al = false;
        this.f12333am = false;
        this.f12334an = 0;
        this.f12335ao = 0;
        this.f12336ap = false;
        this.f12337aq = 0;
        this.f12338ar = true;
        this.f12342av = 32.0f;
        this.f12343aw = null;
        this.f12344ax = null;
        this.f12345ay = false;
        this.f12346az = 0.0f;
        this.f12306aA = 0.0f;
        this.f12307aB = 0.0f;
        this.f12308aC = 0.0f;
        this.f12309aD = 100;
        this.f12310aE = null;
        this.f12311aF = false;
        this.f12312aG = false;
        this.f12313aH = new PointF(0.0f, 0.0f);
        this.f12314aI = null;
        this.f12315aJ = true;
        this.f12317aL = null;
        this.f12318aM = new C3579l(this);
        this.f12319aN = 240;
        this.f12320aO = new C3580m(this);
        this.f12290I = context;
        this.f12296O = 1;
        this.f12297P = 0;
        this.f12301T = i / 240.0f;
        this.f12300S = 1;
        this.f12298Q = -16777216;
        this.f12299R = -1;
        this.f12294M = i;
        this.f12295N = i2;
        this.f12304W = null;
        this.f12305Z = null;
        new File(f12284a).mkdirs();
        new File(f12286c).mkdirs();
        new File(f12285b).mkdirs();
        new File(f12287d).mkdirs();
        new File(f12288e).mkdirs();
        new File(f12289f).mkdirs();
        this.f12342av = getContext().getResources().getDimensionPixelSize(R.dimen.ams_invalidate_rect_margin);
    }

    public AMSDrawManager(Context context) {
        super(context);
        this.f12300S = 0;
        this.f12302U = null;
        this.f12303V = null;
        this.f12304W = null;
        this.f12305Z = null;
        this.f12321aa = null;
        this.f12322ab = false;
        this.f12324ad = false;
        this.f12325ae = null;
        this.f12326af = 32;
        this.f12327ag = 2;
        this.f12328ah = 0;
        this.f12329ai = null;
        this.f12330aj = null;
        this.f12331ak = 0;
        this.f12332al = false;
        this.f12333am = false;
        this.f12334an = 0;
        this.f12335ao = 0;
        this.f12336ap = false;
        this.f12337aq = 0;
        this.f12338ar = true;
        this.f12342av = 32.0f;
        this.f12343aw = null;
        this.f12344ax = null;
        this.f12345ay = false;
        this.f12346az = 0.0f;
        this.f12306aA = 0.0f;
        this.f12307aB = 0.0f;
        this.f12308aC = 0.0f;
        this.f12309aD = 100;
        this.f12310aE = null;
        this.f12311aF = false;
        this.f12312aG = false;
        this.f12313aH = new PointF(0.0f, 0.0f);
        this.f12314aI = null;
        this.f12315aJ = true;
        this.f12317aL = null;
        this.f12318aM = new C3579l(this);
        this.f12319aN = 240;
        this.f12320aO = new C3580m(this);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) throws Resources.NotFoundException {
        switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
            case 0:
                this.f12337aq = 0;
                m12011a(motionEvent);
                break;
            case 1:
            case 3:
                if (this.f12337aq == 0) {
                    m12022c(motionEvent);
                }
                this.f12337aq = 0;
                break;
            case 2:
                if (this.f12337aq == 1 && this.f12338ar) {
                    return m12096d(motionEvent);
                }
                m12018b(motionEvent);
                break;
            case 5:
                if (this.f12338ar) {
                    this.f12337aq = 1;
                    if (this.f12296O == 1) {
                        m12026g();
                        if (this.f12302U != null) {
                            this.f12302U.mo12815a();
                            this.f12302U.f13059B = 0;
                        }
                    } else if (this.f12310aE == null) {
                        if (!this.f12324ad) {
                            if (this.f12302U != null) {
                                this.f12302U.mo12815a();
                                this.f12302U.f13059B = 0;
                            }
                        } else {
                            m12022c(motionEvent);
                        }
                    }
                    return m12096d(motionEvent);
                }
                break;
            case 6:
                if (this.f12338ar) {
                    return m12096d(motionEvent);
                }
                break;
        }
        if (this.f12302U == null) {
            return true;
        }
        if (this.f12303V != null || this.f12302U.m12854f() == null) {
            invalidate();
            return true;
        }
        invalidate(this.f12302U.m12854f());
        return true;
    }

    /* renamed from: d */
    private PointF m11997d(float f, float f2) {
        float fB = m12093B();
        PointF pointFD = m12095D();
        if (fB == 1.0f && pointFD.x == 0.0f && pointFD.y == 0.0f) {
            return new PointF(f, f2);
        }
        return new PointF((f - pointFD.x) / fB, (f2 - pointFD.y) / fB);
    }

    public void setBitmapForAMS(String str) {
        if (str == null) {
            setBitmap(this.f12304W);
            return;
        }
        Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(str);
        if (bitmapDecodeFile != null) {
            setBitmap(bitmapDecodeFile);
        }
    }

    public void setEnableZoom(boolean z) {
        this.f12338ar = z;
    }

    /* renamed from: a */
    public boolean m12005a() {
        try {
            if (this.f12304W != null) {
                this.f12304W.recycle();
                this.f12304W = null;
            }
            this.f12304W = Bitmap.createBitmap(this.f12294M, this.f12295N, Bitmap.Config.ARGB_8888);
            try {
                if (this.f12305Z != null) {
                    this.f12305Z.recycle();
                    this.f12305Z = null;
                }
                this.f12305Z = Bitmap.createBitmap(this.f12294M, this.f12295N, Bitmap.Config.ARGB_8888);
                setDefaultScale(0);
                setBitmap(this.f12304W);
                m12094C();
                m11979E();
                if (!m12009a(Color.red(this.f12299R), Color.green(this.f12299R), Color.blue(this.f12299R), true)) {
                    return false;
                }
                m12008a(this.f12296O, this.f12297P, this.f12298Q, this.f12300S);
                m11980F();
                return true;
            } catch (OutOfMemoryError e) {
                C3641ai.m13210a(this.f12290I, R.string.chat_view_memory_error, 0).show();
                return false;
            }
        } catch (OutOfMemoryError e2) {
            C3641ai.m13210a(this.f12290I, R.string.chat_view_memory_error, 0).show();
            return false;
        }
    }

    /* renamed from: E */
    private boolean m11979E() {
        if (this.f12291J != null) {
            this.f12291J.VipAMS_Close(this.f12292K);
            this.f12291J = null;
        }
        this.f12291J = new AMSLibs();
        this.f12291J.VipAMS_Init();
        String str = f12286c;
        this.f12291J.VipAMS_SetTempFilePath(str.getBytes(), str.getBytes().length);
        this.f12293L = new AMS_UI_DATA();
        this.f12293L.init();
        this.f12293L.setRect((short) 0, (short) 0, (short) this.f12294M, (short) this.f12295N);
        this.f12293L.m_rgbPen = this.f12298Q;
        this.f12293L.m_rgbBack = this.f12299R;
        this.f12293L.m_cObjectSize = (byte) this.f12300S;
        this.f12293L.m_eObjectType = (byte) 1;
        this.f12293L.m_cObjectStyle = (byte) 0;
        AMS_OPTION ams_option = new AMS_OPTION();
        ams_option.init();
        this.f12292K = this.f12291J.VipAMS_Open(ams_option);
        C3250y.m11453c("[AMS Library Version] " + this.f12291J.VipAMS_GetLibVersion(this.f12292K), getClass().getSimpleName());
        AMS_OBJECT_DATA ams_object_data = new AMS_OBJECT_DATA();
        ams_object_data.setM_cSize(this.f12293L.m_cObjectSize);
        ams_object_data.setM_cStyle(this.f12293L.m_cObjectStyle);
        ams_object_data.setM_nColorR(Color.red(this.f12293L.m_rgbPen));
        ams_object_data.setM_nColorG(Color.green(this.f12293L.m_rgbPen));
        ams_object_data.setM_nColorB(Color.blue(this.f12293L.m_rgbPen));
        if (this.f12291J.VipAMS_TotalNewEncoding(this.f12292K, this.f12293L.m_rectRegion, ams_object_data)) {
            return true;
        }
        C3250y.m11442a("Error Code: " + this.f12291J.VipAMS_GetErrorCode(this.f12292K), getClass().getSimpleName());
        return false;
    }

    /* renamed from: b */
    private boolean m11995b(int i, int i2, int i3, int i4) {
        if (!this.f12291J.VipAMS_SetCurObjectType(this.f12292K, (byte) i)) {
            C3250y.m11442a(" Error Code =" + this.f12291J.VipAMS_GetErrorCode(this.f12292K) + ", Line : " + new Exception().getStackTrace()[0].getLineNumber(), getClass().getSimpleName());
            return false;
        }
        if (!this.f12291J.VipAMS_SetCurObjectStyle(this.f12292K, (byte) i2)) {
            C3250y.m11442a(" Error Code =" + this.f12291J.VipAMS_GetErrorCode(this.f12292K) + ", Line : " + new Exception().getStackTrace()[0].getLineNumber(), getClass().getSimpleName());
            return false;
        }
        if (!this.f12291J.VipAMS_SetCurObjectSize(this.f12292K, (byte) i4)) {
            C3250y.m11442a(" Error Code =" + this.f12291J.VipAMS_GetErrorCode(this.f12292K) + ", Line : " + new Exception().getStackTrace()[0].getLineNumber(), getClass().getSimpleName());
            return false;
        }
        if (!this.f12291J.VipAMS_SetCurObjectColor(this.f12292K, Color.red(i3), Color.green(i3), Color.blue(i3))) {
            C3250y.m11442a(" Error Code =" + this.f12291J.VipAMS_GetErrorCode(this.f12292K) + ", Line : " + new Exception().getStackTrace()[0].getLineNumber(), getClass().getSimpleName());
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public boolean m12008a(int i, int i2, int i3, int i4) {
        this.f12293L.m_rgbBack = this.f12299R;
        if (!m11995b(i, i2, i3, i4)) {
            return false;
        }
        this.f12296O = i;
        this.f12297P = i2;
        this.f12298Q = i3;
        this.f12300S = i4;
        if (this.f12302U != null) {
            this.f12302U.mo12853e();
            this.f12302U = null;
        }
        switch (i) {
            case 1:
                this.f12302U = new C3591x(this.f12297P, this.f12298Q, this.f12300S);
                if (this.f12297P == 4) {
                    this.f12323ac = this.f12300S;
                    break;
                }
                break;
            case 2:
                C3399aa c3399aa = new C3399aa(this.f12297P, this.f12298Q, this.f12300S, true, this.f12294M, this.f12295N);
                c3399aa.m12133a(this.f12343aw);
                this.f12302U = c3399aa;
                break;
            case 3:
                this.f12302U = new C3593z(this.f12297P, this.f12298Q, this.f12300S, this.f12315aJ);
                break;
            case 4:
                this.f12302U = new C3590w(this.f12297P, this.f12298Q, this.f12300S, false);
                this.f12302U.m12850c(getContext().getResources().getDrawable(R.drawable.more_option_support_white));
                break;
        }
        if (this.f12302U == null) {
            return true;
        }
        this.f12302U.m12825a(this.f12291J, this.f12292K, this.f12293L);
        this.f12302U.m12820a(this.f12304W, this.f12305Z);
        this.f12302U.m12845b(this.f12321aa);
        this.f12302U.mo12131a(this.f12301T);
        return true;
    }

    public void setEraserSize(int i) {
        this.f12323ac = i;
    }

    /* renamed from: a */
    public boolean m12009a(int i, int i2, int i3, boolean z) {
        if (z && !this.f12291J.VipAMS_SetBackgroundColor(this.f12292K, i, i2, i3)) {
            C3250y.m11442a("VipAMS_SetBackgroundColor Error = " + this.f12291J.VipAMS_GetErrorCode(this.f12292K), getClass().getSimpleName());
            return false;
        }
        this.f12299R = Color.rgb(i, i2, i3);
        if (this.f12321aa != null) {
            this.f12321aa.recycle();
            this.f12321aa = null;
        }
        try {
            this.f12321aa = Bitmap.createBitmap(this.f12304W.getWidth(), this.f12304W.getHeight(), Bitmap.Config.ARGB_8888);
            new Canvas(this.f12321aa).drawColor(this.f12299R);
            if (this.f12302U != null) {
                this.f12302U.m12845b(this.f12321aa);
            }
            if (this.f12303V != null) {
                this.f12303V.m12845b(this.f12321aa);
            }
            return true;
        } catch (OutOfMemoryError e) {
            C3641ai.m13210a(this.f12290I, R.string.chat_view_memory_error, 0).show();
            return false;
        }
    }

    /* renamed from: a */
    public boolean m12010a(Bitmap bitmap, boolean z) {
        if (z) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int[] iArr = new int[width * height];
            bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
            if (!this.f12291J.VipAMS_SetBackgroundRawImage(this.f12292K, iArr, width, height, 24)) {
                C3250y.m11442a("VipAMS_SetBackgroundRawImage1 Error = " + this.f12291J.VipAMS_GetErrorCode(this.f12292K), getClass().getSimpleName());
                return false;
            }
        }
        if (this.f12321aa != null) {
            this.f12321aa.recycle();
            this.f12321aa = null;
        }
        this.f12321aa = Bitmap.createBitmap(this.f12304W.getWidth(), this.f12304W.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(this.f12321aa);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setFilterBitmap(true);
        canvas.drawBitmap(bitmap, new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), new Rect(0, 0, this.f12304W.getWidth(), this.f12304W.getHeight()), paint);
        if (this.f12302U != null) {
            this.f12302U.m12845b(this.f12321aa);
        }
        if (this.f12303V != null) {
            this.f12303V.m12845b(this.f12321aa);
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
        this.f12324ad = z;
        if (!this.f12324ad) {
            if (this.f12303V != null) {
                this.f12303V = null;
                this.f12325ae = null;
                m12026g();
                z3 = true;
            }
            m12008a(this.f12296O, this.f12297P, this.f12298Q, this.f12300S);
        }
        if (!z3 && z2) {
            m12026g();
        }
    }

    public void setAMSLib(AMSLibs aMSLibs, int i, AMS_UI_DATA ams_ui_data) {
        this.f12291J = aMSLibs;
        this.f12292K = i;
        this.f12293L = ams_ui_data;
    }

    public void setOnObjectListener(InterfaceC3581n interfaceC3581n) {
        this.f12317aL = interfaceC3581n;
    }

    public void setOnTextInputRequestListener(InterfaceC3400ab interfaceC3400ab) {
        this.f12343aw = interfaceC3400ab;
    }

    /* renamed from: b */
    public int m12016b() {
        return this.f12299R;
    }

    /* renamed from: c */
    public int m12020c() {
        return this.f12291J.VipAMS_GetBGAudioStyle(this.f12292K);
    }

    /* renamed from: d */
    public boolean m12023d() {
        switch (m12020c()) {
            case 1:
            case 2:
            case 3:
                return true;
            default:
                return false;
        }
    }

    /* renamed from: e */
    public C3588u m12024e() {
        return this.f12303V;
    }

    /* renamed from: a */
    public boolean m12007a(int i, int i2, int i3) {
        if (!this.f12324ad || this.f12303V == null) {
            return false;
        }
        this.f12297P = i;
        this.f12298Q = i2;
        this.f12300S = i3;
        m11995b(this.f12296O, this.f12297P, i2, i3);
        return this.f12303V.mo12137a(this.f12297P, i2, i3);
    }

    /* renamed from: a */
    public boolean m12011a(MotionEvent motionEvent) {
        float f;
        PointF pointF = new PointF();
        pointF.set(m11997d(motionEvent.getX(), motionEvent.getY()));
        float f2 = pointF.x;
        float f3 = pointF.y;
        this.f12309aD = 101;
        if (this.f12296O == 1) {
            this.f12345ay = false;
            if (f2 < 0.0f || f3 < 0.0f || f2 > this.f12294M || f3 > this.f12295N) {
                this.f12345ay = true;
                return true;
            }
            f = f2;
        } else {
            if (f2 < 0.0f) {
                f2 = 0.0f;
            }
            float f4 = f3 >= 0.0f ? f3 : 0.0f;
            float f5 = f2 > ((float) this.f12294M) ? this.f12294M - 1 : f2;
            if (f4 > this.f12295N) {
                f = f5;
                f3 = this.f12295N - 1;
            } else {
                float f6 = f4;
                f = f5;
                f3 = f6;
            }
        }
        return m11989a(f, f3, motionEvent);
    }

    /* renamed from: b */
    public boolean m12018b(MotionEvent motionEvent) throws Resources.NotFoundException {
        float f;
        float f2;
        PointF pointF = new PointF();
        pointF.set(m11997d(motionEvent.getX(), motionEvent.getY()));
        float f3 = pointF.x;
        float f4 = pointF.y;
        this.f12309aD = 102;
        this.f12307aB = f3;
        this.f12308aC = f4;
        if (this.f12296O != 1) {
            if (f3 < 0.0f) {
                f3 = 0.0f;
            }
            f = f4 >= 0.0f ? f4 : 0.0f;
            f2 = f3 > ((float) this.f12294M) ? this.f12294M - 1 : f3;
            if (f > this.f12295N) {
                f = this.f12295N - 1;
            }
        } else {
            if (f3 < 0.0f || f4 < 0.0f || f3 > this.f12294M || f4 > this.f12295N) {
                this.f12346az = f3;
                this.f12306aA = f4;
                if (this.f12345ay) {
                    return true;
                }
                this.f12345ay = true;
                if (f3 < 0.0f) {
                    f3 = 0.0f;
                }
                f = f4 >= 0.0f ? f4 : 0.0f;
                float f5 = f3 > ((float) this.f12294M) ? this.f12294M - 1 : f3;
                if (f > this.f12295N) {
                    f = this.f12295N - 1;
                }
                m11993b(f5, f, motionEvent);
                return m11990a(f5, f, false);
            }
            if (this.f12345ay) {
                this.f12345ay = false;
                float f6 = this.f12346az;
                float f7 = this.f12306aA;
                if (f6 < 0.0f) {
                    f6 = 0.0f;
                }
                f = f7 >= 0.0f ? f7 : 0.0f;
                f2 = f6 > ((float) this.f12294M) ? this.f12294M - 1 : f6;
                if (f > this.f12295N) {
                    f = this.f12295N - 1;
                }
                m11989a(f2, f, motionEvent);
            } else {
                f = f4;
                f2 = f3;
            }
        }
        return m11993b(f2, f, motionEvent);
    }

    /* renamed from: c */
    public boolean m12022c(MotionEvent motionEvent) {
        PointF pointF = new PointF();
        pointF.set(m11997d(motionEvent.getX(), motionEvent.getY()));
        float f = pointF.x;
        float f2 = pointF.y;
        this.f12309aD = 103;
        if ((motionEvent.getAction() & MotionEventCompat.ACTION_MASK) == 3) {
            f = this.f12307aB;
            f2 = this.f12308aC;
        }
        if (this.f12296O != 1) {
            if (f < 0.0f) {
                f = 0.0f;
            }
            if (f2 < 0.0f) {
                f2 = 0.0f;
            }
            if (f > this.f12294M) {
                f = this.f12294M - 1;
            }
            if (f2 > this.f12295N) {
                f2 = this.f12295N - 1;
            }
        } else if (f < 0.0f || f2 < 0.0f || f > this.f12294M || f2 > this.f12295N) {
            return true;
        }
        return m11990a(f, f2, true);
    }

    /* renamed from: a */
    private boolean m11989a(float f, float f2, MotionEvent motionEvent) throws Resources.NotFoundException {
        int m_cStyle;
        if (m12006a(f, f2)) {
            return true;
        }
        if (m11999e(motionEvent)) {
            this.f12322ab = true;
            setEditMode(false, false);
            m11995b(1, 4, this.f12298Q, this.f12323ac);
            this.f12302U = new C3591x(4, this.f12298Q, this.f12323ac);
            this.f12302U.m12825a(this.f12291J, this.f12292K, this.f12293L);
            this.f12302U.m12820a(this.f12304W, this.f12305Z);
            this.f12302U.m12845b(this.f12321aa);
            this.f12302U.mo12131a(this.f12301T);
            return this.f12302U.mo12147d(f, f2);
        }
        if (this.f12303V != null && this.f12303V.mo12146c(f, f2)) {
            return this.f12303V.mo12147d(f, f2);
        }
        AMS_SELECT_OBJECT ams_select_object = new AMS_SELECT_OBJECT();
        if (!this.f12291J.VipAMS_SelectObject(this.f12292K, (int) f, (int) f2, ams_select_object, this.f12296O)) {
            if (this.f12316aK > 148) {
                C3641ai.m13210a(this.f12290I, R.string.ams_msg_edit_protection, 0).show();
                return false;
            }
            this.f12316aK++;
            if (this.f12296O == 3 && this.f12297P == -1) {
                return false;
            }
            this.f12302U.m12820a(this.f12304W, this.f12305Z);
            boolean z = this.f12324ad;
            setEditMode(false, false);
            if (z) {
                this.f12302U.m12847b(false);
            }
            if (this.f12317aL != null) {
                this.f12317aL.mo12519a(2, 0, 0, 0, 0);
            }
            if (this.f12296O == 1 && this.f12297P == 0 && m12000f(motionEvent)) {
                C3588u c3588u = this.f12302U;
                float pressure = motionEvent.getPressure();
                this.f12302U.getClass();
                c3588u.m12841b(pressure * 4096.0f);
            } else {
                this.f12302U.m12841b(-1.0f);
            }
            if (this.f12296O == 2) {
                this.f12344ax.mo12518a(false);
            }
            return this.f12302U.mo12147d(f, f2);
        }
        setEditMode(true, false);
        this.f12325ae = ams_select_object;
        AMS_OBJECT_DATA ams_object_data = new AMS_OBJECT_DATA();
        this.f12291J.VipAMS_GetSelectObjectData(this.f12325ae.getM_pSelectObjectData(), ams_object_data);
        int m_eType = ams_object_data.getM_eType();
        if (m_eType == 3) {
            m_cStyle = ams_object_data.getM_cAdditionalID();
        } else {
            m_cStyle = ams_object_data.getM_cStyle();
        }
        byte m_cSize = ams_object_data.getM_cSize();
        int iRgb = Color.rgb(ams_object_data.getM_nColorR(), ams_object_data.getM_nColorG(), ams_object_data.getM_nColorB());
        if (!m11995b(m_eType, m_cStyle, iRgb, m_cSize)) {
            return false;
        }
        if (this.f12317aL != null) {
            if (ams_object_data.getM_eType() == 3 && ams_object_data.getM_cStyle() == 2) {
                this.f12317aL.mo12519a(1, 3, -1, this.f12298Q, this.f12300S);
            } else {
                this.f12317aL.mo12519a(1, m_eType, m_cStyle, iRgb, m_cSize);
            }
        }
        m12012a(this.f12325ae);
        Drawable drawable = this.f12290I.getResources().getDrawable(R.drawable.ams_ics_selector_image_crop_cancel);
        Drawable drawable2 = this.f12290I.getResources().getDrawable(R.drawable.ams_ics_selector_image_crop_01);
        Drawable drawable3 = this.f12290I.getResources().getDrawable(R.drawable.ams_ics_selector_image_crop_01);
        Drawable drawable4 = this.f12290I.getResources().getDrawable(R.drawable.ams_ics_selector_image_crop_02);
        Drawable drawable5 = this.f12290I.getResources().getDrawable(R.drawable.ams_ics_selector_image_crop_w);
        Drawable drawable6 = this.f12290I.getResources().getDrawable(R.drawable.ams_ics_selector_image_crop_h);
        Drawable drawable7 = this.f12290I.getResources().getDrawable(R.drawable.ams_ics_selector_image_crop_w);
        Drawable drawable8 = this.f12290I.getResources().getDrawable(R.drawable.ams_ics_selector_image_crop_h);
        if (this.f12303V != null) {
            this.f12303V.mo12853e();
            this.f12303V = null;
        }
        switch (this.f12296O) {
            case 2:
                C3399aa c3399aa = new C3399aa(m_cStyle, iRgb, m_cSize, true, this.f12294M, this.f12295N);
                c3399aa.m12133a(this.f12343aw);
                c3399aa.m12847b(false);
                this.f12303V = c3399aa;
                this.f12303V.m12822a(this.f12290I.getResources().getDrawable(R.drawable.gridview_selector_selected));
                this.f12303V.m12824a(drawable5, drawable6, drawable7, drawable8);
                this.f12303V.m12846b(drawable);
                this.f12303V.m12827a(this.f12318aM);
                this.f12303V.m12817a(5);
                this.f12344ax.mo12518a(true);
                break;
            case 3:
                if (ams_object_data.getM_cStyle() == 0) {
                    this.f12303V = new C3593z(m_cStyle, iRgb, m_cSize, ams_object_data.getM_nRotation(), this.f12315aJ);
                } else {
                    this.f12303V = new C3593z(-1, this.f12298Q, this.f12300S, ams_object_data.getM_nRotation(), Bitmap.createBitmap(this.f12291J.VipAMS_GetObjectImageBuf(this.f12292K, ams_object_data), AMSLibs.g_nCurObjectImageWidth, AMSLibs.g_nCurObjectImageHeight, Bitmap.Config.ARGB_8888), this.f12315aJ);
                }
                this.f12303V.m12822a(this.f12290I.getResources().getDrawable(R.drawable.gridview_selector_selected));
                if (this.f12315aJ) {
                    this.f12303V.m12824a(drawable5, drawable6, drawable7, drawable8);
                }
                this.f12303V.m12846b(drawable);
                this.f12303V.m12827a(this.f12318aM);
                this.f12303V.m12817a(5);
                break;
            case 4:
                this.f12303V = new C3590w(m_cStyle, iRgb, m_cSize, false);
                Drawable drawable9 = this.f12290I.getResources().getDrawable(R.drawable.gridview_selector_selected);
                this.f12303V.m12850c(getContext().getResources().getDrawable(R.drawable.more_option_support_white));
                this.f12303V.m12822a(drawable9);
                this.f12303V.m12823a(drawable2, drawable3, drawable4);
                this.f12303V.m12846b(drawable);
                this.f12303V.m12827a(this.f12318aM);
                this.f12303V.m12817a(5);
                break;
            default:
                this.f12303V = new C3593z(0, iRgb, m_cSize, true);
                this.f12303V.m12822a(this.f12290I.getResources().getDrawable(R.drawable.co_list_bg));
                this.f12303V.m12823a(drawable2, drawable3, drawable4);
                this.f12303V.m12846b(drawable);
                this.f12303V.m12827a(this.f12318aM);
                this.f12303V.m12817a(5);
                break;
        }
        this.f12303V.m12825a(this.f12291J, this.f12292K, this.f12293L);
        this.f12303V.m12826a(this.f12325ae);
        this.f12303V.m12845b(this.f12321aa);
        this.f12303V.mo12131a(this.f12301T);
        this.f12303V.m12828a(true);
        this.f12303V.m12820a(this.f12304W, this.f12305Z);
        return this.f12303V.mo12147d(f, f2);
    }

    /* renamed from: b */
    private boolean m11993b(float f, float f2, MotionEvent motionEvent) {
        if (m12017b(f, f2)) {
            return true;
        }
        if (!this.f12324ad) {
            if (this.f12296O == 1 && this.f12297P == 0 && m12000f(motionEvent)) {
                C3588u c3588u = this.f12302U;
                float pressure = motionEvent.getPressure();
                this.f12302U.getClass();
                c3588u.m12841b(pressure * 4096.0f);
            } else {
                this.f12302U.m12841b(-1.0f);
            }
            return this.f12302U.mo12148e(f, f2);
        }
        if (this.f12303V == null) {
            return false;
        }
        if (this.f12317aL != null) {
            getLocationOnScreen(new int[2]);
            this.f12317aL.mo12519a(3, (int) (r5[0] + f), (int) (r5[1] + f2), 0, 0);
        }
        return this.f12303V.mo12148e(f, f2);
    }

    /* renamed from: a */
    private boolean m11990a(float f, float f2, boolean z) {
        if (m12021c(f, f2)) {
            return true;
        }
        if (!this.f12324ad) {
            this.f12302U.mo12851c(z);
            boolean zMo12149f = this.f12302U.mo12149f(f, f2);
            if (this.f12317aL != null) {
                this.f12317aL.mo12519a(0, 0, 0, 0, 0);
            }
            if (this.f12322ab) {
                this.f12322ab = false;
                m12008a(this.f12296O, this.f12297P, this.f12298Q, this.f12300S);
            }
            return zMo12149f;
        }
        if (this.f12303V == null) {
            return false;
        }
        if (this.f12317aL != null) {
            getLocationOnScreen(new int[2]);
            this.f12317aL.mo12519a(4, (int) (r5[0] + f), (int) (r5[1] + f2), 0, 0);
        }
        this.f12303V.mo12851c(z);
        return this.f12303V.mo12149f(f, f2);
    }

    /* renamed from: f */
    public Bitmap m12025f() {
        return this.f12304W;
    }

    /* renamed from: F */
    private boolean m11980F() {
        Canvas canvas = new Canvas(this.f12304W);
        if (this.f12321aa != null) {
            canvas.drawBitmap(this.f12321aa, new Rect(0, 0, this.f12321aa.getWidth(), this.f12321aa.getHeight()), new Rect(0, 0, this.f12304W.getWidth(), this.f12304W.getHeight()), (Paint) null);
            return true;
        }
        canvas.drawColor(this.f12299R);
        return true;
    }

    /* renamed from: G */
    private boolean m11981G() {
        switch (this.f12291J.VipAMS_GetBackgroundStyle(this.f12292K)) {
            case 0:
                int iVipAMS_GetBackgroundColorR = this.f12291J.VipAMS_GetBackgroundColorR(this.f12292K);
                int iVipAMS_GetBackgroundColorG = this.f12291J.VipAMS_GetBackgroundColorG(this.f12292K);
                int iVipAMS_GetBackgroundColorB = this.f12291J.VipAMS_GetBackgroundColorB(this.f12292K);
                this.f12299R = Color.rgb(iVipAMS_GetBackgroundColorR, iVipAMS_GetBackgroundColorG, iVipAMS_GetBackgroundColorB);
                m12009a(iVipAMS_GetBackgroundColorR, iVipAMS_GetBackgroundColorG, iVipAMS_GetBackgroundColorB, false);
                break;
            case 2:
                m11987a(this.f12291J.VipAMS_GetBackgroundIndex(this.f12292K));
                break;
            case 4:
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(this.f12291J.VipAMS_GetCurrentBackgroundBuf(this.f12292K), AMSLibs.g_nCurrentBackgroundWidth, AMSLibs.g_nCurrentBackgroundHeight, Bitmap.Config.ARGB_8888);
                m12010a(bitmapCreateBitmap, false);
                bitmapCreateBitmap.recycle();
                break;
        }
        return true;
    }

    /* renamed from: g */
    public boolean m12026g() {
        return m12012a((AMS_SELECT_OBJECT) null);
    }

    /* renamed from: a */
    public boolean m12012a(AMS_SELECT_OBJECT ams_select_object) {
        float m_pnAMSPointPressure;
        m11981G();
        m11980F();
        AMS_OBJECT_DATA ams_object_data = new AMS_OBJECT_DATA();
        int iVipAMS_GetNextDrawingData = this.f12291J.VipAMS_GetNextDrawingData(this.f12292K, 0, ams_object_data);
        this.f12316aK = 0;
        int iVipAMS_GetNextDrawingData2 = iVipAMS_GetNextDrawingData;
        C3588u c3399aa = null;
        while (iVipAMS_GetNextDrawingData2 != 0) {
            this.f12316aK++;
            if (ams_select_object != null && iVipAMS_GetNextDrawingData2 == ams_select_object.getM_pSelectObjectNode()) {
                iVipAMS_GetNextDrawingData2 = this.f12291J.VipAMS_GetNextDrawingData(this.f12292K, iVipAMS_GetNextDrawingData2, ams_object_data);
            } else {
                switch (ams_object_data.getM_eType()) {
                    case 1:
                        c3399aa = new C3591x(ams_object_data.getM_cStyle(), Color.rgb(ams_object_data.getM_nColorR(), ams_object_data.getM_nColorG(), ams_object_data.getM_nColorB()), ams_object_data.getM_cSize());
                        if (ams_object_data.getM_cStyle() != 4) {
                            c3399aa.m12819a(this.f12304W);
                        } else {
                            c3399aa.m12820a(this.f12304W, this.f12305Z);
                        }
                        c3399aa.m12845b(this.f12321aa);
                        c3399aa.mo12131a(this.f12301T);
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
                                c3399aa.mo12132a(m_pnAMSPointX, m_pnAMSPointY);
                            } else if (i < ams_object_data.getM_TPoint().getM_nPointNum() - 1) {
                                c3399aa.mo12834a(m_pnAMSPointX, m_pnAMSPointY, 0, m_pnAMSPointPressure, false);
                            }
                            if (i == ams_object_data.getM_TPoint().getM_nPointNum() - 1) {
                                c3399aa.mo12842b(m_pnAMSPointX, m_pnAMSPointY);
                            }
                        }
                        break;
                    case 2:
                        c3399aa = new C3399aa(ams_object_data.getM_cStyle(), Color.rgb(ams_object_data.getM_nColorR(), ams_object_data.getM_nColorG(), ams_object_data.getM_nColorB()), ams_object_data.getM_cSize(), true, this.f12294M, this.f12295N);
                        AMS_RECT m_TRect = ams_object_data.getM_TRect();
                        c3399aa.m12819a(this.f12304W);
                        c3399aa.m12845b(this.f12321aa);
                        c3399aa.mo12131a(this.f12301T);
                        c3399aa.mo12135a(m_TRect.nLeft, m_TRect.nTop, m_TRect.nRight, m_TRect.nBottom, ams_object_data.getM_TText().getM_strText(), MotionEventCompat.ACTION_MASK, false);
                        break;
                    case 3:
                        if (ams_object_data.getM_cStyle() == 0) {
                            c3399aa = new C3593z(ams_object_data.getM_cAdditionalID(), Color.rgb(ams_object_data.getM_nColorR(), ams_object_data.getM_nColorG(), ams_object_data.getM_nColorB()), ams_object_data.getM_cSize(), ams_object_data.getM_nRotation(), this.f12315aJ);
                        } else if (ams_object_data.getM_cStyle() == 2) {
                            c3399aa = new C3593z(-1, Color.rgb(ams_object_data.getM_nColorR(), ams_object_data.getM_nColorG(), ams_object_data.getM_nColorB()), ams_object_data.getM_cSize(), ams_object_data.getM_nRotation(), Bitmap.createBitmap(this.f12291J.VipAMS_GetObjectImageBuf(this.f12292K, ams_object_data), AMSLibs.g_nCurObjectImageWidth, AMSLibs.g_nCurObjectImageHeight, Bitmap.Config.ARGB_8888), this.f12315aJ);
                        } else {
                            c3399aa = new C3593z(0, Color.rgb(ams_object_data.getM_nColorR(), ams_object_data.getM_nColorG(), ams_object_data.getM_nColorB()), ams_object_data.getM_cSize(), ams_object_data.getM_nRotation(), this.f12315aJ);
                        }
                        AMS_RECT m_TRect2 = ams_object_data.getM_TRect();
                        c3399aa.m12819a(this.f12304W);
                        c3399aa.m12845b(this.f12321aa);
                        c3399aa.mo12131a(this.f12301T);
                        c3399aa.mo12837a(new RectF(m_TRect2.nLeft, m_TRect2.nTop, m_TRect2.nRight, m_TRect2.nBottom), MotionEventCompat.ACTION_MASK, false);
                        break;
                    case 4:
                        c3399aa = new C3590w(ams_object_data.getM_cStyle(), Color.rgb(ams_object_data.getM_nColorR(), ams_object_data.getM_nColorG(), ams_object_data.getM_nColorB()), ams_object_data.getM_cSize(), false);
                        AMS_RECT m_TRect3 = ams_object_data.getM_TRect();
                        c3399aa.m12850c(getContext().getResources().getDrawable(R.drawable.more_option_support_white));
                        c3399aa.m12819a(this.f12304W);
                        c3399aa.m12845b(this.f12321aa);
                        c3399aa.mo12131a(this.f12301T);
                        c3399aa.mo12831a(m_TRect3.nLeft, m_TRect3.nTop, m_TRect3.nRight, m_TRect3.nBottom, MotionEventCompat.ACTION_MASK, false);
                        break;
                }
                iVipAMS_GetNextDrawingData2 = this.f12291J.VipAMS_GetNextDrawingData(this.f12292K, iVipAMS_GetNextDrawingData2, ams_object_data);
            }
        }
        if (c3399aa != null) {
            c3399aa.mo12853e();
        }
        int iVipAMS_GetErrorCode = this.f12291J.VipAMS_GetErrorCode(this.f12292K);
        if (iVipAMS_GetErrorCode == 0) {
            return true;
        }
        C3250y.m11442a(" Error Code =" + iVipAMS_GetErrorCode + ", Line : " + new Exception().getStackTrace()[0].getLineNumber(), getClass().getSimpleName());
        return false;
    }

    /* renamed from: a */
    public boolean m12013a(String str, int i, int i2) throws Resources.NotFoundException {
        int i3;
        int i4;
        if (this.f12296O != 2) {
            return false;
        }
        this.f12298Q = i;
        this.f12300S = i2;
        if (this.f12324ad) {
            C3399aa c3399aa = (C3399aa) this.f12303V;
            c3399aa.mo12137a(this.f12297P, this.f12298Q, this.f12300S);
            c3399aa.m12139a(str);
        } else {
            C3399aa c3399aa2 = (C3399aa) this.f12302U;
            m11995b(this.f12296O, this.f12297P, this.f12298Q, this.f12300S);
            int i5 = this.f12294M / 2;
            int i6 = this.f12295N / 2;
            if (this.f12312aG) {
                this.f12312aG = false;
                m12044y();
                int i7 = (int) this.f12313aH.x;
                int i8 = (int) this.f12313aH.y;
                c3399aa2.m12142a(str, this.f12298Q, this.f12300S, i7, i8);
                i4 = i8;
                i3 = i7;
            } else {
                c3399aa2.m12141a(str, this.f12298Q, this.f12300S);
                int[] iArr = new int[2];
                c3399aa2.m12143a(iArr);
                i3 = iArr[0];
                i4 = iArr[1];
            }
            m11994b(i3, i4);
        }
        if (this.f12317aL != null) {
            this.f12317aL.mo12519a(0, 0, 0, 0, 0);
        }
        m12041v();
        return true;
    }

    /* renamed from: b */
    private boolean m11994b(int i, int i2) throws Resources.NotFoundException {
        int m_cStyle;
        AMS_SELECT_OBJECT ams_select_object = new AMS_SELECT_OBJECT();
        if (!this.f12291J.VipAMS_SelectObject(this.f12292K, i, i2, ams_select_object, this.f12296O)) {
            return false;
        }
        setEditMode(true, false);
        this.f12325ae = ams_select_object;
        AMS_OBJECT_DATA ams_object_data = new AMS_OBJECT_DATA();
        this.f12291J.VipAMS_GetSelectObjectData(this.f12325ae.getM_pSelectObjectData(), ams_object_data);
        int m_eType = ams_object_data.getM_eType();
        if (m_eType == 3) {
            m_cStyle = ams_object_data.getM_cAdditionalID();
        } else {
            m_cStyle = ams_object_data.getM_cStyle();
        }
        byte m_cSize = ams_object_data.getM_cSize();
        int iRgb = Color.rgb(ams_object_data.getM_nColorR(), ams_object_data.getM_nColorG(), ams_object_data.getM_nColorB());
        if (!m11995b(m_eType, m_cStyle, iRgb, m_cSize)) {
            return false;
        }
        if (this.f12317aL != null) {
            if (ams_object_data.getM_eType() == 3 && ams_object_data.getM_cStyle() == 2) {
                this.f12317aL.mo12519a(1, 3, -1, this.f12298Q, this.f12300S);
            } else {
                this.f12317aL.mo12519a(1, m_eType, m_cStyle, iRgb, m_cSize);
            }
        }
        m12012a(this.f12325ae);
        Drawable drawable = this.f12290I.getResources().getDrawable(R.drawable.ams_ics_selector_image_crop_cancel);
        this.f12290I.getResources().getDrawable(R.drawable.ams_ics_selector_image_crop_01);
        this.f12290I.getResources().getDrawable(R.drawable.ams_ics_selector_image_crop_01);
        this.f12290I.getResources().getDrawable(R.drawable.ams_ics_selector_image_crop_02);
        Drawable drawable2 = this.f12290I.getResources().getDrawable(R.drawable.ams_ics_selector_image_crop_w);
        Drawable drawable3 = this.f12290I.getResources().getDrawable(R.drawable.ams_ics_selector_image_crop_h);
        Drawable drawable4 = this.f12290I.getResources().getDrawable(R.drawable.ams_ics_selector_image_crop_w);
        Drawable drawable5 = this.f12290I.getResources().getDrawable(R.drawable.ams_ics_selector_image_crop_h);
        if (this.f12303V != null) {
            this.f12303V.mo12853e();
            this.f12303V = null;
        }
        switch (this.f12296O) {
            case 2:
                C3399aa c3399aa = new C3399aa(m_cStyle, iRgb, m_cSize, true, this.f12294M, this.f12295N);
                c3399aa.m12133a(this.f12343aw);
                c3399aa.m12847b(true);
                this.f12303V = c3399aa;
                this.f12303V.m12822a(this.f12290I.getResources().getDrawable(R.drawable.gridview_selector_selected));
                this.f12303V.m12824a(drawable2, drawable3, drawable4, drawable5);
                this.f12303V.m12846b(drawable);
                this.f12303V.m12827a(this.f12318aM);
                this.f12303V.m12817a(5);
                break;
            case 3:
                if (ams_object_data.getM_cStyle() == 0) {
                    this.f12303V = new C3593z(m_cStyle, iRgb, m_cSize, ams_object_data.getM_nRotation(), this.f12315aJ);
                } else {
                    this.f12303V = new C3593z(-1, this.f12298Q, this.f12300S, ams_object_data.getM_nRotation(), Bitmap.createBitmap(this.f12291J.VipAMS_GetObjectImageBuf(this.f12292K, ams_object_data), AMSLibs.g_nCurObjectImageWidth, AMSLibs.g_nCurObjectImageHeight, Bitmap.Config.ARGB_8888), this.f12315aJ);
                }
                this.f12303V.m12847b(true);
                this.f12303V.m12822a(this.f12290I.getResources().getDrawable(R.drawable.gridview_selector_selected));
                if (this.f12315aJ) {
                    this.f12303V.m12824a(drawable2, drawable3, drawable4, drawable5);
                }
                this.f12303V.m12846b(drawable);
                this.f12303V.m12827a(this.f12318aM);
                this.f12303V.m12817a(5);
                ((C3593z) this.f12303V).m12863d(true);
                break;
        }
        this.f12303V.m12825a(this.f12291J, this.f12292K, this.f12293L);
        this.f12303V.m12826a(this.f12325ae);
        this.f12303V.m12845b(this.f12321aa);
        this.f12303V.mo12131a(this.f12301T);
        this.f12303V.m12828a(true);
        this.f12303V.m12820a(this.f12304W, this.f12305Z);
        AMS_OBJECT_DATA ams_object_data2 = new AMS_OBJECT_DATA();
        this.f12291J.VipAMS_GetSelectObjectData(this.f12325ae.getM_pSelectObjectData(), ams_object_data2);
        if (this.f12296O == 3) {
            return this.f12303V.mo12836a(new RectF(ams_object_data2.getM_TRect().nLeft, ams_object_data2.getM_TRect().nTop, ams_object_data2.getM_TRect().nRight, ams_object_data2.getM_TRect().nBottom), MotionEventCompat.ACTION_MASK);
        }
        return this.f12303V.mo12134a(ams_object_data2.getM_TRect().nLeft, ams_object_data2.getM_TRect().nTop, ams_object_data2.getM_TRect().nRight, ams_object_data2.getM_TRect().nBottom, new String(ams_object_data2.getM_TText().getM_cText()), MotionEventCompat.ACTION_MASK);
    }

    /* renamed from: h */
    public boolean m12027h() {
        this.f12291J.VipAMS_SetCurrentFrame(this.f12292K, (byte) 0);
        m11981G();
        m11980F();
        this.f12330aj = new AMS_OBJECT_DATA();
        this.f12328ah = 0;
        this.f12332al = false;
        this.f12331ak = 0;
        this.f12333am = false;
        this.f12335ao = 0;
        return true;
    }

    /* renamed from: i */
    public boolean m12028i() {
        float m_pnAMSPointPressure;
        if (this.f12333am) {
            return true;
        }
        if (!this.f12332al) {
            this.f12331ak = 0;
            this.f12328ah = this.f12291J.VipAMS_GetNextDrawingData(this.f12292K, this.f12328ah, this.f12330aj);
            while (this.f12328ah == 0) {
                if (!this.f12291J.VipAMS_SetNextFrame(this.f12292K)) {
                    return false;
                }
                m11980F();
                m12004a(false);
                this.f12328ah = this.f12291J.VipAMS_GetNextDrawingData(this.f12292K, this.f12328ah, this.f12330aj);
            }
            this.f12332al = true;
        }
        this.f12333am = true;
        if (this.f12331ak == 0 && this.f12329ai != null) {
            this.f12329ai.mo12853e();
            this.f12329ai = null;
        }
        switch (this.f12330aj.getM_eType()) {
            case 1:
                if (this.f12331ak == 0) {
                    this.f12329ai = new C3591x(this.f12330aj.getM_cStyle(), Color.rgb(this.f12330aj.getM_nColorR(), this.f12330aj.getM_nColorG(), this.f12330aj.getM_nColorB()), this.f12330aj.getM_cSize());
                    this.f12329ai.m12820a(this.f12304W, this.f12305Z);
                    this.f12329ai.m12845b(this.f12321aa);
                    this.f12329ai.mo12131a(this.f12301T);
                }
                float m_pnAMSPointX = this.f12330aj.getM_TPoint().getM_pnAMSPointX(this.f12331ak);
                float m_pnAMSPointY = this.f12330aj.getM_TPoint().getM_pnAMSPointY(this.f12331ak);
                if (this.f12330aj.getM_TPoint().getM_bPressureFlag()) {
                    m_pnAMSPointPressure = this.f12330aj.getM_TPoint().getM_pnAMSPointPressure(this.f12331ak);
                } else {
                    m_pnAMSPointPressure = -1.0f;
                }
                if (this.f12331ak == 0) {
                    this.f12329ai.mo12132a(m_pnAMSPointX, m_pnAMSPointY);
                    m11984J();
                } else if (this.f12331ak < this.f12330aj.getM_TPoint().getM_nPointNum()) {
                    this.f12329ai.mo12833a(m_pnAMSPointX, m_pnAMSPointY, MotionEventCompat.ACTION_MASK, m_pnAMSPointPressure);
                }
                if (this.f12331ak == this.f12330aj.getM_TPoint().getM_nPointNum() - 1) {
                    this.f12329ai.mo12842b(m_pnAMSPointX, m_pnAMSPointY);
                    this.f12332al = false;
                }
                this.f12331ak++;
                this.f12335ao++;
                m11988a(m11998e(m_pnAMSPointX, m_pnAMSPointY));
                break;
            case 2:
                if (this.f12331ak == 0) {
                    this.f12329ai = new C3399aa(this.f12330aj.getM_cStyle(), Color.rgb(this.f12330aj.getM_nColorR(), this.f12330aj.getM_nColorG(), this.f12330aj.getM_nColorB()), this.f12330aj.getM_cSize(), true, this.f12294M, this.f12295N);
                    this.f12329ai.m12820a(this.f12304W, this.f12305Z);
                    this.f12329ai.m12845b(this.f12321aa);
                    this.f12329ai.mo12131a(this.f12301T);
                }
                AMS_RECT m_TRect = this.f12330aj.getM_TRect();
                this.f12331ak++;
                this.f12335ao++;
                if (this.f12331ak < 32) {
                    this.f12329ai.mo12134a(m_TRect.nLeft, m_TRect.nTop, m_TRect.nRight, m_TRect.nBottom, this.f12330aj.getM_TText().getM_strText(), (int) ((this.f12331ak / 2) * (this.f12331ak / 2)));
                } else {
                    this.f12329ai.mo12134a(m_TRect.nLeft, m_TRect.nTop, m_TRect.nRight, m_TRect.nBottom, this.f12330aj.getM_TText().getM_strText(), MotionEventCompat.ACTION_MASK);
                    this.f12332al = false;
                }
                m11988a(m_TRect);
                break;
            case 3:
                int m_cAdditionalID = this.f12330aj.getM_cAdditionalID();
                if (this.f12331ak == 0) {
                    if (this.f12330aj.getM_cStyle() == 0) {
                        this.f12329ai = new C3593z(m_cAdditionalID, Color.rgb(this.f12330aj.getM_nColorR(), this.f12330aj.getM_nColorG(), this.f12330aj.getM_nColorB()), this.f12330aj.getM_cSize(), this.f12330aj.getM_nRotation(), this.f12315aJ);
                    } else if (this.f12330aj.getM_cStyle() == 2) {
                        this.f12329ai = new C3593z(-1, Color.rgb(this.f12330aj.getM_nColorR(), this.f12330aj.getM_nColorG(), this.f12330aj.getM_nColorB()), this.f12330aj.getM_cSize(), this.f12330aj.getM_nRotation(), Bitmap.createBitmap(this.f12291J.VipAMS_GetObjectImageBuf(this.f12292K, this.f12330aj), AMSLibs.g_nCurObjectImageWidth, AMSLibs.g_nCurObjectImageHeight, Bitmap.Config.ARGB_8888), this.f12315aJ);
                    } else {
                        this.f12329ai = new C3593z(0, Color.rgb(this.f12330aj.getM_nColorR(), this.f12330aj.getM_nColorG(), this.f12330aj.getM_nColorB()), this.f12330aj.getM_cSize(), this.f12330aj.getM_nRotation(), this.f12315aJ);
                    }
                    this.f12329ai.m12820a(this.f12304W, this.f12305Z);
                    this.f12329ai.m12845b(this.f12321aa);
                    this.f12329ai.mo12131a(this.f12301T);
                }
                AMS_RECT m_TRect2 = this.f12330aj.getM_TRect();
                RectF rectF = new RectF(m_TRect2.nLeft, m_TRect2.nTop, m_TRect2.nRight, m_TRect2.nBottom);
                this.f12331ak++;
                this.f12335ao++;
                if (this.f12330aj.getM_cStyle() == 0) {
                    if (m_cAdditionalID < C3410al.m12173a().m12208k()) {
                        if (this.f12331ak < 32) {
                            this.f12329ai.mo12836a(rectF, (int) ((this.f12331ak / 2) * (this.f12331ak / 2)));
                        } else {
                            this.f12329ai.mo12836a(rectF, MotionEventCompat.ACTION_MASK);
                            this.f12332al = false;
                        }
                    } else if (m_cAdditionalID < C3410al.m12173a().m12208k() + C3410al.m12173a().m12205i()) {
                        if (this.f12331ak < 32) {
                            this.f12329ai.mo12836a(rectF, (this.f12331ak / 2) + 1000);
                        } else {
                            this.f12329ai.mo12836a(rectF, MotionEventCompat.ACTION_MASK);
                            this.f12332al = false;
                        }
                    } else if (this.f12331ak < 32) {
                        this.f12329ai.mo12836a(rectF, (int) ((this.f12331ak / 2) * (this.f12331ak / 2)));
                    } else {
                        this.f12329ai.mo12836a(rectF, MotionEventCompat.ACTION_MASK);
                        this.f12332al = false;
                    }
                } else if (this.f12330aj.getM_cStyle() == 2) {
                    if (this.f12331ak < 32) {
                        this.f12329ai.mo12836a(rectF, (int) ((this.f12331ak / 2) * (this.f12331ak / 2)));
                    } else {
                        this.f12329ai.mo12836a(rectF, MotionEventCompat.ACTION_MASK);
                        this.f12332al = false;
                    }
                } else if (this.f12331ak < 32) {
                    this.f12329ai.mo12836a(rectF, (int) ((this.f12331ak / 2) * (this.f12331ak / 2)));
                } else {
                    this.f12329ai.mo12836a(rectF, MotionEventCompat.ACTION_MASK);
                    this.f12332al = false;
                }
                m11988a(m_TRect2);
                break;
            case 4:
                if (this.f12331ak == 0) {
                    this.f12329ai = new C3590w(this.f12330aj.getM_cStyle(), Color.rgb(this.f12330aj.getM_nColorR(), this.f12330aj.getM_nColorG(), this.f12330aj.getM_nColorB()), this.f12330aj.getM_cSize(), false);
                    this.f12329ai.m12850c(getContext().getResources().getDrawable(R.drawable.more_option_support_white));
                    this.f12329ai.m12820a(this.f12304W, this.f12305Z);
                    this.f12329ai.m12845b(this.f12321aa);
                    this.f12329ai.mo12131a(this.f12301T);
                }
                AMS_RECT m_TRect3 = this.f12330aj.getM_TRect();
                this.f12331ak++;
                this.f12335ao++;
                if (this.f12331ak < 32) {
                    this.f12329ai.mo12830a(m_TRect3.nLeft, m_TRect3.nTop, m_TRect3.nRight, m_TRect3.nBottom, (int) ((this.f12331ak / 2) * (this.f12331ak / 2)));
                } else {
                    this.f12329ai.mo12830a(m_TRect3.nLeft, m_TRect3.nTop, m_TRect3.nRight, m_TRect3.nBottom, MotionEventCompat.ACTION_MASK);
                    this.f12332al = false;
                }
                m11988a(m_TRect3);
                break;
        }
        this.f12333am = false;
        return true;
    }

    /* renamed from: j */
    public boolean m12029j() {
        if (this.f12303V == null || !this.f12303V.m12852d()) {
            return false;
        }
        setEditMode(false, true);
        if (this.f12317aL != null) {
            this.f12317aL.mo12519a(0, 0, 0, 0, 0);
        }
        m12041v();
        return true;
    }

    /* renamed from: k */
    public boolean m12030k() {
        if (this.f12310aE != null) {
            m12044y();
            return false;
        }
        if (this.f12291J == null || this.f12291J.VipAMS_Undo(this.f12292K) == 0) {
            return false;
        }
        setEditMode(false, true);
        if (this.f12317aL != null) {
            this.f12317aL.mo12519a(0, 0, 0, 0, 0);
        }
        m12041v();
        return true;
    }

    /* renamed from: l */
    public boolean m12031l() {
        if (this.f12291J == null || this.f12291J.VipAMS_Redo(this.f12292K) == 0) {
            return false;
        }
        setEditMode(false, true);
        if (this.f12317aL != null) {
            this.f12317aL.mo12519a(0, 0, 0, 0, 0);
        }
        m12041v();
        return true;
    }

    /* renamed from: a */
    public boolean m12014a(String str, DisplayMetrics displayMetrics) {
        return m12015a(str, displayMetrics, true);
    }

    /* renamed from: a */
    public boolean m12015a(String str, DisplayMetrics displayMetrics, boolean z) {
        if (this.f12291J == null) {
            return false;
        }
        int iMin = Math.min(Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels), 480);
        int[] iArr = new int[iMin * iMin];
        if (z) {
            m12034o();
            m12026g();
            m12004a(false);
        }
        Bitmap.createScaledBitmap(this.f12304W, iMin, iMin, true).getPixels(iArr, 0, iMin, 0, 0, iMin, iMin);
        this.f12291J.VipAMS_SetAMSImageBuf(this.f12292K, iArr, iMin, iMin);
        AMS_CODING_FILE_INFO[] ams_coding_file_infoArr = {new AMS_CODING_FILE_INFO()};
        ams_coding_file_infoArr[0].setM_eExportType(0);
        ams_coding_file_infoArr[0].setM_strFileName(str);
        if (this.f12291J.VipAMS_TotalSaveEncoding(this.f12292K, ams_coding_file_infoArr) != 0) {
            return true;
        }
        C3250y.m11442a("VipAMS_TotalSaveEncoding Error = " + this.f12291J.VipAMS_GetErrorCode(this.f12292K), getClass().getSimpleName());
        return false;
    }

    /* renamed from: a */
    public int m12002a(String str) {
        if (this.f12291J == null) {
            this.f12336ap = false;
            return 4;
        }
        if (!this.f12291J.VipAMS_ClearEncoding(this.f12292K)) {
            this.f12336ap = false;
            return 4;
        }
        AMS_CODING_FILE_INFO[] ams_coding_file_infoArr = {new AMS_CODING_FILE_INFO()};
        ams_coding_file_infoArr[0].setM_eExportType(0);
        ams_coding_file_infoArr[0].setM_strFileName(str);
        if (this.f12291J.VipAMS_TotalLoadEncodingFile(this.f12292K, ams_coding_file_infoArr, this.f12293L.m_rectRegion) == 0) {
            int iVipAMS_GetErrorCode = this.f12291J.VipAMS_GetErrorCode(this.f12292K);
            this.f12336ap = false;
            switch (iVipAMS_GetErrorCode) {
                case 45:
                    break;
                case 46:
                case 47:
                case 48:
                default:
                    C3250y.m11442a("VipAMS_TotalLoadEncodingFile Error = " + iVipAMS_GetErrorCode, getClass().getSimpleName());
                    break;
                case 49:
                    break;
                case 50:
                    break;
            }
            return 4;
        }
        if (m12023d() || m12035p() > 1 || m11985K()) {
            this.f12336ap = false;
        } else {
            this.f12336ap = true;
        }
        this.f12334an = m11982H();
        return 0;
    }

    /* renamed from: m */
    public int m12032m() {
        return this.f12334an;
    }

    /* renamed from: n */
    public int m12033n() {
        return this.f12335ao;
    }

    /* renamed from: H */
    private int m11982H() {
        AMS_OBJECT_DATA ams_object_data = new AMS_OBJECT_DATA();
        if (this.f12291J != null) {
            this.f12316aK = 0;
            int iVipAMS_GetNextDrawingData = 0;
            int m_nPointNum = 0;
            while (true) {
                iVipAMS_GetNextDrawingData = this.f12291J.VipAMS_GetNextDrawingData(this.f12292K, iVipAMS_GetNextDrawingData, ams_object_data);
                while (iVipAMS_GetNextDrawingData == 0) {
                    if (!this.f12291J.VipAMS_SetNextFrame(this.f12292K)) {
                        return m_nPointNum;
                    }
                    iVipAMS_GetNextDrawingData = this.f12291J.VipAMS_GetNextDrawingData(this.f12292K, iVipAMS_GetNextDrawingData, ams_object_data);
                }
                this.f12316aK++;
                switch (ams_object_data.getM_eType()) {
                    case 1:
                        m_nPointNum += ams_object_data.getM_TPoint().getM_nPointNum();
                        if (!this.f12336ap || ams_object_data.getM_cStyle() != 4) {
                            break;
                        } else {
                            this.f12336ap = false;
                            break;
                        }
                        break;
                    case 2:
                        m_nPointNum += 32;
                        break;
                    case 3:
                        m_nPointNum += 32;
                        if (!this.f12336ap || ams_object_data.getM_cStyle() != 0) {
                            break;
                        } else {
                            if (!C3410al.m12173a().m12204h(ams_object_data.getM_cAdditionalID())) {
                                this.f12336ap = false;
                                break;
                            } else {
                                break;
                            }
                        }
                        break;
                    case 4:
                        m_nPointNum += 32;
                        this.f12336ap = false;
                        break;
                }
            }
        } else {
            return 0;
        }
    }

    /* renamed from: o */
    public void m12034o() {
        if (this.f12291J != null) {
            while (this.f12291J.VipAMS_SetNextFrame(this.f12292K)) {
            }
            setEditMode(false, false);
        }
    }

    public void setPage(int i) {
        if (this.f12291J != null) {
            this.f12291J.VipAMS_SetCurrentFrame(this.f12292K, (byte) i);
            setEditMode(false, false);
        }
    }

    /* renamed from: p */
    public int m12035p() {
        if (this.f12291J == null) {
            return -1;
        }
        return this.f12291J.VipAMS_GetLastFrame(this.f12292K);
    }

    /* renamed from: q */
    public boolean m12036q() {
        if (this.f12291J == null) {
            return false;
        }
        return this.f12291J.VipAMS_IsEnableUndo(this.f12292K);
    }

    /* renamed from: r */
    public boolean m12037r() {
        if (this.f12291J == null) {
            return false;
        }
        return this.f12291J.VipAMS_IsEnableRedo(this.f12292K);
    }

    /* renamed from: s */
    public boolean m12038s() {
        return this.f12291J != null && this.f12291J.VipAMS_IsEditEnable(this.f12292K) && this.f12336ap;
    }

    /* renamed from: t */
    public boolean m12039t() {
        if (this.f12291J == null) {
            return false;
        }
        return this.f12291J.VipAMS_IsAnimationEnable(this.f12292K);
    }

    /* renamed from: u */
    public void m12040u() {
        this.f12290I = null;
        if (this.f12291J != null) {
            this.f12291J.VipAMS_Close(this.f12292K);
            this.f12291J = null;
        }
        if (this.f12304W != null) {
            this.f12304W.recycle();
            this.f12304W = null;
        }
        if (this.f12305Z != null) {
            this.f12305Z.recycle();
            this.f12305Z = null;
        }
        if (this.f12321aa != null) {
            this.f12321aa.recycle();
            this.f12321aa = null;
        }
        this.f12293L = null;
        this.f12302U = null;
        this.f12303V = null;
        this.f12325ae = null;
        this.f12329ai = null;
        this.f12330aj = null;
        this.f12343aw = null;
        System.gc();
    }

    /* renamed from: v */
    public void m12041v() {
        m11983I();
    }

    /* renamed from: a */
    public void m12004a(boolean z) {
        if (z) {
            m12041v();
        } else {
            invalidate();
        }
    }

    /* renamed from: I */
    private void m11983I() {
        if (this.f12329ai == null) {
            invalidate();
        } else if (this.f12329ai.m12854f() == null) {
            invalidate();
        } else {
            invalidate(this.f12329ai.m12854f());
        }
    }

    /* renamed from: a */
    private void m11988a(AMS_RECT ams_rect) {
        this.f12329ai.m12821a(new Rect((int) (ams_rect.nLeft - this.f12342av), (int) (ams_rect.nTop - this.f12342av), (int) (ams_rect.nRight + this.f12342av), (int) (ams_rect.nBottom + this.f12342av)));
    }

    /* renamed from: J */
    private void m11984J() {
        this.f12339as = 0;
        this.f12340at = new float[]{0.0f, 0.0f, 0.0f};
        this.f12341au = new float[]{0.0f, 0.0f, 0.0f};
    }

    /* renamed from: e */
    private AMS_RECT m11998e(float f, float f2) {
        this.f12340at[this.f12339as] = f;
        this.f12341au[this.f12339as] = f2;
        this.f12339as++;
        if (this.f12339as > 2) {
            this.f12339as = 0;
        }
        float fMax = Math.max(Math.max(this.f12340at[0], this.f12340at[1]), this.f12340at[2]);
        float fMin = Math.min(Math.min(this.f12340at[0], this.f12340at[1]), this.f12340at[2]);
        float fMax2 = Math.max(Math.max(this.f12341au[0], this.f12341au[1]), this.f12341au[2]);
        float fMin2 = Math.min(Math.min(this.f12341au[0], this.f12341au[1]), this.f12341au[2]);
        AMS_RECT ams_rect = new AMS_RECT();
        ams_rect.nLeft = (short) fMin;
        ams_rect.nTop = (short) fMin2;
        ams_rect.nRight = (short) fMax;
        ams_rect.nBottom = (short) fMax2;
        return ams_rect;
    }

    /* renamed from: b */
    public boolean m12019b(String str) {
        this.f12294M = 100;
        this.f12295N = 100;
        m11979E();
        m12002a(str);
        boolean zM12038s = m12038s();
        if (this.f12291J != null) {
            this.f12291J.VipAMS_Close(this.f12292K);
            this.f12291J = null;
        }
        return zM12038s;
    }

    /* renamed from: K */
    private boolean m11985K() {
        return this.f12291J.VipAMS_GetBackgroundStyle(this.f12292K) == 2;
    }

    /* renamed from: a */
    private void m11987a(int i) {
        if (i >= 0 && i <= 11) {
            switch (i) {
                case 0:
                    m12009a(MotionEventCompat.ACTION_MASK, MotionEventCompat.ACTION_MASK, MotionEventCompat.ACTION_MASK, false);
                    break;
                case 1:
                    m12009a(MotionEventCompat.ACTION_MASK, MotionEventCompat.ACTION_MASK, MotionEventCompat.ACTION_MASK, false);
                    break;
                case 2:
                    m12009a(MotionEventCompat.ACTION_MASK, MotionEventCompat.ACTION_MASK, MotionEventCompat.ACTION_MASK, false);
                    break;
                case 3:
                    m12009a(MotionEventCompat.ACTION_MASK, 249, 187, false);
                    break;
                case 4:
                    m12009a(207, 230, 244, false);
                    break;
                case 5:
                    m12009a(243, 207, 235, false);
                    break;
                case 6:
                    m12009a(252, 244, MotionEventCompat.ACTION_MASK, false);
                    break;
                case 7:
                    m12009a(MotionEventCompat.ACTION_MASK, 253, 238, false);
                    break;
                case 8:
                    m12009a(230, 247, MotionEventCompat.ACTION_MASK, false);
                    break;
                case 9:
                    m12009a(MotionEventCompat.ACTION_MASK, 250, 208, false);
                    break;
                case 10:
                    m12009a(229, 206, 157, false);
                    break;
                case 11:
                    m12009a(8, 49, 8, false);
                    break;
            }
        }
    }

    public void setOnTouchTextArea(InterfaceC3583p interfaceC3583p) {
        this.f12344ax = interfaceC3583p;
    }

    /* renamed from: e */
    private boolean m11999e(MotionEvent motionEvent) {
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
    private boolean m12000f(MotionEvent motionEvent) {
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
    public void m12042w() {
        Rect rectM12859k;
        switch (this.f12309aD) {
            case 101:
            case 102:
                m12026g();
                if ((this.f12296O == 3 || this.f12296O == 2) && this.f12324ad && this.f12303V != null && (rectM12859k = this.f12303V.m12859k()) != null) {
                    m11994b(rectM12859k.centerX(), rectM12859k.centerY());
                    break;
                }
                break;
        }
    }

    /* renamed from: x */
    public void m12043x() {
        this.f12314aI = this.f12305Z.copy(Bitmap.Config.ARGB_8888, true);
        Drawable drawable = this.f12290I.getResources().getDrawable(R.drawable.ams_ics_selector_image_crop_cancel);
        this.f12310aE = new C3401ac(this.f12296O, this.f12298Q, this.f12300S, false, this.f12294M, this.f12295N);
        this.f12310aE.m12155a(this.f12320aO);
        this.f12310aE.m12847b(true);
        this.f12310aE.m12822a(this.f12290I.getResources().getDrawable(R.drawable.gridview_selector_selected));
        this.f12310aE.m12846b(drawable);
        this.f12310aE.m12827a(this.f12318aM);
        this.f12310aE.m12817a(5);
        this.f12344ax.mo12518a(true);
        this.f12310aE.m12845b(this.f12321aa);
        this.f12310aE.mo12131a(this.f12301T);
        this.f12310aE.m12828a(true);
        this.f12310aE.m12820a(this.f12304W, this.f12314aI);
        if (this.f12296O == 2) {
            String string = this.f12290I.getResources().getString(R.string.ams_msg_enter_message);
            this.f12310aE.m12160a(string, this.f12298Q, this.f12300S, this.f12294M / 2, this.f12295N / 2);
            RectF rectF = new RectF(this.f12310aE.f12447aa);
            this.f12310aE.mo12134a(rectF.left, rectF.top, rectF.right, rectF.bottom, string, MotionEventCompat.ACTION_MASK);
            m12041v();
        }
    }

    /* renamed from: a */
    public void m12003a(int i, int i2) {
        if (this.f12310aE != null) {
            if (i != this.f12298Q) {
                i = this.f12298Q;
            }
            if (i2 != this.f12300S) {
                i2 = this.f12300S;
            }
            this.f12310aE.mo12815a();
            this.f12310aE.mo12137a(this.f12297P, i, i2);
            m12041v();
        }
    }

    /* renamed from: y */
    public void m12044y() {
        if (this.f12310aE == null) {
            m12045z();
            return;
        }
        this.f12310aE.mo12815a();
        m12041v();
        this.f12310aE = null;
        m12045z();
    }

    /* renamed from: z */
    public void m12045z() {
        if (this.f12314aI != null) {
            this.f12314aI.recycle();
        }
        this.f12314aI = null;
    }

    /* renamed from: A */
    public boolean m12001A() {
        return this.f12310aE != null;
    }

    /* renamed from: a */
    public boolean m12006a(float f, float f2) {
        if (this.f12310aE == null) {
            return false;
        }
        this.f12311aF = false;
        if (this.f12310aE.mo12146c(f, f2)) {
            this.f12311aF = true;
            return this.f12310aE.mo12147d(f, f2);
        }
        if (!this.f12291J.VipAMS_SelectObject(this.f12292K, (int) f, (int) f2, new AMS_SELECT_OBJECT(), this.f12296O)) {
            return true;
        }
        m12044y();
        return false;
    }

    /* renamed from: b */
    public boolean m12017b(float f, float f2) {
        if (this.f12310aE == null) {
            return false;
        }
        if (this.f12311aF) {
            return this.f12310aE.mo12148e(f, f2);
        }
        return true;
    }

    /* renamed from: c */
    public boolean m12021c(float f, float f2) {
        if (this.f12310aE == null) {
            return false;
        }
        this.f12313aH.set(f, f2);
        if (this.f12311aF) {
            return this.f12310aE.mo12149f(f, f2);
        }
        this.f12320aO.mo12777a(null, f, f2);
        return true;
    }
}
