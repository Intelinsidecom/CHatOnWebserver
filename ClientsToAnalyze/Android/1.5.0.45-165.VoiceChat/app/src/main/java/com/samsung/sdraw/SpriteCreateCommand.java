package com.samsung.sdraw;

import android.graphics.Canvas;
import android.graphics.RectF;
import java.util.LinkedList;

/* loaded from: classes.dex */
class SpriteCreateCommand implements SpriteCommand {

    /* renamed from: a */
    public AbstractStage f1307a;
    public AbstractSprite sprite;

    public SpriteCreateCommand(AbstractSprite sprite, AbstractStage stage) {
        this.sprite = sprite;
        this.f1307a = stage;
    }

    @Override // com.samsung.sdraw.SpriteCommand
    /* renamed from: a */
    public RectF mo1129a() {
        if (this.sprite instanceof C0989ab) {
            this.sprite.select();
            ((ModeContext) this.f1307a.context).changeModeTo(this.sprite.multiUserID, 3);
        } else if (this.sprite instanceof C1063s) {
            ((ModeContext) this.f1307a.context).changeModeTo(this.sprite.multiUserID, 5);
        } else {
            ((ModeContext) this.f1307a.context).changeModeTo(this.sprite.multiUserID, 1);
        }
        this.sprite.setVisible(true);
        LinkedList<AbstractSprite> linkedListM812a = this.f1307a.m812a(StrokeSprite.class, C1063s.class);
        LinkedList<AbstractSprite> linkedListM827b = this.f1307a.m827b(StrokeSprite.class, C1063s.class);
        if (this.f1307a.context.setting != null && this.f1307a.context.setting.m1121l()) {
            Canvas canvasM830c = this.f1307a.m830c(this.sprite.getLayerID());
            canvasM830c.save();
            canvasM830c.clipRect(this.sprite.getBounds());
            this.f1307a.clearLayers(this.sprite.getLayerID());
            this.f1307a.renderFixedSprites(this.sprite.getLayerID());
            if (this.sprite.getLayerID() == 0) {
                if (linkedListM812a != null) {
                    this.f1307a.m817a(0, linkedListM812a);
                }
            } else if (linkedListM827b != null) {
                this.f1307a.m817a(3, linkedListM827b);
            }
            canvasM830c.restore();
            return null;
        }
        if (this.sprite instanceof StrokeSprite) {
            Canvas canvasM830c2 = this.f1307a.m830c(this.sprite.getLayerID());
            canvasM830c2.save();
            canvasM830c2.clipRect(this.sprite.getBounds());
            this.f1307a.clearLayer(this.sprite.getLayerID());
            this.f1307a.renderFixedSprites(this.sprite.getLayerID());
            if (this.sprite.getLayerID() == 0) {
                if (linkedListM812a != null) {
                    this.f1307a.m817a(0, linkedListM812a);
                }
            } else if (linkedListM827b != null) {
                this.f1307a.m817a(3, linkedListM827b);
            }
            canvasM830c2.restore();
            return null;
        }
        this.f1307a.clearLayer(this.sprite.getLayerID());
        if (this.sprite.getLayerID() == 2) {
            LinkedList<AbstractSprite> linkedListM811a = this.f1307a.m811a(TextSprite.class);
            LinkedList<AbstractSprite> linkedListM811a2 = this.f1307a.m811a(C0989ab.class);
            if (linkedListM811a2 != null) {
                this.f1307a.m818a(2, linkedListM811a2, this.sprite);
            }
            if (linkedListM811a != null) {
                this.f1307a.m817a(2, linkedListM811a);
            }
        } else {
            LinkedList<AbstractSprite> linkedListM826b = this.f1307a.m826b(TextSprite.class);
            LinkedList<AbstractSprite> linkedListM826b2 = this.f1307a.m826b(C0989ab.class);
            if (linkedListM826b2 != null) {
                this.f1307a.m818a(4, linkedListM826b2, this.sprite);
            }
            if (linkedListM826b != null) {
                this.f1307a.m817a(4, linkedListM826b);
            }
        }
        if (this.sprite instanceof C0989ab) {
            this.f1307a.renderSprite(1, this.sprite);
            return null;
        }
        return null;
    }

