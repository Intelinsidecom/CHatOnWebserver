package com.samsung.sdraw;

import android.content.Context;
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
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;

/* renamed from: com.samsung.sdraw.ak */
/* loaded from: classes.dex */
class C0998ak extends C0999al {

    /* renamed from: aq */
    private Drawable f1445aq;

    /* renamed from: ar */
    private boolean f1446ar;

    /* renamed from: as */
    private Bitmap f1447as;

    /* renamed from: at */
    private Bitmap f1448at;

    /* renamed from: au */
    private int f1449au;

    public C0998ak(Context context, String str) {
        super(context, str);
        this.f1446ar = false;
        this.f1449au = 70;
    }

    @Override // com.samsung.sdraw.C0999al
    /* renamed from: a */
    protected PenSettingRootView mo1307a() {
        m1533h();
        return m1289i();
    }

    /* renamed from: i */
    private PenSettingRootView m1289i() {
        PenSettingRootView penSettingRootView = new PenSettingRootView(this.f1698am);
        penSettingRootView.setLayoutParams(new LinearLayout.LayoutParams(m1524a((388.5f * this.f1700ao) - 11.0f), -2));
        penSettingRootView.setOrientation(1);
        penSettingRootView.setPadding(0, -10, 0, 0);
        penSettingRootView.addView(m1290j());
        penSettingRootView.addView(m1294n());
        penSettingRootView.setOnTouchListener(this.f1701ap);
        return penSettingRootView;
    }

