package com.sec.vip.amschaton.ics;

import android.content.DialogInterface;
import android.content.res.Resources;
import com.sec.chaton.R;

/* compiled from: AMSComposerActivity.java */
/* renamed from: com.sec.vip.amschaton.ics.p */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2049p implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSComposerActivity f7343a;

    DialogInterfaceOnClickListenerC2049p(AMSComposerActivity aMSComposerActivity) {
        this.f7343a = aMSComposerActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) throws Resources.NotFoundException {
        this.f7343a.m6262a(R.string.ams_msg_deleted);
        dialogInterface.dismiss();
        this.f7343a.m6882B();
    }
}
