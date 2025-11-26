package com.sec.chaton.settings.tellfriends;

import android.content.DialogInterface;

/* compiled from: InviteFacebookActivity.java */
/* renamed from: com.sec.chaton.settings.tellfriends.o */
/* loaded from: classes.dex */
class DialogInterfaceOnCancelListenerC1466o implements DialogInterface.OnCancelListener {

    /* renamed from: a */
    final /* synthetic */ InviteFacebookActivity f5374a;

    DialogInterfaceOnCancelListenerC1466o(InviteFacebookActivity inviteFacebookActivity) {
        this.f5374a = inviteFacebookActivity;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f5374a.f4959p = true;
        InviteFacebookActivity.f4943a.m5119a();
        this.f5374a.finish();
    }
}
