package com.samsung.sdraw;

import android.graphics.RectF;

/* renamed from: com.samsung.sdraw.ba */
/* loaded from: classes.dex */
class C1015ba implements InterfaceC1057m {

    /* renamed from: a */
    protected AbstractSprite f1553a;

    public C1015ba(AbstractSprite abstractSprite) {
        this.f1553a = abstractSprite;
    }

    @Override // com.samsung.sdraw.InterfaceC1057m
    public void moveBy(PointF point) {
        if (this.f1553a instanceof C0989ab) {
            ((C0989ab) this.f1553a).f1419f.offset(point.x, point.y);
        } else if (this.f1553a instanceof TextSprite) {
            ((TextSprite) this.f1553a).f1359d.offset(point.x, point.y);
        }
    }

    @Override // com.samsung.sdraw.InterfaceC1057m
    public void resizeTo(RectF rect) {
        if (this.f1553a instanceof C0989ab) {
            ((C0989ab) this.f1553a).f1418e = new PointF[]{new PointF(rect.left, rect.top), new PointF(rect.right, rect.top), new PointF(rect.left, rect.bottom), new PointF(rect.right, rect.bottom)};
        } else if (this.f1553a instanceof TextSprite) {
            moveTo(rect.left, rect.top);
        }
    }

    @Override // com.samsung.sdraw.InterfaceC1057m
    public void resizeTo(PointF[] resize) {
        if (this.f1553a instanceof C0989ab) {
            ((C0989ab) this.f1553a).f1418e = resize;
        }
    }

    @Override // com.samsung.sdraw.InterfaceC1057m
    public void moveTo(float x, float y) {
        if (this.f1553a instanceof C0989ab) {
            ((C0989ab) this.f1553a).m1253a(x, y);
            return;
        }
        if (this.f1553a instanceof TextSprite) {
            TextSprite textSprite = (TextSprite) this.f1553a;
            PointF pointF = new PointF(textSprite.f1359d);
            pointF.negate();
            textSprite.f1359d.offset(pointF.x, pointF.y);
            textSprite.f1359d.offset(x, y);
        }
    }

    @Override // com.samsung.sdraw.InterfaceC1057m
    public void rotateTo(float angle) {
        if (this.f1553a instanceof C0989ab) {
            ((C0989ab) this.f1553a).m1260b((int) angle);
        }
    }
}
