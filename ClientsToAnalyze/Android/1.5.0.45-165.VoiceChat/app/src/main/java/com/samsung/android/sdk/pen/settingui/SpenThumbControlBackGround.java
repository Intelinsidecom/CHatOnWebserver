package com.samsung.android.sdk.pen.settingui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.widget.LinearLayout;

/* loaded from: classes.dex */
class SpenThumbControlBackGround extends LinearLayout {
    private Paint mPaint;
    private int mTopPadding;
    private int mTrackWidth;

    public SpenThumbControlBackGround(Context mContext) {
        super(mContext);
    }

    public void initPaint() {
        this.mPaint = new Paint();
        this.mPaint.setColor(-13948117);
        this.mPaint.setStrokeWidth(this.mTrackWidth);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas mCanvas) {
        super.onDraw(mCanvas);
        int mWidthHalf = getWidth() / 2;
        mCanvas.drawLine(mWidthHalf, this.mTopPadding + 3, mWidthHalf, (getHeight() - this.mTopPadding) - 5, this.mPaint);
    }

    public void setTopPadding(int topPadding) {
        this.mTopPadding = topPadding;
    }

    public void setTrackWidth(int trackWidth) {
        this.mTrackWidth = trackWidth;
        initPaint();
    }
}
