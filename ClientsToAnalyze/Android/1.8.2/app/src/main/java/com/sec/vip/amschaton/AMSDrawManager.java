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
import com.sec.chaton.util.C1786r;
import com.sec.widget.C2153y;
import java.io.File;
import twitter4j.MediaEntity;

/* loaded from: classes.dex */
public class AMSDrawManager extends ZoomableImageView implements View.OnTouchListener {

    /* renamed from: a */
    public static final String f6624a = AMSActivity.f6608a;

    /* renamed from: b */
    public static final String f6625b = AMSActivity.f6613f;

    /* renamed from: c */
    public static final String f6626c = f6624a + "template/";

    /* renamed from: F */
    private Context f6627F;

    /* renamed from: G */
    private AMSLibs f6628G;

    /* renamed from: H */
    private int f6629H;

    /* renamed from: I */
    private AMS_UI_DATA f6630I;

    /* renamed from: J */
    private int f6631J;

    /* renamed from: K */
    private int f6632K;

    /* renamed from: L */
    private int f6633L;

    /* renamed from: M */
    private int f6634M;

    /* renamed from: N */
    private int f6635N;

    /* renamed from: O */
    private int f6636O;

    /* renamed from: P */
    private int f6637P;

    /* renamed from: Q */
    private float f6638Q;

    /* renamed from: R */
    private C2068r f6639R;

    /* renamed from: S */
    private C2068r f6640S;

    /* renamed from: T */
    private Bitmap f6641T;

    /* renamed from: U */
    private Bitmap f6642U;

    /* renamed from: V */
    private Bitmap f6643V;

    /* renamed from: W */
    private boolean f6644W;

    /* renamed from: Z */
    private int f6645Z;

    /* renamed from: aA */
    private boolean f6646aA;

    /* renamed from: aB */
    private boolean f6647aB;

    /* renamed from: aC */
    private PointF f6648aC;

    /* renamed from: aD */
    private Bitmap f6649aD;

    /* renamed from: aE */
    private InterfaceC2061k f6650aE;

    /* renamed from: aF */
    private InterfaceC2069s f6651aF;

    /* renamed from: aG */
    private final int f6652aG;

    /* renamed from: aH */
    private InterfaceC2062l f6653aH;

    /* renamed from: aa */
    private boolean f6654aa;

    /* renamed from: ab */
    private AMS_SELECT_OBJECT f6655ab;

    /* renamed from: ac */
    private final int f6656ac;

    /* renamed from: ad */
    private final int f6657ad;

    /* renamed from: ae */
    private int f6658ae;

    /* renamed from: af */
    private C2068r f6659af;

    /* renamed from: ag */
    private AMS_OBJECT_DATA f6660ag;

    /* renamed from: ah */
    private int f6661ah;

    /* renamed from: ai */
    private boolean f6662ai;

    /* renamed from: aj */
    private boolean f6663aj;

    /* renamed from: ak */
    private int f6664ak;

    /* renamed from: al */
    private int f6665al;

    /* renamed from: am */
    private boolean f6666am;

    /* renamed from: an */
    private int f6667an;

    /* renamed from: ao */
    private boolean f6668ao;

    /* renamed from: ap */
    private int f6669ap;

    /* renamed from: aq */
    private float[] f6670aq;

    /* renamed from: ar */
    private float[] f6671ar;

    /* renamed from: as */
    private float f6672as;

    /* renamed from: at */
    private InterfaceC2075y f6673at;

    /* renamed from: au */
    private InterfaceC2063m f6674au;

    /* renamed from: av */
    private boolean f6675av;

    /* renamed from: aw */
    private float f6676aw;

    /* renamed from: ax */
    private float f6677ax;

    /* renamed from: ay */
    private int f6678ay;

    /* renamed from: az */
    private C2076z f6679az;

    public AMSDrawManager(Context context, int i, int i2) {
        super(context);
        this.f6639R = null;
        this.f6640S = null;
        this.f6641T = null;
        this.f6642U = null;
        this.f6643V = null;
        this.f6644W = false;
        this.f6654aa = false;
        this.f6655ab = null;
        this.f6656ac = 32;
        this.f6657ad = 2;
        this.f6658ae = 0;
        this.f6659af = null;
        this.f6660ag = null;
        this.f6661ah = 0;
        this.f6662ai = false;
        this.f6663aj = false;
        this.f6664ak = 0;
        this.f6665al = 0;
        this.f6666am = false;
        this.f6667an = 0;
        this.f6668ao = true;
        this.f6672as = 32.0f;
        this.f6673at = null;
        this.f6674au = null;
        this.f6675av = false;
        this.f6676aw = 0.0f;
        this.f6677ax = 0.0f;
        this.f6678ay = 100;
        this.f6679az = null;
        this.f6646aA = false;
        this.f6647aB = false;
        this.f6648aC = new PointF(0.0f, 0.0f);
        this.f6649aD = null;
        this.f6650aE = null;
        this.f6651aF = new C1976i(this);
        this.f6652aG = 240;
        this.f6653aH = new C2060j(this);
        this.f6627F = context;
        this.f6633L = 1;
        this.f6634M = 0;
        this.f6638Q = i / 240.0f;
        this.f6637P = 1;
        this.f6635N = -16777216;
        this.f6636O = -1;
        this.f6631J = i;
        this.f6632K = i2;
        this.f6641T = null;
        this.f6642U = null;
        new File(f6624a).mkdirs();
        new File(f6625b).mkdirs();
        new File(f6626c).mkdirs();
        new File(AMSActivity.f6609b).mkdirs();
        new File(AMSActivity.f6610c).mkdirs();
        new File(AMSActivity.f6611d).mkdirs();
        this.f6672as = getContext().getResources().getDimensionPixelSize(R.dimen.ams_invalidate_rect_margin);
    }

    public AMSDrawManager(Context context) {
        super(context);
        this.f6639R = null;
        this.f6640S = null;
        this.f6641T = null;
        this.f6642U = null;
        this.f6643V = null;
        this.f6644W = false;
        this.f6654aa = false;
        this.f6655ab = null;
        this.f6656ac = 32;
        this.f6657ad = 2;
        this.f6658ae = 0;
        this.f6659af = null;
        this.f6660ag = null;
        this.f6661ah = 0;
        this.f6662ai = false;
        this.f6663aj = false;
        this.f6664ak = 0;
        this.f6665al = 0;
        this.f6666am = false;
        this.f6667an = 0;
        this.f6668ao = true;
        this.f6672as = 32.0f;
        this.f6673at = null;
        this.f6674au = null;
        this.f6675av = false;
        this.f6676aw = 0.0f;
        this.f6677ax = 0.0f;
        this.f6678ay = 100;
        this.f6679az = null;
        this.f6646aA = false;
        this.f6647aB = false;
        this.f6648aC = new PointF(0.0f, 0.0f);
        this.f6649aD = null;
        this.f6650aE = null;
        this.f6651aF = new C1976i(this);
        this.f6652aG = 240;
        this.f6653aH = new C2060j(this);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) throws Resources.NotFoundException {
        switch (motionEvent.getAction() & MotionEventCompat.ACTION_MASK) {
            case 0:
                this.f6667an = 0;
                m6299a(motionEvent);
                break;
            case 1:
                if (this.f6667an == 0) {
                    m6309c(motionEvent);
                }
                this.f6667an = 0;
                break;
            case 2:
                if (this.f6667an == 1 && this.f6668ao) {
                    return m6384d(motionEvent);
                }
                m6306b(motionEvent);
                break;
            case 5:
                if (this.f6668ao) {
                    this.f6667an = 1;
                    if (this.f6633L == 1) {
                        m6314g();
                    } else if (this.f6679az == null) {
                        if (!this.f6654aa) {
                            if (this.f6639R != null) {
                                this.f6639R.mo7193a();
                                this.f6639R.f7417z = 0;
                            }
                        } else {
                            m6309c(motionEvent);
                        }
                    } else {
                        m6332y();
                    }
                    return m6384d(motionEvent);
                }
                break;
            case 6:
                if (this.f6668ao) {
                    return m6384d(motionEvent);
                }
                break;
        }
        if (this.f6639R == null) {
            return true;
        }
        if (this.f6640S != null || this.f6639R.m7234d() == null) {
            invalidate();
            return true;
        }
        invalidate(this.f6639R.m7234d());
        return true;
    }

    /* renamed from: d */
    private PointF m6286d(float f, float f2) {
        float fB = m6381B();
        PointF pointFD = m6383D();
        if (fB == 1.0f && pointFD.x == 0.0f && pointFD.y == 0.0f) {
            return new PointF(f, f2);
        }
        return new PointF((f - pointFD.x) / fB, (f2 - pointFD.y) / fB);
    }

    public void setBitmapForAMS(String str) {
        if (str == null) {
            setBitmap(this.f6641T);
            return;
        }
        Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(str);
        if (bitmapDecodeFile != null) {
            setBitmap(bitmapDecodeFile);
        }
    }

    public void setEnableZoom(boolean z) {
        this.f6668ao = z;
    }

