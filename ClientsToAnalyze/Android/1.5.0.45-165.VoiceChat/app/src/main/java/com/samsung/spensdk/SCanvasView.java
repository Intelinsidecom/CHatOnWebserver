package com.samsung.spensdk;

import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.samsung.samm.common.SDataAttachFile;
import com.samsung.samm.common.SDataPageMemo;
import com.samsung.samm.common.SObject;
import com.samsung.samm.common.SObjectFilling;
import com.samsung.samm.common.SObjectImage;
import com.samsung.samm.common.SObjectStroke;
import com.samsung.samm.common.SObjectText;
import com.samsung.samm.common.SOptionSCanvas;
import com.samsung.samm.lib.C0907e;
import com.samsung.samm.lib.InterfaceC0886a;
import com.samsung.samm.lib.p003a.C0902p;
import com.samsung.sdraw.CanvasView;
import com.samsung.sdraw.HistoryData;
import com.samsung.sdraw.ObjectInfo;
import com.samsung.sdraw.PenSettingInfo;
import com.samsung.sdraw.SettingView;
import com.samsung.sdraw.StrokeInfo;
import com.samsung.sdraw.TextInfo;
import com.samsung.sdraw.TextSettingInfo;
import com.samsung.spen.engine.signature.C1100a;
import com.samsung.spen.lib.input.SPenEvent;
import com.samsung.spen.lib.input.SPenEventLibrary;
import com.samsung.spen.lib.input.SPenLibrary;
import com.samsung.spen.lib.input.core.SPenDetachmentReceiver;
import com.samsung.spen.p005a.p006a.InterfaceC1072b;
import com.samsung.spen.p005a.p006a.RunnableC1071a;
import com.samsung.spen.p005a.p007b.C1073a;
import com.samsung.spen.p005a.p007b.InterfaceC1074b;
import com.samsung.spen.p005a.p008c.InterfaceC1079b;
import com.samsung.spen.p005a.p008c.RunnableC1078a;
import com.samsung.spen.p005a.p009d.C1084b;
import com.samsung.spen.p005a.p009d.InterfaceC1085c;
import com.samsung.spen.p005a.p010e.C1093b;
import com.samsung.spen.p005a.p010e.InterfaceC1092a;
import com.samsung.spen.p005a.p011f.C1097d;
import com.samsung.spen.p005a.p011f.InterfaceC1094a;
import com.samsung.spen.p005a.p012g.C1099b;
import com.samsung.spen.p005a.p012g.InterfaceC1098a;
import com.samsung.spen.settings.SettingFillingInfo;
import com.samsung.spen.settings.SettingStrokeInfo;
import com.samsung.spen.settings.SettingTextInfo;
import com.samsung.spensdk.applistener.AnimationProcessListener;
import com.samsung.spensdk.applistener.ColorPickerColorChangeListener;
import com.samsung.spensdk.applistener.CustomSoundEffectSettingListener;
import com.samsung.spensdk.applistener.FileProcessListener;
import com.samsung.spensdk.applistener.HistoryUpdateListener;
import com.samsung.spensdk.applistener.SCanvasDeleteAllConfirmListener;
import com.samsung.spensdk.applistener.SCanvasInitializeListener;
import com.samsung.spensdk.applistener.SCanvasLongPressListener;
import com.samsung.spensdk.applistener.SCanvasMatrixChangeListener;
import com.samsung.spensdk.applistener.SCanvasModeChangedListener;
import com.samsung.spensdk.applistener.SObjectSelectListener;
import com.samsung.spensdk.applistener.SObjectUpdateListener;
import com.samsung.spensdk.applistener.SPenDetachmentListener;
import com.samsung.spensdk.applistener.SPenHoverListener;
import com.samsung.spensdk.applistener.SPenTouchIDListener;
import com.samsung.spensdk.applistener.SPenTouchListener;
import com.samsung.spensdk.applistener.SettingFillingChangeListener;
import com.samsung.spensdk.applistener.SettingPresetDeleteBtnClickListener;
import com.samsung.spensdk.applistener.SettingStrokeChangeListener;
import com.samsung.spensdk.applistener.SettingTextChangeListener;
import com.samsung.spensdk.applistener.SettingViewShowListener;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;
import java.io.File;
import java.nio.IntBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

/* loaded from: classes.dex */
public class SCanvasView extends C1084b {
    public static final String TAG = "SPenSDK";

    /* renamed from: A */
    SettingFillingChangeListener f2053A;

    /* renamed from: B */
    SettingPresetDeleteBtnClickListener f2054B;

    /* renamed from: C */
    SettingPresetDeleteBtnClickListener f2055C;

    /* renamed from: D */
    ColorPickerColorChangeListener f2056D;

    /* renamed from: E */
    ColorPickerColorChangeListener f2057E;

    /* renamed from: F */
    FileProcessListener f2058F;

    /* renamed from: G */
    FileProcessListener f2059G;

    /* renamed from: H */
    AnimationProcessListener f2060H;

    /* renamed from: I */
    AnimationProcessListener f2061I;

    /* renamed from: J */
    SObjectSelectListener f2062J;

    /* renamed from: K */
    SObjectSelectListener f2063K;

    /* renamed from: L */
    SObjectUpdateListener f2064L;

    /* renamed from: M */
    SObjectUpdateListener f2065M;

    /* renamed from: N */
    SPenTouchListener f2066N;

    /* renamed from: O */
    SPenDetachmentReceiver f2067O;

    /* renamed from: P */
    CustomSoundEffectSettingListener f2068P;

    /* renamed from: Q */
    View.OnTouchListener f2069Q;

    /* renamed from: R */
    SPenTouchIDListener f2070R;

    /* renamed from: S */
    SPenTouchIDListener f2071S;

    /* renamed from: T */
    private Context f2072T;

    /* renamed from: U */
    private InterfaceC0886a f2073U;

    /* renamed from: V */
    private InterfaceC1098a f2074V;

    /* renamed from: W */
    private InterfaceC1074b f2075W;

    /* renamed from: Z */
    private InterfaceC1079b f2076Z;

    /* renamed from: aA */
    private SPenHoverListener f2077aA;

    /* renamed from: aB */
    private int f2078aB;

    /* renamed from: aC */
    private int f2079aC;

    /* renamed from: aD */
    private int f2080aD;

    /* renamed from: aE */
    private int f2081aE;

    /* renamed from: aa */
    private InterfaceC1094a f2082aa;

    /* renamed from: ab */
    private InterfaceC1072b f2083ab;

    /* renamed from: ac */
    private InterfaceC1092a f2084ac;

    /* renamed from: ad */
    private InterfaceC1085c f2085ad;

    /* renamed from: ae */
    private SOptionSCanvas f2086ae;

    /* renamed from: af */
    private int f2087af;

    /* renamed from: ag */
    private int f2088ag;

    /* renamed from: ah */
    private boolean f2089ah;

    /* renamed from: ai */
    private boolean f2090ai;

    /* renamed from: aj */
    private boolean f2091aj;

    /* renamed from: ak */
    private boolean f2092ak;

    /* renamed from: al */
    private String f2093al;

    /* renamed from: am */
    private boolean f2094am;

    /* renamed from: an */
    private boolean f2095an;

    /* renamed from: ao */
    private boolean f2096ao;

    /* renamed from: ap */
    private ViewGroup f2097ap;

    /* renamed from: aq */
    private ViewGroup f2098aq;

    /* renamed from: ar */
    private HashMap<String, Integer> f2099ar;

    /* renamed from: as */
    private HashMap<String, String> f2100as;

    /* renamed from: at */
    private boolean f2101at;

    /* renamed from: au */
    private C1100a f2102au;

    /* renamed from: av */
    private CanvasView.OnInitializeFinishListener f2103av;

    /* renamed from: aw */
    private CanvasView.OnInitializeFinishListener f2104aw;

    /* renamed from: ax */
    private OnFileProcessingProgressListener f2105ax;

    /* renamed from: ay */
    private OnPlayProgressChangeListener f2106ay;

    /* renamed from: az */
    private OnPlayCompleteListener f2107az;

    /* renamed from: e */
    SCanvasInitializeListener f2108e;

    /* renamed from: f */
    SCanvasInitializeListener f2109f;

    /* renamed from: g */
    SCanvasMatrixChangeListener f2110g;

    /* renamed from: h */
    SCanvasMatrixChangeListener f2111h;

    /* renamed from: i */
    SCanvasModeChangedListener f2112i;

    /* renamed from: j */
    SCanvasModeChangedListener f2113j;

    /* renamed from: k */
    boolean f2114k;

    /* renamed from: l */
    SCanvasDeleteAllConfirmListener f2115l;

    /* renamed from: m */
    SCanvasDeleteAllConfirmListener f2116m;

    /* renamed from: n */
    HistoryUpdateListener f2117n;

    /* renamed from: o */
    HistoryUpdateListener f2118o;

    /* renamed from: p */
    CanvasView.OnHistoryChangeListener f2119p;

    /* renamed from: q */
    SCanvasLongPressListener f2120q;

    /* renamed from: r */
    SCanvasLongPressListener f2121r;

    /* renamed from: s */
    SettingViewShowListener f2122s;

    /* renamed from: t */
    SettingViewShowListener f2123t;

    /* renamed from: u */
    CanvasView.OnSettingViewShowListener f2124u;

    /* renamed from: v */
    SettingStrokeChangeListener f2125v;

    /* renamed from: w */
    SettingStrokeChangeListener f2126w;

    /* renamed from: x */
    SettingTextChangeListener f2127x;

    /* renamed from: y */
    SettingTextChangeListener f2128y;

    /* renamed from: z */
    SettingFillingChangeListener f2129z;

    @Deprecated
    public interface OnFileProcessingProgressListener {
        void onChangeProgress(int i);

        void onLoadComplete(boolean z);
    }

    @Deprecated
    public interface OnPlayCompleteListener {
        void onPlayComplete();
    }

    @Deprecated
    public interface OnPlayProgressChangeListener {
        void onChangeProgress(int i);
    }

    public static String getSDKVersion() {
        return "20130618";
    }

    public static String getSAMMVersion() {
        return C0907e.m606O();
    }

