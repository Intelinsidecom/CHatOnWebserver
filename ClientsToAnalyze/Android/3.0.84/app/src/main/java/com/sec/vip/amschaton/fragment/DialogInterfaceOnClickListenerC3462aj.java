package com.sec.vip.amschaton.fragment;

import android.content.DialogInterface;
import com.sec.chaton.R;

/* compiled from: AMSComposerFragment.java */
/* renamed from: com.sec.vip.amschaton.fragment.aj */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3462aj implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AMSComposerFragment f12822a;

    DialogInterfaceOnClickListenerC3462aj(AMSComposerFragment aMSComposerFragment) {
        this.f12822a = aMSComposerFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (!this.f12822a.f12676X) {
            this.f12822a.m12524a(R.string.ams_msg_deleted);
        }
        this.f12822a.f12677Y = true;
        dialogInterface.dismiss();
        super/*com.sec.vip.amschaton.fragment.AMSFragment*/.mo12415c();
    }
}
