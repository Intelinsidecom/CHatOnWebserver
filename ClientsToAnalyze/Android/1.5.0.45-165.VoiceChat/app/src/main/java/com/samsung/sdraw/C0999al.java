package com.samsung.sdraw;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.samsung.sdraw.AbstractSettingView;
import com.samsung.sdraw.PresetLinearLayout;
import com.vlingo.sdk.internal.http.HttpUtil;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;

/* renamed from: com.samsung.sdraw.al */
/* loaded from: classes.dex */
class C0999al extends C1044cc {

    /* renamed from: A */
    protected SeekBar f1450A;

    /* renamed from: B */
    protected ImageView f1451B;

    /* renamed from: C */
    protected C1051g f1452C;

    /* renamed from: D */
    protected C1050f f1453D;

    /* renamed from: E */
    protected GradientDrawable f1454E;

    /* renamed from: F */
    protected GradientDrawable f1455F;

    /* renamed from: G */
    protected StateListDrawable f1456G;

    /* renamed from: H */
    protected StateListDrawable f1457H;

    /* renamed from: I */
    protected Drawable f1458I;

    /* renamed from: J */
    protected View f1459J;

    /* renamed from: K */
    protected View f1460K;

    /* renamed from: L */
    protected View f1461L;

    /* renamed from: M */
    protected View f1462M;

    /* renamed from: N */
    protected View f1463N;

    /* renamed from: O */
    protected View f1464O;

    /* renamed from: P */
    protected View f1465P;

    /* renamed from: Q */
    protected View f1466Q;

    /* renamed from: R */
    protected PalletView f1467R;

    /* renamed from: S */
    protected ImageView f1468S;

    /* renamed from: T */
    protected ImageView f1469T;

    /* renamed from: U */
    protected TextView f1470U;

    /* renamed from: V */
    protected View f1471V;

    /* renamed from: W */
    protected PresetLinearLayout f1472W;

    /* renamed from: X */
    protected TextView f1473X;

    /* renamed from: Y */
    protected String f1474Y;

    /* renamed from: Z */
    protected boolean f1475Z;

    /* renamed from: a */
    protected String f1476a;

    /* renamed from: aa */
    protected View f1477aa;

    /* renamed from: ab */
    protected LinearLayout f1478ab;

    /* renamed from: ac */
    protected AbstractSettingView.OnSettingViewExpandedListener f1479ac;

    /* renamed from: ad */
    protected boolean f1480ad;

    /* renamed from: ae */
    protected int f1481ae;

    /* renamed from: aq */
    private Drawable f1482aq;

    /* renamed from: ar */
    private boolean f1483ar;

    /* renamed from: as */
    private Bitmap f1484as;

    /* renamed from: at */
    private Bitmap f1485at;

    /* renamed from: au */
    private int f1486au;

    /* renamed from: av */
    private boolean f1487av;

    /* renamed from: b */
    protected String f1488b;

    /* renamed from: c */
    protected String f1489c;

    /* renamed from: d */
    protected String f1490d;

    /* renamed from: e */
    protected String f1491e;

    /* renamed from: f */
    protected String f1492f;

    /* renamed from: g */
    protected String f1493g;

    /* renamed from: h */
    protected String f1494h;

    /* renamed from: i */
    protected String f1495i;

    /* renamed from: j */
    protected String f1496j;

    /* renamed from: k */
    protected String f1497k;

    /* renamed from: l */
    protected String f1498l;

    /* renamed from: m */
    protected String f1499m;

    /* renamed from: n */
    protected String f1500n;

    /* renamed from: o */
    protected String f1501o;

    /* renamed from: p */
    protected String f1502p;

    /* renamed from: q */
    protected String f1503q;

    /* renamed from: r */
    protected String f1504r;

    /* renamed from: s */
    protected PenSettingPreView f1505s;

    /* renamed from: t */
    protected ViewGroup f1506t;

    /* renamed from: u */
    protected ImageButton f1507u;

    /* renamed from: v */
    protected ImageButton f1508v;

    /* renamed from: w */
    protected ImageButton f1509w;

    /* renamed from: x */
    protected ImageButton f1510x;

    /* renamed from: y */
    protected ImageButton f1511y;

    /* renamed from: z */
    protected SeekBar f1512z;

    /* renamed from: d */
    public View m1344d() {
        return this.f1471V;
    }

    /* renamed from: e */
    public TextView m1346e() {
        return this.f1473X;
    }

    public C0999al(Context context, String str) {
        super(context, str);
        this.f1476a = "Pen Settings";
        this.f1488b = HttpUtil.VAL_CLOSE;
        this.f1489c = "Add preset";
        this.f1490d = "Thickness";
        this.f1491e = "Transparency";
        this.f1492f = "Defined color";
        this.f1493g = "Custom color";
        this.f1494h = "Pen type %s, thickness %d percent, transparency %d percent";
        this.f1495i = "Pen";
        this.f1496j = "Art brush";
        this.f1497k = "Calligraphy brush";
        this.f1498l = "Pencil";
        this.f1499m = "Magic pen";
        this.f1500n = "Advanced settings";
        this.f1501o = "Advanced settings";
        this.f1502p = "Vertical scroll bar";
        this.f1503q = "";
        this.f1504r = null;
        this.f1474Y = "No preset settings";
        this.f1475Z = false;
        this.f1483ar = false;
        this.f1486au = 70;
        this.f1487av = false;
        this.f1480ad = false;
        this.f1481ae = 19;
    }

    /* renamed from: a */
    protected PenSettingRootView mo1307a() {
        m1533h();
        return m1319i();
    }

    /* renamed from: i */
    private PenSettingRootView m1319i() {
        PenSettingRootView penSettingRootView = new PenSettingRootView(this.f1698am);
        penSettingRootView.setLayoutParams(new LinearLayout.LayoutParams(m1524a(245.5f * this.f1700ao), -2));
        penSettingRootView.setOrientation(1);
        penSettingRootView.setPadding(0, m1524a(5.0f), 0, 0);
        penSettingRootView.addView(m1320j());
        penSettingRootView.addView(m1324n());
        penSettingRootView.setOnTouchListener(this.f1701ap);
        return penSettingRootView;
    }

