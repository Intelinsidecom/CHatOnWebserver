package com.sec.vip.amschaton.ics;

import android.content.DialogInterface;
import com.sec.chaton.R;

/* compiled from: AMSComposerActivity.java */
/* renamed from: com.sec.vip.amschaton.ics.ae */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1474ae implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f5283a;

    /* renamed from: b */
    final /* synthetic */ AMSComposerActivity f5284b;

    DialogInterfaceOnClickListenerC1474ae(AMSComposerActivity aMSComposerActivity, int i) {
        this.f5284b = aMSComposerActivity;
        this.f5283a = i;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f5284b.m4738a(R.string.ams_msg_deleted);
        dialogInterface.dismiss();
        this.f5284b.m5379f(this.f5283a);
    }
}
