package com.sec.chaton.registration;

import android.content.DialogInterface;
import com.sec.chaton.R;

/* compiled from: FragmentRegistPushName.java */
/* renamed from: com.sec.chaton.registration.er */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2248er implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC2244en f8543a;

    DialogInterfaceOnClickListenerC2248er(HandlerC2244en handlerC2244en) {
        this.f8543a = handlerC2244en;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f8543a.f8539a.f8320h.mo5479a(this.f8543a.f8539a.f8315c);
        this.f8543a.f8539a.f8315c.m11090a(30000);
        dialogInterface.dismiss();
        if (this.f8543a.f8539a.f8314b != null) {
            this.f8543a.f8539a.m8613a(this.f8543a.f8539a.getResources().getString(R.string.multi_deivce_mapping_pop_up_title), this.f8543a.f8539a.f8328p, this.f8543a.f8539a.f8329q);
        }
    }
}
