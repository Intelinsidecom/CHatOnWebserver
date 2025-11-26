package com.sec.chaton.facebook;

import android.content.DialogInterface;
import com.sec.chaton.R;
import com.sec.chaton.util.C1786r;

/* compiled from: FacebookInvitationCardWriteActivity.java */
/* renamed from: com.sec.chaton.facebook.e */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0724e implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ FacebookInvitationCardWriteActivity f2700a;

    DialogInterfaceOnClickListenerC0724e(FacebookInvitationCardWriteActivity facebookInvitationCardWriteActivity) {
        this.f2700a = facebookInvitationCardWriteActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        String str = this.f2700a.f2688a.getText().toString() + "\nwww.chaton.com/invite.html\n\n" + this.f2700a.getString(R.string.logo_is_different_for_canada);
        C1786r.m6063c("Invitation Message " + str, getClass().getSimpleName());
        this.f2700a.f2689b.m3219a(0, this.f2700a.f2690c, str);
    }
}
