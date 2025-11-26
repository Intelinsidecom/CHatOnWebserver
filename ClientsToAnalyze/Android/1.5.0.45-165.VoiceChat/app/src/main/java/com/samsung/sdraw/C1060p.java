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
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/* renamed from: com.samsung.sdraw.p */
/* loaded from: classes.dex */
class C1060p extends C1061q {

    /* renamed from: m */
    private float f1750m;

    /* renamed from: n */
    private float f1751n;

    /* renamed from: o */
    private Bitmap f1752o;

    /* renamed from: p */
    private int f1753p;

    public C1060p(Context context, String str) {
        super(context, str);
        this.f1750m = 1.0f;
        this.f1751n = 1.0f;
        this.f1753p = 70;
    }

    @Override // com.samsung.sdraw.C1061q
    /* renamed from: a */
    protected View mo1568a() {
        m1533h();
        if (((this.f1696ak == 600 && this.f1697al == 1024) || (this.f1696ak == 1024 && this.f1697al == 600)) && this.f1699an == 160) {
            this.f1750m = 1.33f;
            this.f1751n = (float) Math.sqrt(1.33d);
        }
        return m1558d();
    }

    /* renamed from: d */
    private ViewGroup m1558d() {
        LinearLayout linearLayout = new LinearLayout(this.f1698am);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(m1524a((388.5f * this.f1700ao) - 11.0f), -2));
        linearLayout.setOrientation(1);
        linearLayout.setPadding(0, -10, 0, 0);
        linearLayout.addView(m1559e());
        linearLayout.addView(m1563j());
        linearLayout.setOnTouchListener(this.f1701ap);
        return linearLayout;
    }

    /* renamed from: e */
    private ViewGroup m1559e() {
        RelativeLayout relativeLayout = new RelativeLayout(this.f1698am);
        relativeLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, m1524a(59.0f * this.f1700ao)));
        this.f1761h = m1562i();
        relativeLayout.addView(m1560f());
        LinearLayout linearLayout = new LinearLayout(this.f1698am);
        linearLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        linearLayout.setOrientation(0);
        this.f1764k = m1561g();
        linearLayout.addView(this.f1764k);
        linearLayout.addView(this.f1761h);
        relativeLayout.addView(linearLayout);
        return relativeLayout;
    }

    /* renamed from: f */
    private View m1560f() {
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

    /* renamed from: g */
    private TextView m1561g() {
        Typeface typefaceCreateFromFile = null;
        TextView textView = new TextView(this.f1698am);
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, m1524a(59.0f * this.f1700ao), 1.0f));
        textView.setTextSize(20.0f);
        textView.setTextColor(-3618616);
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
        textView.setTextSize(1, this.f1700ao * 20.0f);
        textView.setContentDescription(this.f1754a);
        textView.setPadding(m1524a(this.f1700ao * 22.0f), m1524a(this.f1700ao * 22.0f), m1524a(17.0f * this.f1700ao), 0);
        textView.setIncludeFontPadding(false);
        textView.setSingleLine();
        return textView;
    }

    /* renamed from: i */
    private View m1562i() {
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
        imageButton.setId(2000);
        imageButton.setNextFocusDownId(2009);
        imageButton.setNextFocusLeftId(2009);
        imageButton.setNextFocusRightId(2000);
        imageButton.setContentDescription(this.f1756c);
        imageButton.setImageDrawable(m1527b("/snote_title_button_cancle.png"));
        imageButton.setBackgroundDrawable(m1525a(null, "/snote_title_right_press.9.png", "/snote_title_right_press.9.png"));
        imageButton.setPadding(0, 0, 0, 0);
        imageButton.setScaleType(ImageView.ScaleType.FIT_XY);
        return imageButton;
    }

    /* renamed from: j */
    private ViewGroup m1563j() {
        LinearLayout linearLayout = new LinearLayout(this.f1698am);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundDrawable(m1527b("/snote_title_bottom.9.png"));
        linearLayout.setPadding(m1524a(13.0f * this.f1700ao), 0, m1524a(14.0f * this.f1700ao), 0);
        this.f1762i = m1567n();
        linearLayout.addView(m1564k());
        linearLayout.addView(this.f1762i);
        View view = new View(this.f1698am);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, m1524a(10.0f * this.f1700ao)));
        linearLayout.addView(view);
        return linearLayout;
    }

    /* renamed from: k */
    private ViewGroup m1564k() {
        LinearLayout linearLayout = new LinearLayout(this.f1698am);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = m1524a(5.0f);
        layoutParams.leftMargin = 0;
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setPadding(m1524a(5.5f * this.f1700ao), 0, m1524a(6.25f * this.f1700ao), m1524a(6.0f * this.f1700ao));
        linearLayout.setBackgroundDrawable(m1527b("/snote_option_in_bg.9.png"));
        linearLayout.setGravity(16);
        this.f1759f = m1565l();
        this.f1760g = m1566m();
        linearLayout.addView(this.f1759f);
        linearLayout.addView(this.f1760g);
        return linearLayout;
    }

    /* renamed from: l */
    private CustomSeekBar m1565l() {
        CustomSeekBar customSeekBar = new CustomSeekBar(this.f1698am);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, 1.0f);
        layoutParams.rightMargin = m1524a(4.5f);
        customSeekBar.setLayoutParams(layoutParams);
        customSeekBar.setPadding(m1524a(15.0f * this.f1700ao), m1524a(this.f1700ao * 1.0f), m1524a(24.0f * this.f1700ao), m1524a(2.0f * this.f1700ao));
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
        if (this.f1699an == 213) {
            this.f1763j = m1529b("/eraser_handel.png", "/eraser_handel_press.png", "/eraser_handel_press.png");
        } else {
            this.f1763j = m1525a("/snote_slider_circle.png", "/snote_slider_circle_press.png", "/snote_slider_circle_press.png");
        }
        customSeekBar.setThumb(this.f1763j);
        customSeekBar.setSeekbarId(2009);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(0);
        gradientDrawable.setCornerRadius(m1524a(5.0f));
        customSeekBar.setProgressDrawable(new LayerDrawable(new Drawable[]{new InsetDrawable(m1527b("/snote_slider_bg.9.png"), 0, 0, 0, 0), new ClipDrawable(gradientDrawable, 3, 1)}));
        return customSeekBar;
    }

    /* renamed from: m */
    private ImageView m1566m() {
        LinearLayout.LayoutParams layoutParams;
        ImageView imageView = new ImageView(this.f1698am);
        if (this.f1699an == 213) {
            layoutParams = new LinearLayout.LayoutParams(m1524a(77.0f), m1524a(77.0f));
        } else {
            layoutParams = new LinearLayout.LayoutParams(m1524a(99.0f), m1524a(99.0f));
        }
        layoutParams.rightMargin = m1524a(4.0f);
        layoutParams.topMargin = m1524a(4.0f);
        layoutParams.bottomMargin = m1524a(4.0f);
        imageView.setLayoutParams(layoutParams);
        imageView.setBackgroundDrawable(m1527b("/snote_pen_circle_bg.png"));
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        return imageView;
    }

    /* renamed from: n */
    private View m1567n() {
        Button button = new Button(this.f1698am);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, m1524a(45.0f * this.f1751n));
        layoutParams.topMargin = m1524a(this.f1700ao * 5.0f);
        layoutParams.leftMargin = m1524a(this.f1700ao * 1.0f);
        layoutParams.rightMargin = m1524a(this.f1700ao * 1.0f);
        layoutParams.bottomMargin = m1524a(this.f1700ao * 5.0f);
        button.setLayoutParams(layoutParams);
        button.setFocusable(true);
        button.setText(this.f1755b);
        button.setId(2001);
        button.setNextFocusUpId(2009);
        button.setNextFocusRightId(2001);
        button.setNextFocusLeftId(2001);
        button.setTextColor(new ColorStateList(new int[][]{new int[]{R.attr.state_pressed}, new int[0]}, new int[]{-1, -16777216}));
        button.setTextSize(1, 19.0f * this.f1750m);
        button.setBackgroundDrawable(m1525a("/snote_btn_normal_holo_dark.9.png", "/snote_btn_pressed_holo_dark.9.png", "/snote_btn_focused_holo_dark.9.png"));
        return button;
    }

    @Override // com.samsung.sdraw.C1061q
    /* renamed from: a */
    protected void mo1569a(int i) {
        if (this.f1752o == null) {
            this.f1752o = Bitmap.createBitmap(this.f1753p, this.f1753p, Bitmap.Config.ARGB_8888);
        }
        this.f1752o.eraseColor(0);
        Canvas canvas = new Canvas(this.f1752o);
        Paint paint = new Paint();
        paint.setAlpha(255);
        float f = (float) (this.f1753p * (i / 89.0f) * 0.9d);
        paint.setColor(-1);
        paint.setAntiAlias(true);
        canvas.drawCircle((this.f1753p / 2.0f) - 0.5f, (this.f1753p / 2.0f) - 0.5f, (f >= 1.0f ? f : 1.0f) / 2.0f, paint);
        this.f1760g.setImageBitmap(this.f1752o);
    }

    @Override // com.samsung.sdraw.C1061q
    /* renamed from: b */
    protected void mo1570b() {
        if (this.f1752o != null && !this.f1752o.isRecycled()) {
            this.f1752o.recycle();
            this.f1752o = null;
        }
    }
}