    /* renamed from: a */
    public boolean m6293a() {
        try {
            if (this.f6641T != null) {
                this.f6641T.recycle();
                this.f6641T = null;
            }
            this.f6641T = Bitmap.createBitmap(this.f6631J, this.f6632K, Bitmap.Config.ARGB_8888);
            if (this.f6642U != null) {
                this.f6642U.recycle();
                this.f6642U = null;
            }
            this.f6642U = Bitmap.createBitmap(this.f6631J, this.f6632K, Bitmap.Config.ARGB_8888);
            setDefaultScale(0);
            setBitmap(this.f6641T);
            m6382C();
            m6268E();
            if (!m6297a(Color.red(this.f6636O), Color.green(this.f6636O), Color.blue(this.f6636O), true)) {
                return false;
            }
            m6296a(this.f6633L, this.f6634M, this.f6635N, this.f6637P);
            m6269F();
            return true;
        } catch (OutOfMemoryError e) {
            C2153y.m7535a(this.f6627F, R.string.chat_view_memory_error, 0).show();
            return false;
        }
    }

    /* renamed from: E */
    private boolean m6268E() {
        if (this.f6628G != null) {
            this.f6628G.VipAMS_Close(this.f6629H);
            this.f6628G = null;
        }
        this.f6628G = new AMSLibs();
        this.f6628G.VipAMS_Init();
        String str = f6625b;
        this.f6628G.VipAMS_SetTempFilePath(str.getBytes(), str.getBytes().length);
        this.f6630I = new AMS_UI_DATA();
        this.f6630I.Init();
        this.f6630I.SetRect((short) 0, (short) 0, (short) this.f6631J, (short) this.f6632K);
        this.f6630I.m_rgbPen = this.f6635N;
        this.f6630I.m_rgbBack = this.f6636O;
        this.f6630I.m_cObjectSize = (byte) this.f6637P;
        this.f6630I.m_eObjectType = (byte) 1;
        this.f6630I.m_cObjectStyle = (byte) 0;
        AMS_OPTION ams_option = new AMS_OPTION();
        ams_option.Init();
        this.f6629H = this.f6628G.VipAMS_Open(ams_option);
        AMS_OBJECT_DATA ams_object_data = new AMS_OBJECT_DATA();
        ams_object_data.setM_cSize(this.f6630I.m_cObjectSize);
        ams_object_data.setM_cStyle(this.f6630I.m_cObjectStyle);
        ams_object_data.setM_nColorR(Color.red(this.f6630I.m_rgbPen));
        ams_object_data.setM_nColorG(Color.green(this.f6630I.m_rgbPen));
        ams_object_data.setM_nColorB(Color.blue(this.f6630I.m_rgbPen));
        if (this.f6628G.VipAMS_TotalNewEncoding(this.f6629H, this.f6630I.m_rectRegion, ams_object_data)) {
            return true;
        }
        C1786r.m6054a("Error Code: " + this.f6628G.VipAMS_GetErrorCode(this.f6629H), getClass().getSimpleName());
        return false;
    }

