package com.sec.vip.amschaton.ics;

import android.content.DialogInterface;
import com.sec.chaton.R;

/* compiled from: AMSComposerActivity.java */
/* renamed from: com.sec.vip.amschaton.ics.h */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2041h implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f7333a;

    /* renamed from: b */
    final /* synthetic */ AMSComposerActivity f7334b;

    DialogInterfaceOnClickListenerC2041h(AMSComposerActivity aMSComposerActivity, int i) {
        this.f7334b = aMSComposerActivity;
        this.f7333a = i;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f7334b.m6262a(R.string.ams_msg_deleted);
        dialogInterface.dismiss();
        this.f7334b.m6973n(this.f7333a);
    }
}
