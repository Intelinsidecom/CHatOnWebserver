package com.samsung.sdraw;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.text.Layout;
import android.view.View;
import com.samsung.sdraw.CanvasView;
import com.samsung.sdraw.StrokeSprite;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/* loaded from: classes.dex */
class Setting {

    /* renamed from: A */
    protected boolean f1242A;

    /* renamed from: B */
    protected float[] f1243B;

    /* renamed from: C */
    protected float[] f1244C;

    /* renamed from: D */
    protected float[] f1245D;

    /* renamed from: E */
    protected float[] f1246E;

    /* renamed from: F */
    protected float[] f1247F;

    /* renamed from: G */
    protected float[] f1248G;

    /* renamed from: H */
    protected String f1249H;

    /* renamed from: I */
    protected int f1250I;

    /* renamed from: J */
    protected int f1251J;

    /* renamed from: K */
    protected int f1252K;

    /* renamed from: L */
    protected String f1253L;

    /* renamed from: M */
    private int f1254M;

    /* renamed from: O */
    private int f1256O;

    /* renamed from: Q */
    private String f1258Q;

    /* renamed from: R */
    private Layout.Alignment f1259R;

    /* renamed from: Y */
    private int f1266Y;

    /* renamed from: f */
    protected float[] f1273f;

    /* renamed from: h */
    protected float[] f1274h;

    /* renamed from: i */
    protected float[] f1275i;

    /* renamed from: j */
    protected float[] f1276j;

    /* renamed from: n */
    protected Rect f1277n;

    /* renamed from: o */
    protected Rect f1278o;

    /* renamed from: p */
    protected View f1279p;

    /* renamed from: r */
    protected float f1281r;

    /* renamed from: w */
    protected android.graphics.PointF f1286w;

    /* renamed from: x */
    protected android.graphics.PointF f1287x;

    /* renamed from: y */
    protected float f1288y;

    /* renamed from: z */
    protected boolean f1289z;

    /* renamed from: a */
    protected static final int f1233a = Color.argb(255, 19, 19, 19);

    /* renamed from: b */
    protected static final StrokeSprite.Type f1234b = StrokeSprite.Type.Solid;

    /* renamed from: c */
    protected static final StrokeSprite.ThicknessParameter f1235c = StrokeSprite.ThicknessParameter.SpeedAndPressure;

    /* renamed from: d */
    protected static final StrokeSprite.InputMethod f1236d = StrokeSprite.InputMethod.Hand;

    /* renamed from: e */
    protected static final float[] f1237e = {VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, 5.0f, 22.0f, 85.0f};

    /* renamed from: g */
    protected static final float[] f1238g = {0.04f, 0.16f, 0.195f, 1.25f};

    /* renamed from: k */
    protected static final int f1239k = C1051g.f1731a;

    /* renamed from: l */
    protected static final String f1240l = m1097n();

    /* renamed from: m */
    protected static final Layout.Alignment f1241m = Layout.Alignment.ALIGN_NORMAL;
    public static int lSpinner = 0;

    /* renamed from: v */
    protected HashMap<Integer, StrokeSprite.InputMethod> f1285v = new HashMap<>();

    /* renamed from: N */
    private int f1255N = 20;

    /* renamed from: P */
    private int f1257P = 0;

    /* renamed from: S */
    private boolean f1260S = true;

    /* renamed from: T */
    private HashMap<Integer, PenSettingInfo> f1261T = new HashMap<>();

    /* renamed from: U */
    private HashMap<Integer, TextSettingInfo> f1262U = new HashMap<>();

    /* renamed from: V */
    private HashMap<Integer, FillingSettingInfo> f1263V = new HashMap<>();

    /* renamed from: W */
    private int f1264W = 1;

    /* renamed from: X */
    private int f1265X = 0;
    public boolean bHistoricalOperationSupport = true;

    /* renamed from: Z */
    private boolean f1267Z = false;

    /* renamed from: aa */
    private boolean f1268aa = false;

    /* renamed from: ab */
    private boolean f1269ab = true;
    public CanvasView.OnCancelListener mOnDrawCancelListener = null;

    /* renamed from: ac */
    private boolean f1270ac = true;

    /* renamed from: ad */
    private int f1271ad = 100;