    /* renamed from: b */
    private boolean m6284b(int i, int i2, int i3, int i4) {
        if (!this.f6628G.VipAMS_SetCurObjectType(this.f6629H, (byte) i)) {
            C1786r.m6054a(" Error Code =" + this.f6628G.VipAMS_GetErrorCode(this.f6629H) + ", Line : " + new Exception().getStackTrace()[0].getLineNumber(), getClass().getSimpleName());
            return false;
        }
        if (!this.f6628G.VipAMS_SetCurObjectStyle(this.f6629H, (byte) i2)) {
            C1786r.m6054a(" Error Code =" + this.f6628G.VipAMS_GetErrorCode(this.f6629H) + ", Line : " + new Exception().getStackTrace()[0].getLineNumber(), getClass().getSimpleName());
            return false;
        }
        if (!this.f6628G.VipAMS_SetCurObjectSize(this.f6629H, (byte) i4)) {
            C1786r.m6054a(" Error Code =" + this.f6628G.VipAMS_GetErrorCode(this.f6629H) + ", Line : " + new Exception().getStackTrace()[0].getLineNumber(), getClass().getSimpleName());
            return false;
        }
        if (!this.f6628G.VipAMS_SetCurObjectColor(this.f6629H, Color.red(i3), Color.green(i3), Color.blue(i3))) {
            C1786r.m6054a(" Error Code =" + this.f6628G.VipAMS_GetErrorCode(this.f6629H) + ", Line : " + new Exception().getStackTrace()[0].getLineNumber(), getClass().getSimpleName());
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public boolean m6296a(int i, int i2, int i3, int i4) {
        this.f6630I.m_rgbBack = this.f6636O;
        if (!m6284b(i, i2, i3, i4)) {
            return false;
        }
        this.f6633L = i;
        this.f6634M = i2;
        this.f6635N = i3;
        this.f6637P = i4;
        if (this.f6639R != null) {
            this.f6639R.mo7229c();
            this.f6639R = null;
        }
        switch (i) {
            case 1:
                this.f6639R = new C2071u(this.f6634M, this.f6635N, this.f6637P);
                if (this.f6634M == 4) {
                    this.f6645Z = this.f6637P;
                    break;
                }
                break;
            case 2:
                C2074x c2074x = new C2074x(this.f6634M, this.f6635N, this.f6637P, true, this.f6631J, this.f6632K);
                c2074x.m7247a(this.f6673at);
                this.f6639R = c2074x;
                break;
            case 3:
                this.f6639R = new C2073w(this.f6634M, this.f6635N, this.f6637P, false);
                break;
            case 4:
                this.f6639R = new C2070t(this.f6634M, this.f6635N, this.f6637P, false);
                this.f6639R.m7231c(getContext().getResources().getDrawable(R.drawable.more_option_icon_help));
                break;
        }
        this.f6639R.m7205a(this.f6628G, this.f6629H, this.f6630I);
        this.f6639R.m7200a(this.f6641T, this.f6642U);
        this.f6639R.m7224b(this.f6643V);
        this.f6639R.mo7194a(this.f6638Q);
        return true;
    }

    public void setEraserSize(int i) {
        this.f6645Z = i;
    }

    /* renamed from: a */
    public boolean m6297a(int i, int i2, int i3, boolean z) {
        if (z && !this.f6628G.VipAMS_SetBackgroundColor(this.f6629H, i, i2, i3)) {
            C1786r.m6054a("VipAMS_SetBackgroundColor Error = " + this.f6628G.VipAMS_GetErrorCode(this.f6629H), getClass().getSimpleName());
            return false;
        }
        this.f6636O = Color.rgb(i, i2, i3);
        if (this.f6643V != null) {
            this.f6643V.recycle();
            this.f6643V = null;
        }
        try {
            this.f6643V = Bitmap.createBitmap(this.f6641T.getWidth(), this.f6641T.getHeight(), Bitmap.Config.ARGB_8888);
            new Canvas(this.f6643V).drawColor(this.f6636O);
            if (this.f6639R != null) {
                this.f6639R.m7224b(this.f6643V);
            }
            if (this.f6640S != null) {
                this.f6640S.m7224b(this.f6643V);
            }
            return true;
        } catch (OutOfMemoryError e) {
            C2153y.m7535a(this.f6627F, R.string.chat_view_memory_error, 0).show();
            return false;
        }
    }

    /* renamed from: a */
    public boolean m6298a(Bitmap bitmap, boolean z) {
        if (z) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int[] iArr = new int[width * height];
            bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
            if (!this.f6628G.VipAMS_SetBackgroundRawImage(this.f6629H, iArr, width, height, 24)) {
                C1786r.m6054a("VipAMS_SetBackgroundRawImage1 Error = " + this.f6628G.VipAMS_GetErrorCode(this.f6629H), getClass().getSimpleName());
                return false;
            }
        }
        if (this.f6643V != null) {
            this.f6643V.recycle();
            this.f6643V = null;
        }
        this.f6643V = Bitmap.createBitmap(this.f6641T.getWidth(), this.f6641T.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(this.f6643V);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setFilterBitmap(true);
        canvas.drawBitmap(bitmap, new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), new Rect(0, 0, this.f6641T.getWidth(), this.f6641T.getHeight()), paint);
        if (this.f6639R != null) {
            this.f6639R.m7224b(this.f6643V);
        }
        if (this.f6640S != null) {
            this.f6640S.m7224b(this.f6643V);
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
        this.f6654aa = z;
        if (!this.f6654aa) {
            if (this.f6640S != null) {
                this.f6640S = null;
                this.f6655ab = null;
                m6314g();
                z3 = true;
            }
            m6296a(this.f6633L, this.f6634M, this.f6635N, this.f6637P);
        }
        if (!z3 && z2) {
            m6314g();
        }
    }

    public void setAMSLib(AMSLibs aMSLibs, int i, AMS_UI_DATA ams_ui_data) {
        this.f6628G = aMSLibs;
        this.f6629H = i;
        this.f6630I = ams_ui_data;
    }

    public void setOnObjectListener(InterfaceC2061k interfaceC2061k) {
        this.f6650aE = interfaceC2061k;
    }

    public void setOnTextInputRequestListener(InterfaceC2075y interfaceC2075y) {
        this.f6673at = interfaceC2075y;
    }

    /* renamed from: b */
    public int m6303b() {
        return this.f6636O;
    }

    /* renamed from: c */
    public int m6307c() {
        return this.f6628G.VipAMS_GetBGAudioStyle(this.f6629H);
    }

    /* renamed from: d */
    public boolean m6311d() {
        switch (m6307c()) {
            case 1:
            case 2:
            case 3:
                return true;
            default:
                return false;
        }
    }

    /* renamed from: e */
    public C2068r m6312e() {
        return this.f6640S;
    }

    /* renamed from: a */
    public boolean m6295a(int i, int i2, int i3) {
        if (!this.f6654aa || this.f6640S == null) {
            return false;
        }
        this.f6634M = i;
        this.f6635N = i2;
        this.f6637P = i3;
        m6284b(this.f6633L, this.f6634M, i2, i3);
        return this.f6640S.mo7218a(this.f6634M, i2, i3);
    }

    /* renamed from: a */
    public boolean m6299a(MotionEvent motionEvent) {
        float f;
        PointF pointF = new PointF();
        pointF.set(m6286d(motionEvent.getX(), motionEvent.getY()));
        float f2 = pointF.x;
        float f3 = pointF.y;
        this.f6678ay = MediaEntity.Size.CROP;
        if (this.f6633L == 1) {
            this.f6675av = false;
            if (f2 < 0.0f || f3 < 0.0f || f2 > this.f6631J || f3 > this.f6632K) {
                this.f6675av = true;
                return true;
            }
            f = f2;
        } else {
            if (f2 < 0.0f) {
                f2 = 0.0f;
            }
            float f4 = f3 >= 0.0f ? f3 : 0.0f;
            float f5 = f2 > ((float) this.f6631J) ? this.f6631J - 1 : f2;
            if (f4 > this.f6632K) {
                f = f5;
                f3 = this.f6632K - 1;
            } else {
                float f6 = f4;
                f = f5;
                f3 = f6;
            }
        }
        return m6278a(f, f3, motionEvent);
    }

    /* renamed from: b */
    public boolean m6306b(MotionEvent motionEvent) throws Resources.NotFoundException {
        float f;
        float f2;
        PointF pointF = new PointF();
        pointF.set(m6286d(motionEvent.getX(), motionEvent.getY()));
        float f3 = pointF.x;
        float f4 = pointF.y;
        this.f6678ay = 102;
        if (this.f6633L != 1) {
            if (f3 < 0.0f) {
                f3 = 0.0f;
            }
            f = f4 >= 0.0f ? f4 : 0.0f;
            f2 = f3 > ((float) this.f6631J) ? this.f6631J - 1 : f3;
            if (f > this.f6632K) {
                f = this.f6632K - 1;
            }
        } else {
            if (f3 < 0.0f || f4 < 0.0f || f3 > this.f6631J || f4 > this.f6632K) {
                if (!this.f6675av) {
                    this.f6675av = true;
                    if (f3 < 0.0f) {
                        f3 = 0.0f;
                    }
                    f = f4 >= 0.0f ? f4 : 0.0f;
                    float f5 = f3 > ((float) this.f6631J) ? this.f6631J - 1 : f3;
                    if (f > this.f6632K) {
                        f = this.f6632K - 1;
                    }
                    m6282b(f5, f, motionEvent);
                    return m6279a(f5, f, false);
                }
                this.f6676aw = f3;
                this.f6677ax = f4;
                return true;
            }
            if (this.f6675av) {
                this.f6675av = false;
                float f6 = this.f6676aw;
                float f7 = this.f6677ax;
                if (f6 < 0.0f) {
                    f6 = 0.0f;
                }
                f = f7 >= 0.0f ? f7 : 0.0f;
                f2 = f6 > ((float) this.f6631J) ? this.f6631J - 1 : f6;
                if (f > this.f6632K) {
                    f = this.f6632K - 1;
                }
                m6278a(f2, f, motionEvent);
            } else {
                f = f4;
                f2 = f3;
            }
        }
        return m6282b(f2, f, motionEvent);
    }

    /* renamed from: c */
    public boolean m6309c(MotionEvent motionEvent) {
        float f;
        PointF pointF = new PointF();
        pointF.set(m6286d(motionEvent.getX(), motionEvent.getY()));
        float f2 = pointF.x;
        float f3 = pointF.y;
        this.f6678ay = 103;
        if (this.f6633L != 1) {
            if (f2 < 0.0f) {
                f2 = 0.0f;
            }
            float f4 = f3 >= 0.0f ? f3 : 0.0f;
            float f5 = f2 > ((float) this.f6631J) ? this.f6631J - 1 : f2;
            if (f4 > this.f6632K) {
                f = f5;
                f3 = this.f6632K - 1;
            } else {
                float f6 = f4;
                f = f5;
                f3 = f6;
            }
        } else {
            if (f2 < 0.0f || f3 < 0.0f || f2 > this.f6631J || f3 > this.f6632K) {
                return true;
            }
            f = f2;
        }
        return m6279a(f, f3, true);
    }

    /* renamed from: a */
    private boolean m6278a(float f, float f2, MotionEvent motionEvent) throws Resources.NotFoundException {
        int m_cStyle;
        if (m6294a(f, f2)) {
            return true;
        }
        if (m6288e(motionEvent)) {
            this.f6644W = true;
            setEditMode(false, false);
            m6284b(1, 4, this.f6635N, this.f6645Z);
            this.f6639R = new C2071u(4, this.f6635N, this.f6645Z);
            this.f6639R.m7205a(this.f6628G, this.f6629H, this.f6630I);
            this.f6639R.m7200a(this.f6641T, this.f6642U);
            this.f6639R.m7224b(this.f6643V);
            this.f6639R.mo7194a(this.f6638Q);
            return this.f6639R.mo7235d(f, f2);
        }
        if (this.f6640S != null && this.f6640S.mo7233c(f, f2)) {
            return this.f6640S.mo7235d(f, f2);
        }
        AMS_SELECT_OBJECT ams_select_object = new AMS_SELECT_OBJECT();
        if (!this.f6628G.VipAMS_SelectObject(this.f6629H, (int) f, (int) f2, ams_select_object, this.f6633L)) {
            if (this.f6633L == 3 && this.f6634M == -1) {
                return false;
            }
            this.f6639R.m7200a(this.f6641T, this.f6642U);
            boolean z = this.f6654aa;
            setEditMode(false, false);
            if (z) {
                this.f6639R.m7226b(false);
            }
            if (this.f6650aE != null) {
                this.f6650aE.mo6666a(2, 0, 0, 0, 0);
            }
            if (this.f6633L == 1 && this.f6634M == 0 && m6289f(motionEvent)) {
                C2068r c2068r = this.f6639R;
                float pressure = motionEvent.getPressure();
                this.f6639R.getClass();
                c2068r.m7222b(pressure * 4096.0f);
            } else {
                this.f6639R.m7222b(-1.0f);
            }
            if (this.f6633L == 2) {
                this.f6674au.mo6665a(false);
            }
            return this.f6639R.mo7235d(f, f2);
        }
        setEditMode(true, false);
        this.f6655ab = ams_select_object;
        AMS_OBJECT_DATA ams_object_data = new AMS_OBJECT_DATA();
        this.f6628G.VipAMS_GetSelectObjectData(this.f6655ab.getM_pSelectObjectData(), ams_object_data);
        int m_eType = ams_object_data.getM_eType();
        if (m_eType == 3) {
            m_cStyle = ams_object_data.getM_cAdditionalID();
        } else {
            m_cStyle = ams_object_data.getM_cStyle();
        }
        byte m_cSize = ams_object_data.getM_cSize();
        int iRgb = Color.rgb(ams_object_data.getM_nColorR(), ams_object_data.getM_nColorG(), ams_object_data.getM_nColorB());
        if (!m6284b(m_eType, m_cStyle, iRgb, m_cSize)) {
            return false;
        }
        if (this.f6650aE != null) {
            if (ams_object_data.getM_eType() == 3 && ams_object_data.getM_cStyle() == 2) {
                this.f6650aE.mo6666a(1, 3, -1, this.f6635N, this.f6637P);
            } else {
                this.f6650aE.mo6666a(1, m_eType, m_cStyle, iRgb, m_cSize);
            }
        }
        m6300a(this.f6655ab);
        Drawable drawable = this.f6627F.getResources().getDrawable(R.drawable.ams_ics_selector_image_crop_cancel);
        Drawable drawable2 = this.f6627F.getResources().getDrawable(R.drawable.ams_ics_selector_image_crop_01);
        Drawable drawable3 = this.f6627F.getResources().getDrawable(R.drawable.ams_ics_selector_image_crop_01);
        Drawable drawable4 = this.f6627F.getResources().getDrawable(R.drawable.ams_ics_selector_image_crop_02);
        Drawable drawable5 = this.f6627F.getResources().getDrawable(R.drawable.ams_ics_selector_image_crop_h);
        Drawable drawable6 = this.f6627F.getResources().getDrawable(R.drawable.ams_ics_selector_image_crop_w);
        Drawable drawable7 = this.f6627F.getResources().getDrawable(R.drawable.ams_ics_selector_image_crop_h);
        Drawable drawable8 = this.f6627F.getResources().getDrawable(R.drawable.ams_ics_selector_image_crop_w);
        if (this.f6640S != null) {
            this.f6640S.mo7229c();
            this.f6640S = null;
        }
        switch (this.f6633L) {
            case 2:
                C2074x c2074x = new C2074x(m_cStyle, iRgb, m_cSize, true, this.f6631J, this.f6632K);
                c2074x.m7247a(this.f6673at);
                c2074x.m7226b(false);
                this.f6640S = c2074x;
                this.f6640S.m7202a(this.f6627F.getResources().getDrawable(R.drawable.co_emoti_selected_02));
                this.f6640S.m7204a(drawable5, drawable6, drawable7, drawable8);
                this.f6640S.m7225b(drawable);
                this.f6640S.m7207a(this.f6651aF);
                this.f6640S.m7197a(5);
                this.f6674au.mo6665a(true);
                break;
            case 3:
                if (ams_object_data.getM_cStyle() == 0) {
                    this.f6640S = new C2073w(m_cStyle, iRgb, m_cSize, false);
                } else {
                    this.f6640S = new C2073w(-1, this.f6635N, this.f6637P, Bitmap.createBitmap(this.f6628G.VipAMS_GetObjectImageBuf(this.f6629H, ams_object_data), AMSLibs.g_nCurObjectImageWidth, AMSLibs.g_nCurObjectImageHeight, Bitmap.Config.ARGB_8888), false);
                }
                this.f6640S.m7202a(this.f6627F.getResources().getDrawable(R.drawable.co_emoti_selected_02));
                this.f6640S.m7225b(drawable);
                this.f6640S.m7207a(this.f6651aF);
                this.f6640S.m7197a(5);
                break;
            case 4:
                this.f6640S = new C2070t(m_cStyle, iRgb, m_cSize, false);
                Drawable drawable9 = this.f6627F.getResources().getDrawable(R.drawable.co_emoti_selected_02);
                this.f6640S.m7231c(getContext().getResources().getDrawable(R.drawable.more_option_icon_help));
                this.f6640S.m7202a(drawable9);
                this.f6640S.m7203a(drawable2, drawable3, drawable4);
                this.f6640S.m7225b(drawable);
                this.f6640S.m7207a(this.f6651aF);
                this.f6640S.m7197a(5);
                break;
            default:
                this.f6640S = new C2073w(0, iRgb, m_cSize, true);
                this.f6640S.m7202a(this.f6627F.getResources().getDrawable(R.drawable.memo_bg_focus_02));
                this.f6640S.m7203a(drawable2, drawable3, drawable4);
                this.f6640S.m7225b(drawable);
                this.f6640S.m7207a(this.f6651aF);
                this.f6640S.m7197a(5);
                break;
        }
        this.f6640S.m7205a(this.f6628G, this.f6629H, this.f6630I);
        this.f6640S.m7206a(this.f6655ab);
        this.f6640S.m7224b(this.f6643V);
        this.f6640S.mo7194a(this.f6638Q);
        this.f6640S.m7208a(true);
        this.f6640S.m7200a(this.f6641T, this.f6642U);
        return this.f6640S.mo7235d(f, f2);
    }

    /* renamed from: b */
    private boolean m6282b(float f, float f2, MotionEvent motionEvent) {
        if (m6305b(f, f2)) {
            return true;
        }
        if (!this.f6654aa) {
            if (this.f6633L == 1 && this.f6634M == 0 && m6289f(motionEvent)) {
                C2068r c2068r = this.f6639R;
                float pressure = motionEvent.getPressure();
                this.f6639R.getClass();
                c2068r.m7222b(pressure * 4096.0f);
            } else {
                this.f6639R.m7222b(-1.0f);
            }
            return this.f6639R.mo7237e(f, f2);
        }
        if (this.f6640S == null) {
            return false;
        }
        if (this.f6650aE != null) {
            getLocationOnScreen(new int[2]);
            this.f6650aE.mo6666a(3, (int) (r5[0] + f), (int) (r5[1] + f2), 0, 0);
        }
        return this.f6640S.mo7237e(f, f2);
    }

    /* renamed from: a */
    private boolean m6279a(float f, float f2, boolean z) {
        if (m6308c(f, f2)) {
            return true;
        }
        if (!this.f6654aa) {
            this.f6639R.mo7232c(z);
            boolean zMo7239f = this.f6639R.mo7239f(f, f2);
            if (this.f6650aE != null) {
                this.f6650aE.mo6666a(0, 0, 0, 0, 0);
            }
            if (this.f6644W) {
                this.f6644W = false;
                m6296a(this.f6633L, this.f6634M, this.f6635N, this.f6637P);
            }
            return zMo7239f;
        }
        if (this.f6640S == null) {
            return false;
        }
        if (this.f6650aE != null) {
            getLocationOnScreen(new int[2]);
            this.f6650aE.mo6666a(4, (int) (r5[0] + f), (int) (r5[1] + f2), 0, 0);
        }
        this.f6640S.mo7232c(z);
        return this.f6640S.mo7239f(f, f2);
    }

    /* renamed from: f */
    public Bitmap m6313f() {
        return this.f6641T;
    }

    /* renamed from: F */
    private boolean m6269F() {
        Canvas canvas = new Canvas(this.f6641T);
        if (this.f6643V != null) {
            canvas.drawBitmap(this.f6643V, new Rect(0, 0, this.f6643V.getWidth(), this.f6643V.getHeight()), new Rect(0, 0, this.f6641T.getWidth(), this.f6641T.getHeight()), (Paint) null);
            return true;
        }
        canvas.drawColor(this.f6636O);
        return true;
    }

    /* renamed from: G */
    private boolean m6270G() {
        switch (this.f6628G.VipAMS_GetBackgroundStyle(this.f6629H)) {
            case 0:
                int iVipAMS_GetBackgroundColorR = this.f6628G.VipAMS_GetBackgroundColorR(this.f6629H);
                int iVipAMS_GetBackgroundColorG = this.f6628G.VipAMS_GetBackgroundColorG(this.f6629H);
                int iVipAMS_GetBackgroundColorB = this.f6628G.VipAMS_GetBackgroundColorB(this.f6629H);
                this.f6636O = Color.rgb(iVipAMS_GetBackgroundColorR, iVipAMS_GetBackgroundColorG, iVipAMS_GetBackgroundColorB);
                m6297a(iVipAMS_GetBackgroundColorR, iVipAMS_GetBackgroundColorG, iVipAMS_GetBackgroundColorB, false);
                break;
            case 2:
                m6276a(this.f6628G.VipAMS_GetBackgroundIndex(this.f6629H));
                break;
            case 4:
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(this.f6628G.VipAMS_GetCurrentBackgroundBuf(this.f6629H), AMSLibs.g_nCurrentBackgroundWidth, AMSLibs.g_nCurrentBackgroundHeight, Bitmap.Config.ARGB_8888);
                m6298a(bitmapCreateBitmap, false);
                bitmapCreateBitmap.recycle();
                break;
        }
        return true;
    }

    /* renamed from: g */
    public boolean m6314g() {
        return m6300a((AMS_SELECT_OBJECT) null);
    }

    /* renamed from: a */
    public boolean m6300a(AMS_SELECT_OBJECT ams_select_object) {
        float m_pnAMSPointPressure;
        m6270G();
        m6269F();
        AMS_OBJECT_DATA ams_object_data = new AMS_OBJECT_DATA();
        int iVipAMS_GetNextDrawingData = this.f6628G.VipAMS_GetNextDrawingData(this.f6629H, 0, ams_object_data);
        C2068r c2074x = null;
        while (iVipAMS_GetNextDrawingData != 0) {
            if (ams_select_object != null && iVipAMS_GetNextDrawingData == ams_select_object.getM_pSelectObjectNode()) {
                iVipAMS_GetNextDrawingData = this.f6628G.VipAMS_GetNextDrawingData(this.f6629H, iVipAMS_GetNextDrawingData, ams_object_data);
            } else {
                switch (ams_object_data.getM_eType()) {
                    case 1:
                        c2074x = new C2071u(ams_object_data.getM_cStyle(), Color.rgb(ams_object_data.getM_nColorR(), ams_object_data.getM_nColorG(), ams_object_data.getM_nColorB()), ams_object_data.getM_cSize());
                        if (ams_object_data.getM_cStyle() != 4) {
                            c2074x.m7199a(this.f6641T);
                        } else {
                            c2074x.m7200a(this.f6641T, this.f6642U);
                        }
                        c2074x.m7224b(this.f6643V);
                        c2074x.mo7194a(this.f6638Q);
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
                                c2074x.mo7195a(m_pnAMSPointX, m_pnAMSPointY);
                            } else if (i < ams_object_data.getM_TPoint().getM_nPointNum() - 1) {
                                c2074x.mo7215a(m_pnAMSPointX, m_pnAMSPointY, 0, m_pnAMSPointPressure, false);
                            }
                            if (i == ams_object_data.getM_TPoint().getM_nPointNum() - 1) {
                                c2074x.mo7223b(m_pnAMSPointX, m_pnAMSPointY);
                            }
                        }
                        break;
                    case 2:
                        c2074x = new C2074x(ams_object_data.getM_cStyle(), Color.rgb(ams_object_data.getM_nColorR(), ams_object_data.getM_nColorG(), ams_object_data.getM_nColorB()), ams_object_data.getM_cSize(), true, this.f6631J, this.f6632K);
                        AMS_RECT m_TRect = ams_object_data.getM_TRect();
                        c2074x.m7199a(this.f6641T);
                        c2074x.m7224b(this.f6643V);
                        c2074x.mo7194a(this.f6638Q);
                        c2074x.mo7212a(m_TRect.nLeft, m_TRect.nTop, m_TRect.nRight, m_TRect.nBottom, ams_object_data.getM_TText().getM_strText(), MotionEventCompat.ACTION_MASK, false);
                        break;
                    case 3:
                        if (ams_object_data.getM_cStyle() == 0) {
                            c2074x = new C2073w(ams_object_data.getM_cAdditionalID(), Color.rgb(ams_object_data.getM_nColorR(), ams_object_data.getM_nColorG(), ams_object_data.getM_nColorB()), ams_object_data.getM_cSize(), false);
                        } else if (ams_object_data.getM_cStyle() == 2) {
                            c2074x = new C2073w(-1, Color.rgb(ams_object_data.getM_nColorR(), ams_object_data.getM_nColorG(), ams_object_data.getM_nColorB()), ams_object_data.getM_cSize(), Bitmap.createBitmap(this.f6628G.VipAMS_GetObjectImageBuf(this.f6629H, ams_object_data), AMSLibs.g_nCurObjectImageWidth, AMSLibs.g_nCurObjectImageHeight, Bitmap.Config.ARGB_8888), false);
                        } else {
                            c2074x = new C2073w(0, Color.rgb(ams_object_data.getM_nColorR(), ams_object_data.getM_nColorG(), ams_object_data.getM_nColorB()), ams_object_data.getM_cSize(), false);
                        }
                        AMS_RECT m_TRect2 = ams_object_data.getM_TRect();
                        c2074x.m7199a(this.f6641T);
                        c2074x.m7224b(this.f6643V);
                        c2074x.mo7194a(this.f6638Q);
                        c2074x.mo7220a(new RectF(m_TRect2.nLeft, m_TRect2.nTop, m_TRect2.nRight, m_TRect2.nBottom), MotionEventCompat.ACTION_MASK, false);
                        break;
                    case 4:
                        c2074x = new C2070t(ams_object_data.getM_cStyle(), Color.rgb(ams_object_data.getM_nColorR(), ams_object_data.getM_nColorG(), ams_object_data.getM_nColorB()), ams_object_data.getM_cSize(), false);
                        AMS_RECT m_TRect3 = ams_object_data.getM_TRect();
                        c2074x.m7231c(getContext().getResources().getDrawable(R.drawable.more_option_icon_help));
                        c2074x.m7199a(this.f6641T);
                        c2074x.m7224b(this.f6643V);
                        c2074x.mo7194a(this.f6638Q);
                        c2074x.mo7210a(m_TRect3.nLeft, m_TRect3.nTop, m_TRect3.nRight, m_TRect3.nBottom, MotionEventCompat.ACTION_MASK, false);
                        break;
                }
                iVipAMS_GetNextDrawingData = this.f6628G.VipAMS_GetNextDrawingData(this.f6629H, iVipAMS_GetNextDrawingData, ams_object_data);
            }
        }
        if (c2074x != null) {
            c2074x.mo7229c();
        }
        int iVipAMS_GetErrorCode = this.f6628G.VipAMS_GetErrorCode(this.f6629H);
        if (iVipAMS_GetErrorCode == 0) {
            return true;
        }
        C1786r.m6054a(" Error Code =" + iVipAMS_GetErrorCode + ", Line : " + new Exception().getStackTrace()[0].getLineNumber(), getClass().getSimpleName());
        return false;
    }

