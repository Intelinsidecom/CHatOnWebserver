package com.coolots.chaton.call.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;
import com.coolots.chaton.C0000R;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;

/* loaded from: classes.dex */
public class StrokeTextView extends TextView {
    private boolean mIsStroke;
    private int mStrokeColor;
    private float mStrokeWidth;

    public StrokeTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mIsStroke = false;
        this.mStrokeWidth = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
        initView(context, attrs);
    }

    public StrokeTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mIsStroke = false;
        this.mStrokeWidth = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
        initView(context, attrs);
    }

    public StrokeTextView(Context context) {
        super(context);
        this.mIsStroke = false;
        this.mStrokeWidth = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
    }

    private void initView(Context context, AttributeSet attrs) {
        TypedArray a = context.obtainStyledAttributes(attrs, C0000R.styleable.StrokeTextView);
        this.mIsStroke = a.getBoolean(0, false);
        this.mStrokeWidth = a.getFloat(1, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET);
        this.mStrokeColor = a.getColor(2, -1);
        a.recycle();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.mIsStroke) {
            ColorStateList states = getTextColors();
            getPaint().setStyle(Paint.Style.STROKE);
            getPaint().setStrokeWidth(this.mStrokeWidth);
            setTextColor(this.mStrokeColor);
            super.onDraw(canvas);
            getPaint().setStyle(Paint.Style.FILL);
            setTextColor(states);
        }
        super.onDraw(canvas);
    }
}