    /* renamed from: ae */
    private int f1272ae = 5;
    public CanvasView.OnDrawingInformationListener mOnDrawingInformationListener = null;

    /* renamed from: q */
    protected float f1280q = 8.0f;

    /* renamed from: s */
    protected int f1282s = f1233a;

    /* renamed from: t */
    protected StrokeSprite.Type f1283t = f1234b;

    /* renamed from: u */
    protected StrokeSprite.ThicknessParameter f1284u = f1235c;

    public Setting(Context context) {
        File filesDir;
        this.f1259R = f1241m;
        this.f1285v.put(Integer.valueOf(getUserID()), f1236d);
        this.f1254M = 10;
        this.f1256O = f1239k;
        this.f1258Q = f1240l;
        this.f1259R = f1241m;
        this.f1266Y = f1233a;
        this.f1286w = new android.graphics.PointF(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET);
        this.f1288y = 1.0f;
        this.f1287x = new android.graphics.PointF(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET);
        this.f1289z = false;
        if (context != null) {
            m1096a(context);
        }
        this.f1243B = f1237e;
        this.f1244C = this.f1273f;
        this.f1246E = f1238g;
        this.f1247F = this.f1274h;
        this.f1245D = this.f1275i;
        this.f1248G = this.f1276j;
        setCanvasRect(new Rect(0, 0, 1, 1));
        setScreenRect(new Rect(0, 0, 1, 1));
        if (context != null && (filesDir = context.getFilesDir()) != null) {
            this.f1249H = String.valueOf(filesDir.getPath()) + "/cache";
        } else {
            this.f1249H = "/mnt/sdcard/android/data/com.samsung.sdraw/cache";
        }
        this.f1250I = 70;
        this.f1251J = 30;
        if (context != null) {
            this.f1253L = "/mnt/sdcard/android/data/" + context.getPackageName() + "/serial";
        }
        this.f1252K = 10000;
        this.f1242A = true;
    }

    /* renamed from: a */
    private void m1096a(Context context) {
        this.f1273f = new float[]{VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, 4.2f, 9.5f, 35.0f};
        this.f1274h = new float[]{0.3f, 0.38f, 0.46f, 0.55f};
        this.f1275i = new float[]{VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, 4.2f, 9.5f, 35.0f};
        this.f1276j = new float[]{0.4f, 0.68f, 0.76f, 0.85f};
    }

    public void setCanvasRect(Rect rect) {
        this.f1277n = new Rect(rect);
    }

    public Rect getCanvasRect() {
        return new Rect(this.f1277n);
    }

    public int getCanvasWidth() {
        return this.f1277n.width();
    }

    public int getCanvasHeight() {
        return this.f1277n.height();
    }

    public void setScreenRect(Rect rect) {
        this.f1278o = new Rect(rect);
    }

    public Rect getScreenRect() {
        return new Rect(this.f1278o);
    }

    public int getScreenWidth() {
        return this.f1278o.width();
    }

    public int getScreenHeight() {
        return this.f1278o.height();
    }

    public void setStrokeWidth(float width) {
        this.f1280q = width;
    }

    public float getStrokeWidth() {
        return this.f1283t == StrokeSprite.Type.Zenbrush ? this.f1280q * 1.1f : this.f1280q;
    }

    public void setStrokeColor(int color) {
        this.f1282s = color;
    }

    public int getStrokeColor() {
        return this.f1282s;
    }

    public void setStrokeType(StrokeSprite.Type type) {
        this.f1283t = type;
    }

    public StrokeSprite.Type getStrokeType() {
        return this.f1283t;
    }

    public void setStrokeParameter(StrokeSprite.ThicknessParameter parameter) {
        this.f1284u = parameter;
    }

    public StrokeSprite.ThicknessParameter getStrokeParameter() {
        return this.f1284u;
    }

    /* renamed from: a */
    void m1099a(StrokeSprite.InputMethod inputMethod, int i) {
        this.f1285v.put(Integer.valueOf(i), inputMethod);
    }

    public StrokeSprite.InputMethod getStrokeInput() {
        return m1098a(this.f1264W);
    }

    /* renamed from: a */
    StrokeSprite.InputMethod m1098a(int i) {
        return this.f1285v.get(Integer.valueOf(i));
    }

    /* renamed from: a */
    boolean m1103a() {
        return this.f1289z;
    }

