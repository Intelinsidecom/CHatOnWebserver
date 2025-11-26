package com.sec.vip.amschaton;

import android.content.DialogInterface;

/* renamed from: com.sec.vip.amschaton.co */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0695co implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSComposerActivity f4317a;

    DialogInterfaceOnClickListenerC0695co(AMSComposerActivity aMSComposerActivity) {
        this.f4317a = aMSComposerActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) throws Throwable {
        switch (this.f4317a.f3855ae) {
            case 1:
                this.f4317a.m3734F();
                break;
            default:
                this.f4317a.m3731E();
                break;
        }
    }
}