    /* renamed from: a */
    public boolean m6302a(String str, int i, int i2) throws Resources.NotFoundException {
        int i3;
        int i4;
        if (this.f6633L != 2) {
            return false;
        }
        this.f6635N = i;
        this.f6637P = i2;
        if (this.f6654aa) {
            C2074x c2074x = (C2074x) this.f6640S;
            c2074x.mo7218a(this.f6634M, this.f6635N, this.f6637P);
            c2074x.m7249a(str);
        } else {
            C2074x c2074x2 = (C2074x) this.f6639R;
            m6284b(this.f6633L, this.f6634M, this.f6635N, this.f6637P);
            int i5 = this.f6631J / 2;
            int i6 = this.f6632K / 2;
            if (this.f6647aB) {
                this.f6647aB = false;
                m6332y();
                int i7 = (int) this.f6648aC.x;
                int i8 = (int) this.f6648aC.y;
                c2074x2.m7252a(str, this.f6635N, this.f6637P, i7, i8);
                i4 = i8;
                i3 = i7;
            } else {
                c2074x2.m7251a(str, this.f6635N, this.f6637P);
                int[] iArr = new int[2];
                c2074x2.m7253a(iArr);
                i3 = iArr[0];
                i4 = iArr[1];
            }
            m6283b(i3, i4);
        }
        if (this.f6650aE != null) {
            this.f6650aE.mo6666a(0, 0, 0, 0, 0);
        }
        m6329v();
        return true;
    }

