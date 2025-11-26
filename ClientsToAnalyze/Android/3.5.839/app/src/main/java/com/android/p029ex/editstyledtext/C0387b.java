package com.android.p029ex.editstyledtext;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;

/* compiled from: EditStyledText.java */
/* renamed from: com.android.ex.editstyledtext.b */
/* loaded from: classes.dex */
public class C0387b extends ShapeDrawable {

    /* renamed from: a */
    private Rect f944a;

    public C0387b(int i, int i2, int i3, int i4) {
        super(new RectShape());
        this.f944a = new Rect(i4, i4, i2 - i4, i3 - i4);
        getPaint().setColor(i);
    }

    @Override // android.graphics.drawable.ShapeDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        canvas.drawRect(this.f944a, getPaint());
    }
}
