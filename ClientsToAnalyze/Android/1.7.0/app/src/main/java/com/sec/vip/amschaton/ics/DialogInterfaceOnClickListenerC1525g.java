package com.sec.vip.amschaton.ics;

import android.content.DialogInterface;
import android.content.res.Resources;
import com.sec.chaton.R;

/* compiled from: AMSComposerActivity.java */
/* renamed from: com.sec.vip.amschaton.ics.g */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1525g implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSComposerActivity f5353a;

    DialogInterfaceOnClickListenerC1525g(AMSComposerActivity aMSComposerActivity) {
        this.f5353a = aMSComposerActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) throws Resources.NotFoundException {
        this.f5353a.m4738a(R.string.ams_msg_deleted);
        dialogInterface.dismiss();
        this.f5353a.m5435y();
    }
}
