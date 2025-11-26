package com.sec.vip.amschaton.honeycomb;

import android.content.DialogInterface;
import com.sec.chaton.R;

/* compiled from: AMSComposerActivity.java */
/* renamed from: com.sec.vip.amschaton.honeycomb.y */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1974y implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f7125a;

    /* renamed from: b */
    final /* synthetic */ AMSComposerActivity f7126b;

    DialogInterfaceOnClickListenerC1974y(AMSComposerActivity aMSComposerActivity, int i) {
        this.f7126b = aMSComposerActivity;
        this.f7125a = i;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f7126b.m6262a(R.string.ams_msg_deleted);
        dialogInterface.dismiss();
        this.f7126b.m6608g(this.f7125a);
    }
}
