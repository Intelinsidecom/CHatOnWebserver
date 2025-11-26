package com.samsung.sdraw;

import android.graphics.RectF;
import java.util.LinkedList;

/* renamed from: com.samsung.sdraw.bi */
/* loaded from: classes.dex */
class C1023bi implements SpriteCommand {

    /* renamed from: a */
    protected AbstractSprite f1570a;

    /* renamed from: b */
    protected AbstractStage f1571b;

    /* renamed from: c */
    protected float f1572c;

    /* renamed from: d */
    protected float f1573d;

    public C1023bi(AbstractSprite abstractSprite, AbstractStage abstractStage) {
        this.f1570a = abstractSprite;
        this.f1571b = abstractStage;
    }

    /* renamed from: a */
    public void m1409a(float f, float f2) {
        this.f1572c = f2;
        this.f1573d = f;
    }

    @Override // com.samsung.sdraw.SpriteCommand
    /* renamed from: a */
    public RectF mo1129a() {
        ((ModeContext) this.f1571b.context).changeModeTo(this.f1570a.multiUserID, 3);
        this.f1570a.rotateTo(this.f1573d - this.f1572c);
        LinkedList<AbstractSprite> linkedListM812a = this.f1571b.m812a(StrokeSprite.class, C1063s.class);
        LinkedList<AbstractSprite> linkedListM827b = this.f1571b.m827b(StrokeSprite.class, C1063s.class);
        LinkedList<AbstractSprite> linkedListM811a = this.f1571b.m811a(C0989ab.class);
        LinkedList<AbstractSprite> linkedListM826b = this.f1571b.m826b(C0989ab.class);
        LinkedList<AbstractSprite> linkedListM811a2 = this.f1571b.m811a(TextSprite.class);
        LinkedList<AbstractSprite> linkedListM826b2 = this.f1571b.m826b(TextSprite.class);
        this.f1571b.clearLayers();
        this.f1571b.renderFixedSprites(0);
        if (linkedListM811a != null) {
            this.f1571b.m818a(2, linkedListM811a, this.f1570a);
        }
        if (linkedListM811a2 != null) {
            this.f1571b.m817a(2, linkedListM811a2);
        }
        if (linkedListM812a != null) {
            this.f1571b.m817a(0, linkedListM812a);
        }
        this.f1571b.renderFixedSprites(3);
        if (linkedListM826b != null) {
            this.f1571b.m818a(4, linkedListM826b, this.f1570a);
        }
        if (linkedListM826b2 != null) {
            this.f1571b.m817a(4, linkedListM826b2);
        }
        if (linkedListM827b != null) {
            this.f1571b.m817a(3, linkedListM827b);
        }
        this.f1571b.renderSprite(1, this.f1570a);
        return this.f1570a.getBounds();
    }

    @Override // com.samsung.sdraw.SpriteCommand
    /* renamed from: b */
    public RectF mo1130b() {
        ((ModeContext) this.f1571b.context).changeModeTo(this.f1570a.multiUserID, 3);
        this.f1570a.rotateTo(this.f1572c - this.f1573d);
        LinkedList<AbstractSprite> linkedListM812a = this.f1571b.m812a(StrokeSprite.class, C1063s.class);
        LinkedList<AbstractSprite> linkedListM827b = this.f1571b.m827b(StrokeSprite.class, C1063s.class);
        LinkedList<AbstractSprite> linkedListM811a = this.f1571b.m811a(C0989ab.class);
        LinkedList<AbstractSprite> linkedListM826b = this.f1571b.m826b(C0989ab.class);
        LinkedList<AbstractSprite> linkedListM811a2 = this.f1571b.m811a(TextSprite.class);
        LinkedList<AbstractSprite> linkedListM826b2 = this.f1571b.m826b(TextSprite.class);
        this.f1571b.clearLayers();
        this.f1571b.renderFixedSprites(0);
        if (linkedListM811a != null) {
            this.f1571b.m818a(2, linkedListM811a, this.f1570a);
        }
        if (linkedListM811a2 != null) {
            this.f1571b.m817a(2, linkedListM811a2);
        }
        if (linkedListM812a != null) {
            this.f1571b.m817a(0, linkedListM812a);
        }
        this.f1571b.renderFixedSprites(3);
        if (linkedListM826b != null) {
            this.f1571b.m818a(4, linkedListM826b, this.f1570a);
        }
        if (linkedListM826b2 != null) {
            this.f1571b.m817a(4, linkedListM826b2);
        }
        if (linkedListM827b != null) {
            this.f1571b.m817a(3, linkedListM827b);
        }
        this.f1571b.renderSprite(1, this.f1570a);
        return this.f1570a.getBounds();
    }

    @Override // com.samsung.sdraw.SpriteCommand
    /* renamed from: c */
    public StringBuilder mo1131c() {
        return new StringBuilder();
    }
}
