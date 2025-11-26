package com.samsung.sdraw;

import android.R;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.LightingColorFilter;
import android.graphics.Rect;
import android.text.Layout;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;
import com.samsung.sdraw.C1050f;
import com.samsung.sdraw.C1051g;
import com.samsung.sdraw.FillingSettingInfo;
import com.samsung.sdraw.PalletView;
import com.samsung.sdraw.PenSettingScrollView;
import com.samsung.sdraw.PresetDataManager;
import com.samsung.sdraw.PresetLinearLayout;
import com.samsung.sdraw.StrokeSprite;
import com.samsung.sdraw.TextSettingInfo;
import com.samsung.spensdk.SCanvasConstants;
import com.vlingo.sdk.internal.http.HttpUtil;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class AbstractSettingView extends FrameLayout {
    public static final int ERASER_SETTING_VIEW = 2;
    public static final int FILLING_SETTING_VIEW = 4;
    public static final int PEN_SETTING_VIEW = 1;
    public static final int PEN_TYPE_BRUSH = 1;
    public static final int PEN_TYPE_HILIGHTER = 3;
    public static final int PEN_TYPE_PENCIL = 2;
    public static final int PEN_TYPE_SOLID = 0;
    public static final int SETTINGVIEW_SIZE_OPTION_EXT = 2;
    public static final int SETTINGVIEW_SIZE_OPTION_MINI = 1;
    public static final int SETTINGVIEW_SIZE_OPTION_NORMAL = 0;
    public static final int TEXT_SETTING_VIEW = 3;
    public static final int TITLE_ALIGN_CENTER = 1;
    public static final int TITLE_ALIGN_LEFT = 0;
    public static final int TITLE_ALIGN_RIGHT = 2;

    /* renamed from: af */
    private static boolean f672af = false;

    /* renamed from: A */
    private ModeContext f673A;

    /* renamed from: B */
    private PenSettingPreView f674B;

    /* renamed from: C */
    private C1036bv f675C;

    /* renamed from: D */
    private View[] f676D;

    /* renamed from: E */
    private View[] f677E;

    /* renamed from: F */
    private SeekBar f678F;

    /* renamed from: G */
    private SeekBar f679G;

    /* renamed from: H */
    private C1051g f680H;

    /* renamed from: I */
    private C1050f f681I;

    /* renamed from: J */
    private C1051g f682J;

    /* renamed from: K */
    private C1050f f683K;

    /* renamed from: L */
    private C1051g f684L;

    /* renamed from: M */
    private C1050f f685M;

    /* renamed from: N */
    private SeekBar f686N;

    /* renamed from: O */
    private View f687O;

    /* renamed from: P */
    private View f688P;

    /* renamed from: Q */
    private View f689Q;

    /* renamed from: R */
    private View f690R;

    /* renamed from: S */
    private View f691S;

    /* renamed from: T */
    private SettingChangeListener f692T;

    /* renamed from: U */
    private View f693U;

    /* renamed from: V */
    private View f694V;

    /* renamed from: W */
    private View f695W;

    /* renamed from: Z */
    private View f696Z;

    /* renamed from: a */
    PenSettingInfo f697a;

    /* renamed from: aA */
    private View.OnClickListener f698aA;

    /* renamed from: aB */
    private SeekBar.OnSeekBarChangeListener f699aB;

    /* renamed from: aC */
    private SeekBar.OnSeekBarChangeListener f700aC;

    /* renamed from: aD */
    private SeekBar.OnSeekBarChangeListener f701aD;

    /* renamed from: aE */
    private AdapterView.OnItemSelectedListener f702aE;

    /* renamed from: aF */
    private C1050f.a f703aF;

    /* renamed from: aG */
    private C1050f.a f704aG;

    /* renamed from: aH */
    private C1051g.a f705aH;

    /* renamed from: aI */
    private C1051g.a f706aI;

    /* renamed from: aJ */
    private C1050f.a f707aJ;

    /* renamed from: aK */
    private C1051g.a f708aK;

    /* renamed from: aL */
    private View.OnClickListener f709aL;

    /* renamed from: aM */
    private View.OnClickListener f710aM;

    /* renamed from: aN */
    private View.OnFocusChangeListener f711aN;

    /* renamed from: aO */
    private View.OnClickListener f712aO;

    /* renamed from: aP */
    private View.OnClickListener f713aP;

    /* renamed from: aQ */
    private PenSettingRootView f714aQ;

    /* renamed from: aR */
    private TextSettingInfo.InterfaceC0986b f715aR;

    /* renamed from: aS */
    private FillingSettingInfo.InterfaceC0974b f716aS;

    /* renamed from: aT */
    private InterfaceC0948a f717aT;

    /* renamed from: aU */
    private String f718aU;

    /* renamed from: aV */
    private int f719aV;

    /* renamed from: aW */
    private int f720aW;

    /* renamed from: aX */
    private int f721aX;

    /* renamed from: aY */
    private int f722aY;

    /* renamed from: aZ */
    private boolean f723aZ;

    /* renamed from: aa */
    private boolean f724aa;

    /* renamed from: ab */
    private boolean f725ab;

    /* renamed from: ac */
    private boolean f726ac;

    /* renamed from: ad */
    private boolean f727ad;

    /* renamed from: ae */
    private Spinner f728ae;

    /* renamed from: ag */
    private boolean f729ag;

    /* renamed from: ah */
    private int[] f730ah;

    /* renamed from: ai */
    private PresetDataManager f731ai;

    /* renamed from: aj */
    private C1052h f732aj;

    /* renamed from: ak */
    private PresetLinearLayout f733ak;

    /* renamed from: al */
    private TextView f734al;

    /* renamed from: am */
    private Toast f735am;

    /* renamed from: an */
    private boolean f736an;

    /* renamed from: ao */
    private boolean f737ao;

    /* renamed from: ap */
    private String f738ap;

    /* renamed from: aq */
    private String f739aq;

    /* renamed from: ar */
    private String f740ar;

    /* renamed from: as */
    private String f741as;

    /* renamed from: at */
    private String f742at;

    /* renamed from: au */
    private String f743au;

    /* renamed from: av */
    private String f744av;

    /* renamed from: aw */
    private String f745aw;

    /* renamed from: ax */
    private AdapterView.OnItemSelectedListener f746ax;

    /* renamed from: ay */
    private View.OnClickListener f747ay;

    /* renamed from: az */
    private View.OnClickListener f748az;

    /* renamed from: b */
    TextSettingInfo f749b;

    /* renamed from: ba */
    private View.OnClickListener f750ba;

    /* renamed from: bb */
    private PresetLinearLayout.OnClickPresetItemListener f751bb;

    /* renamed from: bc */
    private PresetDataManager.NotifyListener f752bc;

    /* renamed from: bd */
    private OnDeleteAllConfirmListener f753bd;

    /* renamed from: be */
    private View.OnTouchListener f754be;

    /* renamed from: bf */
    private View.OnTouchListener f755bf;

    /* renamed from: bg */
    private PenSettingScrollView.InterfaceC0978a f756bg;

    /* renamed from: bh */
    private PenSettingScrollView.InterfaceC0978a f757bh;

    /* renamed from: bi */
    private PalletView.InterfaceC0975a f758bi;

    /* renamed from: bj */
    private PalletView.InterfaceC0975a f759bj;

    /* renamed from: bk */
    private boolean f760bk;

    /* renamed from: bl */
    private int f761bl;

    /* renamed from: bm */
    private PresetLinearLayout.InterfaceC0982a f762bm;

    /* renamed from: bn */
    private OnSettingViewExpandedListener f763bn;

    /* renamed from: bo */
    private boolean f764bo;

    /* renamed from: bp */
    private boolean f765bp;

    /* renamed from: bq */
    private boolean f766bq;

    /* renamed from: br */
    private OnPresetDelBtnOnClickListener f767br;

    /* renamed from: bs */
    private int f768bs;

    /* renamed from: bt */
    private boolean f769bt;

    /* renamed from: c */
    FillingSettingInfo f770c;

    /* renamed from: d */
    OnSettingChangedListener f771d;

    /* renamed from: e */
    String f772e;

    /* renamed from: f */
    ArrayList<String> f773f;

    /* renamed from: g */
    ArrayList<String> f774g;

    /* renamed from: h */
    ArrayList<String> f775h;

    /* renamed from: i */
    HashMap<String, Integer> f776i;

    /* renamed from: j */
    HashMap<String, String> f777j;

    /* renamed from: k */
    ScrollThumbController f778k;

    /* renamed from: l */
    String f779l;

    /* renamed from: m */
    String f780m;

    /* renamed from: n */
    SharedPreferencesManager f781n;

    /* renamed from: o */
    C0999al f782o;

    /* renamed from: p */
    C1061q f783p;

    /* renamed from: q */
    C1038bx f784q;

    /* renamed from: r */
    C1066v f785r;

    /* renamed from: s */
    OnSettingChangedListener f786s;

    /* renamed from: t */
    String f787t;

    /* renamed from: u */
    String f788u;

    /* renamed from: v */
    AlertDialog f789v;

    /* renamed from: w */
    int f790w;

    /* renamed from: x */
    int f791x;

    /* renamed from: y */
    int f792y;

    /* renamed from: z */
    private CanvasView f793z;

    public interface OnDeleteAllConfirmListener {
        boolean onDeleteAllConfirm(int i);
    }

    public interface OnPresetDelBtnOnClickListener {
        void onClick(int i);
    }

    public interface OnSettingChangedListener {
        void onClearAll(boolean z);

        void onDeleteAll(boolean z);

        void onEraserWidthChanged(int i);

        void onFillingColorChanged(int i);

        void onPenAlphaChanged(int i);

        void onPenColorChanged(int i);

        void onPenTypeChanged(int i);

        void onPenWidthChanged(int i);

        void onTextAlignmentChanged(Layout.Alignment alignment);

        void onTextColorChanged(int i);

        void onTextFontChanged(String str);

        void onTextSizeChanged(int i);

        void onTextTypeChanged(int i);
    }

    public interface OnSettingViewExpandedListener {
        void onPenSettingViewExpanded(boolean z);
    }

    public interface SettingChangeListener {
        void onClearAll();

        void onColorChanged(int i);

        void onEraserWidthChanged(int i);

        void onPenAlphaChanged(int i);

        void onPenTypeChanged(int i);

        void onPenWidthChanged(int i);
    }

    /* renamed from: com.samsung.sdraw.AbstractSettingView$a */
    interface InterfaceC0948a {
        /* renamed from: a */
        void mo806a(boolean z);

        /* renamed from: b */
        void mo807b(boolean z);

        /* renamed from: c */
        void mo808c(boolean z);

        /* renamed from: d */
        void mo809d(boolean z);
    }

    public AbstractSettingView(Context context) {
        super(context);
        this.f724aa = false;
        this.f725ab = false;
        this.f726ac = false;
        this.f727ad = false;
        this.f729ag = false;
        this.f772e = "";
        this.f773f = new ArrayList<>();
        this.f774g = new ArrayList<>();
        this.f775h = new ArrayList<>();
        this.f776i = new HashMap<>();
        this.f777j = new HashMap<>();
        this.f730ah = new int[]{0, 1, 3, 4, 6, 2};
        this.f779l = "Already exists same pen setting";
        this.f780m = "Maximum number of Preset pens(%d) reached";
        this.f736an = false;
        this.f737ao = true;
        this.f742at = HttpUtil.VAL_CLOSE;
        this.f743au = "Pen type %s, thickness %d percent, transparency %d percent";
        this.f744av = "DropperView Color";
        this.f745aw = null;
        this.f746ax = new AdapterView.OnItemSelectedListener() { // from class: com.samsung.sdraw.AbstractSettingView.1
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                int i = 0;
                String str = (String) AbstractSettingView.this.f728ae.getSelectedItem();
                AbstractSettingView.this.f728ae.setContentDescription(String.format(AbstractSettingView.this.f784q.f1651s, str));
                while (true) {
                    int i2 = i;
                    if (i2 < AbstractSettingView.this.f774g.size()) {
                        if (AbstractSettingView.this.f774g.get(i2).equalsIgnoreCase(str)) {
                            AbstractSettingView.this.m704a(AbstractSettingView.this.f773f.get(i2));
                        }
                        i = i2 + 1;
                    } else {
                        return;
                    }
                }
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        };
        this.f747ay = new View.OnClickListener() { // from class: com.samsung.sdraw.AbstractSettingView.12
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (!v.isSelected()) {
                    if (AbstractSettingView.this.f793z != null) {
                        AbstractSettingView.this.f793z.m977b(AbstractSettingView.this.f697a);
                    }
                    AbstractSettingView.this.m691a(v);
                    if (AbstractSettingView.this.f793z != null) {
                        AbstractSettingView.this.f793z.m972a(AbstractSettingView.this.f697a);
                    }
                    AbstractSettingView.this.f778k.moveScrollControlThumb(AbstractSettingView.this.f782o.f1695aj.getScrollY(), true);
                }
            }
        };
        this.f748az = new View.OnClickListener() { // from class: com.samsung.sdraw.AbstractSettingView.23
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                AbstractSettingView.this.m708b(v);
            }
        };
        this.f698aA = new View.OnClickListener() { // from class: com.samsung.sdraw.AbstractSettingView.28
            @Override // android.view.View.OnClickListener
            public void onClick(View v) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                if (AbstractSettingView.this.f793z != null) {
                    AbstractSettingView.this.f793z.m970a(v);
                }
                if (!v.equals(AbstractSettingView.this.f688P)) {
                    if (!v.equals(AbstractSettingView.this.f689Q)) {
                        if (!v.equals(AbstractSettingView.this.f690R)) {
                            if (v.equals(AbstractSettingView.this.f691S)) {
                                AbstractSettingView.this.m788i().setVisibility(4);
                                if (AbstractSettingView.this.f717aT == null) {
                                    return;
                                }
                                AbstractSettingView.this.f717aT.mo809d(false);
                                return;
                            }
                            return;
                        }
                        AbstractSettingView.this.m787h().setVisibility(4);
                        if (AbstractSettingView.this.f717aT == null) {
                            return;
                        }
                        AbstractSettingView.this.f717aT.mo808c(false);
                        return;
                    }
                    AbstractSettingView.this.m789j().setVisibility(4);
                    if (AbstractSettingView.this.f717aT == null) {
                        return;
                    }
                    AbstractSettingView.this.f717aT.mo807b(false);
                    return;
                }
                AbstractSettingView.this.m786g().setVisibility(4);
                if (AbstractSettingView.this.f717aT == null) {
                    return;
                }
                AbstractSettingView.this.f717aT.mo806a(false);
            }
        };
        this.f699aB = new SeekBar.OnSeekBarChangeListener() { // from class: com.samsung.sdraw.AbstractSettingView.29
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (AbstractSettingView.this.f692T != null) {
                    AbstractSettingView.this.f692T.onPenWidthChanged(AbstractSettingView.this.f697a.getPenWidth());
                }
                if (AbstractSettingView.this.f771d != null) {
                    AbstractSettingView.this.f771d.onPenWidthChanged(AbstractSettingView.this.f697a.getPenWidth());
                }
                if (AbstractSettingView.this.f793z != null) {
                    AbstractSettingView.this.f793z.m977b(AbstractSettingView.this.f697a);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int progress2 = progress + 1;
                if (AbstractSettingView.this.f674B != null) {
                    AbstractSettingView.this.f674B.setPenWidth(progress2);
                    if (AbstractSettingView.this.f782o != null) {
                        AbstractSettingView.this.f674B.setDescription(AbstractSettingView.this.f782o.f1494h, AbstractSettingView.this.f782o.f1495i, AbstractSettingView.this.f782o.f1496j, AbstractSettingView.this.f782o.f1497k, AbstractSettingView.this.f782o.f1498l, AbstractSettingView.this.f782o.f1499m);
                    }
                }
                if (AbstractSettingView.this.f697a != null) {
                    AbstractSettingView.this.f697a.setPenWidth(progress2);
                    if (AbstractSettingView.this.f782o != null) {
                        AbstractSettingView.this.f782o.mo1308a(AbstractSettingView.this.f697a.getPenType(), AbstractSettingView.this.f697a.getPenColor(), AbstractSettingView.this.f697a.getPenAlpha(), AbstractSettingView.this.f697a.getPenWidth());
                        int max = (progress2 * 100) / AbstractSettingView.this.f678F.getMax();
                        if (max > 100) {
                            max = 100;
                        }
                        AbstractSettingView.this.f678F.setContentDescription(String.format(AbstractSettingView.this.f782o.f1490d, Integer.valueOf(max)));
                    }
                    if (AbstractSettingView.this.f673A != null && AbstractSettingView.this.f673A.stage != null) {
                        AbstractSettingView.this.f673A.setting.setStrokeWidth(AbstractSettingView.this.f697a.getPenWidth());
                    }
                }
            }
        };
        this.f700aC = new SeekBar.OnSeekBarChangeListener() { // from class: com.samsung.sdraw.AbstractSettingView.30
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (AbstractSettingView.this.f692T != null) {
                    AbstractSettingView.this.f692T.onPenAlphaChanged(AbstractSettingView.this.f697a.getPenAlpha());
                }
                if (AbstractSettingView.this.f771d != null) {
                    AbstractSettingView.this.f771d.onPenAlphaChanged(AbstractSettingView.this.f697a.getPenAlpha());
                }
                if (AbstractSettingView.this.f793z != null) {
                    AbstractSettingView.this.f793z.m977b(AbstractSettingView.this.f697a);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (AbstractSettingView.this.f674B != null) {
                    AbstractSettingView.this.f674B.setPenAlpha(progress);
                    if (AbstractSettingView.this.f782o != null) {
                        AbstractSettingView.this.f674B.setDescription(AbstractSettingView.this.f782o.f1494h, AbstractSettingView.this.f782o.f1495i, AbstractSettingView.this.f782o.f1496j, AbstractSettingView.this.f782o.f1497k, AbstractSettingView.this.f782o.f1498l, AbstractSettingView.this.f782o.f1499m);
                    }
                }
                if (AbstractSettingView.this.f697a != null) {
                    AbstractSettingView.this.f697a.setPenAlpha(progress);
                    if (AbstractSettingView.this.f782o != null) {
                        AbstractSettingView.this.f782o.mo1308a(AbstractSettingView.this.f697a.getPenType(), AbstractSettingView.this.f697a.getPenColor(), AbstractSettingView.this.f697a.getPenAlpha(), AbstractSettingView.this.f697a.getPenWidth());
                        int max = (progress * 100) / AbstractSettingView.this.f679G.getMax();
                        if (max > 100) {
                            max = 100;
                        }
                        AbstractSettingView.this.f679G.setContentDescription(String.format(AbstractSettingView.this.f782o.f1491e, Integer.valueOf(max)));
                    }
                    if (AbstractSettingView.this.f673A != null && AbstractSettingView.this.f673A.setting != null) {
                        AbstractSettingView.this.f673A.setting.setStrokeColor(AbstractSettingView.this.f697a.getPenAlphaColor());
                    }
                    if (AbstractSettingView.this.f782o != null && AbstractSettingView.this.f782o.f1455F != null) {
                        AbstractSettingView.this.f782o.f1455F.setColor(AbstractSettingView.this.f697a.getPenAlphaColor());
                    }
                }
            }
        };
        this.f701aD = new SeekBar.OnSeekBarChangeListener() { // from class: com.samsung.sdraw.AbstractSettingView.31
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (AbstractSettingView.this.f692T != null) {
                    AbstractSettingView.this.f692T.onEraserWidthChanged(AbstractSettingView.this.f697a.getEraserWidth());
                }
                if (AbstractSettingView.this.f771d != null) {
                    AbstractSettingView.this.f771d.onEraserWidthChanged(AbstractSettingView.this.f697a.getEraserWidth());
                }
                if (AbstractSettingView.this.f793z != null && AbstractSettingView.this.f793z.f881a != null) {
                    AbstractSettingView.this.f793z.f881a.setEraserWidth(AbstractSettingView.this.f697a.getEraserWidth());
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (AbstractSettingView.this.f697a != null) {
                    AbstractSettingView.this.f697a.setEraserWidth(progress);
                    if (AbstractSettingView.this.f673A != null && AbstractSettingView.this.f673A.setting != null && AbstractSettingView.this.f673A.setting.getStrokeType() == StrokeSprite.Type.Eraser) {
                        AbstractSettingView.this.f673A.setting.setEraserWidth(AbstractSettingView.this.f697a.getEraserWidth());
                    }
                    if (AbstractSettingView.this.f783p != null) {
                        AbstractSettingView.this.f783p.mo1569a(progress);
                        int max = (progress * 100) / AbstractSettingView.this.f686N.getMax();
                        AbstractSettingView.this.f686N.setContentDescription(String.format(AbstractSettingView.this.f783p.f1757d, Integer.valueOf(max <= 100 ? max : 100)));
                    }
                }
            }
        };
        this.f702aE = new AdapterView.OnItemSelectedListener() { // from class: com.samsung.sdraw.AbstractSettingView.32
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                Object selectedItem;
                int i = 0;
                int i2 = 0;
                while (true) {
                    if (i2 >= AbstractSettingView.this.f775h.size()) {
                        break;
                    }
                    if (((Spinner) AbstractSettingView.this.f677E[0]) == null || (selectedItem = ((Spinner) AbstractSettingView.this.f677E[0]).getSelectedItem()) == null || !selectedItem.equals(AbstractSettingView.this.f775h.get(i2))) {
                        i2++;
                    } else {
                        int i3 = i2 + 5;
                        if (AbstractSettingView.this.f784q != null) {
                            ((Spinner) AbstractSettingView.this.f677E[0]).setContentDescription(String.format(AbstractSettingView.this.f784q.f1652t, Integer.valueOf(i3)));
                            i = i3;
                        } else {
                            i = i3;
                        }
                    }
                }
                if (AbstractSettingView.this.f675C != null) {
                    AbstractSettingView.this.f675C.m1439b(i);
                    if (AbstractSettingView.this.f784q != null) {
                        AbstractSettingView.this.f675C.m1437a(AbstractSettingView.this.f784q.f1649q, (String) AbstractSettingView.this.f728ae.getSelectedItem());
                    }
                }
                if (AbstractSettingView.this.f749b != null) {
                    AbstractSettingView.this.f749b.setTextSize(i);
                    if (AbstractSettingView.this.f784q != null) {
                        AbstractSettingView.this.f784q.mo1464a(AbstractSettingView.this.f749b.getTextType(), AbstractSettingView.this.f749b.getTextColor(), AbstractSettingView.this.f749b.getTextSize());
                    }
                    if (AbstractSettingView.this.f673A != null && AbstractSettingView.this.f673A.stage != null) {
                        AbstractSettingView.this.f673A.setting.setTextSize(AbstractSettingView.this.f749b.getTextSize());
                    }
                }
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        };
        this.f703aF = new C1050f.a() { // from class: com.samsung.sdraw.AbstractSettingView.33
            @Override // com.samsung.sdraw.C1050f.a
            /* renamed from: a */
            public void mo800a(int i, int i2, int i3) {
                if (AbstractSettingView.this.f749b != null) {
                    AbstractSettingView.this.f749b.m1184a(i2, i3);
                    AbstractSettingView.this.f749b.setTextColor(i);
                    if (AbstractSettingView.this.f675C != null) {
                        AbstractSettingView.this.f675C.m1440c(i);
                    }
                    if (AbstractSettingView.this.f682J != null) {
                        AbstractSettingView.this.f682J.m1552a(i);
                    }
                    if (AbstractSettingView.this.f784q != null) {
                        if (AbstractSettingView.this.f784q.f1613I != null) {
                            AbstractSettingView.this.f784q.f1613I.setColor((-16777216) | (16777215 & i));
                        }
                        AbstractSettingView.this.f784q.mo1464a(AbstractSettingView.this.f749b.getTextType(), AbstractSettingView.this.f749b.getTextColor(), AbstractSettingView.this.f749b.getTextSize());
                    }
                    if (AbstractSettingView.this.f673A != null && AbstractSettingView.this.f673A.setting != null) {
                        AbstractSettingView.this.f673A.setting.setTextColor(AbstractSettingView.this.f749b.getTextColor());
                    }
                }
            }
        };
        this.f704aG = new C1050f.a() { // from class: com.samsung.sdraw.AbstractSettingView.2
            @Override // com.samsung.sdraw.C1050f.a
            /* renamed from: a */
            public void mo800a(int i, int i2, int i3) {
                if (AbstractSettingView.this.f770c != null) {
                    AbstractSettingView.this.f770c.m996a(i2, i3);
                    AbstractSettingView.this.f770c.m995a((-33554432) | (16777215 & i));
                    AbstractSettingView.this.f770c.setFillingColor(i);
                    if (AbstractSettingView.this.f684L != null) {
                        AbstractSettingView.this.f684L.m1552a(i);
                    }
                    if (AbstractSettingView.this.f673A != null && AbstractSettingView.this.f673A.setting != null) {
                        AbstractSettingView.this.f673A.setting.setFillingColor(AbstractSettingView.this.f770c.getFillingColor());
                    }
                    if (AbstractSettingView.this.f771d != null) {
                        AbstractSettingView.this.f771d.onFillingColorChanged(AbstractSettingView.this.f770c.getFillingColor());
                    }
                }
            }
        };
        this.f705aH = new C1051g.a() { // from class: com.samsung.sdraw.AbstractSettingView.3
            @Override // com.samsung.sdraw.C1051g.a
            /* renamed from: a */
            public void mo804a(int i, int i2, boolean z) {
                if ((i2 == AbstractSettingView.this.f682J.m1555b() - 1 || i2 == -1) && AbstractSettingView.this.f784q != null && AbstractSettingView.this.f784q.f1612H.getVisibility() == 8) {
                    AbstractSettingView.this.f784q.m1491b(true);
                    if (!z) {
                        return;
                    }
                }
                if (AbstractSettingView.this.f749b != null) {
                    if (AbstractSettingView.this.f675C != null) {
                        AbstractSettingView.this.f675C.m1440c(i);
                    }
                    if (AbstractSettingView.this.f784q != null) {
                        if (AbstractSettingView.this.f784q.f1613I != null) {
                            AbstractSettingView.this.f784q.f1613I.setColor((-16777216) | (16777215 & i));
                        }
                        AbstractSettingView.this.f784q.mo1464a(AbstractSettingView.this.f749b.getTextType(), i, AbstractSettingView.this.f749b.getTextSize());
                    }
                    AbstractSettingView.this.f749b.setTextColor(i);
                    if (AbstractSettingView.this.f673A != null && AbstractSettingView.this.f673A.setting != null) {
                        AbstractSettingView.this.f673A.setting.setTextColor(AbstractSettingView.this.f749b.getTextColor());
                    }
                }
            }
        };
        this.f706aI = new C1051g.a() { // from class: com.samsung.sdraw.AbstractSettingView.4
            @Override // com.samsung.sdraw.C1051g.a
            /* renamed from: a */
            public void mo804a(int i, int i2, boolean z) {
                if ((i2 == AbstractSettingView.this.f684L.m1555b() - 1 || i2 == -1) && AbstractSettingView.this.f785r.f1792j.getVisibility() == 8) {
                    AbstractSettingView.this.setPalletViewState(true, 4);
                    if (!z) {
                        return;
                    }
                }
                if (AbstractSettingView.this.f770c != null) {
                    if (AbstractSettingView.this.f673A != null && AbstractSettingView.this.f673A.setting != null) {
                        AbstractSettingView.this.f673A.setting.setFillingColor(AbstractSettingView.this.f770c.getFillingColor());
                    }
                    if (i == AbstractSettingView.this.f684L.m1556c()) {
                        AbstractSettingView.this.f770c.m995a((-33554432) | (16777215 & i));
                    } else {
                        AbstractSettingView.this.f770c.m995a((-16777216) | (16777215 & i));
                    }
                    AbstractSettingView.this.f770c.setFillingColor(i);
                    if (AbstractSettingView.this.f771d != null) {
                        AbstractSettingView.this.f771d.onFillingColorChanged(AbstractSettingView.this.f770c.getFillingColor());
                    }
                }
            }
        };
        this.f707aJ = new C1050f.a() { // from class: com.samsung.sdraw.AbstractSettingView.5
            @Override // com.samsung.sdraw.C1050f.a
            /* renamed from: a */
            public void mo800a(int i, int i2, int i3) {
                if (AbstractSettingView.this.f697a != null) {
                    AbstractSettingView.this.f697a.m1022a(i2, i3);
                    AbstractSettingView.this.f697a.m1025b((-33554432) | (16777215 & i));
                    AbstractSettingView.this.f697a.setPenColor(i);
                    if (AbstractSettingView.this.f674B != null) {
                        AbstractSettingView.this.f674B.setPenColor(i);
                    }
                    if (AbstractSettingView.this.f680H != null) {
                        AbstractSettingView.this.f680H.m1552a(AbstractSettingView.this.f697a.m1021a());
                    }
                    if (AbstractSettingView.this.f782o != null) {
                        if (AbstractSettingView.this.f782o.f1454E != null) {
                            AbstractSettingView.this.f782o.f1454E.setColor((i & 16777215) | (-16777216));
                        }
                        if (AbstractSettingView.this.f782o.f1455F != null) {
                            AbstractSettingView.this.f782o.f1455F.setColor(AbstractSettingView.this.f697a.getPenAlphaColor());
                        }
                        AbstractSettingView.this.f782o.mo1308a(AbstractSettingView.this.f697a.getPenType(), AbstractSettingView.this.f697a.getPenColor(), AbstractSettingView.this.f697a.getPenAlpha(), AbstractSettingView.this.f697a.getPenWidth());
                    }
                    if (AbstractSettingView.this.f673A != null && AbstractSettingView.this.f673A.setting != null) {
                        AbstractSettingView.this.f673A.setting.setStrokeColor(AbstractSettingView.this.f697a.getPenAlphaColor());
                    }
                    if (AbstractSettingView.this.f692T != null) {
                        AbstractSettingView.this.f692T.onColorChanged(((AbstractSettingView.this.f697a.getPenAlpha() << 24) & (-16777216)) | AbstractSettingView.this.f697a.getPenColor());
                    }
                    if (AbstractSettingView.this.f771d != null) {
                        AbstractSettingView.this.f771d.onPenColorChanged(((AbstractSettingView.this.f697a.getPenAlpha() << 24) & (-16777216)) | AbstractSettingView.this.f697a.getPenColor());
                    }
                    if (AbstractSettingView.this.f793z != null) {
                        AbstractSettingView.this.f793z.m977b(AbstractSettingView.this.f697a);
                    }
                }
            }
        };
        this.f708aK = new C1051g.a() { // from class: com.samsung.sdraw.AbstractSettingView.6
            @Override // com.samsung.sdraw.C1051g.a
            /* renamed from: a */
            public void mo804a(int i, int i2, boolean z) {
                if ((i2 == AbstractSettingView.this.f680H.m1555b() - 1 || i2 == -1) && AbstractSettingView.this.f782o != null && AbstractSettingView.this.f782o.f1453D.getVisibility() == 8) {
                    AbstractSettingView.this.setPalletViewState(true, 1);
                    AbstractSettingView.this.f778k.relayoutSettingView(AbstractSettingView.this.getContext().getResources().getDisplayMetrics().widthPixels < AbstractSettingView.this.getResources().getDisplayMetrics().heightPixels, false);
                    AbstractSettingView.this.f778k.setScrollToMax();
                    if (!z) {
                        return;
                    }
                }
                if (AbstractSettingView.this.f697a != null) {
                    if (AbstractSettingView.this.f674B != null) {
                        AbstractSettingView.this.f674B.setPenColor(i);
                    }
                    if (AbstractSettingView.this.f782o != null) {
                        if (AbstractSettingView.this.f782o.f1454E != null) {
                            AbstractSettingView.this.f782o.f1454E.setColor((i & 16777215) | (-16777216));
                        }
                        if (AbstractSettingView.this.f782o.f1455F != null) {
                            AbstractSettingView.this.f782o.f1455F.setColor(AbstractSettingView.this.f697a.getPenAlphaColor());
                        }
                        AbstractSettingView.this.f782o.mo1308a(AbstractSettingView.this.f697a.getPenType(), i, AbstractSettingView.this.f697a.getPenAlpha(), AbstractSettingView.this.f697a.getPenWidth());
                    }
                    if (i == AbstractSettingView.this.f680H.m1556c()) {
                        AbstractSettingView.this.f697a.m1025b((-33554432) | (16777215 & i));
                    } else {
                        AbstractSettingView.this.f697a.m1025b((16777215 & i) | (-16777216));
                    }
                    AbstractSettingView.this.f697a.setPenColor(i);
                    if (AbstractSettingView.this.f673A != null && AbstractSettingView.this.f673A.setting != null) {
                        AbstractSettingView.this.f673A.setting.setStrokeColor(AbstractSettingView.this.f697a.getPenAlphaColor());
                    }
                    if (AbstractSettingView.this.f782o != null && AbstractSettingView.this.f782o.f1455F != null) {
                        AbstractSettingView.this.f782o.f1455F.setColor(AbstractSettingView.this.f697a.getPenAlphaColor());
                    }
                    if (AbstractSettingView.this.f692T != null) {
                        AbstractSettingView.this.f692T.onColorChanged(((AbstractSettingView.this.f697a.getPenAlpha() << 24) & (-16777216)) | AbstractSettingView.this.f697a.getPenColor());
                    }
                    if (AbstractSettingView.this.f771d != null) {
                        AbstractSettingView.this.f771d.onPenColorChanged(((AbstractSettingView.this.f697a.getPenAlpha() << 24) & (-16777216)) | AbstractSettingView.this.f697a.getPenColor());
                    }
                    if (AbstractSettingView.this.f793z != null) {
                        AbstractSettingView.this.f793z.m977b(AbstractSettingView.this.f697a);
                    }
                }
            }
        };
        this.f709aL = new View.OnClickListener() { // from class: com.samsung.sdraw.AbstractSettingView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                boolean zOnDeleteAllConfirm = false;
                zOnDeleteAllConfirm = false;
                if (AbstractSettingView.this.f673A == null) {
                    return;
                }
                if (AbstractSettingView.this.f753bd != null && AbstractSettingView.this.f673A.stage != null) {
                    zOnDeleteAllConfirm = AbstractSettingView.this.f753bd.onDeleteAllConfirm(AbstractSettingView.this.f673A.stage.getSelectedLayerID() == 3 ? 1 : 0);
                }
                if (!zOnDeleteAllConfirm && AbstractSettingView.this.f673A.setting != null && AbstractSettingView.this.f723aZ) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                    if (AbstractSettingView.this.f776i.containsKey(SCanvasConstants.LAYOUT_ERASER_DELETEALL_POPUP_ICON)) {
                        if (AbstractSettingView.this.f776i.get(SCanvasConstants.LAYOUT_ERASER_DELETEALL_POPUP_ICON).intValue() != -1) {
                            builder.setIcon(AbstractSettingView.this.f776i.get(SCanvasConstants.LAYOUT_ERASER_DELETEALL_POPUP_ICON).intValue());
                        }
                    } else {
                        builder.setIcon(R.drawable.ic_dialog_alert);
                    }
                    if (AbstractSettingView.this.f776i.containsKey(SCanvasConstants.LOCALE_ERASER_SETTING_CLEARALL)) {
                        builder.setTitle(AbstractSettingView.this.f776i.get(SCanvasConstants.LOCALE_ERASER_SETTING_CLEARALL).intValue());
                    } else if (AbstractSettingView.this.f776i.containsKey(SCanvasConstants.LOCALE_ERASER_SETTING_DELETEALL)) {
                        builder.setTitle(AbstractSettingView.this.f776i.get(SCanvasConstants.LOCALE_ERASER_SETTING_DELETEALL).intValue());
                    } else {
                        builder.setTitle("Delete all");
                    }
                    if (AbstractSettingView.this.f776i.containsKey(SCanvasConstants.LOCALE_ERASER_SETTING_CLEARALL_MESSAGE)) {
                        builder.setMessage(AbstractSettingView.this.f776i.get(SCanvasConstants.LOCALE_ERASER_SETTING_CLEARALL_MESSAGE).intValue());
                    } else if (AbstractSettingView.this.f776i.containsKey(SCanvasConstants.LOCALE_ERASER_SETTING_DELETEALL_MESSAGE)) {
                        builder.setMessage(AbstractSettingView.this.f776i.get(SCanvasConstants.LOCALE_ERASER_SETTING_DELETEALL_MESSAGE).intValue());
                    } else {
                        builder.setMessage("All data will be deleted");
                    }
                    builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() { // from class: com.samsung.sdraw.AbstractSettingView.7.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface arg0, int arg1) {
                            if (AbstractSettingView.this.f771d != null) {
                                AbstractSettingView.this.f771d.onClearAll(false);
                                AbstractSettingView.this.f771d.onDeleteAll(false);
                            }
                            if (AbstractSettingView.this.f673A != null) {
                                ((CanvasView) AbstractSettingView.this.f673A.view).deleteAll(true);
                            }
                            if (AbstractSettingView.this.f692T != null) {
                                AbstractSettingView.this.f692T.onClearAll();
                            }
                            if (AbstractSettingView.this.f771d != null) {
                                AbstractSettingView.this.f771d.onClearAll(true);
                                AbstractSettingView.this.f771d.onDeleteAll(true);
                            }
                        }
                    });
                    builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() { // from class: com.samsung.sdraw.AbstractSettingView.7.2
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface arg0, int arg1) {
                        }
                    });
                    builder.setCancelable(true);
                    builder.create().show();
                }
            }
        };
        this.f710aM = new View.OnClickListener() { // from class: com.samsung.sdraw.AbstractSettingView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (AbstractSettingView.this.f782o != null && AbstractSettingView.this.f782o.f1453D != null) {
                    if (AbstractSettingView.this.f782o.f1453D.getVisibility() == 8) {
                        AbstractSettingView.this.setPalletViewState(true, 1);
                        v.setSelected(false);
                        AbstractSettingView.this.f778k.setScrollToMax();
                    } else {
                        AbstractSettingView.this.setPalletViewState(false, 1);
                        v.setSelected(true);
                    }
                }
                if (AbstractSettingView.this.f785r != null && AbstractSettingView.this.f785r.f1792j != null) {
                    if (AbstractSettingView.this.f785r.f1792j.getVisibility() == 8) {
                        AbstractSettingView.this.setPalletViewState(true, 4);
                        v.setSelected(false);
                    } else {
                        AbstractSettingView.this.setPalletViewState(false, 4);
                        v.setSelected(true);
                    }
                }
            }
        };
        this.f711aN = new View.OnFocusChangeListener() { // from class: com.samsung.sdraw.AbstractSettingView.9
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View arg0, boolean arg1) {
                if (arg0.equals(AbstractSettingView.this.f784q.f1616L) && arg1) {
                    AbstractSettingView.this.f784q.f1616L.setSelected(true);
                    AbstractSettingView.this.f784q.f1617M.setSelected(false);
                    AbstractSettingView.this.f784q.mo1463a(0);
                } else if (arg0.equals(AbstractSettingView.this.f784q.f1617M) && arg1) {
                    AbstractSettingView.this.f784q.f1616L.setSelected(false);
                    AbstractSettingView.this.f784q.f1617M.setSelected(true);
                    AbstractSettingView.this.f784q.mo1463a(1);
                }
                AbstractSettingView.this.m770a(3, true);
            }
        };
        this.f712aO = new View.OnClickListener() { // from class: com.samsung.sdraw.AbstractSettingView.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (v.equals(AbstractSettingView.this.f784q.f1616L)) {
                    AbstractSettingView.this.f784q.f1616L.setSelected(true);
                    AbstractSettingView.this.f784q.f1617M.setSelected(false);
                    AbstractSettingView.this.f784q.mo1463a(0);
                } else if (v.equals(AbstractSettingView.this.f784q.f1617M)) {
                    AbstractSettingView.this.f784q.f1616L.setSelected(false);
                    AbstractSettingView.this.f784q.f1617M.setSelected(true);
                    AbstractSettingView.this.f784q.mo1463a(1);
                }
                AbstractSettingView.this.m770a(3, true);
            }
        };
        this.f713aP = new View.OnClickListener() { // from class: com.samsung.sdraw.AbstractSettingView.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (AbstractSettingView.this.f784q != null && AbstractSettingView.this.f784q.f1608D != null && AbstractSettingView.this.f784q.f1609E != null && AbstractSettingView.this.f784q.f1610F != null) {
                    if (v.equals(AbstractSettingView.this.f784q.f1608D)) {
                        AbstractSettingView.this.f784q.f1608D.setSelected(true);
                        AbstractSettingView.this.f784q.f1609E.setSelected(false);
                        AbstractSettingView.this.f784q.f1610F.setSelected(false);
                        AbstractSettingView.this.f749b.setTextAlignment(Layout.Alignment.ALIGN_NORMAL);
                        return;
                    }
                    if (v.equals(AbstractSettingView.this.f784q.f1609E)) {
                        AbstractSettingView.this.f784q.f1608D.setSelected(false);
                        AbstractSettingView.this.f784q.f1609E.setSelected(true);
                        AbstractSettingView.this.f784q.f1610F.setSelected(false);
                        AbstractSettingView.this.f749b.setTextAlignment(Layout.Alignment.ALIGN_CENTER);
                        return;
                    }
                    if (v.equals(AbstractSettingView.this.f784q.f1610F)) {
                        AbstractSettingView.this.f784q.f1608D.setSelected(false);
                        AbstractSettingView.this.f784q.f1609E.setSelected(false);
                        AbstractSettingView.this.f784q.f1610F.setSelected(true);
                        AbstractSettingView.this.f749b.setTextAlignment(Layout.Alignment.ALIGN_OPPOSITE);
                    }
                }
            }
        };
        this.f715aR = new TextSettingInfo.InterfaceC0986b() { // from class: com.samsung.sdraw.AbstractSettingView.13
            @Override // com.samsung.sdraw.TextSettingInfo.InterfaceC0986b
            /* renamed from: a */
            public void mo794a(int i) {
                AbstractSettingView.this.m684F();
                if (AbstractSettingView.this.f673A != null) {
                    ((CanvasView) AbstractSettingView.this.f673A.view).m973a(AbstractSettingView.this.f749b, 0);
                }
                if (AbstractSettingView.this.f771d != null) {
                    AbstractSettingView.this.f771d.onTextTypeChanged(i);
                }
            }

            @Override // com.samsung.sdraw.TextSettingInfo.InterfaceC0986b
            /* renamed from: b */
            public void mo797b(int i) {
                AbstractSettingView.this.m684F();
                if (AbstractSettingView.this.f673A != null) {
                    ((CanvasView) AbstractSettingView.this.f673A.view).m973a(AbstractSettingView.this.f749b, 1);
                }
                if (AbstractSettingView.this.f682J != null) {
                    AbstractSettingView.this.f682J.m1552a(i);
                }
                if (AbstractSettingView.this.f771d != null) {
                    AbstractSettingView.this.f771d.onTextColorChanged(i);
                }
            }

            @Override // com.samsung.sdraw.TextSettingInfo.InterfaceC0986b
            /* renamed from: c */
            public void mo798c(int i) {
                AbstractSettingView.this.m684F();
                if (AbstractSettingView.this.f673A != null) {
                    ((CanvasView) AbstractSettingView.this.f673A.view).m973a(AbstractSettingView.this.f749b, 2);
                }
                if (AbstractSettingView.this.f771d != null) {
                    AbstractSettingView.this.f771d.onTextSizeChanged(i);
                }
            }

            @Override // com.samsung.sdraw.TextSettingInfo.InterfaceC0986b
            /* renamed from: a */
            public void mo796a(String str) {
                AbstractSettingView.this.m684F();
                if (AbstractSettingView.this.f673A != null) {
                    ((CanvasView) AbstractSettingView.this.f673A.view).m973a(AbstractSettingView.this.f749b, 3);
                }
                if (AbstractSettingView.this.f771d != null) {
                    AbstractSettingView.this.f771d.onTextFontChanged(str);
                }
            }

            @Override // com.samsung.sdraw.TextSettingInfo.InterfaceC0986b
            /* renamed from: a */
            public void mo795a(Layout.Alignment alignment) {
                AbstractSettingView.this.m684F();
                if (AbstractSettingView.this.f673A != null) {
                    ((CanvasView) AbstractSettingView.this.f673A.view).m973a(AbstractSettingView.this.f749b, 4);
                }
                if (AbstractSettingView.this.f771d != null) {
                    AbstractSettingView.this.f771d.onTextAlignmentChanged(alignment);
                }
            }
        };
        this.f716aS = new FillingSettingInfo.InterfaceC0974b() { // from class: com.samsung.sdraw.AbstractSettingView.14
            @Override // com.samsung.sdraw.FillingSettingInfo.InterfaceC0974b
            /* renamed from: a */
            public void mo799a(int i) {
                AbstractSettingView.this.m685G();
                if (AbstractSettingView.this.f771d != null) {
                    AbstractSettingView.this.f771d.onFillingColorChanged(i);
                }
            }
        };
        this.f718aU = "Insert Text";
        this.f719aV = 0;
        this.f720aW = 0;
        this.f721aX = 0;
        this.f722aY = 0;
        this.f723aZ = true;
        this.f750ba = new View.OnClickListener() { // from class: com.samsung.sdraw.AbstractSettingView.15
            @Override // android.view.View.OnClickListener
            public void onClick(View v) throws Throwable {
                C1005ar c1005ar = new C1005ar();
                int penType = AbstractSettingView.this.f697a.getPenType();
                c1005ar.m1387d(penType);
                c1005ar.m1383b(AbstractSettingView.this.f697a.getPenWidth(penType));
                c1005ar.m1389e(AbstractSettingView.this.f697a.getPenColor(penType));
                c1005ar.m1385c(AbstractSettingView.this.f697a.getPenAlpha(penType));
                if (!AbstractSettingView.this.f731ai.m1044b(c1005ar)) {
                    AbstractSettingView.this.m700a(c1005ar, false);
                    AbstractSettingView.this.f731ai.m1040a(c1005ar);
                } else {
                    AbstractSettingView.this.m687I();
                }
                if (AbstractSettingView.this.f731ai.m1042b().size() >= 12 && AbstractSettingView.this.f737ao) {
                    Toast.makeText(AbstractSettingView.this.getContext(), String.format(AbstractSettingView.this.f780m, 12), 0).show();
                }
            }
        };
        this.f751bb = new PresetLinearLayout.OnClickPresetItemListener() { // from class: com.samsung.sdraw.AbstractSettingView.16
            @Override // com.samsung.sdraw.PresetLinearLayout.OnClickPresetItemListener
            public void selectPresetItem(int index) {
                if (index == -1) {
                    AbstractSettingView.this.m727e(AbstractSettingView.this.f761bl);
                } else {
                    AbstractSettingView.this.m727e(index);
                }
            }

            @Override // com.samsung.sdraw.PresetLinearLayout.OnClickPresetItemListener
            public void deletePresetItem(int index) {
                if (!AbstractSettingView.this.f766bq) {
                    AbstractSettingView.this.m730f(index);
                } else {
                    if (AbstractSettingView.this.f767br == null) {
                        return;
                    }
                    AbstractSettingView.this.f767br.onClick(index);
                }
            }
        };
        this.f787t = "Selected pen preset will be permanently erased";
        this.f788u = "Delete";
        this.f752bc = new PresetDataManager.NotifyListener() { // from class: com.samsung.sdraw.AbstractSettingView.17
            @Override // com.samsung.sdraw.PresetDataManager.NotifyListener
            public void dataChanged(int presetCount) {
                AbstractSettingView.this.m686H();
            }
        };
        this.f753bd = null;
        this.f790w = 10;
        this.f754be = new View.OnTouchListener() { // from class: com.samsung.sdraw.AbstractSettingView.18
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent event) {
                AbstractSettingView.this.f778k.onScroll(event, true);
                return true;
            }
        };
        this.f755bf = new View.OnTouchListener() { // from class: com.samsung.sdraw.AbstractSettingView.19
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent event) {
                AbstractSettingView.this.f778k.onScroll(event, false);
                return true;
            }
        };
        this.f756bg = new PenSettingScrollView.InterfaceC0978a() { // from class: com.samsung.sdraw.AbstractSettingView.20
            @Override // com.samsung.sdraw.PenSettingScrollView.InterfaceC0978a
            /* renamed from: a */
            public void mo801a(int i) {
                AbstractSettingView.this.f778k.moveScrollControlThumb(i, true);
            }
        };
        this.f757bh = new PenSettingScrollView.InterfaceC0978a() { // from class: com.samsung.sdraw.AbstractSettingView.21
            @Override // com.samsung.sdraw.PenSettingScrollView.InterfaceC0978a
            /* renamed from: a */
            public void mo801a(int i) {
                AbstractSettingView.this.f778k.moveScrollControlThumb(i, false);
            }
        };
        this.f758bi = new PalletView.InterfaceC0975a() { // from class: com.samsung.sdraw.AbstractSettingView.22
            @Override // com.samsung.sdraw.PalletView.InterfaceC0975a
            /* renamed from: a */
            public void mo802a(boolean z, int i, int i2, int i3, int i4) {
                AbstractSettingView.this.f778k.onLayout(false);
            }
        };
        this.f759bj = new PalletView.InterfaceC0975a() { // from class: com.samsung.sdraw.AbstractSettingView.24
            @Override // com.samsung.sdraw.PalletView.InterfaceC0975a
            /* renamed from: a */
            public void mo802a(boolean z, int i, int i2, int i3, int i4) {
                AbstractSettingView.this.f778k.onLayout(true);
            }
        };
        this.f760bk = false;
        this.f761bl = 0;
        this.f762bm = new PresetLinearLayout.InterfaceC0982a() { // from class: com.samsung.sdraw.AbstractSettingView.25
            @Override // com.samsung.sdraw.PresetLinearLayout.InterfaceC0982a
            /* renamed from: a */
            public void mo803a(int i, View view) {
                AbstractSettingView.this.f761bl = i;
            }
        };
        this.f764bo = false;
        this.f765bp = false;
        this.f766bq = false;
        this.f767br = null;
        this.f768bs = -1;
        this.f769bt = false;
        m769a();
    }

    public AbstractSettingView(Context context, HashMap<String, Integer> resourceIds) {
        super(context);
        this.f724aa = false;
        this.f725ab = false;
        this.f726ac = false;
        this.f727ad = false;
        this.f729ag = false;
        this.f772e = "";
        this.f773f = new ArrayList<>();
        this.f774g = new ArrayList<>();
        this.f775h = new ArrayList<>();
        this.f776i = new HashMap<>();
        this.f777j = new HashMap<>();
        this.f730ah = new int[]{0, 1, 3, 4, 6, 2};
        this.f779l = "Already exists same pen setting";
        this.f780m = "Maximum number of Preset pens(%d) reached";
        this.f736an = false;
        this.f737ao = true;
        this.f742at = HttpUtil.VAL_CLOSE;
        this.f743au = "Pen type %s, thickness %d percent, transparency %d percent";
        this.f744av = "DropperView Color";
        this.f745aw = null;
        this.f746ax = new AdapterView.OnItemSelectedListener() { // from class: com.samsung.sdraw.AbstractSettingView.1
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                int i = 0;
                String str = (String) AbstractSettingView.this.f728ae.getSelectedItem();
                AbstractSettingView.this.f728ae.setContentDescription(String.format(AbstractSettingView.this.f784q.f1651s, str));
                while (true) {
                    int i2 = i;
                    if (i2 < AbstractSettingView.this.f774g.size()) {
                        if (AbstractSettingView.this.f774g.get(i2).equalsIgnoreCase(str)) {
                            AbstractSettingView.this.m704a(AbstractSettingView.this.f773f.get(i2));
                        }
                        i = i2 + 1;
                    } else {
                        return;
                    }
                }
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        };
        this.f747ay = new View.OnClickListener() { // from class: com.samsung.sdraw.AbstractSettingView.12
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (!v.isSelected()) {
                    if (AbstractSettingView.this.f793z != null) {
                        AbstractSettingView.this.f793z.m977b(AbstractSettingView.this.f697a);
                    }
                    AbstractSettingView.this.m691a(v);
                    if (AbstractSettingView.this.f793z != null) {
                        AbstractSettingView.this.f793z.m972a(AbstractSettingView.this.f697a);
                    }
                    AbstractSettingView.this.f778k.moveScrollControlThumb(AbstractSettingView.this.f782o.f1695aj.getScrollY(), true);
                }
            }
        };
        this.f748az = new View.OnClickListener() { // from class: com.samsung.sdraw.AbstractSettingView.23
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                AbstractSettingView.this.m708b(v);
            }
        };
        this.f698aA = new View.OnClickListener() { // from class: com.samsung.sdraw.AbstractSettingView.28
            @Override // android.view.View.OnClickListener
            public void onClick(View v) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                if (AbstractSettingView.this.f793z != null) {
                    AbstractSettingView.this.f793z.m970a(v);
                }
                if (!v.equals(AbstractSettingView.this.f688P)) {
                    if (!v.equals(AbstractSettingView.this.f689Q)) {
                        if (!v.equals(AbstractSettingView.this.f690R)) {
                            if (v.equals(AbstractSettingView.this.f691S)) {
                                AbstractSettingView.this.m788i().setVisibility(4);
                                if (AbstractSettingView.this.f717aT == null) {
                                    return;
                                }
                                AbstractSettingView.this.f717aT.mo809d(false);
                                return;
                            }
                            return;
                        }
                        AbstractSettingView.this.m787h().setVisibility(4);
                        if (AbstractSettingView.this.f717aT == null) {
                            return;
                        }
                        AbstractSettingView.this.f717aT.mo808c(false);
                        return;
                    }
                    AbstractSettingView.this.m789j().setVisibility(4);
                    if (AbstractSettingView.this.f717aT == null) {
                        return;
                    }
                    AbstractSettingView.this.f717aT.mo807b(false);
                    return;
                }
                AbstractSettingView.this.m786g().setVisibility(4);
                if (AbstractSettingView.this.f717aT == null) {
                    return;
                }
                AbstractSettingView.this.f717aT.mo806a(false);
            }
        };
        this.f699aB = new SeekBar.OnSeekBarChangeListener() { // from class: com.samsung.sdraw.AbstractSettingView.29
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (AbstractSettingView.this.f692T != null) {
                    AbstractSettingView.this.f692T.onPenWidthChanged(AbstractSettingView.this.f697a.getPenWidth());
                }
                if (AbstractSettingView.this.f771d != null) {
                    AbstractSettingView.this.f771d.onPenWidthChanged(AbstractSettingView.this.f697a.getPenWidth());
                }
                if (AbstractSettingView.this.f793z != null) {
                    AbstractSettingView.this.f793z.m977b(AbstractSettingView.this.f697a);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int progress2 = progress + 1;
                if (AbstractSettingView.this.f674B != null) {
                    AbstractSettingView.this.f674B.setPenWidth(progress2);
                    if (AbstractSettingView.this.f782o != null) {
                        AbstractSettingView.this.f674B.setDescription(AbstractSettingView.this.f782o.f1494h, AbstractSettingView.this.f782o.f1495i, AbstractSettingView.this.f782o.f1496j, AbstractSettingView.this.f782o.f1497k, AbstractSettingView.this.f782o.f1498l, AbstractSettingView.this.f782o.f1499m);
                    }
                }
                if (AbstractSettingView.this.f697a != null) {
                    AbstractSettingView.this.f697a.setPenWidth(progress2);
                    if (AbstractSettingView.this.f782o != null) {
                        AbstractSettingView.this.f782o.mo1308a(AbstractSettingView.this.f697a.getPenType(), AbstractSettingView.this.f697a.getPenColor(), AbstractSettingView.this.f697a.getPenAlpha(), AbstractSettingView.this.f697a.getPenWidth());
                        int max = (progress2 * 100) / AbstractSettingView.this.f678F.getMax();
                        if (max > 100) {
                            max = 100;
                        }
                        AbstractSettingView.this.f678F.setContentDescription(String.format(AbstractSettingView.this.f782o.f1490d, Integer.valueOf(max)));
                    }
                    if (AbstractSettingView.this.f673A != null && AbstractSettingView.this.f673A.stage != null) {
                        AbstractSettingView.this.f673A.setting.setStrokeWidth(AbstractSettingView.this.f697a.getPenWidth());
                    }
                }
            }
        };
        this.f700aC = new SeekBar.OnSeekBarChangeListener() { // from class: com.samsung.sdraw.AbstractSettingView.30
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (AbstractSettingView.this.f692T != null) {
                    AbstractSettingView.this.f692T.onPenAlphaChanged(AbstractSettingView.this.f697a.getPenAlpha());
                }
                if (AbstractSettingView.this.f771d != null) {
                    AbstractSettingView.this.f771d.onPenAlphaChanged(AbstractSettingView.this.f697a.getPenAlpha());
                }
                if (AbstractSettingView.this.f793z != null) {
                    AbstractSettingView.this.f793z.m977b(AbstractSettingView.this.f697a);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (AbstractSettingView.this.f674B != null) {
                    AbstractSettingView.this.f674B.setPenAlpha(progress);
                    if (AbstractSettingView.this.f782o != null) {
                        AbstractSettingView.this.f674B.setDescription(AbstractSettingView.this.f782o.f1494h, AbstractSettingView.this.f782o.f1495i, AbstractSettingView.this.f782o.f1496j, AbstractSettingView.this.f782o.f1497k, AbstractSettingView.this.f782o.f1498l, AbstractSettingView.this.f782o.f1499m);
                    }
                }
                if (AbstractSettingView.this.f697a != null) {
                    AbstractSettingView.this.f697a.setPenAlpha(progress);
                    if (AbstractSettingView.this.f782o != null) {
                        AbstractSettingView.this.f782o.mo1308a(AbstractSettingView.this.f697a.getPenType(), AbstractSettingView.this.f697a.getPenColor(), AbstractSettingView.this.f697a.getPenAlpha(), AbstractSettingView.this.f697a.getPenWidth());
                        int max = (progress * 100) / AbstractSettingView.this.f679G.getMax();
                        if (max > 100) {
                            max = 100;
                        }
                        AbstractSettingView.this.f679G.setContentDescription(String.format(AbstractSettingView.this.f782o.f1491e, Integer.valueOf(max)));
                    }
                    if (AbstractSettingView.this.f673A != null && AbstractSettingView.this.f673A.setting != null) {
                        AbstractSettingView.this.f673A.setting.setStrokeColor(AbstractSettingView.this.f697a.getPenAlphaColor());
                    }
                    if (AbstractSettingView.this.f782o != null && AbstractSettingView.this.f782o.f1455F != null) {
                        AbstractSettingView.this.f782o.f1455F.setColor(AbstractSettingView.this.f697a.getPenAlphaColor());
                    }
                }
            }
        };
        this.f701aD = new SeekBar.OnSeekBarChangeListener() { // from class: com.samsung.sdraw.AbstractSettingView.31
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (AbstractSettingView.this.f692T != null) {
                    AbstractSettingView.this.f692T.onEraserWidthChanged(AbstractSettingView.this.f697a.getEraserWidth());
                }
                if (AbstractSettingView.this.f771d != null) {
                    AbstractSettingView.this.f771d.onEraserWidthChanged(AbstractSettingView.this.f697a.getEraserWidth());
                }
                if (AbstractSettingView.this.f793z != null && AbstractSettingView.this.f793z.f881a != null) {
                    AbstractSettingView.this.f793z.f881a.setEraserWidth(AbstractSettingView.this.f697a.getEraserWidth());
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (AbstractSettingView.this.f697a != null) {
                    AbstractSettingView.this.f697a.setEraserWidth(progress);
                    if (AbstractSettingView.this.f673A != null && AbstractSettingView.this.f673A.setting != null && AbstractSettingView.this.f673A.setting.getStrokeType() == StrokeSprite.Type.Eraser) {
                        AbstractSettingView.this.f673A.setting.setEraserWidth(AbstractSettingView.this.f697a.getEraserWidth());
                    }
                    if (AbstractSettingView.this.f783p != null) {
                        AbstractSettingView.this.f783p.mo1569a(progress);
                        int max = (progress * 100) / AbstractSettingView.this.f686N.getMax();
                        AbstractSettingView.this.f686N.setContentDescription(String.format(AbstractSettingView.this.f783p.f1757d, Integer.valueOf(max <= 100 ? max : 100)));
                    }
                }
            }
        };
        this.f702aE = new AdapterView.OnItemSelectedListener() { // from class: com.samsung.sdraw.AbstractSettingView.32
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                Object selectedItem;
                int i = 0;
                int i2 = 0;
                while (true) {
                    if (i2 >= AbstractSettingView.this.f775h.size()) {
                        break;
                    }
                    if (((Spinner) AbstractSettingView.this.f677E[0]) == null || (selectedItem = ((Spinner) AbstractSettingView.this.f677E[0]).getSelectedItem()) == null || !selectedItem.equals(AbstractSettingView.this.f775h.get(i2))) {
                        i2++;
                    } else {
                        int i3 = i2 + 5;
                        if (AbstractSettingView.this.f784q != null) {
                            ((Spinner) AbstractSettingView.this.f677E[0]).setContentDescription(String.format(AbstractSettingView.this.f784q.f1652t, Integer.valueOf(i3)));
                            i = i3;
                        } else {
                            i = i3;
                        }
                    }
                }
                if (AbstractSettingView.this.f675C != null) {
                    AbstractSettingView.this.f675C.m1439b(i);
                    if (AbstractSettingView.this.f784q != null) {
                        AbstractSettingView.this.f675C.m1437a(AbstractSettingView.this.f784q.f1649q, (String) AbstractSettingView.this.f728ae.getSelectedItem());
                    }
                }
                if (AbstractSettingView.this.f749b != null) {
                    AbstractSettingView.this.f749b.setTextSize(i);
                    if (AbstractSettingView.this.f784q != null) {
                        AbstractSettingView.this.f784q.mo1464a(AbstractSettingView.this.f749b.getTextType(), AbstractSettingView.this.f749b.getTextColor(), AbstractSettingView.this.f749b.getTextSize());
                    }
                    if (AbstractSettingView.this.f673A != null && AbstractSettingView.this.f673A.stage != null) {
                        AbstractSettingView.this.f673A.setting.setTextSize(AbstractSettingView.this.f749b.getTextSize());
                    }
                }
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        };
        this.f703aF = new C1050f.a() { // from class: com.samsung.sdraw.AbstractSettingView.33
            @Override // com.samsung.sdraw.C1050f.a
            /* renamed from: a */
            public void mo800a(int i, int i2, int i3) {
                if (AbstractSettingView.this.f749b != null) {
                    AbstractSettingView.this.f749b.m1184a(i2, i3);
                    AbstractSettingView.this.f749b.setTextColor(i);
                    if (AbstractSettingView.this.f675C != null) {
                        AbstractSettingView.this.f675C.m1440c(i);
                    }
                    if (AbstractSettingView.this.f682J != null) {
                        AbstractSettingView.this.f682J.m1552a(i);
                    }
                    if (AbstractSettingView.this.f784q != null) {
                        if (AbstractSettingView.this.f784q.f1613I != null) {
                            AbstractSettingView.this.f784q.f1613I.setColor((-16777216) | (16777215 & i));
                        }
                        AbstractSettingView.this.f784q.mo1464a(AbstractSettingView.this.f749b.getTextType(), AbstractSettingView.this.f749b.getTextColor(), AbstractSettingView.this.f749b.getTextSize());
                    }
                    if (AbstractSettingView.this.f673A != null && AbstractSettingView.this.f673A.setting != null) {
                        AbstractSettingView.this.f673A.setting.setTextColor(AbstractSettingView.this.f749b.getTextColor());
                    }
                }
            }
        };
        this.f704aG = new C1050f.a() { // from class: com.samsung.sdraw.AbstractSettingView.2
            @Override // com.samsung.sdraw.C1050f.a
            /* renamed from: a */
            public void mo800a(int i, int i2, int i3) {
                if (AbstractSettingView.this.f770c != null) {
                    AbstractSettingView.this.f770c.m996a(i2, i3);
                    AbstractSettingView.this.f770c.m995a((-33554432) | (16777215 & i));
                    AbstractSettingView.this.f770c.setFillingColor(i);
                    if (AbstractSettingView.this.f684L != null) {
                        AbstractSettingView.this.f684L.m1552a(i);
                    }
                    if (AbstractSettingView.this.f673A != null && AbstractSettingView.this.f673A.setting != null) {
                        AbstractSettingView.this.f673A.setting.setFillingColor(AbstractSettingView.this.f770c.getFillingColor());
                    }
                    if (AbstractSettingView.this.f771d != null) {
                        AbstractSettingView.this.f771d.onFillingColorChanged(AbstractSettingView.this.f770c.getFillingColor());
                    }
                }
            }
        };
        this.f705aH = new C1051g.a() { // from class: com.samsung.sdraw.AbstractSettingView.3
            @Override // com.samsung.sdraw.C1051g.a
            /* renamed from: a */
            public void mo804a(int i, int i2, boolean z) {
                if ((i2 == AbstractSettingView.this.f682J.m1555b() - 1 || i2 == -1) && AbstractSettingView.this.f784q != null && AbstractSettingView.this.f784q.f1612H.getVisibility() == 8) {
                    AbstractSettingView.this.f784q.m1491b(true);
                    if (!z) {
                        return;
                    }
                }
                if (AbstractSettingView.this.f749b != null) {
                    if (AbstractSettingView.this.f675C != null) {
                        AbstractSettingView.this.f675C.m1440c(i);
                    }
                    if (AbstractSettingView.this.f784q != null) {
                        if (AbstractSettingView.this.f784q.f1613I != null) {
                            AbstractSettingView.this.f784q.f1613I.setColor((-16777216) | (16777215 & i));
                        }
                        AbstractSettingView.this.f784q.mo1464a(AbstractSettingView.this.f749b.getTextType(), i, AbstractSettingView.this.f749b.getTextSize());
                    }
                    AbstractSettingView.this.f749b.setTextColor(i);
                    if (AbstractSettingView.this.f673A != null && AbstractSettingView.this.f673A.setting != null) {
                        AbstractSettingView.this.f673A.setting.setTextColor(AbstractSettingView.this.f749b.getTextColor());
                    }
                }
            }
        };
        this.f706aI = new C1051g.a() { // from class: com.samsung.sdraw.AbstractSettingView.4
            @Override // com.samsung.sdraw.C1051g.a
            /* renamed from: a */
            public void mo804a(int i, int i2, boolean z) {
                if ((i2 == AbstractSettingView.this.f684L.m1555b() - 1 || i2 == -1) && AbstractSettingView.this.f785r.f1792j.getVisibility() == 8) {
                    AbstractSettingView.this.setPalletViewState(true, 4);
                    if (!z) {
                        return;
                    }
                }
                if (AbstractSettingView.this.f770c != null) {
                    if (AbstractSettingView.this.f673A != null && AbstractSettingView.this.f673A.setting != null) {
                        AbstractSettingView.this.f673A.setting.setFillingColor(AbstractSettingView.this.f770c.getFillingColor());
                    }
                    if (i == AbstractSettingView.this.f684L.m1556c()) {
                        AbstractSettingView.this.f770c.m995a((-33554432) | (16777215 & i));
                    } else {
                        AbstractSettingView.this.f770c.m995a((-16777216) | (16777215 & i));
                    }
                    AbstractSettingView.this.f770c.setFillingColor(i);
                    if (AbstractSettingView.this.f771d != null) {
                        AbstractSettingView.this.f771d.onFillingColorChanged(AbstractSettingView.this.f770c.getFillingColor());
                    }
                }
            }
        };
        this.f707aJ = new C1050f.a() { // from class: com.samsung.sdraw.AbstractSettingView.5
            @Override // com.samsung.sdraw.C1050f.a
            /* renamed from: a */
            public void mo800a(int i, int i2, int i3) {
                if (AbstractSettingView.this.f697a != null) {
                    AbstractSettingView.this.f697a.m1022a(i2, i3);
                    AbstractSettingView.this.f697a.m1025b((-33554432) | (16777215 & i));
                    AbstractSettingView.this.f697a.setPenColor(i);
                    if (AbstractSettingView.this.f674B != null) {
                        AbstractSettingView.this.f674B.setPenColor(i);
                    }
                    if (AbstractSettingView.this.f680H != null) {
                        AbstractSettingView.this.f680H.m1552a(AbstractSettingView.this.f697a.m1021a());
                    }
                    if (AbstractSettingView.this.f782o != null) {
                        if (AbstractSettingView.this.f782o.f1454E != null) {
                            AbstractSettingView.this.f782o.f1454E.setColor((i & 16777215) | (-16777216));
                        }
                        if (AbstractSettingView.this.f782o.f1455F != null) {
                            AbstractSettingView.this.f782o.f1455F.setColor(AbstractSettingView.this.f697a.getPenAlphaColor());
                        }
                        AbstractSettingView.this.f782o.mo1308a(AbstractSettingView.this.f697a.getPenType(), AbstractSettingView.this.f697a.getPenColor(), AbstractSettingView.this.f697a.getPenAlpha(), AbstractSettingView.this.f697a.getPenWidth());
                    }
                    if (AbstractSettingView.this.f673A != null && AbstractSettingView.this.f673A.setting != null) {
                        AbstractSettingView.this.f673A.setting.setStrokeColor(AbstractSettingView.this.f697a.getPenAlphaColor());
                    }
                    if (AbstractSettingView.this.f692T != null) {
                        AbstractSettingView.this.f692T.onColorChanged(((AbstractSettingView.this.f697a.getPenAlpha() << 24) & (-16777216)) | AbstractSettingView.this.f697a.getPenColor());
                    }
                    if (AbstractSettingView.this.f771d != null) {
                        AbstractSettingView.this.f771d.onPenColorChanged(((AbstractSettingView.this.f697a.getPenAlpha() << 24) & (-16777216)) | AbstractSettingView.this.f697a.getPenColor());
                    }
                    if (AbstractSettingView.this.f793z != null) {
                        AbstractSettingView.this.f793z.m977b(AbstractSettingView.this.f697a);
                    }
                }
            }
        };
        this.f708aK = new C1051g.a() { // from class: com.samsung.sdraw.AbstractSettingView.6
            @Override // com.samsung.sdraw.C1051g.a
            /* renamed from: a */
            public void mo804a(int i, int i2, boolean z) {
                if ((i2 == AbstractSettingView.this.f680H.m1555b() - 1 || i2 == -1) && AbstractSettingView.this.f782o != null && AbstractSettingView.this.f782o.f1453D.getVisibility() == 8) {
                    AbstractSettingView.this.setPalletViewState(true, 1);
                    AbstractSettingView.this.f778k.relayoutSettingView(AbstractSettingView.this.getContext().getResources().getDisplayMetrics().widthPixels < AbstractSettingView.this.getResources().getDisplayMetrics().heightPixels, false);
                    AbstractSettingView.this.f778k.setScrollToMax();
                    if (!z) {
                        return;
                    }
                }
                if (AbstractSettingView.this.f697a != null) {
                    if (AbstractSettingView.this.f674B != null) {
                        AbstractSettingView.this.f674B.setPenColor(i);
                    }
                    if (AbstractSettingView.this.f782o != null) {
                        if (AbstractSettingView.this.f782o.f1454E != null) {
                            AbstractSettingView.this.f782o.f1454E.setColor((i & 16777215) | (-16777216));
                        }
                        if (AbstractSettingView.this.f782o.f1455F != null) {
                            AbstractSettingView.this.f782o.f1455F.setColor(AbstractSettingView.this.f697a.getPenAlphaColor());
                        }
                        AbstractSettingView.this.f782o.mo1308a(AbstractSettingView.this.f697a.getPenType(), i, AbstractSettingView.this.f697a.getPenAlpha(), AbstractSettingView.this.f697a.getPenWidth());
                    }
                    if (i == AbstractSettingView.this.f680H.m1556c()) {
                        AbstractSettingView.this.f697a.m1025b((-33554432) | (16777215 & i));
                    } else {
                        AbstractSettingView.this.f697a.m1025b((16777215 & i) | (-16777216));
                    }
                    AbstractSettingView.this.f697a.setPenColor(i);
                    if (AbstractSettingView.this.f673A != null && AbstractSettingView.this.f673A.setting != null) {
                        AbstractSettingView.this.f673A.setting.setStrokeColor(AbstractSettingView.this.f697a.getPenAlphaColor());
                    }
                    if (AbstractSettingView.this.f782o != null && AbstractSettingView.this.f782o.f1455F != null) {
                        AbstractSettingView.this.f782o.f1455F.setColor(AbstractSettingView.this.f697a.getPenAlphaColor());
                    }
                    if (AbstractSettingView.this.f692T != null) {
                        AbstractSettingView.this.f692T.onColorChanged(((AbstractSettingView.this.f697a.getPenAlpha() << 24) & (-16777216)) | AbstractSettingView.this.f697a.getPenColor());
                    }
                    if (AbstractSettingView.this.f771d != null) {
                        AbstractSettingView.this.f771d.onPenColorChanged(((AbstractSettingView.this.f697a.getPenAlpha() << 24) & (-16777216)) | AbstractSettingView.this.f697a.getPenColor());
                    }
                    if (AbstractSettingView.this.f793z != null) {
                        AbstractSettingView.this.f793z.m977b(AbstractSettingView.this.f697a);
                    }
                }
            }
        };
        this.f709aL = new View.OnClickListener() { // from class: com.samsung.sdraw.AbstractSettingView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                boolean zOnDeleteAllConfirm = false;
                zOnDeleteAllConfirm = false;
                if (AbstractSettingView.this.f673A == null) {
                    return;
                }
                if (AbstractSettingView.this.f753bd != null && AbstractSettingView.this.f673A.stage != null) {
                    zOnDeleteAllConfirm = AbstractSettingView.this.f753bd.onDeleteAllConfirm(AbstractSettingView.this.f673A.stage.getSelectedLayerID() == 3 ? 1 : 0);
                }
                if (!zOnDeleteAllConfirm && AbstractSettingView.this.f673A.setting != null && AbstractSettingView.this.f723aZ) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                    if (AbstractSettingView.this.f776i.containsKey(SCanvasConstants.LAYOUT_ERASER_DELETEALL_POPUP_ICON)) {
                        if (AbstractSettingView.this.f776i.get(SCanvasConstants.LAYOUT_ERASER_DELETEALL_POPUP_ICON).intValue() != -1) {
                            builder.setIcon(AbstractSettingView.this.f776i.get(SCanvasConstants.LAYOUT_ERASER_DELETEALL_POPUP_ICON).intValue());
                        }
                    } else {
                        builder.setIcon(R.drawable.ic_dialog_alert);
                    }
                    if (AbstractSettingView.this.f776i.containsKey(SCanvasConstants.LOCALE_ERASER_SETTING_CLEARALL)) {
                        builder.setTitle(AbstractSettingView.this.f776i.get(SCanvasConstants.LOCALE_ERASER_SETTING_CLEARALL).intValue());
                    } else if (AbstractSettingView.this.f776i.containsKey(SCanvasConstants.LOCALE_ERASER_SETTING_DELETEALL)) {
                        builder.setTitle(AbstractSettingView.this.f776i.get(SCanvasConstants.LOCALE_ERASER_SETTING_DELETEALL).intValue());
                    } else {
                        builder.setTitle("Delete all");
                    }
                    if (AbstractSettingView.this.f776i.containsKey(SCanvasConstants.LOCALE_ERASER_SETTING_CLEARALL_MESSAGE)) {
                        builder.setMessage(AbstractSettingView.this.f776i.get(SCanvasConstants.LOCALE_ERASER_SETTING_CLEARALL_MESSAGE).intValue());
                    } else if (AbstractSettingView.this.f776i.containsKey(SCanvasConstants.LOCALE_ERASER_SETTING_DELETEALL_MESSAGE)) {
                        builder.setMessage(AbstractSettingView.this.f776i.get(SCanvasConstants.LOCALE_ERASER_SETTING_DELETEALL_MESSAGE).intValue());
                    } else {
                        builder.setMessage("All data will be deleted");
                    }
                    builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() { // from class: com.samsung.sdraw.AbstractSettingView.7.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface arg0, int arg1) {
                            if (AbstractSettingView.this.f771d != null) {
                                AbstractSettingView.this.f771d.onClearAll(false);
                                AbstractSettingView.this.f771d.onDeleteAll(false);
                            }
                            if (AbstractSettingView.this.f673A != null) {
                                ((CanvasView) AbstractSettingView.this.f673A.view).deleteAll(true);
                            }
                            if (AbstractSettingView.this.f692T != null) {
                                AbstractSettingView.this.f692T.onClearAll();
                            }
                            if (AbstractSettingView.this.f771d != null) {
                                AbstractSettingView.this.f771d.onClearAll(true);
                                AbstractSettingView.this.f771d.onDeleteAll(true);
                            }
                        }
                    });
                    builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() { // from class: com.samsung.sdraw.AbstractSettingView.7.2
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface arg0, int arg1) {
                        }
                    });
                    builder.setCancelable(true);
                    builder.create().show();
                }
            }
        };
        this.f710aM = new View.OnClickListener() { // from class: com.samsung.sdraw.AbstractSettingView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (AbstractSettingView.this.f782o != null && AbstractSettingView.this.f782o.f1453D != null) {
                    if (AbstractSettingView.this.f782o.f1453D.getVisibility() == 8) {
                        AbstractSettingView.this.setPalletViewState(true, 1);
                        v.setSelected(false);
                        AbstractSettingView.this.f778k.setScrollToMax();
                    } else {
                        AbstractSettingView.this.setPalletViewState(false, 1);
                        v.setSelected(true);
                    }
                }
                if (AbstractSettingView.this.f785r != null && AbstractSettingView.this.f785r.f1792j != null) {
                    if (AbstractSettingView.this.f785r.f1792j.getVisibility() == 8) {
                        AbstractSettingView.this.setPalletViewState(true, 4);
                        v.setSelected(false);
                    } else {
                        AbstractSettingView.this.setPalletViewState(false, 4);
                        v.setSelected(true);
                    }
                }
            }
        };
        this.f711aN = new View.OnFocusChangeListener() { // from class: com.samsung.sdraw.AbstractSettingView.9
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View arg0, boolean arg1) {
                if (arg0.equals(AbstractSettingView.this.f784q.f1616L) && arg1) {
                    AbstractSettingView.this.f784q.f1616L.setSelected(true);
                    AbstractSettingView.this.f784q.f1617M.setSelected(false);
                    AbstractSettingView.this.f784q.mo1463a(0);
                } else if (arg0.equals(AbstractSettingView.this.f784q.f1617M) && arg1) {
                    AbstractSettingView.this.f784q.f1616L.setSelected(false);
                    AbstractSettingView.this.f784q.f1617M.setSelected(true);
                    AbstractSettingView.this.f784q.mo1463a(1);
                }
                AbstractSettingView.this.m770a(3, true);
            }
        };
        this.f712aO = new View.OnClickListener() { // from class: com.samsung.sdraw.AbstractSettingView.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (v.equals(AbstractSettingView.this.f784q.f1616L)) {
                    AbstractSettingView.this.f784q.f1616L.setSelected(true);
                    AbstractSettingView.this.f784q.f1617M.setSelected(false);
                    AbstractSettingView.this.f784q.mo1463a(0);
                } else if (v.equals(AbstractSettingView.this.f784q.f1617M)) {
                    AbstractSettingView.this.f784q.f1616L.setSelected(false);
                    AbstractSettingView.this.f784q.f1617M.setSelected(true);
                    AbstractSettingView.this.f784q.mo1463a(1);
                }
                AbstractSettingView.this.m770a(3, true);
            }
        };
        this.f713aP = new View.OnClickListener() { // from class: com.samsung.sdraw.AbstractSettingView.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (AbstractSettingView.this.f784q != null && AbstractSettingView.this.f784q.f1608D != null && AbstractSettingView.this.f784q.f1609E != null && AbstractSettingView.this.f784q.f1610F != null) {
                    if (v.equals(AbstractSettingView.this.f784q.f1608D)) {
                        AbstractSettingView.this.f784q.f1608D.setSelected(true);
                        AbstractSettingView.this.f784q.f1609E.setSelected(false);
                        AbstractSettingView.this.f784q.f1610F.setSelected(false);
                        AbstractSettingView.this.f749b.setTextAlignment(Layout.Alignment.ALIGN_NORMAL);
                        return;
                    }
                    if (v.equals(AbstractSettingView.this.f784q.f1609E)) {
                        AbstractSettingView.this.f784q.f1608D.setSelected(false);
                        AbstractSettingView.this.f784q.f1609E.setSelected(true);
                        AbstractSettingView.this.f784q.f1610F.setSelected(false);
                        AbstractSettingView.this.f749b.setTextAlignment(Layout.Alignment.ALIGN_CENTER);
                        return;
                    }
                    if (v.equals(AbstractSettingView.this.f784q.f1610F)) {
                        AbstractSettingView.this.f784q.f1608D.setSelected(false);
                        AbstractSettingView.this.f784q.f1609E.setSelected(false);
                        AbstractSettingView.this.f784q.f1610F.setSelected(true);
                        AbstractSettingView.this.f749b.setTextAlignment(Layout.Alignment.ALIGN_OPPOSITE);
                    }
                }
            }
        };
        this.f715aR = new TextSettingInfo.InterfaceC0986b() { // from class: com.samsung.sdraw.AbstractSettingView.13
            @Override // com.samsung.sdraw.TextSettingInfo.InterfaceC0986b
            /* renamed from: a */
            public void mo794a(int i) {
                AbstractSettingView.this.m684F();
                if (AbstractSettingView.this.f673A != null) {
                    ((CanvasView) AbstractSettingView.this.f673A.view).m973a(AbstractSettingView.this.f749b, 0);
                }
                if (AbstractSettingView.this.f771d != null) {
                    AbstractSettingView.this.f771d.onTextTypeChanged(i);
                }
            }

            @Override // com.samsung.sdraw.TextSettingInfo.InterfaceC0986b
            /* renamed from: b */
            public void mo797b(int i) {
                AbstractSettingView.this.m684F();
                if (AbstractSettingView.this.f673A != null) {
                    ((CanvasView) AbstractSettingView.this.f673A.view).m973a(AbstractSettingView.this.f749b, 1);
                }
                if (AbstractSettingView.this.f682J != null) {
                    AbstractSettingView.this.f682J.m1552a(i);
                }
                if (AbstractSettingView.this.f771d != null) {
                    AbstractSettingView.this.f771d.onTextColorChanged(i);
                }
            }

            @Override // com.samsung.sdraw.TextSettingInfo.InterfaceC0986b
            /* renamed from: c */
            public void mo798c(int i) {
                AbstractSettingView.this.m684F();
                if (AbstractSettingView.this.f673A != null) {
                    ((CanvasView) AbstractSettingView.this.f673A.view).m973a(AbstractSettingView.this.f749b, 2);
                }
                if (AbstractSettingView.this.f771d != null) {
                    AbstractSettingView.this.f771d.onTextSizeChanged(i);
                }
            }

            @Override // com.samsung.sdraw.TextSettingInfo.InterfaceC0986b
            /* renamed from: a */
            public void mo796a(String str) {
                AbstractSettingView.this.m684F();
                if (AbstractSettingView.this.f673A != null) {
                    ((CanvasView) AbstractSettingView.this.f673A.view).m973a(AbstractSettingView.this.f749b, 3);
                }
                if (AbstractSettingView.this.f771d != null) {
                    AbstractSettingView.this.f771d.onTextFontChanged(str);
                }
            }

            @Override // com.samsung.sdraw.TextSettingInfo.InterfaceC0986b
            /* renamed from: a */
            public void mo795a(Layout.Alignment alignment) {
                AbstractSettingView.this.m684F();
                if (AbstractSettingView.this.f673A != null) {
                    ((CanvasView) AbstractSettingView.this.f673A.view).m973a(AbstractSettingView.this.f749b, 4);
                }
                if (AbstractSettingView.this.f771d != null) {
                    AbstractSettingView.this.f771d.onTextAlignmentChanged(alignment);
                }
            }
        };
        this.f716aS = new FillingSettingInfo.InterfaceC0974b() { // from class: com.samsung.sdraw.AbstractSettingView.14
            @Override // com.samsung.sdraw.FillingSettingInfo.InterfaceC0974b
            /* renamed from: a */
            public void mo799a(int i) {
                AbstractSettingView.this.m685G();
                if (AbstractSettingView.this.f771d != null) {
                    AbstractSettingView.this.f771d.onFillingColorChanged(i);
                }
            }
        };
        this.f718aU = "Insert Text";
        this.f719aV = 0;
        this.f720aW = 0;
        this.f721aX = 0;
        this.f722aY = 0;
        this.f723aZ = true;
        this.f750ba = new View.OnClickListener() { // from class: com.samsung.sdraw.AbstractSettingView.15
            @Override // android.view.View.OnClickListener
            public void onClick(View v) throws Throwable {
                C1005ar c1005ar = new C1005ar();
                int penType = AbstractSettingView.this.f697a.getPenType();
                c1005ar.m1387d(penType);
                c1005ar.m1383b(AbstractSettingView.this.f697a.getPenWidth(penType));
                c1005ar.m1389e(AbstractSettingView.this.f697a.getPenColor(penType));
                c1005ar.m1385c(AbstractSettingView.this.f697a.getPenAlpha(penType));
                if (!AbstractSettingView.this.f731ai.m1044b(c1005ar)) {
                    AbstractSettingView.this.m700a(c1005ar, false);
                    AbstractSettingView.this.f731ai.m1040a(c1005ar);
                } else {
                    AbstractSettingView.this.m687I();
                }
                if (AbstractSettingView.this.f731ai.m1042b().size() >= 12 && AbstractSettingView.this.f737ao) {
                    Toast.makeText(AbstractSettingView.this.getContext(), String.format(AbstractSettingView.this.f780m, 12), 0).show();
                }
            }
        };
        this.f751bb = new PresetLinearLayout.OnClickPresetItemListener() { // from class: com.samsung.sdraw.AbstractSettingView.16
            @Override // com.samsung.sdraw.PresetLinearLayout.OnClickPresetItemListener
            public void selectPresetItem(int index) {
                if (index == -1) {
                    AbstractSettingView.this.m727e(AbstractSettingView.this.f761bl);
                } else {
                    AbstractSettingView.this.m727e(index);
                }
            }

            @Override // com.samsung.sdraw.PresetLinearLayout.OnClickPresetItemListener
            public void deletePresetItem(int index) {
                if (!AbstractSettingView.this.f766bq) {
                    AbstractSettingView.this.m730f(index);
                } else {
                    if (AbstractSettingView.this.f767br == null) {
                        return;
                    }
                    AbstractSettingView.this.f767br.onClick(index);
                }
            }
        };
        this.f787t = "Selected pen preset will be permanently erased";
        this.f788u = "Delete";
        this.f752bc = new PresetDataManager.NotifyListener() { // from class: com.samsung.sdraw.AbstractSettingView.17
            @Override // com.samsung.sdraw.PresetDataManager.NotifyListener
            public void dataChanged(int presetCount) {
                AbstractSettingView.this.m686H();
            }
        };
        this.f753bd = null;
        this.f790w = 10;
        this.f754be = new View.OnTouchListener() { // from class: com.samsung.sdraw.AbstractSettingView.18
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent event) {
                AbstractSettingView.this.f778k.onScroll(event, true);
                return true;
            }
        };
        this.f755bf = new View.OnTouchListener() { // from class: com.samsung.sdraw.AbstractSettingView.19
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent event) {
                AbstractSettingView.this.f778k.onScroll(event, false);
                return true;
            }
        };
        this.f756bg = new PenSettingScrollView.InterfaceC0978a() { // from class: com.samsung.sdraw.AbstractSettingView.20
            @Override // com.samsung.sdraw.PenSettingScrollView.InterfaceC0978a
            /* renamed from: a */
            public void mo801a(int i) {
                AbstractSettingView.this.f778k.moveScrollControlThumb(i, true);
            }
        };
        this.f757bh = new PenSettingScrollView.InterfaceC0978a() { // from class: com.samsung.sdraw.AbstractSettingView.21
            @Override // com.samsung.sdraw.PenSettingScrollView.InterfaceC0978a
            /* renamed from: a */
            public void mo801a(int i) {
                AbstractSettingView.this.f778k.moveScrollControlThumb(i, false);
            }
        };
        this.f758bi = new PalletView.InterfaceC0975a() { // from class: com.samsung.sdraw.AbstractSettingView.22
            @Override // com.samsung.sdraw.PalletView.InterfaceC0975a
            /* renamed from: a */
            public void mo802a(boolean z, int i, int i2, int i3, int i4) {
                AbstractSettingView.this.f778k.onLayout(false);
            }
        };
        this.f759bj = new PalletView.InterfaceC0975a() { // from class: com.samsung.sdraw.AbstractSettingView.24
            @Override // com.samsung.sdraw.PalletView.InterfaceC0975a
            /* renamed from: a */
            public void mo802a(boolean z, int i, int i2, int i3, int i4) {
                AbstractSettingView.this.f778k.onLayout(true);
            }
        };
        this.f760bk = false;
        this.f761bl = 0;
        this.f762bm = new PresetLinearLayout.InterfaceC0982a() { // from class: com.samsung.sdraw.AbstractSettingView.25
            @Override // com.samsung.sdraw.PresetLinearLayout.InterfaceC0982a
            /* renamed from: a */
            public void mo803a(int i, View view) {
                AbstractSettingView.this.f761bl = i;
            }
        };
        this.f764bo = false;
        this.f765bp = false;
        this.f766bq = false;
        this.f767br = null;
        this.f768bs = -1;
        this.f769bt = false;
        if (resourceIds != null) {
            this.f776i = resourceIds;
        }
        if (this.f776i.containsKey("R.string.textbox_hint")) {
            this.f718aU = getContext().getResources().getString(this.f776i.get("R.string.textbox_hint").intValue());
        }
        if (this.f776i.containsKey(SCanvasConstants.LOCALE_TEXTBOX_HINT_SIZE)) {
            this.f790w = Integer.parseInt(getContext().getResources().getString(this.f776i.get(SCanvasConstants.LOCALE_TEXTBOX_HINT_SIZE).intValue()));
        }
        if (this.f776i.containsKey(SCanvasConstants.LOCALE_PEN_SETTING_PRESET_EXIST_MESSAGE)) {
            this.f779l = getContext().getResources().getString(this.f776i.get(SCanvasConstants.LOCALE_PEN_SETTING_PRESET_EXIST_MESSAGE).intValue());
        }
        if (this.f776i.containsKey(SCanvasConstants.LOCALE_PEN_SETTING_PRESET_MAXIMUM_MESSAGE)) {
            this.f780m = getContext().getResources().getString(this.f776i.get(SCanvasConstants.LOCALE_PEN_SETTING_PRESET_MAXIMUM_MESSAGE).intValue());
        }
        if (this.f776i.containsKey(SCanvasConstants.TALKBACK_SETTING_TEXTBOX_DELETE)) {
            this.f738ap = getContext().getResources().getString(this.f776i.get(SCanvasConstants.TALKBACK_SETTING_TEXTBOX_DELETE).intValue());
        }
        if (this.f776i.containsKey("R.string.object_delete_desc")) {
            this.f739aq = getContext().getResources().getString(this.f776i.get("R.string.object_delete_desc").intValue());
        }
        if (this.f776i.containsKey("R.string.object_rotate_left_desc")) {
            this.f740ar = getContext().getResources().getString(this.f776i.get("R.string.object_rotate_left_desc").intValue());
        }
        if (this.f776i.containsKey("R.string.object_rotate_right_desc")) {
            this.f741as = getContext().getResources().getString(this.f776i.get("R.string.object_rotate_right_desc").intValue());
        }
        if (this.f776i.containsKey(SCanvasConstants.LOCALE_SETTINGVIEW_CLOSE_DESCRIPTION)) {
            this.f742at = getContext().getResources().getString(this.f776i.get(SCanvasConstants.LOCALE_SETTINGVIEW_CLOSE_DESCRIPTION).intValue());
        }
        if (this.f776i.containsKey(SCanvasConstants.TALKBACK_SETTING_PRESET_PREVIEW)) {
            this.f743au = getContext().getString(this.f776i.get(SCanvasConstants.TALKBACK_SETTING_PRESET_PREVIEW).intValue());
        }
        if (this.f776i.containsKey("R.string.dropperview_color_desc")) {
            this.f744av = getContext().getString(this.f776i.get("R.string.dropperview_color_desc").intValue());
        }
        m769a();
    }

    public AbstractSettingView(Context context, HashMap<String, Integer> resourceIds, HashMap<String, String> fontname) {
        super(context);
        this.f724aa = false;
        this.f725ab = false;
        this.f726ac = false;
        this.f727ad = false;
        this.f729ag = false;
        this.f772e = "";
        this.f773f = new ArrayList<>();
        this.f774g = new ArrayList<>();
        this.f775h = new ArrayList<>();
        this.f776i = new HashMap<>();
        this.f777j = new HashMap<>();
        this.f730ah = new int[]{0, 1, 3, 4, 6, 2};
        this.f779l = "Already exists same pen setting";
        this.f780m = "Maximum number of Preset pens(%d) reached";
        this.f736an = false;
        this.f737ao = true;
        this.f742at = HttpUtil.VAL_CLOSE;
        this.f743au = "Pen type %s, thickness %d percent, transparency %d percent";
        this.f744av = "DropperView Color";
        this.f745aw = null;
        this.f746ax = new AdapterView.OnItemSelectedListener() { // from class: com.samsung.sdraw.AbstractSettingView.1
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                int i = 0;
                String str = (String) AbstractSettingView.this.f728ae.getSelectedItem();
                AbstractSettingView.this.f728ae.setContentDescription(String.format(AbstractSettingView.this.f784q.f1651s, str));
                while (true) {
                    int i2 = i;
                    if (i2 < AbstractSettingView.this.f774g.size()) {
                        if (AbstractSettingView.this.f774g.get(i2).equalsIgnoreCase(str)) {
                            AbstractSettingView.this.m704a(AbstractSettingView.this.f773f.get(i2));
                        }
                        i = i2 + 1;
                    } else {
                        return;
                    }
                }
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        };
        this.f747ay = new View.OnClickListener() { // from class: com.samsung.sdraw.AbstractSettingView.12
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (!v.isSelected()) {
                    if (AbstractSettingView.this.f793z != null) {
                        AbstractSettingView.this.f793z.m977b(AbstractSettingView.this.f697a);
                    }
                    AbstractSettingView.this.m691a(v);
                    if (AbstractSettingView.this.f793z != null) {
                        AbstractSettingView.this.f793z.m972a(AbstractSettingView.this.f697a);
                    }
                    AbstractSettingView.this.f778k.moveScrollControlThumb(AbstractSettingView.this.f782o.f1695aj.getScrollY(), true);
                }
            }
        };
        this.f748az = new View.OnClickListener() { // from class: com.samsung.sdraw.AbstractSettingView.23
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                AbstractSettingView.this.m708b(v);
            }
        };
        this.f698aA = new View.OnClickListener() { // from class: com.samsung.sdraw.AbstractSettingView.28
            @Override // android.view.View.OnClickListener
            public void onClick(View v) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                if (AbstractSettingView.this.f793z != null) {
                    AbstractSettingView.this.f793z.m970a(v);
                }
                if (!v.equals(AbstractSettingView.this.f688P)) {
                    if (!v.equals(AbstractSettingView.this.f689Q)) {
                        if (!v.equals(AbstractSettingView.this.f690R)) {
                            if (v.equals(AbstractSettingView.this.f691S)) {
                                AbstractSettingView.this.m788i().setVisibility(4);
                                if (AbstractSettingView.this.f717aT == null) {
                                    return;
                                }
                                AbstractSettingView.this.f717aT.mo809d(false);
                                return;
                            }
                            return;
                        }
                        AbstractSettingView.this.m787h().setVisibility(4);
                        if (AbstractSettingView.this.f717aT == null) {
                            return;
                        }
                        AbstractSettingView.this.f717aT.mo808c(false);
                        return;
                    }
                    AbstractSettingView.this.m789j().setVisibility(4);
                    if (AbstractSettingView.this.f717aT == null) {
                        return;
                    }
                    AbstractSettingView.this.f717aT.mo807b(false);
                    return;
                }
                AbstractSettingView.this.m786g().setVisibility(4);
                if (AbstractSettingView.this.f717aT == null) {
                    return;
                }
                AbstractSettingView.this.f717aT.mo806a(false);
            }
        };
        this.f699aB = new SeekBar.OnSeekBarChangeListener() { // from class: com.samsung.sdraw.AbstractSettingView.29
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (AbstractSettingView.this.f692T != null) {
                    AbstractSettingView.this.f692T.onPenWidthChanged(AbstractSettingView.this.f697a.getPenWidth());
                }
                if (AbstractSettingView.this.f771d != null) {
                    AbstractSettingView.this.f771d.onPenWidthChanged(AbstractSettingView.this.f697a.getPenWidth());
                }
                if (AbstractSettingView.this.f793z != null) {
                    AbstractSettingView.this.f793z.m977b(AbstractSettingView.this.f697a);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int progress2 = progress + 1;
                if (AbstractSettingView.this.f674B != null) {
                    AbstractSettingView.this.f674B.setPenWidth(progress2);
                    if (AbstractSettingView.this.f782o != null) {
                        AbstractSettingView.this.f674B.setDescription(AbstractSettingView.this.f782o.f1494h, AbstractSettingView.this.f782o.f1495i, AbstractSettingView.this.f782o.f1496j, AbstractSettingView.this.f782o.f1497k, AbstractSettingView.this.f782o.f1498l, AbstractSettingView.this.f782o.f1499m);
                    }
                }
                if (AbstractSettingView.this.f697a != null) {
                    AbstractSettingView.this.f697a.setPenWidth(progress2);
                    if (AbstractSettingView.this.f782o != null) {
                        AbstractSettingView.this.f782o.mo1308a(AbstractSettingView.this.f697a.getPenType(), AbstractSettingView.this.f697a.getPenColor(), AbstractSettingView.this.f697a.getPenAlpha(), AbstractSettingView.this.f697a.getPenWidth());
                        int max = (progress2 * 100) / AbstractSettingView.this.f678F.getMax();
                        if (max > 100) {
                            max = 100;
                        }
                        AbstractSettingView.this.f678F.setContentDescription(String.format(AbstractSettingView.this.f782o.f1490d, Integer.valueOf(max)));
                    }
                    if (AbstractSettingView.this.f673A != null && AbstractSettingView.this.f673A.stage != null) {
                        AbstractSettingView.this.f673A.setting.setStrokeWidth(AbstractSettingView.this.f697a.getPenWidth());
                    }
                }
            }
        };
        this.f700aC = new SeekBar.OnSeekBarChangeListener() { // from class: com.samsung.sdraw.AbstractSettingView.30
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (AbstractSettingView.this.f692T != null) {
                    AbstractSettingView.this.f692T.onPenAlphaChanged(AbstractSettingView.this.f697a.getPenAlpha());
                }
                if (AbstractSettingView.this.f771d != null) {
                    AbstractSettingView.this.f771d.onPenAlphaChanged(AbstractSettingView.this.f697a.getPenAlpha());
                }
                if (AbstractSettingView.this.f793z != null) {
                    AbstractSettingView.this.f793z.m977b(AbstractSettingView.this.f697a);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (AbstractSettingView.this.f674B != null) {
                    AbstractSettingView.this.f674B.setPenAlpha(progress);
                    if (AbstractSettingView.this.f782o != null) {
                        AbstractSettingView.this.f674B.setDescription(AbstractSettingView.this.f782o.f1494h, AbstractSettingView.this.f782o.f1495i, AbstractSettingView.this.f782o.f1496j, AbstractSettingView.this.f782o.f1497k, AbstractSettingView.this.f782o.f1498l, AbstractSettingView.this.f782o.f1499m);
                    }
                }
                if (AbstractSettingView.this.f697a != null) {
                    AbstractSettingView.this.f697a.setPenAlpha(progress);
                    if (AbstractSettingView.this.f782o != null) {
                        AbstractSettingView.this.f782o.mo1308a(AbstractSettingView.this.f697a.getPenType(), AbstractSettingView.this.f697a.getPenColor(), AbstractSettingView.this.f697a.getPenAlpha(), AbstractSettingView.this.f697a.getPenWidth());
                        int max = (progress * 100) / AbstractSettingView.this.f679G.getMax();
                        if (max > 100) {
                            max = 100;
                        }
                        AbstractSettingView.this.f679G.setContentDescription(String.format(AbstractSettingView.this.f782o.f1491e, Integer.valueOf(max)));
                    }
                    if (AbstractSettingView.this.f673A != null && AbstractSettingView.this.f673A.setting != null) {
                        AbstractSettingView.this.f673A.setting.setStrokeColor(AbstractSettingView.this.f697a.getPenAlphaColor());
                    }
                    if (AbstractSettingView.this.f782o != null && AbstractSettingView.this.f782o.f1455F != null) {
                        AbstractSettingView.this.f782o.f1455F.setColor(AbstractSettingView.this.f697a.getPenAlphaColor());
                    }
                }
            }
        };
        this.f701aD = new SeekBar.OnSeekBarChangeListener() { // from class: com.samsung.sdraw.AbstractSettingView.31
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (AbstractSettingView.this.f692T != null) {
                    AbstractSettingView.this.f692T.onEraserWidthChanged(AbstractSettingView.this.f697a.getEraserWidth());
                }
                if (AbstractSettingView.this.f771d != null) {
                    AbstractSettingView.this.f771d.onEraserWidthChanged(AbstractSettingView.this.f697a.getEraserWidth());
                }
                if (AbstractSettingView.this.f793z != null && AbstractSettingView.this.f793z.f881a != null) {
                    AbstractSettingView.this.f793z.f881a.setEraserWidth(AbstractSettingView.this.f697a.getEraserWidth());
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (AbstractSettingView.this.f697a != null) {
                    AbstractSettingView.this.f697a.setEraserWidth(progress);
                    if (AbstractSettingView.this.f673A != null && AbstractSettingView.this.f673A.setting != null && AbstractSettingView.this.f673A.setting.getStrokeType() == StrokeSprite.Type.Eraser) {
                        AbstractSettingView.this.f673A.setting.setEraserWidth(AbstractSettingView.this.f697a.getEraserWidth());
                    }
                    if (AbstractSettingView.this.f783p != null) {
                        AbstractSettingView.this.f783p.mo1569a(progress);
                        int max = (progress * 100) / AbstractSettingView.this.f686N.getMax();
                        AbstractSettingView.this.f686N.setContentDescription(String.format(AbstractSettingView.this.f783p.f1757d, Integer.valueOf(max <= 100 ? max : 100)));
                    }
                }
            }
        };
        this.f702aE = new AdapterView.OnItemSelectedListener() { // from class: com.samsung.sdraw.AbstractSettingView.32
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                Object selectedItem;
                int i = 0;
                int i2 = 0;
                while (true) {
                    if (i2 >= AbstractSettingView.this.f775h.size()) {
                        break;
                    }
                    if (((Spinner) AbstractSettingView.this.f677E[0]) == null || (selectedItem = ((Spinner) AbstractSettingView.this.f677E[0]).getSelectedItem()) == null || !selectedItem.equals(AbstractSettingView.this.f775h.get(i2))) {
                        i2++;
                    } else {
                        int i3 = i2 + 5;
                        if (AbstractSettingView.this.f784q != null) {
                            ((Spinner) AbstractSettingView.this.f677E[0]).setContentDescription(String.format(AbstractSettingView.this.f784q.f1652t, Integer.valueOf(i3)));
                            i = i3;
                        } else {
                            i = i3;
                        }
                    }
                }
                if (AbstractSettingView.this.f675C != null) {
                    AbstractSettingView.this.f675C.m1439b(i);
                    if (AbstractSettingView.this.f784q != null) {
                        AbstractSettingView.this.f675C.m1437a(AbstractSettingView.this.f784q.f1649q, (String) AbstractSettingView.this.f728ae.getSelectedItem());
                    }
                }
                if (AbstractSettingView.this.f749b != null) {
                    AbstractSettingView.this.f749b.setTextSize(i);
                    if (AbstractSettingView.this.f784q != null) {
                        AbstractSettingView.this.f784q.mo1464a(AbstractSettingView.this.f749b.getTextType(), AbstractSettingView.this.f749b.getTextColor(), AbstractSettingView.this.f749b.getTextSize());
                    }
                    if (AbstractSettingView.this.f673A != null && AbstractSettingView.this.f673A.stage != null) {
                        AbstractSettingView.this.f673A.setting.setTextSize(AbstractSettingView.this.f749b.getTextSize());
                    }
                }
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        };
        this.f703aF = new C1050f.a() { // from class: com.samsung.sdraw.AbstractSettingView.33
            @Override // com.samsung.sdraw.C1050f.a
            /* renamed from: a */
            public void mo800a(int i, int i2, int i3) {
                if (AbstractSettingView.this.f749b != null) {
                    AbstractSettingView.this.f749b.m1184a(i2, i3);
                    AbstractSettingView.this.f749b.setTextColor(i);
                    if (AbstractSettingView.this.f675C != null) {
                        AbstractSettingView.this.f675C.m1440c(i);
                    }
                    if (AbstractSettingView.this.f682J != null) {
                        AbstractSettingView.this.f682J.m1552a(i);
                    }
                    if (AbstractSettingView.this.f784q != null) {
                        if (AbstractSettingView.this.f784q.f1613I != null) {
                            AbstractSettingView.this.f784q.f1613I.setColor((-16777216) | (16777215 & i));
                        }
                        AbstractSettingView.this.f784q.mo1464a(AbstractSettingView.this.f749b.getTextType(), AbstractSettingView.this.f749b.getTextColor(), AbstractSettingView.this.f749b.getTextSize());
                    }
                    if (AbstractSettingView.this.f673A != null && AbstractSettingView.this.f673A.setting != null) {
                        AbstractSettingView.this.f673A.setting.setTextColor(AbstractSettingView.this.f749b.getTextColor());
                    }
                }
            }
        };
        this.f704aG = new C1050f.a() { // from class: com.samsung.sdraw.AbstractSettingView.2
            @Override // com.samsung.sdraw.C1050f.a
            /* renamed from: a */
            public void mo800a(int i, int i2, int i3) {
                if (AbstractSettingView.this.f770c != null) {
                    AbstractSettingView.this.f770c.m996a(i2, i3);
                    AbstractSettingView.this.f770c.m995a((-33554432) | (16777215 & i));
                    AbstractSettingView.this.f770c.setFillingColor(i);
                    if (AbstractSettingView.this.f684L != null) {
                        AbstractSettingView.this.f684L.m1552a(i);
                    }
                    if (AbstractSettingView.this.f673A != null && AbstractSettingView.this.f673A.setting != null) {
                        AbstractSettingView.this.f673A.setting.setFillingColor(AbstractSettingView.this.f770c.getFillingColor());
                    }
                    if (AbstractSettingView.this.f771d != null) {
                        AbstractSettingView.this.f771d.onFillingColorChanged(AbstractSettingView.this.f770c.getFillingColor());
                    }
                }
            }
        };
        this.f705aH = new C1051g.a() { // from class: com.samsung.sdraw.AbstractSettingView.3
            @Override // com.samsung.sdraw.C1051g.a
            /* renamed from: a */
            public void mo804a(int i, int i2, boolean z) {
                if ((i2 == AbstractSettingView.this.f682J.m1555b() - 1 || i2 == -1) && AbstractSettingView.this.f784q != null && AbstractSettingView.this.f784q.f1612H.getVisibility() == 8) {
                    AbstractSettingView.this.f784q.m1491b(true);
                    if (!z) {
                        return;
                    }
                }
                if (AbstractSettingView.this.f749b != null) {
                    if (AbstractSettingView.this.f675C != null) {
                        AbstractSettingView.this.f675C.m1440c(i);
                    }
                    if (AbstractSettingView.this.f784q != null) {
                        if (AbstractSettingView.this.f784q.f1613I != null) {
                            AbstractSettingView.this.f784q.f1613I.setColor((-16777216) | (16777215 & i));
                        }
                        AbstractSettingView.this.f784q.mo1464a(AbstractSettingView.this.f749b.getTextType(), i, AbstractSettingView.this.f749b.getTextSize());
                    }
                    AbstractSettingView.this.f749b.setTextColor(i);
                    if (AbstractSettingView.this.f673A != null && AbstractSettingView.this.f673A.setting != null) {
                        AbstractSettingView.this.f673A.setting.setTextColor(AbstractSettingView.this.f749b.getTextColor());
                    }
                }
            }
        };
        this.f706aI = new C1051g.a() { // from class: com.samsung.sdraw.AbstractSettingView.4
            @Override // com.samsung.sdraw.C1051g.a
            /* renamed from: a */
            public void mo804a(int i, int i2, boolean z) {
                if ((i2 == AbstractSettingView.this.f684L.m1555b() - 1 || i2 == -1) && AbstractSettingView.this.f785r.f1792j.getVisibility() == 8) {
                    AbstractSettingView.this.setPalletViewState(true, 4);
                    if (!z) {
                        return;
                    }
                }
                if (AbstractSettingView.this.f770c != null) {
                    if (AbstractSettingView.this.f673A != null && AbstractSettingView.this.f673A.setting != null) {
                        AbstractSettingView.this.f673A.setting.setFillingColor(AbstractSettingView.this.f770c.getFillingColor());
                    }
                    if (i == AbstractSettingView.this.f684L.m1556c()) {
                        AbstractSettingView.this.f770c.m995a((-33554432) | (16777215 & i));
                    } else {
                        AbstractSettingView.this.f770c.m995a((-16777216) | (16777215 & i));
                    }
                    AbstractSettingView.this.f770c.setFillingColor(i);
                    if (AbstractSettingView.this.f771d != null) {
                        AbstractSettingView.this.f771d.onFillingColorChanged(AbstractSettingView.this.f770c.getFillingColor());
                    }
                }
            }
        };
        this.f707aJ = new C1050f.a() { // from class: com.samsung.sdraw.AbstractSettingView.5
            @Override // com.samsung.sdraw.C1050f.a
            /* renamed from: a */
            public void mo800a(int i, int i2, int i3) {
                if (AbstractSettingView.this.f697a != null) {
                    AbstractSettingView.this.f697a.m1022a(i2, i3);
                    AbstractSettingView.this.f697a.m1025b((-33554432) | (16777215 & i));
                    AbstractSettingView.this.f697a.setPenColor(i);
                    if (AbstractSettingView.this.f674B != null) {
                        AbstractSettingView.this.f674B.setPenColor(i);
                    }
                    if (AbstractSettingView.this.f680H != null) {
                        AbstractSettingView.this.f680H.m1552a(AbstractSettingView.this.f697a.m1021a());
                    }
                    if (AbstractSettingView.this.f782o != null) {
                        if (AbstractSettingView.this.f782o.f1454E != null) {
                            AbstractSettingView.this.f782o.f1454E.setColor((i & 16777215) | (-16777216));
                        }
                        if (AbstractSettingView.this.f782o.f1455F != null) {
                            AbstractSettingView.this.f782o.f1455F.setColor(AbstractSettingView.this.f697a.getPenAlphaColor());
                        }
                        AbstractSettingView.this.f782o.mo1308a(AbstractSettingView.this.f697a.getPenType(), AbstractSettingView.this.f697a.getPenColor(), AbstractSettingView.this.f697a.getPenAlpha(), AbstractSettingView.this.f697a.getPenWidth());
                    }
                    if (AbstractSettingView.this.f673A != null && AbstractSettingView.this.f673A.setting != null) {
                        AbstractSettingView.this.f673A.setting.setStrokeColor(AbstractSettingView.this.f697a.getPenAlphaColor());
                    }
                    if (AbstractSettingView.this.f692T != null) {
                        AbstractSettingView.this.f692T.onColorChanged(((AbstractSettingView.this.f697a.getPenAlpha() << 24) & (-16777216)) | AbstractSettingView.this.f697a.getPenColor());
                    }
                    if (AbstractSettingView.this.f771d != null) {
                        AbstractSettingView.this.f771d.onPenColorChanged(((AbstractSettingView.this.f697a.getPenAlpha() << 24) & (-16777216)) | AbstractSettingView.this.f697a.getPenColor());
                    }
                    if (AbstractSettingView.this.f793z != null) {
                        AbstractSettingView.this.f793z.m977b(AbstractSettingView.this.f697a);
                    }
                }
            }
        };
        this.f708aK = new C1051g.a() { // from class: com.samsung.sdraw.AbstractSettingView.6
            @Override // com.samsung.sdraw.C1051g.a
            /* renamed from: a */
            public void mo804a(int i, int i2, boolean z) {
                if ((i2 == AbstractSettingView.this.f680H.m1555b() - 1 || i2 == -1) && AbstractSettingView.this.f782o != null && AbstractSettingView.this.f782o.f1453D.getVisibility() == 8) {
                    AbstractSettingView.this.setPalletViewState(true, 1);
                    AbstractSettingView.this.f778k.relayoutSettingView(AbstractSettingView.this.getContext().getResources().getDisplayMetrics().widthPixels < AbstractSettingView.this.getResources().getDisplayMetrics().heightPixels, false);
                    AbstractSettingView.this.f778k.setScrollToMax();
                    if (!z) {
                        return;
                    }
                }
                if (AbstractSettingView.this.f697a != null) {
                    if (AbstractSettingView.this.f674B != null) {
                        AbstractSettingView.this.f674B.setPenColor(i);
                    }
                    if (AbstractSettingView.this.f782o != null) {
                        if (AbstractSettingView.this.f782o.f1454E != null) {
                            AbstractSettingView.this.f782o.f1454E.setColor((i & 16777215) | (-16777216));
                        }
                        if (AbstractSettingView.this.f782o.f1455F != null) {
                            AbstractSettingView.this.f782o.f1455F.setColor(AbstractSettingView.this.f697a.getPenAlphaColor());
                        }
                        AbstractSettingView.this.f782o.mo1308a(AbstractSettingView.this.f697a.getPenType(), i, AbstractSettingView.this.f697a.getPenAlpha(), AbstractSettingView.this.f697a.getPenWidth());
                    }
                    if (i == AbstractSettingView.this.f680H.m1556c()) {
                        AbstractSettingView.this.f697a.m1025b((-33554432) | (16777215 & i));
                    } else {
                        AbstractSettingView.this.f697a.m1025b((16777215 & i) | (-16777216));
                    }
                    AbstractSettingView.this.f697a.setPenColor(i);
                    if (AbstractSettingView.this.f673A != null && AbstractSettingView.this.f673A.setting != null) {
                        AbstractSettingView.this.f673A.setting.setStrokeColor(AbstractSettingView.this.f697a.getPenAlphaColor());
                    }
                    if (AbstractSettingView.this.f782o != null && AbstractSettingView.this.f782o.f1455F != null) {
                        AbstractSettingView.this.f782o.f1455F.setColor(AbstractSettingView.this.f697a.getPenAlphaColor());
                    }
                    if (AbstractSettingView.this.f692T != null) {
                        AbstractSettingView.this.f692T.onColorChanged(((AbstractSettingView.this.f697a.getPenAlpha() << 24) & (-16777216)) | AbstractSettingView.this.f697a.getPenColor());
                    }
                    if (AbstractSettingView.this.f771d != null) {
                        AbstractSettingView.this.f771d.onPenColorChanged(((AbstractSettingView.this.f697a.getPenAlpha() << 24) & (-16777216)) | AbstractSettingView.this.f697a.getPenColor());
                    }
                    if (AbstractSettingView.this.f793z != null) {
                        AbstractSettingView.this.f793z.m977b(AbstractSettingView.this.f697a);
                    }
                }
            }
        };
        this.f709aL = new View.OnClickListener() { // from class: com.samsung.sdraw.AbstractSettingView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                boolean zOnDeleteAllConfirm = false;
                zOnDeleteAllConfirm = false;
                if (AbstractSettingView.this.f673A == null) {
                    return;
                }
                if (AbstractSettingView.this.f753bd != null && AbstractSettingView.this.f673A.stage != null) {
                    zOnDeleteAllConfirm = AbstractSettingView.this.f753bd.onDeleteAllConfirm(AbstractSettingView.this.f673A.stage.getSelectedLayerID() == 3 ? 1 : 0);
                }
                if (!zOnDeleteAllConfirm && AbstractSettingView.this.f673A.setting != null && AbstractSettingView.this.f723aZ) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                    if (AbstractSettingView.this.f776i.containsKey(SCanvasConstants.LAYOUT_ERASER_DELETEALL_POPUP_ICON)) {
                        if (AbstractSettingView.this.f776i.get(SCanvasConstants.LAYOUT_ERASER_DELETEALL_POPUP_ICON).intValue() != -1) {
                            builder.setIcon(AbstractSettingView.this.f776i.get(SCanvasConstants.LAYOUT_ERASER_DELETEALL_POPUP_ICON).intValue());
                        }
                    } else {
                        builder.setIcon(R.drawable.ic_dialog_alert);
                    }
                    if (AbstractSettingView.this.f776i.containsKey(SCanvasConstants.LOCALE_ERASER_SETTING_CLEARALL)) {
                        builder.setTitle(AbstractSettingView.this.f776i.get(SCanvasConstants.LOCALE_ERASER_SETTING_CLEARALL).intValue());
                    } else if (AbstractSettingView.this.f776i.containsKey(SCanvasConstants.LOCALE_ERASER_SETTING_DELETEALL)) {
                        builder.setTitle(AbstractSettingView.this.f776i.get(SCanvasConstants.LOCALE_ERASER_SETTING_DELETEALL).intValue());
                    } else {
                        builder.setTitle("Delete all");
                    }
                    if (AbstractSettingView.this.f776i.containsKey(SCanvasConstants.LOCALE_ERASER_SETTING_CLEARALL_MESSAGE)) {
                        builder.setMessage(AbstractSettingView.this.f776i.get(SCanvasConstants.LOCALE_ERASER_SETTING_CLEARALL_MESSAGE).intValue());
                    } else if (AbstractSettingView.this.f776i.containsKey(SCanvasConstants.LOCALE_ERASER_SETTING_DELETEALL_MESSAGE)) {
                        builder.setMessage(AbstractSettingView.this.f776i.get(SCanvasConstants.LOCALE_ERASER_SETTING_DELETEALL_MESSAGE).intValue());
                    } else {
                        builder.setMessage("All data will be deleted");
                    }
                    builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() { // from class: com.samsung.sdraw.AbstractSettingView.7.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface arg0, int arg1) {
                            if (AbstractSettingView.this.f771d != null) {
                                AbstractSettingView.this.f771d.onClearAll(false);
                                AbstractSettingView.this.f771d.onDeleteAll(false);
                            }
                            if (AbstractSettingView.this.f673A != null) {
                                ((CanvasView) AbstractSettingView.this.f673A.view).deleteAll(true);
                            }
                            if (AbstractSettingView.this.f692T != null) {
                                AbstractSettingView.this.f692T.onClearAll();
                            }
                            if (AbstractSettingView.this.f771d != null) {
                                AbstractSettingView.this.f771d.onClearAll(true);
                                AbstractSettingView.this.f771d.onDeleteAll(true);
                            }
                        }
                    });
                    builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() { // from class: com.samsung.sdraw.AbstractSettingView.7.2
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface arg0, int arg1) {
                        }
                    });
                    builder.setCancelable(true);
                    builder.create().show();
                }
            }
        };
        this.f710aM = new View.OnClickListener() { // from class: com.samsung.sdraw.AbstractSettingView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (AbstractSettingView.this.f782o != null && AbstractSettingView.this.f782o.f1453D != null) {
                    if (AbstractSettingView.this.f782o.f1453D.getVisibility() == 8) {
                        AbstractSettingView.this.setPalletViewState(true, 1);
                        v.setSelected(false);
                        AbstractSettingView.this.f778k.setScrollToMax();
                    } else {
                        AbstractSettingView.this.setPalletViewState(false, 1);
                        v.setSelected(true);
                    }
                }
                if (AbstractSettingView.this.f785r != null && AbstractSettingView.this.f785r.f1792j != null) {
                    if (AbstractSettingView.this.f785r.f1792j.getVisibility() == 8) {
                        AbstractSettingView.this.setPalletViewState(true, 4);
                        v.setSelected(false);
                    } else {
                        AbstractSettingView.this.setPalletViewState(false, 4);
                        v.setSelected(true);
                    }
                }
            }
        };
        this.f711aN = new View.OnFocusChangeListener() { // from class: com.samsung.sdraw.AbstractSettingView.9
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View arg0, boolean arg1) {
                if (arg0.equals(AbstractSettingView.this.f784q.f1616L) && arg1) {
                    AbstractSettingView.this.f784q.f1616L.setSelected(true);
                    AbstractSettingView.this.f784q.f1617M.setSelected(false);
                    AbstractSettingView.this.f784q.mo1463a(0);
                } else if (arg0.equals(AbstractSettingView.this.f784q.f1617M) && arg1) {
                    AbstractSettingView.this.f784q.f1616L.setSelected(false);
                    AbstractSettingView.this.f784q.f1617M.setSelected(true);
                    AbstractSettingView.this.f784q.mo1463a(1);
                }
                AbstractSettingView.this.m770a(3, true);
            }
        };
        this.f712aO = new View.OnClickListener() { // from class: com.samsung.sdraw.AbstractSettingView.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (v.equals(AbstractSettingView.this.f784q.f1616L)) {
                    AbstractSettingView.this.f784q.f1616L.setSelected(true);
                    AbstractSettingView.this.f784q.f1617M.setSelected(false);
                    AbstractSettingView.this.f784q.mo1463a(0);
                } else if (v.equals(AbstractSettingView.this.f784q.f1617M)) {
                    AbstractSettingView.this.f784q.f1616L.setSelected(false);
                    AbstractSettingView.this.f784q.f1617M.setSelected(true);
                    AbstractSettingView.this.f784q.mo1463a(1);
                }
                AbstractSettingView.this.m770a(3, true);
            }
        };
        this.f713aP = new View.OnClickListener() { // from class: com.samsung.sdraw.AbstractSettingView.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (AbstractSettingView.this.f784q != null && AbstractSettingView.this.f784q.f1608D != null && AbstractSettingView.this.f784q.f1609E != null && AbstractSettingView.this.f784q.f1610F != null) {
                    if (v.equals(AbstractSettingView.this.f784q.f1608D)) {
                        AbstractSettingView.this.f784q.f1608D.setSelected(true);
                        AbstractSettingView.this.f784q.f1609E.setSelected(false);
                        AbstractSettingView.this.f784q.f1610F.setSelected(false);
                        AbstractSettingView.this.f749b.setTextAlignment(Layout.Alignment.ALIGN_NORMAL);
                        return;
                    }
                    if (v.equals(AbstractSettingView.this.f784q.f1609E)) {
                        AbstractSettingView.this.f784q.f1608D.setSelected(false);
                        AbstractSettingView.this.f784q.f1609E.setSelected(true);
                        AbstractSettingView.this.f784q.f1610F.setSelected(false);
                        AbstractSettingView.this.f749b.setTextAlignment(Layout.Alignment.ALIGN_CENTER);
                        return;
                    }
                    if (v.equals(AbstractSettingView.this.f784q.f1610F)) {
                        AbstractSettingView.this.f784q.f1608D.setSelected(false);
                        AbstractSettingView.this.f784q.f1609E.setSelected(false);
                        AbstractSettingView.this.f784q.f1610F.setSelected(true);
                        AbstractSettingView.this.f749b.setTextAlignment(Layout.Alignment.ALIGN_OPPOSITE);
                    }
                }
            }
        };
        this.f715aR = new TextSettingInfo.InterfaceC0986b() { // from class: com.samsung.sdraw.AbstractSettingView.13
            @Override // com.samsung.sdraw.TextSettingInfo.InterfaceC0986b
            /* renamed from: a */
            public void mo794a(int i) {
                AbstractSettingView.this.m684F();
                if (AbstractSettingView.this.f673A != null) {
                    ((CanvasView) AbstractSettingView.this.f673A.view).m973a(AbstractSettingView.this.f749b, 0);
                }
                if (AbstractSettingView.this.f771d != null) {
                    AbstractSettingView.this.f771d.onTextTypeChanged(i);
                }
            }

            @Override // com.samsung.sdraw.TextSettingInfo.InterfaceC0986b
            /* renamed from: b */
            public void mo797b(int i) {
                AbstractSettingView.this.m684F();
                if (AbstractSettingView.this.f673A != null) {
                    ((CanvasView) AbstractSettingView.this.f673A.view).m973a(AbstractSettingView.this.f749b, 1);
                }
                if (AbstractSettingView.this.f682J != null) {
                    AbstractSettingView.this.f682J.m1552a(i);
                }
                if (AbstractSettingView.this.f771d != null) {
                    AbstractSettingView.this.f771d.onTextColorChanged(i);
                }
            }

            @Override // com.samsung.sdraw.TextSettingInfo.InterfaceC0986b
            /* renamed from: c */
            public void mo798c(int i) {
                AbstractSettingView.this.m684F();
                if (AbstractSettingView.this.f673A != null) {
                    ((CanvasView) AbstractSettingView.this.f673A.view).m973a(AbstractSettingView.this.f749b, 2);
                }
                if (AbstractSettingView.this.f771d != null) {
                    AbstractSettingView.this.f771d.onTextSizeChanged(i);
                }
            }

            @Override // com.samsung.sdraw.TextSettingInfo.InterfaceC0986b
            /* renamed from: a */
            public void mo796a(String str) {
                AbstractSettingView.this.m684F();
                if (AbstractSettingView.this.f673A != null) {
                    ((CanvasView) AbstractSettingView.this.f673A.view).m973a(AbstractSettingView.this.f749b, 3);
                }
                if (AbstractSettingView.this.f771d != null) {
                    AbstractSettingView.this.f771d.onTextFontChanged(str);
                }
            }

            @Override // com.samsung.sdraw.TextSettingInfo.InterfaceC0986b
            /* renamed from: a */
            public void mo795a(Layout.Alignment alignment) {
                AbstractSettingView.this.m684F();
                if (AbstractSettingView.this.f673A != null) {
                    ((CanvasView) AbstractSettingView.this.f673A.view).m973a(AbstractSettingView.this.f749b, 4);
                }
                if (AbstractSettingView.this.f771d != null) {
                    AbstractSettingView.this.f771d.onTextAlignmentChanged(alignment);
                }
            }
        };
        this.f716aS = new FillingSettingInfo.InterfaceC0974b() { // from class: com.samsung.sdraw.AbstractSettingView.14
            @Override // com.samsung.sdraw.FillingSettingInfo.InterfaceC0974b
            /* renamed from: a */
            public void mo799a(int i) {
                AbstractSettingView.this.m685G();
                if (AbstractSettingView.this.f771d != null) {
                    AbstractSettingView.this.f771d.onFillingColorChanged(i);
                }
            }
        };
        this.f718aU = "Insert Text";
        this.f719aV = 0;
        this.f720aW = 0;
        this.f721aX = 0;
        this.f722aY = 0;
        this.f723aZ = true;
        this.f750ba = new View.OnClickListener() { // from class: com.samsung.sdraw.AbstractSettingView.15
            @Override // android.view.View.OnClickListener
            public void onClick(View v) throws Throwable {
                C1005ar c1005ar = new C1005ar();
                int penType = AbstractSettingView.this.f697a.getPenType();
                c1005ar.m1387d(penType);
                c1005ar.m1383b(AbstractSettingView.this.f697a.getPenWidth(penType));
                c1005ar.m1389e(AbstractSettingView.this.f697a.getPenColor(penType));
                c1005ar.m1385c(AbstractSettingView.this.f697a.getPenAlpha(penType));
                if (!AbstractSettingView.this.f731ai.m1044b(c1005ar)) {
                    AbstractSettingView.this.m700a(c1005ar, false);
                    AbstractSettingView.this.f731ai.m1040a(c1005ar);
                } else {
                    AbstractSettingView.this.m687I();
                }
                if (AbstractSettingView.this.f731ai.m1042b().size() >= 12 && AbstractSettingView.this.f737ao) {
                    Toast.makeText(AbstractSettingView.this.getContext(), String.format(AbstractSettingView.this.f780m, 12), 0).show();
                }
            }
        };
        this.f751bb = new PresetLinearLayout.OnClickPresetItemListener() { // from class: com.samsung.sdraw.AbstractSettingView.16
            @Override // com.samsung.sdraw.PresetLinearLayout.OnClickPresetItemListener
            public void selectPresetItem(int index) {
                if (index == -1) {
                    AbstractSettingView.this.m727e(AbstractSettingView.this.f761bl);
                } else {
                    AbstractSettingView.this.m727e(index);
                }
            }

            @Override // com.samsung.sdraw.PresetLinearLayout.OnClickPresetItemListener
            public void deletePresetItem(int index) {
                if (!AbstractSettingView.this.f766bq) {
                    AbstractSettingView.this.m730f(index);
                } else {
                    if (AbstractSettingView.this.f767br == null) {
                        return;
                    }
                    AbstractSettingView.this.f767br.onClick(index);
                }
            }
        };
        this.f787t = "Selected pen preset will be permanently erased";
        this.f788u = "Delete";
        this.f752bc = new PresetDataManager.NotifyListener() { // from class: com.samsung.sdraw.AbstractSettingView.17
            @Override // com.samsung.sdraw.PresetDataManager.NotifyListener
            public void dataChanged(int presetCount) {
                AbstractSettingView.this.m686H();
            }
        };
        this.f753bd = null;
        this.f790w = 10;
        this.f754be = new View.OnTouchListener() { // from class: com.samsung.sdraw.AbstractSettingView.18
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent event) {
                AbstractSettingView.this.f778k.onScroll(event, true);
                return true;
            }
        };
        this.f755bf = new View.OnTouchListener() { // from class: com.samsung.sdraw.AbstractSettingView.19
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent event) {
                AbstractSettingView.this.f778k.onScroll(event, false);
                return true;
            }
        };
        this.f756bg = new PenSettingScrollView.InterfaceC0978a() { // from class: com.samsung.sdraw.AbstractSettingView.20
            @Override // com.samsung.sdraw.PenSettingScrollView.InterfaceC0978a
            /* renamed from: a */
            public void mo801a(int i) {
                AbstractSettingView.this.f778k.moveScrollControlThumb(i, true);
            }
        };
        this.f757bh = new PenSettingScrollView.InterfaceC0978a() { // from class: com.samsung.sdraw.AbstractSettingView.21
            @Override // com.samsung.sdraw.PenSettingScrollView.InterfaceC0978a
            /* renamed from: a */
            public void mo801a(int i) {
                AbstractSettingView.this.f778k.moveScrollControlThumb(i, false);
            }
        };
        this.f758bi = new PalletView.InterfaceC0975a() { // from class: com.samsung.sdraw.AbstractSettingView.22
            @Override // com.samsung.sdraw.PalletView.InterfaceC0975a
            /* renamed from: a */
            public void mo802a(boolean z, int i, int i2, int i3, int i4) {
                AbstractSettingView.this.f778k.onLayout(false);
            }
        };
        this.f759bj = new PalletView.InterfaceC0975a() { // from class: com.samsung.sdraw.AbstractSettingView.24
            @Override // com.samsung.sdraw.PalletView.InterfaceC0975a
            /* renamed from: a */
            public void mo802a(boolean z, int i, int i2, int i3, int i4) {
                AbstractSettingView.this.f778k.onLayout(true);
            }
        };
        this.f760bk = false;
        this.f761bl = 0;
        this.f762bm = new PresetLinearLayout.InterfaceC0982a() { // from class: com.samsung.sdraw.AbstractSettingView.25
            @Override // com.samsung.sdraw.PresetLinearLayout.InterfaceC0982a
            /* renamed from: a */
            public void mo803a(int i, View view) {
                AbstractSettingView.this.f761bl = i;
            }
        };
        this.f764bo = false;
        this.f765bp = false;
        this.f766bq = false;
        this.f767br = null;
        this.f768bs = -1;
        this.f769bt = false;
        if (resourceIds != null) {
            this.f776i = resourceIds;
        }
        if (fontname != null) {
            this.f777j = fontname;
        }
        if (this.f776i.containsKey("R.string.textbox_hint")) {
            this.f718aU = getContext().getResources().getString(this.f776i.get("R.string.textbox_hint").intValue());
        }
        if (this.f776i.containsKey(SCanvasConstants.LOCALE_TEXTBOX_HINT_SIZE)) {
            this.f790w = Integer.parseInt(getContext().getResources().getString(this.f776i.get(SCanvasConstants.LOCALE_TEXTBOX_HINT_SIZE).intValue()));
        }
        if (this.f776i.containsKey(SCanvasConstants.LOCALE_PEN_SETTING_PRESET_EXIST_MESSAGE)) {
            this.f779l = getContext().getResources().getString(this.f776i.get(SCanvasConstants.LOCALE_PEN_SETTING_PRESET_EXIST_MESSAGE).intValue());
        }
        if (this.f776i.containsKey(SCanvasConstants.LOCALE_PEN_SETTING_PRESET_MAXIMUM_MESSAGE)) {
            this.f780m = getContext().getResources().getString(this.f776i.get(SCanvasConstants.LOCALE_PEN_SETTING_PRESET_MAXIMUM_MESSAGE).intValue());
        }
        if (this.f776i.containsKey(SCanvasConstants.TALKBACK_SETTING_TEXTBOX_DELETE)) {
            this.f738ap = getContext().getResources().getString(this.f776i.get(SCanvasConstants.TALKBACK_SETTING_TEXTBOX_DELETE).intValue());
        }
        if (this.f776i.containsKey("R.string.object_delete_desc")) {
            this.f739aq = getContext().getResources().getString(this.f776i.get("R.string.object_delete_desc").intValue());
        }
        if (this.f776i.containsKey("R.string.object_rotate_left_desc")) {
            this.f740ar = getContext().getResources().getString(this.f776i.get("R.string.object_rotate_left_desc").intValue());
        }
        if (this.f776i.containsKey("R.string.object_rotate_right_desc")) {
            this.f741as = getContext().getResources().getString(this.f776i.get("R.string.object_rotate_right_desc").intValue());
        }
        if (this.f776i.containsKey(SCanvasConstants.LOCALE_SETTINGVIEW_CLOSE_DESCRIPTION)) {
            this.f742at = getContext().getResources().getString(this.f776i.get(SCanvasConstants.LOCALE_SETTINGVIEW_CLOSE_DESCRIPTION).intValue());
        }
        if (this.f776i.containsKey(SCanvasConstants.TALKBACK_SETTING_PRESET_PREVIEW)) {
            this.f743au = getContext().getString(this.f776i.get(SCanvasConstants.TALKBACK_SETTING_PRESET_PREVIEW).intValue());
        }
        if (this.f777j.containsKey(SCanvasConstants.CUSTOM_RESOURCE_ASSETS_PATH)) {
            this.f772e = this.f777j.get(SCanvasConstants.CUSTOM_RESOURCE_ASSETS_PATH);
        }
        if (this.f776i.containsKey("R.string.dropperview_color_desc")) {
            this.f744av = getContext().getString(this.f776i.get("R.string.dropperview_color_desc").intValue());
        }
        m769a();
    }

    public AbstractSettingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f724aa = false;
        this.f725ab = false;
        this.f726ac = false;
        this.f727ad = false;
        this.f729ag = false;
        this.f772e = "";
        this.f773f = new ArrayList<>();
        this.f774g = new ArrayList<>();
        this.f775h = new ArrayList<>();
        this.f776i = new HashMap<>();
        this.f777j = new HashMap<>();
        this.f730ah = new int[]{0, 1, 3, 4, 6, 2};
        this.f779l = "Already exists same pen setting";
        this.f780m = "Maximum number of Preset pens(%d) reached";
        this.f736an = false;
        this.f737ao = true;
        this.f742at = HttpUtil.VAL_CLOSE;
        this.f743au = "Pen type %s, thickness %d percent, transparency %d percent";
        this.f744av = "DropperView Color";
        this.f745aw = null;
        this.f746ax = new AdapterView.OnItemSelectedListener() { // from class: com.samsung.sdraw.AbstractSettingView.1
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                int i = 0;
                String str = (String) AbstractSettingView.this.f728ae.getSelectedItem();
                AbstractSettingView.this.f728ae.setContentDescription(String.format(AbstractSettingView.this.f784q.f1651s, str));
                while (true) {
                    int i2 = i;
                    if (i2 < AbstractSettingView.this.f774g.size()) {
                        if (AbstractSettingView.this.f774g.get(i2).equalsIgnoreCase(str)) {
                            AbstractSettingView.this.m704a(AbstractSettingView.this.f773f.get(i2));
                        }
                        i = i2 + 1;
                    } else {
                        return;
                    }
                }
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        };
        this.f747ay = new View.OnClickListener() { // from class: com.samsung.sdraw.AbstractSettingView.12
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (!v.isSelected()) {
                    if (AbstractSettingView.this.f793z != null) {
                        AbstractSettingView.this.f793z.m977b(AbstractSettingView.this.f697a);
                    }
                    AbstractSettingView.this.m691a(v);
                    if (AbstractSettingView.this.f793z != null) {
                        AbstractSettingView.this.f793z.m972a(AbstractSettingView.this.f697a);
                    }
                    AbstractSettingView.this.f778k.moveScrollControlThumb(AbstractSettingView.this.f782o.f1695aj.getScrollY(), true);
                }
            }
        };
        this.f748az = new View.OnClickListener() { // from class: com.samsung.sdraw.AbstractSettingView.23
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                AbstractSettingView.this.m708b(v);
            }
        };
        this.f698aA = new View.OnClickListener() { // from class: com.samsung.sdraw.AbstractSettingView.28
            @Override // android.view.View.OnClickListener
            public void onClick(View v) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                if (AbstractSettingView.this.f793z != null) {
                    AbstractSettingView.this.f793z.m970a(v);
                }
                if (!v.equals(AbstractSettingView.this.f688P)) {
                    if (!v.equals(AbstractSettingView.this.f689Q)) {
                        if (!v.equals(AbstractSettingView.this.f690R)) {
                            if (v.equals(AbstractSettingView.this.f691S)) {
                                AbstractSettingView.this.m788i().setVisibility(4);
                                if (AbstractSettingView.this.f717aT == null) {
                                    return;
                                }
                                AbstractSettingView.this.f717aT.mo809d(false);
                                return;
                            }
                            return;
                        }
                        AbstractSettingView.this.m787h().setVisibility(4);
                        if (AbstractSettingView.this.f717aT == null) {
                            return;
                        }
                        AbstractSettingView.this.f717aT.mo808c(false);
                        return;
                    }
                    AbstractSettingView.this.m789j().setVisibility(4);
                    if (AbstractSettingView.this.f717aT == null) {
                        return;
                    }
                    AbstractSettingView.this.f717aT.mo807b(false);
                    return;
                }
                AbstractSettingView.this.m786g().setVisibility(4);
                if (AbstractSettingView.this.f717aT == null) {
                    return;
                }
                AbstractSettingView.this.f717aT.mo806a(false);
            }
        };
        this.f699aB = new SeekBar.OnSeekBarChangeListener() { // from class: com.samsung.sdraw.AbstractSettingView.29
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (AbstractSettingView.this.f692T != null) {
                    AbstractSettingView.this.f692T.onPenWidthChanged(AbstractSettingView.this.f697a.getPenWidth());
                }
                if (AbstractSettingView.this.f771d != null) {
                    AbstractSettingView.this.f771d.onPenWidthChanged(AbstractSettingView.this.f697a.getPenWidth());
                }
                if (AbstractSettingView.this.f793z != null) {
                    AbstractSettingView.this.f793z.m977b(AbstractSettingView.this.f697a);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int progress2 = progress + 1;
                if (AbstractSettingView.this.f674B != null) {
                    AbstractSettingView.this.f674B.setPenWidth(progress2);
                    if (AbstractSettingView.this.f782o != null) {
                        AbstractSettingView.this.f674B.setDescription(AbstractSettingView.this.f782o.f1494h, AbstractSettingView.this.f782o.f1495i, AbstractSettingView.this.f782o.f1496j, AbstractSettingView.this.f782o.f1497k, AbstractSettingView.this.f782o.f1498l, AbstractSettingView.this.f782o.f1499m);
                    }
                }
                if (AbstractSettingView.this.f697a != null) {
                    AbstractSettingView.this.f697a.setPenWidth(progress2);
                    if (AbstractSettingView.this.f782o != null) {
                        AbstractSettingView.this.f782o.mo1308a(AbstractSettingView.this.f697a.getPenType(), AbstractSettingView.this.f697a.getPenColor(), AbstractSettingView.this.f697a.getPenAlpha(), AbstractSettingView.this.f697a.getPenWidth());
                        int max = (progress2 * 100) / AbstractSettingView.this.f678F.getMax();
                        if (max > 100) {
                            max = 100;
                        }
                        AbstractSettingView.this.f678F.setContentDescription(String.format(AbstractSettingView.this.f782o.f1490d, Integer.valueOf(max)));
                    }
                    if (AbstractSettingView.this.f673A != null && AbstractSettingView.this.f673A.stage != null) {
                        AbstractSettingView.this.f673A.setting.setStrokeWidth(AbstractSettingView.this.f697a.getPenWidth());
                    }
                }
            }
        };
        this.f700aC = new SeekBar.OnSeekBarChangeListener() { // from class: com.samsung.sdraw.AbstractSettingView.30
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (AbstractSettingView.this.f692T != null) {
                    AbstractSettingView.this.f692T.onPenAlphaChanged(AbstractSettingView.this.f697a.getPenAlpha());
                }
                if (AbstractSettingView.this.f771d != null) {
                    AbstractSettingView.this.f771d.onPenAlphaChanged(AbstractSettingView.this.f697a.getPenAlpha());
                }
                if (AbstractSettingView.this.f793z != null) {
                    AbstractSettingView.this.f793z.m977b(AbstractSettingView.this.f697a);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (AbstractSettingView.this.f674B != null) {
                    AbstractSettingView.this.f674B.setPenAlpha(progress);
                    if (AbstractSettingView.this.f782o != null) {
                        AbstractSettingView.this.f674B.setDescription(AbstractSettingView.this.f782o.f1494h, AbstractSettingView.this.f782o.f1495i, AbstractSettingView.this.f782o.f1496j, AbstractSettingView.this.f782o.f1497k, AbstractSettingView.this.f782o.f1498l, AbstractSettingView.this.f782o.f1499m);
                    }
                }
                if (AbstractSettingView.this.f697a != null) {
                    AbstractSettingView.this.f697a.setPenAlpha(progress);
                    if (AbstractSettingView.this.f782o != null) {
                        AbstractSettingView.this.f782o.mo1308a(AbstractSettingView.this.f697a.getPenType(), AbstractSettingView.this.f697a.getPenColor(), AbstractSettingView.this.f697a.getPenAlpha(), AbstractSettingView.this.f697a.getPenWidth());
                        int max = (progress * 100) / AbstractSettingView.this.f679G.getMax();
                        if (max > 100) {
                            max = 100;
                        }
                        AbstractSettingView.this.f679G.setContentDescription(String.format(AbstractSettingView.this.f782o.f1491e, Integer.valueOf(max)));
                    }
                    if (AbstractSettingView.this.f673A != null && AbstractSettingView.this.f673A.setting != null) {
                        AbstractSettingView.this.f673A.setting.setStrokeColor(AbstractSettingView.this.f697a.getPenAlphaColor());
                    }
                    if (AbstractSettingView.this.f782o != null && AbstractSettingView.this.f782o.f1455F != null) {
                        AbstractSettingView.this.f782o.f1455F.setColor(AbstractSettingView.this.f697a.getPenAlphaColor());
                    }
                }
            }
        };
        this.f701aD = new SeekBar.OnSeekBarChangeListener() { // from class: com.samsung.sdraw.AbstractSettingView.31
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (AbstractSettingView.this.f692T != null) {
                    AbstractSettingView.this.f692T.onEraserWidthChanged(AbstractSettingView.this.f697a.getEraserWidth());
                }
                if (AbstractSettingView.this.f771d != null) {
                    AbstractSettingView.this.f771d.onEraserWidthChanged(AbstractSettingView.this.f697a.getEraserWidth());
                }
                if (AbstractSettingView.this.f793z != null && AbstractSettingView.this.f793z.f881a != null) {
                    AbstractSettingView.this.f793z.f881a.setEraserWidth(AbstractSettingView.this.f697a.getEraserWidth());
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (AbstractSettingView.this.f697a != null) {
                    AbstractSettingView.this.f697a.setEraserWidth(progress);
                    if (AbstractSettingView.this.f673A != null && AbstractSettingView.this.f673A.setting != null && AbstractSettingView.this.f673A.setting.getStrokeType() == StrokeSprite.Type.Eraser) {
                        AbstractSettingView.this.f673A.setting.setEraserWidth(AbstractSettingView.this.f697a.getEraserWidth());
                    }
                    if (AbstractSettingView.this.f783p != null) {
                        AbstractSettingView.this.f783p.mo1569a(progress);
                        int max = (progress * 100) / AbstractSettingView.this.f686N.getMax();
                        AbstractSettingView.this.f686N.setContentDescription(String.format(AbstractSettingView.this.f783p.f1757d, Integer.valueOf(max <= 100 ? max : 100)));
                    }
                }
            }
        };
        this.f702aE = new AdapterView.OnItemSelectedListener() { // from class: com.samsung.sdraw.AbstractSettingView.32
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                Object selectedItem;
                int i = 0;
                int i2 = 0;
                while (true) {
                    if (i2 >= AbstractSettingView.this.f775h.size()) {
                        break;
                    }
                    if (((Spinner) AbstractSettingView.this.f677E[0]) == null || (selectedItem = ((Spinner) AbstractSettingView.this.f677E[0]).getSelectedItem()) == null || !selectedItem.equals(AbstractSettingView.this.f775h.get(i2))) {
                        i2++;
                    } else {
                        int i3 = i2 + 5;
                        if (AbstractSettingView.this.f784q != null) {
                            ((Spinner) AbstractSettingView.this.f677E[0]).setContentDescription(String.format(AbstractSettingView.this.f784q.f1652t, Integer.valueOf(i3)));
                            i = i3;
                        } else {
                            i = i3;
                        }
                    }
                }
                if (AbstractSettingView.this.f675C != null) {
                    AbstractSettingView.this.f675C.m1439b(i);
                    if (AbstractSettingView.this.f784q != null) {
                        AbstractSettingView.this.f675C.m1437a(AbstractSettingView.this.f784q.f1649q, (String) AbstractSettingView.this.f728ae.getSelectedItem());
                    }
                }
                if (AbstractSettingView.this.f749b != null) {
                    AbstractSettingView.this.f749b.setTextSize(i);
                    if (AbstractSettingView.this.f784q != null) {
                        AbstractSettingView.this.f784q.mo1464a(AbstractSettingView.this.f749b.getTextType(), AbstractSettingView.this.f749b.getTextColor(), AbstractSettingView.this.f749b.getTextSize());
                    }
                    if (AbstractSettingView.this.f673A != null && AbstractSettingView.this.f673A.stage != null) {
                        AbstractSettingView.this.f673A.setting.setTextSize(AbstractSettingView.this.f749b.getTextSize());
                    }
                }
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        };
        this.f703aF = new C1050f.a() { // from class: com.samsung.sdraw.AbstractSettingView.33
            @Override // com.samsung.sdraw.C1050f.a
            /* renamed from: a */
            public void mo800a(int i, int i2, int i3) {
                if (AbstractSettingView.this.f749b != null) {
                    AbstractSettingView.this.f749b.m1184a(i2, i3);
                    AbstractSettingView.this.f749b.setTextColor(i);
                    if (AbstractSettingView.this.f675C != null) {
                        AbstractSettingView.this.f675C.m1440c(i);
                    }
                    if (AbstractSettingView.this.f682J != null) {
                        AbstractSettingView.this.f682J.m1552a(i);
                    }
                    if (AbstractSettingView.this.f784q != null) {
                        if (AbstractSettingView.this.f784q.f1613I != null) {
                            AbstractSettingView.this.f784q.f1613I.setColor((-16777216) | (16777215 & i));
                        }
                        AbstractSettingView.this.f784q.mo1464a(AbstractSettingView.this.f749b.getTextType(), AbstractSettingView.this.f749b.getTextColor(), AbstractSettingView.this.f749b.getTextSize());
                    }
                    if (AbstractSettingView.this.f673A != null && AbstractSettingView.this.f673A.setting != null) {
                        AbstractSettingView.this.f673A.setting.setTextColor(AbstractSettingView.this.f749b.getTextColor());
                    }
                }
            }
        };
        this.f704aG = new C1050f.a() { // from class: com.samsung.sdraw.AbstractSettingView.2
            @Override // com.samsung.sdraw.C1050f.a
            /* renamed from: a */
            public void mo800a(int i, int i2, int i3) {
                if (AbstractSettingView.this.f770c != null) {
                    AbstractSettingView.this.f770c.m996a(i2, i3);
                    AbstractSettingView.this.f770c.m995a((-33554432) | (16777215 & i));
                    AbstractSettingView.this.f770c.setFillingColor(i);
                    if (AbstractSettingView.this.f684L != null) {
                        AbstractSettingView.this.f684L.m1552a(i);
                    }
                    if (AbstractSettingView.this.f673A != null && AbstractSettingView.this.f673A.setting != null) {
                        AbstractSettingView.this.f673A.setting.setFillingColor(AbstractSettingView.this.f770c.getFillingColor());
                    }
                    if (AbstractSettingView.this.f771d != null) {
                        AbstractSettingView.this.f771d.onFillingColorChanged(AbstractSettingView.this.f770c.getFillingColor());
                    }
                }
            }
        };
        this.f705aH = new C1051g.a() { // from class: com.samsung.sdraw.AbstractSettingView.3
            @Override // com.samsung.sdraw.C1051g.a
            /* renamed from: a */
            public void mo804a(int i, int i2, boolean z) {
                if ((i2 == AbstractSettingView.this.f682J.m1555b() - 1 || i2 == -1) && AbstractSettingView.this.f784q != null && AbstractSettingView.this.f784q.f1612H.getVisibility() == 8) {
                    AbstractSettingView.this.f784q.m1491b(true);
                    if (!z) {
                        return;
                    }
                }
                if (AbstractSettingView.this.f749b != null) {
                    if (AbstractSettingView.this.f675C != null) {
                        AbstractSettingView.this.f675C.m1440c(i);
                    }
                    if (AbstractSettingView.this.f784q != null) {
                        if (AbstractSettingView.this.f784q.f1613I != null) {
                            AbstractSettingView.this.f784q.f1613I.setColor((-16777216) | (16777215 & i));
                        }
                        AbstractSettingView.this.f784q.mo1464a(AbstractSettingView.this.f749b.getTextType(), i, AbstractSettingView.this.f749b.getTextSize());
                    }
                    AbstractSettingView.this.f749b.setTextColor(i);
                    if (AbstractSettingView.this.f673A != null && AbstractSettingView.this.f673A.setting != null) {
                        AbstractSettingView.this.f673A.setting.setTextColor(AbstractSettingView.this.f749b.getTextColor());
                    }
                }
            }
        };
        this.f706aI = new C1051g.a() { // from class: com.samsung.sdraw.AbstractSettingView.4
            @Override // com.samsung.sdraw.C1051g.a
            /* renamed from: a */
            public void mo804a(int i, int i2, boolean z) {
                if ((i2 == AbstractSettingView.this.f684L.m1555b() - 1 || i2 == -1) && AbstractSettingView.this.f785r.f1792j.getVisibility() == 8) {
                    AbstractSettingView.this.setPalletViewState(true, 4);
                    if (!z) {
                        return;
                    }
                }
                if (AbstractSettingView.this.f770c != null) {
                    if (AbstractSettingView.this.f673A != null && AbstractSettingView.this.f673A.setting != null) {
                        AbstractSettingView.this.f673A.setting.setFillingColor(AbstractSettingView.this.f770c.getFillingColor());
                    }
                    if (i == AbstractSettingView.this.f684L.m1556c()) {
                        AbstractSettingView.this.f770c.m995a((-33554432) | (16777215 & i));
                    } else {
                        AbstractSettingView.this.f770c.m995a((-16777216) | (16777215 & i));
                    }
                    AbstractSettingView.this.f770c.setFillingColor(i);
                    if (AbstractSettingView.this.f771d != null) {
                        AbstractSettingView.this.f771d.onFillingColorChanged(AbstractSettingView.this.f770c.getFillingColor());
                    }
                }
            }
        };
        this.f707aJ = new C1050f.a() { // from class: com.samsung.sdraw.AbstractSettingView.5
            @Override // com.samsung.sdraw.C1050f.a
            /* renamed from: a */
            public void mo800a(int i, int i2, int i3) {
                if (AbstractSettingView.this.f697a != null) {
                    AbstractSettingView.this.f697a.m1022a(i2, i3);
                    AbstractSettingView.this.f697a.m1025b((-33554432) | (16777215 & i));
                    AbstractSettingView.this.f697a.setPenColor(i);
                    if (AbstractSettingView.this.f674B != null) {
                        AbstractSettingView.this.f674B.setPenColor(i);
                    }
                    if (AbstractSettingView.this.f680H != null) {
                        AbstractSettingView.this.f680H.m1552a(AbstractSettingView.this.f697a.m1021a());
                    }
                    if (AbstractSettingView.this.f782o != null) {
                        if (AbstractSettingView.this.f782o.f1454E != null) {
                            AbstractSettingView.this.f782o.f1454E.setColor((i & 16777215) | (-16777216));
                        }
                        if (AbstractSettingView.this.f782o.f1455F != null) {
                            AbstractSettingView.this.f782o.f1455F.setColor(AbstractSettingView.this.f697a.getPenAlphaColor());
                        }
                        AbstractSettingView.this.f782o.mo1308a(AbstractSettingView.this.f697a.getPenType(), AbstractSettingView.this.f697a.getPenColor(), AbstractSettingView.this.f697a.getPenAlpha(), AbstractSettingView.this.f697a.getPenWidth());
                    }
                    if (AbstractSettingView.this.f673A != null && AbstractSettingView.this.f673A.setting != null) {
                        AbstractSettingView.this.f673A.setting.setStrokeColor(AbstractSettingView.this.f697a.getPenAlphaColor());
                    }
                    if (AbstractSettingView.this.f692T != null) {
                        AbstractSettingView.this.f692T.onColorChanged(((AbstractSettingView.this.f697a.getPenAlpha() << 24) & (-16777216)) | AbstractSettingView.this.f697a.getPenColor());
                    }
                    if (AbstractSettingView.this.f771d != null) {
                        AbstractSettingView.this.f771d.onPenColorChanged(((AbstractSettingView.this.f697a.getPenAlpha() << 24) & (-16777216)) | AbstractSettingView.this.f697a.getPenColor());
                    }
                    if (AbstractSettingView.this.f793z != null) {
                        AbstractSettingView.this.f793z.m977b(AbstractSettingView.this.f697a);
                    }
                }
            }
        };
        this.f708aK = new C1051g.a() { // from class: com.samsung.sdraw.AbstractSettingView.6
            @Override // com.samsung.sdraw.C1051g.a
            /* renamed from: a */
            public void mo804a(int i, int i2, boolean z) {
                if ((i2 == AbstractSettingView.this.f680H.m1555b() - 1 || i2 == -1) && AbstractSettingView.this.f782o != null && AbstractSettingView.this.f782o.f1453D.getVisibility() == 8) {
                    AbstractSettingView.this.setPalletViewState(true, 1);
                    AbstractSettingView.this.f778k.relayoutSettingView(AbstractSettingView.this.getContext().getResources().getDisplayMetrics().widthPixels < AbstractSettingView.this.getResources().getDisplayMetrics().heightPixels, false);
                    AbstractSettingView.this.f778k.setScrollToMax();
                    if (!z) {
                        return;
                    }
                }
                if (AbstractSettingView.this.f697a != null) {
                    if (AbstractSettingView.this.f674B != null) {
                        AbstractSettingView.this.f674B.setPenColor(i);
                    }
                    if (AbstractSettingView.this.f782o != null) {
                        if (AbstractSettingView.this.f782o.f1454E != null) {
                            AbstractSettingView.this.f782o.f1454E.setColor((i & 16777215) | (-16777216));
                        }
                        if (AbstractSettingView.this.f782o.f1455F != null) {
                            AbstractSettingView.this.f782o.f1455F.setColor(AbstractSettingView.this.f697a.getPenAlphaColor());
                        }
                        AbstractSettingView.this.f782o.mo1308a(AbstractSettingView.this.f697a.getPenType(), i, AbstractSettingView.this.f697a.getPenAlpha(), AbstractSettingView.this.f697a.getPenWidth());
                    }
                    if (i == AbstractSettingView.this.f680H.m1556c()) {
                        AbstractSettingView.this.f697a.m1025b((-33554432) | (16777215 & i));
                    } else {
                        AbstractSettingView.this.f697a.m1025b((16777215 & i) | (-16777216));
                    }
                    AbstractSettingView.this.f697a.setPenColor(i);
                    if (AbstractSettingView.this.f673A != null && AbstractSettingView.this.f673A.setting != null) {
                        AbstractSettingView.this.f673A.setting.setStrokeColor(AbstractSettingView.this.f697a.getPenAlphaColor());
                    }
                    if (AbstractSettingView.this.f782o != null && AbstractSettingView.this.f782o.f1455F != null) {
                        AbstractSettingView.this.f782o.f1455F.setColor(AbstractSettingView.this.f697a.getPenAlphaColor());
                    }
                    if (AbstractSettingView.this.f692T != null) {
                        AbstractSettingView.this.f692T.onColorChanged(((AbstractSettingView.this.f697a.getPenAlpha() << 24) & (-16777216)) | AbstractSettingView.this.f697a.getPenColor());
                    }
                    if (AbstractSettingView.this.f771d != null) {
                        AbstractSettingView.this.f771d.onPenColorChanged(((AbstractSettingView.this.f697a.getPenAlpha() << 24) & (-16777216)) | AbstractSettingView.this.f697a.getPenColor());
                    }
                    if (AbstractSettingView.this.f793z != null) {
                        AbstractSettingView.this.f793z.m977b(AbstractSettingView.this.f697a);
                    }
                }
            }
        };
        this.f709aL = new View.OnClickListener() { // from class: com.samsung.sdraw.AbstractSettingView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                boolean zOnDeleteAllConfirm = false;
                zOnDeleteAllConfirm = false;
                if (AbstractSettingView.this.f673A == null) {
                    return;
                }
                if (AbstractSettingView.this.f753bd != null && AbstractSettingView.this.f673A.stage != null) {
                    zOnDeleteAllConfirm = AbstractSettingView.this.f753bd.onDeleteAllConfirm(AbstractSettingView.this.f673A.stage.getSelectedLayerID() == 3 ? 1 : 0);
                }
                if (!zOnDeleteAllConfirm && AbstractSettingView.this.f673A.setting != null && AbstractSettingView.this.f723aZ) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                    if (AbstractSettingView.this.f776i.containsKey(SCanvasConstants.LAYOUT_ERASER_DELETEALL_POPUP_ICON)) {
                        if (AbstractSettingView.this.f776i.get(SCanvasConstants.LAYOUT_ERASER_DELETEALL_POPUP_ICON).intValue() != -1) {
                            builder.setIcon(AbstractSettingView.this.f776i.get(SCanvasConstants.LAYOUT_ERASER_DELETEALL_POPUP_ICON).intValue());
                        }
                    } else {
                        builder.setIcon(R.drawable.ic_dialog_alert);
                    }
                    if (AbstractSettingView.this.f776i.containsKey(SCanvasConstants.LOCALE_ERASER_SETTING_CLEARALL)) {
                        builder.setTitle(AbstractSettingView.this.f776i.get(SCanvasConstants.LOCALE_ERASER_SETTING_CLEARALL).intValue());
                    } else if (AbstractSettingView.this.f776i.containsKey(SCanvasConstants.LOCALE_ERASER_SETTING_DELETEALL)) {
                        builder.setTitle(AbstractSettingView.this.f776i.get(SCanvasConstants.LOCALE_ERASER_SETTING_DELETEALL).intValue());
                    } else {
                        builder.setTitle("Delete all");
                    }
                    if (AbstractSettingView.this.f776i.containsKey(SCanvasConstants.LOCALE_ERASER_SETTING_CLEARALL_MESSAGE)) {
                        builder.setMessage(AbstractSettingView.this.f776i.get(SCanvasConstants.LOCALE_ERASER_SETTING_CLEARALL_MESSAGE).intValue());
                    } else if (AbstractSettingView.this.f776i.containsKey(SCanvasConstants.LOCALE_ERASER_SETTING_DELETEALL_MESSAGE)) {
                        builder.setMessage(AbstractSettingView.this.f776i.get(SCanvasConstants.LOCALE_ERASER_SETTING_DELETEALL_MESSAGE).intValue());
                    } else {
                        builder.setMessage("All data will be deleted");
                    }
                    builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() { // from class: com.samsung.sdraw.AbstractSettingView.7.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface arg0, int arg1) {
                            if (AbstractSettingView.this.f771d != null) {
                                AbstractSettingView.this.f771d.onClearAll(false);
                                AbstractSettingView.this.f771d.onDeleteAll(false);
                            }
                            if (AbstractSettingView.this.f673A != null) {
                                ((CanvasView) AbstractSettingView.this.f673A.view).deleteAll(true);
                            }
                            if (AbstractSettingView.this.f692T != null) {
                                AbstractSettingView.this.f692T.onClearAll();
                            }
                            if (AbstractSettingView.this.f771d != null) {
                                AbstractSettingView.this.f771d.onClearAll(true);
                                AbstractSettingView.this.f771d.onDeleteAll(true);
                            }
                        }
                    });
                    builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() { // from class: com.samsung.sdraw.AbstractSettingView.7.2
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface arg0, int arg1) {
                        }
                    });
                    builder.setCancelable(true);
                    builder.create().show();
                }
            }
        };
        this.f710aM = new View.OnClickListener() { // from class: com.samsung.sdraw.AbstractSettingView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (AbstractSettingView.this.f782o != null && AbstractSettingView.this.f782o.f1453D != null) {
                    if (AbstractSettingView.this.f782o.f1453D.getVisibility() == 8) {
                        AbstractSettingView.this.setPalletViewState(true, 1);
                        v.setSelected(false);
                        AbstractSettingView.this.f778k.setScrollToMax();
                    } else {
                        AbstractSettingView.this.setPalletViewState(false, 1);
                        v.setSelected(true);
                    }
                }
                if (AbstractSettingView.this.f785r != null && AbstractSettingView.this.f785r.f1792j != null) {
                    if (AbstractSettingView.this.f785r.f1792j.getVisibility() == 8) {
                        AbstractSettingView.this.setPalletViewState(true, 4);
                        v.setSelected(false);
                    } else {
                        AbstractSettingView.this.setPalletViewState(false, 4);
                        v.setSelected(true);
                    }
                }
            }
        };
        this.f711aN = new View.OnFocusChangeListener() { // from class: com.samsung.sdraw.AbstractSettingView.9
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View arg0, boolean arg1) {
                if (arg0.equals(AbstractSettingView.this.f784q.f1616L) && arg1) {
                    AbstractSettingView.this.f784q.f1616L.setSelected(true);
                    AbstractSettingView.this.f784q.f1617M.setSelected(false);
                    AbstractSettingView.this.f784q.mo1463a(0);
                } else if (arg0.equals(AbstractSettingView.this.f784q.f1617M) && arg1) {
                    AbstractSettingView.this.f784q.f1616L.setSelected(false);
                    AbstractSettingView.this.f784q.f1617M.setSelected(true);
                    AbstractSettingView.this.f784q.mo1463a(1);
                }
                AbstractSettingView.this.m770a(3, true);
            }
        };
        this.f712aO = new View.OnClickListener() { // from class: com.samsung.sdraw.AbstractSettingView.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (v.equals(AbstractSettingView.this.f784q.f1616L)) {
                    AbstractSettingView.this.f784q.f1616L.setSelected(true);
                    AbstractSettingView.this.f784q.f1617M.setSelected(false);
                    AbstractSettingView.this.f784q.mo1463a(0);
                } else if (v.equals(AbstractSettingView.this.f784q.f1617M)) {
                    AbstractSettingView.this.f784q.f1616L.setSelected(false);
                    AbstractSettingView.this.f784q.f1617M.setSelected(true);
                    AbstractSettingView.this.f784q.mo1463a(1);
                }
                AbstractSettingView.this.m770a(3, true);
            }
        };
        this.f713aP = new View.OnClickListener() { // from class: com.samsung.sdraw.AbstractSettingView.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (AbstractSettingView.this.f784q != null && AbstractSettingView.this.f784q.f1608D != null && AbstractSettingView.this.f784q.f1609E != null && AbstractSettingView.this.f784q.f1610F != null) {
                    if (v.equals(AbstractSettingView.this.f784q.f1608D)) {
                        AbstractSettingView.this.f784q.f1608D.setSelected(true);
                        AbstractSettingView.this.f784q.f1609E.setSelected(false);
                        AbstractSettingView.this.f784q.f1610F.setSelected(false);
                        AbstractSettingView.this.f749b.setTextAlignment(Layout.Alignment.ALIGN_NORMAL);
                        return;
                    }
                    if (v.equals(AbstractSettingView.this.f784q.f1609E)) {
                        AbstractSettingView.this.f784q.f1608D.setSelected(false);
                        AbstractSettingView.this.f784q.f1609E.setSelected(true);
                        AbstractSettingView.this.f784q.f1610F.setSelected(false);
                        AbstractSettingView.this.f749b.setTextAlignment(Layout.Alignment.ALIGN_CENTER);
                        return;
                    }
                    if (v.equals(AbstractSettingView.this.f784q.f1610F)) {
                        AbstractSettingView.this.f784q.f1608D.setSelected(false);
                        AbstractSettingView.this.f784q.f1609E.setSelected(false);
                        AbstractSettingView.this.f784q.f1610F.setSelected(true);
                        AbstractSettingView.this.f749b.setTextAlignment(Layout.Alignment.ALIGN_OPPOSITE);
                    }
                }
            }
        };
        this.f715aR = new TextSettingInfo.InterfaceC0986b() { // from class: com.samsung.sdraw.AbstractSettingView.13
            @Override // com.samsung.sdraw.TextSettingInfo.InterfaceC0986b
            /* renamed from: a */
            public void mo794a(int i) {
                AbstractSettingView.this.m684F();
                if (AbstractSettingView.this.f673A != null) {
                    ((CanvasView) AbstractSettingView.this.f673A.view).m973a(AbstractSettingView.this.f749b, 0);
                }
                if (AbstractSettingView.this.f771d != null) {
                    AbstractSettingView.this.f771d.onTextTypeChanged(i);
                }
            }

            @Override // com.samsung.sdraw.TextSettingInfo.InterfaceC0986b
            /* renamed from: b */
            public void mo797b(int i) {
                AbstractSettingView.this.m684F();
                if (AbstractSettingView.this.f673A != null) {
                    ((CanvasView) AbstractSettingView.this.f673A.view).m973a(AbstractSettingView.this.f749b, 1);
                }
                if (AbstractSettingView.this.f682J != null) {
                    AbstractSettingView.this.f682J.m1552a(i);
                }
                if (AbstractSettingView.this.f771d != null) {
                    AbstractSettingView.this.f771d.onTextColorChanged(i);
                }
            }

            @Override // com.samsung.sdraw.TextSettingInfo.InterfaceC0986b
            /* renamed from: c */
            public void mo798c(int i) {
                AbstractSettingView.this.m684F();
                if (AbstractSettingView.this.f673A != null) {
                    ((CanvasView) AbstractSettingView.this.f673A.view).m973a(AbstractSettingView.this.f749b, 2);
                }
                if (AbstractSettingView.this.f771d != null) {
                    AbstractSettingView.this.f771d.onTextSizeChanged(i);
                }
            }

            @Override // com.samsung.sdraw.TextSettingInfo.InterfaceC0986b
            /* renamed from: a */
            public void mo796a(String str) {
                AbstractSettingView.this.m684F();
                if (AbstractSettingView.this.f673A != null) {
                    ((CanvasView) AbstractSettingView.this.f673A.view).m973a(AbstractSettingView.this.f749b, 3);
                }
                if (AbstractSettingView.this.f771d != null) {
                    AbstractSettingView.this.f771d.onTextFontChanged(str);
                }
            }

            @Override // com.samsung.sdraw.TextSettingInfo.InterfaceC0986b
            /* renamed from: a */
            public void mo795a(Layout.Alignment alignment) {
                AbstractSettingView.this.m684F();
                if (AbstractSettingView.this.f673A != null) {
                    ((CanvasView) AbstractSettingView.this.f673A.view).m973a(AbstractSettingView.this.f749b, 4);
                }
                if (AbstractSettingView.this.f771d != null) {
                    AbstractSettingView.this.f771d.onTextAlignmentChanged(alignment);
                }
            }
        };
        this.f716aS = new FillingSettingInfo.InterfaceC0974b() { // from class: com.samsung.sdraw.AbstractSettingView.14
            @Override // com.samsung.sdraw.FillingSettingInfo.InterfaceC0974b
            /* renamed from: a */
            public void mo799a(int i) {
                AbstractSettingView.this.m685G();
                if (AbstractSettingView.this.f771d != null) {
                    AbstractSettingView.this.f771d.onFillingColorChanged(i);
                }
            }
        };
        this.f718aU = "Insert Text";
        this.f719aV = 0;
        this.f720aW = 0;
        this.f721aX = 0;
        this.f722aY = 0;
        this.f723aZ = true;
        this.f750ba = new View.OnClickListener() { // from class: com.samsung.sdraw.AbstractSettingView.15
            @Override // android.view.View.OnClickListener
            public void onClick(View v) throws Throwable {
                C1005ar c1005ar = new C1005ar();
                int penType = AbstractSettingView.this.f697a.getPenType();
                c1005ar.m1387d(penType);
                c1005ar.m1383b(AbstractSettingView.this.f697a.getPenWidth(penType));
                c1005ar.m1389e(AbstractSettingView.this.f697a.getPenColor(penType));
                c1005ar.m1385c(AbstractSettingView.this.f697a.getPenAlpha(penType));
                if (!AbstractSettingView.this.f731ai.m1044b(c1005ar)) {
                    AbstractSettingView.this.m700a(c1005ar, false);
                    AbstractSettingView.this.f731ai.m1040a(c1005ar);
                } else {
                    AbstractSettingView.this.m687I();
                }
                if (AbstractSettingView.this.f731ai.m1042b().size() >= 12 && AbstractSettingView.this.f737ao) {
                    Toast.makeText(AbstractSettingView.this.getContext(), String.format(AbstractSettingView.this.f780m, 12), 0).show();
                }
            }
        };
        this.f751bb = new PresetLinearLayout.OnClickPresetItemListener() { // from class: com.samsung.sdraw.AbstractSettingView.16
            @Override // com.samsung.sdraw.PresetLinearLayout.OnClickPresetItemListener
            public void selectPresetItem(int index) {
                if (index == -1) {
                    AbstractSettingView.this.m727e(AbstractSettingView.this.f761bl);
                } else {
                    AbstractSettingView.this.m727e(index);
                }
            }

            @Override // com.samsung.sdraw.PresetLinearLayout.OnClickPresetItemListener
            public void deletePresetItem(int index) {
                if (!AbstractSettingView.this.f766bq) {
                    AbstractSettingView.this.m730f(index);
                } else {
                    if (AbstractSettingView.this.f767br == null) {
                        return;
                    }
                    AbstractSettingView.this.f767br.onClick(index);
                }
            }
        };
        this.f787t = "Selected pen preset will be permanently erased";
        this.f788u = "Delete";
        this.f752bc = new PresetDataManager.NotifyListener() { // from class: com.samsung.sdraw.AbstractSettingView.17
            @Override // com.samsung.sdraw.PresetDataManager.NotifyListener
            public void dataChanged(int presetCount) {
                AbstractSettingView.this.m686H();
            }
        };
        this.f753bd = null;
        this.f790w = 10;
        this.f754be = new View.OnTouchListener() { // from class: com.samsung.sdraw.AbstractSettingView.18
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent event) {
                AbstractSettingView.this.f778k.onScroll(event, true);
                return true;
            }
        };
        this.f755bf = new View.OnTouchListener() { // from class: com.samsung.sdraw.AbstractSettingView.19
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent event) {
                AbstractSettingView.this.f778k.onScroll(event, false);
                return true;
            }
        };
        this.f756bg = new PenSettingScrollView.InterfaceC0978a() { // from class: com.samsung.sdraw.AbstractSettingView.20
            @Override // com.samsung.sdraw.PenSettingScrollView.InterfaceC0978a
            /* renamed from: a */
            public void mo801a(int i) {
                AbstractSettingView.this.f778k.moveScrollControlThumb(i, true);
            }
        };
        this.f757bh = new PenSettingScrollView.InterfaceC0978a() { // from class: com.samsung.sdraw.AbstractSettingView.21
            @Override // com.samsung.sdraw.PenSettingScrollView.InterfaceC0978a
            /* renamed from: a */
            public void mo801a(int i) {
                AbstractSettingView.this.f778k.moveScrollControlThumb(i, false);
            }
        };
        this.f758bi = new PalletView.InterfaceC0975a() { // from class: com.samsung.sdraw.AbstractSettingView.22
            @Override // com.samsung.sdraw.PalletView.InterfaceC0975a
            /* renamed from: a */
            public void mo802a(boolean z, int i, int i2, int i3, int i4) {
                AbstractSettingView.this.f778k.onLayout(false);
            }
        };
        this.f759bj = new PalletView.InterfaceC0975a() { // from class: com.samsung.sdraw.AbstractSettingView.24
            @Override // com.samsung.sdraw.PalletView.InterfaceC0975a
            /* renamed from: a */
            public void mo802a(boolean z, int i, int i2, int i3, int i4) {
                AbstractSettingView.this.f778k.onLayout(true);
            }
        };
        this.f760bk = false;
        this.f761bl = 0;
        this.f762bm = new PresetLinearLayout.InterfaceC0982a() { // from class: com.samsung.sdraw.AbstractSettingView.25
            @Override // com.samsung.sdraw.PresetLinearLayout.InterfaceC0982a
            /* renamed from: a */
            public void mo803a(int i, View view) {
                AbstractSettingView.this.f761bl = i;
            }
        };
        this.f764bo = false;
        this.f765bp = false;
        this.f766bq = false;
        this.f767br = null;
        this.f768bs = -1;
        this.f769bt = false;
        m769a();
    }

    public AbstractSettingView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.f724aa = false;
        this.f725ab = false;
        this.f726ac = false;
        this.f727ad = false;
        this.f729ag = false;
        this.f772e = "";
        this.f773f = new ArrayList<>();
        this.f774g = new ArrayList<>();
        this.f775h = new ArrayList<>();
        this.f776i = new HashMap<>();
        this.f777j = new HashMap<>();
        this.f730ah = new int[]{0, 1, 3, 4, 6, 2};
        this.f779l = "Already exists same pen setting";
        this.f780m = "Maximum number of Preset pens(%d) reached";
        this.f736an = false;
        this.f737ao = true;
        this.f742at = HttpUtil.VAL_CLOSE;
        this.f743au = "Pen type %s, thickness %d percent, transparency %d percent";
        this.f744av = "DropperView Color";
        this.f745aw = null;
        this.f746ax = new AdapterView.OnItemSelectedListener() { // from class: com.samsung.sdraw.AbstractSettingView.1
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                int i = 0;
                String str = (String) AbstractSettingView.this.f728ae.getSelectedItem();
                AbstractSettingView.this.f728ae.setContentDescription(String.format(AbstractSettingView.this.f784q.f1651s, str));
                while (true) {
                    int i2 = i;
                    if (i2 < AbstractSettingView.this.f774g.size()) {
                        if (AbstractSettingView.this.f774g.get(i2).equalsIgnoreCase(str)) {
                            AbstractSettingView.this.m704a(AbstractSettingView.this.f773f.get(i2));
                        }
                        i = i2 + 1;
                    } else {
                        return;
                    }
                }
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        };
        this.f747ay = new View.OnClickListener() { // from class: com.samsung.sdraw.AbstractSettingView.12
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (!v.isSelected()) {
                    if (AbstractSettingView.this.f793z != null) {
                        AbstractSettingView.this.f793z.m977b(AbstractSettingView.this.f697a);
                    }
                    AbstractSettingView.this.m691a(v);
                    if (AbstractSettingView.this.f793z != null) {
                        AbstractSettingView.this.f793z.m972a(AbstractSettingView.this.f697a);
                    }
                    AbstractSettingView.this.f778k.moveScrollControlThumb(AbstractSettingView.this.f782o.f1695aj.getScrollY(), true);
                }
            }
        };
        this.f748az = new View.OnClickListener() { // from class: com.samsung.sdraw.AbstractSettingView.23
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                AbstractSettingView.this.m708b(v);
            }
        };
        this.f698aA = new View.OnClickListener() { // from class: com.samsung.sdraw.AbstractSettingView.28
            @Override // android.view.View.OnClickListener
            public void onClick(View v) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                if (AbstractSettingView.this.f793z != null) {
                    AbstractSettingView.this.f793z.m970a(v);
                }
                if (!v.equals(AbstractSettingView.this.f688P)) {
                    if (!v.equals(AbstractSettingView.this.f689Q)) {
                        if (!v.equals(AbstractSettingView.this.f690R)) {
                            if (v.equals(AbstractSettingView.this.f691S)) {
                                AbstractSettingView.this.m788i().setVisibility(4);
                                if (AbstractSettingView.this.f717aT == null) {
                                    return;
                                }
                                AbstractSettingView.this.f717aT.mo809d(false);
                                return;
                            }
                            return;
                        }
                        AbstractSettingView.this.m787h().setVisibility(4);
                        if (AbstractSettingView.this.f717aT == null) {
                            return;
                        }
                        AbstractSettingView.this.f717aT.mo808c(false);
                        return;
                    }
                    AbstractSettingView.this.m789j().setVisibility(4);
                    if (AbstractSettingView.this.f717aT == null) {
                        return;
                    }
                    AbstractSettingView.this.f717aT.mo807b(false);
                    return;
                }
                AbstractSettingView.this.m786g().setVisibility(4);
                if (AbstractSettingView.this.f717aT == null) {
                    return;
                }
                AbstractSettingView.this.f717aT.mo806a(false);
            }
        };
        this.f699aB = new SeekBar.OnSeekBarChangeListener() { // from class: com.samsung.sdraw.AbstractSettingView.29
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (AbstractSettingView.this.f692T != null) {
                    AbstractSettingView.this.f692T.onPenWidthChanged(AbstractSettingView.this.f697a.getPenWidth());
                }
                if (AbstractSettingView.this.f771d != null) {
                    AbstractSettingView.this.f771d.onPenWidthChanged(AbstractSettingView.this.f697a.getPenWidth());
                }
                if (AbstractSettingView.this.f793z != null) {
                    AbstractSettingView.this.f793z.m977b(AbstractSettingView.this.f697a);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int progress2 = progress + 1;
                if (AbstractSettingView.this.f674B != null) {
                    AbstractSettingView.this.f674B.setPenWidth(progress2);
                    if (AbstractSettingView.this.f782o != null) {
                        AbstractSettingView.this.f674B.setDescription(AbstractSettingView.this.f782o.f1494h, AbstractSettingView.this.f782o.f1495i, AbstractSettingView.this.f782o.f1496j, AbstractSettingView.this.f782o.f1497k, AbstractSettingView.this.f782o.f1498l, AbstractSettingView.this.f782o.f1499m);
                    }
                }
                if (AbstractSettingView.this.f697a != null) {
                    AbstractSettingView.this.f697a.setPenWidth(progress2);
                    if (AbstractSettingView.this.f782o != null) {
                        AbstractSettingView.this.f782o.mo1308a(AbstractSettingView.this.f697a.getPenType(), AbstractSettingView.this.f697a.getPenColor(), AbstractSettingView.this.f697a.getPenAlpha(), AbstractSettingView.this.f697a.getPenWidth());
                        int max = (progress2 * 100) / AbstractSettingView.this.f678F.getMax();
                        if (max > 100) {
                            max = 100;
                        }
                        AbstractSettingView.this.f678F.setContentDescription(String.format(AbstractSettingView.this.f782o.f1490d, Integer.valueOf(max)));
                    }
                    if (AbstractSettingView.this.f673A != null && AbstractSettingView.this.f673A.stage != null) {
                        AbstractSettingView.this.f673A.setting.setStrokeWidth(AbstractSettingView.this.f697a.getPenWidth());
                    }
                }
            }
        };
        this.f700aC = new SeekBar.OnSeekBarChangeListener() { // from class: com.samsung.sdraw.AbstractSettingView.30
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (AbstractSettingView.this.f692T != null) {
                    AbstractSettingView.this.f692T.onPenAlphaChanged(AbstractSettingView.this.f697a.getPenAlpha());
                }
                if (AbstractSettingView.this.f771d != null) {
                    AbstractSettingView.this.f771d.onPenAlphaChanged(AbstractSettingView.this.f697a.getPenAlpha());
                }
                if (AbstractSettingView.this.f793z != null) {
                    AbstractSettingView.this.f793z.m977b(AbstractSettingView.this.f697a);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (AbstractSettingView.this.f674B != null) {
                    AbstractSettingView.this.f674B.setPenAlpha(progress);
                    if (AbstractSettingView.this.f782o != null) {
                        AbstractSettingView.this.f674B.setDescription(AbstractSettingView.this.f782o.f1494h, AbstractSettingView.this.f782o.f1495i, AbstractSettingView.this.f782o.f1496j, AbstractSettingView.this.f782o.f1497k, AbstractSettingView.this.f782o.f1498l, AbstractSettingView.this.f782o.f1499m);
                    }
                }
                if (AbstractSettingView.this.f697a != null) {
                    AbstractSettingView.this.f697a.setPenAlpha(progress);
                    if (AbstractSettingView.this.f782o != null) {
                        AbstractSettingView.this.f782o.mo1308a(AbstractSettingView.this.f697a.getPenType(), AbstractSettingView.this.f697a.getPenColor(), AbstractSettingView.this.f697a.getPenAlpha(), AbstractSettingView.this.f697a.getPenWidth());
                        int max = (progress * 100) / AbstractSettingView.this.f679G.getMax();
                        if (max > 100) {
                            max = 100;
                        }
                        AbstractSettingView.this.f679G.setContentDescription(String.format(AbstractSettingView.this.f782o.f1491e, Integer.valueOf(max)));
                    }
                    if (AbstractSettingView.this.f673A != null && AbstractSettingView.this.f673A.setting != null) {
                        AbstractSettingView.this.f673A.setting.setStrokeColor(AbstractSettingView.this.f697a.getPenAlphaColor());
                    }
                    if (AbstractSettingView.this.f782o != null && AbstractSettingView.this.f782o.f1455F != null) {
                        AbstractSettingView.this.f782o.f1455F.setColor(AbstractSettingView.this.f697a.getPenAlphaColor());
                    }
                }
            }
        };
        this.f701aD = new SeekBar.OnSeekBarChangeListener() { // from class: com.samsung.sdraw.AbstractSettingView.31
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (AbstractSettingView.this.f692T != null) {
                    AbstractSettingView.this.f692T.onEraserWidthChanged(AbstractSettingView.this.f697a.getEraserWidth());
                }
                if (AbstractSettingView.this.f771d != null) {
                    AbstractSettingView.this.f771d.onEraserWidthChanged(AbstractSettingView.this.f697a.getEraserWidth());
                }
                if (AbstractSettingView.this.f793z != null && AbstractSettingView.this.f793z.f881a != null) {
                    AbstractSettingView.this.f793z.f881a.setEraserWidth(AbstractSettingView.this.f697a.getEraserWidth());
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (AbstractSettingView.this.f697a != null) {
                    AbstractSettingView.this.f697a.setEraserWidth(progress);
                    if (AbstractSettingView.this.f673A != null && AbstractSettingView.this.f673A.setting != null && AbstractSettingView.this.f673A.setting.getStrokeType() == StrokeSprite.Type.Eraser) {
                        AbstractSettingView.this.f673A.setting.setEraserWidth(AbstractSettingView.this.f697a.getEraserWidth());
                    }
                    if (AbstractSettingView.this.f783p != null) {
                        AbstractSettingView.this.f783p.mo1569a(progress);
                        int max = (progress * 100) / AbstractSettingView.this.f686N.getMax();
                        AbstractSettingView.this.f686N.setContentDescription(String.format(AbstractSettingView.this.f783p.f1757d, Integer.valueOf(max <= 100 ? max : 100)));
                    }
                }
            }
        };
        this.f702aE = new AdapterView.OnItemSelectedListener() { // from class: com.samsung.sdraw.AbstractSettingView.32
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                Object selectedItem;
                int i = 0;
                int i2 = 0;
                while (true) {
                    if (i2 >= AbstractSettingView.this.f775h.size()) {
                        break;
                    }
                    if (((Spinner) AbstractSettingView.this.f677E[0]) == null || (selectedItem = ((Spinner) AbstractSettingView.this.f677E[0]).getSelectedItem()) == null || !selectedItem.equals(AbstractSettingView.this.f775h.get(i2))) {
                        i2++;
                    } else {
                        int i3 = i2 + 5;
                        if (AbstractSettingView.this.f784q != null) {
                            ((Spinner) AbstractSettingView.this.f677E[0]).setContentDescription(String.format(AbstractSettingView.this.f784q.f1652t, Integer.valueOf(i3)));
                            i = i3;
                        } else {
                            i = i3;
                        }
                    }
                }
                if (AbstractSettingView.this.f675C != null) {
                    AbstractSettingView.this.f675C.m1439b(i);
                    if (AbstractSettingView.this.f784q != null) {
                        AbstractSettingView.this.f675C.m1437a(AbstractSettingView.this.f784q.f1649q, (String) AbstractSettingView.this.f728ae.getSelectedItem());
                    }
                }
                if (AbstractSettingView.this.f749b != null) {
                    AbstractSettingView.this.f749b.setTextSize(i);
                    if (AbstractSettingView.this.f784q != null) {
                        AbstractSettingView.this.f784q.mo1464a(AbstractSettingView.this.f749b.getTextType(), AbstractSettingView.this.f749b.getTextColor(), AbstractSettingView.this.f749b.getTextSize());
                    }
                    if (AbstractSettingView.this.f673A != null && AbstractSettingView.this.f673A.stage != null) {
                        AbstractSettingView.this.f673A.setting.setTextSize(AbstractSettingView.this.f749b.getTextSize());
                    }
                }
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        };
        this.f703aF = new C1050f.a() { // from class: com.samsung.sdraw.AbstractSettingView.33
            @Override // com.samsung.sdraw.C1050f.a
            /* renamed from: a */
            public void mo800a(int i, int i2, int i3) {
                if (AbstractSettingView.this.f749b != null) {
                    AbstractSettingView.this.f749b.m1184a(i2, i3);
                    AbstractSettingView.this.f749b.setTextColor(i);
                    if (AbstractSettingView.this.f675C != null) {
                        AbstractSettingView.this.f675C.m1440c(i);
                    }
                    if (AbstractSettingView.this.f682J != null) {
                        AbstractSettingView.this.f682J.m1552a(i);
                    }
                    if (AbstractSettingView.this.f784q != null) {
                        if (AbstractSettingView.this.f784q.f1613I != null) {
                            AbstractSettingView.this.f784q.f1613I.setColor((-16777216) | (16777215 & i));
                        }
                        AbstractSettingView.this.f784q.mo1464a(AbstractSettingView.this.f749b.getTextType(), AbstractSettingView.this.f749b.getTextColor(), AbstractSettingView.this.f749b.getTextSize());
                    }
                    if (AbstractSettingView.this.f673A != null && AbstractSettingView.this.f673A.setting != null) {
                        AbstractSettingView.this.f673A.setting.setTextColor(AbstractSettingView.this.f749b.getTextColor());
                    }
                }
            }
        };
        this.f704aG = new C1050f.a() { // from class: com.samsung.sdraw.AbstractSettingView.2
            @Override // com.samsung.sdraw.C1050f.a
            /* renamed from: a */
            public void mo800a(int i, int i2, int i3) {
                if (AbstractSettingView.this.f770c != null) {
                    AbstractSettingView.this.f770c.m996a(i2, i3);
                    AbstractSettingView.this.f770c.m995a((-33554432) | (16777215 & i));
                    AbstractSettingView.this.f770c.setFillingColor(i);
                    if (AbstractSettingView.this.f684L != null) {
                        AbstractSettingView.this.f684L.m1552a(i);
                    }
                    if (AbstractSettingView.this.f673A != null && AbstractSettingView.this.f673A.setting != null) {
                        AbstractSettingView.this.f673A.setting.setFillingColor(AbstractSettingView.this.f770c.getFillingColor());
                    }
                    if (AbstractSettingView.this.f771d != null) {
                        AbstractSettingView.this.f771d.onFillingColorChanged(AbstractSettingView.this.f770c.getFillingColor());
                    }
                }
            }
        };
        this.f705aH = new C1051g.a() { // from class: com.samsung.sdraw.AbstractSettingView.3
            @Override // com.samsung.sdraw.C1051g.a
            /* renamed from: a */
            public void mo804a(int i, int i2, boolean z) {
                if ((i2 == AbstractSettingView.this.f682J.m1555b() - 1 || i2 == -1) && AbstractSettingView.this.f784q != null && AbstractSettingView.this.f784q.f1612H.getVisibility() == 8) {
                    AbstractSettingView.this.f784q.m1491b(true);
                    if (!z) {
                        return;
                    }
                }
                if (AbstractSettingView.this.f749b != null) {
                    if (AbstractSettingView.this.f675C != null) {
                        AbstractSettingView.this.f675C.m1440c(i);
                    }
                    if (AbstractSettingView.this.f784q != null) {
                        if (AbstractSettingView.this.f784q.f1613I != null) {
                            AbstractSettingView.this.f784q.f1613I.setColor((-16777216) | (16777215 & i));
                        }
                        AbstractSettingView.this.f784q.mo1464a(AbstractSettingView.this.f749b.getTextType(), i, AbstractSettingView.this.f749b.getTextSize());
                    }
                    AbstractSettingView.this.f749b.setTextColor(i);
                    if (AbstractSettingView.this.f673A != null && AbstractSettingView.this.f673A.setting != null) {
                        AbstractSettingView.this.f673A.setting.setTextColor(AbstractSettingView.this.f749b.getTextColor());
                    }
                }
            }
        };
        this.f706aI = new C1051g.a() { // from class: com.samsung.sdraw.AbstractSettingView.4
            @Override // com.samsung.sdraw.C1051g.a
            /* renamed from: a */
            public void mo804a(int i, int i2, boolean z) {
                if ((i2 == AbstractSettingView.this.f684L.m1555b() - 1 || i2 == -1) && AbstractSettingView.this.f785r.f1792j.getVisibility() == 8) {
                    AbstractSettingView.this.setPalletViewState(true, 4);
                    if (!z) {
                        return;
                    }
                }
                if (AbstractSettingView.this.f770c != null) {
                    if (AbstractSettingView.this.f673A != null && AbstractSettingView.this.f673A.setting != null) {
                        AbstractSettingView.this.f673A.setting.setFillingColor(AbstractSettingView.this.f770c.getFillingColor());
                    }
                    if (i == AbstractSettingView.this.f684L.m1556c()) {
                        AbstractSettingView.this.f770c.m995a((-33554432) | (16777215 & i));
                    } else {
                        AbstractSettingView.this.f770c.m995a((-16777216) | (16777215 & i));
                    }
                    AbstractSettingView.this.f770c.setFillingColor(i);
                    if (AbstractSettingView.this.f771d != null) {
                        AbstractSettingView.this.f771d.onFillingColorChanged(AbstractSettingView.this.f770c.getFillingColor());
                    }
                }
            }
        };
        this.f707aJ = new C1050f.a() { // from class: com.samsung.sdraw.AbstractSettingView.5
            @Override // com.samsung.sdraw.C1050f.a
            /* renamed from: a */
            public void mo800a(int i, int i2, int i3) {
                if (AbstractSettingView.this.f697a != null) {
                    AbstractSettingView.this.f697a.m1022a(i2, i3);
                    AbstractSettingView.this.f697a.m1025b((-33554432) | (16777215 & i));
                    AbstractSettingView.this.f697a.setPenColor(i);
                    if (AbstractSettingView.this.f674B != null) {
                        AbstractSettingView.this.f674B.setPenColor(i);
                    }
                    if (AbstractSettingView.this.f680H != null) {
                        AbstractSettingView.this.f680H.m1552a(AbstractSettingView.this.f697a.m1021a());
                    }
                    if (AbstractSettingView.this.f782o != null) {
                        if (AbstractSettingView.this.f782o.f1454E != null) {
                            AbstractSettingView.this.f782o.f1454E.setColor((i & 16777215) | (-16777216));
                        }
                        if (AbstractSettingView.this.f782o.f1455F != null) {
                            AbstractSettingView.this.f782o.f1455F.setColor(AbstractSettingView.this.f697a.getPenAlphaColor());
                        }
                        AbstractSettingView.this.f782o.mo1308a(AbstractSettingView.this.f697a.getPenType(), AbstractSettingView.this.f697a.getPenColor(), AbstractSettingView.this.f697a.getPenAlpha(), AbstractSettingView.this.f697a.getPenWidth());
                    }
                    if (AbstractSettingView.this.f673A != null && AbstractSettingView.this.f673A.setting != null) {
                        AbstractSettingView.this.f673A.setting.setStrokeColor(AbstractSettingView.this.f697a.getPenAlphaColor());
                    }
                    if (AbstractSettingView.this.f692T != null) {
                        AbstractSettingView.this.f692T.onColorChanged(((AbstractSettingView.this.f697a.getPenAlpha() << 24) & (-16777216)) | AbstractSettingView.this.f697a.getPenColor());
                    }
                    if (AbstractSettingView.this.f771d != null) {
                        AbstractSettingView.this.f771d.onPenColorChanged(((AbstractSettingView.this.f697a.getPenAlpha() << 24) & (-16777216)) | AbstractSettingView.this.f697a.getPenColor());
                    }
                    if (AbstractSettingView.this.f793z != null) {
                        AbstractSettingView.this.f793z.m977b(AbstractSettingView.this.f697a);
                    }
                }
            }
        };
        this.f708aK = new C1051g.a() { // from class: com.samsung.sdraw.AbstractSettingView.6
            @Override // com.samsung.sdraw.C1051g.a
            /* renamed from: a */
            public void mo804a(int i, int i2, boolean z) {
                if ((i2 == AbstractSettingView.this.f680H.m1555b() - 1 || i2 == -1) && AbstractSettingView.this.f782o != null && AbstractSettingView.this.f782o.f1453D.getVisibility() == 8) {
                    AbstractSettingView.this.setPalletViewState(true, 1);
                    AbstractSettingView.this.f778k.relayoutSettingView(AbstractSettingView.this.getContext().getResources().getDisplayMetrics().widthPixels < AbstractSettingView.this.getResources().getDisplayMetrics().heightPixels, false);
                    AbstractSettingView.this.f778k.setScrollToMax();
                    if (!z) {
                        return;
                    }
                }
                if (AbstractSettingView.this.f697a != null) {
                    if (AbstractSettingView.this.f674B != null) {
                        AbstractSettingView.this.f674B.setPenColor(i);
                    }
                    if (AbstractSettingView.this.f782o != null) {
                        if (AbstractSettingView.this.f782o.f1454E != null) {
                            AbstractSettingView.this.f782o.f1454E.setColor((i & 16777215) | (-16777216));
                        }
                        if (AbstractSettingView.this.f782o.f1455F != null) {
                            AbstractSettingView.this.f782o.f1455F.setColor(AbstractSettingView.this.f697a.getPenAlphaColor());
                        }
                        AbstractSettingView.this.f782o.mo1308a(AbstractSettingView.this.f697a.getPenType(), i, AbstractSettingView.this.f697a.getPenAlpha(), AbstractSettingView.this.f697a.getPenWidth());
                    }
                    if (i == AbstractSettingView.this.f680H.m1556c()) {
                        AbstractSettingView.this.f697a.m1025b((-33554432) | (16777215 & i));
                    } else {
                        AbstractSettingView.this.f697a.m1025b((16777215 & i) | (-16777216));
                    }
                    AbstractSettingView.this.f697a.setPenColor(i);
                    if (AbstractSettingView.this.f673A != null && AbstractSettingView.this.f673A.setting != null) {
                        AbstractSettingView.this.f673A.setting.setStrokeColor(AbstractSettingView.this.f697a.getPenAlphaColor());
                    }
                    if (AbstractSettingView.this.f782o != null && AbstractSettingView.this.f782o.f1455F != null) {
                        AbstractSettingView.this.f782o.f1455F.setColor(AbstractSettingView.this.f697a.getPenAlphaColor());
                    }
                    if (AbstractSettingView.this.f692T != null) {
                        AbstractSettingView.this.f692T.onColorChanged(((AbstractSettingView.this.f697a.getPenAlpha() << 24) & (-16777216)) | AbstractSettingView.this.f697a.getPenColor());
                    }
                    if (AbstractSettingView.this.f771d != null) {
                        AbstractSettingView.this.f771d.onPenColorChanged(((AbstractSettingView.this.f697a.getPenAlpha() << 24) & (-16777216)) | AbstractSettingView.this.f697a.getPenColor());
                    }
                    if (AbstractSettingView.this.f793z != null) {
                        AbstractSettingView.this.f793z.m977b(AbstractSettingView.this.f697a);
                    }
                }
            }
        };
        this.f709aL = new View.OnClickListener() { // from class: com.samsung.sdraw.AbstractSettingView.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                boolean zOnDeleteAllConfirm = false;
                zOnDeleteAllConfirm = false;
                if (AbstractSettingView.this.f673A == null) {
                    return;
                }
                if (AbstractSettingView.this.f753bd != null && AbstractSettingView.this.f673A.stage != null) {
                    zOnDeleteAllConfirm = AbstractSettingView.this.f753bd.onDeleteAllConfirm(AbstractSettingView.this.f673A.stage.getSelectedLayerID() == 3 ? 1 : 0);
                }
                if (!zOnDeleteAllConfirm && AbstractSettingView.this.f673A.setting != null && AbstractSettingView.this.f723aZ) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                    if (AbstractSettingView.this.f776i.containsKey(SCanvasConstants.LAYOUT_ERASER_DELETEALL_POPUP_ICON)) {
                        if (AbstractSettingView.this.f776i.get(SCanvasConstants.LAYOUT_ERASER_DELETEALL_POPUP_ICON).intValue() != -1) {
                            builder.setIcon(AbstractSettingView.this.f776i.get(SCanvasConstants.LAYOUT_ERASER_DELETEALL_POPUP_ICON).intValue());
                        }
                    } else {
                        builder.setIcon(R.drawable.ic_dialog_alert);
                    }
                    if (AbstractSettingView.this.f776i.containsKey(SCanvasConstants.LOCALE_ERASER_SETTING_CLEARALL)) {
                        builder.setTitle(AbstractSettingView.this.f776i.get(SCanvasConstants.LOCALE_ERASER_SETTING_CLEARALL).intValue());
                    } else if (AbstractSettingView.this.f776i.containsKey(SCanvasConstants.LOCALE_ERASER_SETTING_DELETEALL)) {
                        builder.setTitle(AbstractSettingView.this.f776i.get(SCanvasConstants.LOCALE_ERASER_SETTING_DELETEALL).intValue());
                    } else {
                        builder.setTitle("Delete all");
                    }
                    if (AbstractSettingView.this.f776i.containsKey(SCanvasConstants.LOCALE_ERASER_SETTING_CLEARALL_MESSAGE)) {
                        builder.setMessage(AbstractSettingView.this.f776i.get(SCanvasConstants.LOCALE_ERASER_SETTING_CLEARALL_MESSAGE).intValue());
                    } else if (AbstractSettingView.this.f776i.containsKey(SCanvasConstants.LOCALE_ERASER_SETTING_DELETEALL_MESSAGE)) {
                        builder.setMessage(AbstractSettingView.this.f776i.get(SCanvasConstants.LOCALE_ERASER_SETTING_DELETEALL_MESSAGE).intValue());
                    } else {
                        builder.setMessage("All data will be deleted");
                    }
                    builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() { // from class: com.samsung.sdraw.AbstractSettingView.7.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface arg0, int arg1) {
                            if (AbstractSettingView.this.f771d != null) {
                                AbstractSettingView.this.f771d.onClearAll(false);
                                AbstractSettingView.this.f771d.onDeleteAll(false);
                            }
                            if (AbstractSettingView.this.f673A != null) {
                                ((CanvasView) AbstractSettingView.this.f673A.view).deleteAll(true);
                            }
                            if (AbstractSettingView.this.f692T != null) {
                                AbstractSettingView.this.f692T.onClearAll();
                            }
                            if (AbstractSettingView.this.f771d != null) {
                                AbstractSettingView.this.f771d.onClearAll(true);
                                AbstractSettingView.this.f771d.onDeleteAll(true);
                            }
                        }
                    });
                    builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() { // from class: com.samsung.sdraw.AbstractSettingView.7.2
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface arg0, int arg1) {
                        }
                    });
                    builder.setCancelable(true);
                    builder.create().show();
                }
            }
        };
        this.f710aM = new View.OnClickListener() { // from class: com.samsung.sdraw.AbstractSettingView.8
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (AbstractSettingView.this.f782o != null && AbstractSettingView.this.f782o.f1453D != null) {
                    if (AbstractSettingView.this.f782o.f1453D.getVisibility() == 8) {
                        AbstractSettingView.this.setPalletViewState(true, 1);
                        v.setSelected(false);
                        AbstractSettingView.this.f778k.setScrollToMax();
                    } else {
                        AbstractSettingView.this.setPalletViewState(false, 1);
                        v.setSelected(true);
                    }
                }
                if (AbstractSettingView.this.f785r != null && AbstractSettingView.this.f785r.f1792j != null) {
                    if (AbstractSettingView.this.f785r.f1792j.getVisibility() == 8) {
                        AbstractSettingView.this.setPalletViewState(true, 4);
                        v.setSelected(false);
                    } else {
                        AbstractSettingView.this.setPalletViewState(false, 4);
                        v.setSelected(true);
                    }
                }
            }
        };
        this.f711aN = new View.OnFocusChangeListener() { // from class: com.samsung.sdraw.AbstractSettingView.9
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View arg0, boolean arg1) {
                if (arg0.equals(AbstractSettingView.this.f784q.f1616L) && arg1) {
                    AbstractSettingView.this.f784q.f1616L.setSelected(true);
                    AbstractSettingView.this.f784q.f1617M.setSelected(false);
                    AbstractSettingView.this.f784q.mo1463a(0);
                } else if (arg0.equals(AbstractSettingView.this.f784q.f1617M) && arg1) {
                    AbstractSettingView.this.f784q.f1616L.setSelected(false);
                    AbstractSettingView.this.f784q.f1617M.setSelected(true);
                    AbstractSettingView.this.f784q.mo1463a(1);
                }
                AbstractSettingView.this.m770a(3, true);
            }
        };
        this.f712aO = new View.OnClickListener() { // from class: com.samsung.sdraw.AbstractSettingView.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (v.equals(AbstractSettingView.this.f784q.f1616L)) {
                    AbstractSettingView.this.f784q.f1616L.setSelected(true);
                    AbstractSettingView.this.f784q.f1617M.setSelected(false);
                    AbstractSettingView.this.f784q.mo1463a(0);
                } else if (v.equals(AbstractSettingView.this.f784q.f1617M)) {
                    AbstractSettingView.this.f784q.f1616L.setSelected(false);
                    AbstractSettingView.this.f784q.f1617M.setSelected(true);
                    AbstractSettingView.this.f784q.mo1463a(1);
                }
                AbstractSettingView.this.m770a(3, true);
            }
        };
        this.f713aP = new View.OnClickListener() { // from class: com.samsung.sdraw.AbstractSettingView.11
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (AbstractSettingView.this.f784q != null && AbstractSettingView.this.f784q.f1608D != null && AbstractSettingView.this.f784q.f1609E != null && AbstractSettingView.this.f784q.f1610F != null) {
                    if (v.equals(AbstractSettingView.this.f784q.f1608D)) {
                        AbstractSettingView.this.f784q.f1608D.setSelected(true);
                        AbstractSettingView.this.f784q.f1609E.setSelected(false);
                        AbstractSettingView.this.f784q.f1610F.setSelected(false);
                        AbstractSettingView.this.f749b.setTextAlignment(Layout.Alignment.ALIGN_NORMAL);
                        return;
                    }
                    if (v.equals(AbstractSettingView.this.f784q.f1609E)) {
                        AbstractSettingView.this.f784q.f1608D.setSelected(false);
                        AbstractSettingView.this.f784q.f1609E.setSelected(true);
                        AbstractSettingView.this.f784q.f1610F.setSelected(false);
                        AbstractSettingView.this.f749b.setTextAlignment(Layout.Alignment.ALIGN_CENTER);
                        return;
                    }
                    if (v.equals(AbstractSettingView.this.f784q.f1610F)) {
                        AbstractSettingView.this.f784q.f1608D.setSelected(false);
                        AbstractSettingView.this.f784q.f1609E.setSelected(false);
                        AbstractSettingView.this.f784q.f1610F.setSelected(true);
                        AbstractSettingView.this.f749b.setTextAlignment(Layout.Alignment.ALIGN_OPPOSITE);
                    }
                }
            }
        };
        this.f715aR = new TextSettingInfo.InterfaceC0986b() { // from class: com.samsung.sdraw.AbstractSettingView.13
            @Override // com.samsung.sdraw.TextSettingInfo.InterfaceC0986b
            /* renamed from: a */
            public void mo794a(int i) {
                AbstractSettingView.this.m684F();
                if (AbstractSettingView.this.f673A != null) {
                    ((CanvasView) AbstractSettingView.this.f673A.view).m973a(AbstractSettingView.this.f749b, 0);
                }
                if (AbstractSettingView.this.f771d != null) {
                    AbstractSettingView.this.f771d.onTextTypeChanged(i);
                }
            }

            @Override // com.samsung.sdraw.TextSettingInfo.InterfaceC0986b
            /* renamed from: b */
            public void mo797b(int i) {
                AbstractSettingView.this.m684F();
                if (AbstractSettingView.this.f673A != null) {
                    ((CanvasView) AbstractSettingView.this.f673A.view).m973a(AbstractSettingView.this.f749b, 1);
                }
                if (AbstractSettingView.this.f682J != null) {
                    AbstractSettingView.this.f682J.m1552a(i);
                }
                if (AbstractSettingView.this.f771d != null) {
                    AbstractSettingView.this.f771d.onTextColorChanged(i);
                }
            }

            @Override // com.samsung.sdraw.TextSettingInfo.InterfaceC0986b
            /* renamed from: c */
            public void mo798c(int i) {
                AbstractSettingView.this.m684F();
                if (AbstractSettingView.this.f673A != null) {
                    ((CanvasView) AbstractSettingView.this.f673A.view).m973a(AbstractSettingView.this.f749b, 2);
                }
                if (AbstractSettingView.this.f771d != null) {
                    AbstractSettingView.this.f771d.onTextSizeChanged(i);
                }
            }

            @Override // com.samsung.sdraw.TextSettingInfo.InterfaceC0986b
            /* renamed from: a */
            public void mo796a(String str) {
                AbstractSettingView.this.m684F();
                if (AbstractSettingView.this.f673A != null) {
                    ((CanvasView) AbstractSettingView.this.f673A.view).m973a(AbstractSettingView.this.f749b, 3);
                }
                if (AbstractSettingView.this.f771d != null) {
                    AbstractSettingView.this.f771d.onTextFontChanged(str);
                }
            }

            @Override // com.samsung.sdraw.TextSettingInfo.InterfaceC0986b
            /* renamed from: a */
            public void mo795a(Layout.Alignment alignment) {
                AbstractSettingView.this.m684F();
                if (AbstractSettingView.this.f673A != null) {
                    ((CanvasView) AbstractSettingView.this.f673A.view).m973a(AbstractSettingView.this.f749b, 4);
                }
                if (AbstractSettingView.this.f771d != null) {
                    AbstractSettingView.this.f771d.onTextAlignmentChanged(alignment);
                }
            }
        };
        this.f716aS = new FillingSettingInfo.InterfaceC0974b() { // from class: com.samsung.sdraw.AbstractSettingView.14
            @Override // com.samsung.sdraw.FillingSettingInfo.InterfaceC0974b
            /* renamed from: a */
            public void mo799a(int i) {
                AbstractSettingView.this.m685G();
                if (AbstractSettingView.this.f771d != null) {
                    AbstractSettingView.this.f771d.onFillingColorChanged(i);
                }
            }
        };
        this.f718aU = "Insert Text";
        this.f719aV = 0;
        this.f720aW = 0;
        this.f721aX = 0;
        this.f722aY = 0;
        this.f723aZ = true;
        this.f750ba = new View.OnClickListener() { // from class: com.samsung.sdraw.AbstractSettingView.15
            @Override // android.view.View.OnClickListener
            public void onClick(View v) throws Throwable {
                C1005ar c1005ar = new C1005ar();
                int penType = AbstractSettingView.this.f697a.getPenType();
                c1005ar.m1387d(penType);
                c1005ar.m1383b(AbstractSettingView.this.f697a.getPenWidth(penType));
                c1005ar.m1389e(AbstractSettingView.this.f697a.getPenColor(penType));
                c1005ar.m1385c(AbstractSettingView.this.f697a.getPenAlpha(penType));
                if (!AbstractSettingView.this.f731ai.m1044b(c1005ar)) {
                    AbstractSettingView.this.m700a(c1005ar, false);
                    AbstractSettingView.this.f731ai.m1040a(c1005ar);
                } else {
                    AbstractSettingView.this.m687I();
                }
                if (AbstractSettingView.this.f731ai.m1042b().size() >= 12 && AbstractSettingView.this.f737ao) {
                    Toast.makeText(AbstractSettingView.this.getContext(), String.format(AbstractSettingView.this.f780m, 12), 0).show();
                }
            }
        };
        this.f751bb = new PresetLinearLayout.OnClickPresetItemListener() { // from class: com.samsung.sdraw.AbstractSettingView.16
            @Override // com.samsung.sdraw.PresetLinearLayout.OnClickPresetItemListener
            public void selectPresetItem(int index) {
                if (index == -1) {
                    AbstractSettingView.this.m727e(AbstractSettingView.this.f761bl);
                } else {
                    AbstractSettingView.this.m727e(index);
                }
            }

            @Override // com.samsung.sdraw.PresetLinearLayout.OnClickPresetItemListener
            public void deletePresetItem(int index) {
                if (!AbstractSettingView.this.f766bq) {
                    AbstractSettingView.this.m730f(index);
                } else {
                    if (AbstractSettingView.this.f767br == null) {
                        return;
                    }
                    AbstractSettingView.this.f767br.onClick(index);
                }
            }
        };
        this.f787t = "Selected pen preset will be permanently erased";
        this.f788u = "Delete";
        this.f752bc = new PresetDataManager.NotifyListener() { // from class: com.samsung.sdraw.AbstractSettingView.17
            @Override // com.samsung.sdraw.PresetDataManager.NotifyListener
            public void dataChanged(int presetCount) {
                AbstractSettingView.this.m686H();
            }
        };
        this.f753bd = null;
        this.f790w = 10;
        this.f754be = new View.OnTouchListener() { // from class: com.samsung.sdraw.AbstractSettingView.18
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent event) {
                AbstractSettingView.this.f778k.onScroll(event, true);
                return true;
            }
        };
        this.f755bf = new View.OnTouchListener() { // from class: com.samsung.sdraw.AbstractSettingView.19
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent event) {
                AbstractSettingView.this.f778k.onScroll(event, false);
                return true;
            }
        };
        this.f756bg = new PenSettingScrollView.InterfaceC0978a() { // from class: com.samsung.sdraw.AbstractSettingView.20
            @Override // com.samsung.sdraw.PenSettingScrollView.InterfaceC0978a
            /* renamed from: a */
            public void mo801a(int i) {
                AbstractSettingView.this.f778k.moveScrollControlThumb(i, true);
            }
        };
        this.f757bh = new PenSettingScrollView.InterfaceC0978a() { // from class: com.samsung.sdraw.AbstractSettingView.21
            @Override // com.samsung.sdraw.PenSettingScrollView.InterfaceC0978a
            /* renamed from: a */
            public void mo801a(int i) {
                AbstractSettingView.this.f778k.moveScrollControlThumb(i, false);
            }
        };
        this.f758bi = new PalletView.InterfaceC0975a() { // from class: com.samsung.sdraw.AbstractSettingView.22
            @Override // com.samsung.sdraw.PalletView.InterfaceC0975a
            /* renamed from: a */
            public void mo802a(boolean z, int i, int i2, int i3, int i4) {
                AbstractSettingView.this.f778k.onLayout(false);
            }
        };
        this.f759bj = new PalletView.InterfaceC0975a() { // from class: com.samsung.sdraw.AbstractSettingView.24
            @Override // com.samsung.sdraw.PalletView.InterfaceC0975a
            /* renamed from: a */
            public void mo802a(boolean z, int i, int i2, int i3, int i4) {
                AbstractSettingView.this.f778k.onLayout(true);
            }
        };
        this.f760bk = false;
        this.f761bl = 0;
        this.f762bm = new PresetLinearLayout.InterfaceC0982a() { // from class: com.samsung.sdraw.AbstractSettingView.25
            @Override // com.samsung.sdraw.PresetLinearLayout.InterfaceC0982a
            /* renamed from: a */
            public void mo803a(int i, View view) {
                AbstractSettingView.this.f761bl = i;
            }
        };
        this.f764bo = false;
        this.f765bp = false;
        this.f766bq = false;
        this.f767br = null;
        this.f768bs = -1;
        this.f769bt = false;
        m769a();
    }

    /* renamed from: a */
    void m772a(CanvasView canvasView) {
        this.f793z = canvasView;
        this.f673A = canvasView.m969a();
    }

    /* renamed from: a */
    void m769a() {
        setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        this.f778k = new ScrollThumbController(this);
    }

    /* renamed from: o */
    private void m746o() {
        if (this.f731ai == null) {
            this.f731ai = new PresetDataManager();
            this.f781n = new SharedPreferencesManager(getContext());
            this.f731ai.m1039a(this.f781n);
            this.f731ai.m1045c();
        }
    }

    /* renamed from: p */
    private void m748p() throws Throwable {
        this.f732aj = (C1052h) this.f782o.m1344d();
        this.f734al = this.f782o.m1346e();
        this.f733ak = this.f782o.f1472W;
        this.f733ak.initData(this.f772e);
        if (this.f731ai.m1042b() != null) {
            m705a(this.f731ai.m1042b());
        }
        m686H();
    }

    /* renamed from: q */
    private void m750q() {
        if (this.f688P != null) {
            this.f688P.setOnClickListener(this.f698aA);
        }
        if (this.f676D != null) {
            for (int i = 0; i < 6; i++) {
                if (this.f730ah[i] <= 5 && this.f676D[this.f730ah[i]] != null) {
                    this.f676D[this.f730ah[i]].setOnClickListener(this.f747ay);
                }
            }
        }
        if (this.f678F != null) {
            this.f678F.setOnSeekBarChangeListener(this.f699aB);
        }
        if (this.f679G != null) {
            this.f679G.setOnSeekBarChangeListener(this.f700aC);
        }
        if (this.f681I != null) {
            this.f681I.m1545a(this.f707aJ);
        }
        if (this.f732aj != null) {
            this.f732aj.setOnClickListener(this.f750ba);
        }
        if (this.f733ak != null) {
            this.f733ak.setClickPresetItemListener(this.f751bb);
        }
        if (this.f731ai != null) {
            this.f731ai.m1038a(this.f752bc);
        }
    }

    /* renamed from: r */
    private void m752r() throws Throwable {
        ArrayAdapter arrayAdapter;
        ArrayAdapter arrayAdapter2;
        if (this.f690R != null) {
            this.f690R.setOnClickListener(this.f698aA);
        }
        if (this.f677E != null) {
            for (int i = 0; i < 4; i++) {
                if (this.f677E[i] != null) {
                    if (this.f677E[i] instanceof ImageButton) {
                        this.f677E[i].setOnClickListener(this.f748az);
                    } else {
                        for (int i2 = 5; i2 < 21; i2++) {
                            this.f775h.add(Integer.toString(i2));
                        }
                        if (getContext().getResources().getDisplayMetrics().densityDpi == 160) {
                            if (this.f776i.containsKey(SCanvasConstants.LAYOUT_TEXT_SPINNER_TABLET)) {
                                arrayAdapter2 = new ArrayAdapter(getContext(), this.f776i.get(SCanvasConstants.LAYOUT_TEXT_SPINNER_TABLET).intValue(), this.f775h);
                                arrayAdapter2.setDropDownViewResource(this.f776i.get(SCanvasConstants.LAYOUT_TEXT_SPINNER_TABLET).intValue());
                            } else {
                                ArrayAdapter arrayAdapter3 = new ArrayAdapter(getContext(), R.layout.simple_spinner_item, this.f775h);
                                arrayAdapter3.setDropDownViewResource(R.layout.simple_spinner_item);
                                arrayAdapter2 = arrayAdapter3;
                            }
                        } else if (this.f776i.containsKey(SCanvasConstants.LAYOUT_TEXT_SPINNER)) {
                            arrayAdapter2 = new ArrayAdapter(getContext(), this.f776i.get(SCanvasConstants.LAYOUT_TEXT_SPINNER).intValue(), this.f775h);
                            arrayAdapter2.setDropDownViewResource(this.f776i.get(SCanvasConstants.LAYOUT_TEXT_SPINNER).intValue());
                        } else {
                            ArrayAdapter arrayAdapter4 = new ArrayAdapter(getContext(), R.layout.simple_spinner_item, this.f775h);
                            arrayAdapter4.setDropDownViewResource(R.layout.simple_spinner_item);
                            arrayAdapter2 = arrayAdapter4;
                        }
                        ((Spinner) this.f677E[i]).setAdapter((SpinnerAdapter) arrayAdapter2);
                        ((Spinner) this.f677E[i]).setOnItemSelectedListener(this.f702aE);
                    }
                }
            }
        }
        if (this.f728ae != null) {
            File[] fileArrListFiles = new File("/system/fonts/").listFiles();
            if (fileArrListFiles != null) {
                for (File file : fileArrListFiles) {
                    if (file.getName().endsWith("DroidSans.ttf")) {
                        C1040bz.f1672b.put("Sans serif", "/system/fonts/DroidSans.ttf");
                        this.f774g.add("Sans serif");
                        this.f773f.add("Sans serif");
                    } else if (file.getName().endsWith("DroidSerif-Regular.ttf")) {
                        C1040bz.f1672b.put("Serif", "/system/fonts/DroidSerif-Regular.ttf");
                        this.f774g.add("Serif");
                        this.f773f.add("Serif");
                    } else if (file.getName().endsWith("DroidSansMono.ttf")) {
                        C1040bz.f1672b.put("Monospace", "/system/fonts/DroidSansMono.ttf");
                        this.f774g.add("Monospace");
                        this.f773f.add("Monospace");
                    }
                }
            }
            m757u();
            C1040bz.f1673c = new ArrayList<>(this.f774g);
            if (getContext().getResources().getDisplayMetrics().densityDpi == 160) {
                if (this.f776i.containsKey(SCanvasConstants.LAYOUT_TEXT_SPINNER_TABLET)) {
                    ArrayAdapter arrayAdapter5 = new ArrayAdapter(getContext(), this.f776i.get(SCanvasConstants.LAYOUT_TEXT_SPINNER_TABLET).intValue(), this.f774g);
                    arrayAdapter5.setDropDownViewResource(this.f776i.get(SCanvasConstants.LAYOUT_TEXT_SPINNER_TABLET).intValue());
                    arrayAdapter = arrayAdapter5;
                } else {
                    arrayAdapter = new ArrayAdapter(getContext(), R.layout.simple_spinner_item, this.f774g);
                    arrayAdapter.setDropDownViewResource(R.layout.simple_spinner_item);
                }
            } else if (this.f776i.containsKey(SCanvasConstants.LAYOUT_TEXT_SPINNER)) {
                ArrayAdapter arrayAdapter6 = new ArrayAdapter(getContext(), this.f776i.get(SCanvasConstants.LAYOUT_TEXT_SPINNER).intValue(), this.f774g);
                arrayAdapter6.setDropDownViewResource(this.f776i.get(SCanvasConstants.LAYOUT_TEXT_SPINNER).intValue());
                arrayAdapter = arrayAdapter6;
            } else {
                arrayAdapter = new ArrayAdapter(getContext(), R.layout.simple_spinner_item, this.f774g);
                arrayAdapter.setDropDownViewResource(R.layout.simple_spinner_item);
            }
            this.f728ae.setAdapter((SpinnerAdapter) arrayAdapter);
            this.f728ae.setOnItemSelectedListener(this.f746ax);
        }
        if (this.f683K != null) {
            this.f683K.m1545a(this.f703aF);
        }
    }

    /* renamed from: s */
    private void m754s() {
        if (this.f689Q != null) {
            this.f689Q.setOnClickListener(this.f698aA);
        }
        if (this.f686N != null) {
            this.f686N.setOnSeekBarChangeListener(this.f701aD);
        }
        if (this.f687O != null) {
            this.f687O.setOnClickListener(this.f709aL);
        }
    }

    /* renamed from: t */
    private void m755t() {
        if (this.f691S != null) {
            this.f691S.setOnClickListener(this.f698aA);
        }
        if (this.f685M != null) {
            this.f685M.m1545a(this.f704aG);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01e4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0162 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01df A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:156:0x015d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00c4  */
    /* renamed from: u */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m757u() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 592
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.samsung.sdraw.AbstractSettingView.m757u():void");
    }

    /* renamed from: b */
    protected void m777b() {
        if (this.f697a != null) {
            if (this.f697a.getPenType() != 4) {
                if (this.f680H != null) {
                    this.f680H.m1553a(this.f708aK, this.f697a.getPenColor());
                }
                if (this.f678F != null) {
                    this.f678F.setProgress(this.f697a.getPenWidth() - 1);
                    if (this.f782o != null) {
                        this.f678F.setContentDescription(String.format(this.f782o.f1490d, Integer.valueOf((this.f678F.getProgress() * 100) / this.f678F.getMax())));
                    }
                }
                if (this.f679G != null) {
                    this.f679G.setProgress(this.f697a.getPenAlpha());
                    if (this.f782o != null) {
                        this.f679G.setContentDescription(String.format(this.f782o.f1491e, Integer.valueOf((this.f679G.getProgress() * 100) / this.f679G.getMax())));
                    }
                }
                if (this.f680H != null) {
                    this.f680H.m1552a(this.f697a.m1021a());
                }
                if (this.f674B != null) {
                    this.f674B.setPenColor(((this.f697a.getPenAlpha() << 24) & (-16777216)) | this.f697a.getPenColor());
                }
                if (this.f686N != null) {
                    this.f686N.setProgress(this.f697a.getEraserWidth());
                    if (this.f783p != null) {
                        this.f686N.setContentDescription(String.format(this.f783p.f1757d, Integer.valueOf((this.f686N.getProgress() * 100) / this.f686N.getMax())));
                    }
                }
            }
            if (this.f676D != null) {
                if (this.f697a.getPenType() == 4) {
                    m776a(true);
                } else {
                    m776a(false);
                    m691a(this.f676D[this.f730ah[this.f697a.getPenType()]]);
                }
            }
            if (this.f782o != null && this.f697a.getPenType() != 4) {
                if (this.f782o.f1454E != null) {
                    this.f782o.f1454E.setColor(((this.f697a.getPenAlpha() << 24) & (-16777216)) | this.f697a.getPenColor());
                }
                if (this.f782o.f1455F != null) {
                    this.f782o.f1455F.setColor(this.f697a.getPenAlphaColor());
                }
            }
            if (this.f692T != null) {
                this.f692T.onColorChanged(((this.f697a.getPenAlpha() << 24) & (-16777216)) | this.f697a.getPenColor());
            }
            if (this.f771d != null) {
                this.f771d.onPenColorChanged(((this.f697a.getPenAlpha() << 24) & (-16777216)) | this.f697a.getPenColor());
            }
        }
    }

    /* renamed from: c */
    protected void m782c() {
        if (this.f749b != null) {
            if (this.f682J != null) {
                this.f682J.m1553a(this.f705aH, this.f749b.getTextColor());
            }
            if (this.f677E != null && ((Spinner) this.f677E[0]) != null) {
                ((Spinner) this.f677E[0]).setSelection(this.f749b.getTextSize() - 5);
                if (this.f784q != null) {
                    ((Spinner) this.f677E[0]).setContentDescription(String.format(this.f784q.f1652t, Integer.valueOf(this.f749b.getTextSize())));
                }
            }
            if (this.f682J != null) {
                this.f682J.m1552a(this.f749b.getTextColor());
            }
            if (this.f675C != null) {
                this.f675C.m1440c(this.f749b.getTextColor());
            }
            if (this.f677E != null) {
                m776a(false);
                m763x();
                if (this.f728ae != null) {
                    m762w();
                }
            }
            if (this.f784q != null && this.f784q.f1613I != null) {
                this.f784q.f1613I.setColor(this.f749b.getTextColor());
            }
            if (this.f683K != null) {
                this.f683K.m1546a(this.f682J, this.f749b.getTextColor());
            }
        }
    }

    /* renamed from: v */
    private void m759v() {
        if (this.f770c != null) {
            if (this.f684L != null) {
                this.f684L.m1553a(this.f706aI, this.f770c.getFillingColor());
                this.f684L.m1552a(this.f770c.getFillingColor());
            }
            if (this.f685M != null) {
                this.f685M.m1546a(this.f684L, this.f770c.getFillingColor());
            }
            if (this.f771d != null) {
                this.f771d.onFillingColorChanged(this.f770c.getFillingColor());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m691a(View view) {
        if (this.f697a != null) {
            for (int i = 0; i < 6; i++) {
                if (this.f730ah[i] <= 5 && this.f676D[this.f730ah[i]] != null) {
                    this.f676D[this.f730ah[i]].setSelected(false);
                    int penColor = this.f697a.getPenColor();
                    if (view.equals(this.f676D[this.f730ah[i]])) {
                        this.f697a.setPenType(i);
                        if (this.f729ag) {
                            this.f697a.setPenColor(penColor);
                        }
                        m717c(i);
                        if (this.f674B != null) {
                            this.f674B.setType(this.f697a.getPenType());
                            this.f674B.setPenWidth(this.f697a.getPenWidth());
                            this.f674B.setPenColor(((this.f697a.getPenAlpha() << 24) & (-16777216)) | this.f697a.getPenColor());
                            if (this.f782o != null) {
                                this.f674B.setDescription(this.f782o.f1494h, this.f782o.f1495i, this.f782o.f1496j, this.f782o.f1497k, this.f782o.f1498l, this.f782o.f1499m);
                            }
                        }
                        if (this.f782o != null && this.f697a.getPenType() != 4) {
                            if (this.f782o.f1454E != null) {
                                this.f782o.f1454E.setColor(this.f697a.getPenColor() | (-16777216));
                            }
                            if (this.f782o.f1455F != null) {
                                this.f782o.f1455F.setColor(this.f697a.getPenAlphaColor());
                            }
                        }
                        if (this.f692T != null) {
                            this.f692T.onColorChanged(((this.f697a.getPenAlpha() << 24) & (-16777216)) | this.f697a.getPenColor());
                        }
                        if (this.f771d != null) {
                            this.f771d.onPenColorChanged(((this.f697a.getPenAlpha() << 24) & (-16777216)) | this.f697a.getPenColor());
                        }
                        if (this.f692T != null) {
                            this.f692T.onPenWidthChanged(this.f697a.getPenWidth());
                        }
                        if (this.f771d != null) {
                            this.f771d.onPenWidthChanged(this.f697a.getPenWidth());
                        }
                        if (this.f692T != null) {
                            this.f692T.onPenAlphaChanged(this.f697a.getPenAlpha());
                        }
                        if (this.f771d != null) {
                            this.f771d.onPenAlphaChanged(this.f697a.getPenAlpha());
                        }
                    }
                }
            }
            view.setSelected(true);
            m682D();
        }
    }

    /* renamed from: w */
    private void m762w() {
        if (this.f749b != null) {
            if (this.f773f != null) {
                String textFont = this.f749b.getTextFont();
                int i = 0;
                while (true) {
                    if (i >= this.f773f.size()) {
                        break;
                    }
                    if (textFont == null || !textFont.equals(this.f773f.get(i))) {
                        i++;
                    } else {
                        this.f728ae.setSelection(i);
                        if (this.f784q != null) {
                            this.f728ae.setContentDescription(String.format(this.f784q.f1651s, (String) this.f728ae.getSelectedItem()));
                        }
                    }
                }
            }
            if (this.f675C != null) {
                this.f675C.m1435a(this.f749b.getTextType());
                this.f675C.m1439b(this.f749b.getTextSize());
                this.f675C.m1440c(this.f749b.getTextColor());
                this.f675C.m1436a(this.f749b.getTextFont());
                if (this.f784q != null) {
                    this.f675C.m1437a(this.f784q.f1649q, (String) this.f728ae.getSelectedItem());
                }
            }
            if (this.f784q != null && this.f784q.f1613I != null) {
                this.f784q.f1613I.setColor((-16777216) | this.f749b.getTextColor());
            }
        }
    }

    /* renamed from: x */
    private void m763x() {
        boolean z;
        boolean z2 = false;
        boolean z3 = true;
        if (this.f749b != null) {
            for (int i = 1; i < 4; i++) {
                this.f677E[i].setSelected(false);
            }
            m706a(false, false, false);
            switch (this.f749b.getTextType()) {
                case 0:
                    z3 = false;
                    z = false;
                    break;
                case 1:
                    this.f677E[1].setSelected(true);
                    z = true;
                    z3 = false;
                    break;
                case 2:
                    this.f677E[2].setSelected(true);
                    z = false;
                    break;
                case 3:
                    this.f677E[1].setSelected(true);
                    this.f677E[2].setSelected(true);
                    z = true;
                    break;
                case 4:
                    this.f677E[3].setSelected(true);
                    z = false;
                    z2 = true;
                    z3 = false;
                    break;
                case 5:
                    this.f677E[1].setSelected(true);
                    this.f677E[3].setSelected(true);
                    z = true;
                    z2 = true;
                    z3 = false;
                    break;
                case 6:
                    this.f677E[2].setSelected(true);
                    this.f677E[3].setSelected(true);
                    z = false;
                    z2 = true;
                    break;
                case 7:
                    this.f677E[1].setSelected(true);
                    this.f677E[2].setSelected(true);
                    this.f677E[3].setSelected(true);
                    z2 = true;
                    z = true;
                    break;
                default:
                    z3 = false;
                    z = false;
                    break;
            }
            m706a(z, z3, z2);
            int textType = this.f749b.getTextType();
            m724d(textType);
            if (this.f675C != null) {
                this.f675C.m1435a(textType);
                this.f675C.m1439b(this.f749b.getTextSize());
                this.f675C.m1440c(this.f749b.getTextColor());
                this.f675C.m1436a(this.f749b.getTextFont());
                if (this.f784q != null) {
                    this.f675C.m1437a(this.f784q.f1649q, (String) this.f728ae.getSelectedItem());
                }
            }
            if (this.f784q != null && this.f784q.f1613I != null) {
                this.f784q.f1613I.setColor((-16777216) | this.f749b.getTextColor());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m704a(String str) {
        if (this.f749b != null) {
            if (this.f673A != null && this.f673A.setting != null) {
                this.f673A.setting.setTextFont(str);
            }
            this.f749b.setTextFont(str);
            if (this.f675C != null) {
                this.f675C.m1435a(this.f749b.getTextType());
                this.f675C.m1439b(this.f749b.getTextSize());
                this.f675C.m1440c(this.f749b.getTextColor());
                this.f675C.m1436a(str);
                if (this.f784q != null) {
                    this.f675C.m1437a(this.f784q.f1649q, (String) this.f728ae.getSelectedItem());
                }
            }
            if (this.f784q != null && this.f784q.f1613I != null) {
                this.f784q.f1613I.setColor((-16777216) | this.f749b.getTextColor());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m708b(View view) {
        if (this.f749b != null) {
            boolean z = false;
            boolean z2 = false;
            boolean z3 = false;
            int i = 0;
            for (int i2 = 1; i2 < 4; i2++) {
                if (view.equals(this.f677E[i2])) {
                    if (this.f677E[i2].isSelected()) {
                        this.f677E[i2].setSelected(false);
                        view.setSelected(false);
                    } else {
                        this.f677E[i2].setSelected(true);
                        view.setSelected(true);
                    }
                }
                if (this.f677E[i2].isSelected()) {
                    if (i2 == 1) {
                        i |= 1;
                        z3 = true;
                    } else if (i2 == 2) {
                        i |= 2;
                        z2 = true;
                    } else if (i2 == 3) {
                        i |= 4;
                        z = true;
                    }
                }
            }
            m706a(z3, z2, z);
            this.f749b.setTextType(i);
            m724d(i);
            if (this.f675C != null) {
                this.f675C.m1435a(i);
                this.f675C.m1439b(this.f749b.getTextSize());
                this.f675C.m1440c(this.f749b.getTextColor());
                this.f675C.m1436a(this.f749b.getTextFont());
                if (this.f784q != null) {
                    this.f675C.m1437a(this.f784q.f1649q, (String) this.f728ae.getSelectedItem());
                }
            }
            if (this.f784q != null && this.f784q.f1613I != null) {
                this.f784q.f1613I.setColor((-16777216) | this.f749b.getTextColor());
            }
        }
    }

    /* renamed from: a */
    void m776a(boolean z) {
        if (this.f673A != null && this.f673A.stage != null && this.f697a == null) {
        }
    }

    /* renamed from: c */
    private void m717c(int i) {
        StrokeSprite.Type typeM1020a = PenSettingInfo.m1020a(i);
        StrokeSprite.ThicknessParameter thicknessParameterM689a = m689a(i);
        if (this.f679G != null && this.f782o != null) {
            if (typeM1020a != StrokeSprite.Type.Hightlighter) {
                if (this.f764bo) {
                    this.f782o.mo1310a(true, i);
                } else {
                    this.f782o.mo1310a(false, i);
                }
            } else {
                if (this.f782o.f1450A != null) {
                    this.f782o.f1456G.setAlpha(255);
                }
                if (this.f764bo) {
                    this.f782o.mo1310a(true, i);
                } else {
                    this.f782o.mo1310a(false, i);
                }
            }
        }
        if (this.f673A != null && this.f673A.stage != null) {
            this.f673A.setting.setStrokeType(typeM1020a);
            if (this.f697a != null && this.f697a.getPenType() != 4) {
                this.f673A.setting.setStrokeColor(this.f697a.getPenAlphaColor());
                this.f673A.setting.setStrokeWidth(this.f697a.getPenWidth());
            }
            this.f673A.setting.setStrokeParameter(thicknessParameterM689a);
        }
        if (this.f697a != null && this.f697a.getPenType() != 4) {
            if (this.f678F != null) {
                this.f678F.setProgress(this.f697a.getPenWidth() - 1);
                if (this.f782o != null) {
                    this.f678F.setContentDescription(String.format(this.f782o.f1490d, Integer.valueOf((this.f678F.getProgress() * 100) / this.f678F.getMax())));
                }
            }
            if (this.f679G != null) {
                this.f679G.setProgress(this.f697a.getPenAlpha());
                if (this.f782o != null) {
                    this.f679G.setContentDescription(String.format(this.f782o.f1491e, Integer.valueOf((this.f679G.getProgress() * 100) / this.f679G.getMax())));
                }
            }
            if (this.f680H != null) {
                this.f680H.m1552a(this.f697a.m1021a());
            }
        }
        if (this.f692T != null) {
            this.f692T.onPenTypeChanged(i);
        }
        if (this.f771d != null) {
            this.f771d.onPenTypeChanged(i);
        }
    }

    /* renamed from: d */
    private void m724d(int i) {
        if (this.f673A != null && this.f673A.stage != null) {
            this.f673A.setting.setTextType(i);
            if (this.f749b != null) {
                this.f673A.setting.setTextColor(this.f749b.getTextColor());
            }
        }
        if (this.f749b != null) {
            if (((Spinner) this.f677E[0]) != null) {
                ((Spinner) this.f677E[0]).setSelection(this.f749b.getTextSize() - 5);
                if (this.f784q != null) {
                    ((Spinner) this.f677E[0]).setContentDescription(String.format(this.f784q.f1652t, Integer.valueOf(this.f749b.getTextSize())));
                }
            }
            if (this.f682J != null) {
                this.f682J.m1552a(this.f749b.getTextColor());
            }
        }
    }

    /* renamed from: a */
    static StrokeSprite.ThicknessParameter m689a(int i) {
        StrokeSprite.ThicknessParameter thicknessParameter = StrokeSprite.ThicknessParameter.Constant;
        switch (i) {
            case 0:
                return StrokeSprite.ThicknessParameter.SpeedAndPressure;
            case 1:
                return StrokeSprite.ThicknessParameter.Pressure;
            case 2:
                return StrokeSprite.ThicknessParameter.SpeedAndPressure;
            case 3:
                return StrokeSprite.ThicknessParameter.Constant;
            case 4:
            default:
                return thicknessParameter;
            case 5:
                return StrokeSprite.ThicknessParameter.SpeedAndPressure;
        }
    }

    public void showView(int settingView) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (settingView == 1 || settingView == 2 || settingView == 3 || settingView == 4) {
            if (this.f793z != null && this.f793z.getDropperMode()) {
                this.f793z.setDropperMode(false);
            }
            m778b(settingView);
            if (settingView == 1) {
                if (!(m786g().getVisibility() == 0)) {
                    if (this.f778k != null) {
                        this.f778k.onLayout(true);
                    }
                    m786g().setVisibility(0);
                    m682D();
                    if (this.f717aT != null) {
                        this.f717aT.mo806a(true);
                        return;
                    }
                    return;
                }
                return;
            }
            if (settingView == 2) {
                if (!(m789j().getVisibility() == 0)) {
                    m789j().setVisibility(0);
                    m683E();
                    if (this.f717aT != null) {
                        this.f717aT.mo807b(true);
                        return;
                    }
                    return;
                }
                return;
            }
            if (settingView == 3 && !f672af) {
                if (!(m787h().getVisibility() == 0)) {
                    if (this.f778k != null) {
                        this.f778k.onLayout(false);
                    }
                    m787h().setVisibility(0);
                    m684F();
                    if (this.f717aT != null) {
                        this.f717aT.mo808c(true);
                        return;
                    }
                    return;
                }
                return;
            }
            if (settingView == 4) {
                if (!(m788i().getVisibility() == 0)) {
                    m788i().setVisibility(0);
                    m685G();
                    if (this.f717aT != null) {
                        this.f717aT.mo809d(true);
                    }
                }
            }
        }
    }

    public void closeView() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (this.f724aa) {
            if (m786g().getVisibility() == 0) {
                m786g().setVisibility(4);
                if (this.f793z != null) {
                    this.f793z.m970a(this.f693U);
                }
                if (this.f717aT != null) {
                    this.f717aT.mo806a(false);
                }
            }
        }
        if (this.f725ab) {
            if (m789j().getVisibility() == 0) {
                m789j().setVisibility(4);
                if (this.f793z != null) {
                    this.f793z.m970a(this.f694V);
                }
                if (this.f717aT != null) {
                    this.f717aT.mo807b(false);
                }
            }
        }
        if (this.f727ad) {
            if (m788i().getVisibility() == 0) {
                m788i().setVisibility(4);
                if (this.f793z != null) {
                    this.f793z.m970a(this.f696Z);
                }
                if (this.f717aT != null) {
                    this.f717aT.mo809d(false);
                }
            }
        }
        if (!f672af && this.f726ac) {
            if (m787h().getVisibility() == 0) {
                m787h().setVisibility(4);
                if (this.f793z != null) {
                    this.f793z.m970a(this.f695W);
                }
                if (this.f717aT != null) {
                    this.f717aT.mo808c(false);
                }
            }
        }
    }

    /* renamed from: b */
    void m778b(int i) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (this.f724aa && i != 1) {
            if (m786g().getVisibility() == 0) {
                m786g().setVisibility(4);
                if (this.f793z != null) {
                    this.f793z.m970a(this.f693U);
                }
                if (this.f717aT != null) {
                    this.f717aT.mo806a(false);
                }
            }
        }
        if (this.f725ab && i != 2) {
            if (m789j().getVisibility() == 0) {
                m789j().setVisibility(4);
                if (this.f793z != null) {
                    this.f793z.m970a(this.f694V);
                }
                if (this.f717aT != null) {
                    this.f717aT.mo807b(false);
                }
            }
        }
        if (this.f727ad && i != 4) {
            if (m788i().getVisibility() == 0) {
                m788i().setVisibility(4);
                if (this.f793z != null) {
                    this.f793z.m970a(this.f696Z);
                }
                if (this.f717aT != null) {
                    this.f717aT.mo809d(false);
                }
            }
        }
        if (!f672af && this.f726ac && i != 3) {
            if (m787h().getVisibility() == 0) {
                m787h().setVisibility(4);
                if (this.f793z != null) {
                    this.f793z.m970a(this.f695W);
                }
                if (this.f717aT != null) {
                    this.f717aT.mo808c(false);
                }
            }
        }
    }

    @Override // android.view.View
    public boolean isShown() {
        boolean z;
        if (this.f724aa) {
            z = (m786g().getVisibility() == 0) | false;
        } else {
            z = false;
        }
        if (this.f725ab) {
            z |= m789j().getVisibility() == 0;
        }
        if (this.f727ad) {
            z |= m788i().getVisibility() == 0;
        }
        if (f672af || !this.f726ac) {
            return z;
        }
        return z | (m787h().getVisibility() == 0);
    }

    public boolean isShown(int settingView) {
        return settingView == 1 ? this.f724aa && m786g().getVisibility() == 0 : settingView == 2 ? this.f725ab && m789j().getVisibility() == 0 : (settingView != 3 || f672af) ? settingView == 4 && this.f727ad && m788i().getVisibility() == 0 : this.f726ac && m787h().getVisibility() == 0;
    }

    /* renamed from: a */
    private void m699a(PenSettingPreView penSettingPreView) {
        this.f674B = penSettingPreView;
    }

    /* renamed from: a */
    private void m701a(C1036bv c1036bv) {
        this.f675C = c1036bv;
    }

    /* renamed from: a */
    private void m692a(ViewGroup viewGroup) {
        this.f676D = null;
        this.f676D = new View[viewGroup.getChildCount()];
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            this.f676D[i] = viewGroup.getChildAt(i);
        }
    }

    /* renamed from: a */
    private void m693a(SeekBar seekBar) {
        this.f678F = seekBar;
    }

    /* renamed from: b */
    private void m710b(SeekBar seekBar) {
        this.f679G = seekBar;
    }

    /* renamed from: a */
    private void m703a(C1051g c1051g) {
        this.f680H = c1051g;
    }

    /* renamed from: a */
    private void m702a(C1050f c1050f) {
        this.f681I = c1050f;
    }

    /* renamed from: c */
    private void m719c(SeekBar seekBar) {
        this.f686N = seekBar;
    }

    /* renamed from: c */
    private void m718c(View view) {
        this.f687O = view;
    }

    /* renamed from: b */
    private void m709b(ViewGroup viewGroup) {
        this.f677E = null;
        this.f677E = new View[viewGroup.getChildCount()];
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            this.f677E[i] = viewGroup.getChildAt(i + 1);
        }
    }

    /* renamed from: a */
    private void m694a(Spinner spinner) {
        this.f728ae = spinner;
    }

    /* renamed from: b */
    private void m714b(C1051g c1051g) {
        this.f682J = c1051g;
    }

    /* renamed from: b */
    private void m713b(C1050f c1050f) {
        this.f683K = c1050f;
    }

    /* renamed from: c */
    private void m722c(C1051g c1051g) {
        this.f684L = c1051g;
    }

    /* renamed from: c */
    private void m721c(C1050f c1050f) {
        this.f685M = c1050f;
    }

    /* renamed from: d */
    private void m725d(View view) {
        this.f693U = view;
    }

    /* renamed from: e */
    private void m728e(View view) {
        this.f694V = view;
    }

    /* renamed from: f */
    private void m731f(View view) {
        this.f695W = view;
    }

    /* renamed from: g */
    private void m733g(View view) {
        this.f696Z = view;
    }

    /* renamed from: h */
    private void m735h(View view) {
        this.f688P = view;
    }

    /* renamed from: i */
    private void m737i(View view) {
        this.f689Q = view;
    }

    /* renamed from: j */
    private void m739j(View view) {
        this.f690R = view;
    }

    /* renamed from: k */
    private void m741k(View view) {
        this.f691S = view;
    }

    public void setOnSettingChangeListener(SettingChangeListener listener) {
        this.f692T = listener;
    }

    /* renamed from: y */
    private void m765y() {
        if (getContext() != null && this.f783p == null) {
            DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
            if (displayMetrics.densityDpi == 160 || displayMetrics.densityDpi == 213 || m768z()) {
                this.f783p = new C1060p(getContext(), this.f772e);
            } else {
                this.f783p = new C1061q(getContext(), this.f772e);
            }
        }
        if (this.f783p != null) {
            if (isDeleteDefaultDescription()) {
                this.f783p.m1584c();
            }
            if (this.f776i.containsKey(SCanvasConstants.LOCALE_ERASER_SETTING_TITLE)) {
                this.f783p.m1583b(this.f776i.get(SCanvasConstants.LOCALE_ERASER_SETTING_TITLE).intValue());
            }
            if (this.f776i.containsKey(SCanvasConstants.LOCALE_ERASER_SETTING_DELETEALL)) {
                this.f783p.m1586d(this.f776i.get(SCanvasConstants.LOCALE_ERASER_SETTING_DELETEALL).intValue());
            } else if (this.f776i.containsKey(SCanvasConstants.LOCALE_ERASER_SETTING_CLEARALL)) {
                this.f783p.m1586d(this.f776i.get(SCanvasConstants.LOCALE_ERASER_SETTING_CLEARALL).intValue());
            }
            if (this.f776i.containsKey(SCanvasConstants.LOCALE_SETTINGVIEW_CLOSE_DESCRIPTION)) {
                this.f783p.m1585c(this.f776i.get(SCanvasConstants.LOCALE_SETTINGVIEW_CLOSE_DESCRIPTION).intValue());
            }
            if (this.f776i.containsKey(SCanvasConstants.TALKBACK_SETTING_SETTINGVIEW_SEEKBAR_SIZE)) {
                this.f783p.m1587e(this.f776i.get(SCanvasConstants.TALKBACK_SETTING_SETTINGVIEW_SEEKBAR_SIZE).intValue());
            }
            if (this.f745aw != null) {
                this.f783p.m1581a(this.f745aw);
            }
            m728e(this.f783p.mo1568a());
            if (this.f768bs != -1) {
                this.f783p.m1588f(this.f768bs);
            }
            m737i(this.f783p.f1761h);
            m719c(this.f783p.f1759f);
            this.f783p.f1759f.setMax(89);
            m718c(this.f783p.f1762i);
        }
    }

    /* renamed from: z */
    private boolean m768z() throws ClassNotFoundException {
        try {
            Class<?> clsLoadClass = getContext().getClassLoader().loadClass("android.os.SystemProperties");
            String str = (String) clsLoadClass.getMethod("get", String.class).invoke(clsLoadClass, new String("ro.build.characteristics"));
            if (str != null) {
                if (str.contains("tablet")) {
                    return true;
                }
            }
        } catch (Exception e) {
        }
        return false;
    }

    /* renamed from: A */
    private void m675A() {
        if (getContext() != null && this.f782o == null) {
            if (this.f777j.containsKey(SCanvasConstants.CUSTOM_RESOURCE_ASSETS_PATH)) {
                C1044cc.f1690af = this.f777j.get(SCanvasConstants.CUSTOM_RESOURCE_ASSETS_PATH);
            }
            DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
            if (displayMetrics.densityDpi == 160 || displayMetrics.densityDpi == 213 || m768z()) {
                this.f782o = new C0998ak(getContext(), this.f772e);
            } else {
                this.f782o = new C0999al(getContext(), this.f772e);
            }
        }
        if (this.f782o != null) {
            if (isDeleteDefaultDescription()) {
                this.f782o.m1350g();
            }
            if (this.f776i.containsKey(SCanvasConstants.LOCALE_PEN_SETTING_TITLE)) {
                this.f782o.m1337a(this.f776i.get(SCanvasConstants.LOCALE_PEN_SETTING_TITLE).intValue());
            }
            if (this.f776i.containsKey(SCanvasConstants.LOCALE_PEN_SETTING_PRESET_EMPTY_MESSAGE)) {
                this.f782o.m1343c(this.f776i.get(SCanvasConstants.LOCALE_PEN_SETTING_PRESET_EMPTY_MESSAGE).intValue());
            }
            if (this.f776i.containsKey(SCanvasConstants.LOCALE_SETTINGVIEW_CLOSE_DESCRIPTION)) {
                this.f782o.m1341b(this.f776i.get(SCanvasConstants.LOCALE_SETTINGVIEW_CLOSE_DESCRIPTION).intValue());
            }
            if (this.f776i.containsKey(SCanvasConstants.LOCALE_SETTINGVIEW_PRESET_ADD_DESCRIPTION)) {
                this.f782o.m1362r(this.f776i.get(SCanvasConstants.LOCALE_SETTINGVIEW_PRESET_ADD_DESCRIPTION).intValue());
            }
            if (this.f776i.containsKey(SCanvasConstants.TALKBACK_SETTING_SETTINGVIEW_SEEKBAR_SIZE)) {
                this.f782o.m1345d(this.f776i.get(SCanvasConstants.TALKBACK_SETTING_SETTINGVIEW_SEEKBAR_SIZE).intValue());
            }
            if (this.f776i.containsKey(SCanvasConstants.TALKBACK_SETTING_SETTINGVIEW_SEEKBAR_OPACITY)) {
                this.f782o.m1347e(this.f776i.get(SCanvasConstants.TALKBACK_SETTING_SETTINGVIEW_SEEKBAR_OPACITY).intValue());
            }
            if (this.f776i.containsKey(SCanvasConstants.TALKBACK_SETTING_DEFINED_COLOR)) {
                this.f782o.m1349f(this.f776i.get(SCanvasConstants.TALKBACK_SETTING_DEFINED_COLOR).intValue());
            }
            if (this.f776i.containsKey(SCanvasConstants.TALKBACK_SETTING_CUSTOM_COLOR)) {
                this.f782o.m1351g(this.f776i.get(SCanvasConstants.TALKBACK_SETTING_CUSTOM_COLOR).intValue());
            }
            if (this.f776i.containsKey(SCanvasConstants.TALKBACK_SETTING_PEN_PREVIEW)) {
                this.f782o.m1352h(this.f776i.get(SCanvasConstants.TALKBACK_SETTING_PEN_PREVIEW).intValue());
            }
            if (this.f776i.containsKey(SCanvasConstants.TALKBACK_SETTING_PENTYPE_SOLID)) {
                this.f782o.m1353i(this.f776i.get(SCanvasConstants.TALKBACK_SETTING_PENTYPE_SOLID).intValue());
            }
            if (this.f776i.containsKey(SCanvasConstants.TALKBACK_SETTING_PENTYPE_BRUSH)) {
                this.f782o.m1354j(this.f776i.get(SCanvasConstants.TALKBACK_SETTING_PENTYPE_BRUSH).intValue());
            }
            if (this.f776i.containsKey(SCanvasConstants.TALKBACK_SETTING_PENTYPE_CHINESE_BRUSH)) {
                this.f782o.m1355k(this.f776i.get(SCanvasConstants.TALKBACK_SETTING_PENTYPE_CHINESE_BRUSH).intValue());
            }
            if (this.f776i.containsKey(SCanvasConstants.TALKBACK_SETTING_PENTYPE_CRAYON)) {
                this.f782o.m1356l(this.f776i.get(SCanvasConstants.TALKBACK_SETTING_PENTYPE_CRAYON).intValue());
            }
            if (this.f776i.containsKey(SCanvasConstants.TALKBACK_SETTING_PENTYPE_MARKER)) {
                this.f782o.m1357m(this.f776i.get(SCanvasConstants.TALKBACK_SETTING_PENTYPE_MARKER).intValue());
            }
            if (this.f776i.containsKey("R.string.select_desc")) {
                this.f782o.m1361q(this.f776i.get("R.string.select_desc").intValue());
            }
            if (this.f776i.containsKey(SCanvasConstants.TALKBACK_SETTING_SETTINGVIEW_EXPAND)) {
                this.f782o.m1358n(this.f776i.get(SCanvasConstants.TALKBACK_SETTING_SETTINGVIEW_EXPAND).intValue());
            }
            if (this.f776i.containsKey(SCanvasConstants.TALKBACK_SETTING_SETTINGVIEW_CONTRACT)) {
                this.f782o.m1359o(this.f776i.get(SCanvasConstants.TALKBACK_SETTING_SETTINGVIEW_CONTRACT).intValue());
            }
            if (this.f776i.containsKey(SCanvasConstants.TALKBACK_SETTING_SETTINGVIEW_SCROLLBAR)) {
                this.f782o.m1360p(this.f776i.get(SCanvasConstants.TALKBACK_SETTING_SETTINGVIEW_SCROLLBAR).intValue());
            }
            if (this.f745aw != null) {
                this.f782o.m1340a(this.f745aw);
            }
            this.f714aQ = this.f782o.mo1307a();
            m725d(this.f714aQ);
            this.f791x = this.f714aQ.getLayoutParams().width;
            if (this.f768bs != -1) {
                this.f782o.m1363s(this.f768bs);
            }
            m735h(this.f782o.f1462M);
            m699a(this.f782o.f1505s);
            m692a(this.f782o.f1506t);
            m693a(this.f782o.f1512z);
            this.f782o.f1512z.setMax(71);
            m710b(this.f782o.f1450A);
            this.f782o.f1450A.setMax(255);
            m703a(this.f782o.f1452C);
            m702a(this.f782o.f1453D);
            if (this.f782o.f1460K != null) {
                this.f782o.f1460K.setOnClickListener(this.f710aM);
                this.f782o.f1461L.setOnClickListener(this.f710aM);
            }
            if (this.f782o.f1693ah != null) {
                this.f782o.f1693ah.setOnTouchListener(this.f754be);
            }
            if (this.f782o.f1695aj != null) {
                this.f782o.f1695aj.setOnScrollChangedListener(this.f756bg);
            }
            if (this.f782o.f1467R != null) {
                this.f782o.f1467R.setOnLayoutListener(this.f759bj);
            }
            this.f782o.m1339a(this.f762bm);
            if (this.f763bn != null) {
                this.f782o.m1338a(this.f763bn);
                this.f763bn = null;
            }
            this.f782o.m1342b(this.f736an);
        }
    }

    /* renamed from: B */
    private void m678B() {
        if (getContext() != null && this.f784q == null) {
            DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
            if (displayMetrics.densityDpi == 160 || displayMetrics.densityDpi == 213 || m768z()) {
                this.f784q = new C1037bw(getContext(), this.f772e);
            } else {
                this.f784q = new C1038bx(getContext(), this.f772e);
            }
        }
        if (this.f784q != null) {
            if (isDeleteDefaultDescription()) {
                this.f784q.m1493d();
            }
            if (this.f776i.containsKey(SCanvasConstants.LAYOUT_PEN_SPINNER)) {
                this.f784q.m1490b(this.f776i.get(SCanvasConstants.LAYOUT_PEN_SPINNER).intValue());
            }
            if (this.f776i.containsKey(SCanvasConstants.LOCALE_TEXT_SETTING_TITLE)) {
                this.f784q.m1492c(this.f776i.get(SCanvasConstants.LOCALE_TEXT_SETTING_TITLE).intValue());
            }
            if (this.f776i.containsKey(SCanvasConstants.LOCALE_TEXT_SETTING_TAB_FONT)) {
                this.f784q.m1495e(this.f776i.get(SCanvasConstants.LOCALE_TEXT_SETTING_TAB_FONT).intValue());
            }
            if (this.f776i.containsKey(SCanvasConstants.LOCALE_TEXT_SETTING_TAB_PARAGRAPH)) {
                this.f784q.m1496f(this.f776i.get(SCanvasConstants.LOCALE_TEXT_SETTING_TAB_PARAGRAPH).intValue());
            }
            if (this.f776i.containsKey(SCanvasConstants.LOCALE_TEXT_SETTING_TAB_PARAGRAPH_ALIGN)) {
                this.f784q.m1497g(this.f776i.get(SCanvasConstants.LOCALE_TEXT_SETTING_TAB_PARAGRAPH_ALIGN).intValue());
            }
            if (this.f776i.containsKey(SCanvasConstants.LOCALE_SETTINGVIEW_CLOSE_DESCRIPTION)) {
                this.f784q.m1494d(this.f776i.get(SCanvasConstants.LOCALE_SETTINGVIEW_CLOSE_DESCRIPTION).intValue());
            }
            if (this.f776i.containsKey(SCanvasConstants.TALKBACK_SETTING_TYPE_BOLD_ON)) {
                this.f784q.m1501k(this.f776i.get(SCanvasConstants.TALKBACK_SETTING_TYPE_BOLD_ON).intValue());
            }
            if (this.f776i.containsKey(SCanvasConstants.TALKBACK_SETTING_TYPE_ITALIC_ON)) {
                this.f784q.m1502l(this.f776i.get(SCanvasConstants.TALKBACK_SETTING_TYPE_ITALIC_ON).intValue());
            }
            if (this.f776i.containsKey(SCanvasConstants.TALKBACK_SETTING_TYPE_UNDERLINE_ON)) {
                this.f784q.m1503m(this.f776i.get(SCanvasConstants.TALKBACK_SETTING_TYPE_UNDERLINE_ON).intValue());
            }
            if (this.f776i.containsKey(SCanvasConstants.TALKBACK_SETTING_TYPE_BOLD_OFF)) {
                this.f784q.m1498h(this.f776i.get(SCanvasConstants.TALKBACK_SETTING_TYPE_BOLD_OFF).intValue());
            }
            if (this.f776i.containsKey(SCanvasConstants.TALKBACK_SETTING_TYPE_ITALIC_OFF)) {
                this.f784q.m1499i(this.f776i.get(SCanvasConstants.TALKBACK_SETTING_TYPE_ITALIC_OFF).intValue());
            }
            if (this.f776i.containsKey(SCanvasConstants.TALKBACK_SETTING_TYPE_UNDERLINE_OFF)) {
                this.f784q.m1500j(this.f776i.get(SCanvasConstants.TALKBACK_SETTING_TYPE_UNDERLINE_OFF).intValue());
            }
            if (this.f776i.containsKey(SCanvasConstants.TALKBACK_SETTING_ALIGN_LEFT)) {
                this.f784q.m1504n(this.f776i.get(SCanvasConstants.TALKBACK_SETTING_ALIGN_LEFT).intValue());
            }
            if (this.f776i.containsKey(SCanvasConstants.TALKBACK_SETTING_ALIGN_CENTER)) {
                this.f784q.m1505o(this.f776i.get(SCanvasConstants.TALKBACK_SETTING_ALIGN_CENTER).intValue());
            }
            if (this.f776i.containsKey(SCanvasConstants.TALKBACK_SETTING_ALIGN_RIGHT)) {
                this.f784q.m1506p(this.f776i.get(SCanvasConstants.TALKBACK_SETTING_ALIGN_RIGHT).intValue());
            }
            if (this.f776i.containsKey(SCanvasConstants.TALKBACK_SETTING_DEFINED_COLOR)) {
                this.f784q.m1507q(this.f776i.get(SCanvasConstants.TALKBACK_SETTING_DEFINED_COLOR).intValue());
            }
            if (this.f776i.containsKey(SCanvasConstants.TALKBACK_SETTING_CUSTOM_COLOR)) {
                this.f784q.m1508r(this.f776i.get(SCanvasConstants.TALKBACK_SETTING_CUSTOM_COLOR).intValue());
            }
            if (this.f776i.containsKey(SCanvasConstants.TALKBACK_SETTING_TEXT_PREVIEW)) {
                this.f784q.m1509s(this.f776i.get(SCanvasConstants.TALKBACK_SETTING_TEXT_PREVIEW).intValue());
            }
            if (this.f776i.containsKey(SCanvasConstants.TALKBACK_SETTING_SETTINGVIEW_SCROLLBAR)) {
                this.f784q.m1510t(this.f776i.get(SCanvasConstants.TALKBACK_SETTING_SETTINGVIEW_SCROLLBAR).intValue());
            }
            if (this.f776i.containsKey(SCanvasConstants.TALKBACK_SETTING_TEXT_FONT)) {
                this.f784q.m1511u(this.f776i.get(SCanvasConstants.TALKBACK_SETTING_TEXT_FONT).intValue());
            }
            if (this.f776i.containsKey(SCanvasConstants.TALKBACK_SETTING_TEXT_SIZE)) {
                this.f784q.m1512v(this.f776i.get(SCanvasConstants.TALKBACK_SETTING_TEXT_SIZE).intValue());
            }
            if (this.f776i.containsKey("R.string.select_desc")) {
                this.f784q.m1513w(this.f776i.get("R.string.select_desc").intValue());
            }
            if (this.f745aw != null) {
                this.f784q.m1489a(this.f745aw);
            }
            m731f(this.f784q.mo1462a());
            this.f792y = this.f695W.getLayoutParams().width;
            if (this.f768bs != -1) {
                this.f784q.m1514x(this.f768bs);
            }
            m739j(this.f784q.f1615K);
            m701a(this.f784q.f1655w);
            if (this.f675C != null) {
                this.f675C.m1438a(this.f784q.f1638f, this.f784q.f1641i, this.f784q.f1639g, this.f784q.f1642j, this.f784q.f1640h, this.f784q.f1643k);
            }
            m709b(this.f784q.f1656x);
            m694a(this.f784q.f1625U);
            m714b(this.f784q.f1611G);
            m713b(this.f784q.f1612H);
            if (this.f784q.f1616L != null && this.f784q.f1617M != null) {
                this.f784q.f1616L.setOnClickListener(this.f712aO);
                this.f784q.f1616L.setOnFocusChangeListener(this.f711aN);
                this.f784q.f1617M.setOnClickListener(this.f712aO);
                this.f784q.f1617M.setOnFocusChangeListener(this.f711aN);
                this.f784q.f1616L.setSelected(true);
                this.f784q.f1617M.setSelected(false);
            }
            if (this.f784q.f1608D != null && this.f784q.f1609E != null && this.f784q.f1610F != null) {
                this.f784q.f1608D.setOnClickListener(this.f713aP);
                this.f784q.f1609E.setOnClickListener(this.f713aP);
                this.f784q.f1610F.setOnClickListener(this.f713aP);
                this.f784q.f1608D.setSelected(true);
                this.f784q.f1609E.setSelected(false);
                this.f784q.f1610F.setSelected(false);
            }
            if (this.f784q.f1693ah != null) {
                this.f784q.f1693ah.setOnTouchListener(this.f755bf);
            }
            if (this.f784q.f1695aj != null) {
                this.f784q.f1695aj.setOnScrollChangedListener(this.f757bh);
            }
            if (this.f784q.f1618N != null) {
                this.f784q.f1618N.setOnLayoutListener(this.f758bi);
            }
        }
        m770a(3, true);
    }

    /* renamed from: C */
    private void m679C() {
        if (getContext() != null && this.f785r == null) {
            DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
            if (displayMetrics.densityDpi == 160 || displayMetrics.densityDpi == 213 || m768z()) {
                this.f785r = new C1065u(getContext(), this.f772e);
            } else {
                this.f785r = new C1066v(getContext(), this.f772e);
            }
        }
        if (this.f785r != null) {
            if (isDeleteDefaultDescription()) {
                this.f785r.m1625b();
            }
            if (this.f776i.containsKey(SCanvasConstants.LOCALE_FILLING_SETTING_TITLE)) {
                this.f785r.m1623a(this.f776i.get(SCanvasConstants.LOCALE_FILLING_SETTING_TITLE).intValue());
            }
            if (this.f776i.containsKey(SCanvasConstants.LOCALE_SETTINGVIEW_CLOSE_DESCRIPTION)) {
                this.f785r.m1626b(this.f776i.get(SCanvasConstants.LOCALE_SETTINGVIEW_CLOSE_DESCRIPTION).intValue());
            }
            if (this.f776i.containsKey(SCanvasConstants.TALKBACK_SETTING_SETTINGVIEW_EXPAND)) {
                this.f785r.m1629e(this.f776i.get(SCanvasConstants.TALKBACK_SETTING_SETTINGVIEW_EXPAND).intValue());
            }
            if (this.f776i.containsKey(SCanvasConstants.TALKBACK_SETTING_SETTINGVIEW_CONTRACT)) {
                this.f785r.m1630f(this.f776i.get(SCanvasConstants.TALKBACK_SETTING_SETTINGVIEW_CONTRACT).intValue());
            }
            if (this.f776i.containsKey(SCanvasConstants.TALKBACK_SETTING_DEFINED_COLOR)) {
                this.f785r.m1627c(this.f776i.get(SCanvasConstants.TALKBACK_SETTING_DEFINED_COLOR).intValue());
            }
            if (this.f776i.containsKey(SCanvasConstants.TALKBACK_SETTING_CUSTOM_COLOR)) {
                this.f785r.m1628d(this.f776i.get(SCanvasConstants.TALKBACK_SETTING_CUSTOM_COLOR).intValue());
            }
            if (this.f776i.containsKey("R.string.select_desc")) {
                this.f785r.m1631g(this.f776i.get("R.string.select_desc").intValue());
            }
            if (this.f745aw != null) {
                this.f785r.m1624a(this.f745aw);
            }
            m733g(this.f785r.mo1609a());
            if (this.f768bs != -1) {
                this.f785r.m1632h(this.f768bs);
            }
            m741k(this.f785r.f1796n);
            m722c(this.f785r.f1791i);
            m721c(this.f785r.f1792j);
            if (this.f785r.f1794l != null) {
                this.f785r.f1794l.setOnClickListener(this.f710aM);
                this.f785r.f1795m.setOnClickListener(this.f710aM);
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f782o != null) {
            this.f782o.mo1313c();
        }
        if (this.f783p != null) {
            this.f783p.mo1570b();
        }
        if (this.f784q != null) {
            this.f784q.mo1467c();
        }
        this.f724aa = false;
        this.f725ab = false;
        this.f726ac = false;
        this.f727ad = false;
        if (this.f789v != null && this.f789v.isShowing()) {
            this.f789v.cancel();
        }
    }

    /* renamed from: D */
    private void m682D() {
        if (this.f697a != null && isShown()) {
            if (this.f678F != null && this.f697a.getPenType() != 4 && this.f678F.getProgress() != this.f697a.getPenWidth()) {
                this.f678F.setProgress(this.f697a.getPenWidth() - 1);
                if (this.f782o != null) {
                    this.f678F.setContentDescription(String.format(this.f782o.f1490d, Integer.valueOf((this.f678F.getProgress() * 100) / this.f678F.getMax())));
                }
            }
            if (this.f679G != null && this.f697a.getPenType() != 4 && this.f679G.getProgress() != this.f697a.getPenAlpha() && this.f697a.getPenType() == 3) {
                this.f679G.setProgress(this.f697a.getPenAlpha());
                if (this.f782o != null) {
                    this.f679G.setContentDescription(String.format(this.f782o.f1491e, Integer.valueOf((this.f679G.getProgress() * 100) / this.f679G.getMax())));
                }
            }
            if (this.f680H != null && this.f697a.getPenType() != 4) {
                this.f680H.m1552a(this.f697a.m1021a());
            }
            if (this.f681I != null) {
                this.f681I.m1546a(this.f680H, this.f697a.getPenColor());
            }
            if (this.f674B != null && this.f697a.getPenType() != 4) {
                this.f674B.setType(this.f697a.getPenType());
                this.f674B.setPenColor(((this.f697a.getPenAlpha() << 24) & (-16777216)) | this.f697a.getPenColor());
                this.f674B.setPenWidth(this.f697a.getPenWidth());
                this.f674B.setPenAlpha(this.f697a.getPenAlpha());
                if (this.f782o != null) {
                    this.f674B.setDescription(this.f782o.f1494h, this.f782o.f1495i, this.f782o.f1496j, this.f782o.f1497k, this.f782o.f1498l, this.f782o.f1499m);
                }
            }
            if (this.f782o != null && this.f697a.getPenType() != 4) {
                for (int i = 0; i < 6; i++) {
                    if (this.f730ah[i] <= 5 && this.f676D[this.f730ah[i]] != null) {
                        this.f676D[this.f730ah[i]].setSelected(false);
                    }
                }
                if (this.f697a.getPenType() != 4) {
                    this.f676D[this.f730ah[this.f697a.getPenType()]].setSelected(true);
                }
                int penAlpha = ((this.f697a.getPenAlpha() << 24) & (-16777216)) | this.f697a.getPenColor();
                if (this.f782o.f1454E != null) {
                    this.f782o.f1454E.setColor((16777215 & penAlpha) | (-16777216));
                }
                if (this.f782o.f1455F != null) {
                    this.f782o.f1455F.setColor(this.f697a.getPenAlphaColor());
                }
                if (this.f782o.f1458I != null) {
                    this.f782o.f1458I.setColorFilter(new LightingColorFilter(0, penAlpha));
                }
                this.f782o.mo1308a(this.f697a.getPenType(), this.f697a.getPenColor(), this.f697a.getPenAlpha(), this.f697a.getPenWidth());
                if (this.f697a.getPenType() != 3) {
                    if (this.f782o.f1512z != null) {
                        this.f782o.f1512z.setNextFocusDownId(1011);
                    }
                    if (this.f782o.f1452C != null) {
                        this.f782o.f1452C.setNextFocusUpId(1009);
                    }
                    this.f782o.f1459J.setVisibility(8);
                } else {
                    if (this.f782o.f1450A != null) {
                        this.f782o.f1456G.setAlpha(255);
                    }
                    if (this.f782o.f1512z != null) {
                        this.f782o.f1512z.setNextFocusDownId(1010);
                    }
                    if (this.f782o.f1452C != null) {
                        this.f782o.f1452C.setNextFocusUpId(1010);
                    }
                    this.f782o.f1459J.setVisibility(0);
                }
                setPalletViewState(this.f764bo, 1);
            }
        }
        invalidate();
    }

    /* renamed from: E */
    private void m683E() {
        if (this.f697a != null && isShown() && this.f686N != null && this.f686N.getProgress() != this.f697a.getEraserWidth()) {
            this.f686N.setProgress(this.f697a.getEraserWidth());
            if (this.f783p != null) {
                this.f686N.setContentDescription(String.format(this.f783p.f1757d, Integer.valueOf((this.f686N.getProgress() * 100) / this.f686N.getMax())));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: F */
    public void m684F() {
        if (this.f749b != null) {
            if (this.f677E != null && ((Spinner) this.f677E[0]) != null) {
                ((Spinner) this.f677E[0]).setSelection(this.f749b.getTextSize() - 5);
                if (this.f784q != null) {
                    ((Spinner) this.f677E[0]).setContentDescription(String.format(this.f784q.f1652t, Integer.valueOf(this.f749b.getTextSize())));
                }
            }
            if (this.f675C != null) {
                this.f675C.m1440c(this.f749b.getTextColor());
                this.f675C.m1439b(this.f749b.getTextSize());
                this.f675C.m1436a(this.f749b.getTextFont());
                if (this.f784q != null) {
                    this.f675C.m1437a(this.f784q.f1649q, (String) this.f728ae.getSelectedItem());
                }
            }
            if (this.f682J != null) {
                this.f682J.m1552a(this.f749b.getTextColor());
                if (this.f683K != null) {
                    this.f683K.m1546a(this.f682J, this.f749b.getTextColor() & 16777215);
                }
            }
            if (this.f784q != null) {
                int textColor = this.f749b.getTextColor();
                if (this.f784q.f1613I != null) {
                    this.f784q.f1613I.setColor((textColor & 16777215) | (-16777216));
                }
                this.f784q.mo1464a(this.f749b.getTextType(), this.f749b.getTextColor(), this.f749b.getTextSize());
                if (this.f784q.f1608D != null && this.f784q.f1609E != null && this.f784q.f1610F != null) {
                    if (this.f749b.getTextAlignment() == Layout.Alignment.ALIGN_NORMAL) {
                        this.f784q.f1608D.setSelected(true);
                        this.f784q.f1609E.setSelected(false);
                        this.f784q.f1610F.setSelected(false);
                    } else if (this.f749b.getTextAlignment() == Layout.Alignment.ALIGN_CENTER) {
                        this.f784q.f1608D.setSelected(false);
                        this.f784q.f1609E.setSelected(true);
                        this.f784q.f1610F.setSelected(false);
                    } else if (this.f749b.getTextAlignment() == Layout.Alignment.ALIGN_OPPOSITE) {
                        this.f784q.f1608D.setSelected(false);
                        this.f784q.f1609E.setSelected(false);
                        this.f784q.f1610F.setSelected(true);
                    }
                }
            }
        }
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: G */
    public void m685G() {
        if (this.f770c != null && isShown()) {
            if (this.f684L != null) {
                this.f684L.m1552a(this.f770c.m994a());
                if (this.f685M != null) {
                    this.f685M.m1546a(this.f684L, 16777215 & this.f770c.getFillingColor());
                }
            }
            setPalletViewState(this.f765bp, 4);
            if (this.f673A != null) {
                ((CanvasView) this.f673A.view).m971a(this.f770c);
            }
        }
        invalidate();
    }

    /* renamed from: a */
    void m774a(PenSettingInfo penSettingInfo) {
        if (this.f697a == null && getContext() != null) {
            this.f697a = new PenSettingInfo(getContext());
        }
        if (this.f697a != null) {
            for (int i = 0; i < 6; i++) {
                this.f697a.setPenType(i);
                if (i != 4) {
                    this.f697a.setPenColor(penSettingInfo.getPenColor(i));
                    this.f697a.setPenAlpha(penSettingInfo.getPenAlpha(i));
                }
                this.f697a.setPenWidth(penSettingInfo.getPenWidth(i));
            }
            this.f697a.setEraserWidth(penSettingInfo.getEraserWidth());
            this.f697a.setPenType(penSettingInfo.getPenType());
            if (penSettingInfo.getPenType() != 4) {
                if (this.f676D != null) {
                    m691a(this.f676D[this.f730ah[penSettingInfo.getPenType()]]);
                }
                this.f697a.setPenColor(this.f697a.getPenColor());
            }
            if (this.f786s != null) {
                this.f771d = this.f786s;
                this.f771d.onPenTypeChanged(this.f697a.getPenType());
                if (this.f697a.getPenType() != 4) {
                    this.f771d.onPenColorChanged(this.f697a.getPenColor());
                    this.f771d.onPenAlphaChanged(this.f697a.getPenAlpha());
                }
                this.f771d.onPenWidthChanged(this.f697a.getPenWidth());
                this.f786s = null;
            }
        }
    }

    /* renamed from: a */
    void m775a(TextSettingInfo textSettingInfo) {
        if (this.f749b == null && getContext() != null) {
            this.f749b = new TextSettingInfo(getContext());
            this.f749b.m1186a(this.f715aR);
        }
        if (this.f749b != null) {
            this.f749b.setTextFont(textSettingInfo.getTextFont());
            this.f749b.setTextAlignment(textSettingInfo.getTextAlignment());
            this.f749b.setTextColor(textSettingInfo.getTextColor());
            this.f749b.setTextType(textSettingInfo.getTextType());
            this.f749b.setTextSize(textSettingInfo.getTextSize());
            this.f749b.m1186a(this.f715aR);
            if (this.f786s != null) {
                this.f771d = this.f786s;
                this.f771d.onTextFontChanged(this.f749b.getTextFont());
                this.f771d.onTextAlignmentChanged(this.f749b.getTextAlignment());
                this.f771d.onTextColorChanged(this.f749b.getTextColor());
                this.f771d.onTextTypeChanged(this.f749b.getTextType());
                this.f771d.onTextSizeChanged(this.f749b.getTextSize());
                this.f786s = null;
            }
        }
    }

    /* renamed from: a */
    void m773a(FillingSettingInfo fillingSettingInfo) {
        if (this.f770c == null && getContext() != null) {
            this.f770c = new FillingSettingInfo(getContext());
            this.f770c.m998a(this.f716aS);
        }
        if (this.f770c != null) {
            this.f770c.setFillingColor(fillingSettingInfo.getFillingColor());
            if (this.f786s != null) {
                this.f771d = this.f786s;
                this.f771d.onFillingColorChanged(this.f770c.getFillingColor());
                this.f786s = null;
            }
        }
    }

    /* renamed from: b */
    void m780b(PenSettingInfo penSettingInfo) throws Throwable {
        if (this.f697a == null && getContext() != null) {
            m786g();
        }
        if (this.f697a != null) {
            if (this.f697a.getPenType() != penSettingInfo.getPenType()) {
                this.f697a.setPenType(penSettingInfo.getPenType());
            }
            if (this.f697a.getPenColor() != penSettingInfo.getPenColor()) {
                this.f697a.setPenColor(penSettingInfo.getPenColor());
            }
            if (this.f697a.getPenWidth() != penSettingInfo.getPenWidth()) {
                this.f697a.setPenWidth(penSettingInfo.getPenWidth());
            }
            if (this.f697a.getPenAlpha() != penSettingInfo.getPenAlpha()) {
                this.f697a.setPenAlpha(penSettingInfo.getPenAlpha());
            }
            if (penSettingInfo.getPenType() == 4) {
                if (this.f697a.getEraserWidth() != penSettingInfo.getEraserWidth()) {
                    this.f697a.setEraserWidth(penSettingInfo.getEraserWidth());
                }
            } else if (this.f793z != null) {
                this.f793z.m977b(this.f697a);
            }
            m682D();
        }
    }

    /* renamed from: b */
    void m781b(TextSettingInfo textSettingInfo) throws Throwable {
        if (this.f749b == null && getContext() != null) {
            m787h();
        }
        if (this.f749b != null) {
            if (this.f749b.getTextFont() == null || !this.f749b.getTextFont().equals(textSettingInfo.getTextFont())) {
                this.f749b.setTextFont(textSettingInfo.getTextFont());
            }
            if (this.f749b.getTextColor() != textSettingInfo.getTextColor()) {
                this.f749b.setTextColor(textSettingInfo.getTextColor());
            }
            if (this.f749b.getTextSize() != textSettingInfo.getTextSize()) {
                this.f749b.setTextSize(textSettingInfo.getTextSize());
            }
            if (this.f749b.getTextType() != textSettingInfo.getTextType()) {
                this.f749b.setTextType(textSettingInfo.getTextType());
            }
            if (this.f749b.getTextAlignment() != textSettingInfo.getTextAlignment()) {
                this.f749b.setTextAlignment(textSettingInfo.getTextAlignment());
            }
            this.f749b.m1186a(this.f715aR);
            m782c();
        }
    }

    /* renamed from: b */
    void m779b(FillingSettingInfo fillingSettingInfo) {
        if (this.f770c == null && getContext() != null) {
            m788i();
        }
        if (this.f770c != null) {
            if (this.f770c.getFillingColor() != fillingSettingInfo.getFillingColor()) {
                this.f770c.setFillingColor(fillingSettingInfo.getFillingColor());
            }
            this.f770c.m998a(this.f716aS);
            m759v();
        }
    }

    /* renamed from: a */
    void m771a(InterfaceC0948a interfaceC0948a) {
        this.f717aT = interfaceC0948a;
    }

    public void setEraserClearAllVisible(boolean visible) {
        if (visible) {
            this.f721aX = 0;
            this.f783p.m1582a(true);
        } else {
            this.f721aX = 1;
            this.f783p.m1582a(false);
        }
    }

    /* renamed from: d */
    String m783d() {
        return this.f718aU;
    }

    public void setOnSettingChangedListener(OnSettingChangedListener listener) {
        if (this.f786s == null) {
            if (this.f793z == null) {
                this.f786s = listener;
            } else {
                this.f771d = listener;
            }
        }
    }

    public int getPenSettingViewSizeOption() {
        return this.f719aV;
    }

    public boolean setPenSettingViewSizeOption(int penSettingViewOption) {
        if (penSettingViewOption == 0) {
            this.f719aV = penSettingViewOption;
            if (this.f782o == null) {
                return true;
            }
            boolean z = this.f782o.f1475Z;
            this.f782o.f1475Z = false;
            if (this.f697a != null) {
                this.f782o.mo1312b(false, this.f697a.getPenType());
            } else {
                this.f782o.mo1312b(false, 0);
            }
            m770a(1, z);
            return true;
        }
        if (penSettingViewOption == 1) {
            this.f719aV = penSettingViewOption;
            if (this.f782o == null) {
                return true;
            }
            if (this.f697a != null) {
                this.f782o.mo1312b(true, this.f697a.getPenType());
            } else {
                this.f782o.mo1312b(true, 0);
            }
            boolean z2 = this.f782o.f1475Z;
            this.f782o.f1475Z = false;
            m770a(1, z2);
            return true;
        }
        if (penSettingViewOption != 2) {
            return false;
        }
        this.f719aV = penSettingViewOption;
        if (this.f782o == null) {
            return true;
        }
        boolean z3 = !this.f782o.f1475Z;
        this.f782o.f1475Z = true;
        if (this.f697a != null) {
            this.f782o.mo1312b(false, this.f697a.getPenType());
        } else {
            this.f782o.mo1312b(false, 0);
        }
        m770a(1, z3);
        return true;
    }

    public int getTextSettingViewSizeOption() {
        return this.f720aW;
    }

    public boolean setTextSettingViewSizeOption(int settingViewSizeOption) {
        if (settingViewSizeOption == 0 || settingViewSizeOption == 2) {
            this.f720aW = settingViewSizeOption;
            if (this.f784q == null) {
                return true;
            }
            this.f784q.mo1465a(false);
            return true;
        }
        if (settingViewSizeOption != 1) {
            return false;
        }
        this.f720aW = settingViewSizeOption;
        if (this.f784q == null) {
            return true;
        }
        this.f784q.mo1465a(true);
        return true;
    }

    public int getEraserSettingViewSizeOption() {
        return this.f721aX;
    }

    public boolean setEraserSettingViewSizeOption(int settingViewSizeOption) {
        if (settingViewSizeOption == 0 || settingViewSizeOption == 2) {
            this.f721aX = settingViewSizeOption;
            if (this.f783p == null) {
                return true;
            }
            this.f783p.m1582a(false);
            return true;
        }
        if (settingViewSizeOption != 1) {
            return false;
        }
        this.f721aX = settingViewSizeOption;
        if (this.f783p == null) {
            return true;
        }
        this.f783p.m1582a(true);
        return true;
    }

    public int getFillingSettingViewSizeOption() {
        return this.f722aY;
    }

    public boolean setFillingSettingViewSizeOption(int settingViewSizeOption) {
        if (settingViewSizeOption == 0 || settingViewSizeOption == 2) {
            this.f722aY = settingViewSizeOption;
            if (this.f785r == null) {
                return true;
            }
            this.f785r.mo1611b(false);
            return true;
        }
        if (settingViewSizeOption != 1) {
            return false;
        }
        this.f722aY = settingViewSizeOption;
        if (this.f785r == null) {
            return true;
        }
        this.f785r.mo1611b(true);
        return true;
    }

    public boolean getDeleteAllPopupVisible() {
        return this.f723aZ;
    }

    public void setDeleteAllPopupVisible(boolean bDeleteAllPopupVisible) {
        this.f723aZ = bDeleteAllPopupVisible;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: H */
    public void m686H() {
        if (this.f733ak != null) {
            if (this.f733ak.getChildCount() <= 0) {
                this.f734al.setVisibility(0);
            } else {
                this.f734al.setVisibility(8);
            }
            if (this.f732aj != null && this.f782o != null) {
                this.f782o.m1348f();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m700a(C1005ar c1005ar, boolean z) throws Throwable {
        C1044cc presetListItem;
        View penPresetListRow;
        if (this.f733ak != null) {
            String string = "Remove from preset";
            if (isDeleteDefaultDescription()) {
                string = "";
            } else if (this.f776i.containsKey(SCanvasConstants.LOCALE_SETTINGVIEW_PRESET_DELETE_DESCRIPTION)) {
                string = getContext().getString(this.f776i.get(SCanvasConstants.LOCALE_SETTINGVIEW_PRESET_DELETE_DESCRIPTION).intValue());
            }
            String strM690a = m690a(this.f743au, c1005ar.m1390f(), c1005ar.m1386d(), c1005ar.m1388e());
            if (this.f733ak instanceof PresetTabletLinearLayout) {
                presetListItem = new PresetTabletItem(getContext(), this.f772e, string, strM690a);
                penPresetListRow = ((PresetTabletItem) presetListItem).getPenPresetListRow();
            } else {
                presetListItem = new PresetListItem(getContext(), this.f772e, string, strM690a);
                penPresetListRow = ((PresetListItem) presetListItem).getPenPresetListRow();
            }
            if (z) {
                this.f733ak.addView(penPresetListRow);
            } else {
                this.f733ak.addView(penPresetListRow, 0);
            }
            this.f733ak.setPresetData(c1005ar, presetListItem);
            if (!z) {
                this.f733ak.setFocusOrder();
            }
        }
    }

    /* renamed from: a */
    private void m705a(ArrayList<C1005ar> arrayList) throws Throwable {
        Iterator<C1005ar> it = arrayList.iterator();
        while (it.hasNext()) {
            m700a(it.next(), true);
        }
        this.f733ak.setFocusOrder();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: I */
    public void m687I() {
        if (this.f735am == null) {
            this.f735am = Toast.makeText(getContext(), this.f779l, 0);
        }
        this.f735am.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m727e(int i) {
        C1005ar c1005arM1036a = this.f731ai.m1036a(i);
        if (c1005arM1036a != null) {
            int iM1390f = c1005arM1036a.m1390f();
            this.f697a.setPenType(iM1390f);
            this.f697a.setPenColor(c1005arM1036a.m1391g());
            this.f697a.setPenAlpha(c1005arM1036a.m1388e());
            this.f697a.setPenWidth(c1005arM1036a.m1386d());
            if (this.f793z != null) {
                this.f793z.m977b(this.f697a);
            }
            m691a(this.f676D[this.f730ah[iM1390f]]);
            if (this.f793z != null) {
                this.f793z.m972a(this.f697a);
            }
            this.f731ai.m1046c(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m730f(final int i) {
        if (this.f789v == null || !this.f789v.isShowing()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            if (this.f776i.containsKey(SCanvasConstants.LOCALE_PEN_SETTING_PRESET_DELETE_MESSAGE)) {
                builder.setMessage(this.f776i.get(SCanvasConstants.LOCALE_PEN_SETTING_PRESET_DELETE_MESSAGE).intValue());
            } else {
                builder.setMessage(this.f787t);
            }
            builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() { // from class: com.samsung.sdraw.AbstractSettingView.26
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialog, int id) {
                    AbstractSettingView.this.f733ak.removeViewAt(i);
                    AbstractSettingView.this.f731ai.m1043b(i);
                }
            });
            builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() { // from class: com.samsung.sdraw.AbstractSettingView.27
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialog, int id) {
                    dialog.cancel();
                }
            });
            this.f789v = builder.create();
            if (this.f776i.containsKey(SCanvasConstants.LOCALE_PEN_SETTING_PRESET_DELETE_TITLE)) {
                this.f789v.setTitle(this.f776i.get(SCanvasConstants.LOCALE_PEN_SETTING_PRESET_DELETE_TITLE).intValue());
            } else {
                this.f789v.setTitle(this.f788u);
            }
            this.f789v.show();
        }
    }

    /* renamed from: e */
    PresetDataManager m784e() {
        if (this.f731ai == null) {
            m746o();
        }
        return this.f731ai;
    }

    public void setOnDeleteAllConfirmListener(OnDeleteAllConfirmListener mOnDeleteAllConfirmListener) {
        this.f753bd = mOnDeleteAllConfirmListener;
    }

    /* renamed from: f */
    int m785f() {
        return getContext().getResources().getDisplayMetrics().densityDpi == 160 ? this.f790w * 4 : this.f790w * 2;
    }

    /* renamed from: b */
    static void m715b(boolean z) {
        f672af = z;
    }

    /* renamed from: g */
    View m786g() throws Throwable {
        if (!this.f724aa) {
            m675A();
            if (this.f697a == null && getContext() != null) {
                this.f697a = new PenSettingInfo(getContext());
            }
            if (this.f693U.getParent() != this) {
                addView(this.f693U);
            }
            boolean z = this.f693U.getVisibility() == 0;
            this.f693U.setVisibility(4);
            if (this.f717aT != null && z) {
                this.f717aT.mo806a(false);
            }
            if (this.f697a != null) {
                m777b();
            }
            m746o();
            m748p();
            m750q();
            setPenSettingViewSizeOption(this.f719aV);
            this.f724aa = true;
        }
        return this.f693U;
    }

    /* renamed from: h */
    View m787h() throws Throwable {
        if (!this.f726ac) {
            m678B();
            if (this.f749b == null && getContext() != null) {
                this.f749b = new TextSettingInfo(getContext());
            }
            if (this.f749b != null) {
                this.f749b.m1186a(this.f715aR);
            }
            if (this.f695W.getParent() != this) {
                addView(this.f695W);
            }
            boolean z = this.f695W.getVisibility() == 0;
            this.f695W.setVisibility(4);
            if (this.f717aT != null && z) {
                this.f717aT.mo808c(false);
            }
            m752r();
            if (this.f749b != null) {
                m782c();
            }
            setTextSettingViewSizeOption(this.f720aW);
            this.f726ac = true;
        }
        return this.f695W;
    }

    /* renamed from: i */
    View m788i() {
        if (!this.f727ad) {
            m679C();
            if (this.f770c == null && getContext() != null) {
                this.f770c = new FillingSettingInfo(getContext());
            }
            if (this.f770c != null) {
                this.f770c.m998a(this.f716aS);
            }
            if (this.f696Z.getParent() != this) {
                addView(this.f696Z);
            }
            boolean z = this.f696Z.getVisibility() == 0;
            this.f696Z.setVisibility(4);
            if (this.f717aT != null && z) {
                this.f717aT.mo809d(false);
            }
            if (this.f770c != null) {
                m759v();
            }
            m755t();
            setFillingSettingViewSizeOption(this.f722aY);
            this.f727ad = true;
        }
        return this.f696Z;
    }

    /* renamed from: j */
    View m789j() {
        if (!this.f725ab) {
            m765y();
            if (this.f694V.getParent() != this) {
                addView(this.f694V);
            }
            boolean z = this.f694V.getVisibility() == 0;
            this.f694V.setVisibility(4);
            if (this.f717aT != null && z) {
                this.f717aT.mo807b(false);
            }
            m754s();
            setEraserSettingViewSizeOption(this.f721aX);
            this.f725ab = true;
        }
        return this.f694V;
    }

    public void relayoutSettingView(boolean portrait, boolean fromCanvas) {
    }

    public boolean getCustomClearAll() {
        return this.f760bk;
    }

    public void setCustomClearAll(boolean bCustomClearAll) {
        this.f760bk = bCustomClearAll;
    }

    public int getPresetCount() {
        if (this.f731ai == null) {
            m746o();
        }
        return this.f731ai.m1047d();
    }

    public PenSettingInfo getPresetInfo(int presetIndex) {
        C1005ar c1005arM1036a;
        PresetDataManager presetDataManagerM784e = m784e();
        if (presetDataManagerM784e == null || (c1005arM1036a = presetDataManagerM784e.m1036a(presetIndex)) == null) {
            return null;
        }
        PenSettingInfo penSettingInfo = new PenSettingInfo();
        penSettingInfo.setPenType(c1005arM1036a.m1390f());
        penSettingInfo.setPenColor(c1005arM1036a.m1391g());
        penSettingInfo.setPenAlpha(c1005arM1036a.m1388e());
        penSettingInfo.setPenWidth(c1005arM1036a.m1386d());
        return penSettingInfo;
    }

    public boolean deletePresetInfo(int presetIndex, boolean bShowConfirmDialog) {
        PresetDataManager presetDataManagerM784e = m784e();
        if (presetDataManagerM784e != null && presetDataManagerM784e.m1047d() > presetIndex) {
            if (bShowConfirmDialog) {
                m730f(presetIndex);
            } else {
                if (this.f733ak != null) {
                    this.f733ak.removeViewAt(presetIndex);
                }
                presetDataManagerM784e.m1043b(presetIndex);
            }
            return true;
        }
        return bShowConfirmDialog;
    }

    public boolean addPreset(PenSettingInfo info, boolean bShowErrorDialog) {
        PresetDataManager presetDataManagerM784e = m784e();
        if (presetDataManagerM784e == null || info == null) {
            return false;
        }
        if (presetDataManagerM784e.m1047d() >= 12) {
            if (!bShowErrorDialog) {
                return false;
            }
            Toast.makeText(getContext(), String.format(this.f780m, 12), 0).show();
            return false;
        }
        C1005ar c1005ar = new C1005ar();
        c1005ar.m1387d(info.getPenType());
        c1005ar.m1389e(info.getPenColor());
        c1005ar.m1385c(info.getPenAlpha());
        c1005ar.m1383b(info.getPenWidth());
        if (presetDataManagerM784e.m1044b(c1005ar)) {
            if (!bShowErrorDialog) {
                return false;
            }
            m687I();
            return false;
        }
        presetDataManagerM784e.m1040a(c1005ar);
        return true;
    }

    public void setOnSettingViewExpandedListener(OnSettingViewExpandedListener onSettingViewExpandedListener) {
        if (this.f782o != null) {
            this.f782o.m1338a(onSettingViewExpandedListener);
        } else {
            this.f763bn = onSettingViewExpandedListener;
        }
    }

    public void setPalletViewState(boolean open, int settingview) {
        if (settingview == 1) {
            boolean z = this.f764bo != open;
            this.f764bo = open;
            if (this.f782o != null) {
                if (this.f697a != null) {
                    this.f782o.mo1310a(open, this.f697a.getPenType());
                } else {
                    this.f782o.mo1310a(open, 0);
                }
                m770a(1, z);
                return;
            }
            return;
        }
        if (settingview == 4) {
            this.f765bp = open;
            if (this.f785r != null) {
                this.f785r.mo1610a(open);
            }
        }
    }

    /* renamed from: a */
    void m770a(int i, boolean z) {
        int i2;
        if (z && i == 1 && this.f782o != null) {
            int i3 = this.f791x;
            if (this.f782o.f1477aa.getVisibility() == 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f782o.f1477aa.getLayoutParams();
                i3 = layoutParams.rightMargin + this.f782o.f1477aa.getLayoutParams().width + layoutParams.leftMargin + i3;
            }
            if (this.f782o.f1693ah.getVisibility() == 0) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f782o.f1693ah.getLayoutParams();
                i3 += layoutParams2.rightMargin + this.f782o.f1693ah.getLayoutParams().width + layoutParams2.leftMargin;
            }
            this.f693U.getLayoutParams().width = i3;
            return;
        }
        if (z && i == 3 && this.f784q != null) {
            int i4 = this.f792y;
            if (this.f784q.f1693ah.getVisibility() == 0) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.f784q.f1693ah.getLayoutParams();
                i2 = layoutParams3.rightMargin + this.f784q.f1693ah.getLayoutParams().width + layoutParams3.leftMargin + i4;
            } else {
                i2 = i4;
            }
            this.f695W.getLayoutParams().width = i2;
        }
    }

    public void setOnPresetDelBtnOnClickListener(OnPresetDelBtnOnClickListener listener) {
        this.f767br = listener;
    }

    public void setCustomDeletePreset(boolean isCustomDeletePreset) {
        this.f766bq = isCustomDeletePreset;
    }

    public boolean getCustomDeletePreset() {
        return this.f766bq;
    }

    /* renamed from: k */
    String m790k() {
        return this.f738ap;
    }

    /* renamed from: l */
    String m791l() {
        return this.f739aq;
    }

    /* renamed from: m */
    String m792m() {
        return this.f740ar;
    }

    /* renamed from: n */
    String m793n() {
        return this.f741as;
    }

    /* renamed from: a */
    private void m706a(boolean z, boolean z2, boolean z3) {
        if (this.f784q != null) {
            if (z) {
                this.f677E[1].setContentDescription(this.f784q.f1638f);
            } else {
                this.f677E[1].setContentDescription(this.f784q.f1641i);
            }
            if (z2) {
                this.f677E[2].setContentDescription(this.f784q.f1639g);
            } else {
                this.f677E[2].setContentDescription(this.f784q.f1642j);
            }
            if (z3) {
                this.f677E[3].setContentDescription(this.f784q.f1640h);
            } else {
                this.f677E[3].setContentDescription(this.f784q.f1643k);
            }
        }
    }

    public boolean setTitleAlign(int align) {
        if (align == 0) {
            this.f768bs = 19;
        } else if (align == 1) {
            this.f768bs = 17;
        } else if (align == 2) {
            this.f768bs = 21;
        } else {
            return false;
        }
        if (this.f782o != null) {
            this.f782o.m1363s(this.f768bs);
        }
        if (this.f783p != null) {
            this.f783p.m1588f(this.f768bs);
        }
        if (this.f785r != null) {
            this.f785r.m1632h(this.f768bs);
        }
        if (this.f784q == null) {
            return true;
        }
        this.f784q.m1514x(this.f768bs);
        return true;
    }

    /* renamed from: a */
    private String m690a(String str, int i, int i2, int i3) {
        String str2 = "Pen";
        if (this.f782o != null) {
            if (i == 0) {
                str2 = this.f782o.f1495i;
            } else if (i == 1) {
                str2 = this.f782o.f1496j;
            } else if (i == 5) {
                str2 = this.f782o.f1497k;
            } else if (i == 2) {
                str2 = this.f782o.f1498l;
            } else if (i == 3) {
                str2 = this.f782o.f1499m;
            }
        }
        return String.format(str, str2, Integer.valueOf((i2 * 100) / 72), Integer.valueOf((i3 * 100) / 255));
    }

    public void setPresetSaveButtonFlag(boolean dim) {
        this.f736an = dim;
        if (this.f782o != null) {
            this.f782o.m1342b(dim);
        }
    }

    public void setDisplayPresetFullToastPopUp(boolean bDisplayPresetFullToastPopUp) {
        this.f737ao = bDisplayPresetFullToastPopUp;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected boolean dispatchHoverEvent(MotionEvent arg0) {
        if (this.f693U != null && this.f693U.getVisibility() == 0) {
            Rect rect = new Rect();
            this.f693U.getLocalVisibleRect(rect);
            if (rect.contains((int) arg0.getX(), (int) arg0.getY())) {
                super.dispatchHoverEvent(arg0);
                return true;
            }
            if (arg0.getAction() == 10) {
                return super.dispatchHoverEvent(arg0);
            }
            return false;
        }
        if (this.f694V != null && this.f694V.getVisibility() == 0) {
            Rect rect2 = new Rect();
            this.f694V.getLocalVisibleRect(rect2);
            if (rect2.contains((int) arg0.getX(), (int) arg0.getY())) {
                super.dispatchHoverEvent(arg0);
                return true;
            }
            if (arg0.getAction() == 10) {
                return super.dispatchHoverEvent(arg0);
            }
            return false;
        }
        if (this.f695W != null && this.f695W.getVisibility() == 0) {
            Rect rect3 = new Rect();
            this.f695W.getLocalVisibleRect(rect3);
            if (rect3.contains((int) arg0.getX(), (int) arg0.getY())) {
                super.dispatchHoverEvent(arg0);
                return true;
            }
            if (arg0.getAction() == 10) {
                return super.dispatchHoverEvent(arg0);
            }
            return false;
        }
        if (this.f696Z == null || this.f696Z.getVisibility() != 0) {
            return false;
        }
        Rect rect4 = new Rect();
        this.f696Z.getLocalVisibleRect(rect4);
        if (rect4.contains((int) arg0.getX(), (int) arg0.getY())) {
            super.dispatchHoverEvent(arg0);
            return true;
        }
        if (arg0.getAction() == 10) {
            return super.dispatchHoverEvent(arg0);
        }
        return false;
    }

    public void setMaintainPenColor(boolean maintainPenColor) {
        this.f729ag = maintainPenColor;
    }

    public boolean getMaintainPenColor() {
        return this.f729ag;
    }

    public void deleteDefaultDescription() {
        this.f769bt = true;
    }

    public boolean isDeleteDefaultDescription() {
        return this.f769bt;
    }
}