    /* renamed from: j */
    private ViewGroup m1320j() {
        RelativeLayout relativeLayout = new RelativeLayout(this.f1698am);
        relativeLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.f1462M = m1323m();
        relativeLayout.addView(m1321k());
        LinearLayout linearLayout = new LinearLayout(this.f1698am);
        linearLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        linearLayout.setOrientation(0);
        this.f1470U = m1322l();
        linearLayout.addView(this.f1470U);
        linearLayout.addView(this.f1462M);
        relativeLayout.addView(linearLayout);
        return relativeLayout;
    }

    /* renamed from: k */
    private View m1321k() {
        LinearLayout linearLayout = new LinearLayout(this.f1698am);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, m1524a(27.5f)));
        linearLayout.setOrientation(0);
        ImageView imageView = new ImageView(this.f1698am);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(-1, m1524a(27.5f), 1.0f));
        imageView.setBackgroundDrawable(m1527b("/snote_title_left.9.png"));
        ImageView imageView2 = new ImageView(this.f1698am);
        imageView2.setLayoutParams(new LinearLayout.LayoutParams(-1, m1524a(27.5f), 1.0f));
        imageView2.setBackgroundDrawable(m1527b("/snote_title_right.9.png"));
        linearLayout.addView(imageView);
        linearLayout.addView(imageView2);
        return linearLayout;
    }

    /* renamed from: l */
    private TextView m1322l() {
        Typeface typefaceCreateFromFile = null;
        TextView textView = new TextView(this.f1698am);
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, m1524a(27.5f), 1.0f));
        textView.setTextSize(13.0f);
        textView.setTextColor(-1);
        textView.setGravity(this.f1481ae);
        textView.setFocusable(false);
        textView.setText(this.f1476a);
        if (this.f1504r != null) {
            try {
                typefaceCreateFromFile = Typeface.createFromFile(this.f1504r);
            } catch (Exception e) {
                C0992ae.m1272a("Invalid font path");
            }
        }
        if (typefaceCreateFromFile != null) {
            textView.setTypeface(typefaceCreateFromFile);
        }
        textView.setTextSize(1, 13.0f);
        textView.setContentDescription(this.f1476a);
        textView.setPadding(m1524a(12.0f), m1524a(2.0f), m1524a(7.0f), 0);
        return textView;
    }

    /* renamed from: m */
    private View m1323m() {
        ImageButton imageButton = new ImageButton(this.f1698am);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        if (this.f1699an == 240) {
            layoutParams.topMargin = m1524a(5.5f);
            layoutParams.rightMargin = m1524a(5.5f);
        } else {
            layoutParams.topMargin = m1524a(3.5f);
            layoutParams.rightMargin = m1524a(3.5f);
        }
        imageButton.setLayoutParams(layoutParams);
        imageButton.setFocusable(true);
        imageButton.setContentDescription(this.f1488b);
        imageButton.setId(1000);
        imageButton.setNextFocusRightId(1000);
        imageButton.setNextFocusLeftId(1002);
        imageButton.setNextFocusDownId(12070701);
        if (this.f1699an == 240) {
            imageButton.setBackgroundDrawable(m1529b("/popup_exit.png", "/popup_exit_press.png", (String) null));
            imageButton.setImageDrawable(m1529b((String) null, (String) null, "/snote_add_focus.png"));
        } else if (this.f1699an == 480) {
            imageButton.setBackgroundDrawable(m1525a("/popup_exit_480.png", "/popup_exit_press_480.png", null));
            imageButton.setImageDrawable(m1525a(null, null, "/snote_add_focus.png"));
        } else {
            imageButton.setBackgroundDrawable(m1525a("/popup_exit.png", "/popup_exit_press.png", null));
            imageButton.setImageDrawable(m1525a(null, null, "/snote_add_focus.png"));
        }
        imageButton.setPadding(0, 0, 0, 0);
        return imageButton;
    }

    /* renamed from: n */
    private ViewGroup m1324n() {
        LinearLayout linearLayout = new LinearLayout(this.f1698am);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        linearLayout.setOrientation(0);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setPadding(m1524a(6.0f), m1524a(8.0f), m1524a(11.5f), m1524a(15.0f));
        linearLayout.setBackgroundDrawable(m1527b("/snote_title_bottom.9.png"));
        linearLayout.addView(m1325o());
        return linearLayout;
    }

    /* renamed from: o */
    private ViewGroup m1325o() {
        this.f1478ab = new LinearLayout(this.f1698am);
        this.f1478ab.setLayoutParams(new LinearLayout.LayoutParams(-2, -2, 1.0f));
        this.f1478ab.setOrientation(0);
        this.f1695aj = new PenSettingScrollView(this.f1698am);
        this.f1695aj.setLayoutParams(new LinearLayout.LayoutParams(m1524a(this.f1700ao * 245.5f), -2));
        this.f1695aj.setFadingEdgeLength(0);
        this.f1695aj.setVerticalScrollBarEnabled(false);
        this.f1695aj.setOverScrollMode(2);
        this.f1695aj.setFocusable(false);
        PalletView palletView = new PalletView(this.f1698am);
        palletView.setLayoutParams(new ViewGroup.LayoutParams(-1, m1524a(237.0f)));
        palletView.setOrientation(1);
        this.f1506t = m1329s();
        this.f1459J = m1333w();
        this.f1460K = m1316C();
        this.f1460K.setContentDescription(this.f1500n);
        try {
            this.f1460K.setHoverPopupType(1);
        } catch (NoSuchMethodError e) {
            e.printStackTrace();
        }
        this.f1461L = m1317D();
        this.f1464O = m1327q();
        this.f1465P = m1336z();
        this.f1466Q = m1326p();
        palletView.addView(this.f1464O);
        palletView.addView(this.f1506t);
        palletView.addView(this.f1466Q);
        palletView.addView(this.f1465P);
        this.f1467R = palletView;
        this.f1695aj.addView(this.f1467R);
        this.f1478ab.addView(this.f1695aj);
        this.f1477aa = m1318E();
        this.f1477aa.setVisibility(8);
        this.f1478ab.addView(this.f1477aa);
        this.f1693ah = mo1311b();
        this.f1478ab.addView(this.f1693ah);
        this.f1693ah.setVisibility(8);
        LinearLayout linearLayout = new LinearLayout(this.f1698am);
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(m1524a(245.5f), m1524a(5.0f)));
        linearLayout.setOrientation(1);
        LinearLayout linearLayout2 = new LinearLayout(this.f1698am);
        linearLayout2.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        linearLayout2.setOrientation(1);
        linearLayout2.addView(linearLayout);
        linearLayout2.addView(this.f1478ab);
        linearLayout2.addView(this.f1460K);
        return linearLayout2;
    }

    /* renamed from: p */
    private View m1326p() {
        LinearLayout linearLayout = new LinearLayout(this.f1698am);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = m1524a(5.0f);
        layoutParams.leftMargin = m1524a(7.0f);
        layoutParams.rightMargin = m1524a(7.0f);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setBackgroundDrawable(m1527b("/snote_option_in_bg.9.png"));
        linearLayout.setOrientation(1);
        this.f1459J = m1333w();
        this.f1463N = m1330t();
        linearLayout.addView(this.f1463N);
        linearLayout.addView(this.f1459J);
        return linearLayout;
    }

    /* renamed from: q */
    private View m1327q() {
        LinearLayout.LayoutParams layoutParams;
        FrameLayout frameLayout = new FrameLayout(this.f1698am);
        if (this.f1699an == 240) {
            layoutParams = new LinearLayout.LayoutParams(-1, m1524a(75.0f));
        } else {
            layoutParams = new LinearLayout.LayoutParams(-1, m1524a(67.5f));
        }
        layoutParams.leftMargin = m1524a(7.0f);
        layoutParams.rightMargin = m1524a(7.0f);
        frameLayout.setLayoutParams(layoutParams);
        frameLayout.setBackgroundDrawable(m1527b("/snote_type_preview_bg_00.png"));
        this.f1505s = new PenSettingPreView(this.f1698am);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1, 17);
        layoutParams2.leftMargin++;
        this.f1505s.setLayoutParams(layoutParams2);
        this.f1505s.setBackgroundDrawable(m1527b("/snote_type_preview_bg_00.png"));
        this.f1505s.setContentDescription(this.f1494h);
        frameLayout.addView(this.f1505s);
        this.f1471V = m1328r();
        this.f1471V.setVisibility(8);
        frameLayout.addView(this.f1471V);
        return frameLayout;
    }

    /* renamed from: r */
    private View m1328r() {
        FrameLayout.LayoutParams layoutParams;
        C1052h c1052h = new C1052h(this.f1698am);
        if (this.f1699an == 480) {
            layoutParams = new FrameLayout.LayoutParams(m1524a(28.5f * this.f1700ao), m1524a(22.0f * this.f1700ao), 53);
        } else {
            layoutParams = new FrameLayout.LayoutParams(-2, -2, 53);
        }
        c1052h.setLayoutParams(layoutParams);
        c1052h.setContentDescription(this.f1489c);
        c1052h.setFocusable(true);
        c1052h.setId(1002);
        c1052h.setNextFocusUpId(1000);
        c1052h.setNextFocusDownId(1008);
        c1052h.setNextFocusLeftId(1004);
        c1052h.setNextFocusRightId(1003);
        c1052h.setPadding(0, 0, 0, 0);
        if (this.f1699an == 240) {
            c1052h.setBackgroundDrawable(m1530b("/snote_add.png", "/snote_add_press.png", null, null, "/snote_add_dim.png"));
            c1052h.setImageDrawable(m1529b((String) null, (String) null, "/snote_add_focus.png"));
        } else {
            c1052h.setBackgroundDrawable(m1526a("/snote_add.png", "/snote_add_press.png", null, null, "/snote_add_dim.png"));
            c1052h.setImageDrawable(m1525a(null, null, "/snote_add_focus.png"));
        }
        return c1052h;
    }

    /* renamed from: s */
    private ViewGroup m1329s() {
        LinearLayout linearLayout = new LinearLayout(this.f1698am);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = m1524a(5.0f);
        layoutParams.leftMargin = m1524a(7.0f);
        layoutParams.rightMargin = m1524a(6.0f);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(0);
        linearLayout.setBackgroundDrawable(m1527b("/snote_popup_in_bg02.9.png"));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(m1524a(46.5f * this.f1700ao), m1524a(53.0f * this.f1700ao));
        this.f1507u = new ImageButton(this.f1698am);
        this.f1507u.setContentDescription(String.valueOf(String.format(this.f1495i, 1)) + this.f1503q);
        this.f1507u.setFocusable(true);
        this.f1507u.setId(1004);
        this.f1507u.setNextFocusUpId(1002);
        this.f1507u.setNextFocusDownId(1009);
        this.f1507u.setNextFocusRightId(1005);
        this.f1507u.setNextFocusLeftId(1004);
        this.f1507u.setBackgroundDrawable(m1525a("/pensetting_icon_pen_unselect.png", "/pensetting_icon_pen.png", null));
        this.f1507u.setImageDrawable(m1525a(null, null, "/pensetting_icon_selected.png"));
        this.f1507u.setLayoutParams(layoutParams2);
        this.f1507u.setScaleType(ImageView.ScaleType.FIT_XY);
        this.f1507u.setPadding(0, 0, 0, 0);
        linearLayout.addView(this.f1507u);
        this.f1508v = new ImageButton(this.f1698am);
        this.f1508v.setContentDescription(String.valueOf(String.format(this.f1496j, 2)) + this.f1503q);
        this.f1508v.setFocusable(true);
        this.f1508v.setId(1005);
        this.f1508v.setNextFocusUpId(1002);
        this.f1508v.setNextFocusDownId(1009);
        this.f1508v.setNextFocusLeftId(1004);
        this.f1508v.setNextFocusRightId(1006);
        this.f1508v.setBackgroundDrawable(m1525a("/pensetting_icon_brush_unselect.png", "/pensetting_icon_brush.png", null));
        this.f1508v.setImageDrawable(m1525a(null, null, "/pensetting_icon_selected.png"));
        this.f1508v.setLayoutParams(layoutParams2);
        this.f1508v.setScaleType(ImageView.ScaleType.FIT_XY);
        this.f1508v.setPadding(0, 0, 0, 0);
        linearLayout.addView(this.f1508v);
        this.f1509w = new ImageButton(this.f1698am);
        this.f1509w.setContentDescription(String.valueOf(String.format(this.f1497k, 3)) + this.f1503q);
        this.f1509w.setFocusable(true);
        this.f1509w.setId(1006);
        this.f1509w.setNextFocusDownId(1009);
        this.f1509w.setNextFocusLeftId(1005);
        this.f1509w.setNextFocusRightId(1007);
        this.f1509w.setNextFocusUpId(1002);
        this.f1509w.setBackgroundDrawable(m1525a("/pensetting_icon_chinabrush_unselect.png", "/pensetting_icon_chinabrush.png", null));
        this.f1509w.setImageDrawable(m1525a(null, null, "/pensetting_icon_selected.png"));
        this.f1509w.setLayoutParams(layoutParams2);
        this.f1509w.setScaleType(ImageView.ScaleType.FIT_XY);
        this.f1509w.setPadding(0, 0, 0, 0);
        linearLayout.addView(this.f1509w);
        this.f1510x = new ImageButton(this.f1698am);
        this.f1510x.setContentDescription(String.valueOf(String.format(this.f1498l, 4)) + this.f1503q);
        this.f1510x.setFocusable(true);
        this.f1510x.setId(1007);
        this.f1510x.setNextFocusDownId(1009);
        this.f1510x.setNextFocusLeftId(1006);
        this.f1510x.setNextFocusRightId(1008);
        this.f1510x.setNextFocusUpId(1002);
        this.f1510x.setBackgroundDrawable(m1525a("/pensetting_icon_pencil_unselect.png", "/pensetting_icon_pencil.png", null));
        this.f1510x.setImageDrawable(m1525a(null, null, "/pensetting_icon_selected.png"));
        this.f1510x.setLayoutParams(layoutParams2);
        this.f1510x.setScaleType(ImageView.ScaleType.FIT_XY);
        this.f1510x.setPadding(0, 0, 0, 0);
        linearLayout.addView(this.f1510x);
        this.f1511y = new ImageButton(this.f1698am);
        this.f1511y.setContentDescription(String.valueOf(String.format(this.f1499m, 5)) + this.f1503q);
        this.f1511y.setFocusable(true);
        this.f1511y.setId(1008);
        this.f1511y.setNextFocusDownId(1009);
        this.f1511y.setNextFocusLeftId(1007);
        this.f1511y.setNextFocusRightId(1003);
        this.f1511y.setNextFocusUpId(1002);
        this.f1511y.setBackgroundDrawable(m1525a("/pensetting_icon_neon_unselect.png", "/pensetting_icon_neon.png", null));
        this.f1511y.setImageDrawable(m1525a(null, null, "/pensetting_icon_selected.png"));
        this.f1511y.setLayoutParams(layoutParams2);
        this.f1511y.setScaleType(ImageView.ScaleType.FIT_XY);
        this.f1511y.setPadding(0, 0, 0, 0);
        linearLayout.addView(this.f1511y);
        if (this.f1699an == 240) {
            linearLayout.setPadding(0, 0, 0, m1524a(1.5f));
        } else {
            linearLayout.setPadding(0, 0, 0, m1524a(1.0f));
        }
        return linearLayout;
    }

    /* renamed from: t */
    private ViewGroup m1330t() {
        LinearLayout linearLayout = new LinearLayout(this.f1698am);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        linearLayout.setPadding(0, m1524a(2.0f), m1524a(6.25f), m1524a(2.0f));
        linearLayout.setGravity(16);
        this.f1512z = m1331u();
        this.f1451B = m1332v();
        linearLayout.addView(this.f1512z);
        linearLayout.addView(this.f1451B);
        return linearLayout;
    }

    /* renamed from: u */
    private CustomSeekBar m1331u() {
        Drawable drawableB;
        int iA;
        CustomSeekBar customSeekBar = new CustomSeekBar(this.f1698am);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(m1524a(165.0f), -2, 1.0f);
        layoutParams.rightMargin = m1524a(4.5f);
        customSeekBar.setLayoutParams(layoutParams);
        customSeekBar.setPadding(m1524a(12.0f), m1524a(2.0f), m1524a(12.0f), m1524a(1.0f));
        customSeekBar.setMax(39);
        customSeekBar.setContentDescription(this.f1490d);
        try {
            customSeekBar.setHoverPopupType(1);
        } catch (NoSuchMethodError e) {
            e.printStackTrace();
        }
        customSeekBar.setId(1009);
        customSeekBar.setNextFocusDownId(1010);
        customSeekBar.setNextFocusUpId(1004);
        customSeekBar.setNextFocusRightId(1009);
        customSeekBar.setNextFocusLeftId(1009);
        if (this.f1699an == 240) {
            this.f1457H = m1525a("/snote_slider_circle.png", "/snote_slider_circle_press.png", "/snote_slider_circle_press.png");
        } else if (this.f1699an == 480) {
            this.f1457H = m1525a("/eraser_handel_480.png", "/eraser_handel_press_480.png", "/eraser_handel_press_480.png");
        } else {
            this.f1457H = m1525a("/eraser_handel.png", "/eraser_handel_press.png", "/eraser_handel_press.png");
        }
        customSeekBar.setThumb(this.f1457H);
        customSeekBar.setSeekbarId(1009);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(0);
        gradientDrawable.setCornerRadius(m1524a(5.0f));
        this.f1454E = gradientDrawable;
        ClipDrawable clipDrawable = new ClipDrawable(this.f1454E, 3, 1);
        if (this.f1699an == 240) {
            drawableB = m1527b("/snote_slider_bg.9.png");
        } else {
            drawableB = m1527b("/eraser_bar.9.png");
        }
        int i = this.f1698am.getApplicationInfo().targetSdkVersion;
        if (Integer.valueOf(Build.VERSION.SDK).intValue() >= 14) {
            if (i <= 10) {
                int i2 = this.f1698am.getResources().getDisplayMetrics().densityDpi;
                if (i2 == 160) {
                    iA = m1524a(6.5f);
                } else if (i2 == 480) {
                    iA = m1524a(5.5f);
                } else {
                    iA = m1524a(5.5f);
                }
            } else {
                int i3 = this.f1698am.getResources().getDisplayMetrics().densityDpi;
                if (i3 == 160) {
                    iA = m1524a(3.5f);
                } else if (i3 == 480) {
                    iA = m1524a(-1.0f);
                } else {
                    iA = m1524a(2.5f);
                }
            }
        } else {
            iA = m1524a(2.0f);
        }
        customSeekBar.setProgressDrawable(new LayerDrawable(new Drawable[]{new InsetDrawable(drawableB, 0, iA, 0, iA), clipDrawable}));
        customSeekBar.setPenSettingViewHolder(this);
        return customSeekBar;
    }

    /* renamed from: v */
    private ImageView m1332v() {
        ImageView imageView = new ImageView(this.f1698am);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(m1524a(37.5f), m1524a(37.5f)));
        imageView.setBackgroundDrawable(m1527b("/snote_pen_circle_bg.png"));
        this.f1482aq = m1527b("/snote_pen_circle_big_01.png");
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{this.f1482aq, m1527b("/snote_pen_circle_big_02.png")});
        imageView.setPadding(0, 0, 0, m1524a(0.3f));
        imageView.setImageDrawable(layerDrawable);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        return imageView;
    }

    /* renamed from: w */
    private ViewGroup m1333w() {
        LinearLayout linearLayout = new LinearLayout(this.f1698am);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.bottomMargin = m1524a(2.0f);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setPadding(0, m1524a(2.0f), m1524a(6.25f), 0);
        linearLayout.setGravity(16);
        this.f1450A = m1334x();
        linearLayout.addView(this.f1450A);
        linearLayout.addView(m1335y());
        linearLayout.setVisibility(8);
        return linearLayout;
    }

    /* renamed from: x */
    private CustomSeekBar m1334x() {
        int iA;
        CustomSeekBar customSeekBar = new CustomSeekBar(this.f1698am);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(m1524a(165.0f), -2, 1.0f);
        layoutParams.rightMargin = m1524a(4.5f);
        customSeekBar.setLayoutParams(layoutParams);
        customSeekBar.setPadding(m1524a(12.0f), m1524a(1.0f), m1524a(12.0f), m1524a(2.0f));
        customSeekBar.setMax(39);
        customSeekBar.setContentDescription(this.f1491e);
        try {
            customSeekBar.setHoverPopupType(1);
        } catch (NoSuchMethodError e) {
            e.printStackTrace();
        }
        customSeekBar.setId(1010);
        customSeekBar.setNextFocusDownId(1011);
        customSeekBar.setNextFocusUpId(1009);
        customSeekBar.setNextFocusRightId(1010);
        customSeekBar.setNextFocusLeftId(1010);
        if (this.f1699an == 240) {
            this.f1456G = m1525a("/snote_slider_circle.png", "/snote_slider_circle_press.png", "/snote_slider_circle_press.png");
        } else if (this.f1699an == 480) {
            this.f1456G = m1525a("/eraser_handel_480.png", "/eraser_handel_press_480.png", "/eraser_handel_press_480.png");
        } else {
            this.f1456G = m1525a("/eraser_handel.png", "/eraser_handel_press.png", "/eraser_handel_press.png");
        }
        customSeekBar.setThumb(this.f1456G);
        customSeekBar.setSeekbarId(1010);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(0);
        gradientDrawable.setCornerRadius(m1524a(5.0f));
        this.f1455F = gradientDrawable;
        ClipDrawable clipDrawable = new ClipDrawable(this.f1455F, 3, 1);
        Drawable drawableB = m1527b("/eraser_bar.9.png");
        int i = this.f1698am.getApplicationInfo().targetSdkVersion;
        if (Integer.valueOf(Build.VERSION.SDK).intValue() >= 14) {
            if (i <= 10) {
                int i2 = this.f1698am.getResources().getDisplayMetrics().densityDpi;
                if (i2 == 160) {
                    iA = m1524a(6.5f);
                } else if (i2 == 480) {
                    iA = m1524a(5.5f);
                } else {
                    iA = m1524a(5.5f);
                }
            } else {
                int i3 = this.f1698am.getResources().getDisplayMetrics().densityDpi;
                if (i3 == 160) {
                    iA = m1524a(3.5f);
                } else if (i3 == 480) {
                    iA = m1524a(-1.0f);
                } else {
                    iA = m1524a(2.5f);
                }
            }
        } else {
            iA = m1524a(2.0f);
        }
        customSeekBar.setProgressDrawable(new LayerDrawable(new Drawable[]{new InsetDrawable(drawableB, 0, iA, 0, iA), clipDrawable}));
        customSeekBar.setPenSettingViewHolder(this);
        return customSeekBar;
    }

    /* renamed from: y */
    private View m1335y() {
        ImageView imageView = new ImageView(this.f1698am);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(m1524a(37.5f), m1524a(37.5f)));
        imageView.setBackgroundDrawable(new LayerDrawable(new Drawable[]{m1527b("/snote_pen_circle_transparency.png"), m1527b("/snote_pen_circle_transparency.png")}));
        this.f1458I = m1527b("/snote_pen_circle_big_03.png");
        imageView.setImageDrawable(this.f1458I);
        return imageView;
    }

    /* renamed from: z */
    private ViewGroup m1336z() {
        LinearLayout linearLayout = new LinearLayout(this.f1698am);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = m1524a(5.0f);
        layoutParams.leftMargin = m1524a(7.0f);
        layoutParams.rightMargin = m1524a(7.0f);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundDrawable(m1527b("/snote_option_in_bg.9.png"));
        this.f1452C = m1314A();
        this.f1452C.setContentDescription(String.valueOf(this.f1492f) + this.f1503q);
        this.f1453D = m1315B();
        this.f1453D.setContentDescription(String.valueOf(this.f1493g) + this.f1503q);
        linearLayout.addView(this.f1452C);
        linearLayout.addView(this.f1453D);
        this.f1453D.setVisibility(8);
        return linearLayout;
    }

    /* renamed from: A */
    private C1051g m1314A() {
        C1051g c1051g = new C1051g(this.f1698am);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 1);
        if (this.f1699an == 240) {
            layoutParams.topMargin = m1524a(1.5f);
            layoutParams.leftMargin = m1524a(1.5f);
            layoutParams.rightMargin = m1524a(1.5f);
            layoutParams.bottomMargin = m1524a(3.0f);
        } else {
            layoutParams.topMargin = m1524a(1.0f);
            layoutParams.leftMargin = m1524a(0.5f);
            layoutParams.rightMargin = m1524a(1.5f);
            layoutParams.bottomMargin = m1524a(2.0f);
        }
        c1051g.setLayoutParams(layoutParams);
        c1051g.setClickable(true);
        c1051g.setPadding(m1524a(2.0f), m1524a(2.0f), m1524a(2.5f), m1524a(2.0f));
        c1051g.setFocusable(true);
        c1051g.setId(1011);
        c1051g.setNextFocusDownId(1011);
        c1051g.setNextFocusLeftId(1011);
        c1051g.setNextFocusRightId(1011);
        c1051g.setNextFocusUpId(1010);
        return c1051g;
    }

    /* renamed from: B */
    private C1050f m1315B() {
        C1050f c1050f = new C1050f(this.f1698am);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, m1524a(51.0f));
        if (this.f1699an == 240) {
            layoutParams.topMargin = m1524a(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET);
            layoutParams.leftMargin = m1524a(3.5f);
            layoutParams.rightMargin = m1524a(3.5f);
            layoutParams.bottomMargin = m1524a(3.0f);
        } else {
            layoutParams.topMargin = m1524a(0.5f);
            layoutParams.leftMargin = m1524a(2.5f);
            layoutParams.rightMargin = m1524a(2.5f);
            layoutParams.bottomMargin = m1524a(2.5f);
        }
        c1050f.setLayoutParams(layoutParams);
        c1050f.setClickable(true);
        c1050f.setFocusable(true);
        c1050f.setId(1012);
        c1050f.setNextFocusDownId(1012);
        c1050f.setNextFocusLeftId(1012);
        c1050f.setNextFocusRightId(1012);
        c1050f.setNextFocusUpId(1012);
        return c1050f;
    }

    /* renamed from: C */
    private View m1316C() {
        LinearLayout linearLayout = new LinearLayout(this.f1698am);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        linearLayout.setGravity(1);
        ImageView imageView = new ImageView(this.f1698am);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(m1524a(30.0f), m1524a(20.0f)));
        imageView.setPadding(m1524a(7.5f), m1524a(0.5f), m1524a(7.5f), m1524a(4.0f));
        imageView.setFocusable(false);
        imageView.setImageDrawable(m1527b("/expand_icon_01.png"));
        this.f1468S = imageView;
        linearLayout.addView(this.f1468S);
        return linearLayout;
    }

    /* renamed from: D */
    private View m1317D() {
        LinearLayout linearLayout = new LinearLayout(this.f1698am);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        linearLayout.setBackgroundDrawable(new ColorDrawable(0));
        linearLayout.setGravity(1);
        ImageView imageView = new ImageView(this.f1698am);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(m1524a(30.0f), m1524a(5.0f)));
        imageView.setPadding(m1524a(7.5f), m1524a(0.5f), m1524a(7.5f), m1524a(4.0f));
        imageView.setFocusable(false);
        imageView.setImageDrawable(new ColorDrawable(0));
        this.f1469T = imageView;
        linearLayout.addView(this.f1469T);
        return linearLayout;
    }

    /* renamed from: E */
    private View m1318E() {
        LinearLayout.LayoutParams layoutParams;
        ScrollView scrollView = new ScrollView(this.f1698am);
        if (this.f1699an == 240) {
            layoutParams = new LinearLayout.LayoutParams(m1524a(63.5f), -1);
        } else {
            layoutParams = new LinearLayout.LayoutParams(m1524a(55.5f), -1);
        }
        layoutParams.rightMargin = m1524a(8.0f);
        layoutParams.bottomMargin = 0;
        scrollView.setLayoutParams(layoutParams);
        scrollView.setPadding(m1524a(3.0f), m1524a(3.0f), m1524a(3.0f), m1524a(3.0f));
        scrollView.setBackgroundDrawable(m1527b("/snote_option_in_bg.9.png"));
        scrollView.setVerticalScrollBarEnabled(false);
        scrollView.setHorizontalScrollBarEnabled(false);
        scrollView.setFocusable(false);
        LinearLayout linearLayout = new LinearLayout(this.f1698am);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        linearLayout.setFocusable(false);
        this.f1472W = new PresetLinearLayout(this.f1698am);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        this.f1472W.setOrientation(1);
        this.f1472W.setLayoutParams(layoutParams2);
        this.f1472W.setBackgroundColor(0);
        this.f1473X = new TextView(this.f1698am);
        this.f1473X.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.f1473X.setTextSize(13.0f);
        this.f1473X.setTextColor(-1);
        this.f1473X.setTextSize(1, 13.0f);
        this.f1473X.setText(this.f1474Y);
        this.f1473X.setFocusable(false);
        this.f1473X.setVisibility(8);
        this.f1473X.setContentDescription(this.f1474Y);
        this.f1473X.setPadding(m1524a(2.0f), m1524a(5.0f), m1524a(2.0f), 0);
        linearLayout.addView(this.f1472W);
        linearLayout.addView(this.f1473X);
        scrollView.addView(linearLayout);
        return scrollView;
    }

    /* renamed from: b */
    protected View mo1311b() {
        ThumbControlBackGround thumbControlBackGround = new ThumbControlBackGround(this.f1698am);
        thumbControlBackGround.setTrackWidth(m1524a(4.0f));
        thumbControlBackGround.setTopPadding(m1524a(7.5f));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(m1524a(25.0f), -1);
        layoutParams.rightMargin = m1524a(8.0f);
        thumbControlBackGround.setLayoutParams(layoutParams);
        thumbControlBackGround.setPadding(m1524a(3.0f), m1524a(3.0f), m1524a(3.0f), m1524a(3.0f));
        thumbControlBackGround.setBackgroundDrawable(m1527b("/snote_option_in_bg.9.png"));
        RelativeLayout relativeLayout = new RelativeLayout(this.f1698am);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.f1694ai = new ImageView(this.f1698am);
        this.f1694ai.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.f1694ai.setScaleType(ImageView.ScaleType.CENTER);
        this.f1694ai.setPadding(0, m1524a(7.5f), 0, 0);
        if (this.f1699an == 480) {
            this.f1694ai.setImageDrawable(m1527b("/snote_popup_scroll_handle_n_480.png"));
        } else {
            this.f1694ai.setImageDrawable(m1527b("/snote_popup_scroll_handle_n.png"));
        }
        relativeLayout.addView(this.f1694ai);
        thumbControlBackGround.addView(relativeLayout);
        thumbControlBackGround.setContentDescription(this.f1502p);
        try {
            thumbControlBackGround.setHoverPopupType(1);
        } catch (NoSuchMethodError e) {
            e.printStackTrace();
        }
        return thumbControlBackGround;
    }

    /* renamed from: a */
    protected void mo1310a(boolean z, int i) {
        this.f1483ar = z;
        if (z) {
            if (i == 3) {
                this.f1459J.setVisibility(0);
            } else {
                this.f1459J.setVisibility(8);
            }
            this.f1468S.setImageDrawable(m1527b("/expand_icon_02.png"));
            this.f1460K.setContentDescription(this.f1501o);
            mo1312b(false, i);
            this.f1453D.setVisibility(0);
            return;
        }
        if (i == 3) {
            this.f1459J.setVisibility(0);
        } else {
            this.f1459J.setVisibility(8);
        }
        this.f1468S.setImageDrawable(m1527b("/expand_icon_01.png"));
        this.f1460K.setContentDescription(this.f1500n);
        this.f1453D.setVisibility(8);
        if (this.f1479ac != null) {
            this.f1479ac.onPenSettingViewExpanded(false);
        }
    }

    /* renamed from: a */
    protected void mo1308a(int i, int i2, int i3, int i4) {
        if (this.f1484as == null) {
            this.f1484as = Bitmap.createBitmap(this.f1486au, this.f1486au, Bitmap.Config.ARGB_8888);
        }
        if (this.f1485at == null) {
            this.f1485at = Bitmap.createBitmap(this.f1486au, this.f1486au, Bitmap.Config.ARGB_8888);
        }
        this.f1484as.eraseColor(0);
        Canvas canvas = new Canvas(this.f1484as);
        Paint paint = new Paint();
        paint.setAlpha(255);
        float f = (float) (this.f1486au * (i4 / 72.0f) * 0.9d);
        int i5 = (-16777216) | i2;
        paint.setColor(i5);
        paint.setAntiAlias(true);
        canvas.drawCircle(this.f1486au / 2.0f, this.f1486au / 2.0f, (f >= 1.0f ? f : 1.0f) / 2.0f, paint);
        if (this.f1458I != null) {
            this.f1458I.setColorFilter(new LightingColorFilter(0, i5));
            if (i == 3) {
                this.f1458I.setAlpha(i3);
            } else {
                this.f1458I.setAlpha(127);
            }
        }
        if (this.f1482aq != null) {
            this.f1482aq.setColorFilter(new LightingColorFilter(0, i5));
        }
        this.f1451B.setImageBitmap(this.f1484as);
        this.f1512z.invalidate();
        if (this.f1450A != null) {
            this.f1450A.invalidate();
        }
    }

    /* renamed from: c */
    protected void mo1313c() {
        if (this.f1484as != null && !this.f1484as.isRecycled()) {
            this.f1484as.recycle();
            this.f1484as = null;
        }
        if (this.f1485at != null && !this.f1485at.isRecycled()) {
            this.f1485at.recycle();
            this.f1485at = null;
        }
    }

    /* renamed from: a */
    void m1337a(int i) {
        this.f1476a = this.f1698am.getResources().getString(i);
    }

    /* renamed from: b */
    void m1341b(int i) {
        this.f1488b = this.f1698am.getResources().getString(i);
    }

    /* renamed from: c */
    void m1343c(int i) {
        this.f1474Y = this.f1698am.getResources().getString(i);
    }

    /* renamed from: d */
    void m1345d(int i) {
        this.f1490d = this.f1698am.getResources().getString(i);
    }

    /* renamed from: e */
    void m1347e(int i) {
        this.f1491e = this.f1698am.getResources().getString(i);
    }

    /* renamed from: f */
    void m1349f(int i) {
        this.f1492f = this.f1698am.getResources().getString(i);
    }

    /* renamed from: g */
    void m1351g(int i) {
        this.f1493g = this.f1698am.getResources().getString(i);
    }

    /* renamed from: h */
    void m1352h(int i) {
        this.f1494h = this.f1698am.getResources().getString(i);
    }

    /* renamed from: i */
    void m1353i(int i) {
        this.f1495i = this.f1698am.getResources().getString(i);
    }

    /* renamed from: j */
    void m1354j(int i) {
        this.f1496j = this.f1698am.getResources().getString(i);
    }

    /* renamed from: k */
    void m1355k(int i) {
        this.f1497k = this.f1698am.getResources().getString(i);
    }

    /* renamed from: l */
    void m1356l(int i) {
        this.f1498l = this.f1698am.getResources().getString(i);
    }

    /* renamed from: m */
    void m1357m(int i) {
        this.f1499m = this.f1698am.getResources().getString(i);
    }

    /* renamed from: n */
    void m1358n(int i) {
        this.f1500n = this.f1698am.getResources().getString(i);
    }

    /* renamed from: o */
    void m1359o(int i) {
        this.f1501o = this.f1698am.getResources().getString(i);
    }

    /* renamed from: p */
    void m1360p(int i) {
        this.f1502p = this.f1698am.getResources().getString(i);
    }

    /* renamed from: q */
    void m1361q(int i) {
        Resources resources = this.f1698am.getResources();
        if (i == -1) {
            this.f1503q = "";
        } else {
            this.f1503q = " " + resources.getString(i);
        }
    }

    /* renamed from: a */
    void m1340a(String str) {
        this.f1504r = str;
    }

    /* renamed from: b */
    public void mo1312b(boolean z, int i) {
        if (z) {
            this.f1477aa.setVisibility(8);
            this.f1471V.setVisibility(8);
            this.f1505s.setVisibility(8);
            this.f1464O.setVisibility(8);
            this.f1459J.setVisibility(8);
            this.f1463N.setVisibility(8);
            this.f1506t.setVisibility(8);
            this.f1460K.setVisibility(8);
            this.f1461L.setVisibility(8);
            this.f1453D.setVisibility(8);
            this.f1466Q.setVisibility(8);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f1465P.getLayoutParams();
            layoutParams.bottomMargin = m1524a(12.0f);
            this.f1465P.setLayoutParams(layoutParams);
            this.f1487av = true;
            if (this.f1479ac != null) {
                this.f1479ac.onPenSettingViewExpanded(false);
                return;
            }
            return;
        }
        if (this.f1475Z) {
            this.f1477aa.setVisibility(0);
            m1348f();
            this.f1460K.setPadding(0, 0, 0, 0);
            this.f1461L.setPadding(m1524a(55.5f), 0, 0, 0);
        } else {
            this.f1477aa.setVisibility(8);
            this.f1471V.setVisibility(8);
            this.f1460K.setPadding(0, 0, 0, 0);
            this.f1461L.setPadding(0, 0, 0, 0);
        }
        this.f1505s.setVisibility(0);
        this.f1464O.setVisibility(0);
        if (this.f1483ar) {
            if (i == 3) {
                this.f1453D.setVisibility(0);
                this.f1459J.setVisibility(0);
            } else {
                this.f1453D.setVisibility(0);
                this.f1459J.setVisibility(8);
            }
            if (this.f1479ac != null) {
                this.f1479ac.onPenSettingViewExpanded(true);
            }
        } else if (i == 3) {
            this.f1459J.setVisibility(0);
        }
        this.f1463N.setVisibility(0);
        this.f1506t.setVisibility(0);
        this.f1460K.setVisibility(0);
        this.f1461L.setVisibility(0);
        this.f1466Q.setVisibility(0);
        if (this.f1487av) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f1465P.getLayoutParams();
            layoutParams2.bottomMargin = m1524a(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET);
            this.f1465P.setLayoutParams(layoutParams2);
            this.f1487av = false;
        }
    }

    /* renamed from: r */
    void m1362r(int i) {
        this.f1489c = this.f1698am.getResources().getString(i);
    }

    /* renamed from: a */
    public void m1339a(PresetLinearLayout.InterfaceC0982a interfaceC0982a) {
        this.f1472W.setOnItemSelectedListener(interfaceC0982a);
    }

    /* renamed from: b */
    public void m1342b(boolean z) {
        if (z != this.f1480ad) {
            this.f1480ad = z;
            m1348f();
        }
    }

    /* renamed from: f */
    protected void m1348f() {
        if (this.f1472W.getChildCount() >= 12) {
            mo1309a(false);
        } else {
            mo1309a(true);
        }
    }

    /* renamed from: a */
    protected void mo1309a(boolean z) {
        this.f1471V.setEnabled(z);
        if (this.f1480ad) {
            if (this.f1471V.getVisibility() == 8) {
                this.f1471V.setVisibility(0);
            }
            if (z) {
                if (this.f1699an == 240) {
                    this.f1471V.setBackgroundDrawable(m1530b("/snote_add.png", "/snote_add_press.png", "/snote_add.png", null, "/snote_add_dim.png"));
                    return;
                } else {
                    this.f1471V.setBackgroundDrawable(m1526a("/snote_add.png", "/snote_add_press.png", "/snote_add.png", null, "/snote_add_dim.png"));
                    return;
                }
            }
            if (this.f1699an == 240) {
                this.f1471V.setBackgroundDrawable(m1531c("/snote_add_dim.png"));
                return;
            } else {
                this.f1471V.setBackgroundDrawable(m1527b("/snote_add_dim.png"));
                return;
            }
        }
        this.f1471V.setVisibility(z ? 0 : 8);
        if (this.f1699an == 240) {
            this.f1471V.setBackgroundDrawable(m1530b("/snote_add.png", "/snote_add_press.png", "/snote_add.png", null, "/snote_add_dim.png"));
        } else {
            this.f1471V.setBackgroundDrawable(m1526a("/snote_add.png", "/snote_add_press.png", "/snote_add.png", null, "/snote_add_dim.png"));
        }
    }

    /* renamed from: a */
    public void m1338a(AbstractSettingView.OnSettingViewExpandedListener onSettingViewExpandedListener) {
        this.f1479ac = onSettingViewExpandedListener;
    }

    /* renamed from: s */
    protected void m1363s(int i) {
        this.f1481ae = i;
        if (this.f1470U != null) {
            this.f1470U.setGravity(i);
        }
    }

    /* renamed from: g */
    protected void m1350g() {
        this.f1488b = "";
        this.f1489c = "";
        this.f1490d = "";
        this.f1491e = "";
        this.f1492f = "";
        this.f1493g = "";
        this.f1494h = "";
        this.f1495i = "";
        this.f1496j = "";
        this.f1497k = "";
        this.f1498l = "";
        this.f1499m = "";
        this.f1500n = "";
        this.f1501o = "";
        this.f1502p = "";
    }
}
