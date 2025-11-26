package com.sec.chaton.registration;

import android.content.DialogInterface;
import com.sec.chaton.R;
import com.sec.chaton.util.C3159aa;

/* compiled from: FragmentRegistPushName.java */
/* renamed from: com.sec.chaton.registration.eu */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2251eu implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC2249es f8546a;

    DialogInterfaceOnClickListenerC2251eu(HandlerC2249es handlerC2249es) {
        this.f8546a = handlerC2249es;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        C3159aa.m10962a().m10986b("provisioning_pushname_status", "");
        this.f8546a.f8544a.f8321i.m5601a(this.f8546a.f8544a.f8319g, this.f8546a.f8544a.f8313a.getText().toString(), this.f8546a.f8544a.f8317e == null ? null : this.f8546a.f8544a.f8317e, this.f8546a.f8544a.f8318f);
        dialogInterface.dismiss();
        if (this.f8546a.f8544a.f8314b != null) {
            this.f8546a.f8544a.m8613a(this.f8546a.f8544a.getResources().getString(R.string.multi_deivce_mapping_pop_up_title), this.f8546a.f8544a.f8328p, this.f8546a.f8544a.f8329q);
        }
    }
}
