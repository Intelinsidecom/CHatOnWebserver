package com.sec.chaton.registration;

import android.content.DialogInterface;
import android.content.Intent;
import com.sec.chaton.HomeActivity;
import com.sec.chaton.util.C3214cb;

/* compiled from: FragmentRegistPushName.java */
/* renamed from: com.sec.chaton.registration.ew */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC2253ew implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC2249es f8548a;

    DialogInterfaceOnClickListenerC2253ew(HandlerC2249es handlerC2249es) {
        this.f8548a = handlerC2249es;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        C3214cb.m11266d();
        Intent intent = new Intent(this.f8548a.f8544a.getActivity(), (Class<?>) HomeActivity.class);
        intent.setFlags(67108864);
        this.f8548a.f8544a.getActivity().startActivity(intent);
    }
}
