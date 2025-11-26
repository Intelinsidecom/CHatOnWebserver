package com.sec.vip.amschaton.honeycomb;

import android.content.DialogInterface;
import com.sec.chaton.R;

/* compiled from: AMSComposerActivity.java */
/* renamed from: com.sec.vip.amschaton.honeycomb.p */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1965p implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSComposerActivity f7112a;

    DialogInterfaceOnClickListenerC1965p(AMSComposerActivity aMSComposerActivity) {
        this.f7112a = aMSComposerActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f7112a.m6262a(R.string.ams_msg_deleted);
        this.f7112a.f6934W = true;
        dialogInterface.dismiss();
        this.f7112a.m6615h();
    }
}
