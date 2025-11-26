package com.samsung.sdraw;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.vlingo.sdk.internal.http.HttpUtil;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;

/* renamed from: com.samsung.sdraw.v */
/* loaded from: classes.dex */
class C1066v extends C1044cc {

    /* renamed from: a */
    protected String f1783a;

    /* renamed from: b */
    protected String f1784b;

    /* renamed from: c */
    protected String f1785c;

    /* renamed from: d */
    protected String f1786d;

    /* renamed from: e */
    protected String f1787e;

    /* renamed from: f */
    protected String f1788f;

    /* renamed from: g */
    protected String f1789g;

    /* renamed from: h */
    protected String f1790h;

    /* renamed from: i */
    protected C1051g f1791i;

    /* renamed from: j */
    protected C1050f f1792j;

    /* renamed from: k */
    protected View f1793k;

    /* renamed from: l */
    protected View f1794l;

    /* renamed from: m */
    protected View f1795m;

    /* renamed from: n */
    protected View f1796n;

    /* renamed from: o */
    protected View f1797o;

    /* renamed from: p */
    protected ImageView f1798p;

    /* renamed from: q */
    protected ImageView f1799q;

    /* renamed from: r */
    protected TextView f1800r;

    /* renamed from: s */
    protected int f1801s;

    /* renamed from: t */
    private boolean f1802t;

    public C1066v(Context context, String str) {
        super(context, str);
        this.f1783a = "Filling Settings";
        this.f1784b = HttpUtil.VAL_CLOSE;
        this.f1785c = "Defined Color";
        this.f1786d = "Custom Color";
        this.f1787e = "Advanced settings";
        this.f1788f = "Advanced settings";
        this.f1789g = "";
        this.f1790h = null;
        this.f1802t = false;
        this.f1801s = 19;
    }

    /* renamed from: a */
    protected View mo1609a() {
        m1533h();
        return m1612c();
    }

