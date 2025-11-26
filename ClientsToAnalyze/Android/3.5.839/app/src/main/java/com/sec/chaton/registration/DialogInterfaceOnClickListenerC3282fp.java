package com.sec.chaton.registration;

import android.content.DialogInterface;
import com.sec.chaton.R;

/* compiled from: FragmentRegistPushName.java */
/* renamed from: com.sec.chaton.registration.fp */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3282fp implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC3268fb f12050a;

    DialogInterfaceOnClickListenerC3282fp(HandlerC3268fb handlerC3268fb) {
        this.f12050a = handlerC3268fb;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f12050a.f12036a.m12965a(this.f12050a.f12036a.getResources().getString(R.string.multi_deivce_mapping_pop_up_title), this.f12050a.f12036a.getActivity().getResources().getString(R.string.multidevice_sync_chat_title), this.f12050a.f12036a.f11803q);
        this.f12050a.f12036a.f11798l.m8728a();
    }
}
