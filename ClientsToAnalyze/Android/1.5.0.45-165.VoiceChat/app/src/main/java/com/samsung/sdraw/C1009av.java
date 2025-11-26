package com.samsung.sdraw;

import android.graphics.Path;

/* renamed from: com.samsung.sdraw.av */
/* loaded from: classes.dex */
class C1009av implements InterfaceC1026bl {
    C1009av() {
    }

    @Override // com.samsung.sdraw.InterfaceC1026bl
    /* renamed from: a */
    public void mo1395a(StrokeSprite strokeSprite, Path path, C1043cb c1043cb) {
        path.moveTo(c1043cb.x, c1043cb.y);
        path.addCircle(c1043cb.x, c1043cb.y, c1043cb.f1688h, Path.Direction.CW);
    }
}