    /* renamed from: c */
    private ViewGroup m1612c() {
        LinearLayout linearLayout = new LinearLayout(this.f1698am);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(m1524a(245.5f * this.f1700ao), -2));
        linearLayout.setOrientation(1);
        linearLayout.setPadding(0, m1524a(5.0f), 0, 0);
        linearLayout.addView(m1613d());
        linearLayout.addView(m1617i());
        linearLayout.setOnTouchListener(this.f1701ap);
        return linearLayout;
    }

    /* renamed from: d */
    private ViewGroup m1613d() {
        RelativeLayout relativeLayout = new RelativeLayout(this.f1698am);
        relativeLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.f1796n = m1616g();
        relativeLayout.addView(m1614e());
        LinearLayout linearLayout = new LinearLayout(this.f1698am);
        linearLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        linearLayout.setOrientation(0);
        this.f1800r = m1615f();
        linearLayout.addView(this.f1800r);
        linearLayout.addView(this.f1796n);
        relativeLayout.addView(linearLayout);
        return relativeLayout;
    }

    /* renamed from: e */
    private View m1614e() {
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

    /* renamed from: f */
    private TextView m1615f() {
        Typeface typefaceCreateFromFile = null;
        TextView textView = new TextView(this.f1698am);
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, m1524a(27.5f), 1.0f));
        textView.setTextSize(13.0f);
        textView.setTextColor(-1);
        textView.setGravity(this.f1801s);
        textView.setFocusable(false);
        textView.setText(this.f1783a);
        if (this.f1790h != null) {
            try {
                typefaceCreateFromFile = Typeface.createFromFile(this.f1790h);
            } catch (Exception e) {
                C0992ae.m1272a("Invalid font path");
            }
        }
        if (typefaceCreateFromFile != null) {
            textView.setTypeface(typefaceCreateFromFile);
        }
        textView.setTextSize(1, 13.0f);
        textView.setContentDescription(this.f1783a);
        textView.setPadding(m1524a(12.0f), m1524a(2.0f), m1524a(7.0f), 0);
        return textView;
    }

    /* renamed from: g */
    private View m1616g() {
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
        imageButton.setId(4000);
        imageButton.setNextFocusDownId(4011);
        imageButton.setNextFocusLeftId(4011);
        imageButton.setNextFocusRightId(4000);
        imageButton.setContentDescription(this.f1784b);
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

    /* renamed from: i */
    private ViewGroup m1617i() {
        ScrollView scrollView = new ScrollView(this.f1698am);
        scrollView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2, 1.0f));
        scrollView.setFadingEdgeLength(0);
        scrollView.setVerticalScrollBarEnabled(false);
        scrollView.setOverScrollMode(2);
        LinearLayout linearLayout = new LinearLayout(this.f1698am);
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, m1524a(237.0f)));
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundDrawable(m1527b("/snote_title_bottom.9.png"));
        this.f1794l = m1621m();
        this.f1794l.setContentDescription(this.f1787e);
        try {
            this.f1794l.setHoverPopupType(1);
        } catch (NoSuchMethodError e) {
            e.printStackTrace();
        }
        this.f1795m = m1622n();
        this.f1797o = m1618j();
        linearLayout.addView(this.f1797o);
        linearLayout.addView(this.f1794l);
        this.f1793k = linearLayout;
        scrollView.addView(this.f1793k);
        return scrollView;
    }

    /* renamed from: j */
    private ViewGroup m1618j() {
        LinearLayout linearLayout = new LinearLayout(this.f1698am);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = m1524a(5.0f);
        layoutParams.leftMargin = m1524a(7.0f);
        layoutParams.rightMargin = m1524a(7.0f);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundDrawable(m1527b("/snote_option_in_bg.9.png"));
        this.f1791i = m1619k();
        this.f1791i.setContentDescription(String.valueOf(this.f1785c) + this.f1789g);
        this.f1792j = m1620l();
        this.f1792j.setContentDescription(String.valueOf(this.f1786d) + this.f1789g);
        linearLayout.addView(this.f1791i);
        linearLayout.addView(this.f1792j);
        this.f1792j.setVisibility(8);
        return linearLayout;
    }

    /* renamed from: k */
    private C1051g m1619k() {
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
        c1051g.setId(4011);
        c1051g.setNextFocusRightId(4011);
        c1051g.setNextFocusUpId(4000);
        return c1051g;
    }

    /* renamed from: l */
    private C1050f m1620l() {
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

    /* renamed from: m */
    private View m1621m() {
        LinearLayout linearLayout = new LinearLayout(this.f1698am);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        linearLayout.setGravity(1);
        ImageView imageView = new ImageView(this.f1698am);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(m1524a(30.0f), m1524a(20.0f)));
        imageView.setPadding(m1524a(7.5f), m1524a(0.5f), m1524a(7.5f), m1524a(4.0f));
        imageView.setFocusable(false);
        imageView.setImageDrawable(m1527b("/expand_icon_01.png"));
        this.f1798p = imageView;
        linearLayout.addView(this.f1798p);
        return linearLayout;
    }

    /* renamed from: n */
    private View m1622n() {
        LinearLayout linearLayout = new LinearLayout(this.f1698am);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        linearLayout.setBackgroundDrawable(new ColorDrawable(0));
        linearLayout.setGravity(1);
        ImageView imageView = new ImageView(this.f1698am);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(m1524a(30.0f), m1524a(5.0f));
        layoutParams.topMargin = m1524a(2.0f);
        imageView.setLayoutParams(layoutParams);
        imageView.setPadding(m1524a(7.5f), m1524a(2.5f), m1524a(7.5f), m1524a(2.5f));
        imageView.setFocusable(true);
        imageView.setImageDrawable(new ColorDrawable(0));
        this.f1799q = imageView;
        linearLayout.addView(this.f1799q);
        return linearLayout;
    }

    /* renamed from: a */
    protected void mo1610a(boolean z) {
        this.f1802t = z;
        if (z) {
            this.f1798p.setImageDrawable(m1527b("/expand_icon_02.png"));
            this.f1794l.setContentDescription(this.f1788f);
            this.f1792j.setVisibility(0);
            mo1611b(false);
            return;
        }
        this.f1798p.setImageDrawable(m1527b("/expand_icon_01.png"));
        this.f1794l.setContentDescription(this.f1787e);
        this.f1792j.setVisibility(8);
    }

    /* renamed from: a */
    void m1623a(int i) {
        this.f1783a = this.f1698am.getResources().getString(i);
    }

    /* renamed from: b */
    void m1626b(int i) {
        this.f1784b = this.f1698am.getResources().getString(i);
    }

    /* renamed from: c */
    void m1627c(int i) {
        this.f1785c = this.f1698am.getResources().getString(i);
    }

    /* renamed from: d */
    void m1628d(int i) {
        this.f1786d = this.f1698am.getResources().getString(i);
    }

    /* renamed from: e */
    void m1629e(int i) {
        this.f1787e = this.f1698am.getResources().getString(i);
    }

    /* renamed from: f */
    void m1630f(int i) {
        this.f1788f = this.f1698am.getResources().getString(i);
    }

    /* renamed from: g */
    void m1631g(int i) {
        Resources resources = this.f1698am.getResources();
        if (i == -1) {
            this.f1789g = "";
        } else {
            this.f1789g = " " + resources.getString(i);
        }
    }

    /* renamed from: a */
    void m1624a(String str) {
        this.f1790h = str;
    }

    /* renamed from: b */
    public void mo1611b(boolean z) {
        if (z) {
            this.f1794l.setVisibility(8);
            this.f1795m.setVisibility(8);
            this.f1792j.setVisibility(8);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f1797o.getLayoutParams();
            layoutParams.bottomMargin = m1524a(12.0f);
            this.f1797o.setLayoutParams(layoutParams);
            return;
        }
        if (this.f1802t) {
            this.f1792j.setVisibility(0);
        }
        this.f1794l.setVisibility(0);
        this.f1795m.setVisibility(0);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f1797o.getLayoutParams();
        layoutParams2.bottomMargin = m1524a(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET);
        this.f1797o.setLayoutParams(layoutParams2);
    }

    /* renamed from: h */
    protected void m1632h(int i) {
        this.f1801s = i;
        if (this.f1800r != null) {
            this.f1800r.setGravity(i);
        }
    }

    /* renamed from: b */
    protected void m1625b() {
        this.f1784b = "";
        this.f1785c = "";
        this.f1786d = "";
        this.f1787e = "";
        this.f1788f = "";
    }
}
