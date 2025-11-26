package com.samsung.sdraw;

import android.graphics.RectF;

/* renamed from: com.samsung.sdraw.bb */
/* loaded from: classes.dex */
class C1016bb implements InterfaceC1070z {

    /* renamed from: a */
    protected AbstractSprite f1554a;

    public C1016bb(AbstractSprite abstractSprite) {
        this.f1554a = abstractSprite;
    }

    @Override // com.samsung.sdraw.InterfaceC1070z
    public boolean isHitted(RectF rect) {
        RectF bounds = this.f1554a.getBounds();
        return this.f1554a.f830a && rect.left <= bounds.right && rect.right >= bounds.left && rect.top <= bounds.bottom && rect.bottom >= bounds.top;
    }

    @Override // com.samsung.sdraw.InterfaceC1070z
    public boolean isHitted(PointF point) {
        return this.f1554a.isVisible() && this.f1554a.mo1136a().contains(point.x, point.y);
    }
}
