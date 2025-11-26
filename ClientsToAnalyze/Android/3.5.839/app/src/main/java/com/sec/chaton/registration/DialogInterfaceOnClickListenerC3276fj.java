package com.sec.chaton.registration;

import android.content.DialogInterface;
import com.sec.chaton.R;

/* compiled from: FragmentRegistPushName.java */
/* renamed from: com.sec.chaton.registration.fj */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3276fj implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC3268fb f12044a;

    DialogInterfaceOnClickListenerC3276fj(HandlerC3268fb handlerC3268fb) {
        this.f12044a = handlerC3268fb;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f12044a.f12036a.m12965a(this.f12044a.f12036a.getResources().getString(R.string.multi_deivce_mapping_pop_up_title), this.f12044a.f12036a.f11802p, this.f12044a.f12036a.f11803q);
        this.f12044a.f12036a.f11799m.m9499a("voip", 1, false);
    }
}
