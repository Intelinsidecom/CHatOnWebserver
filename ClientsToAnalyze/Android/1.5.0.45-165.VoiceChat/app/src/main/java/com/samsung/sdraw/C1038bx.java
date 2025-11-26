package com.samsung.sdraw;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import com.vlingo.sdk.internal.http.HttpUtil;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: com.samsung.sdraw.bx */
/* loaded from: classes.dex */
class C1038bx extends C1044cc {

    /* renamed from: A */
    protected ImageButton f1605A;

    /* renamed from: B */
    protected ImageButton f1606B;

    /* renamed from: C */
    protected ImageButton f1607C;

    /* renamed from: D */
    protected ImageButton f1608D;

    /* renamed from: E */
    protected ImageButton f1609E;

    /* renamed from: F */
    protected ImageButton f1610F;

    /* renamed from: G */
    protected C1051g f1611G;

    /* renamed from: H */
    protected C1050f f1612H;

    /* renamed from: I */
    protected GradientDrawable f1613I;

    /* renamed from: J */
    protected View f1614J;

    /* renamed from: K */
    protected View f1615K;

    /* renamed from: L */
    protected View f1616L;

    /* renamed from: M */
    protected View f1617M;

    /* renamed from: N */
    protected PalletView f1618N;

    /* renamed from: O */
    protected View f1619O;

    /* renamed from: P */
    protected View f1620P;

    /* renamed from: Q */
    protected View f1621Q;

    /* renamed from: R */
    protected Button f1622R;

    /* renamed from: S */
    protected Button f1623S;

    /* renamed from: T */
    protected View f1624T;

    /* renamed from: U */
    protected Spinner f1625U;

    /* renamed from: V */
    protected Spinner f1626V;

    /* renamed from: W */
    protected int f1627W;

    /* renamed from: X */
    protected TextView f1628X;

    /* renamed from: Y */
    protected int f1629Y;

    /* renamed from: Z */
    protected int f1630Z;

    /* renamed from: a */
    protected String f1631a;

    /* renamed from: aa */
    private Bitmap f1632aa;

    /* renamed from: ab */
    private int f1633ab;

    /* renamed from: b */
    protected String f1634b;

    /* renamed from: c */
    protected String f1635c;

    /* renamed from: d */
    protected String f1636d;

    /* renamed from: e */
    protected String f1637e;

    /* renamed from: f */
    protected String f1638f;

    /* renamed from: g */
    protected String f1639g;

    /* renamed from: h */
    protected String f1640h;

    /* renamed from: i */
    protected String f1641i;

    /* renamed from: j */
    protected String f1642j;

    /* renamed from: k */
    protected String f1643k;

    /* renamed from: l */
    protected String f1644l;

    /* renamed from: m */
    protected String f1645m;

    /* renamed from: n */
    protected String f1646n;

    /* renamed from: o */
    protected String f1647o;

    /* renamed from: p */
    protected String f1648p;

    /* renamed from: q */
    protected String f1649q;

    /* renamed from: r */
    protected String f1650r;

    /* renamed from: s */
    protected String f1651s;

    /* renamed from: t */
    protected String f1652t;

    /* renamed from: u */
    protected String f1653u;

    /* renamed from: v */
    protected String f1654v;

    /* renamed from: w */
    protected C1036bv f1655w;

    /* renamed from: x */
    protected ViewGroup f1656x;

    /* renamed from: y */
    protected ViewGroup f1657y;

    /* renamed from: z */
    protected ViewGroup f1658z;

    public C1038bx(Context context, String str) {
        super(context, str);
        this.f1631a = "Text Settings";
        this.f1634b = "Font";
        this.f1635c = "Paragraph";
        this.f1636d = "Align";
        this.f1637e = HttpUtil.VAL_CLOSE;
        this.f1638f = "Bold is on";
        this.f1639g = "Italic is on";
        this.f1640h = "Underline is on";
        this.f1641i = "Bold is off";
        this.f1642j = "Italic is off";
        this.f1643k = "Underline is off";
        this.f1644l = "Left";
        this.f1645m = "Center";
        this.f1646n = "Right";
        this.f1647o = "Defined color";
        this.f1648p = "Custom color";
        this.f1649q = "font %s, size %d, %s, %s, %s";
        this.f1650r = "Vertical scroll bar";
        this.f1651s = "%s, DropDown list";
        this.f1652t = "%d, DropDown list";
        this.f1653u = "";
        this.f1654v = null;
        this.f1633ab = 70;
        this.f1630Z = 19;
    }

