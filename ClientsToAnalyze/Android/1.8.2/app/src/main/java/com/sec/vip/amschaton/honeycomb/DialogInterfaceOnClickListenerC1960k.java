package com.sec.vip.amschaton.honeycomb;

import android.content.DialogInterface;
import android.content.res.Resources;
import com.sec.chaton.R;

/* compiled from: AMSComposerActivity.java */
/* renamed from: com.sec.vip.amschaton.honeycomb.k */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1960k implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSComposerActivity f7107a;

    DialogInterfaceOnClickListenerC1960k(AMSComposerActivity aMSComposerActivity) {
        this.f7107a = aMSComposerActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) throws Resources.NotFoundException {
        this.f7107a.m6262a(R.string.ams_msg_deleted);
        dialogInterface.dismiss();
        this.f7107a.m6659x();
    }
}
