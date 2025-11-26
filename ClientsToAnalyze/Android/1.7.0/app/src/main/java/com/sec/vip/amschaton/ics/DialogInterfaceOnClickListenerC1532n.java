package com.sec.vip.amschaton.ics;

import android.content.DialogInterface;

/* compiled from: AMSComposerActivity.java */
/* renamed from: com.sec.vip.amschaton.ics.n */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1532n implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSComposerActivity f5360a;

    DialogInterfaceOnClickListenerC1532n(AMSComposerActivity aMSComposerActivity) {
        this.f5360a = aMSComposerActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) throws Throwable {
        AMSComposerActivity.f5178a = false;
        switch (i) {
            case 1:
                String strM5332A = this.f5360a.m5332A();
                if (strM5332A != null) {
                    this.f5360a.m5370d(false);
                    this.f5360a.m5355a(strM5332A, false);
                    break;
                }
                break;
            default:
                String strM5370d = this.f5360a.m5370d(true);
                if (strM5370d != null) {
                    this.f5360a.m5355a(strM5370d, true);
                    break;
                }
                break;
        }
    }
}
