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
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: com.samsung.sdraw.bw */
/* loaded from: classes.dex */
class C1037bw extends C1038bx {

    /* renamed from: aa */
    private static float f1602aa = 59.0f;

    /* renamed from: ab */
    private Bitmap f1603ab;

    /* renamed from: ac */
    private int f1604ac;

    public C1037bw(Context context, String str) {
        super(context, str);
        this.f1604ac = 70;
    }

    @Override // com.samsung.sdraw.C1038bx
    /* renamed from: a */
    protected PenSettingRootView mo1462a() {
        m1533h();
        if (this.f1699an == 320) {
            f1602aa = 48.0f;
        }
        return m1441e();
    }

    /* renamed from: e */
    private PenSettingRootView m1441e() {
        LinearLayout.LayoutParams layoutParams;
        PenSettingRootView penSettingRootView = new PenSettingRootView(this.f1698am);
        if (this.f1699an == 213) {
            layoutParams = new LinearLayout.LayoutParams(m1524a(301.0f), -2);
        } else {
            layoutParams = new LinearLayout.LayoutParams(m1524a(377.5f), -2);
        }
        penSettingRootView.setLayoutParams(layoutParams);
        penSettingRootView.setOrientation(1);
        penSettingRootView.setPadding(0, -10, 0, 0);
        penSettingRootView.addView(m1442f());
        penSettingRootView.addView(m1446k());
        penSettingRootView.setOnTouchListener(this.f1701ap);
        return penSettingRootView;
    }

