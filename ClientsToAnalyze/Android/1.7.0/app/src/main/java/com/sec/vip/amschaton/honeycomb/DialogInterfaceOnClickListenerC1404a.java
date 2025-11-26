package com.sec.vip.amschaton.honeycomb;

import android.content.DialogInterface;
import android.content.res.Resources;

/* compiled from: AMSComposerActivity.java */
/* renamed from: com.sec.vip.amschaton.honeycomb.a */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1404a implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSComposerActivity f5032a;

    DialogInterfaceOnClickListenerC1404a(AMSComposerActivity aMSComposerActivity) {
        this.f5032a = aMSComposerActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) throws Resources.NotFoundException {
        this.f5032a.m5085i();
        dialogInterface.dismiss();
        this.f5032a.m5119y();
    }
}
