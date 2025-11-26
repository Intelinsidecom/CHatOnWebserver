package com.sec.chaton.registration;

import android.content.DialogInterface;
import com.sec.chaton.R;

/* compiled from: FragmentRegistPushName.java */
/* renamed from: com.sec.chaton.registration.fg */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2264fg implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC2249es f8560a;

    DialogInterfaceOnClickListenerC2264fg(HandlerC2249es handlerC2249es) {
        this.f8560a = handlerC2249es;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f8560a.f8544a.m8613a(this.f8560a.f8544a.getResources().getString(R.string.multi_deivce_mapping_pop_up_title), this.f8560a.f8544a.getActivity().getResources().getString(R.string.multidevice_sync_chat_title), this.f8560a.f8544a.f8329q);
        this.f8560a.f8544a.f8324l.m5375a();
    }
}
