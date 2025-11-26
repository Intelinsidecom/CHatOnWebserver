package com.coolots.chaton.call.view.layout;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.SlidingDrawer;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;

/* loaded from: classes.dex */
public class TranslatorSlidingDrawer extends SlidingDrawer {
    private int mTopOffset;
    private boolean mVertical;

    public TranslatorSlidingDrawer(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        int orientation = attrs.getAttributeIntValue("android", "orientation", 1);
        this.mTopOffset = attrs.getAttributeIntValue("android", "topOffset", 0);
        this.mVertical = orientation == 1;
    }

    public TranslatorSlidingDrawer(Context context, AttributeSet attrs) {
        super(context, attrs);
        int orientation = attrs.getAttributeIntValue("android", "orientation", 1);
        this.mTopOffset = attrs.getAttributeIntValue("android", "topOffset", 0);
        this.mVertical = orientation == 1;
    }

    @Override // android.widget.SlidingDrawer, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        View handle = getHandle();
        boolean isVertical = this.mVertical;
        drawChild(canvas, handle, drawingTime);
        Bitmap cache = getContent().getDrawingCache();
        if (cache != null) {
            if (isVertical) {
                canvas.drawBitmap(cache, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, handle.getBottom(), (Paint) null);
                return;
            } else {
                canvas.drawBitmap(cache, handle.getRight(), VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, (Paint) null);
                return;
            }
        }
        canvas.save();
        canvas.translate(isVertical ? 0 : handle.getLeft() - this.mTopOffset, isVertical ? handle.getTop() - this.mTopOffset : 0);
        drawChild(canvas, getContent(), drawingTime);
        canvas.restore();
    }
}
