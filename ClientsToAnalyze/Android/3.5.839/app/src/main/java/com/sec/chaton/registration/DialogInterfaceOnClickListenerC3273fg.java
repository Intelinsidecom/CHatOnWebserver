package com.sec.chaton.registration;

import android.content.DialogInterface;
import android.content.Intent;
import com.sec.chaton.HomeActivity;
import com.sec.chaton.util.C4859bx;

/* compiled from: FragmentRegistPushName.java */
/* renamed from: com.sec.chaton.registration.fg */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3273fg implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC3268fb f12041a;

    DialogInterfaceOnClickListenerC3273fg(HandlerC3268fb handlerC3268fb) {
        this.f12041a = handlerC3268fb;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f12041a.f12036a.m12975d();
        C4859bx.m18398d();
        Intent intent = new Intent(this.f12041a.f12036a.getActivity(), (Class<?>) HomeActivity.class);
        intent.setFlags(67108864);
        this.f12041a.f12036a.getActivity().startActivity(intent);
    }
}
