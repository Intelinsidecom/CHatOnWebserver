package com.sec.chaton.registration;

import android.content.DialogInterface;
import com.sec.chaton.R;

/* compiled from: FragmentRegistPushName.java */
/* renamed from: com.sec.chaton.registration.ep */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2246ep implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC2244en f8541a;

    DialogInterfaceOnClickListenerC2246ep(HandlerC2244en handlerC2244en) {
        this.f8541a = handlerC2244en;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f8541a.f8539a.f8314b != null) {
            this.f8541a.f8539a.m8613a(this.f8541a.f8539a.getActivity().getResources().getString(R.string.multi_deivce_mapping_pop_up_title), this.f8541a.f8539a.f8328p, this.f8541a.f8539a.f8329q);
        }
        this.f8541a.f8539a.m8619c();
    }
}
