package com.samsung.sdraw;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import com.coolots.p2pmsg.model.SimpleUserInfo;
import com.samsung.sdraw.StrokeSprite;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;

/* loaded from: classes.dex */
class PenMode implements ModeState {
    protected Paint cursorPaint;
    protected long drawingTime;
    protected StrokeSprite mStroke;
    protected long vectorLimit;
    protected int touchID = -1;

    /* renamed from: a */
    private boolean f1101a = false;

    /* renamed from: b */
    private int f1102b = 1;

    /* renamed from: c */
    private boolean f1103c = false;

    /* renamed from: d */
    private boolean f1104d = false;
    protected Paint paint = new Paint();

    public PenMode() {
        this.paint.setAntiAlias(true);
        this.paint.setDither(true);
        this.paint.setFilterBitmap(true);
    }

    @Override // com.samsung.sdraw.ModeState
    public void onActivate(AbstractModeContext context, boolean isActive) throws InterruptedException {
        if (isActive) {
            context.stage.renderAllSprites(true, this.f1102b);
        } else {
            onFinishJob(context);
        }
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
                    canvas.drawBitmap(bitmapM825b, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, this.paint);
                }
            } else if (layer == 3) {
                Bitmap bitmapM825b2 = context.stage.m825b(3);
                if (bitmapM825b2 != null) {
                    canvas.drawBitmap(bitmapM825b2, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, this.paint);
                }
            } else if (layer == 2) {
                Bitmap bitmapM825b3 = context.stage.m825b(2);
                if (bitmapM825b3 != null) {
                    canvas.drawBitmap(bitmapM825b3, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, this.paint);
                }
            } else if (layer == 4) {
                Bitmap bitmapM825b4 = context.stage.m825b(4);
                if (bitmapM825b4 != null) {
                    canvas.drawBitmap(bitmapM825b4, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, this.paint);
                }
            } else {
                Bitmap bitmapM825b5 = context.stage.m825b(layer);
                if (bitmapM825b5 != null) {
                    canvas.drawBitmap(bitmapM825b5, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, this.paint);
                }
            }
            if (layer == 0 || layer == 3) {
                drawCursorPoint(context, canvas);
            }
        }
    }

    @Override // com.samsung.sdraw.ModeState
    public void onDraw(AbstractModeContext context, Canvas canvas) {
        if (context.stage != null) {
            Bitmap bitmapM825b = context.stage.m825b(0);
            Bitmap bitmapM825b2 = context.stage.m825b(3);
            if (context.setting != null && context.setting.m1121l()) {
                if (bitmapM825b != null && context.stage.layerIsVisible(0)) {
                    canvas.drawBitmap(bitmapM825b, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, this.paint);
                }
                if (this.f1104d) {
                    if (bitmapM825b2 != null && context.stage.layerIsVisible(3)) {
                        canvas.drawBitmap(bitmapM825b2, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, this.paint);
                    }
                } else if (context.stage.getSelectedLayerID() == 0 && !context.stage.getDrawingFront()) {
                    drawFluidLayers(context, canvas);
                    if (bitmapM825b2 != null && context.stage.layerIsVisible(3)) {
                        canvas.drawBitmap(bitmapM825b2, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, this.paint);
                    }
                } else {
                    if (bitmapM825b2 != null && context.stage.layerIsVisible(3)) {
                        canvas.drawBitmap(bitmapM825b2, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, this.paint);
                    }
                    drawFluidLayers(context, canvas);
                }
            } else {
                Bitmap bitmapM825b3 = context.stage.m825b(2);
                Bitmap bitmapM825b4 = context.stage.m825b(4);
                if (bitmapM825b3 != null) {
                    canvas.drawBitmap(bitmapM825b3, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, this.paint);
                }
                if (bitmapM825b != null && context.stage.layerIsVisible(0)) {
                    canvas.drawBitmap(bitmapM825b, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, this.paint);
                }
                if (this.f1104d) {
                    if (bitmapM825b4 != null) {
                        canvas.drawBitmap(bitmapM825b4, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, this.paint);
                    }
                    if (bitmapM825b2 != null && context.stage.layerIsVisible(3)) {
                        canvas.drawBitmap(bitmapM825b2, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, this.paint);
                    }
                } else if (context.stage.getSelectedLayerID() == 0 && !context.stage.getDrawingFront()) {
                    drawFluidLayers(context, canvas);
                    if (bitmapM825b4 != null) {
                        canvas.drawBitmap(bitmapM825b4, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, this.paint);
                    }
                    if (bitmapM825b2 != null && context.stage.layerIsVisible(3)) {
                        canvas.drawBitmap(bitmapM825b2, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, this.paint);
                    }
                } else {
                    if (bitmapM825b4 != null) {
                        canvas.drawBitmap(bitmapM825b4, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, this.paint);
                    }
                    if (bitmapM825b2 != null && context.stage.layerIsVisible(3)) {
                        canvas.drawBitmap(bitmapM825b2, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, this.paint);
                    }
                    drawFluidLayers(context, canvas);
                }
            }
            drawCursorPoint(context, canvas);
        }
    }

    public void drawFluidLayers(AbstractModeContext context, Canvas canvas) {
        Bitmap bitmapM825b = context.stage.m825b(1);
        if (bitmapM825b != null) {
            canvas.drawBitmap(bitmapM825b, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, this.paint);
        }
        int size = context.stage.m837g().size();
        for (int i = 5; i < size; i++) {
            Bitmap bitmapM825b2 = context.stage.m825b(i);
            if (bitmapM825b2 != null) {
                canvas.drawBitmap(bitmapM825b2, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, this.paint);
            }
        }
    }

    @Override // com.samsung.sdraw.ModeState
    public boolean onTouchEvent(AbstractModeContext context, MotionEvent event) {
        return onTouchEvent(context, event, context.setting.getUserID(), 0);
    }

    @Override // com.samsung.sdraw.ModeState
    public boolean onTouchEvent(AbstractModeContext context, MotionEvent event, int userID, int strokeID) throws InterruptedException {
        ViewParent parent;
        RectF rectFOnTouchCancelEvent = null;
        int action = event.getAction();
        if (event.getActionIndex() == this.touchID && event.getActionMasked() == 6) {
            action = 1;
        }
        switch (action) {
            case 0:
                this.touchID = event.getPointerId(0);
                if (userID == context.setting.getUserID()) {
                    strokeID = context.setting.getMultiObjectId();
                }
                rectFOnTouchCancelEvent = onTouchDownEvent(context, event, userID, strokeID);
                break;
            case 1:
                if (this.touchID == event.getPointerId(0)) {
                    rectFOnTouchCancelEvent = onTouchUpEvent(context, event, userID);
                    this.touchID = -1;
                    break;
                }
                break;
            case 2:
                if (this.touchID == event.getPointerId(0)) {
                    rectFOnTouchCancelEvent = onTouchMoveEvent(context, event, userID);
                    break;
                }
                break;
            case 3:
                rectFOnTouchCancelEvent = onTouchCancelEvent(context, event, userID);
                if (context.setting.mOnDrawCancelListener != null) {
                    context.setting.mOnDrawCancelListener.onCancel(userID);
                }
                if (this.f1103c) {
                    this.f1103c = false;
                    break;
                }
                break;
            default:
                rectFOnTouchCancelEvent = new RectF();
                break;
        }
        if (rectFOnTouchCancelEvent == null) {
            return false;
        }
        if (!rectFOnTouchCancelEvent.isEmpty()) {
            RectF rectFMapFromScene = context.stage.mapFromScene(rectFOnTouchCancelEvent);
            if (this.mStroke != null) {
                rectFMapFromScene.inset((-Math.max(5.0f, this.mStroke.m1166k())) * 0.5f, (-Math.max(5.0f, this.mStroke.m1166k())) * 0.5f);
            }
            View viewM1120k = context.setting.m1120k();
            if (viewM1120k != null && (parent = viewM1120k.getParent()) != null) {
                Rect rect = new Rect();
                rectFMapFromScene.roundOut(rect);
                parent.invalidateChild(viewM1120k, rect);
            } else {
                context.invalidate(rectFMapFromScene);
            }
        }
        return true;
    }

    public void removeStrokeSprite(AbstractModeContext context) {
        if (this.mStroke != null) {
            this.mStroke.m1164i();
            this.mStroke.f1315d = true;
            LinkedList<AbstractSprite> sprites = context.stage.getSprites();
            if (!sprites.isEmpty()) {
                sprites.removeLast();
            }
            context.stage.clearLayer(this.f1102b);
            LinkedList<SpriteCommand> undoList = context.stage.getUndoList();
            if (undoList != null && !undoList.isEmpty()) {
                context.stage.getUndoList().pop();
            }
            this.mStroke = null;
        }
    }

    protected RectF onTouchDownEvent(AbstractModeContext context, MotionEvent event, int userID, int strokeID) {
        float penWidth;
        this.touchID = event.getPointerId(0);
        StrokeSprite.InputMethod inputMethodM1098a = context.setting.m1098a(userID);
        if (userID == context.setting.getUserID()) {
            if (context.setting.getStrokeType() == StrokeSprite.Type.Eraser) {
                if (context.setting.m1122m()) {
                    context.setting.setStrokeParameter(StrokeSprite.ThicknessParameter.SpeedAndPressure);
                } else {
                    context.setting.setStrokeParameter(StrokeSprite.ThicknessParameter.Constant);
                }
            }
            if ((Build.VERSION.RELEASE.startsWith(SimpleUserInfo.STATE_MOVETO_CONFERENCE) && event.getToolType(0) == 4) || context.setting.getStrokeType() == StrokeSprite.Type.Eraser) {
                this.mStroke = context.factory.mo1401a(StrokeSprite.Type.Eraser, StrokeSprite.ThicknessParameter.Constant, StrokeSprite.InputMethod.Hand, context.setting.getEraserWidth(), context.setting.getStrokeColor(), context.stage.getSelectedLayerID());
            } else {
                this.mStroke = context.factory.mo1401a(context.setting.getStrokeType(), context.setting.getStrokeParameter(), inputMethodM1098a, context.setting.getStrokeWidth(), context.setting.getStrokeColor(), context.stage.getSelectedLayerID());
            }
        } else {
            PenSettingInfo penSettingInfo = context.setting.getPenSettingInfos().containsKey(Integer.valueOf(userID)) ? context.setting.getPenSettingInfos().get(Integer.valueOf(userID)) : new PenSettingInfo();
            if (penSettingInfo.getPenType() == 5) {
                penWidth = penSettingInfo.getPenWidth() * 1.1f;
            } else if (penSettingInfo.getPenType() == 2) {
                penWidth = penSettingInfo.getPenWidth() + 2;
            } else {
                penWidth = penSettingInfo.getPenWidth();
            }
            if ((Build.VERSION.RELEASE.startsWith(SimpleUserInfo.STATE_MOVETO_CONFERENCE) && event.getToolType(0) == 4) || PenSettingInfo.m1020a(penSettingInfo.getPenType()) == StrokeSprite.Type.Eraser) {
                this.mStroke = context.factory.mo1401a(StrokeSprite.Type.Eraser, StrokeSprite.ThicknessParameter.Constant, StrokeSprite.InputMethod.Hand, penWidth, penSettingInfo.getPenAlphaColor(), 0);
            } else {
                this.mStroke = context.factory.mo1401a(PenSettingInfo.m1020a(penSettingInfo.getPenType()), AbstractSettingView.m689a(penSettingInfo.getPenType()), inputMethodM1098a, penWidth, penSettingInfo.getPenAlphaColor(), 0);
            }
        }
        this.mStroke.objectID = -1;
        this.mStroke.multiUserID = userID;
        this.mStroke.multiObjectID = strokeID;
        if (inputMethodM1098a == StrokeSprite.InputMethod.Hand) {
            this.mStroke.m1154c(0);
            this.mStroke.m1144a(context.setting.m1108b());
            this.mStroke.m1149b(context.setting.m1113d());
        } else {
            if (this.mStroke.getType() == StrokeSprite.Type.Eraser) {
                this.mStroke.m1154c(2);
            } else {
                this.mStroke.m1154c(1);
            }
            this.mStroke.m1144a(context.setting.m1104a(this.mStroke.getType()));
            this.mStroke.m1149b(context.setting.m1109b(this.mStroke.getType()));
        }
        if (this.mStroke.getType() != StrokeSprite.Type.Eraser || !context.setting.m1119j()) {
            this.cursorPaint = null;
        } else {
            this.cursorPaint = new Paint();
            this.cursorPaint.setAntiAlias(true);
            this.cursorPaint.setColor(-16777216);
            this.cursorPaint.setStyle(Paint.Style.STROKE);
            this.cursorPaint.setStrokeWidth(1.0f);
        }
        context.stage.addSprite(this.mStroke, true, userID);
        if (userID == context.setting.getUserID()) {
            this.f1101a = true;
        }
        if (context.setting.m1103a()) {
            this.mStroke.m1155c(true);
        }
        return addPoints(context, event, userID);
    }

    protected RectF onTouchMoveEvent(AbstractModeContext context, MotionEvent event, int userID) {
        return this.mStroke == null ? new RectF() : addPoints(context, event, userID);
    }

    protected RectF onTouchUpEvent(AbstractModeContext context, MotionEvent event, int userID) throws InterruptedException {
        boolean zOnStrokeInserting;
        int layerID;
        if (this.mStroke == null) {
            return new RectF();
        }
        synchronized (Stage.sprites1) {
            zOnStrokeInserting = ((Stage) context.stage).mOnSpriteChangeListener != null ? ((Stage) context.stage).mOnSpriteChangeListener.onStrokeInserting(this.mStroke.m1174s()) : false;
        }
        if (zOnStrokeInserting) {
            this.mStroke.m1164i();
            this.mStroke.m1157d(true);
            RectF rectF = new RectF(this.mStroke.getBounds());
            if (this.mStroke.isPublicLayer()) {
                LinkedList<AbstractSprite> sprites = context.stage.getSprites(0);
                int size = sprites.size() - 1;
                while (true) {
                    if (size < 0) {
                        break;
                    }
                    if (sprites.get(size).multiUserID != userID) {
                        size--;
                    } else {
                        sprites.remove(size);
                        break;
                    }
                }
            } else {
                context.stage.getSprites(3).removeLast();
            }
            if (userID == context.setting.getUserID() || this.mStroke.getType() == StrokeSprite.Type.Hightlighter) {
                context.stage.clearLayer(this.f1102b);
            }
            if (context.isUndoable(userID)) {
                context.stage.getUndoList(userID).pop();
            }
            this.mStroke = null;
            this.touchID = -1;
            if (userID == context.setting.getUserID()) {
                if (this.f1101a && context.historyChangeListener != null) {
                    context.historyChangeListener.onHistoryChanged(context.stage.isUndoable(), context.stage.isRedoable());
                }
                this.f1101a = false;
            }
            return rectF;
        }
        int action = (event.getAction() & 65280) >> 8;
        int pointerCount = event.getPointerCount();
        int i = 0;
        while (true) {
            if (i < pointerCount) {
                if (this.touchID == event.getPointerId(i)) {
                    break;
                }
                i++;
            } else {
                i = -1;
                break;
            }
        }
        if (i == -1 || action != i) {
            return new RectF();
        }
        this.touchID = -1;
        RectF rectF2 = new RectF(addPoints(context, event, userID));
        if ((!this.mStroke.m1170o() || this.cursorPaint != null) && (userID == context.setting.getUserID() || this.mStroke.getType() == StrokeSprite.Type.Hightlighter)) {
            context.stage.clearLayer(this.f1102b, rectF2);
        }
        if (this.mStroke.getType() == StrokeSprite.Type.Eraser) {
            layerID = this.mStroke.getLayerID();
        } else {
            layerID = (userID == context.setting.getUserID() || this.mStroke.getType() == StrokeSprite.Type.Hightlighter) ? this.f1102b : this.mStroke.getLayerID();
        }
        context.stage.renderSprite(layerID, this.mStroke, rectF2);
        rectF2.union(this.mStroke.m1164i());
        if ((!this.mStroke.m1170o() || this.cursorPaint != null) && (userID == context.setting.getUserID() || this.mStroke.getType() == StrokeSprite.Type.Hightlighter)) {
            context.stage.clearLayer(this.f1102b, rectF2);
        }
        if (this.mStroke.getType() == StrokeSprite.Type.Solid || this.mStroke.getType() == StrokeSprite.Type.Eraser) {
            this.mStroke.m1157d(true);
            if (userID == context.setting.getUserID()) {
                context.stage.clearLayer(this.f1102b, rectF2);
            }
        }
        context.stage.renderSprite(layerID, this.mStroke, rectF2);
        this.mStroke.m1157d(true);
        StrokeInfo strokeInfoM1174s = this.mStroke.m1174s();
        synchronized (Stage.sprites1) {
            if (((Stage) context.stage).mOnSpriteChangeListener != null) {
                ((Stage) context.stage).mOnSpriteChangeListener.onObjectInserted(strokeInfoM1174s, false, false);
            }
        }
        if (this.mStroke == null) {
            return new RectF();
        }
        this.mStroke.objectID = strokeInfoM1174s.getID();
        if ((userID == context.setting.getUserID() && this.mStroke.getType() != StrokeSprite.Type.Eraser) || this.mStroke.getType() == StrokeSprite.Type.Hightlighter) {
            makeCachedStrokeSprite(context, this.f1102b);
            strokeToFixedLayer(context, this.f1102b);
        }
        rectF2.union(this.mStroke.getBounds());
        if (userID == context.setting.getUserID()) {
            if (this.f1101a && context.historyChangeListener != null) {
                context.historyChangeListener.onHistoryChanged(context.stage.isUndoable(), context.stage.isRedoable());
            }
            this.f1101a = false;
        }
        this.mStroke = null;
        return rectF2;
    }

    protected void strokeToFixedLayer(AbstractModeContext context, int targetLayer) {
        Canvas canvasM830c;
        Bitmap bitmapM825b = context.stage.m825b(targetLayer);
        RectF bounds = this.mStroke.getBounds();
        Rect rect = new Rect();
        bounds.roundOut(rect);
        rect.left = Math.max(0, rect.left);
        rect.top = Math.max(0, rect.top);
        rect.right = Math.min(bitmapM825b.getWidth(), rect.right);
        rect.bottom = Math.min(bitmapM825b.getHeight(), rect.bottom);
        if (rect.width() <= 0) {
            rect.right = rect.left + 1;
        }
        if (rect.height() <= 0) {
            rect.bottom = rect.top + 1;
        }
        if (this.mStroke.getLayerID() == 0) {
            canvasM830c = context.stage.m830c(0);
        } else {
            canvasM830c = context.stage.m830c(3);
        }
        canvasM830c.save();
        canvasM830c.clipRect(rect);
        canvasM830c.drawBitmap(bitmapM825b, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, (Paint) null);
        canvasM830c.restore();
        context.stage.clearLayer(targetLayer);
    }

    protected void makeCachedStrokeSprite(AbstractModeContext context, int targetLayer) throws InterruptedException {
        Bitmap bitmapM825b = context.stage.m825b(targetLayer);
        RectF bounds = this.mStroke.getBounds();
        Rect rect = new Rect();
        bounds.roundOut(rect);
        rect.left = Math.max(0, rect.left);
        rect.top = Math.max(0, rect.top);
        rect.right = Math.min(bitmapM825b.getWidth(), rect.right);
        rect.bottom = Math.min(bitmapM825b.getHeight(), rect.bottom);
        if (rect.width() <= 0) {
            rect.right = rect.left + 1;
        }
        if (rect.height() <= 0) {
            rect.bottom = rect.top + 1;
        }
        if (rect.left <= bitmapM825b.getWidth() && rect.top <= bitmapM825b.getHeight()) {
            context.stage.f846j.m1424a(new C1025bk(this.mStroke, Bitmap.createBitmap(bitmapM825b, rect.left, rect.top, rect.width(), rect.height())));
        }
    }

    protected RectF onTouchCancelEvent(AbstractModeContext context, MotionEvent event, int userID) {
        if (this.mStroke == null) {
            return new RectF();
        }
        if (this.mStroke.m1160f() == StrokeSprite.InputMethod.Tablet && !this.f1103c) {
            return onTouchUpEvent(context, event, userID);
        }
        this.mStroke.m1164i();
        this.mStroke.m1157d(true);
        RectF rectF = new RectF(this.mStroke.getBounds());
        if (this.mStroke.isPublicLayer()) {
            synchronized (Stage.sprites1) {
                LinkedList<AbstractSprite> sprites = context.stage.getSprites(0);
                int size = sprites.size() - 1;
                while (true) {
                    if (size < 0) {
                        break;
                    }
                    if (sprites.get(size).multiUserID != userID) {
                        size--;
                    } else {
                        sprites.remove(size);
                        break;
                    }
                }
                if (userID == context.setting.getUserID()) {
                    if (this.mStroke.getType() == StrokeSprite.Type.Eraser) {
                        m1018a(context, 0);
                    } else {
                        context.stage.clearLayer(this.f1102b);
                    }
                } else if (this.mStroke.getType() == StrokeSprite.Type.Hightlighter) {
                    context.stage.clearLayer(this.f1102b);
                } else {
                    m1018a(context, 0);
                }
            }
        } else {
            synchronized (Stage.sprites2) {
                context.stage.getSprites(3).removeLast();
                if (this.mStroke.getType() == StrokeSprite.Type.Eraser) {
                    m1018a(context, 3);
                } else {
                    context.stage.clearLayer(this.f1102b);
                }
            }
        }
        if (context.isUndoable(userID)) {
            context.stage.getUndoList(userID).pop();
        }
        if (userID == context.setting.getUserID() && context.historyChangeListener != null) {
            context.historyChangeListener.onHistoryChanged(context.stage.isUndoable(), context.stage.isRedoable());
        }
        this.mStroke = null;
        this.touchID = -1;
        if (userID == context.setting.getUserID()) {
            this.f1101a = false;
        }
        return rectF;
    }

    /* renamed from: a */
    private void m1018a(AbstractModeContext abstractModeContext, int i) {
        Bitmap bitmap;
        LinkedList<AbstractSprite> linkedListM812a;
        if (i == 3) {
            bitmap = abstractModeContext.stage.fixedSprites2;
            linkedListM812a = abstractModeContext.stage.m827b(StrokeSprite.class, C1063s.class);
        } else {
            bitmap = abstractModeContext.stage.f845i;
            linkedListM812a = abstractModeContext.stage.m812a(StrokeSprite.class, C1063s.class);
        }
        Canvas canvasM830c = abstractModeContext.stage.m830c(i);
        canvasM830c.save();
        canvasM830c.clipRect(this.mStroke.getBounds());
        abstractModeContext.stage.clearLayer(i);
        if (bitmap != null && abstractModeContext.stage.layerIsVisible(i)) {
            abstractModeContext.stage.m830c(i).drawBitmap(bitmap, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, (Paint) null);
        }
        if (linkedListM812a != null) {
            Iterator<AbstractSprite> it = linkedListM812a.iterator();
            while (it.hasNext()) {
                AbstractSprite next = it.next();
                if (next.isHitted(this.mStroke.getBounds())) {
                    if (((StrokeSprite) next).m1169n()) {
                        abstractModeContext.stage.renderSprite(i, next, this.mStroke.getBounds());
                    } else {
                        ((StrokeSprite) next).m1157d(true);
                        abstractModeContext.stage.renderSprite(i, next, this.mStroke.getBounds());
                        ((StrokeSprite) next).m1157d(false);
                    }
                }
            }
        }
        canvasM830c.restore();
    }

    @Override // com.samsung.sdraw.ModeState
    public void onFinishJob(AbstractModeContext context) throws InterruptedException {
        onFinishJob(context, context.setting.getUserID());
    }

    @Override // com.samsung.sdraw.ModeState
    public void onFinishJob(AbstractModeContext context, int userID) throws InterruptedException {
        if (this.mStroke != null && !this.mStroke.m1169n() && !this.mStroke.f1317f.isEmpty()) {
            C1007at c1007atLastElement = this.mStroke.f1317f.lastElement();
            MotionEvent motionEventObtain = MotionEvent.obtain(c1007atLastElement.f1537d, c1007atLastElement.f1537d, 1, c1007atLastElement.f1534a, c1007atLastElement.f1535b, 0);
            onTouchUpEvent(context, motionEventObtain, userID);
            motionEventObtain.recycle();
        }
    }

    protected RectF addPoints(AbstractModeContext context, MotionEvent event, int userID) {
        PointF pointF = new PointF();
        android.graphics.PointF correctionPoint = context.setting.m1098a(userID) == StrokeSprite.InputMethod.Tablet ? context.setting.getCorrectionPoint() : new PointF();
        RectF rectF = new RectF();
        StrokeSprite.Type type = this.mStroke.getType();
        int pointerCount = event.getPointerCount();
        int i = 0;
        while (true) {
            if (i >= pointerCount) {
                i = -1;
                break;
            }
            if (this.touchID == event.getPointerId(i)) {
                break;
            }
            i++;
        }
        if (this.mStroke != null && userID == context.setting.getUserID() && context.stage.m835e(userID) && context.setting.mOnDrawingInformationListener != null) {
            context.setting.mOnDrawingInformationListener.onDrawingPen(context.view, event);
        }
        if (i == -1) {
            pointF.set(event.getX(), event.getY());
            PointF pointFMapToScene = context.stage.mapToScene(pointF);
            this.mStroke.f1317f.add(new C1007at(pointFMapToScene.x, pointFMapToScene.y, event.getPressure(), event.getEventTime(), (float) Math.sqrt(((this.mStroke.f1317f.lastElement().f1535b - this.mStroke.f1317f.get(this.mStroke.f1317f.size() - 1).f1535b) * (this.mStroke.f1317f.lastElement().f1535b - this.mStroke.f1317f.get(this.mStroke.f1317f.size() - 1).f1535b)) + ((this.mStroke.f1317f.lastElement().f1534a - this.mStroke.f1317f.get(this.mStroke.f1317f.size() - 1).f1534a) * (this.mStroke.f1317f.lastElement().f1534a - this.mStroke.f1317f.get(this.mStroke.f1317f.size() - 1).f1534a)))));
            return rectF;
        }
        if (context.setting.getUseHistoricalEvents() && this.mStroke.m1160f() != StrokeSprite.InputMethod.Hand) {
            int historySize = event.getHistorySize();
            for (int i2 = 0; i2 < historySize; i2++) {
                pointF.set(event.getHistoricalX(i2), event.getHistoricalY(i2));
                processTouchEvent(context, rectF, pointF, correctionPoint, type, event.getHistoricalPressure(i2), event.getHistoricalEventTime(i2), userID);
            }
        }
        pointF.set(event.getX(), event.getY());
        if (event.getAction() == 0 && this.mStroke.getType() == StrokeSprite.Type.Zenbrush) {
            processTouchEvent(context, rectF, pointF, correctionPoint, type, event.getPressure() * 2.0f, event.getEventTime(), userID);
        } else {
            processTouchEvent(context, rectF, pointF, correctionPoint, type, event.getPressure(), event.getEventTime(), userID);
        }
        return rectF;
    }

    protected void processTouchEvent(AbstractModeContext context, RectF refreshRect, PointF touchPoint, android.graphics.PointF correctionPoint, StrokeSprite.Type strokeType, float pressure, long time, int userID) {
        touchPoint.offset(correctionPoint.x, correctionPoint.y);
        Rect canvasRect = context.setting.getCanvasRect();
        touchPoint.offset(-canvasRect.left, -canvasRect.top);
        PointF pointFMapToScene = context.stage.mapToScene(touchPoint);
        if (this.mStroke.m1152b(pointFMapToScene.x, pointFMapToScene.y, 255.0f * pressure, time, false)) {
            RectF rectFM1147b = this.mStroke.m1147b(true);
            refreshRect.union(rectFM1147b);
            drawLineSegment(context, rectFM1147b, strokeType, userID);
        }
    }

    protected void drawLineSegment(AbstractModeContext context, RectF segmentRect, StrokeSprite.Type strokeType, int userID) {
        int layerID;
        if ((!this.mStroke.m1170o() || this.cursorPaint != null) && (userID == context.setting.getUserID() || this.mStroke.getType() == StrokeSprite.Type.Hightlighter)) {
            context.stage.clearLayer(this.f1102b, segmentRect);
        }
        if (this.mStroke.getType() == StrokeSprite.Type.Eraser) {
            layerID = this.mStroke.getLayerID();
        } else {
            layerID = (userID == context.setting.getUserID() || this.mStroke.getType() == StrokeSprite.Type.Hightlighter) ? this.f1102b : this.mStroke.getLayerID();
        }
        context.stage.renderSprite(layerID, this.mStroke, segmentRect);
    }

    protected void drawCursorPoint(AbstractModeContext context, Canvas canvas) {
        if (this.mStroke != null && context.getCursorVisible()) {
            Vector<C1043cb> vectorM1156d = this.mStroke.m1156d();
            if (this.cursorPaint != null && !this.mStroke.m1169n() && !vectorM1156d.isEmpty()) {
                C1043cb c1043cbLastElement = vectorM1156d.lastElement();
                canvas.drawCircle(c1043cbLastElement.x, c1043cbLastElement.y, c1043cbLastElement.f1688h, this.cursorPaint);
            }
        }
    }

    @Override // com.samsung.sdraw.ModeState
    public int getLayerID(AbstractModeContext context) {
        return 0;
    }

    @Override // com.samsung.sdraw.ModeState
    public boolean isAnimating() {
        return this.f1104d;
    }

    @Override // com.samsung.sdraw.ModeState
    public void setAnimating(boolean animating) {
        this.f1104d = animating;
    }

    public void setCursorVisible(boolean visible) {
    }

    public StrokeSprite getSprite() {
        return this.mStroke;
    }

    @Override // com.samsung.sdraw.ModeState
    public void clearOffscreenBuffer(AbstractModeContext context) {
    }

    @Override // com.samsung.sdraw.ModeState
    public boolean isFixedBuffer(AbstractModeContext context) {
        return false;
    }

    public int getStrokeVertorSize() {
        if (this.mStroke != null) {
            return this.mStroke.m1156d().size();
        }
        return 0;
    }

    public void setFluidLayerId(int layerId) {
        this.f1102b = layerId;
    }

    public int getFluidLayerId() {
        return this.f1102b;
    }

    public void setIsMethodCancelEvent(boolean isMethodCancelEvent) {
        this.f1103c = isMethodCancelEvent;
    }
}
