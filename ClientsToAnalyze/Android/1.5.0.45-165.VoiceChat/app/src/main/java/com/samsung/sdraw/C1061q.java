package com.samsung.sdraw;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.vlingo.sdk.internal.http.HttpUtil;

/* renamed from: com.samsung.sdraw.q */
/* loaded from: classes.dex */
class C1061q extends C1044cc {

    /* renamed from: a */
    protected String f1754a;

    /* renamed from: b */
    protected String f1755b;

    /* renamed from: c */
    protected String f1756c;

    /* renamed from: d */
    protected String f1757d;

    /* renamed from: e */
    protected String f1758e;

    /* renamed from: f */
    protected SeekBar f1759f;

    /* renamed from: g */
    protected ImageView f1760g;

    /* renamed from: h */
    protected View f1761h;

    /* renamed from: i */
    protected View f1762i;

    /* renamed from: j */
    protected StateListDrawable f1763j;

    /* renamed from: k */
    protected TextView f1764k;

    /* renamed from: l */
    protected int f1765l;

    /* renamed from: m */
    private Bitmap f1766m;

    /* renamed from: n */
    private int f1767n;

    public C1061q(Context context, String str) {
        super(context, str);
        this.f1754a = "Eraser Settings";
        this.f1755b = "Clear all";
        this.f1756c = HttpUtil.VAL_CLOSE;
        this.f1757d = "Thickness";
        this.f1758e = null;
        this.f1767n = 70;
        this.f1765l = 19;
    }

    /* renamed from: a */
    protected View mo1568a() {
        m1533h();
        return m1571d();
    }

