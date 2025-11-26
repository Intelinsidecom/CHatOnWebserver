package com.android.p029ex.editstyledtext;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.text.Spannable;
import android.text.style.ForegroundColorSpan;
import android.util.Log;

/* compiled from: EditStyledText.java */
/* renamed from: com.android.ex.editstyledtext.ag */
/* loaded from: classes.dex */
public class C0367ag extends ShapeDrawable {

    /* renamed from: c */
    private static boolean f882c = false;

    /* renamed from: a */
    private Spannable f883a;

    /* renamed from: b */
    private int f884b;

    public C0367ag(int i, int i2, Spannable spannable) {
        super(new RectShape());
        this.f883a = spannable;
        this.f884b = i2;
        m1316b(i);
        m1317a(i2);
    }

    @Override // android.graphics.drawable.ShapeDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        m1314a();
        canvas.drawRect(new Rect(0, 9, this.f884b, 11), getPaint());
    }

    /* renamed from: a */
    public void m1317a(int i) {
        if (f882c) {
            Log.d("EditStyledTextSpan", "--- renewBounds:" + i);
        }
        if (i > 20) {
            i -= 20;
        }
        this.f884b = i;
        setBounds(0, 0, i, 20);
    }

    /* renamed from: b */
    private void m1316b(int i) {
        if (f882c) {
            Log.d("EditStyledTextSpan", "--- renewColor:" + i);
        }
        getPaint().setColor(i);
    }

    /* renamed from: a */
    private void m1314a() {
        C0368ah c0368ahM1315b = m1315b();
        Spannable spannable = this.f883a;
        ForegroundColorSpan[] foregroundColorSpanArr = (ForegroundColorSpan[]) spannable.getSpans(spannable.getSpanStart(c0368ahM1315b), spannable.getSpanEnd(c0368ahM1315b), ForegroundColorSpan.class);
        if (f882c) {
            Log.d("EditStyledTextSpan", "--- renewColor:" + foregroundColorSpanArr.length);
        }
        if (foregroundColorSpanArr.length > 0) {
            m1316b(foregroundColorSpanArr[foregroundColorSpanArr.length - 1].getForegroundColor());
        }
    }

    /* renamed from: b */
    private C0368ah m1315b() {
        Spannable spannable = this.f883a;
        C0368ah[] c0368ahArr = (C0368ah[]) spannable.getSpans(0, spannable.length(), C0368ah.class);
        if (c0368ahArr.length > 0) {
            for (C0368ah c0368ah : c0368ahArr) {
                if (c0368ah.getDrawable() == this) {
                    return c0368ah;
                }
            }
        }
        Log.e("EditStyledTextSpan", "---renewBounds: Couldn't find");
        return null;
    }
}
