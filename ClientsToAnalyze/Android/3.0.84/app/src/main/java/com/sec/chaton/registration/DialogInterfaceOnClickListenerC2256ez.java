package com.sec.chaton.registration;

import android.content.DialogInterface;
import com.sec.chaton.R;
import com.sec.chaton.util.C3159aa;

/* compiled from: FragmentRegistPushName.java */
/* renamed from: com.sec.chaton.registration.ez */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2256ez implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC2249es f8551a;

    DialogInterfaceOnClickListenerC2256ez(HandlerC2249es handlerC2249es) {
        this.f8551a = handlerC2249es;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        C3159aa.m10962a().m10986b("provisioning_pushname_status", "");
        if (this.f8551a.f8544a.f8327o.equals("skip")) {
            this.f8551a.f8544a.f8321i.m5598a(this.f8551a.f8544a.f8313a.getText().toString());
        } else {
            this.f8551a.f8544a.f8323k.m5615a(this.f8551a.f8544a.f8313a.getText().toString());
        }
        dialogInterface.dismiss();
        if (this.f8551a.f8544a.f8314b != null) {
            this.f8551a.f8544a.m8613a(this.f8551a.f8544a.getResources().getString(R.string.multi_deivce_mapping_pop_up_title), this.f8551a.f8544a.f8328p, this.f8551a.f8544a.f8329q);
        }
    }
}
