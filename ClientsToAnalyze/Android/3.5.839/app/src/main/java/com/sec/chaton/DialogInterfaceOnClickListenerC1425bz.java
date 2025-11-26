package com.sec.chaton;

import android.content.DialogInterface;
import android.content.Intent;
import com.sec.chaton.specialbuddy.C4542g;
import com.sec.chaton.util.C4904y;

/* compiled from: PlusFragment.java */
/* renamed from: com.sec.chaton.bz */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1425bz implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ PlusFragment f5061a;

    DialogInterfaceOnClickListenerC1425bz(PlusFragment plusFragment) {
        this.f5061a = plusFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f5061a.f1967K != null) {
            Intent intentM17226a = C4542g.m17226a(this.f5061a.f1990q, String.valueOf(this.f5061a.f1967K.buddyid), this.f5061a.f1967K.channelname, this.f5061a.f1967K.usertype);
            intentM17226a.putExtra("callChatList", true);
            this.f5061a.startActivity(intentM17226a);
            this.f5061a.f1967K = null;
            return;
        }
        if (C4904y.f17873c) {
            C4904y.m18641c("mCurrentTopicChatEntry is null", PlusFragment.f1956a);
        }
    }
}
