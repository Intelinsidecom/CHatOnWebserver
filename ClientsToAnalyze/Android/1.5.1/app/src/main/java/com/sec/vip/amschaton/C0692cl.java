package com.sec.vip.amschaton;

import android.widget.PopupWindow;

/* renamed from: com.sec.vip.amschaton.cl */
/* loaded from: classes.dex */
class C0692cl implements PopupWindow.OnDismissListener {

    /* renamed from: a */
    final /* synthetic */ AMSComposerActivity f4314a;

    C0692cl(AMSComposerActivity aMSComposerActivity) {
        this.f4314a = aMSComposerActivity;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.f4314a.m3758a(false);
    }
}
