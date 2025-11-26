package com.samsung.sdraw;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;

/* renamed from: com.samsung.sdraw.bv */
/* loaded from: classes.dex */
class C1036bv extends ImageView {

    /* renamed from: a */
    private TextSprite f1591a;

    /* renamed from: b */
    private C1054j f1592b;

    /* renamed from: c */
    private Setting f1593c;

    /* renamed from: d */
    private int f1594d;

    /* renamed from: e */
    private Bitmap f1595e;

    /* renamed from: f */
    private String f1596f;

    /* renamed from: g */
    private String f1597g;

    /* renamed from: h */
    private String f1598h;

    /* renamed from: i */
    private String f1599i;

    /* renamed from: j */
    private String f1600j;

    /* renamed from: k */
    private String f1601k;

    public C1036bv(Context context) {
        super(context);
        this.f1596f = "bold is on";
        this.f1597g = "italic is on";
        this.f1598h = "underline is on";
        this.f1599i = "bold is off";
        this.f1600j = "italic is off";
        this.f1601k = "underline is off";
        m1434a(context);
    }

    /* renamed from: a */
    private void m1434a(Context context) {
        this.f1592b = new C1054j(context);
        this.f1593c = new Setting(getContext());
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (this.f1595e == null && w > 0 && h > 0) {
            this.f1595e = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        }
        this.f1591a = m1433a();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f1591a.mo1139a(canvas, this.f1591a.getBounds());
    }

    /* renamed from: a */
    public void m1435a(int i) {
        this.f1593c.setTextType(i);
        if (this.f1591a != null) {
            this.f1591a.dispose();
        }
        this.f1591a = m1433a();
        invalidate();
    }

    /* renamed from: b */
    public void m1439b(int i) {
        this.f1593c.setTextSize(i);
        if (this.f1591a != null) {
            this.f1591a.dispose();
        }
        this.f1591a = m1433a();
        invalidate();
    }

    /* renamed from: c */
    public void m1440c(int i) {
        this.f1594d = i;
        if (this.f1591a != null) {
            this.f1591a.dispose();
        }
        this.f1591a = m1433a();
        invalidate();
    }

    /* renamed from: a */
    public void m1436a(String str) {
        this.f1593c.setTextFont(str);
        if (this.f1591a != null) {
            this.f1591a.dispose();
        }
        this.f1591a = m1433a();
        invalidate();
    }

    /* renamed from: a */
    private TextSprite m1433a() {
        float f;
        RectF rectF;
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        if (displayMetrics.densityDpi == 213) {
            f = 0.75f;
        } else {
            f = 1.0f;
        }
        if (displayMetrics.densityDpi == 160 || displayMetrics.densityDpi == 213) {
            rectF = new RectF(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, ((int) (displayMetrics.densityDpi * 2.2d)) * f, 100.0f * f);
        } else {
            rectF = new RectF(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, (int) (displayMetrics.densityDpi * 1.4d), 100.0f);
        }
        TextInfo textInfo = new TextInfo(this.f1594d, this.f1593c.getTextSize() * 4, "ABC abc", rectF, this.f1593c.getTextType(), Layout.Alignment.ALIGN_CENTER, this.f1593c.getTextFont());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("ABC abc");
        spannableStringBuilder.setSpan(new C1040bz(getContext(), textInfo.textFont), 0, spannableStringBuilder.length(), 18);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(textInfo.color), 0, spannableStringBuilder.length(), 18);
        spannableStringBuilder.setSpan(new AbsoluteSizeSpan(textInfo.size), 0, spannableStringBuilder.length(), 18);
        switch (this.f1593c.getTextType()) {
            case 1:
                spannableStringBuilder.setSpan(new StyleSpan(1), 0, spannableStringBuilder.length(), 18);
                break;
            case 2:
                spannableStringBuilder.setSpan(new StyleSpan(2), 0, spannableStringBuilder.length(), 18);
                break;
            case 3:
                spannableStringBuilder.setSpan(new StyleSpan(1), 0, spannableStringBuilder.length(), 18);
                spannableStringBuilder.setSpan(new StyleSpan(2), 0, spannableStringBuilder.length(), 18);
                break;
            case 4:
                spannableStringBuilder.setSpan(new UnderlineSpan(), 0, spannableStringBuilder.length(), 18);
                break;
            case 5:
                spannableStringBuilder.setSpan(new StyleSpan(1), 0, spannableStringBuilder.length(), 18);
                spannableStringBuilder.setSpan(new UnderlineSpan(), 0, spannableStringBuilder.length(), 18);
                break;
            case 6:
                spannableStringBuilder.setSpan(new StyleSpan(2), 0, spannableStringBuilder.length(), 18);
                spannableStringBuilder.setSpan(new UnderlineSpan(), 0, spannableStringBuilder.length(), 18);
                break;
            case 7:
                spannableStringBuilder.setSpan(new StyleSpan(1), 0, spannableStringBuilder.length(), 18);
                spannableStringBuilder.setSpan(new StyleSpan(2), 0, spannableStringBuilder.length(), 18);
                spannableStringBuilder.setSpan(new UnderlineSpan(), 0, spannableStringBuilder.length(), 18);
                break;
        }
        spannableStringBuilder.setSpan(textInfo.alignment, 0, spannableStringBuilder.length(), 18);
        TextSprite textSpriteMo1402a = this.f1592b.mo1402a((int) rectF.width(), (int) rectF.height(), textInfo.alignment, spannableStringBuilder, textInfo.textFont);
        if (displayMetrics.densityDpi == 160 || displayMetrics.densityDpi == 213) {
            textSpriteMo1402a.moveTo(3.0f, (((int) ((displayMetrics.densityDpi * f) * 0.32d)) - (textSpriteMo1402a.m1196c().getHeight() / 2)) + 5.0f);
        } else {
            textSpriteMo1402a.moveTo(-10.0f, ((int) (displayMetrics.densityDpi * 0.18d)) - (textSpriteMo1402a.m1196c().getHeight() / 2));
        }
        textSpriteMo1402a.setVisible(true);
        return textSpriteMo1402a;
    }

    /* renamed from: a */
    public void m1437a(String str, String str2) {
        String str3 = this.f1599i;
        String str4 = this.f1600j;
        String str5 = this.f1601k;
        switch (this.f1593c.getTextType()) {
            case 1:
                str3 = this.f1596f;
                break;
            case 2:
                str4 = this.f1597g;
                break;
            case 3:
                str3 = this.f1596f;
                str4 = this.f1597g;
                break;
            case 4:
                str5 = this.f1598h;
                break;
            case 5:
                str3 = this.f1596f;
                str5 = this.f1598h;
                break;
            case 6:
                str4 = this.f1597g;
                str5 = this.f1598h;
                break;
            case 7:
                str3 = this.f1596f;
                str4 = this.f1597g;
                str5 = this.f1598h;
                break;
        }
        setContentDescription(String.format(str, str2, Integer.valueOf(this.f1593c.getTextSize()), str3, str4, str5));
    }

    /* renamed from: a */
    public void m1438a(String str, String str2, String str3, String str4, String str5, String str6) {
        this.f1596f = str;
        this.f1599i = str2;
        this.f1597g = str3;
        this.f1600j = str4;
        this.f1598h = str5;
        this.f1601k = str6;
    }
}
