package com.sec.chaton.calllog.common.view.swipe;

import android.view.MotionEvent;

/* compiled from: SwipeLayout.java */
/* renamed from: com.sec.chaton.calllog.common.view.swipe.c */
/* loaded from: classes.dex */
class C0834c implements InterfaceC0833b {

    /* renamed from: a */
    final /* synthetic */ SwipeLayout f3197a;

    /* renamed from: b */
    private boolean f3198b;

    private C0834c(SwipeLayout swipeLayout) {
        this.f3197a = swipeLayout;
        this.f3198b = false;
    }

    @Override // com.sec.chaton.calllog.common.view.swipe.InterfaceC0833b
    /* renamed from: a */
    public boolean mo4418a(MotionEvent motionEvent) {
        if (this.f3198b) {
            return false;
        }
        if (this.f3197a.f3181e != 2) {
            this.f3197a.f3181e = 0;
            this.f3197a.f3182f.sendEmptyMessageDelayed(2, 100L);
            if (this.f3197a.f3177a == null) {
                return false;
            }
            this.f3197a.f3177a.mo4389a((InterfaceC0833b) null);
            return false;
        }
        return this.f3197a.onTouchEvent(motionEvent);
    }
}
