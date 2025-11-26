package com.sec.chaton.calllog.common.view.swipe;

import android.view.MotionEvent;

/* compiled from: SwipeLayout.java */
/* renamed from: com.sec.chaton.calllog.common.view.swipe.c */
/* loaded from: classes.dex */
class C1445c implements InterfaceC1444b {

    /* renamed from: a */
    final /* synthetic */ SwipeLayout f5167a;

    /* renamed from: b */
    private boolean f5168b;

    private C1445c(SwipeLayout swipeLayout) {
        this.f5167a = swipeLayout;
        this.f5168b = false;
    }

    @Override // com.sec.chaton.calllog.common.view.swipe.InterfaceC1444b
    /* renamed from: a */
    public boolean mo7572a(MotionEvent motionEvent) {
        if (this.f5168b) {
            return false;
        }
        if (this.f5167a.f5151e != 2) {
            this.f5167a.f5151e = 0;
            this.f5167a.f5152f.sendEmptyMessageDelayed(2, 100L);
            if (this.f5167a.f5147a == null) {
                return false;
            }
            this.f5167a.f5147a.mo7543a((InterfaceC1444b) null);
            return false;
        }
        return this.f5167a.onTouchEvent(motionEvent);
    }
}