    /* renamed from: f */
    private ViewGroup m1442f() {
        RelativeLayout relativeLayout = new RelativeLayout(this.f1698am);
        relativeLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, m1524a(f1602aa * this.f1700ao)));
        this.f1615K = m1445j();
        relativeLayout.addView(m1443g());
        LinearLayout linearLayout = new LinearLayout(this.f1698am);
        linearLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        linearLayout.setOrientation(0);
        this.f1628X = m1444i();
        linearLayout.addView(this.f1628X);
        linearLayout.addView(this.f1615K);
        relativeLayout.addView(linearLayout);
        return relativeLayout;
    }

    /* renamed from: g */
    private View m1443g() {
        LinearLayout linearLayout = new LinearLayout(this.f1698am);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, m1524a(f1602aa * this.f1700ao)));
        linearLayout.setOrientation(0);
        ImageView imageView = new ImageView(this.f1698am);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(-1, m1524a(f1602aa * this.f1700ao), 1.0f));
        imageView.setBackgroundDrawable(m1527b("/snote_title_left_tablet.9.png"));
        ImageView imageView2 = new ImageView(this.f1698am);
        imageView2.setLayoutParams(new LinearLayout.LayoutParams(-1, m1524a(f1602aa * this.f1700ao), 1.0f));
        imageView2.setBackgroundDrawable(m1527b("/snote_title_right_tablet.9.png"));
        linearLayout.addView(imageView);
        linearLayout.addView(imageView2);
        return linearLayout;
    }

    /* renamed from: i */
    private TextView m1444i() {
        Typeface typefaceCreateFromFile = null;
        TextView textView = new TextView(this.f1698am);
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, m1524a(f1602aa * this.f1700ao), 1.0f));
        textView.setTextSize(20.0f);
        textView.setTextColor(-3618616);
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
        textView.setTextSize(1, this.f1700ao * 20.0f);
        textView.setContentDescription(this.f1631a);
        textView.setPadding(m1524a(this.f1700ao * 22.0f), m1524a(this.f1700ao * 22.0f), m1524a(17.0f * this.f1700ao), 0);
        textView.setIncludeFontPadding(false);
        textView.setSingleLine();
        return textView;
    }

    /* renamed from: j */
    private View m1445j() {
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
        imageButton.setContentDescription(this.f1637e);
        imageButton.setId(3000);
        imageButton.setNextFocusDownId(3001);
        imageButton.setNextFocusLeftId(3001);
        imageButton.setNextFocusRightId(3000);
        imageButton.setImageDrawable(m1527b("/snote_title_button_cancle.png"));
        imageButton.setBackgroundDrawable(m1525a((String) null, "/snote_title_right_press.9.png", "/snote_title_right_press.9.png"));
        imageButton.setPadding(0, 0, 0, 0);
        imageButton.setScaleType(ImageView.ScaleType.FIT_XY);
        return imageButton;
    }

    /* renamed from: k */
    private ViewGroup m1446k() {
        LinearLayout.LayoutParams layoutParams;
        LinearLayout linearLayout = new LinearLayout(this.f1698am);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2, 1.0f));
        linearLayout.setOrientation(0);
        this.f1695aj = new PenSettingScrollView(this.f1698am);
        new LinearLayout.LayoutParams(m1524a(377.5f), -2);
        if (this.f1699an == 213) {
            layoutParams = new LinearLayout.LayoutParams(m1524a(301.0f), -2);
        } else {
            layoutParams = new LinearLayout.LayoutParams(m1524a(377.5f), -2);
        }
        layoutParams.bottomMargin = m1524a(7.0f);
        this.f1695aj.setLayoutParams(layoutParams);
        this.f1695aj.setFadingEdgeLength(0);
        this.f1695aj.setVerticalScrollBarEnabled(false);
        this.f1695aj.setOverScrollMode(2);
        this.f1695aj.setFocusable(false);
        PalletView palletView = new PalletView(this.f1698am);
        palletView.setLayoutParams(new ViewGroup.LayoutParams(-1, m1524a(237.0f * this.f1700ao)));
        palletView.setOrientation(1);
        palletView.setPadding(m1524a(13.0f * this.f1700ao), 0, m1524a(14.0f * this.f1700ao), 0);
        this.f1658z = m1451p();
        palletView.addView(this.f1658z);
        this.f1619O = m1447l();
        this.f1656x = m1448m();
        this.f1620P = m1457v();
        this.f1614J = m1460y();
        this.f1621Q = m1461z();
        palletView.addView(this.f1619O);
        palletView.addView(this.f1656x);
        palletView.addView(this.f1620P);
        this.f1624T = m1449n();
        palletView.addView(this.f1624T);
        mo1463a(0);
        this.f1618N = palletView;
        this.f1695aj.addView(this.f1618N);
        linearLayout.addView(this.f1695aj);
        this.f1693ah = mo1466b();
        linearLayout.addView(this.f1693ah);
        this.f1693ah.setVisibility(8);
        LinearLayout linearLayout2 = new LinearLayout(this.f1698am);
        linearLayout2.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        linearLayout2.setOrientation(1);
        linearLayout2.setBackgroundDrawable(m1527b("/snote_title_bottom.9.png"));
        linearLayout2.setPadding(0, 0, 0, 0);
        linearLayout2.addView(linearLayout);
        linearLayout2.addView(this.f1614J);
        return linearLayout2;
    }

    @Override // com.samsung.sdraw.C1038bx
    /* renamed from: b */
    protected View mo1466b() {
        ThumbControlBackGround thumbControlBackGround = new ThumbControlBackGround(this.f1698am);
        thumbControlBackGround.setTrackWidth(m1524a(4.0f));
        thumbControlBackGround.setTopPadding(m1524a(7.5f));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(m1524a(35.0f), -1);
        layoutParams.topMargin = m1524a(5.0f);
        layoutParams.rightMargin = m1524a(12.0f);
        layoutParams.bottomMargin = m1524a(7.0f);
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

    @Override // com.samsung.sdraw.C1038bx
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
    private View m1447l() {
        LinearLayout linearLayout = new LinearLayout(this.f1698am);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, m1524a(108.5f * this.f1700ao));
        layoutParams.topMargin = m1524a(5.0f * this.f1700ao);
        layoutParams.leftMargin = 0;
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setBackgroundDrawable(m1527b("/snote_type_preview_bg_00.png"));
        this.f1655w = new C1036bv(this.f1698am);
        this.f1655w.setLayoutParams(new FrameLayout.LayoutParams(-1, -1, 17));
        this.f1655w.setContentDescription(this.f1649q);
        linearLayout.addView(this.f1655w);
        return linearLayout;
    }

    /* renamed from: m */
    private ViewGroup m1448m() {
        LinearLayout linearLayout = new LinearLayout(this.f1698am);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = m1524a(10.0f * this.f1700ao);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(0);
        this.f1657y = m1454s();
        linearLayout.addView(this.f1657y);
        linearLayout.addView(m1450o());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(m1524a(48.0f * this.f1700ao), m1524a(40.0f * this.f1700ao));
        layoutParams2.leftMargin = m1524a(11.0f * this.f1700ao);
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
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(m1524a(48.0f * this.f1700ao), m1524a(40.0f * this.f1700ao));
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
        this.f1607C = new ImageButton(this.f1698am);
        this.f1607C.setLayoutParams(layoutParams3);
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
    private ViewGroup m1449n() {
        LinearLayout.LayoutParams layoutParams;
        LinearLayout.LayoutParams layoutParams2;
        LinearLayout linearLayout = new LinearLayout(this.f1698am);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, m1524a(59.0f * this.f1700ao));
        layoutParams3.leftMargin = m1524a(6.0f * this.f1700ao);
        layoutParams3.topMargin = m1524a(4.5f * this.f1700ao);
        layoutParams3.rightMargin = m1524a(7.0f * this.f1700ao);
        layoutParams3.bottomMargin = m1524a(2.5f * this.f1700ao);
        layoutParams3.gravity = 16;
        linearLayout.setLayoutParams(layoutParams3);
        linearLayout.setOrientation(0);
        TextView textView = new TextView(this.f1698am);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, m1524a(59.0f * this.f1700ao));
        layoutParams4.weight = 1.0f;
        textView.setLayoutParams(layoutParams4);
        textView.setText(this.f1636d);
        textView.setTextColor(-3618616);
        if (this.f1699an == 213) {
            textView.setTextSize(1, 17.0f);
        } else {
            textView.setTextSize(1, 22.0f);
        }
        textView.setGravity(17);
        linearLayout.addView(textView);
        if (this.f1699an == 213) {
            layoutParams = new LinearLayout.LayoutParams(m1524a(43.0f), m1524a(33.0f));
        } else {
            layoutParams = new LinearLayout.LayoutParams(m1524a(48.0f * this.f1700ao), m1524a(40.0f * this.f1700ao));
        }
        layoutParams.leftMargin = m1524a(11.0f * this.f1700ao);
        layoutParams.gravity = 16;
        this.f1608D = new ImageButton(this.f1698am);
        this.f1608D.setLayoutParams(layoutParams);
        this.f1608D.setFocusable(true);
        this.f1608D.setContentDescription(this.f1644l);
        this.f1608D.setId(C1044cc.ID_ALIGN_LEFT);
        this.f1608D.setNextFocusUpId(3002);
        this.f1608D.setNextFocusRightId(C1044cc.ID_ALIGN_CENTER);
        this.f1608D.setNextFocusLeftId(C1044cc.ID_ALIGN_LEFT);
        this.f1608D.setBackgroundDrawable(m1525a("/snote_btn_normal_holo_dark.9.png", "/snote_btn_pressed_holo_dark.9.png", "/snote_btn_focused_holo_dark.9.png"));
        this.f1608D.setImageDrawable(m1525a("/snote_text_left.png", "/snote_text_left_press.png", "/snote_text_left_press.png"));
        linearLayout.addView(this.f1608D);
        if (this.f1699an == 213) {
            layoutParams2 = new LinearLayout.LayoutParams(m1524a(43.0f), m1524a(33.0f));
        } else {
            layoutParams2 = new LinearLayout.LayoutParams(m1524a(48.0f * this.f1700ao), m1524a(40.0f * this.f1700ao));
        }
        layoutParams2.gravity = 16;
        this.f1609E = new ImageButton(this.f1698am);
        this.f1609E.setLayoutParams(layoutParams2);
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
        this.f1610F.setLayoutParams(layoutParams2);
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
    private Spinner m1450o() {
        if (m1456u() == null) {
            this.f1626V = new Spinner(this.f1698am);
        } else {
            this.f1626V = new Spinner(this.f1698am, m1456u());
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(m1524a(50.0f * this.f1700ao), m1524a(40.0f * this.f1700ao));
        layoutParams.topMargin = m1524a(0.5f * this.f1700ao);
        layoutParams.leftMargin = m1524a(10.0f * this.f1700ao);
        this.f1626V.setLayoutParams(layoutParams);
        this.f1626V.setBackgroundDrawable(m1529b("/snote_spinner_ab_normal_holo.9.png", "/snote_spinner_ab_pressed_holo.9.png", "/snote_spinner_ab_focused_holo.9.png"));
        this.f1626V.setFocusable(true);
        this.f1626V.setContentDescription(this.f1652t);
        this.f1626V.setId(3004);
        this.f1626V.setNextFocusDownId(3011);
        this.f1626V.setNextFocusLeftId(3003);
        this.f1626V.setNextFocusRightId(3005);
        this.f1626V.setNextFocusUpId(3001);
        return this.f1626V;
    }

    /* renamed from: p */
    private ViewGroup m1451p() {
        LinearLayout linearLayout = new LinearLayout(this.f1698am);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, m1524a(49.0f * this.f1700ao)));
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        this.f1616L = m1452q();
        this.f1617M = m1453r();
        linearLayout.addView(this.f1616L);
        ImageView imageView = new ImageView(this.f1698am);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(m1524a(1.0f), m1524a(20.0f * this.f1700ao)));
        imageView.setBackgroundDrawable(m1527b("/snote_popup_tab_divider.png"));
        linearLayout.addView(imageView);
        linearLayout.addView(this.f1617M);
        LinearLayout linearLayout2 = new LinearLayout(this.f1698am);
        linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(-1, m1524a(50.0f * this.f1700ao)));
        linearLayout2.setOrientation(1);
        ImageView imageView2 = new ImageView(this.f1698am);
        imageView2.setLayoutParams(new LinearLayout.LayoutParams(-1, m1524a(1.0f)));
        imageView2.setBackgroundDrawable(m1527b("/snote_tab_line.9.png"));
        linearLayout2.addView(linearLayout);
        linearLayout2.addView(imageView2);
        return linearLayout2;
    }

    /* renamed from: q */
    private View m1452q() {
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
        this.f1622R.setTextSize(1, 18.0f * this.f1700ao);
        this.f1622R.setTextColor(new ColorStateList(new int[][]{new int[]{-16842919, -16842913}, new int[]{R.attr.state_pressed}, new int[]{R.attr.state_selected}}, new int[]{-3618616, -12411425, -12411425}));
        this.f1622R.setClickable(false);
        this.f1622R.setPadding(0, 0, 0, 0);
        ImageView imageView = new ImageView(this.f1698am);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(-1, m1524a(4.0f * this.f1700ao)));
        imageView.setBackgroundDrawable(m1528b(0, -12411425, -12411425));
        linearLayout.addView(this.f1622R);
        linearLayout.addView(imageView);
        return linearLayout;
    }

    /* renamed from: r */
    private View m1453r() {
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
        this.f1623S.setTextSize(1, 18.0f * this.f1700ao);
        this.f1623S.setTextColor(new ColorStateList(new int[][]{new int[]{-16842919, -16842913}, new int[]{R.attr.state_pressed}, new int[]{R.attr.state_selected}}, new int[]{-3618616, -12411425, -12411425}));
        this.f1623S.setClickable(false);
        this.f1623S.setPadding(0, 0, 0, 0);
        ImageView imageView = new ImageView(this.f1698am);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(-1, m1524a(4.0f * this.f1700ao)));
        imageView.setBackgroundDrawable(m1528b(0, -12411425, -12411425));
        linearLayout.addView(this.f1623S);
        linearLayout.addView(imageView);
        return linearLayout;
    }

    /* renamed from: s */
    private ViewGroup m1454s() {
        LinearLayout linearLayout = new LinearLayout(this.f1698am);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, m1524a(40.0f * this.f1700ao));
        layoutParams.weight = 1.0f;
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setGravity(16);
        linearLayout.addView(m1455t());
        return linearLayout;
    }

    /* renamed from: t */
    private Spinner m1455t() {
        if (m1456u() == null) {
            this.f1625U = new Spinner(this.f1698am);
        } else {
            this.f1625U = new Spinner(this.f1698am, m1456u());
        }
        this.f1625U.setLayoutParams(new LinearLayout.LayoutParams(-1, m1524a(40.0f * this.f1700ao)));
        this.f1625U.setBackgroundDrawable(m1529b("/snote_spinner_ab_normal_holo.9.png", "/snote_spinner_ab_pressed_holo.9.png", "/snote_spinner_ab_focused_holo.9.png"));
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
    private AttributeSet m1456u() {
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
    private ViewGroup m1457v() {
        LinearLayout linearLayout = new LinearLayout(this.f1698am);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = m1524a(5.0f);
        layoutParams.leftMargin = 0;
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundDrawable(m1527b("/snote_option_in_bg.9.png"));
        this.f1611G = m1458w();
        this.f1611G.setContentDescription(String.valueOf(this.f1647o) + this.f1653u);
        this.f1612H = m1459x();
        this.f1612H.setContentDescription(String.valueOf(this.f1648p) + this.f1653u);
        linearLayout.addView(this.f1611G);
        linearLayout.addView(this.f1612H);
        return linearLayout;
    }

    /* renamed from: w */
    private C1051g m1458w() {
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
        c1051g.setId(3011);
        c1051g.setNextFocusUpId(3003);
        c1051g.setNextFocusDownId(3011);
        c1051g.setNextFocusLeftId(3011);
        c1051g.setNextFocusRightId(3011);
        return c1051g;
    }

    /* renamed from: x */
    private C1050f m1459x() {
        C1050f c1050f = new C1050f(this.f1698am);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, m1524a(85.0f * this.f1700ao));
        layoutParams.topMargin = m1524a(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET * this.f1700ao);
        layoutParams.leftMargin = m1524a(this.f1700ao * 4.0f);
        layoutParams.rightMargin = m1524a(this.f1700ao * 4.0f);
        layoutParams.bottomMargin = m1524a(this.f1700ao * 4.0f);
        c1050f.setLayoutParams(layoutParams);
        c1050f.setClickable(true);
        return c1050f;
    }

    /* renamed from: y */
    private View m1460y() {
        LinearLayout linearLayout = new LinearLayout(this.f1698am);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.leftMargin = m1524a(this.f1700ao * 6.0f);
        layoutParams.rightMargin = m1524a(7.0f * this.f1700ao);
        layoutParams.bottomMargin = m1524a(this.f1700ao * 6.0f);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setGravity(1);
        return linearLayout;
    }

    /* renamed from: z */
    private View m1461z() {
        LinearLayout linearLayout = new LinearLayout(this.f1698am);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.leftMargin = m1524a(6.0f * this.f1700ao);
        layoutParams.rightMargin = m1524a(7.0f * this.f1700ao);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setBackgroundDrawable(new ColorDrawable(0));
        linearLayout.setGravity(1);
        ImageView imageView = new ImageView(this.f1698am);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(m1524a(30.0f), m1524a(5.0f));
        layoutParams2.topMargin = m1524a(2.0f);
        imageView.setLayoutParams(layoutParams2);
        imageView.setPadding(m1524a(7.5f), m1524a(2.5f), m1524a(7.5f), m1524a(2.5f));
        imageView.setFocusable(true);
        imageView.setImageDrawable(new ColorDrawable(0));
        linearLayout.addView(imageView);
        return linearLayout;
    }

    @Override // com.samsung.sdraw.C1038bx
    /* renamed from: a */
    protected void mo1464a(int i, int i2, int i3) {
        if (this.f1603ab == null) {
            this.f1603ab = Bitmap.createBitmap(this.f1604ac, this.f1604ac, Bitmap.Config.ARGB_8888);
        }
        this.f1603ab.eraseColor(0);
        Canvas canvas = new Canvas(this.f1603ab);
        Paint paint = new Paint();
        paint.setAlpha(255);
        float f = (float) (this.f1604ac * (i3 / 20.0f) * 0.7d);
        paint.setColor((-16777216) | i2);
        paint.setAntiAlias(true);
        canvas.drawCircle((this.f1604ac / 2.0f) - 0.5f, (this.f1604ac / 2.0f) + 0.5f, (f >= 1.0f ? f : 1.0f) / 2.0f, paint);
    }

    @Override // com.samsung.sdraw.C1038bx
    /* renamed from: c */
    protected void mo1467c() {
        if (this.f1603ab != null && !this.f1603ab.isRecycled()) {
            this.f1603ab.recycle();
            this.f1603ab = null;
        }
    }

    @Override // com.samsung.sdraw.C1038bx
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
}