    /* renamed from: d */
    private ViewGroup m1571d() {
        LinearLayout linearLayout = new LinearLayout(this.f1698am);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(m1524a(245.5f * this.f1700ao), -2));
        linearLayout.setOrientation(1);
        linearLayout.setPadding(0, m1524a(5.0f), 0, 0);
        linearLayout.addView(m1572e());
        linearLayout.addView(m1576j());
        linearLayout.setOnTouchListener(this.f1701ap);
        return linearLayout;
    }

    /* renamed from: e */
    private ViewGroup m1572e() {
        RelativeLayout relativeLayout = new RelativeLayout(this.f1698am);
        relativeLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.f1761h = m1575i();
        relativeLayout.addView(m1573f());
        LinearLayout linearLayout = new LinearLayout(this.f1698am);
        linearLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        linearLayout.setOrientation(0);
        this.f1764k = m1574g();
        linearLayout.addView(this.f1764k);
        linearLayout.addView(this.f1761h);
        relativeLayout.addView(linearLayout);
        return relativeLayout;
    }

    /* renamed from: f */
    private View m1573f() {
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

    /* renamed from: g */
    private TextView m1574g() {
        Typeface typefaceCreateFromFile = null;
        TextView textView = new TextView(this.f1698am);
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, m1524a(27.5f), 1.0f));
        textView.setTextSize(13.0f);
        textView.setTextColor(-1);
        textView.setGravity(this.f1765l);
        textView.setFocusable(false);
        textView.setText(this.f1754a);
        if (this.f1758e != null) {
            try {
                typefaceCreateFromFile = Typeface.createFromFile(this.f1758e);
            } catch (Exception e) {
                C0992ae.m1272a("Invalid font path");
            }
        }
        if (typefaceCreateFromFile != null) {
            textView.setTypeface(typefaceCreateFromFile);
        }
        textView.setTextSize(1, 13.0f);
        textView.setContentDescription(this.f1754a);
        textView.setPadding(m1524a(12.0f), m1524a(2.0f), m1524a(7.0f), 0);
        return textView;
    }

    /* renamed from: i */
    private View m1575i() {
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
        imageButton.setId(2000);
        imageButton.setNextFocusDownId(2009);
        imageButton.setNextFocusLeftId(2009);
        imageButton.setNextFocusRightId(2000);
        imageButton.setContentDescription(this.f1756c);
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

    /* renamed from: j */
    private ViewGroup m1576j() {
        LinearLayout linearLayout = new LinearLayout(this.f1698am);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundDrawable(m1527b("/snote_title_bottom.9.png"));
        linearLayout.setPadding(m1524a(13.0f), 0, m1524a(13.0f), 0);
        this.f1762i = m1580n();
        linearLayout.addView(m1577k());
        linearLayout.addView(this.f1762i);
        View view = new View(this.f1698am);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, m1524a(10.0f)));
        linearLayout.addView(view);
        return linearLayout;
    }

    /* renamed from: k */
    private ViewGroup m1577k() {
        LinearLayout linearLayout = new LinearLayout(this.f1698am);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = m1524a(5.0f);
        layoutParams.bottomMargin = m1524a(6.0f);
        layoutParams.leftMargin = 0;
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setPadding(m1524a(5.5f), 0, m1524a(6.25f), m1524a(6.0f));
        linearLayout.setBackgroundDrawable(m1527b("/snote_option_in_bg.9.png"));
        linearLayout.setGravity(16);
        this.f1759f = m1578l();
        this.f1760g = m1579m();
        linearLayout.addView(this.f1759f);
        linearLayout.addView(this.f1760g);
        return linearLayout;
    }

    /* renamed from: l */
    private CustomSeekBar m1578l() {
        Drawable drawableB;
        int iA;
        CustomSeekBar customSeekBar = new CustomSeekBar(this.f1698am);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, 1.0f);
        layoutParams.rightMargin = m1524a(4.5f);
        customSeekBar.setLayoutParams(layoutParams);
        customSeekBar.setPadding(m1524a(12.0f), m1524a(1.0f), m1524a(12.0f), m1524a(2.0f));
        customSeekBar.setMax(39);
        customSeekBar.setContentDescription(this.f1757d);
        try {
            customSeekBar.setHoverPopupType(1);
        } catch (NoSuchMethodError e) {
            e.printStackTrace();
        }
        customSeekBar.setId(2009);
        customSeekBar.setNextFocusUpId(2000);
        customSeekBar.setNextFocusDownId(2001);
        customSeekBar.setNextFocusLeftId(2009);
        customSeekBar.setNextFocusRightId(2009);
        if (this.f1699an == 240) {
            this.f1763j = m1525a("/snote_slider_circle.png", "/snote_slider_circle_press.png", "/snote_slider_circle_press.png");
        } else if (this.f1699an == 480) {
            this.f1763j = m1525a("/eraser_handel_480.png", "/eraser_handel_press_480.png", "/eraser_handel_press_480.png");
        } else {
            this.f1763j = m1525a("/eraser_handel.png", "/eraser_handel_press.png", "/eraser_handel_press.png");
        }
        customSeekBar.setThumb(this.f1763j);
        customSeekBar.setSeekbarId(2009);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(0);
        gradientDrawable.setCornerRadius(m1524a(5.0f));
        ClipDrawable clipDrawable = new ClipDrawable(gradientDrawable, 3, 1);
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
        return customSeekBar;
    }

    /* renamed from: m */
    private ImageView m1579m() {
        LinearLayout.LayoutParams layoutParams;
        ImageView imageView = new ImageView(this.f1698am);
        if (this.f1699an == 240 && ((this.f1696ak == 960 && this.f1697al == 540) || (this.f1696ak == 540 && this.f1697al == 960))) {
            layoutParams = new LinearLayout.LayoutParams(m1524a(67.0f), m1524a(67.0f));
            layoutParams.rightMargin = m1524a(4.0f);
            layoutParams.topMargin = m1524a(4.0f);
            layoutParams.bottomMargin = m1524a(4.0f);
        } else if (this.f1699an == 480) {
            layoutParams = new LinearLayout.LayoutParams(m1524a(33.333332f), m1524a(33.333332f));
            layoutParams.rightMargin = m1524a(4.0f);
            layoutParams.topMargin = m1524a(4.0f);
            layoutParams.bottomMargin = m1524a(4.0f);
        } else {
            layoutParams = new LinearLayout.LayoutParams(m1524a(50.0f), m1524a(50.0f));
        }
        imageView.setLayoutParams(layoutParams);
        imageView.setBackgroundDrawable(m1527b("/snote_pen_circle_bg.png"));
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        return imageView;
    }

    /* renamed from: n */
    private View m1580n() {
        Button button = new Button(this.f1698am);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, m1524a(43.0f));
        layoutParams.bottomMargin = m1524a(-1.0f);
        button.setLayoutParams(layoutParams);
        button.setFocusable(true);
        button.setText(this.f1755b);
        button.setId(2001);
        button.setNextFocusUpId(2009);
        button.setNextFocusRightId(2001);
        button.setNextFocusLeftId(2001);
        button.setTextColor(new ColorStateList(new int[][]{new int[]{R.attr.state_pressed}, new int[0]}, new int[]{-1, -16777216}));
        button.setTextSize(1, 18.0f);
        button.setBackgroundDrawable(m1525a("/snote_btn_normal_holo_dark.9.png", "/snote_btn_pressed_holo_dark.9.png", "/snote_btn_focused_holo_dark.9.png"));
        return button;
    }

    /* renamed from: a */
    protected void mo1569a(int i) {
        if (this.f1766m == null) {
            this.f1766m = Bitmap.createBitmap(this.f1767n, this.f1767n, Bitmap.Config.ARGB_8888);
        }
        this.f1766m.eraseColor(0);
        Canvas canvas = new Canvas(this.f1766m);
        Paint paint = new Paint();
        paint.setAlpha(255);
        float f = (float) (this.f1767n * (i / 89.0f) * 0.9d);
        paint.setColor(-1);
        paint.setAntiAlias(true);
        canvas.drawCircle((this.f1767n / 2.0f) - 0.5f, this.f1767n / 2.0f, (f >= 1.0f ? f : 1.0f) / 2.0f, paint);
        this.f1760g.setImageBitmap(this.f1766m);
    }

    /* renamed from: b */
    protected void mo1570b() {
        if (this.f1766m != null && !this.f1766m.isRecycled()) {
            this.f1766m.recycle();
            this.f1766m = null;
        }
    }

    /* renamed from: a */
    public void m1582a(boolean z) {
        if (z) {
            this.f1762i.setVisibility(8);
        } else {
            this.f1762i.setVisibility(0);
        }
    }

    /* renamed from: b */
    void m1583b(int i) {
        this.f1754a = this.f1698am.getResources().getString(i);
    }

    /* renamed from: c */
    void m1585c(int i) {
        this.f1756c = this.f1698am.getResources().getString(i);
    }

    /* renamed from: d */
    void m1586d(int i) {
        this.f1755b = this.f1698am.getResources().getString(i);
    }

    /* renamed from: e */
    void m1587e(int i) {
        this.f1757d = this.f1698am.getResources().getString(i);
    }

    /* renamed from: a */
    void m1581a(String str) {
        this.f1758e = str;
    }

    /* renamed from: f */
    protected void m1588f(int i) {
        this.f1765l = i;
        if (this.f1764k != null) {
            this.f1764k.setGravity(i);
        }
    }

    /* renamed from: c */
    protected void m1584c() {
        this.f1756c = "";
        this.f1757d = "";
    }
}
