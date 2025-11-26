package com.samsung.android.sdk.pen.objectruntime.preload;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.VideoView;

/* loaded from: classes.dex */
public class WrapperVideoView extends VideoView {
    private WrapperVideoViewListener mListener;
    private int mStart;

    public interface WrapperVideoViewListener {
        void onStart();
    }

    public void setListener(WrapperVideoViewListener listener) {
        this.mListener = listener;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mStart == 5 && this.mListener != null) {
            this.mListener.onStart();
            this.mListener = null;
        }
        this.mStart++;
    }

    public WrapperVideoView(Context context) {
        super(context);
    }
}
