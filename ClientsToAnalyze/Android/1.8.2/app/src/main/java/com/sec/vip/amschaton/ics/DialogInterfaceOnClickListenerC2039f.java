package com.sec.vip.amschaton.ics;

import android.content.DialogInterface;
import com.sec.chaton.R;

/* compiled from: AMSComposerActivity.java */
/* renamed from: com.sec.vip.amschaton.ics.f */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2039f implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSComposerActivity f7330a;

    DialogInterfaceOnClickListenerC2039f(AMSComposerActivity aMSComposerActivity) {
        this.f7330a = aMSComposerActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f7330a.m6262a(R.string.ams_msg_deleted);
        dialogInterface.dismiss();
        this.f7330a.f7152M = true;
        this.f7330a.m6946h();
    }
}
