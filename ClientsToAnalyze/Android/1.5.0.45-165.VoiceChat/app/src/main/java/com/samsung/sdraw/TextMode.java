package com.samsung.sdraw;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.text.Editable;
import android.text.Layout;
import android.view.MotionEvent;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
class TextMode implements ModeState {

    /* renamed from: a */
    protected TextSprite f1341a;

    /* renamed from: c */
    protected boolean f1343c = false;

    /* renamed from: d */
    private boolean f1344d = false;

    /* renamed from: e */
    private OnTextSelectedListener f1345e = null;

    /* renamed from: f */
    private boolean f1346f = false;

    /* renamed from: b */
    protected Paint f1342b = new Paint();

    public interface OnTextSelectedListener {
        void onTextSelected(ObjectInfo objectInfo, boolean z);
    }

    public TextMode() {
        this.f1342b.setAntiAlias(true);
        this.f1342b.setDither(true);
        this.f1342b.setFilterBitmap(true);
    }

    @Override // com.samsung.sdraw.ModeState
    public void clearOffscreenBuffer(AbstractModeContext context) {
        if (context.stage != null && context.stage.getFluidStroke() != null) {
            context.stage.getFluidStroke().eraseColor(0);
        }
    }

    /* renamed from: a */
    private void m1178a(AbstractModeContext abstractModeContext, InterfaceC1035bu interfaceC1035bu) {
        TextSprite textSpriteMo1403a;
        PointF pointF = new PointF();
        pointF.x = interfaceC1035bu.getTextBoxPosition().x;
        pointF.y = interfaceC1035bu.getTextBoxPosition().y;
        PointF pointFMapToScene = abstractModeContext.stage.mapToScene(pointF);
        int textBoxWidth = interfaceC1035bu.getTextBoxWidth();
        int textBoxHeight = interfaceC1035bu.getTextBoxHeight();
        Layout.Alignment textBoxAlignment = interfaceC1035bu.getTextBoxAlignment();
        Editable textBoxText = interfaceC1035bu.getTextBoxText();
        if (textBoxText.length() != 0) {
            if (abstractModeContext.stage.getSelectedLayerID() == 0) {
                textSpriteMo1403a = abstractModeContext.factory.mo1403a(textBoxWidth, textBoxHeight, textBoxAlignment, textBoxText, abstractModeContext.setting.getTextFont(), 2);
            } else {
                textSpriteMo1403a = abstractModeContext.factory.mo1403a(textBoxWidth, textBoxHeight, textBoxAlignment, textBoxText, abstractModeContext.setting.getTextFont(), 4);
            }
            textSpriteMo1403a.objectID = interfaceC1035bu.getObjectID();
            textSpriteMo1403a.multiUserID = abstractModeContext.setting.getUserID();
            if (textSpriteMo1403a.getLayerID() == 4) {
                textSpriteMo1403a.multiObjectID = 0;
            } else {
                textSpriteMo1403a.multiObjectID = abstractModeContext.setting.getMultiObjectId();
            }
            textSpriteMo1403a.moveTo(pointFMapToScene.x, pointFMapToScene.y);
            abstractModeContext.stage.addSprite(textSpriteMo1403a, true, textSpriteMo1403a.multiUserID);
            m1180a(abstractModeContext, false);
        }
    }

    @Override // com.samsung.sdraw.ModeState
    public boolean isFixedBuffer(AbstractModeContext context) {
        return false;
    }

    /* renamed from: a */
    private void m1177a(AbstractModeContext abstractModeContext, TextSprite textSprite, InterfaceC1035bu interfaceC1035bu) {
        PointF pointF = new PointF(interfaceC1035bu.getTextBoxPosition().x, interfaceC1035bu.getTextBoxPosition().y);
        boolean z = textSprite.m1195b() != abstractModeContext.setting.getTextColor();
        if (textSprite.m1197d() != abstractModeContext.setting.getTextSize()) {
            z = true;
        }
        if (textSprite.m1198e() != abstractModeContext.setting.getTextType()) {
            z = true;
        }
        if (!textSprite.m1200g().equals(abstractModeContext.setting.getTextFont())) {
            z = true;
        }
        boolean z2 = !textSprite.m1199f().equals(abstractModeContext.setting.getTextAlignment()) ? true : z;
        PointF pointFMapToScene = abstractModeContext.stage.mapToScene(pointF);
        int textBoxWidth = interfaceC1035bu.getTextBoxWidth();
        int textBoxHeight = interfaceC1035bu.getTextBoxHeight();
        Layout.Alignment textBoxAlignment = interfaceC1035bu.getTextBoxAlignment();
        Editable textBoxText = interfaceC1035bu.getTextBoxText();
        if (textBoxText.length() == 0) {
            abstractModeContext.stage.deleteSprite(textSprite, true);
        } else {
            abstractModeContext.stage.modifyTextSprite(textSprite, pointFMapToScene, textBoxWidth, textBoxHeight, textBoxAlignment, textBoxText, z2);
            textSprite.setVisible(true);
        }
        m1180a(abstractModeContext, false);
    }

