package com.sec.vip.amschaton;

import android.content.DialogInterface;
import java.io.IOException;

/* renamed from: com.sec.vip.amschaton.ct */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0700ct implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSComposerActivity f4322a;

    DialogInterfaceOnClickListenerC0700ct(AMSComposerActivity aMSComposerActivity) {
        this.f4322a = aMSComposerActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) throws IOException {
        this.f4322a.m3793n();
        dialogInterface.dismiss();
    }
}