    public SCanvasView(Context context) {
        super(context);
        this.f2072T = null;
        this.f2073U = null;
        this.f2074V = null;
        this.f2075W = null;
        this.f2076Z = null;
        this.f2082aa = null;
        this.f2083ab = null;
        this.f2084ac = null;
        this.f2085ad = this;
        this.f2086ae = null;
        this.f2087af = 0;
        this.f2088ag = 0;
        this.f2089ah = true;
        this.f2090ai = true;
        this.f2091aj = false;
        this.f2092ak = false;
        this.f2093al = null;
        this.f2094am = false;
        this.f2095an = false;
        this.f2096ao = false;
        this.f2097ap = null;
        this.f2098aq = null;
        this.f2099ar = new HashMap<>();
        this.f2100as = new HashMap<>();
        this.f2101at = true;
        this.f2108e = new SCanvasInitializeListener() { // from class: com.samsung.spensdk.SCanvasView.1
            @Override // com.samsung.spensdk.applistener.SCanvasInitializeListener
            public void onInitialized() {
                Log.w(SCanvasView.TAG, "SCanvasLayout has been initialized!!");
            }
        };
        this.f2109f = new SCanvasInitializeListener() { // from class: com.samsung.spensdk.SCanvasView.12
            @Override // com.samsung.spensdk.applistener.SCanvasInitializeListener
            public void onInitialized() {
                if (SCanvasView.this.f2108e != null) {
                    SCanvasView.this.f2108e.onInitialized();
                }
            }
        };
        this.f2103av = null;
        this.f2104aw = new CanvasView.OnInitializeFinishListener() { // from class: com.samsung.spensdk.SCanvasView.21
            @Override // com.samsung.sdraw.CanvasView.OnInitializeFinishListener
            public void onFinish() {
                SCanvasView.this.m2008d();
                if (SCanvasView.this.f2103av != null) {
                    SCanvasView.this.f2103av.onFinish();
                }
                if (SCanvasView.this.f2108e != null) {
                    SCanvasView.this.f2108e.onInitialized();
                }
            }
        };
        this.f2110g = new SCanvasMatrixChangeListener() { // from class: com.samsung.spensdk.SCanvasView.22
            @Override // com.samsung.spensdk.applistener.SCanvasMatrixChangeListener
            public void onMatrixChanged(Matrix matrix) {
                Log.w(SCanvasView.TAG, "SCanvas matrix has been changed!!");
            }

            @Override // com.samsung.spensdk.applistener.SCanvasMatrixChangeListener
            public void onMatrixChangeFinished() {
                Log.w(SCanvasView.TAG, "SCanvas matrix changement has finished changed!!");
            }
        };
        this.f2111h = new SCanvasMatrixChangeListener() { // from class: com.samsung.spensdk.SCanvasView.23
            @Override // com.samsung.spensdk.applistener.SCanvasMatrixChangeListener
            public void onMatrixChanged(Matrix matrix) {
                if (SCanvasView.this.f2110g != null) {
                    SCanvasView.this.f2110g.onMatrixChanged(matrix);
                }
            }

            @Override // com.samsung.spensdk.applistener.SCanvasMatrixChangeListener
            public void onMatrixChangeFinished() {
                if (SCanvasView.this.f2110g != null) {
                    SCanvasView.this.f2110g.onMatrixChangeFinished();
                }
            }
        };
        this.f2112i = new SCanvasModeChangedListener() { // from class: com.samsung.spensdk.SCanvasView.24
            @Override // com.samsung.spensdk.applistener.SCanvasModeChangedListener
            public void onModeChanged(int i) {
                Log.w(SCanvasView.TAG, "SCanvasMode has been changed!!");
            }
        };
        this.f2113j = new SCanvasModeChangedListener() { // from class: com.samsung.spensdk.SCanvasView.25
            @Override // com.samsung.spensdk.applistener.SCanvasModeChangedListener
            public void onModeChanged(int i) {
                if (SCanvasView.this.f2112i != null) {
                    SCanvasView.this.f2112i.onModeChanged(i);
                }
            }
        };
        this.f2114k = false;
        this.f2115l = new SCanvasDeleteAllConfirmListener() { // from class: com.samsung.spensdk.SCanvasView.26
            @Override // com.samsung.spensdk.applistener.SCanvasDeleteAllConfirmListener
            public boolean onDeleteAllConfirm(int i) {
                Log.w(SCanvasView.TAG, String.valueOf(i) + " Layer DeleteAll button has been clicked!!");
                return true;
            }
        };
        this.f2116m = new SCanvasDeleteAllConfirmListener() { // from class: com.samsung.spensdk.SCanvasView.27
            @Override // com.samsung.spensdk.applistener.SCanvasDeleteAllConfirmListener
            public boolean onDeleteAllConfirm(int i) {
                if (SCanvasView.this.f2115l == null || !SCanvasView.this.f2114k) {
                    return false;
                }
                return SCanvasView.this.f2115l.onDeleteAllConfirm(i);
            }
        };
        this.f2117n = new HistoryUpdateListener() { // from class: com.samsung.spensdk.SCanvasView.2
            @Override // com.samsung.spensdk.applistener.HistoryUpdateListener
            public void onHistoryChanged(boolean z, boolean z2) {
            }
        };
        this.f2118o = new HistoryUpdateListener() { // from class: com.samsung.spensdk.SCanvasView.3
            @Override // com.samsung.spensdk.applistener.HistoryUpdateListener
            public void onHistoryChanged(boolean z, boolean z2) {
                if (SCanvasView.this.f2117n != null) {
                    SCanvasView.this.f2117n.onHistoryChanged(SCanvasView.this.isUndoable(), SCanvasView.this.isRedoable());
                }
                if (SCanvasView.this.f2119p != null) {
                    SCanvasView.this.f2119p.onHistoryChanged(SCanvasView.this.isUndoable(), SCanvasView.this.isRedoable());
                }
            }
        };
        this.f2119p = new CanvasView.OnHistoryChangeListener() { // from class: com.samsung.spensdk.SCanvasView.4
            @Override // com.samsung.sdraw.CanvasView.OnHistoryChangeListener
            public void onHistoryChanged(boolean z, boolean z2) {
            }
        };
        this.f2120q = new SCanvasLongPressListener() { // from class: com.samsung.spensdk.SCanvasView.5
            @Override // com.samsung.spensdk.applistener.SCanvasLongPressListener
            public void onLongPressed(float f, float f2) {
            }

            @Override // com.samsung.spensdk.applistener.SCanvasLongPressListener
            public void onLongPressed() {
            }
        };
        this.f2121r = new SCanvasLongPressListener() { // from class: com.samsung.spensdk.SCanvasView.6
            @Override // com.samsung.spensdk.applistener.SCanvasLongPressListener
            public void onLongPressed(float f, float f2) {
                SCanvasView.this.f2120q.onLongPressed(f, f2);
            }

            @Override // com.samsung.spensdk.applistener.SCanvasLongPressListener
            public void onLongPressed() {
                SCanvasView.this.f2120q.onLongPressed();
            }
        };
        this.f2122s = null;
        this.f2123t = new SettingViewShowListener() { // from class: com.samsung.spensdk.SCanvasView.7
            @Override // com.samsung.spensdk.applistener.SettingViewShowListener
            public void onPenSettingViewShow(boolean z) {
                Log.i(SCanvasView.TAG, "PenSettingViewShow : " + z);
                if (SCanvasView.this.f2122s != null) {
                    SCanvasView.this.f2122s.onPenSettingViewShow(z);
                }
                if (SCanvasView.this.f2124u != null) {
                    SCanvasView.this.f2124u.onPenSettingViewShow(z);
                }
            }

            @Override // com.samsung.spensdk.applistener.SettingViewShowListener
            public void onEraserSettingViewShow(boolean z) {
                Log.i(SCanvasView.TAG, "EraserSettingViewShow : " + z);
                if (SCanvasView.this.f2122s != null) {
                    SCanvasView.this.f2122s.onEraserSettingViewShow(z);
                }
                if (SCanvasView.this.f2124u != null) {
                    SCanvasView.this.f2124u.onEraserSettingViewShow(z);
                }
            }

            @Override // com.samsung.spensdk.applistener.SettingViewShowListener
            public void onTextSettingViewShow(boolean z) {
                Log.i(SCanvasView.TAG, "TextSettingViewShow : " + z);
                if (SCanvasView.this.f2122s != null) {
                    SCanvasView.this.f2122s.onTextSettingViewShow(z);
                }
                if (SCanvasView.this.f2124u != null) {
                    SCanvasView.this.f2124u.onTextSettingViewShow(z);
                }
            }

            @Override // com.samsung.spensdk.applistener.SettingViewShowListener
            public void onFillingSettingViewShow(boolean z) {
                Log.i(SCanvasView.TAG, "FillingSettingViewShow : " + z);
                if (SCanvasView.this.f2122s != null) {
                    SCanvasView.this.f2122s.onFillingSettingViewShow(z);
                }
                if (SCanvasView.this.f2124u != null) {
                    SCanvasView.this.f2124u.onFillingSettingViewShow(z);
                }
            }
        };
        this.f2124u = null;
        this.f2125v = null;
        this.f2126w = new SettingStrokeChangeListener() { // from class: com.samsung.spensdk.SCanvasView.8
            @Override // com.samsung.spensdk.applistener.SettingStrokeChangeListener
            public void onStrokeColorChanged(int i) {
                if (SCanvasView.this.f2125v != null) {
                    SCanvasView.this.f2125v.onStrokeColorChanged(i);
                }
            }

            @Override // com.samsung.spensdk.applistener.SettingStrokeChangeListener
            public void onStrokeAlphaChanged(int i) {
                if (SCanvasView.this.f2125v != null) {
                    SCanvasView.this.f2125v.onStrokeAlphaChanged(i);
                }
            }

            @Override // com.samsung.spensdk.applistener.SettingStrokeChangeListener
            public void onStrokeStyleChanged(int i) {
                if (SCanvasView.this.f2125v != null) {
                    SCanvasView.this.f2125v.onStrokeStyleChanged(i);
                }
            }

            @Override // com.samsung.spensdk.applistener.SettingStrokeChangeListener
            public void onStrokeWidthChanged(int i) {
                if (SCanvasView.this.f2125v != null) {
                    SCanvasView.this.f2125v.onStrokeWidthChanged(i);
                }
            }

            @Override // com.samsung.spensdk.applistener.SettingStrokeChangeListener
            public void onEraserWidthChanged(int i) {
                if (SCanvasView.this.f2125v != null) {
                    SCanvasView.this.f2125v.onEraserWidthChanged(i);
                }
            }

            @Override // com.samsung.spensdk.applistener.SettingStrokeChangeListener
            public void onDeleteAll(boolean z) {
                if (SCanvasView.this.f2125v != null) {
                    SCanvasView.this.f2125v.onDeleteAll(z);
                }
            }

            @Override // com.samsung.spensdk.applistener.SettingStrokeChangeListener
            public void onClearAll(boolean z) {
                if (SCanvasView.this.f2125v != null) {
                    SCanvasView.this.f2125v.onClearAll(z);
                }
            }
        };
        this.f2127x = null;
        this.f2128y = new SettingTextChangeListener() { // from class: com.samsung.spensdk.SCanvasView.9
            @Override // com.samsung.spensdk.applistener.SettingTextChangeListener
            public void onTextColorChanged(int i) {
                if (SCanvasView.this.f2127x != null) {
                    SCanvasView.this.f2127x.onTextColorChanged(i);
                }
            }

            @Override // com.samsung.spensdk.applistener.SettingTextChangeListener
            public void onTextFontChanged(String str) {
                if (SCanvasView.this.f2127x != null) {
                    SCanvasView.this.f2127x.onTextFontChanged(str);
                }
            }

            @Override // com.samsung.spensdk.applistener.SettingTextChangeListener
            public void onTextSizeChanged(int i) {
                if (SCanvasView.this.f2127x != null) {
                    SCanvasView.this.f2127x.onTextSizeChanged(i);
                }
            }

            @Override // com.samsung.spensdk.applistener.SettingTextChangeListener
            public void onTextStyleChanged(int i) {
                if (SCanvasView.this.f2127x != null) {
                    SCanvasView.this.f2127x.onTextStyleChanged(i);
                }
            }

            @Override // com.samsung.spensdk.applistener.SettingTextChangeListener
            public void onTextAlignmentChanged(int i) {
                if (SCanvasView.this.f2127x != null) {
                    SCanvasView.this.f2127x.onTextAlignmentChanged(i);
                }
            }
        };
        this.f2129z = null;
        this.f2053A = new SettingFillingChangeListener() { // from class: com.samsung.spensdk.SCanvasView.10
            @Override // com.samsung.spensdk.applistener.SettingFillingChangeListener
            public void onFillingColorChanged(int i) {
                if (SCanvasView.this.f2129z != null) {
                    SCanvasView.this.f2129z.onFillingColorChanged(i);
                }
            }
        };
        this.f2054B = null;
        this.f2055C = new SettingPresetDeleteBtnClickListener() { // from class: com.samsung.spensdk.SCanvasView.11
            @Override // com.samsung.spensdk.applistener.SettingPresetDeleteBtnClickListener
            public void onClick(int i) {
                if (SCanvasView.this.f2054B != null) {
                    SCanvasView.this.f2054B.onClick(i);
                }
            }
        };
        this.f2056D = null;
        this.f2057E = new ColorPickerColorChangeListener() { // from class: com.samsung.spensdk.SCanvasView.13
            @Override // com.samsung.spensdk.applistener.ColorPickerColorChangeListener
            public void onColorPickerColorChanged(int i) {
                if (SCanvasView.this.f2056D != null) {
                    SCanvasView.this.f2056D.onColorPickerColorChanged(i);
                }
            }
        };
        this.f2058F = null;
        this.f2059G = new FileProcessListener() { // from class: com.samsung.spensdk.SCanvasView.14
            @Override // com.samsung.spensdk.applistener.FileProcessListener
            public void onChangeProgress(int i) {
                if (SCanvasView.this.f2058F != null) {
                    SCanvasView.this.f2058F.onChangeProgress(i);
                }
                if (SCanvasView.this.f2105ax == null) {
                    return;
                }
                SCanvasView.this.f2105ax.onChangeProgress(i);
            }

            @Override // com.samsung.spensdk.applistener.FileProcessListener
            public void onLoadComplete(boolean z) {
                if (SCanvasView.this.f2058F != null) {
                    SCanvasView.this.f2058F.onLoadComplete(z);
                }
                if (SCanvasView.this.f2105ax != null) {
                    SCanvasView.this.f2105ax.onLoadComplete(z);
                }
                SCanvasView.this.f2075W.mo1736j(true);
                SCanvasView.this.invalidate();
                if (SCanvasView.this.getSelectLayer() == 0) {
                    SCanvasView.this.f2094am = false;
                } else if (SCanvasView.this.getSelectLayer() == 1) {
                    SCanvasView.this.f2095an = false;
                }
            }
        };
        this.f2105ax = null;
        this.f2060H = null;
        this.f2061I = new AnimationProcessListener() { // from class: com.samsung.spensdk.SCanvasView.15
            @Override // com.samsung.spensdk.applistener.AnimationProcessListener
            public void onPlayComplete() {
                if (SCanvasView.this.f2060H != null) {
                    SCanvasView.this.f2060H.onPlayComplete();
                }
                if (SCanvasView.this.f2107az == null) {
                    return;
                }
                SCanvasView.this.f2107az.onPlayComplete();
            }

            @Override // com.samsung.spensdk.applistener.AnimationProcessListener
            public void onChangeProgress(int i) {
                if (SCanvasView.this.f2060H != null) {
                    SCanvasView.this.f2060H.onChangeProgress(i);
                }
                if (SCanvasView.this.f2106ay == null) {
                    return;
                }
                SCanvasView.this.f2106ay.onChangeProgress(i);
            }
        };
        this.f2106ay = null;
        this.f2107az = null;
        this.f2062J = null;
        this.f2063K = new SObjectSelectListener() { // from class: com.samsung.spensdk.SCanvasView.16
            @Override // com.samsung.spensdk.applistener.SObjectSelectListener
            public void onSObjectSelected(SObject sObject, boolean z) {
                if (SCanvasView.this.f2062J != null) {
                    SCanvasView.this.f2062J.onSObjectSelected(sObject, z);
                }
            }
        };
        this.f2064L = null;
        this.f2065M = new SObjectUpdateListener() { // from class: com.samsung.spensdk.SCanvasView.17
            @Override // com.samsung.spensdk.applistener.SObjectUpdateListener
            public void onSObjectInserted(SObject sObject, boolean z, boolean z2) {
                if (sObject.getLayer() == 0) {
                    SCanvasView.this.f2094am = true;
                } else if (sObject.getLayer() == 1) {
                    SCanvasView.this.f2095an = true;
                }
                if (SCanvasView.this.f2064L != null) {
                    SCanvasView.this.f2064L.onSObjectInserted(sObject, z, z2);
                }
            }

            @Override // com.samsung.spensdk.applistener.SObjectUpdateListener
            public void onSObjectDeleted(SObject sObject, boolean z, boolean z2, boolean z3) {
                if (sObject.getLayer() == 0) {
                    SCanvasView.this.f2094am = true;
                } else if (sObject.getLayer() == 1) {
                    SCanvasView.this.f2095an = true;
                }
                if (SCanvasView.this.f2064L != null) {
                    SCanvasView.this.f2064L.onSObjectDeleted(sObject, z, z2, z3);
                }
            }

            @Override // com.samsung.spensdk.applistener.SObjectUpdateListener
            public void onSObjectChanged(SObject sObject, boolean z, boolean z2) {
                if (sObject.getLayer() == 0) {
                    SCanvasView.this.f2094am = true;
                } else if (sObject.getLayer() == 1) {
                    SCanvasView.this.f2095an = true;
                }
                if (SCanvasView.this.f2064L != null) {
                    SCanvasView.this.f2064L.onSObjectChanged(sObject, z, z2);
                }
            }

            @Override // com.samsung.spensdk.applistener.SObjectUpdateListener
            public boolean onSObjectStrokeInserting(SObjectStroke sObjectStroke) {
                if (SCanvasView.this.f2064L != null) {
                    return SCanvasView.this.f2064L.onSObjectStrokeInserting(sObjectStroke);
                }
                return false;
            }

            @Override // com.samsung.spensdk.applistener.SObjectUpdateListener
            public void onSObjectSelected(SObject sObject, boolean z) {
                if (SCanvasView.this.f2064L != null) {
                    SCanvasView.this.f2064L.onSObjectSelected(sObject, z);
                }
            }

            @Override // com.samsung.spensdk.applistener.SObjectUpdateListener
            public void onSObjectDeletedAll(boolean z, int i) {
                if (i == 0) {
                    SCanvasView.this.f2094am = true;
                } else if (i == 1) {
                    SCanvasView.this.f2095an = true;
                }
                if (SCanvasView.this.f2064L != null) {
                    SCanvasView.this.f2064L.onSObjectDeletedAll(z, i);
                }
            }
        };
        this.f2066N = null;
        this.f2077aA = null;
        this.f2067O = null;
        this.f2068P = null;
        this.f2078aB = 0;
        this.f2079aC = -1;
        this.f2080aD = -1;
        this.f2081aE = -1;
        this.f2069Q = null;
        this.f2070R = new SPenTouchIDListener() { // from class: com.samsung.spensdk.SCanvasView.18
            @Override // com.samsung.spensdk.applistener.SPenTouchIDListener
            public boolean onTouchPen(View view, MotionEvent motionEvent, int i) {
                return false;
            }

            @Override // com.samsung.spensdk.applistener.SPenTouchIDListener
            public boolean onTouchPenEraser(View view, MotionEvent motionEvent, int i) {
                return false;
            }

            @Override // com.samsung.spensdk.applistener.SPenTouchIDListener
            public boolean onTouchFinger(View view, MotionEvent motionEvent, int i) {
                return false;
            }

            @Override // com.samsung.spensdk.applistener.SPenTouchIDListener
            public boolean onDrawingPen(View view, MotionEvent motionEvent, int i, int i2) {
                if (SCanvasView.this.f2071S == null) {
                    return false;
                }
                SPenEvent event = SPenLibrary.getEvent(motionEvent);
                if (event.isFinger()) {
                    return SCanvasView.this.f2071S.onDrawingPen(view, motionEvent, SCanvasView.this.f2080aD, 0);
                }
                if (event.isPen()) {
                    return SCanvasView.this.f2071S.onDrawingPen(view, motionEvent, SCanvasView.this.f2079aC, 1);
                }
                if (event.isEraserPen()) {
                    return SCanvasView.this.f2071S.onDrawingPen(view, motionEvent, SCanvasView.this.f2081aE, 2);
                }
                return false;
            }
        };
        this.f2071S = null;
        this.f2072T = context;
        super.setOnInitializeFinishListener(this.f2104aw);
    }

