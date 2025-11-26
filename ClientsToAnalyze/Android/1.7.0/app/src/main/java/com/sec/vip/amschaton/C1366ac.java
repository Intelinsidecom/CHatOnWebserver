package com.sec.vip.amschaton;

import android.widget.PopupWindow;

/* compiled from: AMSToolPopup.java */
/* renamed from: com.sec.vip.amschaton.ac */
/* loaded from: classes.dex */
class C1366ac implements PopupWindow.OnDismissListener {

    /* renamed from: a */
    final /* synthetic */ C1560y f4789a;

    C1366ac(C1560y c1560y) {
        this.f4789a = c1560y;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.f4789a.m5653d();
        if (this.f4789a.f5417c != null) {
            this.f4789a.f5417c.recycle();
            this.f4789a.f5417c = null;
        }
    }
}
