package com.sec.vip.amschaton.honeycomb;

import android.content.DialogInterface;

/* compiled from: AMSComposerActivity.java */
/* renamed from: com.sec.vip.amschaton.honeycomb.f */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1447f implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSComposerActivity f5086a;

    DialogInterfaceOnClickListenerC1447f(AMSComposerActivity aMSComposerActivity) {
        this.f5086a = aMSComposerActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) throws Throwable {
        AMSComposerActivity.f4934a = false;
        switch (i) {
            case 1:
                String strM5028A = this.f5086a.m5028A();
                if (strM5028A != null) {
                    this.f5086a.m5059c(false);
                    this.f5086a.m5049a(strM5028A, false);
                    break;
                }
                break;
            default:
                String strM5059c = this.f5086a.m5059c(true);
                if (strM5059c != null) {
                    this.f5086a.m5049a(strM5059c, true);
                    break;
                }
                break;
        }
    }
}
