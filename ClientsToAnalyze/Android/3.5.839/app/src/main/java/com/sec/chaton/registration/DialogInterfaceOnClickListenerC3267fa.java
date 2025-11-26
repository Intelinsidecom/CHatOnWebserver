package com.sec.chaton.registration;

import android.content.DialogInterface;
import com.sec.chaton.R;

/* compiled from: FragmentRegistPushName.java */
/* renamed from: com.sec.chaton.registration.fa */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3267fa implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC3262ew f12035a;

    DialogInterfaceOnClickListenerC3267fa(HandlerC3262ew handlerC3262ew) {
        this.f12035a = handlerC3262ew;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f12035a.f12029a.f11794h.mo9077a(this.f12035a.f12029a.f11789c);
        this.f12035a.f12029a.f11789c.m18262a(30000);
        dialogInterface.dismiss();
        if (this.f12035a.f12029a.f11788b != null) {
            this.f12035a.f12029a.m12965a(this.f12035a.f12029a.getResources().getString(R.string.multi_deivce_mapping_pop_up_title), this.f12035a.f12029a.f11802p, this.f12035a.f12029a.f11803q);
        }
    }
}
