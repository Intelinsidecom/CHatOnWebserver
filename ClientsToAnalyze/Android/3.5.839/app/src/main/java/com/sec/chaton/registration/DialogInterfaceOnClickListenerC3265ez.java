package com.sec.chaton.registration;

import android.content.DialogInterface;
import com.sec.chaton.R;

/* compiled from: FragmentRegistPushName.java */
/* renamed from: com.sec.chaton.registration.ez */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3265ez implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC3262ew f12032a;

    DialogInterfaceOnClickListenerC3265ez(HandlerC3262ew handlerC3262ew) {
        this.f12032a = handlerC3262ew;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f12032a.f12029a.f11788b != null) {
            this.f12032a.f12029a.m12965a(this.f12032a.f12029a.getResources().getString(R.string.multi_deivce_mapping_pop_up_title), this.f12032a.f12029a.f11802p, this.f12032a.f12029a.f11803q);
        }
        this.f12032a.f12029a.m12972c();
    }
}
