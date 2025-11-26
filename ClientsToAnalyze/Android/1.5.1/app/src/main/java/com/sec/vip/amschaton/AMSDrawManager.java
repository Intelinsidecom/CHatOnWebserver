package com.sec.vip.amschaton;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import com.sec.amsoma.AMSLibs;
import com.sec.amsoma.structure.AMS_CODING_FILE_INFO;
import com.sec.amsoma.structure.AMS_OBJECT_DATA;
import com.sec.amsoma.structure.AMS_OPTION;
import com.sec.amsoma.structure.AMS_RECT;
import com.sec.amsoma.structure.AMS_SELECT_OBJECT;
import com.sec.amsoma.structure.AMS_UI_DATA;
import com.sec.chaton.C0062R;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.pns.msg.MsgResultCode;
import java.io.File;
import java.io.IOException;

/* loaded from: classes.dex */
public class AMSDrawManager extends ZoomableImageView implements View.OnTouchListener {

    /* renamed from: a */
    public static final String f3876a = AMSActivity.f3808e;

    /* renamed from: b */
    public static final String f3877b = AMSActivity.f3812i;

    /* renamed from: c */
    public static final String f3878c = f3876a + "template/";

    /* renamed from: F */
    private Context f3879F;

    /* renamed from: G */
    private AMSLibs f3880G;

    /* renamed from: H */
    private int f3881H;

    /* renamed from: I */
    private AMS_UI_DATA f3882I;

    /* renamed from: J */
    private int f3883J;

    /* renamed from: K */
    private int f3884K;

    /* renamed from: L */
    private int f3885L;

    /* renamed from: M */
    private int f3886M;

    /* renamed from: N */
    private int f3887N;

    /* renamed from: O */
    private int f3888O;

    /* renamed from: P */
    private int f3889P;

    /* renamed from: Q */
    private float f3890Q;

    /* renamed from: R */
    private AMSObject f3891R;

    /* renamed from: S */
    private AMSObject f3892S;

    /* renamed from: T */
    private Bitmap f3893T;

    /* renamed from: U */
    private Bitmap f3894U;

    /* renamed from: V */
    private Bitmap f3895V;

    /* renamed from: W */
    private boolean f3896W;

    /* renamed from: X */
    private AMS_SELECT_OBJECT f3897X;

    /* renamed from: Y */
    private final int f3898Y;

    /* renamed from: Z */
    private final int f3899Z;

    /* renamed from: aa */
    private int f3900aa;

    /* renamed from: ab */
    private AMSObject f3901ab;

    /* renamed from: ac */
    private AMS_OBJECT_DATA f3902ac;

    /* renamed from: ad */
    private int f3903ad;

    /* renamed from: ae */
    private boolean f3904ae;

    /* renamed from: af */
    private boolean f3905af;

    /* renamed from: ag */
    private int f3906ag;

    /* renamed from: ah */
    private int f3907ah;

    /* renamed from: ai */
    private boolean f3908ai;

    /* renamed from: aj */
    private int f3909aj;

    /* renamed from: ak */
    private boolean f3910ak;

    /* renamed from: al */
    private InterfaceC0715r f3911al;

    /* renamed from: am */
    private InterfaceC0641ao f3912am;

    /* renamed from: an */
    private final String f3913an;

    /* renamed from: ao */
    private final int f3914ao;

    public class BackgroundAudioType {
    }

    public AMSDrawManager(Context context, int i, int i2) {
        super(context);
        this.f3891R = null;
        this.f3892S = null;
        this.f3893T = null;
        this.f3894U = null;
        this.f3895V = null;
        this.f3896W = false;
        this.f3897X = null;
        this.f3898Y = 32;
        this.f3899Z = 2;
        this.f3900aa = 0;
        this.f3901ab = null;
        this.f3902ac = null;
        this.f3903ad = 0;
        this.f3904ae = false;
        this.f3905af = false;
        this.f3906ag = 0;
        this.f3907ah = 0;
        this.f3908ai = false;
        this.f3909aj = 0;
        this.f3910ak = true;
        this.f3911al = null;
        this.f3912am = null;
        this.f3913an = "bg_org_hp/memo_bg_%02d.jpg";
        this.f3914ao = 240;
        this.f3879F = context;
        this.f3885L = 1;
        this.f3886M = 0;
        this.f3890Q = i / 240;
        this.f3889P = 1;
        this.f3887N = -16777216;
        this.f3888O = -1;
        this.f3883J = i;
        this.f3884K = i2;
        this.f3893T = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        this.f3894U = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        setBitmap(this.f3893T);
        new File(f3876a).mkdirs();
        new File(f3877b).mkdirs();
        new File(f3878c).mkdirs();
        new File(AMSActivity.f3809f).mkdirs();
        new File(AMSActivity.f3810g).mkdirs();
    }

    /* renamed from: G */
    private boolean m3820G() {
        this.f3880G = new AMSLibs();
        this.f3880G.VipAMS_Init();
        String str = new String(f3877b);
        this.f3880G.VipAMS_SetTempFilePath(str.toCharArray(), str.length());
        String str2 = new String(f3878c);
        this.f3880G.VipAMS_SetStampTemplatePath(str2.toCharArray(), str2.length());
        this.f3882I = new AMS_UI_DATA();
        this.f3882I.Init();
        this.f3882I.SetRect((short) 0, (short) 0, (short) this.f3883J, (short) this.f3884K);
        this.f3882I.m_Bitmap = Bitmap.createBitmap(this.f3883J, this.f3884K, Bitmap.Config.ARGB_8888);
        this.f3882I.m_rgbPen = this.f3887N;
        this.f3882I.m_rgbBack = this.f3888O;
        this.f3882I.m_cObjectSize = (byte) this.f3889P;
        this.f3882I.m_eObjectType = (byte) 1;
        this.f3882I.m_cObjectStyle = (byte) 0;
        AMS_OPTION ams_option = new AMS_OPTION();
        ams_option.Init();
        this.f3881H = this.f3880G.VipAMS_Open(ams_option);
        AMS_OBJECT_DATA ams_object_data = new AMS_OBJECT_DATA();
        ams_object_data.setM_cSize(this.f3882I.m_cObjectSize);
        ams_object_data.setM_cStyle(this.f3882I.m_cObjectStyle);
        ams_object_data.setM_nColorR(Color.red(this.f3882I.m_rgbPen));
        ams_object_data.setM_nColorG(Color.green(this.f3882I.m_rgbPen));
        ams_object_data.setM_nColorB(Color.blue(this.f3882I.m_rgbPen));
        if (this.f3880G.VipAMS_TotalNewEncoding(this.f3881H, this.f3882I, this.f3882I.m_rectRegion, ams_object_data)) {
            return true;
        }
        ChatONLogWriter.m3499a("Error Code: " + this.f3880G.VipAMS_GetErrorCode(this.f3881H), getClass().getSimpleName());
        return false;
    }

