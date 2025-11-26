package com.coolots.chaton.call.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.SeekBar;

/* loaded from: classes.dex */
public class HorizontalSeekBar extends SeekBar {
    static final int mMinValue = 16;
    private int lastProgress;
    private SeekBar.OnSeekBarChangeListener onChangeListener;

    public HorizontalSeekBar(Context context) {
        super(context);
        this.onChangeListener = null;
        this.lastProgress = 0;
    }

    public HorizontalSeekBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.onChangeListener = null;
        this.lastProgress = 0;
    }

    public HorizontalSeekBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.onChangeListener = null;
        this.lastProgress = 0;
    }

    @Override // android.widget.SeekBar
    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onChangeListener) {
        this.onChangeListener = onChangeListener;
    }

    @Override // android.widget.AbsSeekBar, android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        if (!isEnabled()) {
            return false;
        }
        switch (event.getAction()) {
            case 0:
                if (this.onChangeListener != null) {
                    this.onChangeListener.onStartTrackingTouch(this);
                }
                setPressed(true);
                setSelected(true);
                break;
            case 1:
                if (this.onChangeListener != null) {
                    this.onChangeListener.onStopTrackingTouch(this);
                }
                setPressed(false);
                setSelected(false);
                break;
            case 2:
                super.onTouchEvent(event);
                int progress = (int) ((getMax() * event.getX()) / getWidth());
                if (progress < 0) {
                    progress = 0;
                }
                if (progress > getMax()) {
                    progress = getMax();
                }
                if (progress < 16) {
                    progress = 16;
                }
                int progress2 = (progress / 16) * 16;
                if (progress2 == 96) {
                    progress2 = 100;
                }
                setProgress(progress2);
                if (progress2 != this.lastProgress) {
                    this.lastProgress = progress2;
                    if (this.onChangeListener != null) {
                        this.onChangeListener.onProgressChanged(this, progress2, true);
                    }
                }
                onSizeChanged(getWidth(), getHeight(), 0, 0);
                setPressed(true);
                setSelected(true);
                break;
            case 3:
                super.onTouchEvent(event);
                setPressed(false);
                setSelected(false);
                break;
        }
        return true;
    }

    public synchronized void setProgressAndThumb(int progress) {
        setProgress(progress);
        onSizeChanged(getWidth(), getHeight(), 0, 0);
        if (progress != this.lastProgress) {
            this.lastProgress = progress;
            if (this.onChangeListener != null) {
                this.onChangeListener.onProgressChanged(this, progress, true);
            }
        }
    }

    public synchronized void setMaximum(int maximum) {
        setMax(maximum);
    }

    public synchronized int getMaximum() {
        return getMax();
    }
}
