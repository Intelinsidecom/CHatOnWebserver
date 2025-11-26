package com.samsung.sdraw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/* loaded from: classes.dex */
public class ThumbControlBackGround extends LinearLayout {

    /* renamed from: a */
    private int f1363a;

    /* renamed from: b */
    private int f1364b;

    /* renamed from: c */
    private Paint f1365c;

    public ThumbControlBackGround(Context context) {
        super(context);
    }

    public ThumbControlBackGround(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ThumbControlBackGround(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setTrackWidth(int trackW) {
        this.f1363a = trackW;
        initPaint();
    }

    public void setTopPadding(int topPadding) {
        this.f1364b = topPadding;
    }

    public void initPaint() {
        this.f1365c = new Paint();
        this.f1365c.setColor(-13948117);
        this.f1365c.setStrokeWidth(this.f1363a);
        this.f1365c.setAntiAlias(true);
        this.f1365c.setStrokeCap(Paint.Cap.ROUND);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth() / 2;
        canvas.drawLine(width, this.f1364b + 3, width, (getHeight() - this.f1364b) - 5, this.f1365c);
    }
}
