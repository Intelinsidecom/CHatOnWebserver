package com.sec.chaton.registration;

import android.content.DialogInterface;
import com.sec.chaton.R;
import com.sec.chaton.util.C4809aa;

/* compiled from: FragmentRegistPushName.java */
/* renamed from: com.sec.chaton.registration.fd */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC3270fd implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ HandlerC3268fb f12038a;

    DialogInterfaceOnClickListenerC3270fd(HandlerC3268fb handlerC3268fb) {
        this.f12038a = handlerC3268fb;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        C4809aa.m18104a().m18128b("provisioning_pushname_status", "");
        this.f12038a.f12036a.f11795i.m9354a(this.f12038a.f12036a.f11793g, this.f12038a.f12036a.f11787a.getText().toString(), this.f12038a.f12036a.f11791e == null ? null : this.f12038a.f12036a.f11791e, this.f12038a.f12036a.f11792f);
        dialogInterface.dismiss();
        if (this.f12038a.f12036a.f11788b != null) {
            this.f12038a.f12036a.m12965a(this.f12038a.f12036a.getResources().getString(R.string.multi_deivce_mapping_pop_up_title), this.f12038a.f12036a.f11802p, this.f12038a.f12036a.f11803q);
        }
    }
}