    @Override // com.samsung.sdraw.ModeState
    public void onActivate(AbstractModeContext context, boolean isActive) {
        if (!isActive) {
            onFinishJob(context);
            Iterator<AbstractSprite> it = context.stage.getSelectedSprites().iterator();
            while (it.hasNext()) {
                AbstractSprite next = it.next();
                if (next instanceof TextSprite) {
                    next.deselect();
                }
            }
            context.invalidate();
            return;
        }
        Iterator<AbstractSprite> it2 = context.stage.getSelectedSprites().iterator();
        while (it2.hasNext()) {
            AbstractSprite next2 = it2.next();
            if (next2 instanceof TextSprite) {
                next2.deselect();
            }
        }
        m1180a(context, true);
    }

    @Override // com.samsung.sdraw.ModeState
    public void onDraw(AbstractModeContext context, Canvas canvas) {
        if (context.stage != null) {
            Bitmap bitmapM825b = context.stage.m825b(2);
            Bitmap bitmapM825b2 = context.stage.m825b(4);
            Bitmap bitmapM825b3 = context.stage.m825b(0);
            Bitmap bitmapM825b4 = context.stage.m825b(3);
            Bitmap bitmapM825b5 = context.stage.m825b(1);
            if (bitmapM825b != null && context.stage.layerIsVisible(2)) {
                canvas.drawBitmap(bitmapM825b, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, this.f1342b);
            }
            if (bitmapM825b3 != null && context.stage.layerIsVisible(0)) {
                canvas.drawBitmap(bitmapM825b3, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, this.f1342b);
            }
            if (this.f1344d) {
                if (bitmapM825b2 != null && context.stage.layerIsVisible(4)) {
                    canvas.drawBitmap(bitmapM825b2, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, this.f1342b);
                }
                if (bitmapM825b4 != null && context.stage.layerIsVisible(3)) {
                    canvas.drawBitmap(bitmapM825b4, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, this.f1342b);
                    return;
                }
                return;
            }
            if (context.stage.getSelectedLayerID() == 0 && !context.stage.getDrawingFront()) {
                if (bitmapM825b5 != null) {
                    canvas.drawBitmap(bitmapM825b5, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, this.f1342b);
                }
                if (bitmapM825b2 != null && context.stage.layerIsVisible(4)) {
                    canvas.drawBitmap(bitmapM825b2, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, this.f1342b);
                }
                if (bitmapM825b4 != null && context.stage.layerIsVisible(3)) {
                    canvas.drawBitmap(bitmapM825b4, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, this.f1342b);
                    return;
                }
                return;
            }
            if (bitmapM825b2 != null && context.stage.layerIsVisible(4)) {
                canvas.drawBitmap(bitmapM825b2, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, this.f1342b);
            }
            if (bitmapM825b4 != null && context.stage.layerIsVisible(3)) {
                canvas.drawBitmap(bitmapM825b4, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, this.f1342b);
            }
            if (bitmapM825b5 != null) {
                canvas.drawBitmap(bitmapM825b5, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, this.f1342b);
            }
        }
    }

    /* renamed from: a */
    protected void m1179a(AbstractModeContext abstractModeContext, PointF pointF) {
        ArrayList<AbstractSprite> hits = abstractModeContext.stage.getHits(abstractModeContext.stage.mapToScene(pointF), false);
        InterfaceC1035bu edit = abstractModeContext.getEdit();
        if (edit.isShowTextBox()) {
            edit.showTextBox(false);
            if (abstractModeContext.stage.getCountOfSelectedSprites() != 0) {
                m1177a(abstractModeContext, (TextSprite) abstractModeContext.stage.getSelectedSprites().get(0), edit);
            } else if (edit.getTextBoxText().length() != 0) {
                m1178a(abstractModeContext, edit);
            }
            abstractModeContext.stage.deselectSprites();
            edit.restoreTextSettingInfo();
            if (this.f1345e != null && this.f1341a != null) {
                this.f1345e.onTextSelected(this.f1341a.m1203j(), false);
            }
            this.f1341a = null;
            for (int size = hits.size() - 1; size >= 0; size--) {
                AbstractSprite abstractSprite = hits.get(size);
                if (abstractSprite instanceof TextSprite) {
                    TextSprite textSprite = (TextSprite) abstractSprite;
                    textSprite.select();
                    textSprite.setVisible(false);
                    edit.createTextBox(abstractModeContext.stage.mapFromScene(textSprite.getBounds()), textSprite.m1201h(), new TextInfo(textSprite.m1195b(), textSprite.m1197d(), textSprite.m1201h().toString(), textSprite.m1202i(), textSprite.m1198e(), textSprite.m1199f(), textSprite.m1200g(), textSprite.getLayerID()));
                    m1180a(abstractModeContext, false);
                    this.f1341a = textSprite;
                    if (this.f1345e != null) {
                        this.f1345e.onTextSelected(this.f1341a.m1203j(), true);
                        return;
                    }
                    return;
                }
            }
            return;
        }
        abstractModeContext.stage.deselectSprites();
        if (!this.f1346f) {
            for (int size2 = hits.size() - 1; size2 >= 0; size2--) {
                AbstractSprite abstractSprite2 = hits.get(size2);
                if (abstractSprite2 instanceof TextSprite) {
                    TextSprite textSprite2 = (TextSprite) abstractSprite2;
                    textSprite2.select();
                    textSprite2.setVisible(false);
                    edit.createTextBox(abstractModeContext.stage.mapFromScene(textSprite2.getBounds()), textSprite2.m1201h(), new TextInfo(textSprite2.m1195b(), textSprite2.m1197d(), textSprite2.m1201h().toString(), textSprite2.m1202i(), textSprite2.m1198e(), textSprite2.m1199f(), textSprite2.m1200g(), textSprite2.getLayerID()));
                    m1180a(abstractModeContext, false);
                    this.f1341a = textSprite2;
                    if (this.f1345e != null) {
                        this.f1345e.onTextSelected(this.f1341a.m1203j(), true);
                        return;
                    }
                    return;
                }
            }
        } else if (hits.size() > 0) {
            for (int size3 = hits.size() - 1; size3 >= 0; size3--) {
                if (hits.get(size3) instanceof TextSprite) {
                    this.f1341a = (TextSprite) hits.get(size3);
                    this.f1341a.select();
                    this.f1341a.setVisible(false);
                    if (this.f1345e != null) {
                        this.f1345e.onTextSelected(this.f1341a.m1203j(), true);
                        return;
                    }
                    return;
                }
            }
        }
        Point point = new Point();
        point.x = (int) pointF.x;
        point.y = (int) pointF.y;
        edit.createTextBox(point);
        edit.setObjectID(-1);
        m1180a(abstractModeContext, false);
    }

