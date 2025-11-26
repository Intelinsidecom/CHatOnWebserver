package com.sec.vip.amschaton.ics;

import android.content.DialogInterface;
import com.sec.chaton.R;

/* compiled from: AMSComposerActivity.java */
/* renamed from: com.sec.vip.amschaton.ics.ag */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1476ag implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSComposerActivity f5287a;

    DialogInterfaceOnClickListenerC1476ag(AMSComposerActivity aMSComposerActivity) {
        this.f5287a = aMSComposerActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f5287a.m4738a(R.string.ams_msg_deleted);
        dialogInterface.dismiss();
        this.f5287a.m5390h();
    }
}