    /* renamed from: b */
    private boolean m6283b(int i, int i2) throws Resources.NotFoundException {
        int m_cStyle;
        AMS_SELECT_OBJECT ams_select_object = new AMS_SELECT_OBJECT();
        if (!this.f6628G.VipAMS_SelectObject(this.f6629H, i, i2, ams_select_object, this.f6633L)) {
            return false;
        }
        setEditMode(true, false);
        this.f6655ab = ams_select_object;
        AMS_OBJECT_DATA ams_object_data = new AMS_OBJECT_DATA();
        this.f6628G.VipAMS_GetSelectObjectData(this.f6655ab.getM_pSelectObjectData(), ams_object_data);
        int m_eType = ams_object_data.getM_eType();
        if (m_eType == 3) {
            m_cStyle = ams_object_data.getM_cAdditionalID();
        } else {
            m_cStyle = ams_object_data.getM_cStyle();
        }
        byte m_cSize = ams_object_data.getM_cSize();
        int iRgb = Color.rgb(ams_object_data.getM_nColorR(), ams_object_data.getM_nColorG(), ams_object_data.getM_nColorB());
        if (!m6284b(m_eType, m_cStyle, iRgb, m_cSize)) {
            return false;
        }
        if (this.f6650aE != null) {
            if (ams_object_data.getM_eType() == 3 && ams_object_data.getM_cStyle() == 2) {
                this.f6650aE.mo6666a(1, 3, -1, this.f6635N, this.f6637P);
            } else {
                this.f6650aE.mo6666a(1, m_eType, m_cStyle, iRgb, m_cSize);
            }
        }
        m6300a(this.f6655ab);
        Drawable drawable = this.f6627F.getResources().getDrawable(R.drawable.ams_ics_selector_image_crop_cancel);
        Drawable drawable2 = this.f6627F.getResources().getDrawable(R.drawable.ams_ics_selector_image_crop_h);
        Drawable drawable3 = this.f6627F.getResources().getDrawable(R.drawable.ams_ics_selector_image_crop_w);
        Drawable drawable4 = this.f6627F.getResources().getDrawable(R.drawable.ams_ics_selector_image_crop_h);
        Drawable drawable5 = this.f6627F.getResources().getDrawable(R.drawable.ams_ics_selector_image_crop_w);
        if (this.f6640S != null) {
            this.f6640S.mo7229c();
            this.f6640S = null;
        }
        switch (this.f6633L) {
            case 2:
                C2074x c2074x = new C2074x(m_cStyle, iRgb, m_cSize, true, this.f6631J, this.f6632K);
                c2074x.m7247a(this.f6673at);
                c2074x.m7226b(true);
                this.f6640S = c2074x;
                this.f6640S.m7202a(this.f6627F.getResources().getDrawable(R.drawable.co_emoti_selected_02));
                this.f6640S.m7204a(drawable2, drawable3, drawable4, drawable5);
                this.f6640S.m7225b(drawable);
                this.f6640S.m7207a(this.f6651aF);
                this.f6640S.m7197a(5);
                break;
            case 3:
                if (ams_object_data.getM_cStyle() == 0) {
                    this.f6640S = new C2073w(m_cStyle, iRgb, m_cSize, false);
                } else {
                    this.f6640S = new C2073w(-1, this.f6635N, this.f6637P, Bitmap.createBitmap(this.f6628G.VipAMS_GetObjectImageBuf(this.f6629H, ams_object_data), AMSLibs.g_nCurObjectImageWidth, AMSLibs.g_nCurObjectImageHeight, Bitmap.Config.ARGB_8888), false);
                }
                this.f6640S.m7226b(true);
                this.f6640S.m7202a(this.f6627F.getResources().getDrawable(R.drawable.co_emoti_selected_02));
                this.f6640S.m7225b(drawable);
                this.f6640S.m7207a(this.f6651aF);
                this.f6640S.m7197a(5);
                ((C2073w) this.f6640S).m7245d(true);
                break;
        }
        this.f6640S.m7205a(this.f6628G, this.f6629H, this.f6630I);
        this.f6640S.m7206a(this.f6655ab);
        this.f6640S.m7224b(this.f6643V);
        this.f6640S.mo7194a(this.f6638Q);
        this.f6640S.m7208a(true);
        this.f6640S.m7200a(this.f6641T, this.f6642U);
        AMS_OBJECT_DATA ams_object_data2 = new AMS_OBJECT_DATA();
        this.f6628G.VipAMS_GetSelectObjectData(this.f6655ab.getM_pSelectObjectData(), ams_object_data2);
        if (this.f6633L == 3) {
            return this.f6640S.mo7219a(new RectF(ams_object_data2.getM_TRect().nLeft, ams_object_data2.getM_TRect().nTop, ams_object_data2.getM_TRect().nRight, ams_object_data2.getM_TRect().nBottom), MotionEventCompat.ACTION_MASK);
        }
        return this.f6640S.mo7211a(ams_object_data2.getM_TRect().nLeft, ams_object_data2.getM_TRect().nTop, ams_object_data2.getM_TRect().nRight, ams_object_data2.getM_TRect().nBottom, new String(ams_object_data2.getM_TText().getM_cText()), MotionEventCompat.ACTION_MASK);
    }

