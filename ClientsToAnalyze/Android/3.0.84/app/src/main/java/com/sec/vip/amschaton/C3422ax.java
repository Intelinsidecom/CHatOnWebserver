package com.sec.vip.amschaton;

import android.widget.PopupWindow;

/* compiled from: AMSToolPopup.java */
/* renamed from: com.sec.vip.amschaton.ax */
/* loaded from: classes.dex */
class C3422ax implements PopupWindow.OnDismissListener {

    /* renamed from: a */
    final /* synthetic */ C3421aw f12536a;

    C3422ax(C3421aw c3421aw) {
        this.f12536a = c3421aw;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.f12536a.m12246i();
        if (this.f12536a.f12528f != null) {
            this.f12536a.f12528f.mo12247a();
        }
        if (this.f12536a.f12525c != null) {
            this.f12536a.f12525c.recycle();
            this.f12536a.f12525c = null;
        }
    }
}
