package com.samsung.sdraw;

import android.graphics.Path;
import java.util.Vector;

/* renamed from: com.samsung.sdraw.aw */
/* loaded from: classes.dex */
class C1010aw implements InterfaceC1029bo {
    C1010aw() {
    }

    @Override // com.samsung.sdraw.InterfaceC1029bo
    /* renamed from: a */
    public boolean mo1204a(StrokeSprite strokeSprite, int i, Path path, C1043cb c1043cb) {
        C1043cb c1043cb2 = strokeSprite.m1156d().get(Math.max(0, Math.min(strokeSprite.m1156d().size() - 1, i)));
        Vector<C1053i> vectorM1158e = strokeSprite.m1158e();
        int size = vectorM1158e.size();
        if (size >= 4) {
            C1053i c1053i = vectorM1158e.get(size - 4);
            C1053i c1053i2 = vectorM1158e.get(size - 3);
            C1053i c1053i3 = vectorM1158e.get(size - 2);
            boolean zIsClockWise = PointF.isClockWise(c1053i.f1744a, c1053i.f1745b, c1053i2.f1744a, c1053i2.f1745b);
            boolean zIsClockWise2 = PointF.isClockWise(c1053i2.f1744a, c1053i2.f1745b, c1053i3.f1744a, c1053i3.f1745b);
            boolean zM1421a = strokeSprite.m1153c().m1421a();
            if (c1043cb == null || !zM1421a || strokeSprite.m1153c().getAlpha() != 255 || zIsClockWise != zIsClockWise2 || Math.abs(c1043cb2.f1685e - c1043cb.f1685e) > 5.0f || Math.abs(c1043cb2.f1686f - c1043cb.f1686f) > 5.0f || Math.abs(c1043cb2.f1683c - c1043cb.f1683c) > 5.0f || Math.abs(c1043cb2.f1684d - c1043cb.f1684d) > 5.0f) {
                path.addCircle(c1043cb2.x, c1043cb2.y, c1043cb2.f1688h, Path.Direction.CW);
                return true;
            }
            path.moveTo(c1043cb.f1685e, c1043cb.f1686f);
            path.lineTo(c1043cb.f1683c, c1043cb.f1684d);
        }
        return false;
    }
}
