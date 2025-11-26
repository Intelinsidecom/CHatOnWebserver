package com.sec.chaton.mobileweb;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.ImageView;

/* loaded from: classes.dex */
public class PageProgressView extends ImageView {

    /* renamed from: a */
    private int f9223a;

    /* renamed from: b */
    private int f9224b;

    /* renamed from: c */
    private int f9225c;

    /* renamed from: d */
    private Rect f9226d;

    /* renamed from: e */
    private Handler f9227e;

    public PageProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m10983a(context);
    }

    public PageProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m10983a(context);
    }

    public PageProgressView(Context context) {
        super(context);
        m10983a(context);
    }

    /* renamed from: a */
    private void m10983a(Context context) {
        this.f9226d = new Rect(0, 0, 0, 0);
        this.f9223a = 0;
        this.f9224b = 0;
        this.f9227e = new HandlerC2606t(this);
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.f9226d.left = 0;
        this.f9226d.right = ((i3 - i) * this.f9223a) / 10000;
        this.f9226d.top = 0;
        this.f9226d.bottom = i4 - i2;
    }

    /* renamed from: a */
    void m10988a(int i) {
        this.f9223a = this.f9224b;
        this.f9224b = i;
        this.f9225c = (this.f9224b - this.f9223a) / 10;
        this.f9227e.removeMessages(42);
        this.f9227e.sendEmptyMessage(42);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        Drawable drawable = getDrawable();
        drawable.setBounds(this.f9226d);
        drawable.draw(canvas);
    }
}
