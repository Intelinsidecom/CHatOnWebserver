package com.samsung.sdraw;

import android.graphics.Canvas;
import android.graphics.RectF;
import java.util.LinkedList;

/* renamed from: com.samsung.sdraw.be */
/* loaded from: classes.dex */
class C1019be implements SpriteCommand {

    /* renamed from: a */
    protected AbstractSprite f1558a;

    /* renamed from: b */
    protected AbstractStage f1559b;

    public C1019be(AbstractSprite abstractSprite, AbstractStage abstractStage) {
        this.f1558a = abstractSprite;
        this.f1559b = abstractStage;
    }

    @Override // com.samsung.sdraw.SpriteCommand
    /* renamed from: a */
    public RectF mo1129a() {
        if (this.f1558a instanceof C0989ab) {
            ((ModeContext) this.f1559b.context).changeModeTo(this.f1558a.multiUserID, 1);
        }
        if (this.f1558a instanceof TextSprite) {
            ((ModeContext) this.f1559b.context).changeModeTo(this.f1558a.multiUserID, 4);
        }
        this.f1558a.setVisible(false);
        LinkedList<AbstractSprite> linkedListM812a = this.f1559b.m812a(StrokeSprite.class, C1063s.class);
        LinkedList<AbstractSprite> linkedListM827b = this.f1559b.m827b(StrokeSprite.class, C1063s.class);
        if (this.f1559b.context.setting != null && this.f1559b.context.setting.m1121l()) {
            Canvas canvasM830c = this.f1559b.m830c(this.f1558a.getLayerID());
            canvasM830c.save();
            canvasM830c.clipRect(this.f1558a.getBounds());
            this.f1559b.clearLayers(this.f1558a.getLayerID());
            this.f1559b.renderFixedSprites(this.f1558a.getLayerID());
            if (this.f1558a.getLayerID() == 0) {
                if (linkedListM812a != null) {
                    this.f1559b.m817a(0, linkedListM812a);
                }
            } else if (linkedListM827b != null) {
                this.f1559b.m817a(3, linkedListM827b);
            }
            canvasM830c.restore();
        } else if (this.f1558a instanceof StrokeSprite) {
            Canvas canvasM830c2 = this.f1559b.m830c(this.f1558a.getLayerID());
            canvasM830c2.save();
            canvasM830c2.clipRect(this.f1558a.getBounds());
            this.f1559b.clearLayer(this.f1558a.getLayerID());
            this.f1559b.renderFixedSprites(this.f1558a.getLayerID());
            if (this.f1558a.getLayerID() == 0) {
                if (linkedListM812a != null) {
                    this.f1559b.m817a(0, linkedListM812a);
                }
            } else if (linkedListM827b != null) {
                this.f1559b.m817a(3, linkedListM827b);
            }
            canvasM830c2.restore();
        } else {
            this.f1559b.clearLayer(this.f1558a.getLayerID());
            if (this.f1558a.getLayerID() == 2) {
                LinkedList<AbstractSprite> linkedListM811a = this.f1559b.m811a(TextSprite.class);
                LinkedList<AbstractSprite> linkedListM811a2 = this.f1559b.m811a(C0989ab.class);
                if (linkedListM811a2 != null) {
                    this.f1559b.m818a(2, linkedListM811a2, this.f1558a);
                }
                if (linkedListM811a != null) {
                    this.f1559b.m817a(2, linkedListM811a);
                }
            } else {
                LinkedList<AbstractSprite> linkedListM826b = this.f1559b.m826b(TextSprite.class);
                LinkedList<AbstractSprite> linkedListM826b2 = this.f1559b.m826b(C0989ab.class);
                if (linkedListM826b2 != null) {
                    this.f1559b.m818a(4, linkedListM826b2, this.f1558a);
                }
                if (linkedListM826b != null) {
                    this.f1559b.m817a(4, linkedListM826b);
                }
            }
            if (this.f1558a instanceof C0989ab) {
                this.f1559b.renderSprite(1, this.f1558a);
            }
        }
        return this.f1558a.getBounds();
    }

    @Override // com.samsung.sdraw.SpriteCommand
    /* renamed from: b */
    public RectF mo1130b() {
        if (this.f1558a instanceof C0989ab) {
            this.f1558a.select();
            ((ModeContext) this.f1559b.context).changeModeTo(this.f1558a.multiUserID, 3);
        }
        if (this.f1558a instanceof TextSprite) {
            ((ModeContext) this.f1559b.context).changeModeTo(this.f1558a.multiUserID, 4);
        }
        this.f1558a.setVisible(true);
        LinkedList<AbstractSprite> linkedListM812a = this.f1559b.m812a(StrokeSprite.class, C1063s.class);
        LinkedList<AbstractSprite> linkedListM827b = this.f1559b.m827b(StrokeSprite.class, C1063s.class);
        if (this.f1559b.context.setting != null && this.f1559b.context.setting.m1121l()) {
            Canvas canvasM830c = this.f1559b.m830c(this.f1558a.getLayerID());
            canvasM830c.save();
            canvasM830c.clipRect(this.f1558a.getBounds());
            this.f1559b.clearLayers(this.f1558a.getLayerID());
            this.f1559b.renderFixedSprites(this.f1558a.getLayerID());
            if (this.f1558a.getLayerID() == 0) {
                if (linkedListM812a != null) {
                    this.f1559b.m817a(0, linkedListM812a);
                }
            } else if (linkedListM827b != null) {
                this.f1559b.m817a(3, linkedListM827b);
            }
            canvasM830c.restore();
        } else if (this.f1558a instanceof StrokeSprite) {
            Canvas canvasM830c2 = this.f1559b.m830c(this.f1558a.getLayerID());
            canvasM830c2.save();
            canvasM830c2.clipRect(this.f1558a.getBounds());
            this.f1559b.clearLayer(this.f1558a.getLayerID());
            this.f1559b.renderFixedSprites(this.f1558a.getLayerID());
            if (this.f1558a.getLayerID() == 0) {
                if (linkedListM812a != null) {
                    this.f1559b.m817a(0, linkedListM812a);
                }
            } else if (linkedListM827b != null) {
                this.f1559b.m817a(3, linkedListM827b);
            }
            canvasM830c2.restore();
        } else {
            this.f1559b.clearLayer(this.f1558a.getLayerID());
            if (this.f1558a.getLayerID() == 2) {
                LinkedList<AbstractSprite> linkedListM811a = this.f1559b.m811a(TextSprite.class);
                LinkedList<AbstractSprite> linkedListM811a2 = this.f1559b.m811a(C0989ab.class);
                if (linkedListM811a2 != null) {
                    this.f1559b.m818a(2, linkedListM811a2, this.f1558a);
                }
                if (linkedListM811a != null) {
                    this.f1559b.m817a(2, linkedListM811a);
                }
            } else {
                LinkedList<AbstractSprite> linkedListM826b = this.f1559b.m826b(TextSprite.class);
                LinkedList<AbstractSprite> linkedListM826b2 = this.f1559b.m826b(C0989ab.class);
                if (linkedListM826b2 != null) {
                    this.f1559b.m818a(4, linkedListM826b2, this.f1558a);
                }
                if (linkedListM826b != null) {
                    this.f1559b.m817a(4, linkedListM826b);
                }
            }
            if (this.f1558a instanceof C0989ab) {
                this.f1559b.renderSprite(1, this.f1558a);
            }
        }
        return this.f1558a.getBounds();
    }

    @Override // com.samsung.sdraw.SpriteCommand
    /* renamed from: c */
    public StringBuilder mo1131c() {
        return null;
    }
}
