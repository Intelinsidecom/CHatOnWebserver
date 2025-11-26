package com.samsung.sdraw;

import android.graphics.RectF;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;

/* renamed from: com.samsung.sdraw.aq */
/* loaded from: classes.dex */
class C1004aq implements InterfaceC1070z {

    /* renamed from: a */
    protected AbstractSprite f1529a;

    public C1004aq(AbstractSprite abstractSprite) {
        this.f1529a = abstractSprite;
    }

    /* renamed from: a */
    public boolean m1378a(PointF pointF, PointF pointF2, PointF pointF3) {
        return ((pointF2.x - pointF.x) * (pointF3.y - pointF.y)) - ((pointF2.y - pointF.y) * (pointF3.x - pointF.x)) > VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
    }

    @Override // com.samsung.sdraw.InterfaceC1070z
    public boolean isHitted(RectF rect) {
        PointF pointF = new PointF();
        pointF.x = rect.left + 1.0f;
        pointF.y = rect.top + 1.0f;
        C0989ab c0989ab = (C0989ab) this.f1529a;
        return m1378a(c0989ab.m1263c(3), c0989ab.m1263c(2), pointF) & m1378a(c0989ab.m1263c(0), c0989ab.m1263c(1), pointF) & true & m1378a(c0989ab.m1263c(1), c0989ab.m1263c(3), pointF) & m1378a(c0989ab.m1263c(2), c0989ab.m1263c(0), pointF);
    }

    @Override // com.samsung.sdraw.InterfaceC1070z
    public boolean isHitted(PointF point) {
        return false;
    }
}
