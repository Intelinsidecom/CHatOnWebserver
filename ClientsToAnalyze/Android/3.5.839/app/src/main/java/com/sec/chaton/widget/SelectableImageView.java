package com.sec.chaton.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import com.sec.chaton.p076m.C2575g;

/* loaded from: classes.dex */
public class SelectableImageView extends ImageView {

    /* renamed from: a */
    private Drawable f17929a;

    public SelectableImageView(Context context) {
        super(context);
    }

    public SelectableImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SelectableImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C2575g.SelectableImageView, i, 0);
        this.f17929a = typedArrayObtainStyledAttributes.getDrawable(0);
        typedArrayObtainStyledAttributes.recycle();
        setFocusable(true);
        setClickable(true);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
        invalidate();
        return zOnTouchEvent;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f17929a != null) {
            this.f17929a.setState(getDrawableState());
            this.f17929a.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            this.f17929a.draw(canvas);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f17929a != null) {
            invalidate();
        }
    }

    public void setSelector(int i) {
        setSelector(getResources().getDrawable(i));
    }

    public void setSelector(Drawable drawable) {
        this.f17929a = drawable;
        invalidate();
    }
}
