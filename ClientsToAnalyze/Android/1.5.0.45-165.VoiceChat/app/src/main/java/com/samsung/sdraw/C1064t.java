package com.samsung.sdraw;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;
import java.util.LinkedList;

/* renamed from: com.samsung.sdraw.t */
/* loaded from: classes.dex */
class C1064t implements ModeState {

    /* renamed from: b */
    private boolean f1779b = false;

    /* renamed from: c */
    private boolean f1780c = false;

    /* renamed from: d */
    private boolean f1781d = false;

    /* renamed from: a */
    protected Paint f1778a = new Paint();

    public C1064t() {
        this.f1778a.setAntiAlias(true);
        this.f1778a.setDither(true);
        this.f1778a.setFilterBitmap(true);
    }

    @Override // com.samsung.sdraw.ModeState
    public void onActivate(AbstractModeContext context, boolean isActive) {
        if (isActive) {
            LinkedList<AbstractSprite> linkedListM812a = context.stage.m812a(StrokeSprite.class, C1063s.class);
            LinkedList<AbstractSprite> linkedListM827b = context.stage.m827b(StrokeSprite.class, C1063s.class);
            if (context.setting != null && context.setting.m1121l()) {
                context.stage.clearLayers();
                if (((Stage) context.stage).f845i != null && context.stage.layerIsVisible(0)) {
                    context.stage.m830c(0).drawBitmap(context.stage.f845i, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, (Paint) null);
                }
                if (linkedListM812a != null) {
                    context.stage.m817a(0, linkedListM812a);
                }
                if (((Stage) context.stage).fixedSprites2 != null && context.stage.layerIsVisible(3)) {
                    context.stage.m830c(3).drawBitmap(context.stage.fixedSprites2, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, (Paint) null);
                }
                if (linkedListM827b != null) {
                    context.stage.m817a(3, linkedListM827b);
                }
            } else {
                LinkedList<AbstractSprite> linkedListM811a = context.stage.m811a(C0989ab.class);
                LinkedList<AbstractSprite> linkedListM826b = context.stage.m826b(C0989ab.class);
                LinkedList<AbstractSprite> linkedListM811a2 = context.stage.m811a(TextSprite.class);
                LinkedList<AbstractSprite> linkedListM826b2 = context.stage.m826b(TextSprite.class);
                context.stage.clearLayers();
                if (((Stage) context.stage).f845i != null && context.stage.layerIsVisible(0)) {
                    context.stage.m830c(0).drawBitmap(context.stage.f845i, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, (Paint) null);
                }
                if (linkedListM811a != null) {
                    context.stage.m817a(2, linkedListM811a);
                }
                if (linkedListM811a2 != null) {
                    context.stage.m817a(2, linkedListM811a2);
                }
                if (linkedListM812a != null) {
                    context.stage.m817a(0, linkedListM812a);
                }
                if (((Stage) context.stage).fixedSprites2 != null && context.stage.layerIsVisible(3)) {
                    context.stage.m830c(3).drawBitmap(context.stage.fixedSprites2, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, (Paint) null);
                }
                if (linkedListM826b != null) {
                    context.stage.m817a(4, linkedListM826b);
                }
                if (linkedListM826b2 != null) {
                    context.stage.m817a(4, linkedListM826b2);
                }
                if (linkedListM827b != null) {
                    context.stage.m817a(3, linkedListM827b);
                }
            }
            context.stage.clearLayer(1);
            context.invalidate();
            return;
        }
        onFinishJob(context);
    }

    @Override // com.samsung.sdraw.ModeState
    public void onLayout(AbstractModeContext context, Rect rect) {
        context.invalidate();
    }

    @Override // com.samsung.sdraw.ModeState
    public void onDraw(AbstractModeContext context, Canvas canvas, int layer) {
        if (context.stage != null && context.stage.layerIsVisible(layer)) {
            if (layer == 0) {
                Bitmap bitmapM825b = context.stage.m825b(0);
                if (bitmapM825b != null) {
                    canvas.drawBitmap(bitmapM825b, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, this.f1778a);
                    return;
                }
                return;
            }
            if (layer == 3) {
                Bitmap bitmapM825b2 = context.stage.m825b(3);
                if (bitmapM825b2 != null) {
                    canvas.drawBitmap(bitmapM825b2, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, this.f1778a);
                    return;
                }
                return;
            }
            if (layer == 2) {
                Bitmap bitmapM825b3 = context.stage.m825b(2);
                if (bitmapM825b3 != null) {
                    canvas.drawBitmap(bitmapM825b3, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, this.f1778a);
                    return;
                }
                return;
            }
            if (layer == 4) {
                Bitmap bitmapM825b4 = context.stage.m825b(4);
                if (bitmapM825b4 != null) {
                    canvas.drawBitmap(bitmapM825b4, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, this.f1778a);
                    return;
                }
                return;
            }
            Bitmap bitmapM825b5 = context.stage.m825b(layer);
            if (bitmapM825b5 != null) {
                canvas.drawBitmap(bitmapM825b5, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, this.f1778a);
            }
        }
    }