    /* renamed from: H */
    private boolean m3821H() {
        Canvas canvas = new Canvas(this.f3893T);
        if (this.f3895V != null) {
            canvas.drawBitmap(this.f3895V, new Rect(0, 0, this.f3895V.getWidth(), this.f3895V.getHeight()), new Rect(0, 0, this.f3893T.getWidth(), this.f3893T.getHeight()), (Paint) null);
            return true;
        }
        canvas.drawColor(this.f3888O);
        return true;
    }

    /* renamed from: I */
    private boolean m3822I() throws IOException {
        switch (this.f3880G.VipAMS_GetBackgroundStyle(this.f3881H)) {
            case 0:
                int iVipAMS_GetBackgroundColorR = this.f3880G.VipAMS_GetBackgroundColorR(this.f3881H);
                int iVipAMS_GetBackgroundColorG = this.f3880G.VipAMS_GetBackgroundColorG(this.f3881H);
                int iVipAMS_GetBackgroundColorB = this.f3880G.VipAMS_GetBackgroundColorB(this.f3881H);
                this.f3888O = Color.rgb(iVipAMS_GetBackgroundColorR, iVipAMS_GetBackgroundColorG, iVipAMS_GetBackgroundColorB);
                m3834a(iVipAMS_GetBackgroundColorR, iVipAMS_GetBackgroundColorG, iVipAMS_GetBackgroundColorB, false);
                break;
            case 2:
                m3835a((int) this.f3880G.VipAMS_GetBackgroundIndex(this.f3881H), false);
                break;
            case 4:
                int[] iArrVipAMS_GetCurrentBackgroundBuf = this.f3880G.VipAMS_GetCurrentBackgroundBuf(this.f3881H);
                AMSLibs aMSLibs = this.f3880G;
                int i = AMSLibs.g_nCurrentBackgroundWidth;
                AMSLibs aMSLibs2 = this.f3880G;
                m3836a(Bitmap.createBitmap(iArrVipAMS_GetCurrentBackgroundBuf, i, AMSLibs.g_nCurrentBackgroundHeight, Bitmap.Config.ARGB_8888), false);
                break;
        }
        return true;
    }

