package com.coolots.chaton.common.util;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class CTextView extends TextView {
    private int mAvailableWidth;
    private List<String> mCutStr;
    private Paint mPaint;

    public CTextView(Context context) {
        super(context);
        this.mAvailableWidth = 0;
        this.mCutStr = new ArrayList();
    }

    public CTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mAvailableWidth = 0;
        this.mCutStr = new ArrayList();
    }

    private int setTextInfo(String text, int textWidth, int textHeight) {
        int end;
        this.mPaint = getPaint();
        this.mPaint.setColor(getTextColors().getDefaultColor());
        this.mPaint.setTextSize(getTextSize());
        int mTextHeight = textHeight;
        if (textWidth > 0) {
            this.mAvailableWidth = (textWidth - getPaddingLeft()) - getPaddingRight();
            this.mCutStr.clear();
            String[] textArr = text.split("\n");
            for (int i = 0; i < textArr.length; i++) {
                if (textArr[i].length() == 0) {
                    textArr[i] = " ";
                }
                do {
                    end = this.mPaint.breakText(textArr[i], true, this.mAvailableWidth, null);
                    if (end > 0) {
                        this.mCutStr.add(textArr[i].substring(0, end));
                        textArr[i] = textArr[i].substring(end);
                        if (textHeight == 0) {
                            mTextHeight += getLineHeight();
                        }
                    }
                } while (end > 0);
            }
        }
        return mTextHeight + getPaddingTop() + getPaddingBottom();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        float height = getPaddingTop() + getLineHeight();
        for (String text : this.mCutStr) {
            canvas.drawText(text, getPaddingLeft(), height, this.mPaint);
            height += getLineHeight();
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int parentWidth = View.MeasureSpec.getSize(widthMeasureSpec);
        int parentHeight = View.MeasureSpec.getSize(heightMeasureSpec);
        int height = setTextInfo(getText().toString(), parentWidth, parentHeight);
        if (parentHeight == 0) {
            parentHeight = height;
        }
        setMeasuredDimension(parentWidth, parentHeight);
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence text, int start, int before, int after) {
        setTextInfo(text.toString(), getWidth(), getHeight());
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        if (w != oldw) {
            setTextInfo(getText().toString(), w, h);
        }
    }
}
