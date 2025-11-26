package com.samsung.sdraw;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.StatFs;
import android.text.DynamicLayout;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.AlignmentSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.ContextMenu;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.coolots.p2pmsg.model.SimpleUserInfo;
import com.samsung.sdraw.AbstractSettingView;
import com.samsung.sdraw.C0988aa;
import com.samsung.sdraw.FillingSettingInfo;
import com.samsung.sdraw.PenSettingInfo;
import com.samsung.sdraw.SelectMode;
import com.samsung.sdraw.Stage;
import com.samsung.sdraw.StrokeSprite;
import com.samsung.sdraw.TextMode;
import com.samsung.sdraw.TextSettingInfo;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Vector;

/* loaded from: classes.dex */
public class CanvasView extends View implements InterfaceC1035bu {
    public static final int ERASER_MODE = 2;
    public static final int FILLING_MODE = 5;
    public static final int LAYER1 = 0;
    public static final int LAYER2 = 1;
    public static final int METASTATE_ERASER = 2;
    public static final int METASTATE_HAND = 0;
    public static final int METASTATE_MAX = 3;
    public static final int METASTATE_PEN = 1;
    public static final int PEN_MODE = 1;
    public static final int SELECT_MODE = 3;
    public static final int TEXT_MODE = 4;

    /* renamed from: bV */
    private static /* synthetic */ int[] f854bV;

    /* renamed from: y */
    private static final int f855y = ViewConfiguration.getLongPressTimeout();

    /* renamed from: z */
    private static final int f856z = ViewConfiguration.getTapTimeout();

    /* renamed from: A */
    private boolean f857A;

    /* renamed from: B */
    private HandlerC0969a f858B;

    /* renamed from: C */
    private int f859C;

    /* renamed from: D */
    private int f860D;

    /* renamed from: E */
    private Rect f861E;

    /* renamed from: F */
    private Rect f862F;

    /* renamed from: G */
    private boolean f863G;

    /* renamed from: H */
    private Context f864H;

    /* renamed from: I */
    private ImageButton f865I;

    /* renamed from: J */
    private int f866J;

    /* renamed from: K */
    private int f867K;

    /* renamed from: L */
    private int f868L;

    /* renamed from: M */
    private int f869M;

    /* renamed from: N */
    private ImageButton f870N;

    /* renamed from: O */
    private int f871O;

    /* renamed from: P */
    private int f872P;

    /* renamed from: Q */
    private int f873Q;

    /* renamed from: R */
    private Drawable f874R;

    /* renamed from: S */
    private Drawable f875S;

    /* renamed from: T */
    private boolean f876T;

    /* renamed from: U */
    private boolean f877U;

    /* renamed from: V */
    private C0997aj f878V;

    /* renamed from: W */
    private boolean f879W;

    /* renamed from: Z */
    private float f880Z;

    /* renamed from: a */
    PenSettingInfo f881a;

    /* renamed from: aA */
    private C0988aa f882aA;

    /* renamed from: aB */
    private C0988aa.b f883aB;

    /* renamed from: aC */
    private PenSettingInfo.InterfaceC0976a f884aC;

    /* renamed from: aD */
    private FillingSettingInfo.InterfaceC0973a f885aD;

    /* renamed from: aE */
    private TextSettingInfo.InterfaceC0985a f886aE;

    /* renamed from: aF */
    private boolean f887aF;

    /* renamed from: aG */
    private int f888aG;

    /* renamed from: aH */
    private int f889aH;

    /* renamed from: aI */
    private float f890aI;

    /* renamed from: aJ */
    private float f891aJ;

    /* renamed from: aK */
    private float f892aK;

    /* renamed from: aL */
    private float f893aL;

    /* renamed from: aM */
    private boolean f894aM;

    /* renamed from: aN */
    private boolean f895aN;

    /* renamed from: aO */
    private boolean f896aO;

    /* renamed from: aP */
    private View.OnTouchListener f897aP;

    /* renamed from: aQ */
    private View.OnFocusChangeListener f898aQ;

    /* renamed from: aR */
    private int f899aR;

    /* renamed from: aS */
    private TextWatcher f900aS;

    /* renamed from: aT */
    private ContextMenu f901aT;

    /* renamed from: aU */
    private C0971c f902aU;

    /* renamed from: aV */
    private GestureDetector f903aV;

    /* renamed from: aW */
    private View.OnLongClickListener f904aW;

    /* renamed from: aX */
    private View.OnTouchListener f905aX;

    /* renamed from: aY */
    private View.OnTouchListener f906aY;

    /* renamed from: aZ */
    private TextMode.OnTextSelectedListener f907aZ;

    /* renamed from: aa */
    private Object[] f908aa;

    /* renamed from: ab */
    private int f909ab;

    /* renamed from: ac */
    private Layout.Alignment f910ac;

    /* renamed from: ad */
    private Editable f911ad;

    /* renamed from: ae */
    private boolean f912ae;

    /* renamed from: af */
    private RectF f913af;

    /* renamed from: ag */
    private EnumC0970b f914ag;

    /* renamed from: ah */
    private boolean f915ah;

    /* renamed from: ai */
    private EditText f916ai;

    /* renamed from: aj */
    private boolean f917aj;

    /* renamed from: ak */
    private TextMode f918ak;

    /* renamed from: al */
    private SelectMode f919al;

    /* renamed from: am */
    private String f920am;

    /* renamed from: an */
    private DisplayMetrics f921an;

    /* renamed from: ao */
    private String f922ao;

    /* renamed from: ap */
    private int f923ap;

    /* renamed from: aq */
    private int f924aq;

    /* renamed from: ar */
    private boolean f925ar;

    /* renamed from: as */
    private int f926as;

    /* renamed from: at */
    private boolean f927at;

    /* renamed from: au */
    private boolean f928au;

    /* renamed from: av */
    private int f929av;

    /* renamed from: aw */
    private boolean f930aw;

    /* renamed from: ax */
    private boolean f931ax;

    /* renamed from: ay */
    private boolean f932ay;

    /* renamed from: az */
    private boolean f933az;

    /* renamed from: b */
    LinkedList<ObjectInfo> f934b;

    /* renamed from: bA */
    private OnLongPressListener f935bA;

    /* renamed from: bB */
    private InterfaceC0972d f936bB;

    /* renamed from: bC */
    private boolean f937bC;

    /* renamed from: bD */
    private final boolean f938bD;

    /* renamed from: bE */
    private boolean f939bE;

    /* renamed from: bF */
    private boolean f940bF;

    /* renamed from: bG */
    private float f941bG;

    /* renamed from: bH */
    private boolean f942bH;

    /* renamed from: bI */
    private int f943bI;

    /* renamed from: bJ */
    private PenData f944bJ;

    /* renamed from: bK */
    private PenData f945bK;

    /* renamed from: bL */
    private boolean f946bL;

    /* renamed from: bM */
    private OnModeChangedListener f947bM;

    /* renamed from: bN */
    private boolean f948bN;

    /* renamed from: bO */
    private int f949bO;

    /* renamed from: bP */
    private int f950bP;

    /* renamed from: bQ */
    private boolean f951bQ;

    /* renamed from: bR */
    private boolean f952bR;

    /* renamed from: bS */
    private boolean f953bS;

    /* renamed from: bT */
    private boolean f954bT;

    /* renamed from: bU */
    private boolean f955bU;

    /* renamed from: ba */
    private SelectMode.OnImageSelectedListener f956ba;

    /* renamed from: bb */
    private OnSelectChangeListener f957bb;

    /* renamed from: bc */
    private OnCanvasMatrixChangeListener f958bc;

    /* renamed from: bd */
    private boolean f959bd;

    /* renamed from: be */
    private boolean f960be;

    /* renamed from: bf */
    private int f961bf;

    /* renamed from: bg */
    private int f962bg;

    /* renamed from: bh */
    private InitializeFinishListener f963bh;

    /* renamed from: bi */
    private boolean f964bi;

    /* renamed from: bj */
    private Handler f965bj;

    /* renamed from: bk */
    private Stage.OnSpriteChangeListener f966bk;

    /* renamed from: bl */
    private OnInitializeFinishListener f967bl;

    /* renamed from: bm */
    private OnObjectListener f968bm;

    /* renamed from: bn */
    private OnSettingViewShowListener f969bn;

    /* renamed from: bo */
    private boolean f970bo;

    /* renamed from: bp */
    private boolean f971bp;

    /* renamed from: bq */
    private boolean f972bq;

    /* renamed from: br */
    private boolean f973br;

    /* renamed from: bs */
    private OnDropperColorChangeListener f974bs;

    /* renamed from: bt */
    private boolean f975bt;

    /* renamed from: bu */
    private boolean f976bu;

    /* renamed from: bv */
    private boolean f977bv;

    /* renamed from: bw */
    private View.OnTouchListener f978bw;

    /* renamed from: bx */
    private View.OnHoverListener f979bx;

    /* renamed from: by */
    private OutOfMemoryListener f980by;

    /* renamed from: bz */
    private OnCancelListener f981bz;

    /* renamed from: c */
    PenSettingInfo f982c;

    /* renamed from: d */
    SpannableStringBuilder f983d;

    /* renamed from: e */
    String f984e;

    /* renamed from: f */
    boolean f985f;

    /* renamed from: g */
    HashMap<Integer, Integer> f986g;

    /* renamed from: h */
    boolean f987h;

    /* renamed from: i */
    boolean f988i;

    /* renamed from: j */
    AbstractSettingView.InterfaceC0948a f989j;

    /* renamed from: k */
    boolean f990k;

    /* renamed from: l */
    private ModeContext f991l;

    /* renamed from: m */
    private Rect f992m;

    /* renamed from: n */
    private TextSettingInfo f993n;

    /* renamed from: o */
    private FillingSettingInfo f994o;

    /* renamed from: p */
    private int f995p;

    /* renamed from: q */
    private TextSettingInfo f996q;

    /* renamed from: r */
    private boolean f997r;

    /* renamed from: s */
    private boolean f998s;

    /* renamed from: t */
    private boolean f999t;

    /* renamed from: u */
    private int f1000u;

    /* renamed from: v */
    private SettingView f1001v;

    /* renamed from: w */
    private boolean f1002w;

    /* renamed from: x */
    private int f1003x;

    public interface InitializeFinishListener {
        void onFinish();
    }

    public enum ObjectType {
        None,
        Stroke,
        Image,
        Text;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static ObjectType[] valuesCustom() {
            ObjectType[] objectTypeArrValuesCustom = values();
            int length = objectTypeArrValuesCustom.length;
            ObjectType[] objectTypeArr = new ObjectType[length];
            System.arraycopy(objectTypeArrValuesCustom, 0, objectTypeArr, 0, length);
            return objectTypeArr;
        }
    }

    public interface OnCancelListener {
        void onCancel(int i);
    }

    public interface OnCanvasMatrixChangeListener {
        void onMatrixChangeEnd();

        void onMatrixChanged(Matrix matrix);
    }

    public interface OnDrawingInformationListener {
        void onDrawingPen(View view, MotionEvent motionEvent);
    }

    public interface OnDropperColorChangeListener {
        void onDropperColorChanged(int i);
    }

    public interface OnHistoryChangeListener {
        void onHistoryChanged(boolean z, boolean z2);
    }

    public interface OnInitializeFinishListener {
        void onFinish();
    }

    public interface OnLongPressListener {
        void onLongPress();

        void onLongPress(float f, float f2);
    }

    public interface OnModeChangedListener {
        void onModeChanged(int i);
    }

    public interface OnObjectListener {
        void onObjectChanged(ObjectInfo objectInfo, boolean z, boolean z2);

        void onObjectDeleted(ObjectInfo objectInfo, boolean z, boolean z2, boolean z3);

        void onObjectDeletedAll(boolean z, int i);

        void onObjectInserted(ObjectInfo objectInfo, boolean z, boolean z2);

        void onObjectSelected(ObjectInfo objectInfo, boolean z);

        boolean onStrokeInserting(StrokeInfo strokeInfo);
    }

    public interface OnSelectChangeListener {
        void onSelectChanged();
    }

    public interface OnSettingViewShowListener {
        void onEraserSettingViewShow(boolean z);

        void onFillingSettingViewShow(boolean z);

        void onPenSettingViewShow(boolean z);

        void onTextSettingViewShow(boolean z);
    }

    public interface OutOfMemoryListener {
        void onOutOfMemory();
    }

    /* renamed from: com.samsung.sdraw.CanvasView$b */
    private enum EnumC0970b {
        NONE,
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        TOP_LEFT,
        TOP_RIGHT,
        BOTTOM_LEFT,
        BOTTOM_RIGHT,
        CENTER;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static EnumC0970b[] valuesCustom() {
            EnumC0970b[] enumC0970bArrValuesCustom = values();
            int length = enumC0970bArrValuesCustom.length;
            EnumC0970b[] enumC0970bArr = new EnumC0970b[length];
            System.arraycopy(enumC0970bArrValuesCustom, 0, enumC0970bArr, 0, length);
            return enumC0970bArr;
        }
    }

    /* renamed from: com.samsung.sdraw.CanvasView$d */
    interface InterfaceC0972d {
        /* renamed from: a */
        void m993a(boolean z);
    }

    /* renamed from: d */
    static /* synthetic */ int[] m922d() {
        int[] iArr = f854bV;
        if (iArr == null) {
            iArr = new int[Layout.Alignment.values().length];
            try {
                iArr[Layout.Alignment.ALIGN_CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[Layout.Alignment.ALIGN_LEFT.ordinal()] = 4;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[Layout.Alignment.ALIGN_NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[Layout.Alignment.ALIGN_OPPOSITE.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[Layout.Alignment.ALIGN_RIGHT.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            f854bV = iArr;
        }
        return iArr;
    }

    public CanvasView(Context context) throws IOException {
        super(context);
        this.f995p = -1;
        this.f997r = false;
        this.f1002w = false;
        this.f1003x = 1;
        this.f857A = false;
        this.f861E = new Rect();
        this.f862F = new Rect();
        this.f863G = false;
        this.f876T = false;
        this.f877U = false;
        this.f879W = false;
        this.f908aa = new Object[7];
        this.f909ab = 0;
        this.f910ac = Layout.Alignment.ALIGN_NORMAL;
        this.f913af = new RectF(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, 800.0f, 480.0f);
        this.f915ah = false;
        this.f917aj = false;
        this.f984e = "";
        this.f920am = "/system/fonts/";
        this.f921an = getContext().getResources().getDisplayMetrics();
        this.f922ao = "Delete";
        this.f985f = false;
        this.f926as = 10;
        this.f927at = false;
        this.f928au = false;
        this.f929av = 0;
        this.f930aw = true;
        this.f931ax = false;
        this.f932ay = false;
        this.f933az = false;
        this.f883aB = new C0988aa.b() { // from class: com.samsung.sdraw.CanvasView.1
            @Override // com.samsung.sdraw.C0988aa.b
            /* renamed from: a */
            public void mo980a(Matrix matrix) {
                CanvasView.this.f991l.m674a(matrix);
                if (CanvasView.this.f958bc != null) {
                    CanvasView.this.f958bc.onMatrixChanged(matrix);
                }
                mo979a();
            }

            @Override // com.samsung.sdraw.C0988aa.b
            /* renamed from: a */
            public void mo979a() {
                CanvasView.this.invalidate();
            }
        };
        this.f884aC = new PenSettingInfo.InterfaceC0976a() { // from class: com.samsung.sdraw.CanvasView.12
            @Override // com.samsung.sdraw.PenSettingInfo.InterfaceC0976a
            /* renamed from: a */
            public void mo982a(int i, int i2) {
                if (CanvasView.this.f991l != null && CanvasView.this.f991l.setting != null && CanvasView.this.f881a != null) {
                    CanvasView.this.f991l.setting.setStrokeWidth(CanvasView.this.f881a.getPenWidth());
                }
                if (CanvasView.this.f991l != null) {
                    CanvasView.this.f991l.invalidate();
                }
            }

            @Override // com.samsung.sdraw.PenSettingInfo.InterfaceC0976a
            /* renamed from: a */
            public void mo981a(int i) {
                CanvasView.this.m871a(i);
                if (CanvasView.this.f991l != null) {
                    CanvasView.this.f991l.invalidate();
                }
            }

            @Override // com.samsung.sdraw.PenSettingInfo.InterfaceC0976a
            /* renamed from: b */
            public void mo984b(int i, int i2) {
                if (CanvasView.this.f991l != null && CanvasView.this.f991l.setting != null && CanvasView.this.f881a != null) {
                    CanvasView.this.f991l.setting.setStrokeColor(CanvasView.this.f881a.getPenAlphaColor());
                }
                if (CanvasView.this.f991l != null) {
                    CanvasView.this.f991l.invalidate();
                }
            }

            @Override // com.samsung.sdraw.PenSettingInfo.InterfaceC0976a
            /* renamed from: c */
            public void mo985c(int i, int i2) {
                if (CanvasView.this.f991l != null && CanvasView.this.f991l.setting != null && CanvasView.this.f881a != null) {
                    CanvasView.this.f991l.setting.setStrokeColor(CanvasView.this.f881a.getPenAlphaColor());
                }
                if (CanvasView.this.f991l != null) {
                    CanvasView.this.f991l.invalidate();
                }
            }

            @Override // com.samsung.sdraw.PenSettingInfo.InterfaceC0976a
            /* renamed from: b */
            public void mo983b(int i) {
                if (CanvasView.this.f991l != null && CanvasView.this.f991l.setting != null && CanvasView.this.f881a != null && CanvasView.this.getMode() == 2) {
                    CanvasView.this.f991l.setting.setEraserWidth(CanvasView.this.f881a.getEraserWidth());
                }
                if (CanvasView.this.f991l != null) {
                    CanvasView.this.f991l.invalidate();
                }
            }
        };
        this.f885aD = new FillingSettingInfo.InterfaceC0973a() { // from class: com.samsung.sdraw.CanvasView.14
            @Override // com.samsung.sdraw.FillingSettingInfo.InterfaceC0973a
            /* renamed from: a */
            public void mo986a(int i) {
                if (CanvasView.this.f991l != null && CanvasView.this.f991l.setting != null && CanvasView.this.f994o != null) {
                    CanvasView.this.f991l.setting.setFillingColor(CanvasView.this.f994o.getFillingColor());
                }
                if (CanvasView.this.f991l != null) {
                    CanvasView.this.f991l.invalidate();
                }
            }
        };
        this.f886aE = new TextSettingInfo.InterfaceC0985a() { // from class: com.samsung.sdraw.CanvasView.15
            @Override // com.samsung.sdraw.TextSettingInfo.InterfaceC0985a
            /* renamed from: a */
            public void mo987a(int i) {
                if (CanvasView.this.f991l != null && CanvasView.this.f991l.setting != null && CanvasView.this.f993n != null && CanvasView.this.f916ai != null) {
                    CanvasView.this.f991l.setting.setTextType(CanvasView.this.f993n.getTextType());
                    CanvasView.this.f909ab = CanvasView.this.f993n.getTextType();
                    CanvasView.this.m873a(CanvasView.this.f993n.getTextType(), true);
                }
            }

            @Override // com.samsung.sdraw.TextSettingInfo.InterfaceC0985a
            /* renamed from: b */
            public void mo990b(int i) {
                if (CanvasView.this.f991l != null && CanvasView.this.f991l.setting != null && CanvasView.this.f993n != null) {
                    CanvasView.this.f991l.setting.setTextColor(CanvasView.this.f993n.getTextColor());
                    if (!CanvasView.this.f933az) {
                        CanvasView.this.m949k();
                        CanvasView.this.f933az = true;
                    }
                    if (CanvasView.this.isShowTextBox()) {
                        CanvasView.this.f983d = (SpannableStringBuilder) CanvasView.this.f916ai.getText();
                        int selectionStart = CanvasView.this.f916ai.getSelectionStart();
                        int selectionEnd = CanvasView.this.f916ai.getSelectionEnd();
                        CanvasView.this.f916ai.setText(CanvasView.this.f983d);
                        CanvasView.this.f916ai.setSelection(selectionStart, selectionEnd);
                    }
                }
            }

            @Override // com.samsung.sdraw.TextSettingInfo.InterfaceC0985a
            /* renamed from: c */
            public void mo991c(int i) {
                if (CanvasView.this.f991l != null && CanvasView.this.f991l.setting != null && CanvasView.this.f993n != null) {
                    CanvasView.this.f991l.setting.setMaxTextSize(CanvasView.this.getMaxTextSize());
                    CanvasView.this.f991l.setting.setTextSize(CanvasView.this.f993n.getTextSize());
                    if (!CanvasView.this.f933az) {
                        CanvasView.this.m949k();
                        CanvasView.this.f933az = true;
                    }
                    if (CanvasView.this.isShowTextBox()) {
                        CanvasView.this.f983d = (SpannableStringBuilder) CanvasView.this.f916ai.getText();
                        int selectionStart = CanvasView.this.f916ai.getSelectionStart();
                        int selectionEnd = CanvasView.this.f916ai.getSelectionEnd();
                        CanvasView.this.f916ai.setText(CanvasView.this.f983d);
                        CanvasView.this.f916ai.setSelection(selectionStart, selectionEnd);
                    }
                }
            }

            @Override // com.samsung.sdraw.TextSettingInfo.InterfaceC0985a
            /* renamed from: a */
            public void mo989a(String str) {
                if (CanvasView.this.f991l != null && CanvasView.this.f991l.setting != null && CanvasView.this.f993n != null) {
                    CanvasView.this.f991l.setting.setTextFont(CanvasView.this.f993n.getTextFont());
                    if (!CanvasView.this.f933az) {
                        CanvasView.this.m949k();
                        CanvasView.this.f933az = true;
                    }
                    if (CanvasView.this.isShowTextBox()) {
                        if (!C1040bz.f1671a.containsKey(CanvasView.this.f993n.getTextFont())) {
                            try {
                                CanvasView.this.f916ai.setTypeface(Typeface.createFromFile(C1040bz.f1672b.get(CanvasView.this.f993n.getTextFont())));
                            } catch (Exception e) {
                                CanvasView.this.f916ai.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
                            }
                            C0993af.m1275a("DIOTEK/DRAW", String.format("createTextBox(RectF,Editable,TextInfo) => %s : not cached", String.valueOf(CanvasView.this.f920am) + CanvasView.this.f993n.getTextFont()));
                        } else {
                            CanvasView.this.f916ai.setTypeface(C1040bz.f1671a.get(CanvasView.this.f993n.getTextFont()));
                        }
                        C1040bz c1040bz = new C1040bz(CanvasView.this.f864H, CanvasView.this.f993n.getTextFont());
                        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(CanvasView.this.f916ai.getText().toString());
                        CanvasView.this.m906b(CanvasView.this.f993n.getTextSize());
                        spannableStringBuilder.setSpan(c1040bz, 0, spannableStringBuilder.length(), 18);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(CanvasView.this.f993n.getTextColor()), 0, spannableStringBuilder.length(), 18);
                        spannableStringBuilder.setSpan(CanvasView.this.f908aa[5], 0, spannableStringBuilder.length(), 18);
                        CanvasView.this.setTextAlignment(CanvasView.this.f993n.getTextAlignment());
                        int selectionStart = CanvasView.this.f916ai.getSelectionStart();
                        int selectionEnd = CanvasView.this.f916ai.getSelectionEnd();
                        CanvasView.this.m873a(CanvasView.this.f909ab, true);
                        if ((CanvasView.this.getTextAttribute() & 1) == 1) {
                            spannableStringBuilder.setSpan(CanvasView.this.f908aa[1], 0, spannableStringBuilder.length(), 18);
                        }
                        if ((CanvasView.this.getTextAttribute() & 2) == 2) {
                            spannableStringBuilder.setSpan(CanvasView.this.f908aa[2], 0, spannableStringBuilder.length(), 18);
                        }
                        if ((CanvasView.this.getTextAttribute() & 4) == 4) {
                            spannableStringBuilder.setSpan(CanvasView.this.f908aa[3], 0, spannableStringBuilder.length(), 18);
                        }
                        if ((CanvasView.this.getTextAttribute() & 8) == 8) {
                            spannableStringBuilder.setSpan(CanvasView.this.f908aa[4], 0, spannableStringBuilder.length(), 18);
                        }
                        CanvasView.this.f916ai.setText(spannableStringBuilder);
                        CanvasView.this.f916ai.setSelection(selectionStart, selectionEnd);
                    }
                }
            }

            @Override // com.samsung.sdraw.TextSettingInfo.InterfaceC0985a
            /* renamed from: a */
            public void mo988a(Layout.Alignment alignment) {
                if (CanvasView.this.f991l != null && CanvasView.this.f991l.setting != null && CanvasView.this.f993n != null) {
                    CanvasView.this.f991l.setting.setTextAlignment(CanvasView.this.f993n.getTextAlignment());
                    CanvasView.this.setTextAlignment(CanvasView.this.f993n.getTextAlignment());
                }
            }
        };
        this.f986g = new HashMap<>();
        this.f887aF = true;
        this.f894aM = false;
        this.f895aN = false;
        this.f896aO = false;
        this.f897aP = new View.OnTouchListener() { // from class: com.samsung.sdraw.CanvasView.16
            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                int i;
                int i2;
                if (!CanvasView.this.f894aM && CanvasView.this.f978bw != null) {
                    CanvasView.this.f978bw.onTouch(v, event);
                }
                CanvasView.this.f896aO = CanvasView.this.f903aV.onTouchEvent(event);
                if (CanvasView.this.f896aO) {
                    return true;
                }
                switch (event.getAction()) {
                    case 0:
                        boolean z = false;
                        boolean z2 = false;
                        boolean z3 = false;
                        boolean z4 = false;
                        int height = v.getHeight() - v.getPaddingTop();
                        int width = v.getWidth() - v.getPaddingLeft();
                        CanvasView.this.f888aG = (int) event.getRawX();
                        CanvasView.this.f889aH = (int) event.getRawY();
                        CanvasView.this.f890aI = event.getRawX() - CanvasView.this.f888aG;
                        CanvasView.this.f891aJ = event.getRawY() - CanvasView.this.f889aH;
                        if (v.getPaddingTop() + 5 > event.getY()) {
                            z3 = true;
                        }
                        if (v.getPaddingLeft() + 5 > event.getX()) {
                            z = true;
                        }
                        if (height - 5 < event.getY() + 5.0f) {
                            z4 = true;
                        }
                        if (width - 5 < event.getX() + 5.0f) {
                            z2 = true;
                        }
                        CanvasView.this.f916ai.setVisibility(0);
                        CanvasView.this.f914ag = EnumC0970b.NONE;
                        CanvasView.this.f895aN = true;
                        if (z) {
                            if (z3) {
                                CanvasView.this.f914ag = EnumC0970b.TOP_LEFT;
                            } else if (z4) {
                                CanvasView.this.f914ag = EnumC0970b.BOTTOM_LEFT;
                            } else {
                                CanvasView.this.f914ag = EnumC0970b.LEFT;
                            }
                        } else if (z2) {
                            if (z3) {
                                CanvasView.this.f914ag = EnumC0970b.TOP_RIGHT;
                            } else if (z4) {
                                CanvasView.this.f914ag = EnumC0970b.BOTTOM_RIGHT;
                            } else {
                                CanvasView.this.f914ag = EnumC0970b.RIGHT;
                            }
                        } else if (z3) {
                            CanvasView.this.f914ag = EnumC0970b.TOP;
                        } else if (z4) {
                            CanvasView.this.f914ag = EnumC0970b.BOTTOM;
                        } else {
                            CanvasView.this.f895aN = false;
                            if (CanvasView.this.f940bF && !CanvasView.this.f916ai.isFocusableInTouchMode()) {
                                CanvasView.this.f914ag = EnumC0970b.CENTER;
                            }
                        }
                        if (CanvasView.this.f914ag != EnumC0970b.NONE) {
                            v.cancelLongPress();
                            return true;
                        }
                        return false;
                    case 1:
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) CanvasView.this.f916ai.getLayoutParams();
                        PointF pointFMapToScene = CanvasView.this.f991l.stage.mapToScene(new PointF(layoutParams.leftMargin, layoutParams.topMargin));
                        Rect rect = new Rect(layoutParams.leftMargin, layoutParams.topMargin, layoutParams.width, layoutParams.height);
                        if (CanvasView.this.m888a(rect, true)) {
                            layoutParams.width = rect.right;
                            layoutParams.height = rect.bottom;
                        }
                        if (pointFMapToScene.x < VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
                            layoutParams.width += layoutParams.leftMargin;
                            layoutParams.leftMargin = 0;
                        }
                        if (pointFMapToScene.y < VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
                            layoutParams.height += layoutParams.topMargin;
                            layoutParams.topMargin = 0;
                        }
                        if (pointFMapToScene.x + layoutParams.width > CanvasView.this.f992m.right) {
                            layoutParams.width = CanvasView.this.f992m.right - layoutParams.leftMargin;
                        }
                        if (pointFMapToScene.y + layoutParams.height > CanvasView.this.f992m.bottom) {
                            layoutParams.height = CanvasView.this.f992m.bottom - layoutParams.topMargin;
                        }
                        CanvasView.this.f916ai.setLayoutParams(layoutParams);
                        if (!CanvasView.this.f940bF) {
                            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) CanvasView.this.f865I.getLayoutParams();
                            layoutParams2.leftMargin = layoutParams.leftMargin - CanvasView.this.f866J;
                            layoutParams2.topMargin = (layoutParams.topMargin - CanvasView.this.f867K) + 10;
                            layoutParams2.width = -2;
                            layoutParams2.height = -2;
                            if (layoutParams2.leftMargin < 0) {
                                layoutParams2.leftMargin = (layoutParams.leftMargin + layoutParams.width) - 30;
                            }
                            if (layoutParams2.topMargin < 0) {
                                layoutParams2.topMargin = (layoutParams.topMargin + layoutParams.height) - 20;
                            }
                            if (layoutParams2.leftMargin < CanvasView.this.f992m.left) {
                                layoutParams2.leftMargin = CanvasView.this.f992m.left;
                            }
                            if (layoutParams2.leftMargin + layoutParams2.width > CanvasView.this.f992m.right) {
                                layoutParams2.leftMargin = CanvasView.this.f992m.right - CanvasView.this.f866J;
                            }
                            if (layoutParams2.topMargin < CanvasView.this.f992m.top) {
                                layoutParams2.topMargin = CanvasView.this.f992m.top;
                            }
                            if (layoutParams2.topMargin + layoutParams2.height > CanvasView.this.getBottom()) {
                                layoutParams2.topMargin = CanvasView.this.f992m.bottom - CanvasView.this.f867K;
                            }
                            try {
                                CanvasView.this.f865I.setLayoutParams(layoutParams2);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) CanvasView.this.f870N.getLayoutParams();
                        layoutParams3.leftMargin = (int) ((layoutParams.leftMargin + ((layoutParams.width * CanvasView.this.getScale()) / 2.0f)) - (CanvasView.this.f871O / 2.0f));
                        layoutParams3.topMargin = (int) (((layoutParams.topMargin + ((CanvasView.this.f916ai.getPaddingTop() / 2.0f) * CanvasView.this.getScale())) - CanvasView.this.f872P) - CanvasView.this.f873Q);
                        layoutParams3.width = CanvasView.this.f871O;
                        layoutParams3.height = CanvasView.this.f872P;
                        if (layoutParams3.topMargin >= 0 && layoutParams3.topMargin >= CanvasView.this.getTop()) {
                            CanvasView.this.f870N.setBackgroundDrawable(CanvasView.this.f874R);
                            CanvasView.this.f870N.setPadding(0, -10, 0, 0);
                        } else {
                            layoutParams3.topMargin = (int) (((layoutParams.topMargin + (layoutParams.height * CanvasView.this.getScale())) - ((CanvasView.this.f916ai.getPaddingBottom() / 2.0f) * CanvasView.this.getScale())) + CanvasView.this.f873Q);
                            CanvasView.this.f870N.setBackgroundDrawable(CanvasView.this.f875S);
                            CanvasView.this.f870N.setPadding(0, 10, 0, 0);
                        }
                        if (layoutParams3.topMargin + layoutParams3.height > CanvasView.this.getBottom()) {
                            layoutParams3.topMargin = (int) (((((layoutParams.height * CanvasView.this.getScale()) + layoutParams.topMargin) - (CanvasView.this.f916ai.getPaddingBottom() * CanvasView.this.getScale())) - layoutParams3.height) - CanvasView.this.f873Q);
                            CanvasView.this.f870N.setBackgroundDrawable(CanvasView.this.f874R);
                            CanvasView.this.f870N.setPadding(0, -10, 0, 0);
                        }
                        try {
                            CanvasView.this.f870N.setLayoutParams(layoutParams3);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        if (CanvasView.this.f940bF) {
                            if (!CanvasView.this.f895aN && !CanvasView.this.f916ai.isFocusableInTouchMode()) {
                                CanvasView.this.f916ai.setFocusableInTouchMode(true);
                                CanvasView.this.f894aM = true;
                                event.setAction(0);
                                CanvasView.this.f916ai.onTouchEvent(event);
                                event.setAction(1);
                                CanvasView.this.f916ai.onTouchEvent(event);
                                CanvasView.this.f894aM = false;
                            }
                            CanvasView.this.f895aN = false;
                        }
                        CanvasView.this.f914ag = EnumC0970b.NONE;
                        v.setLongClickable(true);
                        return false;
                    case 2:
                        if (CanvasView.this.f914ag != EnumC0970b.NONE) {
                            RelativeLayout relativeLayout = (RelativeLayout) CanvasView.this.getParent();
                            float scaleX = relativeLayout.getScaleX();
                            float scaleY = relativeLayout.getScaleY();
                            int rawX = (int) event.getRawX();
                            int rawY = (int) event.getRawY();
                            int i3 = (int) ((rawX - CanvasView.this.f888aG) / scaleX);
                            if (i3 != 0) {
                                float rawX2 = event.getRawX() - rawX;
                                CanvasView canvasView = CanvasView.this;
                                canvasView.f892aK = ((rawX2 - CanvasView.this.f890aI) / scaleX) + canvasView.f892aK;
                                if (CanvasView.this.f892aK >= 1.0f) {
                                    CanvasView.this.f892aK -= 1.0f;
                                    i = i3 + 1;
                                } else {
                                    if (CanvasView.this.f890aI <= -1.0f) {
                                        i3--;
                                        CanvasView.this.f892aK -= -1.0f;
                                    }
                                    i = i3;
                                }
                            } else {
                                i = i3;
                            }
                            int i4 = (int) ((rawY - CanvasView.this.f889aH) / scaleY);
                            if (i4 != 0) {
                                float rawY2 = event.getRawY() - rawY;
                                CanvasView canvasView2 = CanvasView.this;
                                canvasView2.f893aL = ((rawY2 - CanvasView.this.f891aJ) / scaleY) + canvasView2.f893aL;
                                if (CanvasView.this.f893aL >= 1.0f) {
                                    CanvasView.this.f893aL -= 1.0f;
                                    i2 = i4 + 1;
                                } else {
                                    if (CanvasView.this.f893aL <= -1.0f) {
                                        i4--;
                                        CanvasView.this.f893aL -= -1.0f;
                                    }
                                    i2 = i4;
                                }
                            } else {
                                i2 = i4;
                            }
                            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) CanvasView.this.f916ai.getLayoutParams();
                            Rect rect2 = new Rect(layoutParams4.leftMargin, layoutParams4.topMargin, layoutParams4.width, layoutParams4.height);
                            if (CanvasView.this.f914ag == EnumC0970b.LEFT || CanvasView.this.f914ag == EnumC0970b.TOP_LEFT || CanvasView.this.f914ag == EnumC0970b.BOTTOM_LEFT) {
                                int i5 = layoutParams4.leftMargin + i;
                                int iRound = Math.round((rect2.left - i5) / CanvasView.this.getScale());
                                int paddingLeft = CanvasView.this.f916ai.getPaddingLeft() + CanvasView.this.f916ai.getPaddingRight();
                                rect2.right += iRound;
                                if (rect2.right > (CanvasView.this.f993n.getTextSize() * 4) + paddingLeft) {
                                    layoutParams4.leftMargin = i5;
                                    rect2.left = i5;
                                    layoutParams4.width += iRound;
                                    rect2.right += iRound;
                                }
                                rect2.right -= iRound;
                                if (rect2.right < (CanvasView.this.f993n.getTextSize() * 4) + paddingLeft) {
                                    rect2.right = (CanvasView.this.f993n.getTextSize() * 4) + paddingLeft;
                                }
                            }
                            if (CanvasView.this.f914ag == EnumC0970b.RIGHT || CanvasView.this.f914ag == EnumC0970b.TOP_RIGHT || CanvasView.this.f914ag == EnumC0970b.BOTTOM_RIGHT) {
                                rect2.right = layoutParams4.width + i;
                                int paddingLeft2 = CanvasView.this.f916ai.getPaddingLeft() + CanvasView.this.f916ai.getPaddingRight();
                                if (rect2.right < (CanvasView.this.f993n.getTextSize() * 4) + paddingLeft2) {
                                    rect2.right = paddingLeft2 + (CanvasView.this.f993n.getTextSize() * 4);
                                }
                            }
                            if (CanvasView.this.f914ag == EnumC0970b.TOP || CanvasView.this.f914ag == EnumC0970b.TOP_LEFT || CanvasView.this.f914ag == EnumC0970b.TOP_RIGHT) {
                                int i6 = layoutParams4.topMargin + i2;
                                int iRound2 = Math.round((rect2.top - i6) / CanvasView.this.getScale());
                                TextPaint textPaint = new TextPaint();
                                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(CanvasView.this.f916ai.getText());
                                if (spannableStringBuilder.length() <= 0) {
                                    if (CanvasView.this.f1001v != null) {
                                        spannableStringBuilder.append((CharSequence) CanvasView.this.f1001v.m783d());
                                    } else {
                                        spannableStringBuilder.append((CharSequence) "Insert Text");
                                    }
                                }
                                if ((layoutParams4.height + iRound2) - (CanvasView.this.f916ai.getPaddingTop() + CanvasView.this.f916ai.getPaddingBottom()) > new DynamicLayout(spannableStringBuilder, textPaint, rect2.right - (CanvasView.this.f916ai.getPaddingLeft() + CanvasView.this.f916ai.getPaddingRight()), CanvasView.this.f916ai.getLayout() == null ? null : CanvasView.this.f916ai.getLayout().getAlignment(), 1.0f, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, false).getHeight()) {
                                    layoutParams4.topMargin = i6;
                                    rect2.top = i6;
                                    rect2.bottom += iRound2;
                                    layoutParams4.height += iRound2;
                                    if (layoutParams4.topMargin < CanvasView.this.f913af.top) {
                                        rect2.bottom -= Math.round((CanvasView.this.f913af.top - layoutParams4.topMargin) / CanvasView.this.getScale());
                                        layoutParams4.height -= Math.round((CanvasView.this.f913af.top - layoutParams4.topMargin) / CanvasView.this.getScale());
                                        layoutParams4.topMargin = (int) CanvasView.this.f913af.top;
                                        rect2.top = (int) CanvasView.this.f913af.top;
                                    }
                                }
                            }
                            if (CanvasView.this.f914ag == EnumC0970b.BOTTOM || CanvasView.this.f914ag == EnumC0970b.BOTTOM_LEFT || CanvasView.this.f914ag == EnumC0970b.BOTTOM_RIGHT) {
                                rect2.bottom = layoutParams4.height + i2;
                                if (rect2.bottom < 100) {
                                    rect2.bottom = 100;
                                }
                            }
                            PointF pointFMapToScene2 = CanvasView.this.f991l.stage.mapToScene(new PointF(layoutParams4.leftMargin, layoutParams4.topMargin));
                            if (CanvasView.this.f914ag != EnumC0970b.CENTER) {
                                if (CanvasView.this.m888a(rect2, false)) {
                                    layoutParams4.width = rect2.right;
                                    layoutParams4.height = rect2.bottom;
                                }
                                if (pointFMapToScene2.x < CanvasView.this.f992m.left) {
                                    layoutParams4.width = rect2.right;
                                    layoutParams4.leftMargin = CanvasView.this.f992m.left;
                                }
                                if (pointFMapToScene2.y < CanvasView.this.f992m.top) {
                                    layoutParams4.height = rect2.bottom;
                                    layoutParams4.topMargin = CanvasView.this.f992m.top;
                                }
                                if (pointFMapToScene2.x + layoutParams4.width > CanvasView.this.f992m.right) {
                                    layoutParams4.width = (int) (CanvasView.this.f992m.right - pointFMapToScene2.x);
                                }
                                if (pointFMapToScene2.y + layoutParams4.height > CanvasView.this.f992m.bottom) {
                                    layoutParams4.height = (int) (CanvasView.this.f992m.bottom - pointFMapToScene2.y);
                                }
                            } else {
                                if (CanvasView.this.f940bF && !CanvasView.this.f895aN) {
                                    if (i > 5 || i < -5 || i2 > 5 || i2 < -5) {
                                        CanvasView.this.f895aN = true;
                                    } else {
                                        return false;
                                    }
                                }
                                RectF rectF = new RectF(CanvasView.this.f992m);
                                rectF.left -= CanvasView.this.getLeft();
                                rectF.top -= CanvasView.this.getTop();
                                rectF.right -= CanvasView.this.getLeft();
                                rectF.bottom -= CanvasView.this.getTop();
                                rectF.offset((-rectF.left) * 2.0f, (-rectF.top) * 2.0f);
                                if (pointFMapToScene2.x + i < rectF.left + ((CanvasView.this.f916ai.getPaddingLeft() / 6.0f) * CanvasView.this.getScale())) {
                                    layoutParams4.leftMargin += (int) ((rectF.left + ((CanvasView.this.f916ai.getPaddingLeft() / 6.0f) * CanvasView.this.getScale())) - pointFMapToScene2.x);
                                    layoutParams4.rightMargin = 0;
                                } else if (pointFMapToScene2.x + layoutParams4.width + i > rectF.right) {
                                    layoutParams4.rightMargin = (int) (pointFMapToScene2.x + (layoutParams4.width * CanvasView.this.getScale()));
                                } else {
                                    layoutParams4.leftMargin += i;
                                    if (((int) pointFMapToScene2.x) + layoutParams4.width > rectF.right) {
                                        layoutParams4.rightMargin = ((int) pointFMapToScene2.x) + layoutParams4.width;
                                    } else {
                                        layoutParams4.rightMargin = (-((int) pointFMapToScene2.x)) - layoutParams4.width;
                                    }
                                }
                                if (pointFMapToScene2.y + i2 < rectF.top + ((CanvasView.this.f916ai.getPaddingTop() / 6.0f) * CanvasView.this.getScale())) {
                                    layoutParams4.topMargin = (int) (((rectF.top + ((CanvasView.this.f916ai.getPaddingTop() / 6.0f) * CanvasView.this.getScale())) - pointFMapToScene2.y) + layoutParams4.topMargin);
                                    layoutParams4.bottomMargin = 0;
                                } else if (pointFMapToScene2.y + layoutParams4.height + i2 > rectF.bottom) {
                                    layoutParams4.bottomMargin = (int) ((layoutParams4.topMargin + (layoutParams4.height * CanvasView.this.getScale())) - 1.0f);
                                } else {
                                    layoutParams4.topMargin += i2;
                                    if (layoutParams4.topMargin + layoutParams4.height > rectF.bottom) {
                                        layoutParams4.bottomMargin = (int) (layoutParams4.topMargin + (layoutParams4.height * CanvasView.this.getScale()));
                                    } else {
                                        layoutParams4.bottomMargin = (-((int) pointFMapToScene2.y)) - layoutParams4.height;
                                    }
                                }
                            }
                            CanvasView.this.f888aG = (int) event.getRawX();
                            CanvasView.this.f889aH = (int) event.getRawY();
                            CanvasView.this.f890aI = event.getRawX() - CanvasView.this.f888aG;
                            CanvasView.this.f891aJ = event.getRawY() - CanvasView.this.f889aH;
                            CanvasView.this.f916ai.setLayoutParams(layoutParams4);
                            if (!CanvasView.this.f940bF) {
                                RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) CanvasView.this.f865I.getLayoutParams();
                                layoutParams5.leftMargin = layoutParams4.leftMargin - CanvasView.this.f866J;
                                layoutParams5.topMargin = (layoutParams4.topMargin - CanvasView.this.f867K) + 10;
                                layoutParams5.width = -2;
                                layoutParams5.height = -2;
                                if (layoutParams5.leftMargin < 0) {
                                    layoutParams5.leftMargin = (layoutParams4.leftMargin + layoutParams4.width) - 30;
                                }
                                if (layoutParams5.topMargin < 0) {
                                    layoutParams5.topMargin = (layoutParams4.topMargin + layoutParams4.height) - 20;
                                }
                                if (layoutParams5.leftMargin < CanvasView.this.f913af.left) {
                                    layoutParams5.leftMargin = (int) CanvasView.this.f913af.left;
                                }
                                if (layoutParams5.leftMargin + layoutParams5.width > CanvasView.this.f913af.right) {
                                    layoutParams5.leftMargin = (int) (CanvasView.this.f913af.right - CanvasView.this.f866J);
                                }
                                if (layoutParams5.topMargin < CanvasView.this.f913af.top) {
                                    layoutParams5.topMargin = (int) CanvasView.this.f913af.top;
                                }
                                if (layoutParams5.topMargin + layoutParams5.height > CanvasView.this.getBottom()) {
                                    layoutParams5.topMargin = (int) (CanvasView.this.f913af.bottom - CanvasView.this.f867K);
                                }
                                try {
                                    CanvasView.this.f865I.setLayoutParams(layoutParams5);
                                } catch (Exception e3) {
                                    e3.printStackTrace();
                                }
                            }
                            RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) CanvasView.this.f870N.getLayoutParams();
                            layoutParams6.leftMargin = (int) ((layoutParams4.leftMargin + ((layoutParams4.width * CanvasView.this.getScale()) / 2.0f)) - (CanvasView.this.f871O / 2.0f));
                            layoutParams6.topMargin = (int) (((layoutParams4.topMargin + ((CanvasView.this.f916ai.getPaddingTop() / 2.0f) * CanvasView.this.getScale())) - CanvasView.this.f872P) - CanvasView.this.f873Q);
                            layoutParams6.width = CanvasView.this.f871O;
                            layoutParams6.height = CanvasView.this.f872P;
                            if (layoutParams6.topMargin >= 0 && layoutParams6.topMargin >= CanvasView.this.getTop()) {
                                CanvasView.this.f870N.setBackgroundDrawable(CanvasView.this.f874R);
                                CanvasView.this.f870N.setPadding(0, -10, 0, 0);
                            } else {
                                layoutParams6.topMargin = (int) (((layoutParams4.topMargin + (layoutParams4.height * CanvasView.this.getScale())) - ((CanvasView.this.f916ai.getPaddingBottom() / 2.0f) * CanvasView.this.getScale())) + CanvasView.this.f873Q);
                                CanvasView.this.f870N.setBackgroundDrawable(CanvasView.this.f875S);
                                CanvasView.this.f870N.setPadding(0, 10, 0, 0);
                            }
                            if (layoutParams6.topMargin + layoutParams6.height > CanvasView.this.getBottom()) {
                                layoutParams6.topMargin = (int) ((((layoutParams4.topMargin + (layoutParams4.height * CanvasView.this.getScale())) - (CanvasView.this.f916ai.getPaddingBottom() * CanvasView.this.getScale())) - layoutParams6.height) - CanvasView.this.f873Q);
                                CanvasView.this.f870N.setBackgroundDrawable(CanvasView.this.f874R);
                                CanvasView.this.f870N.setPadding(0, -10, 0, 0);
                            }
                            if (layoutParams6.leftMargin + layoutParams6.width > CanvasView.this.getRight()) {
                                layoutParams6.rightMargin = CanvasView.this.getRight() + (CanvasView.this.getRight() - layoutParams6.leftMargin);
                            } else {
                                layoutParams6.rightMargin = 0;
                            }
                            try {
                                CanvasView.this.f870N.setLayoutParams(layoutParams6);
                            } catch (Exception e4) {
                                e4.printStackTrace();
                            }
                            return true;
                        }
                        return false;
                    default:
                        return false;
                }
            }
        };
        this.f898aQ = new View.OnFocusChangeListener() { // from class: com.samsung.sdraw.CanvasView.17
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View v, boolean hasFocus) {
                InputMethodManager inputMethodManager = (InputMethodManager) CanvasView.this.getContext().getSystemService("input_method");
                if (hasFocus) {
                    inputMethodManager.showSoftInput(v, 0);
                } else {
                    inputMethodManager.hideSoftInputFromWindow(CanvasView.this.getWindowToken(), 0);
                }
            }
        };
        this.f899aR = 0;
        this.f900aS = new TextWatcher() { // from class: com.samsung.sdraw.CanvasView.18
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Layout.Alignment alignment;
                if (!CanvasView.this.f912ae) {
                    CanvasView.this.f911ad = new SpannableStringBuilder(CanvasView.this.f916ai.getText());
                }
                CanvasView.this.f912ae = false;
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(CanvasView.this.f916ai.getText());
                if (spannableStringBuilder.length() <= 0) {
                    if (CanvasView.this.f1001v != null) {
                        spannableStringBuilder.append((CharSequence) CanvasView.this.f1001v.m783d());
                    } else {
                        spannableStringBuilder.append((CharSequence) "Insert Text");
                    }
                    spannableStringBuilder.setSpan(new AbsoluteSizeSpan(40), 0, spannableStringBuilder.length(), 18);
                }
                CanvasView canvasView = CanvasView.this;
                TextPaint paint = CanvasView.this.f916ai.getPaint();
                int iMax = Math.max(1, CanvasView.this.f916ai.getWidth() - (CanvasView.this.f916ai.getPaddingLeft() + CanvasView.this.f916ai.getPaddingRight()));
                if (CanvasView.this.f916ai.getLayout() != null) {
                    alignment = CanvasView.this.f916ai.getLayout().getAlignment();
                } else {
                    alignment = null;
                }
                canvasView.f899aR = new DynamicLayout(spannableStringBuilder, paint, iMax, alignment, 1.0f, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, false).getLineCount();
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                DynamicLayout dynamicLayout;
                int lineCount;
                if (CanvasView.this.f916ai.getWidth() > 0) {
                    CanvasView.this.f916ai.setFilters(new InputFilter[]{new C0991ad(CanvasView.this.getContext(), 128)});
                    CanvasView.this.m913c(((ForegroundColorSpan) CanvasView.this.f908aa[0]).getForegroundColor());
                    CanvasView.this.m873a(CanvasView.this.f991l.setting.getTextType(), true);
                    CanvasView.this.setTextAlignment(CanvasView.this.f991l.setting.getTextAlignment());
                    CanvasView.this.m906b(CanvasView.this.f991l.setting.getTextSize());
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) CanvasView.this.f916ai.getLayoutParams();
                    int textSize = 10;
                    if (CanvasView.this.f993n != null) {
                        textSize = CanvasView.this.f993n.getTextSize();
                    }
                    if (CanvasView.this.f916ai.getText() != null) {
                        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(CanvasView.this.f916ai.getText());
                        if (spannableStringBuilder.length() <= 0) {
                            if (CanvasView.this.f1001v != null) {
                                spannableStringBuilder.append((CharSequence) CanvasView.this.f1001v.m783d());
                            } else {
                                spannableStringBuilder.append((CharSequence) "Insert Text");
                            }
                            spannableStringBuilder.setSpan(new AbsoluteSizeSpan(40), 0, spannableStringBuilder.length(), 18);
                        }
                        int paddingLeft = CanvasView.this.f916ai.getPaddingLeft() + CanvasView.this.f916ai.getPaddingRight();
                        if (layoutParams.width < (textSize * 4) + paddingLeft) {
                            layoutParams.width = (textSize * 4) + paddingLeft;
                            CanvasView.this.f916ai.setLayoutParams(layoutParams);
                        }
                        if (CanvasView.this.f916ai.getLayoutParams().width <= CanvasView.this.f916ai.getPaddingLeft() + CanvasView.this.f916ai.getPaddingRight()) {
                            dynamicLayout = new DynamicLayout(spannableStringBuilder, CanvasView.this.f916ai.getPaint(), CanvasView.this.f916ai.getWidth() - (CanvasView.this.f916ai.getPaddingLeft() + CanvasView.this.f916ai.getPaddingRight()), CanvasView.this.f916ai.getLayout() != null ? CanvasView.this.f916ai.getLayout().getAlignment() : null, 1.0f, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, false);
                        } else {
                            dynamicLayout = new DynamicLayout(spannableStringBuilder, CanvasView.this.f916ai.getPaint(), CanvasView.this.f916ai.getLayoutParams().width - (CanvasView.this.f916ai.getPaddingLeft() + CanvasView.this.f916ai.getPaddingRight()), CanvasView.this.f916ai.getLayout() != null ? CanvasView.this.f916ai.getLayout().getAlignment() : null, 1.0f, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, false);
                        }
                        lineCount = dynamicLayout.getLineCount();
                    } else {
                        dynamicLayout = null;
                        lineCount = 0;
                    }
                    if (lineCount != CanvasView.this.f899aR && lineCount > 0 && dynamicLayout != null) {
                        Rect rect = new Rect();
                        int paddingBottom = CanvasView.this.f916ai.getPaddingBottom() + CanvasView.this.f916ai.getPaddingTop();
                        dynamicLayout.getLineBounds(lineCount - 1, rect);
                        if (rect.bottom + paddingBottom < CanvasView.this.f880Z) {
                            layoutParams.height = rect.bottom + paddingBottom;
                            if (layoutParams.height > CanvasView.this.f880Z) {
                                layoutParams.height = (int) (CanvasView.this.f880Z - 10.0f);
                            }
                            CanvasView.this.f916ai.setLayoutParams(layoutParams);
                        } else if (rect.bottom + paddingBottom + CanvasView.this.f991l.setting.getCanvasRect().top >= CanvasView.this.f991l.setting.getCanvasRect().height() || CanvasView.this.f916ai.getHeight() >= rect.bottom + paddingBottom) {
                            if (CanvasView.this.f911ad.length() != s.length() && !CanvasView.this.f879W) {
                                CanvasView.this.f912ae = true;
                            }
                        } else {
                            Rect rect2 = new Rect();
                            CanvasView.this.f916ai.getLineBounds(0, rect2);
                            layoutParams.topMargin -= rect2.height();
                            if (layoutParams.topMargin < 0) {
                                layoutParams.topMargin = 0;
                            }
                            CanvasView.this.f880Z = (CanvasView.this.f991l.setting.getCanvasRect().height() - layoutParams.topMargin) - CanvasView.this.f991l.setting.getCanvasRect().top;
                            layoutParams.height = (int) (CanvasView.this.f880Z - 10.0f);
                            CanvasView.this.f916ai.setLayoutParams(layoutParams);
                        }
                        if (!CanvasView.this.f940bF) {
                            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) CanvasView.this.f865I.getLayoutParams();
                            layoutParams2.leftMargin = layoutParams.leftMargin - CanvasView.this.f866J;
                            layoutParams2.topMargin = (layoutParams.topMargin - CanvasView.this.f867K) + 10;
                            layoutParams2.width = -2;
                            layoutParams2.height = -2;
                            if (layoutParams2.leftMargin < 0) {
                                layoutParams2.leftMargin = (layoutParams.leftMargin + layoutParams.width) - 40;
                            }
                            if (layoutParams2.topMargin < 0) {
                                layoutParams2.topMargin = (layoutParams.topMargin + layoutParams.height) - 30;
                            }
                            if (layoutParams2.leftMargin < CanvasView.this.f913af.left) {
                                layoutParams2.leftMargin = (int) CanvasView.this.f913af.left;
                            }
                            if (layoutParams2.leftMargin + layoutParams2.width > CanvasView.this.f913af.right) {
                                layoutParams2.leftMargin = (int) (CanvasView.this.f913af.right - CanvasView.this.f866J);
                            }
                            if (layoutParams2.topMargin < CanvasView.this.f913af.top) {
                                layoutParams2.topMargin = (int) CanvasView.this.f913af.top;
                            }
                            if (layoutParams2.topMargin + layoutParams2.height > CanvasView.this.getBottom()) {
                                layoutParams2.topMargin = (int) (CanvasView.this.f913af.bottom - CanvasView.this.f867K);
                            }
                            try {
                                CanvasView.this.f865I.setLayoutParams(layoutParams2);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) CanvasView.this.f870N.getLayoutParams();
                        layoutParams3.leftMargin = (int) ((layoutParams.leftMargin + ((layoutParams.width * CanvasView.this.getScale()) / 2.0f)) - (CanvasView.this.f871O / 2.0f));
                        layoutParams3.topMargin = (int) (((layoutParams.topMargin + ((CanvasView.this.f916ai.getPaddingTop() / 2.0f) * CanvasView.this.getScale())) - CanvasView.this.f872P) - CanvasView.this.f873Q);
                        layoutParams3.width = CanvasView.this.f871O;
                        layoutParams3.height = CanvasView.this.f872P;
                        if (layoutParams3.topMargin >= 0 && layoutParams3.topMargin >= CanvasView.this.getTop()) {
                            CanvasView.this.f870N.setBackgroundDrawable(CanvasView.this.f874R);
                            CanvasView.this.f870N.setPadding(0, -10, 0, 0);
                        } else {
                            layoutParams3.topMargin = (int) (((layoutParams.topMargin + (layoutParams.height * CanvasView.this.getScale())) - ((CanvasView.this.f916ai.getPaddingBottom() / 2.0f) * CanvasView.this.getScale())) + CanvasView.this.f873Q);
                            CanvasView.this.f870N.setBackgroundDrawable(CanvasView.this.f875S);
                            CanvasView.this.f870N.setPadding(0, 10, 0, 0);
                        }
                        if (layoutParams3.topMargin + layoutParams3.height > CanvasView.this.getBottom()) {
                            layoutParams3.topMargin = (int) ((((layoutParams.topMargin + (layoutParams.height * CanvasView.this.getScale())) - (CanvasView.this.f916ai.getPaddingBottom() * CanvasView.this.getScale())) - layoutParams3.height) - CanvasView.this.f873Q);
                            CanvasView.this.f870N.setBackgroundDrawable(CanvasView.this.f874R);
                            CanvasView.this.f870N.setPadding(0, -10, 0, 0);
                        }
                        try {
                            CanvasView.this.f870N.setLayoutParams(layoutParams3);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
        };
        this.f903aV = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.samsung.sdraw.CanvasView.19
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent e) {
                return !CanvasView.this.f954bT;
            }
        });
        this.f904aW = new View.OnLongClickListener() { // from class: com.samsung.sdraw.CanvasView.20
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View arg0) {
                return !CanvasView.this.f953bS;
            }
        };
        this.f987h = false;
        this.f988i = false;
        this.f905aX = new View.OnTouchListener() { // from class: com.samsung.sdraw.CanvasView.2
            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                int rawX = (int) event.getRawX();
                int rawY = (int) event.getRawY();
                switch (event.getAction()) {
                    case 0:
                        CanvasView.this.f868L = (int) event.getRawX();
                        CanvasView.this.f869M = (int) event.getRawY();
                        CanvasView.this.f916ai.clearFocus();
                        return false;
                    case 1:
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) CanvasView.this.f916ai.getLayoutParams();
                        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) CanvasView.this.f865I.getLayoutParams();
                        CanvasView.this.f987h = false;
                        CanvasView.this.f988i = false;
                        layoutParams2.leftMargin = layoutParams.leftMargin - CanvasView.this.f866J;
                        layoutParams2.topMargin = (layoutParams.topMargin - CanvasView.this.f867K) + 10;
                        if (layoutParams2.leftMargin < 0) {
                            CanvasView.this.f987h = true;
                            layoutParams2.leftMargin = (layoutParams.leftMargin + layoutParams.width) - 30;
                        }
                        if (layoutParams2.topMargin < 0) {
                            CanvasView.this.f988i = true;
                            layoutParams2.topMargin = (layoutParams.topMargin + layoutParams.height) - 20;
                        }
                        CanvasView.this.f865I.setLayoutParams(layoutParams2);
                        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) CanvasView.this.f870N.getLayoutParams();
                        layoutParams3.leftMargin = (int) ((layoutParams.leftMargin + ((layoutParams.width * CanvasView.this.getScale()) / 2.0f)) - (CanvasView.this.f871O / 2.0f));
                        layoutParams3.topMargin = (int) (((layoutParams.topMargin + ((CanvasView.this.f916ai.getPaddingTop() / 2.0f) * CanvasView.this.getScale())) - CanvasView.this.f872P) - CanvasView.this.f873Q);
                        layoutParams3.width = CanvasView.this.f871O;
                        layoutParams3.height = CanvasView.this.f872P;
                        if (layoutParams3.topMargin >= 0 && layoutParams3.topMargin >= CanvasView.this.getTop()) {
                            CanvasView.this.f870N.setBackgroundDrawable(CanvasView.this.f874R);
                            CanvasView.this.f870N.setPadding(0, -10, 0, 0);
                        } else {
                            layoutParams3.topMargin = (int) (((layoutParams.topMargin + (layoutParams.height * CanvasView.this.getScale())) - ((CanvasView.this.f916ai.getPaddingBottom() / 2.0f) * CanvasView.this.getScale())) + CanvasView.this.f873Q);
                            CanvasView.this.f870N.setBackgroundDrawable(CanvasView.this.f875S);
                            CanvasView.this.f870N.setPadding(0, 10, 0, 0);
                        }
                        if (layoutParams3.topMargin + layoutParams3.height > CanvasView.this.getBottom()) {
                            layoutParams3.topMargin = (int) (((((layoutParams.height * CanvasView.this.getScale()) + layoutParams.topMargin) - (CanvasView.this.f916ai.getPaddingBottom() * CanvasView.this.getScale())) - layoutParams3.height) - CanvasView.this.f873Q);
                            CanvasView.this.f870N.setBackgroundDrawable(CanvasView.this.f874R);
                            CanvasView.this.f870N.setPadding(0, -10, 0, 0);
                        }
                        try {
                            CanvasView.this.f870N.setLayoutParams(layoutParams3);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        return false;
                    case 2:
                        float f = rawX - CanvasView.this.f868L;
                        float f2 = rawY - CanvasView.this.f869M;
                        RectF rectF = new RectF(CanvasView.this.f913af);
                        rectF.left -= CanvasView.this.getLeft();
                        rectF.top -= CanvasView.this.getTop();
                        rectF.right -= CanvasView.this.getLeft();
                        rectF.bottom -= CanvasView.this.getTop();
                        rectF.offset((-rectF.left) * 2.0f, (-rectF.top) * 2.0f);
                        rectF.right = rectF.left + Math.min(rectF.width(), CanvasView.this.getWidth());
                        rectF.bottom = rectF.top + Math.min(rectF.height(), CanvasView.this.getHeight());
                        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) CanvasView.this.f916ai.getLayoutParams();
                        RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) CanvasView.this.f865I.getLayoutParams();
                        if (layoutParams4.leftMargin + f < rectF.left) {
                            layoutParams4.leftMargin = (int) rectF.left;
                        } else if (layoutParams4.leftMargin + layoutParams4.width + f > rectF.right) {
                            layoutParams4.leftMargin = (int) (rectF.right - layoutParams4.width);
                        } else {
                            layoutParams4.leftMargin = (int) (f + layoutParams4.leftMargin);
                        }
                        if (layoutParams4.topMargin + f2 < rectF.top) {
                            layoutParams4.topMargin = (int) rectF.top;
                        } else if (layoutParams4.topMargin + layoutParams4.height + f2 > rectF.bottom) {
                            layoutParams4.topMargin = (int) (rectF.bottom - layoutParams4.height);
                        } else {
                            layoutParams4.topMargin = (int) (layoutParams4.topMargin + f2);
                        }
                        if (layoutParams4.topMargin + layoutParams4.height >= CanvasView.this.getHeight()) {
                            layoutParams4.topMargin = CanvasView.this.getHeight() - layoutParams4.height;
                        }
                        layoutParams5.leftMargin = layoutParams4.leftMargin - CanvasView.this.f866J;
                        layoutParams5.topMargin = (layoutParams4.topMargin - CanvasView.this.f867K) + 10;
                        layoutParams5.width = -2;
                        layoutParams5.height = -2;
                        if (CanvasView.this.f987h) {
                            layoutParams5.leftMargin = (layoutParams4.leftMargin + layoutParams4.width) - 30;
                            if (layoutParams5.leftMargin + CanvasView.this.f865I.getWidth() > CanvasView.this.f913af.width()) {
                                layoutParams5.leftMargin = ((int) CanvasView.this.f913af.width()) - CanvasView.this.f865I.getWidth();
                            }
                        }
                        if (CanvasView.this.f988i) {
                            layoutParams5.topMargin = (layoutParams4.topMargin + layoutParams4.height) - 20;
                            if (layoutParams5.topMargin + CanvasView.this.f865I.getHeight() > CanvasView.this.f913af.height()) {
                                layoutParams5.topMargin = ((int) CanvasView.this.f913af.height()) - CanvasView.this.f865I.getHeight();
                            }
                        }
                        CanvasView.this.f868L = rawX;
                        CanvasView.this.f869M = rawY;
                        CanvasView.this.f865I.setLayoutParams(layoutParams5);
                        CanvasView.this.f916ai.setLayoutParams(layoutParams4);
                        RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) CanvasView.this.f870N.getLayoutParams();
                        layoutParams6.leftMargin = (int) ((layoutParams4.leftMargin + ((layoutParams4.width * CanvasView.this.getScale()) / 2.0f)) - (CanvasView.this.f871O / 2.0f));
                        layoutParams6.topMargin = (int) (((layoutParams4.topMargin + ((CanvasView.this.f916ai.getPaddingTop() / 2.0f) * CanvasView.this.getScale())) - CanvasView.this.f872P) - CanvasView.this.f873Q);
                        layoutParams6.width = CanvasView.this.f871O;
                        layoutParams6.height = CanvasView.this.f872P;
                        if (layoutParams6.topMargin >= 0 && layoutParams6.topMargin >= CanvasView.this.getTop()) {
                            CanvasView.this.f870N.setBackgroundDrawable(CanvasView.this.f874R);
                            CanvasView.this.f870N.setPadding(0, -10, 0, 0);
                        } else {
                            layoutParams6.topMargin = (int) (((layoutParams4.topMargin + (layoutParams4.height * CanvasView.this.getScale())) - ((CanvasView.this.f916ai.getPaddingBottom() / 2.0f) * CanvasView.this.getScale())) + CanvasView.this.f873Q);
                            CanvasView.this.f870N.setBackgroundDrawable(CanvasView.this.f875S);
                            CanvasView.this.f870N.setPadding(0, 10, 0, 0);
                        }
                        if (layoutParams6.topMargin + layoutParams6.height > CanvasView.this.getBottom()) {
                            layoutParams6.topMargin = (int) (((((layoutParams4.height * CanvasView.this.getScale()) + layoutParams4.topMargin) - (CanvasView.this.f916ai.getPaddingBottom() * CanvasView.this.getScale())) - layoutParams6.height) - CanvasView.this.f873Q);
                            CanvasView.this.f870N.setBackgroundDrawable(CanvasView.this.f874R);
                            CanvasView.this.f870N.setPadding(0, -10, 0, 0);
                        }
                        try {
                            CanvasView.this.f870N.setLayoutParams(layoutParams6);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        return false;
                    default:
                        return false;
                }
            }
        };
        this.f906aY = new View.OnTouchListener() { // from class: com.samsung.sdraw.CanvasView.3
            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                PointF pointFMapToScene = CanvasView.this.f991l.stage.mapToScene(new PointF(event.getX(), event.getY()));
                switch (event.getAction()) {
                    case 0:
                        CanvasView.this.f876T = true;
                        return false;
                    case 1:
                        if (CanvasView.this.f876T) {
                            CanvasView.this.f870N.playSoundEffect(0);
                            CanvasView.this.deleteSelectedObject();
                            CanvasView.this.m970a(v);
                        }
                        return false;
                    case 2:
                        if (!new Rect(0, 0, CanvasView.this.f870N.getWidth(), CanvasView.this.f870N.getHeight()).contains((int) pointFMapToScene.x, (int) pointFMapToScene.y)) {
                            CanvasView.this.f876T = false;
                        }
                        return false;
                    default:
                        return false;
                }
            }
        };
        this.f907aZ = new TextMode.OnTextSelectedListener() { // from class: com.samsung.sdraw.CanvasView.4
            @Override // com.samsung.sdraw.TextMode.OnTextSelectedListener
            public void onTextSelected(ObjectInfo objectInfo, boolean bSelected) {
                if (CanvasView.this.f968bm == null) {
                    return;
                }
                CanvasView.this.f968bm.onObjectSelected(objectInfo, bSelected);
            }
        };
        this.f956ba = new SelectMode.OnImageSelectedListener() { // from class: com.samsung.sdraw.CanvasView.5
            @Override // com.samsung.sdraw.SelectMode.OnImageSelectedListener
            public void onImageSelected(ObjectInfo objectInfo, boolean bSelected) {
                if (CanvasView.this.f968bm == null) {
                    return;
                }
                CanvasView.this.f968bm.onObjectSelected(objectInfo, bSelected);
            }
        };
        this.f957bb = null;
        this.f958bc = null;
        this.f959bd = true;
        this.f960be = false;
        this.f961bf = 0;
        this.f962bg = 0;
        this.f964bi = false;
        this.f965bj = new Handler() { // from class: com.samsung.sdraw.CanvasView.6
            @Override // android.os.Handler
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case 2:
                        if (!CanvasView.this.f976bu) {
                            CanvasView.this.f964bi = true;
                            break;
                        }
                        break;
                    case 3:
                        int userID = CanvasView.this.getUserID();
                        CanvasView.this.f991l.stage.addSprite((C1063s) msg.obj, true, userID);
                        CanvasView.this.f991l.stage.clearLayer(CanvasView.this.f991l.modes.get(Integer.valueOf(userID)).getLayerID(CanvasView.this.f991l));
                        CanvasView.this.f991l.stage.renderSprites(CanvasView.this.f991l.modes.get(Integer.valueOf(userID)).getLayerID(CanvasView.this.f991l));
                        CanvasView.this.f991l.invalidate();
                        break;
                }
                super.handleMessage(msg);
            }
        };
        this.f966bk = new Stage.OnSpriteChangeListener() { // from class: com.samsung.sdraw.CanvasView.7
            @Override // com.samsung.sdraw.Stage.OnSpriteChangeListener
            public void onObjectDeleted(ObjectInfo objectInfo, boolean byUndo, boolean byRedo, boolean bFreeMemory) {
                if (CanvasView.this.f968bm == null) {
                    return;
                }
                CanvasView.this.f968bm.onObjectDeleted(objectInfo, byUndo, byRedo, bFreeMemory);
            }

            @Override // com.samsung.sdraw.Stage.OnSpriteChangeListener
            public void onSpriteChanged(boolean undoable, boolean redoable) {
            }

            @Override // com.samsung.sdraw.Stage.OnSpriteChangeListener
            public void onObjectChanged(ObjectInfo objectInfo, boolean byUndo, boolean byRedo) {
                if (CanvasView.this.f968bm == null) {
                    return;
                }
                CanvasView.this.f968bm.onObjectChanged(objectInfo, byUndo, byRedo);
            }

            @Override // com.samsung.sdraw.Stage.OnSpriteChangeListener
            public void onObjectInserted(ObjectInfo objectInfo, boolean byUndo, boolean byRedo) {
                if (CanvasView.this.f968bm == null) {
                    return;
                }
                CanvasView.this.f968bm.onObjectInserted(objectInfo, byUndo, byRedo);
            }

            @Override // com.samsung.sdraw.Stage.OnSpriteChangeListener
            public boolean onStrokeInserting(StrokeInfo strokeInfo) {
                if (CanvasView.this.f968bm != null) {
                    return CanvasView.this.f968bm.onStrokeInserting(strokeInfo);
                }
                return false;
            }

            @Override // com.samsung.sdraw.Stage.OnSpriteChangeListener
            public void onMultiClearAll(boolean undo) {
                if (CanvasView.this.f936bB == null) {
                    return;
                }
                CanvasView.this.f936bB.m993a(undo);
            }
        };
        this.f970bo = false;
        this.f971bp = false;
        this.f972bq = false;
        this.f989j = new AbstractSettingView.InterfaceC0948a() { // from class: com.samsung.sdraw.CanvasView.8
            @Override // com.samsung.sdraw.AbstractSettingView.InterfaceC0948a
            /* renamed from: c */
            public void mo808c(boolean z) {
                if (CanvasView.this.f969bn != null) {
                    CanvasView.this.f969bn.onTextSettingViewShow(z);
                }
                if (!CanvasView.this.f971bp) {
                    CanvasView.this.f1001v.m775a(CanvasView.this.f993n);
                    CanvasView.this.f971bp = true;
                }
            }

            @Override // com.samsung.sdraw.AbstractSettingView.InterfaceC0948a
            /* renamed from: a */
            public void mo806a(boolean z) {
                if (CanvasView.this.f969bn != null) {
                    CanvasView.this.f969bn.onPenSettingViewShow(z);
                }
                if (!CanvasView.this.f970bo) {
                    CanvasView.this.f1001v.m774a(CanvasView.this.f881a);
                    CanvasView.this.f970bo = true;
                }
            }

            @Override // com.samsung.sdraw.AbstractSettingView.InterfaceC0948a
            /* renamed from: b */
            public void mo807b(boolean z) {
                if (CanvasView.this.f969bn != null) {
                    CanvasView.this.f969bn.onEraserSettingViewShow(z);
                }
                if (!CanvasView.this.f970bo) {
                    CanvasView.this.f1001v.m774a(CanvasView.this.f881a);
                    if (CanvasView.this.getMode() == 2) {
                        CanvasView.this.m974a(true);
                    }
                    CanvasView.this.f970bo = true;
                }
            }

            @Override // com.samsung.sdraw.AbstractSettingView.InterfaceC0948a
            /* renamed from: d */
            public void mo809d(boolean z) {
                if (CanvasView.this.f969bn != null) {
                    CanvasView.this.f969bn.onFillingSettingViewShow(z);
                }
                if (!CanvasView.this.f972bq) {
                    CanvasView.this.f1001v.m773a(CanvasView.this.f994o);
                    CanvasView.this.f972bq = true;
                }
            }
        };
        this.f973br = false;
        this.f974bs = null;
        this.f990k = false;
        this.f975bt = false;
        this.f976bu = true;
        this.f977bv = true;
        this.f979bx = null;
        this.f937bC = true;
        this.f938bD = false;
        this.f939bE = false;
        this.f940bF = true;
        this.f941bG = 1.0f;
        this.f942bH = false;
        this.f943bI = 0;
        this.f944bJ = null;
        this.f945bK = null;
        this.f946bL = false;
        this.f948bN = true;
        this.f949bO = 200;
        this.f950bP = 200;
        this.f951bQ = true;
        this.f952bR = true;
        this.f953bS = true;
        this.f954bT = true;
        this.f955bU = false;
        this.f864H = context;
        m928f();
    }

    public CanvasView(Context context, AttributeSet attrs) throws IOException {
        super(context, attrs);
        this.f995p = -1;
        this.f997r = false;
        this.f1002w = false;
        this.f1003x = 1;
        this.f857A = false;
        this.f861E = new Rect();
        this.f862F = new Rect();
        this.f863G = false;
        this.f876T = false;
        this.f877U = false;
        this.f879W = false;
        this.f908aa = new Object[7];
        this.f909ab = 0;
        this.f910ac = Layout.Alignment.ALIGN_NORMAL;
        this.f913af = new RectF(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, 800.0f, 480.0f);
        this.f915ah = false;
        this.f917aj = false;
        this.f984e = "";
        this.f920am = "/system/fonts/";
        this.f921an = getContext().getResources().getDisplayMetrics();
        this.f922ao = "Delete";
        this.f985f = false;
        this.f926as = 10;
        this.f927at = false;
        this.f928au = false;
        this.f929av = 0;
        this.f930aw = true;
        this.f931ax = false;
        this.f932ay = false;
        this.f933az = false;
        this.f883aB = new C0988aa.b() { // from class: com.samsung.sdraw.CanvasView.1
            @Override // com.samsung.sdraw.C0988aa.b
            /* renamed from: a */
            public void mo980a(Matrix matrix) {
                CanvasView.this.f991l.m674a(matrix);
                if (CanvasView.this.f958bc != null) {
                    CanvasView.this.f958bc.onMatrixChanged(matrix);
                }
                mo979a();
            }

            @Override // com.samsung.sdraw.C0988aa.b
            /* renamed from: a */
            public void mo979a() {
                CanvasView.this.invalidate();
            }
        };
        this.f884aC = new PenSettingInfo.InterfaceC0976a() { // from class: com.samsung.sdraw.CanvasView.12
            @Override // com.samsung.sdraw.PenSettingInfo.InterfaceC0976a
            /* renamed from: a */
            public void mo982a(int i, int i2) {
                if (CanvasView.this.f991l != null && CanvasView.this.f991l.setting != null && CanvasView.this.f881a != null) {
                    CanvasView.this.f991l.setting.setStrokeWidth(CanvasView.this.f881a.getPenWidth());
                }
                if (CanvasView.this.f991l != null) {
                    CanvasView.this.f991l.invalidate();
                }
            }

            @Override // com.samsung.sdraw.PenSettingInfo.InterfaceC0976a
            /* renamed from: a */
            public void mo981a(int i) {
                CanvasView.this.m871a(i);
                if (CanvasView.this.f991l != null) {
                    CanvasView.this.f991l.invalidate();
                }
            }

            @Override // com.samsung.sdraw.PenSettingInfo.InterfaceC0976a
            /* renamed from: b */
            public void mo984b(int i, int i2) {
                if (CanvasView.this.f991l != null && CanvasView.this.f991l.setting != null && CanvasView.this.f881a != null) {
                    CanvasView.this.f991l.setting.setStrokeColor(CanvasView.this.f881a.getPenAlphaColor());
                }
                if (CanvasView.this.f991l != null) {
                    CanvasView.this.f991l.invalidate();
                }
            }

            @Override // com.samsung.sdraw.PenSettingInfo.InterfaceC0976a
            /* renamed from: c */
            public void mo985c(int i, int i2) {
                if (CanvasView.this.f991l != null && CanvasView.this.f991l.setting != null && CanvasView.this.f881a != null) {
                    CanvasView.this.f991l.setting.setStrokeColor(CanvasView.this.f881a.getPenAlphaColor());
                }
                if (CanvasView.this.f991l != null) {
                    CanvasView.this.f991l.invalidate();
                }
            }

            @Override // com.samsung.sdraw.PenSettingInfo.InterfaceC0976a
            /* renamed from: b */
            public void mo983b(int i) {
                if (CanvasView.this.f991l != null && CanvasView.this.f991l.setting != null && CanvasView.this.f881a != null && CanvasView.this.getMode() == 2) {
                    CanvasView.this.f991l.setting.setEraserWidth(CanvasView.this.f881a.getEraserWidth());
                }
                if (CanvasView.this.f991l != null) {
                    CanvasView.this.f991l.invalidate();
                }
            }
        };
        this.f885aD = new FillingSettingInfo.InterfaceC0973a() { // from class: com.samsung.sdraw.CanvasView.14
            @Override // com.samsung.sdraw.FillingSettingInfo.InterfaceC0973a
            /* renamed from: a */
            public void mo986a(int i) {
                if (CanvasView.this.f991l != null && CanvasView.this.f991l.setting != null && CanvasView.this.f994o != null) {
                    CanvasView.this.f991l.setting.setFillingColor(CanvasView.this.f994o.getFillingColor());
                }
                if (CanvasView.this.f991l != null) {
                    CanvasView.this.f991l.invalidate();
                }
            }
        };
        this.f886aE = new TextSettingInfo.InterfaceC0985a() { // from class: com.samsung.sdraw.CanvasView.15
            @Override // com.samsung.sdraw.TextSettingInfo.InterfaceC0985a
            /* renamed from: a */
            public void mo987a(int i) {
                if (CanvasView.this.f991l != null && CanvasView.this.f991l.setting != null && CanvasView.this.f993n != null && CanvasView.this.f916ai != null) {
                    CanvasView.this.f991l.setting.setTextType(CanvasView.this.f993n.getTextType());
                    CanvasView.this.f909ab = CanvasView.this.f993n.getTextType();
                    CanvasView.this.m873a(CanvasView.this.f993n.getTextType(), true);
                }
            }

            @Override // com.samsung.sdraw.TextSettingInfo.InterfaceC0985a
            /* renamed from: b */
            public void mo990b(int i) {
                if (CanvasView.this.f991l != null && CanvasView.this.f991l.setting != null && CanvasView.this.f993n != null) {
                    CanvasView.this.f991l.setting.setTextColor(CanvasView.this.f993n.getTextColor());
                    if (!CanvasView.this.f933az) {
                        CanvasView.this.m949k();
                        CanvasView.this.f933az = true;
                    }
                    if (CanvasView.this.isShowTextBox()) {
                        CanvasView.this.f983d = (SpannableStringBuilder) CanvasView.this.f916ai.getText();
                        int selectionStart = CanvasView.this.f916ai.getSelectionStart();
                        int selectionEnd = CanvasView.this.f916ai.getSelectionEnd();
                        CanvasView.this.f916ai.setText(CanvasView.this.f983d);
                        CanvasView.this.f916ai.setSelection(selectionStart, selectionEnd);
                    }
                }
            }

            @Override // com.samsung.sdraw.TextSettingInfo.InterfaceC0985a
            /* renamed from: c */
            public void mo991c(int i) {
                if (CanvasView.this.f991l != null && CanvasView.this.f991l.setting != null && CanvasView.this.f993n != null) {
                    CanvasView.this.f991l.setting.setMaxTextSize(CanvasView.this.getMaxTextSize());
                    CanvasView.this.f991l.setting.setTextSize(CanvasView.this.f993n.getTextSize());
                    if (!CanvasView.this.f933az) {
                        CanvasView.this.m949k();
                        CanvasView.this.f933az = true;
                    }
                    if (CanvasView.this.isShowTextBox()) {
                        CanvasView.this.f983d = (SpannableStringBuilder) CanvasView.this.f916ai.getText();
                        int selectionStart = CanvasView.this.f916ai.getSelectionStart();
                        int selectionEnd = CanvasView.this.f916ai.getSelectionEnd();
                        CanvasView.this.f916ai.setText(CanvasView.this.f983d);
                        CanvasView.this.f916ai.setSelection(selectionStart, selectionEnd);
                    }
                }
            }

            @Override // com.samsung.sdraw.TextSettingInfo.InterfaceC0985a
            /* renamed from: a */
            public void mo989a(String str) {
                if (CanvasView.this.f991l != null && CanvasView.this.f991l.setting != null && CanvasView.this.f993n != null) {
                    CanvasView.this.f991l.setting.setTextFont(CanvasView.this.f993n.getTextFont());
                    if (!CanvasView.this.f933az) {
                        CanvasView.this.m949k();
                        CanvasView.this.f933az = true;
                    }
                    if (CanvasView.this.isShowTextBox()) {
                        if (!C1040bz.f1671a.containsKey(CanvasView.this.f993n.getTextFont())) {
                            try {
                                CanvasView.this.f916ai.setTypeface(Typeface.createFromFile(C1040bz.f1672b.get(CanvasView.this.f993n.getTextFont())));
                            } catch (Exception e) {
                                CanvasView.this.f916ai.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
                            }
                            C0993af.m1275a("DIOTEK/DRAW", String.format("createTextBox(RectF,Editable,TextInfo) => %s : not cached", String.valueOf(CanvasView.this.f920am) + CanvasView.this.f993n.getTextFont()));
                        } else {
                            CanvasView.this.f916ai.setTypeface(C1040bz.f1671a.get(CanvasView.this.f993n.getTextFont()));
                        }
                        C1040bz c1040bz = new C1040bz(CanvasView.this.f864H, CanvasView.this.f993n.getTextFont());
                        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(CanvasView.this.f916ai.getText().toString());
                        CanvasView.this.m906b(CanvasView.this.f993n.getTextSize());
                        spannableStringBuilder.setSpan(c1040bz, 0, spannableStringBuilder.length(), 18);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(CanvasView.this.f993n.getTextColor()), 0, spannableStringBuilder.length(), 18);
                        spannableStringBuilder.setSpan(CanvasView.this.f908aa[5], 0, spannableStringBuilder.length(), 18);
                        CanvasView.this.setTextAlignment(CanvasView.this.f993n.getTextAlignment());
                        int selectionStart = CanvasView.this.f916ai.getSelectionStart();
                        int selectionEnd = CanvasView.this.f916ai.getSelectionEnd();
                        CanvasView.this.m873a(CanvasView.this.f909ab, true);
                        if ((CanvasView.this.getTextAttribute() & 1) == 1) {
                            spannableStringBuilder.setSpan(CanvasView.this.f908aa[1], 0, spannableStringBuilder.length(), 18);
                        }
                        if ((CanvasView.this.getTextAttribute() & 2) == 2) {
                            spannableStringBuilder.setSpan(CanvasView.this.f908aa[2], 0, spannableStringBuilder.length(), 18);
                        }
                        if ((CanvasView.this.getTextAttribute() & 4) == 4) {
                            spannableStringBuilder.setSpan(CanvasView.this.f908aa[3], 0, spannableStringBuilder.length(), 18);
                        }
                        if ((CanvasView.this.getTextAttribute() & 8) == 8) {
                            spannableStringBuilder.setSpan(CanvasView.this.f908aa[4], 0, spannableStringBuilder.length(), 18);
                        }
                        CanvasView.this.f916ai.setText(spannableStringBuilder);
                        CanvasView.this.f916ai.setSelection(selectionStart, selectionEnd);
                    }
                }
            }

            @Override // com.samsung.sdraw.TextSettingInfo.InterfaceC0985a
            /* renamed from: a */
            public void mo988a(Layout.Alignment alignment) {
                if (CanvasView.this.f991l != null && CanvasView.this.f991l.setting != null && CanvasView.this.f993n != null) {
                    CanvasView.this.f991l.setting.setTextAlignment(CanvasView.this.f993n.getTextAlignment());
                    CanvasView.this.setTextAlignment(CanvasView.this.f993n.getTextAlignment());
                }
            }
        };
        this.f986g = new HashMap<>();
        this.f887aF = true;
        this.f894aM = false;
        this.f895aN = false;
        this.f896aO = false;
        this.f897aP = new View.OnTouchListener() { // from class: com.samsung.sdraw.CanvasView.16
            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                int i;
                int i2;
                if (!CanvasView.this.f894aM && CanvasView.this.f978bw != null) {
                    CanvasView.this.f978bw.onTouch(v, event);
                }
                CanvasView.this.f896aO = CanvasView.this.f903aV.onTouchEvent(event);
                if (CanvasView.this.f896aO) {
                    return true;
                }
                switch (event.getAction()) {
                    case 0:
                        boolean z = false;
                        boolean z2 = false;
                        boolean z3 = false;
                        boolean z4 = false;
                        int height = v.getHeight() - v.getPaddingTop();
                        int width = v.getWidth() - v.getPaddingLeft();
                        CanvasView.this.f888aG = (int) event.getRawX();
                        CanvasView.this.f889aH = (int) event.getRawY();
                        CanvasView.this.f890aI = event.getRawX() - CanvasView.this.f888aG;
                        CanvasView.this.f891aJ = event.getRawY() - CanvasView.this.f889aH;
                        if (v.getPaddingTop() + 5 > event.getY()) {
                            z3 = true;
                        }
                        if (v.getPaddingLeft() + 5 > event.getX()) {
                            z = true;
                        }
                        if (height - 5 < event.getY() + 5.0f) {
                            z4 = true;
                        }
                        if (width - 5 < event.getX() + 5.0f) {
                            z2 = true;
                        }
                        CanvasView.this.f916ai.setVisibility(0);
                        CanvasView.this.f914ag = EnumC0970b.NONE;
                        CanvasView.this.f895aN = true;
                        if (z) {
                            if (z3) {
                                CanvasView.this.f914ag = EnumC0970b.TOP_LEFT;
                            } else if (z4) {
                                CanvasView.this.f914ag = EnumC0970b.BOTTOM_LEFT;
                            } else {
                                CanvasView.this.f914ag = EnumC0970b.LEFT;
                            }
                        } else if (z2) {
                            if (z3) {
                                CanvasView.this.f914ag = EnumC0970b.TOP_RIGHT;
                            } else if (z4) {
                                CanvasView.this.f914ag = EnumC0970b.BOTTOM_RIGHT;
                            } else {
                                CanvasView.this.f914ag = EnumC0970b.RIGHT;
                            }
                        } else if (z3) {
                            CanvasView.this.f914ag = EnumC0970b.TOP;
                        } else if (z4) {
                            CanvasView.this.f914ag = EnumC0970b.BOTTOM;
                        } else {
                            CanvasView.this.f895aN = false;
                            if (CanvasView.this.f940bF && !CanvasView.this.f916ai.isFocusableInTouchMode()) {
                                CanvasView.this.f914ag = EnumC0970b.CENTER;
                            }
                        }
                        if (CanvasView.this.f914ag != EnumC0970b.NONE) {
                            v.cancelLongPress();
                            return true;
                        }
                        return false;
                    case 1:
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) CanvasView.this.f916ai.getLayoutParams();
                        PointF pointFMapToScene = CanvasView.this.f991l.stage.mapToScene(new PointF(layoutParams.leftMargin, layoutParams.topMargin));
                        Rect rect = new Rect(layoutParams.leftMargin, layoutParams.topMargin, layoutParams.width, layoutParams.height);
                        if (CanvasView.this.m888a(rect, true)) {
                            layoutParams.width = rect.right;
                            layoutParams.height = rect.bottom;
                        }
                        if (pointFMapToScene.x < VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
                            layoutParams.width += layoutParams.leftMargin;
                            layoutParams.leftMargin = 0;
                        }
                        if (pointFMapToScene.y < VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
                            layoutParams.height += layoutParams.topMargin;
                            layoutParams.topMargin = 0;
                        }
                        if (pointFMapToScene.x + layoutParams.width > CanvasView.this.f992m.right) {
                            layoutParams.width = CanvasView.this.f992m.right - layoutParams.leftMargin;
                        }
                        if (pointFMapToScene.y + layoutParams.height > CanvasView.this.f992m.bottom) {
                            layoutParams.height = CanvasView.this.f992m.bottom - layoutParams.topMargin;
                        }
                        CanvasView.this.f916ai.setLayoutParams(layoutParams);
                        if (!CanvasView.this.f940bF) {
                            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) CanvasView.this.f865I.getLayoutParams();
                            layoutParams2.leftMargin = layoutParams.leftMargin - CanvasView.this.f866J;
                            layoutParams2.topMargin = (layoutParams.topMargin - CanvasView.this.f867K) + 10;
                            layoutParams2.width = -2;
                            layoutParams2.height = -2;
                            if (layoutParams2.leftMargin < 0) {
                                layoutParams2.leftMargin = (layoutParams.leftMargin + layoutParams.width) - 30;
                            }
                            if (layoutParams2.topMargin < 0) {
                                layoutParams2.topMargin = (layoutParams.topMargin + layoutParams.height) - 20;
                            }
                            if (layoutParams2.leftMargin < CanvasView.this.f992m.left) {
                                layoutParams2.leftMargin = CanvasView.this.f992m.left;
                            }
                            if (layoutParams2.leftMargin + layoutParams2.width > CanvasView.this.f992m.right) {
                                layoutParams2.leftMargin = CanvasView.this.f992m.right - CanvasView.this.f866J;
                            }
                            if (layoutParams2.topMargin < CanvasView.this.f992m.top) {
                                layoutParams2.topMargin = CanvasView.this.f992m.top;
                            }
                            if (layoutParams2.topMargin + layoutParams2.height > CanvasView.this.getBottom()) {
                                layoutParams2.topMargin = CanvasView.this.f992m.bottom - CanvasView.this.f867K;
                            }
                            try {
                                CanvasView.this.f865I.setLayoutParams(layoutParams2);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) CanvasView.this.f870N.getLayoutParams();
                        layoutParams3.leftMargin = (int) ((layoutParams.leftMargin + ((layoutParams.width * CanvasView.this.getScale()) / 2.0f)) - (CanvasView.this.f871O / 2.0f));
                        layoutParams3.topMargin = (int) (((layoutParams.topMargin + ((CanvasView.this.f916ai.getPaddingTop() / 2.0f) * CanvasView.this.getScale())) - CanvasView.this.f872P) - CanvasView.this.f873Q);
                        layoutParams3.width = CanvasView.this.f871O;
                        layoutParams3.height = CanvasView.this.f872P;
                        if (layoutParams3.topMargin >= 0 && layoutParams3.topMargin >= CanvasView.this.getTop()) {
                            CanvasView.this.f870N.setBackgroundDrawable(CanvasView.this.f874R);
                            CanvasView.this.f870N.setPadding(0, -10, 0, 0);
                        } else {
                            layoutParams3.topMargin = (int) (((layoutParams.topMargin + (layoutParams.height * CanvasView.this.getScale())) - ((CanvasView.this.f916ai.getPaddingBottom() / 2.0f) * CanvasView.this.getScale())) + CanvasView.this.f873Q);
                            CanvasView.this.f870N.setBackgroundDrawable(CanvasView.this.f875S);
                            CanvasView.this.f870N.setPadding(0, 10, 0, 0);
                        }
                        if (layoutParams3.topMargin + layoutParams3.height > CanvasView.this.getBottom()) {
                            layoutParams3.topMargin = (int) (((((layoutParams.height * CanvasView.this.getScale()) + layoutParams.topMargin) - (CanvasView.this.f916ai.getPaddingBottom() * CanvasView.this.getScale())) - layoutParams3.height) - CanvasView.this.f873Q);
                            CanvasView.this.f870N.setBackgroundDrawable(CanvasView.this.f874R);
                            CanvasView.this.f870N.setPadding(0, -10, 0, 0);
                        }
                        try {
                            CanvasView.this.f870N.setLayoutParams(layoutParams3);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        if (CanvasView.this.f940bF) {
                            if (!CanvasView.this.f895aN && !CanvasView.this.f916ai.isFocusableInTouchMode()) {
                                CanvasView.this.f916ai.setFocusableInTouchMode(true);
                                CanvasView.this.f894aM = true;
                                event.setAction(0);
                                CanvasView.this.f916ai.onTouchEvent(event);
                                event.setAction(1);
                                CanvasView.this.f916ai.onTouchEvent(event);
                                CanvasView.this.f894aM = false;
                            }
                            CanvasView.this.f895aN = false;
                        }
                        CanvasView.this.f914ag = EnumC0970b.NONE;
                        v.setLongClickable(true);
                        return false;
                    case 2:
                        if (CanvasView.this.f914ag != EnumC0970b.NONE) {
                            RelativeLayout relativeLayout = (RelativeLayout) CanvasView.this.getParent();
                            float scaleX = relativeLayout.getScaleX();
                            float scaleY = relativeLayout.getScaleY();
                            int rawX = (int) event.getRawX();
                            int rawY = (int) event.getRawY();
                            int i3 = (int) ((rawX - CanvasView.this.f888aG) / scaleX);
                            if (i3 != 0) {
                                float rawX2 = event.getRawX() - rawX;
                                CanvasView canvasView = CanvasView.this;
                                canvasView.f892aK = ((rawX2 - CanvasView.this.f890aI) / scaleX) + canvasView.f892aK;
                                if (CanvasView.this.f892aK >= 1.0f) {
                                    CanvasView.this.f892aK -= 1.0f;
                                    i = i3 + 1;
                                } else {
                                    if (CanvasView.this.f890aI <= -1.0f) {
                                        i3--;
                                        CanvasView.this.f892aK -= -1.0f;
                                    }
                                    i = i3;
                                }
                            } else {
                                i = i3;
                            }
                            int i4 = (int) ((rawY - CanvasView.this.f889aH) / scaleY);
                            if (i4 != 0) {
                                float rawY2 = event.getRawY() - rawY;
                                CanvasView canvasView2 = CanvasView.this;
                                canvasView2.f893aL = ((rawY2 - CanvasView.this.f891aJ) / scaleY) + canvasView2.f893aL;
                                if (CanvasView.this.f893aL >= 1.0f) {
                                    CanvasView.this.f893aL -= 1.0f;
                                    i2 = i4 + 1;
                                } else {
                                    if (CanvasView.this.f893aL <= -1.0f) {
                                        i4--;
                                        CanvasView.this.f893aL -= -1.0f;
                                    }
                                    i2 = i4;
                                }
                            } else {
                                i2 = i4;
                            }
                            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) CanvasView.this.f916ai.getLayoutParams();
                            Rect rect2 = new Rect(layoutParams4.leftMargin, layoutParams4.topMargin, layoutParams4.width, layoutParams4.height);
                            if (CanvasView.this.f914ag == EnumC0970b.LEFT || CanvasView.this.f914ag == EnumC0970b.TOP_LEFT || CanvasView.this.f914ag == EnumC0970b.BOTTOM_LEFT) {
                                int i5 = layoutParams4.leftMargin + i;
                                int iRound = Math.round((rect2.left - i5) / CanvasView.this.getScale());
                                int paddingLeft = CanvasView.this.f916ai.getPaddingLeft() + CanvasView.this.f916ai.getPaddingRight();
                                rect2.right += iRound;
                                if (rect2.right > (CanvasView.this.f993n.getTextSize() * 4) + paddingLeft) {
                                    layoutParams4.leftMargin = i5;
                                    rect2.left = i5;
                                    layoutParams4.width += iRound;
                                    rect2.right += iRound;
                                }
                                rect2.right -= iRound;
                                if (rect2.right < (CanvasView.this.f993n.getTextSize() * 4) + paddingLeft) {
                                    rect2.right = (CanvasView.this.f993n.getTextSize() * 4) + paddingLeft;
                                }
                            }
                            if (CanvasView.this.f914ag == EnumC0970b.RIGHT || CanvasView.this.f914ag == EnumC0970b.TOP_RIGHT || CanvasView.this.f914ag == EnumC0970b.BOTTOM_RIGHT) {
                                rect2.right = layoutParams4.width + i;
                                int paddingLeft2 = CanvasView.this.f916ai.getPaddingLeft() + CanvasView.this.f916ai.getPaddingRight();
                                if (rect2.right < (CanvasView.this.f993n.getTextSize() * 4) + paddingLeft2) {
                                    rect2.right = paddingLeft2 + (CanvasView.this.f993n.getTextSize() * 4);
                                }
                            }
                            if (CanvasView.this.f914ag == EnumC0970b.TOP || CanvasView.this.f914ag == EnumC0970b.TOP_LEFT || CanvasView.this.f914ag == EnumC0970b.TOP_RIGHT) {
                                int i6 = layoutParams4.topMargin + i2;
                                int iRound2 = Math.round((rect2.top - i6) / CanvasView.this.getScale());
                                TextPaint textPaint = new TextPaint();
                                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(CanvasView.this.f916ai.getText());
                                if (spannableStringBuilder.length() <= 0) {
                                    if (CanvasView.this.f1001v != null) {
                                        spannableStringBuilder.append((CharSequence) CanvasView.this.f1001v.m783d());
                                    } else {
                                        spannableStringBuilder.append((CharSequence) "Insert Text");
                                    }
                                }
                                if ((layoutParams4.height + iRound2) - (CanvasView.this.f916ai.getPaddingTop() + CanvasView.this.f916ai.getPaddingBottom()) > new DynamicLayout(spannableStringBuilder, textPaint, rect2.right - (CanvasView.this.f916ai.getPaddingLeft() + CanvasView.this.f916ai.getPaddingRight()), CanvasView.this.f916ai.getLayout() == null ? null : CanvasView.this.f916ai.getLayout().getAlignment(), 1.0f, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, false).getHeight()) {
                                    layoutParams4.topMargin = i6;
                                    rect2.top = i6;
                                    rect2.bottom += iRound2;
                                    layoutParams4.height += iRound2;
                                    if (layoutParams4.topMargin < CanvasView.this.f913af.top) {
                                        rect2.bottom -= Math.round((CanvasView.this.f913af.top - layoutParams4.topMargin) / CanvasView.this.getScale());
                                        layoutParams4.height -= Math.round((CanvasView.this.f913af.top - layoutParams4.topMargin) / CanvasView.this.getScale());
                                        layoutParams4.topMargin = (int) CanvasView.this.f913af.top;
                                        rect2.top = (int) CanvasView.this.f913af.top;
                                    }
                                }
                            }
                            if (CanvasView.this.f914ag == EnumC0970b.BOTTOM || CanvasView.this.f914ag == EnumC0970b.BOTTOM_LEFT || CanvasView.this.f914ag == EnumC0970b.BOTTOM_RIGHT) {
                                rect2.bottom = layoutParams4.height + i2;
                                if (rect2.bottom < 100) {
                                    rect2.bottom = 100;
                                }
                            }
                            PointF pointFMapToScene2 = CanvasView.this.f991l.stage.mapToScene(new PointF(layoutParams4.leftMargin, layoutParams4.topMargin));
                            if (CanvasView.this.f914ag != EnumC0970b.CENTER) {
                                if (CanvasView.this.m888a(rect2, false)) {
                                    layoutParams4.width = rect2.right;
                                    layoutParams4.height = rect2.bottom;
                                }
                                if (pointFMapToScene2.x < CanvasView.this.f992m.left) {
                                    layoutParams4.width = rect2.right;
                                    layoutParams4.leftMargin = CanvasView.this.f992m.left;
                                }
                                if (pointFMapToScene2.y < CanvasView.this.f992m.top) {
                                    layoutParams4.height = rect2.bottom;
                                    layoutParams4.topMargin = CanvasView.this.f992m.top;
                                }
                                if (pointFMapToScene2.x + layoutParams4.width > CanvasView.this.f992m.right) {
                                    layoutParams4.width = (int) (CanvasView.this.f992m.right - pointFMapToScene2.x);
                                }
                                if (pointFMapToScene2.y + layoutParams4.height > CanvasView.this.f992m.bottom) {
                                    layoutParams4.height = (int) (CanvasView.this.f992m.bottom - pointFMapToScene2.y);
                                }
                            } else {
                                if (CanvasView.this.f940bF && !CanvasView.this.f895aN) {
                                    if (i > 5 || i < -5 || i2 > 5 || i2 < -5) {
                                        CanvasView.this.f895aN = true;
                                    } else {
                                        return false;
                                    }
                                }
                                RectF rectF = new RectF(CanvasView.this.f992m);
                                rectF.left -= CanvasView.this.getLeft();
                                rectF.top -= CanvasView.this.getTop();
                                rectF.right -= CanvasView.this.getLeft();
                                rectF.bottom -= CanvasView.this.getTop();
                                rectF.offset((-rectF.left) * 2.0f, (-rectF.top) * 2.0f);
                                if (pointFMapToScene2.x + i < rectF.left + ((CanvasView.this.f916ai.getPaddingLeft() / 6.0f) * CanvasView.this.getScale())) {
                                    layoutParams4.leftMargin += (int) ((rectF.left + ((CanvasView.this.f916ai.getPaddingLeft() / 6.0f) * CanvasView.this.getScale())) - pointFMapToScene2.x);
                                    layoutParams4.rightMargin = 0;
                                } else if (pointFMapToScene2.x + layoutParams4.width + i > rectF.right) {
                                    layoutParams4.rightMargin = (int) (pointFMapToScene2.x + (layoutParams4.width * CanvasView.this.getScale()));
                                } else {
                                    layoutParams4.leftMargin += i;
                                    if (((int) pointFMapToScene2.x) + layoutParams4.width > rectF.right) {
                                        layoutParams4.rightMargin = ((int) pointFMapToScene2.x) + layoutParams4.width;
                                    } else {
                                        layoutParams4.rightMargin = (-((int) pointFMapToScene2.x)) - layoutParams4.width;
                                    }
                                }
                                if (pointFMapToScene2.y + i2 < rectF.top + ((CanvasView.this.f916ai.getPaddingTop() / 6.0f) * CanvasView.this.getScale())) {
                                    layoutParams4.topMargin = (int) (((rectF.top + ((CanvasView.this.f916ai.getPaddingTop() / 6.0f) * CanvasView.this.getScale())) - pointFMapToScene2.y) + layoutParams4.topMargin);
                                    layoutParams4.bottomMargin = 0;
                                } else if (pointFMapToScene2.y + layoutParams4.height + i2 > rectF.bottom) {
                                    layoutParams4.bottomMargin = (int) ((layoutParams4.topMargin + (layoutParams4.height * CanvasView.this.getScale())) - 1.0f);
                                } else {
                                    layoutParams4.topMargin += i2;
                                    if (layoutParams4.topMargin + layoutParams4.height > rectF.bottom) {
                                        layoutParams4.bottomMargin = (int) (layoutParams4.topMargin + (layoutParams4.height * CanvasView.this.getScale()));
                                    } else {
                                        layoutParams4.bottomMargin = (-((int) pointFMapToScene2.y)) - layoutParams4.height;
                                    }
                                }
                            }
                            CanvasView.this.f888aG = (int) event.getRawX();
                            CanvasView.this.f889aH = (int) event.getRawY();
                            CanvasView.this.f890aI = event.getRawX() - CanvasView.this.f888aG;
                            CanvasView.this.f891aJ = event.getRawY() - CanvasView.this.f889aH;
                            CanvasView.this.f916ai.setLayoutParams(layoutParams4);
                            if (!CanvasView.this.f940bF) {
                                RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) CanvasView.this.f865I.getLayoutParams();
                                layoutParams5.leftMargin = layoutParams4.leftMargin - CanvasView.this.f866J;
                                layoutParams5.topMargin = (layoutParams4.topMargin - CanvasView.this.f867K) + 10;
                                layoutParams5.width = -2;
                                layoutParams5.height = -2;
                                if (layoutParams5.leftMargin < 0) {
                                    layoutParams5.leftMargin = (layoutParams4.leftMargin + layoutParams4.width) - 30;
                                }
                                if (layoutParams5.topMargin < 0) {
                                    layoutParams5.topMargin = (layoutParams4.topMargin + layoutParams4.height) - 20;
                                }
                                if (layoutParams5.leftMargin < CanvasView.this.f913af.left) {
                                    layoutParams5.leftMargin = (int) CanvasView.this.f913af.left;
                                }
                                if (layoutParams5.leftMargin + layoutParams5.width > CanvasView.this.f913af.right) {
                                    layoutParams5.leftMargin = (int) (CanvasView.this.f913af.right - CanvasView.this.f866J);
                                }
                                if (layoutParams5.topMargin < CanvasView.this.f913af.top) {
                                    layoutParams5.topMargin = (int) CanvasView.this.f913af.top;
                                }
                                if (layoutParams5.topMargin + layoutParams5.height > CanvasView.this.getBottom()) {
                                    layoutParams5.topMargin = (int) (CanvasView.this.f913af.bottom - CanvasView.this.f867K);
                                }
                                try {
                                    CanvasView.this.f865I.setLayoutParams(layoutParams5);
                                } catch (Exception e3) {
                                    e3.printStackTrace();
                                }
                            }
                            RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) CanvasView.this.f870N.getLayoutParams();
                            layoutParams6.leftMargin = (int) ((layoutParams4.leftMargin + ((layoutParams4.width * CanvasView.this.getScale()) / 2.0f)) - (CanvasView.this.f871O / 2.0f));
                            layoutParams6.topMargin = (int) (((layoutParams4.topMargin + ((CanvasView.this.f916ai.getPaddingTop() / 2.0f) * CanvasView.this.getScale())) - CanvasView.this.f872P) - CanvasView.this.f873Q);
                            layoutParams6.width = CanvasView.this.f871O;
                            layoutParams6.height = CanvasView.this.f872P;
                            if (layoutParams6.topMargin >= 0 && layoutParams6.topMargin >= CanvasView.this.getTop()) {
                                CanvasView.this.f870N.setBackgroundDrawable(CanvasView.this.f874R);
                                CanvasView.this.f870N.setPadding(0, -10, 0, 0);
                            } else {
                                layoutParams6.topMargin = (int) (((layoutParams4.topMargin + (layoutParams4.height * CanvasView.this.getScale())) - ((CanvasView.this.f916ai.getPaddingBottom() / 2.0f) * CanvasView.this.getScale())) + CanvasView.this.f873Q);
                                CanvasView.this.f870N.setBackgroundDrawable(CanvasView.this.f875S);
                                CanvasView.this.f870N.setPadding(0, 10, 0, 0);
                            }
                            if (layoutParams6.topMargin + layoutParams6.height > CanvasView.this.getBottom()) {
                                layoutParams6.topMargin = (int) ((((layoutParams4.topMargin + (layoutParams4.height * CanvasView.this.getScale())) - (CanvasView.this.f916ai.getPaddingBottom() * CanvasView.this.getScale())) - layoutParams6.height) - CanvasView.this.f873Q);
                                CanvasView.this.f870N.setBackgroundDrawable(CanvasView.this.f874R);
                                CanvasView.this.f870N.setPadding(0, -10, 0, 0);
                            }
                            if (layoutParams6.leftMargin + layoutParams6.width > CanvasView.this.getRight()) {
                                layoutParams6.rightMargin = CanvasView.this.getRight() + (CanvasView.this.getRight() - layoutParams6.leftMargin);
                            } else {
                                layoutParams6.rightMargin = 0;
                            }
                            try {
                                CanvasView.this.f870N.setLayoutParams(layoutParams6);
                            } catch (Exception e4) {
                                e4.printStackTrace();
                            }
                            return true;
                        }
                        return false;
                    default:
                        return false;
                }
            }
        };
        this.f898aQ = new View.OnFocusChangeListener() { // from class: com.samsung.sdraw.CanvasView.17
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View v, boolean hasFocus) {
                InputMethodManager inputMethodManager = (InputMethodManager) CanvasView.this.getContext().getSystemService("input_method");
                if (hasFocus) {
                    inputMethodManager.showSoftInput(v, 0);
                } else {
                    inputMethodManager.hideSoftInputFromWindow(CanvasView.this.getWindowToken(), 0);
                }
            }
        };
        this.f899aR = 0;
        this.f900aS = new TextWatcher() { // from class: com.samsung.sdraw.CanvasView.18
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Layout.Alignment alignment;
                if (!CanvasView.this.f912ae) {
                    CanvasView.this.f911ad = new SpannableStringBuilder(CanvasView.this.f916ai.getText());
                }
                CanvasView.this.f912ae = false;
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(CanvasView.this.f916ai.getText());
                if (spannableStringBuilder.length() <= 0) {
                    if (CanvasView.this.f1001v != null) {
                        spannableStringBuilder.append((CharSequence) CanvasView.this.f1001v.m783d());
                    } else {
                        spannableStringBuilder.append((CharSequence) "Insert Text");
                    }
                    spannableStringBuilder.setSpan(new AbsoluteSizeSpan(40), 0, spannableStringBuilder.length(), 18);
                }
                CanvasView canvasView = CanvasView.this;
                TextPaint paint = CanvasView.this.f916ai.getPaint();
                int iMax = Math.max(1, CanvasView.this.f916ai.getWidth() - (CanvasView.this.f916ai.getPaddingLeft() + CanvasView.this.f916ai.getPaddingRight()));
                if (CanvasView.this.f916ai.getLayout() != null) {
                    alignment = CanvasView.this.f916ai.getLayout().getAlignment();
                } else {
                    alignment = null;
                }
                canvasView.f899aR = new DynamicLayout(spannableStringBuilder, paint, iMax, alignment, 1.0f, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, false).getLineCount();
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                DynamicLayout dynamicLayout;
                int lineCount;
                if (CanvasView.this.f916ai.getWidth() > 0) {
                    CanvasView.this.f916ai.setFilters(new InputFilter[]{new C0991ad(CanvasView.this.getContext(), 128)});
                    CanvasView.this.m913c(((ForegroundColorSpan) CanvasView.this.f908aa[0]).getForegroundColor());
                    CanvasView.this.m873a(CanvasView.this.f991l.setting.getTextType(), true);
                    CanvasView.this.setTextAlignment(CanvasView.this.f991l.setting.getTextAlignment());
                    CanvasView.this.m906b(CanvasView.this.f991l.setting.getTextSize());
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) CanvasView.this.f916ai.getLayoutParams();
                    int textSize = 10;
                    if (CanvasView.this.f993n != null) {
                        textSize = CanvasView.this.f993n.getTextSize();
                    }
                    if (CanvasView.this.f916ai.getText() != null) {
                        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(CanvasView.this.f916ai.getText());
                        if (spannableStringBuilder.length() <= 0) {
                            if (CanvasView.this.f1001v != null) {
                                spannableStringBuilder.append((CharSequence) CanvasView.this.f1001v.m783d());
                            } else {
                                spannableStringBuilder.append((CharSequence) "Insert Text");
                            }
                            spannableStringBuilder.setSpan(new AbsoluteSizeSpan(40), 0, spannableStringBuilder.length(), 18);
                        }
                        int paddingLeft = CanvasView.this.f916ai.getPaddingLeft() + CanvasView.this.f916ai.getPaddingRight();
                        if (layoutParams.width < (textSize * 4) + paddingLeft) {
                            layoutParams.width = (textSize * 4) + paddingLeft;
                            CanvasView.this.f916ai.setLayoutParams(layoutParams);
                        }
                        if (CanvasView.this.f916ai.getLayoutParams().width <= CanvasView.this.f916ai.getPaddingLeft() + CanvasView.this.f916ai.getPaddingRight()) {
                            dynamicLayout = new DynamicLayout(spannableStringBuilder, CanvasView.this.f916ai.getPaint(), CanvasView.this.f916ai.getWidth() - (CanvasView.this.f916ai.getPaddingLeft() + CanvasView.this.f916ai.getPaddingRight()), CanvasView.this.f916ai.getLayout() != null ? CanvasView.this.f916ai.getLayout().getAlignment() : null, 1.0f, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, false);
                        } else {
                            dynamicLayout = new DynamicLayout(spannableStringBuilder, CanvasView.this.f916ai.getPaint(), CanvasView.this.f916ai.getLayoutParams().width - (CanvasView.this.f916ai.getPaddingLeft() + CanvasView.this.f916ai.getPaddingRight()), CanvasView.this.f916ai.getLayout() != null ? CanvasView.this.f916ai.getLayout().getAlignment() : null, 1.0f, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, false);
                        }
                        lineCount = dynamicLayout.getLineCount();
                    } else {
                        dynamicLayout = null;
                        lineCount = 0;
                    }
                    if (lineCount != CanvasView.this.f899aR && lineCount > 0 && dynamicLayout != null) {
                        Rect rect = new Rect();
                        int paddingBottom = CanvasView.this.f916ai.getPaddingBottom() + CanvasView.this.f916ai.getPaddingTop();
                        dynamicLayout.getLineBounds(lineCount - 1, rect);
                        if (rect.bottom + paddingBottom < CanvasView.this.f880Z) {
                            layoutParams.height = rect.bottom + paddingBottom;
                            if (layoutParams.height > CanvasView.this.f880Z) {
                                layoutParams.height = (int) (CanvasView.this.f880Z - 10.0f);
                            }
                            CanvasView.this.f916ai.setLayoutParams(layoutParams);
                        } else if (rect.bottom + paddingBottom + CanvasView.this.f991l.setting.getCanvasRect().top >= CanvasView.this.f991l.setting.getCanvasRect().height() || CanvasView.this.f916ai.getHeight() >= rect.bottom + paddingBottom) {
                            if (CanvasView.this.f911ad.length() != s.length() && !CanvasView.this.f879W) {
                                CanvasView.this.f912ae = true;
                            }
                        } else {
                            Rect rect2 = new Rect();
                            CanvasView.this.f916ai.getLineBounds(0, rect2);
                            layoutParams.topMargin -= rect2.height();
                            if (layoutParams.topMargin < 0) {
                                layoutParams.topMargin = 0;
                            }
                            CanvasView.this.f880Z = (CanvasView.this.f991l.setting.getCanvasRect().height() - layoutParams.topMargin) - CanvasView.this.f991l.setting.getCanvasRect().top;
                            layoutParams.height = (int) (CanvasView.this.f880Z - 10.0f);
                            CanvasView.this.f916ai.setLayoutParams(layoutParams);
                        }
                        if (!CanvasView.this.f940bF) {
                            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) CanvasView.this.f865I.getLayoutParams();
                            layoutParams2.leftMargin = layoutParams.leftMargin - CanvasView.this.f866J;
                            layoutParams2.topMargin = (layoutParams.topMargin - CanvasView.this.f867K) + 10;
                            layoutParams2.width = -2;
                            layoutParams2.height = -2;
                            if (layoutParams2.leftMargin < 0) {
                                layoutParams2.leftMargin = (layoutParams.leftMargin + layoutParams.width) - 40;
                            }
                            if (layoutParams2.topMargin < 0) {
                                layoutParams2.topMargin = (layoutParams.topMargin + layoutParams.height) - 30;
                            }
                            if (layoutParams2.leftMargin < CanvasView.this.f913af.left) {
                                layoutParams2.leftMargin = (int) CanvasView.this.f913af.left;
                            }
                            if (layoutParams2.leftMargin + layoutParams2.width > CanvasView.this.f913af.right) {
                                layoutParams2.leftMargin = (int) (CanvasView.this.f913af.right - CanvasView.this.f866J);
                            }
                            if (layoutParams2.topMargin < CanvasView.this.f913af.top) {
                                layoutParams2.topMargin = (int) CanvasView.this.f913af.top;
                            }
                            if (layoutParams2.topMargin + layoutParams2.height > CanvasView.this.getBottom()) {
                                layoutParams2.topMargin = (int) (CanvasView.this.f913af.bottom - CanvasView.this.f867K);
                            }
                            try {
                                CanvasView.this.f865I.setLayoutParams(layoutParams2);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) CanvasView.this.f870N.getLayoutParams();
                        layoutParams3.leftMargin = (int) ((layoutParams.leftMargin + ((layoutParams.width * CanvasView.this.getScale()) / 2.0f)) - (CanvasView.this.f871O / 2.0f));
                        layoutParams3.topMargin = (int) (((layoutParams.topMargin + ((CanvasView.this.f916ai.getPaddingTop() / 2.0f) * CanvasView.this.getScale())) - CanvasView.this.f872P) - CanvasView.this.f873Q);
                        layoutParams3.width = CanvasView.this.f871O;
                        layoutParams3.height = CanvasView.this.f872P;
                        if (layoutParams3.topMargin >= 0 && layoutParams3.topMargin >= CanvasView.this.getTop()) {
                            CanvasView.this.f870N.setBackgroundDrawable(CanvasView.this.f874R);
                            CanvasView.this.f870N.setPadding(0, -10, 0, 0);
                        } else {
                            layoutParams3.topMargin = (int) (((layoutParams.topMargin + (layoutParams.height * CanvasView.this.getScale())) - ((CanvasView.this.f916ai.getPaddingBottom() / 2.0f) * CanvasView.this.getScale())) + CanvasView.this.f873Q);
                            CanvasView.this.f870N.setBackgroundDrawable(CanvasView.this.f875S);
                            CanvasView.this.f870N.setPadding(0, 10, 0, 0);
                        }
                        if (layoutParams3.topMargin + layoutParams3.height > CanvasView.this.getBottom()) {
                            layoutParams3.topMargin = (int) ((((layoutParams.topMargin + (layoutParams.height * CanvasView.this.getScale())) - (CanvasView.this.f916ai.getPaddingBottom() * CanvasView.this.getScale())) - layoutParams3.height) - CanvasView.this.f873Q);
                            CanvasView.this.f870N.setBackgroundDrawable(CanvasView.this.f874R);
                            CanvasView.this.f870N.setPadding(0, -10, 0, 0);
                        }
                        try {
                            CanvasView.this.f870N.setLayoutParams(layoutParams3);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
        };
        this.f903aV = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.samsung.sdraw.CanvasView.19
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent e) {
                return !CanvasView.this.f954bT;
            }
        });
        this.f904aW = new View.OnLongClickListener() { // from class: com.samsung.sdraw.CanvasView.20
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View arg0) {
                return !CanvasView.this.f953bS;
            }
        };
        this.f987h = false;
        this.f988i = false;
        this.f905aX = new View.OnTouchListener() { // from class: com.samsung.sdraw.CanvasView.2
            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                int rawX = (int) event.getRawX();
                int rawY = (int) event.getRawY();
                switch (event.getAction()) {
                    case 0:
                        CanvasView.this.f868L = (int) event.getRawX();
                        CanvasView.this.f869M = (int) event.getRawY();
                        CanvasView.this.f916ai.clearFocus();
                        return false;
                    case 1:
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) CanvasView.this.f916ai.getLayoutParams();
                        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) CanvasView.this.f865I.getLayoutParams();
                        CanvasView.this.f987h = false;
                        CanvasView.this.f988i = false;
                        layoutParams2.leftMargin = layoutParams.leftMargin - CanvasView.this.f866J;
                        layoutParams2.topMargin = (layoutParams.topMargin - CanvasView.this.f867K) + 10;
                        if (layoutParams2.leftMargin < 0) {
                            CanvasView.this.f987h = true;
                            layoutParams2.leftMargin = (layoutParams.leftMargin + layoutParams.width) - 30;
                        }
                        if (layoutParams2.topMargin < 0) {
                            CanvasView.this.f988i = true;
                            layoutParams2.topMargin = (layoutParams.topMargin + layoutParams.height) - 20;
                        }
                        CanvasView.this.f865I.setLayoutParams(layoutParams2);
                        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) CanvasView.this.f870N.getLayoutParams();
                        layoutParams3.leftMargin = (int) ((layoutParams.leftMargin + ((layoutParams.width * CanvasView.this.getScale()) / 2.0f)) - (CanvasView.this.f871O / 2.0f));
                        layoutParams3.topMargin = (int) (((layoutParams.topMargin + ((CanvasView.this.f916ai.getPaddingTop() / 2.0f) * CanvasView.this.getScale())) - CanvasView.this.f872P) - CanvasView.this.f873Q);
                        layoutParams3.width = CanvasView.this.f871O;
                        layoutParams3.height = CanvasView.this.f872P;
                        if (layoutParams3.topMargin >= 0 && layoutParams3.topMargin >= CanvasView.this.getTop()) {
                            CanvasView.this.f870N.setBackgroundDrawable(CanvasView.this.f874R);
                            CanvasView.this.f870N.setPadding(0, -10, 0, 0);
                        } else {
                            layoutParams3.topMargin = (int) (((layoutParams.topMargin + (layoutParams.height * CanvasView.this.getScale())) - ((CanvasView.this.f916ai.getPaddingBottom() / 2.0f) * CanvasView.this.getScale())) + CanvasView.this.f873Q);
                            CanvasView.this.f870N.setBackgroundDrawable(CanvasView.this.f875S);
                            CanvasView.this.f870N.setPadding(0, 10, 0, 0);
                        }
                        if (layoutParams3.topMargin + layoutParams3.height > CanvasView.this.getBottom()) {
                            layoutParams3.topMargin = (int) (((((layoutParams.height * CanvasView.this.getScale()) + layoutParams.topMargin) - (CanvasView.this.f916ai.getPaddingBottom() * CanvasView.this.getScale())) - layoutParams3.height) - CanvasView.this.f873Q);
                            CanvasView.this.f870N.setBackgroundDrawable(CanvasView.this.f874R);
                            CanvasView.this.f870N.setPadding(0, -10, 0, 0);
                        }
                        try {
                            CanvasView.this.f870N.setLayoutParams(layoutParams3);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        return false;
                    case 2:
                        float f = rawX - CanvasView.this.f868L;
                        float f2 = rawY - CanvasView.this.f869M;
                        RectF rectF = new RectF(CanvasView.this.f913af);
                        rectF.left -= CanvasView.this.getLeft();
                        rectF.top -= CanvasView.this.getTop();
                        rectF.right -= CanvasView.this.getLeft();
                        rectF.bottom -= CanvasView.this.getTop();
                        rectF.offset((-rectF.left) * 2.0f, (-rectF.top) * 2.0f);
                        rectF.right = rectF.left + Math.min(rectF.width(), CanvasView.this.getWidth());
                        rectF.bottom = rectF.top + Math.min(rectF.height(), CanvasView.this.getHeight());
                        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) CanvasView.this.f916ai.getLayoutParams();
                        RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) CanvasView.this.f865I.getLayoutParams();
                        if (layoutParams4.leftMargin + f < rectF.left) {
                            layoutParams4.leftMargin = (int) rectF.left;
                        } else if (layoutParams4.leftMargin + layoutParams4.width + f > rectF.right) {
                            layoutParams4.leftMargin = (int) (rectF.right - layoutParams4.width);
                        } else {
                            layoutParams4.leftMargin = (int) (f + layoutParams4.leftMargin);
                        }
                        if (layoutParams4.topMargin + f2 < rectF.top) {
                            layoutParams4.topMargin = (int) rectF.top;
                        } else if (layoutParams4.topMargin + layoutParams4.height + f2 > rectF.bottom) {
                            layoutParams4.topMargin = (int) (rectF.bottom - layoutParams4.height);
                        } else {
                            layoutParams4.topMargin = (int) (layoutParams4.topMargin + f2);
                        }
                        if (layoutParams4.topMargin + layoutParams4.height >= CanvasView.this.getHeight()) {
                            layoutParams4.topMargin = CanvasView.this.getHeight() - layoutParams4.height;
                        }
                        layoutParams5.leftMargin = layoutParams4.leftMargin - CanvasView.this.f866J;
                        layoutParams5.topMargin = (layoutParams4.topMargin - CanvasView.this.f867K) + 10;
                        layoutParams5.width = -2;
                        layoutParams5.height = -2;
                        if (CanvasView.this.f987h) {
                            layoutParams5.leftMargin = (layoutParams4.leftMargin + layoutParams4.width) - 30;
                            if (layoutParams5.leftMargin + CanvasView.this.f865I.getWidth() > CanvasView.this.f913af.width()) {
                                layoutParams5.leftMargin = ((int) CanvasView.this.f913af.width()) - CanvasView.this.f865I.getWidth();
                            }
                        }
                        if (CanvasView.this.f988i) {
                            layoutParams5.topMargin = (layoutParams4.topMargin + layoutParams4.height) - 20;
                            if (layoutParams5.topMargin + CanvasView.this.f865I.getHeight() > CanvasView.this.f913af.height()) {
                                layoutParams5.topMargin = ((int) CanvasView.this.f913af.height()) - CanvasView.this.f865I.getHeight();
                            }
                        }
                        CanvasView.this.f868L = rawX;
                        CanvasView.this.f869M = rawY;
                        CanvasView.this.f865I.setLayoutParams(layoutParams5);
                        CanvasView.this.f916ai.setLayoutParams(layoutParams4);
                        RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) CanvasView.this.f870N.getLayoutParams();
                        layoutParams6.leftMargin = (int) ((layoutParams4.leftMargin + ((layoutParams4.width * CanvasView.this.getScale()) / 2.0f)) - (CanvasView.this.f871O / 2.0f));
                        layoutParams6.topMargin = (int) (((layoutParams4.topMargin + ((CanvasView.this.f916ai.getPaddingTop() / 2.0f) * CanvasView.this.getScale())) - CanvasView.this.f872P) - CanvasView.this.f873Q);
                        layoutParams6.width = CanvasView.this.f871O;
                        layoutParams6.height = CanvasView.this.f872P;
                        if (layoutParams6.topMargin >= 0 && layoutParams6.topMargin >= CanvasView.this.getTop()) {
                            CanvasView.this.f870N.setBackgroundDrawable(CanvasView.this.f874R);
                            CanvasView.this.f870N.setPadding(0, -10, 0, 0);
                        } else {
                            layoutParams6.topMargin = (int) (((layoutParams4.topMargin + (layoutParams4.height * CanvasView.this.getScale())) - ((CanvasView.this.f916ai.getPaddingBottom() / 2.0f) * CanvasView.this.getScale())) + CanvasView.this.f873Q);
                            CanvasView.this.f870N.setBackgroundDrawable(CanvasView.this.f875S);
                            CanvasView.this.f870N.setPadding(0, 10, 0, 0);
                        }
                        if (layoutParams6.topMargin + layoutParams6.height > CanvasView.this.getBottom()) {
                            layoutParams6.topMargin = (int) (((((layoutParams4.height * CanvasView.this.getScale()) + layoutParams4.topMargin) - (CanvasView.this.f916ai.getPaddingBottom() * CanvasView.this.getScale())) - layoutParams6.height) - CanvasView.this.f873Q);
                            CanvasView.this.f870N.setBackgroundDrawable(CanvasView.this.f874R);
                            CanvasView.this.f870N.setPadding(0, -10, 0, 0);
                        }
                        try {
                            CanvasView.this.f870N.setLayoutParams(layoutParams6);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        return false;
                    default:
                        return false;
                }
            }
        };
        this.f906aY = new View.OnTouchListener() { // from class: com.samsung.sdraw.CanvasView.3
            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                PointF pointFMapToScene = CanvasView.this.f991l.stage.mapToScene(new PointF(event.getX(), event.getY()));
                switch (event.getAction()) {
                    case 0:
                        CanvasView.this.f876T = true;
                        return false;
                    case 1:
                        if (CanvasView.this.f876T) {
                            CanvasView.this.f870N.playSoundEffect(0);
                            CanvasView.this.deleteSelectedObject();
                            CanvasView.this.m970a(v);
                        }
                        return false;
                    case 2:
                        if (!new Rect(0, 0, CanvasView.this.f870N.getWidth(), CanvasView.this.f870N.getHeight()).contains((int) pointFMapToScene.x, (int) pointFMapToScene.y)) {
                            CanvasView.this.f876T = false;
                        }
                        return false;
                    default:
                        return false;
                }
            }
        };
        this.f907aZ = new TextMode.OnTextSelectedListener() { // from class: com.samsung.sdraw.CanvasView.4
            @Override // com.samsung.sdraw.TextMode.OnTextSelectedListener
            public void onTextSelected(ObjectInfo objectInfo, boolean bSelected) {
                if (CanvasView.this.f968bm == null) {
                    return;
                }
                CanvasView.this.f968bm.onObjectSelected(objectInfo, bSelected);
            }
        };
        this.f956ba = new SelectMode.OnImageSelectedListener() { // from class: com.samsung.sdraw.CanvasView.5
            @Override // com.samsung.sdraw.SelectMode.OnImageSelectedListener
            public void onImageSelected(ObjectInfo objectInfo, boolean bSelected) {
                if (CanvasView.this.f968bm == null) {
                    return;
                }
                CanvasView.this.f968bm.onObjectSelected(objectInfo, bSelected);
            }
        };
        this.f957bb = null;
        this.f958bc = null;
        this.f959bd = true;
        this.f960be = false;
        this.f961bf = 0;
        this.f962bg = 0;
        this.f964bi = false;
        this.f965bj = new Handler() { // from class: com.samsung.sdraw.CanvasView.6
            @Override // android.os.Handler
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case 2:
                        if (!CanvasView.this.f976bu) {
                            CanvasView.this.f964bi = true;
                            break;
                        }
                        break;
                    case 3:
                        int userID = CanvasView.this.getUserID();
                        CanvasView.this.f991l.stage.addSprite((C1063s) msg.obj, true, userID);
                        CanvasView.this.f991l.stage.clearLayer(CanvasView.this.f991l.modes.get(Integer.valueOf(userID)).getLayerID(CanvasView.this.f991l));
                        CanvasView.this.f991l.stage.renderSprites(CanvasView.this.f991l.modes.get(Integer.valueOf(userID)).getLayerID(CanvasView.this.f991l));
                        CanvasView.this.f991l.invalidate();
                        break;
                }
                super.handleMessage(msg);
            }
        };
        this.f966bk = new Stage.OnSpriteChangeListener() { // from class: com.samsung.sdraw.CanvasView.7
            @Override // com.samsung.sdraw.Stage.OnSpriteChangeListener
            public void onObjectDeleted(ObjectInfo objectInfo, boolean byUndo, boolean byRedo, boolean bFreeMemory) {
                if (CanvasView.this.f968bm == null) {
                    return;
                }
                CanvasView.this.f968bm.onObjectDeleted(objectInfo, byUndo, byRedo, bFreeMemory);
            }

            @Override // com.samsung.sdraw.Stage.OnSpriteChangeListener
            public void onSpriteChanged(boolean undoable, boolean redoable) {
            }

            @Override // com.samsung.sdraw.Stage.OnSpriteChangeListener
            public void onObjectChanged(ObjectInfo objectInfo, boolean byUndo, boolean byRedo) {
                if (CanvasView.this.f968bm == null) {
                    return;
                }
                CanvasView.this.f968bm.onObjectChanged(objectInfo, byUndo, byRedo);
            }

            @Override // com.samsung.sdraw.Stage.OnSpriteChangeListener
            public void onObjectInserted(ObjectInfo objectInfo, boolean byUndo, boolean byRedo) {
                if (CanvasView.this.f968bm == null) {
                    return;
                }
                CanvasView.this.f968bm.onObjectInserted(objectInfo, byUndo, byRedo);
            }

            @Override // com.samsung.sdraw.Stage.OnSpriteChangeListener
            public boolean onStrokeInserting(StrokeInfo strokeInfo) {
                if (CanvasView.this.f968bm != null) {
                    return CanvasView.this.f968bm.onStrokeInserting(strokeInfo);
                }
                return false;
            }

            @Override // com.samsung.sdraw.Stage.OnSpriteChangeListener
            public void onMultiClearAll(boolean undo) {
                if (CanvasView.this.f936bB == null) {
                    return;
                }
                CanvasView.this.f936bB.m993a(undo);
            }
        };
        this.f970bo = false;
        this.f971bp = false;
        this.f972bq = false;
        this.f989j = new AbstractSettingView.InterfaceC0948a() { // from class: com.samsung.sdraw.CanvasView.8
            @Override // com.samsung.sdraw.AbstractSettingView.InterfaceC0948a
            /* renamed from: c */
            public void mo808c(boolean z) {
                if (CanvasView.this.f969bn != null) {
                    CanvasView.this.f969bn.onTextSettingViewShow(z);
                }
                if (!CanvasView.this.f971bp) {
                    CanvasView.this.f1001v.m775a(CanvasView.this.f993n);
                    CanvasView.this.f971bp = true;
                }
            }

            @Override // com.samsung.sdraw.AbstractSettingView.InterfaceC0948a
            /* renamed from: a */
            public void mo806a(boolean z) {
                if (CanvasView.this.f969bn != null) {
                    CanvasView.this.f969bn.onPenSettingViewShow(z);
                }
                if (!CanvasView.this.f970bo) {
                    CanvasView.this.f1001v.m774a(CanvasView.this.f881a);
                    CanvasView.this.f970bo = true;
                }
            }

            @Override // com.samsung.sdraw.AbstractSettingView.InterfaceC0948a
            /* renamed from: b */
            public void mo807b(boolean z) {
                if (CanvasView.this.f969bn != null) {
                    CanvasView.this.f969bn.onEraserSettingViewShow(z);
                }
                if (!CanvasView.this.f970bo) {
                    CanvasView.this.f1001v.m774a(CanvasView.this.f881a);
                    if (CanvasView.this.getMode() == 2) {
                        CanvasView.this.m974a(true);
                    }
                    CanvasView.this.f970bo = true;
                }
            }

            @Override // com.samsung.sdraw.AbstractSettingView.InterfaceC0948a
            /* renamed from: d */
            public void mo809d(boolean z) {
                if (CanvasView.this.f969bn != null) {
                    CanvasView.this.f969bn.onFillingSettingViewShow(z);
                }
                if (!CanvasView.this.f972bq) {
                    CanvasView.this.f1001v.m773a(CanvasView.this.f994o);
                    CanvasView.this.f972bq = true;
                }
            }
        };
        this.f973br = false;
        this.f974bs = null;
        this.f990k = false;
        this.f975bt = false;
        this.f976bu = true;
        this.f977bv = true;
        this.f979bx = null;
        this.f937bC = true;
        this.f938bD = false;
        this.f939bE = false;
        this.f940bF = true;
        this.f941bG = 1.0f;
        this.f942bH = false;
        this.f943bI = 0;
        this.f944bJ = null;
        this.f945bK = null;
        this.f946bL = false;
        this.f948bN = true;
        this.f949bO = 200;
        this.f950bP = 200;
        this.f951bQ = true;
        this.f952bR = true;
        this.f953bS = true;
        this.f954bT = true;
        this.f955bU = false;
        this.f864H = context;
        m928f();
    }

    public CanvasView(Context context, AttributeSet attrs, int defStyle) throws IOException {
        super(context, attrs, defStyle);
        this.f995p = -1;
        this.f997r = false;
        this.f1002w = false;
        this.f1003x = 1;
        this.f857A = false;
        this.f861E = new Rect();
        this.f862F = new Rect();
        this.f863G = false;
        this.f876T = false;
        this.f877U = false;
        this.f879W = false;
        this.f908aa = new Object[7];
        this.f909ab = 0;
        this.f910ac = Layout.Alignment.ALIGN_NORMAL;
        this.f913af = new RectF(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, 800.0f, 480.0f);
        this.f915ah = false;
        this.f917aj = false;
        this.f984e = "";
        this.f920am = "/system/fonts/";
        this.f921an = getContext().getResources().getDisplayMetrics();
        this.f922ao = "Delete";
        this.f985f = false;
        this.f926as = 10;
        this.f927at = false;
        this.f928au = false;
        this.f929av = 0;
        this.f930aw = true;
        this.f931ax = false;
        this.f932ay = false;
        this.f933az = false;
        this.f883aB = new C0988aa.b() { // from class: com.samsung.sdraw.CanvasView.1
            @Override // com.samsung.sdraw.C0988aa.b
            /* renamed from: a */
            public void mo980a(Matrix matrix) {
                CanvasView.this.f991l.m674a(matrix);
                if (CanvasView.this.f958bc != null) {
                    CanvasView.this.f958bc.onMatrixChanged(matrix);
                }
                mo979a();
            }

            @Override // com.samsung.sdraw.C0988aa.b
            /* renamed from: a */
            public void mo979a() {
                CanvasView.this.invalidate();
            }
        };
        this.f884aC = new PenSettingInfo.InterfaceC0976a() { // from class: com.samsung.sdraw.CanvasView.12
            @Override // com.samsung.sdraw.PenSettingInfo.InterfaceC0976a
            /* renamed from: a */
            public void mo982a(int i, int i2) {
                if (CanvasView.this.f991l != null && CanvasView.this.f991l.setting != null && CanvasView.this.f881a != null) {
                    CanvasView.this.f991l.setting.setStrokeWidth(CanvasView.this.f881a.getPenWidth());
                }
                if (CanvasView.this.f991l != null) {
                    CanvasView.this.f991l.invalidate();
                }
            }

            @Override // com.samsung.sdraw.PenSettingInfo.InterfaceC0976a
            /* renamed from: a */
            public void mo981a(int i) {
                CanvasView.this.m871a(i);
                if (CanvasView.this.f991l != null) {
                    CanvasView.this.f991l.invalidate();
                }
            }

            @Override // com.samsung.sdraw.PenSettingInfo.InterfaceC0976a
            /* renamed from: b */
            public void mo984b(int i, int i2) {
                if (CanvasView.this.f991l != null && CanvasView.this.f991l.setting != null && CanvasView.this.f881a != null) {
                    CanvasView.this.f991l.setting.setStrokeColor(CanvasView.this.f881a.getPenAlphaColor());
                }
                if (CanvasView.this.f991l != null) {
                    CanvasView.this.f991l.invalidate();
                }
            }

            @Override // com.samsung.sdraw.PenSettingInfo.InterfaceC0976a
            /* renamed from: c */
            public void mo985c(int i, int i2) {
                if (CanvasView.this.f991l != null && CanvasView.this.f991l.setting != null && CanvasView.this.f881a != null) {
                    CanvasView.this.f991l.setting.setStrokeColor(CanvasView.this.f881a.getPenAlphaColor());
                }
                if (CanvasView.this.f991l != null) {
                    CanvasView.this.f991l.invalidate();
                }
            }

            @Override // com.samsung.sdraw.PenSettingInfo.InterfaceC0976a
            /* renamed from: b */
            public void mo983b(int i) {
                if (CanvasView.this.f991l != null && CanvasView.this.f991l.setting != null && CanvasView.this.f881a != null && CanvasView.this.getMode() == 2) {
                    CanvasView.this.f991l.setting.setEraserWidth(CanvasView.this.f881a.getEraserWidth());
                }
                if (CanvasView.this.f991l != null) {
                    CanvasView.this.f991l.invalidate();
                }
            }
        };
        this.f885aD = new FillingSettingInfo.InterfaceC0973a() { // from class: com.samsung.sdraw.CanvasView.14
            @Override // com.samsung.sdraw.FillingSettingInfo.InterfaceC0973a
            /* renamed from: a */
            public void mo986a(int i) {
                if (CanvasView.this.f991l != null && CanvasView.this.f991l.setting != null && CanvasView.this.f994o != null) {
                    CanvasView.this.f991l.setting.setFillingColor(CanvasView.this.f994o.getFillingColor());
                }
                if (CanvasView.this.f991l != null) {
                    CanvasView.this.f991l.invalidate();
                }
            }
        };
        this.f886aE = new TextSettingInfo.InterfaceC0985a() { // from class: com.samsung.sdraw.CanvasView.15
            @Override // com.samsung.sdraw.TextSettingInfo.InterfaceC0985a
            /* renamed from: a */
            public void mo987a(int i) {
                if (CanvasView.this.f991l != null && CanvasView.this.f991l.setting != null && CanvasView.this.f993n != null && CanvasView.this.f916ai != null) {
                    CanvasView.this.f991l.setting.setTextType(CanvasView.this.f993n.getTextType());
                    CanvasView.this.f909ab = CanvasView.this.f993n.getTextType();
                    CanvasView.this.m873a(CanvasView.this.f993n.getTextType(), true);
                }
            }

            @Override // com.samsung.sdraw.TextSettingInfo.InterfaceC0985a
            /* renamed from: b */
            public void mo990b(int i) {
                if (CanvasView.this.f991l != null && CanvasView.this.f991l.setting != null && CanvasView.this.f993n != null) {
                    CanvasView.this.f991l.setting.setTextColor(CanvasView.this.f993n.getTextColor());
                    if (!CanvasView.this.f933az) {
                        CanvasView.this.m949k();
                        CanvasView.this.f933az = true;
                    }
                    if (CanvasView.this.isShowTextBox()) {
                        CanvasView.this.f983d = (SpannableStringBuilder) CanvasView.this.f916ai.getText();
                        int selectionStart = CanvasView.this.f916ai.getSelectionStart();
                        int selectionEnd = CanvasView.this.f916ai.getSelectionEnd();
                        CanvasView.this.f916ai.setText(CanvasView.this.f983d);
                        CanvasView.this.f916ai.setSelection(selectionStart, selectionEnd);
                    }
                }
            }

            @Override // com.samsung.sdraw.TextSettingInfo.InterfaceC0985a
            /* renamed from: c */
            public void mo991c(int i) {
                if (CanvasView.this.f991l != null && CanvasView.this.f991l.setting != null && CanvasView.this.f993n != null) {
                    CanvasView.this.f991l.setting.setMaxTextSize(CanvasView.this.getMaxTextSize());
                    CanvasView.this.f991l.setting.setTextSize(CanvasView.this.f993n.getTextSize());
                    if (!CanvasView.this.f933az) {
                        CanvasView.this.m949k();
                        CanvasView.this.f933az = true;
                    }
                    if (CanvasView.this.isShowTextBox()) {
                        CanvasView.this.f983d = (SpannableStringBuilder) CanvasView.this.f916ai.getText();
                        int selectionStart = CanvasView.this.f916ai.getSelectionStart();
                        int selectionEnd = CanvasView.this.f916ai.getSelectionEnd();
                        CanvasView.this.f916ai.setText(CanvasView.this.f983d);
                        CanvasView.this.f916ai.setSelection(selectionStart, selectionEnd);
                    }
                }
            }

            @Override // com.samsung.sdraw.TextSettingInfo.InterfaceC0985a
            /* renamed from: a */
            public void mo989a(String str) {
                if (CanvasView.this.f991l != null && CanvasView.this.f991l.setting != null && CanvasView.this.f993n != null) {
                    CanvasView.this.f991l.setting.setTextFont(CanvasView.this.f993n.getTextFont());
                    if (!CanvasView.this.f933az) {
                        CanvasView.this.m949k();
                        CanvasView.this.f933az = true;
                    }
                    if (CanvasView.this.isShowTextBox()) {
                        if (!C1040bz.f1671a.containsKey(CanvasView.this.f993n.getTextFont())) {
                            try {
                                CanvasView.this.f916ai.setTypeface(Typeface.createFromFile(C1040bz.f1672b.get(CanvasView.this.f993n.getTextFont())));
                            } catch (Exception e) {
                                CanvasView.this.f916ai.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
                            }
                            C0993af.m1275a("DIOTEK/DRAW", String.format("createTextBox(RectF,Editable,TextInfo) => %s : not cached", String.valueOf(CanvasView.this.f920am) + CanvasView.this.f993n.getTextFont()));
                        } else {
                            CanvasView.this.f916ai.setTypeface(C1040bz.f1671a.get(CanvasView.this.f993n.getTextFont()));
                        }
                        C1040bz c1040bz = new C1040bz(CanvasView.this.f864H, CanvasView.this.f993n.getTextFont());
                        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(CanvasView.this.f916ai.getText().toString());
                        CanvasView.this.m906b(CanvasView.this.f993n.getTextSize());
                        spannableStringBuilder.setSpan(c1040bz, 0, spannableStringBuilder.length(), 18);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(CanvasView.this.f993n.getTextColor()), 0, spannableStringBuilder.length(), 18);
                        spannableStringBuilder.setSpan(CanvasView.this.f908aa[5], 0, spannableStringBuilder.length(), 18);
                        CanvasView.this.setTextAlignment(CanvasView.this.f993n.getTextAlignment());
                        int selectionStart = CanvasView.this.f916ai.getSelectionStart();
                        int selectionEnd = CanvasView.this.f916ai.getSelectionEnd();
                        CanvasView.this.m873a(CanvasView.this.f909ab, true);
                        if ((CanvasView.this.getTextAttribute() & 1) == 1) {
                            spannableStringBuilder.setSpan(CanvasView.this.f908aa[1], 0, spannableStringBuilder.length(), 18);
                        }
                        if ((CanvasView.this.getTextAttribute() & 2) == 2) {
                            spannableStringBuilder.setSpan(CanvasView.this.f908aa[2], 0, spannableStringBuilder.length(), 18);
                        }
                        if ((CanvasView.this.getTextAttribute() & 4) == 4) {
                            spannableStringBuilder.setSpan(CanvasView.this.f908aa[3], 0, spannableStringBuilder.length(), 18);
                        }
                        if ((CanvasView.this.getTextAttribute() & 8) == 8) {
                            spannableStringBuilder.setSpan(CanvasView.this.f908aa[4], 0, spannableStringBuilder.length(), 18);
                        }
                        CanvasView.this.f916ai.setText(spannableStringBuilder);
                        CanvasView.this.f916ai.setSelection(selectionStart, selectionEnd);
                    }
                }
            }

            @Override // com.samsung.sdraw.TextSettingInfo.InterfaceC0985a
            /* renamed from: a */
            public void mo988a(Layout.Alignment alignment) {
                if (CanvasView.this.f991l != null && CanvasView.this.f991l.setting != null && CanvasView.this.f993n != null) {
                    CanvasView.this.f991l.setting.setTextAlignment(CanvasView.this.f993n.getTextAlignment());
                    CanvasView.this.setTextAlignment(CanvasView.this.f993n.getTextAlignment());
                }
            }
        };
        this.f986g = new HashMap<>();
        this.f887aF = true;
        this.f894aM = false;
        this.f895aN = false;
        this.f896aO = false;
        this.f897aP = new View.OnTouchListener() { // from class: com.samsung.sdraw.CanvasView.16
            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                int i;
                int i2;
                if (!CanvasView.this.f894aM && CanvasView.this.f978bw != null) {
                    CanvasView.this.f978bw.onTouch(v, event);
                }
                CanvasView.this.f896aO = CanvasView.this.f903aV.onTouchEvent(event);
                if (CanvasView.this.f896aO) {
                    return true;
                }
                switch (event.getAction()) {
                    case 0:
                        boolean z = false;
                        boolean z2 = false;
                        boolean z3 = false;
                        boolean z4 = false;
                        int height = v.getHeight() - v.getPaddingTop();
                        int width = v.getWidth() - v.getPaddingLeft();
                        CanvasView.this.f888aG = (int) event.getRawX();
                        CanvasView.this.f889aH = (int) event.getRawY();
                        CanvasView.this.f890aI = event.getRawX() - CanvasView.this.f888aG;
                        CanvasView.this.f891aJ = event.getRawY() - CanvasView.this.f889aH;
                        if (v.getPaddingTop() + 5 > event.getY()) {
                            z3 = true;
                        }
                        if (v.getPaddingLeft() + 5 > event.getX()) {
                            z = true;
                        }
                        if (height - 5 < event.getY() + 5.0f) {
                            z4 = true;
                        }
                        if (width - 5 < event.getX() + 5.0f) {
                            z2 = true;
                        }
                        CanvasView.this.f916ai.setVisibility(0);
                        CanvasView.this.f914ag = EnumC0970b.NONE;
                        CanvasView.this.f895aN = true;
                        if (z) {
                            if (z3) {
                                CanvasView.this.f914ag = EnumC0970b.TOP_LEFT;
                            } else if (z4) {
                                CanvasView.this.f914ag = EnumC0970b.BOTTOM_LEFT;
                            } else {
                                CanvasView.this.f914ag = EnumC0970b.LEFT;
                            }
                        } else if (z2) {
                            if (z3) {
                                CanvasView.this.f914ag = EnumC0970b.TOP_RIGHT;
                            } else if (z4) {
                                CanvasView.this.f914ag = EnumC0970b.BOTTOM_RIGHT;
                            } else {
                                CanvasView.this.f914ag = EnumC0970b.RIGHT;
                            }
                        } else if (z3) {
                            CanvasView.this.f914ag = EnumC0970b.TOP;
                        } else if (z4) {
                            CanvasView.this.f914ag = EnumC0970b.BOTTOM;
                        } else {
                            CanvasView.this.f895aN = false;
                            if (CanvasView.this.f940bF && !CanvasView.this.f916ai.isFocusableInTouchMode()) {
                                CanvasView.this.f914ag = EnumC0970b.CENTER;
                            }
                        }
                        if (CanvasView.this.f914ag != EnumC0970b.NONE) {
                            v.cancelLongPress();
                            return true;
                        }
                        return false;
                    case 1:
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) CanvasView.this.f916ai.getLayoutParams();
                        PointF pointFMapToScene = CanvasView.this.f991l.stage.mapToScene(new PointF(layoutParams.leftMargin, layoutParams.topMargin));
                        Rect rect = new Rect(layoutParams.leftMargin, layoutParams.topMargin, layoutParams.width, layoutParams.height);
                        if (CanvasView.this.m888a(rect, true)) {
                            layoutParams.width = rect.right;
                            layoutParams.height = rect.bottom;
                        }
                        if (pointFMapToScene.x < VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
                            layoutParams.width += layoutParams.leftMargin;
                            layoutParams.leftMargin = 0;
                        }
                        if (pointFMapToScene.y < VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
                            layoutParams.height += layoutParams.topMargin;
                            layoutParams.topMargin = 0;
                        }
                        if (pointFMapToScene.x + layoutParams.width > CanvasView.this.f992m.right) {
                            layoutParams.width = CanvasView.this.f992m.right - layoutParams.leftMargin;
                        }
                        if (pointFMapToScene.y + layoutParams.height > CanvasView.this.f992m.bottom) {
                            layoutParams.height = CanvasView.this.f992m.bottom - layoutParams.topMargin;
                        }
                        CanvasView.this.f916ai.setLayoutParams(layoutParams);
                        if (!CanvasView.this.f940bF) {
                            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) CanvasView.this.f865I.getLayoutParams();
                            layoutParams2.leftMargin = layoutParams.leftMargin - CanvasView.this.f866J;
                            layoutParams2.topMargin = (layoutParams.topMargin - CanvasView.this.f867K) + 10;
                            layoutParams2.width = -2;
                            layoutParams2.height = -2;
                            if (layoutParams2.leftMargin < 0) {
                                layoutParams2.leftMargin = (layoutParams.leftMargin + layoutParams.width) - 30;
                            }
                            if (layoutParams2.topMargin < 0) {
                                layoutParams2.topMargin = (layoutParams.topMargin + layoutParams.height) - 20;
                            }
                            if (layoutParams2.leftMargin < CanvasView.this.f992m.left) {
                                layoutParams2.leftMargin = CanvasView.this.f992m.left;
                            }
                            if (layoutParams2.leftMargin + layoutParams2.width > CanvasView.this.f992m.right) {
                                layoutParams2.leftMargin = CanvasView.this.f992m.right - CanvasView.this.f866J;
                            }
                            if (layoutParams2.topMargin < CanvasView.this.f992m.top) {
                                layoutParams2.topMargin = CanvasView.this.f992m.top;
                            }
                            if (layoutParams2.topMargin + layoutParams2.height > CanvasView.this.getBottom()) {
                                layoutParams2.topMargin = CanvasView.this.f992m.bottom - CanvasView.this.f867K;
                            }
                            try {
                                CanvasView.this.f865I.setLayoutParams(layoutParams2);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) CanvasView.this.f870N.getLayoutParams();
                        layoutParams3.leftMargin = (int) ((layoutParams.leftMargin + ((layoutParams.width * CanvasView.this.getScale()) / 2.0f)) - (CanvasView.this.f871O / 2.0f));
                        layoutParams3.topMargin = (int) (((layoutParams.topMargin + ((CanvasView.this.f916ai.getPaddingTop() / 2.0f) * CanvasView.this.getScale())) - CanvasView.this.f872P) - CanvasView.this.f873Q);
                        layoutParams3.width = CanvasView.this.f871O;
                        layoutParams3.height = CanvasView.this.f872P;
                        if (layoutParams3.topMargin >= 0 && layoutParams3.topMargin >= CanvasView.this.getTop()) {
                            CanvasView.this.f870N.setBackgroundDrawable(CanvasView.this.f874R);
                            CanvasView.this.f870N.setPadding(0, -10, 0, 0);
                        } else {
                            layoutParams3.topMargin = (int) (((layoutParams.topMargin + (layoutParams.height * CanvasView.this.getScale())) - ((CanvasView.this.f916ai.getPaddingBottom() / 2.0f) * CanvasView.this.getScale())) + CanvasView.this.f873Q);
                            CanvasView.this.f870N.setBackgroundDrawable(CanvasView.this.f875S);
                            CanvasView.this.f870N.setPadding(0, 10, 0, 0);
                        }
                        if (layoutParams3.topMargin + layoutParams3.height > CanvasView.this.getBottom()) {
                            layoutParams3.topMargin = (int) (((((layoutParams.height * CanvasView.this.getScale()) + layoutParams.topMargin) - (CanvasView.this.f916ai.getPaddingBottom() * CanvasView.this.getScale())) - layoutParams3.height) - CanvasView.this.f873Q);
                            CanvasView.this.f870N.setBackgroundDrawable(CanvasView.this.f874R);
                            CanvasView.this.f870N.setPadding(0, -10, 0, 0);
                        }
                        try {
                            CanvasView.this.f870N.setLayoutParams(layoutParams3);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        if (CanvasView.this.f940bF) {
                            if (!CanvasView.this.f895aN && !CanvasView.this.f916ai.isFocusableInTouchMode()) {
                                CanvasView.this.f916ai.setFocusableInTouchMode(true);
                                CanvasView.this.f894aM = true;
                                event.setAction(0);
                                CanvasView.this.f916ai.onTouchEvent(event);
                                event.setAction(1);
                                CanvasView.this.f916ai.onTouchEvent(event);
                                CanvasView.this.f894aM = false;
                            }
                            CanvasView.this.f895aN = false;
                        }
                        CanvasView.this.f914ag = EnumC0970b.NONE;
                        v.setLongClickable(true);
                        return false;
                    case 2:
                        if (CanvasView.this.f914ag != EnumC0970b.NONE) {
                            RelativeLayout relativeLayout = (RelativeLayout) CanvasView.this.getParent();
                            float scaleX = relativeLayout.getScaleX();
                            float scaleY = relativeLayout.getScaleY();
                            int rawX = (int) event.getRawX();
                            int rawY = (int) event.getRawY();
                            int i3 = (int) ((rawX - CanvasView.this.f888aG) / scaleX);
                            if (i3 != 0) {
                                float rawX2 = event.getRawX() - rawX;
                                CanvasView canvasView = CanvasView.this;
                                canvasView.f892aK = ((rawX2 - CanvasView.this.f890aI) / scaleX) + canvasView.f892aK;
                                if (CanvasView.this.f892aK >= 1.0f) {
                                    CanvasView.this.f892aK -= 1.0f;
                                    i = i3 + 1;
                                } else {
                                    if (CanvasView.this.f890aI <= -1.0f) {
                                        i3--;
                                        CanvasView.this.f892aK -= -1.0f;
                                    }
                                    i = i3;
                                }
                            } else {
                                i = i3;
                            }
                            int i4 = (int) ((rawY - CanvasView.this.f889aH) / scaleY);
                            if (i4 != 0) {
                                float rawY2 = event.getRawY() - rawY;
                                CanvasView canvasView2 = CanvasView.this;
                                canvasView2.f893aL = ((rawY2 - CanvasView.this.f891aJ) / scaleY) + canvasView2.f893aL;
                                if (CanvasView.this.f893aL >= 1.0f) {
                                    CanvasView.this.f893aL -= 1.0f;
                                    i2 = i4 + 1;
                                } else {
                                    if (CanvasView.this.f893aL <= -1.0f) {
                                        i4--;
                                        CanvasView.this.f893aL -= -1.0f;
                                    }
                                    i2 = i4;
                                }
                            } else {
                                i2 = i4;
                            }
                            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) CanvasView.this.f916ai.getLayoutParams();
                            Rect rect2 = new Rect(layoutParams4.leftMargin, layoutParams4.topMargin, layoutParams4.width, layoutParams4.height);
                            if (CanvasView.this.f914ag == EnumC0970b.LEFT || CanvasView.this.f914ag == EnumC0970b.TOP_LEFT || CanvasView.this.f914ag == EnumC0970b.BOTTOM_LEFT) {
                                int i5 = layoutParams4.leftMargin + i;
                                int iRound = Math.round((rect2.left - i5) / CanvasView.this.getScale());
                                int paddingLeft = CanvasView.this.f916ai.getPaddingLeft() + CanvasView.this.f916ai.getPaddingRight();
                                rect2.right += iRound;
                                if (rect2.right > (CanvasView.this.f993n.getTextSize() * 4) + paddingLeft) {
                                    layoutParams4.leftMargin = i5;
                                    rect2.left = i5;
                                    layoutParams4.width += iRound;
                                    rect2.right += iRound;
                                }
                                rect2.right -= iRound;
                                if (rect2.right < (CanvasView.this.f993n.getTextSize() * 4) + paddingLeft) {
                                    rect2.right = (CanvasView.this.f993n.getTextSize() * 4) + paddingLeft;
                                }
                            }
                            if (CanvasView.this.f914ag == EnumC0970b.RIGHT || CanvasView.this.f914ag == EnumC0970b.TOP_RIGHT || CanvasView.this.f914ag == EnumC0970b.BOTTOM_RIGHT) {
                                rect2.right = layoutParams4.width + i;
                                int paddingLeft2 = CanvasView.this.f916ai.getPaddingLeft() + CanvasView.this.f916ai.getPaddingRight();
                                if (rect2.right < (CanvasView.this.f993n.getTextSize() * 4) + paddingLeft2) {
                                    rect2.right = paddingLeft2 + (CanvasView.this.f993n.getTextSize() * 4);
                                }
                            }
                            if (CanvasView.this.f914ag == EnumC0970b.TOP || CanvasView.this.f914ag == EnumC0970b.TOP_LEFT || CanvasView.this.f914ag == EnumC0970b.TOP_RIGHT) {
                                int i6 = layoutParams4.topMargin + i2;
                                int iRound2 = Math.round((rect2.top - i6) / CanvasView.this.getScale());
                                TextPaint textPaint = new TextPaint();
                                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(CanvasView.this.f916ai.getText());
                                if (spannableStringBuilder.length() <= 0) {
                                    if (CanvasView.this.f1001v != null) {
                                        spannableStringBuilder.append((CharSequence) CanvasView.this.f1001v.m783d());
                                    } else {
                                        spannableStringBuilder.append((CharSequence) "Insert Text");
                                    }
                                }
                                if ((layoutParams4.height + iRound2) - (CanvasView.this.f916ai.getPaddingTop() + CanvasView.this.f916ai.getPaddingBottom()) > new DynamicLayout(spannableStringBuilder, textPaint, rect2.right - (CanvasView.this.f916ai.getPaddingLeft() + CanvasView.this.f916ai.getPaddingRight()), CanvasView.this.f916ai.getLayout() == null ? null : CanvasView.this.f916ai.getLayout().getAlignment(), 1.0f, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, false).getHeight()) {
                                    layoutParams4.topMargin = i6;
                                    rect2.top = i6;
                                    rect2.bottom += iRound2;
                                    layoutParams4.height += iRound2;
                                    if (layoutParams4.topMargin < CanvasView.this.f913af.top) {
                                        rect2.bottom -= Math.round((CanvasView.this.f913af.top - layoutParams4.topMargin) / CanvasView.this.getScale());
                                        layoutParams4.height -= Math.round((CanvasView.this.f913af.top - layoutParams4.topMargin) / CanvasView.this.getScale());
                                        layoutParams4.topMargin = (int) CanvasView.this.f913af.top;
                                        rect2.top = (int) CanvasView.this.f913af.top;
                                    }
                                }
                            }
                            if (CanvasView.this.f914ag == EnumC0970b.BOTTOM || CanvasView.this.f914ag == EnumC0970b.BOTTOM_LEFT || CanvasView.this.f914ag == EnumC0970b.BOTTOM_RIGHT) {
                                rect2.bottom = layoutParams4.height + i2;
                                if (rect2.bottom < 100) {
                                    rect2.bottom = 100;
                                }
                            }
                            PointF pointFMapToScene2 = CanvasView.this.f991l.stage.mapToScene(new PointF(layoutParams4.leftMargin, layoutParams4.topMargin));
                            if (CanvasView.this.f914ag != EnumC0970b.CENTER) {
                                if (CanvasView.this.m888a(rect2, false)) {
                                    layoutParams4.width = rect2.right;
                                    layoutParams4.height = rect2.bottom;
                                }
                                if (pointFMapToScene2.x < CanvasView.this.f992m.left) {
                                    layoutParams4.width = rect2.right;
                                    layoutParams4.leftMargin = CanvasView.this.f992m.left;
                                }
                                if (pointFMapToScene2.y < CanvasView.this.f992m.top) {
                                    layoutParams4.height = rect2.bottom;
                                    layoutParams4.topMargin = CanvasView.this.f992m.top;
                                }
                                if (pointFMapToScene2.x + layoutParams4.width > CanvasView.this.f992m.right) {
                                    layoutParams4.width = (int) (CanvasView.this.f992m.right - pointFMapToScene2.x);
                                }
                                if (pointFMapToScene2.y + layoutParams4.height > CanvasView.this.f992m.bottom) {
                                    layoutParams4.height = (int) (CanvasView.this.f992m.bottom - pointFMapToScene2.y);
                                }
                            } else {
                                if (CanvasView.this.f940bF && !CanvasView.this.f895aN) {
                                    if (i > 5 || i < -5 || i2 > 5 || i2 < -5) {
                                        CanvasView.this.f895aN = true;
                                    } else {
                                        return false;
                                    }
                                }
                                RectF rectF = new RectF(CanvasView.this.f992m);
                                rectF.left -= CanvasView.this.getLeft();
                                rectF.top -= CanvasView.this.getTop();
                                rectF.right -= CanvasView.this.getLeft();
                                rectF.bottom -= CanvasView.this.getTop();
                                rectF.offset((-rectF.left) * 2.0f, (-rectF.top) * 2.0f);
                                if (pointFMapToScene2.x + i < rectF.left + ((CanvasView.this.f916ai.getPaddingLeft() / 6.0f) * CanvasView.this.getScale())) {
                                    layoutParams4.leftMargin += (int) ((rectF.left + ((CanvasView.this.f916ai.getPaddingLeft() / 6.0f) * CanvasView.this.getScale())) - pointFMapToScene2.x);
                                    layoutParams4.rightMargin = 0;
                                } else if (pointFMapToScene2.x + layoutParams4.width + i > rectF.right) {
                                    layoutParams4.rightMargin = (int) (pointFMapToScene2.x + (layoutParams4.width * CanvasView.this.getScale()));
                                } else {
                                    layoutParams4.leftMargin += i;
                                    if (((int) pointFMapToScene2.x) + layoutParams4.width > rectF.right) {
                                        layoutParams4.rightMargin = ((int) pointFMapToScene2.x) + layoutParams4.width;
                                    } else {
                                        layoutParams4.rightMargin = (-((int) pointFMapToScene2.x)) - layoutParams4.width;
                                    }
                                }
                                if (pointFMapToScene2.y + i2 < rectF.top + ((CanvasView.this.f916ai.getPaddingTop() / 6.0f) * CanvasView.this.getScale())) {
                                    layoutParams4.topMargin = (int) (((rectF.top + ((CanvasView.this.f916ai.getPaddingTop() / 6.0f) * CanvasView.this.getScale())) - pointFMapToScene2.y) + layoutParams4.topMargin);
                                    layoutParams4.bottomMargin = 0;
                                } else if (pointFMapToScene2.y + layoutParams4.height + i2 > rectF.bottom) {
                                    layoutParams4.bottomMargin = (int) ((layoutParams4.topMargin + (layoutParams4.height * CanvasView.this.getScale())) - 1.0f);
                                } else {
                                    layoutParams4.topMargin += i2;
                                    if (layoutParams4.topMargin + layoutParams4.height > rectF.bottom) {
                                        layoutParams4.bottomMargin = (int) (layoutParams4.topMargin + (layoutParams4.height * CanvasView.this.getScale()));
                                    } else {
                                        layoutParams4.bottomMargin = (-((int) pointFMapToScene2.y)) - layoutParams4.height;
                                    }
                                }
                            }
                            CanvasView.this.f888aG = (int) event.getRawX();
                            CanvasView.this.f889aH = (int) event.getRawY();
                            CanvasView.this.f890aI = event.getRawX() - CanvasView.this.f888aG;
                            CanvasView.this.f891aJ = event.getRawY() - CanvasView.this.f889aH;
                            CanvasView.this.f916ai.setLayoutParams(layoutParams4);
                            if (!CanvasView.this.f940bF) {
                                RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) CanvasView.this.f865I.getLayoutParams();
                                layoutParams5.leftMargin = layoutParams4.leftMargin - CanvasView.this.f866J;
                                layoutParams5.topMargin = (layoutParams4.topMargin - CanvasView.this.f867K) + 10;
                                layoutParams5.width = -2;
                                layoutParams5.height = -2;
                                if (layoutParams5.leftMargin < 0) {
                                    layoutParams5.leftMargin = (layoutParams4.leftMargin + layoutParams4.width) - 30;
                                }
                                if (layoutParams5.topMargin < 0) {
                                    layoutParams5.topMargin = (layoutParams4.topMargin + layoutParams4.height) - 20;
                                }
                                if (layoutParams5.leftMargin < CanvasView.this.f913af.left) {
                                    layoutParams5.leftMargin = (int) CanvasView.this.f913af.left;
                                }
                                if (layoutParams5.leftMargin + layoutParams5.width > CanvasView.this.f913af.right) {
                                    layoutParams5.leftMargin = (int) (CanvasView.this.f913af.right - CanvasView.this.f866J);
                                }
                                if (layoutParams5.topMargin < CanvasView.this.f913af.top) {
                                    layoutParams5.topMargin = (int) CanvasView.this.f913af.top;
                                }
                                if (layoutParams5.topMargin + layoutParams5.height > CanvasView.this.getBottom()) {
                                    layoutParams5.topMargin = (int) (CanvasView.this.f913af.bottom - CanvasView.this.f867K);
                                }
                                try {
                                    CanvasView.this.f865I.setLayoutParams(layoutParams5);
                                } catch (Exception e3) {
                                    e3.printStackTrace();
                                }
                            }
                            RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) CanvasView.this.f870N.getLayoutParams();
                            layoutParams6.leftMargin = (int) ((layoutParams4.leftMargin + ((layoutParams4.width * CanvasView.this.getScale()) / 2.0f)) - (CanvasView.this.f871O / 2.0f));
                            layoutParams6.topMargin = (int) (((layoutParams4.topMargin + ((CanvasView.this.f916ai.getPaddingTop() / 2.0f) * CanvasView.this.getScale())) - CanvasView.this.f872P) - CanvasView.this.f873Q);
                            layoutParams6.width = CanvasView.this.f871O;
                            layoutParams6.height = CanvasView.this.f872P;
                            if (layoutParams6.topMargin >= 0 && layoutParams6.topMargin >= CanvasView.this.getTop()) {
                                CanvasView.this.f870N.setBackgroundDrawable(CanvasView.this.f874R);
                                CanvasView.this.f870N.setPadding(0, -10, 0, 0);
                            } else {
                                layoutParams6.topMargin = (int) (((layoutParams4.topMargin + (layoutParams4.height * CanvasView.this.getScale())) - ((CanvasView.this.f916ai.getPaddingBottom() / 2.0f) * CanvasView.this.getScale())) + CanvasView.this.f873Q);
                                CanvasView.this.f870N.setBackgroundDrawable(CanvasView.this.f875S);
                                CanvasView.this.f870N.setPadding(0, 10, 0, 0);
                            }
                            if (layoutParams6.topMargin + layoutParams6.height > CanvasView.this.getBottom()) {
                                layoutParams6.topMargin = (int) ((((layoutParams4.topMargin + (layoutParams4.height * CanvasView.this.getScale())) - (CanvasView.this.f916ai.getPaddingBottom() * CanvasView.this.getScale())) - layoutParams6.height) - CanvasView.this.f873Q);
                                CanvasView.this.f870N.setBackgroundDrawable(CanvasView.this.f874R);
                                CanvasView.this.f870N.setPadding(0, -10, 0, 0);
                            }
                            if (layoutParams6.leftMargin + layoutParams6.width > CanvasView.this.getRight()) {
                                layoutParams6.rightMargin = CanvasView.this.getRight() + (CanvasView.this.getRight() - layoutParams6.leftMargin);
                            } else {
                                layoutParams6.rightMargin = 0;
                            }
                            try {
                                CanvasView.this.f870N.setLayoutParams(layoutParams6);
                            } catch (Exception e4) {
                                e4.printStackTrace();
                            }
                            return true;
                        }
                        return false;
                    default:
                        return false;
                }
            }
        };
        this.f898aQ = new View.OnFocusChangeListener() { // from class: com.samsung.sdraw.CanvasView.17
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View v, boolean hasFocus) {
                InputMethodManager inputMethodManager = (InputMethodManager) CanvasView.this.getContext().getSystemService("input_method");
                if (hasFocus) {
                    inputMethodManager.showSoftInput(v, 0);
                } else {
                    inputMethodManager.hideSoftInputFromWindow(CanvasView.this.getWindowToken(), 0);
                }
            }
        };
        this.f899aR = 0;
        this.f900aS = new TextWatcher() { // from class: com.samsung.sdraw.CanvasView.18
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Layout.Alignment alignment;
                if (!CanvasView.this.f912ae) {
                    CanvasView.this.f911ad = new SpannableStringBuilder(CanvasView.this.f916ai.getText());
                }
                CanvasView.this.f912ae = false;
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(CanvasView.this.f916ai.getText());
                if (spannableStringBuilder.length() <= 0) {
                    if (CanvasView.this.f1001v != null) {
                        spannableStringBuilder.append((CharSequence) CanvasView.this.f1001v.m783d());
                    } else {
                        spannableStringBuilder.append((CharSequence) "Insert Text");
                    }
                    spannableStringBuilder.setSpan(new AbsoluteSizeSpan(40), 0, spannableStringBuilder.length(), 18);
                }
                CanvasView canvasView = CanvasView.this;
                TextPaint paint = CanvasView.this.f916ai.getPaint();
                int iMax = Math.max(1, CanvasView.this.f916ai.getWidth() - (CanvasView.this.f916ai.getPaddingLeft() + CanvasView.this.f916ai.getPaddingRight()));
                if (CanvasView.this.f916ai.getLayout() != null) {
                    alignment = CanvasView.this.f916ai.getLayout().getAlignment();
                } else {
                    alignment = null;
                }
                canvasView.f899aR = new DynamicLayout(spannableStringBuilder, paint, iMax, alignment, 1.0f, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, false).getLineCount();
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                DynamicLayout dynamicLayout;
                int lineCount;
                if (CanvasView.this.f916ai.getWidth() > 0) {
                    CanvasView.this.f916ai.setFilters(new InputFilter[]{new C0991ad(CanvasView.this.getContext(), 128)});
                    CanvasView.this.m913c(((ForegroundColorSpan) CanvasView.this.f908aa[0]).getForegroundColor());
                    CanvasView.this.m873a(CanvasView.this.f991l.setting.getTextType(), true);
                    CanvasView.this.setTextAlignment(CanvasView.this.f991l.setting.getTextAlignment());
                    CanvasView.this.m906b(CanvasView.this.f991l.setting.getTextSize());
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) CanvasView.this.f916ai.getLayoutParams();
                    int textSize = 10;
                    if (CanvasView.this.f993n != null) {
                        textSize = CanvasView.this.f993n.getTextSize();
                    }
                    if (CanvasView.this.f916ai.getText() != null) {
                        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(CanvasView.this.f916ai.getText());
                        if (spannableStringBuilder.length() <= 0) {
                            if (CanvasView.this.f1001v != null) {
                                spannableStringBuilder.append((CharSequence) CanvasView.this.f1001v.m783d());
                            } else {
                                spannableStringBuilder.append((CharSequence) "Insert Text");
                            }
                            spannableStringBuilder.setSpan(new AbsoluteSizeSpan(40), 0, spannableStringBuilder.length(), 18);
                        }
                        int paddingLeft = CanvasView.this.f916ai.getPaddingLeft() + CanvasView.this.f916ai.getPaddingRight();
                        if (layoutParams.width < (textSize * 4) + paddingLeft) {
                            layoutParams.width = (textSize * 4) + paddingLeft;
                            CanvasView.this.f916ai.setLayoutParams(layoutParams);
                        }
                        if (CanvasView.this.f916ai.getLayoutParams().width <= CanvasView.this.f916ai.getPaddingLeft() + CanvasView.this.f916ai.getPaddingRight()) {
                            dynamicLayout = new DynamicLayout(spannableStringBuilder, CanvasView.this.f916ai.getPaint(), CanvasView.this.f916ai.getWidth() - (CanvasView.this.f916ai.getPaddingLeft() + CanvasView.this.f916ai.getPaddingRight()), CanvasView.this.f916ai.getLayout() != null ? CanvasView.this.f916ai.getLayout().getAlignment() : null, 1.0f, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, false);
                        } else {
                            dynamicLayout = new DynamicLayout(spannableStringBuilder, CanvasView.this.f916ai.getPaint(), CanvasView.this.f916ai.getLayoutParams().width - (CanvasView.this.f916ai.getPaddingLeft() + CanvasView.this.f916ai.getPaddingRight()), CanvasView.this.f916ai.getLayout() != null ? CanvasView.this.f916ai.getLayout().getAlignment() : null, 1.0f, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, false);
                        }
                        lineCount = dynamicLayout.getLineCount();
                    } else {
                        dynamicLayout = null;
                        lineCount = 0;
                    }
                    if (lineCount != CanvasView.this.f899aR && lineCount > 0 && dynamicLayout != null) {
                        Rect rect = new Rect();
                        int paddingBottom = CanvasView.this.f916ai.getPaddingBottom() + CanvasView.this.f916ai.getPaddingTop();
                        dynamicLayout.getLineBounds(lineCount - 1, rect);
                        if (rect.bottom + paddingBottom < CanvasView.this.f880Z) {
                            layoutParams.height = rect.bottom + paddingBottom;
                            if (layoutParams.height > CanvasView.this.f880Z) {
                                layoutParams.height = (int) (CanvasView.this.f880Z - 10.0f);
                            }
                            CanvasView.this.f916ai.setLayoutParams(layoutParams);
                        } else if (rect.bottom + paddingBottom + CanvasView.this.f991l.setting.getCanvasRect().top >= CanvasView.this.f991l.setting.getCanvasRect().height() || CanvasView.this.f916ai.getHeight() >= rect.bottom + paddingBottom) {
                            if (CanvasView.this.f911ad.length() != s.length() && !CanvasView.this.f879W) {
                                CanvasView.this.f912ae = true;
                            }
                        } else {
                            Rect rect2 = new Rect();
                            CanvasView.this.f916ai.getLineBounds(0, rect2);
                            layoutParams.topMargin -= rect2.height();
                            if (layoutParams.topMargin < 0) {
                                layoutParams.topMargin = 0;
                            }
                            CanvasView.this.f880Z = (CanvasView.this.f991l.setting.getCanvasRect().height() - layoutParams.topMargin) - CanvasView.this.f991l.setting.getCanvasRect().top;
                            layoutParams.height = (int) (CanvasView.this.f880Z - 10.0f);
                            CanvasView.this.f916ai.setLayoutParams(layoutParams);
                        }
                        if (!CanvasView.this.f940bF) {
                            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) CanvasView.this.f865I.getLayoutParams();
                            layoutParams2.leftMargin = layoutParams.leftMargin - CanvasView.this.f866J;
                            layoutParams2.topMargin = (layoutParams.topMargin - CanvasView.this.f867K) + 10;
                            layoutParams2.width = -2;
                            layoutParams2.height = -2;
                            if (layoutParams2.leftMargin < 0) {
                                layoutParams2.leftMargin = (layoutParams.leftMargin + layoutParams.width) - 40;
                            }
                            if (layoutParams2.topMargin < 0) {
                                layoutParams2.topMargin = (layoutParams.topMargin + layoutParams.height) - 30;
                            }
                            if (layoutParams2.leftMargin < CanvasView.this.f913af.left) {
                                layoutParams2.leftMargin = (int) CanvasView.this.f913af.left;
                            }
                            if (layoutParams2.leftMargin + layoutParams2.width > CanvasView.this.f913af.right) {
                                layoutParams2.leftMargin = (int) (CanvasView.this.f913af.right - CanvasView.this.f866J);
                            }
                            if (layoutParams2.topMargin < CanvasView.this.f913af.top) {
                                layoutParams2.topMargin = (int) CanvasView.this.f913af.top;
                            }
                            if (layoutParams2.topMargin + layoutParams2.height > CanvasView.this.getBottom()) {
                                layoutParams2.topMargin = (int) (CanvasView.this.f913af.bottom - CanvasView.this.f867K);
                            }
                            try {
                                CanvasView.this.f865I.setLayoutParams(layoutParams2);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) CanvasView.this.f870N.getLayoutParams();
                        layoutParams3.leftMargin = (int) ((layoutParams.leftMargin + ((layoutParams.width * CanvasView.this.getScale()) / 2.0f)) - (CanvasView.this.f871O / 2.0f));
                        layoutParams3.topMargin = (int) (((layoutParams.topMargin + ((CanvasView.this.f916ai.getPaddingTop() / 2.0f) * CanvasView.this.getScale())) - CanvasView.this.f872P) - CanvasView.this.f873Q);
                        layoutParams3.width = CanvasView.this.f871O;
                        layoutParams3.height = CanvasView.this.f872P;
                        if (layoutParams3.topMargin >= 0 && layoutParams3.topMargin >= CanvasView.this.getTop()) {
                            CanvasView.this.f870N.setBackgroundDrawable(CanvasView.this.f874R);
                            CanvasView.this.f870N.setPadding(0, -10, 0, 0);
                        } else {
                            layoutParams3.topMargin = (int) (((layoutParams.topMargin + (layoutParams.height * CanvasView.this.getScale())) - ((CanvasView.this.f916ai.getPaddingBottom() / 2.0f) * CanvasView.this.getScale())) + CanvasView.this.f873Q);
                            CanvasView.this.f870N.setBackgroundDrawable(CanvasView.this.f875S);
                            CanvasView.this.f870N.setPadding(0, 10, 0, 0);
                        }
                        if (layoutParams3.topMargin + layoutParams3.height > CanvasView.this.getBottom()) {
                            layoutParams3.topMargin = (int) ((((layoutParams.topMargin + (layoutParams.height * CanvasView.this.getScale())) - (CanvasView.this.f916ai.getPaddingBottom() * CanvasView.this.getScale())) - layoutParams3.height) - CanvasView.this.f873Q);
                            CanvasView.this.f870N.setBackgroundDrawable(CanvasView.this.f874R);
                            CanvasView.this.f870N.setPadding(0, -10, 0, 0);
                        }
                        try {
                            CanvasView.this.f870N.setLayoutParams(layoutParams3);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
        };
        this.f903aV = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.samsung.sdraw.CanvasView.19
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent e) {
                return !CanvasView.this.f954bT;
            }
        });
        this.f904aW = new View.OnLongClickListener() { // from class: com.samsung.sdraw.CanvasView.20
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View arg0) {
                return !CanvasView.this.f953bS;
            }
        };
        this.f987h = false;
        this.f988i = false;
        this.f905aX = new View.OnTouchListener() { // from class: com.samsung.sdraw.CanvasView.2
            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                int rawX = (int) event.getRawX();
                int rawY = (int) event.getRawY();
                switch (event.getAction()) {
                    case 0:
                        CanvasView.this.f868L = (int) event.getRawX();
                        CanvasView.this.f869M = (int) event.getRawY();
                        CanvasView.this.f916ai.clearFocus();
                        return false;
                    case 1:
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) CanvasView.this.f916ai.getLayoutParams();
                        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) CanvasView.this.f865I.getLayoutParams();
                        CanvasView.this.f987h = false;
                        CanvasView.this.f988i = false;
                        layoutParams2.leftMargin = layoutParams.leftMargin - CanvasView.this.f866J;
                        layoutParams2.topMargin = (layoutParams.topMargin - CanvasView.this.f867K) + 10;
                        if (layoutParams2.leftMargin < 0) {
                            CanvasView.this.f987h = true;
                            layoutParams2.leftMargin = (layoutParams.leftMargin + layoutParams.width) - 30;
                        }
                        if (layoutParams2.topMargin < 0) {
                            CanvasView.this.f988i = true;
                            layoutParams2.topMargin = (layoutParams.topMargin + layoutParams.height) - 20;
                        }
                        CanvasView.this.f865I.setLayoutParams(layoutParams2);
                        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) CanvasView.this.f870N.getLayoutParams();
                        layoutParams3.leftMargin = (int) ((layoutParams.leftMargin + ((layoutParams.width * CanvasView.this.getScale()) / 2.0f)) - (CanvasView.this.f871O / 2.0f));
                        layoutParams3.topMargin = (int) (((layoutParams.topMargin + ((CanvasView.this.f916ai.getPaddingTop() / 2.0f) * CanvasView.this.getScale())) - CanvasView.this.f872P) - CanvasView.this.f873Q);
                        layoutParams3.width = CanvasView.this.f871O;
                        layoutParams3.height = CanvasView.this.f872P;
                        if (layoutParams3.topMargin >= 0 && layoutParams3.topMargin >= CanvasView.this.getTop()) {
                            CanvasView.this.f870N.setBackgroundDrawable(CanvasView.this.f874R);
                            CanvasView.this.f870N.setPadding(0, -10, 0, 0);
                        } else {
                            layoutParams3.topMargin = (int) (((layoutParams.topMargin + (layoutParams.height * CanvasView.this.getScale())) - ((CanvasView.this.f916ai.getPaddingBottom() / 2.0f) * CanvasView.this.getScale())) + CanvasView.this.f873Q);
                            CanvasView.this.f870N.setBackgroundDrawable(CanvasView.this.f875S);
                            CanvasView.this.f870N.setPadding(0, 10, 0, 0);
                        }
                        if (layoutParams3.topMargin + layoutParams3.height > CanvasView.this.getBottom()) {
                            layoutParams3.topMargin = (int) (((((layoutParams.height * CanvasView.this.getScale()) + layoutParams.topMargin) - (CanvasView.this.f916ai.getPaddingBottom() * CanvasView.this.getScale())) - layoutParams3.height) - CanvasView.this.f873Q);
                            CanvasView.this.f870N.setBackgroundDrawable(CanvasView.this.f874R);
                            CanvasView.this.f870N.setPadding(0, -10, 0, 0);
                        }
                        try {
                            CanvasView.this.f870N.setLayoutParams(layoutParams3);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        return false;
                    case 2:
                        float f = rawX - CanvasView.this.f868L;
                        float f2 = rawY - CanvasView.this.f869M;
                        RectF rectF = new RectF(CanvasView.this.f913af);
                        rectF.left -= CanvasView.this.getLeft();
                        rectF.top -= CanvasView.this.getTop();
                        rectF.right -= CanvasView.this.getLeft();
                        rectF.bottom -= CanvasView.this.getTop();
                        rectF.offset((-rectF.left) * 2.0f, (-rectF.top) * 2.0f);
                        rectF.right = rectF.left + Math.min(rectF.width(), CanvasView.this.getWidth());
                        rectF.bottom = rectF.top + Math.min(rectF.height(), CanvasView.this.getHeight());
                        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) CanvasView.this.f916ai.getLayoutParams();
                        RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) CanvasView.this.f865I.getLayoutParams();
                        if (layoutParams4.leftMargin + f < rectF.left) {
                            layoutParams4.leftMargin = (int) rectF.left;
                        } else if (layoutParams4.leftMargin + layoutParams4.width + f > rectF.right) {
                            layoutParams4.leftMargin = (int) (rectF.right - layoutParams4.width);
                        } else {
                            layoutParams4.leftMargin = (int) (f + layoutParams4.leftMargin);
                        }
                        if (layoutParams4.topMargin + f2 < rectF.top) {
                            layoutParams4.topMargin = (int) rectF.top;
                        } else if (layoutParams4.topMargin + layoutParams4.height + f2 > rectF.bottom) {
                            layoutParams4.topMargin = (int) (rectF.bottom - layoutParams4.height);
                        } else {
                            layoutParams4.topMargin = (int) (layoutParams4.topMargin + f2);
                        }
                        if (layoutParams4.topMargin + layoutParams4.height >= CanvasView.this.getHeight()) {
                            layoutParams4.topMargin = CanvasView.this.getHeight() - layoutParams4.height;
                        }
                        layoutParams5.leftMargin = layoutParams4.leftMargin - CanvasView.this.f866J;
                        layoutParams5.topMargin = (layoutParams4.topMargin - CanvasView.this.f867K) + 10;
                        layoutParams5.width = -2;
                        layoutParams5.height = -2;
                        if (CanvasView.this.f987h) {
                            layoutParams5.leftMargin = (layoutParams4.leftMargin + layoutParams4.width) - 30;
                            if (layoutParams5.leftMargin + CanvasView.this.f865I.getWidth() > CanvasView.this.f913af.width()) {
                                layoutParams5.leftMargin = ((int) CanvasView.this.f913af.width()) - CanvasView.this.f865I.getWidth();
                            }
                        }
                        if (CanvasView.this.f988i) {
                            layoutParams5.topMargin = (layoutParams4.topMargin + layoutParams4.height) - 20;
                            if (layoutParams5.topMargin + CanvasView.this.f865I.getHeight() > CanvasView.this.f913af.height()) {
                                layoutParams5.topMargin = ((int) CanvasView.this.f913af.height()) - CanvasView.this.f865I.getHeight();
                            }
                        }
                        CanvasView.this.f868L = rawX;
                        CanvasView.this.f869M = rawY;
                        CanvasView.this.f865I.setLayoutParams(layoutParams5);
                        CanvasView.this.f916ai.setLayoutParams(layoutParams4);
                        RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) CanvasView.this.f870N.getLayoutParams();
                        layoutParams6.leftMargin = (int) ((layoutParams4.leftMargin + ((layoutParams4.width * CanvasView.this.getScale()) / 2.0f)) - (CanvasView.this.f871O / 2.0f));
                        layoutParams6.topMargin = (int) (((layoutParams4.topMargin + ((CanvasView.this.f916ai.getPaddingTop() / 2.0f) * CanvasView.this.getScale())) - CanvasView.this.f872P) - CanvasView.this.f873Q);
                        layoutParams6.width = CanvasView.this.f871O;
                        layoutParams6.height = CanvasView.this.f872P;
                        if (layoutParams6.topMargin >= 0 && layoutParams6.topMargin >= CanvasView.this.getTop()) {
                            CanvasView.this.f870N.setBackgroundDrawable(CanvasView.this.f874R);
                            CanvasView.this.f870N.setPadding(0, -10, 0, 0);
                        } else {
                            layoutParams6.topMargin = (int) (((layoutParams4.topMargin + (layoutParams4.height * CanvasView.this.getScale())) - ((CanvasView.this.f916ai.getPaddingBottom() / 2.0f) * CanvasView.this.getScale())) + CanvasView.this.f873Q);
                            CanvasView.this.f870N.setBackgroundDrawable(CanvasView.this.f875S);
                            CanvasView.this.f870N.setPadding(0, 10, 0, 0);
                        }
                        if (layoutParams6.topMargin + layoutParams6.height > CanvasView.this.getBottom()) {
                            layoutParams6.topMargin = (int) (((((layoutParams4.height * CanvasView.this.getScale()) + layoutParams4.topMargin) - (CanvasView.this.f916ai.getPaddingBottom() * CanvasView.this.getScale())) - layoutParams6.height) - CanvasView.this.f873Q);
                            CanvasView.this.f870N.setBackgroundDrawable(CanvasView.this.f874R);
                            CanvasView.this.f870N.setPadding(0, -10, 0, 0);
                        }
                        try {
                            CanvasView.this.f870N.setLayoutParams(layoutParams6);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        return false;
                    default:
                        return false;
                }
            }
        };
        this.f906aY = new View.OnTouchListener() { // from class: com.samsung.sdraw.CanvasView.3
            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                PointF pointFMapToScene = CanvasView.this.f991l.stage.mapToScene(new PointF(event.getX(), event.getY()));
                switch (event.getAction()) {
                    case 0:
                        CanvasView.this.f876T = true;
                        return false;
                    case 1:
                        if (CanvasView.this.f876T) {
                            CanvasView.this.f870N.playSoundEffect(0);
                            CanvasView.this.deleteSelectedObject();
                            CanvasView.this.m970a(v);
                        }
                        return false;
                    case 2:
                        if (!new Rect(0, 0, CanvasView.this.f870N.getWidth(), CanvasView.this.f870N.getHeight()).contains((int) pointFMapToScene.x, (int) pointFMapToScene.y)) {
                            CanvasView.this.f876T = false;
                        }
                        return false;
                    default:
                        return false;
                }
            }
        };
        this.f907aZ = new TextMode.OnTextSelectedListener() { // from class: com.samsung.sdraw.CanvasView.4
            @Override // com.samsung.sdraw.TextMode.OnTextSelectedListener
            public void onTextSelected(ObjectInfo objectInfo, boolean bSelected) {
                if (CanvasView.this.f968bm == null) {
                    return;
                }
                CanvasView.this.f968bm.onObjectSelected(objectInfo, bSelected);
            }
        };
        this.f956ba = new SelectMode.OnImageSelectedListener() { // from class: com.samsung.sdraw.CanvasView.5
            @Override // com.samsung.sdraw.SelectMode.OnImageSelectedListener
            public void onImageSelected(ObjectInfo objectInfo, boolean bSelected) {
                if (CanvasView.this.f968bm == null) {
                    return;
                }
                CanvasView.this.f968bm.onObjectSelected(objectInfo, bSelected);
            }
        };
        this.f957bb = null;
        this.f958bc = null;
        this.f959bd = true;
        this.f960be = false;
        this.f961bf = 0;
        this.f962bg = 0;
        this.f964bi = false;
        this.f965bj = new Handler() { // from class: com.samsung.sdraw.CanvasView.6
            @Override // android.os.Handler
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case 2:
                        if (!CanvasView.this.f976bu) {
                            CanvasView.this.f964bi = true;
                            break;
                        }
                        break;
                    case 3:
                        int userID = CanvasView.this.getUserID();
                        CanvasView.this.f991l.stage.addSprite((C1063s) msg.obj, true, userID);
                        CanvasView.this.f991l.stage.clearLayer(CanvasView.this.f991l.modes.get(Integer.valueOf(userID)).getLayerID(CanvasView.this.f991l));
                        CanvasView.this.f991l.stage.renderSprites(CanvasView.this.f991l.modes.get(Integer.valueOf(userID)).getLayerID(CanvasView.this.f991l));
                        CanvasView.this.f991l.invalidate();
                        break;
                }
                super.handleMessage(msg);
            }
        };
        this.f966bk = new Stage.OnSpriteChangeListener() { // from class: com.samsung.sdraw.CanvasView.7
            @Override // com.samsung.sdraw.Stage.OnSpriteChangeListener
            public void onObjectDeleted(ObjectInfo objectInfo, boolean byUndo, boolean byRedo, boolean bFreeMemory) {
                if (CanvasView.this.f968bm == null) {
                    return;
                }
                CanvasView.this.f968bm.onObjectDeleted(objectInfo, byUndo, byRedo, bFreeMemory);
            }

            @Override // com.samsung.sdraw.Stage.OnSpriteChangeListener
            public void onSpriteChanged(boolean undoable, boolean redoable) {
            }

            @Override // com.samsung.sdraw.Stage.OnSpriteChangeListener
            public void onObjectChanged(ObjectInfo objectInfo, boolean byUndo, boolean byRedo) {
                if (CanvasView.this.f968bm == null) {
                    return;
                }
                CanvasView.this.f968bm.onObjectChanged(objectInfo, byUndo, byRedo);
            }

            @Override // com.samsung.sdraw.Stage.OnSpriteChangeListener
            public void onObjectInserted(ObjectInfo objectInfo, boolean byUndo, boolean byRedo) {
                if (CanvasView.this.f968bm == null) {
                    return;
                }
                CanvasView.this.f968bm.onObjectInserted(objectInfo, byUndo, byRedo);
            }

            @Override // com.samsung.sdraw.Stage.OnSpriteChangeListener
            public boolean onStrokeInserting(StrokeInfo strokeInfo) {
                if (CanvasView.this.f968bm != null) {
                    return CanvasView.this.f968bm.onStrokeInserting(strokeInfo);
                }
                return false;
            }

            @Override // com.samsung.sdraw.Stage.OnSpriteChangeListener
            public void onMultiClearAll(boolean undo) {
                if (CanvasView.this.f936bB == null) {
                    return;
                }
                CanvasView.this.f936bB.m993a(undo);
            }
        };
        this.f970bo = false;
        this.f971bp = false;
        this.f972bq = false;
        this.f989j = new AbstractSettingView.InterfaceC0948a() { // from class: com.samsung.sdraw.CanvasView.8
            @Override // com.samsung.sdraw.AbstractSettingView.InterfaceC0948a
            /* renamed from: c */
            public void mo808c(boolean z) {
                if (CanvasView.this.f969bn != null) {
                    CanvasView.this.f969bn.onTextSettingViewShow(z);
                }
                if (!CanvasView.this.f971bp) {
                    CanvasView.this.f1001v.m775a(CanvasView.this.f993n);
                    CanvasView.this.f971bp = true;
                }
            }

            @Override // com.samsung.sdraw.AbstractSettingView.InterfaceC0948a
            /* renamed from: a */
            public void mo806a(boolean z) {
                if (CanvasView.this.f969bn != null) {
                    CanvasView.this.f969bn.onPenSettingViewShow(z);
                }
                if (!CanvasView.this.f970bo) {
                    CanvasView.this.f1001v.m774a(CanvasView.this.f881a);
                    CanvasView.this.f970bo = true;
                }
            }

            @Override // com.samsung.sdraw.AbstractSettingView.InterfaceC0948a
            /* renamed from: b */
            public void mo807b(boolean z) {
                if (CanvasView.this.f969bn != null) {
                    CanvasView.this.f969bn.onEraserSettingViewShow(z);
                }
                if (!CanvasView.this.f970bo) {
                    CanvasView.this.f1001v.m774a(CanvasView.this.f881a);
                    if (CanvasView.this.getMode() == 2) {
                        CanvasView.this.m974a(true);
                    }
                    CanvasView.this.f970bo = true;
                }
            }

            @Override // com.samsung.sdraw.AbstractSettingView.InterfaceC0948a
            /* renamed from: d */
            public void mo809d(boolean z) {
                if (CanvasView.this.f969bn != null) {
                    CanvasView.this.f969bn.onFillingSettingViewShow(z);
                }
                if (!CanvasView.this.f972bq) {
                    CanvasView.this.f1001v.m773a(CanvasView.this.f994o);
                    CanvasView.this.f972bq = true;
                }
            }
        };
        this.f973br = false;
        this.f974bs = null;
        this.f990k = false;
        this.f975bt = false;
        this.f976bu = true;
        this.f977bv = true;
        this.f979bx = null;
        this.f937bC = true;
        this.f938bD = false;
        this.f939bE = false;
        this.f940bF = true;
        this.f941bG = 1.0f;
        this.f942bH = false;
        this.f943bI = 0;
        this.f944bJ = null;
        this.f945bK = null;
        this.f946bL = false;
        this.f948bN = true;
        this.f949bO = 200;
        this.f950bP = 200;
        this.f951bQ = true;
        this.f952bR = true;
        this.f953bS = true;
        this.f954bT = true;
        this.f955bU = false;
        this.f864H = context;
        m928f();
        m951l();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        this.f991l.setting.removeCacheFiles();
        StatFs statFs = new StatFs("/mnt/sdcard");
        long availableBlocks = (statFs.getAvailableBlocks() * statFs.getBlockSize()) / 1048576;
        if (availableBlocks > 30 && this.f952bR) {
            m976b();
        }
        dispose();
        this.f916ai = null;
        if (availableBlocks > 30) {
            this.f985f = true;
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onAttachedToWindow() throws IOException {
        if (this.f985f) {
            m928f();
            m932g();
            if (this.f952bR) {
                m978c();
            }
            if (this.f991l.historyChangeListener != null) {
                this.f991l.historyChangeListener.onHistoryChanged(this.f991l.stage.isUndoable(), this.f991l.stage.isRedoable());
            }
            this.f985f = false;
            super.onAttachedToWindow();
        }
    }

    /* renamed from: e */
    private void m924e() {
        String str = Build.VERSION.RELEASE;
        if (str.startsWith("2.3")) {
            this.f923ap = 1024;
            this.f924aq = 512;
            this.f877U = false;
            this.f991l.setting.setTextZoomMode(false);
            return;
        }
        if (str.startsWith("3")) {
            this.f923ap = 67108864;
            this.f924aq = 33554432;
            this.f877U = false;
            this.f991l.setting.setTextZoomMode(false);
            return;
        }
        if (str.startsWith(SimpleUserInfo.STATE_MOVETO_CONFERENCE)) {
            this.f923ap = 4;
            this.f924aq = 2;
            this.f877U = false;
            this.f991l.setting.setTextZoomMode(false);
        }
    }

    /* renamed from: f */
    private void m928f() throws IOException {
        this.f999t = false;
        this.f1000u = hashCode();
        this.f991l = new ModeContext(this);
        this.f991l.setting.m1105b(this.f1000u);
        this.f881a = new PenSettingInfo(getContext());
        if (this.f881a != null) {
            this.f881a.m1023a(this.f884aC);
        }
        this.f993n = new TextSettingInfo(getContext());
        this.f996q = new TextSettingInfo(getContext());
        if (this.f993n != null) {
            this.f993n.m1185a(this.f886aE);
        }
        this.f994o = new FillingSettingInfo(getContext());
        if (this.f994o != null) {
            this.f994o.m997a(this.f885aD);
        }
        this.f858B = new HandlerC0969a(this, null);
        setOnLongClickListener(new View.OnLongClickListener() { // from class: com.samsung.sdraw.CanvasView.9
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View v) {
                return false;
            }
        });
        m924e();
        ((Stage) this.f991l.stage).setSpriteChangeListener(this.f966bk);
        String str = Build.VERSION.RELEASE;
        if (this.f902aU == null && str.startsWith(SimpleUserInfo.STATE_MOVETO_CONFERENCE)) {
            this.f902aU = new C0971c();
        }
    }

    /* renamed from: g */
    private void m932g() {
        try {
            this.f991l.changeCanvasSize(this.f992m);
            this.f991l.changeScreenSize(this.f992m);
            this.f913af = new RectF(this.f991l.setting.getCanvasRect());
            this.f991l.setZoom(1.0f);
            this.f991l.setPanning(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET);
            this.f991l.onActivate(true);
            this.f882aA = new C0988aa(getContext(), this.f992m, new Rect());
            if (this.f882aA != null) {
                this.f882aA.m1220a(this.f883aB);
            }
            this.f991l.drawBackgroundTheme();
            this.f918ak = this.f991l.getTextMode(getUserID());
            this.f919al = this.f991l.getSelectMode(getUserID());
            this.f918ak.m1181a(this.f907aZ);
            this.f919al.m1092a(this.f956ba);
            this.f991l.setting.setOnDrawCancelListener(this.f981bz);
        } catch (OutOfMemoryError e) {
            if (this.f980by != null) {
                this.f980by.onOutOfMemory();
            }
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (changed) {
            if (this.f915ah && this.f925ar != m955m() && this.f991l != null && this.f991l.getMode() == 4) {
                hideImm();
            }
            if (this.f882aA != null) {
                this.f882aA.m1222a(changed, left - getPaddingLeft(), top - getPaddingTop(), right - getPaddingRight(), bottom - getPaddingBottom());
            }
            if (this.f991l != null) {
                this.f991l.onLayout(new Rect(this.f992m));
            }
            if (!this.f915ah) {
                if (this.f960be) {
                    this.f960be = false;
                    setCanvasSize(this.f961bf, this.f962bg);
                } else {
                    setCanvasSize(right - left, bottom - top);
                }
                this.f863G = m955m();
                if (this.f863G) {
                    this.f861E = new Rect(0, 0, right - left, bottom - top);
                } else {
                    this.f862F = new Rect(0, 0, right - left, bottom - top);
                }
                if (this.f942bH) {
                    setMinZoom(this.f941bG);
                    zoomTo(this.f941bG);
                } else {
                    setMinZoom(1.0f);
                    zoomTo(1.0f);
                }
                this.f925ar = m955m();
                m951l();
                if (this.f963bh != null) {
                    this.f963bh.onFinish();
                }
                if (this.f902aU != null && this.f979bx != null) {
                    this.f902aU.m992a(this.f979bx);
                }
                if (this.f967bl != null) {
                    this.f967bl.onFinish();
                }
            } else if (this.f991l != null) {
                if (this.f925ar != m955m()) {
                    if (this.f991l.getMode() != 4 || this.f877U) {
                        m872a(right - left, bottom - top);
                    } else {
                        this.f925ar = m955m();
                    }
                }
                this.f991l.invalidate();
            }
            if (this.f1001v != null) {
                this.f1001v.relayoutSettingView(m955m(), true);
            }
            C0993af.m1274a("CanvasView Size : " + (right - left) + ", h " + (bottom - top));
        }
    }

    /* renamed from: a */
    private void m872a(int i, int i2) {
        if (this.f863G == m955m()) {
            if (this.f942bH) {
                setMinZoom(this.f941bG);
                zoomTo(this.f941bG);
            } else {
                setMinZoom(1.0f);
                zoomTo(1.0f);
            }
        } else {
            float fMax = Math.max(i / (this.f863G ? this.f861E.width() : this.f862F.width()), i2 / (this.f863G ? this.f861E.height() : this.f862F.height()));
            if (this.f942bH) {
                setMinZoom(this.f941bG);
                zoomTo(this.f941bG);
            } else {
                setMinZoom(fMax);
                zoomTo(fMax);
            }
        }
        this.f925ar = m955m();
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        if (!this.f999t && (w != oldw || h != oldh)) {
            if (this.f992m == null) {
                this.f992m = new Rect(getPaddingLeft(), getPaddingTop(), (getLeft() + w) - getPaddingRight(), (getTop() + h) - getPaddingBottom());
            }
            this.f999t = true;
            m932g();
            if (this.f1002w) {
                this.f1002w = false;
                if (this.f991l != null) {
                    this.f991l.drawBackgroundTheme();
                }
            }
        }
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        boolean z;
        if (this.f991l == null || this.f991l.setting == null) {
            return true;
        }
        if (event.getAction() == 0) {
            PointF pointFMapToScene = this.f991l.stage.mapToScene(new PointF(event.getX(), event.getY()));
            if (!this.f992m.contains((int) pointFMapToScene.x, (int) pointFMapToScene.y)) {
                return true;
            }
        }
        if (this.f973br && this.f887aF) {
            if (event.getPointerCount() > 1) {
                return m889a(event);
            }
            if (new RectF(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, getWidth(), getHeight()).contains(event.getX(), event.getY())) {
                getDropperColor(event.getX(), event.getY());
            }
            return true;
        }
        int action = event.getAction();
        if (this.f975bt) {
            if (this.f998s) {
                if (this.f882aA != null) {
                    return this.f882aA.m1225a(this, event);
                }
                return true;
            }
            boolean z2 = false;
            if (Build.VERSION.RELEASE.startsWith(SimpleUserInfo.STATE_MOVETO_CONFERENCE)) {
                if ((event.getToolType(0) & this.f924aq) == this.f924aq) {
                    z2 = true;
                }
            } else if ((event.getMetaState() & this.f924aq) == this.f924aq) {
                z2 = true;
            }
            if (this.f882aA != null && z2) {
                this.f927at = true;
                if (action == 1) {
                    this.f928au = true;
                }
                return this.f882aA.m1225a(this, event);
            }
            if (this.f882aA != null && event.getPointerCount() > 1 && this.f991l.getMode() != 3) {
                this.f857A = true;
                this.f927at = true;
                if ((action & 255) == 5) {
                    MotionEvent motionEventObtain = MotionEvent.obtain(event);
                    motionEventObtain.setAction(3);
                    this.f991l.onTouchEvent(motionEventObtain);
                    motionEventObtain.recycle();
                }
                return this.f882aA.m1225a(this, event);
            }
            if (this.f882aA != null && action == 1) {
                this.f928au = true;
                if (this.f882aA != null) {
                    this.f882aA.m1225a(this, event);
                }
            }
            return true;
        }
        if (action == 0) {
            ViewParent parent = getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            this.f965bj.removeMessages(2);
            this.f965bj.sendEmptyMessageAtTime(2, event.getDownTime() + f856z + 0);
        } else if (action == 1) {
            this.f964bi = false;
            ViewParent parent2 = getParent();
            if (parent2 != null && (parent2 instanceof ViewGroup)) {
                parent2.requestDisallowInterceptTouchEvent(false);
            }
        } else if (action == 3) {
            this.f964bi = false;
        }
        C0993af.m1274a("onTouch : " + action);
        if (this.f998s) {
            if (this.f882aA != null) {
                return this.f882aA.m1225a(this, event);
            }
            return true;
        }
        if (this.f882aA != null && event.getPointerCount() > 1 && this.f991l.getMode(getUserID()) != 3) {
            this.f965bj.removeMessages(2);
            this.f857A = true;
            this.f927at = true;
            if ((action & 255) == 5) {
                MotionEvent motionEventObtain2 = MotionEvent.obtain(event);
                if (!this.f964bi) {
                    motionEventObtain2.setAction(3);
                } else {
                    motionEventObtain2.setAction(1);
                }
                if (getDrawable()) {
                    this.f991l.onTouchEvent(motionEventObtain2);
                }
                motionEventObtain2.recycle();
            }
            return this.f882aA.m1225a(this, event);
        }
        if (this.f882aA != null && action == 1) {
            this.f928au = true;
            if (this.f882aA != null) {
                this.f882aA.m1225a(this, event);
            }
            if (this.f927at && this.f958bc != null) {
                this.f958bc.onMatrixChangeEnd();
            }
        }
        if (!this.f887aF) {
            return true;
        }
        if (event.getAction() == 0) {
            this.f857A = false;
        }
        if (this.f991l.getMode() == 4 && isShowTextBox()) {
            int right = this.f916ai.getRight() - 1;
            int bottom = this.f916ai.getBottom() - 1;
            switch (action) {
                case 0:
                    boolean z3 = false;
                    if (-1.0f <= right - 30 || -1.0f >= right + 30) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (-1.0f > bottom - 30 && -1.0f < bottom + 30) {
                        z3 = true;
                    }
                    if (z && z3) {
                        this.f914ag = EnumC0970b.BOTTOM_RIGHT;
                    } else if (z) {
                        this.f914ag = EnumC0970b.RIGHT;
                    } else if (z3) {
                        this.f914ag = EnumC0970b.BOTTOM;
                    } else {
                        this.f914ag = EnumC0970b.NONE;
                    }
                    if (this.f914ag != EnumC0970b.NONE) {
                        this.f916ai.cancelLongPress();
                        return true;
                    }
                    break;
                case 1:
                    this.f914ag = EnumC0970b.NONE;
                    this.f916ai.setLongClickable(true);
                    break;
                case 2:
                    if (this.f914ag != EnumC0970b.NONE) {
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f916ai.getLayoutParams();
                        Rect rect = new Rect(layoutParams.leftMargin, layoutParams.topMargin, layoutParams.width, layoutParams.height);
                        if (this.f914ag == EnumC0970b.RIGHT || this.f914ag == EnumC0970b.BOTTOM_RIGHT) {
                            rect.right = ((int) (-1.0f)) - this.f916ai.getLeft();
                        }
                        if (this.f914ag == EnumC0970b.BOTTOM || this.f914ag == EnumC0970b.BOTTOM_RIGHT) {
                            rect.bottom = ((int) (-1.0f)) - this.f916ai.getTop();
                        }
                        if (m888a(rect, false)) {
                            layoutParams.width = rect.right;
                            layoutParams.height = rect.bottom;
                        }
                        this.f916ai.setLayoutParams(layoutParams);
                        return true;
                    }
                    break;
            }
        }
        if (this.f991l.getMode(getUserID()) == 3 && ((Stage) this.f991l.stage).selectedImageSprite() == null) {
            changeModeTo(this.f1003x);
            this.f858B.removeMessages(2);
            return true;
        }
        if (event.getAction() == 2 && this.f991l.getMode(getUserID()) != 3 && (Math.abs(((int) event.getX()) - this.f859C) > 15 || Math.abs(((int) event.getY()) - this.f860D) > 15)) {
            this.f857A = true;
        }
        if (Build.VERSION.RELEASE.startsWith(SimpleUserInfo.STATE_MOVETO_CONFERENCE)) {
            if (this.f991l.getMode(getUserID()) == 1 && (event.getToolType(0) & this.f923ap) != 0) {
                this.f991l.setting.setEraserWidth(this.f881a.getEraserWidth());
            }
            if ((event.getToolType(0) & this.f924aq) == this.f924aq) {
                this.f991l.setInputMethod(StrokeSprite.InputMethod.Tablet);
            } else {
                this.f991l.setInputMethod(StrokeSprite.InputMethod.Hand);
            }
        } else {
            if (this.f991l.getMode(getUserID()) == 1 && (event.getMetaState() & this.f923ap) != 0) {
                this.f991l.setting.setEraserWidth(this.f881a.getEraserWidth());
            }
            if ((event.getMetaState() & this.f924aq) == this.f924aq) {
                this.f991l.setInputMethod(StrokeSprite.InputMethod.Tablet);
            } else {
                this.f991l.setInputMethod(StrokeSprite.InputMethod.Hand);
            }
        }
        this.f991l.onTouchEvent(event);
        if (getMode(getUserID()) == 3 && event.getAction() == 1 && ((Stage) this.f991l.stage).selectedImageSprite() == null) {
            changeModeTo(this.f1003x);
        }
        if (this.f991l.getMode(getUserID()) == 1 && getPenSettingInfo(getUserID()).getPenType() == 3 && action == 2 && ((Build.VERSION.SDK_INT < 14 || event.getToolType(0) != 4) && ((PenMode) this.f991l.modes.get(Integer.valueOf(getUserID()))).getStrokeVertorSize() > this.f991l.setting.m1118i())) {
            MotionEvent motionEventObtain3 = MotionEvent.obtain(event.getDownTime(), event.getEventTime(), 1, event.getX(), event.getY(), 0);
            this.f991l.onTouchEvent(motionEventObtain3);
            motionEventObtain3.recycle();
            MotionEvent motionEventObtain4 = MotionEvent.obtain(event.getDownTime(), event.getEventTime(), 0, event.getX(), event.getY(), 0);
            this.f991l.onTouchEvent(motionEventObtain4);
            motionEventObtain4.recycle();
        }
        this.f858B.removeMessages(2);
        Message messageObtain = Message.obtain(this.f858B, 2);
        Bundle bundle = new Bundle();
        bundle.putFloat("pos_x", event.getX());
        bundle.putFloat("pos_y", event.getY());
        messageObtain.setData(bundle);
        if (action == 0) {
            this.f859C = (int) event.getX();
            this.f860D = (int) event.getY();
        }
        this.f858B.sendMessageAtTime(messageObtain, event.getDownTime() + f856z + f855y);
        if (event.getAction() == 1) {
            this.f858B.removeMessages(2);
        }
        if (this.f939bE) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    private boolean m889a(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.f975bt) {
            if (this.f998s) {
                if (this.f882aA != null) {
                    return this.f882aA.m1225a(this, motionEvent);
                }
                return true;
            }
            if (this.f882aA != null && motionEvent.getPointerCount() > 1 && this.f991l.getMode() != 3) {
                this.f857A = true;
                this.f927at = true;
                if ((action & 255) == 5) {
                    MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
                    motionEventObtain.setAction(3);
                    this.f991l.onTouchEvent(motionEventObtain);
                    motionEventObtain.recycle();
                }
                return this.f882aA.m1225a(this, motionEvent);
            }
            if (this.f882aA == null || action != 1) {
                return true;
            }
            this.f928au = true;
            if (this.f882aA == null) {
                return true;
            }
            this.f882aA.m1225a(this, motionEvent);
            return true;
        }
        if (this.f998s) {
            if (this.f882aA != null) {
                return this.f882aA.m1225a(this, motionEvent);
            }
            return true;
        }
        if (this.f882aA != null && motionEvent.getPointerCount() > 1 && this.f991l.getMode() != 3) {
            this.f965bj.removeMessages(2);
            this.f857A = true;
            this.f927at = true;
            if ((action & 255) == 5) {
                MotionEvent motionEventObtain2 = MotionEvent.obtain(motionEvent);
                if (!this.f964bi) {
                    motionEventObtain2.setAction(3);
                } else {
                    motionEventObtain2.setAction(1);
                }
                this.f991l.onTouchEvent(motionEventObtain2);
                motionEventObtain2.recycle();
            }
            return this.f882aA.m1225a(this, motionEvent);
        }
        if (this.f882aA == null || action != 1) {
            return true;
        }
        this.f928au = true;
        if (this.f882aA == null) {
            return true;
        }
        this.f882aA.m1225a(this, motionEvent);
        return true;
    }

    protected void onDraw(Bitmap bitmap) {
        if (this.f991l != null && bitmap != null) {
            setCanvasSize(bitmap.getWidth(), bitmap.getHeight());
            changeModeTo(1);
            this.f991l.onDraw(new Canvas(bitmap));
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.f991l != null && this.f991l.isBUpdateScreen()) {
            C0993af.m1274a("CanvasView onDraw");
            canvas.save();
            canvas.clipRect(new Rect(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom()));
            canvas.translate(getPaddingLeft(), getPaddingTop());
            if (this.f882aA == null) {
                this.f882aA = new C0988aa(getContext(), this.f992m, new Rect());
                if (this.f882aA == null) {
                    canvas.restore();
                    return;
                }
            }
            if (this.f991l == null) {
                canvas.restore();
                throw new NullPointerException();
            }
            if (!this.f991l.modes.containsKey(Integer.valueOf(getUserID()))) {
                this.f991l.createNewMode(getUserID());
            }
            this.f991l.modes.get(Integer.valueOf(getUserID())).setAnimating(this.f882aA.m1224a());
            this.f991l.onDraw(canvas);
            canvas.restore();
            m874a(canvas);
        }
    }

    /* renamed from: a */
    private void m874a(Canvas canvas) {
        float fM1238e;
        if (this.f930aw && this.f959bd) {
            canvas.save();
            if (this.f927at && !this.f928au) {
                this.f929av += 20;
                if (this.f929av >= 255) {
                    this.f929av = 255;
                } else {
                    invalidate();
                }
            }
            if (this.f928au) {
                this.f927at = false;
                this.f929av -= 20;
                if (this.f929av <= 0) {
                    this.f929av = 0;
                    this.f928au = false;
                } else {
                    invalidate();
                }
            }
            Paint paint = new Paint();
            paint.setColor(-12303292);
            paint.setAlpha(this.f929av);
            if (this.f882aA == null) {
                fM1238e = 1.0f;
            } else {
                fM1238e = this.f882aA.m1238e();
            }
            RectF rectF = new RectF(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, getBottom() - this.f926as, fM1238e != VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET ? (int) (((getWidth() - this.f926as) * getWidth()) / (this.f992m.width() * fM1238e)) : 0, getBottom());
            rectF.offset(-(this.f882aA != null ? (int) (((getWidth() - this.f926as) * this.f882aA.m1240f()) / (this.f992m.width() * fM1238e)) : 0), VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET);
            canvas.drawRoundRect(rectF, 5.0f, 5.0f, paint);
            RectF rectF2 = new RectF(getRight() - this.f926as, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, getRight(), fM1238e != VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET ? (int) (((getHeight() - this.f926as) * getHeight()) / (this.f992m.height() * fM1238e)) : 0);
            rectF2.offset(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, -(this.f882aA != null ? (int) (((getHeight() - this.f926as) * this.f882aA.m1241g()) / (this.f992m.height() * fM1238e)) : 0));
            canvas.drawRoundRect(rectF2, 5.0f, 5.0f, paint);
            canvas.restore();
        }
    }

    public Bitmap getBitmap(boolean bOnlyIncludeForegroud) {
        if (this.f991l == null) {
            return null;
        }
        return getBitmap(bOnlyIncludeForegroud, -2);
    }

    public Bitmap getBitmap(boolean bOnlyIncludeForegroud, int layer) {
        AbstractSprite abstractSprite;
        if (this.f991l == null) {
            return null;
        }
        if (!bOnlyIncludeForegroud) {
            this.f991l.stage.drawBackgroundTheme();
        } else {
            this.f991l.stage.listOfLayers.get(2).m1014b();
        }
        LinkedList<AbstractSprite> linkedListM811a = this.f991l.stage.m811a(C0989ab.class);
        LinkedList<AbstractSprite> linkedListM811a2 = this.f991l.stage.m811a(TextSprite.class);
        this.f991l.stage.m817a(2, linkedListM811a);
        ArrayList<AbstractSprite> selectedSprites = this.f991l.stage.getSelectedSprites();
        if (selectedSprites.size() != 0) {
            AbstractSprite abstractSprite2 = selectedSprites.get(0);
            abstractSprite2.setVisible(true);
            abstractSprite = abstractSprite2;
        } else {
            abstractSprite = null;
        }
        this.f991l.stage.m817a(2, linkedListM811a2);
        Bitmap bitmapM825b = this.f991l.stage.m825b(2);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmapM825b.getWidth(), bitmapM825b.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        if (layer == 0) {
            canvas.drawBitmap(this.f991l.stage.m825b(2), VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, (Paint) null);
            canvas.drawBitmap(this.f991l.stage.m825b(0), VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, (Paint) null);
        } else if (layer == 1) {
            canvas.drawBitmap(this.f991l.stage.m825b(4), VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, (Paint) null);
            canvas.drawBitmap(this.f991l.stage.m825b(3), VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, (Paint) null);
        } else if (layer == -1) {
            int selectLayer = getSelectLayer();
            if (selectLayer == 0) {
                canvas.drawBitmap(this.f991l.stage.m825b(2), VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, (Paint) null);
                canvas.drawBitmap(this.f991l.stage.m825b(0), VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, (Paint) null);
            } else if (selectLayer == 1) {
                canvas.drawBitmap(this.f991l.stage.m825b(4), VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, (Paint) null);
                canvas.drawBitmap(this.f991l.stage.m825b(3), VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, (Paint) null);
            }
        } else if (layer == -2) {
            canvas.drawBitmap(this.f991l.stage.m825b(2), VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, (Paint) null);
            canvas.drawBitmap(this.f991l.stage.m825b(0), VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, (Paint) null);
            canvas.drawBitmap(this.f991l.stage.m825b(4), VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, (Paint) null);
            canvas.drawBitmap(this.f991l.stage.m825b(3), VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, (Paint) null);
        }
        this.f991l.stage.clearLayer(2);
        this.f991l.stage.drawBackgroundTheme();
        LinkedList<AbstractSprite> sprites = this.f991l.stage.getSprites();
        if (selectedSprites.size() == 0) {
            this.f991l.stage.m817a(2, linkedListM811a);
            this.f991l.stage.m817a(2, linkedListM811a2);
        } else if (abstractSprite instanceof TextSprite) {
            this.f991l.stage.m817a(2, linkedListM811a);
            abstractSprite.setVisible(false);
            Iterator<AbstractSprite> it = sprites.iterator();
            while (it.hasNext()) {
                AbstractSprite next = it.next();
                if ((next instanceof TextSprite) && next != abstractSprite) {
                    this.f991l.stage.renderSprite(2, next);
                }
            }
        } else if (abstractSprite instanceof C0989ab) {
            this.f991l.stage.m818a(2, linkedListM811a, abstractSprite);
            Iterator<AbstractSprite> it2 = sprites.iterator();
            while (it2.hasNext()) {
                AbstractSprite next2 = it2.next();
                if (next2 instanceof TextSprite) {
                    this.f991l.stage.renderSprite(2, next2);
                }
            }
        }
        return bitmapCreateBitmap;
    }

    public void setBitmap(Bitmap bm, boolean bCopyBimap) {
        setBitmap(bm, bCopyBimap, -2);
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00d0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setBitmap(android.graphics.Bitmap r11, boolean r12, int r13) {
        /*
            r10 = this;
            r9 = 0
            r1 = 1
            r8 = 0
            r2 = 0
            if (r11 == 0) goto Le
            boolean r0 = r11.isMutable()
            if (r0 != 0) goto Lf
            if (r12 != 0) goto Lf
        Le:
            return
        Lf:
            if (r13 != 0) goto L70
            r0 = r1
        L12:
            int r4 = r10.getSelectLayer()
            if (r0 == 0) goto L88
            r10.setSelectLayer(r2)
            com.samsung.sdraw.ModeContext r1 = r10.f991l
            com.samsung.sdraw.AbstractStage r1 = r1.stage
            r1.clearStage()
            r1 = r2
        L23:
            r10.setSelectLayer(r4)
            if (r12 == 0) goto Lb3
            if (r0 == 0) goto L93
            com.samsung.sdraw.ModeContext r3 = r10.f991l
            com.samsung.sdraw.AbstractStage r3 = r3.stage
            int r5 = r11.getWidth()
            int r6 = r11.getHeight()
            android.graphics.Bitmap$Config r7 = android.graphics.Bitmap.Config.ARGB_8888
            android.graphics.Bitmap r5 = android.graphics.Bitmap.createBitmap(r5, r6, r7)
            r3.f845i = r5
            android.graphics.Canvas r3 = new android.graphics.Canvas
            com.samsung.sdraw.ModeContext r5 = r10.f991l
            com.samsung.sdraw.AbstractStage r5 = r5.stage
            android.graphics.Bitmap r5 = r5.f845i
            r3.<init>(r5)
        L49:
            r3.drawBitmap(r11, r8, r8, r9)
        L4c:
            if (r0 == 0) goto Lc3
            com.samsung.sdraw.ModeContext r0 = r10.f991l
            com.samsung.sdraw.AbstractStage r0 = r0.stage
            android.graphics.Canvas r0 = r0.m830c(r2)
            r0.drawBitmap(r11, r8, r8, r9)
        L59:
            r10.setSelectLayer(r1)
            com.samsung.sdraw.ModeContext r0 = r10.f991l
            com.samsung.sdraw.CanvasView$OnHistoryChangeListener r0 = r0.historyChangeListener
            if (r0 == 0) goto L69
            com.samsung.sdraw.ModeContext r0 = r10.f991l
            com.samsung.sdraw.CanvasView$OnHistoryChangeListener r0 = r0.historyChangeListener
            r0.onHistoryChanged(r2, r2)
        L69:
            r10.setSelectLayer(r4)
            r10.invalidate()
            goto Le
        L70:
            if (r13 != r1) goto L74
            r0 = r2
            goto L12
        L74:
            r0 = -1
            if (r13 != r0) goto L83
            int r0 = r10.getSelectLayer()
            if (r0 != 0) goto L7f
            r0 = r1
            goto L12
        L7f:
            if (r0 != r1) goto Ld0
            r0 = r2
            goto L12
        L83:
            r0 = -2
            if (r13 != r0) goto Ld0
            r0 = r2
            goto L12
        L88:
            r10.setSelectLayer(r1)
            com.samsung.sdraw.ModeContext r3 = r10.f991l
            com.samsung.sdraw.AbstractStage r3 = r3.stage
            r3.clearStage()
            goto L23
        L93:
            com.samsung.sdraw.ModeContext r3 = r10.f991l
            com.samsung.sdraw.AbstractStage r3 = r3.stage
            int r5 = r11.getWidth()
            int r6 = r11.getHeight()
            android.graphics.Bitmap$Config r7 = android.graphics.Bitmap.Config.ARGB_8888
            android.graphics.Bitmap r5 = android.graphics.Bitmap.createBitmap(r5, r6, r7)
            r3.fixedSprites2 = r5
            android.graphics.Canvas r3 = new android.graphics.Canvas
            com.samsung.sdraw.ModeContext r5 = r10.f991l
            com.samsung.sdraw.AbstractStage r5 = r5.stage
            android.graphics.Bitmap r5 = r5.fixedSprites2
            r3.<init>(r5)
            goto L49
        Lb3:
            if (r0 == 0) goto Lbc
            com.samsung.sdraw.ModeContext r3 = r10.f991l
            com.samsung.sdraw.AbstractStage r3 = r3.stage
            r3.f845i = r11
            goto L4c
        Lbc:
            com.samsung.sdraw.ModeContext r3 = r10.f991l
            com.samsung.sdraw.AbstractStage r3 = r3.stage
            r3.fixedSprites2 = r11
            goto L4c
        Lc3:
            com.samsung.sdraw.ModeContext r0 = r10.f991l
            com.samsung.sdraw.AbstractStage r0 = r0.stage
            r3 = 3
            android.graphics.Canvas r0 = r0.m830c(r3)
            r0.drawBitmap(r11, r8, r8, r9)
            goto L59
        Ld0:
            r0 = r2
            goto L12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.samsung.sdraw.CanvasView.setBitmap(android.graphics.Bitmap, boolean, int):void");
    }

    public byte[] getData() {
        return getData(-2);
    }

    public byte[] getData(int layer) {
        if (this.f991l == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Bitmap bitmap = getBitmap(false, layer);
        if (bitmap != null) {
            bitmap.compress(Bitmap.CompressFormat.PNG, 0, byteArrayOutputStream);
        }
        return byteArrayOutputStream.toByteArray();
    }

    public void setData(byte[] drawingData) {
        setData(drawingData, -2);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0092  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setData(byte[] r9, int r10) {
        /*
            r8 = this;
            r7 = 0
            r1 = 1
            r6 = 0
            r2 = 0
            if (r9 != 0) goto L7
        L6:
            return
        L7:
            int r0 = r9.length
            android.graphics.Bitmap r3 = android.graphics.BitmapFactory.decodeByteArray(r9, r2, r0)
            if (r3 == 0) goto L6
            if (r10 != 0) goto L54
            r0 = r1
        L11:
            int r4 = r8.getSelectLayer()
            if (r0 == 0) goto L6c
            r8.setSelectLayer(r2)
            com.samsung.sdraw.ModeContext r1 = r8.f991l
            com.samsung.sdraw.AbstractStage r1 = r1.stage
            r1.clearStage()
            r1 = r2
        L22:
            r8.setSelectLayer(r4)
            if (r0 == 0) goto L77
            android.graphics.Canvas r0 = new android.graphics.Canvas
            com.samsung.sdraw.ModeContext r5 = r8.f991l
            com.samsung.sdraw.AbstractStage r5 = r5.stage
            android.graphics.Bitmap r5 = r5.f845i
            r0.<init>(r5)
            r0.drawBitmap(r3, r6, r6, r7)
            com.samsung.sdraw.ModeContext r0 = r8.f991l
            com.samsung.sdraw.AbstractStage r0 = r0.stage
            android.graphics.Canvas r0 = r0.m830c(r2)
            r0.drawBitmap(r3, r6, r6, r7)
        L40:
            r8.setSelectLayer(r1)
            com.samsung.sdraw.ModeContext r0 = r8.f991l
            com.samsung.sdraw.CanvasView$OnHistoryChangeListener r0 = r0.historyChangeListener
            if (r0 == 0) goto L50
            com.samsung.sdraw.ModeContext r0 = r8.f991l
            com.samsung.sdraw.CanvasView$OnHistoryChangeListener r0 = r0.historyChangeListener
            r0.onHistoryChanged(r2, r2)
        L50:
            r8.setSelectLayer(r4)
            goto L6
        L54:
            if (r10 != r1) goto L58
            r0 = r2
            goto L11
        L58:
            r0 = -1
            if (r10 != r0) goto L67
            int r0 = r8.getSelectLayer()
            if (r0 != 0) goto L63
            r0 = r1
            goto L11
        L63:
            if (r0 != r1) goto L92
            r0 = r2
            goto L11
        L67:
            r0 = -2
            if (r10 != r0) goto L92
            r0 = r2
            goto L11
        L6c:
            r8.setSelectLayer(r1)
            com.samsung.sdraw.ModeContext r5 = r8.f991l
            com.samsung.sdraw.AbstractStage r5 = r5.stage
            r5.clearStage()
            goto L22
        L77:
            android.graphics.Canvas r0 = new android.graphics.Canvas
            com.samsung.sdraw.ModeContext r5 = r8.f991l
            com.samsung.sdraw.AbstractStage r5 = r5.stage
            android.graphics.Bitmap r5 = r5.fixedSprites2
            r0.<init>(r5)
            r0.drawBitmap(r3, r6, r6, r7)
            com.samsung.sdraw.ModeContext r0 = r8.f991l
            com.samsung.sdraw.AbstractStage r0 = r0.stage
            r5 = 3
            android.graphics.Canvas r0 = r0.m830c(r5)
            r0.drawBitmap(r3, r6, r6, r7)
            goto L40
        L92:
            r0 = r2
            goto L11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.samsung.sdraw.CanvasView.setData(byte[], int):void");
    }

    public void rotateImageSprite(boolean isLeft) {
        if (this.f991l.getMode() == 3) {
            LinkedList<AbstractSprite> sprites = this.f991l.stage.getSprites();
            int size = sprites.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                AbstractSprite abstractSprite = sprites.get(i);
                if (!(abstractSprite instanceof C0989ab) || !abstractSprite.isSelected()) {
                    i++;
                } else {
                    C0989ab c0989ab = (C0989ab) abstractSprite;
                    int i2 = c0989ab.f1423j;
                    c0989ab.m1260b(isLeft ? -90 : 90);
                    this.f991l.stage.rotateSprite(abstractSprite, c0989ab.f1423j, i2, true);
                }
            }
            if (this.f991l.modes.containsKey(Integer.valueOf(getUserID()))) {
                ((SelectMode) this.f991l.modes.get(Integer.valueOf(getUserID()))).m1088a(this.f991l);
            }
            if (this.f991l.historyChangeListener != null) {
                this.f991l.historyChangeListener.onHistoryChanged(this.f991l.stage.isUndoable(), this.f991l.stage.isRedoable());
            }
        }
    }

    public boolean deleteSelectedObject() {
        Iterator<AbstractSprite> it = this.f991l.stage.getSprites().iterator();
        while (it.hasNext()) {
            AbstractSprite next = it.next();
            if (next.isSelected()) {
                if (next instanceof C0989ab) {
                    if (this.f968bm != null) {
                        this.f968bm.onObjectSelected(((C0989ab) next).m1262c(), false);
                    }
                    this.f991l.stage.deleteSprite(next, true);
                    changeModeTo(this.f1003x);
                    this.f991l.invalidate();
                    if (this.f991l.historyChangeListener != null) {
                        this.f991l.historyChangeListener.onHistoryChanged(this.f991l.stage.isUndoable(), this.f991l.stage.isRedoable());
                    }
                    return true;
                }
                if (next instanceof TextSprite) {
                    this.f991l.getTextMode(getUserID()).onFinishJob(this.f991l);
                    if (this.f968bm != null) {
                        this.f968bm.onObjectSelected(((TextSprite) next).m1203j(), false);
                    }
                    this.f991l.stage.deleteSprite(next, true);
                    next.deselect();
                    showTextBox(false);
                    restoreTextSettingInfo();
                    if (this.f916ai != null) {
                        this.f916ai.setText("");
                    }
                    this.f991l.stage.renderAllSprites(false, 1);
                    if (this.f991l.historyChangeListener != null) {
                        this.f991l.historyChangeListener.onHistoryChanged(this.f991l.stage.isUndoable(), this.f991l.stage.isRedoable());
                    }
                    return true;
                }
            }
        }
        if (!isShowTextBox()) {
            return false;
        }
        showTextBox(false);
        restoreTextSettingInfo();
        if (this.f916ai != null) {
            this.f916ai.setText("");
        }
        return true;
    }

    /* renamed from: com.samsung.sdraw.CanvasView$a */
    private class HandlerC0969a extends Handler {
        private HandlerC0969a() {
        }

        /* synthetic */ HandlerC0969a(CanvasView canvasView, HandlerC0969a handlerC0969a) {
            this();
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 2:
                    if (!CanvasView.this.f857A) {
                        Bundle data = msg.getData();
                        MotionEvent motionEventObtain = MotionEvent.obtain(0L, 0L, 0, data.getFloat("pos_x"), data.getFloat("pos_y"), 0);
                        int userID = CanvasView.this.getUserID();
                        if (CanvasView.this.f991l.getMode(userID) == 1 || CanvasView.this.f991l.getMode(userID) == 2) {
                            CanvasView.this.f1003x = CanvasView.this.getMode(userID);
                            AbstractSprite abstractSpriteSelectHittedSprite = CanvasView.this.f991l.stage.selectHittedSprite(new PointF(motionEventObtain.getX(), motionEventObtain.getY()));
                            if (abstractSpriteSelectHittedSprite != null) {
                                CanvasView.this.f991l.removeCurrentStrokeSpriteForce();
                                if (abstractSpriteSelectHittedSprite instanceof TextSprite) {
                                    TextSprite textSprite = (TextSprite) abstractSpriteSelectHittedSprite;
                                    textSprite.select();
                                    CanvasView.this.f991l.changeModeTo(4);
                                    CanvasView.this.f991l.getTextMode(userID).m1182a(true);
                                    CanvasView.this.f991l.onTouchEvent(motionEventObtain);
                                    CanvasView.this.f991l.getTextMode(userID).m1182a(false);
                                    if (!CanvasView.this.f877U) {
                                        CanvasView.this.setMinZoom(1.0f);
                                        CanvasView.this.zoomTo(1.0f);
                                    }
                                    abstractSpriteSelectHittedSprite.setVisible(false);
                                    CanvasView.this.createTextBox(CanvasView.this.f991l.stage.mapFromScene(textSprite.getBounds()), textSprite.m1201h(), new TextInfo(textSprite.m1195b(), textSprite.m1197d(), textSprite.m1201h().toString(), textSprite.m1202i(), textSprite.m1198e(), textSprite.m1199f(), textSprite.m1200g()));
                                    CanvasView.this.f991l.getTextMode(userID).m1180a((AbstractModeContext) CanvasView.this.f991l, false);
                                    if (CanvasView.this.f959bd) {
                                        CanvasView.this.f931ax = true;
                                    }
                                    if (!CanvasView.this.f877U) {
                                        CanvasView.this.setZoomEnable(false);
                                    }
                                    CanvasView.this.f857A = true;
                                    if (CanvasView.this.f947bM != null) {
                                        CanvasView.this.f947bM.onModeChanged(4);
                                    }
                                } else if (abstractSpriteSelectHittedSprite instanceof C0989ab) {
                                    CanvasView.this.setEnableZoom(true);
                                    CanvasView.this.m974a(false);
                                    CanvasView.this.f991l.changeModeTo(3);
                                    CanvasView.this.f991l.onTouchEvent(motionEventObtain);
                                    if (CanvasView.this.f947bM != null) {
                                        CanvasView.this.f947bM.onModeChanged(3);
                                    }
                                }
                            } else {
                                if (CanvasView.this.f935bA != null && CanvasView.this.f948bN) {
                                    CanvasView.this.f935bA.onLongPress();
                                    CanvasView.this.f935bA.onLongPress(motionEventObtain.getX(), motionEventObtain.getY());
                                    CanvasView.this.f857A = true;
                                }
                                if (CanvasView.this.f951bQ) {
                                    CanvasView.this.f991l.removeCurrentStrokeSpriteForce();
                                }
                                CanvasView.this.f991l.invalidate();
                            }
                        } else if (CanvasView.this.f935bA != null && CanvasView.this.f948bN) {
                            if (CanvasView.this.isShowTextBox()) {
                                CanvasView.this.hideImm();
                            }
                            CanvasView.this.f935bA.onLongPress();
                            CanvasView.this.f935bA.onLongPress(motionEventObtain.getX(), motionEventObtain.getY());
                            CanvasView.this.f857A = true;
                        }
                        motionEventObtain.recycle();
                        super.handleMessage(msg);
                        return;
                    }
                    return;
                default:
                    throw new RuntimeException("Unknown message " + msg);
            }
        }
    }

    protected boolean drawImageObject(ImageInfo imageInfo, boolean select) {
        AbstractSprite next;
        if ((this.f991l != null && this.f991l.setting.m1121l()) || imageInfo.getImg().isRecycled() || this.f991l == null || this.f991l.factory == null) {
            return false;
        }
        if (!this.f991l.modes.containsKey(Integer.valueOf(getUserID()))) {
            this.f991l.createNewMode(getUserID());
            this.f991l.stage.m814a(getUserID());
        }
        Canvas canvas = new Canvas();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(imageInfo.getImg().getWidth(), imageInfo.getImg().getHeight(), Bitmap.Config.ARGB_8888);
        canvas.setBitmap(bitmapCreateBitmap);
        canvas.drawBitmap(imageInfo.getImg(), VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, new Paint());
        RectF rect = imageInfo.getRect();
        float angle = imageInfo.getAngle();
        PointF pointF = new PointF(rect.width(), rect.height());
        PointF pointF2 = new PointF(rect.left, rect.top);
        C0989ab c0989abMo1404a = this.f991l.factory.mo1404a((int) pointF2.x, (int) pointF2.y, (int) pointF.x, (int) pointF.y, getSelectLayer() == 0 ? 2 : 4, 0);
        c0989abMo1404a.objectID = imageInfo.getID();
        c0989abMo1404a.multiUserID = getUserID();
        c0989abMo1404a.multiObjectID = 0;
        c0989abMo1404a.m1257a(bitmapCreateBitmap);
        c0989abMo1404a.m1260b((int) angle);
        if (select) {
            if (getMode() != 3) {
                this.f1003x = getMode();
            }
            c0989abMo1404a.select();
            this.f991l.changeModeTo(3);
            if (this.f947bM != null) {
                this.f947bM.onModeChanged(3);
            }
        }
        this.f991l.stage.addSprite(c0989abMo1404a, true, getUserID());
        if (select) {
            if (this.f968bm != null) {
                this.f968bm.onObjectSelected(c0989abMo1404a.m1262c(), true);
            }
            this.f991l.stage.renderSprite(1, c0989abMo1404a);
        } else {
            LinkedList<AbstractSprite> linkedListM811a = this.f991l.stage.m811a(C0989ab.class);
            LinkedList<AbstractSprite> linkedListM826b = this.f991l.stage.m826b(C0989ab.class);
            LinkedList<AbstractSprite> linkedListM811a2 = this.f991l.stage.m811a(TextSprite.class);
            LinkedList<AbstractSprite> linkedListM826b2 = this.f991l.stage.m826b(TextSprite.class);
            Iterator<AbstractSprite> it = this.f991l.stage.getSelectedSprites().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (next.isSelected()) {
                    break;
                }
            }
            if (next instanceof C0989ab) {
                this.f991l.stage.m818a(2, linkedListM811a, next);
                this.f991l.stage.m817a(2, linkedListM811a2);
                this.f991l.stage.m818a(4, linkedListM826b, next);
                this.f991l.stage.m817a(4, linkedListM826b2);
            } else {
                this.f991l.stage.m817a(2, linkedListM811a);
                this.f991l.stage.m818a(2, linkedListM811a2, next);
                this.f991l.stage.m817a(4, linkedListM826b);
                this.f991l.stage.m818a(4, linkedListM826b2, next);
            }
        }
        this.f991l.invalidate();
        return true;
    }

    protected boolean drawImageObject(int userID, int imageID, ImageInfo imageInfo) {
        AbstractSprite next;
        if ((this.f991l != null && this.f991l.setting.m1121l()) || imageInfo.getImg().isRecycled() || this.f991l == null) {
            return false;
        }
        int selectLayer = getSelectLayer();
        if (userID == getUserID()) {
            this.f991l.stage.setSelectLayer(imageInfo.getLayerID());
        }
        if (!this.f991l.modes.containsKey(Integer.valueOf(userID))) {
            this.f991l.createNewMode(userID);
            this.f991l.stage.m814a(userID);
        }
        Canvas canvas = new Canvas();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(imageInfo.getImg().getWidth(), imageInfo.getImg().getHeight(), Bitmap.Config.ARGB_8888);
        canvas.setBitmap(bitmapCreateBitmap);
        canvas.drawBitmap(imageInfo.getImg(), VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, new Paint());
        RectF rect = imageInfo.getRect();
        float angle = imageInfo.getAngle();
        PointF pointF = new PointF(rect.width(), rect.height());
        PointF pointF2 = new PointF(rect.left, rect.top);
        int i = 4;
        if (imageInfo.getLayerID() == 0 || userID != getUserID()) {
            i = 2;
        }
        C0989ab c0989abMo1404a = this.f991l.factory.mo1404a((int) pointF2.x, (int) pointF2.y, (int) pointF.x, (int) pointF.y, i, 0);
        c0989abMo1404a.objectID = imageInfo.getID();
        c0989abMo1404a.multiUserID = userID;
        c0989abMo1404a.multiObjectID = imageID;
        c0989abMo1404a.m1257a(bitmapCreateBitmap);
        c0989abMo1404a.m1260b((int) angle);
        this.f991l.stage.addSprite(c0989abMo1404a, true, userID);
        LinkedList<AbstractSprite> linkedListM811a = this.f991l.stage.m811a(C0989ab.class);
        LinkedList<AbstractSprite> linkedListM826b = this.f991l.stage.m826b(C0989ab.class);
        LinkedList<AbstractSprite> linkedListM811a2 = this.f991l.stage.m811a(TextSprite.class);
        LinkedList<AbstractSprite> linkedListM826b2 = this.f991l.stage.m826b(TextSprite.class);
        Iterator<AbstractSprite> it = this.f991l.stage.getSelectedSprites().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (next.isSelected()) {
                break;
            }
        }
        if (next instanceof C0989ab) {
            this.f991l.stage.m818a(2, linkedListM811a, next);
            this.f991l.stage.m817a(2, linkedListM811a2);
            this.f991l.stage.m818a(4, linkedListM826b, next);
            this.f991l.stage.m817a(4, linkedListM826b2);
        } else {
            this.f991l.stage.m817a(2, linkedListM811a);
            this.f991l.stage.m818a(2, linkedListM811a2, next);
            this.f991l.stage.m817a(4, linkedListM826b);
            this.f991l.stage.m818a(4, linkedListM826b2, next);
        }
        this.f991l.invalidate();
        if (userID == getUserID()) {
            this.f991l.stage.setSelectLayer(selectLayer);
        }
        return true;
    }

    protected void dispose() {
        this.f991l.dispose();
    }

    public void changeModeTo(int mode) {
        changeModeTo(getUserID(), mode);
    }

    public void changeModeTo(int userID, int mode) {
        if (this.f991l.getMode(userID) != mode && this.f991l.getMode(userID) != -1) {
            boolean z = userID == getUserID();
            if (z && this.f931ax) {
                setZoomEnable(true);
                this.f931ax = false;
            }
            if (mode == 1) {
                if (z && this.f932ay) {
                    setZoomEnable(true);
                    this.f932ay = false;
                }
                m975a(false, userID);
                if (z && !this.f877U) {
                    int mode2 = this.f991l.getMode();
                    this.f991l.changeModeTo(userID, 1);
                    if (mode2 == 4 && !this.f877U) {
                        m872a(getWidth(), getHeight());
                    }
                } else {
                    this.f991l.changeModeTo(userID, 1);
                }
            } else if (mode == 2) {
                if (z && this.f932ay) {
                    setZoomEnable(true);
                    this.f932ay = false;
                }
                if (getMode(userID) == 1) {
                    if (z && this.f881a != null && this.f881a.getPenType() != 4) {
                        this.f986g.put(Integer.valueOf(userID), Integer.valueOf(this.f881a.getPenType()));
                    } else {
                        this.f986g.put(Integer.valueOf(userID), Integer.valueOf(getPenSettingInfo(userID).getPenType()));
                    }
                }
                m975a(true, userID);
                if (z && !this.f877U) {
                    int mode3 = this.f991l.getMode();
                    this.f991l.changeModeTo(userID, 2);
                    if (mode3 == 4 && !this.f877U) {
                        m872a(getWidth(), getHeight());
                    }
                } else {
                    this.f991l.changeModeTo(userID, 2);
                }
            } else if (mode == 3) {
                if (!this.f991l.setting.m1121l()) {
                    if (z && this.f932ay) {
                        setZoomEnable(true);
                        this.f932ay = false;
                    }
                    if (getMode(userID) == 1) {
                        if (this.f881a != null) {
                            this.f986g.put(Integer.valueOf(userID), Integer.valueOf(this.f881a.getPenType()));
                        } else {
                            this.f986g.put(Integer.valueOf(userID), Integer.valueOf(getPenSettingInfo(userID).getPenType()));
                        }
                    }
                    if (z && !this.f877U) {
                        int mode4 = this.f991l.getMode();
                        this.f991l.changeModeTo(userID, 3);
                        if (mode4 == 4) {
                            m872a(getWidth(), getHeight());
                        }
                    } else {
                        this.f991l.changeModeTo(userID, 3);
                    }
                } else {
                    return;
                }
            } else if (mode == 4) {
                if (!this.f991l.setting.m1121l()) {
                    if (z) {
                        if (!this.f933az) {
                            m949k();
                            this.f933az = true;
                        }
                        if (this.f1001v != null) {
                            this.f1001v.closeView();
                        }
                    }
                    if (getMode(userID) == 1) {
                        if (this.f881a != null) {
                            this.f986g.put(Integer.valueOf(userID), Integer.valueOf(this.f881a.getPenType()));
                        } else {
                            this.f986g.put(Integer.valueOf(userID), Integer.valueOf(getPenSettingInfo(userID).getPenType()));
                        }
                    }
                    this.f991l.changeModeTo(userID, 4);
                    if (z && !this.f877U) {
                        setMinZoom(1.0f);
                        zoomTo(1.0f);
                        if (this.f959bd) {
                            this.f932ay = true;
                            setZoomEnable(false);
                        }
                    }
                } else {
                    return;
                }
            } else if (mode == 5) {
                if (z && this.f932ay) {
                    setZoomEnable(true);
                    this.f932ay = false;
                }
                if (getMode(userID) == 1) {
                    if (this.f881a != null) {
                        this.f986g.put(Integer.valueOf(userID), Integer.valueOf(this.f881a.getPenType()));
                    } else {
                        this.f986g.put(Integer.valueOf(userID), Integer.valueOf(getPenSettingInfo(userID).getPenType()));
                    }
                }
                if (z && !this.f877U) {
                    int mode5 = this.f991l.getMode();
                    this.f991l.changeModeTo(userID, 5);
                    if (mode5 == 4) {
                        m872a(getWidth(), getHeight());
                    }
                } else {
                    this.f991l.changeModeTo(userID, 5);
                }
            }
            if (this.f947bM != null) {
                this.f947bM.onModeChanged(mode);
            }
        }
    }

    public void changeModeToNoListener(int mode) {
        int userID = getUserID();
        if (this.f991l.getMode(userID) != mode && this.f991l.getMode(userID) != -1) {
            if (this.f931ax) {
                setZoomEnable(true);
                this.f931ax = false;
            }
            if (mode == 1) {
                if (this.f932ay) {
                    setZoomEnable(true);
                    this.f932ay = false;
                }
                m975a(false, userID);
                if (!this.f877U) {
                    int mode2 = this.f991l.getMode();
                    this.f991l.changeModeTo(userID, 1);
                    if (mode2 == 4 && !this.f877U) {
                        m872a(getWidth(), getHeight());
                        return;
                    }
                    return;
                }
                this.f991l.changeModeTo(userID, 1);
                return;
            }
            if (mode == 2) {
                if (this.f932ay) {
                    setZoomEnable(true);
                    this.f932ay = false;
                }
                if (getMode(userID) == 1 && this.f881a != null && this.f881a.getPenType() != 4) {
                    this.f986g.put(Integer.valueOf(userID), Integer.valueOf(this.f881a.getPenType()));
                }
                m975a(true, userID);
                if (!this.f877U) {
                    int mode3 = this.f991l.getMode();
                    this.f991l.changeModeTo(userID, 2);
                    if (mode3 == 4 && !this.f877U) {
                        m872a(getWidth(), getHeight());
                        return;
                    }
                    return;
                }
                this.f991l.changeModeTo(userID, 2);
                return;
            }
            if (mode == 3) {
                if (!this.f991l.setting.m1121l()) {
                    if (this.f932ay) {
                        setZoomEnable(true);
                        this.f932ay = false;
                    }
                    if (getMode(userID) == 1 && this.f881a != null) {
                        this.f986g.put(Integer.valueOf(userID), Integer.valueOf(this.f881a.getPenType()));
                    }
                    if (!this.f877U) {
                        int mode4 = this.f991l.getMode();
                        this.f991l.changeModeTo(userID, 3);
                        if (mode4 == 4) {
                            m872a(getWidth(), getHeight());
                            return;
                        }
                        return;
                    }
                    this.f991l.changeModeTo(userID, 3);
                    return;
                }
                return;
            }
            if (mode == 4) {
                if (!this.f991l.setting.m1121l()) {
                    if (!this.f933az) {
                        m949k();
                        this.f933az = true;
                    }
                    if (this.f1001v != null) {
                        this.f1001v.closeView();
                    }
                    if (getMode(userID) == 1 && this.f881a != null) {
                        this.f986g.put(Integer.valueOf(userID), Integer.valueOf(this.f881a.getPenType()));
                    }
                    this.f991l.changeModeTo(userID, 4);
                    if (!this.f877U) {
                        setMinZoom(1.0f);
                        zoomTo(1.0f);
                        if (this.f959bd) {
                            this.f932ay = true;
                            setZoomEnable(false);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            if (mode == 5) {
                if (this.f932ay) {
                    setZoomEnable(true);
                    this.f932ay = false;
                }
                if (getMode(userID) == 1 && this.f881a != null) {
                    this.f986g.put(Integer.valueOf(userID), Integer.valueOf(this.f881a.getPenType()));
                }
                if (!this.f877U) {
                    int mode5 = this.f991l.getMode();
                    this.f991l.changeModeTo(userID, 5);
                    if (mode5 == 4) {
                        m872a(getWidth(), getHeight());
                        return;
                    }
                    return;
                }
                this.f991l.changeModeTo(userID, 5);
            }
        }
    }

    /* renamed from: a */
    ModeContext m969a() {
        return this.f991l;
    }

    public void setOnHistoryChangeListener(OnHistoryChangeListener listener) {
        this.f991l.historyChangeListener = listener;
    }

    public boolean isUndoable() {
        return this.f991l.isUndoable();
    }

    public boolean isRedoable() {
        return this.f991l.isRedoable();
    }

    protected boolean isUndoable(int userId) {
        return this.f991l.isUndoable(userId);
    }

    protected boolean isRedoable(int userId) {
        return this.f991l.isRedoable(userId);
    }

    public boolean undo() {
        if (this.f991l == null) {
            return false;
        }
        if ((this.f991l.setting != null && !this.f991l.setting.bHistoricalOperationSupport) || !this.f991l.isUndoable()) {
            return false;
        }
        this.f991l.undo();
        if (isShowTextBox()) {
            showTextBox(false);
            restoreTextSettingInfo();
        }
        return true;
    }

    public boolean redo() {
        if (this.f991l == null) {
            return false;
        }
        if ((this.f991l.setting != null && !this.f991l.setting.bHistoricalOperationSupport) || !this.f991l.isRedoable()) {
            return false;
        }
        this.f991l.redo();
        if (isShowTextBox()) {
            showTextBox(false);
            restoreTextSettingInfo();
        }
        return true;
    }

    protected boolean undo(int userId) {
        if (this.f991l == null) {
            return false;
        }
        if ((this.f991l.setting != null && !this.f991l.setting.bHistoricalOperationSupport) || !this.f991l.isUndoable(userId)) {
            return false;
        }
        this.f991l.undo(userId);
        if (userId == getUserID() && isShowTextBox()) {
            showTextBox(false);
            restoreTextSettingInfo();
        }
        return true;
    }

    protected boolean redo(int userId) {
        if (this.f991l == null) {
            return false;
        }
        if ((this.f991l.setting != null && !this.f991l.setting.bHistoricalOperationSupport) || !this.f991l.isRedoable(userId)) {
            return false;
        }
        this.f991l.redo(userId);
        if (userId == getUserID() && isShowTextBox()) {
            showTextBox(false);
            restoreTextSettingInfo();
        }
        return true;
    }

    public void setSettingView(SettingView view) {
        if (view != null) {
            this.f1001v = view;
            this.f984e = this.f1001v.f772e;
            this.f1001v.m771a(this.f989j);
            if (this.f881a == null) {
                this.f881a = new PenSettingInfo(getContext());
                if (this.f881a != null) {
                    this.f881a.m1023a(this.f884aC);
                }
            } else {
                this.f881a.m1023a(this.f884aC);
            }
            if (this.f993n == null) {
                this.f993n = new TextSettingInfo(getContext());
                if (this.f993n != null) {
                    this.f993n.m1185a(this.f886aE);
                }
            } else {
                this.f993n.m1185a(this.f886aE);
            }
            this.f1001v.m772a(this);
            if (this.f916ai != null) {
                this.f916ai.setHint(this.f1001v.m783d());
                this.f916ai.setTextSize(this.f1001v.m785f());
            }
            if (this.f1001v.isDeleteDefaultDescription()) {
                this.f922ao = "";
            }
            this.f922ao = this.f1001v.m790k();
            if (this.f870N != null) {
                this.f870N.setContentDescription(this.f922ao);
            }
            SelectMode selectMode = this.f991l.getSelectMode(getUserID());
            if (selectMode != null) {
                if (this.f1001v.isDeleteDefaultDescription()) {
                    selectMode.m1087a();
                }
                selectMode.m1093a(this.f1001v.m791l());
                selectMode.m1094b(this.f1001v.m792m());
                selectMode.m1095c(this.f1001v.m793n());
            }
        }
    }

    public TextSettingInfo getTextSettingInfo() {
        return getTextSettingInfo(getUserID());
    }

    public TextSettingInfo getTextSettingInfo(int userID) {
        if (userID == getUserID()) {
            if (this.f993n == null) {
                this.f993n = new TextSettingInfo(getContext());
                this.f991l.setting.setTextSettingInfos(userID, this.f993n);
                this.f993n.m1185a(this.f886aE);
            }
            return this.f993n;
        }
        TextSettingInfo textSettingInfo = this.f991l.setting.getTextSettingInfo(userID);
        if (textSettingInfo == null) {
            TextSettingInfo textSettingInfo2 = new TextSettingInfo(getContext());
            this.f991l.setting.setTextSettingInfos(userID, textSettingInfo2);
            return textSettingInfo2;
        }
        return textSettingInfo;
    }

    public void setTextSettingInfo(TextSettingInfo info) {
        setTextSettingInfo(getUserID(), info);
    }

    public void setTextSettingInfo(int userID, TextSettingInfo info) {
        if (info != null && this.f991l != null && this.f991l.setting != null) {
            this.f991l.setting.setTextSettingInfos(userID, info);
            if (userID == getUserID() && this.f993n != null) {
                this.f993n.setTextType(info.getTextType());
                this.f993n.setTextColor(info.getTextColor());
                this.f993n.setTextSize(info.getTextSize());
                this.f993n.setTextFont(info.getTextFont());
                this.f993n.setTextAlignment(info.getTextAlignment());
                this.f993n.m1185a(this.f886aE);
                this.f886aE.mo987a(this.f993n.getTextType());
                this.f886aE.mo990b(this.f993n.getTextColor());
                this.f886aE.mo991c(this.f993n.getTextSize());
                this.f886aE.mo989a(this.f993n.getTextFont());
                this.f886aE.mo988a(this.f993n.getTextAlignment());
            }
        }
    }

    public TextSettingInfo getTextSettingViewInfo() {
        if (this.f1001v == null) {
            return null;
        }
        if (this.f1001v.f749b == null) {
            this.f1001v.m787h();
        }
        return this.f1001v.f749b;
    }

    public void setTextSettingViewInfo(TextSettingInfo info) {
        if (info != null && this.f991l != null && this.f991l.setting != null) {
            this.f991l.setting.setTextSettingInfos(getUserID(), info);
            if (this.f993n != null) {
                this.f993n.setTextType(info.getTextType());
                this.f993n.setTextColor(info.getTextColor());
                this.f993n.setTextSize(info.getTextSize());
                this.f993n.setTextFont(info.getTextFont());
                this.f993n.setTextAlignment(info.getTextAlignment());
                this.f993n.m1185a(this.f886aE);
                this.f886aE.mo987a(this.f993n.getTextType());
                this.f886aE.mo990b(this.f993n.getTextColor());
                this.f886aE.mo991c(this.f993n.getTextSize());
                this.f886aE.mo989a(this.f993n.getTextFont());
                this.f886aE.mo988a(this.f993n.getTextAlignment());
                if (this.f1001v != null) {
                    this.f1001v.m781b(this.f993n);
                }
            }
        }
    }

    public PenSettingInfo getPenSettingInfo() {
        return getPenSettingInfo(getUserID());
    }

    public PenSettingInfo getPenSettingInfo(int userID) {
        if (userID == getUserID()) {
            if (this.f881a == null) {
                this.f881a = new PenSettingInfo(getContext());
                this.f991l.setting.setPenSettingInfos(userID, this.f881a);
                this.f881a.m1023a(this.f884aC);
            }
            return this.f881a;
        }
        PenSettingInfo penSettingInfo = this.f991l.setting.getPenSettingInfo(userID);
        if (penSettingInfo == null) {
            PenSettingInfo penSettingInfo2 = new PenSettingInfo(getContext());
            this.f991l.setting.setPenSettingInfos(userID, penSettingInfo2);
            return penSettingInfo2;
        }
        return penSettingInfo;
    }

    public PenSettingInfo getPenSettingViewInfo() {
        if (this.f1001v == null) {
            return null;
        }
        if (this.f1001v.f697a == null) {
            this.f1001v.m786g();
        }
        return this.f1001v.f697a;
    }

    public void setPenSettingInfo(PenSettingInfo info) {
        setPenSettingInfo(getUserID(), info);
    }

    public void setPenSettingInfo(int userID, PenSettingInfo info) {
        if (info != null && this.f991l != null && this.f991l.setting != null) {
            this.f991l.setting.setPenSettingInfos(userID, info);
            if (userID == getUserID() && this.f881a != null) {
                this.f881a.setPenType(info.getPenType());
                this.f881a.setPenColor(info.getPenColor());
                this.f881a.setPenWidth(info.getPenWidth());
                this.f881a.setPenAlpha(info.getPenAlpha());
                if (info.getPenType() == 4) {
                    this.f881a.setEraserWidth(info.getEraserWidth());
                }
                this.f881a.m1023a(this.f884aC);
                int penType = this.f881a.getPenType();
                this.f884aC.mo981a(penType);
                this.f884aC.mo983b(this.f881a.getEraserWidth());
                this.f884aC.mo985c(penType, this.f881a.getPenAlpha(penType));
                this.f884aC.mo984b(penType, this.f881a.getPenColor(penType));
                this.f884aC.mo982a(penType, this.f881a.getPenWidth(penType));
            }
        }
    }

    public void setPenSettingViewInfo(PenSettingInfo info) {
        if (info != null && this.f991l != null && this.f991l.setting != null) {
            this.f991l.setting.setPenSettingInfos(getUserID(), info);
            if (this.f881a != null) {
                this.f881a.setPenType(info.getPenType());
                this.f881a.setPenColor(info.getPenColor());
                this.f881a.setPenWidth(info.getPenWidth());
                this.f881a.setPenAlpha(info.getPenAlpha());
                if (info.getPenType() == 4) {
                    this.f881a.setEraserWidth(info.getEraserWidth());
                }
                this.f881a.m1023a(this.f884aC);
                int penType = this.f881a.getPenType();
                this.f884aC.mo981a(penType);
                this.f884aC.mo983b(this.f881a.getEraserWidth());
                this.f884aC.mo985c(penType, this.f881a.getPenAlpha(penType));
                this.f884aC.mo984b(penType, this.f881a.getPenColor(penType));
                this.f884aC.mo982a(penType, this.f881a.getPenWidth(penType));
            }
            if (this.f1001v != null) {
                this.f1001v.m780b(this.f881a);
            }
        }
    }

    protected FillingSettingInfo getFillingSettingInfo() {
        if (this.f994o == null) {
            this.f994o = new FillingSettingInfo();
            this.f994o.m997a(this.f885aD);
        }
        return this.f994o;
    }

    public FillingSettingInfo getFillingSettingInfo(int userID) {
        if (userID == getUserID()) {
            if (this.f994o == null) {
                this.f994o = new FillingSettingInfo(getContext());
                this.f991l.setting.setFillingSettingInfos(userID, this.f994o);
                this.f994o.m997a(this.f885aD);
            }
            return this.f994o;
        }
        FillingSettingInfo fillingSettingInfo = this.f991l.setting.getFillingSettingInfo(userID);
        if (fillingSettingInfo == null) {
            FillingSettingInfo fillingSettingInfo2 = new FillingSettingInfo(getContext());
            this.f991l.setting.setFillingSettingInfos(userID, fillingSettingInfo2);
            return fillingSettingInfo2;
        }
        return fillingSettingInfo;
    }

    protected void setFillingSettingInfo(FillingSettingInfo info) {
        if (info != null && this.f994o != null) {
            this.f994o.setFillingColor(info.getFillingColor());
            this.f994o.m997a(this.f885aD);
            this.f885aD.mo986a(this.f994o.getFillingColor());
        }
    }

    protected void setFillingSettingInfo(int userID, FillingSettingInfo info) {
        if (info != null && this.f991l != null && this.f991l.setting != null) {
            this.f991l.setting.setFillingSettingInfos(userID, info);
            if (userID == getUserID() && this.f994o != null) {
                this.f994o.setFillingColor(info.getFillingColor());
                this.f994o.m997a(this.f885aD);
                this.f885aD.mo986a(this.f994o.getFillingColor());
            }
        }
    }

    protected FillingSettingInfo getFillingSettingViewInfo() {
        if (this.f1001v == null) {
            return null;
        }
        if (this.f1001v.f770c == null) {
            this.f1001v.m788i();
        }
        return this.f1001v.f770c;
    }

    protected void setFillingSettingViewInfo(FillingSettingInfo info) {
        if (info != null) {
            if (this.f994o != null) {
                this.f994o.setFillingColor(info.getFillingColor());
                this.f994o.m997a(this.f885aD);
                this.f885aD.mo986a(this.f994o.getFillingColor());
            }
            if (this.f1001v != null) {
                this.f1001v.m779b(info);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m871a(int i) {
        StrokeSprite.Type typeM1020a = PenSettingInfo.m1020a(i);
        StrokeSprite.ThicknessParameter thicknessParameterM689a = AbstractSettingView.m689a(i);
        if (this.f991l != null && this.f991l.setting != null) {
            this.f991l.setting.setStrokeType(typeM1020a);
            if (this.f881a != null) {
                this.f991l.setting.setStrokeColor(this.f881a.getPenAlphaColor());
            }
            this.f991l.setting.setStrokeParameter(thicknessParameterM689a);
        }
    }

    /* renamed from: a */
    void m974a(boolean z) {
        m975a(z, getUserID());
    }

    /* renamed from: a */
    void m975a(boolean z, int i) {
        if (this.f991l != null && this.f991l.setting != null) {
            if (i == getUserID()) {
                if (this.f881a != null && this.f1001v != null && this.f1001v.f697a != null) {
                    this.f881a.setPenType(this.f1001v.f697a.getPenType());
                    this.f881a.setPenWidth(this.f1001v.f697a.getPenWidth());
                    this.f881a.setPenColor(this.f1001v.f697a.getPenColor());
                    this.f881a.setPenAlpha(this.f1001v.f697a.getPenAlpha());
                    if (this.f881a.getPenType() == 4) {
                        this.f881a.setEraserWidth(this.f1001v.f697a.getEraserWidth());
                    }
                }
                if (z) {
                    if (this.f881a != null) {
                        if (this.f881a.getPenType() != 4) {
                            this.f986g.put(Integer.valueOf(i), Integer.valueOf(this.f881a.getPenType()));
                        }
                        if (this.f881a.getPenType() != 4) {
                            if (this.f1001v != null && this.f1001v.f697a != null) {
                                this.f1001v.f697a.setPenType(4);
                            }
                            this.f881a.setPenType(4);
                            if (this.f1001v.f697a != null) {
                                this.f881a.setEraserWidth(this.f1001v.f697a.getEraserWidth());
                            }
                            this.f991l.setting.setEraserWidth(this.f881a.getEraserWidth());
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (this.f881a != null && this.f881a.getPenType() == 4) {
                    if (!this.f986g.containsKey(Integer.valueOf(i))) {
                        this.f986g.put(Integer.valueOf(i), 0);
                    }
                    if (this.f1001v != null && this.f1001v.f697a != null) {
                        this.f1001v.f697a.setPenType(this.f986g.get(Integer.valueOf(i)).intValue());
                    }
                    this.f881a.setPenType(this.f986g.get(Integer.valueOf(i)).intValue());
                    this.f881a.setPenWidth(this.f881a.getPenWidth());
                    this.f991l.setting.setStrokeWidth(this.f881a.getPenWidth());
                    return;
                }
                return;
            }
            PenSettingInfo penSettingInfo = getPenSettingInfo(i);
            if (z) {
                if (penSettingInfo != null) {
                    if (penSettingInfo.getPenType() != 4) {
                        this.f986g.put(Integer.valueOf(i), Integer.valueOf(penSettingInfo.getPenType()));
                    }
                    if (penSettingInfo.getPenType() != 4) {
                        penSettingInfo.setPenType(4);
                        penSettingInfo.setEraserWidth(penSettingInfo.getEraserWidth());
                        return;
                    }
                    return;
                }
                return;
            }
            if (penSettingInfo != null && penSettingInfo.getPenType() == 4) {
                if (!this.f986g.containsKey(Integer.valueOf(i))) {
                    this.f986g.put(Integer.valueOf(i), 0);
                }
                penSettingInfo.setPenType(this.f986g.get(Integer.valueOf(i)).intValue());
                penSettingInfo.setPenWidth(penSettingInfo.getPenWidth());
            }
        }
    }

    public void clearAll(boolean isUndoable) {
        if (this.f991l != null) {
            if (isShowTextBox()) {
                this.f991l.getTextMode(getUserID()).f1341a = null;
                this.f916ai.setText("");
                showTextBox(false);
                restoreTextSettingInfo();
            }
            if (this.f968bm != null) {
                Iterator<AbstractSprite> it = this.f991l.stage.getSprites().iterator();
                while (it.hasNext()) {
                    AbstractSprite next = it.next();
                    if (next.isSelected()) {
                        next.deselect();
                        if (next instanceof TextSprite) {
                            this.f968bm.onObjectSelected(((TextSprite) next).m1203j(), false);
                        } else if (next instanceof C0989ab) {
                            this.f968bm.onObjectSelected(((C0989ab) next).m1262c(), false);
                        } else if (next instanceof StrokeSprite) {
                            this.f968bm.onObjectSelected(((StrokeSprite) next).m1174s(), false);
                        } else if (next instanceof C1063s) {
                            this.f968bm.onObjectSelected(((C1063s) next).m1597d(), false);
                        }
                    }
                }
            }
            if (this.f968bm != null) {
                this.f968bm.onObjectDeletedAll(true, getSelectLayer());
            }
            this.f991l.clear();
        }
    }

    public void clearAll() {
        clearAll(true);
    }

    public void clear() {
        if (this.f968bm != null) {
            this.f968bm.onObjectDeletedAll(true, getSelectLayer());
        }
        if (this.f991l != null) {
            this.f991l.clear();
        }
    }

    public void zoomTo(float scale) {
        if (this.f959bd && this.f882aA != null) {
            this.f882aA.m1231c(scale);
        }
    }

    public void panBy(float dx, float dy) {
        if (this.f882aA != null) {
            this.f882aA.m1228b(dx, dy);
        }
    }

    /* renamed from: a */
    private boolean m887a(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3) {
        int canvasWidth = this.f991l.setting.getCanvasWidth();
        int canvasHeight = this.f991l.setting.getCanvasHeight();
        this.f991l.stage.setBackgroundImages(bitmap != null ? m865a(bitmap, canvasWidth, canvasHeight) : null, bitmap2 != null ? m865a(bitmap2, canvasWidth, canvasHeight) : null, bitmap3 != null ? m865a(bitmap3, canvasWidth, canvasHeight) : null);
        this.f991l.drawBackgroundTheme();
        return true;
    }

    /* renamed from: a */
    private Bitmap m865a(Bitmap bitmap, int i, int i2) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (i != 1) {
            width = Math.min(i, bitmap.getWidth());
        }
        if (i2 != 1) {
            height = Math.min(i2, bitmap.getHeight());
        }
        return Bitmap.createScaledBitmap(bitmap, width, height, true);
    }

    public boolean setBackgroundTemplate(Bitmap topBG, Bitmap middleBG, Bitmap bottomBG) {
        return m887a(topBG, middleBG, bottomBG);
    }

    public boolean setBackgroundImage(Bitmap middle) {
        Bitmap bitmapCreateScaledBitmap;
        if (this.f991l == null || this.f991l.setting.m1121l() || middle == null || middle.isRecycled()) {
            return false;
        }
        int canvasWidth = this.f991l.setting.getCanvasWidth();
        int canvasHeight = this.f991l.setting.getCanvasHeight();
        int width = middle.getWidth();
        int height = middle.getHeight();
        if (canvasWidth != width || canvasHeight != height) {
            bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(middle, canvasWidth, canvasHeight, true);
        } else {
            bitmapCreateScaledBitmap = Bitmap.createBitmap(middle);
        }
        this.f991l.stage.setBackgroundImages(null, bitmapCreateScaledBitmap, null);
        this.f991l.drawBackgroundTheme();
        return true;
    }

    @Override // android.view.View
    public void setBackgroundColor(int argb) {
        if (this.f991l != null && !this.f991l.setting.m1121l()) {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(this.f991l.setting.getCanvasWidth(), 1, Bitmap.Config.ARGB_8888);
            bitmapCreateBitmap.eraseColor(argb);
            m887a((Bitmap) null, bitmapCreateBitmap, (Bitmap) null);
            bitmapCreateBitmap.recycle();
        }
    }

    public Bitmap getBackgroundImage() {
        int width;
        int height;
        if (this.f991l == null || this.f991l.stage == null) {
            return null;
        }
        if ((this.f991l.stage.f845i == null && this.f991l.stage.fixedSprites2 == null) || this.f991l.setting.m1121l()) {
            return null;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(this.f991l.setting.getCanvasWidth(), this.f991l.setting.getCanvasHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        if (canvas != null) {
            if (this.f991l.stage.f845i != null) {
                width = this.f991l.stage.f845i.getWidth();
                height = this.f991l.stage.f845i.getHeight();
            } else {
                width = this.f991l.stage.fixedSprites2.getWidth();
                height = this.f991l.stage.fixedSprites2.getHeight();
            }
            float intrinsicWidth = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
            if (this.f991l.stage.f847k != null) {
                intrinsicWidth = (width / this.f991l.stage.f847k.getIntrinsicWidth()) * this.f991l.stage.f847k.getIntrinsicHeight();
                this.f991l.stage.f847k.setBounds(0, 0, width, (int) intrinsicWidth);
                this.f991l.stage.f847k.draw(canvas);
            }
            if (this.f991l.stage.f848l != null) {
                float intrinsicWidth2 = (width / this.f991l.stage.f848l.getIntrinsicWidth()) * this.f991l.stage.f848l.getIntrinsicHeight();
                for (int i = (int) intrinsicWidth; i <= height && ((int) intrinsicWidth2) != 0; i = (int) (i + intrinsicWidth2)) {
                    this.f991l.stage.f848l.setBounds(0, i, width, (int) (i + intrinsicWidth2));
                    this.f991l.stage.f848l.draw(canvas);
                }
            }
            if (this.f991l.stage.f849m != null) {
                this.f991l.stage.f849m.setBounds(0, (int) (height - ((width / this.f991l.stage.f849m.getIntrinsicWidth()) * this.f991l.stage.f849m.getIntrinsicHeight())), width, height);
                this.f991l.stage.f849m.draw(canvas);
            }
        }
        return bitmapCreateBitmap;
    }

    public float getZoomLevel() {
        return this.f882aA != null ? this.f882aA.m1238e() : VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
    }

    public void setEraserMode() {
        if (this.f991l != null && this.f991l.setting != null) {
            this.f991l.setting.setStrokeType(StrokeSprite.Type.Eraser);
            if (this.f881a != null) {
                this.f991l.setting.setStrokeWidth(this.f881a.getEraserWidth());
            }
            this.f991l.changeModeTo(2);
            if (this.f947bM != null) {
                this.f947bM.onModeChanged(2);
            }
        }
    }

    public void setPenMode() {
        if (this.f991l != null && this.f991l.setting != null) {
            if (this.f881a != null) {
                this.f991l.setting.setStrokeType(PenSettingInfo.m1020a(this.f881a.getPenType()));
                this.f991l.setting.setStrokeWidth(this.f881a.getPenWidth());
            }
            this.f991l.changeModeTo(1);
            if (this.f947bM != null) {
                this.f947bM.onModeChanged(1);
            }
        }
    }

    public int getMode() {
        return getMode(getUserID());
    }

    public int getMode(int userID) {
        if (this.f991l == null) {
            return -1;
        }
        if (this.f991l.getMode(userID) == 1) {
            return 1;
        }
        if (this.f991l.getMode(userID) == 2) {
            return 2;
        }
        if (this.f991l.getMode(userID) == 3) {
            return 3;
        }
        if (this.f991l.getMode(userID) == 4) {
            return 4;
        }
        return this.f991l.getMode(userID) == 5 ? 5 : -1;
    }

    /* renamed from: h */
    private void m937h() {
        PenSettingInfo penSettingInfo = getPenSettingInfo();
        this.f982c = new PenSettingInfo();
        this.f982c.setPenType(penSettingInfo.getPenType());
        this.f982c.setPenWidth(penSettingInfo.getPenWidth());
        this.f982c.setPenColor(penSettingInfo.getPenColor());
        this.f982c.setPenAlpha(penSettingInfo.getPenAlpha());
    }

    protected void setLatestPenInfo() {
        setPenSettingInfo(this.f982c);
    }

    public LinkedList<ObjectInfo> getObjectInfos() {
        return getObjectInfos(-2);
    }

    public LinkedList<ObjectInfo> getObjectInfos(int layerID) {
        LinkedList<AbstractSprite> sprites;
        m937h();
        if (layerID == 0) {
            sprites = this.f991l.stage.getSprites(0);
        } else if (layerID == 1) {
            sprites = this.f991l.stage.getSprites(3);
        } else if (layerID == -1) {
            if (this.f991l.stage.getSelectedLayerID() == 0) {
                sprites = this.f991l.stage.getSprites(0);
            } else {
                sprites = this.f991l.stage.getSprites(3);
            }
        } else if (layerID == -2) {
            sprites = this.f991l.stage.getSprites(0);
            Iterator<AbstractSprite> it = this.f991l.stage.getSprites(3).iterator();
            while (it.hasNext()) {
                sprites.add(it.next());
            }
        } else {
            return null;
        }
        LinkedList<ObjectInfo> linkedList = new LinkedList<>();
        for (int i = 0; i < sprites.size(); i++) {
            if ((sprites.get(i) instanceof StrokeSprite) && (sprites.get(i).isVisible() || ((StrokeSprite) sprites.get(i)).m1172q())) {
                linkedList.add(((StrokeSprite) sprites.get(i)).m1174s());
            } else if ((sprites.get(i) instanceof C0989ab) && sprites.get(i).isVisible()) {
                linkedList.add(((C0989ab) sprites.get(i)).m1262c());
            } else if ((sprites.get(i) instanceof TextSprite) && sprites.get(i).isVisible()) {
                linkedList.add(((TextSprite) sprites.get(i)).m1203j());
            } else if ((sprites.get(i) instanceof C1063s) && sprites.get(i).isVisible()) {
                linkedList.add(((C1063s) sprites.get(i)).m1597d());
            }
        }
        return linkedList;
    }

    public LinkedList<StrokeInfo> getStrokeInfos() {
        return getStrokeInfos(-2);
    }

    public LinkedList<StrokeInfo> getStrokeInfos(int layerID) {
        LinkedList<AbstractSprite> linkedListM811a;
        if (layerID == 0) {
            linkedListM811a = this.f991l.stage.m811a(StrokeSprite.class);
        } else if (layerID == 1) {
            linkedListM811a = this.f991l.stage.m826b(StrokeSprite.class);
        } else if (layerID == -1) {
            if (this.f991l.stage.getSelectedLayerID() == 0) {
                linkedListM811a = this.f991l.stage.m811a(StrokeSprite.class);
            } else {
                linkedListM811a = this.f991l.stage.m826b(StrokeSprite.class);
            }
        } else if (layerID == -2) {
            linkedListM811a = this.f991l.stage.m811a(StrokeSprite.class);
            Iterator<AbstractSprite> it = this.f991l.stage.m826b(StrokeSprite.class).iterator();
            while (it.hasNext()) {
                linkedListM811a.add(it.next());
            }
        } else {
            return null;
        }
        LinkedList<StrokeInfo> linkedList = new LinkedList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= linkedListM811a.size()) {
                return linkedList;
            }
            if (linkedListM811a.get(i2).isVisible() || ((StrokeSprite) linkedListM811a.get(i2)).m1172q()) {
                linkedList.add(((StrokeSprite) linkedListM811a.get(i2)).m1174s());
            }
            i = i2 + 1;
        }
    }

    public LinkedList<TextInfo> getTextInfos() {
        return getTextInfos(-2);
    }

    public LinkedList<TextInfo> getTextInfos(int layerID) {
        LinkedList<AbstractSprite> linkedListM811a;
        if (layerID == 0) {
            linkedListM811a = this.f991l.stage.m811a(TextSprite.class);
        } else if (layerID == 1) {
            linkedListM811a = this.f991l.stage.m826b(TextSprite.class);
        } else if (layerID == -1) {
            if (this.f991l.stage.getSelectedLayerID() == 0) {
                linkedListM811a = this.f991l.stage.m811a(TextSprite.class);
            } else {
                linkedListM811a = this.f991l.stage.m826b(TextSprite.class);
            }
        } else if (layerID == -2) {
            linkedListM811a = this.f991l.stage.m811a(TextSprite.class);
            Iterator<AbstractSprite> it = this.f991l.stage.m826b(TextSprite.class).iterator();
            while (it.hasNext()) {
                linkedListM811a.add(it.next());
            }
        } else {
            return null;
        }
        LinkedList<TextInfo> linkedList = new LinkedList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= linkedListM811a.size()) {
                return linkedList;
            }
            if (linkedListM811a.get(i2).isVisible()) {
                linkedList.add(((TextSprite) linkedListM811a.get(i2)).m1203j());
            }
            i = i2 + 1;
        }
    }

    public LinkedList<ImageInfo> getImageInfos() {
        return getImageInfos(-2);
    }

    public LinkedList<ImageInfo> getImageInfos(int layerID) {
        LinkedList<AbstractSprite> linkedListM811a;
        if (layerID == 0) {
            linkedListM811a = this.f991l.stage.m811a(C0989ab.class);
        } else if (layerID == 1) {
            linkedListM811a = this.f991l.stage.m826b(C0989ab.class);
        } else if (layerID == -1) {
            if (this.f991l.stage.getSelectedLayerID() == 0) {
                linkedListM811a = this.f991l.stage.m811a(C0989ab.class);
            } else {
                linkedListM811a = this.f991l.stage.m826b(C0989ab.class);
            }
        } else if (layerID == -2) {
            linkedListM811a = this.f991l.stage.m811a(C0989ab.class);
            Iterator<AbstractSprite> it = this.f991l.stage.m826b(C0989ab.class).iterator();
            while (it.hasNext()) {
                linkedListM811a.add(it.next());
            }
        } else {
            return null;
        }
        LinkedList<ImageInfo> linkedList = new LinkedList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= linkedListM811a.size()) {
                return linkedList;
            }
            if (linkedListM811a.get(i2).isVisible()) {
                linkedList.add(((C0989ab) linkedListM811a.get(i2)).m1262c());
            }
            i = i2 + 1;
        }
    }

    protected LinkedList<FillColorInfo> getFillColorInfos() {
        return getFillColorInfos(-2);
    }

    protected LinkedList<FillColorInfo> getFillColorInfos(int layerID) {
        LinkedList<AbstractSprite> linkedListM811a;
        if (layerID == 0) {
            linkedListM811a = this.f991l.stage.m811a(C1063s.class);
        } else if (layerID == 1) {
            linkedListM811a = this.f991l.stage.m826b(C1063s.class);
        } else if (layerID == -1) {
            if (this.f991l.stage.getSelectedLayerID() == 0) {
                linkedListM811a = this.f991l.stage.m811a(C1063s.class);
            } else {
                linkedListM811a = this.f991l.stage.m826b(C1063s.class);
            }
        } else if (layerID == -2) {
            linkedListM811a = this.f991l.stage.m811a(C1063s.class);
            Iterator<AbstractSprite> it = this.f991l.stage.m826b(C1063s.class).iterator();
            while (it.hasNext()) {
                linkedListM811a.add(it.next());
            }
        } else {
            return null;
        }
        LinkedList<FillColorInfo> linkedList = new LinkedList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= linkedListM811a.size()) {
                return linkedList;
            }
            if (linkedListM811a.get(i2).isVisible()) {
                linkedList.add(((C1063s) linkedListM811a.get(i2)).m1597d());
            }
            i = i2 + 1;
        }
    }

    public void addTouchEvent(int what, float x, float y, float pressure, int meta_state, long down_time, long event_time) {
        int i;
        if (this.f991l.stage != null) {
            PointF pointFMapFromScene = this.f991l.stage.mapFromScene(new PointF(x, y));
            if (meta_state == 0) {
                i = 0;
            } else if (meta_state == 1) {
                i = this.f924aq;
            } else if (meta_state == 2) {
                i = this.f923ap;
            } else {
                i = 0;
            }
            if (this.f991l.modes.containsKey(Integer.valueOf(getUserID())) && (this.f991l.modes.get(Integer.valueOf(getUserID())) instanceof PenMode)) {
                MotionEvent motionEventObtain = MotionEvent.obtain(down_time, event_time, what, pointFMapFromScene.x, pointFMapFromScene.y, pressure, 1.0f, i, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, 0, 0);
                m910b(motionEventObtain);
                motionEventObtain.recycle();
            }
        }
    }

    /* renamed from: b */
    private boolean m910b(MotionEvent motionEvent) {
        ViewParent parent;
        if (this.f991l != null && this.f991l.setting != null) {
            int action = motionEvent.getAction();
            if (action == 0) {
                ViewParent parent2 = getParent();
                if (parent2 != null && (parent2 instanceof ViewGroup)) {
                    parent2.requestDisallowInterceptTouchEvent(true);
                    MotionEvent motionEventObtain = MotionEvent.obtain(0L, 0L, 3, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, 0);
                    ((ViewGroup) parent2).onTouchEvent(motionEventObtain);
                    motionEventObtain.recycle();
                }
            } else if (action == 1 && (parent = getParent()) != null && (parent instanceof ViewGroup)) {
                parent.requestDisallowInterceptTouchEvent(false);
            }
            if ((motionEvent.getMetaState() & this.f924aq) == this.f924aq) {
                this.f991l.setInputMethod(StrokeSprite.InputMethod.Tablet);
            } else {
                this.f991l.setInputMethod(StrokeSprite.InputMethod.Hand);
            }
            this.f991l.onTouchEvent(motionEvent);
        }
        return true;
    }

    /* renamed from: a */
    private boolean m890a(MotionEvent motionEvent, int i, int i2) {
        if (this.f991l != null && this.f991l.setting != null) {
            if ((motionEvent.getMetaState() & this.f924aq) == this.f924aq) {
                this.f991l.setInputMethod(StrokeSprite.InputMethod.Tablet, i);
            } else {
                this.f991l.setInputMethod(StrokeSprite.InputMethod.Hand, i);
            }
            this.f991l.onTouchEvent(motionEvent, i, i2);
        }
        return true;
    }

    public void setDrawable(boolean drawable) {
        this.f887aF = drawable;
    }

    public void setEraserCursorVisible(boolean visible) {
        this.f991l.setCursorVisible(visible);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public boolean m888a(Rect rect, boolean z) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f916ai.getText());
        TextPaint textPaint = new TextPaint();
        PointF pointFMapToScene = this.f991l.stage.mapToScene(new PointF(rect.left, rect.top));
        this.f880Z = this.f992m.bottom - pointFMapToScene.y;
        if (rect.right - (this.f916ai.getPaddingLeft() + this.f916ai.getPaddingRight()) < 0) {
            return false;
        }
        if (spannableStringBuilder.length() <= 0) {
            if (this.f1001v != null) {
                spannableStringBuilder.append((CharSequence) this.f1001v.m783d());
            } else {
                spannableStringBuilder.append((CharSequence) "Insert Text");
            }
            spannableStringBuilder.setSpan(new AbsoluteSizeSpan(40), 0, spannableStringBuilder.length(), 18);
        }
        int paddingTop = this.f916ai.getPaddingTop();
        int paddingBottom = this.f916ai.getPaddingBottom();
        DynamicLayout dynamicLayout = new DynamicLayout(spannableStringBuilder, textPaint, rect.right - (this.f916ai.getPaddingLeft() + this.f916ai.getPaddingRight()), this.f916ai.getLayout() == null ? null : this.f916ai.getLayout().getAlignment(), 1.0f, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, false);
        Rect rect2 = new Rect();
        dynamicLayout.getLineBounds(dynamicLayout.getLineCount() - 1, rect2);
        if (pointFMapToScene.x + rect.right > this.f992m.right) {
            rect.right = (int) (this.f992m.right - pointFMapToScene.x);
        }
        if (rect2.bottom <= rect.bottom - (paddingTop + paddingBottom)) {
            if (rect.bottom > this.f880Z) {
                rect.bottom = (int) this.f880Z;
            }
            if (z) {
                rect.bottom = rect2.bottom + paddingTop + paddingBottom;
            }
        } else if (rect2.bottom < this.f880Z - (paddingTop + paddingBottom)) {
            rect.bottom = rect2.bottom + paddingTop + paddingBottom;
        } else {
            rect.bottom = (int) this.f880Z;
        }
        return true;
    }

    /* renamed from: i */
    private void m941i() {
        this.f908aa[0] = new ForegroundColorSpan(this.f991l.setting.getTextColor());
        this.f908aa[1] = new StyleSpan(1);
        this.f908aa[2] = new StyleSpan(2);
        this.f908aa[3] = new UnderlineSpan();
        this.f908aa[4] = new StrikethroughSpan();
        this.f908aa[5] = new AbsoluteSizeSpan(this.f991l.setting.getTextSize() * 4);
        this.f908aa[6] = new AlignmentSpan() { // from class: com.samsung.sdraw.CanvasView.10
            @Override // android.text.style.AlignmentSpan
            public Layout.Alignment getAlignment() {
                return CanvasView.this.f910ac;
            }
        };
    }

    public void setTextAlignment(Layout.Alignment nAlign) {
        this.f910ac = nAlign;
        if (this.f879W || isShowTextBox()) {
            this.f908aa[6] = new AlignmentSpan() { // from class: com.samsung.sdraw.CanvasView.11
                @Override // android.text.style.AlignmentSpan
                public Layout.Alignment getAlignment() {
                    return CanvasView.this.f910ac;
                }
            };
            if (!this.f933az) {
                m949k();
                this.f933az = true;
            }
            if (isShowTextBox()) {
                switch (m922d()[nAlign.ordinal()]) {
                    case 1:
                        this.f916ai.setGravity(51);
                        break;
                    case 2:
                        this.f916ai.setGravity(53);
                        break;
                    case 3:
                        this.f916ai.setGravity(49);
                        break;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m906b(int i) {
        if (i < 5) {
            i = 5;
        } else if (i > 20) {
            i = 20;
        }
        this.f991l.setting.setTextSize(i);
        this.f908aa[5] = new AbsoluteSizeSpan(this.f991l.setting.getTextSize() * 4);
        if (isShowTextBox()) {
            SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) this.f916ai.getText();
            Object[] spans = spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), AbsoluteSizeSpan.class);
            if (spans.length > 0) {
                spannableStringBuilder.removeSpan(spans[0]);
            }
            spannableStringBuilder.setSpan(this.f908aa[5], 0, spannableStringBuilder.length(), 18);
            this.f916ai.invalidate();
        }
    }

    public int getTextAttribute() {
        return this.f909ab;
    }

    public int getTextSize() {
        if (isShowTextBox()) {
            SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) this.f916ai.getText();
            Object[] spans = spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), AbsoluteSizeSpan.class);
            if (spans.length > 0) {
                return ((AbsoluteSizeSpan) spans[0]).getSize() / 4;
            }
        }
        if (this.f908aa[5] != null) {
            return ((AbsoluteSizeSpan) this.f908aa[5]).getSize() / 4;
        }
        return 10;
    }

    public int getTextColor() {
        return this.f993n != null ? this.f993n.getTextColor() : C1051g.f1731a;
    }

    /* renamed from: j */
    private String m944j() {
        return this.f991l.setting.getTextFont();
    }

    public int getMaxTextSize() {
        if (!isShowTextBox() || this.f916ai.getText().length() <= 0 || this.f916ai.getLineCount() <= 0) {
            return 20;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f916ai.getText());
        Canvas canvas = new Canvas();
        Rect rect = new Rect(0, 0, (this.f916ai.getWidth() - this.f916ai.getPaddingLeft()) - this.f916ai.getPaddingRight(), this.f916ai.getHeight());
        Rect rect2 = new Rect();
        TextPaint textPaint = new TextPaint();
        textPaint.setAntiAlias(true);
        DynamicLayout dynamicLayout = new DynamicLayout(spannableStringBuilder, textPaint, rect.width(), this.f916ai.getLayout() != null ? this.f916ai.getLayout().getAlignment() : null, 1.0f, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, false);
        int paddingTop = this.f916ai.getPaddingTop() + this.f916ai.getPaddingBottom();
        int textSize = this.f991l.setting.getTextSize();
        Object[] spans = spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), AbsoluteSizeSpan.class);
        if (spans.length > 0) {
            AbsoluteSizeSpan absoluteSizeSpan = (AbsoluteSizeSpan) spans[0];
            do {
                textSize++;
                spannableStringBuilder.removeSpan(absoluteSizeSpan);
                absoluteSizeSpan = new AbsoluteSizeSpan(textSize * 4);
                spannableStringBuilder.setSpan(absoluteSizeSpan, 0, spannableStringBuilder.length(), 18);
                dynamicLayout.draw(canvas);
                dynamicLayout.getLineBounds(dynamicLayout.getLineCount() - 1, rect2);
            } while (rect2.bottom < this.f880Z - paddingTop);
        } else {
            do {
                textSize++;
                spannableStringBuilder.setSpan(new AbsoluteSizeSpan(textSize * 4), 0, spannableStringBuilder.length(), 18);
                dynamicLayout.draw(canvas);
                dynamicLayout.getLineBounds(dynamicLayout.getLineCount() - 1, rect2);
            } while (rect2.bottom < this.f880Z - paddingTop);
        }
        return textSize - 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m913c(int i) {
        this.f991l.setting.setTextColor(this.f991l.setting.getTextColor());
        this.f908aa[0] = new ForegroundColorSpan(this.f991l.setting.getTextColor());
        if (isShowTextBox()) {
            SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) this.f916ai.getText();
            for (Object obj : spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), ForegroundColorSpan.class)) {
                spannableStringBuilder.removeSpan(obj);
            }
            spannableStringBuilder.setSpan(this.f908aa[0], 0, spannableStringBuilder.length(), 18);
            this.f916ai.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m873a(int i, boolean z) {
        if (z) {
            this.f909ab |= i;
        } else {
            this.f909ab ^= i;
        }
        if (isShowTextBox()) {
            SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) this.f916ai.getText();
            Object[] spans = spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), StyleSpan.class);
            for (int i2 = 0; i2 < spans.length; i2++) {
                if (((StyleSpan) spans[i2]).getStyle() == 1) {
                    spannableStringBuilder.removeSpan(spans[i2]);
                }
            }
            if ((this.f909ab & 1) == 1) {
                spannableStringBuilder.setSpan(this.f908aa[1], 0, spannableStringBuilder.length(), 18);
            }
            for (int i3 = 0; i3 < spans.length; i3++) {
                if (((StyleSpan) spans[i3]).getStyle() == 2) {
                    spannableStringBuilder.removeSpan(spans[i3]);
                }
            }
            if ((this.f909ab & 2) == 2) {
                spannableStringBuilder.setSpan(this.f908aa[2], 0, spannableStringBuilder.length(), 18);
            }
            Object[] spans2 = spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), UnderlineSpan.class);
            if (spans2.length > 0) {
                spannableStringBuilder.removeSpan(spans2[0]);
            }
            if ((this.f909ab & 4) == 4) {
                spannableStringBuilder.setSpan(this.f908aa[3], 0, spannableStringBuilder.length(), 18);
            }
            Object[] spans3 = spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), StrikethroughSpan.class);
            if (spans3.length > 0) {
                spannableStringBuilder.removeSpan(spans3[0]);
            }
            if ((this.f909ab & 8) == 8) {
                spannableStringBuilder.setSpan(this.f908aa[4], 0, spannableStringBuilder.length(), 18);
            }
            this.f916ai.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public void m949k() {
        Drawable drawableB;
        if (getParent() instanceof RelativeLayout) {
            RelativeLayout relativeLayout = (RelativeLayout) getParent();
            this.f878V = new C0997aj(this.f864H, this.f984e);
            if (this.f916ai == null && !this.f917aj) {
                this.f916ai = new EditText(this.f864H);
                try {
                    this.f916ai.setCursorColor(-16777216);
                } catch (NoSuchMethodError e) {
                    e.printStackTrace();
                }
                this.f916ai.setOnCreateContextMenuListener(new View.OnCreateContextMenuListener() { // from class: com.samsung.sdraw.CanvasView.13
                    @Override // android.view.View.OnCreateContextMenuListener
                    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
                        CanvasView.this.f901aT = menu;
                    }
                });
                if (this.f1001v != null) {
                    this.f916ai.setHint(this.f1001v.m783d());
                    this.f916ai.setTextSize(this.f1001v.m785f());
                } else {
                    this.f916ai.setHint("Insert Text");
                    if (getContext().getResources().getDisplayMetrics().densityDpi == 160) {
                        this.f916ai.setTextSize(40.0f);
                    } else {
                        this.f916ai.setTextSize(20.0f);
                    }
                }
                this.f916ai.setRawInputType(131073);
                if (this.f955bU) {
                    this.f916ai.setImeOptions(268435456);
                }
                this.f916ai.setGravity(48);
                this.f916ai.addTextChangedListener(this.f900aS);
                this.f916ai.setBackgroundDrawable(this.f878V.m1531c("/textbox1.9.png"));
                this.f916ai.setPadding(40, 40, 40, 40);
                if (relativeLayout != null) {
                    relativeLayout.addView(this.f916ai, relativeLayout.indexOfChild(this.f1001v), new RelativeLayout.LayoutParams(this.f949bO, this.f950bP));
                }
                this.f916ai.setOnTouchListener(this.f897aP);
                if (Build.VERSION.RELEASE.startsWith(SimpleUserInfo.STATE_MOVETO_CONFERENCE)) {
                    this.f916ai.setOnHoverListener(this.f902aU.f1038b);
                }
                this.f916ai.setOnFocusChangeListener(this.f898aQ);
                this.f916ai.setOnLongClickListener(this.f904aW);
                this.f916ai.setVisibility(4);
            }
            if (!this.f940bF && this.f865I == null) {
                this.f865I = new ImageButton(this.f864H);
                this.f865I.setBackgroundColor(0);
                Bitmap bitmapD = this.f878V.m1532d("/bt_text_move.png");
                if (bitmapD != null) {
                    this.f865I.setImageBitmap(bitmapD);
                    if (relativeLayout != null) {
                        relativeLayout.addView(this.f865I, relativeLayout.indexOfChild(this.f1001v), new RelativeLayout.LayoutParams(-2, -2));
                        this.f866J = bitmapD.getWidth();
                        this.f867K = bitmapD.getHeight();
                    }
                }
                this.f865I.setOnTouchListener(this.f905aX);
                this.f865I.setVisibility(4);
            }
            if (this.f870N == null) {
                this.f870N = new ImageButton(this.f864H);
                this.f870N.setContentDescription(this.f922ao);
                if (this.f921an.densityDpi == 160 || this.f921an.densityDpi == 213) {
                    this.f873Q = 16;
                    drawableB = this.f878V.m1527b("/icon_popup_delete.png");
                    this.f874R = this.f878V.m1527b("/up_popup_delete.png");
                    this.f875S = this.f878V.m1527b("/down_popup_delete.png");
                } else {
                    this.f873Q = 6;
                    drawableB = this.f878V.m1527b("/icon_popup_delete_n.png");
                    this.f874R = this.f878V.m1527b("/btn_popup_delete_n_default.png");
                    this.f875S = this.f878V.m1527b("/btn_popup_delete_n_default_02.png");
                }
                this.f870N.setBackgroundDrawable(this.f874R);
                Bitmap bitmapD2 = this.f878V.m1532d("/up_popup_delete.png");
                if (drawableB != null) {
                    this.f870N.setImageDrawable(drawableB);
                    if (relativeLayout != null) {
                        this.f870N.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
                        relativeLayout.addView(this.f870N, relativeLayout.indexOfChild(this.f1001v));
                        this.f870N.setPadding(0, -10, 0, 0);
                        this.f871O = bitmapD2.getWidth();
                        this.f872P = bitmapD2.getHeight();
                    }
                }
                this.f870N.setOnTouchListener(this.f906aY);
                this.f870N.setVisibility(4);
            }
        }
    }

    @Override // com.samsung.sdraw.InterfaceC1035bu
    public void createTextBox(RectF rect, Editable text, TextInfo textInfo) {
        if (this.f991l != null && !this.f991l.setting.m1121l()) {
            if (!this.f933az) {
                m949k();
                this.f933az = true;
            }
            if (this.f940bF && this.f916ai.isFocusableInTouchMode()) {
                this.f916ai.setFocusableInTouchMode(false);
            }
            if (!this.f997r && this.f1001v != null && this.f1001v.f749b != null) {
                this.f996q.setTextColor(this.f1001v.f749b.getTextColor());
                this.f996q.setTextSize(this.f1001v.f749b.getTextSize());
                this.f996q.setTextType(this.f1001v.f749b.getTextType());
                this.f996q.setTextFont(this.f1001v.f749b.getTextFont());
                this.f996q.setTextAlignment(this.f1001v.f749b.getTextAlignment());
                this.f997r = true;
            }
            this.f993n.setTextColor(textInfo.color);
            this.f993n.setTextSize(textInfo.size);
            this.f993n.setTextType(textInfo.textStyle);
            this.f993n.setTextFont(textInfo.textFont);
            this.f993n.setTextAlignment(textInfo.alignment);
            setTextSettingViewInfo(this.f993n);
            this.f991l.setting.setMaxTextSize(getMaxTextSize());
            m873a(this.f991l.setting.getTextType(), true);
            RelativeLayout relativeLayout = (RelativeLayout) getParent();
            this.f879W = true;
            if (relativeLayout != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f916ai.getLayoutParams();
                layoutParams.leftMargin = ((int) rect.left) - this.f916ai.getPaddingLeft();
                layoutParams.topMargin = ((int) rect.top) - this.f916ai.getPaddingTop();
                layoutParams.width = (int) (textInfo.rectf.width() + this.f916ai.getPaddingLeft() + this.f916ai.getPaddingRight());
                layoutParams.height = (int) (textInfo.rectf.height() + this.f916ai.getPaddingTop() + this.f916ai.getPaddingBottom());
                PointF pointFMapToScene = this.f991l.stage.mapToScene(new PointF(layoutParams.leftMargin, layoutParams.topMargin));
                if (pointFMapToScene.x + layoutParams.width > getRight()) {
                    layoutParams.width = getRight() - layoutParams.leftMargin;
                }
                if (pointFMapToScene.y + layoutParams.height > getBottom()) {
                    layoutParams.height = getBottom() - layoutParams.topMargin;
                }
                if (layoutParams.leftMargin + layoutParams.width > getRight()) {
                    layoutParams.rightMargin = layoutParams.leftMargin + layoutParams.width;
                } else {
                    layoutParams.rightMargin = 0;
                }
                if (layoutParams.topMargin + layoutParams.height > getBottom()) {
                    layoutParams.bottomMargin = layoutParams.topMargin + layoutParams.height;
                } else {
                    layoutParams.bottomMargin = 0;
                }
                this.f880Z = this.f991l.setting.getCanvasHeight() - (rect.top + this.f991l.setting.getCanvasRect().top);
                if (this.f877U) {
                    this.f916ai.setPivotX(39.0f);
                    this.f916ai.setPivotY(39.0f);
                    this.f916ai.setScaleX(getScale());
                    this.f916ai.setScaleY(getScale());
                }
                this.f916ai.setLayoutParams(layoutParams);
                if (!C1040bz.f1671a.containsKey(this.f993n.getTextFont())) {
                    try {
                        this.f916ai.setTypeface(Typeface.createFromFile(C1040bz.f1672b.get(this.f993n.getTextFont())));
                    } catch (Exception e) {
                        this.f916ai.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
                    }
                    C0993af.m1275a("DIOTEK/DRAW", String.format("createTextBox(RectF,Editable,TextInfo) => %s : not cached", String.valueOf(this.f920am) + this.f993n.getTextFont()));
                } else {
                    this.f916ai.setTypeface(C1040bz.f1671a.get(this.f993n.getTextFont()));
                }
                C1040bz c1040bz = new C1040bz(this.f864H, this.f993n.getTextFont());
                this.f916ai.setText(text, TextView.BufferType.SPANNABLE);
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f916ai.getText().toString());
                m906b(this.f993n.getTextSize());
                spannableStringBuilder.setSpan(c1040bz, 0, spannableStringBuilder.length(), 18);
                spannableStringBuilder.setSpan(new ForegroundColorSpan(this.f993n.getTextColor()), 0, spannableStringBuilder.length(), 18);
                spannableStringBuilder.setSpan(this.f908aa[5], 0, spannableStringBuilder.length(), 18);
                int length = spannableStringBuilder.length();
                int textAttribute = textInfo.textStyle | getTextAttribute();
                textInfo.textStyle = textAttribute;
                if ((textAttribute & 1) == 1) {
                    spannableStringBuilder.setSpan(this.f908aa[1], 0, length, 18);
                }
                int textAttribute2 = textInfo.textStyle | getTextAttribute();
                textInfo.textStyle = textAttribute2;
                if ((textAttribute2 & 2) == 2) {
                    spannableStringBuilder.setSpan(this.f908aa[2], 0, length, 18);
                }
                int textAttribute3 = textInfo.textStyle | getTextAttribute();
                textInfo.textStyle = textAttribute3;
                if ((textAttribute3 & 4) == 4) {
                    spannableStringBuilder.setSpan(this.f908aa[3], 0, length, 18);
                }
                int textAttribute4 = textInfo.textStyle | getTextAttribute();
                textInfo.textStyle = textAttribute4;
                if ((textAttribute4 & 8) == 8) {
                    spannableStringBuilder.setSpan(this.f908aa[4], 0, length, 18);
                }
                this.f916ai.setText(spannableStringBuilder);
                this.f916ai.setVisibility(0);
                setTextAlignment(this.f993n.getTextAlignment());
                if (!this.f940bF) {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f865I.getLayoutParams();
                    layoutParams2.leftMargin = layoutParams.leftMargin - this.f866J;
                    layoutParams2.topMargin = (layoutParams.topMargin - this.f867K) + 10;
                    layoutParams2.width = -2;
                    layoutParams2.height = -2;
                    if (layoutParams2.leftMargin < 0) {
                        layoutParams2.leftMargin = (layoutParams.leftMargin + layoutParams.width) - 30;
                    }
                    if (layoutParams2.topMargin < 0) {
                        layoutParams2.topMargin = (layoutParams.topMargin + layoutParams.height) - 20;
                    }
                    if (layoutParams2.leftMargin < this.f913af.left) {
                        layoutParams2.leftMargin = (int) this.f913af.left;
                    }
                    if (layoutParams2.leftMargin + layoutParams2.width > this.f913af.right) {
                        layoutParams2.leftMargin = (int) (this.f913af.right - this.f866J);
                    }
                    if (layoutParams2.topMargin < this.f913af.top) {
                        layoutParams2.topMargin = (int) this.f913af.top;
                    }
                    if (layoutParams2.topMargin + layoutParams2.height > getBottom()) {
                        layoutParams2.topMargin = (int) (this.f913af.bottom - this.f867K);
                    }
                    try {
                        this.f865I.setLayoutParams(layoutParams2);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    this.f865I.setVisibility(0);
                }
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f870N.getLayoutParams();
                layoutParams3.leftMargin = (int) ((layoutParams.leftMargin + ((layoutParams.width * getScale()) / 2.0f)) - (this.f871O / 2.0f));
                layoutParams3.topMargin = (int) (((layoutParams.topMargin + ((this.f916ai.getPaddingTop() / 2.0f) * getScale())) - this.f872P) - this.f873Q);
                layoutParams3.width = this.f871O;
                layoutParams3.height = this.f872P;
                if (layoutParams3.topMargin < 0 || layoutParams3.topMargin < getTop()) {
                    layoutParams3.topMargin = (int) (((layoutParams.topMargin + (layoutParams.height * getScale())) - ((this.f916ai.getPaddingBottom() / 2.0f) * getScale())) + this.f873Q);
                    this.f870N.setBackgroundDrawable(this.f875S);
                    this.f870N.setPadding(0, 10, 0, 0);
                } else {
                    this.f870N.setBackgroundDrawable(this.f874R);
                    this.f870N.setPadding(0, -10, 0, 0);
                }
                if (layoutParams3.topMargin + layoutParams3.height > getBottom()) {
                    layoutParams3.topMargin = (int) (((((layoutParams.height * getScale()) + layoutParams.topMargin) - (this.f916ai.getPaddingBottom() * getScale())) - layoutParams3.height) - this.f873Q);
                    this.f870N.setBackgroundDrawable(this.f874R);
                    this.f870N.setPadding(0, -10, 0, 0);
                }
                try {
                    this.f870N.setLayoutParams(layoutParams3);
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
                this.f870N.setVisibility(0);
                this.f916ai.setSelection(this.f916ai.getText().length());
                this.f916ai.requestFocus();
                this.f916ai.invalidate();
            }
            this.f879W = false;
        }
    }

    public void createTextBox(RectF rect, Editable text, Layout.Alignment alignment) {
        if (this.f991l != null && !this.f991l.setting.m1121l()) {
            if (!this.f933az) {
                m949k();
                this.f933az = true;
            }
            if (this.f940bF && this.f916ai.isFocusableInTouchMode()) {
                this.f916ai.setFocusableInTouchMode(false);
            }
            if (!this.f997r && this.f1001v != null && this.f1001v.f749b != null) {
                this.f996q.setTextColor(this.f1001v.f749b.getTextColor());
                this.f996q.setTextSize(this.f1001v.f749b.getTextSize());
                this.f996q.setTextType(this.f1001v.f749b.getTextType());
                this.f996q.setTextFont(this.f1001v.f749b.getTextFont());
                this.f996q.setTextAlignment(this.f1001v.f749b.getTextAlignment());
                this.f997r = true;
            }
            setTextSettingViewInfo(this.f993n);
            RelativeLayout relativeLayout = (RelativeLayout) getParent();
            this.f879W = true;
            if (relativeLayout != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f916ai.getLayoutParams();
                layoutParams.leftMargin = ((int) rect.left) - this.f916ai.getPaddingLeft();
                layoutParams.topMargin = ((int) rect.top) - this.f916ai.getPaddingTop();
                layoutParams.leftMargin += getLeft();
                layoutParams.topMargin += getTop();
                layoutParams.width = (int) (rect.width() + this.f916ai.getPaddingLeft() + this.f916ai.getPaddingRight());
                layoutParams.height = (int) (rect.height() + this.f916ai.getPaddingTop() + this.f916ai.getPaddingBottom());
                if (this.f991l.setting.getCanvasRect().left + layoutParams.leftMargin + layoutParams.width > this.f991l.setting.getCanvasRect().width()) {
                    layoutParams.width = (this.f991l.setting.getCanvasRect().width() - layoutParams.leftMargin) - this.f991l.setting.getCanvasRect().left;
                }
                if (this.f991l.setting.getCanvasRect().top + layoutParams.topMargin + layoutParams.height > this.f991l.setting.getCanvasRect().height()) {
                    layoutParams.height = (this.f991l.setting.getCanvasRect().height() - layoutParams.topMargin) - this.f991l.setting.getCanvasRect().top;
                }
                this.f880Z = this.f991l.setting.getCanvasHeight() - (rect.top + this.f991l.setting.getCanvasRect().top);
                this.f916ai.setLayoutParams(layoutParams);
                this.f916ai.setText(text, TextView.BufferType.SPANNABLE);
                if (!C1040bz.f1671a.containsKey(this.f993n.getTextFont())) {
                    try {
                        this.f916ai.setTypeface(Typeface.createFromFile(C1040bz.f1672b.get(this.f993n.getTextFont())));
                    } catch (Exception e) {
                        this.f916ai.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
                    }
                    C0993af.m1275a("DIOTEK/DRAW", String.format("createTextBox(RectF,Editable,Alignment) => %s : not cached", String.valueOf(this.f920am) + this.f993n.getTextFont()));
                } else {
                    this.f916ai.setTypeface(C1040bz.f1671a.get(this.f993n.getTextFont()));
                }
                Object[] spans = text.getSpans(0, text.length(), C1040bz.class);
                int i = 0;
                for (int i2 = 0; i2 < spans.length; i2++) {
                    if (((StyleSpan) spans[i2]).getStyle() == 1) {
                        i |= 1;
                    } else if (((StyleSpan) spans[i2]).getStyle() == 2) {
                        i |= 2;
                    }
                }
                if (text.getSpans(0, text.length(), UnderlineSpan.class).length > 0) {
                    i |= 4;
                }
                if (text.getSpans(0, text.length(), StrikethroughSpan.class).length > 0) {
                    i |= 8;
                }
                Object[] spans2 = text.getSpans(0, text.length(), ForegroundColorSpan.class);
                if (spans2.length > 0) {
                    m913c(((ForegroundColorSpan) spans2[0]).getForegroundColor());
                    m906b(this.f991l.setting.getTextSize());
                }
                this.f916ai.setVisibility(0);
                setTextAlignment(alignment);
                if (!this.f940bF) {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f865I.getLayoutParams();
                    layoutParams2.leftMargin = layoutParams.leftMargin - this.f866J;
                    layoutParams2.topMargin = (layoutParams.topMargin - this.f867K) + 10;
                    layoutParams2.width = -2;
                    layoutParams2.height = -2;
                    if (layoutParams2.leftMargin < 0) {
                        layoutParams2.leftMargin = (layoutParams.leftMargin + layoutParams.width) - 30;
                    }
                    if (layoutParams2.topMargin < 0) {
                        layoutParams2.topMargin = (layoutParams.topMargin + layoutParams.height) - 20;
                    }
                    if (layoutParams2.leftMargin < this.f913af.left) {
                        layoutParams2.leftMargin = (int) this.f913af.left;
                    }
                    if (layoutParams2.leftMargin + layoutParams2.width > this.f913af.right) {
                        layoutParams2.leftMargin = (int) (this.f913af.right - this.f866J);
                    }
                    if (layoutParams2.topMargin < this.f913af.top) {
                        layoutParams2.topMargin = (int) this.f913af.top;
                    }
                    if (layoutParams2.topMargin + layoutParams2.height > getBottom()) {
                        layoutParams2.topMargin = (int) (this.f913af.bottom - this.f867K);
                    }
                    try {
                        this.f865I.setLayoutParams(layoutParams2);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    this.f865I.setVisibility(0);
                }
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f870N.getLayoutParams();
                layoutParams3.leftMargin = (int) ((layoutParams.leftMargin + ((layoutParams.width * getScale()) / 2.0f)) - (this.f871O / 2.0f));
                layoutParams3.topMargin = (int) (((layoutParams.topMargin + ((this.f916ai.getPaddingTop() / 2.0f) * getScale())) - this.f872P) - this.f873Q);
                layoutParams3.width = this.f871O;
                layoutParams3.height = this.f872P;
                if (layoutParams3.topMargin < 0 || layoutParams3.topMargin < getTop()) {
                    layoutParams3.topMargin = (int) (((layoutParams.topMargin + (layoutParams.height * getScale())) - ((this.f916ai.getPaddingBottom() / 2.0f) * getScale())) + this.f873Q);
                    this.f870N.setBackgroundDrawable(this.f875S);
                    this.f870N.setPadding(0, 10, 0, 0);
                } else {
                    this.f870N.setBackgroundDrawable(this.f874R);
                    this.f870N.setPadding(0, -10, 0, 0);
                }
                if (layoutParams3.topMargin + layoutParams3.height > getBottom()) {
                    layoutParams3.topMargin = (int) (((((layoutParams.height * getScale()) + layoutParams.topMargin) - (this.f916ai.getPaddingBottom() * getScale())) - layoutParams3.height) - this.f873Q);
                    this.f870N.setBackgroundDrawable(this.f874R);
                    this.f870N.setPadding(0, -10, 0, 0);
                }
                try {
                    this.f870N.setLayoutParams(layoutParams3);
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
                this.f870N.setVisibility(0);
                this.f916ai.setSelection(this.f916ai.getText().length());
                this.f909ab = 0;
                m873a(i, true);
                this.f916ai.requestFocus();
                this.f916ai.invalidate();
            }
            this.f879W = false;
        }
    }

    @Override // com.samsung.sdraw.InterfaceC1035bu
    public void createTextBox(Point point) {
        TextInfo textInfo;
        if (this.f991l != null && !this.f991l.setting.m1121l()) {
            if (!this.f933az) {
                m949k();
                this.f933az = true;
            }
            if (this.f940bF) {
                this.f916ai.setFocusableInTouchMode(true);
            }
            m873a(this.f991l.setting.getTextType(), true);
            this.f991l.setting.setMaxTextSize(getMaxTextSize());
            RectF rectF = new RectF(this.f991l.setting.getCanvasRect());
            rectF.offset((-rectF.left) * 2.0f, (-rectF.top) * 2.0f);
            if (rectF.contains(point.x, point.y) && ((RelativeLayout) getParent()) != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f916ai.getLayoutParams();
                layoutParams.leftMargin = (point.x - 30) - getLeft();
                layoutParams.topMargin = (point.y - 30) - getTop();
                layoutParams.width = this.f949bO;
                layoutParams.height = this.f950bP;
                layoutParams.leftMargin += getLeft();
                layoutParams.topMargin += getTop();
                PointF pointFMapToScene = this.f991l.stage.mapToScene(new PointF(layoutParams.leftMargin, layoutParams.topMargin));
                if (pointFMapToScene.x + layoutParams.width > rectF.right) {
                    layoutParams.leftMargin = (int) (rectF.right - (layoutParams.width * getScale()));
                }
                if (pointFMapToScene.x < rectF.left) {
                    layoutParams.leftMargin = (int) rectF.left;
                }
                if (pointFMapToScene.y + layoutParams.height > rectF.bottom) {
                    layoutParams.topMargin = (int) (rectF.bottom - (layoutParams.height * getScale()));
                }
                if (pointFMapToScene.y < rectF.top) {
                    layoutParams.topMargin = (int) rectF.top;
                }
                if (layoutParams.leftMargin + layoutParams.width > getRight()) {
                    layoutParams.rightMargin = layoutParams.leftMargin + layoutParams.width;
                } else {
                    layoutParams.rightMargin = 0;
                }
                if (layoutParams.topMargin + layoutParams.height > getBottom()) {
                    layoutParams.bottomMargin = layoutParams.topMargin + layoutParams.height;
                } else {
                    layoutParams.bottomMargin = 0;
                }
                if (this.f877U) {
                    this.f916ai.setPivotX(39.0f);
                    this.f916ai.setPivotY(39.0f);
                    this.f916ai.setScaleX(getScale());
                    this.f916ai.setScaleY(getScale());
                }
                try {
                    this.f916ai.setText("");
                    this.f916ai.setLayoutParams(layoutParams);
                    this.f880Z = (this.f991l.setting.getCanvasRect().height() - layoutParams.topMargin) - this.f991l.setting.getCanvasRect().top;
                } catch (Exception e) {
                    e.printStackTrace();
                }
                C1040bz c1040bz = new C1040bz(this.f864H, this.f991l.setting.getTextFont());
                if (!C1040bz.f1671a.containsKey(this.f993n.getTextFont())) {
                    try {
                        this.f916ai.setTypeface(Typeface.createFromFile(C1040bz.f1672b.get(this.f993n.getTextFont())));
                    } catch (Exception e2) {
                        this.f916ai.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
                        this.f993n.setTextFont("Sans serif");
                    }
                    C0993af.m1275a("DIOTEK/DRAW", String.format("createTextBox(Point) => %s : not cached", String.valueOf(this.f920am) + this.f993n.getTextFont()));
                } else {
                    this.f916ai.setTypeface(C1040bz.f1671a.get(this.f993n.getTextFont()));
                    if (this.f993n.getTextFont() == null) {
                        this.f993n.setTextFont("Sans serif");
                    }
                }
                if (getSelectLayer() == 0) {
                    textInfo = new TextInfo(getTextColor(), getTextSize(), "", rectF, getTextAttribute(), this.f993n.getTextAlignment(), m944j(), 2);
                } else {
                    textInfo = new TextInfo(getTextColor(), getTextSize(), "", rectF, getTextAttribute(), this.f993n.getTextAlignment(), m944j(), 4);
                }
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f916ai.getText().toString());
                spannableStringBuilder.setSpan(new ForegroundColorSpan(textInfo.color), 0, spannableStringBuilder.length(), 18);
                spannableStringBuilder.setSpan(new AbsoluteSizeSpan(textInfo.size * 4), 0, spannableStringBuilder.length(), 18);
                spannableStringBuilder.setSpan(c1040bz, 0, spannableStringBuilder.length(), 18);
                int length = spannableStringBuilder.length();
                int i = textInfo.textStyle;
                if ((i & 1) == 1) {
                    spannableStringBuilder.setSpan(this.f908aa[1], 0, length, 18);
                }
                if ((i & 2) == 2) {
                    spannableStringBuilder.setSpan(this.f908aa[2], 0, length, 18);
                }
                if ((i & 4) == 4) {
                    spannableStringBuilder.setSpan(this.f908aa[3], 0, length, 18);
                }
                if ((i & 8) == 8) {
                    spannableStringBuilder.setSpan(this.f908aa[4], 0, length, 18);
                }
                this.f916ai.setText(spannableStringBuilder);
                this.f916ai.setVisibility(0);
                setTextAlignment(this.f993n.getTextAlignment());
                if (!this.f940bF) {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f865I.getLayoutParams();
                    layoutParams2.leftMargin = layoutParams.leftMargin - this.f866J;
                    layoutParams2.topMargin = (layoutParams.topMargin - this.f867K) + 10;
                    layoutParams2.width = -2;
                    layoutParams2.height = -2;
                    if (layoutParams2.leftMargin < 0) {
                        layoutParams2.leftMargin = (layoutParams.leftMargin + layoutParams.width) - 30;
                    }
                    if (layoutParams2.topMargin < 0) {
                        layoutParams2.topMargin = (layoutParams.topMargin + layoutParams.height) - 20;
                    }
                    if (layoutParams2.leftMargin < this.f913af.left) {
                        layoutParams2.leftMargin = (int) this.f913af.left;
                    }
                    if (layoutParams2.leftMargin + layoutParams2.width > this.f913af.right) {
                        layoutParams2.leftMargin = (int) (this.f913af.right - this.f866J);
                    }
                    if (layoutParams2.topMargin < this.f913af.top) {
                        layoutParams2.topMargin = (int) this.f913af.top;
                    }
                    if (layoutParams2.topMargin + layoutParams2.height > getBottom()) {
                        layoutParams2.topMargin = (int) (this.f913af.bottom - this.f867K);
                    }
                    try {
                        this.f865I.setLayoutParams(layoutParams2);
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                    this.f865I.setVisibility(0);
                }
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f870N.getLayoutParams();
                layoutParams3.leftMargin = (int) ((layoutParams.leftMargin + ((layoutParams.width * getScale()) / 2.0f)) - (this.f871O / 2.0f));
                layoutParams3.topMargin = (int) (((layoutParams.topMargin + ((this.f916ai.getPaddingTop() / 2.0f) * getScale())) - this.f872P) - this.f873Q);
                layoutParams3.width = this.f871O;
                layoutParams3.height = this.f872P;
                if (layoutParams3.topMargin < 0 || layoutParams3.topMargin < getTop()) {
                    layoutParams3.topMargin = (int) (((layoutParams.topMargin + (layoutParams.height * getScale())) - ((this.f916ai.getPaddingBottom() / 2.0f) * getScale())) + this.f873Q);
                    this.f870N.setBackgroundDrawable(this.f875S);
                    this.f870N.setPadding(0, 10, 0, 0);
                } else {
                    this.f870N.setBackgroundDrawable(this.f874R);
                    this.f870N.setPadding(0, -10, 0, 0);
                }
                if (layoutParams3.topMargin + layoutParams3.height > getBottom()) {
                    layoutParams3.topMargin = (int) ((((layoutParams.topMargin + (layoutParams.height * getScale())) - (this.f916ai.getPaddingBottom() * getScale())) - layoutParams3.height) - this.f873Q);
                    this.f870N.setBackgroundDrawable(this.f874R);
                    this.f870N.setPadding(0, -10, 0, 0);
                }
                try {
                    this.f870N.setLayoutParams(layoutParams3);
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
                this.f870N.setVisibility(0);
                switch (m922d()[this.f910ac.ordinal()]) {
                    case 1:
                        this.f916ai.setGravity(51);
                        break;
                    case 2:
                        this.f916ai.setGravity(53);
                        break;
                    case 3:
                        this.f916ai.setGravity(49);
                        break;
                }
                this.f916ai.requestFocus();
                this.f916ai.invalidate();
            }
        }
    }

    @Override // com.samsung.sdraw.InterfaceC1035bu
    public boolean isShowTextBox() {
        return this.f916ai != null && this.f916ai.getVisibility() == 0;
    }

    @Override // com.samsung.sdraw.InterfaceC1035bu
    public Point getTextBoxPosition() {
        if (this.f916ai == null) {
            m949k();
        }
        if (this.f916ai == null) {
            return new Point(0, 0);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f916ai.getLayoutParams();
        return new Point(layoutParams.leftMargin + this.f916ai.getPaddingLeft(), layoutParams.topMargin + this.f916ai.getPaddingTop());
    }

    @Override // com.samsung.sdraw.InterfaceC1035bu
    public int getTextBoxWidth() {
        if (this.f916ai == null) {
            return 0;
        }
        return (this.f916ai.getWidth() - this.f916ai.getPaddingLeft()) - this.f916ai.getPaddingRight();
    }

    @Override // com.samsung.sdraw.InterfaceC1035bu
    public int getTextBoxHeight() {
        if (this.f916ai == null) {
            return 0;
        }
        return (this.f916ai.getHeight() - this.f916ai.getPaddingTop()) - this.f916ai.getPaddingBottom();
    }

    @Override // com.samsung.sdraw.InterfaceC1035bu
    public Layout.Alignment getTextBoxAlignment() {
        return this.f910ac;
    }

    @Override // com.samsung.sdraw.InterfaceC1035bu
    public Editable getTextBoxText() {
        return this.f916ai == null ? new SpannableStringBuilder() : new SpannableStringBuilder(this.f916ai.getText());
    }

    @Override // com.samsung.sdraw.InterfaceC1035bu
    public void showTextBox(boolean isShow) {
        if (this.f916ai != null) {
            this.f916ai.setVisibility(isShow ? 0 : 4);
            if (!this.f940bF && this.f865I != null) {
                this.f865I.setVisibility(this.f916ai.getVisibility());
            }
            if (this.f870N != null) {
                this.f870N.setVisibility(this.f916ai.getVisibility());
            }
            if (!isShow && this.f901aT != null) {
                this.f901aT.close();
                this.f901aT = null;
            }
        }
    }

    protected boolean drawStrokeObject(StrokeInfo strokeInfo) {
        StrokeInfo strokeInfo2;
        StrokeSprite sprite;
        if (strokeInfo == null || this.f991l == null || this.f991l.factory == null) {
            return false;
        }
        if (!this.f991l.modes.containsKey(Integer.valueOf(getUserID()))) {
            this.f991l.createNewMode(getUserID());
            this.f991l.stage.m814a(getUserID());
        }
        if (strokeInfo.type >= 6 || strokeInfo.type < 0) {
            strokeInfo.type = 0;
        }
        if (strokeInfo.width < 1.0f) {
            strokeInfo.width = 1.0f;
        } else if (strokeInfo.type == 4) {
            if (strokeInfo.width > 89.0f) {
                strokeInfo.width = 89.0f;
            }
        } else if (strokeInfo.width > 72.0f) {
            strokeInfo.width = 72.0f;
        }
        if (strokeInfo.alpha < 0) {
            strokeInfo.alpha = 0;
        } else if (strokeInfo.alpha > 255) {
            strokeInfo.alpha = 255;
        }
        if (this.f881a == null) {
            strokeInfo2 = null;
        } else {
            strokeInfo2 = new StrokeInfo(this.f881a.getPenType(), this.f881a.getPenColor(), this.f881a.getPenAlpha(), this.f881a.getPenWidth(), strokeInfo.pressure, strokeInfo.points, strokeInfo.meta_state, strokeInfo.event_time);
        }
        int mode = getMode();
        if (strokeInfo.type == 4) {
            changeModeToNoListener(2);
        } else {
            changeModeToNoListener(1);
        }
        m882a(strokeInfo);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= strokeInfo.points.length) {
                break;
            }
            if (i2 == 0) {
                addTouchEvent(0, strokeInfo.points[0].x, strokeInfo.points[0].y, strokeInfo.pressure[0], strokeInfo.meta_state, 0L, 0L);
                int userID = getUserID();
                if (this.f991l.modes.containsKey(Integer.valueOf(userID)) && (this.f991l.modes.get(Integer.valueOf(userID)) instanceof PenMode) && (sprite = ((PenMode) this.f991l.modes.get(Integer.valueOf(userID))).getSprite()) != null) {
                    sprite.objectID = strokeInfo.getID();
                    sprite.multiObjectID = strokeInfo.getMultiObjectID();
                    sprite.multiUserID = userID;
                }
            } else if (i2 == strokeInfo.points.length - 1) {
                addTouchEvent(1, strokeInfo.points[i2].x, strokeInfo.points[i2].y, strokeInfo.pressure[i2], strokeInfo.meta_state, 0L, 0L);
            } else {
                addTouchEvent(2, strokeInfo.points[i2].x, strokeInfo.points[i2].y, strokeInfo.pressure[i2], strokeInfo.meta_state, 0L, 0L);
            }
            i = i2 + 1;
        }
        m882a(strokeInfo2);
        changeModeToNoListener(mode);
        if (mode == 2) {
            this.f991l.setting.setStrokeType(StrokeSprite.Type.Eraser);
            if (this.f881a != null) {
                this.f991l.setting.setStrokeWidth(this.f881a.getEraserWidth());
            }
        }
        return true;
    }

    public boolean drawStrokeObject(int userID, int strokeID, StrokeInfo strokeInfo) {
        StrokeInfo strokeInfo2;
        StrokeSprite sprite;
        if (strokeInfo == null || this.f991l == null) {
            return false;
        }
        if (!this.f991l.modes.containsKey(Integer.valueOf(userID))) {
            this.f991l.createNewMode(userID);
            this.f991l.stage.m814a(userID);
        }
        if (strokeInfo.type >= 6) {
            strokeInfo.type = 5;
        } else if (strokeInfo.type < 0) {
            strokeInfo.type = 0;
        }
        if (strokeInfo.width < 1.0f) {
            strokeInfo.width = 1.0f;
        } else if (strokeInfo.type == 4) {
            if (strokeInfo.width > 89.0f) {
                strokeInfo.width = 89.0f;
            }
        } else if (strokeInfo.width > 72.0f) {
            strokeInfo.width = 72.0f;
        }
        if (strokeInfo.alpha < 0) {
            strokeInfo.alpha = 0;
        } else if (strokeInfo.alpha > 255) {
            strokeInfo.alpha = 255;
        }
        StrokeInfo strokeInfo3 = null;
        int mode = getMode();
        if (userID == getUserID()) {
            if (this.f881a != null) {
                strokeInfo3 = new StrokeInfo(this.f881a.getPenType(), this.f881a.getPenColor(), this.f881a.getPenAlpha(), this.f881a.getPenWidth(), strokeInfo.pressure, strokeInfo.points, strokeInfo.meta_state, strokeInfo.event_time);
            }
            m882a(strokeInfo);
            if (strokeInfo.type == 4) {
                changeModeToNoListener(2);
                strokeInfo2 = strokeInfo3;
            } else {
                changeModeToNoListener(1);
                strokeInfo2 = strokeInfo3;
            }
        } else {
            PenSettingInfo penSettingInfo = new PenSettingInfo();
            penSettingInfo.setPenType(strokeInfo.type);
            penSettingInfo.setPenColor(strokeInfo.color);
            penSettingInfo.setPenWidth((int) strokeInfo.width);
            penSettingInfo.setPenAlpha(strokeInfo.alpha);
            if (strokeInfo.type == 4) {
                penSettingInfo.setEraserWidth((int) strokeInfo.width);
            }
            setPenSettingInfo(userID, penSettingInfo);
            strokeInfo2 = null;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= strokeInfo.points.length) {
                break;
            }
            if (i2 == 0) {
                drawMultiUserStrokePoint(userID, strokeID, 0, strokeInfo.points[0].x, strokeInfo.points[0].y, strokeInfo.pressure[0], strokeInfo.meta_state, 0L, 0L);
                if (this.f991l.modes.containsKey(Integer.valueOf(userID)) && (this.f991l.modes.get(Integer.valueOf(userID)) instanceof PenMode) && (sprite = ((PenMode) this.f991l.modes.get(Integer.valueOf(userID))).getSprite()) != null) {
                    sprite.objectID = strokeInfo.getID();
                    sprite.multiObjectID = strokeID;
                    sprite.multiUserID = userID;
                }
            } else if (i2 == strokeInfo.points.length - 1) {
                drawMultiUserStrokePoint(userID, strokeID, 1, strokeInfo.points[i2].x, strokeInfo.points[i2].y, strokeInfo.pressure[i2], strokeInfo.meta_state, 0L, 0L);
            } else {
                drawMultiUserStrokePoint(userID, strokeID, 2, strokeInfo.points[i2].x, strokeInfo.points[i2].y, strokeInfo.pressure[i2], strokeInfo.meta_state, 0L, 0L);
            }
            i = i2 + 1;
        }
        if (userID == getUserID()) {
            m882a(strokeInfo2);
            changeModeToNoListener(mode);
            if (mode == 2) {
                this.f991l.setting.setStrokeType(StrokeSprite.Type.Eraser);
                if (this.f881a != null) {
                    this.f991l.setting.setStrokeWidth(this.f881a.getEraserWidth());
                }
            }
        }
        return true;
    }

    protected boolean drawTextObject(TextInfo textInfo, boolean select) {
        SpannableStringBuilder spannableStringBuilder;
        AbstractSprite next;
        if (this.f991l != null && this.f991l.setting.m1121l()) {
            return false;
        }
        if (!this.f933az) {
            m949k();
            this.f933az = true;
        }
        if (textInfo == null || this.f991l == null || this.f991l.factory == null) {
            return false;
        }
        if (!this.f991l.modes.containsKey(Integer.valueOf(getUserID()))) {
            this.f991l.createNewMode(getUserID());
            this.f991l.stage.m814a(getUserID());
        }
        int textSize = this.f993n.getTextSize();
        this.f993n.setTextSize(textInfo.size);
        RectF rectF = new RectF(textInfo.rectf);
        PointF pointF = new PointF(rectF.left, rectF.top);
        String str = textInfo.textFont;
        C1040bz c1040bz = new C1040bz(this.f864H, textInfo.textFont);
        if (textInfo.text.length() > 128) {
            spannableStringBuilder = new SpannableStringBuilder(textInfo.text.substring(0, 128));
        } else {
            spannableStringBuilder = new SpannableStringBuilder(textInfo.text);
        }
        spannableStringBuilder.setSpan(new ForegroundColorSpan(textInfo.color), 0, spannableStringBuilder.length(), 18);
        spannableStringBuilder.setSpan(new AbsoluteSizeSpan(this.f993n.getTextSize() * 4), 0, spannableStringBuilder.length(), 18);
        spannableStringBuilder.setSpan(c1040bz, 0, spannableStringBuilder.length(), 18);
        int i = 4;
        if (getSelectLayer() == 0) {
            i = 2;
        }
        TextSprite textSpriteMo1403a = this.f991l.factory.mo1403a((int) rectF.width(), (int) rectF.height(), textInfo.alignment, spannableStringBuilder, str, i);
        textSpriteMo1403a.multiUserID = getUserID();
        this.f995p = textInfo.getID();
        textSpriteMo1403a.objectID = textInfo.getID();
        textSpriteMo1403a.multiObjectID = 0;
        setObjectID(textInfo.getID());
        m906b(textInfo.size);
        if (select) {
            this.f918ak.onFinishJob(this.f991l);
            changeModeTo(4);
            createTextBox(this.f991l.stage.mapFromScene(rectF), spannableStringBuilder, textInfo);
            PointF pointF2 = new PointF();
            pointF2.x = getTextBoxPosition().x;
            pointF2.y = getTextBoxPosition().y;
            pointF2.x -= this.f991l.view.getLeft();
            pointF2.y -= this.f991l.view.getTop();
            PointF pointFMapToScene = this.f991l.stage.mapToScene(pointF2);
            int textBoxWidth = getTextBoxWidth();
            int textBoxHeight = getTextBoxHeight();
            Layout.Alignment textBoxAlignment = getTextBoxAlignment();
            Editable textBoxText = getTextBoxText();
            if (textBoxText.length() == 0) {
                return false;
            }
            TextSprite textSpriteMo1402a = this.f991l.factory.mo1402a(textBoxWidth, textBoxHeight, textBoxAlignment, textBoxText, this.f991l.setting.getTextFont());
            textSpriteMo1402a.objectID = textInfo.getID();
            setObjectID(textInfo.getID());
            textSpriteMo1402a.moveTo(pointFMapToScene.x, pointFMapToScene.y);
            this.f991l.stage.addSprite(textSpriteMo1402a, true);
            showTextBox(false);
            this.f991l.getTextMode(getUserID()).f1341a = textSpriteMo1402a;
            textSpriteMo1402a.select();
            textSpriteMo1402a.setVisible(false);
            createTextBox(textSpriteMo1402a.getBounds(), textSpriteMo1402a.m1201h(), new TextInfo(textSpriteMo1402a.m1195b(), textSpriteMo1402a.m1197d(), textSpriteMo1402a.m1201h().toString(), textSpriteMo1402a.m1202i(), textSpriteMo1402a.m1198e(), textSpriteMo1402a.m1199f(), textSpriteMo1402a.m1200g()));
            this.f991l.getTextMode(getUserID()).m1180a((AbstractModeContext) this.f991l, false);
            if (this.f968bm != null) {
                this.f968bm.onObjectSelected(textSpriteMo1402a.m1203j(), true);
            }
        } else {
            int length = spannableStringBuilder.length();
            switch (textInfo.textStyle) {
                case 1:
                    spannableStringBuilder.setSpan(this.f908aa[1], 0, length, 18);
                    break;
                case 2:
                    spannableStringBuilder.setSpan(this.f908aa[2], 0, length, 18);
                    break;
                case 3:
                    spannableStringBuilder.setSpan(this.f908aa[1], 0, length, 18);
                    spannableStringBuilder.setSpan(this.f908aa[2], 0, length, 18);
                    break;
                case 4:
                    spannableStringBuilder.setSpan(this.f908aa[3], 0, length, 18);
                    break;
                case 5:
                    spannableStringBuilder.setSpan(this.f908aa[1], 0, length, 18);
                    spannableStringBuilder.setSpan(this.f908aa[3], 0, length, 18);
                    break;
                case 6:
                    spannableStringBuilder.setSpan(this.f908aa[2], 0, length, 18);
                    spannableStringBuilder.setSpan(this.f908aa[3], 0, length, 18);
                    break;
                case 7:
                    spannableStringBuilder.setSpan(this.f908aa[1], 0, length, 18);
                    spannableStringBuilder.setSpan(this.f908aa[2], 0, length, 18);
                    spannableStringBuilder.setSpan(this.f908aa[3], 0, length, 18);
                    break;
            }
            spannableStringBuilder.setSpan(textInfo.alignment, 0, length, 18);
            textSpriteMo1403a.m1194a(spannableStringBuilder, pointF, (int) rectF.width(), (int) rectF.height(), textInfo.alignment);
            textSpriteMo1403a.setVisible(true);
            this.f991l.stage.addSprite(textSpriteMo1403a, true, textSpriteMo1403a.multiUserID);
            LinkedList<AbstractSprite> linkedListM811a = this.f991l.stage.m811a(C0989ab.class);
            LinkedList<AbstractSprite> linkedListM826b = this.f991l.stage.m826b(C0989ab.class);
            LinkedList<AbstractSprite> linkedListM811a2 = this.f991l.stage.m811a(TextSprite.class);
            LinkedList<AbstractSprite> linkedListM826b2 = this.f991l.stage.m826b(TextSprite.class);
            Iterator<AbstractSprite> it = this.f991l.stage.getSelectedSprites().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                } else {
                    next = it.next();
                    if (next.isSelected()) {
                    }
                }
            }
            if (next instanceof C0989ab) {
                this.f991l.stage.m818a(2, linkedListM811a, next);
                this.f991l.stage.m817a(2, linkedListM811a2);
                this.f991l.stage.m818a(4, linkedListM826b, next);
                this.f991l.stage.m817a(4, linkedListM826b2);
            } else {
                this.f991l.stage.m817a(2, linkedListM811a);
                this.f991l.stage.m818a(2, linkedListM811a2, next);
                this.f991l.stage.m817a(4, linkedListM826b);
                this.f991l.stage.m818a(4, linkedListM826b2, next);
            }
            this.f993n.setTextSize(textSize);
            m906b(textSize);
            this.f991l.invalidate();
        }
        return true;
    }

    public boolean drawTextObject(int userID, int textID, TextInfo textInfo) {
        SpannableStringBuilder spannableStringBuilder;
        if (this.f991l != null && this.f991l.setting.m1121l()) {
            return false;
        }
        if (!this.f933az) {
            m949k();
            this.f933az = true;
        }
        if (textInfo == null || this.f991l == null) {
            return false;
        }
        int selectLayer = getSelectLayer();
        if (userID == getUserID()) {
            this.f991l.stage.setSelectLayer(textInfo.getLayerID());
        }
        if (!this.f991l.modes.containsKey(Integer.valueOf(userID))) {
            this.f991l.createNewMode(userID);
            this.f991l.stage.m814a(userID);
        }
        RectF rectF = new RectF(textInfo.rectf);
        PointF pointF = new PointF(rectF.left, rectF.top);
        String str = textInfo.textFont;
        C1040bz c1040bz = new C1040bz(this.f864H, textInfo.textFont);
        if (textInfo.text.length() > 128) {
            spannableStringBuilder = new SpannableStringBuilder(textInfo.text.substring(0, 128));
        } else {
            spannableStringBuilder = new SpannableStringBuilder(textInfo.text);
        }
        spannableStringBuilder.setSpan(new ForegroundColorSpan(textInfo.color), 0, spannableStringBuilder.length(), 18);
        spannableStringBuilder.setSpan(new AbsoluteSizeSpan(textInfo.size * 4), 0, spannableStringBuilder.length(), 18);
        spannableStringBuilder.setSpan(c1040bz, 0, spannableStringBuilder.length(), 18);
        int i = 4;
        if (textInfo.getLayerID() == 0 || userID != getUserID()) {
            i = 2;
        }
        TextSprite textSpriteMo1403a = this.f991l.factory.mo1403a((int) rectF.width(), (int) rectF.height(), textInfo.alignment, spannableStringBuilder, str, i);
        textSpriteMo1403a.objectID = textInfo.getID();
        textSpriteMo1403a.multiUserID = userID;
        textSpriteMo1403a.multiObjectID = textID;
        int length = spannableStringBuilder.length();
        switch (textInfo.textStyle) {
            case 1:
                spannableStringBuilder.setSpan(this.f908aa[1], 0, length, 18);
                break;
            case 2:
                spannableStringBuilder.setSpan(this.f908aa[2], 0, length, 18);
                break;
            case 3:
                spannableStringBuilder.setSpan(this.f908aa[1], 0, length, 18);
                spannableStringBuilder.setSpan(this.f908aa[2], 0, length, 18);
                break;
            case 4:
                spannableStringBuilder.setSpan(this.f908aa[3], 0, length, 18);
                break;
            case 5:
                spannableStringBuilder.setSpan(this.f908aa[1], 0, length, 18);
                spannableStringBuilder.setSpan(this.f908aa[3], 0, length, 18);
                break;
            case 6:
                spannableStringBuilder.setSpan(this.f908aa[2], 0, length, 18);
                spannableStringBuilder.setSpan(this.f908aa[3], 0, length, 18);
                break;
            case 7:
                spannableStringBuilder.setSpan(this.f908aa[1], 0, length, 18);
                spannableStringBuilder.setSpan(this.f908aa[2], 0, length, 18);
                spannableStringBuilder.setSpan(this.f908aa[3], 0, length, 18);
                break;
        }
        spannableStringBuilder.setSpan(textInfo.alignment, 0, length, 18);
        textSpriteMo1403a.m1194a(spannableStringBuilder, pointF, (int) rectF.width(), (int) rectF.height(), textInfo.alignment);
        textSpriteMo1403a.setVisible(true);
        this.f991l.stage.addSprite(textSpriteMo1403a, true, userID);
        this.f991l.stage.renderSprite(textSpriteMo1403a.getLayerID(), textSpriteMo1403a);
        this.f991l.invalidate();
        if (userID == getUserID()) {
            this.f991l.stage.setSelectLayer(selectLayer);
        }
        return true;
    }

    /* renamed from: l */
    private void m951l() {
        changeModeTo(this.f991l.getMode(getUserID()));
        m941i();
        this.f915ah = true;
    }

    public void NewClearView() {
        setReObjectInfos(this.f934b);
        if (this.f991l != null) {
            this.f991l.clear();
        }
    }

    public void setReObjectInfos(LinkedList<ObjectInfo> ObjectInfos) {
        this.f934b = getObjectInfos();
    }

    public LinkedList<ObjectInfo> getReObjectInfos() {
        return this.f934b;
    }

    public void setOnSelectChangeListener(OnSelectChangeListener listener) {
        this.f957bb = listener;
    }

    public void setOnCanvasMatrixChangeListener(OnCanvasMatrixChangeListener listener) {
        this.f958bc = listener;
    }

    public void setMinZoom(float zoom) {
        if (zoom > VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
            if (this.f882aA == null) {
                this.f882aA = new C0988aa(getContext(), this.f992m, new Rect());
            }
            this.f882aA.m1235d(zoom);
        }
    }

    public void setMaxZoom(float zoom) {
        this.f882aA.m1239e(zoom);
    }

    /* renamed from: b */
    void m976b() {
        this.f991l.serializeContext(false);
    }

    /* renamed from: c */
    boolean m978c() {
        return this.f991l.deserializeContext(false);
    }

    public void setEnableZoom(boolean set) {
        this.f959bd = set;
        if (this.f882aA != null) {
            this.f882aA.m1233c(set);
        }
    }

    public void setMatrix(Matrix matrix) {
        this.f959bd = false;
        if (this.f991l != null) {
            this.f991l.m674a(matrix);
            invalidate();
        }
        if (this.f958bc != null) {
            this.f958bc.onMatrixChanged(matrix);
        }
    }

    public void panTo(float x, float y) {
        if (this.f882aA != null) {
            this.f882aA.m1232c(x, y);
        }
    }

    public void setCanvasSize(int w, int h) {
        if (isShowTextBox()) {
            hideImm();
        }
        this.f992m = new Rect(0, 0, w, h);
        if (this.f991l != null) {
            try {
                this.f991l.changeCanvasSize(this.f992m);
                this.f991l.changeScreenSize(this.f992m);
                this.f991l.setZoom(1.0f);
                this.f991l.setPanning(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET);
                if (this.f882aA != null) {
                    this.f882aA.m1218a(this.f992m);
                    return;
                }
                this.f960be = true;
                this.f961bf = w;
                this.f962bg = h;
            } catch (OutOfMemoryError e) {
                if (this.f980by != null) {
                    this.f980by.onOutOfMemory();
                }
            }
        }
    }

    public void setInitializeFinishListener(InitializeFinishListener l) {
        this.f963bh = l;
    }

    public void setScrollDrawing(boolean visible) {
        this.f930aw = visible;
    }

    public void zoomTo(float scale, float cx, float cy) {
        if (this.f959bd && this.f882aA != null) {
            this.f882aA.m1216a(scale, cx, cy);
        }
    }

    public void setBaseScale(float scale) {
        this.f882aA.f1367a.setScale(scale, scale);
        this.f882aA.m1216a(1.0f, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET);
        this.f930aw = false;
    }

    @Override // com.samsung.sdraw.InterfaceC1035bu
    public void setObjectID(int objectID) {
        this.f995p = objectID;
    }

    @Override // com.samsung.sdraw.InterfaceC1035bu
    public int getObjectID() {
        return this.f995p;
    }

    public RectF getSelectedObjectBounds() {
        RectF rectF = new RectF();
        ArrayList<AbstractSprite> selectedSprites = this.f991l.stage.getSelectedSprites();
        if (selectedSprites.size() != 0) {
            return selectedSprites.get(0).getBounds();
        }
        if (isShowTextBox()) {
            Point textBoxPosition = getTextBoxPosition();
            RectF rectF2 = new RectF(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, getTextBoxWidth(), getTextBoxHeight());
            rectF2.offset(textBoxPosition.x, textBoxPosition.y);
            return rectF2;
        }
        return rectF;
    }

    public ObjectType getSelectedObjectType() {
        ArrayList<AbstractSprite> selectedSprites = this.f991l.stage.getSelectedSprites();
        if (selectedSprites.size() != 0) {
            AbstractSprite abstractSprite = selectedSprites.get(0);
            if (abstractSprite instanceof StrokeSprite) {
                return ObjectType.Stroke;
            }
            if (abstractSprite instanceof C0989ab) {
                return ObjectType.Image;
            }
            if (abstractSprite instanceof TextSprite) {
                return ObjectType.Text;
            }
            return ObjectType.None;
        }
        if (isShowTextBox()) {
            return ObjectType.Text;
        }
        return ObjectType.None;
    }

    /* renamed from: m */
    private boolean m955m() {
        int rotation = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getRotation();
        return rotation == 0 || rotation == 2;
    }

    public void setOnInitializeFinishListener(OnInitializeFinishListener listener) {
        this.f967bl = listener;
    }

    public void setOnObjectListener(OnObjectListener listener) {
        this.f968bm = listener;
    }

    public boolean deleteObject(int nObjectID, boolean bCanBeUndo) {
        LinkedList<AbstractSprite> sprites = this.f991l.stage.getSprites(0);
        int i = 0;
        while (i < 2) {
            Iterator<AbstractSprite> it = sprites.iterator();
            while (it.hasNext()) {
                AbstractSprite next = it.next();
                if (next.objectID == nObjectID) {
                    if ((next instanceof C0989ab) && next.isVisible()) {
                        if (this.f968bm != null && next.isSelected()) {
                            next.deselect();
                            this.f968bm.onObjectSelected(((C0989ab) next).m1262c(), false);
                        }
                        this.f991l.stage.deleteSprite(next, bCanBeUndo);
                        changeModeTo(this.f1003x);
                        this.f991l.onActivate(true);
                        if (this.f991l.historyChangeListener != null) {
                            this.f991l.historyChangeListener.onHistoryChanged(this.f991l.stage.isUndoable(), this.f991l.stage.isRedoable());
                        }
                        return true;
                    }
                    if ((next instanceof TextSprite) && next.isVisible()) {
                        this.f991l.getTextMode(next.multiUserID).onFinishJob(this.f991l);
                        this.f991l.stage.deleteSprite(next, bCanBeUndo);
                        next.deselect();
                        showTextBox(false);
                        restoreTextSettingInfo();
                        if (this.f916ai != null) {
                            this.f916ai.setText("");
                        }
                        this.f991l.onActivate(true);
                        if (this.f991l.historyChangeListener != null) {
                            this.f991l.historyChangeListener.onHistoryChanged(this.f991l.stage.isUndoable(), this.f991l.stage.isRedoable());
                        }
                        return true;
                    }
                    if ((next instanceof StrokeSprite) && next.isVisible()) {
                        this.f991l.stage.deleteSprite(next, bCanBeUndo);
                        this.f991l.changeModeTo(1);
                        if (this.f947bM != null) {
                            this.f947bM.onModeChanged(1);
                        }
                        if (this.f991l.historyChangeListener != null) {
                            this.f991l.historyChangeListener.onHistoryChanged(this.f991l.stage.isUndoable(), this.f991l.stage.isRedoable());
                        }
                        return true;
                    }
                    if ((next instanceof TextSprite) && next.isSelected()) {
                        if (this.f968bm != null) {
                            this.f968bm.onObjectSelected(((TextSprite) next).m1203j(), false);
                        }
                        this.f991l.stage.deleteSprite(next, bCanBeUndo);
                        next.deselect();
                        showTextBox(false);
                        restoreTextSettingInfo();
                        if (this.f916ai != null) {
                            this.f916ai.setText("");
                        }
                        this.f991l.onActivate(true);
                        if (this.f991l.historyChangeListener != null) {
                            this.f991l.historyChangeListener.onHistoryChanged(this.f991l.stage.isUndoable(), this.f991l.stage.isRedoable());
                        }
                        return true;
                    }
                }
            }
            i++;
            sprites = this.f991l.stage.getSprites(3);
        }
        if (!isShowTextBox()) {
            return false;
        }
        showTextBox(false);
        restoreTextSettingInfo();
        if (this.f916ai != null) {
            this.f916ai.setText("");
        }
        return true;
    }

    public boolean deleteObject(int userID, int objectID, boolean bCanBeUndo) {
        LinkedList<AbstractSprite> sprites = this.f991l.stage.getSprites(0);
        int i = userID == getUserID() ? 2 : 1;
        LinkedList<AbstractSprite> sprites2 = sprites;
        int i2 = 0;
        while (i2 < i) {
            Iterator<AbstractSprite> it = sprites2.iterator();
            while (it.hasNext()) {
                AbstractSprite next = it.next();
                if (next.multiObjectID == objectID && next.multiUserID == userID) {
                    if ((next instanceof C0989ab) && next.isVisible()) {
                        this.f991l.stage.deleteSprite(next, bCanBeUndo, userID);
                        changeModeTo(userID, this.f1003x);
                        if (userID != getUserID() || this.f991l.historyChangeListener == null) {
                            return true;
                        }
                        this.f991l.historyChangeListener.onHistoryChanged(this.f991l.stage.isUndoable(), this.f991l.stage.isRedoable());
                        return true;
                    }
                    if ((next instanceof TextSprite) && next.isVisible()) {
                        this.f991l.getTextMode(userID).onFinishJob(this.f991l);
                        this.f991l.stage.deleteSprite(next, bCanBeUndo, userID);
                        next.deselect();
                        if (userID == getUserID()) {
                            showTextBox(false);
                            restoreTextSettingInfo();
                            if (this.f916ai != null) {
                                this.f916ai.setText("");
                            }
                        }
                        this.f991l.onActivate(true, userID);
                        if (userID != getUserID() || this.f991l.historyChangeListener == null) {
                            return true;
                        }
                        this.f991l.historyChangeListener.onHistoryChanged(this.f991l.stage.isUndoable(), this.f991l.stage.isRedoable());
                        return true;
                    }
                    if ((next instanceof StrokeSprite) && next.isVisible()) {
                        this.f991l.stage.deleteSprite(next, bCanBeUndo, userID);
                        this.f991l.changeModeTo(userID, 1);
                        this.f991l.onActivate(true, userID);
                        if (userID != getUserID() || this.f991l.historyChangeListener == null) {
                            return true;
                        }
                        this.f991l.historyChangeListener.onHistoryChanged(this.f991l.stage.isUndoable(), this.f991l.stage.isRedoable());
                        return true;
                    }
                    if ((next instanceof TextSprite) && next.isSelected()) {
                        if (this.f968bm != null) {
                            this.f968bm.onObjectSelected(((TextSprite) next).m1203j(), false);
                        }
                        this.f991l.stage.deleteSprite(next, bCanBeUndo, userID);
                        next.deselect();
                        if (userID == getUserID()) {
                            showTextBox(false);
                            restoreTextSettingInfo();
                            if (this.f916ai != null) {
                                this.f916ai.setText("");
                            }
                        }
                        this.f991l.onActivate(true, userID);
                        if (userID != getUserID() || this.f991l.historyChangeListener == null) {
                            return true;
                        }
                        this.f991l.historyChangeListener.onHistoryChanged(this.f991l.stage.isUndoable(), this.f991l.stage.isRedoable());
                        return true;
                    }
                }
            }
            i2++;
            sprites2 = this.f991l.stage.getSprites(3);
        }
        if (userID != getUserID() || !isShowTextBox()) {
            return false;
        }
        showTextBox(false);
        restoreTextSettingInfo();
        if (this.f916ai == null) {
            return true;
        }
        this.f916ai.setText("");
        return true;
    }

    public boolean deleteObject(ObjectInfo objectInfo, boolean bCanBeUndo) {
        return deleteObject(objectInfo.getID(), bCanBeUndo);
    }

    public boolean deleteObject(int userID, int objectID, ObjectInfo objectInfo, boolean bCanBeUndo) {
        return deleteObject(userID, objectID, bCanBeUndo);
    }

    public boolean selectObject(int nObjectID) {
        Iterator<AbstractSprite> it = this.f991l.stage.getSprites().iterator();
        while (it.hasNext()) {
            AbstractSprite next = it.next();
            if (next.objectID == nObjectID) {
                if ((next instanceof C0989ab) && next.isVisible()) {
                    next.select();
                    this.f991l.changeModeTo(3);
                    this.f991l.invalidate();
                    if (this.f947bM != null) {
                        this.f947bM.onModeChanged(3);
                    }
                    return true;
                }
                if ((next instanceof TextSprite) && next.isVisible()) {
                    TextSprite textSprite = (TextSprite) next;
                    if (getMode() != 4) {
                        this.f991l.changeModeTo(4);
                    }
                    this.f991l.getTextMode(getUserID()).f1341a = textSprite;
                    next.select();
                    if (!this.f877U) {
                        setMinZoom(1.0f);
                        zoomTo(1.0f);
                        if (this.f959bd) {
                            this.f932ay = true;
                            setZoomEnable(false);
                        }
                    }
                    next.setVisible(false);
                    createTextBox(this.f991l.stage.mapFromScene(textSprite.getBounds()), textSprite.m1201h(), new TextInfo(textSprite.m1195b(), textSprite.m1197d(), textSprite.m1201h().toString(), textSprite.m1202i(), textSprite.m1198e(), textSprite.m1199f(), textSprite.m1200g()));
                    this.f991l.getTextMode(getUserID()).m1180a((AbstractModeContext) this.f991l, false);
                    if (!this.f877U) {
                        setZoomEnable(false);
                    }
                    if (this.f947bM != null) {
                        this.f947bM.onModeChanged(4);
                    }
                    if (this.f968bm != null) {
                        this.f968bm.onObjectSelected(textSprite.m1203j(), true);
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public ObjectInfo selectObject(int nXPos, int nYPos) {
        AbstractSprite abstractSpriteSelectHittedSprite = this.f991l.stage.selectHittedSprite(new PointF(nXPos, nYPos));
        if (abstractSpriteSelectHittedSprite == null) {
            return null;
        }
        if ((abstractSpriteSelectHittedSprite instanceof C0989ab) && abstractSpriteSelectHittedSprite.isVisible()) {
            abstractSpriteSelectHittedSprite.select();
            this.f991l.changeModeTo(3);
            if (this.f947bM != null) {
                this.f947bM.onModeChanged(3);
            }
            this.f991l.invalidate();
            return ((C0989ab) abstractSpriteSelectHittedSprite).m1262c();
        }
        if (!(abstractSpriteSelectHittedSprite instanceof TextSprite)) {
            return null;
        }
        TextSprite textSprite = (TextSprite) abstractSpriteSelectHittedSprite;
        if (getMode() != 4) {
            this.f991l.changeModeTo(4);
        }
        this.f991l.getTextMode(getUserID()).f1341a = textSprite;
        abstractSpriteSelectHittedSprite.select();
        if (!this.f877U) {
            setMinZoom(1.0f);
            zoomTo(1.0f);
            if (this.f959bd) {
                this.f932ay = true;
                setZoomEnable(false);
            }
        }
        abstractSpriteSelectHittedSprite.setVisible(false);
        createTextBox(this.f991l.stage.mapFromScene(textSprite.getBounds()), textSprite.m1201h(), new TextInfo(textSprite.m1195b(), textSprite.m1197d(), textSprite.m1201h().toString(), textSprite.m1202i(), textSprite.m1198e(), textSprite.m1199f(), textSprite.m1200g()));
        this.f991l.getTextMode(getUserID()).m1180a((AbstractModeContext) this.f991l, false);
        if (!this.f877U) {
            setZoomEnable(false);
        }
        if (this.f947bM != null) {
            this.f947bM.onModeChanged(4);
        }
        if (this.f968bm != null) {
            this.f968bm.onObjectSelected(textSprite.m1203j(), true);
        }
        return ((TextSprite) abstractSpriteSelectHittedSprite).m1203j();
    }

    public void setOnSettingViewShowListener(OnSettingViewShowListener listener) {
        this.f969bn = listener;
    }

    protected void setUsingHistoricalEventForStroke(boolean set) {
        if (this.f991l != null) {
            this.f991l.setting.setUseHistoricalEvents(set);
        }
    }

    public void hideImm() {
        ((InputMethodManager) getContext().getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 2);
        if (isShowTextBox() && this.f991l.getMode(getUserID()) == 4) {
            this.f991l.getTextMode(getUserID()).onFinishJob(this.f991l);
        }
    }

    /* renamed from: a */
    private int m864a(float f, float f2) {
        if (this.f991l == null || this.f991l.stage == null) {
            return 0;
        }
        PointF pointF = new PointF(f, f2);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        if (pointF.y >= this.f991l.stage.f845i.getHeight()) {
            return 0;
        }
        if (getSelectLayer() == 0) {
            int pixel = this.f991l.stage.f845i.getPixel((int) pointF.x, (int) pointF.y);
            Paint paint = new Paint();
            paint.setColor(pixel);
            canvas.drawPoint(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, paint);
            int pixel2 = this.f991l.stage.m825b(0).getPixel((int) pointF.x, (int) pointF.y);
            Paint paint2 = new Paint();
            paint2.setColor(pixel2);
            canvas.drawPoint(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, paint2);
        } else {
            int pixel3 = this.f991l.stage.fixedSprites2.getPixel((int) pointF.x, (int) pointF.y);
            Paint paint3 = new Paint();
            paint3.setColor(pixel3);
            canvas.drawPoint(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, paint3);
            int pixel4 = this.f991l.stage.m825b(3).getPixel((int) pointF.x, (int) pointF.y);
            Paint paint4 = new Paint();
            paint4.setColor(pixel4);
            canvas.drawPoint(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, paint4);
        }
        int pixel5 = bitmapCreateBitmap.getPixel(0, 0);
        bitmapCreateBitmap.recycle();
        return pixel5;
    }

    public int getDropperColor(float x, float y) {
        int pixel = 0;
        if (this.f991l != null) {
            PointF pointFMapToScene = this.f991l.stage.mapToScene(new PointF(x, y));
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            if (pointFMapToScene.x > this.f992m.right - 1) {
                pointFMapToScene.x = this.f992m.right - 1;
            }
            if (pointFMapToScene.y > this.f992m.bottom - 1) {
                pointFMapToScene.y = this.f992m.bottom - 1;
            }
            if (this.f991l.setting != null && this.f991l.setting.m1121l()) {
                if (this.f991l.stage.f845i != null) {
                    int pixel2 = this.f991l.stage.f845i.getPixel((int) pointFMapToScene.x, (int) pointFMapToScene.y);
                    Paint paint = new Paint();
                    paint.setColor(pixel2);
                    canvas.drawPoint(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, paint);
                    int pixel3 = this.f991l.stage.m825b(0).getPixel((int) pointFMapToScene.x, (int) pointFMapToScene.y);
                    Paint paint2 = new Paint();
                    paint2.setColor(pixel3);
                    canvas.drawPoint(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, paint2);
                }
                if (this.f991l.stage.fixedSprites2 != null) {
                    int pixel4 = this.f991l.stage.fixedSprites2.getPixel((int) pointFMapToScene.x, (int) pointFMapToScene.y);
                    Paint paint3 = new Paint();
                    paint3.setColor(pixel4);
                    canvas.drawPoint(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, paint3);
                    int pixel5 = this.f991l.stage.m825b(3).getPixel((int) pointFMapToScene.x, (int) pointFMapToScene.y);
                    Paint paint4 = new Paint();
                    paint4.setColor(pixel5);
                    canvas.drawPoint(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, paint4);
                }
            } else {
                if (this.f991l.stage.f845i != null) {
                    int pixel6 = this.f991l.stage.f845i.getPixel((int) pointFMapToScene.x, (int) pointFMapToScene.y);
                    Paint paint5 = new Paint();
                    paint5.setColor(pixel6);
                    canvas.drawPoint(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, paint5);
                    int pixel7 = this.f991l.stage.m825b(2).getPixel((int) pointFMapToScene.x, (int) pointFMapToScene.y);
                    Paint paint6 = new Paint();
                    paint6.setColor(pixel7);
                    canvas.drawPoint(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, paint6);
                    int pixel8 = this.f991l.stage.m825b(0).getPixel((int) pointFMapToScene.x, (int) pointFMapToScene.y);
                    Paint paint7 = new Paint();
                    paint7.setColor(pixel8);
                    canvas.drawPoint(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, paint7);
                }
                if (this.f991l.stage.fixedSprites2 != null) {
                    int pixel9 = this.f991l.stage.fixedSprites2.getPixel((int) pointFMapToScene.x, (int) pointFMapToScene.y);
                    Paint paint8 = new Paint();
                    paint8.setColor(pixel9);
                    canvas.drawPoint(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, paint8);
                    int pixel10 = this.f991l.stage.m825b(4).getPixel((int) pointFMapToScene.x, (int) pointFMapToScene.y);
                    Paint paint9 = new Paint();
                    paint9.setColor(pixel10);
                    canvas.drawPoint(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, paint9);
                    int pixel11 = this.f991l.stage.m825b(3).getPixel((int) pointFMapToScene.x, (int) pointFMapToScene.y);
                    Paint paint10 = new Paint();
                    paint10.setColor(pixel11);
                    canvas.drawPoint(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, paint10);
                }
            }
            pixel = bitmapCreateBitmap.getPixel(0, 0);
            bitmapCreateBitmap.recycle();
            if (this.f974bs != null) {
                this.f974bs.onDropperColorChanged(pixel);
            }
        }
        return pixel;
    }

    public void setDropperMode(boolean spoid_mode) {
        this.f973br = spoid_mode;
    }

    public void setOnDropperColorChangeListener(OnDropperColorChangeListener listener) {
        this.f974bs = listener;
    }

    /* renamed from: a */
    private boolean m893a(TextInfo textInfo) {
        SpannableStringBuilder spannableStringBuilder;
        boolean z;
        if (textInfo != null) {
            if (textInfo.size < 5) {
                textInfo.size = 5;
            } else if (textInfo.size > 20) {
                textInfo.size = 20;
            }
            Iterator<AbstractSprite> it = this.f991l.stage.getSprites().iterator();
            while (it.hasNext()) {
                AbstractSprite next = it.next();
                if ((next instanceof TextSprite) && ((TextSprite) next).objectID == textInfo.getID()) {
                    float f = 40;
                    float f2 = 40;
                    if (textInfo.rectf == null) {
                        textInfo.rectf = ((TextSprite) next).m1202i();
                    } else if (!this.f992m.contains((int) textInfo.rectf.left, (int) textInfo.rectf.top, (int) textInfo.rectf.right, (int) textInfo.rectf.bottom) || textInfo.rectf.left >= textInfo.rectf.right || textInfo.rectf.top >= textInfo.rectf.bottom) {
                        return false;
                    }
                    PointF pointFMapToScene = this.f991l.stage.mapToScene(new PointF(((float) 40) < textInfo.rectf.left ? textInfo.rectf.left : f, ((float) 40) < textInfo.rectf.top ? textInfo.rectf.top : f2));
                    int iWidth = (int) textInfo.rectf.width();
                    int iHeight = (int) textInfo.rectf.height();
                    if (pointFMapToScene.x + iWidth >= this.f992m.right - 40) {
                        iWidth = (int) ((this.f992m.right - pointFMapToScene.x) - 40);
                    }
                    if (pointFMapToScene.y + iHeight >= this.f992m.bottom - 40) {
                        iHeight = (int) ((this.f992m.bottom - pointFMapToScene.y) - 40);
                    }
                    if (textInfo.alignment == null) {
                        textInfo.alignment = ((TextSprite) next).m1199f();
                    }
                    Layout.Alignment alignment = textInfo.alignment;
                    if (textInfo.text == null) {
                        textInfo.text = ((TextSprite) next).m1201h().toString();
                    }
                    if (textInfo.text.length() > 128) {
                        spannableStringBuilder = new SpannableStringBuilder(textInfo.text.substring(0, 128));
                    } else {
                        spannableStringBuilder = new SpannableStringBuilder(textInfo.text);
                    }
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(textInfo.color), 0, spannableStringBuilder.length(), 18);
                    spannableStringBuilder.setSpan(new AbsoluteSizeSpan(textInfo.size * 4), 0, spannableStringBuilder.length(), 18);
                    if (textInfo.textFont == null) {
                        textInfo.textFont = ((TextSprite) next).m1200g();
                    } else {
                        Iterator<String> it2 = C1040bz.f1673c.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                z = false;
                                break;
                            }
                            if (it2.next().equals(textInfo.textFont)) {
                                z = true;
                                break;
                            }
                        }
                        if (!z) {
                            textInfo.textFont = "Sans serif";
                        }
                    }
                    spannableStringBuilder.setSpan(new C1040bz(this.f864H, textInfo.textFont), 0, spannableStringBuilder.length(), 18);
                    if ((textInfo.textStyle & 1) == 1) {
                        spannableStringBuilder.setSpan(this.f908aa[1], 0, spannableStringBuilder.length(), 18);
                    }
                    if ((textInfo.textStyle & 2) == 2) {
                        spannableStringBuilder.setSpan(this.f908aa[2], 0, spannableStringBuilder.length(), 18);
                    }
                    if ((textInfo.textStyle & 4) == 4) {
                        spannableStringBuilder.setSpan(this.f908aa[3], 0, spannableStringBuilder.length(), 18);
                    }
                    if ((textInfo.textStyle & 8) == 8) {
                        spannableStringBuilder.setSpan(this.f908aa[4], 0, spannableStringBuilder.length(), 18);
                    }
                    this.f991l.stage.modifyTextSprite((TextSprite) next, pointFMapToScene, iWidth, iHeight, alignment, spannableStringBuilder, true);
                    this.f918ak.m1180a((AbstractModeContext) this.f991l, false);
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    private boolean m892a(ImageInfo imageInfo, boolean z) {
        if (imageInfo != null) {
            Iterator<AbstractSprite> it = this.f991l.stage.getSprites().iterator();
            while (it.hasNext()) {
                AbstractSprite next = it.next();
                if ((next instanceof C0989ab) && ((C0989ab) next).objectID == imageInfo.getID()) {
                    if (imageInfo.rectf == null) {
                        imageInfo.rectf = next.getBounds();
                    } else if (!this.f913af.contains(imageInfo.rectf) || imageInfo.rectf.left >= imageInfo.rectf.right || imageInfo.rectf.top >= imageInfo.rectf.bottom) {
                        return false;
                    }
                    this.f991l.stage.modifyImageSprite((C0989ab) next, imageInfo, z);
                    this.f919al.m1091a(this.f991l, next);
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    private boolean m886a(int i, int i2, TextInfo textInfo) {
        LinkedList<AbstractSprite> sprites;
        SpannableStringBuilder spannableStringBuilder;
        boolean z;
        if (textInfo != null) {
            if (textInfo.size < 5) {
                textInfo.size = 5;
            } else if (textInfo.size > 20) {
                textInfo.size = 20;
            }
            if (textInfo.getLayerID() == 0 || i != getUserID()) {
                sprites = this.f991l.stage.getSprites(0);
            } else {
                sprites = this.f991l.stage.getSprites(3);
            }
            Iterator<AbstractSprite> it = sprites.iterator();
            while (it.hasNext()) {
                AbstractSprite next = it.next();
                if ((next instanceof TextSprite) && ((TextSprite) next).multiUserID == i && ((TextSprite) next).multiObjectID == i2) {
                    float f = 40;
                    float f2 = 40;
                    if (textInfo.rectf == null) {
                        textInfo.rectf = ((TextSprite) next).m1202i();
                    } else if (!this.f992m.contains((int) textInfo.rectf.left, (int) textInfo.rectf.top, (int) textInfo.rectf.right, (int) textInfo.rectf.bottom) || textInfo.rectf.left >= textInfo.rectf.right || textInfo.rectf.top >= textInfo.rectf.bottom) {
                        return false;
                    }
                    PointF pointFMapToScene = this.f991l.stage.mapToScene(new PointF(((float) 40) < textInfo.rectf.left ? textInfo.rectf.left : f, ((float) 40) < textInfo.rectf.top ? textInfo.rectf.top : f2));
                    int iWidth = (int) textInfo.rectf.width();
                    int iHeight = (int) textInfo.rectf.height();
                    if (pointFMapToScene.x + iWidth >= this.f992m.right - 40) {
                        iWidth = (int) ((this.f992m.right - pointFMapToScene.x) - 40);
                    }
                    if (pointFMapToScene.y + iHeight >= this.f992m.bottom - 40) {
                        iHeight = (int) ((this.f992m.bottom - pointFMapToScene.y) - 40);
                    }
                    if (textInfo.alignment == null) {
                        textInfo.alignment = ((TextSprite) next).m1199f();
                    }
                    Layout.Alignment alignment = textInfo.alignment;
                    if (textInfo.text == null) {
                        textInfo.text = ((TextSprite) next).m1201h().toString();
                    }
                    if (textInfo.text.length() > 128) {
                        spannableStringBuilder = new SpannableStringBuilder(textInfo.text.substring(0, 128));
                    } else {
                        spannableStringBuilder = new SpannableStringBuilder(textInfo.text);
                    }
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(textInfo.color), 0, spannableStringBuilder.length(), 18);
                    spannableStringBuilder.setSpan(new AbsoluteSizeSpan(textInfo.size * 4), 0, spannableStringBuilder.length(), 18);
                    if (textInfo.textFont == null) {
                        textInfo.textFont = ((TextSprite) next).m1200g();
                    } else {
                        Iterator<String> it2 = C1040bz.f1673c.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                z = false;
                                break;
                            }
                            if (it2.next().equals(textInfo.textFont)) {
                                z = true;
                                break;
                            }
                        }
                        if (!z) {
                            textInfo.textFont = "Sans serif";
                        }
                    }
                    spannableStringBuilder.setSpan(new C1040bz(this.f864H, textInfo.textFont), 0, spannableStringBuilder.length(), 18);
                    if ((textInfo.textStyle & 1) == 1) {
                        spannableStringBuilder.setSpan(this.f908aa[1], 0, spannableStringBuilder.length(), 18);
                    }
                    if ((textInfo.textStyle & 2) == 2) {
                        spannableStringBuilder.setSpan(this.f908aa[2], 0, spannableStringBuilder.length(), 18);
                    }
                    if ((textInfo.textStyle & 4) == 4) {
                        spannableStringBuilder.setSpan(this.f908aa[3], 0, spannableStringBuilder.length(), 18);
                    }
                    if ((textInfo.textStyle & 8) == 8) {
                        spannableStringBuilder.setSpan(this.f908aa[4], 0, spannableStringBuilder.length(), 18);
                    }
                    this.f991l.stage.modifyTextSprite((TextSprite) next, pointFMapToScene, iWidth, iHeight, alignment, spannableStringBuilder, true, i);
                    this.f918ak.m1180a((AbstractModeContext) this.f991l, false);
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    private boolean m885a(int i, int i2, ImageInfo imageInfo, boolean z) {
        LinkedList<AbstractSprite> sprites;
        if (imageInfo != null) {
            if (imageInfo.getLayerID() == 1) {
                sprites = this.f991l.stage.getSprites(3);
            } else {
                sprites = this.f991l.stage.getSprites(0);
            }
            Iterator<AbstractSprite> it = sprites.iterator();
            while (it.hasNext()) {
                AbstractSprite next = it.next();
                if ((next instanceof C0989ab) && ((C0989ab) next).multiUserID == i && ((C0989ab) next).multiObjectID == i2) {
                    if (imageInfo.rectf == null) {
                        imageInfo.rectf = next.getBounds();
                    } else if (!this.f913af.contains(imageInfo.rectf) || imageInfo.rectf.left >= imageInfo.rectf.right || imageInfo.rectf.top >= imageInfo.rectf.bottom) {
                        return false;
                    }
                    this.f991l.stage.modifyImageSprite((C0989ab) next, imageInfo, i, z);
                    this.f919al.m1091a(this.f991l, next);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean changeObject(ObjectInfo objectInfo) {
        boolean zM893a = false;
        if (objectInfo != null) {
            if (!(this.f919al.f1197a instanceof C0989ab)) {
                this.f918ak.onFinishJob(this.f991l);
            }
            if (objectInfo instanceof ImageInfo) {
                zM893a = m892a((ImageInfo) objectInfo, false);
            } else if (objectInfo instanceof TextInfo) {
                zM893a = m893a((TextInfo) objectInfo);
            }
            if (this.f991l.historyChangeListener != null) {
                this.f991l.historyChangeListener.onHistoryChanged(this.f991l.stage.isUndoable(), this.f991l.stage.isRedoable());
            }
        }
        return zM893a;
    }

    protected boolean changeObject(ObjectInfo info, boolean updateBitmapResource) {
        if (!updateBitmapResource) {
            return changeObject(info);
        }
        if (info == null) {
            return false;
        }
        if (!(this.f919al.f1197a instanceof C0989ab)) {
            this.f918ak.onFinishJob(this.f991l);
        }
        if (!(info instanceof ImageInfo)) {
            return false;
        }
        boolean zM892a = m892a((ImageInfo) info, updateBitmapResource);
        if (this.f991l.historyChangeListener != null) {
            this.f991l.historyChangeListener.onHistoryChanged(this.f991l.stage.isUndoable(), this.f991l.stage.isRedoable());
            return zM892a;
        }
        return zM892a;
    }

    public boolean changeObject(int userID, int objectID, ObjectInfo objectInfo) {
        boolean zM886a = false;
        if (objectInfo != null) {
            this.f918ak.onFinishJob(this.f991l);
            if (objectInfo instanceof ImageInfo) {
                zM886a = m885a(userID, objectID, (ImageInfo) objectInfo, false);
            } else if (objectInfo instanceof TextInfo) {
                zM886a = m886a(userID, objectID, (TextInfo) objectInfo);
            }
            if (userID == getUserID() && this.f991l.historyChangeListener != null) {
                this.f991l.historyChangeListener.onHistoryChanged(this.f991l.stage.isUndoable(), this.f991l.stage.isRedoable());
            }
        }
        return zM886a;
    }

    protected boolean changeObject(int userID, int objectID, ObjectInfo objectInfo, boolean updateBitmapResource) {
        if (!updateBitmapResource) {
            return changeObject(userID, objectID, objectInfo);
        }
        if (objectInfo == null) {
            return false;
        }
        this.f918ak.onFinishJob(this.f991l);
        if (!(objectInfo instanceof ImageInfo)) {
            return false;
        }
        boolean zM885a = m885a(userID, objectID, (ImageInfo) objectInfo, updateBitmapResource);
        if (userID == getUserID() && this.f991l.historyChangeListener != null) {
            this.f991l.historyChangeListener.onHistoryChanged(this.f991l.stage.isUndoable(), this.f991l.stage.isRedoable());
            return zM885a;
        }
        return zM885a;
    }

    public void setPanningMode(boolean panningMode) {
        this.f975bt = panningMode;
    }

    public boolean getPanningMode() {
        return this.f975bt;
    }

    public boolean isDrawing() {
        if (this.f991l == null || this.f991l.modes == null) {
            return false;
        }
        return (this.f991l.getMode() == 1 || this.f991l.getMode() == 2) && ((PenMode) this.f991l.modes.get(Integer.valueOf(getUserID()))).mStroke != null;
    }

    public boolean isDrawing(int userID) {
        if (this.f991l == null || this.f991l.modes == null) {
            return false;
        }
        return (this.f991l.getMode(userID) == 1 || this.f991l.getMode(userID) == 2) && ((PenMode) this.f991l.modes.get(Integer.valueOf(userID))).mStroke != null;
    }

    protected boolean isAnyoneDrawing() {
        if (this.f991l == null || this.f991l.modes == null) {
            return false;
        }
        for (ModeState modeState : this.f991l.modes.values()) {
            if ((modeState instanceof PenMode) || (modeState instanceof C1059o)) {
                if (((PenMode) modeState).mStroke != null) {
                    return true;
                }
            }
        }
        return false;
    }

    protected boolean isEditing() {
        return this.f991l != null && this.f991l.modes != null && this.f991l.getMode() == 4 && isShowTextBox();
    }

    public void cancelDrawing() {
        if (this.f991l != null && this.f991l.modes != null && isDrawing()) {
            ((PenMode) this.f991l.modes.get(Integer.valueOf(getUserID()))).setIsMethodCancelEvent(true);
            MotionEvent motionEventObtain = MotionEvent.obtain(System.currentTimeMillis(), System.currentTimeMillis(), 3, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, 0);
            onTouchEvent(motionEventObtain);
            motionEventObtain.recycle();
        }
    }

    public void cancelDrawing(int userID) {
        if (this.f991l != null && this.f991l.modes != null && isDrawing(userID)) {
            ((PenMode) this.f991l.modes.get(Integer.valueOf(userID))).setIsMethodCancelEvent(true);
            MotionEvent motionEventObtain = MotionEvent.obtain(System.currentTimeMillis(), System.currentTimeMillis(), 3, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, 0);
            this.f991l.onTouchEvent(motionEventObtain, userID, 0);
            motionEventObtain.recycle();
        }
    }

    protected void cancelAllDrawing() {
        if (this.f991l != null && this.f991l.modes != null) {
            for (Map.Entry<Integer, ModeState> entry : this.f991l.modes.entrySet()) {
                int iIntValue = entry.getKey().intValue();
                ModeState value = entry.getValue();
                if ((value instanceof PenMode) || (value instanceof C1059o)) {
                    if (((PenMode) value).mStroke != null) {
                        ((PenMode) value).setIsMethodCancelEvent(true);
                        MotionEvent motionEventObtain = MotionEvent.obtain(System.currentTimeMillis(), System.currentTimeMillis(), 3, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, 0);
                        this.f991l.onTouchEvent(motionEventObtain, iIntValue, 0);
                        motionEventObtain.recycle();
                    }
                }
            }
        }
    }

    protected void cancelEditing() {
        if (this.f991l != null && this.f991l.modes != null && isEditing()) {
            if (this.f991l.getTextMode(getUserID()).f1341a != null) {
                this.f991l.getTextMode(getUserID()).f1341a.setVisible(true);
                this.f991l.getTextMode(getUserID()).f1341a.deselect();
                this.f991l.getTextMode(getUserID()).f1341a = null;
            }
            this.f916ai.setText("");
            showTextBox(false);
            restoreTextSettingInfo();
            this.f991l.getTextMode(getUserID()).m1180a((AbstractModeContext) this.f991l, false);
        }
    }

    public void setMultiTouchCancel(boolean cancel) {
        this.f976bu = cancel;
    }

    @Override // android.view.View
    public void invalidate(Rect dirty) {
        if (this.f991l != null && this.f991l.isBUpdateScreen()) {
            super.invalidate(dirty);
        }
    }

    @Override // android.view.View
    public void invalidate(int l, int t, int r, int b) {
        if (this.f991l != null && this.f991l.isBUpdateScreen()) {
            super.invalidate(l, t, r, b);
        }
    }

    @Override // android.view.View
    public void invalidate() {
        if (this.f991l != null && this.f991l.isBUpdateScreen()) {
            super.invalidate();
        }
    }

    protected void setDrawingUpdatable(boolean isUpdate) {
        if (this.f991l != null) {
            this.f991l.setBUpdateScreen(isUpdate);
        }
    }

    /* renamed from: a */
    private void m882a(StrokeInfo strokeInfo) {
        if (this.f991l != null && strokeInfo != null) {
            StrokeSprite.Type typeM1020a = PenSettingInfo.m1020a(strokeInfo.type);
            StrokeSprite.ThicknessParameter thicknessParameterM689a = AbstractSettingView.m689a(strokeInfo.type);
            this.f991l.setting.setStrokeType(typeM1020a);
            this.f991l.setting.setStrokeWidth(strokeInfo.width);
            this.f991l.setting.setStrokeColor((strokeInfo.alpha << 24) | (16777215 & strokeInfo.color));
            this.f991l.setting.setStrokeParameter(thicknessParameterM689a);
        }
    }

    public float getScale() {
        return this.f882aA != null ? this.f882aA.m1238e() : VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
    }

    public void setZoomEnable(boolean set) {
        this.f959bd = set;
        if (this.f882aA != null) {
            this.f882aA.m1233c(set);
        }
    }

    public boolean getZoomEnable() {
        return this.f959bd;
    }

    public void setPanEnable(boolean set) {
        this.f977bv = set;
        if (this.f882aA != null) {
            this.f882aA.m1236d(set);
        }
    }

    public boolean getPanEnable() {
        return this.f977bv;
    }

    public void drawStrokePoint(int what, float x, float y, float pressure, int meta_state, long down_time, long event_time) {
        int i;
        if (this.f991l.stage != null) {
            PointF pointFMapFromScene = this.f991l.stage.mapFromScene(new PointF(x, y));
            if (meta_state == 0) {
                i = 0;
            } else if (meta_state == 1) {
                i = this.f924aq;
            } else if (meta_state == 2) {
                i = this.f923ap;
            } else {
                i = 0;
            }
            if (this.f991l.modes.containsKey(Integer.valueOf(getUserID())) && (this.f991l.modes.get(Integer.valueOf(getUserID())) instanceof PenMode)) {
                MotionEvent motionEventObtain = MotionEvent.obtain(down_time, event_time, what, pointFMapFromScene.x, pointFMapFromScene.y, pressure, 1.0f, i, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, 0, 0);
                m910b(motionEventObtain);
                motionEventObtain.recycle();
            }
        }
    }

    public void drawMultiUserStrokePoint(int userID, int strokeID, int what, float x, float y, float pressure, int meta_state, long down_time, long event_time) {
        int i;
        if (this.f991l.stage != null) {
            PointF pointFMapFromScene = this.f991l.stage.mapFromScene(new PointF(x, y));
            if (meta_state == 0) {
                i = 0;
            } else if (meta_state == 1) {
                i = this.f924aq;
            } else if (meta_state == 2) {
                i = this.f923ap;
            } else {
                i = 0;
            }
            if (what == 0) {
                if (!this.f991l.modes.containsKey(Integer.valueOf(userID))) {
                    this.f991l.createNewMode(userID);
                    this.f991l.stage.m814a(userID);
                }
                PenSettingInfo penSettingInfo = getPenSettingInfo(userID);
                if (penSettingInfo.getPenType() == 4 || i == this.f923ap) {
                    changeModeTo(userID, 2);
                    penSettingInfo.setPenType(4);
                    setPenSettingInfo(userID, penSettingInfo);
                } else {
                    changeModeTo(userID, 1);
                    if (penSettingInfo.getPenType() == 3 && userID != getUserID()) {
                        ((PenMode) this.f991l.modes.get(Integer.valueOf(userID))).setFluidLayerId(this.f991l.stage.selectFluidLayer(this.f991l.setting.getScreenWidth(), this.f991l.setting.getScreenHeight()));
                    }
                }
            }
            MotionEvent motionEventObtain = MotionEvent.obtain(down_time, event_time, what, pointFMapFromScene.x, pointFMapFromScene.y, pressure, 1.0f, i, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, 0, 0);
            m890a(motionEventObtain, userID, strokeID);
            if (this.f991l.getMode(userID) == 1 && getPenSettingInfo(userID).getPenType() == 3 && what == 2 && ((Build.VERSION.SDK_INT < 14 || motionEventObtain.getToolType(0) != 4) && ((PenMode) this.f991l.modes.get(Integer.valueOf(userID))).getStrokeVertorSize() > this.f991l.setting.m1118i())) {
                MotionEvent motionEventObtain2 = MotionEvent.obtain(motionEventObtain.getDownTime(), motionEventObtain.getEventTime(), 1, motionEventObtain.getX(), motionEventObtain.getY(), pressure, 1.0f, i, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, 0, 0);
                m890a(motionEventObtain2, userID, strokeID);
                motionEventObtain2.recycle();
                MotionEvent motionEventObtain3 = MotionEvent.obtain(motionEventObtain.getDownTime(), motionEventObtain.getEventTime(), 0, motionEventObtain.getX(), motionEventObtain.getY(), pressure, 1.0f, i, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, 0, 0);
                m890a(motionEventObtain3, userID, strokeID);
                motionEventObtain3.recycle();
            }
            motionEventObtain.recycle();
            if ((what == 1 || what == 3) && getPenSettingInfo(userID).getPenType() == 3 && userID != getUserID()) {
                this.f991l.stage.m816a(((PenMode) this.f991l.modes.get(Integer.valueOf(userID))).getFluidLayerId(), 1, 1);
            }
        }
    }

    public void setOnSelectedTextViewTouchListener(View.OnTouchListener textTouchlistener) {
        this.f978bw = textTouchlistener;
    }

    /* renamed from: com.samsung.sdraw.CanvasView$c */
    static class C0971c {

        /* renamed from: a */
        public View.OnHoverListener f1037a;

        /* renamed from: b */
        public View.OnHoverListener f1038b = new View.OnHoverListener() { // from class: com.samsung.sdraw.CanvasView.c.1
            @Override // android.view.View.OnHoverListener
            public boolean onHover(View v, MotionEvent event) {
                if (C0971c.this.f1037a != null) {
                    return C0971c.this.f1037a.onHover(v, event);
                }
                return false;
            }
        };

        C0971c() {
        }

        /* renamed from: a */
        public void m992a(View.OnHoverListener onHoverListener) {
            this.f1037a = onHoverListener;
        }
    }

    public void setOnSelectedTextViewHoverListener(View.OnHoverListener textHoverlistener) {
        String str = Build.VERSION.RELEASE;
        if (this.f902aU == null && str.startsWith(SimpleUserInfo.STATE_MOVETO_CONFERENCE)) {
            this.f902aU = new C0971c();
        }
        if (this.f902aU != null) {
            this.f902aU.m992a(textHoverlistener);
        } else {
            this.f979bx = textHoverlistener;
        }
    }

    public void setSelectLayer(int layerID) {
        if (layerID == 0 || layerID == 1) {
            this.f991l.stage.setSelectLayer(layerID);
            if (this.f991l.historyChangeListener != null) {
                this.f991l.historyChangeListener.onHistoryChanged(this.f991l.stage.isUndoable(), this.f991l.stage.isRedoable());
            }
        }
    }

    public int getSelectLayer() {
        return this.f991l.stage.getSelectedLayerID() == 3 ? 1 : 0;
    }

    public int getMaxMutiUserDrawingCount() {
        if (this.f991l == null || this.f991l.setting == null) {
            return 5;
        }
        return this.f991l.setting.getMaxMultiUserDrawingCount();
    }

    public void setUserID(int userID) {
        if (this.f991l != null) {
            this.f991l.setting.setMyOpenID(userID);
            this.f991l.createNewMode(userID);
            this.f918ak = this.f991l.getTextMode(userID);
            this.f919al = this.f991l.getSelectMode(userID);
            this.f918ak.m1181a(this.f907aZ);
            this.f919al.m1092a(this.f956ba);
            this.f991l.stage.m814a(userID);
        }
    }

    public int getUserID() {
        return this.f991l.setting.getUserID();
    }

    public void setOutOfMemoryListener(OutOfMemoryListener listener) {
        this.f980by = listener;
    }

    public void setOnCancelListener(OnCancelListener listener) {
        this.f981bz = listener;
    }

    public boolean getDrawable() {
        return this.f887aF;
    }

    public void setPenMarkerClickable(boolean clickable) {
    }

    public void setDrawingFront(boolean drawingFront) {
        if (this.f991l != null && this.f991l.setting != null) {
            this.f991l.stage.setDrawingFront(drawingFront);
        }
    }

    public void setOnLongPressListener(OnLongPressListener listener) {
        this.f935bA = listener;
    }

    public void setMultiStroke(boolean isMultiStroke) {
        this.f937bC = isMultiStroke;
    }

    public void setMultiStrokeID(int nID) {
        this.f991l.setting.setMultiObjectId(nID);
    }

    public void deleteAll(boolean bFreeMemory) {
        if (this.f991l != null) {
            if (isShowTextBox()) {
                this.f991l.getTextMode(getUserID()).f1341a = null;
                this.f916ai.setText("");
                showTextBox(false);
                restoreTextSettingInfo();
            }
            if (this.f968bm != null) {
                Iterator<AbstractSprite> it = this.f991l.stage.getSprites().iterator();
                while (it.hasNext()) {
                    AbstractSprite next = it.next();
                    if (next.isSelected()) {
                        next.deselect();
                        if (next instanceof TextSprite) {
                            this.f968bm.onObjectSelected(((TextSprite) next).m1203j(), false);
                        } else if (next instanceof C0989ab) {
                            this.f968bm.onObjectSelected(((C0989ab) next).m1262c(), false);
                        } else if (next instanceof StrokeSprite) {
                            this.f968bm.onObjectSelected(((StrokeSprite) next).m1174s(), false);
                        }
                    }
                }
            }
            if (this.f968bm != null) {
                this.f968bm.onObjectDeletedAll(bFreeMemory, getSelectLayer());
            }
            this.f991l.clear();
        }
    }

    public void deleteAll(boolean bFreeMemory, int layerID) {
        if (this.f937bC) {
            if (isShowTextBox()) {
                if (this.f991l != null) {
                    this.f991l.getTextMode(getUserID()).f1341a = null;
                }
                this.f916ai.setText("");
                showTextBox(false);
                restoreTextSettingInfo();
            }
            if (layerID == 0) {
                int selectLayer = getSelectLayer();
                cancelDrawing();
                this.f991l.stage.setSelectLayer(0);
                if (this.f968bm != null) {
                    this.f968bm.onObjectDeletedAll(bFreeMemory, 0);
                }
                if (this.f991l != null) {
                    this.f991l.clear();
                }
                setSelectLayer(selectLayer);
                return;
            }
            int selectLayer2 = getSelectLayer();
            cancelDrawing();
            this.f991l.stage.setSelectLayer(1);
            if (this.f968bm != null) {
                this.f968bm.onObjectDeletedAll(bFreeMemory, 1);
            }
            if (this.f991l != null) {
                this.f991l.clear();
            }
            setSelectLayer(selectLayer2);
            return;
        }
        if (isShowTextBox()) {
            if (this.f991l != null) {
                this.f991l.getTextMode(getUserID()).f1341a = null;
            }
            this.f916ai.setText("");
            showTextBox(false);
            restoreTextSettingInfo();
        }
        int selectLayer3 = getSelectLayer();
        cancelDrawing();
        this.f991l.stage.setSelectLayer(layerID);
        if (this.f968bm != null) {
            this.f968bm.onObjectDeletedAll(bFreeMemory, layerID);
        }
        if (this.f991l != null) {
            this.f991l.clear();
        }
        setSelectLayer(selectLayer3);
    }

    public void setTouchEventDispatchMode(boolean isTouchPass) {
        this.f939bE = isTouchPass;
    }

    public boolean getTouchEventDispatchMode() {
        return this.f939bE;
    }

    protected boolean getDropperMode() {
        return this.f973br;
    }

    protected boolean getFillColorMode() {
        return this.f990k;
    }

    protected boolean drawFillColorObject(FillColorInfo fillColorInfo) {
        if (this.f991l == null) {
            return false;
        }
        Rect canvasRect = this.f991l.setting.getCanvasRect();
        if (fillColorInfo.f1045x < 0 || fillColorInfo.f1045x > canvasRect.width() || fillColorInfo.f1046y < 0 || fillColorInfo.f1046y > canvasRect.height()) {
            return false;
        }
        int i = (-16777216) | (16777215 & fillColorInfo.color);
        PointF pointF = new PointF(fillColorInfo.f1045x, fillColorInfo.f1046y);
        int[] iArr = new int[canvasRect.width() * canvasRect.height()];
        if (getSelectLayer() == 0) {
            this.f991l.stage.m825b(0).getPixels(iArr, 0, canvasRect.width(), 0, 0, canvasRect.width(), canvasRect.height());
        } else {
            this.f991l.stage.m825b(3).getPixels(iArr, 0, canvasRect.width(), 0, 0, canvasRect.width(), canvasRect.height());
        }
        if (m864a((int) pointF.x, (int) pointF.y) == i) {
            return true;
        }
        int i2 = fillColorInfo.getLayerID() == 0 ? 0 : 3;
        C1063s c1063sMo1405a = this.f991l.factory.mo1405a(this.f991l, fillColorInfo.f1045x, fillColorInfo.f1046y, i, fillColorInfo.fillingBound, fillColorInfo.cachePath, i2);
        c1063sMo1405a.multiUserID = getUserID();
        if (i2 == 0) {
            c1063sMo1405a.multiObjectID = this.f991l.setting.getMultiObjectId();
        } else {
            c1063sMo1405a.multiObjectID = 0;
        }
        c1063sMo1405a.objectID = fillColorInfo.getID();
        this.f991l.stage.addSprite(c1063sMo1405a, true);
        this.f991l.stage.clearLayer(i2);
        this.f991l.stage.renderFixedSprites(i2);
        this.f991l.stage.renderSprites(i2);
        this.f991l.invalidate();
        return true;
    }

    protected boolean drawFillColorObject(int userID, int fillColorID, FillColorInfo fillColorInfo) {
        if (this.f991l == null) {
            return false;
        }
        Rect canvasRect = this.f991l.setting.getCanvasRect();
        if (fillColorInfo.f1045x < 0 || fillColorInfo.f1045x > canvasRect.width() || fillColorInfo.f1046y < 0 || fillColorInfo.f1046y > canvasRect.height()) {
            return false;
        }
        int i = (-16777216) | (16777215 & fillColorInfo.color);
        PointF pointF = new PointF(fillColorInfo.f1045x, fillColorInfo.f1046y);
        if (m864a((int) pointF.x, (int) pointF.y) == i) {
            return true;
        }
        int i2 = fillColorInfo.getLayerID() != 0 ? 3 : 0;
        C1063s c1063sMo1405a = this.f991l.factory.mo1405a(this.f991l, fillColorInfo.f1045x, fillColorInfo.f1046y, i, fillColorInfo.fillingBound, fillColorInfo.cachePath, i2);
        c1063sMo1405a.objectID = fillColorInfo.getID();
        c1063sMo1405a.multiUserID = userID;
        c1063sMo1405a.multiObjectID = fillColorID;
        this.f991l.stage.addSprite(c1063sMo1405a, true);
        this.f991l.stage.clearLayer(i2);
        this.f991l.stage.renderFixedSprites(i2);
        this.f991l.stage.renderSprites(i2);
        this.f991l.invalidate();
        return true;
    }

    public void setHistoricalOperationSupport(boolean bSupport) {
        if (this.f991l != null && this.f991l.setting != null) {
            this.f991l.setting.bHistoricalOperationSupport = bSupport;
            if (!bSupport) {
                if (this.f991l.stage != null) {
                    this.f991l.stage.m819a(getUserID(), true);
                }
                if (this.f991l.historyChangeListener != null) {
                    this.f991l.historyChangeListener.onHistoryChanged(false, false);
                }
            }
        }
    }

    public boolean isHistoricalOperationSupport() {
        if (this.f991l == null || this.f991l.setting == null) {
            return true;
        }
        return this.f991l.setting.bHistoricalOperationSupport;
    }

    public boolean getTextLongClickSelectOption() {
        if (this.f991l == null || this.f991l.setting == null) {
            return true;
        }
        return this.f991l.setting.getTextLongClickSelectOption();
    }

    public void setTextLongClickSelectOption(boolean bTextLongClickSelectable) {
        if (this.f991l != null && this.f991l.setting != null) {
            this.f991l.setting.setTextLongClickSelectOption(bTextLongClickSelectable);
        }
    }

    /* renamed from: a */
    void m973a(TextSettingInfo textSettingInfo, int i) {
        if (this.f993n != null) {
            switch (i) {
                case 0:
                    this.f993n.setTextType(textSettingInfo.getTextType());
                    break;
                case 1:
                    this.f993n.setTextColor(textSettingInfo.getTextColor());
                    break;
                case 2:
                    this.f993n.setTextSize(textSettingInfo.getTextSize());
                    break;
                case 3:
                    this.f993n.setTextFont(textSettingInfo.getTextFont());
                    break;
                case 4:
                    this.f993n.setTextAlignment(textSettingInfo.getTextAlignment());
                    break;
            }
        }
    }

    /* renamed from: a */
    void m971a(FillingSettingInfo fillingSettingInfo) {
        if (this.f994o != null) {
            this.f994o.setFillingColor(fillingSettingInfo.getFillingColor());
        }
    }

    protected void readyToFileLoad() {
        if (getMode() == 3) {
            changeModeTo(this.f1003x);
        }
        hideImm();
    }

    protected void setImageObjectMinimumEditableSize(int nMinSize) {
        if (this.f991l != null) {
            this.f991l.setting.setImageObjectMinimumEditableSize(nMinSize);
        }
    }

    protected int getImageObjectMinimumEditableSize() {
        if (this.f991l != null) {
            return this.f991l.setting.getImageObjectMinimumEditableSize();
        }
        return 0;
    }

    protected Bitmap createCanvasHoverPointerForStroke(PenSettingInfo info, int nWidth, int nHeight) {
        if (info == null || nWidth <= 0 || nHeight <= 0) {
            return null;
        }
        if (info.getPenType() != 4) {
            return m866a(info, nWidth, nHeight);
        }
        return m904b(info, nWidth, nHeight);
    }

    /* renamed from: a */
    private Bitmap m866a(PenSettingInfo penSettingInfo, int i, int i2) throws Throwable {
        if (penSettingInfo == null || i <= 0 || i2 <= 0) {
            return null;
        }
        String[] strArr = new String[5];
        strArr[0] = "/snote_popup_btn_03.png";
        strArr[1] = "/snote_popup_btn_04.png";
        strArr[2] = "/snote_popup_btn_02.png";
        strArr[4] = "/snote_popup_btn_04.png";
        Bitmap bitmapM867a = m867a(strArr[penSettingInfo.getPenType()]);
        if (bitmapM867a == null) {
            return null;
        }
        Canvas canvas = new Canvas(bitmapM867a);
        StrokeSprite strokeSpriteM912c = m912c(penSettingInfo, i, i2);
        strokeSpriteM912c.mo1139a(canvas, strokeSpriteM912c.getBounds());
        return bitmapM867a;
    }

    /* renamed from: b */
    private Bitmap m904b(PenSettingInfo penSettingInfo, int i, int i2) {
        Bitmap bitmapCreateBitmap;
        if (penSettingInfo == null || i <= 0 || i2 <= 0 || (bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888)) == null) {
            return null;
        }
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(-16777216);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(1.0f);
        canvas.drawCircle(i / 2.0f, i2 / 2.0f, penSettingInfo.getEraserWidth() / 2.0f, paint);
        paint.setColor(-1);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(i / 2.0f, i2 / 2.0f, (penSettingInfo.getEraserWidth() / 2.0f) - 1.0f, paint);
        return bitmapCreateBitmap;
    }

    /* renamed from: c */
    private StrokeSprite m912c(PenSettingInfo penSettingInfo, int i, int i2) {
        if (penSettingInfo == null || i <= 0 || i2 <= 0) {
            return null;
        }
        C1054j c1054j = new C1054j(this.f864H);
        Setting setting = new Setting(this.f864H);
        StrokeSprite strokeSpriteM1557a = c1054j.m1557a(PenSettingInfo.m1020a(penSettingInfo.getPenType()), StrokeSprite.ThicknessParameter.Constant, StrokeSprite.InputMethod.Tablet, penSettingInfo.getPenWidth(), ((penSettingInfo.getPenAlpha() & 255) << 24) | (penSettingInfo.getPenColor() & 16777215));
        strokeSpriteM1557a.setVisible(true);
        strokeSpriteM1557a.m1144a(setting.m1108b());
        strokeSpriteM1557a.m1149b(setting.m1113d());
        PointF[] pointFArrM894a = m894a(penSettingInfo.getPenType(), i, i2);
        if (pointFArrM894a == null) {
            return null;
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= pointFArrM894a.length) {
                break;
            }
            strokeSpriteM1557a.m1145a(pointFArrM894a[i4].x, pointFArrM894a[i4].y, 255.0f, 1L);
            strokeSpriteM1557a.m1147b(true);
            i3 = i4 + 1;
        }
        if (penSettingInfo.getPenType() != 5 && penSettingInfo.getPenType() != 1) {
            strokeSpriteM1557a.m1164i();
        }
        strokeSpriteM1557a.m1157d(true);
        return strokeSpriteM1557a;
    }

    /* renamed from: a */
    private PointF[] m894a(int i, int i2, int i3) {
        if (i2 <= 0 || i3 <= 0) {
            return null;
        }
        float f = (i3 / 2.0f) + 10.0f;
        float f2 = (i2 / 2.0f) + 5.0f;
        PointF[] pointFArr = {new PointF((f2 / 2.0f) + 10.0f, f), new PointF((2.0f * f2) / 3.0f, f - 1.0f), new PointF(f2, f - 2.0f), new PointF((4.0f * f2) / 3.0f, f - 1.0f), new PointF((i2 - (f2 / 2.0f)) - 10.0f, f)};
        if (i == 3) {
            pointFArr[0].offset(-14.0f, -3.0f);
            pointFArr[1].offset(-7.0f, -3.0f);
            pointFArr[2].offset(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, -3.0f);
            pointFArr[3].offset(3.0f, -3.0f);
            pointFArr[4].offset(7.0f, -3.0f);
            return pointFArr;
        }
        return pointFArr;
    }

    /* renamed from: a */
    private Bitmap m867a(String str) {
        Bitmap bitmapD;
        if (str == null || str.isEmpty() || (bitmapD = new C0997aj(this.f864H, this.f984e).m1532d(str)) == null) {
            return null;
        }
        return bitmapD.copy(Bitmap.Config.ARGB_8888, true);
    }

    protected PenSettingInfo changeNextPenSetting(boolean includeDefinedPenSetting, boolean includeCustomPenSetting, boolean includeEraserSetting) {
        PenSettingInfo penSettingInfoM917d;
        int penType = this.f881a.getPenType();
        if (penType != 4 && !this.f946bL) {
            this.f943bI = penType;
            this.f946bL = false;
        }
        if (!includeDefinedPenSetting && !includeCustomPenSetting && !includeEraserSetting) {
            return null;
        }
        boolean z = this.f881a.getPenType() == 4;
        PresetDataManager presetDataManagerE = this.f1001v.m784e();
        if (includeCustomPenSetting) {
            if (presetDataManagerE.m1047d() > 0 && !z && !presetDataManagerE.m1041a(this.f881a, true)) {
                presetDataManagerE.m1048e();
                penSettingInfoM917d = m870a(presetDataManagerE);
            } else if (presetDataManagerE.m1049f()) {
                penSettingInfoM917d = m870a(presetDataManagerE);
            } else if (includeEraserSetting && !z) {
                penSettingInfoM917d = m917d(this.f881a.getEraserWidth());
            } else if (includeDefinedPenSetting) {
                if (z && this.f945bK == null) {
                    this.f881a.setPenType(0);
                    m977b(this.f881a);
                }
                penSettingInfoM917d = m869a(this.f945bK);
                presetDataManagerE.m1048e();
            } else {
                presetDataManagerE.m1048e();
                penSettingInfoM917d = m870a(presetDataManagerE);
            }
        } else if (z && includeDefinedPenSetting) {
            penSettingInfoM917d = m869a(this.f944bJ);
        } else {
            penSettingInfoM917d = (z || !includeEraserSetting) ? null : m917d(this.f881a.getEraserWidth());
        }
        return penSettingInfoM917d;
    }

    /* renamed from: a */
    void m972a(PenSettingInfo penSettingInfo) {
        int penType = this.f881a.getPenType();
        this.f881a.setPenType(penSettingInfo.getPenType());
        if (this.f1001v.getMaintainPenColor()) {
            this.f881a.setPenColor(penSettingInfo.getPenColor(penType));
        }
        if (!this.f1001v.m784e().m1041a(penSettingInfo, false)) {
            this.f945bK.setPenType(penSettingInfo.getPenType());
            this.f945bK.setPenSize(penSettingInfo.getPenWidth());
            this.f945bK.setColor(penSettingInfo.getPenColor());
            this.f945bK.setAlpha(penSettingInfo.getPenAlpha());
        }
    }

    /* renamed from: b */
    void m977b(PenSettingInfo penSettingInfo) {
        if (this.f944bJ == null) {
            this.f944bJ = new PenData();
        }
        if (this.f945bK == null) {
            this.f945bK = new PenData();
        }
        if (!this.f1001v.m784e().m1041a(penSettingInfo, false) && penSettingInfo.getPenType() != 4) {
            this.f945bK.setPenType(penSettingInfo.getPenType());
            this.f945bK.setPenSize(penSettingInfo.getPenWidth());
            this.f945bK.setColor(penSettingInfo.getPenColor());
            this.f945bK.setAlpha(penSettingInfo.getPenAlpha());
        }
        int penType = penSettingInfo.getPenType();
        if (penType != 4) {
            this.f944bJ.setPenType(penType);
            this.f944bJ.setPenSize(penSettingInfo.getPenWidth(penType));
            this.f944bJ.setColor(penSettingInfo.getPenColor(penType));
            this.f944bJ.setAlpha(penSettingInfo.getPenAlpha(penType));
        }
        for (int i = 0; i < 6; i++) {
            this.f881a.setPenWidth(i, penSettingInfo.getPenWidth(i));
            this.f881a.setPenColor(i, penSettingInfo.getPenColor(i));
            this.f881a.setPenAlpha(i, penSettingInfo.getPenAlpha(i));
        }
        if (penType != 4) {
            this.f943bI = this.f881a.getPenType();
            this.f986g.put(Integer.valueOf(getUserID()), Integer.valueOf(this.f881a.getPenType()));
            this.f881a.setPenType(penType);
        }
    }

    /* renamed from: a */
    private PenSettingInfo m870a(PresetDataManager presetDataManager) {
        C1005ar c1005arM1050g;
        if (presetDataManager == null || (c1005arM1050g = presetDataManager.m1050g()) == null) {
            return null;
        }
        PenSettingInfo penSettingInfo = new PenSettingInfo();
        penSettingInfo.setPenType(c1005arM1050g.m1390f());
        penSettingInfo.setPenColor(c1005arM1050g.m1391g());
        penSettingInfo.setPenAlpha(c1005arM1050g.m1388e());
        penSettingInfo.setPenWidth(c1005arM1050g.m1386d());
        return penSettingInfo;
    }

    /* renamed from: a */
    private PenSettingInfo m869a(PenData penData) {
        PenSettingInfo penSettingInfo = new PenSettingInfo();
        penSettingInfo.setPenType(penData.getPenType());
        penSettingInfo.setPenColor(penData.getColor());
        penSettingInfo.setPenAlpha(penData.getAlpha());
        penSettingInfo.setPenWidth(penData.getPenSize());
        return penSettingInfo;
    }

    /* renamed from: d */
    private PenSettingInfo m917d(int i) {
        PenSettingInfo penSettingInfo = new PenSettingInfo();
        penSettingInfo.setPenType(4);
        penSettingInfo.setEraserWidth(i);
        return penSettingInfo;
    }

    protected boolean getObjectSupportPenOnly() {
        if (this.f991l == null || this.f991l.setting == null) {
            return false;
        }
        return this.f991l.setting.m1121l();
    }

    protected void setObjectSupportPenOnly(boolean bObjectSupportPenOnly) {
        if (this.f991l != null && this.f991l.setting.m1121l() != bObjectSupportPenOnly) {
            this.f991l.setting.m1100a(bObjectSupportPenOnly);
            if (this.f992m != null) {
                try {
                    this.f991l.changeCanvasSize(this.f992m);
                    if (bObjectSupportPenOnly && this.f991l.stage != null) {
                        this.f991l.stage.cleanUpObjectLayer();
                        if (this.f991l.historyChangeListener != null) {
                            this.f991l.historyChangeListener.onHistoryChanged(this.f991l.isUndoable(), this.f991l.isRedoable());
                        }
                    }
                    this.f991l.invalidate();
                } catch (OutOfMemoryError e) {
                    if (this.f980by != null) {
                        this.f980by.onOutOfMemory();
                        return;
                    }
                    return;
                }
            }
            AbstractSettingView.m715b(bObjectSupportPenOnly);
        }
    }

    public void setOnModeChangedListener(OnModeChangedListener listener) {
        this.f947bM = listener;
    }

    protected LinkedList<ObjectInfo> getSelectedObjectInfos() {
        if (this.f991l == null || this.f991l.stage == null) {
            return null;
        }
        LinkedList<ObjectInfo> linkedList = new LinkedList<>();
        ArrayList<AbstractSprite> selectedSprites = this.f991l.stage.getSelectedSprites();
        InterfaceC1035bu edit = this.f991l.getEdit();
        if (edit.isShowTextBox()) {
            if (selectedSprites.size() != 0) {
                for (int i = 0; i < selectedSprites.size(); i++) {
                    if (selectedSprites.get(i) instanceof TextSprite) {
                        TextInfo textInfo = new TextInfo(this.f993n.getTextColor(), this.f993n.getTextSize(), edit.getTextBoxText().toString(), new RectF(edit.getTextBoxPosition().x, edit.getTextBoxPosition().y, edit.getTextBoxPosition().x + edit.getTextBoxWidth(), edit.getTextBoxPosition().y + edit.getTextBoxHeight()), this.f993n.getTextType(), this.f993n.getTextAlignment(), this.f993n.getTextFont(), getSelectLayer());
                        textInfo.setID(((TextSprite) selectedSprites.get(i)).m1203j().getID());
                        textInfo.setMultiObjectID(((TextSprite) selectedSprites.get(i)).m1203j().getMultiObjectID());
                        textInfo.setMultiUserID(((TextSprite) selectedSprites.get(i)).m1203j().getMultiUserID());
                        linkedList.add(textInfo);
                    }
                }
            } else if (edit.getTextBoxText().length() != 0) {
                TextInfo textInfo2 = new TextInfo(this.f993n.getTextColor(), this.f993n.getTextSize(), edit.getTextBoxText().toString(), new RectF(edit.getTextBoxPosition().x, edit.getTextBoxPosition().y, edit.getTextBoxPosition().x + edit.getTextBoxWidth(), edit.getTextBoxPosition().y + edit.getTextBoxHeight()), this.f993n.getTextType(), this.f993n.getTextAlignment(), this.f993n.getTextFont(), getSelectLayer());
                textInfo2.setID(getObjectID());
                textInfo2.setMultiUserID(getUserID());
                textInfo2.setMultiObjectID(this.f991l.setting.getMultiObjectId());
                linkedList.add(textInfo2);
            }
        }
        for (int i2 = 0; i2 < selectedSprites.size(); i2++) {
            if (selectedSprites.get(i2).isVisible() && (selectedSprites.get(i2) instanceof C0989ab)) {
                linkedList.add(((C0989ab) selectedSprites.get(i2)).m1262c());
            }
        }
        return linkedList;
    }

    @Override // com.samsung.sdraw.InterfaceC1035bu
    public void restoreTextSettingInfo() {
        if (!isShowTextBox() && this.f997r && this.f996q != null) {
            setTextSettingViewInfo(this.f996q);
            this.f997r = false;
        }
    }

    protected void setUseLongPressListener(boolean bUseLongPressListener) {
        this.f948bN = bUseLongPressListener;
    }

    protected int[] getSettingColorValues() {
        C1051g c1051g = new C1051g(getContext());
        int[] iArrM1554a = c1051g.m1554a();
        int iM1555b = c1051g.m1555b();
        int i = iM1555b - 1;
        while (true) {
            if (i > 0) {
                if (iArrM1554a[i] == c1051g.m1556c()) {
                    break;
                }
                i--;
            } else {
                i = iM1555b;
                break;
            }
        }
        return Arrays.copyOfRange(iArrM1554a, 0, i);
    }

    protected void setTextBoxDefaultSize(int nTextBoxDefaultWidth, int nTextBoxDefaultHeight) {
        this.f949bO = nTextBoxDefaultWidth;
        this.f950bP = nTextBoxDefaultHeight;
        if (!this.f933az) {
            m949k();
            this.f933az = true;
        } else {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f916ai.getLayoutParams();
            layoutParams.width = this.f949bO;
            layoutParams.height = this.f950bP;
            this.f916ai.setLayoutParams(layoutParams);
        }
    }

    protected void setRemoveLongPressStroke(boolean isRemove) {
        this.f951bQ = isRemove;
    }

    protected boolean getRemoveLongPressStroke() {
        return this.f951bQ;
    }

    protected void setSerializeEnable(boolean enable) {
        this.f952bR = enable;
    }

    protected HistoryData getHistoryData() {
        if (this.f991l == null) {
            return null;
        }
        int selectLayer = getSelectLayer();
        this.f991l.stage.setSelectLayer(0);
        HistoryData historyData = new HistoryData();
        historyData.m1003a(this.f991l.stage.getSprites(0), this.f991l.setting.getCanvasRect(), this.f991l.stage.f845i);
        for (Integer num : this.f991l.modes.keySet()) {
            historyData.m1002a(num.intValue(), this.f991l.stage.getUndoList(num.intValue()), this.f991l.stage.getRedoList(num.intValue()));
        }
        this.f991l.stage.setSelectLayer(selectLayer);
        return historyData;
    }

    protected void setHistoryData(HistoryData historyData) {
        if (historyData != null && this.f991l != null) {
            int selectLayer = getSelectLayer();
            this.f991l.stage.setSelectLayer(0);
            m884a(historyData.m1001a());
            LinkedList<Integer> linkedListM1004b = historyData.m1004b();
            HashMap<Integer, LinkedList<C1069y>> mapM1005c = historyData.m1005c();
            HashMap<Integer, LinkedList<C1069y>> mapM1006d = historyData.m1006d();
            LinkedList<AbstractSprite> sprites = this.f991l.stage.getSprites(0);
            Iterator<Integer> it = linkedListM1004b.iterator();
            while (it.hasNext()) {
                int iIntValue = it.next().intValue();
                this.f991l.createNewMode(iIntValue);
                this.f991l.stage.m814a(iIntValue);
                LinkedList<SpriteCommand> undoList = this.f991l.stage.getUndoList(iIntValue);
                undoList.clear();
                LinkedList<C1069y> linkedList = mapM1005c.get(Integer.valueOf(iIntValue));
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= linkedList.size()) {
                        break;
                    }
                    C1069y c1069y = linkedList.get(i2);
                    Iterator<AbstractSprite> it2 = sprites.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        AbstractSprite next = it2.next();
                        if (next.multiUserID == iIntValue && next.objectID == c1069y.f1811b) {
                            m883a(c1069y, undoList, next);
                            break;
                        }
                    }
                    i = i2 + 1;
                }
                LinkedList<C1069y> linkedList2 = mapM1006d.get(Integer.valueOf(iIntValue));
                LinkedList<SpriteCommand> redoList = this.f991l.stage.getRedoList(iIntValue);
                redoList.clear();
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 < linkedList2.size()) {
                        C1069y c1069y2 = linkedList2.get(i4);
                        Iterator<AbstractSprite> it3 = sprites.iterator();
                        while (true) {
                            if (!it3.hasNext()) {
                                break;
                            }
                            AbstractSprite next2 = it3.next();
                            if (next2.multiUserID == iIntValue && next2.objectID == c1069y2.f1811b) {
                                m883a(c1069y2, redoList, next2);
                                break;
                            }
                        }
                        i3 = i4 + 1;
                    }
                }
            }
            if (this.f991l.historyChangeListener != null) {
                this.f991l.historyChangeListener.onHistoryChanged(this.f991l.isUndoable(), this.f991l.isRedoable());
            }
            this.f991l.stage.setSelectLayer(selectLayer);
        }
    }

    /* renamed from: a */
    private void m884a(LinkedList<byte[]> linkedList) {
        if (this.f991l != null) {
            byte[] bArr = linkedList.get(0);
            Vector<ByteBuffer> vector = new Vector<>();
            int size = linkedList.size();
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 < size - 1) {
                    vector.add(ByteBuffer.wrap(linkedList.get(i2)));
                    i = i2 + 1;
                } else {
                    new MemoDataUtils(this.f991l).parse(bArr, linkedList.get(size - 1), vector);
                    return;
                }
            }
        }
    }

    /* renamed from: a */
    private void m883a(C1069y c1069y, LinkedList<SpriteCommand> linkedList, AbstractSprite abstractSprite) {
        if (this.f991l != null) {
            int i = c1069y.f1810a;
            if (i == 0) {
                linkedList.add(new SpriteCreateCommand(abstractSprite, this.f991l.stage));
                return;
            }
            if (i == 1) {
                linkedList.add(new C1019be(abstractSprite, this.f991l.stage));
                return;
            }
            if (i == 2) {
                C1021bg c1021bg = new C1021bg(abstractSprite, this.f991l.stage);
                c1021bg.f1563d = new PointF(c1069y.f1813d);
                c1021bg.f1562c = new PointF(c1069y.f1812c);
                linkedList.add(c1021bg);
                return;
            }
            if (i == 3) {
                C1023bi c1023bi = new C1023bi(abstractSprite, this.f991l.stage);
                c1023bi.f1572c = c1069y.f1814e;
                c1023bi.f1573d = c1069y.f1815f;
                linkedList.add(c1023bi);
                return;
            }
            if (i == 4) {
                C1022bh c1022bh = new C1022bh(abstractSprite, this.f991l.stage);
                c1022bh.f1566c = new RectF(c1069y.f1816g);
                c1022bh.f1567d = new RectF(c1069y.f1817h);
                c1022bh.f1569f = new PointF[4];
                c1022bh.f1569f[0] = new PointF(c1069y.f1819j[0]);
                c1022bh.f1569f[1] = new PointF(c1069y.f1819j[1]);
                c1022bh.f1569f[2] = new PointF(c1069y.f1819j[2]);
                c1022bh.f1569f[3] = new PointF(c1069y.f1819j[3]);
                c1022bh.f1568e = new PointF[4];
                c1022bh.f1569f[0] = new PointF(c1069y.f1818i[0]);
                c1022bh.f1569f[1] = new PointF(c1069y.f1818i[1]);
                c1022bh.f1569f[2] = new PointF(c1069y.f1818i[2]);
                c1022bh.f1569f[3] = new PointF(c1069y.f1818i[3]);
                linkedList.add(c1022bh);
                return;
            }
            if (i == 5) {
                linkedList.add(new C1018bd(abstractSprite, this.f991l.stage));
                return;
            }
            if (i == 6 && (abstractSprite instanceof C0989ab)) {
                linkedList.add(new C0990ac((C0989ab) abstractSprite, this.f991l.stage, c1069y.f1816g, c1069y.f1820k, (int) c1069y.f1821l, (int) c1069y.f1814e));
            } else if (i == 7 && (abstractSprite instanceof TextSprite)) {
                linkedList.add(new C1039by((TextSprite) abstractSprite, this.f991l.stage, c1069y.f1822m, c1069y.f1823n, c1069y.f1824o, c1069y.f1825p, c1069y.f1826q, c1069y.f1827r, c1069y.f1828s, c1069y.f1829t, c1069y.f1830u, c1069y.f1831v));
            }
        }
    }

    protected void setUseTextBoxLongPress(boolean isUseTextBoxLongPress) {
        this.f953bS = isUseTextBoxLongPress;
    }

    protected void setUseTextBoxDoubleTap(boolean isUseTextBoxDoubleTap) {
        this.f954bT = isUseTextBoxDoubleTap;
    }

    public void setOnDrawingInformationListener(OnDrawingInformationListener listener) {
        if (this.f991l != null) {
            this.f991l.setting.setOnDrawingInformationListener(listener);
        }
    }

    protected void setTextImeOption(boolean isNoExtractUI) {
        this.f955bU = isNoExtractUI;
        if (this.f955bU && this.f916ai != null) {
            this.f916ai.setImeOptions(268435456);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        super.onWindowFocusChanged(hasWindowFocus);
        if (hasWindowFocus && isShowTextBox() && this.f916ai.isFocusableInTouchMode()) {
            ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this.f916ai, 2);
        }
    }

    /* renamed from: a */
    void m970a(View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            FrameLayout.class.getMethod("clearAccessibilityFocus", new Class[0]).invoke(view, new Object[0]);
        } catch (Exception e) {
        }
    }
}