    /* renamed from: J */
    private int m3823J() {
        int m_nPointNum = 0;
        AMS_OBJECT_DATA ams_object_data = new AMS_OBJECT_DATA();
        if (this.f3880G != null) {
            int iVipAMS_GetNextDrawingData = 0;
            while (true) {
                iVipAMS_GetNextDrawingData = this.f3880G.VipAMS_GetNextDrawingData(this.f3881H, iVipAMS_GetNextDrawingData, ams_object_data);
                while (iVipAMS_GetNextDrawingData == 0) {
                    if (!this.f3880G.VipAMS_SetNextFrame(this.f3881H)) {
                        return m_nPointNum;
                    }
                    iVipAMS_GetNextDrawingData = this.f3880G.VipAMS_GetNextDrawingData(this.f3881H, iVipAMS_GetNextDrawingData, ams_object_data);
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

    /* renamed from: b */
    private boolean m3824b(int i, int i2, int i3, int i4) {
        this.f3882I.m_eObjectType = (byte) i;
        this.f3882I.m_cObjectStyle = (byte) i2;
        this.f3882I.m_rgbPen = i3;
        this.f3882I.m_cObjectSize = (byte) i4;
        if (!this.f3880G.VipAMS_SetCurObjectType(this.f3881H, this.f3882I, this.f3882I.m_eObjectType)) {
            ChatONLogWriter.m3499a(" Error Code =" + this.f3880G.VipAMS_GetErrorCode(this.f3881H) + ", Line : " + new Exception().getStackTrace()[0].getLineNumber(), getClass().getSimpleName());
            return false;
        }
        if (!this.f3880G.VipAMS_SetCurObjectStyle(this.f3881H, this.f3882I, this.f3882I.m_cObjectStyle)) {
            ChatONLogWriter.m3499a(" Error Code =" + this.f3880G.VipAMS_GetErrorCode(this.f3881H) + ", Line : " + new Exception().getStackTrace()[0].getLineNumber(), getClass().getSimpleName());
            return false;
        }
        if (!this.f3880G.VipAMS_SetCurObjectSize(this.f3881H, this.f3882I, this.f3882I.m_cObjectSize)) {
            ChatONLogWriter.m3499a(" Error Code =" + this.f3880G.VipAMS_GetErrorCode(this.f3881H) + ", Line : " + new Exception().getStackTrace()[0].getLineNumber(), getClass().getSimpleName());
            return false;
        }
        if (this.f3880G.VipAMS_SetCurObjectColor(this.f3881H, this.f3882I, Color.red(this.f3882I.m_rgbPen), Color.green(this.f3882I.m_rgbPen), Color.blue(this.f3882I.m_rgbPen))) {
            return true;
        }
        ChatONLogWriter.m3499a(" Error Code =" + this.f3880G.VipAMS_GetErrorCode(this.f3881H) + ", Line : " + new Exception().getStackTrace()[0].getLineNumber(), getClass().getSimpleName());
        return false;
    }

    /* renamed from: d */
    private PointF m3825d(float f, float f2) {
        float fD = m4218D();
        PointF pointFF = m4220F();
        return (fD == 1.0f && pointFF.x == 0.0f && pointFF.y == 0.0f) ? new PointF(f, f2) : new PointF((f - pointFF.x) / fD, (f2 - pointFF.y) / fD);
    }

    /* renamed from: A */
    public boolean m3826A() {
        if (this.f3880G == null) {
            return false;
        }
        return this.f3880G.VipAMS_IsEditEnable(this.f3881H) && this.f3908ai;
    }

    /* renamed from: B */
    public boolean m3827B() {
        if (this.f3880G == null) {
            return false;
        }
        return this.f3880G.VipAMS_IsAnimationEnable(this.f3881H);
    }

    /* renamed from: C */
    public void m3828C() {
        this.f3879F = null;
        this.f3880G = null;
        this.f3882I = null;
        this.f3891R = null;
        this.f3892S = null;
        this.f3893T = null;
        this.f3895V = null;
        this.f3897X = null;
        this.f3901ab = null;
        this.f3902ac = null;
        this.f3911al = null;
    }

    /* renamed from: a */
    public void m3829a() {
        m4219E();
        m3820G();
        m3834a(Color.red(this.f3888O), Color.green(this.f3888O), Color.blue(this.f3888O), true);
        m3833a(this.f3885L, this.f3886M, this.f3887N, this.f3889P);
        m3821H();
    }

    /* renamed from: a */
    public boolean m3830a(float f, float f2) throws IOException {
        float f3 = f < 0.0f ? 0.0f : f;
        float f4 = f2 < 0.0f ? 0.0f : f2;
        float f5 = f3 > ((float) this.f3883J) ? this.f3883J - 1 : f3;
        float f6 = f4 > ((float) this.f3884K) ? this.f3884K - 1 : f4;
        if (this.f3892S != null && this.f3892S.mo3974c(f5, f6)) {
            return this.f3892S.mo3976d(f5, f6);
        }
        AMS_SELECT_OBJECT ams_select_object = new AMS_SELECT_OBJECT();
        if (!this.f3880G.VipAMS_SelectObject(this.f3881H, this.f3882I, (int) f5, (int) f6, ams_select_object, this.f3885L)) {
            if (this.f3885L == 3 && this.f3886M == -1) {
                return false;
            }
            this.f3891R.m3958a(this.f3893T, this.f3894U);
            boolean z = this.f3896W;
            setEditMode(false, false);
            if (z) {
                this.f3891R.m3970b(false);
            }
            if (this.f3912am != null) {
                this.f3912am.mo3818a(2, 0, 0, 0, 0);
            }
            return this.f3891R.mo3976d(f5, f6);
        }
        setEditMode(true, false);
        this.f3897X = ams_select_object;
        AMS_OBJECT_DATA ams_object_data = new AMS_OBJECT_DATA();
        this.f3880G.VipAMS_GetSelectObjectData(this.f3897X.getM_pSelectObjectData(), ams_object_data);
        int m_eType = ams_object_data.getM_eType();
        int m_cAdditionalID = m_eType == 3 ? ams_object_data.getM_cAdditionalID() : ams_object_data.getM_cStyle();
        byte m_cSize = ams_object_data.getM_cSize();
        int iRgb = Color.rgb(ams_object_data.getM_nColorR(), ams_object_data.getM_nColorG(), ams_object_data.getM_nColorB());
        if (!m3824b(m_eType, m_cAdditionalID, iRgb, m_cSize)) {
            return false;
        }
        if (this.f3912am != null) {
            if (ams_object_data.getM_eType() == 3 && ams_object_data.getM_cStyle() == 2) {
                this.f3912am.mo3818a(1, 3, -1, this.f3887N, this.f3889P);
            } else {
                this.f3912am.mo3818a(1, m_eType, m_cAdditionalID, iRgb, m_cSize);
            }
        }
        m3837a(this.f3897X);
        if (this.f3892S != null) {
            this.f3892S.m3973c();
            this.f3892S = null;
        }
        switch (this.f3885L) {
            case 2:
                AMSObjectText aMSObjectText = new AMSObjectText(m_cAdditionalID, iRgb, m_cSize);
                aMSObjectText.m3979a(this.f3911al);
                aMSObjectText.m3970b(false);
                this.f3892S = aMSObjectText;
                this.f3892S.m3959a(this.f3879F.getResources().getDrawable(C0062R.drawable.memo_bg_focus_02));
                break;
            case 3:
                if (ams_object_data.getM_cStyle() == 0) {
                    this.f3892S = new AMSObjectStamp(m_cAdditionalID, iRgb, m_cSize);
                } else {
                    int[] iArrVipAMS_GetObjectImageBuf = this.f3880G.VipAMS_GetObjectImageBuf(this.f3881H, ams_object_data);
                    AMSLibs aMSLibs = this.f3880G;
                    int i = AMSLibs.g_nCurObjectImageWidth;
                    AMSLibs aMSLibs2 = this.f3880G;
                    this.f3892S = new AMSObjectStamp(-1, this.f3887N, this.f3889P, Bitmap.createBitmap(iArrVipAMS_GetObjectImageBuf, i, AMSLibs.g_nCurObjectImageHeight, Bitmap.Config.ARGB_8888));
                }
                this.f3892S.m3959a(this.f3879F.getResources().getDrawable(C0062R.drawable.memo_bg_focus_02));
                break;
            case 4:
                this.f3892S = new AMSObjectDrawings(m_cAdditionalID, iRgb, m_cSize);
                this.f3892S.m3959a(this.f3879F.getResources().getDrawable(C0062R.drawable.image_editor_cut_framebox));
                break;
            default:
                this.f3892S = new AMSObjectStamp(0, iRgb, m_cSize);
                this.f3892S.m3959a(this.f3879F.getResources().getDrawable(C0062R.drawable.memo_bg_focus_02));
                break;
        }
        this.f3892S.m3960a(this.f3880G, this.f3881H, this.f3882I);
        this.f3892S.m3961a(this.f3897X);
        this.f3892S.m3969b(this.f3895V);
        this.f3892S.mo3954a(this.f3890Q);
        this.f3892S.m3962a(true);
        this.f3892S.m3958a(this.f3893T, this.f3894U);
        return this.f3892S.mo3976d(f5, f6);
    }

    /* renamed from: a */
    public boolean m3831a(int i, int i2) {
        this.f3880G.VipAMS_SetBGAudioStyle(this.f3881H, i2);
        if (i2 == 1) {
            this.f3880G.VipAMS_SetBGMIndex(this.f3881H, i);
        }
        return true;
    }

    /* renamed from: a */
    public boolean m3832a(int i, int i2, int i3) {
        if (!this.f3896W || this.f3892S == null) {
            return false;
        }
        this.f3886M = i;
        this.f3887N = i2;
        this.f3889P = i3;
        m3824b(this.f3885L, this.f3886M, i2, i3);
        return this.f3892S.mo3966a(this.f3886M, i2, i3);
    }

    /* renamed from: a */
    public boolean m3833a(int i, int i2, int i3, int i4) {
        this.f3882I.m_rgbBack = this.f3888O;
        if (!m3824b(i, i2, i3, i4)) {
            return false;
        }
        this.f3885L = i;
        this.f3886M = i2;
        this.f3887N = i3;
        this.f3889P = i4;
        if (this.f3891R != null) {
            this.f3891R.m3973c();
            this.f3891R = null;
        }
        switch (i) {
            case 1:
                this.f3891R = new AMSObjectLine(this.f3886M, this.f3887N, this.f3889P);
                break;
            case 2:
                AMSObjectText aMSObjectText = new AMSObjectText(this.f3886M, this.f3887N, this.f3889P);
                aMSObjectText.m3979a(this.f3911al);
                this.f3891R = aMSObjectText;
                break;
            case 3:
                this.f3891R = new AMSObjectStamp(this.f3886M, this.f3887N, this.f3889P);
                break;
            case 4:
                this.f3891R = new AMSObjectDrawings(this.f3886M, this.f3887N, this.f3889P);
                break;
        }
        this.f3891R.m3960a(this.f3880G, this.f3881H, this.f3882I);
        this.f3891R.m3958a(this.f3893T, this.f3894U);
        this.f3891R.m3969b(this.f3895V);
        this.f3891R.mo3954a(this.f3890Q);
        return true;
    }

    /* renamed from: a */
    public boolean m3834a(int i, int i2, int i3, boolean z) {
        if (z && !this.f3880G.VipAMS_SetBackgroundColor(this.f3881H, this.f3882I, i, i2, i3)) {
            ChatONLogWriter.m3499a("VipAMS_SetBackgroundColor Error = " + this.f3880G.VipAMS_GetErrorCode(this.f3881H), getClass().getSimpleName());
            return false;
        }
        this.f3888O = Color.rgb(i, i2, i3);
        this.f3895V = Bitmap.createBitmap(this.f3893T.getWidth(), this.f3893T.getHeight(), Bitmap.Config.ARGB_8888);
        new Canvas(this.f3895V).drawColor(this.f3888O);
        if (this.f3891R != null) {
            this.f3891R.m3969b(this.f3895V);
        }
        if (this.f3892S != null) {
            this.f3892S.m3969b(this.f3895V);
        }
        return true;
    }

    /* renamed from: a */
    public boolean m3835a(int i, boolean z) throws IOException {
        if (z && !this.f3880G.VipAMS_SetBackgroundIndex(this.f3881H, (byte) i)) {
            ChatONLogWriter.m3499a("VipAMS_SetBackgroundIndex Error = " + this.f3880G.VipAMS_GetErrorCode(this.f3881H), getClass().getSimpleName());
            return false;
        }
        try {
            m3836a(BitmapFactory.decodeStream(this.f3879F.getAssets().open(String.format("bg_org_hp/memo_bg_%02d.jpg", Integer.valueOf(i + 1)))), false);
            if (this.f3891R != null) {
                this.f3891R.m3969b(this.f3895V);
            }
            if (this.f3892S != null) {
                this.f3892S.m3969b(this.f3895V);
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: a */
    public boolean m3836a(Bitmap bitmap, boolean z) {
        if (z) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int[] iArr = new int[width * height];
            bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
            if (!this.f3880G.VipAMS_SetBackgroundRawImage(this.f3881H, iArr, width, height, 24)) {
                ChatONLogWriter.m3499a("VipAMS_SetBackgroundRawImage1 Error = " + this.f3880G.VipAMS_GetErrorCode(this.f3881H), getClass().getSimpleName());
                return false;
            }
        }
        this.f3895V = Bitmap.createBitmap(this.f3893T.getWidth(), this.f3893T.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(this.f3895V);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setFilterBitmap(true);
        canvas.drawBitmap(bitmap, new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), new Rect(0, 0, this.f3893T.getWidth(), this.f3893T.getHeight()), paint);
        if (this.f3891R != null) {
            this.f3891R.m3969b(this.f3895V);
        }
        if (this.f3892S != null) {
            this.f3892S.m3969b(this.f3895V);
        }
        return true;
    }

    /* renamed from: a */
    public boolean m3837a(AMS_SELECT_OBJECT ams_select_object) throws IOException {
        AMSObjectStamp aMSObjectStamp;
        m3822I();
        m3821H();
        AMS_OBJECT_DATA ams_object_data = new AMS_OBJECT_DATA();
        int iVipAMS_GetNextDrawingData = this.f3880G.VipAMS_GetNextDrawingData(this.f3881H, 0, ams_object_data);
        while (iVipAMS_GetNextDrawingData != 0) {
            if (ams_select_object == null || iVipAMS_GetNextDrawingData != ams_select_object.getM_pSelectObjectNode()) {
                switch (ams_object_data.getM_eType()) {
                    case 1:
                        AMSObjectLine aMSObjectLine = new AMSObjectLine(ams_object_data.getM_cStyle(), Color.rgb(ams_object_data.getM_nColorR(), ams_object_data.getM_nColorG(), ams_object_data.getM_nColorB()), ams_object_data.getM_cSize());
                        if (ams_object_data.getM_cStyle() != 4) {
                            aMSObjectLine.m3957a(this.f3893T);
                        } else {
                            aMSObjectLine.m3958a(this.f3893T, this.f3894U);
                        }
                        aMSObjectLine.m3969b(this.f3895V);
                        aMSObjectLine.mo3954a(this.f3890Q);
                        for (int i = 0; i < ams_object_data.getM_TPoint().getM_nPointNum(); i++) {
                            float m_pnAMSPointX = ams_object_data.getM_TPoint().getM_pnAMSPointX(i);
                            float m_pnAMSPointY = ams_object_data.getM_TPoint().getM_pnAMSPointY(i);
                            if (i == 0) {
                                aMSObjectLine.mo3955a(m_pnAMSPointX, m_pnAMSPointY);
                            } else if (i < ams_object_data.getM_TPoint().getM_nPointNum() - 1) {
                                aMSObjectLine.mo3964a(m_pnAMSPointX, m_pnAMSPointY, 0);
                            }
                            if (i == ams_object_data.getM_TPoint().getM_nPointNum() - 1) {
                                aMSObjectLine.mo3968b(m_pnAMSPointX, m_pnAMSPointY);
                            }
                        }
                        break;
                    case 2:
                        AMSObjectText aMSObjectText = new AMSObjectText(ams_object_data.getM_cStyle(), Color.rgb(ams_object_data.getM_nColorR(), ams_object_data.getM_nColorG(), ams_object_data.getM_nColorB()), ams_object_data.getM_cSize());
                        AMS_RECT m_TRect = ams_object_data.getM_TRect();
                        aMSObjectText.m3957a(this.f3893T);
                        aMSObjectText.m3969b(this.f3895V);
                        aMSObjectText.mo3954a(this.f3890Q);
                        aMSObjectText.mo3965a(m_TRect.nLeft, m_TRect.nTop, ams_object_data.getM_TText().getM_strText(), 255);
                        break;
                    case 3:
                        if (ams_object_data.getM_cStyle() == 0) {
                            aMSObjectStamp = new AMSObjectStamp(ams_object_data.getM_cAdditionalID(), Color.rgb(ams_object_data.getM_nColorR(), ams_object_data.getM_nColorG(), ams_object_data.getM_nColorB()), ams_object_data.getM_cSize());
                        } else if (ams_object_data.getM_cStyle() == 2) {
                            int[] iArrVipAMS_GetObjectImageBuf = this.f3880G.VipAMS_GetObjectImageBuf(this.f3881H, ams_object_data);
                            AMSLibs aMSLibs = this.f3880G;
                            int i2 = AMSLibs.g_nCurObjectImageWidth;
                            AMSLibs aMSLibs2 = this.f3880G;
                            aMSObjectStamp = new AMSObjectStamp(-1, Color.rgb(ams_object_data.getM_nColorR(), ams_object_data.getM_nColorG(), ams_object_data.getM_nColorB()), ams_object_data.getM_cSize(), Bitmap.createBitmap(iArrVipAMS_GetObjectImageBuf, i2, AMSLibs.g_nCurObjectImageHeight, Bitmap.Config.ARGB_8888));
                        } else {
                            aMSObjectStamp = new AMSObjectStamp(0, Color.rgb(ams_object_data.getM_nColorR(), ams_object_data.getM_nColorG(), ams_object_data.getM_nColorB()), ams_object_data.getM_cSize());
                        }
                        AMS_RECT m_TRect2 = ams_object_data.getM_TRect();
                        aMSObjectStamp.m3957a(this.f3893T);
                        aMSObjectStamp.m3969b(this.f3895V);
                        aMSObjectStamp.mo3954a(this.f3890Q);
                        aMSObjectStamp.mo3964a(m_TRect2.nLeft, m_TRect2.nTop, 255);
                        break;
                    case 4:
                        AMSObjectDrawings aMSObjectDrawings = new AMSObjectDrawings(ams_object_data.getM_cStyle(), Color.rgb(ams_object_data.getM_nColorR(), ams_object_data.getM_nColorG(), ams_object_data.getM_nColorB()), ams_object_data.getM_cSize());
                        AMS_RECT m_TRect3 = ams_object_data.getM_TRect();
                        aMSObjectDrawings.m3957a(this.f3893T);
                        aMSObjectDrawings.m3969b(this.f3895V);
                        aMSObjectDrawings.mo3954a(this.f3890Q);
                        aMSObjectDrawings.mo3963a(m_TRect3.nLeft, m_TRect3.nTop, m_TRect3.nRight, m_TRect3.nBottom, 255);
                        break;
                }
                iVipAMS_GetNextDrawingData = this.f3880G.VipAMS_GetNextDrawingData(this.f3881H, iVipAMS_GetNextDrawingData, ams_object_data);
            } else {
                iVipAMS_GetNextDrawingData = this.f3880G.VipAMS_GetNextDrawingData(this.f3881H, iVipAMS_GetNextDrawingData, ams_object_data);
            }
        }
        int iVipAMS_GetErrorCode = this.f3880G.VipAMS_GetErrorCode(this.f3881H);
        if (iVipAMS_GetErrorCode == 0) {
            return true;
        }
        ChatONLogWriter.m3499a(" Error Code =" + iVipAMS_GetErrorCode + ", Line : " + new Exception().getStackTrace()[0].getLineNumber(), getClass().getSimpleName());
        return false;
    }

    /* renamed from: a */
    public boolean m3838a(String str) throws IOException {
        if (this.f3880G == null) {
            return false;
        }
        int[] iArr = new int[240 * 240];
        m3864v();
        m3852j();
        Bitmap.createScaledBitmap(this.f3893T, 240, 240, true).getPixels(iArr, 0, 240, 0, 0, 240, 240);
        this.f3880G.VipAMS_SetAMSImageBuf(this.f3881H, this.f3882I, iArr, 240, 240);
        AMS_CODING_FILE_INFO[] ams_coding_file_infoArr = {new AMS_CODING_FILE_INFO()};
        ams_coding_file_infoArr[0].setM_eExportType(0);
        ams_coding_file_infoArr[0].setM_strFileName(str);
        if (this.f3880G.VipAMS_TotalSaveEncoding(this.f3881H, this.f3882I, ams_coding_file_infoArr) != 0) {
            return true;
        }
        ChatONLogWriter.m3499a("VipAMS_TotalSaveEncoding Error = " + this.f3880G.VipAMS_GetErrorCode(this.f3881H), getClass().getSimpleName());
        return false;
    }

    /* renamed from: a */
    public boolean m3839a(String str, int i) {
        this.f3880G.VipAMS_SetBGAudioStyle(this.f3881H, i);
        if (i != 2 && i != 3) {
            return true;
        }
        this.f3880G.VipAMS_SetBGAudioFile(this.f3881H, this.f3882I, str.toCharArray());
        return true;
    }

    /* renamed from: a */
    public boolean m3840a(String str, int i, int i2) {
        if (this.f3885L != 2) {
            return false;
        }
        this.f3887N = i;
        this.f3889P = i2;
        if (this.f3896W) {
            AMSObjectText aMSObjectText = (AMSObjectText) this.f3892S;
            aMSObjectText.mo3966a(this.f3886M, this.f3887N, this.f3889P);
            aMSObjectText.m3980a(str);
        } else {
            AMSObjectText aMSObjectText2 = (AMSObjectText) this.f3891R;
            m3824b(this.f3885L, this.f3886M, this.f3887N, this.f3889P);
            aMSObjectText2.m3982a(str, this.f3887N, this.f3889P);
        }
        if (this.f3912am != null) {
            this.f3912am.mo3818a(0, 0, 0, 0, 0);
        }
        invalidate();
        return true;
    }

    /* renamed from: b */
    public int m3841b() {
        return this.f3885L;
    }

    /* renamed from: b */
    public int m3842b(String str) {
        if (this.f3880G == null) {
            this.f3908ai = false;
            return 3;
        }
        if (!this.f3880G.VipAMS_ClearEncoding(this.f3881H, this.f3882I)) {
            this.f3908ai = false;
            return 3;
        }
        AMS_CODING_FILE_INFO[] ams_coding_file_infoArr = {new AMS_CODING_FILE_INFO()};
        ams_coding_file_infoArr[0].setM_eExportType(0);
        ams_coding_file_infoArr[0].setM_strFileName(str);
        if (this.f3880G.VipAMS_TotalLoadEncodingFile(this.f3881H, this.f3882I, ams_coding_file_infoArr, this.f3882I.m_rectRegion) != 0) {
            this.f3906ag = m3823J();
            this.f3908ai = true;
            return 0;
        }
        int iVipAMS_GetErrorCode = this.f3880G.VipAMS_GetErrorCode(this.f3881H);
        this.f3908ai = false;
        switch (iVipAMS_GetErrorCode) {
            case 49:
                break;
            case 50:
                break;
            default:
                ChatONLogWriter.m3499a("VipAMS_TotalLoadEncodingFile Error = " + iVipAMS_GetErrorCode, getClass().getSimpleName());
                break;
        }
        return 3;
    }

    /* renamed from: b */
    public boolean m3843b(float f, float f2) {
        float f3 = f < 0.0f ? 0.0f : f;
        float f4 = f2 < 0.0f ? 0.0f : f2;
        float f5 = f3 > ((float) this.f3883J) ? this.f3883J - 1 : f3;
        float f6 = f4 > ((float) this.f3884K) ? this.f3884K - 1 : f4;
        if (!this.f3896W) {
            return this.f3891R.mo3977e(f5, f6);
        }
        if (this.f3892S == null) {
            return false;
        }
        if (this.f3912am != null) {
            getLocationOnScreen(new int[2]);
            this.f3912am.mo3818a(3, (int) (r3[0] + f5), (int) (r3[1] + f6), 0, 0);
        }
        return this.f3892S.mo3977e(f5, f6);
    }

    /* renamed from: c */
    public int m3844c() {
        return this.f3888O;
    }

    /* renamed from: c */
    public boolean m3845c(float f, float f2) {
        float f3 = f < 0.0f ? 0.0f : f;
        float f4 = f2 < 0.0f ? 0.0f : f2;
        if (f3 > this.f3883J) {
            f3 = this.f3883J - 1;
        }
        float f5 = f4 > ((float) this.f3884K) ? this.f3884K - 1 : f4;
        if (!this.f3896W) {
            boolean zMo3978f = this.f3891R.mo3978f(f3, f5);
            if (this.f3912am != null) {
                this.f3912am.mo3818a(0, 0, 0, 0, 0);
            }
            return zMo3978f;
        }
        if (this.f3892S == null) {
            return false;
        }
        if (this.f3912am != null) {
            getLocationOnScreen(new int[2]);
            this.f3912am.mo3818a(4, (int) (r5[0] + f3), (int) (r5[1] + f5), 0, 0);
        }
        return this.f3892S.mo3978f(f3, f5);
    }

    /* renamed from: d */
    public int m3846d() {
        return this.f3880G.VipAMS_GetBGAudioStyle(this.f3881H);
    }

    /* renamed from: e */
    public String m3847e() {
        if (m3846d() == 0 || m3846d() == 1) {
            return null;
        }
        return String.valueOf(this.f3880G.VipAMS_GetBGAudioFile(this.f3881H));
    }

    /* renamed from: f */
    public int m3848f() {
        if (m3846d() == 0 || m3846d() == 2 || m3846d() == 3) {
            return -1;
        }
        return this.f3880G.VipAMS_GetBGMIndex(this.f3881H);
    }

    /* renamed from: g */
    public boolean m3849g() {
        switch (m3846d()) {
            case 1:
            case 2:
            case 3:
                return true;
            default:
                return false;
        }
    }

    /* renamed from: h */
    public AMSObject m3850h() {
        return this.f3892S;
    }

    /* renamed from: i */
    public Bitmap m3851i() {
        return this.f3893T;
    }

    /* renamed from: j */
    public boolean m3852j() throws IOException {
        return m3837a((AMS_SELECT_OBJECT) null);
    }

    /* renamed from: k */
    public boolean m3853k() throws IOException {
        this.f3880G.VipAMS_SetCurrentFrame(this.f3881H, (byte) 0);
        m3822I();
        m3821H();
        this.f3902ac = new AMS_OBJECT_DATA();
        this.f3900aa = 0;
        this.f3904ae = false;
        this.f3903ad = 0;
        this.f3905af = false;
        this.f3907ah = 0;
        return true;
    }

    /* renamed from: l */
    public boolean m3854l() {
        if (this.f3905af) {
            return true;
        }
        if (!this.f3904ae) {
            this.f3903ad = 0;
            this.f3900aa = this.f3880G.VipAMS_GetNextDrawingData(this.f3881H, this.f3900aa, this.f3902ac);
            while (this.f3900aa == 0) {
                if (!this.f3880G.VipAMS_SetNextFrame(this.f3881H)) {
                    return false;
                }
                m3821H();
                this.f3900aa = this.f3880G.VipAMS_GetNextDrawingData(this.f3881H, this.f3900aa, this.f3902ac);
            }
            this.f3904ae = true;
        }
        this.f3905af = true;
        if (this.f3903ad == 0 && this.f3901ab != null) {
            this.f3901ab.m3973c();
            this.f3901ab = null;
        }
        switch (this.f3902ac.getM_eType()) {
            case 1:
                if (this.f3903ad == 0) {
                    this.f3901ab = new AMSObjectLine(this.f3902ac.getM_cStyle(), Color.rgb(this.f3902ac.getM_nColorR(), this.f3902ac.getM_nColorG(), this.f3902ac.getM_nColorB()), this.f3902ac.getM_cSize());
                    this.f3901ab.m3958a(this.f3893T, this.f3894U);
                    this.f3901ab.m3969b(this.f3895V);
                    this.f3901ab.mo3954a(this.f3890Q);
                }
                float m_pnAMSPointX = this.f3902ac.getM_TPoint().getM_pnAMSPointX(this.f3903ad);
                float m_pnAMSPointY = this.f3902ac.getM_TPoint().getM_pnAMSPointY(this.f3903ad);
                if (this.f3903ad == 0) {
                    this.f3901ab.mo3955a(m_pnAMSPointX, m_pnAMSPointY);
                } else if (this.f3903ad < this.f3902ac.getM_TPoint().getM_nPointNum()) {
                    this.f3901ab.mo3964a(m_pnAMSPointX, m_pnAMSPointY, 255);
                }
                if (this.f3903ad == this.f3902ac.getM_TPoint().getM_nPointNum() - 1) {
                    this.f3901ab.mo3968b(m_pnAMSPointX, m_pnAMSPointY);
                    this.f3904ae = false;
                }
                this.f3903ad++;
                this.f3907ah++;
                break;
            case 2:
                if (this.f3903ad == 0) {
                    this.f3901ab = new AMSObjectText(this.f3902ac.getM_cStyle(), Color.rgb(this.f3902ac.getM_nColorR(), this.f3902ac.getM_nColorG(), this.f3902ac.getM_nColorB()), this.f3902ac.getM_cSize());
                    this.f3901ab.m3958a(this.f3893T, this.f3894U);
                    this.f3901ab.m3969b(this.f3895V);
                    this.f3901ab.mo3954a(this.f3890Q);
                }
                AMS_RECT m_TRect = this.f3902ac.getM_TRect();
                this.f3903ad++;
                this.f3907ah++;
                if (this.f3903ad >= 32) {
                    this.f3901ab.mo3965a(m_TRect.nLeft, m_TRect.nTop, this.f3902ac.getM_TText().getM_strText(), 255);
                    this.f3904ae = false;
                    break;
                } else {
                    this.f3901ab.mo3965a(m_TRect.nLeft, m_TRect.nTop, this.f3902ac.getM_TText().getM_strText(), (int) ((this.f3903ad / 2) * (this.f3903ad / 2)));
                    break;
                }
            case 3:
                int m_cAdditionalID = this.f3902ac.getM_cAdditionalID();
                if (this.f3903ad == 0) {
                    if (this.f3902ac.getM_cStyle() == 0) {
                        this.f3901ab = new AMSObjectStamp(m_cAdditionalID, Color.rgb(this.f3902ac.getM_nColorR(), this.f3902ac.getM_nColorG(), this.f3902ac.getM_nColorB()), this.f3902ac.getM_cSize());
                    } else if (this.f3902ac.getM_cStyle() == 2) {
                        int[] iArrVipAMS_GetObjectImageBuf = this.f3880G.VipAMS_GetObjectImageBuf(this.f3881H, this.f3902ac);
                        AMSLibs aMSLibs = this.f3880G;
                        int i = AMSLibs.g_nCurObjectImageWidth;
                        AMSLibs aMSLibs2 = this.f3880G;
                        this.f3901ab = new AMSObjectStamp(-1, Color.rgb(this.f3902ac.getM_nColorR(), this.f3902ac.getM_nColorG(), this.f3902ac.getM_nColorB()), this.f3902ac.getM_cSize(), Bitmap.createBitmap(iArrVipAMS_GetObjectImageBuf, i, AMSLibs.g_nCurObjectImageHeight, Bitmap.Config.ARGB_8888));
                    } else {
                        this.f3901ab = new AMSObjectStamp(0, Color.rgb(this.f3902ac.getM_nColorR(), this.f3902ac.getM_nColorG(), this.f3902ac.getM_nColorB()), this.f3902ac.getM_cSize());
                    }
                    this.f3901ab.m3958a(this.f3893T, this.f3894U);
                    this.f3901ab.m3969b(this.f3895V);
                    this.f3901ab.mo3954a(this.f3890Q);
                }
                AMS_RECT m_TRect2 = this.f3902ac.getM_TRect();
                this.f3903ad++;
                this.f3907ah++;
                if (this.f3902ac.getM_cStyle() != 0) {
                    if (this.f3902ac.getM_cStyle() != 2) {
                        if (this.f3903ad >= 32) {
                            this.f3901ab.mo3964a(m_TRect2.nLeft, m_TRect2.nTop, 255);
                            this.f3904ae = false;
                            break;
                        } else {
                            this.f3901ab.mo3964a(m_TRect2.nLeft, m_TRect2.nTop, (int) ((this.f3903ad / 2) * (this.f3903ad / 2)));
                            break;
                        }
                    } else if (this.f3903ad >= 32) {
                        this.f3901ab.mo3964a(m_TRect2.nLeft, m_TRect2.nTop, 255);
                        this.f3904ae = false;
                        break;
                    } else {
                        this.f3901ab.mo3964a(m_TRect2.nLeft, m_TRect2.nTop, (int) ((this.f3903ad / 2) * (this.f3903ad / 2)));
                        break;
                    }
                } else if (m_cAdditionalID >= AMSStampManager.m4056a().m4063b()) {
                    if (m_cAdditionalID >= AMSStampManager.m4056a().m4063b() + AMSStampManager.m4056a().m4067d()) {
                        if (this.f3903ad >= 32) {
                            this.f3901ab.mo3964a(m_TRect2.nLeft, m_TRect2.nTop, 255);
                            this.f3904ae = false;
                            break;
                        } else {
                            this.f3901ab.mo3964a(m_TRect2.nLeft, m_TRect2.nTop, (int) ((this.f3903ad / 2) * (this.f3903ad / 2)));
                            break;
                        }
                    } else if (this.f3903ad >= 32) {
                        this.f3901ab.mo3964a(m_TRect2.nLeft, m_TRect2.nTop, 255);
                        this.f3904ae = false;
                        break;
                    } else {
                        this.f3901ab.mo3964a(m_TRect2.nLeft, m_TRect2.nTop, (this.f3903ad / 2) + MsgResultCode.SUCCESS);
                        break;
                    }
                } else if (this.f3903ad >= 32) {
                    this.f3901ab.mo3964a(m_TRect2.nLeft, m_TRect2.nTop, 255);
                    this.f3904ae = false;
                    break;
                } else {
                    this.f3901ab.mo3964a(m_TRect2.nLeft, m_TRect2.nTop, (int) ((this.f3903ad / 2) * (this.f3903ad / 2)));
                    break;
                }
            case 4:
                if (this.f3903ad == 0) {
                    this.f3901ab = new AMSObjectDrawings(this.f3902ac.getM_cStyle(), Color.rgb(this.f3902ac.getM_nColorR(), this.f3902ac.getM_nColorG(), this.f3902ac.getM_nColorB()), this.f3902ac.getM_cSize());
                    this.f3901ab.m3958a(this.f3893T, this.f3894U);
                    this.f3901ab.m3969b(this.f3895V);
                    this.f3901ab.mo3954a(this.f3890Q);
                }
                AMS_RECT m_TRect3 = this.f3902ac.getM_TRect();
                this.f3903ad++;
                this.f3907ah++;
                if (this.f3903ad >= 32) {
                    this.f3901ab.mo3963a(m_TRect3.nLeft, m_TRect3.nTop, m_TRect3.nRight, m_TRect3.nBottom, 255);
                    this.f3904ae = false;
                    break;
                } else {
                    this.f3901ab.mo3963a(m_TRect3.nLeft, m_TRect3.nTop, m_TRect3.nRight, m_TRect3.nBottom, (int) ((this.f3903ad / 2) * (this.f3903ad / 2)));
                    break;
                }
        }
        this.f3905af = false;
        return true;
    }

    /* renamed from: m */
    public boolean m3855m() throws IOException {
        if (this.f3892S != null && this.f3892S.m3971b()) {
            setEditMode(false, true);
            if (this.f3912am != null) {
                this.f3912am.mo3818a(0, 0, 0, 0, 0);
            }
            invalidate();
            return true;
        }
        return false;
    }

    /* renamed from: n */
    public boolean m3856n() throws IOException {
        if (this.f3880G != null && this.f3880G.VipAMS_Undo(this.f3881H, this.f3882I) != 0) {
            setEditMode(false, true);
            if (this.f3912am != null) {
                this.f3912am.mo3818a(0, 0, 0, 0, 0);
            }
            invalidate();
            return true;
        }
        return false;
    }

    /* renamed from: o */
    public boolean m3857o() throws IOException {
        if (this.f3880G != null && this.f3880G.VipAMS_Redo(this.f3881H, this.f3882I) != 0) {
            setEditMode(false, true);
            if (this.f3912am != null) {
                this.f3912am.mo3818a(0, 0, 0, 0, 0);
            }
            invalidate();
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) throws IOException {
        PointF pointF = new PointF();
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.f3909aj = 0;
                pointF.set(m3825d(motionEvent.getX(), motionEvent.getY()));
                m3830a(pointF.x, pointF.y);
                break;
            case 1:
                if (this.f3909aj == 0) {
                    pointF.set(m3825d(motionEvent.getX(), motionEvent.getY()));
                    m3845c(pointF.x, pointF.y);
                }
                this.f3909aj = 0;
                break;
            case 2:
                if (this.f3909aj != 1 || !this.f3910ak) {
                    pointF.set(m3825d(motionEvent.getX(), motionEvent.getY()));
                    m3843b(pointF.x, pointF.y);
                    break;
                } else {
                    return m4221a(motionEvent);
                }
                break;
            case 5:
                if (this.f3910ak) {
                    this.f3909aj = 1;
                    if (!this.f3896W) {
                        this.f3891R.mo3953a();
                        this.f3891R.f3979s = 0;
                    }
                    return m4221a(motionEvent);
                }
                break;
            case 6:
                if (this.f3910ak) {
                    return m4221a(motionEvent);
                }
                break;
        }
        if (this.f3892S != null || this.f3891R.m3975d() == null) {
            invalidate();
        } else {
            invalidate(this.f3891R.m3975d());
        }
        return true;
    }

    /* renamed from: p */
    public int m3858p() {
        return this.f3906ag;
    }

    /* renamed from: q */
    public int m3859q() {
        return this.f3907ah;
    }

    /* renamed from: r */
    public boolean m3860r() throws IOException {
        if (this.f3880G != null && this.f3880G.VipAMS_AddFrame(this.f3881H)) {
            setEditMode(false, false);
            m3852j();
            invalidate();
            return true;
        }
        return false;
    }

    /* renamed from: s */
    public boolean m3861s() throws IOException {
        if (this.f3880G == null) {
            return false;
        }
        if (!this.f3880G.VipAMS_RemoveFrame(this.f3881H, (byte) m3866x())) {
            return false;
        }
        setEditMode(false, false);
        m3852j();
        invalidate();
        return true;
    }

    public void setAMSLib(AMSLibs aMSLibs, int i, AMS_UI_DATA ams_ui_data) {
        this.f3880G = aMSLibs;
        this.f3881H = i;
        this.f3882I = ams_ui_data;
    }

    public void setBitmapForAMS(String str) {
        if (str == null) {
            setBitmap(this.f3893T);
            return;
        }
        Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(str);
        if (bitmapDecodeFile != null) {
            setBitmap(bitmapDecodeFile);
        }
    }

    public void setEditMode(boolean z, boolean z2) throws IOException {
        boolean z3 = false;
        this.f3896W = z;
        if (!this.f3896W) {
            if (this.f3892S != null) {
                this.f3892S = null;
                this.f3897X = null;
                m3852j();
                z3 = true;
            }
            m3833a(this.f3885L, this.f3886M, this.f3887N, this.f3889P);
        }
        if (z3 || !z2) {
            return;
        }
        m3852j();
    }

    public void setEnableZoom(boolean z) {
        this.f3910ak = z;
    }

    public void setOnObjectListener(InterfaceC0641ao interfaceC0641ao) {
        this.f3912am = interfaceC0641ao;
    }

    public void setOnTextInputRequestListener(InterfaceC0715r interfaceC0715r) {
        this.f3911al = interfaceC0715r;
    }

    public void setPage(int i) throws IOException {
        if (this.f3880G == null) {
            return;
        }
        this.f3880G.VipAMS_SetCurrentFrame(this.f3881H, (byte) i);
        setEditMode(false, false);
    }

    public void setPlayMode(boolean z) {
        if (z) {
            setOnTouchListener(null);
        } else {
            setOnTouchListener(this);
        }
    }

    /* renamed from: t */
    public boolean m3862t() throws IOException {
        if (this.f3880G != null && this.f3880G.VipAMS_SetPrevFrame(this.f3881H)) {
            setEditMode(false, false);
            return true;
        }
        return false;
    }

    /* renamed from: u */
    public boolean m3863u() throws IOException {
        if (this.f3880G != null && this.f3880G.VipAMS_SetNextFrame(this.f3881H)) {
            setEditMode(false, false);
            return true;
        }
        return false;
    }

    /* renamed from: v */
    public void m3864v() throws IOException {
        if (this.f3880G == null) {
            return;
        }
        while (this.f3880G.VipAMS_SetNextFrame(this.f3881H)) {
        }
        setEditMode(false, false);
    }

    /* renamed from: w */
    public int m3865w() {
        if (this.f3880G == null) {
            return -1;
        }
        return this.f3880G.VipAMS_GetLastFrame(this.f3881H);
    }

    /* renamed from: x */
    public int m3866x() {
        if (this.f3880G == null) {
            return -1;
        }
        return this.f3880G.VipAMS_GetCurrentFrame(this.f3881H);
    }

    /* renamed from: y */
    public boolean m3867y() {
        if (this.f3880G == null) {
            return false;
        }
        return this.f3880G.VipAMS_IsEnableUndo(this.f3881H);
    }

    /* renamed from: z */
    public boolean m3868z() {
        if (this.f3880G == null) {
            return false;
        }
        return this.f3880G.VipAMS_IsEnableRedo(this.f3881H);
    }
}
