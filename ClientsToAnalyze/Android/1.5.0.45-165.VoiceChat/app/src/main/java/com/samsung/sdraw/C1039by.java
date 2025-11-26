package com.samsung.sdraw;

import android.graphics.RectF;
import android.text.Editable;
import android.text.Layout;
import java.util.LinkedList;

/* renamed from: com.samsung.sdraw.by */
/* loaded from: classes.dex */
class C1039by implements SpriteCommand {

    /* renamed from: a */
    protected Editable f1659a;

    /* renamed from: b */
    protected Editable f1660b;

    /* renamed from: c */
    protected PointF f1661c;

    /* renamed from: d */
    protected PointF f1662d;

    /* renamed from: e */
    protected int f1663e;

    /* renamed from: f */
    protected int f1664f;

    /* renamed from: g */
    protected int f1665g;

    /* renamed from: h */
    protected int f1666h;

    /* renamed from: i */
    protected Layout.Alignment f1667i;

    /* renamed from: j */
    protected Layout.Alignment f1668j;

    /* renamed from: k */
    public TextSprite f1669k;

    /* renamed from: l */
    public AbstractStage f1670l;

    public C1039by(TextSprite textSprite, AbstractStage abstractStage, Editable editable, Editable editable2, PointF pointF, PointF pointF2, int i, int i2, int i3, int i4, Layout.Alignment alignment, Layout.Alignment alignment2) {
        this.f1669k = textSprite;
        this.f1670l = abstractStage;
        this.f1659a = editable;
        this.f1661c = new PointF(pointF);
        this.f1663e = i;
        this.f1665g = i3;
        this.f1660b = editable2;
        this.f1662d = new PointF(pointF2);
        this.f1664f = i2;
        this.f1666h = i4;
        this.f1667i = alignment;
        this.f1668j = alignment2;
    }

    @Override // com.samsung.sdraw.SpriteCommand
    /* renamed from: a */
    public RectF mo1129a() {
        ((ModeContext) this.f1670l.context).changeModeTo(this.f1669k.multiUserID, 4);
        RectF rectF = new RectF(this.f1669k.getBounds());
        this.f1669k.m1194a(this.f1660b, this.f1662d, this.f1664f, this.f1666h, this.f1668j);
        this.f1670l.clearLayer(this.f1669k.getLayerID());
        if (this.f1669k.getLayerID() == 4) {
            LinkedList<AbstractSprite> linkedListM826b = this.f1670l.m826b(TextSprite.class);
            LinkedList<AbstractSprite> linkedListM826b2 = this.f1670l.m826b(C0989ab.class);
            if (linkedListM826b2 != null) {
                this.f1670l.m817a(4, linkedListM826b2);
            }
            if (linkedListM826b != null) {
                this.f1670l.m817a(4, linkedListM826b);
            }
        } else {
            LinkedList<AbstractSprite> linkedListM811a = this.f1670l.m811a(TextSprite.class);
            LinkedList<AbstractSprite> linkedListM811a2 = this.f1670l.m811a(C0989ab.class);
            if (linkedListM811a2 != null) {
                this.f1670l.m817a(2, linkedListM811a2);
            }
            if (linkedListM811a != null) {
                this.f1670l.m817a(2, linkedListM811a);
            }
        }
        rectF.union(this.f1669k.getBounds());
        return rectF;
    }

    @Override // com.samsung.sdraw.SpriteCommand
    /* renamed from: b */
    public RectF mo1130b() {
        ((ModeContext) this.f1670l.context).changeModeTo(this.f1669k.multiUserID, 4);
        RectF rectF = new RectF(this.f1669k.getBounds());
        this.f1669k.m1194a(this.f1659a, this.f1661c, this.f1663e, this.f1665g, this.f1667i);
        this.f1670l.clearLayer(this.f1669k.getLayerID());
        if (this.f1669k.getLayerID() == 4) {
            LinkedList<AbstractSprite> linkedListM826b = this.f1670l.m826b(TextSprite.class);
            LinkedList<AbstractSprite> linkedListM826b2 = this.f1670l.m826b(C0989ab.class);
            if (linkedListM826b2 != null) {
                this.f1670l.m817a(4, linkedListM826b2);
            }
            if (linkedListM826b != null) {
                this.f1670l.m817a(4, linkedListM826b);
            }
        } else {
            LinkedList<AbstractSprite> linkedListM811a = this.f1670l.m811a(TextSprite.class);
            LinkedList<AbstractSprite> linkedListM811a2 = this.f1670l.m811a(C0989ab.class);
            if (linkedListM811a2 != null) {
                this.f1670l.m817a(2, linkedListM811a2);
            }
            if (linkedListM811a != null) {
                this.f1670l.m817a(2, linkedListM811a);
            }
        }
        rectF.union(this.f1669k.getBounds());
        return rectF;
    }

    @Override // com.samsung.sdraw.SpriteCommand
    /* renamed from: c */
    public StringBuilder mo1131c() {
        return null;
    }
}