    /* renamed from: a */
    protected PenSettingRootView mo1462a() {
        m1533h();
        return m1468e();
    }

    /* renamed from: e */
    private PenSettingRootView m1468e() {
        PenSettingRootView penSettingRootView = new PenSettingRootView(this.f1698am);
        penSettingRootView.setLayoutParams(new LinearLayout.LayoutParams(m1524a(245.5f * this.f1700ao), -2));
        penSettingRootView.setOrientation(1);
        penSettingRootView.setPadding(0, m1524a(5.0f), 0, 0);
        penSettingRootView.addView(m1469f());
        penSettingRootView.addView(m1473k());
        penSettingRootView.setOnTouchListener(this.f1701ap);
        return penSettingRootView;
    }

    /* renamed from: f */
    private ViewGroup m1469f() {
        RelativeLayout relativeLayout = new RelativeLayout(this.f1698am);
        relativeLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.f1615K = m1472j();
        relativeLayout.addView(m1470g());
        LinearLayout linearLayout = new LinearLayout(this.f1698am);
        linearLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        linearLayout.setOrientation(0);
        this.f1628X = m1471i();
        linearLayout.addView(this.f1628X);
        linearLayout.addView(this.f1615K);
        relativeLayout.addView(linearLayout);
        return relativeLayout;
    }