    @Override // com.samsung.sdraw.ModeState
    public boolean onTouchEvent(AbstractModeContext context, MotionEvent event, int userID, int textID) {
        PointF pointF = new PointF(event.getX(), event.getY());
        if (event.getAction() == 0) {
            if (userID == context.setting.getUserID()) {
                context.setting.getMultiObjectId();
            }
            m1179a(context, pointF);
            return true;
        }
        if (event.getAction() == 3 && context.setting.getTextZoomMode()) {
            onFinishJob(context);
            return true;
        }
        return true;
    }

    @Override // com.samsung.sdraw.ModeState
    public boolean onTouchEvent(AbstractModeContext context, MotionEvent event) {
        return onTouchEvent(context, event, context.setting.getUserID(), -1);
    }

    /* renamed from: a */
    void m1180a(AbstractModeContext abstractModeContext, boolean z) {
        clearOffscreenBuffer(abstractModeContext);
        abstractModeContext.stage.renderAllSprites(z, 1);
    }

    @Override // com.samsung.sdraw.ModeState
    public void onFinishJob(AbstractModeContext context) {
        InterfaceC1035bu edit = context.getEdit();
        if (context.stage.getCountOfSelectedSprites() != 0) {
            edit.showTextBox(false);
            Iterator<AbstractSprite> it = context.stage.getSprites().iterator();
            while (it.hasNext()) {
                AbstractSprite next = it.next();
                if ((next instanceof TextSprite) && next.isSelected()) {
                    TextSprite textSprite = (TextSprite) next;
                    m1177a(context, textSprite, context.getEdit());
                    textSprite.deselect();
                    if (this.f1345e != null) {
                        this.f1345e.onTextSelected(textSprite.m1203j(), false);
                    }
                }
            }
        } else if (edit.getTextBoxText().length() != 0 && edit.isShowTextBox()) {
            edit.showTextBox(false);
            m1178a(context, edit);
        }
        if (edit.isShowTextBox()) {
            edit.showTextBox(false);
        }
        edit.restoreTextSettingInfo();
        this.f1341a = null;
    }

    @Override // com.samsung.sdraw.ModeState
    public void onFinishJob(AbstractModeContext context, int userID) {
        onFinishJob(context);
    }

    @Override // com.samsung.sdraw.ModeState
    public void onLayout(AbstractModeContext context, Rect rect) {
        context.invalidate();
    }

    @Override // com.samsung.sdraw.ModeState
    public void onDraw(AbstractModeContext context, Canvas canvas, int layer) {
        Paint paint = new Paint();
        Bitmap bitmapM825b = context.stage.m825b(layer);
        if (bitmapM825b != null) {
            canvas.drawBitmap(bitmapM825b, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, paint);
        }
    }

    @Override // com.samsung.sdraw.ModeState
    public int getLayerID(AbstractModeContext context) {
        return 2;
    }

    @Override // com.samsung.sdraw.ModeState
    public void setAnimating(boolean animating) {
        this.f1344d = animating;
    }

    @Override // com.samsung.sdraw.ModeState
    public boolean isAnimating() {
        return this.f1344d;
    }

    /* renamed from: a */
    public void m1181a(OnTextSelectedListener onTextSelectedListener) {
        this.f1345e = onTextSelectedListener;
    }

    /* renamed from: a */
    public void m1182a(boolean z) {
        this.f1346f = z;
    }
}
