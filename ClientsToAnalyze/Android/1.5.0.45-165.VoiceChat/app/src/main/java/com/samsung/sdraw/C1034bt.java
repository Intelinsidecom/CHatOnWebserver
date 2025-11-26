package com.samsung.sdraw;

import android.graphics.RectF;

/* renamed from: com.samsung.sdraw.bt */
/* loaded from: classes.dex */
class C1034bt implements InterfaceC1057m {

    /* renamed from: a */
    private TextSprite f1590a;

    public C1034bt(TextSprite textSprite) {
        this.f1590a = textSprite;
    }

    @Override // com.samsung.sdraw.InterfaceC1057m
    public void moveBy(PointF point) {
        this.f1590a.f1359d.offset(point.x, point.y);
    }

    @Override // com.samsung.sdraw.InterfaceC1057m
    public void resizeTo(RectF rect) {
        this.f1590a.m1194a(this.f1590a.m1201h(), this.f1590a.f1359d, (int) rect.width(), (int) rect.height(), this.f1590a.m1196c().getAlignment());
    }

    @Override // com.samsung.sdraw.InterfaceC1057m
    public void moveTo(float x, float y) {
        TextSprite textSprite = this.f1590a;
        PointF pointF = new PointF(textSprite.f1359d);
        pointF.negate();
        textSprite.f1359d.offset(pointF.x, pointF.y);
        textSprite.f1359d.offset(x, y);
    }

    @Override // com.samsung.sdraw.InterfaceC1057m
    public void rotateTo(float angle) {
    }

    @Override // com.samsung.sdraw.InterfaceC1057m
    public void resizeTo(PointF[] resize) {
    }
}