    @Override // com.samsung.sdraw.ModeState
    public void onDraw(AbstractModeContext context, Canvas canvas) {
        if (context.stage != null) {
            if (context.setting != null && context.setting.m1121l()) {
                Bitmap bitmapM825b = context.stage.m825b(0);
                Bitmap bitmapM825b2 = context.stage.m825b(3);
                Bitmap bitmapM825b3 = context.stage.m825b(1);
                if (bitmapM825b != null && context.stage.layerIsVisible(0)) {
                    canvas.drawBitmap(bitmapM825b, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, this.f1778a);
                }
                if (this.f1781d) {
                    if (bitmapM825b2 != null && context.stage.layerIsVisible(3)) {
                        canvas.drawBitmap(bitmapM825b2, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, this.f1778a);
                        return;
                    }
                    return;
                }
                if (context.stage.getSelectedLayerID() == 0 && !context.stage.getDrawingFront()) {
                    if (bitmapM825b3 != null) {
                        canvas.drawBitmap(bitmapM825b3, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, this.f1778a);
                    }
                    if (bitmapM825b2 != null && context.stage.layerIsVisible(3)) {
                        canvas.drawBitmap(bitmapM825b2, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, this.f1778a);
                        return;
                    }
                    return;
                }
                if (bitmapM825b2 != null && context.stage.layerIsVisible(3)) {
                    canvas.drawBitmap(bitmapM825b2, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, this.f1778a);
                }
                if (bitmapM825b3 != null) {
                    canvas.drawBitmap(bitmapM825b3, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, this.f1778a);
                    return;
                }
                return;
            }
            Bitmap bitmapM825b4 = context.stage.m825b(2);
            Bitmap bitmapM825b5 = context.stage.m825b(4);
            Bitmap bitmapM825b6 = context.stage.m825b(0);
            Bitmap bitmapM825b7 = context.stage.m825b(3);
            Bitmap bitmapM825b8 = context.stage.m825b(1);
            if (bitmapM825b4 != null) {
                canvas.drawBitmap(bitmapM825b4, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, this.f1778a);
            }
            if (bitmapM825b6 != null && context.stage.layerIsVisible(0)) {
                canvas.drawBitmap(bitmapM825b6, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, this.f1778a);
            }
            if (this.f1781d) {
                if (bitmapM825b5 != null) {
                    canvas.drawBitmap(bitmapM825b5, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, this.f1778a);
                }
                if (bitmapM825b7 != null && context.stage.layerIsVisible(3)) {
                    canvas.drawBitmap(bitmapM825b7, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, this.f1778a);
                    return;
                }
                return;
            }
            if (context.stage.getSelectedLayerID() == 0 && !context.stage.getDrawingFront()) {
                if (bitmapM825b8 != null) {
                    canvas.drawBitmap(bitmapM825b8, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, this.f1778a);
                }
                if (bitmapM825b5 != null) {
                    canvas.drawBitmap(bitmapM825b5, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, this.f1778a);
                }
                if (bitmapM825b7 != null && context.stage.layerIsVisible(3)) {
                    canvas.drawBitmap(bitmapM825b7, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, this.f1778a);
                    return;
                }
                return;
            }
            if (bitmapM825b5 != null) {
                canvas.drawBitmap(bitmapM825b5, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, this.f1778a);
            }
            if (bitmapM825b7 != null && context.stage.layerIsVisible(3)) {
                canvas.drawBitmap(bitmapM825b7, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, this.f1778a);
            }
            if (bitmapM825b8 != null) {
                canvas.drawBitmap(bitmapM825b8, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, this.f1778a);
            }
        }
    }

    @Override // com.samsung.sdraw.ModeState
    public boolean onTouchEvent(AbstractModeContext context, MotionEvent event) {
        return false;
    }

    @Override // com.samsung.sdraw.ModeState
    public boolean onTouchEvent(AbstractModeContext context, MotionEvent event, int userID, int objectID) {
        return false;
    }

    @Override // com.samsung.sdraw.ModeState
    public void onFinishJob(AbstractModeContext context) {
    }

    @Override // com.samsung.sdraw.ModeState
    public void onFinishJob(AbstractModeContext context, int userID) {
    }

    @Override // com.samsung.sdraw.ModeState
    public int getLayerID(AbstractModeContext context) {
        return 0;
    }

    @Override // com.samsung.sdraw.ModeState
    public boolean isAnimating() {
        return this.f1781d;
    }

    @Override // com.samsung.sdraw.ModeState
    public void setAnimating(boolean animating) {
        this.f1781d = animating;
    }

    @Override // com.samsung.sdraw.ModeState
    public void clearOffscreenBuffer(AbstractModeContext context) {
    }

    @Override // com.samsung.sdraw.ModeState
    public boolean isFixedBuffer(AbstractModeContext context) {
        return false;
    }
}
