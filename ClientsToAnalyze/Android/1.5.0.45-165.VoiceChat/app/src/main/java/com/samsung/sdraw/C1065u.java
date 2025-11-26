package com.samsung.sdraw;

import android.content.Context;
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
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;

/* renamed from: com.samsung.sdraw.u */
/* loaded from: classes.dex */
class C1065u extends C1066v {

    /* renamed from: t */
    private boolean f1782t;

    public C1065u(Context context, String str) {
        super(context, str);
        this.f1782t = false;
    }

    @Override // com.samsung.sdraw.C1066v
    /* renamed from: a */
    protected View mo1609a() {
        m1533h();
        return m1598c();
    }

    /* renamed from: c */
    private ViewGroup m1598c() {
        LinearLayout linearLayout = new LinearLayout(this.f1698am);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(m1524a((388.5f * this.f1700ao) - 11.0f), -2));
        linearLayout.setOrientation(1);
        linearLayout.setPadding(0, -10, 0, 0);
        linearLayout.addView(m1599d());
        linearLayout.addView(m1603i());
        linearLayout.setOnTouchListener(this.f1701ap);
        return linearLayout;
    }

    /* renamed from: d */
    private ViewGroup m1599d() {
        RelativeLayout relativeLayout = new RelativeLayout(this.f1698am);
        relativeLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, m1524a(59.0f * this.f1700ao)));
        this.f1796n = m1602g();
        relativeLayout.addView(m1600e());
        LinearLayout linearLayout = new LinearLayout(this.f1698am);
        linearLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        linearLayout.setOrientation(0);
        this.f1800r = m1601f();
        linearLayout.addView(this.f1800r);
        linearLayout.addView(this.f1796n);
        relativeLayout.addView(linearLayout);
        return relativeLayout;
    }

    /* renamed from: e */
    private View m1600e() {
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

    /* renamed from: f */
    private TextView m1601f() {
        Typeface typefaceCreateFromFile = null;
        TextView textView = new TextView(this.f1698am);
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, m1524a(59.0f * this.f1700ao), 1.0f));
        textView.setTextSize(20.0f);
        textView.setTextColor(-3618616);
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
        textView.setTextSize(1, this.f1700ao * 20.0f);
        textView.setContentDescription(this.f1783a);
        textView.setPadding(m1524a(this.f1700ao * 22.0f), m1524a(this.f1700ao * 22.0f), m1524a(17.0f * this.f1700ao), 0);
        textView.setIncludeFontPadding(false);
        textView.setSingleLine();
        return textView;
    }

    /* renamed from: g */
    private View m1602g() {
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
        imageButton.setId(4000);
        imageButton.setNextFocusDownId(4011);
        imageButton.setNextFocusLeftId(4011);
        imageButton.setNextFocusRightId(4000);
        imageButton.setContentDescription(this.f1784b);
        imageButton.setImageDrawable(m1527b("/snote_title_button_cancle.png"));
        imageButton.setBackgroundDrawable(m1525a(null, "/snote_title_right_press.9.png", "/snote_title_right_press.9.png"));
        imageButton.setPadding(0, 0, 0, 0);
        imageButton.setScaleType(ImageView.ScaleType.FIT_XY);
        return imageButton;
    }

    /* renamed from: i */
    private ViewGroup m1603i() {
        ScrollView scrollView = new ScrollView(this.f1698am);
        scrollView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2, 1.0f));
        scrollView.setFadingEdgeLength(0);
        scrollView.setVerticalScrollBarEnabled(false);
        scrollView.setOverScrollMode(2);
        LinearLayout linearLayout = new LinearLayout(this.f1698am);
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, m1524a(237.0f * this.f1700ao)));
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundDrawable(m1527b("/snote_title_bottom.9.png"));
        linearLayout.setPadding(m1524a(13.0f * this.f1700ao), 0, m1524a(14.0f * this.f1700ao), 0);
        this.f1794l = m1607m();
        this.f1794l.setContentDescription(this.f1787e);
        try {
            this.f1794l.setHoverPopupType(1);
        } catch (NoSuchMethodError e) {
            e.printStackTrace();
        }
        this.f1795m = m1608n();
        this.f1797o = m1604j();
        linearLayout.addView(this.f1797o);
        linearLayout.addView(this.f1794l);
        linearLayout.addView(this.f1795m);
        this.f1793k = linearLayout;
        scrollView.addView(this.f1793k);
        return scrollView;
    }

    /* renamed from: j */
    private ViewGroup m1604j() {
        LinearLayout linearLayout = new LinearLayout(this.f1698am);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = m1524a(5.0f * this.f1700ao);
        layoutParams.leftMargin = 0;
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundDrawable(m1527b("/snote_option_in_bg.9.png"));
        this.f1791i = m1605k();
        this.f1791i.setContentDescription(String.valueOf(this.f1785c) + this.f1789g);
        this.f1792j = m1606l();
        this.f1792j.setContentDescription(String.valueOf(this.f1786d) + this.f1789g);
        linearLayout.addView(this.f1791i);
        linearLayout.addView(this.f1792j);
        this.f1792j.setVisibility(8);
        return linearLayout;
    }

    /* renamed from: k */
    private C1051g m1605k() {
        C1051g c1051g = new C1051g(this.f1698am);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 1);
        layoutParams.topMargin = m1524a(this.f1700ao * 2.0f);
        layoutParams.leftMargin = m1524a(this.f1700ao * 2.0f);
        layoutParams.rightMargin = m1524a(4.0f * this.f1700ao);
        layoutParams.bottomMargin = m1524a(3.0f * this.f1700ao);
        c1051g.setLayoutParams(layoutParams);
        c1051g.setClickable(true);
        c1051g.setPadding(m1524a(2.0f), m1524a(2.0f), m1524a(5.0f), m1524a(2.0f));
        c1051g.setFocusable(true);
        c1051g.setId(4011);
        c1051g.setNextFocusRightId(4011);
        c1051g.setNextFocusUpId(4000);
        return c1051g;
    }

    /* renamed from: l */
    private C1050f m1606l() {
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

    /* renamed from: m */
    private View m1607m() {
        LinearLayout linearLayout = new LinearLayout(this.f1698am);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        linearLayout.setGravity(1);
        ImageView imageView = new ImageView(this.f1698am);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(m1524a(30.0f), m1524a(20.0f));
        layoutParams.topMargin = m1524a(2.0f);
        imageView.setLayoutParams(layoutParams);
        imageView.setPadding(m1524a(7.5f), m1524a(2.5f), m1524a(7.5f), m1524a(2.5f));
        imageView.setFocusable(false);
        imageView.setImageDrawable(m1527b("/expand_icon_01.png"));
        this.f1798p = imageView;
        linearLayout.addView(this.f1798p);
        return linearLayout;
    }

    /* renamed from: n */
    private View m1608n() {
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

    @Override // com.samsung.sdraw.C1066v
    /* renamed from: a */
    protected void mo1610a(boolean z) {
        this.f1782t = z;
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

    @Override // com.samsung.sdraw.C1066v
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
        if (this.f1782t) {
            this.f1792j.setVisibility(0);
        }
        this.f1794l.setVisibility(0);
        this.f1795m.setVisibility(0);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f1797o.getLayoutParams();
        layoutParams2.bottomMargin = m1524a(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET);
        this.f1797o.setLayoutParams(layoutParams2);
    }
}
