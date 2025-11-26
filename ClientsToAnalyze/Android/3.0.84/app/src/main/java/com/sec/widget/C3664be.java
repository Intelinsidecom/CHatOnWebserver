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
/* renamed from: com.sec.widget.be */
/* loaded from: classes.dex */
class C3664be extends View {

    /* renamed from: a */
    protected String[] f13556a;

    /* renamed from: b */
    final /* synthetic */ TwIndexScrollView f13557b;

    /* renamed from: c */
    private Paint f13558c;

    /* renamed from: d */
    private Drawable f13559d;

    /* renamed from: e */
    private String f13560e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3664be(TwIndexScrollView twIndexScrollView, Context context) {
        super(context);
        this.f13557b = twIndexScrollView;
        m13239a();
    }

    /* renamed from: a */
    private void m13239a() {
        Resources resources = getResources();
        setFocusable(false);
        this.f13558c = new Paint();
        this.f13558c.setTextAlign(Paint.Align.CENTER);
        this.f13558c.setAntiAlias(true);
        this.f13558c.setTextSize(resources.getDimension(R.dimen.tw_indexview_index_textsize));
        this.f13558c.setColor(resources.getColor(R.color.fastscroll_sub_rectangular_orange_color));
        this.f13558c.setTypeface(Typeface.DEFAULT);
        this.f13559d = resources.getDrawable(R.drawable.fastscroll_menu_submenu_background);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.f13560e != null) {
            int length = this.f13560e.length();
            int width = getWidth();
            int height = getHeight();
            int i = width / 2;
            Paint.FontMetrics fontMetrics = this.f13558c.getFontMetrics();
            int iAbs = (int) Math.abs(fontMetrics.top);
            int iAbs2 = ((int) Math.abs(fontMetrics.bottom)) + ((int) Math.abs(fontMetrics.top));
            int i2 = (height / 2) - (iAbs2 / 2);
            if (!this.f13557b.f13442e) {
                canvas.save();
                canvas.translate(i, i2);
                StringBuffer stringBuffer = new StringBuffer();
                for (int i3 = 0; i3 < length; i3++) {
                    stringBuffer.append(this.f13556a[i3]);
                }
                String string = stringBuffer.toString();
                Rect rect = new Rect();
                float[] fArr = new float[1];
                this.f13558c.getTextWidths(string, string.length() - 1, string.length(), fArr);
                this.f13558c.getTextBounds(string, 0, string.length(), rect);
                int i4 = ((-rect.width()) / 2) - (((int) fArr[0]) / 2);
                int iWidth = (rect.width() / 2) + (((int) fArr[0]) / 2);
                if (string.length() == 1) {
                    i4 = -this.f13557b.f13447j;
                    iWidth = this.f13557b.f13447j;
                }
                Rect rect2 = new Rect();
                this.f13559d.getPadding(rect2);
                this.f13559d.setBounds(i4 - rect2.left, -rect2.top, iWidth + rect2.right, iAbs2 + rect2.bottom);
                this.f13559d.draw(canvas);
                canvas.translate(0.0f, iAbs);
                if (this.f13557b.f13429E && !this.f13557b.f13437M) {
                    this.f13558c.setColor(TwIndexScrollView.f13424m);
                }
                canvas.drawText(string, 0, string.length() - 1, (-fArr[0]) / 2.0f, 0.0f, this.f13558c);
                this.f13558c.setColor(TwIndexScrollView.f13424m);
                if (string.length() == 1) {
                    canvas.drawText(string, string.length() - 1, string.length(), 0.0f, 0.0f, this.f13558c);
                } else {
                    canvas.drawText(string, string.length() - 1, string.length(), (rect.width() - fArr[0]) / 2.0f, 0.0f, this.f13558c);
                }
                canvas.restore();
            }
        }
    }

    /* renamed from: a */
    void m13240a(String str) {
        this.f13560e = str;
        this.f13556a = new String[str.length()];
        for (int i = 0; i < str.length(); i++) {
            this.f13556a[i] = Character.toString(str.charAt(i));
        }
    }
}
