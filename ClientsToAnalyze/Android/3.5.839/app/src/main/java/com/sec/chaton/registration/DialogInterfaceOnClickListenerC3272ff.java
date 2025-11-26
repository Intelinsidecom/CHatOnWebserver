package com.sec.chaton.registration;

import android.content.DialogInterface;
import android.content.Intent;
import com.sec.chaton.HomeActivity;
import com.sec.chaton.util.C4859bx;

/* compiled from: FragmentRegistPushName.java */
/* renamed from: com.sec.chaton.registration.ff */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3272ff implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC3268fb f12040a;

    DialogInterfaceOnClickListenerC3272ff(HandlerC3268fb handlerC3268fb) {
        this.f12040a = handlerC3268fb;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        C4859bx.m18398d();
        Intent intent = new Intent(this.f12040a.f12036a.getActivity(), (Class<?>) HomeActivity.class);
        intent.setFlags(67108864);
        this.f12040a.f12036a.getActivity().startActivity(intent);
    }
}