    /* renamed from: h */
    public boolean m6315h() {
        this.f6628G.VipAMS_SetCurrentFrame(this.f6629H, (byte) 0);
        m6270G();
        m6269F();
        this.f6660ag = new AMS_OBJECT_DATA();
        this.f6658ae = 0;
        this.f6662ai = false;
        this.f6661ah = 0;
        this.f6663aj = false;
        this.f6665al = 0;
        return true;
    }

    /* renamed from: i */
    public boolean m6316i() {
        float m_pnAMSPointPressure;
        if (this.f6663aj) {
            return true;
        }
        if (!this.f6662ai) {
            this.f6661ah = 0;
            this.f6658ae = this.f6628G.VipAMS_GetNextDrawingData(this.f6629H, this.f6658ae, this.f6660ag);
            while (this.f6658ae == 0) {
                if (!this.f6628G.VipAMS_SetNextFrame(this.f6629H)) {
                    return false;
                }
                m6269F();
                m6292a(false);
                this.f6658ae = this.f6628G.VipAMS_GetNextDrawingData(this.f6629H, this.f6658ae, this.f6660ag);
            }
            this.f6662ai = true;
        }
        this.f6663aj = true;
        if (this.f6661ah == 0 && this.f6659af != null) {
            this.f6659af.mo7229c();
            this.f6659af = null;
        }
        switch (this.f6660ag.getM_eType()) {
            case 1:
                if (this.f6661ah == 0) {
                    this.f6659af = new C2071u(this.f6660ag.getM_cStyle(), Color.rgb(this.f6660ag.getM_nColorR(), this.f6660ag.getM_nColorG(), this.f6660ag.getM_nColorB()), this.f6660ag.getM_cSize());
                    this.f6659af.m7200a(this.f6641T, this.f6642U);
                    this.f6659af.m7224b(this.f6643V);
                    this.f6659af.mo7194a(this.f6638Q);
                }
                float m_pnAMSPointX = this.f6660ag.getM_TPoint().getM_pnAMSPointX(this.f6661ah);
                float m_pnAMSPointY = this.f6660ag.getM_TPoint().getM_pnAMSPointY(this.f6661ah);
                if (this.f6660ag.getM_TPoint().getM_bPressureFlag()) {
                    m_pnAMSPointPressure = this.f6660ag.getM_TPoint().getM_pnAMSPointPressure(this.f6661ah);
                } else {
                    m_pnAMSPointPressure = -1.0f;
                }
                if (this.f6661ah == 0) {
                    this.f6659af.mo7195a(m_pnAMSPointX, m_pnAMSPointY);
                    m6273J();
                } else if (this.f6661ah < this.f6660ag.getM_TPoint().getM_nPointNum()) {
                    this.f6659af.mo7214a(m_pnAMSPointX, m_pnAMSPointY, MotionEventCompat.ACTION_MASK, m_pnAMSPointPressure);
                }
                if (this.f6661ah == this.f6660ag.getM_TPoint().getM_nPointNum() - 1) {
                    this.f6659af.mo7223b(m_pnAMSPointX, m_pnAMSPointY);
                    this.f6662ai = false;
                }
                this.f6661ah++;
                this.f6665al++;
                m6277a(m6287e(m_pnAMSPointX, m_pnAMSPointY));
                break;
            case 2:
                if (this.f6661ah == 0) {
                    this.f6659af = new C2074x(this.f6660ag.getM_cStyle(), Color.rgb(this.f6660ag.getM_nColorR(), this.f6660ag.getM_nColorG(), this.f6660ag.getM_nColorB()), this.f6660ag.getM_cSize(), true, this.f6631J, this.f6632K);
                    this.f6659af.m7200a(this.f6641T, this.f6642U);
                    this.f6659af.m7224b(this.f6643V);
                    this.f6659af.mo7194a(this.f6638Q);
                }
                AMS_RECT m_TRect = this.f6660ag.getM_TRect();
                this.f6661ah++;
                this.f6665al++;
                if (this.f6661ah < 32) {
                    this.f6659af.mo7211a(m_TRect.nLeft, m_TRect.nTop, m_TRect.nRight, m_TRect.nBottom, this.f6660ag.getM_TText().getM_strText(), (int) ((this.f6661ah / 2) * (this.f6661ah / 2)));
                } else {
                    this.f6659af.mo7211a(m_TRect.nLeft, m_TRect.nTop, m_TRect.nRight, m_TRect.nBottom, this.f6660ag.getM_TText().getM_strText(), MotionEventCompat.ACTION_MASK);
                    this.f6662ai = false;
                }
                m6277a(m_TRect);
                break;
            case 3:
                int m_cAdditionalID = this.f6660ag.getM_cAdditionalID();
                if (this.f6661ah == 0) {
                    if (this.f6660ag.getM_cStyle() == 0) {
                        this.f6659af = new C2073w(m_cAdditionalID, Color.rgb(this.f6660ag.getM_nColorR(), this.f6660ag.getM_nColorG(), this.f6660ag.getM_nColorB()), this.f6660ag.getM_cSize(), false);
                    } else if (this.f6660ag.getM_cStyle() == 2) {
                        this.f6659af = new C2073w(-1, Color.rgb(this.f6660ag.getM_nColorR(), this.f6660ag.getM_nColorG(), this.f6660ag.getM_nColorB()), this.f6660ag.getM_cSize(), Bitmap.createBitmap(this.f6628G.VipAMS_GetObjectImageBuf(this.f6629H, this.f6660ag), AMSLibs.g_nCurObjectImageWidth, AMSLibs.g_nCurObjectImageHeight, Bitmap.Config.ARGB_8888), false);
                    } else {
                        this.f6659af = new C2073w(0, Color.rgb(this.f6660ag.getM_nColorR(), this.f6660ag.getM_nColorG(), this.f6660ag.getM_nColorB()), this.f6660ag.getM_cSize(), false);
                    }
                    this.f6659af.m7200a(this.f6641T, this.f6642U);
                    this.f6659af.m7224b(this.f6643V);
                    this.f6659af.mo7194a(this.f6638Q);
                }
                AMS_RECT m_TRect2 = this.f6660ag.getM_TRect();
                RectF rectF = new RectF(m_TRect2.nLeft, m_TRect2.nTop, m_TRect2.nRight, m_TRect2.nBottom);
                this.f6661ah++;
                this.f6665al++;
                if (this.f6660ag.getM_cStyle() == 0) {
                    if (m_cAdditionalID < C1849ai.m6394a().m6410f()) {
                        if (this.f6661ah < 32) {
                            this.f6659af.mo7219a(rectF, (int) ((this.f6661ah / 2) * (this.f6661ah / 2)));
                        } else {
                            this.f6659af.mo7219a(rectF, MotionEventCompat.ACTION_MASK);
                            this.f6662ai = false;
                        }
                    } else if (m_cAdditionalID < C1849ai.m6394a().m6410f() + C1849ai.m6394a().m6407d()) {
                        if (this.f6661ah < 32) {
                            this.f6659af.mo7219a(rectF, (this.f6661ah / 2) + 1000);
                        } else {
                            this.f6659af.mo7219a(rectF, MotionEventCompat.ACTION_MASK);
                            this.f6662ai = false;
                        }
                    } else if (this.f6661ah < 32) {
                        this.f6659af.mo7219a(rectF, (int) ((this.f6661ah / 2) * (this.f6661ah / 2)));
                    } else {
                        this.f6659af.mo7219a(rectF, MotionEventCompat.ACTION_MASK);
                        this.f6662ai = false;
                    }
                } else if (this.f6660ag.getM_cStyle() == 2) {
                    if (this.f6661ah < 32) {
                        this.f6659af.mo7219a(rectF, (int) ((this.f6661ah / 2) * (this.f6661ah / 2)));
                    } else {
                        this.f6659af.mo7219a(rectF, MotionEventCompat.ACTION_MASK);
                        this.f6662ai = false;
                    }
                } else if (this.f6661ah < 32) {
                    this.f6659af.mo7219a(rectF, (int) ((this.f6661ah / 2) * (this.f6661ah / 2)));
                } else {
                    this.f6659af.mo7219a(rectF, MotionEventCompat.ACTION_MASK);
                    this.f6662ai = false;
                }
                m6277a(m_TRect2);
                break;
            case 4:
                if (this.f6661ah == 0) {
                    this.f6659af = new C2070t(this.f6660ag.getM_cStyle(), Color.rgb(this.f6660ag.getM_nColorR(), this.f6660ag.getM_nColorG(), this.f6660ag.getM_nColorB()), this.f6660ag.getM_cSize(), false);
                    this.f6659af.m7231c(getContext().getResources().getDrawable(R.drawable.more_option_icon_help));
                    this.f6659af.m7200a(this.f6641T, this.f6642U);
                    this.f6659af.m7224b(this.f6643V);
                    this.f6659af.mo7194a(this.f6638Q);
                }
                AMS_RECT m_TRect3 = this.f6660ag.getM_TRect();
                this.f6661ah++;
                this.f6665al++;
                if (this.f6661ah < 32) {
                    this.f6659af.mo7209a(m_TRect3.nLeft, m_TRect3.nTop, m_TRect3.nRight, m_TRect3.nBottom, (int) ((this.f6661ah / 2) * (this.f6661ah / 2)));
                } else {
                    this.f6659af.mo7209a(m_TRect3.nLeft, m_TRect3.nTop, m_TRect3.nRight, m_TRect3.nBottom, MotionEventCompat.ACTION_MASK);
                    this.f6662ai = false;
                }
                m6277a(m_TRect3);
                break;
        }
        this.f6663aj = false;
        return true;
    }

