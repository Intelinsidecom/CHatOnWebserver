package com.samsung.sdraw;

import android.graphics.RectF;
import java.util.LinkedList;

/* renamed from: com.samsung.sdraw.ac */
/* loaded from: classes.dex */
class C0990ac implements SpriteCommand {

    /* renamed from: a */
    public C0989ab f1432a;

    /* renamed from: b */
    public AbstractStage f1433b;

    /* renamed from: c */
    protected RectF f1434c;

    /* renamed from: d */
    protected RectF f1435d;

    /* renamed from: e */
    protected float f1436e;

    /* renamed from: f */
    protected float f1437f;

    public C0990ac(C0989ab c0989ab, AbstractStage abstractStage, RectF rectF, RectF rectF2, int i, int i2) {
        this.f1432a = c0989ab;
        this.f1433b = abstractStage;
        this.f1434c = rectF;
        this.f1435d = rectF2;
        this.f1436e = i;
        this.f1437f = i2;
    }

    @Override // com.samsung.sdraw.SpriteCommand
    /* renamed from: a */
    public RectF mo1129a() {
        ((ModeContext) this.f1433b.context).changeModeTo(this.f1432a.multiUserID, 3);
        this.f1432a.m1255a(0);
        this.f1432a.resizeTo(this.f1435d);
        this.f1432a.rotateTo(this.f1436e);
        RectF rectF = new RectF(this.f1432a.getBounds());
        LinkedList<AbstractSprite> linkedListM812a = this.f1433b.m812a(StrokeSprite.class, C1063s.class);
        LinkedList<AbstractSprite> linkedListM827b = this.f1433b.m827b(StrokeSprite.class, C1063s.class);
        LinkedList<AbstractSprite> linkedListM811a = this.f1433b.m811a(C0989ab.class);
        LinkedList<AbstractSprite> linkedListM826b = this.f1433b.m826b(C0989ab.class);
        LinkedList<AbstractSprite> linkedListM811a2 = this.f1433b.m811a(TextSprite.class);
        LinkedList<AbstractSprite> linkedListM826b2 = this.f1433b.m826b(TextSprite.class);
        this.f1433b.clearLayers();
        this.f1433b.renderFixedSprites(0);
        if (linkedListM811a != null) {
            this.f1433b.m817a(2, linkedListM811a);
        }
        if (linkedListM811a2 != null) {
            this.f1433b.m817a(2, linkedListM811a2);
        }
        if (linkedListM812a != null) {
            this.f1433b.m817a(0, linkedListM812a);
        }
        this.f1433b.renderFixedSprites(3);
        if (linkedListM826b != null) {
            this.f1433b.m817a(4, linkedListM826b);
        }
        if (linkedListM826b2 != null) {
            this.f1433b.m817a(4, linkedListM826b2);
        }
        if (linkedListM827b != null) {
            this.f1433b.m817a(3, linkedListM827b);
        }
        this.f1433b.renderSprite(1, this.f1432a);
        rectF.union(this.f1432a.getBounds());
        return rectF;
    }

    @Override // com.samsung.sdraw.SpriteCommand
    /* renamed from: b */
    public RectF mo1130b() {
        ((ModeContext) this.f1433b.context).changeModeTo(this.f1432a.multiUserID, 3);
        this.f1432a.m1255a(0);
        this.f1432a.resizeTo(this.f1434c);
        this.f1432a.rotateTo(this.f1437f);
        RectF rectF = new RectF(this.f1432a.getBounds());
        LinkedList<AbstractSprite> linkedListM812a = this.f1433b.m812a(StrokeSprite.class, C1063s.class);
        LinkedList<AbstractSprite> linkedListM827b = this.f1433b.m827b(StrokeSprite.class, C1063s.class);
        LinkedList<AbstractSprite> linkedListM811a = this.f1433b.m811a(C0989ab.class);
        LinkedList<AbstractSprite> linkedListM826b = this.f1433b.m826b(C0989ab.class);
        LinkedList<AbstractSprite> linkedListM811a2 = this.f1433b.m811a(TextSprite.class);
        LinkedList<AbstractSprite> linkedListM826b2 = this.f1433b.m826b(TextSprite.class);
        this.f1433b.clearLayers();
        this.f1433b.renderFixedSprites(0);
        if (linkedListM811a != null) {
            this.f1433b.m817a(2, linkedListM811a);
        }
        if (linkedListM811a2 != null) {
            this.f1433b.m817a(2, linkedListM811a2);
        }
        if (linkedListM812a != null) {
            this.f1433b.m817a(0, linkedListM812a);
        }
        this.f1433b.renderFixedSprites(3);
        if (linkedListM826b != null) {
            this.f1433b.m817a(4, linkedListM826b);
        }
        if (linkedListM826b2 != null) {
            this.f1433b.m817a(4, linkedListM826b2);
        }
        if (linkedListM827b != null) {
            this.f1433b.m817a(3, linkedListM827b);
        }
        this.f1433b.renderSprite(1, this.f1432a);
        rectF.union(this.f1432a.getBounds());
        return rectF;
    }

    @Override // com.samsung.sdraw.SpriteCommand
    /* renamed from: c */
    public StringBuilder mo1131c() {
        return new StringBuilder();
    }
}
