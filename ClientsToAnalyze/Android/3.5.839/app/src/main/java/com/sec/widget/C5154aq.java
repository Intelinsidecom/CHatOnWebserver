package com.sec.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.sec.chaton.R;

/* compiled from: TwIndexScrollView.java */
/* renamed from: com.sec.widget.aq */
/* loaded from: classes.dex */
class C5154aq extends View {

    /* renamed from: a */
    protected String[] f18860a;

    /* renamed from: b */
    final /* synthetic */ TwIndexScrollView f18861b;

    /* renamed from: c */
    private Paint f18862c;

    /* renamed from: d */
    private Drawable f18863d;

    /* renamed from: e */
    private String f18864e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C5154aq(TwIndexScrollView twIndexScrollView, Context context) {
        super(context);
        this.f18861b = twIndexScrollView;
        m19724a();
    }

    /* renamed from: a */
    private void m19724a() {
        Resources resources = getResources();
        setFocusable(false);
        this.f18862c = new Paint();
        this.f18862c.setTextAlign(Paint.Align.CENTER);
        this.f18862c.setAntiAlias(true);
        this.f18862c.setTextSize(resources.getDimension(R.dimen.tw_indexview_index_textsize));
        this.f18862c.setColor(resources.getColor(R.color.fastscroll_sub_rectangular_orange_color));
        this.f18862c.setTypeface(Typeface.DEFAULT);
        this.f18863d = resources.getDrawable(R.drawable.fastscroll_menu_submenu_background);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.f18864e != null) {
            int length = this.f18864e.length();
            int width = getWidth();
            int height = getHeight();
            int i = width / 2;
            Paint.FontMetrics fontMetrics = this.f18862c.getFontMetrics();
            int iAbs = (int) Math.abs(fontMetrics.top);
            int iAbs2 = ((int) Math.abs(fontMetrics.bottom)) + ((int) Math.abs(fontMetrics.top));
            int i2 = (height / 2) - (iAbs2 / 2);
            if (!this.f18861b.f18809e) {
                canvas.save();
                canvas.translate(i, i2);
                StringBuffer stringBuffer = new StringBuffer();
                for (int i3 = 0; i3 < length; i3++) {
                    stringBuffer.append(this.f18860a[i3]);
                }
                String string = stringBuffer.toString();
                Rect rect = new Rect();
                float[] fArr = new float[1];
                this.f18862c.getTextWidths(string, string.length() - 1, string.length(), fArr);
                this.f18862c.getTextBounds(string, 0, string.length(), rect);
                int i4 = ((-rect.width()) / 2) - (((int) fArr[0]) / 2);
                int iWidth = (rect.width() / 2) + (((int) fArr[0]) / 2);
                if (string.length() == 1) {
                    i4 = -this.f18861b.f18814j;
                    iWidth = this.f18861b.f18814j;
                }
                Rect rect2 = new Rect();
                this.f18863d.getPadding(rect2);
                this.f18863d.setBounds(i4 - rect2.left, -rect2.top, iWidth + rect2.right, iAbs2 + rect2.bottom);
                this.f18863d.draw(canvas);
                canvas.translate(0.0f, iAbs);
                if (this.f18861b.f18796E && !this.f18861b.f18804M) {
                    this.f18862c.setColor(TwIndexScrollView.f18791m);
                }
                canvas.drawText(string, 0, string.length() - 1, (-fArr[0]) / 2.0f, 0.0f, this.f18862c);
                this.f18862c.setColor(TwIndexScrollView.f18791m);
                if (string.length() == 1) {
                    canvas.drawText(string, string.length() - 1, string.length(), 0.0f, 0.0f, this.f18862c);
                } else {
                    canvas.drawText(string, string.length() - 1, string.length(), (rect.width() - fArr[0]) / 2.0f, 0.0f, this.f18862c);
                }
                canvas.restore();
            }
        }
    }

    /* renamed from: a */
    void m19725a(String str) {
        this.f18864e = str;
        this.f18860a = new String[str.length()];
        for (int i = 0; i < str.length(); i++) {
            this.f18860a[i] = Character.toString(str.charAt(i));
        }
    }
}