    /* renamed from: j */
    public boolean m6317j() {
        if (this.f6640S == null || !this.f6640S.m7227b()) {
            return false;
        }
        setEditMode(false, true);
        if (this.f6650aE != null) {
            this.f6650aE.mo6666a(0, 0, 0, 0, 0);
        }
        m6329v();
        return true;
    }

    /* renamed from: k */
    public boolean m6318k() {
        if (this.f6679az != null) {
            m6332y();
            return false;
        }
        if (this.f6628G == null || this.f6628G.VipAMS_Undo(this.f6629H) == 0) {
            return false;
        }
        setEditMode(false, true);
        if (this.f6650aE != null) {
            this.f6650aE.mo6666a(0, 0, 0, 0, 0);
        }
        m6329v();
        return true;
    }

    /* renamed from: l */
    public boolean m6319l() {
        if (this.f6628G == null || this.f6628G.VipAMS_Redo(this.f6629H) == 0) {
            return false;
        }
        setEditMode(false, true);
        if (this.f6650aE != null) {
            this.f6650aE.mo6666a(0, 0, 0, 0, 0);
        }
        m6329v();
        return true;
    }

    /* renamed from: a */
    public boolean m6301a(String str) {
        if (this.f6628G == null) {
            return false;
        }
        int[] iArr = new int[57600];
        m6322o();
        m6314g();
        m6292a(false);
        Bitmap.createScaledBitmap(this.f6641T, 240, 240, true).getPixels(iArr, 0, 240, 0, 0, 240, 240);
        this.f6628G.VipAMS_SetAMSImageBuf(this.f6629H, iArr, 240, 240);
        AMS_CODING_FILE_INFO[] ams_coding_file_infoArr = {new AMS_CODING_FILE_INFO()};
        ams_coding_file_infoArr[0].setM_eExportType(0);
        ams_coding_file_infoArr[0].setM_strFileName(str);
        if (this.f6628G.VipAMS_TotalSaveEncoding(this.f6629H, ams_coding_file_infoArr) != 0) {
            return true;
        }
        C1786r.m6054a("VipAMS_TotalSaveEncoding Error = " + this.f6628G.VipAMS_GetErrorCode(this.f6629H), getClass().getSimpleName());
        return false;
    }

    /* renamed from: b */
    public int m6304b(String str) {
        if (this.f6628G == null) {
            this.f6666am = false;
            return 4;
        }
        if (!this.f6628G.VipAMS_ClearEncoding(this.f6629H)) {
            this.f6666am = false;
            return 4;
        }
        AMS_CODING_FILE_INFO[] ams_coding_file_infoArr = {new AMS_CODING_FILE_INFO()};
        ams_coding_file_infoArr[0].setM_eExportType(0);
        ams_coding_file_infoArr[0].setM_strFileName(str);
        if (this.f6628G.VipAMS_TotalLoadEncodingFile(this.f6629H, ams_coding_file_infoArr, this.f6630I.m_rectRegion) == 0) {
            int iVipAMS_GetErrorCode = this.f6628G.VipAMS_GetErrorCode(this.f6629H);
            this.f6666am = false;
            switch (iVipAMS_GetErrorCode) {
                case 45:
                    break;
                case 46:
                case 47:
                case 48:
                default:
                    C1786r.m6054a("VipAMS_TotalLoadEncodingFile Error = " + iVipAMS_GetErrorCode, getClass().getSimpleName());
                    break;
                case 49:
                    break;
                case 50:
                    break;
            }
            return 4;
        }
        if (m6311d() || m6323p() > 1 || m6274K()) {
            this.f6666am = false;
        } else {
            this.f6666am = true;
        }
        this.f6664ak = m6271H();
        return 0;
    }

    /* renamed from: m */
    public int m6320m() {
        return this.f6664ak;
    }

    /* renamed from: n */
    public int m6321n() {
        return this.f6665al;
    }

    /* renamed from: H */
    private int m6271H() {
        AMS_OBJECT_DATA ams_object_data = new AMS_OBJECT_DATA();
        if (this.f6628G != null) {
            int iVipAMS_GetNextDrawingData = 0;
            int m_nPointNum = 0;
            while (true) {
                iVipAMS_GetNextDrawingData = this.f6628G.VipAMS_GetNextDrawingData(this.f6629H, iVipAMS_GetNextDrawingData, ams_object_data);
                while (iVipAMS_GetNextDrawingData == 0) {
                    if (!this.f6628G.VipAMS_SetNextFrame(this.f6629H)) {
                        return m_nPointNum;
                    }
                    iVipAMS_GetNextDrawingData = this.f6628G.VipAMS_GetNextDrawingData(this.f6629H, iVipAMS_GetNextDrawingData, ams_object_data);
                }
                switch (ams_object_data.getM_eType()) {
                    case 1:
                        m_nPointNum += ams_object_data.getM_TPoint().getM_nPointNum();
                        if (!this.f6666am || ams_object_data.getM_cStyle() != 4) {
                            break;
                        } else {
                            this.f6666am = false;
                            break;
                        }
                    case 2:
                        m_nPointNum += 32;
                        break;
                    case 3:
                        m_nPointNum += 32;
                        if (!this.f6666am || ams_object_data.getM_cStyle() != 0) {
                            break;
                        } else {
                            if (!C1849ai.m6394a().m6406c(ams_object_data.getM_cAdditionalID())) {
                                this.f6666am = false;
                                break;
                            } else {
                                break;
                            }
                        }
                        break;
                    case 4:
                        m_nPointNum += 32;
                        this.f6666am = false;
                        break;
                }
            }
        } else {
            return 0;
        }
    }

    /* renamed from: o */
    public void m6322o() {
        if (this.f6628G != null) {
            while (this.f6628G.VipAMS_SetNextFrame(this.f6629H)) {
            }
            setEditMode(false, false);
        }
    }

    public void setPage(int i) {
        if (this.f6628G != null) {
            this.f6628G.VipAMS_SetCurrentFrame(this.f6629H, (byte) i);
            setEditMode(false, false);
        }
    }

    /* renamed from: p */
    public int m6323p() {
        if (this.f6628G == null) {
            return -1;
        }
        return this.f6628G.VipAMS_GetLastFrame(this.f6629H);
    }

    /* renamed from: q */
    public boolean m6324q() {
        if (this.f6628G == null) {
            return false;
        }
        return this.f6628G.VipAMS_IsEnableUndo(this.f6629H);
    }

    /* renamed from: r */
    public boolean m6325r() {
        if (this.f6628G == null) {
            return false;
        }
        return this.f6628G.VipAMS_IsEnableRedo(this.f6629H);
    }

    /* renamed from: s */
    public boolean m6326s() {
        return this.f6628G != null && this.f6628G.VipAMS_IsEditEnable(this.f6629H) && this.f6666am;
    }

    /* renamed from: t */
    public boolean m6327t() {
        if (this.f6628G == null) {
            return false;
        }
        return this.f6628G.VipAMS_IsAnimationEnable(this.f6629H);
    }

