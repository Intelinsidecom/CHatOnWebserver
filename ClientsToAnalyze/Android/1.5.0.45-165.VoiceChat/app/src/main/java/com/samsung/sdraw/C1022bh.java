package com.samsung.sdraw;

import android.graphics.RectF;
import java.util.LinkedList;

/* renamed from: com.samsung.sdraw.bh */
/* loaded from: classes.dex */
class C1022bh implements SpriteCommand {

    /* renamed from: a */
    protected AbstractSprite f1564a;

    /* renamed from: b */
    protected AbstractStage f1565b;

    /* renamed from: c */
    protected RectF f1566c;

    /* renamed from: d */
    protected RectF f1567d;

    /* renamed from: e */
    protected PointF[] f1568e;

    /* renamed from: f */
    protected PointF[] f1569f;

    public C1022bh(AbstractSprite abstractSprite, AbstractStage abstractStage) {
        this.f1564a = abstractSprite;
        this.f1565b = abstractStage;
    }

    /* renamed from: a */
    public void m1408a(PointF[] pointFArr, PointF[] pointFArr2) {
        this.f1568e = pointFArr;
        this.f1569f = pointFArr2;
    }

    @Override // com.samsung.sdraw.SpriteCommand
    /* renamed from: a */
    public RectF mo1129a() {
        ((ModeContext) this.f1565b.context).changeModeTo(this.f1564a.multiUserID, 3);
        this.f1564a.resizeTo(this.f1568e);
        LinkedList<AbstractSprite> linkedListM812a = this.f1565b.m812a(StrokeSprite.class, C1063s.class);
        LinkedList<AbstractSprite> linkedListM827b = this.f1565b.m827b(StrokeSprite.class, C1063s.class);
        LinkedList<AbstractSprite> linkedListM811a = this.f1565b.m811a(C0989ab.class);
        LinkedList<AbstractSprite> linkedListM826b = this.f1565b.m826b(C0989ab.class);
        LinkedList<AbstractSprite> linkedListM811a2 = this.f1565b.m811a(TextSprite.class);
        LinkedList<AbstractSprite> linkedListM826b2 = this.f1565b.m826b(TextSprite.class);
        this.f1565b.clearLayers();
        this.f1565b.renderFixedSprites(0);
        if (linkedListM811a != null) {
            this.f1565b.m818a(2, linkedListM811a, this.f1564a);
        }
        if (linkedListM811a2 != null) {
            this.f1565b.m817a(2, linkedListM811a2);
        }
        if (linkedListM812a != null) {
            this.f1565b.m817a(0, linkedListM812a);
        }
        this.f1565b.renderFixedSprites(3);
        if (linkedListM826b != null) {
            this.f1565b.m818a(4, linkedListM826b, this.f1564a);
        }
        if (linkedListM826b2 != null) {
            this.f1565b.m817a(4, linkedListM826b2);
        }
        if (linkedListM827b != null) {
            this.f1565b.m817a(3, linkedListM827b);
        }
        this.f1565b.renderSprite(1, this.f1564a);
        return this.f1564a.getBounds();
    }

    @Override // com.samsung.sdraw.SpriteCommand
    /* renamed from: b */
    public RectF mo1130b() {
        ((ModeContext) this.f1565b.context).changeModeTo(this.f1564a.multiUserID, 3);
        this.f1564a.resizeTo(this.f1569f);
        LinkedList<AbstractSprite> linkedListM812a = this.f1565b.m812a(StrokeSprite.class, C1063s.class);
        LinkedList<AbstractSprite> linkedListM827b = this.f1565b.m827b(StrokeSprite.class, C1063s.class);
        LinkedList<AbstractSprite> linkedListM811a = this.f1565b.m811a(C0989ab.class);
        LinkedList<AbstractSprite> linkedListM826b = this.f1565b.m826b(C0989ab.class);
        LinkedList<AbstractSprite> linkedListM811a2 = this.f1565b.m811a(TextSprite.class);
        LinkedList<AbstractSprite> linkedListM826b2 = this.f1565b.m826b(TextSprite.class);
        this.f1565b.clearLayers();
        this.f1565b.renderFixedSprites(0);
        if (linkedListM811a != null) {
            this.f1565b.m818a(2, linkedListM811a, this.f1564a);
        }
        if (linkedListM811a2 != null) {
            this.f1565b.m817a(2, linkedListM811a2);
        }
        if (linkedListM812a != null) {
            this.f1565b.m817a(0, linkedListM812a);
        }
        this.f1565b.renderFixedSprites(3);
        if (linkedListM826b != null) {
            this.f1565b.m818a(4, linkedListM826b, this.f1564a);
        }
        if (linkedListM826b2 != null) {
            this.f1565b.m817a(4, linkedListM826b2);
        }
        if (linkedListM827b != null) {
            this.f1565b.m817a(3, linkedListM827b);
        }
        this.f1565b.renderSprite(1, this.f1564a);
        return this.f1564a.getBounds();
    }

    @Override // com.samsung.sdraw.SpriteCommand
    /* renamed from: c */
    public StringBuilder mo1131c() {
        return new StringBuilder();
    }
}
