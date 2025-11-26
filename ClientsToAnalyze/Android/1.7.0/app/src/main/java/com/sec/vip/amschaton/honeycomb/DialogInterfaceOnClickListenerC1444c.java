package com.sec.vip.amschaton.honeycomb;

import android.content.DialogInterface;
import android.content.res.Resources;
import com.sec.chaton.R;

/* compiled from: AMSComposerActivity.java */
/* renamed from: com.sec.vip.amschaton.honeycomb.c */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1444c implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSComposerActivity f5083a;

    DialogInterfaceOnClickListenerC1444c(AMSComposerActivity aMSComposerActivity) {
        this.f5083a = aMSComposerActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) throws Resources.NotFoundException {
        this.f5083a.m4738a(R.string.ams_msg_deleted);
        dialogInterface.dismiss();
        this.f5083a.m5119y();
    }
}
