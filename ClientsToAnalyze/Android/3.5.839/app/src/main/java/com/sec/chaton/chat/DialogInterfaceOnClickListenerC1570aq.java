package com.sec.chaton.chat;

import android.content.DialogInterface;
import com.sec.chaton.R;
import com.sec.chaton.p055d.C2142w;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.aq */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC1570aq implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MenuItemOnMenuItemClickListenerC1568ao f5992a;

    DialogInterfaceOnClickListenerC1570aq(MenuItemOnMenuItemClickListenerC1568ao menuItemOnMenuItemClickListenerC1568ao) {
        this.f5992a = menuItemOnMenuItemClickListenerC1568ao;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f5992a.f5990c.m8138e(R.string.recall_fail_due_to_network)) {
            this.f5992a.f5988a.mo8403q();
            if (this.f5992a.f5990c.f5531aX instanceof C2142w) {
                ((C2142w) this.f5992a.f5990c.f5531aX).m9628a(this.f5992a.f5990c.f5750v, this.f5992a.f5990c.f5488E, this.f5992a.f5990c.f5487D, this.f5992a.f5990c.f5752x, this.f5992a.f5989b);
            }
        }
    }
}