    /* renamed from: j */
    private ViewGroup m1290j() {
        RelativeLayout relativeLayout = new RelativeLayout(this.f1698am);
        relativeLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, m1524a(59.0f * this.f1700ao)));
        relativeLayout.setPadding(0, 0, 0, 0);
        this.f1462M = m1293m();
        relativeLayout.addView(m1291k());
        LinearLayout linearLayout = new LinearLayout(this.f1698am);
        linearLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        linearLayout.setOrientation(0);
        this.f1470U = m1292l();
        linearLayout.addView(this.f1470U);
        linearLayout.addView(this.f1462M);
        relativeLayout.addView(linearLayout);
        return relativeLayout;
    }

    /* renamed from: k */
    private View m1291k() {
        LinearLayout linearLayout = new LinearLayout(this.f1698am);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, m1524a(this.f1700ao * 59.0f)));
        linearLayout.setOrientation(0);
        ImageView imageView = new ImageView(this.f1698am);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(-1, m1524a(this.f1700ao * 59.0f), 1.0f));
        imageView.setBackgroundDrawable(m1527b("/snote_title_left_tablet.9.png"));
        ImageView imageView2 = new ImageView(this.f1698am);
        imageView2.setLayoutParams(new LinearLayout.LayoutParams(-1, m1524a(this.f1700ao * 59.0f), 1.0f));
        imageView2.setBackgroundDrawable(m1527b("/snote_title_right_tablet.9.png"));
        linearLayout.addView(imageView);
        linearLayout.addView(imageView2);
        return linearLayout;
    }

    /* renamed from: l */
    private TextView m1292l() {
        Typeface typefaceCreateFromFile = null;
        TextView textView = new TextView(this.f1698am);
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, m1524a(59.0f * this.f1700ao), 1.0f));
        textView.setTextSize(20.0f);
        textView.setTextColor(-3618616);
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
        textView.setTextSize(1, this.f1700ao * 20.0f);
        textView.setContentDescription(this.f1476a);
        textView.setPadding(m1524a(this.f1700ao * 22.0f), m1524a(this.f1700ao * 22.0f), m1524a(17.0f * this.f1700ao), 0);
        textView.setIncludeFontPadding(false);
        textView.setSingleLine();
        return textView;
    }

    /* renamed from: m */
    private View m1293m() {
        ImageButton imageButton = new ImageButton(this.f1698am);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        if (this.f1699an == 213) {
            layoutParams.topMargin = m1524a(15.05f);
            layoutParams.rightMargin = m1524a(5.0f);
        } else {
            layoutParams.topMargin = m1524a(20.0f * this.f1700ao);
            layoutParams.rightMargin = m1524a(6.0f);
        }
        imageButton.setLayoutParams(layoutParams);
        imageButton.setFocusable(true);
        imageButton.setContentDescription(this.f1488b);
        imageButton.setId(1000);
        imageButton.setNextFocusRightId(1000);
        imageButton.setNextFocusLeftId(1002);
        imageButton.setNextFocusDownId(PresetTabletItem.IB_TABLET_PEN_PRESET_DELETE_ID);
        imageButton.setImageDrawable(m1527b("/snote_title_button_cancle.png"));
        imageButton.setBackgroundDrawable(m1525a(null, "/snote_title_right_press.9.png", "/snote_title_right_press.9.png"));
        imageButton.setPadding(0, 0, 0, 0);
        imageButton.setScaleType(ImageView.ScaleType.FIT_XY);
        return imageButton;
    }

    /* renamed from: n */
    private ViewGroup m1294n() {
        LinearLayout linearLayout = new LinearLayout(this.f1698am);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        linearLayout.setPadding(m1524a(11.0f * this.f1700ao), m1524a(4.0f * this.f1700ao), 0, m1524a(15.0f * this.f1700ao));
        linearLayout.setBackgroundDrawable(m1527b("/snote_title_bottom.9.png"));
        linearLayout.addView(m1295o());
        return linearLayout;
    }

    /* renamed from: o */
    private ViewGroup m1295o() {
        this.f1478ab = new LinearLayout(this.f1698am);
        this.f1478ab.setLayoutParams(new LinearLayout.LayoutParams(-2, -2, 1.0f));
        this.f1478ab.setOrientation(0);
        this.f1695aj = new PenSettingScrollView(this.f1698am);
        this.f1695aj.setLayoutParams(new LinearLayout.LayoutParams(m1524a((this.f1700ao * 388.5f) - 11.0f), -2));
        this.f1695aj.setFadingEdgeLength(0);
        this.f1695aj.setVerticalScrollBarEnabled(false);
        this.f1695aj.setOverScrollMode(2);
        this.f1695aj.setFocusable(false);
        PalletView palletView = new PalletView(this.f1698am);
        palletView.setLayoutParams(new ViewGroup.LayoutParams(-1, m1524a(237.0f * this.f1700ao)));
        palletView.setOrientation(1);
        palletView.setPadding(m1524a(13.0f * this.f1700ao), 0, m1524a(14.0f * this.f1700ao), 0);
        this.f1506t = m1299s();
        this.f1459J = m1303w();
        this.f1460K = m1286C();
        this.f1460K.setContentDescription(this.f1500n);
        try {
            this.f1460K.setHoverPopupType(1);
        } catch (NoSuchMethodError e) {
            e.printStackTrace();
        }
        this.f1461L = m1287D();
        this.f1464O = m1297q();
        this.f1465P = m1306z();
        this.f1466Q = m1296p();
        palletView.addView(this.f1464O);
        palletView.addView(this.f1506t);
        palletView.addView(this.f1466Q);
        palletView.addView(this.f1465P);
        this.f1467R = palletView;
        this.f1695aj.addView(this.f1467R);
        this.f1478ab.addView(this.f1695aj);
        this.f1477aa = m1288E();
        this.f1477aa.setVisibility(8);
        this.f1478ab.addView(this.f1477aa);
        this.f1693ah = mo1311b();
        this.f1478ab.addView(this.f1693ah);
        this.f1693ah.setVisibility(8);
        LinearLayout linearLayout = new LinearLayout(this.f1698am);
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(m1524a((this.f1700ao * 388.5f) - 11.0f), m1524a(5.0f)));
        linearLayout.setOrientation(1);
        LinearLayout linearLayout2 = new LinearLayout(this.f1698am);
        linearLayout2.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        linearLayout2.setOrientation(1);
        linearLayout2.addView(linearLayout);
        linearLayout2.addView(this.f1478ab);
        linearLayout2.addView(this.f1460K);
        return linearLayout2;
    }

    @Override // com.samsung.sdraw.C0999al
    /* renamed from: b */
    protected View mo1311b() {
        ThumbControlBackGround thumbControlBackGround = new ThumbControlBackGround(this.f1698am);
        thumbControlBackGround.setTrackWidth(m1524a(4.0f));
        thumbControlBackGround.setTopPadding(m1524a(7.5f));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(m1524a(35.0f), -1);
        layoutParams.topMargin = m1524a(5.0f);
        layoutParams.leftMargin = m1524a(-5.0f);
        layoutParams.rightMargin = m1524a(12.0f);
        thumbControlBackGround.setLayoutParams(layoutParams);
        thumbControlBackGround.setPadding(m1524a(3.0f), m1524a(3.0f), m1524a(3.0f), m1524a(3.0f));
        thumbControlBackGround.setBackgroundDrawable(m1527b("/snote_option_in_bg.9.png"));
        RelativeLayout relativeLayout = new RelativeLayout(this.f1698am);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.f1694ai = new ImageView(this.f1698am);
        this.f1694ai.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.f1694ai.setScaleType(ImageView.ScaleType.CENTER);
        this.f1694ai.setPadding(0, m1524a(7.5f), 0, 0);
        this.f1694ai.setImageDrawable(m1527b("/snote_popup_scroll_handle_n.png"));
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

    /* renamed from: p */
    private View m1296p() {
        LinearLayout linearLayout = new LinearLayout(this.f1698am);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = m1524a(5.0f);
        layoutParams.leftMargin = 0;
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setBackgroundDrawable(m1527b("/snote_option_in_bg.9.png"));
        linearLayout.setOrientation(1);
        this.f1459J = m1303w();
        this.f1463N = m1300t();
        linearLayout.addView(this.f1463N);
        linearLayout.addView(this.f1459J);
        return linearLayout;
    }

    /* renamed from: q */
    private View m1297q() {
        FrameLayout frameLayout = new FrameLayout(this.f1698am);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, m1524a(141.5f * this.f1700ao));
        layoutParams.topMargin = m1524a(5.0f);
        layoutParams.leftMargin = 0;
        frameLayout.setLayoutParams(layoutParams);
        frameLayout.setBackgroundDrawable(m1527b("/snote_type_preview_bg_00.png"));
        this.f1505s = new PenSettingPreView(this.f1698am);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1, 17);
        layoutParams2.leftMargin++;
        this.f1505s.setLayoutParams(layoutParams2);
        this.f1505s.setBackgroundDrawable(m1527b("/snote_type_preview_bg_00.png"));
        this.f1505s.setContentDescription(this.f1494h);
        frameLayout.addView(this.f1505s);
        this.f1471V = m1298r();
        frameLayout.addView(this.f1471V);
        return frameLayout;
    }

    /* renamed from: r */
    private View m1298r() {
        FrameLayout.LayoutParams layoutParams;
        C1052h c1052h = new C1052h(this.f1698am);
        if (this.f1699an == 320) {
            layoutParams = new FrameLayout.LayoutParams(m1524a(31.0f), m1524a(31.0f), 53);
        } else {
            layoutParams = new FrameLayout.LayoutParams(-2, -2, 53);
        }
        if (this.f1699an == 213) {
            layoutParams.topMargin = m1524a(3.0f);
            layoutParams.rightMargin = m1524a(3.0f);
        } else {
            layoutParams.topMargin = m1524a(5.0f);
            layoutParams.rightMargin = m1524a(5.0f);
        }
        c1052h.setLayoutParams(layoutParams);
        c1052h.setContentDescription(this.f1489c);
        c1052h.setFocusable(true);
        c1052h.setId(1002);
        c1052h.setNextFocusUpId(1000);
        c1052h.setNextFocusDownId(1008);
        c1052h.setNextFocusLeftId(1004);
        c1052h.setNextFocusRightId(1003);
        c1052h.setBackgroundDrawable(m1526a("/snote_tablet_add.png", "/snote_tablet_add_press.png", "/snote_tablet_add.png", null, "/snote_tablet_add_dim.png"));
        c1052h.setImageDrawable(m1525a(null, null, "/snote_tablet_add_focus.png"));
        c1052h.setPadding(0, 0, 0, 0);
        c1052h.setScaleType(ImageView.ScaleType.FIT_XY);
        return c1052h;
    }

    /* renamed from: s */
    private ViewGroup m1299s() {
        LinearLayout linearLayout = new LinearLayout(this.f1698am);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = m1524a(5.0f);
        layoutParams.leftMargin = m1524a((1.0f - this.f1700ao) * 4.0f);
        layoutParams.rightMargin = 0;
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(0);
        linearLayout.setBackgroundDrawable(m1527b("/snote_option_in_bg.9.png"));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(m1524a(70.0f * this.f1700ao), m1524a(70.0f * this.f1700ao));
        this.f1507u = new ImageButton(this.f1698am);
        this.f1507u.setContentDescription(String.valueOf(String.format(this.f1495i, 1)) + this.f1503q);
        this.f1507u.setFocusable(true);
        this.f1507u.setId(1004);
        this.f1507u.setNextFocusUpId(1002);
        this.f1507u.setNextFocusDownId(1009);
        this.f1507u.setNextFocusRightId(1005);
        this.f1507u.setNextFocusLeftId(1004);
        this.f1507u.setBackgroundDrawable(m1527b("/snote_type_01.png"));
        this.f1507u.setImageDrawable(m1525a(null, "/snote_type_selected.png", "/snote_type_selected.png"));
        this.f1507u.setScaleType(ImageView.ScaleType.FIT_XY);
        this.f1507u.setLayoutParams(layoutParams2);
        this.f1507u.setPadding(0, 0, 0, 0);
        linearLayout.addView(this.f1507u);
        this.f1508v = new ImageButton(this.f1698am);
        this.f1508v.setContentDescription(String.valueOf(String.format(this.f1496j, 2)) + this.f1503q);
        this.f1508v.setFocusable(true);
        this.f1508v.setImageDrawable(m1525a(null, "/snote_type_selected.png", "/snote_type_selected.png"));
        this.f1508v.setId(1005);
        this.f1508v.setNextFocusUpId(1002);
        this.f1508v.setNextFocusDownId(1009);
        this.f1508v.setNextFocusLeftId(1004);
        this.f1508v.setNextFocusRightId(1006);
        this.f1508v.setBackgroundDrawable(m1527b("/snote_type_02.png"));
        this.f1508v.setScaleType(ImageView.ScaleType.FIT_XY);
        this.f1508v.setLayoutParams(layoutParams2);
        this.f1508v.setPadding(0, 0, 0, 0);
        linearLayout.addView(this.f1508v);
        this.f1509w = new ImageButton(this.f1698am);
        this.f1509w.setContentDescription(String.valueOf(String.format(this.f1497k, 3)) + this.f1503q);
        this.f1509w.setFocusable(true);
        this.f1509w.setImageDrawable(m1525a(null, "/snote_type_selected.png", "/snote_type_selected.png"));
        this.f1509w.setId(1006);
        this.f1509w.setNextFocusDownId(1009);
        this.f1509w.setNextFocusLeftId(1005);
        this.f1509w.setNextFocusRightId(1007);
        this.f1509w.setNextFocusUpId(1002);
        this.f1509w.setBackgroundDrawable(m1527b("/snote_type_05.png"));
        this.f1509w.setScaleType(ImageView.ScaleType.FIT_XY);
        this.f1509w.setLayoutParams(layoutParams2);
        this.f1509w.setPadding(0, 0, 0, 0);
        linearLayout.addView(this.f1509w);
        this.f1510x = new ImageButton(this.f1698am);
        this.f1510x.setContentDescription(String.valueOf(String.format(this.f1498l, 4)) + this.f1503q);
        this.f1510x.setFocusable(true);
        this.f1510x.setImageDrawable(m1525a(null, "/snote_type_selected.png", "/snote_type_selected.png"));
        this.f1510x.setId(1007);
        this.f1510x.setNextFocusDownId(1009);
        this.f1510x.setNextFocusLeftId(1006);
        this.f1510x.setNextFocusRightId(1008);
        this.f1510x.setNextFocusUpId(1002);
        this.f1510x.setBackgroundDrawable(m1527b("/snote_type_03.png"));
        this.f1510x.setScaleType(ImageView.ScaleType.FIT_XY);
        this.f1510x.setLayoutParams(layoutParams2);
        this.f1510x.setPadding(0, 0, 0, 0);
        linearLayout.addView(this.f1510x);
        this.f1511y = new ImageButton(this.f1698am);
        this.f1511y.setContentDescription(String.valueOf(String.format(this.f1499m, 5)) + this.f1503q);
        this.f1511y.setFocusable(true);
        this.f1511y.setImageDrawable(m1525a(null, "/snote_type_selected.png", "/snote_type_selected.png"));
        this.f1511y.setId(1008);
        this.f1511y.setNextFocusDownId(1009);
        this.f1511y.setNextFocusLeftId(1007);
        this.f1511y.setNextFocusRightId(1003);
        this.f1511y.setNextFocusUpId(1002);
        this.f1511y.setBackgroundDrawable(m1527b("/snote_type_04.png"));
        this.f1511y.setScaleType(ImageView.ScaleType.FIT_XY);
        this.f1511y.setLayoutParams(layoutParams2);
        this.f1511y.setPadding(0, 0, 0, 0);
        linearLayout.addView(this.f1511y);
        return linearLayout;
    }

    /* renamed from: t */
    private ViewGroup m1300t() {
        LinearLayout linearLayout = new LinearLayout(this.f1698am);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        linearLayout.setPadding(0, m1524a(this.f1700ao * 2.0f), m1524a(6.25f * this.f1700ao), m1524a(this.f1700ao * 2.0f));
        linearLayout.setGravity(16);
        this.f1512z = m1301u();
        this.f1451B = m1302v();
        linearLayout.addView(this.f1512z);
        linearLayout.addView(this.f1451B);
        return linearLayout;
    }

    /* renamed from: u */
    private CustomSeekBar m1301u() {
        CustomSeekBar customSeekBar = new CustomSeekBar(this.f1698am);
        customSeekBar.setPenSettingViewHolder(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(m1524a(165.0f * this.f1700ao), -2, 1.0f);
        layoutParams.rightMargin = m1524a(4.5f);
        customSeekBar.setLayoutParams(layoutParams);
        customSeekBar.setPadding(m1524a(18.0f * this.f1700ao), m1524a(2.0f * this.f1700ao), m1524a(24.0f * this.f1700ao), m1524a(this.f1700ao * 1.0f));
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
        if (this.f1699an == 213) {
            this.f1457H = m1529b("/eraser_handel.png", "/eraser_handel_press.png", "/eraser_handel_press.png");
        } else {
            this.f1457H = m1525a("/snote_slider_circle.png", "/snote_slider_circle_press.png", "/snote_slider_circle_press.png");
        }
        customSeekBar.setThumb(this.f1457H);
        customSeekBar.setSeekbarId(1009);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(0);
        gradientDrawable.setCornerRadius(m1524a(5.0f));
        this.f1454E = gradientDrawable;
        customSeekBar.setProgressDrawable(new LayerDrawable(new Drawable[]{new InsetDrawable(m1527b("/snote_slider_bg.9.png"), 0, 0, 0, 0), new ClipDrawable(this.f1454E, 3, 1)}));
        return customSeekBar;
    }

    /* renamed from: v */
    private ImageView m1302v() {
        ImageView imageView = new ImageView(this.f1698am);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(m1524a(47.0f), m1524a(47.0f)));
        imageView.setBackgroundDrawable(m1527b("/snote_pen_circle_bg.png"));
        this.f1445aq = m1527b("/snote_pen_circle_big_01.png");
        imageView.setImageDrawable(new LayerDrawable(new Drawable[]{this.f1445aq, m1527b("/snote_pen_circle_big_02.png")}));
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        return imageView;
    }

    /* renamed from: w */
    private ViewGroup m1303w() {
        LinearLayout linearLayout = new LinearLayout(this.f1698am);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        linearLayout.setPadding(0, m1524a(2.0f * this.f1700ao), m1524a(6.25f * this.f1700ao), 0);
        linearLayout.setGravity(16);
        this.f1450A = m1304x();
        linearLayout.addView(this.f1450A);
        linearLayout.addView(m1305y());
        linearLayout.setVisibility(8);
        return linearLayout;
    }

    /* renamed from: x */
    private CustomSeekBar m1304x() {
        CustomSeekBar customSeekBar = new CustomSeekBar(this.f1698am);
        customSeekBar.setPenSettingViewHolder(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(m1524a(165.0f), -2, 1.0f);
        layoutParams.rightMargin = m1524a(4.5f);
        customSeekBar.setLayoutParams(layoutParams);
        customSeekBar.setPadding(m1524a(18.0f * this.f1700ao), m1524a(this.f1700ao * 1.0f), m1524a(24.0f * this.f1700ao), m1524a(2.0f * this.f1700ao));
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
        if (this.f1699an == 213) {
            this.f1456G = m1529b("/eraser_handel.png", "/eraser_handel_press.png", "/eraser_handel_press.png");
        } else {
            this.f1456G = m1525a("/snote_slider_circle.png", "/snote_slider_circle_press.png", "/snote_slider_circle_press.png");
        }
        customSeekBar.setThumb(this.f1456G);
        customSeekBar.setSeekbarId(1010);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(0);
        gradientDrawable.setCornerRadius(m1524a(5.0f));
        this.f1455F = gradientDrawable;
        customSeekBar.setProgressDrawable(new LayerDrawable(new Drawable[]{new InsetDrawable(m1527b("/snote_slider_bg.9.png"), 0, 0, 0, 0), new ClipDrawable(this.f1455F, 3, 1)}));
        return customSeekBar;
    }

    /* renamed from: y */
    private View m1305y() {
        ImageView imageView = new ImageView(this.f1698am);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(m1524a(47.0f), m1524a(47.0f)));
        imageView.setBackgroundDrawable(new LayerDrawable(new Drawable[]{m1527b("/snote_pen_circle_transparency.png"), m1527b("/snote_pen_circle_transparency.png")}));
        this.f1458I = m1527b("/snote_pen_circle_big_03.png");
        imageView.setImageDrawable(this.f1458I);
        return imageView;
    }

    /* renamed from: z */
    private ViewGroup m1306z() {
        LinearLayout linearLayout = new LinearLayout(this.f1698am);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = m1524a(5.0f);
        layoutParams.leftMargin = 0;
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundDrawable(m1527b("/snote_option_in_bg.9.png"));
        this.f1452C = m1284A();
        this.f1452C.setContentDescription(String.valueOf(this.f1492f) + this.f1503q);
        this.f1453D = m1285B();
        this.f1453D.setContentDescription(String.valueOf(this.f1493g) + this.f1503q);
        linearLayout.addView(this.f1452C);
        linearLayout.addView(this.f1453D);
        this.f1453D.setVisibility(8);
        return linearLayout;
    }

    /* renamed from: A */
    private C1051g m1284A() {
        C1051g c1051g = new C1051g(this.f1698am);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 1);
        layoutParams.topMargin = m1524a(this.f1700ao * 2.0f);
        layoutParams.leftMargin = m1524a(this.f1700ao * 2.0f);
        layoutParams.rightMargin = m1524a(4.0f * this.f1700ao);
        layoutParams.bottomMargin = m1524a(3.0f * this.f1700ao);
        c1051g.setLayoutParams(layoutParams);
        c1051g.setClickable(true);
        c1051g.setPadding(m1524a(2.0f), m1524a(2.0f), m1524a(2.0f), m1524a(2.0f));
        c1051g.setFocusable(true);
        c1051g.setId(1011);
        c1051g.setNextFocusDownId(1011);
        c1051g.setNextFocusLeftId(1011);
        c1051g.setNextFocusRightId(1011);
        c1051g.setNextFocusUpId(1010);
        return c1051g;
    }

    /* renamed from: B */
    private C1050f m1285B() {
        C1050f c1050f = new C1050f(this.f1698am);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, m1524a(85.0f * this.f1700ao));
        layoutParams.topMargin = m1524a(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET * this.f1700ao);
        layoutParams.leftMargin = m1524a(this.f1700ao * 4.0f);
        layoutParams.rightMargin = m1524a(this.f1700ao * 4.0f);
        layoutParams.bottomMargin = m1524a(this.f1700ao * 4.0f);
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
    private View m1286C() {
        LinearLayout linearLayout = new LinearLayout(this.f1698am);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        linearLayout.setGravity(1);
        ImageView imageView = new ImageView(this.f1698am);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(m1524a(30.0f), m1524a(20.0f));
        layoutParams.topMargin = m1524a(2.0f);
        layoutParams.bottomMargin = m1524a(7.0f * this.f1700ao);
        imageView.setLayoutParams(layoutParams);
        imageView.setPadding(m1524a(7.5f), m1524a(2.5f), m1524a(7.5f), m1524a(2.5f));
        imageView.setFocusable(false);
        imageView.setImageDrawable(m1527b("/expand_icon_01.png"));
        this.f1468S = imageView;
        linearLayout.addView(this.f1468S);
        return linearLayout;
    }

    /* renamed from: D */
    private View m1287D() {
        LinearLayout linearLayout = new LinearLayout(this.f1698am);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        linearLayout.setBackgroundDrawable(new ColorDrawable(0));
        linearLayout.setGravity(1);
        ImageView imageView = new ImageView(this.f1698am);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(m1524a(30.0f), m1524a(5.0f));
        layoutParams.topMargin = m1524a(2.0f);
        imageView.setLayoutParams(layoutParams);
        imageView.setPadding(m1524a(7.5f), m1524a(2.5f), m1524a(7.5f), m1524a(2.5f));
        imageView.setFocusable(false);
        imageView.setImageDrawable(new ColorDrawable(0));
        this.f1469T = imageView;
        linearLayout.addView(this.f1469T);
        return linearLayout;
    }

    /* renamed from: E */
    private View m1288E() {
        LinearLayout.LayoutParams layoutParams;
        ScrollView scrollView = new ScrollView(this.f1698am);
        if (this.f1699an == 213) {
            layoutParams = new LinearLayout.LayoutParams(m1524a(77.0f), -1);
        } else {
            layoutParams = new LinearLayout.LayoutParams(m1524a(97.0f * this.f1700ao), -1);
        }
        layoutParams.topMargin = m1524a(5.0f);
        layoutParams.leftMargin = m1524a((-9.0f) * this.f1700ao);
        layoutParams.rightMargin = m1524a(13.0f * this.f1700ao);
        scrollView.setLayoutParams(layoutParams);
        scrollView.setPadding(m1524a(5.0f), m1524a(5.0f), m1524a(5.0f), m1524a(5.0f));
        scrollView.setBackgroundDrawable(m1527b("/snote_option_in_bg.9.png"));
        scrollView.setVerticalScrollBarEnabled(false);
        scrollView.setHorizontalScrollBarEnabled(false);
        scrollView.setFocusable(false);
        LinearLayout linearLayout = new LinearLayout(this.f1698am);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        linearLayout.setFocusable(false);
        this.f1472W = new PresetTabletLinearLayout(this.f1698am);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        this.f1472W.setOrientation(1);
        this.f1472W.setLayoutParams(layoutParams2);
        this.f1472W.setBackgroundColor(0);
        if (this.f1699an == 213) {
            this.f1472W.setPadding(m1524a(6.0f), m1524a(4.0f), m1524a(6.0f), 0);
        }
        this.f1473X = new TextView(this.f1698am);
        this.f1473X.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.f1473X.setTextSize(20.0f);
        this.f1473X.setTextColor(-3618616);
        this.f1473X.setTextSize(1, 20.0f * this.f1700ao);
        this.f1473X.setText(this.f1474Y);
        this.f1473X.setFocusable(false);
        this.f1473X.setVisibility(8);
        this.f1473X.setContentDescription(this.f1474Y);
        this.f1473X.setPadding(m1524a(6.0f), m1524a(5.0f), m1524a(6.0f), 0);
        linearLayout.addView(this.f1472W);
        linearLayout.addView(this.f1473X);
        scrollView.addView(linearLayout);
        return scrollView;
    }

    @Override // com.samsung.sdraw.C0999al
    /* renamed from: a */
    protected void mo1310a(boolean z, int i) {
        this.f1446ar = z;
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

    @Override // com.samsung.sdraw.C0999al
    /* renamed from: a */
    protected void mo1308a(int i, int i2, int i3, int i4) {
        if (this.f1447as == null) {
            this.f1447as = Bitmap.createBitmap(this.f1449au, this.f1449au, Bitmap.Config.ARGB_8888);
        }
        if (this.f1448at == null) {
            this.f1448at = Bitmap.createBitmap(this.f1449au, this.f1449au, Bitmap.Config.ARGB_8888);
        }
        this.f1447as.eraseColor(0);
        Canvas canvas = new Canvas(this.f1447as);
        Paint paint = new Paint();
        paint.setAlpha(255);
        float f = (float) (this.f1449au * (i4 / 72.0f) * 0.9d);
        int i5 = (-16777216) | i2;
        paint.setColor(i5);
        paint.setAntiAlias(true);
        canvas.drawCircle(this.f1449au / 2.0f, this.f1449au / 2.0f, (f >= 1.0f ? f : 1.0f) / 2.0f, paint);
        this.f1458I.setColorFilter(new LightingColorFilter(0, i5));
        if (i == 3) {
            this.f1458I.setAlpha(i3);
        } else {
            this.f1458I.setAlpha(127);
        }
        this.f1445aq.setColorFilter(new LightingColorFilter(0, i5));
        this.f1451B.setImageBitmap(this.f1447as);
        this.f1512z.invalidate();
        this.f1450A.invalidate();
    }

    @Override // com.samsung.sdraw.C0999al
    /* renamed from: c */
    protected void mo1313c() {
        if (this.f1447as != null && !this.f1447as.isRecycled()) {
            this.f1447as.recycle();
            this.f1447as = null;
        }
        if (this.f1448at != null && !this.f1448at.isRecycled()) {
            this.f1448at.recycle();
            this.f1448at = null;
        }
    }

    @Override // com.samsung.sdraw.C0999al
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
            this.f1461L.setPadding(m1524a(97.0f), 0, 0, 0);
        } else {
            this.f1477aa.setVisibility(8);
            this.f1471V.setVisibility(8);
            this.f1460K.setPadding(0, 0, 0, 0);
            this.f1461L.setPadding(0, 0, 0, 0);
        }
        this.f1505s.setVisibility(0);
        this.f1464O.setVisibility(0);
        if (this.f1446ar) {
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
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f1465P.getLayoutParams();
        layoutParams2.bottomMargin = m1524a(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET);
        this.f1465P.setLayoutParams(layoutParams2);
    }

    @Override // com.samsung.sdraw.C0999al
    /* renamed from: a */
    protected void mo1309a(boolean z) {
        this.f1471V.setEnabled(z);
        if (this.f1480ad) {
            if (this.f1471V.getVisibility() == 8) {
                this.f1471V.setVisibility(0);
            }
            if (z) {
                this.f1471V.setBackgroundDrawable(m1526a("/snote_tablet_add.png", "/snote_tablet_add_press.png", "/snote_tablet_add.png", null, "/snote_tablet_add_dim.png"));
                return;
            } else {
                this.f1471V.setBackgroundDrawable(m1527b("/snote_tablet_add_dim.png"));
                return;
            }
        }
        this.f1471V.setVisibility(z ? 0 : 8);
        this.f1471V.setBackgroundDrawable(m1526a("/snote_tablet_add.png", "/snote_tablet_add_press.png", "/snote_tablet_add.png", null, "/snote_tablet_add_dim.png"));
    }
}