    /* renamed from: g */
    private View m1470g() {
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

    /* renamed from: i */
    private TextView m1471i() {
        Typeface typefaceCreateFromFile = null;
        TextView textView = new TextView(this.f1698am);
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, m1524a(27.5f), 1.0f));
        textView.setTextSize(13.0f);
        textView.setTextColor(-1);
        textView.setGravity(this.f1630Z);
        textView.setFocusable(false);
        textView.setText(this.f1631a);
        if (this.f1654v != null) {
            try {
                typefaceCreateFromFile = Typeface.createFromFile(this.f1654v);
            } catch (Exception e) {
                C0992ae.m1272a("Invalid font path");
            }
        }
        if (typefaceCreateFromFile != null) {
            textView.setTypeface(typefaceCreateFromFile);
        }
        textView.setTextSize(1, 13.0f);
        textView.setContentDescription(this.f1631a);
        textView.setPadding(m1524a(12.0f), m1524a(2.0f), m1524a(7.0f), 0);
        return textView;
    }

    /* renamed from: j */
    private View m1472j() {
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
        imageButton.setContentDescription(this.f1637e);
        imageButton.setId(3000);
        imageButton.setNextFocusDownId(3001);
        imageButton.setNextFocusLeftId(3001);
        imageButton.setNextFocusRightId(3000);
        if (this.f1699an == 240) {
            imageButton.setBackgroundDrawable(m1529b("/popup_exit.png", "/popup_exit_press.png", (String) null));
            imageButton.setImageDrawable(m1529b((String) null, (String) null, "/snote_add_focus.png"));
        } else if (this.f1699an == 480) {
            imageButton.setBackgroundDrawable(m1525a("/popup_exit_480.png", "/popup_exit_press_480.png", (String) null));
            imageButton.setImageDrawable(m1525a((String) null, (String) null, "/snote_add_focus.png"));
        } else {
            imageButton.setBackgroundDrawable(m1525a("/popup_exit.png", "/popup_exit_press.png", (String) null));
            imageButton.setImageDrawable(m1525a((String) null, (String) null, "/snote_add_focus.png"));
        }
        imageButton.setPadding(0, 0, 0, 0);
        return imageButton;
    }

    /* renamed from: k */
    private ViewGroup m1473k() {
        LinearLayout linearLayout = new LinearLayout(this.f1698am);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2, 1.0f));
        linearLayout.setOrientation(0);
        LinearLayout linearLayout2 = new LinearLayout(this.f1698am);
        linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(m1524a(245.5f * this.f1700ao), -2));
        linearLayout2.setOrientation(1);
        this.f1695aj = new PenSettingScrollView(this.f1698am);
        this.f1695aj.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.f1695aj.setFadingEdgeLength(0);
        this.f1695aj.setVerticalScrollBarEnabled(false);
        this.f1695aj.setOverScrollMode(2);
        PalletView palletView = new PalletView(this.f1698am);
        palletView.setLayoutParams(new ViewGroup.LayoutParams(-1, m1524a(237.0f)));
        palletView.setOrientation(1);
        this.f1619O = m1474l();
        this.f1656x = m1475m();
        this.f1620P = m1484v();
        this.f1614J = m1487y();
        this.f1621Q = m1488z();
        palletView.addView(this.f1619O);
        palletView.addView(this.f1656x);
        palletView.addView(this.f1620P);
        this.f1624T = m1476n();
        palletView.addView(this.f1624T);
        mo1463a(0);
        this.f1618N = palletView;
        this.f1695aj.addView(this.f1618N);
        this.f1658z = m1478p();
        linearLayout2.addView(this.f1658z);
        linearLayout2.addView(this.f1695aj);
        linearLayout.addView(linearLayout2);
        this.f1693ah = mo1466b();
        linearLayout.addView(this.f1693ah);
        this.f1693ah.setVisibility(8);
        LinearLayout linearLayout3 = new LinearLayout(this.f1698am);
        linearLayout3.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        linearLayout3.setOrientation(1);
        linearLayout3.setBackgroundDrawable(m1527b("/snote_title_bottom.9.png"));
        linearLayout3.addView(linearLayout);
        linearLayout3.addView(this.f1614J);
        return linearLayout3;
    }

    /* renamed from: a */
    protected void mo1463a(int i) {
        this.f1629Y = i;
        if (i == 0) {
            this.f1619O.setVisibility(0);
            this.f1656x.setVisibility(0);
            this.f1620P.setVisibility(0);
            this.f1614J.setVisibility(0);
            this.f1621Q.setVisibility(0);
            this.f1624T.setVisibility(8);
            return;
        }
        if (i == 1) {
            this.f1619O.setVisibility(8);
            this.f1656x.setVisibility(8);
            this.f1620P.setVisibility(8);
            this.f1614J.setVisibility(8);
            this.f1621Q.setVisibility(8);
            this.f1624T.setVisibility(0);
            if (this.f1693ah != null) {
                this.f1693ah.setVisibility(8);
            }
        }
    }

    /* renamed from: l */
    private View m1474l() {
        LinearLayout linearLayout = new LinearLayout(this.f1698am);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, m1524a(54.5f));
        layoutParams.topMargin = m1524a(5.0f);
        layoutParams.leftMargin = m1524a(7.0f);
        layoutParams.rightMargin = m1524a(7.0f);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setBackgroundDrawable(m1527b("/snote_type_preview_bg_00.png"));
        this.f1655w = new C1036bv(this.f1698am);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1, 17);
        layoutParams2.leftMargin = m1524a(-5.0f);
        this.f1655w.setLayoutParams(layoutParams2);
        this.f1655w.setContentDescription(this.f1649q);
        linearLayout.addView(this.f1655w);
        return linearLayout;
    }

    /* renamed from: m */
    private ViewGroup m1475m() {
        LinearLayout linearLayout = new LinearLayout(this.f1698am);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = m1524a(7.5f);
        layoutParams.leftMargin = m1524a(7.0f);
        layoutParams.rightMargin = m1524a(5.0f);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(0);
        this.f1657y = m1481s();
        linearLayout.addView(this.f1657y);
        linearLayout.addView(m1477o());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(m1524a(29.0f), m1524a(27.5f));
        layoutParams2.leftMargin = m1524a(5.0f);
        this.f1605A = new ImageButton(this.f1698am);
        this.f1605A.setLayoutParams(layoutParams2);
        this.f1605A.setFocusable(true);
        this.f1605A.setContentDescription(this.f1641i);
        this.f1605A.setId(3005);
        this.f1605A.setNextFocusLeftId(3004);
        this.f1605A.setNextFocusRightId(3006);
        this.f1605A.setNextFocusUpId(3001);
        this.f1605A.setNextFocusDownId(3011);
        this.f1605A.setBackgroundDrawable(m1525a("/snote_btn_normal_holo_dark.9.png", "/snote_btn_pressed_holo_dark.9.png", "/snote_btn_focused_holo_dark.9.png"));
        this.f1605A.setImageDrawable(m1525a("/snote_text_icon_bold.png", "/snote_text_icon_bold_press.png", "/snote_text_icon_bold_press.png"));
        linearLayout.addView(this.f1605A);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(m1524a(29.0f), m1524a(27.5f));
        this.f1606B = new ImageButton(this.f1698am);
        this.f1606B.setLayoutParams(layoutParams3);
        this.f1606B.setFocusable(true);
        this.f1606B.setContentDescription(this.f1642j);
        this.f1606B.setId(3006);
        this.f1606B.setNextFocusLeftId(3005);
        this.f1606B.setNextFocusRightId(C1044cc.ID_ATTRIBUTE_UNDER);
        this.f1606B.setNextFocusUpId(3001);
        this.f1606B.setNextFocusDownId(3011);
        this.f1606B.setBackgroundDrawable(m1525a("/snote_btn_normal_holo_dark.9.png", "/snote_btn_pressed_holo_dark.9.png", "/snote_btn_focused_holo_dark.9.png"));
        this.f1606B.setImageDrawable(m1525a("/snote_text_icon_italic.png", "/snote_text_icon_italic_press.png", "/snote_text_icon_italic_press.png"));
        linearLayout.addView(this.f1606B);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(m1524a(29.0f), m1524a(27.5f));
        this.f1607C = new ImageButton(this.f1698am);
        layoutParams4.rightMargin = m1524a(2.5f);
        this.f1607C.setLayoutParams(layoutParams4);
        this.f1607C.setFocusable(true);
        this.f1607C.setContentDescription(this.f1643k);
        this.f1607C.setId(C1044cc.ID_ATTRIBUTE_UNDER);
        this.f1607C.setNextFocusLeftId(3006);
        this.f1607C.setNextFocusRightId(C1044cc.ID_ATTRIBUTE_UNDER);
        this.f1607C.setNextFocusUpId(3001);
        this.f1607C.setNextFocusDownId(3011);
        this.f1607C.setBackgroundDrawable(m1525a("/snote_btn_normal_holo_dark.9.png", "/snote_btn_pressed_holo_dark.9.png", "/snote_btn_focused_holo_dark.9.png"));
        this.f1607C.setImageDrawable(m1525a("/snote_text_icon_underline.png", "/snote_text_icon_underline_press.png", "/snote_text_icon_underline_press.png"));
        linearLayout.addView(this.f1607C);
        return linearLayout;
    }

    /* renamed from: n */
    private ViewGroup m1476n() {
        LinearLayout linearLayout = new LinearLayout(this.f1698am);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, m1524a(54.0f));
        layoutParams.leftMargin = m1524a(6.0f);
        layoutParams.rightMargin = m1524a(7.0f);
        layoutParams.gravity = 16;
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(0);
        TextView textView = new TextView(this.f1698am);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, m1524a(54.0f));
        layoutParams2.weight = 1.0f;
        textView.setLayoutParams(layoutParams2);
        textView.setText(this.f1636d);
        textView.setTextColor(-3618616);
        textView.setTextSize(1, 15.0f);
        textView.setGravity(17);
        linearLayout.addView(textView);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(m1524a(44.0f), m1524a(27.0f));
        layoutParams3.leftMargin = m1524a(11.0f);
        layoutParams3.gravity = 16;
        this.f1608D = new ImageButton(this.f1698am);
        this.f1608D.setLayoutParams(layoutParams3);
        this.f1608D.setFocusable(true);
        this.f1608D.setContentDescription(this.f1644l);
        this.f1608D.setId(C1044cc.ID_ALIGN_LEFT);
        this.f1608D.setNextFocusUpId(3002);
        this.f1608D.setNextFocusRightId(C1044cc.ID_ALIGN_CENTER);
        this.f1608D.setNextFocusLeftId(C1044cc.ID_ALIGN_LEFT);
        this.f1608D.setBackgroundDrawable(m1525a("/snote_btn_normal_holo_dark.9.png", "/snote_btn_pressed_holo_dark.9.png", "/snote_btn_focused_holo_dark.9.png"));
        this.f1608D.setImageDrawable(m1525a("/snote_text_left.png", "/snote_text_left_press.png", "/snote_text_left_press.png"));
        linearLayout.addView(this.f1608D);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(m1524a(44.0f), m1524a(27.0f));
        layoutParams4.gravity = 16;
        this.f1609E = new ImageButton(this.f1698am);
        this.f1609E.setLayoutParams(layoutParams4);
        this.f1609E.setFocusable(true);
        this.f1609E.setContentDescription(this.f1645m);
        this.f1609E.setId(C1044cc.ID_ALIGN_CENTER);
        this.f1609E.setNextFocusUpId(3002);
        this.f1609E.setNextFocusLeftId(C1044cc.ID_ALIGN_LEFT);
        this.f1609E.setNextFocusRightId(3010);
        this.f1609E.setBackgroundDrawable(m1525a("/snote_btn_normal_holo_dark.9.png", "/snote_btn_pressed_holo_dark.9.png", "/snote_btn_focused_holo_dark.9.png"));
        this.f1609E.setImageDrawable(m1525a("/snote_text_center.png", "/snote_text_center_press.png", "/snote_text_center_press.png"));
        linearLayout.addView(this.f1609E);
        this.f1610F = new ImageButton(this.f1698am);
        this.f1610F.setLayoutParams(layoutParams4);
        this.f1610F.setFocusable(true);
        this.f1610F.setContentDescription(this.f1646n);
        this.f1610F.setId(3010);
        this.f1610F.setNextFocusUpId(3002);
        this.f1610F.setNextFocusLeftId(C1044cc.ID_ALIGN_CENTER);
        this.f1610F.setNextFocusRightId(3010);
        this.f1610F.setBackgroundDrawable(m1525a("/snote_btn_normal_holo_dark.9.png", "/snote_btn_pressed_holo_dark.9.png", "/snote_btn_focused_holo_dark.9.png"));
        this.f1610F.setImageDrawable(m1525a("/snote_text_right.png", "/snote_text_right_press.png", "/snote_text_right_press.png"));
        linearLayout.addView(this.f1610F);
        return linearLayout;
    }

    /* renamed from: o */
    private Spinner m1477o() {
        if (m1483u() == null) {
            this.f1626V = new Spinner(this.f1698am);
        } else {
            this.f1626V = new Spinner(this.f1698am, m1483u());
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(m1524a(33.5f), m1524a(27.5f));
        layoutParams.leftMargin = m1524a(5.0f);
        this.f1626V.setLayoutParams(layoutParams);
        if (this.f1699an == 240 && ((this.f1696ak == 960 && this.f1697al == 540) || (this.f1696ak == 540 && this.f1697al == 960))) {
            this.f1626V.setBackgroundDrawable(m1529b("/snote_spinner_ab_normal_holo.9.png", "/snote_spinner_ab_pressed_holo.9.png", "/snote_spinner_ab_focused_holo.9.png"));
        } else {
            this.f1626V.setBackgroundDrawable(m1529b("/snote_dropdown.9.png", "/snote_dropdown_press.9.png", "/snote_dropdown_focus.9.png"));
        }
        this.f1626V.setFocusable(true);
        this.f1626V.setContentDescription(this.f1652t);
        this.f1626V.setId(3004);
        this.f1626V.setNextFocusDownId(3011);
        this.f1626V.setNextFocusLeftId(3003);
        this.f1626V.setNextFocusRightId(3005);
        this.f1626V.setNextFocusUpId(3001);
        return this.f1626V;
    }

    /* renamed from: b */
    protected View mo1466b() {
        ThumbControlBackGround thumbControlBackGround = new ThumbControlBackGround(this.f1698am);
        thumbControlBackGround.setTrackWidth(m1524a(4.0f));
        thumbControlBackGround.setTopPadding(m1524a(7.5f));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(m1524a(25.0f), -1);
        layoutParams.topMargin = m1524a(2.0f);
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
        this.f1694ai.setImageDrawable(m1527b("/snote_popup_scroll_handle_n.png"));
        relativeLayout.addView(this.f1694ai);
        thumbControlBackGround.addView(relativeLayout);
        thumbControlBackGround.setContentDescription(this.f1650r);
        try {
            thumbControlBackGround.setHoverPopupType(1);
        } catch (NoSuchMethodError e) {
            e.printStackTrace();
        }
        return thumbControlBackGround;
    }

    /* renamed from: p */
    private ViewGroup m1478p() {
        LinearLayout linearLayout = new LinearLayout(this.f1698am);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, m1524a(32.0f)));
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        this.f1616L = m1479q();
        this.f1617M = m1480r();
        linearLayout.addView(this.f1616L);
        ImageView imageView = new ImageView(this.f1698am);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(m1524a(1.0f), m1524a(13.0f)));
        imageView.setBackgroundDrawable(m1527b("/snote_popup_tab_divider.png"));
        linearLayout.addView(imageView);
        linearLayout.addView(this.f1617M);
        LinearLayout linearLayout2 = new LinearLayout(this.f1698am);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, m1524a(33.0f));
        if (this.f1699an == 240) {
            layoutParams.leftMargin = m1524a(4.0f);
            layoutParams.rightMargin = m1524a(4.0f);
        } else {
            layoutParams.leftMargin = m1524a(3.5f);
            layoutParams.rightMargin = m1524a(3.5f);
        }
        linearLayout2.setLayoutParams(layoutParams);
        linearLayout2.setOrientation(1);
        ImageView imageView2 = new ImageView(this.f1698am);
        imageView2.setLayoutParams(new LinearLayout.LayoutParams(-1, m1524a(1.0f)));
        imageView2.setBackgroundDrawable(m1527b("/snote_tab_line.9.png"));
        linearLayout2.addView(linearLayout);
        linearLayout2.addView(imageView2);
        return linearLayout2;
    }

    /* renamed from: q */
    private View m1479q() {
        LinearLayout linearLayout = new LinearLayout(this.f1698am);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.weight = 1.0f;
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(1);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        linearLayout.setBackgroundDrawable(m1529b((String) null, (String) null, "/snote_ic_area_center_focus.9.png"));
        linearLayout.setId(3001);
        linearLayout.setNextFocusDownId(3003);
        linearLayout.setNextFocusRightId(3002);
        linearLayout.setNextFocusLeftId(3001);
        linearLayout.setNextFocusUpId(3000);
        this.f1622R = new Button(this.f1698am);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -1);
        layoutParams2.weight = 1.0f;
        this.f1622R.setLayoutParams(layoutParams2);
        this.f1622R.setBackgroundColor(0);
        this.f1622R.setGravity(17);
        this.f1622R.setText(this.f1634b);
        this.f1622R.setTextSize(1, 12.0f);
        this.f1622R.setTextColor(new ColorStateList(new int[][]{new int[]{-16842919, -16842913}, new int[]{R.attr.state_pressed}, new int[]{R.attr.state_selected}}, new int[]{-3618616, -12411425, -12411425}));
        this.f1622R.setClickable(false);
        this.f1622R.setPadding(0, 0, 0, 0);
        ImageView imageView = new ImageView(this.f1698am);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(-1, m1524a(2.0f)));
        imageView.setBackgroundDrawable(m1528b(0, -12411425, -12411425));
        linearLayout.addView(this.f1622R);
        linearLayout.addView(imageView);
        return linearLayout;
    }

    /* renamed from: r */
    private View m1480r() {
        LinearLayout linearLayout = new LinearLayout(this.f1698am);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.weight = 1.0f;
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(1);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        linearLayout.setBackgroundDrawable(m1529b((String) null, (String) null, "/snote_ic_area_center_focus.9.png"));
        linearLayout.setId(3002);
        linearLayout.setNextFocusDownId(C1044cc.ID_ALIGN_LEFT);
        linearLayout.setNextFocusLeftId(3001);
        linearLayout.setNextFocusRightId(3002);
        linearLayout.setNextFocusUpId(3000);
        this.f1623S = new Button(this.f1698am);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -1);
        layoutParams2.weight = 1.0f;
        this.f1623S.setLayoutParams(layoutParams2);
        this.f1623S.setBackgroundColor(0);
        this.f1623S.setGravity(17);
        this.f1623S.setText(this.f1635c);
        this.f1623S.setTextSize(1, 12.0f);
        this.f1623S.setTextColor(new ColorStateList(new int[][]{new int[]{-16842919, -16842913}, new int[]{R.attr.state_pressed}, new int[]{R.attr.state_selected}}, new int[]{-3618616, -12411425, -12411425}));
        this.f1623S.setClickable(false);
        this.f1623S.setPadding(0, 0, 0, 0);
        ImageView imageView = new ImageView(this.f1698am);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(-1, m1524a(2.0f)));
        imageView.setBackgroundDrawable(m1528b(0, -12411425, -12411425));
        linearLayout.addView(this.f1623S);
        linearLayout.addView(imageView);
        return linearLayout;
    }

    /* renamed from: s */
    private ViewGroup m1481s() {
        LinearLayout linearLayout = new LinearLayout(this.f1698am);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, m1524a(27.5f));
        layoutParams.weight = 1.0f;
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setGravity(16);
        linearLayout.addView(m1482t());
        return linearLayout;
    }

    /* renamed from: t */
    private Spinner m1482t() {
        if (m1483u() == null) {
            this.f1625U = new Spinner(this.f1698am);
        } else {
            this.f1625U = new Spinner(this.f1698am, m1483u());
        }
        this.f1625U.setLayoutParams(new LinearLayout.LayoutParams(-1, m1524a(27.5f)));
        if (this.f1699an == 240 && ((this.f1696ak == 960 && this.f1697al == 540) || (this.f1696ak == 540 && this.f1697al == 960))) {
            this.f1625U.setBackgroundDrawable(m1529b("/snote_spinner_ab_normal_holo.9.png", "/snote_spinner_ab_pressed_holo.9.png", "/snote_spinner_ab_focused_holo.9.png"));
        } else {
            this.f1625U.setBackgroundDrawable(m1529b("/snote_dropdown.9.png", "/snote_dropdown_press.9.png", "/snote_dropdown_focus.9.png"));
        }
        this.f1625U.setFocusable(true);
        this.f1625U.setContentDescription(this.f1651s);
        this.f1625U.setId(3003);
        this.f1625U.setNextFocusDownId(3011);
        this.f1625U.setNextFocusLeftId(3003);
        this.f1625U.setNextFocusRightId(3004);
        this.f1625U.setNextFocusUpId(3001);
        return this.f1625U;
    }

    /* renamed from: u */
    private AttributeSet m1483u() {
        XmlResourceParser layout;
        Resources resources = this.f1698am.getResources();
        if (this.f1627W == 0 || (layout = resources.getLayout(this.f1627W)) == null) {
            return null;
        }
        int next = 0;
        do {
            try {
                next = layout.next();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (XmlPullParserException e2) {
                e2.printStackTrace();
            }
            if (next == 2 && layout.getName().equals("Spinner")) {
                return Xml.asAttributeSet(layout);
            }
        } while (next != 1);
        return null;
    }

    /* renamed from: v */
    private ViewGroup m1484v() {
        LinearLayout linearLayout = new LinearLayout(this.f1698am);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = m1524a(7.5f);
        layoutParams.leftMargin = m1524a(7.0f);
        layoutParams.rightMargin = m1524a(7.0f);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundDrawable(m1527b("/snote_option_in_bg.9.png"));
        this.f1611G = m1485w();
        this.f1611G.setContentDescription(String.valueOf(this.f1647o) + this.f1653u);
        this.f1612H = m1486x();
        this.f1612H.setContentDescription(String.valueOf(this.f1648p) + this.f1653u);
        linearLayout.addView(this.f1611G);
        linearLayout.addView(this.f1612H);
        return linearLayout;
    }

    /* renamed from: w */
    private C1051g m1485w() {
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
        c1051g.setId(3011);
        c1051g.setNextFocusUpId(3003);
        c1051g.setNextFocusDownId(3011);
        c1051g.setNextFocusLeftId(3011);
        c1051g.setNextFocusRightId(3011);
        return c1051g;
    }

    /* renamed from: x */
    private C1050f m1486x() {
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

    /* renamed from: y */
    private View m1487y() {
        LinearLayout linearLayout = new LinearLayout(this.f1698am);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.leftMargin = m1524a(6.0f);
        layoutParams.rightMargin = m1524a(7.0f);
        layoutParams.bottomMargin = m1524a(6.0f);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setGravity(1);
        return linearLayout;
    }

    /* renamed from: z */
    private View m1488z() {
        LinearLayout linearLayout = new LinearLayout(this.f1698am);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.leftMargin = m1524a(6.0f);
        layoutParams.rightMargin = m1524a(7.0f);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setBackgroundDrawable(new ColorDrawable(0));
        linearLayout.setGravity(1);
        ImageView imageView = new ImageView(this.f1698am);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(m1524a(30.0f), m1524a(5.0f)));
        imageView.setPadding(m1524a(7.5f), m1524a(0.5f), m1524a(7.5f), m1524a(4.0f));
        imageView.setFocusable(false);
        imageView.setImageDrawable(new ColorDrawable(0));
        linearLayout.addView(imageView);
        return linearLayout;
    }

    /* renamed from: b */
    protected void m1491b(boolean z) {
        if (z) {
            this.f1612H.setVisibility(0);
            mo1465a(false);
        } else {
            this.f1612H.setVisibility(8);
        }
    }

    /* renamed from: a */
    protected void mo1464a(int i, int i2, int i3) {
        if (this.f1632aa == null) {
            this.f1632aa = Bitmap.createBitmap(this.f1633ab, this.f1633ab, Bitmap.Config.ARGB_8888);
        }
        this.f1632aa.eraseColor(0);
        Canvas canvas = new Canvas(this.f1632aa);
        Paint paint = new Paint();
        paint.setAlpha(255);
        float f = (float) (this.f1633ab * (i3 / 20.0f) * 0.7d);
        paint.setColor((-16777216) | i2);
        paint.setAntiAlias(true);
        canvas.drawCircle((this.f1633ab / 2.0f) - 0.5f, (this.f1633ab / 2.0f) + 0.5f, (f >= 1.0f ? f : 1.0f) / 2.0f, paint);
    }

    /* renamed from: c */
    protected void mo1467c() {
        if (this.f1632aa != null && !this.f1632aa.isRecycled()) {
            this.f1632aa.recycle();
            this.f1632aa = null;
        }
    }

    /* renamed from: b */
    void m1490b(int i) {
        this.f1627W = i;
    }

    /* renamed from: c */
    void m1492c(int i) {
        this.f1631a = this.f1698am.getResources().getString(i);
    }

    /* renamed from: d */
    void m1494d(int i) {
        this.f1637e = this.f1698am.getResources().getString(i);
    }

    /* renamed from: e */
    void m1495e(int i) {
        this.f1634b = this.f1698am.getResources().getString(i);
    }

    /* renamed from: f */
    void m1496f(int i) {
        this.f1635c = this.f1698am.getResources().getString(i);
    }

    /* renamed from: g */
    void m1497g(int i) {
        this.f1636d = this.f1698am.getResources().getString(i);
    }

    /* renamed from: h */
    void m1498h(int i) {
        this.f1641i = this.f1698am.getResources().getString(i);
    }

    /* renamed from: i */
    void m1499i(int i) {
        this.f1642j = this.f1698am.getResources().getString(i);
    }

    /* renamed from: j */
    void m1500j(int i) {
        this.f1643k = this.f1698am.getResources().getString(i);
    }

    /* renamed from: k */
    void m1501k(int i) {
        this.f1638f = this.f1698am.getResources().getString(i);
    }

    /* renamed from: l */
    void m1502l(int i) {
        this.f1639g = this.f1698am.getResources().getString(i);
    }

    /* renamed from: m */
    void m1503m(int i) {
        this.f1640h = this.f1698am.getResources().getString(i);
    }

    /* renamed from: n */
    void m1504n(int i) {
        this.f1644l = this.f1698am.getResources().getString(i);
    }

    /* renamed from: o */
    void m1505o(int i) {
        this.f1645m = this.f1698am.getResources().getString(i);
    }

    /* renamed from: p */
    void m1506p(int i) {
        this.f1646n = this.f1698am.getResources().getString(i);
    }

    /* renamed from: q */
    void m1507q(int i) {
        this.f1647o = this.f1698am.getResources().getString(i);
    }

    /* renamed from: r */
    void m1508r(int i) {
        this.f1648p = this.f1698am.getResources().getString(i);
    }

    /* renamed from: s */
    void m1509s(int i) {
        this.f1649q = this.f1698am.getResources().getString(i);
    }

    /* renamed from: t */
    void m1510t(int i) {
        this.f1650r = this.f1698am.getResources().getString(i);
    }

    /* renamed from: u */
    void m1511u(int i) {
        this.f1651s = this.f1698am.getResources().getString(i);
    }

    /* renamed from: v */
    void m1512v(int i) {
        this.f1652t = this.f1698am.getResources().getString(i);
    }

    /* renamed from: w */
    void m1513w(int i) {
        Resources resources = this.f1698am.getResources();
        if (i == -1) {
            this.f1653u = "";
        } else {
            this.f1653u = " " + resources.getString(i);
        }
    }

    /* renamed from: a */
    void m1489a(String str) {
        this.f1654v = str;
    }

    /* renamed from: a */
    void mo1465a(boolean z) {
        if (z) {
            this.f1658z.setVisibility(8);
            this.f1619O.setVisibility(8);
            this.f1612H.setVisibility(8);
        } else {
            this.f1658z.setVisibility(0);
            if (this.f1629Y != 1) {
                this.f1619O.setVisibility(0);
            }
            this.f1612H.setVisibility(0);
        }
    }

    /* renamed from: x */
    protected void m1514x(int i) {
        this.f1630Z = i;
        if (this.f1628X != null) {
            this.f1628X.setGravity(i);
        }
    }

    /* renamed from: d */
    protected void m1493d() {
        this.f1637e = "";
        this.f1638f = "";
        this.f1639g = "";
        this.f1640h = "";
        this.f1641i = "";
        this.f1642j = "";
        this.f1643k = "";
        this.f1644l = "";
        this.f1645m = "";
        this.f1646n = "";
        this.f1647o = "";
        this.f1648p = "";
        this.f1649q = "";
        this.f1650r = "";
        this.f1651s = "";
        this.f1652t = "";
    }
}
