package com.sec.vip.amschaton.honeycomb;

import android.content.DialogInterface;
import com.sec.chaton.R;

/* compiled from: AMSComposerActivity.java */
/* renamed from: com.sec.vip.amschaton.honeycomb.v */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1463v implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f5111a;

    /* renamed from: b */
    final /* synthetic */ AMSComposerActivity f5112b;

    DialogInterfaceOnClickListenerC1463v(AMSComposerActivity aMSComposerActivity, int i) {
        this.f5112b = aMSComposerActivity;
        this.f5111a = i;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f5112b.m4738a(R.string.ams_msg_deleted);
        dialogInterface.dismiss();
        this.f5112b.m5072f(this.f5111a);
    }
}
