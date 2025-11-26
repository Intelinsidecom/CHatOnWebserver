package com.sec.chaton.registration;

import android.content.DialogInterface;
import com.sec.chaton.R;

/* compiled from: FragmentRegistPushName.java */
/* renamed from: com.sec.chaton.registration.ey */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3264ey implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC3262ew f12031a;

    DialogInterfaceOnClickListenerC3264ey(HandlerC3262ew handlerC3262ew) {
        this.f12031a = handlerC3262ew;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f12031a.f12029a.f11788b != null) {
            this.f12031a.f12029a.m12965a(this.f12031a.f12029a.getActivity().getResources().getString(R.string.multi_deivce_mapping_pop_up_title), this.f12031a.f12029a.f11802p, this.f12031a.f12029a.f11803q);
        }
        this.f12031a.f12029a.m12972c();
    }
}