    /* renamed from: a */
    void m1101a(float[] fArr) {
        this.f1243B = fArr;
    }

    /* renamed from: b */
    float[] m1108b() {
        return this.f1243B;
    }

    /* renamed from: b */
    void m1106b(float[] fArr) {
        this.f1244C = fArr;
    }

    /* renamed from: c */
    float[] m1111c() {
        return this.f1283t == StrokeSprite.Type.Zenbrush ? this.f1245D : this.f1244C;
    }

    /* renamed from: a */
    void m1102a(float[] fArr, float[] fArr2) {
        m1101a(fArr);
        m1106b(fArr2);
    }

    /* renamed from: c */
    void m1110c(float[] fArr) {
        this.f1246E = fArr;
    }

    /* renamed from: d */
    float[] m1113d() {
        return this.f1246E;
    }

    /* renamed from: d */
    void m1112d(float[] fArr) {
        this.f1247F = fArr;
    }

    /* renamed from: e */
    float[] m1114e() {
        return this.f1283t == StrokeSprite.Type.Zenbrush ? this.f1248G : this.f1247F;
    }

    /* renamed from: b */
    void m1107b(float[] fArr, float[] fArr2) {
        m1110c(fArr);
        m1112d(fArr2);
    }

    public android.graphics.PointF getCorrectionPoint() {
        return this.f1287x;
    }

    /* renamed from: b */
    void m1105b(int i) throws IOException {
        this.f1249H = String.valueOf(this.f1249H) + "/" + Integer.toString(i);
        try {
            new File(String.valueOf(this.f1249H) + "/.nomedia").createNewFile();
        } catch (IOException e) {
        }
    }

    /* renamed from: f */
    String m1115f() {
        return this.f1253L;
    }

    /* renamed from: g */
    String m1116g() {
        return this.f1249H;
    }

    /* renamed from: h */
    int m1117h() {
        return this.f1251J;
    }

    /* renamed from: i */
    int m1118i() {
        return this.f1252K;
    }

    /* renamed from: j */
    boolean m1119j() {
        return this.f1242A;
    }

    /* renamed from: k */
    View m1120k() {
        return this.f1279p;
    }

    public void setTextColor(int color) {
        this.f1256O = color;
    }

    public void setTextSize(int size) {
        this.f1254M = size;
    }

    public int getTextColor() {
        return this.f1256O;
    }

    public int getTextSize() {
        return this.f1254M;
    }

    public void setTextType(int textType) {
        this.f1257P = textType;
    }

    public int getTextType() {
        return this.f1257P;
    }

    public void setTextFont(String font) {
        this.f1258Q = font;
    }

    public String getTextFont() {
        return this.f1258Q;
    }

    public void setTextAlignment(Layout.Alignment align) {
        this.f1259R = align;
    }

    public Layout.Alignment getTextAlignment() {
        return this.f1259R;
    }

    public void setMaxTextSize(int size) {
        this.f1255N = size;
    }

    public int getMaxTextSize() {
        return this.f1255N;
    }