    /* renamed from: u */
    public void m6328u() {
        this.f6627F = null;
        if (this.f6628G != null) {
            this.f6628G.VipAMS_Close(this.f6629H);
            this.f6628G = null;
        }
        if (this.f6641T != null) {
            this.f6641T.recycle();
            this.f6641T = null;
        }
        if (this.f6642U != null) {
            this.f6642U.recycle();
            this.f6642U = null;
        }
        if (this.f6643V != null) {
            this.f6643V.recycle();
            this.f6643V = null;
        }
        this.f6630I = null;
        this.f6639R = null;
        this.f6640S = null;
        this.f6655ab = null;
        this.f6659af = null;
        this.f6660ag = null;
        this.f6673at = null;
        System.gc();
    }

    /* renamed from: v */
    public void m6329v() {
        m6272I();
    }

    /* renamed from: a */
    public void m6292a(boolean z) {
        if (z) {
            m6329v();
        } else {
            invalidate();
        }
    }

    /* renamed from: I */
    private void m6272I() {
        if (this.f6659af == null) {
            invalidate();
        } else if (this.f6659af.m7234d() == null) {
            invalidate();
        } else {
            invalidate(this.f6659af.m7234d());
        }
    }

    /* renamed from: a */
    private void m6277a(AMS_RECT ams_rect) {
        this.f6659af.m7201a(new Rect((int) (ams_rect.nLeft - this.f6672as), (int) (ams_rect.nTop - this.f6672as), (int) (ams_rect.nRight + this.f6672as), (int) (ams_rect.nBottom + this.f6672as)));
    }

    /* renamed from: J */
    private void m6273J() {
        this.f6669ap = 0;
        this.f6670aq = new float[]{0.0f, 0.0f, 0.0f};
        this.f6671ar = new float[]{0.0f, 0.0f, 0.0f};
    }

    /* renamed from: e */
    private AMS_RECT m6287e(float f, float f2) {
        this.f6670aq[this.f6669ap] = f;
        this.f6671ar[this.f6669ap] = f2;
        this.f6669ap++;
        if (this.f6669ap > 2) {
            this.f6669ap = 0;
        }
        float fMax = Math.max(Math.max(this.f6670aq[0], this.f6670aq[1]), this.f6670aq[2]);
        float fMin = Math.min(Math.min(this.f6670aq[0], this.f6670aq[1]), this.f6670aq[2]);
        float fMax2 = Math.max(Math.max(this.f6671ar[0], this.f6671ar[1]), this.f6671ar[2]);
        float fMin2 = Math.min(Math.min(this.f6671ar[0], this.f6671ar[1]), this.f6671ar[2]);
        AMS_RECT ams_rect = new AMS_RECT();
        ams_rect.nLeft = (short) fMin;
        ams_rect.nTop = (short) fMin2;
        ams_rect.nRight = (short) fMax;
        ams_rect.nBottom = (short) fMax2;
        return ams_rect;
    }

    /* renamed from: c */
    public boolean m6310c(String str) {
        this.f6631J = 100;
        this.f6632K = 100;
        m6268E();
        m6304b(str);
        boolean zM6326s = m6326s();
        if (this.f6628G != null) {
            this.f6628G.VipAMS_Close(this.f6629H);
            this.f6628G = null;
        }
        return zM6326s;
    }

    /* renamed from: K */
    private boolean m6274K() {
        return this.f6628G.VipAMS_GetBackgroundStyle(this.f6629H) == 2;
    }

    /* renamed from: a */
    private void m6276a(int i) {
        if (i >= 0 && i <= 11) {
            switch (i) {
                case 0:
                    m6297a(MotionEventCompat.ACTION_MASK, MotionEventCompat.ACTION_MASK, MotionEventCompat.ACTION_MASK, false);
                    break;
                case 1:
                    m6297a(MotionEventCompat.ACTION_MASK, MotionEventCompat.ACTION_MASK, MotionEventCompat.ACTION_MASK, false);
                    break;
                case 2:
                    m6297a(MotionEventCompat.ACTION_MASK, MotionEventCompat.ACTION_MASK, MotionEventCompat.ACTION_MASK, false);
                    break;
                case 3:
                    m6297a(MotionEventCompat.ACTION_MASK, 249, 187, false);
                    break;
                case 4:
                    m6297a(207, 230, 244, false);
                    break;
                case 5:
                    m6297a(243, 207, 235, false);
                    break;
                case 6:
                    m6297a(252, 244, MotionEventCompat.ACTION_MASK, false);
                    break;
                case 7:
                    m6297a(MotionEventCompat.ACTION_MASK, 253, 238, false);
                    break;
                case 8:
                    m6297a(230, 247, MotionEventCompat.ACTION_MASK, false);
                    break;
                case 9:
                    m6297a(MotionEventCompat.ACTION_MASK, 250, 208, false);
                    break;
                case 10:
                    m6297a(229, 206, 157, false);
                    break;
                case 11:
                    m6297a(8, 49, 8, false);
                    break;
            }
        }
    }

    public void setOnTouchTextArea(InterfaceC2063m interfaceC2063m) {
        this.f6674au = interfaceC2063m;
    }

    /* renamed from: e */
    private boolean m6288e(MotionEvent motionEvent) {
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
    private boolean m6289f(MotionEvent motionEvent) {
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
    public void m6330w() {
        Rect rectM7242i;
        switch (this.f6678ay) {
            case MediaEntity.Size.CROP /* 101 */:
            case 102:
                m6314g();
                if ((this.f6633L == 3 || this.f6633L == 2) && this.f6654aa && this.f6640S != null && (rectM7242i = this.f6640S.m7242i()) != null) {
                    m6283b(rectM7242i.centerX(), rectM7242i.centerY());
                    break;
                }
                break;
        }
    }

    /* renamed from: x */
    public void m6331x() {
        this.f6649aD = this.f6642U.copy(Bitmap.Config.ARGB_8888, true);
        Drawable drawable = this.f6627F.getResources().getDrawable(R.drawable.ams_ics_selector_image_crop_cancel);
        this.f6679az = new C2076z(this.f6633L, this.f6635N, this.f6637P, false, this.f6631J, this.f6632K);
        this.f6679az.m7259a(this.f6653aH);
        this.f6679az.m7226b(true);
        this.f6679az.m7202a(this.f6627F.getResources().getDrawable(R.drawable.co_emoti_selected_02));
        this.f6679az.m7225b(drawable);
        this.f6679az.m7207a(this.f6651aF);
        this.f6679az.m7197a(5);
        this.f6674au.mo6665a(true);
        this.f6679az.m7224b(this.f6643V);
        this.f6679az.mo7194a(this.f6638Q);
        this.f6679az.m7208a(true);
        this.f6679az.m7200a(this.f6641T, this.f6649aD);
        if (this.f6633L == 2) {
            String string = this.f6627F.getResources().getString(R.string.ams_msg_enter_message);
            this.f6679az.m7264a(string, this.f6635N, this.f6637P, this.f6631J / 2, this.f6632K / 2);
            RectF rectF = new RectF(this.f6679az.f7458W);
            this.f6679az.mo7211a(rectF.left, rectF.top, rectF.right, rectF.bottom, string, MotionEventCompat.ACTION_MASK);
            m6329v();
        }
    }

    /* renamed from: a */
    public void m6291a(int i, int i2) {
        if (this.f6679az != null) {
            if (i != this.f6635N) {
                i = this.f6635N;
            }
            if (i2 != this.f6637P) {
                i2 = this.f6637P;
            }
            this.f6679az.mo7193a();
            this.f6679az.mo7218a(this.f6634M, i, i2);
            m6329v();
        }
    }

    /* renamed from: y */
    public void m6332y() {
        if (this.f6679az == null) {
            m6333z();
            return;
        }
        this.f6679az.mo7193a();
        m6329v();
        this.f6679az = null;
        m6333z();
    }

    /* renamed from: z */
    public void m6333z() {
        if (this.f6649aD != null) {
            this.f6649aD.recycle();
        }
        this.f6649aD = null;
    }

    /* renamed from: A */
    public boolean m6290A() {
        return this.f6679az != null;
    }

    /* renamed from: a */
    public boolean m6294a(float f, float f2) {
        if (this.f6679az == null) {
            return false;
        }
        this.f6646aA = false;
        if (this.f6679az.mo7233c(f, f2)) {
            this.f6646aA = true;
            return this.f6679az.mo7235d(f, f2);
        }
        if (!this.f6628G.VipAMS_SelectObject(this.f6629H, (int) f, (int) f2, new AMS_SELECT_OBJECT(), this.f6633L)) {
            return true;
        }
        m6332y();
        return false;
    }

    /* renamed from: b */
    public boolean m6305b(float f, float f2) {
        if (this.f6679az == null) {
            return false;
        }
        if (this.f6646aA) {
            return this.f6679az.mo7237e(f, f2);
        }
        return true;
    }

    /* renamed from: c */
    public boolean m6308c(float f, float f2) {
        if (this.f6679az == null) {
            return false;
        }
        this.f6648aC.set(f, f2);
        if (this.f6646aA) {
            return this.f6679az.mo7239f(f, f2);
        }
        this.f6653aH.mo7172a(null, f, f2);
        return true;
    }
}
