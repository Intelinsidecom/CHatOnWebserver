package com.sec.vip.amschaton.honeycomb;

import android.content.DialogInterface;
import com.sec.chaton.R;

/* compiled from: AMSComposerActivity.java */
/* renamed from: com.sec.vip.amschaton.honeycomb.aa */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1405aa implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSComposerActivity f5033a;

    DialogInterfaceOnClickListenerC1405aa(AMSComposerActivity aMSComposerActivity) {
        this.f5033a = aMSComposerActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f5033a.m4738a(R.string.ams_msg_deleted);
        dialogInterface.dismiss();
        this.f5033a.m5082h();
    }
}