    @Override // com.samsung.sdraw.SpriteCommand
    /* renamed from: b */
    public RectF mo1130b() {
        if (this.sprite instanceof C0989ab) {
            ((ModeContext) this.f1307a.context).changeModeTo(this.sprite.multiUserID, 1);
        }
        if (this.sprite instanceof TextSprite) {
            ((ModeContext) this.f1307a.context).changeModeTo(this.sprite.multiUserID, 1);
        }
        this.sprite.setVisible(false);
        LinkedList<AbstractSprite> linkedListM812a = this.f1307a.m812a(StrokeSprite.class, C1063s.class);
        LinkedList<AbstractSprite> linkedListM827b = this.f1307a.m827b(StrokeSprite.class, C1063s.class);
        if (this.f1307a.context.setting != null && this.f1307a.context.setting.m1121l()) {
            Canvas canvasM830c = this.f1307a.m830c(this.sprite.getLayerID());
            canvasM830c.save();
            canvasM830c.clipRect(this.sprite.getBounds());
            this.f1307a.clearLayers(this.sprite.getLayerID());
            this.f1307a.renderFixedSprites(this.sprite.getLayerID());
            if (this.sprite.getLayerID() == 0) {
                if (linkedListM812a != null) {
                    this.f1307a.m817a(0, linkedListM812a);
                }
            } else if (linkedListM827b != null) {
                this.f1307a.m817a(3, linkedListM827b);
            }
            canvasM830c.restore();
            return null;
        }
        if (this.sprite instanceof StrokeSprite) {
            Canvas canvasM830c2 = this.f1307a.m830c(this.sprite.getLayerID());
            canvasM830c2.save();
            canvasM830c2.clipRect(this.sprite.getBounds());
            this.f1307a.clearLayer(this.sprite.getLayerID());
            this.f1307a.renderFixedSprites(this.sprite.getLayerID());
            if (this.sprite.getLayerID() == 0) {
                if (linkedListM812a != null) {
                    this.f1307a.m817a(0, linkedListM812a);
                }
            } else if (linkedListM827b != null) {
                this.f1307a.m817a(3, linkedListM827b);
            }
            canvasM830c2.restore();
            return null;
        }
        this.f1307a.clearLayer(this.sprite.getLayerID());
        if (this.sprite.getLayerID() == 2) {
            LinkedList<AbstractSprite> linkedListM811a = this.f1307a.m811a(TextSprite.class);
            LinkedList<AbstractSprite> linkedListM811a2 = this.f1307a.m811a(C0989ab.class);
            if (linkedListM811a2 != null) {
                this.f1307a.m818a(2, linkedListM811a2, this.sprite);
            }
            if (linkedListM811a != null) {
                this.f1307a.m817a(2, linkedListM811a);
            }
        } else {
            LinkedList<AbstractSprite> linkedListM826b = this.f1307a.m826b(TextSprite.class);
            LinkedList<AbstractSprite> linkedListM826b2 = this.f1307a.m826b(C0989ab.class);
            if (linkedListM826b2 != null) {
                this.f1307a.m818a(4, linkedListM826b2, this.sprite);
            }
            if (linkedListM826b != null) {
                this.f1307a.m817a(4, linkedListM826b);
            }
        }
        if (this.sprite instanceof C0989ab) {
            this.f1307a.renderSprite(1, this.sprite);
            return null;
        }
        return null;
    }

    @Override // com.samsung.sdraw.SpriteCommand
    /* renamed from: c */
    public StringBuilder mo1131c() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("<createcommand id=\"%d\"/>\n", Integer.valueOf(this.f1307a.getSprites().indexOf(this.sprite))));
        return sb;
    }
}
