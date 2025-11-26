package com.sec.vip.amschaton;

import android.widget.PopupWindow;

/* compiled from: AMSToolPopup.java */
/* renamed from: com.sec.vip.amschaton.au */
/* loaded from: classes.dex */
class C1861au implements PopupWindow.OnDismissListener {

    /* renamed from: a */
    final /* synthetic */ C1860at f6822a;

    C1861au(C1860at c1860at) {
        this.f6822a = c1860at;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.f6822a.m6446h();
        if (this.f6822a.f6814c != null) {
            this.f6822a.f6814c.recycle();
            this.f6822a.f6814c = null;
        }
    }
}