    /* renamed from: n */
    private static String m1097n() {
        String str = null;
        File[] fileArrListFiles = new File("/system/fonts/").listFiles();
        if (fileArrListFiles != null) {
            int length = fileArrListFiles.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                if (!fileArrListFiles[i].getName().endsWith("Sans.ttf")) {
                    i++;
                } else {
                    str = "Sans serif";
                    break;
                }
            }
        }
        if (str == null) {
            return "Sans serif";
        }
        return str;
    }

    public void setFillingColor(int color) {
        this.f1266Y = color;
    }

    public int getFillingColor() {
        return this.f1266Y;
    }

    public void removeCacheFiles() {
        File file;
        if (this.f1249H != null && (file = new File(this.f1249H)) != null) {
            String[] list = file.list();
            if (list != null) {
                for (String str : list) {
                    File file2 = new File(String.valueOf(this.f1249H) + str);
                    if (file2.exists() && !file2.delete()) {
                        return;
                    }
                }
            }
            if (file.delete()) {
            }
        }
    }

    public void setUseHistoricalEvents(boolean set) {
        this.f1260S = set;
    }

    public boolean getUseHistoricalEvents() {
        return this.f1260S;
    }

    public HashMap<Integer, PenSettingInfo> getPenSettingInfos() {
        return this.f1261T;
    }

    public void setPenSettingInfos(int userID, PenSettingInfo penSettingInfo) {
        if (this.f1261T.containsKey(Integer.valueOf(userID))) {
            PenSettingInfo penSettingInfo2 = this.f1261T.get(Integer.valueOf(userID));
            penSettingInfo2.setPenType(penSettingInfo.getPenType());
            penSettingInfo2.setPenColor(penSettingInfo.getPenColor());
            penSettingInfo2.setPenWidth(penSettingInfo.getPenWidth());
            penSettingInfo2.setPenAlpha(penSettingInfo.getPenAlpha());
            if (penSettingInfo.getPenType() == 4) {
                penSettingInfo2.setEraserWidth(penSettingInfo.getEraserWidth());
            }
            this.f1261T.put(Integer.valueOf(userID), penSettingInfo2);
            return;
        }
        this.f1261T.put(Integer.valueOf(userID), penSettingInfo);
    }

    public PenSettingInfo getPenSettingInfo(int userID) {
        if (this.f1261T.containsKey(Integer.valueOf(userID))) {
            return this.f1261T.get(Integer.valueOf(userID));
        }
        return null;
    }

    public HashMap<Integer, TextSettingInfo> getTextSettingInfos() {
        return this.f1262U;
    }

    public void setTextSettingInfos(int userID, TextSettingInfo textSettingInfo) {
        this.f1262U.put(Integer.valueOf(userID), textSettingInfo);
    }

    public TextSettingInfo getTextSettingInfo(int userID) {
        if (!this.f1262U.containsKey(Integer.valueOf(userID))) {
            this.f1262U.put(Integer.valueOf(userID), null);
        }
        return this.f1262U.get(Integer.valueOf(userID));
    }

    public HashMap<Integer, FillingSettingInfo> getFillingSettingInfos() {
        return this.f1263V;
    }

    public void setFillingSettingInfos(int userID, FillingSettingInfo fillingSettingInfo) {
        this.f1263V.put(Integer.valueOf(userID), fillingSettingInfo);
    }

    public FillingSettingInfo getFillingSettingInfo(int userID) {
        if (!this.f1263V.containsKey(Integer.valueOf(userID))) {
            this.f1263V.put(Integer.valueOf(userID), null);
        }
        return this.f1263V.get(Integer.valueOf(userID));
    }

    public void setMyOpenID(int userID) {
        this.f1264W = userID;
    }

    public int getUserID() {
        return this.f1264W;
    }

    public void setOnDrawCancelListener(CanvasView.OnCancelListener listener) {
        this.mOnDrawCancelListener = listener;
    }

    public void setMultiObjectId(int mulitObjectId) {
        this.f1265X = mulitObjectId;
    }

    public int getMultiObjectId() {
        return this.f1265X;
    }

    public void setTextLongClickSelectOption(boolean bTextLongClickSelectable) {
        this.f1270ac = bTextLongClickSelectable;
    }

    public boolean getTextLongClickSelectOption() {
        return this.f1270ac;
    }

    public void setImageObjectMinimumEditableSize(int nMinSize) {
        this.f1271ad = nMinSize;
    }

    public int getImageObjectMinimumEditableSize() {
        return this.f1271ad;
    }

    /* renamed from: a */
    void m1100a(boolean z) {
        this.f1267Z = z;
    }

    /* renamed from: l */
    boolean m1121l() {
        return this.f1267Z;
    }

    /* renamed from: m */
    boolean m1122m() {
        return this.f1268aa;
    }

    public void setEraserWidth(float width) {
        this.f1281r = width;
    }

    public float getEraserWidth() {
        return this.f1281r;
    }

    public boolean getTextZoomMode() {
        return this.f1269ab;
    }

    public void setTextZoomMode(boolean bTextZoomMode) {
        this.f1269ab = bTextZoomMode;
    }

    /* renamed from: a */
    float[] m1104a(StrokeSprite.Type type) {
        return type == StrokeSprite.Type.Zenbrush ? this.f1245D : this.f1244C;
    }

    /* renamed from: b */
    float[] m1109b(StrokeSprite.Type type) {
        return type == StrokeSprite.Type.Zenbrush ? this.f1248G : this.f1247F;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:50:0x006a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String makeFillCacheFile(com.samsung.sdraw.AbstractModeContext r6, android.graphics.Bitmap r7) throws java.lang.Throwable {
        /*
            r5 = this;
            r0 = 0
            com.samsung.sdraw.Setting r1 = r6.setting     // Catch: java.io.IOException -> L4a java.lang.Throwable -> L65
            java.lang.String r1 = r1.m1116g()     // Catch: java.io.IOException -> L4a java.lang.Throwable -> L65
            if (r1 == 0) goto L87
            if (r7 == 0) goto L48
            java.io.File r2 = new java.io.File     // Catch: java.io.IOException -> L4a java.lang.Throwable -> L65
            r2.<init>(r1)     // Catch: java.io.IOException -> L4a java.lang.Throwable -> L65
            boolean r1 = r2.mkdirs()     // Catch: java.io.IOException -> L4a java.lang.Throwable -> L65
            if (r1 != 0) goto L1d
            java.lang.String r1 = "SPen"
            java.lang.String r3 = "cache file delete failed"
            com.samsung.sdraw.C0993af.m1275a(r1, r3)     // Catch: java.io.IOException -> L4a java.lang.Throwable -> L65
        L1d:
            java.lang.String r1 = "fillColorCache"
            java.lang.String r3 = ".png"
            java.io.File r1 = java.io.File.createTempFile(r1, r3, r2)     // Catch: java.io.IOException -> L4a java.lang.Throwable -> L65
            if (r1 == 0) goto L87
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch: java.io.IOException -> L4a java.lang.Throwable -> L65
            r2.<init>(r1)     // Catch: java.io.IOException -> L4a java.lang.Throwable -> L65
            android.graphics.Bitmap$CompressFormat r3 = android.graphics.Bitmap.CompressFormat.PNG     // Catch: java.lang.Throwable -> L83 java.io.IOException -> L85
            r4 = 100
            r7.compress(r3, r4, r2)     // Catch: java.lang.Throwable -> L83 java.io.IOException -> L85
            java.lang.String r0 = r1.getAbsolutePath()     // Catch: java.lang.Throwable -> L83 java.io.IOException -> L85
        L37:
            if (r2 == 0) goto L3c
            r2.close()     // Catch: java.io.IOException -> L7e
        L3c:
            if (r7 == 0) goto L47
            boolean r1 = r7.isRecycled()
            if (r1 != 0) goto L47
            r7.recycle()
        L47:
            return r0
        L48:
            r2 = r0
            goto L37
        L4a:
            r1 = move-exception
            r2 = r0
        L4c:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L83
            if (r2 == 0) goto L54
            r2.close()     // Catch: java.io.IOException -> L60
        L54:
            if (r7 == 0) goto L47
            boolean r1 = r7.isRecycled()
            if (r1 != 0) goto L47
            r7.recycle()
            goto L47
        L60:
            r1 = move-exception
            r1.printStackTrace()
            goto L54
        L65:
            r1 = move-exception
            r2 = r0
            r0 = r1
        L68:
            if (r2 == 0) goto L6d
            r2.close()     // Catch: java.io.IOException -> L79
        L6d:
            if (r7 == 0) goto L78
            boolean r1 = r7.isRecycled()
            if (r1 != 0) goto L78
            r7.recycle()
        L78:
            throw r0
        L79:
            r1 = move-exception
            r1.printStackTrace()
            goto L6d
        L7e:
            r1 = move-exception
            r1.printStackTrace()
            goto L3c
        L83:
            r0 = move-exception
            goto L68
        L85:
            r1 = move-exception
            goto L4c
        L87:
            r2 = r0
            goto L37
        */
        throw new UnsupportedOperationException("Method not decompiled: com.samsung.sdraw.Setting.makeFillCacheFile(com.samsung.sdraw.AbstractModeContext, android.graphics.Bitmap):java.lang.String");
    }

    public void setMaxMultiUserDrawingCount(int numberOfUsers) {
        this.f1272ae = numberOfUsers;
    }

    public int getMaxMultiUserDrawingCount() {
        return this.f1272ae;
    }

    public void setOnDrawingInformationListener(CanvasView.OnDrawingInformationListener listener) {
        this.mOnDrawingInformationListener = listener;
    }
}
