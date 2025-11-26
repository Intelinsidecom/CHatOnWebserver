package com.sec.chaton.registration;

import android.content.DialogInterface;
import com.sec.chaton.R;

/* compiled from: FragmentRegistPushName.java */
/* renamed from: com.sec.chaton.registration.fn */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3280fn implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC3268fb f12048a;

    DialogInterfaceOnClickListenerC3280fn(HandlerC3268fb handlerC3268fb) {
        this.f12048a = handlerC3268fb;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f12048a.f12036a.m12966a(this.f12048a.f12036a.getActivity().getResources().getString(R.string.multi_deivce_mapping_pop_up_title), this.f12048a.f12036a.getResources().getString(R.string.auto_regi_buddy_sync), this.f12048a.f12036a.f11803q, true);
        this.f12048a.f12036a.f11799m.m9497a("append");
    }
}
