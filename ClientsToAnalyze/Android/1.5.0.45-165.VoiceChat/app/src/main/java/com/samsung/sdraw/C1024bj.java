package com.samsung.sdraw;

import android.graphics.Path;

/* renamed from: com.samsung.sdraw.bj */
/* loaded from: classes.dex */
class C1024bj implements InterfaceC1026bl {
    C1024bj() {
    }

    @Override // com.samsung.sdraw.InterfaceC1026bl
    /* renamed from: a */
    public void mo1395a(StrokeSprite strokeSprite, Path path, C1043cb c1043cb) {
        path.moveTo(c1043cb.x, c1043cb.y);
        if (strokeSprite.m1156d().size() == 1) {
            path.addRect(c1043cb.x - c1043cb.f1688h, c1043cb.y - c1043cb.f1688h, c1043cb.f1688h + c1043cb.x, c1043cb.f1688h + c1043cb.y, Path.Direction.CW);
        }
    }
}
