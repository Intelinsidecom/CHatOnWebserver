package com.samsung.sdraw;

import android.graphics.RectF;
import java.util.LinkedList;

/* renamed from: com.samsung.sdraw.bg */
/* loaded from: classes.dex */
class C1021bg implements SpriteCommand {

    /* renamed from: a */
    protected AbstractSprite f1560a;

    /* renamed from: b */
    protected AbstractStage f1561b;

    /* renamed from: c */
    protected PointF f1562c;

    /* renamed from: d */
    protected PointF f1563d;

    public C1021bg(AbstractSprite abstractSprite, AbstractStage abstractStage) {
        this.f1560a = abstractSprite;
        this.f1561b = abstractStage;
    }

    /* renamed from: a */
    public void m1406a(PointF pointF) {
        this.f1562c = pointF;
    }

    /* renamed from: b */
    public void m1407b(PointF pointF) {
        this.f1563d = pointF;
    }

    @Override // com.samsung.sdraw.SpriteCommand
    /* renamed from: a */
    public RectF mo1129a() {
        ((ModeContext) this.f1561b.context).changeModeTo(this.f1560a.multiUserID, 3);
        this.f1560a.moveTo(this.f1563d.x - this.f1562c.x, this.f1563d.y - this.f1562c.y);
        LinkedList<AbstractSprite> linkedListM812a = this.f1561b.m812a(StrokeSprite.class, C1063s.class);
        LinkedList<AbstractSprite> linkedListM827b = this.f1561b.m827b(StrokeSprite.class, C1063s.class);
        LinkedList<AbstractSprite> linkedListM811a = this.f1561b.m811a(C0989ab.class);
        LinkedList<AbstractSprite> linkedListM826b = this.f1561b.m826b(C0989ab.class);
        LinkedList<AbstractSprite> linkedListM811a2 = this.f1561b.m811a(TextSprite.class);
        LinkedList<AbstractSprite> linkedListM826b2 = this.f1561b.m826b(TextSprite.class);
        this.f1561b.clearLayers();
        this.f1561b.renderFixedSprites(0);
        if (linkedListM811a != null) {
            this.f1561b.m818a(2, linkedListM811a, this.f1560a);
        }
        if (linkedListM811a2 != null) {
            this.f1561b.m818a(2, linkedListM811a2, this.f1560a);
        }
        if (linkedListM812a != null) {
            this.f1561b.m817a(0, linkedListM812a);
        }
        this.f1561b.renderFixedSprites(3);
        if (linkedListM827b != null) {
            this.f1561b.m817a(3, linkedListM827b);
        }
        if (linkedListM826b != null) {
            this.f1561b.m818a(4, linkedListM826b, this.f1560a);
        }
        if (linkedListM826b2 != null) {
            this.f1561b.m818a(4, linkedListM826b2, this.f1560a);
        }
        this.f1561b.renderSprite(1, this.f1560a);
        return this.f1560a.getBounds();
    }

    @Override // com.samsung.sdraw.SpriteCommand
    /* renamed from: b */
    public RectF mo1130b() {
        ((ModeContext) this.f1561b.context).changeModeTo(this.f1560a.multiUserID, 3);
        this.f1560a.moveTo(this.f1562c.x - this.f1563d.x, this.f1562c.y - this.f1563d.y);
        LinkedList<AbstractSprite> linkedListM812a = this.f1561b.m812a(StrokeSprite.class, C1063s.class);
        LinkedList<AbstractSprite> linkedListM827b = this.f1561b.m827b(StrokeSprite.class, C1063s.class);
        LinkedList<AbstractSprite> linkedListM811a = this.f1561b.m811a(C0989ab.class);
        LinkedList<AbstractSprite> linkedListM826b = this.f1561b.m826b(C0989ab.class);
        LinkedList<AbstractSprite> linkedListM811a2 = this.f1561b.m811a(TextSprite.class);
        LinkedList<AbstractSprite> linkedListM826b2 = this.f1561b.m826b(TextSprite.class);
        this.f1561b.clearLayers();
        this.f1561b.renderFixedSprites(0);
        if (linkedListM811a != null) {
            this.f1561b.m818a(2, linkedListM811a, this.f1560a);
        }
        if (linkedListM811a2 != null) {
            this.f1561b.m818a(2, linkedListM811a2, this.f1560a);
        }
        if (linkedListM812a != null) {
            this.f1561b.m817a(0, linkedListM812a);
        }
        this.f1561b.renderFixedSprites(3);
        if (linkedListM826b != null) {
            this.f1561b.m818a(4, linkedListM826b, this.f1560a);
        }
        if (linkedListM826b2 != null) {
            this.f1561b.m818a(4, linkedListM826b2, this.f1560a);
        }
        if (linkedListM827b != null) {
            this.f1561b.m817a(3, linkedListM827b);
        }
        this.f1561b.renderSprite(1, this.f1560a);
        return this.f1560a.getBounds();
    }

    @Override // com.samsung.sdraw.SpriteCommand
    /* renamed from: c */
    public StringBuilder mo1131c() {
        return new StringBuilder();
    }
}
