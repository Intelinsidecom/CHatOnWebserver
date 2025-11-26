package com.coolots.chaton.call.view.layout.video;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.coolots.chaton.C0000R;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;

/* loaded from: classes.dex */
public class DualCameraCircleProgressView extends View {
    private static final int CIRCLE_MAX_VALUE = 360;
    private static final String LOG_TAG = "DualCameraCircleProgressView";
    private Paint mBgPaint;
    private RectF mOval;
    private Paint mPaint;
    private float mProgress;
    private float mStart;

    public DualCameraCircleProgressView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mStart = 270.0f;
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(context.getResources().getColor(C0000R.color.circle_time_progress));
        this.mBgPaint = new Paint(this.mPaint);
        this.mBgPaint.setColor(context.getResources().getColor(C0000R.color.circle_time_progress_background));
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.mOval = new RectF(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, 146.0f, 146.0f);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawArc(this.mOval, this.mStart, 360.0f, true, this.mBgPaint);
        canvas.drawArc(this.mOval, this.mStart, this.mProgress, true, this.mPaint);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View changedView, int visibility) {
        if (changedView == this) {
            switch (visibility) {
                case 4:
                case 8:
                    this.mProgress = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
                    break;
            }
        }
    }

    public void setProgress(int progress) {
        this.mProgress = progress * 2;
        invalidate();
    }

    protected void setProgress(int progress, int maxValue) {
        this.mProgress = (progress * CIRCLE_MAX_VALUE) / maxValue;
        invalidate();
    }
}