    public SCanvasView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2072T = null;
        this.f2073U = null;
        this.f2074V = null;
        this.f2075W = null;
        this.f2076Z = null;
        this.f2082aa = null;
        this.f2083ab = null;
        this.f2084ac = null;
        this.f2085ad = this;
        this.f2086ae = null;
        this.f2087af = 0;
        this.f2088ag = 0;
        this.f2089ah = true;
        this.f2090ai = true;
        this.f2091aj = false;
        this.f2092ak = false;
        this.f2093al = null;
        this.f2094am = false;
        this.f2095an = false;
        this.f2096ao = false;
        this.f2097ap = null;
        this.f2098aq = null;
        this.f2099ar = new HashMap<>();
        this.f2100as = new HashMap<>();
        this.f2101at = true;
        this.f2108e = new SCanvasInitializeListener() { // from class: com.samsung.spensdk.SCanvasView.1
            @Override // com.samsung.spensdk.applistener.SCanvasInitializeListener
            public void onInitialized() {
                Log.w(SCanvasView.TAG, "SCanvasLayout has been initialized!!");
            }
        };
        this.f2109f = new SCanvasInitializeListener() { // from class: com.samsung.spensdk.SCanvasView.12
            @Override // com.samsung.spensdk.applistener.SCanvasInitializeListener
            public void onInitialized() {
                if (SCanvasView.this.f2108e != null) {
                    SCanvasView.this.f2108e.onInitialized();
                }
            }
        };
        this.f2103av = null;
        this.f2104aw = new CanvasView.OnInitializeFinishListener() { // from class: com.samsung.spensdk.SCanvasView.21
            @Override // com.samsung.sdraw.CanvasView.OnInitializeFinishListener
            public void onFinish() {
                SCanvasView.this.m2008d();
                if (SCanvasView.this.f2103av != null) {
                    SCanvasView.this.f2103av.onFinish();
                }
                if (SCanvasView.this.f2108e != null) {
                    SCanvasView.this.f2108e.onInitialized();
                }
            }
        };
        this.f2110g = new SCanvasMatrixChangeListener() { // from class: com.samsung.spensdk.SCanvasView.22
            @Override // com.samsung.spensdk.applistener.SCanvasMatrixChangeListener
            public void onMatrixChanged(Matrix matrix) {
                Log.w(SCanvasView.TAG, "SCanvas matrix has been changed!!");
            }

            @Override // com.samsung.spensdk.applistener.SCanvasMatrixChangeListener
            public void onMatrixChangeFinished() {
                Log.w(SCanvasView.TAG, "SCanvas matrix changement has finished changed!!");
            }
        };
        this.f2111h = new SCanvasMatrixChangeListener() { // from class: com.samsung.spensdk.SCanvasView.23
            @Override // com.samsung.spensdk.applistener.SCanvasMatrixChangeListener
            public void onMatrixChanged(Matrix matrix) {
                if (SCanvasView.this.f2110g != null) {
                    SCanvasView.this.f2110g.onMatrixChanged(matrix);
                }
            }

            @Override // com.samsung.spensdk.applistener.SCanvasMatrixChangeListener
            public void onMatrixChangeFinished() {
                if (SCanvasView.this.f2110g != null) {
                    SCanvasView.this.f2110g.onMatrixChangeFinished();
                }
            }
        };
        this.f2112i = new SCanvasModeChangedListener() { // from class: com.samsung.spensdk.SCanvasView.24
            @Override // com.samsung.spensdk.applistener.SCanvasModeChangedListener
            public void onModeChanged(int i) {
                Log.w(SCanvasView.TAG, "SCanvasMode has been changed!!");
            }
        };
        this.f2113j = new SCanvasModeChangedListener() { // from class: com.samsung.spensdk.SCanvasView.25
            @Override // com.samsung.spensdk.applistener.SCanvasModeChangedListener
            public void onModeChanged(int i) {
                if (SCanvasView.this.f2112i != null) {
                    SCanvasView.this.f2112i.onModeChanged(i);
                }
            }
        };
        this.f2114k = false;
        this.f2115l = new SCanvasDeleteAllConfirmListener() { // from class: com.samsung.spensdk.SCanvasView.26
            @Override // com.samsung.spensdk.applistener.SCanvasDeleteAllConfirmListener
            public boolean onDeleteAllConfirm(int i) {
                Log.w(SCanvasView.TAG, String.valueOf(i) + " Layer DeleteAll button has been clicked!!");
                return true;
            }
        };
        this.f2116m = new SCanvasDeleteAllConfirmListener() { // from class: com.samsung.spensdk.SCanvasView.27
            @Override // com.samsung.spensdk.applistener.SCanvasDeleteAllConfirmListener
            public boolean onDeleteAllConfirm(int i) {
                if (SCanvasView.this.f2115l == null || !SCanvasView.this.f2114k) {
                    return false;
                }
                return SCanvasView.this.f2115l.onDeleteAllConfirm(i);
            }
        };
        this.f2117n = new HistoryUpdateListener() { // from class: com.samsung.spensdk.SCanvasView.2
            @Override // com.samsung.spensdk.applistener.HistoryUpdateListener
            public void onHistoryChanged(boolean z, boolean z2) {
            }
        };
        this.f2118o = new HistoryUpdateListener() { // from class: com.samsung.spensdk.SCanvasView.3
            @Override // com.samsung.spensdk.applistener.HistoryUpdateListener
            public void onHistoryChanged(boolean z, boolean z2) {
                if (SCanvasView.this.f2117n != null) {
                    SCanvasView.this.f2117n.onHistoryChanged(SCanvasView.this.isUndoable(), SCanvasView.this.isRedoable());
                }
                if (SCanvasView.this.f2119p != null) {
                    SCanvasView.this.f2119p.onHistoryChanged(SCanvasView.this.isUndoable(), SCanvasView.this.isRedoable());
                }
            }
        };
        this.f2119p = new CanvasView.OnHistoryChangeListener() { // from class: com.samsung.spensdk.SCanvasView.4
            @Override // com.samsung.sdraw.CanvasView.OnHistoryChangeListener
            public void onHistoryChanged(boolean z, boolean z2) {
            }
        };
        this.f2120q = new SCanvasLongPressListener() { // from class: com.samsung.spensdk.SCanvasView.5
            @Override // com.samsung.spensdk.applistener.SCanvasLongPressListener
            public void onLongPressed(float f, float f2) {
            }

            @Override // com.samsung.spensdk.applistener.SCanvasLongPressListener
            public void onLongPressed() {
            }
        };
        this.f2121r = new SCanvasLongPressListener() { // from class: com.samsung.spensdk.SCanvasView.6
            @Override // com.samsung.spensdk.applistener.SCanvasLongPressListener
            public void onLongPressed(float f, float f2) {
                SCanvasView.this.f2120q.onLongPressed(f, f2);
            }

            @Override // com.samsung.spensdk.applistener.SCanvasLongPressListener
            public void onLongPressed() {
                SCanvasView.this.f2120q.onLongPressed();
            }
        };
        this.f2122s = null;
        this.f2123t = new SettingViewShowListener() { // from class: com.samsung.spensdk.SCanvasView.7
            @Override // com.samsung.spensdk.applistener.SettingViewShowListener
            public void onPenSettingViewShow(boolean z) {
                Log.i(SCanvasView.TAG, "PenSettingViewShow : " + z);
                if (SCanvasView.this.f2122s != null) {
                    SCanvasView.this.f2122s.onPenSettingViewShow(z);
                }
                if (SCanvasView.this.f2124u != null) {
                    SCanvasView.this.f2124u.onPenSettingViewShow(z);
                }
            }

            @Override // com.samsung.spensdk.applistener.SettingViewShowListener
            public void onEraserSettingViewShow(boolean z) {
                Log.i(SCanvasView.TAG, "EraserSettingViewShow : " + z);
                if (SCanvasView.this.f2122s != null) {
                    SCanvasView.this.f2122s.onEraserSettingViewShow(z);
                }
                if (SCanvasView.this.f2124u != null) {
                    SCanvasView.this.f2124u.onEraserSettingViewShow(z);
                }
            }

            @Override // com.samsung.spensdk.applistener.SettingViewShowListener
            public void onTextSettingViewShow(boolean z) {
                Log.i(SCanvasView.TAG, "TextSettingViewShow : " + z);
                if (SCanvasView.this.f2122s != null) {
                    SCanvasView.this.f2122s.onTextSettingViewShow(z);
                }
                if (SCanvasView.this.f2124u != null) {
                    SCanvasView.this.f2124u.onTextSettingViewShow(z);
                }
            }

            @Override // com.samsung.spensdk.applistener.SettingViewShowListener
            public void onFillingSettingViewShow(boolean z) {
                Log.i(SCanvasView.TAG, "FillingSettingViewShow : " + z);
                if (SCanvasView.this.f2122s != null) {
                    SCanvasView.this.f2122s.onFillingSettingViewShow(z);
                }
                if (SCanvasView.this.f2124u != null) {
                    SCanvasView.this.f2124u.onFillingSettingViewShow(z);
                }
            }
        };
        this.f2124u = null;
        this.f2125v = null;
        this.f2126w = new SettingStrokeChangeListener() { // from class: com.samsung.spensdk.SCanvasView.8
            @Override // com.samsung.spensdk.applistener.SettingStrokeChangeListener
            public void onStrokeColorChanged(int i) {
                if (SCanvasView.this.f2125v != null) {
                    SCanvasView.this.f2125v.onStrokeColorChanged(i);
                }
            }

            @Override // com.samsung.spensdk.applistener.SettingStrokeChangeListener
            public void onStrokeAlphaChanged(int i) {
                if (SCanvasView.this.f2125v != null) {
                    SCanvasView.this.f2125v.onStrokeAlphaChanged(i);
                }
            }

            @Override // com.samsung.spensdk.applistener.SettingStrokeChangeListener
            public void onStrokeStyleChanged(int i) {
                if (SCanvasView.this.f2125v != null) {
                    SCanvasView.this.f2125v.onStrokeStyleChanged(i);
                }
            }

            @Override // com.samsung.spensdk.applistener.SettingStrokeChangeListener
            public void onStrokeWidthChanged(int i) {
                if (SCanvasView.this.f2125v != null) {
                    SCanvasView.this.f2125v.onStrokeWidthChanged(i);
                }
            }

            @Override // com.samsung.spensdk.applistener.SettingStrokeChangeListener
            public void onEraserWidthChanged(int i) {
                if (SCanvasView.this.f2125v != null) {
                    SCanvasView.this.f2125v.onEraserWidthChanged(i);
                }
            }

            @Override // com.samsung.spensdk.applistener.SettingStrokeChangeListener
            public void onDeleteAll(boolean z) {
                if (SCanvasView.this.f2125v != null) {
                    SCanvasView.this.f2125v.onDeleteAll(z);
                }
            }

            @Override // com.samsung.spensdk.applistener.SettingStrokeChangeListener
            public void onClearAll(boolean z) {
                if (SCanvasView.this.f2125v != null) {
                    SCanvasView.this.f2125v.onClearAll(z);
                }
            }
        };
        this.f2127x = null;
        this.f2128y = new SettingTextChangeListener() { // from class: com.samsung.spensdk.SCanvasView.9
            @Override // com.samsung.spensdk.applistener.SettingTextChangeListener
            public void onTextColorChanged(int i) {
                if (SCanvasView.this.f2127x != null) {
                    SCanvasView.this.f2127x.onTextColorChanged(i);
                }
            }

            @Override // com.samsung.spensdk.applistener.SettingTextChangeListener
            public void onTextFontChanged(String str) {
                if (SCanvasView.this.f2127x != null) {
                    SCanvasView.this.f2127x.onTextFontChanged(str);
                }
            }

            @Override // com.samsung.spensdk.applistener.SettingTextChangeListener
            public void onTextSizeChanged(int i) {
                if (SCanvasView.this.f2127x != null) {
                    SCanvasView.this.f2127x.onTextSizeChanged(i);
                }
            }

            @Override // com.samsung.spensdk.applistener.SettingTextChangeListener
            public void onTextStyleChanged(int i) {
                if (SCanvasView.this.f2127x != null) {
                    SCanvasView.this.f2127x.onTextStyleChanged(i);
                }
            }

            @Override // com.samsung.spensdk.applistener.SettingTextChangeListener
            public void onTextAlignmentChanged(int i) {
                if (SCanvasView.this.f2127x != null) {
                    SCanvasView.this.f2127x.onTextAlignmentChanged(i);
                }
            }
        };
        this.f2129z = null;
        this.f2053A = new SettingFillingChangeListener() { // from class: com.samsung.spensdk.SCanvasView.10
            @Override // com.samsung.spensdk.applistener.SettingFillingChangeListener
            public void onFillingColorChanged(int i) {
                if (SCanvasView.this.f2129z != null) {
                    SCanvasView.this.f2129z.onFillingColorChanged(i);
                }
            }
        };
        this.f2054B = null;
        this.f2055C = new SettingPresetDeleteBtnClickListener() { // from class: com.samsung.spensdk.SCanvasView.11
            @Override // com.samsung.spensdk.applistener.SettingPresetDeleteBtnClickListener
            public void onClick(int i) {
                if (SCanvasView.this.f2054B != null) {
                    SCanvasView.this.f2054B.onClick(i);
                }
            }
        };
        this.f2056D = null;
        this.f2057E = new ColorPickerColorChangeListener() { // from class: com.samsung.spensdk.SCanvasView.13
            @Override // com.samsung.spensdk.applistener.ColorPickerColorChangeListener
            public void onColorPickerColorChanged(int i) {
                if (SCanvasView.this.f2056D != null) {
                    SCanvasView.this.f2056D.onColorPickerColorChanged(i);
                }
            }
        };
        this.f2058F = null;
        this.f2059G = new FileProcessListener() { // from class: com.samsung.spensdk.SCanvasView.14
            @Override // com.samsung.spensdk.applistener.FileProcessListener
            public void onChangeProgress(int i) {
                if (SCanvasView.this.f2058F != null) {
                    SCanvasView.this.f2058F.onChangeProgress(i);
                }
                if (SCanvasView.this.f2105ax == null) {
                    return;
                }
                SCanvasView.this.f2105ax.onChangeProgress(i);
            }

            @Override // com.samsung.spensdk.applistener.FileProcessListener
            public void onLoadComplete(boolean z) {
                if (SCanvasView.this.f2058F != null) {
                    SCanvasView.this.f2058F.onLoadComplete(z);
                }
                if (SCanvasView.this.f2105ax != null) {
                    SCanvasView.this.f2105ax.onLoadComplete(z);
                }
                SCanvasView.this.f2075W.mo1736j(true);
                SCanvasView.this.invalidate();
                if (SCanvasView.this.getSelectLayer() == 0) {
                    SCanvasView.this.f2094am = false;
                } else if (SCanvasView.this.getSelectLayer() == 1) {
                    SCanvasView.this.f2095an = false;
                }
            }
        };
        this.f2105ax = null;
        this.f2060H = null;
        this.f2061I = new AnimationProcessListener() { // from class: com.samsung.spensdk.SCanvasView.15
            @Override // com.samsung.spensdk.applistener.AnimationProcessListener
            public void onPlayComplete() {
                if (SCanvasView.this.f2060H != null) {
                    SCanvasView.this.f2060H.onPlayComplete();
                }
                if (SCanvasView.this.f2107az == null) {
                    return;
                }
                SCanvasView.this.f2107az.onPlayComplete();
            }

            @Override // com.samsung.spensdk.applistener.AnimationProcessListener
            public void onChangeProgress(int i) {
                if (SCanvasView.this.f2060H != null) {
                    SCanvasView.this.f2060H.onChangeProgress(i);
                }
                if (SCanvasView.this.f2106ay == null) {
                    return;
                }
                SCanvasView.this.f2106ay.onChangeProgress(i);
            }
        };
        this.f2106ay = null;
        this.f2107az = null;
        this.f2062J = null;
        this.f2063K = new SObjectSelectListener() { // from class: com.samsung.spensdk.SCanvasView.16
            @Override // com.samsung.spensdk.applistener.SObjectSelectListener
            public void onSObjectSelected(SObject sObject, boolean z) {
                if (SCanvasView.this.f2062J != null) {
                    SCanvasView.this.f2062J.onSObjectSelected(sObject, z);
                }
            }
        };
        this.f2064L = null;
        this.f2065M = new SObjectUpdateListener() { // from class: com.samsung.spensdk.SCanvasView.17
            @Override // com.samsung.spensdk.applistener.SObjectUpdateListener
            public void onSObjectInserted(SObject sObject, boolean z, boolean z2) {
                if (sObject.getLayer() == 0) {
                    SCanvasView.this.f2094am = true;
                } else if (sObject.getLayer() == 1) {
                    SCanvasView.this.f2095an = true;
                }
                if (SCanvasView.this.f2064L != null) {
                    SCanvasView.this.f2064L.onSObjectInserted(sObject, z, z2);
                }
            }

            @Override // com.samsung.spensdk.applistener.SObjectUpdateListener
            public void onSObjectDeleted(SObject sObject, boolean z, boolean z2, boolean z3) {
                if (sObject.getLayer() == 0) {
                    SCanvasView.this.f2094am = true;
                } else if (sObject.getLayer() == 1) {
                    SCanvasView.this.f2095an = true;
                }
                if (SCanvasView.this.f2064L != null) {
                    SCanvasView.this.f2064L.onSObjectDeleted(sObject, z, z2, z3);
                }
            }

            @Override // com.samsung.spensdk.applistener.SObjectUpdateListener
            public void onSObjectChanged(SObject sObject, boolean z, boolean z2) {
                if (sObject.getLayer() == 0) {
                    SCanvasView.this.f2094am = true;
                } else if (sObject.getLayer() == 1) {
                    SCanvasView.this.f2095an = true;
                }
                if (SCanvasView.this.f2064L != null) {
                    SCanvasView.this.f2064L.onSObjectChanged(sObject, z, z2);
                }
            }

            @Override // com.samsung.spensdk.applistener.SObjectUpdateListener
            public boolean onSObjectStrokeInserting(SObjectStroke sObjectStroke) {
                if (SCanvasView.this.f2064L != null) {
                    return SCanvasView.this.f2064L.onSObjectStrokeInserting(sObjectStroke);
                }
                return false;
            }

            @Override // com.samsung.spensdk.applistener.SObjectUpdateListener
            public void onSObjectSelected(SObject sObject, boolean z) {
                if (SCanvasView.this.f2064L != null) {
                    SCanvasView.this.f2064L.onSObjectSelected(sObject, z);
                }
            }

            @Override // com.samsung.spensdk.applistener.SObjectUpdateListener
            public void onSObjectDeletedAll(boolean z, int i) {
                if (i == 0) {
                    SCanvasView.this.f2094am = true;
                } else if (i == 1) {
                    SCanvasView.this.f2095an = true;
                }
                if (SCanvasView.this.f2064L != null) {
                    SCanvasView.this.f2064L.onSObjectDeletedAll(z, i);
                }
            }
        };
        this.f2066N = null;
        this.f2077aA = null;
        this.f2067O = null;
        this.f2068P = null;
        this.f2078aB = 0;
        this.f2079aC = -1;
        this.f2080aD = -1;
        this.f2081aE = -1;
        this.f2069Q = null;
        this.f2070R = new SPenTouchIDListener() { // from class: com.samsung.spensdk.SCanvasView.18
            @Override // com.samsung.spensdk.applistener.SPenTouchIDListener
            public boolean onTouchPen(View view, MotionEvent motionEvent, int i) {
                return false;
            }

            @Override // com.samsung.spensdk.applistener.SPenTouchIDListener
            public boolean onTouchPenEraser(View view, MotionEvent motionEvent, int i) {
                return false;
            }

            @Override // com.samsung.spensdk.applistener.SPenTouchIDListener
            public boolean onTouchFinger(View view, MotionEvent motionEvent, int i) {
                return false;
            }

            @Override // com.samsung.spensdk.applistener.SPenTouchIDListener
            public boolean onDrawingPen(View view, MotionEvent motionEvent, int i, int i2) {
                if (SCanvasView.this.f2071S == null) {
                    return false;
                }
                SPenEvent event = SPenLibrary.getEvent(motionEvent);
                if (event.isFinger()) {
                    return SCanvasView.this.f2071S.onDrawingPen(view, motionEvent, SCanvasView.this.f2080aD, 0);
                }
                if (event.isPen()) {
                    return SCanvasView.this.f2071S.onDrawingPen(view, motionEvent, SCanvasView.this.f2079aC, 1);
                }
                if (event.isEraserPen()) {
                    return SCanvasView.this.f2071S.onDrawingPen(view, motionEvent, SCanvasView.this.f2081aE, 2);
                }
                return false;
            }
        };
        this.f2071S = null;
        this.f2072T = context;
        super.setOnInitializeFinishListener(this.f2104aw);
    }

    public SCanvasView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2072T = null;
        this.f2073U = null;
        this.f2074V = null;
        this.f2075W = null;
        this.f2076Z = null;
        this.f2082aa = null;
        this.f2083ab = null;
        this.f2084ac = null;
        this.f2085ad = this;
        this.f2086ae = null;
        this.f2087af = 0;
        this.f2088ag = 0;
        this.f2089ah = true;
        this.f2090ai = true;
        this.f2091aj = false;
        this.f2092ak = false;
        this.f2093al = null;
        this.f2094am = false;
        this.f2095an = false;
        this.f2096ao = false;
        this.f2097ap = null;
        this.f2098aq = null;
        this.f2099ar = new HashMap<>();
        this.f2100as = new HashMap<>();
        this.f2101at = true;
        this.f2108e = new SCanvasInitializeListener() { // from class: com.samsung.spensdk.SCanvasView.1
            @Override // com.samsung.spensdk.applistener.SCanvasInitializeListener
            public void onInitialized() {
                Log.w(SCanvasView.TAG, "SCanvasLayout has been initialized!!");
            }
        };
        this.f2109f = new SCanvasInitializeListener() { // from class: com.samsung.spensdk.SCanvasView.12
            @Override // com.samsung.spensdk.applistener.SCanvasInitializeListener
            public void onInitialized() {
                if (SCanvasView.this.f2108e != null) {
                    SCanvasView.this.f2108e.onInitialized();
                }
            }
        };
        this.f2103av = null;
        this.f2104aw = new CanvasView.OnInitializeFinishListener() { // from class: com.samsung.spensdk.SCanvasView.21
            @Override // com.samsung.sdraw.CanvasView.OnInitializeFinishListener
            public void onFinish() {
                SCanvasView.this.m2008d();
                if (SCanvasView.this.f2103av != null) {
                    SCanvasView.this.f2103av.onFinish();
                }
                if (SCanvasView.this.f2108e != null) {
                    SCanvasView.this.f2108e.onInitialized();
                }
            }
        };
        this.f2110g = new SCanvasMatrixChangeListener() { // from class: com.samsung.spensdk.SCanvasView.22
            @Override // com.samsung.spensdk.applistener.SCanvasMatrixChangeListener
            public void onMatrixChanged(Matrix matrix) {
                Log.w(SCanvasView.TAG, "SCanvas matrix has been changed!!");
            }

            @Override // com.samsung.spensdk.applistener.SCanvasMatrixChangeListener
            public void onMatrixChangeFinished() {
                Log.w(SCanvasView.TAG, "SCanvas matrix changement has finished changed!!");
            }
        };
        this.f2111h = new SCanvasMatrixChangeListener() { // from class: com.samsung.spensdk.SCanvasView.23
            @Override // com.samsung.spensdk.applistener.SCanvasMatrixChangeListener
            public void onMatrixChanged(Matrix matrix) {
                if (SCanvasView.this.f2110g != null) {
                    SCanvasView.this.f2110g.onMatrixChanged(matrix);
                }
            }

            @Override // com.samsung.spensdk.applistener.SCanvasMatrixChangeListener
            public void onMatrixChangeFinished() {
                if (SCanvasView.this.f2110g != null) {
                    SCanvasView.this.f2110g.onMatrixChangeFinished();
                }
            }
        };
        this.f2112i = new SCanvasModeChangedListener() { // from class: com.samsung.spensdk.SCanvasView.24
            @Override // com.samsung.spensdk.applistener.SCanvasModeChangedListener
            public void onModeChanged(int i2) {
                Log.w(SCanvasView.TAG, "SCanvasMode has been changed!!");
            }
        };
        this.f2113j = new SCanvasModeChangedListener() { // from class: com.samsung.spensdk.SCanvasView.25
            @Override // com.samsung.spensdk.applistener.SCanvasModeChangedListener
            public void onModeChanged(int i2) {
                if (SCanvasView.this.f2112i != null) {
                    SCanvasView.this.f2112i.onModeChanged(i2);
                }
            }
        };
        this.f2114k = false;
        this.f2115l = new SCanvasDeleteAllConfirmListener() { // from class: com.samsung.spensdk.SCanvasView.26
            @Override // com.samsung.spensdk.applistener.SCanvasDeleteAllConfirmListener
            public boolean onDeleteAllConfirm(int i2) {
                Log.w(SCanvasView.TAG, String.valueOf(i2) + " Layer DeleteAll button has been clicked!!");
                return true;
            }
        };
        this.f2116m = new SCanvasDeleteAllConfirmListener() { // from class: com.samsung.spensdk.SCanvasView.27
            @Override // com.samsung.spensdk.applistener.SCanvasDeleteAllConfirmListener
            public boolean onDeleteAllConfirm(int i2) {
                if (SCanvasView.this.f2115l == null || !SCanvasView.this.f2114k) {
                    return false;
                }
                return SCanvasView.this.f2115l.onDeleteAllConfirm(i2);
            }
        };
        this.f2117n = new HistoryUpdateListener() { // from class: com.samsung.spensdk.SCanvasView.2
            @Override // com.samsung.spensdk.applistener.HistoryUpdateListener
            public void onHistoryChanged(boolean z, boolean z2) {
            }
        };
        this.f2118o = new HistoryUpdateListener() { // from class: com.samsung.spensdk.SCanvasView.3
            @Override // com.samsung.spensdk.applistener.HistoryUpdateListener
            public void onHistoryChanged(boolean z, boolean z2) {
                if (SCanvasView.this.f2117n != null) {
                    SCanvasView.this.f2117n.onHistoryChanged(SCanvasView.this.isUndoable(), SCanvasView.this.isRedoable());
                }
                if (SCanvasView.this.f2119p != null) {
                    SCanvasView.this.f2119p.onHistoryChanged(SCanvasView.this.isUndoable(), SCanvasView.this.isRedoable());
                }
            }
        };
        this.f2119p = new CanvasView.OnHistoryChangeListener() { // from class: com.samsung.spensdk.SCanvasView.4
            @Override // com.samsung.sdraw.CanvasView.OnHistoryChangeListener
            public void onHistoryChanged(boolean z, boolean z2) {
            }
        };
        this.f2120q = new SCanvasLongPressListener() { // from class: com.samsung.spensdk.SCanvasView.5
            @Override // com.samsung.spensdk.applistener.SCanvasLongPressListener
            public void onLongPressed(float f, float f2) {
            }

            @Override // com.samsung.spensdk.applistener.SCanvasLongPressListener
            public void onLongPressed() {
            }
        };
        this.f2121r = new SCanvasLongPressListener() { // from class: com.samsung.spensdk.SCanvasView.6
            @Override // com.samsung.spensdk.applistener.SCanvasLongPressListener
            public void onLongPressed(float f, float f2) {
                SCanvasView.this.f2120q.onLongPressed(f, f2);
            }

            @Override // com.samsung.spensdk.applistener.SCanvasLongPressListener
            public void onLongPressed() {
                SCanvasView.this.f2120q.onLongPressed();
            }
        };
        this.f2122s = null;
        this.f2123t = new SettingViewShowListener() { // from class: com.samsung.spensdk.SCanvasView.7
            @Override // com.samsung.spensdk.applistener.SettingViewShowListener
            public void onPenSettingViewShow(boolean z) {
                Log.i(SCanvasView.TAG, "PenSettingViewShow : " + z);
                if (SCanvasView.this.f2122s != null) {
                    SCanvasView.this.f2122s.onPenSettingViewShow(z);
                }
                if (SCanvasView.this.f2124u != null) {
                    SCanvasView.this.f2124u.onPenSettingViewShow(z);
                }
            }

            @Override // com.samsung.spensdk.applistener.SettingViewShowListener
            public void onEraserSettingViewShow(boolean z) {
                Log.i(SCanvasView.TAG, "EraserSettingViewShow : " + z);
                if (SCanvasView.this.f2122s != null) {
                    SCanvasView.this.f2122s.onEraserSettingViewShow(z);
                }
                if (SCanvasView.this.f2124u != null) {
                    SCanvasView.this.f2124u.onEraserSettingViewShow(z);
                }
            }

            @Override // com.samsung.spensdk.applistener.SettingViewShowListener
            public void onTextSettingViewShow(boolean z) {
                Log.i(SCanvasView.TAG, "TextSettingViewShow : " + z);
                if (SCanvasView.this.f2122s != null) {
                    SCanvasView.this.f2122s.onTextSettingViewShow(z);
                }
                if (SCanvasView.this.f2124u != null) {
                    SCanvasView.this.f2124u.onTextSettingViewShow(z);
                }
            }

            @Override // com.samsung.spensdk.applistener.SettingViewShowListener
            public void onFillingSettingViewShow(boolean z) {
                Log.i(SCanvasView.TAG, "FillingSettingViewShow : " + z);
                if (SCanvasView.this.f2122s != null) {
                    SCanvasView.this.f2122s.onFillingSettingViewShow(z);
                }
                if (SCanvasView.this.f2124u != null) {
                    SCanvasView.this.f2124u.onFillingSettingViewShow(z);
                }
            }
        };
        this.f2124u = null;
        this.f2125v = null;
        this.f2126w = new SettingStrokeChangeListener() { // from class: com.samsung.spensdk.SCanvasView.8
            @Override // com.samsung.spensdk.applistener.SettingStrokeChangeListener
            public void onStrokeColorChanged(int i2) {
                if (SCanvasView.this.f2125v != null) {
                    SCanvasView.this.f2125v.onStrokeColorChanged(i2);
                }
            }

            @Override // com.samsung.spensdk.applistener.SettingStrokeChangeListener
            public void onStrokeAlphaChanged(int i2) {
                if (SCanvasView.this.f2125v != null) {
                    SCanvasView.this.f2125v.onStrokeAlphaChanged(i2);
                }
            }

            @Override // com.samsung.spensdk.applistener.SettingStrokeChangeListener
            public void onStrokeStyleChanged(int i2) {
                if (SCanvasView.this.f2125v != null) {
                    SCanvasView.this.f2125v.onStrokeStyleChanged(i2);
                }
            }

            @Override // com.samsung.spensdk.applistener.SettingStrokeChangeListener
            public void onStrokeWidthChanged(int i2) {
                if (SCanvasView.this.f2125v != null) {
                    SCanvasView.this.f2125v.onStrokeWidthChanged(i2);
                }
            }

            @Override // com.samsung.spensdk.applistener.SettingStrokeChangeListener
            public void onEraserWidthChanged(int i2) {
                if (SCanvasView.this.f2125v != null) {
                    SCanvasView.this.f2125v.onEraserWidthChanged(i2);
                }
            }

            @Override // com.samsung.spensdk.applistener.SettingStrokeChangeListener
            public void onDeleteAll(boolean z) {
                if (SCanvasView.this.f2125v != null) {
                    SCanvasView.this.f2125v.onDeleteAll(z);
                }
            }

            @Override // com.samsung.spensdk.applistener.SettingStrokeChangeListener
            public void onClearAll(boolean z) {
                if (SCanvasView.this.f2125v != null) {
                    SCanvasView.this.f2125v.onClearAll(z);
                }
            }
        };
        this.f2127x = null;
        this.f2128y = new SettingTextChangeListener() { // from class: com.samsung.spensdk.SCanvasView.9
            @Override // com.samsung.spensdk.applistener.SettingTextChangeListener
            public void onTextColorChanged(int i2) {
                if (SCanvasView.this.f2127x != null) {
                    SCanvasView.this.f2127x.onTextColorChanged(i2);
                }
            }

            @Override // com.samsung.spensdk.applistener.SettingTextChangeListener
            public void onTextFontChanged(String str) {
                if (SCanvasView.this.f2127x != null) {
                    SCanvasView.this.f2127x.onTextFontChanged(str);
                }
            }

            @Override // com.samsung.spensdk.applistener.SettingTextChangeListener
            public void onTextSizeChanged(int i2) {
                if (SCanvasView.this.f2127x != null) {
                    SCanvasView.this.f2127x.onTextSizeChanged(i2);
                }
            }

            @Override // com.samsung.spensdk.applistener.SettingTextChangeListener
            public void onTextStyleChanged(int i2) {
                if (SCanvasView.this.f2127x != null) {
                    SCanvasView.this.f2127x.onTextStyleChanged(i2);
                }
            }

            @Override // com.samsung.spensdk.applistener.SettingTextChangeListener
            public void onTextAlignmentChanged(int i2) {
                if (SCanvasView.this.f2127x != null) {
                    SCanvasView.this.f2127x.onTextAlignmentChanged(i2);
                }
            }
        };
        this.f2129z = null;
        this.f2053A = new SettingFillingChangeListener() { // from class: com.samsung.spensdk.SCanvasView.10
            @Override // com.samsung.spensdk.applistener.SettingFillingChangeListener
            public void onFillingColorChanged(int i2) {
                if (SCanvasView.this.f2129z != null) {
                    SCanvasView.this.f2129z.onFillingColorChanged(i2);
                }
            }
        };
        this.f2054B = null;
        this.f2055C = new SettingPresetDeleteBtnClickListener() { // from class: com.samsung.spensdk.SCanvasView.11
            @Override // com.samsung.spensdk.applistener.SettingPresetDeleteBtnClickListener
            public void onClick(int i2) {
                if (SCanvasView.this.f2054B != null) {
                    SCanvasView.this.f2054B.onClick(i2);
                }
            }
        };
        this.f2056D = null;
        this.f2057E = new ColorPickerColorChangeListener() { // from class: com.samsung.spensdk.SCanvasView.13
            @Override // com.samsung.spensdk.applistener.ColorPickerColorChangeListener
            public void onColorPickerColorChanged(int i2) {
                if (SCanvasView.this.f2056D != null) {
                    SCanvasView.this.f2056D.onColorPickerColorChanged(i2);
                }
            }
        };
        this.f2058F = null;
        this.f2059G = new FileProcessListener() { // from class: com.samsung.spensdk.SCanvasView.14
            @Override // com.samsung.spensdk.applistener.FileProcessListener
            public void onChangeProgress(int i2) {
                if (SCanvasView.this.f2058F != null) {
                    SCanvasView.this.f2058F.onChangeProgress(i2);
                }
                if (SCanvasView.this.f2105ax == null) {
                    return;
                }
                SCanvasView.this.f2105ax.onChangeProgress(i2);
            }

            @Override // com.samsung.spensdk.applistener.FileProcessListener
            public void onLoadComplete(boolean z) {
                if (SCanvasView.this.f2058F != null) {
                    SCanvasView.this.f2058F.onLoadComplete(z);
                }
                if (SCanvasView.this.f2105ax != null) {
                    SCanvasView.this.f2105ax.onLoadComplete(z);
                }
                SCanvasView.this.f2075W.mo1736j(true);
                SCanvasView.this.invalidate();
                if (SCanvasView.this.getSelectLayer() == 0) {
                    SCanvasView.this.f2094am = false;
                } else if (SCanvasView.this.getSelectLayer() == 1) {
                    SCanvasView.this.f2095an = false;
                }
            }
        };
        this.f2105ax = null;
        this.f2060H = null;
        this.f2061I = new AnimationProcessListener() { // from class: com.samsung.spensdk.SCanvasView.15
            @Override // com.samsung.spensdk.applistener.AnimationProcessListener
            public void onPlayComplete() {
                if (SCanvasView.this.f2060H != null) {
                    SCanvasView.this.f2060H.onPlayComplete();
                }
                if (SCanvasView.this.f2107az == null) {
                    return;
                }
                SCanvasView.this.f2107az.onPlayComplete();
            }

            @Override // com.samsung.spensdk.applistener.AnimationProcessListener
            public void onChangeProgress(int i2) {
                if (SCanvasView.this.f2060H != null) {
                    SCanvasView.this.f2060H.onChangeProgress(i2);
                }
                if (SCanvasView.this.f2106ay == null) {
                    return;
                }
                SCanvasView.this.f2106ay.onChangeProgress(i2);
            }
        };
        this.f2106ay = null;
        this.f2107az = null;
        this.f2062J = null;
        this.f2063K = new SObjectSelectListener() { // from class: com.samsung.spensdk.SCanvasView.16
            @Override // com.samsung.spensdk.applistener.SObjectSelectListener
            public void onSObjectSelected(SObject sObject, boolean z) {
                if (SCanvasView.this.f2062J != null) {
                    SCanvasView.this.f2062J.onSObjectSelected(sObject, z);
                }
            }
        };
        this.f2064L = null;
        this.f2065M = new SObjectUpdateListener() { // from class: com.samsung.spensdk.SCanvasView.17
            @Override // com.samsung.spensdk.applistener.SObjectUpdateListener
            public void onSObjectInserted(SObject sObject, boolean z, boolean z2) {
                if (sObject.getLayer() == 0) {
                    SCanvasView.this.f2094am = true;
                } else if (sObject.getLayer() == 1) {
                    SCanvasView.this.f2095an = true;
                }
                if (SCanvasView.this.f2064L != null) {
                    SCanvasView.this.f2064L.onSObjectInserted(sObject, z, z2);
                }
            }

            @Override // com.samsung.spensdk.applistener.SObjectUpdateListener
            public void onSObjectDeleted(SObject sObject, boolean z, boolean z2, boolean z3) {
                if (sObject.getLayer() == 0) {
                    SCanvasView.this.f2094am = true;
                } else if (sObject.getLayer() == 1) {
                    SCanvasView.this.f2095an = true;
                }
                if (SCanvasView.this.f2064L != null) {
                    SCanvasView.this.f2064L.onSObjectDeleted(sObject, z, z2, z3);
                }
            }

            @Override // com.samsung.spensdk.applistener.SObjectUpdateListener
            public void onSObjectChanged(SObject sObject, boolean z, boolean z2) {
                if (sObject.getLayer() == 0) {
                    SCanvasView.this.f2094am = true;
                } else if (sObject.getLayer() == 1) {
                    SCanvasView.this.f2095an = true;
                }
                if (SCanvasView.this.f2064L != null) {
                    SCanvasView.this.f2064L.onSObjectChanged(sObject, z, z2);
                }
            }

            @Override // com.samsung.spensdk.applistener.SObjectUpdateListener
            public boolean onSObjectStrokeInserting(SObjectStroke sObjectStroke) {
                if (SCanvasView.this.f2064L != null) {
                    return SCanvasView.this.f2064L.onSObjectStrokeInserting(sObjectStroke);
                }
                return false;
            }

            @Override // com.samsung.spensdk.applistener.SObjectUpdateListener
            public void onSObjectSelected(SObject sObject, boolean z) {
                if (SCanvasView.this.f2064L != null) {
                    SCanvasView.this.f2064L.onSObjectSelected(sObject, z);
                }
            }

            @Override // com.samsung.spensdk.applistener.SObjectUpdateListener
            public void onSObjectDeletedAll(boolean z, int i2) {
                if (i2 == 0) {
                    SCanvasView.this.f2094am = true;
                } else if (i2 == 1) {
                    SCanvasView.this.f2095an = true;
                }
                if (SCanvasView.this.f2064L != null) {
                    SCanvasView.this.f2064L.onSObjectDeletedAll(z, i2);
                }
            }
        };
        this.f2066N = null;
        this.f2077aA = null;
        this.f2067O = null;
        this.f2068P = null;
        this.f2078aB = 0;
        this.f2079aC = -1;
        this.f2080aD = -1;
        this.f2081aE = -1;
        this.f2069Q = null;
        this.f2070R = new SPenTouchIDListener() { // from class: com.samsung.spensdk.SCanvasView.18
            @Override // com.samsung.spensdk.applistener.SPenTouchIDListener
            public boolean onTouchPen(View view, MotionEvent motionEvent, int i2) {
                return false;
            }

            @Override // com.samsung.spensdk.applistener.SPenTouchIDListener
            public boolean onTouchPenEraser(View view, MotionEvent motionEvent, int i2) {
                return false;
            }

            @Override // com.samsung.spensdk.applistener.SPenTouchIDListener
            public boolean onTouchFinger(View view, MotionEvent motionEvent, int i2) {
                return false;
            }

            @Override // com.samsung.spensdk.applistener.SPenTouchIDListener
            public boolean onDrawingPen(View view, MotionEvent motionEvent, int i2, int i22) {
                if (SCanvasView.this.f2071S == null) {
                    return false;
                }
                SPenEvent event = SPenLibrary.getEvent(motionEvent);
                if (event.isFinger()) {
                    return SCanvasView.this.f2071S.onDrawingPen(view, motionEvent, SCanvasView.this.f2080aD, 0);
                }
                if (event.isPen()) {
                    return SCanvasView.this.f2071S.onDrawingPen(view, motionEvent, SCanvasView.this.f2079aC, 1);
                }
                if (event.isEraserPen()) {
                    return SCanvasView.this.f2071S.onDrawingPen(view, motionEvent, SCanvasView.this.f2081aE, 2);
                }
                return false;
            }
        };
        this.f2071S = null;
        this.f2072T = context;
        super.setOnInitializeFinishListener(this.f2104aw);
    }

    /* renamed from: b */
    boolean m2022b() {
        if (this.f2073U != null) {
            return true;
        }
        Log.e(TAG, "S-Canvas is not created yet. Call this function in onInitialized() of SCanvasInitializeListener or call it after onInitialized()");
        return false;
    }

    @Deprecated
    public boolean createSAMMLibrary() {
        Log.w(TAG, "Deprecated API");
        return false;
    }

    @Override // com.samsung.sdraw.CanvasView
    @Deprecated
    public void setSettingView(SettingView settingView) {
        super.setSettingView(settingView);
        this.f2099ar = null;
        this.f2100as = null;
        this.f2097ap = settingView;
    }

    @Deprecated
    public void setSettingView(ViewGroup viewGroup, ViewGroup viewGroup2, boolean z) {
        super.setSettingView((SettingView) viewGroup2);
        this.f2099ar = null;
        this.f2100as = null;
        this.f2097ap = viewGroup2;
        this.f2098aq = viewGroup;
        if (this.f2098aq != null) {
            this.f2098aq.addView(this.f2097ap);
        }
        this.f2101at = z;
    }

    public void setSettingView(ViewGroup viewGroup, ViewGroup viewGroup2) {
        super.setSettingView((SettingView) viewGroup2);
        this.f2099ar = null;
        this.f2100as = null;
        this.f2097ap = viewGroup2;
        this.f2098aq = viewGroup;
        if (this.f2098aq != null) {
            this.f2098aq.addView(this.f2097ap);
        }
    }

    @Deprecated
    public void createSettingView(ViewGroup viewGroup, HashMap<String, Integer> map, boolean z) {
        this.f2099ar = map;
        this.f2100as = null;
        this.f2098aq = viewGroup;
        this.f2101at = z;
    }

    public void createSettingView(ViewGroup viewGroup, HashMap<String, Integer> map) {
        this.f2099ar = map;
        this.f2100as = null;
        this.f2098aq = viewGroup;
    }

    @Deprecated
    public void createSettingView(ViewGroup viewGroup, HashMap<String, Integer> map, HashMap<String, String> map2, boolean z) {
        this.f2099ar = map;
        this.f2100as = map2;
        this.f2098aq = viewGroup;
        this.f2101at = z;
    }

    public void createSettingView(ViewGroup viewGroup, HashMap<String, Integer> map, HashMap<String, String> map2) {
        this.f2099ar = map;
        this.f2100as = map2;
        this.f2098aq = viewGroup;
    }

    public void setDeleteSettingViewDefaultDescription(boolean z) {
        this.f2096ao = z;
    }

    public boolean isDeletedSettingViewDefaultDescription() {
        if (m2022b()) {
            return false;
        }
        return this.f2074V.mo1971l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public boolean m2008d() {
        return m2004c(getWidth(), getHeight());
    }

    /* renamed from: c */
    private boolean m2004c(int i, int i2) {
        boolean z = false;
        this.f2087af = i;
        this.f2088ag = i2;
        this.f2086ae = new SOptionSCanvas();
        if (m2023b(i, i2) && updateCallbackFunctions()) {
            if (this.f2074V.mo1947a()) {
                if (this.f2108e != null) {
                    this.f2108e.onInitialized();
                }
                z = true;
            }
            if (this.f2054B != null) {
                this.f2074V.mo1962c(true);
            }
        }
        return z;
    }

    /* renamed from: b */
    boolean m2023b(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            Log.e(TAG, "Invalid Canvas Size (" + i + ", " + i2 + ")");
            return false;
        }
        this.f2073U = new C0907e(this.f2072T, i, i2, this.f2089ah, this.f2090ai, this.f2093al);
        if (this.f2073U != null && this.f2073U.mo181b()) {
            this.f2082aa = new C1097d();
            this.f2084ac = new C1093b(this.f2072T);
            this.f2083ab = new RunnableC1071a(this.f2072T, i, i2);
            this.f2075W = new C1073a(this.f2072T, i, i2);
            this.f2076Z = new RunnableC1078a(this.f2072T, i, i2);
            this.f2074V = new C1099b(this.f2072T, this.f2098aq, this.f2099ar, this.f2100as, this.f2097ap, this.f2101at);
            this.f2085ad = this;
            this.f2074V.mo1939a(this.f2085ad);
            this.f2074V.mo1938a(this.f2075W);
            this.f2083ab.mo1648a(this.f2076Z);
            this.f2083ab.mo1649a(this.f2084ac);
            this.f2083ab.mo1647a(this.f2075W);
            this.f2075W.mo1695a(this.f2085ad);
            this.f2076Z.mo1769a(this.f2073U);
            this.f2076Z.mo1770a(this.f2085ad);
            this.f2085ad.onSetObjectManagerInterface(this.f2082aa);
            this.f2082aa.mo1881a(this.f2073U);
            this.f2082aa.mo1882a(this.f2085ad);
            if (this.f2096ao) {
                this.f2074V.mo1961c();
            }
            this.f2073U.mo166a(new C0907e.a() { // from class: com.samsung.spensdk.SCanvasView.19
                @Override // com.samsung.samm.lib.C0907e.a
                /* renamed from: a */
                public Bitmap mo638a(boolean z, int i3) {
                    return SCanvasView.this.f2076Z.mo1766a(z, i3);
                }
            });
            return true;
        }
        return false;
    }

    public void setImageBufferEncodingOption(boolean z, boolean z2) {
        if (!m2022b()) {
            this.f2089ah = z;
            this.f2090ai = z2;
        }
    }

    public void setTempDirPath(String str) {
        if (!m2022b()) {
            this.f2093al = str;
        }
    }

    public boolean updateCallbackFunctions() {
        if (!m2022b()) {
            return false;
        }
        this.f2083ab.mo1650a(this.f2061I);
        this.f2074V.mo1946a(this.f2123t);
        this.f2074V.mo1944a(this.f2126w);
        this.f2074V.mo1945a(this.f2128y);
        this.f2074V.mo1942a(this.f2053A);
        this.f2074V.mo1943a(this.f2055C);
        this.f2075W.mo1696a(this.f2057E);
        this.f2075W.mo1697a(this.f2118o);
        this.f2075W.mo1698a(this.f2121r);
        this.f2076Z.mo1771a(this.f2059G);
        this.f2076Z.mo1772a(this.f2070R);
        this.f2085ad.onSetSCanvasInitializeListener(this.f2109f);
        this.f2085ad.onSetSCanvasMatrixChangeListener(this.f2111h);
        this.f2085ad.onSetSCanvasModeChangedListener(this.f2113j);
        this.f2085ad.onSetSCanvasDeleteAllConfirmListener(this.f2116m);
        this.f2085ad.onSetSCanvasSObjectUpdateListener(this.f2065M);
        this.f2085ad.onSetSCanvasSObjectSelectListener(this.f2063K);
        this.f2084ac.mo1676a(this.f2068P);
        this.f2074V.mo1940a(this.f2077aA);
        this.f2074V.mo1937a(this.f2069Q);
        return true;
    }

    @Deprecated
    public boolean closeSAMMLibrary() {
        Log.w(TAG, "Deprecated API, call closeSCanvasView instead.");
        return closeSCanvasView();
    }

    public boolean closeSCanvasView() {
        if (!m2022b()) {
            return false;
        }
        this.f2082aa.mo1880a();
        this.f2074V.mo1969j();
        boolean zMo167a = this.f2073U.mo167a();
        this.f2073U = null;
        m2010e();
        return zMo167a;
    }

    public boolean setOption(SOptionSCanvas sOptionSCanvas) {
        if (!m2022b()) {
            return false;
        }
        if (sOptionSCanvas == null) {
            Log.e(TAG, "canvasOption is null");
            return false;
        }
        if (this.f2086ae == null || sOptionSCanvas.mSAMMOption == null || sOptionSCanvas.mPlayOption == null) {
            return false;
        }
        this.f2086ae.mSAMMOption.setConvertCanvasHorizontalAlignOption(sOptionSCanvas.mSAMMOption.getConvertCanvasHorizontalAlignOption());
        this.f2086ae.mSAMMOption.setConvertCanvasVerticalAlignOption(sOptionSCanvas.mSAMMOption.getConvertCanvasVerticalAlignOption());
        this.f2086ae.mSAMMOption.setConvertCanvasSizeOption(sOptionSCanvas.mSAMMOption.getConvertCanvasSizeOption());
        this.f2086ae.mSAMMOption.setSaveImageLeftCroppingOption(sOptionSCanvas.mSAMMOption.getSaveImageLeftCroppingOption());
        this.f2086ae.mSAMMOption.setSaveImageRightCroppingOption(sOptionSCanvas.mSAMMOption.getSaveImageRightCroppingOption());
        this.f2086ae.mSAMMOption.setSaveImageTopCroppingOption(sOptionSCanvas.mSAMMOption.getSaveImageTopCroppingOption());
        this.f2086ae.mSAMMOption.setSaveImageBottomCroppingOption(sOptionSCanvas.mSAMMOption.getSaveImageBottomCroppingOption());
        this.f2086ae.mSAMMOption.setSaveContentsCroppingOption(sOptionSCanvas.mSAMMOption.getSaveContentsCroppingOption());
        this.f2086ae.mSAMMOption.setSaveImageSize(sOptionSCanvas.mSAMMOption.getSaveImageSize());
        this.f2086ae.mSAMMOption.setJPGImageQuality(sOptionSCanvas.mSAMMOption.getJPGImageQuality());
        this.f2086ae.mSAMMOption.setContentsQuality(sOptionSCanvas.mSAMMOption.getContentsQuality());
        this.f2086ae.mSAMMOption.setSaveOnlyForegroundImage(sOptionSCanvas.mSAMMOption.isSaveOnlyForegroundImage());
        this.f2086ae.mSAMMOption.setCreateNewImageFile(sOptionSCanvas.mSAMMOption.isCreateNewImageFile());
        this.f2086ae.mPlayOption.setInvisibleBGImageAnimationOption(sOptionSCanvas.mPlayOption.getInvisibleBGImageAnimationOption());
        this.f2086ae.mPlayOption.setAnimationSpeed(sOptionSCanvas.mPlayOption.getAnimationSpeed());
        this.f2086ae.mPlayOption.setPlayBGAudioOption(sOptionSCanvas.mPlayOption.getPlayBGAudioOption());
        this.f2086ae.mPlayOption.setRepeatBGAudioOption(sOptionSCanvas.mPlayOption.getRepeatBGAudioOption());
        this.f2086ae.mPlayOption.setStopBGAudioOption(sOptionSCanvas.mPlayOption.getStopBGAudioOption());
        this.f2086ae.mPlayOption.setBGAudioVolume(sOptionSCanvas.mPlayOption.getBGAudioVolume());
        this.f2086ae.mPlayOption.setSoundEffectOption(sOptionSCanvas.mPlayOption.getSoundEffectOption());
        this.f2086ae.mPlayOption.setSoundEffectVolume(sOptionSCanvas.mPlayOption.getSoundEffectVolume());
        this.f2073U.mo173a(this.f2086ae.mSAMMOption);
        this.f2083ab.mo1654a(this.f2086ae.mPlayOption);
        return true;
    }

    public SOptionSCanvas getOption() {
        if (!m2022b() || this.f2086ae == null) {
            return null;
        }
        this.f2086ae.mSAMMOption = this.f2073U.mo186c();
        this.f2086ae.mPlayOption = this.f2083ab.mo1646a();
        return this.f2086ae;
    }

    public static boolean isSAMMFile(String str) {
        return C0907e.m626n(str);
    }

    public boolean loadSAMMFile(String str, boolean z) {
        return m2019a(str, false, z, false, false);
    }

    public boolean loadSAMMFile(String str, boolean z, boolean z2) {
        return m2020a(str, false, z, false, false, z2);
    }

    public boolean loadSAMMData(String str) {
        return m2019a(str, true, !isAnimationMode(), false, false);
    }

    public boolean loadSAMMData(String str, boolean z) {
        return m2020a(str, true, !isAnimationMode(), false, false, z);
    }

    public boolean loadSAMMFile(String str, boolean z, boolean z2, boolean z3) {
        return m2019a(str, false, z, z2, z3);
    }

    /* renamed from: a */
    boolean m2019a(String str, boolean z, boolean z2, boolean z3, boolean z4) {
        return m2020a(str, z, z2, z3, z4, true);
    }

    /* renamed from: a */
    boolean m2020a(String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        if (!m2022b() || str == null) {
            return false;
        }
        this.f2084ac.mo1677a();
        this.f2082aa.mo1880a();
        this.f2074V.mo1958b();
        this.f2074V.mo1968i();
        if (z) {
            if (!this.f2073U.mo185b(str)) {
                Log.e(TAG, "loadSAMMData : Error on load SAMM Data : " + str);
                return false;
            }
        } else if (!this.f2073U.mo174a(str)) {
            Log.e(TAG, "Error on load SAMM File : " + str);
            return false;
        }
        this.f2091aj = true;
        if (!m2021a(false)) {
            return false;
        }
        if (z5 && !m2025b(false)) {
            return false;
        }
        this.f2091aj = false;
        LinkedList<SObject> linkedListMo165K = this.f2073U.mo165K();
        Iterator<SObject> it = linkedListMo165K.iterator();
        while (it.hasNext()) {
            it.next().setLayer(getSelectLayer());
        }
        if (!this.f2082aa.mo1883a(linkedListMo165K)) {
            Log.e(TAG, "Error on load SAMM File : " + str);
            return false;
        }
        this.f2075W.mo1700a(1.0f);
        this.f2075W.mo1736j(false);
        if (z2) {
            if (!m2018a(this.f2076Z, !this.f2092ak, linkedListMo165K, z3, z4)) {
                Log.e(TAG, "Error on restore CanvasView From SAMM Data");
                this.f2075W.mo1736j(true);
                return false;
            }
        }
        if (!z3) {
            if (this.f2058F != null) {
                this.f2058F.onLoadComplete(true);
            }
            this.f2075W.mo1736j(true);
            invalidate();
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0118  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    boolean m2021a(boolean r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 362
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.samsung.spensdk.SCanvasView.m2021a(boolean):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x001a  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0114  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    boolean m2025b(boolean r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 338
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.samsung.spensdk.SCanvasView.m2025b(boolean):boolean");
    }

    /* renamed from: a */
    boolean m2018a(InterfaceC1079b interfaceC1079b, boolean z, LinkedList<SObject> linkedList, boolean z2, boolean z3) {
        if (!m2022b() || interfaceC1079b == null) {
            return false;
        }
        if (z2) {
            if (z3) {
                interfaceC1079b.mo1768a(this.f2072T, z, linkedList);
            } else {
                interfaceC1079b.mo1768a((Context) null, z, linkedList);
            }
        } else {
            interfaceC1079b.mo1775a(z, linkedList);
        }
        return true;
    }

    public boolean saveSAMMFile(String str) {
        if (!m2022b() || str == null) {
            return false;
        }
        this.f2074V.mo1967h();
        if (!m2026c()) {
            Log.e(TAG, "Fail to add SAMM Data");
            return false;
        }
        if (!this.f2073U.mo188c(str)) {
            Log.e(TAG, "Fail to save SAMM File: " + str);
            return false;
        }
        return true;
    }

    public String saveSAMMData() {
        String strMo189d = null;
        if (m2022b()) {
            this.f2074V.mo1967h();
            if (!m2026c()) {
                Log.e(TAG, "Fail to add SAMM Data");
            } else {
                strMo189d = this.f2073U.mo189d();
                if (strMo189d == null) {
                    Log.e(TAG, "saveSAMMData : Fail to save Temp SAMM Data: " + strMo189d);
                }
            }
        }
        return strMo189d;
    }

    public boolean encodeSAMMDataInFile(String str) {
        if (!m2022b() || str == null) {
            return false;
        }
        this.f2074V.mo1967h();
        if (!m2026c()) {
            Log.e(TAG, "Fail to add SAMM Data");
            return false;
        }
        if (!this.f2073U.mo191d(str)) {
            Log.e(TAG, "Fail to encode SAMM Data into File: " + str);
            return false;
        }
        return true;
    }

    public static boolean removeSAMMDataFromFile(String str) {
        if (str == null) {
            return false;
        }
        if (!C0907e.m627o(str)) {
            Log.e(TAG, "Fail to remove SAMM Data from File: " + str);
            return false;
        }
        return true;
    }

    /* renamed from: c */
    boolean m2026c() {
        if (m2022b() && this.f2073U.mo164J()) {
            LinkedList<SObject> linkedListMo1885b = this.f2082aa.mo1885b(true);
            if (linkedListMo1885b == null) {
                return true;
            }
            ListIterator<SObject> listIterator = linkedListMo1885b.listIterator();
            while (listIterator.hasNext()) {
                if (!this.f2073U.mo172a(listIterator.next())) {
                    Log.e(TAG, "Fail to add Object");
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public boolean isSettingViewVisible(int i) {
        if (m2022b()) {
            return this.f2074V.mo1948a(i);
        }
        return false;
    }

    public boolean setSettingViewSizeOption(int i, int i2) {
        if (m2022b()) {
            return this.f2074V.mo1949a(i, i2);
        }
        return false;
    }

    public int getSettingViewSizeOption(int i) {
        if (m2022b()) {
            return this.f2074V.mo1955b(i);
        }
        return 0;
    }

    public boolean showSettingView(int i, boolean z) {
        if (!m2022b()) {
            return false;
        }
        requestLayout();
        return this.f2074V.mo1950a(i, z);
    }

    public boolean toggleShowSettingView(int i) {
        return isSettingViewVisible(i) ? showSettingView(i, false) : showSettingView(i, true);
    }

    public boolean setDeleteAllPopupVisible(boolean z) {
        if (m2022b()) {
            return this.f2074V.mo1954a(z);
        }
        return false;
    }

    public boolean getDeleteAllPopupVisible() {
        if (m2022b()) {
            return this.f2074V.mo1966g();
        }
        return false;
    }

    @Override // com.samsung.sdraw.CanvasView
    public void setTextBoxDefaultSize(int i, int i2) {
        if (m2022b()) {
            this.f2074V.mo1956b(i, i2);
        }
    }

    public SettingStrokeInfo getSettingStrokeInfo() {
        if (m2022b()) {
            return this.f2075W.mo1708b();
        }
        return null;
    }

    public boolean setSettingStrokeInfo(SettingStrokeInfo settingStrokeInfo) {
        if (m2022b()) {
            return this.f2075W.mo1706a(settingStrokeInfo);
        }
        return false;
    }

    public SettingStrokeInfo getSettingViewStrokeInfo() {
        if (m2022b()) {
            return this.f2074V.mo1963d();
        }
        return null;
    }

    public boolean setSettingViewStrokeInfo(SettingStrokeInfo settingStrokeInfo) {
        if (m2022b()) {
            return this.f2074V.mo1952a(settingStrokeInfo);
        }
        return false;
    }

    public boolean setSettingStrokeInfo(int i, float f, int i2) {
        if (m2022b()) {
            return this.f2075W.mo1673a(i, f, i2);
        }
        return false;
    }

    public boolean setEraserStrokeSetting(int i) {
        if (m2022b()) {
            return this.f2075W.mo1715c(i);
        }
        return false;
    }

    @Deprecated
    public boolean setEraserPenSetting(int i) {
        if (m2022b()) {
            return this.f2075W.mo1715c(i);
        }
        return false;
    }

    public SettingStrokeInfo getSettingStrokeInfo(int i) {
        if (m2022b()) {
            return this.f2075W.mo1694a(i);
        }
        return null;
    }

    public boolean setSettingStrokeInfo(int i, SettingStrokeInfo settingStrokeInfo) {
        if (m2022b()) {
            return this.f2075W.mo1702a(i, settingStrokeInfo);
        }
        return false;
    }

    public SettingTextInfo getSettingTextInfo() {
        if (m2022b()) {
            return this.f2075W.mo1712c();
        }
        return null;
    }

    public boolean setSettingTextInfo(SettingTextInfo settingTextInfo) {
        if (m2022b()) {
            return this.f2075W.mo1707a(settingTextInfo);
        }
        return false;
    }

    public SettingTextInfo getSettingViewTextInfo() {
        if (m2022b()) {
            return this.f2074V.mo1964e();
        }
        return null;
    }

    public boolean setSettingViewTextInfo(SettingTextInfo settingTextInfo) {
        if (m2022b()) {
            return this.f2074V.mo1953a(settingTextInfo);
        }
        return false;
    }

    public boolean setSettingTextInfo(int i, float f, int i2, String str) {
        if (m2022b()) {
            return this.f2075W.mo1674a(i, f, i2, str);
        }
        return false;
    }

    public SettingFillingInfo getSettingFillingInfo() {
        if (m2022b()) {
            return this.f2075W.mo1717d();
        }
        return null;
    }

    public boolean setSettingFillingInfo(SettingFillingInfo settingFillingInfo) {
        if (m2022b()) {
            return this.f2075W.mo1705a(settingFillingInfo);
        }
        return false;
    }

    public SettingFillingInfo getSettingViewFillingInfo() {
        if (m2022b()) {
            return this.f2074V.mo1965f();
        }
        return null;
    }

    public boolean setSettingViewFillingInfo(SettingFillingInfo settingFillingInfo) {
        if (m2022b()) {
            return this.f2074V.mo1951a(settingFillingInfo);
        }
        return false;
    }

    public SettingTextInfo getSettingTextInfo(int i) {
        if (m2022b()) {
            return this.f2075W.mo1709b(i);
        }
        return null;
    }

    public boolean setSettingTextInfo(int i, SettingTextInfo settingTextInfo) {
        if (m2022b()) {
            return this.f2075W.mo1703a(i, settingTextInfo);
        }
        return false;
    }

    public int getSettingViewPresetNum() {
        if (m2022b()) {
            return this.f2074V.mo1970k();
        }
        return 0;
    }

    public SettingStrokeInfo getSettingViewPresetInfo(int i) {
        if (m2022b()) {
            return this.f2074V.mo1960c(i);
        }
        return null;
    }

    public boolean deleteSettingViewPresetInfo(int i, boolean z) {
        if (m2022b()) {
            return this.f2074V.mo1959b(i, z);
        }
        return false;
    }

    public void setUseHistoricalEventForStroke(boolean z) {
        if (m2022b()) {
            this.f2076Z.mo1774a(z);
        }
    }

    @Override // com.samsung.sdraw.CanvasView
    public void hideImm() {
        if (m2022b()) {
            this.f2074V.mo1967h();
        }
    }

    public void setTextIMEOptionFlagNoExtractUI(boolean z) {
        if (m2022b()) {
            this.f2074V.mo1957b(z);
        }
    }

    public boolean setProgressDialogSetting(String str, String str2, int i, boolean z) {
        if (!m2022b()) {
            return false;
        }
        this.f2076Z.mo1773a(str, str2, i, z);
        return true;
    }

    public boolean setCanvasDrawable(boolean z) {
        if (m2022b()) {
            return this.f2075W.mo1720d(z);
        }
        return false;
    }

    public boolean getCanvasDrawable() {
        if (m2022b()) {
            return this.f2075W.mo1731h();
        }
        return false;
    }

    public boolean setCanvasSupportPenOnly(boolean z) {
        if (m2022b()) {
            return this.f2075W.mo1723e(z);
        }
        return false;
    }

    public boolean getCanvasSupportPenOnly() {
        if (m2022b()) {
            return this.f2075W.mo1734i();
        }
        return false;
    }

    public void setCanvasZoomEnable(boolean z) {
        if (m2022b()) {
            this.f2075W.mo1724f(z);
        }
    }

    public boolean getCanvasZoomEnable() {
        if (m2022b()) {
            return this.f2075W.mo1737j();
        }
        return false;
    }

    public void setCanvasPanEnable(boolean z) {
        if (m2022b()) {
            this.f2075W.mo1728g(z);
        }
    }

    public boolean getCanvasPanEnable() {
        if (m2022b()) {
            return this.f2075W.mo1738k();
        }
        return false;
    }

    @Override // com.samsung.sdraw.CanvasView
    public void setDrawingFront(boolean z) {
        if (m2022b()) {
            this.f2075W.mo1730h(z);
        }
    }

    @Override // com.samsung.sdraw.CanvasView
    public void setPanningMode(boolean z) {
        if (m2022b()) {
            this.f2075W.mo1716c(z);
        }
    }

    @Override // com.samsung.sdraw.CanvasView
    public boolean getPanningMode() {
        if (m2022b()) {
            return this.f2075W.mo1725f();
        }
        return false;
    }

    public boolean setCanvasZoomScale(float f) {
        if (m2022b()) {
            return this.f2075W.mo1700a(f);
        }
        return false;
    }

    public boolean setCanvasZoomScale(float f, float f2, float f3) {
        if (m2022b()) {
            return this.f2075W.mo1701a(f, f2, f3);
        }
        return false;
    }

    public float getCanvasZoomScale() {
        return !m2022b() ? VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET : this.f2075W.mo1721e();
    }

    public boolean setCanvasBaseZoomScale(float f) {
        if (m2022b()) {
            return this.f2075W.mo1710b(f);
        }
        return false;
    }

    public boolean setCanvasMatrix(Matrix matrix) {
        if (m2022b()) {
            return this.f2075W.mo1704a(matrix);
        }
        return false;
    }

    public boolean setCanvasMaxZoomScale(float f) {
        if (m2022b()) {
            return this.f2075W.mo1713c(f);
        }
        return false;
    }

    public boolean setCanvasMinZoomScale(float f) {
        if (m2022b()) {
            return this.f2075W.mo1718d(f);
        }
        return false;
    }

    public boolean panBySCanvas(float f, float f2) {
        if (m2022b()) {
            return this.f2075W.mo1711b(f, f2);
        }
        return false;
    }

    public boolean panToSCanvas(float f, float f2) {
        if (m2022b()) {
            return this.f2075W.mo1714c(f, f2);
        }
        return false;
    }

    public int getCanvasMode() {
        if (m2022b()) {
            return this.f2075W.mo1727g();
        }
        return 0;
    }

    public boolean setCanvasMode(int i) {
        if (m2022b()) {
            return this.f2075W.mo1719d(i);
        }
        return false;
    }

    @Override // com.samsung.sdraw.CanvasView
    public void setTouchEventDispatchMode(boolean z) {
        if (m2022b()) {
            this.f2075W.mo1740l(z);
        }
    }

    @Override // com.samsung.sdraw.CanvasView
    public boolean getTouchEventDispatchMode() {
        if (m2022b()) {
            return this.f2075W.mo1743m();
        }
        return false;
    }

    @Override // com.samsung.sdraw.CanvasView
    public void setHistoricalOperationSupport(boolean z) {
        if (m2022b()) {
            this.f2075W.mo1742m(z);
        }
    }

    @Override // com.samsung.sdraw.CanvasView
    public boolean isHistoricalOperationSupport() {
        if (m2022b()) {
            return this.f2075W.mo1745n();
        }
        return true;
    }

    @Override // com.samsung.sdraw.CanvasView
    public void setTextLongClickSelectOption(boolean z) {
        if (m2022b()) {
            this.f2075W.mo1744n(z);
        }
    }

    @Override // com.samsung.sdraw.CanvasView
    public boolean getTextLongClickSelectOption() {
        if (m2022b()) {
            return this.f2075W.mo1747o();
        }
        return true;
    }

    public void setUseCanvasLongPressListener(boolean z) {
        if (m2022b()) {
            this.f2075W.mo1746o(z);
        }
    }

    public boolean setEraserAnimationMode(boolean z) {
        if (!m2022b()) {
            return false;
        }
        this.f2075W.mo1671a(z);
        return true;
    }

    public boolean isEraserAnimationMode() {
        if (m2022b()) {
            return this.f2075W.mo1672a();
        }
        return false;
    }

    @Override // com.samsung.sdraw.CanvasView
    public void setEraserCursorVisible(boolean z) {
        if (m2022b()) {
            this.f2075W.mo1675b(z);
        }
    }

    public void setColorPickerMode(boolean z) {
        if (m2022b()) {
            this.f2075W.mo1733i(z);
        }
    }

    public boolean isColorPickerMode() {
        if (m2022b()) {
            return this.f2075W.mo1741l();
        }
        return false;
    }

    public void getColorPickerColor(float f, float f2) {
        if (m2022b()) {
            this.f2075W.mo1693a(f, f2);
        }
    }

    @Override // com.samsung.sdraw.CanvasView
    public boolean undo() {
        if (!m2022b()) {
            return false;
        }
        if (this.f2075W == null) {
            Log.e(TAG, "Canvas Manager is not activated yet.");
            return false;
        }
        return this.f2075W.mo1751q();
    }

    @Override // com.samsung.sdraw.CanvasView
    public boolean undo(int i) {
        if (!m2022b()) {
            return false;
        }
        if (this.f2075W == null) {
            Log.e(TAG, "Canvas Manager is not activated yet.");
            return false;
        }
        return this.f2075W.mo1722e(i);
    }

    @Override // com.samsung.sdraw.CanvasView
    public boolean redo() {
        if (!m2022b()) {
            return false;
        }
        if (this.f2075W == null) {
            Log.e(TAG, "Canvas Manager is not activated yet.");
            return false;
        }
        return this.f2075W.mo1753r();
    }

    @Override // com.samsung.sdraw.CanvasView
    public boolean redo(int i) {
        if (!m2022b()) {
            return false;
        }
        if (this.f2075W == null) {
            Log.e(TAG, "Canvas Manager is not activated yet.");
            return false;
        }
        return this.f2075W.mo1726f(i);
    }

    @Override // com.samsung.sdraw.CanvasView
    public boolean isUndoable() {
        if (m2022b()) {
            return this.f2075W.mo1755s();
        }
        return false;
    }

    @Override // com.samsung.sdraw.CanvasView
    public boolean isUndoable(int i) {
        if (m2022b()) {
            return this.f2075W.mo1729g(i);
        }
        return false;
    }

    @Override // com.samsung.sdraw.CanvasView
    public boolean isRedoable() {
        if (m2022b()) {
            return this.f2075W.mo1756t();
        }
        return false;
    }

    @Override // com.samsung.sdraw.CanvasView
    public boolean isRedoable(int i) {
        if (m2022b()) {
            return this.f2075W.mo1732h(i);
        }
        return false;
    }

    @Override // com.samsung.sdraw.CanvasView
    public boolean isDrawing() {
        if (m2022b()) {
            return this.f2075W.mo1757u();
        }
        return false;
    }

    @Override // com.samsung.sdraw.CanvasView
    public void cancelDrawing() {
        if (m2022b()) {
            this.f2075W.mo1758v();
        }
    }

    public boolean isTextEditing() {
        if (m2022b()) {
            return this.f2075W.mo1759w();
        }
        return false;
    }

    public void cancelTextEditing() {
        if (m2022b()) {
            this.f2075W.mo1760x();
        }
    }

    @Override // com.samsung.sdraw.CanvasView
    public void cancelDrawing(int i) {
        if (m2022b()) {
            this.f2075W.mo1735i(i);
        }
    }

    @Override // com.samsung.sdraw.CanvasView
    public void cancelAllDrawing() {
        if (m2022b()) {
            this.f2075W.mo1761y();
        }
    }

    @Override // com.samsung.sdraw.CanvasView
    public boolean isAnyoneDrawing() {
        if (m2022b()) {
            return this.f2075W.mo1762z();
        }
        return false;
    }

    @Override // com.samsung.sdraw.CanvasView
    public void setMultiTouchCancel(boolean z) {
        if (m2022b()) {
            this.f2075W.mo1739k(z);
        }
    }

    @Override // com.samsung.sdraw.CanvasView
    public void deleteAll(boolean z) {
        if (m2022b()) {
            this.f2075W.mo1754s(z);
        }
    }

    @Override // com.samsung.sdraw.CanvasView
    public void deleteAll(boolean z, int i) {
        if (m2022b()) {
            this.f2075W.mo1699a(z, i);
            if (i == 0) {
                this.f2094am = true;
            } else if (i == 1) {
                this.f2095an = true;
            }
        }
    }

    public boolean initCheckLayerObjectChange(int i) {
        if (!m2022b()) {
            return false;
        }
        if (i == 0) {
            this.f2094am = false;
        } else {
            if (i != 1) {
                return false;
            }
            this.f2095an = false;
        }
        return true;
    }

    public boolean checkLayerObjectChange(int i) {
        if (!m2022b()) {
            return false;
        }
        if (i == 0) {
            return this.f2094am;
        }
        if (i == 1) {
            return this.f2095an;
        }
        return false;
    }

    public boolean setCanvasBitmap(Bitmap bitmap) {
        if (m2022b()) {
            return this.f2076Z.mo1781a(bitmap, true);
        }
        return false;
    }

    public Bitmap getCanvasBitmap(boolean z) {
        if (m2022b()) {
            return this.f2076Z.mo1785b(z);
        }
        return null;
    }

    public boolean isCanvasDrawingEmpty(boolean z, boolean z2) {
        if (!m2022b()) {
            return true;
        }
        if (z && z2) {
            LinkedList<SObject> linkedListB = this.f2082aa.mo1855b(getSelectLayer());
            if (linkedListB == null || linkedListB.size() == 0) {
                return true;
            }
            boolean zM1998a = m1998a(linkedListB);
            if (!zM1998a) {
                return zM1998a;
            }
        }
        return m2005c(z);
    }

    /* renamed from: a */
    private boolean m1998a(LinkedList<SObject> linkedList) {
        Iterator<SObject> it = linkedList.iterator();
        while (it.hasNext()) {
            SObject next = it.next();
            if ((next instanceof SObjectStroke) && ((SObjectStroke) next).getStyle() == 4) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: c */
    private boolean m2005c(boolean z) {
        if (!m2022b()) {
            return true;
        }
        Bitmap bitmapMo1785b = this.f2076Z.mo1785b(z);
        if (bitmapMo1785b == null) {
            return false;
        }
        int width = bitmapMo1785b.getWidth() * bitmapMo1785b.getHeight();
        int[] iArr = new int[width];
        bitmapMo1785b.copyPixelsToBuffer(IntBuffer.wrap(iArr));
        for (int i = 0; i < width; i++) {
            if (iArr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    protected boolean setSCanvasSize(int i, int i2) {
        if (m2022b()) {
            return this.f2076Z.mo1792c(i, i2);
        }
        return false;
    }

    public boolean setSCanvasBitmapData(byte[] bArr) {
        if (m2022b()) {
            return this.f2076Z.mo1783a(bArr);
        }
        return false;
    }

    public byte[] getSCanvasBitmapData() {
        if (m2022b()) {
            return this.f2076Z.mo1796d();
        }
        return null;
    }

    public boolean setClearImageBitmap(Bitmap bitmap) {
        if (!m2022b() || !this.f2076Z.mo1779a(bitmap)) {
            return false;
        }
        if (isAnimationMode()) {
            this.f2092ak = true;
        }
        return m2024b(bitmap);
    }

    /* renamed from: b */
    boolean m2024b(Bitmap bitmap) {
        if (this.f2073U.mo184b(bitmap)) {
            return true;
        }
        Log.e(TAG, "Fail to set Foreground Image Bitmap");
        return false;
    }

    public Bitmap getClearImageBitmap() {
        if (m2022b()) {
            return this.f2076Z.mo1784b();
        }
        return null;
    }

    public boolean setClearImageBitmap(Bitmap bitmap, int i, int i2) {
        if (!m2022b() || !this.f2076Z.mo1780a(bitmap, i, i2)) {
            return false;
        }
        if (isAnimationMode()) {
            this.f2092ak = true;
        }
        return m2024b(this.f2076Z.mo1784b());
    }

    public boolean clearSCanvasView() throws Throwable {
        if (!m2022b()) {
            return false;
        }
        this.f2076Z.mo1667a();
        this.f2073U.mo192e();
        m2021a(false);
        return true;
    }

    public boolean clearScreen() throws Throwable {
        if (!m2022b()) {
            return false;
        }
        this.f2076Z.mo1667a();
        m2021a(false);
        return true;
    }

    public boolean setAnimationMode(boolean z) {
        if (!m2022b()) {
            return false;
        }
        this.f2083ab.mo1651a(z);
        this.f2075W.mo1720d(!z);
        this.f2085ad.onSetObjectManagerInterface(this.f2082aa);
        this.f2085ad.onSetDispatchObjectEvent(z ? false : true);
        return true;
    }

    public boolean isAnimationMode() {
        if (m2022b()) {
            return this.f2083ab.mo1659b();
        }
        return false;
    }

    public int getAnimationState() {
        if (m2022b()) {
            return this.f2083ab.mo1661c();
        }
        return 0;
    }

    public boolean setAnimationSpeed(int i) {
        if (m2022b()) {
            return this.f2083ab.mo1652a(i);
        }
        return false;
    }

    public int getAnimationSpeed() {
        if (m2022b()) {
            return this.f2083ab.mo1666g();
        }
        return 4;
    }

    public boolean doAnimationStart() throws Throwable {
        if (!m2022b()) {
            return false;
        }
        if (this.f2086ae == null) {
            Log.e(TAG, "Canvas Option is null");
            return false;
        }
        if (this.f2086ae.mPlayOption == null) {
            Log.e(TAG, "Play Option is null");
            return false;
        }
        m2021a(this.f2086ae.mPlayOption.getInvisibleBGImageAnimationOption());
        if (this.f2092ak) {
            this.f2076Z.mo1667a();
            if (!this.f2082aa.mo1883a(this.f2073U.mo165K())) {
                return false;
            }
        }
        return this.f2083ab.mo1656a(this.f2092ak ? false : true, this.f2082aa.mo1885b(false), this.f2073U.mo156B());
    }

    public boolean doAnimationPause() {
        if (m2022b()) {
            return this.f2083ab.mo1664e();
        }
        return false;
    }

    public boolean doAnimationResume() {
        if (m2022b()) {
            return this.f2083ab.mo1663d();
        }
        return false;
    }

    public boolean doAnimationStop(boolean z) {
        if (m2022b()) {
            return this.f2083ab.mo1657a(z, true);
        }
        return false;
    }

    public boolean doAnimationClose() {
        if (!m2022b()) {
            return false;
        }
        this.f2083ab.mo1665f();
        if (this.f2073U.mo159E()) {
            this.f2073U.mo162H();
        }
        this.f2082aa.mo1880a();
        return true;
    }

    public boolean setAppID(String str, int i, int i2, String str2) {
        if (m2022b()) {
            return C0907e.m622a(str, i, i2, str2);
        }
        return false;
    }

    public String getAppID() {
        if (m2022b()) {
            return C0907e.m607R();
        }
        return null;
    }

    public String getAppIDName() {
        if (m2022b()) {
            return C0907e.m608S();
        }
        return null;
    }

    public int getAppIDVerMajor() {
        if (m2022b()) {
            return C0907e.m609T();
        }
        return 0;
    }

    public int getAppIDVerMinor() {
        if (m2022b()) {
            return C0907e.m610U();
        }
        return 0;
    }

    public String getAppIDVerPatchName() {
        if (m2022b()) {
            return C0907e.m611V();
        }
        return null;
    }

    public String getLoadAppID() {
        if (m2022b()) {
            return this.f2073U.mo196f();
        }
        return null;
    }

    public String getLoadAppIDName() {
        if (m2022b()) {
            return this.f2073U.mo199g();
        }
        return null;
    }

    public int getLoadAppIDVerMajor() {
        if (m2022b()) {
            return this.f2073U.mo201h();
        }
        return 0;
    }

    public int getLoadAppIDVerMinor() {
        if (m2022b()) {
            return this.f2073U.mo203i();
        }
        return 0;
    }

    public String getLoadAppIDVerPatchName() {
        if (m2022b()) {
            return this.f2073U.mo205j();
        }
        return null;
    }

    public boolean setTitle(String str) {
        return m2022b() && this.f2073U.mo194e(str);
    }

    public String getTitle() {
        if (m2022b()) {
            return this.f2073U.mo207k();
        }
        return null;
    }

    public boolean setAuthor(String str, String str2, String str3, Bitmap bitmap) {
        if (m2022b()) {
            return this.f2073U.mo178a(str, str2, str3, bitmap);
        }
        return false;
    }

    public String getAuthorName() {
        if (m2022b()) {
            return this.f2073U.mo209l();
        }
        return null;
    }

    public String getAuthorPhoneNum() {
        if (m2022b()) {
            return this.f2073U.mo211m();
        }
        return null;
    }

    public String getAuthorEmail() {
        if (m2022b()) {
            return this.f2073U.mo213n();
        }
        return null;
    }

    public Bitmap getAuthorImage() {
        if (m2022b()) {
            return this.f2073U.mo214o();
        }
        return null;
    }

    public long getCreateTime() {
        if (m2022b()) {
            return this.f2073U.mo215p();
        }
        return 0L;
    }

    public boolean setHypertext(String str) {
        if (m2022b()) {
            return this.f2073U.mo197f(str);
        }
        return false;
    }

    public String getHypertext() {
        if (m2022b()) {
            return this.f2073U.mo216q();
        }
        return null;
    }

    public boolean setGeoTag(int i, int i2) {
        if (m2022b()) {
            return this.f2073U.mo169a(i, i2);
        }
        return false;
    }

    public int getGeoTagLatitude() {
        if (m2022b()) {
            return this.f2073U.mo217r();
        }
        return 0;
    }

    public int getGeoTagLongitude() {
        if (m2022b()) {
            return this.f2073U.mo218s();
        }
        return 0;
    }

    public String[] getTags() {
        if (m2022b()) {
            return this.f2073U.mo219t();
        }
        return null;
    }

    public boolean addTag(String str) {
        if (m2022b()) {
            return this.f2073U.mo200g(str);
        }
        return false;
    }

    public boolean removeTag(String str) {
        if (m2022b()) {
            return this.f2073U.mo202h(str);
        }
        return false;
    }

    public boolean setCheckPreference(int i) {
        if (m2022b()) {
            return this.f2073U.mo168a(i);
        }
        return false;
    }

    public int getCheckPreference() {
        if (m2022b()) {
            return this.f2073U.mo220u();
        }
        return 0;
    }

    public boolean putExtra(String str, String str2) {
        if (m2022b()) {
            return this.f2073U.mo176a(str, str2);
        }
        return false;
    }

    public String getStringExtra(String str, String str2) {
        if (m2022b()) {
            return this.f2073U.mo180b(str, str2);
        }
        return null;
    }

    public boolean clearStringExtra(String str) {
        if (m2022b()) {
            return this.f2073U.mo204i(str);
        }
        return false;
    }

    public boolean putExtra(String str, int i) {
        if (m2022b()) {
            return this.f2073U.mo175a(str, i);
        }
        return false;
    }

    public int getIntExtra(String str, int i) {
        return !m2022b() ? i : this.f2073U.mo179b(str, i);
    }

    public boolean clearIntExtra(String str) {
        if (m2022b()) {
            return this.f2073U.mo206j(str);
        }
        return false;
    }

    @Override // com.samsung.sdraw.CanvasView, android.view.View
    public void setBackgroundColor(int i) {
        super.setBackgroundColor(i);
        setBGColor(i);
    }

    public boolean setBGColor(int i) {
        if (!m2022b()) {
            return false;
        }
        super.setBackgroundColor(i);
        if (!this.f2073U.mo182b(i)) {
            Log.e(TAG, "Fail to set Background color");
            return false;
        }
        return true;
    }

    public int getBGColor() {
        if (m2022b()) {
            return this.f2073U.mo221v();
        }
        return 0;
    }

    public boolean setCustomBGImageIndex(int i) {
        if (m2022b()) {
            return this.f2073U.mo187c(i);
        }
        return false;
    }

    public int getCustomBGImageIndex() {
        if (m2022b()) {
            return this.f2073U.mo222w();
        }
        return -1;
    }

    public boolean setBGImagePath(String str) {
        Bitmap bitmapCreateScaledBitmap;
        if (!m2022b()) {
            return false;
        }
        if (this.f2089ah) {
            if (this.f2073U.mo208k(str)) {
                return m2021a(false);
            }
            return false;
        }
        Bitmap bitmapM574a = C0902p.m574a(str, this.f2087af, this.f2088ag);
        if (bitmapM574a == null || (bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapM574a, this.f2087af, this.f2088ag, true)) == null) {
            return false;
        }
        return setBGImage(bitmapCreateScaledBitmap);
    }

    public String getBGImagePath() {
        if (m2022b()) {
            return this.f2073U.mo223x();
        }
        return null;
    }

    public String getBGImagePathDecoded() {
        if (m2022b()) {
            return this.f2073U.mo224y();
        }
        return null;
    }

    public String getClearImagePathDecoded() {
        if (m2022b()) {
            return this.f2073U.mo225z();
        }
        return null;
    }

    @Override // com.samsung.sdraw.CanvasView
    @Deprecated
    public boolean setBackgroundTemplate(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3) {
        if (!m2022b()) {
            return false;
        }
        return m2027c(this.f2076Z.mo1765a(bitmap, bitmap2, bitmap3));
    }

    @Override // com.samsung.sdraw.CanvasView
    public boolean setBackgroundImage(Bitmap bitmap) {
        return setBGImage(bitmap);
    }

    public boolean setBackgroundImageExpress(Bitmap bitmap) {
        return m2022b() && this.f2076Z.mo1793c(bitmap);
    }

    public boolean setBGImage(Bitmap bitmap) {
        if (!m2022b() || bitmap == null) {
            return false;
        }
        if (!this.f2089ah && (bitmap.getWidth() != this.f2087af || bitmap.getHeight() != this.f2088ag)) {
            bitmap = Bitmap.createScaledBitmap(bitmap, this.f2087af, this.f2088ag, true);
        }
        if (this.f2076Z.mo1793c(bitmap)) {
            return m2027c(bitmap);
        }
        return false;
    }

    /* renamed from: c */
    boolean m2027c(Bitmap bitmap) {
        if (bitmap == null) {
            return false;
        }
        if (!this.f2073U.mo170a(bitmap)) {
            Log.e(TAG, "Fail to set Background Image Bitmap");
            return false;
        }
        return true;
    }

    public boolean filterBGImage(int i, int i2) {
        if (m2022b() && this.f2073U.mo183b(i, i2)) {
            return m2021a(false);
        }
        return false;
    }

    public boolean setBGAudioFile(String str) {
        if (m2022b()) {
            return this.f2073U.mo210l(str);
        }
        return false;
    }

    public String getBGAudioFile() {
        if (m2022b()) {
            return this.f2073U.mo156B();
        }
        return null;
    }

    public boolean setCustomBGAudioIndex(int i) {
        if (m2022b()) {
            return this.f2073U.mo190d(i);
        }
        return false;
    }

    public int getCustomBGAudioIndex() {
        if (m2022b()) {
            return this.f2073U.mo155A();
        }
        return -1;
    }

    public boolean clearBGAudio() {
        if (m2022b()) {
            return this.f2073U.mo158D();
        }
        return false;
    }

    public boolean isVoiceRecording() {
        if (m2022b()) {
            return this.f2073U.mo159E();
        }
        return false;
    }

    public boolean recordVoiceStart() {
        if (m2022b()) {
            return this.f2073U.mo160F();
        }
        return false;
    }

    public boolean recordVoiceCancel() {
        if (!m2022b()) {
            return false;
        }
        this.f2083ab.mo1657a(true, true);
        return this.f2073U.mo162H();
    }

    public boolean recordVoiceComplete() {
        if (!m2022b()) {
            return false;
        }
        this.f2083ab.mo1657a(true, true);
        return this.f2073U.mo161G();
    }

    public boolean setBGAudioAsRecordedVoice() {
        if (m2022b()) {
            return this.f2073U.mo157C();
        }
        return false;
    }

    public boolean attachFile(String str, String str2, Bitmap bitmap, int i) {
        if (m2022b()) {
            return this.f2073U.mo177a(str, str2, bitmap, i);
        }
        return false;
    }

    public boolean attachFile(SDataAttachFile sDataAttachFile) {
        if (m2022b()) {
            return this.f2073U.mo177a(sDataAttachFile.getFilePath(), sDataAttachFile.getFileDescription(), sDataAttachFile.getFileIconBitmap(), 0);
        }
        return false;
    }

    public boolean detachFile(String str) {
        if (m2022b()) {
            return this.f2073U.mo212m(str);
        }
        return false;
    }

    public boolean detachFile(int i) {
        if (m2022b()) {
            return this.f2073U.mo193e(i);
        }
        return false;
    }

    public int getAttachedFileNum() {
        if (m2022b()) {
            return this.f2073U.mo163I();
        }
        return 0;
    }

    public SDataAttachFile getAttachedFileData(int i) {
        if (m2022b()) {
            return this.f2073U.mo195f(i);
        }
        return null;
    }

    public boolean setPageMemo(SDataPageMemo sDataPageMemo, int i) {
        if (m2022b()) {
            return this.f2073U.mo171a(sDataPageMemo, i);
        }
        return false;
    }

    public SDataPageMemo getPageMemo(int i) {
        if (m2022b()) {
            return this.f2073U.mo198g(i);
        }
        return null;
    }

    public int getSAMMObjectNum() {
        if (m2022b()) {
            return this.f2082aa.mo1877a(true);
        }
        return 0;
    }

    public int getSAMMObjectNum(boolean z) {
        if (m2022b()) {
            return this.f2082aa.mo1877a(z);
        }
        return 0;
    }

    public final SObject getSAMMObject(int i) {
        if (m2022b()) {
            return this.f2082aa.mo1879a(i, true, true);
        }
        return null;
    }

    public final SObject getSAMMObject(int i, boolean z) {
        if (m2022b()) {
            return this.f2082aa.mo1878a(i, z);
        }
        return null;
    }

    public RectF getSelectedSObjectRect() {
        if (m2022b()) {
            return this.f2075W.mo1748p();
        }
        return null;
    }

    @Override // com.samsung.sdraw.CanvasView
    public void setRemoveLongPressStroke(boolean z) {
        if (m2022b()) {
            this.f2075W.mo1749p(z);
        }
    }

    public void setSelectAllTextByLongPress(boolean z) {
        if (m2022b()) {
            this.f2075W.mo1750q(z);
        }
    }

    public void setSelectAllTextByDoubleTap(boolean z) {
        if (m2022b()) {
            this.f2075W.mo1752r(z);
        }
    }

    public LinkedList<SObject> getSObjectListbyLayer(int i) {
        if (m2022b()) {
            return this.f2082aa.mo1855b(i);
        }
        return null;
    }

    public boolean insertSAMMStroke(SObjectStroke sObjectStroke) {
        return m1996a((SObject) sObjectStroke, false);
    }

    public boolean insertSAMMFilling(SObjectFilling sObjectFilling) {
        return m1996a((SObject) sObjectFilling, false);
    }

    public boolean insertSAMMImage(SObjectImage sObjectImage, boolean z) {
        return m1996a(sObjectImage, z);
    }

    public boolean insertSAMMText(SObjectText sObjectText, boolean z) {
        return m1996a(sObjectText, z);
    }

    /* renamed from: a */
    private boolean m1996a(SObject sObject, boolean z) {
        if (!m2022b()) {
            return false;
        }
        if (sObject == null) {
            Log.e(TAG, "Invalid Object Data");
            return false;
        }
        this.f2074V.mo1967h();
        SObject sObjectCopyObject = sObject.copyObject();
        if (sObjectCopyObject instanceof SObjectStroke) {
            if (((SObjectStroke) sObjectCopyObject).getPointNum() <= 0) {
                Log.e(TAG, "Invalid Stroke point num");
                return false;
            }
        } else if (sObjectCopyObject instanceof SObjectText) {
            SObjectText sObjectText = (SObjectText) sObjectCopyObject;
            if (sObjectText.getRect() == null) {
                Log.e(TAG, "Invalid Text Area");
                return false;
            }
            if (sObjectText.getText() == null) {
                Log.e(TAG, "Text Data is null");
                return false;
            }
        } else if (sObjectCopyObject instanceof SObjectImage) {
            SObjectImage sObjectImage = (SObjectImage) sObjectCopyObject;
            if (sObjectImage.getRect() == null) {
                Log.e(TAG, "Invalid image Area");
                return false;
            }
            if (sObjectImage.getStyle() == 2 && !sObjectImage.isValidImage()) {
                Log.e(TAG, "Invalid Image Bitmap");
                return false;
            }
        } else if ((sObjectCopyObject instanceof SObjectFilling) && ((SObjectFilling) sObjectCopyObject).getFillPoint() == null) {
            Log.e(TAG, "Fill Point is null");
            return false;
        }
        if (this.f2082aa.mo1854b(sObjectCopyObject) == -1) {
            return false;
        }
        if (!this.f2076Z.mo1782a(sObjectCopyObject, z)) {
            this.f2082aa.mo1886b();
            return false;
        }
        return true;
    }

    public boolean changeSAMMObject(int i, SObject sObject) {
        if (!m2022b()) {
            return false;
        }
        LinkedList<SObject> linkedListMo1885b = this.f2082aa.mo1885b(true);
        if (linkedListMo1885b == null) {
            Log.e(TAG, "There is no visible object");
            return false;
        }
        if (i < 0 || i >= linkedListMo1885b.size()) {
            Log.e(TAG, "There is object of that index : " + i);
            return false;
        }
        SObject sObject2 = linkedListMo1885b.get(i);
        if (sObject2 instanceof SObjectStroke) {
            Log.e(TAG, "Only image or text object can be changed");
            return false;
        }
        if ((!(sObject2 instanceof SObjectImage) || !(sObject instanceof SObjectImage)) && ((!(sObject2 instanceof SObjectText) || !(sObject instanceof SObjectText)) && (!(sObject2 instanceof SObjectFilling) || !(sObject instanceof SObjectFilling)))) {
            Log.e(TAG, "Type of object to change is different");
            return false;
        }
        if (!this.f2082aa.mo1887b(sObject2, sObject)) {
            Log.e(TAG, "Fail to change sObject!");
            return false;
        }
        return this.f2076Z.mo1795d(sObject2);
    }

    public boolean deleteSAMMObject(SObject sObject) {
        if (m2022b()) {
            return this.f2076Z.mo1794c(sObject);
        }
        return false;
    }

    public SObject selectSAMMObject(int i, int i2) {
        if (m2022b()) {
            return this.f2076Z.mo1767a(i, i2);
        }
        return null;
    }

    public boolean drawSAMMStrokePoint(int i, float f, float f2, float f3, int i2, long j, long j2) {
        if (m2022b()) {
            return this.f2076Z.mo1668a(i, f, f2, f3, i2, j, j2);
        }
        return false;
    }

    /* renamed from: a */
    private boolean m1995a(int i, int i2, SObject sObject) {
        if (!m2022b()) {
            return false;
        }
        if (sObject instanceof SObjectStroke) {
            SObjectStroke sObjectStroke = (SObjectStroke) sObject;
            if (sObjectStroke == null) {
                Log.e(TAG, "Invalid StrokeData");
                return false;
            }
            if (sObjectStroke.getPointNum() <= 0) {
                Log.e(TAG, "Invalid Stroke point num");
                return false;
            }
        } else if (sObject instanceof SObjectText) {
            SObjectText sObjectText = (SObjectText) sObject;
            if (sObjectText.getRect() == null) {
                Log.e(TAG, "Invalid Text Area");
                return false;
            }
            if (sObjectText.getText() == null) {
                Log.e(TAG, "Text Data is null");
                return false;
            }
        } else if (sObject instanceof SObjectImage) {
            SObjectImage sObjectImage = (SObjectImage) sObject;
            if (sObjectImage.getRect() == null) {
                Log.e(TAG, "Invalid image Area");
                return false;
            }
            if (sObjectImage.getStyle() == 2 && sObjectImage.getImageBitmap() == null) {
                Log.e(TAG, "Invalid Image Bitmap");
                return false;
            }
        }
        if (this.f2082aa.mo1848a(i, i2, sObject) == -1) {
            return false;
        }
        if (!this.f2076Z.mo1778a(i, i2, sObject)) {
            this.f2082aa.mo1889c();
            return false;
        }
        return true;
    }

    public boolean insertSAMMStroke(int i, int i2, SObjectStroke sObjectStroke) {
        return m1995a(i, i2, sObjectStroke);
    }

    public boolean insertSAMMText(int i, int i2, SObjectText sObjectText) {
        return m1995a(i, i2, sObjectText);
    }

    public boolean insertSAMMImage(int i, int i2, SObjectImage sObjectImage) {
        return m1995a(i, i2, sObjectImage);
    }

    public boolean deleteSAMMObject(int i, int i2) {
        if (m2022b()) {
            return this.f2076Z.mo1787b(i, i2);
        }
        return false;
    }

    public boolean changeSAMMObject(int i, int i2, SObject sObject) {
        if (!m2022b()) {
            return false;
        }
        if (this.f2082aa.mo1855b(0) == null) {
            Log.e(TAG, "There is no visible object");
            return false;
        }
        SObject sObjectA = this.f2082aa.mo1851a(i, i2);
        if (sObjectA instanceof SObjectStroke) {
            Log.e(TAG, "Only image or text object can be changed");
            return false;
        }
        if ((!(sObjectA instanceof SObjectImage) || !(sObject instanceof SObjectImage)) && (!(sObjectA instanceof SObjectText) || !(sObject instanceof SObjectText))) {
            Log.e(TAG, "Type of object to change is different");
            return false;
        }
        if (!this.f2082aa.mo1853a(sObjectA, sObject)) {
            Log.e(TAG, "Fail to change sObject!");
            return false;
        }
        return this.f2076Z.mo1788b(i, i2, sObjectA);
    }

    public boolean drawMultiUserSAMMStrokePoint(int i, int i2, int i3, float f, float f2, float f3, int i4, long j, long j2) {
        if (m2022b()) {
            return this.f2076Z.mo1777a(i, i2, i3, f, f2, f3, i4, j, j2);
        }
        return false;
    }

    public boolean isSObjectSelected() {
        if (m2022b()) {
            return this.f2082aa.mo1893d();
        }
        return false;
    }

    public SObject getSelectedSObject() {
        if (!m2022b()) {
            return null;
        }
        return this.f2082aa.mo1888c(true);
    }

    public int getSelectedSObjectType() {
        if (m2022b()) {
            return this.f2082aa.mo1894e();
        }
        return 0;
    }

    public boolean deleteSelectedSObject() {
        boolean z;
        if (!m2022b()) {
            return false;
        }
        LinkedList<SObject> linkedListMo1891d = this.f2082aa.mo1891d(true);
        if (linkedListMo1891d == null || linkedListMo1891d.isEmpty()) {
            Log.e(TAG, "There is no selected object");
            return false;
        }
        Iterator<SObject> it = linkedListMo1891d.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = true;
                break;
            }
            if (!this.f2076Z.mo1794c(it.next())) {
                z = false;
                break;
            }
        }
        return z;
    }

    public boolean rotateSelectedSObject(float f) {
        boolean z;
        if (!m2022b()) {
            return false;
        }
        LinkedList<SObject> linkedListMo1891d = this.f2082aa.mo1891d(false);
        if (linkedListMo1891d == null) {
            Log.e(TAG, "There is no selected object");
            return false;
        }
        if (3 != this.f2082aa.mo1884b(linkedListMo1891d)) {
            Log.e(TAG, "Only image object can be rotated");
            return false;
        }
        if (linkedListMo1891d.size() > 1) {
            Log.e(TAG, "Rotation for Multiple Objects is not support");
            return false;
        }
        Iterator<SObject> it = linkedListMo1891d.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            SObject next = it.next();
            SObject sObjectCopyObject = next.copyObject();
            sObjectCopyObject.setRotateAngle(f);
            if (!this.f2082aa.mo1887b(next, sObjectCopyObject)) {
                Log.e(TAG, "Fail to change sObject!");
                z = true;
                break;
            }
            if (!this.f2076Z.mo1795d(next)) {
                z = true;
                break;
            }
        }
        return !z;
    }

    public boolean isClipboardSObjectListExist() {
        if (m2022b()) {
            return this.f2082aa.mo1896f();
        }
        return false;
    }

    public LinkedList<SObject> getClipboardSObjectList() {
        if (m2022b()) {
            return this.f2082aa.mo1897g();
        }
        return null;
    }

    public int getClipboardSObjectListType() {
        if (m2022b()) {
            return this.f2082aa.mo1898h();
        }
        return 0;
    }

    public boolean copySelectedSObjectList(boolean z) {
        if (m2022b()) {
            return this.f2082aa.mo1895e(z);
        }
        return false;
    }

    public boolean cutSelectedSObjectList(boolean z) {
        if (m2022b() && this.f2082aa.mo1895e(z)) {
            return deleteSelectedSObject();
        }
        return false;
    }

    public void clearClipboardSObjectList() {
        if (m2022b()) {
            this.f2082aa.mo1899i();
        }
    }

    public boolean pasteClipboardSObjectList(boolean z, int i, int i2) {
        if (!this.f2082aa.mo1896f()) {
            Log.e(TAG, "Clipboard is empty");
            return false;
        }
        LinkedList<SObject> linkedListMo1897g = this.f2082aa.mo1897g();
        if (linkedListMo1897g == null) {
            Log.e(TAG, "Clipboard is empty");
            return false;
        }
        Iterator<SObject> it = linkedListMo1897g.iterator();
        while (it.hasNext()) {
            SObject sObjectCopyObject = it.next().copyObject();
            if (i > 0 && i2 > 0) {
                m2017a(sObjectCopyObject, i, i2, this.f2087af, this.f2088ag);
                if (!m1996a(sObjectCopyObject, z)) {
                    return false;
                }
            } else if (!m1996a(sObjectCopyObject, z)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    boolean m2017a(SObject sObject, int i, int i2, int i3, int i4) {
        RectF rect = sObject.getRect();
        float f = rect.right - rect.left;
        float f2 = rect.bottom - rect.top;
        rect.left = i - (f / 2.0f);
        rect.right = rect.left + f;
        rect.top = i2 - (f2 / 2.0f);
        rect.bottom = rect.top + f2;
        if (i3 > 0) {
            if (rect.left < VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
                rect.left = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
                rect.right = rect.left + f;
            }
            if (rect.right >= i3) {
                rect.right = i3;
                rect.left = rect.right - f;
            }
        }
        if (i4 > 0) {
            if (rect.top < VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
                rect.top = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
                rect.bottom = rect.top + f2;
            }
            if (rect.bottom >= i4) {
                rect.bottom = i4;
                rect.top = rect.bottom - f2;
            }
        }
        sObject.setRect(rect);
        return true;
    }

    public HistoryData getHistoryUpdatedData() {
        return super.getHistoryData();
    }

    public boolean setHistoryUpdatedData(HistoryData historyData) {
        super.setHistoryData(historyData);
        return true;
    }

    /* renamed from: a */
    private static String m1992a(Context context) {
        String parent = context.getFilesDir().getParent();
        File file = new File(String.valueOf(parent) + "/Signature/");
        if (file.isDirectory() || file.mkdirs()) {
            return String.valueOf(parent) + "/Signature/";
        }
        return null;
    }

    public static boolean isSignatureExist(Context context) {
        String strM1992a = m1992a(context);
        C1100a c1100a = new C1100a();
        c1100a.m1981a(strM1992a, 1024, 3, 10, 200);
        return c1100a.m1984a(10);
    }

    public static boolean unregisterSignature(Context context) {
        String strM1992a = m1992a(context);
        C1100a c1100a = new C1100a();
        c1100a.m1981a(strM1992a, 1024, 3, 10, 200);
        return c1100a.m1987b(10);
    }

    public boolean openSignatureEngine() {
        if (!m2022b()) {
            return false;
        }
        String strM1992a = m1992a(this.f2072T);
        int i = this.f2087af < this.f2088ag ? this.f2087af : this.f2088ag;
        int i2 = i / 4 > 0 ? i / 4 : 200;
        this.f2102au = new C1100a();
        this.f2102au.m1981a(strM1992a, 1024, 3, 10, i2);
        this.f2085ad.onSetOnSignatureDataListener(this.f2102au);
        return true;
    }

    public boolean closeSignatureEngine() {
        if (!m2022b()) {
            return false;
        }
        if (this.f2102au == null) {
            Log.e(TAG, "Signature Engine is not Opened!");
            return false;
        }
        this.f2085ad.onSetOnSignatureDataListener(null);
        return true;
    }

    public int registerSignature() {
        if (!m2022b()) {
            return -1;
        }
        if (this.f2102au == null) {
            Log.e(TAG, "Signature Engine is not Opened!");
            return -1;
        }
        int iM1988c = this.f2102au.m1988c(10);
        this.f2076Z.mo1667a();
        return iM1988c;
    }

    public boolean isSignatureRegistrationCompleted() {
        if (!m2022b()) {
            return false;
        }
        if (this.f2102au == null) {
            Log.e(TAG, "Signature Engine is not Opened!");
            return false;
        }
        return this.f2102au.m1984a(10);
    }

    public boolean verifySignature(int i) {
        int i2 = 0;
        if (!m2022b()) {
            return false;
        }
        if (this.f2102au == null) {
            Log.e(TAG, "Signature Engine is not Opened!");
            return false;
        }
        switch (i) {
            case 0:
                break;
            case 1:
                i2 = 1;
                break;
            case 2:
                i2 = 2;
                break;
            default:
                return false;
        }
        boolean zM1985a = this.f2102au.m1985a(10, i2);
        this.f2076Z.mo1667a();
        return zM1985a;
    }

    public boolean clearSignatureScreen() {
        if (!m2022b()) {
            return false;
        }
        if (this.f2102au == null) {
            Log.e(TAG, "Signature Engine is not Opened!");
            return false;
        }
        boolean zM1983a = this.f2102au.m1983a();
        this.f2076Z.mo1667a();
        return zM1983a;
    }

    public void logSObjectInfo(SObject sObject) {
        if (m2022b()) {
            this.f2082aa.mo1892d(sObject);
        }
    }

    public void logSObjectListInfo(boolean z) {
        if (m2022b()) {
            this.f2082aa.mo1890c(this.f2082aa.mo1885b(z));
        }
    }

    public void setSCanvasInitializeListener(SCanvasInitializeListener sCanvasInitializeListener) {
        this.f2108e = sCanvasInitializeListener;
    }

    @Override // com.samsung.sdraw.CanvasView
    @Deprecated
    public void setOnInitializeFinishListener(CanvasView.OnInitializeFinishListener onInitializeFinishListener) {
        this.f2103av = onInitializeFinishListener;
    }

    public void setSCanvasMatrixChangeListener(SCanvasMatrixChangeListener sCanvasMatrixChangeListener) {
        this.f2110g = sCanvasMatrixChangeListener;
    }

    public void setSCanvasModeChangedListener(SCanvasModeChangedListener sCanvasModeChangedListener) {
        this.f2112i = sCanvasModeChangedListener;
    }

    public void setSCanvasDeleteAllConfirmListener(SCanvasDeleteAllConfirmListener sCanvasDeleteAllConfirmListener) {
        this.f2115l = sCanvasDeleteAllConfirmListener;
        this.f2114k = true;
    }

    public void setHistoryUpdateListener(HistoryUpdateListener historyUpdateListener) {
        this.f2117n = historyUpdateListener;
    }

    @Override // com.samsung.sdraw.CanvasView
    @Deprecated
    public void setOnHistoryChangeListener(CanvasView.OnHistoryChangeListener onHistoryChangeListener) {
        this.f2119p = onHistoryChangeListener;
    }

    public void setSCanvasLongPressListener(SCanvasLongPressListener sCanvasLongPressListener) {
        this.f2120q = sCanvasLongPressListener;
    }

    public void setSettingViewShowListener(SettingViewShowListener settingViewShowListener) {
        this.f2122s = settingViewShowListener;
    }

    @Override // com.samsung.sdraw.CanvasView
    @Deprecated
    public void setOnSettingViewShowListener(CanvasView.OnSettingViewShowListener onSettingViewShowListener) {
        this.f2124u = onSettingViewShowListener;
    }

    public void setSettingStrokeChangeListener(SettingStrokeChangeListener settingStrokeChangeListener) {
        this.f2125v = settingStrokeChangeListener;
    }

    public void setSettingTextChangeListener(SettingTextChangeListener settingTextChangeListener) {
        this.f2127x = settingTextChangeListener;
    }

    public void setSettingFillingChangeListener(SettingFillingChangeListener settingFillingChangeListener) {
        this.f2129z = settingFillingChangeListener;
    }

    public void setSettingPresetDeleteBtnClickListener(SettingPresetDeleteBtnClickListener settingPresetDeleteBtnClickListener) {
        this.f2054B = settingPresetDeleteBtnClickListener;
    }

    public void setColorPickerColorChangeListener(ColorPickerColorChangeListener colorPickerColorChangeListener) {
        this.f2056D = colorPickerColorChangeListener;
    }

    public void setFileProcessListener(FileProcessListener fileProcessListener) {
        this.f2058F = fileProcessListener;
    }

    @Deprecated
    public void setOnFileProcessingProgressListener(OnFileProcessingProgressListener onFileProcessingProgressListener) {
        this.f2105ax = onFileProcessingProgressListener;
    }

    public void setAnimationProcessListener(AnimationProcessListener animationProcessListener) {
        this.f2060H = animationProcessListener;
    }

    @Deprecated
    public void setOnPlayCompleteListener(OnPlayCompleteListener onPlayCompleteListener) {
        this.f2107az = onPlayCompleteListener;
    }

    @Deprecated
    public void setOnPlayProgressChangeListener(OnPlayProgressChangeListener onPlayProgressChangeListener) {
        this.f2106ay = onPlayProgressChangeListener;
    }

    public void setSObjectSelectListener(SObjectSelectListener sObjectSelectListener) {
        this.f2062J = sObjectSelectListener;
    }

    public void setSObjectUpdateListener(SObjectUpdateListener sObjectUpdateListener) {
        this.f2064L = sObjectUpdateListener;
    }

    @Override // com.samsung.sdraw.CanvasView
    @Deprecated
    public void setOnObjectListener(CanvasView.OnObjectListener onObjectListener) {
    }

    public void setSPenTouchListener(SPenTouchListener sPenTouchListener) {
        this.f2066N = sPenTouchListener;
        this.f2071S = null;
        if (m2022b() && this.f2074V != null) {
            this.f2074V.mo1941a(this.f2066N);
        }
    }

    public void setSPenHoverListener(SPenHoverListener sPenHoverListener) {
        if (!SPenEventLibrary.isHoverListenerSupport()) {
            Log.e(TAG, "S Pen Hover Listener cannot be supported under android ICS");
            return;
        }
        this.f2077aA = sPenHoverListener;
        if (m2022b()) {
            this.f2074V.mo1940a(this.f2077aA);
        }
    }

    public boolean setSPenDetachmentListener(SPenDetachmentListener sPenDetachmentListener) {
        if (sPenDetachmentListener == null) {
            return m2010e();
        }
        if (this.f2067O == null) {
            this.f2067O = new SPenDetachmentReceiver();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.samsung.pen.INSERT");
        this.f2072T.registerReceiver(this.f2067O, intentFilter);
        this.f2067O.m1991a(sPenDetachmentListener);
        return true;
    }

    /* renamed from: e */
    private boolean m2010e() {
        if (this.f2067O != null) {
            this.f2072T.unregisterReceiver(this.f2067O);
        }
        this.f2067O = null;
        return true;
    }

    public void setCustomSoundEffectSettingListener(CustomSoundEffectSettingListener customSoundEffectSettingListener) {
        this.f2068P = customSoundEffectSettingListener;
    }

    public void setSPenTouchIDListener(SPenTouchIDListener sPenTouchIDListener) {
        this.f2071S = sPenTouchIDListener;
        this.f2066N = null;
        if (this.f2071S != null) {
            this.f2069Q = new View.OnTouchListener() { // from class: com.samsung.spensdk.SCanvasView.20
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    SPenEvent event = SPenLibrary.getEvent(motionEvent);
                    if (event.isFinger()) {
                        if (motionEvent.getAction() == 0) {
                            SCanvasView.this.f2080aD = SCanvasView.this.f2078aB;
                            SCanvasView.this.f2078aB++;
                        }
                        SCanvasView.this.setMultiStrokeID(SCanvasView.this.f2080aD);
                        return SCanvasView.this.f2071S.onTouchFinger(view, motionEvent, SCanvasView.this.f2080aD);
                    }
                    if (event.isPen()) {
                        if (motionEvent.getAction() == 0) {
                            SCanvasView.this.f2079aC = SCanvasView.this.f2078aB;
                            SCanvasView.this.f2078aB++;
                        }
                        SCanvasView.this.setMultiStrokeID(SCanvasView.this.f2079aC);
                        return SCanvasView.this.f2071S.onTouchPen(view, motionEvent, SCanvasView.this.f2079aC);
                    }
                    if (event.isEraserPen()) {
                        if (motionEvent.getAction() == 0) {
                            SCanvasView.this.f2081aE = SCanvasView.this.f2078aB;
                            SCanvasView.this.f2078aB++;
                        }
                        SCanvasView.this.setMultiStrokeID(SCanvasView.this.f2081aE);
                        return SCanvasView.this.f2071S.onTouchPenEraser(view, motionEvent, SCanvasView.this.f2081aE);
                    }
                    return false;
                }
            };
        } else {
            this.f2069Q = null;
        }
        if (this.f2074V != null) {
            this.f2074V.mo1937a(this.f2069Q);
        }
    }

    @Override // com.samsung.sdraw.CanvasView
    @Deprecated
    public void changeModeTo(int i) {
        super.changeModeTo(i);
    }

    @Override // com.samsung.sdraw.CanvasView
    @Deprecated
    public boolean deleteSelectedObject() {
        return super.deleteSelectedObject();
    }

    @Override // com.samsung.sdraw.CanvasView
    @Deprecated
    public void drawStrokePoint(int i, float f, float f2, float f3, int i2, long j, long j2) {
        super.drawStrokePoint(i, f, f2, f3, i2, j, j2);
    }

    @Override // com.samsung.sdraw.CanvasView
    @Deprecated
    public int getMode() {
        return super.getMode();
    }

    @Override // com.samsung.sdraw.CanvasView
    @Deprecated
    public LinkedList<ObjectInfo> getObjectInfos() {
        return super.getObjectInfos();
    }

    @Override // com.samsung.sdraw.CanvasView
    @Deprecated
    public PenSettingInfo getPenSettingInfo() {
        return super.getPenSettingInfo();
    }

    @Override // com.samsung.sdraw.CanvasView
    @Deprecated
    public CanvasView.ObjectType getSelectedObjectType() {
        return super.getSelectedObjectType();
    }

    @Override // com.samsung.sdraw.CanvasView
    @Deprecated
    public LinkedList<StrokeInfo> getStrokeInfos() {
        return super.getStrokeInfos();
    }

    @Override // com.samsung.sdraw.CanvasView
    @Deprecated
    public LinkedList<TextInfo> getTextInfos() {
        return super.getTextInfos();
    }

    @Override // com.samsung.sdraw.CanvasView
    @Deprecated
    public TextSettingInfo getTextSettingInfo() {
        return super.getTextSettingInfo();
    }

    @Override // com.samsung.sdraw.CanvasView
    @Deprecated
    public ObjectInfo selectObject(int i, int i2) {
        return super.selectObject(i, i2);
    }

    @Override // com.samsung.sdraw.CanvasView
    @Deprecated
    public void setPenSettingInfo(PenSettingInfo penSettingInfo) {
        super.setPenSettingInfo(penSettingInfo);
    }

    @Override // com.samsung.sdraw.CanvasView
    @Deprecated
    public void setTextSettingInfo(TextSettingInfo textSettingInfo) {
        super.setTextSettingInfo(textSettingInfo);
    }
}
