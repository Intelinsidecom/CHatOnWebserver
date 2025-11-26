package com.sec.chaton.registration;

import android.content.DialogInterface;
import com.sec.chaton.R;
import com.sec.chaton.util.C4809aa;

/* compiled from: FragmentRegistPushName.java */
/* renamed from: com.sec.chaton.registration.fi */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3275fi implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC3268fb f12043a;

    DialogInterfaceOnClickListenerC3275fi(HandlerC3268fb handlerC3268fb) {
        this.f12043a = handlerC3268fb;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        C4809aa.m18104a().m18128b("provisioning_pushname_status", "");
        if (this.f12043a.f12036a.f11801o.equals("skip")) {
            this.f12043a.f12036a.f11795i.m9351a(this.f12043a.f12036a.f11787a.getText().toString());
        } else {
            this.f12043a.f12036a.f11797k.m9388a(this.f12043a.f12036a.f11787a.getText().toString());
        }
        dialogInterface.dismiss();
        if (this.f12043a.f12036a.f11788b != null) {
            this.f12043a.f12036a.m12965a(this.f12043a.f12036a.getResources().getString(R.string.multi_deivce_mapping_pop_up_title), this.f12043a.f12036a.f11802p, this.f12043a.f12036a.f11803q);
        }
    }
}
