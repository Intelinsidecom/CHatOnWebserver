package com.sec.chaton.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import com.sec.chaton.p044l.C1608g;

/* loaded from: classes.dex */
public class SelectableImageView extends ImageView {

    /* renamed from: a */
    private Drawable f11766a;

    public SelectableImageView(Context context) {
        super(context);
    }

    public SelectableImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SelectableImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1608g.SelectableImageView, i, 0);
        this.f11766a = typedArrayObtainStyledAttributes.getDrawable(0);
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
        if (this.f11766a != null) {
            this.f11766a.setState(getDrawableState());
            this.f11766a.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            this.f11766a.draw(canvas);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f11766a != null) {
            invalidate();
        }
    }
}
